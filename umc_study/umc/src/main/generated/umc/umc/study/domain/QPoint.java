package umc.umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPoint is a Querydsl query type for Point
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPoint extends EntityPathBase<Point> {

    private static final long serialVersionUID = 1597958737L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPoint point1 = new QPoint("point1");

    public final DateTimePath<java.time.LocalDateTime> cleartime = createDateTime("cleartime", java.time.LocalDateTime.class);

    public final ListPath<Mission, QMission> MissionList = this.<Mission, QMission>createList("MissionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Long> user_id = createNumber("user_id", Long.class);

    public final QUsers users;

    public QPoint(String variable) {
        this(Point.class, forVariable(variable), INITS);
    }

    public QPoint(Path<? extends Point> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPoint(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPoint(PathMetadata metadata, PathInits inits) {
        this(Point.class, metadata, inits);
    }

    public QPoint(Class<? extends Point> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

