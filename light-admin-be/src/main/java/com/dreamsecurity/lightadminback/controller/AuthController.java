package com.dreamsecurity.lightadminback.controller;

import com.dreamsecurity.lightadminback.common.enums.ErrorCode;
import com.dreamsecurity.lightadminback.common.jwt.JwtUtil;
import com.dreamsecurity.lightadminback.dto.JwtRequestDTO;
import com.dreamsecurity.lightadminback.dto.ResponseDTO;
import com.dreamsecurity.lightadminback.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * AuthController
 * 인증, 로그인, 로그아웃 관련 컨트롤러
 *
 * @author smmoon
 * @since 2025-03-21
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, AuthService authService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    /**
     * login 처리
     * @param requestDTO
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody JwtRequestDTO requestDTO) {
        String userId = null;
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestDTO.getId(), requestDTO.getPassword())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            userId = userDetails.getUsername();
        }catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(ResponseDTO.of(ErrorCode.USER_NOT_FOUND, e.getLocalizedMessage()));
        }

        return ResponseEntity.ok(ResponseDTO.success(authService.getLoginResponse(userId)));
    }

    /**
     * logout 처리
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ResponseDTO.of(ErrorCode.UNAUTHORIZED_EXCEPTION, "로그인이 필요합니다."));
        }

        String userId = request.getAttribute("userId").toString();
        authService.logout(userId);
        return ResponseEntity.ok(ResponseDTO.success("Logout 성공"));
    }

    /**
     * refreshtoken, accesstoken 재생산
     * @param request
     * @return
     */
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        String refreshToken = request.getHeader("refreshToken");

        if (refreshToken == null || !jwtUtil.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ResponseDTO.of(ErrorCode.INVALID_CREDENTIALS, "RefreshToken이 유효하지 않습니다."));
        }

        return ResponseEntity.ok(ResponseDTO.success(authService.refreshAccessToken(refreshToken)));
    }
}
