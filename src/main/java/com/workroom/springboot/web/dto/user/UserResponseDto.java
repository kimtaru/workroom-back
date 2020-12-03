package com.workroom.springboot.web.dto.user;


import com.workroom.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String userAccount;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.userAccount = entity.getUserAccount();
    }
}
