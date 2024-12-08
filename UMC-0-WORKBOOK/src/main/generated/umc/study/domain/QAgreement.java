package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgreement is a Querydsl query type for Agreement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAgreement extends EntityPathBase<Agreement> {

    private static final long serialVersionUID = -1439928L;

    public static final QAgreement agreement = new QAgreement("agreement");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.mapping.MemberAgree, umc.study.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.study.domain.mapping.MemberAgree, umc.study.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.study.domain.mapping.MemberAgree.class, umc.study.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final EnumPath<umc.study.domain.enums.RequiredYN> requiredYN = createEnum("requiredYN", umc.study.domain.enums.RequiredYN.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAgreement(String variable) {
        super(Agreement.class, forVariable(variable));
    }

    public QAgreement(Path<? extends Agreement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgreement(PathMetadata metadata) {
        super(Agreement.class, metadata);
    }

}

