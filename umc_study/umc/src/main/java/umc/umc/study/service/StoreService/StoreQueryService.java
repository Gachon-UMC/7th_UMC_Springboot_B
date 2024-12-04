package umc.umc.study.service.StoreService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import umc.umc.study.domain.Review;
import umc.umc.study.domain.Store;
import umc.umc.study.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService{
    Page<Review> getReviewList(Integer StoreId, Integer page);
    Page<Review> getUserReviewList(Integer UserId, Integer page);
}