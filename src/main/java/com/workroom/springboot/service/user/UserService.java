package com.workroom.springboot.service.user;

import com.workroom.springboot.domain.users.UserRepository;
import com.workroom.springboot.domain.users.UserRepositorySupport;
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

    /* 회원 가입 시 계정 중복 체크 */
    @Transactional(readOnly = true)
    public Long findByUserAccount(String email) {
        Long check = userRepositorySupport.findByUserAccount(email);
        return check;
        /*
        * return: 0/1(미중복/중복)
        * */
    }

    @Transactional
    public Long updateByUserAccount(String email, String pwd) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return userRepositorySupport.updateByUserAccount(email,passwordEncoder.encode(pwd));
    }




}
