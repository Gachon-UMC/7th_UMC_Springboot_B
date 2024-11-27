package umc.umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoss is a Querydsl query type for Boss
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoss extends EntityPathBase<Boss> {

    private static final long serialVersionUID = -1334343028L;

    public static final QBoss boss = new QBoss("boss");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> store_id = createNumber("store_id", Integer.class);

    public final ListPath<Store, QStore> StoreList = this.<Store, QStore>createList("StoreList", Store.class, QStore.class, PathInits.DIRECT2);

    public QBoss(String variable) {
        super(Boss.class, forVariable(variable));
    }

    public QBoss(Path<? extends Boss> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoss(PathMetadata metadata) {
        super(Boss.class, metadata);
    }

}

