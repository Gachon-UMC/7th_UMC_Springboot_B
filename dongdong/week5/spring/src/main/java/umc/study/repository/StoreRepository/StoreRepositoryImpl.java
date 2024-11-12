package umc.study.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QStore;
import umc.study.domain.Store;

import java.util.List;

// 이 놈이 실질적인 QueryDSL에서 필터링 조건을 담은 , 즉 동적 쿼리 본체
@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.storeName.eq(name));
        }

        if (score != null) {
            predicate.and(store.storeScope.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}