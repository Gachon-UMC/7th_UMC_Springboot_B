package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter { // week8 미션

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = Gender.fromValue(request.getGender());


//        switch (gender){
//            case 1:
//                gender = Gender.MALE;
//                break;
//            case 2:
//                gender = Gender.FEMALE;
//                break;
//            case 3:
//                gender = Gender.NONE;
//                break;
//        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드.
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }

    // week9 미션 - 특정 멤버 리뷰 조회
    public static MemberResponseDTO.MemberReviewDTO memberReviewDTO(Review review) {
        return MemberResponseDTO.MemberReviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MemberReviewListDTO memberReviewListDTO(Page<Review> reviewPage) {
        List<MemberResponseDTO.MemberReviewDTO> memberReviewDTOList = reviewPage.stream()
                .map(MemberConverter::memberReviewDTO).collect(Collectors.toList()); // 각각의 memberReviewDTO를 리스트에 넣어줌

        return MemberResponseDTO.MemberReviewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(memberReviewDTOList.size())
                .reviewList(memberReviewDTOList)
                .build();
    }

    // week9 미션 - 내가 진행 중인 미션 목록
    public static MemberResponseDTO.MemberMissionDTO memberMissionDTO(MemberMission memberMission) {
        Mission mission = memberMission.getMission();

        return MemberResponseDTO.MemberMissionDTO.builder()
                .storeName(mission.getStore().getName())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .status(MissionStatus.CHALLENGING) // 진행 중인 미션으로 하드 코딩
                .build();
    }

    public static MemberResponseDTO.MemberMissionListDTO memberMissionListDTO(Page<MemberMission> memberMissionPage) {
        List<MemberResponseDTO.MemberMissionDTO> memberMissionDTOList = memberMissionPage.stream()
                .map(MemberConverter::memberMissionDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberMissionListDTO.builder()
                .isLast(memberMissionPage.isLast())
                .isFirst(memberMissionPage.isFirst())
                .totalPage(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .listSize(memberMissionDTOList.size())
                .missionList(memberMissionDTOList)
                .build();
    }
}