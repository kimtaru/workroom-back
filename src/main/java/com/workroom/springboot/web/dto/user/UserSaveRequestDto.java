package com.workroom.springboot.web.dto.user;

import com.workroom.springboot.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String userAccount;
    private String name;
    private String googleId;
    private String password;
    private Long termOne;
    private Long termTwo;

    public void setPassword(String password) {
        this.password = password;
    }

    @Builder
    public UserSaveRequestDto(String userAccount, String name, String googleId, String password, Long termOne, Long termTwo) {
        this.userAccount = userAccount;
        this.name = name;
        this.googleId = googleId;
        this.password = password;
        this.termOne = termOne;
        this.termTwo = termTwo;
    }

    public Users toEntity() {
        return Users.builder()
                .userAccount(userAccount)
                .password(password)
                .name(name)
                .googleId(googleId)
                .termOne(termOne)
                .termTwo(termTwo)
                .build();
    }
}
