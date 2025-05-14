package com.dreamsecurity.lightadminback.common.jwt;

import com.dreamsecurity.lightadminback.dto.UserDTO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * JwtUserDetails
 * 커스텀 UserDetails
 *
 * @author smmoon
 * @since 2025-04-07
 */
@Getter
public class JwtUserDetails implements UserDetails {

    private final UserDTO user;

    public JwtUserDetails(UserDTO user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // roles 필드가 "ROLE_ADMIN", "ROLE_USER" 형태라고 가정
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+user.getRoles()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 필요 시 상태값에 따라 조절
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // user.getState() 값으로 "LOCKED" 체크 가능
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !"INACTIVE".equalsIgnoreCase(user.getState()); // 비활성 계정 처리
    }
}
