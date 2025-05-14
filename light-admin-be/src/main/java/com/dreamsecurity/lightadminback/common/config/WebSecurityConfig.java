package com.dreamsecurity.lightadminback.common.config;

import com.dreamsecurity.lightadminback.common.jwt.JwtAuthenticationEntryPoint;
import com.dreamsecurity.lightadminback.common.jwt.JwtAuthenticationFilter;
import com.dreamsecurity.lightadminback.common.enums.Role;
import com.dreamsecurity.lightadminback.common.jwt.JwtUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig
 * Security 설정
 *
 * @author smmoon
 * @since 2025-03-13
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;
    @Autowired
    private JwtUserDetailService jwtUserDetailSerive;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 사용자 인증 설정. 임시용
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailSerive).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
        .cors().and().csrf().disable()
        .exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
            .antMatchers("/api/auth/login", "/api/home/home", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // 기본 접근 가능
            .antMatchers("/api/admin/**").hasAnyRole(
                    Role.SUPER_ADMIN.getRoleName()
                    ,Role.USER.getRoleName()) // SUPER_ADMIN만 접근 가능
            .anyRequest().authenticated()
        .and()
        .formLogin().disable() // 기본 로그인 폼 사용
            //.loginPage("/login") // 커스텀 로그인 페이지
            //.defaultSuccessUrl("/home", true) // 로그인 성공 시 이동할 페이지
            //.permitAll()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/home")
            .permitAll()
        .and().addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
