package com.dreamsecurity.lightadminback.common.interceptor;

import com.dreamsecurity.lightadminback.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MenuAuthorizationInterceptor
 * 인가. 역할별 메뉴 인가처리
 *
 * @author smmoon
 * @since 2025-04-17
 */
@Component
public class MenuAuthorizationInterceptor implements HandlerInterceptor {
    @Autowired
    private RoleMenuService roleMenuService;

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }

        String uri = request.getRequestURI();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        List<String> roleList = authorities.stream()
                .map(grantedAuthority -> {
                    String role = grantedAuthority.getAuthority();
                    return role.startsWith("ROLE_") ? role.substring(5) : role;
                })
                .collect(Collectors.toList());

        // DB에서 현재 Role에 접근 가능한 URI 패턴 리스트 불러오기
        List<String> accessiblePatterns = roleMenuService.findAllowedUrisByRoles(roleList);

        // URI 접근 허용 여부 검사
        boolean hasAccess = accessiblePatterns.stream()
                .anyMatch(pattern -> pathMatcher.match(pattern, uri));

        if (!hasAccess) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 권한이 없습니다.");
            return false;
        }

        return true;
    }
}
