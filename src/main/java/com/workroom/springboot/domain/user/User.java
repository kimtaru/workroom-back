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

    @Column(length = 20, nullable = false)
    private String userNumber;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 20, nullable = false)
    private String userDept;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Builder
    public User(String userNumber, String userName, String userDept, String email, String password) {
        this.userNumber = userNumber;
        this.userName = userName;
        this.userDept = userDept;
        this.email = email;
        this.password = password;
    }
}
