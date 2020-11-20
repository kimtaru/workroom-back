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
    public IssuesResponseDto findById(Long id) {
        System.out.println(">>>>>>>>>>>>>>>service");

        Issues entity = issuesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("aaa"));
        return new IssuesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<IssuesResponseDto> findByThrower(String thrower) {
        return issuesRepositorySupport.findByThrower(thrower).stream()
                .map(IssuesResponseDto::new)
                .collect(Collectors.toList());
    }
}
