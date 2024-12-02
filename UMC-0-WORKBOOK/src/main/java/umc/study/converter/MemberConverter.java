package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.study.web.dto.MemberDTO.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(gender)
                .name(request.getName())
                .age(request.getAge())
                .role(request.getRole())
                .build();
    }

    // 내 리뷰 목록 조회
    public static MemberResponseDTO.MyReviewPreviewDTO myReviewPreviewDTO(Review review){
        return MemberResponseDTO.MyReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }

    public static MemberResponseDTO.MyReviewPreviewListDTO myReviewPreviewListDTO(Page<Review> myReviewList){

        List<MemberResponseDTO.MyReviewPreviewDTO> myReviewPreviewDTOList = myReviewList.stream()
                .map(MemberConverter::myReviewPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MyReviewPreviewListDTO.builder()
                .isLast(myReviewList.isLast())
                .isFirst(myReviewList.isFirst())
                .totalPage(myReviewList.getTotalPages())
                .totalElements(myReviewList.getTotalElements())
                .listSize(myReviewPreviewDTOList.size())
                .myReviewList(myReviewPreviewDTOList)
                .build();
    }


}
