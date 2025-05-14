package com.dreamsecurity.lightadminback.common.config;

import com.dreamsecurity.lightadminback.common.interceptor.MenuAuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfig
 * 메뉴별 인가처리 인터셉터 추가
 *
 * @author smmoon
 * @since 2025-04-18
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private MenuAuthorizationInterceptor menuAuthorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(menuAuthorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-ui/**"
                        ,"/v3/api-docs/**"
                        ,"/api/home/home"
                        ,"/api/auth/login"
                        ,"/api/auth/refreshtoken");
    }
}
