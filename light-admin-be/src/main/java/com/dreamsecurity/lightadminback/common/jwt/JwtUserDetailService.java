package com.dreamsecurity.lightadminback.common.jwt;

import com.dreamsecurity.lightadminback.common.enums.ErrorCode;
import com.dreamsecurity.lightadminback.common.exception.BaseException;
import com.dreamsecurity.lightadminback.dto.UserDTO;
import com.dreamsecurity.lightadminback.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JwtUserDetailService
 * login 처리
 *
 * @author smmoon
 * @since 2025-03-21
 */
@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userMapper.findById(username);
        if (user == null) {
            throw new BadCredentialsException("Invalid username or password.");
        }
        return new JwtUserDetails(user);
    }
}
