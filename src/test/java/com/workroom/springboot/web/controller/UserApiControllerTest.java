package com.workroom.springboot.web.controller;

import com.workroom.springboot.domain.users.UserRepository;
import com.workroom.springboot.domain.users.UserRepositorySupport;
import com.workroom.springboot.domain.users.Users;
import com.workroom.springboot.web.dto.user.UserResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private UserRepositorySupport userRepositorySupport;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }



    @Test
    public void Query_test() throws Exception {
        Users users = userRepository.save(Users.builder()
                .userAccount("ppp@kk.js")
                .password("vmfnsk91")
                .termOne((long) 1)
                .termTwo((long) 1)
                .build());

        UserResponseDto userResponseDto = userRepositorySupport.findByUsername("ppp@kk.js");
        System.out.println(">>>>>>>>>>>>>>>>"+userResponseDto.getUserAccount());
        System.out.println(">>>>>>>>>>>>>>>>"+userResponseDto.getPassword());
    }




}
