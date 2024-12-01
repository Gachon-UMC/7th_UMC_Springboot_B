package umc.umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -489887219L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final NumberPath<Integer> clear = createNumber("clear", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> cleartime = createDateTime("cleartime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QPoint point;

    public final NumberPath<Integer> store_id = createNumber("store_id", Integer.class);

    public final StringPath title = createString("title");

    public final ListPath<Users, QUsers> userList = this.<Users, QUsers>createList("userList", Users.class, QUsers.class, PathInits.DIRECT2);

    public final ListPath<Users, QUsers> userList_status = this.<Users, QUsers>createList("userList_status", Users.class, QUsers.class, PathInits.DIRECT2);

    public final QUsers users;

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.point = inits.isInitialized("point") ? new QPoint(forProperty("point"), inits.get("point")) : null;
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

