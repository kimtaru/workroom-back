package com.workroom.springboot.domain.users;

import com.workroom.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, unique = true)
    private String googleId;

    @Column(length = 100, nullable = false, unique = true)
    private String userAccount;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 5, nullable = false)
    private Long termOne;

    @Column(length = 5, nullable = false)
    private Long termTwo;


    @Builder
    public Users(String userAccount, String name, String googleId, String password, Long termOne, Long termTwo) {
        this.userAccount = userAccount;
        this.name = name;
        this.googleId = googleId;
        this.password = password;
        this.termOne = termOne;
        this.termTwo = termTwo;
    }
}
