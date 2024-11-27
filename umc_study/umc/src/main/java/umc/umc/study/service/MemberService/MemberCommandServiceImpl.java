package umc.umc.study.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.umc.study.converter.MemberConverter;
import umc.umc.study.converter.MemberPreferConverter;
import umc.umc.study.domain.FoodCategory;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.MemberPrefer;
import umc.umc.study.repository.FoodCategoryRepository;
import umc.umc.study.repository.MemberRepository;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;


import umc.umc.study.apiPayload.code.status.ErrorStatus;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;


    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}