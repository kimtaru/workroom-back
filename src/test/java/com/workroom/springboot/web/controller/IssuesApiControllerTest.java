package com.workroom.springboot.web.controller;

import com.workroom.springboot.domain.issues.Issues;
import com.workroom.springboot.domain.issues.IssuesRepository;
import com.workroom.springboot.domain.issues.IssuesRepositorySupport;
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
    private IssuesRepositorySupport issuesRepositorySupport;

    @After
    public void tearDown() throws Exception {
        issuesRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_function_check() {
        String thrower = "sol";
        String agenda = "coding";
        String attendent = "a,b,c";
        issuesRepository.save(new Issues(agenda,thrower,attendent));

        Issues result = issuesRepositorySupport.findByThrower(thrower);
        assertThat(result.getThrower()).isEqualTo(thrower);
    }
}
