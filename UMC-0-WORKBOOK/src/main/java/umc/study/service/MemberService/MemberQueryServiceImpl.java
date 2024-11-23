package umc.study.service.MemberService;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page){

        Member member = memberRepository.findById(memberId).get();

        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return memberPage;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page){

        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> memberPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));

        return memberPage;



    }
}
