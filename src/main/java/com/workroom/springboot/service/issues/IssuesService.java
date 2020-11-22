package com.workroom.springboot.service.issues;

import com.workroom.springboot.domain.issues.Issues;
import com.workroom.springboot.domain.issues.IssuesRepository;
import com.workroom.springboot.domain.issues.IssuesRepositorySupport;
import com.workroom.springboot.web.dto.issues.IssuesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IssuesService {
    private final IssuesRepository issuesRepository;
    private final IssuesRepositorySupport issuesRepositorySupport;

    @Transactional
    public List<IssuesResponseDto> findAllIssues() {
        return issuesRepositorySupport.findAllIssues();
    }
}
