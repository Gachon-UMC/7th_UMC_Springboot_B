package umc.umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1954481481L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review1 = new QReview("review1");

    public final StringPath favorite_food = createString("favorite_food");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image_url = createString("image_url");

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final StringPath review = createString("review");

    public final QStore store;

    public final QUsers users;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

