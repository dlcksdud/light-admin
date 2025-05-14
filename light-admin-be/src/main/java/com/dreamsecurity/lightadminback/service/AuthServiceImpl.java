package com.dreamsecurity.lightadminback.service;

import com.dreamsecurity.lightadminback.common.enums.ErrorCode;
import com.dreamsecurity.lightadminback.common.exception.BaseException;
import com.dreamsecurity.lightadminback.common.jwt.JwtUtil;
import com.dreamsecurity.lightadminback.dto.LoginResponseDTO;
import com.dreamsecurity.lightadminback.dto.RefreshTokenDTO;
import com.dreamsecurity.lightadminback.dto.TokenResponseDTO;
import com.dreamsecurity.lightadminback.dto.UserDTO;
import com.dreamsecurity.lightadminback.repository.RefreshTokenMapper;
import com.dreamsecurity.lightadminback.repository.UserMapper;
import org.springframework.stereotype.Service;

/**
 * AuthServiceImpl
 *
 * @author smmoon
 * @since 2025-03-25
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;
    private final RefreshTokenMapper refreshTokenMapper;

    public AuthServiceImpl(JwtUtil jwtUtil, UserMapper userMapper, RefreshTokenMapper refreshTokenMapper) {
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
        this.refreshTokenMapper = refreshTokenMapper;
    }

    @Override
    public void logout(String userId) {
        // 로그아웃 구현 (예: refresh token 삭제)
        refreshTokenMapper.deleteByUserId(userId);
    }

    @Override
    public LoginResponseDTO getLoginResponse(String userId) {
        // refresh token 생성 및 저장
        RefreshTokenDTO refreshTokenDTO = jwtUtil.generateRefreshToken(userId);
        refreshTokenMapper.insertOrUpdate(refreshTokenDTO);

        UserDTO user = userMapper.findById(userId);
        if (user == null) {
            throw new BaseException(ErrorCode.USER_NOT_FOUND);
        }

        return new LoginResponseDTO(
                jwtUtil.generateToken(userId, user.getRoles()),
                refreshTokenDTO.getToken(),
                user.getId(),
                user.getName(),
                user.getRoles()
        );
    }

    @Override
    public TokenResponseDTO refreshAccessToken(String refreshToken) {
        if (!jwtUtil.validateToken(refreshToken)) {
            throw new BaseException(ErrorCode.EXPIRED_REFRESH_TOKEN);
        }

        String userId = jwtUtil.extractUserId(refreshToken);
        RefreshTokenDTO storedToken = refreshTokenMapper.findByUserId(userId);

        if (storedToken == null || !storedToken.getToken().equals(refreshToken)) {
            throw new BaseException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        UserDTO user = userMapper.findById(userId);
        String accessToken = jwtUtil.generateToken(userId, user.getRoles());

        return TokenResponseDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public RefreshTokenDTO findRefreseTokenByToken(String token) {
        return refreshTokenMapper.findByUserId(jwtUtil.extractUserId(token));
    }

}
