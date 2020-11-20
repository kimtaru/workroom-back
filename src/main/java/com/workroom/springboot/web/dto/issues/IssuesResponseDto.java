package com.workroom.springboot.web.dto.issues;

import com.workroom.springboot.domain.issues.Issues;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class IssuesResponseDto {
    private Long id;
    private String thrower;
    private String agenda;
    private String attendent;
    private LocalDateTime createdDt;

    public IssuesResponseDto(Issues entity) {
        this.id = entity.getId();
        this.thrower = entity.getThrower();
        this.agenda = entity.getAgenda();
        this.attendent = entity.getAttendent();
        this.createdDt = entity.getCreatedDate();
    }
}