package com.workroom.springboot.service.user;

import com.workroom.springboot.domain.user.User;
import com.workroom.springboot.domain.user.UserRepository;
import com.workroom.springboot.domain.user.UserRepositorySupport;
import com.workroom.springboot.web.dto.user.UserResponseDto;
import com.workroom.springboot.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRepositorySupport userRepositorySupport;

    /* 회원 가입 */
    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Long findByUserAccount(String email) {
        Long check = userRepositorySupport.findByUserAccount(email);
        return check;
    }
}
