package umc.umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 1602691785L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsers users = new QUsers("users");

    public final StringPath address = createString("address");

    public final StringPath birthday = createString("birthday");

    public final StringPath favorite_food = createString("favorite_food");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QMission mission;

    public final QMission mission_status;

    public final ListPath<Mission, QMission> MissionList = this.<Mission, QMission>createList("MissionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final ListPath<Point, QPoint> PointList = this.<Point, QPoint>createList("PointList", Point.class, QPoint.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> ReviewList = this.<Review, QReview>createList("ReviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QUsers(String variable) {
        this(Users.class, forVariable(variable), INITS);
    }

    public QUsers(Path<? extends Users> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsers(PathMetadata metadata, PathInits inits) {
        this(Users.class, metadata, inits);
    }

    public QUsers(Class<? extends Users> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
        this.mission_status = inits.isInitialized("mission_status") ? new QMission(forProperty("mission_status"), inits.get("mission_status")) : null;
    }

}

