package umc.study.repository.StoreRepository;

import umc.study.domain.Store;

import java.util.List;

// 이 놈은 QueryDSL을 사용하여 사용자 정의 쿼리를 작성할 수 있는 메서드를 정의하는 놈
public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}