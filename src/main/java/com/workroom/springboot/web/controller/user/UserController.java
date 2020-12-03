package com.workroom.springboot.web.controller.user;

import com.workroom.springboot.service.user.UserService;
import com.workroom.springboot.web.dto.user.UserResponseDto;
import com.workroom.springboot.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    /*
    * desc: 회원가입
    * */
    @PostMapping("/api/user/join")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    /*
    * desc: 계정 중복체크
    * */
    @GetMapping("/api/user/join/{email}")
    public Long findByUserAccount(@PathVariable String email) {
        return userService.findByUserAccount(email);
    }
}
