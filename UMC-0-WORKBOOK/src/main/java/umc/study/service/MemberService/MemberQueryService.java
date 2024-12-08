package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;

public interface MemberQueryService {

    Page<Review> getMyReviewList(Long memberId, Integer page);
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
