package com.workroom.springboot.domain.issues;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.workroom.springboot.domain.user.QUser;
import com.workroom.springboot.web.dto.issues.IssuesResponseDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssuesRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public IssuesRepositorySupport(JPAQueryFactory queryFactory) {
        super(Issues.class);
        this.queryFactory = queryFactory;
    }



    public List<IssuesResponseDto> findAllIssues() {
        QIssues issues = new QIssues("issues");
        QUser user = new QUser("user");

        return queryFactory
                .select(Projections.bean(IssuesResponseDto.class
                        , issues.id
                        , user.userName
                        , user.userDept
                        , issues.thrower
                        , issues.agenda
                        , issues.createdDate
                        , issues.attendent))
                .from(issues, user)
                .where(issues.thrower.eq(user.userNumber))
                .orderBy(issues.createdDate.desc())
                .fetch();

    }
}
