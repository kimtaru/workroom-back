package com.workroom.springboot.web.controller.user;

import com.workroom.springboot.service.user.UserService;
import com.workroom.springboot.web.dto.user.UserSaveRequsetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/user/join")
    public Long save(@RequestBody UserSaveRequsetDto requsetDto) {
        return userService.save(requsetDto);
    }
}
