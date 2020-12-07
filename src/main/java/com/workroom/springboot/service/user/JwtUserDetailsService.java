package com.workroom.springboot.service.user;


import com.workroom.springboot.domain.users.UserRepositorySupport;
import com.workroom.springboot.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepositorySupport userRepositorySupport;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponseDto userResponseDto = userRepositorySupport.findByUsername(username);

        if (userResponseDto.getUserAccount().equals(username)) {
            return new User(userResponseDto.getUserAccount(), userResponseDto.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
