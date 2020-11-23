package com.workroom.springboot.web.controller;

import com.workroom.springboot.domain.issues.Issues;
import com.workroom.springboot.domain.issues.IssuesRepository;
import com.workroom.springboot.domain.issues.IssuesRepositorySupport;
import com.workroom.springboot.domain.user.User;
import com.workroom.springboot.domain.user.UserRepository;
import com.workroom.springboot.web.dto.issues.IssuesResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssuesApiControllerTest {
    @Autowired
    private IssuesRepository issuesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IssuesRepositorySupport issuesRepositorySupport;

    @After
    public void tearDown() throws Exception {
        issuesRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_function_check() {
        String thrower = "111";
        String agenda = "coding";
        String attendent = "a,b,c";
        issuesRepository.save(new Issues(agenda,thrower,attendent));

        String userNumber = "111";
        String userName = "sol";
        String userDept = "dept";
        String email = "email";
        String password = "pwd";
        userRepository.save(new User(userNumber,userName,userDept,email,password));

        List<IssuesResponseDto> result = issuesRepositorySupport.findAllIssues();
        System.out.println(">>>>>>>>>>>>>>>"+result.get(0).getUserName());
    }
}
