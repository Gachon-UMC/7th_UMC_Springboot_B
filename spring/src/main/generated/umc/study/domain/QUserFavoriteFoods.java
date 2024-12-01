package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFavoriteFoods is a Querydsl query type for UserFavoriteFoods
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFavoriteFoods extends EntityPathBase<UserFavoriteFoods> {

    private static final long serialVersionUID = -2059270964L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFavoriteFoods userFavoriteFoods = new QUserFavoriteFoods("userFavoriteFoods");

    public final QFood food;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QUserFavoriteFoods(String variable) {
        this(UserFavoriteFoods.class, forVariable(variable), INITS);
    }

    public QUserFavoriteFoods(Path<? extends UserFavoriteFoods> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFavoriteFoods(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFavoriteFoods(PathMetadata metadata, PathInits inits) {
        this(UserFavoriteFoods.class, metadata, inits);
    }

    public QUserFavoriteFoods(Class<? extends UserFavoriteFoods> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new QFood(forProperty("food")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

