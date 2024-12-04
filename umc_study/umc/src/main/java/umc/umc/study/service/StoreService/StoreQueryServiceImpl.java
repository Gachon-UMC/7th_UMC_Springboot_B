package umc.umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.umc.study.domain.Review;
import umc.umc.study.domain.Store;
import umc.umc.study.domain.Users;
import umc.umc.study.repository.ReviewRepository;
import umc.umc.study.repository.StoreRepository;
import umc.umc.study.repository.UsersRepository;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final UsersRepository usersRepository;

    @Override
    public Page<Review> getReviewList(Integer StoreId, Integer page) {


        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Review> getUserReviewList(Integer UserId, Integer page) {


        Users users = usersRepository.findById(UserId).get();


        Page<Review> StorePage = reviewRepository.findAllByUsers(users, PageRequest.of(page, 10));
        return StorePage;
    }
}
