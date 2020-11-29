package com.workroom.springboot.service.user;

import com.workroom.springboot.domain.user.UserRepository;
import com.workroom.springboot.web.dto.user.UserSaveRequsetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    /* 회원 가입 */
    @Transactional
    public Long save(UserSaveRequsetDto requestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return userRepository.save(requestDto.toEntity()).getId();
    }
}
