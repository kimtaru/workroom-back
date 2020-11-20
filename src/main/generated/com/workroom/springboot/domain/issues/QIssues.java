package com.workroom.springboot.domain.issues;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIssues is a Querydsl query type for Issues
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIssues extends EntityPathBase<Issues> {

    private static final long serialVersionUID = 1876203582L;

    public static final QIssues issues = new QIssues("issues");

    public final com.workroom.springboot.domain.QBaseTimeEntity _super = new com.workroom.springboot.domain.QBaseTimeEntity(this);

    public final StringPath agenda = createString("agenda");

    public final StringPath attendent = createString("attendent");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath thrower = createString("thrower");

    public QIssues(String variable) {
        super(Issues.class, forVariable(variable));
    }

    public QIssues(Path<? extends Issues> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIssues(PathMetadata metadata) {
        super(Issues.class, metadata);
    }

}

