package com.workroom.springboot.domain.issues;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.workroom.springboot.domain.issues.QIssues.issues;

@Repository
public class IssuesRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public IssuesRepositorySupport(JPAQueryFactory queryFactory) {
        super(Issues.class);
        this.queryFactory = queryFactory;
    }

    public List<Issues> findByThrower(String thrower) {
        return queryFactory
                .selectFrom(issues)
                .where(issues.thrower.eq(thrower))
                .fetch();
    }
}
