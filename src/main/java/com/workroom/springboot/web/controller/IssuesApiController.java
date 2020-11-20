package com.workroom.springboot.web.controller;

import com.workroom.springboot.domain.issues.Issues;
import com.workroom.springboot.domain.issues.IssuesRepositorySupport;
import com.workroom.springboot.service.issues.IssuesService;
import com.workroom.springboot.web.dto.issues.IssuesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IssuesApiController {
    private final IssuesService issuesService;


    @GetMapping("/api/v1/issues/{id}")
    public IssuesResponseDto findByThrower(@PathVariable Long id) {
        System.out.println(">>>>>>>>>>>>test;");
        System.out.println(">>>>>>>>>>>>thrower: "+id);

        return issuesService.findById(id);
    }

    @GetMapping("/api/issues")
    public List<IssuesResponseDto> findAllIssues() {
        return issuesService.findAllIssues();
    }

    @GetMapping("/api/v2/issues/{thrower}")
    public List<IssuesResponseDto> findByThrower(@PathVariable String thrower) {
        return issuesService.findByThrower(thrower);
    }
}