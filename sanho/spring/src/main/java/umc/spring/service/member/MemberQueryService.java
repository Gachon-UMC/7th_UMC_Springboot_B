package umc.spring.service.member;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {

    // week9 미션
    Page<Review> getReviewList(Long memberId, Integer page); // Page 자체에 페이징과 관련된 여러 정보가 담김 -> Paging을 위한 추상화 제공

    // week9 미션 - 내가 진행 중인 미션 목록
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
