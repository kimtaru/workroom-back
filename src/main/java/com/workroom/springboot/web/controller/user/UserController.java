package com.workroom.springboot.web.controller.user;

import com.workroom.springboot.service.user.UserService;
import com.workroom.springboot.web.dto.user.UserResponseDto;
import com.workroom.springboot.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    /*
    * desc: 회원가입
    * */
    @PostMapping("/join")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    /*
    * desc: 계정 중복체크
    * */
    @GetMapping("/join/{email}")
    public Long findByUserAccount(@PathVariable String email) {
        return userService.findByUserAccount(email);
    }
}
