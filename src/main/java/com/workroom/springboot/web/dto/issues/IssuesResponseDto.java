package com.workroom.springboot.web.dto.issues;

import com.workroom.springboot.domain.issues.Issues;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class IssuesResponseDto {
    private Long id;
    private String agenda;
    private String userName;

}
