package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 479029197L;

    public static final QUser user = new QUser("user");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactive_date = createDate("inactive_date", java.time.LocalDate.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.Status> status = createEnum("status", umc.study.domain.enums.Status.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath user_name = createString("user_name");

    public final StringPath userAddress = createString("userAddress");

    public final DatePath<java.time.LocalDate> userBirth = createDate("userBirth", java.time.LocalDate.class);

    public final StringPath userEmail = createString("userEmail");

    public final ListPath<UserFavoriteFoods, QUserFavoriteFoods> userFavoriteFoodsList = this.<UserFavoriteFoods, QUserFavoriteFoods>createList("userFavoriteFoodsList", UserFavoriteFoods.class, QUserFavoriteFoods.class, PathInits.DIRECT2);

    public final BooleanPath userLogin = createBoolean("userLogin");

    public final ListPath<UserMission, QUserMission> userMissionList = this.<UserMission, QUserMission>createList("userMissionList", UserMission.class, QUserMission.class, PathInits.DIRECT2);

    public final StringPath userPhone = createString("userPhone");

    public final NumberPath<Integer> userPoint = createNumber("userPoint", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

