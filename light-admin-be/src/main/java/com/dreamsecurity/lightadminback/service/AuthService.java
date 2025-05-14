package com.dreamsecurity.lightadminback.service;

import com.dreamsecurity.lightadminback.dto.LoginResponseDTO;
import com.dreamsecurity.lightadminback.dto.RefreshTokenDTO;
import com.dreamsecurity.lightadminback.dto.TokenResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    public void logout(String id);
    public LoginResponseDTO getLoginResponse(String userId);
    public TokenResponseDTO refreshAccessToken(String refreshToken);
    public RefreshTokenDTO findRefreseTokenByToken(String token);
}
