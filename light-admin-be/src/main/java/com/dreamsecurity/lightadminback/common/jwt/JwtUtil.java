package com.dreamsecurity.lightadminback.common.jwt;

import com.dreamsecurity.lightadminback.common.enums.Role;
import com.dreamsecurity.lightadminback.dto.RefreshTokenDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * JwtUtil
 * Jwt 토큰 유틸리티
 *
 * @author smmoon
 * @since 2025-03-20
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Value("${jwt.refreshExpirationDateInMs}")
    private int refreshExpirationDateInMs;

    private Key key;
    public String generateToken(String userId, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLE", (!role.startsWith("ROLE_")? "ROLE_"+role : role) );
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    /**
     * JWT 토큰 생성
     * @param userId 사용자 이름
     * @return 생성된 JWT 토큰
     */


    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
        if(roles.contains(new SimpleGrantedAuthority(Role.SUPER_ADMIN.getRoleName()))){
            claims.put("ROLE", Role.SUPER_ADMIN.getRoleName());
        }
        else if(roles.contains(new SimpleGrantedAuthority(Role.USER.getRoleName()))){
            claims.put("ROLE", Role.USER.getRoleName());
        }
        else if(roles.contains(new SimpleGrantedAuthority(Role.AUDITOR.getRoleName()))){
            claims.put("ROLE", Role.AUDITOR.getRoleName());
        }
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String doGenerateToken(Map<String, Object> claims, String userId){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * refresh token 생성
     * @param userId
     * @return refresh token
     */
    public RefreshTokenDTO generateRefreshToken(String userId) {
        RefreshTokenDTO refreshTokenDTO = new RefreshTokenDTO();
        Date expiryDate = new Date(System.currentTimeMillis() + refreshExpirationDateInMs);
        refreshTokenDTO.setUserId(userId);
        refreshTokenDTO.setExpiryDate(expiryDate);
        refreshTokenDTO.setToken(Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact());
        return  refreshTokenDTO;
    }

    /**
     * Jwt 토큰에서 사용자 이름 추출
     * @param token JWT 토큰
     * @return 사용자 이름
     */
    public String extractUserId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Jwt 토큰에서 Role 추출
     * @param token
     * @return Role
     */
    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("ROLE", String.class);
    }


    /**
     * Jwt 토큰 검증
     * @param token JWT 토큰
     * @return 토큰 유효 여부
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token); // 서명 검증
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // 토큰이 유효하지 않거나, 만료된 경우
            return false;
        }
    }

    /**
     * request에서 Jwt 추출
     * @param request
     * @return
     */
    public String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
