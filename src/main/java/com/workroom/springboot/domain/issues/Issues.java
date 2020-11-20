package com.workroom.springboot.domain.issues;

import com.workroom.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Issues extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String agenda;

    @Column(length = 10, nullable = false)
    private String thrower;

    @Column(nullable = false)
    private String attendent;

    @Builder
    public Issues(String agenda, String thrower, String attendent) {
        this.agenda = agenda;
        this.thrower = thrower;
        this.attendent = attendent;
    }







}
