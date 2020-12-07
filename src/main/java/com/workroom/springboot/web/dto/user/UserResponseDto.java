package com.workroom.springboot.web.dto.user;


import com.workroom.springboot.domain.users.Users;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String userAccount;
    private String password;

    public UserResponseDto(Users entity) {
        this.id = entity.getId();
        this.userAccount = entity.getUserAccount();
        this.password = entity.getPassword();
    }

    public UserResponseDto(Long id, String userAccount, String password) {
        this.id = id;
        this.userAccount = userAccount;
        this.password = password;
    }
}
