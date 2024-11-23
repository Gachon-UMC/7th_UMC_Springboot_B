package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService { // week8 미션

    Member joinMember(MemberRequestDTO.JoinDto request);
}
