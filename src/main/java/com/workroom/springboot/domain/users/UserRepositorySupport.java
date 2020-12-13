package com.workroom.springboot.domain.users;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.workroom.springboot.web.dto.user.UserResponseDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.workroom.springboot.domain.users.QUsers.users;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public UserRepositorySupport(JPAQueryFactory queryFactory) {
        super(Users.class);
        this.queryFactory = queryFactory;
    }


    public Long findByUserAccount(String email) {
        return queryFactory.from(users).where(users.userAccount.eq(email)).fetchCount();
    }

    public UserResponseDto findByUsername(String username) {
        return queryFactory.from(users)
                .select(Projections.constructor(UserResponseDto.class,
                 users.id
                ,users.userAccount
                ,users.password))
                .where(users.userAccount.eq(username))
                .fetchOne();
    }

    public Long updateByUserAccount(String email, String pwd) {
        return queryFactory.update(users).where(users.userAccount.eq(email))
                .set(users.password, pwd).execute();
    }









}
