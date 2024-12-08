package umc.spring.repository.store;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QStore;
import umc.spring.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder(); // 동적 쿼리 작성 BooleanBuilder

        if (name != null) {
            predicate.and(store.name.eq(name)); // equal
        }

        if (score != null) {
            predicate.and(store.score.goe(4.0f)); // "greater than or equal to"
        }

        // 가게 이름이 name이고, 평점이 4.0보다 크거나 같은 가게
        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();


//        List<Store> fetch = jpaQueryFactory
//                .selectFrom(store)
//                .where(store.name.eq(name), store.score.goe(4.0f))
//                .fetch();
    }
}