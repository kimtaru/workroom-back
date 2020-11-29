package com.workroom.springboot.domain.user;

import com.workroom.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String userAccount;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 5, nullable = false)
    private Long termOne;

    @Column(length = 5, nullable = false)
    private Long termTwo;


    @Builder
    public User(String userAccount, String password, Long termOne, Long termTwo) {
        this.userAccount = userAccount;
        this.password = password;
        this.termOne = termOne;
        this.termTwo = termTwo;
    }
}
