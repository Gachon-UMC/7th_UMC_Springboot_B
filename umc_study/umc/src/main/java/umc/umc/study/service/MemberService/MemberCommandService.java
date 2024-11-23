package umc.umc.study.service.MemberService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import umc.umc.study.domain.Member;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;

@Service
public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.@Valid JoinDto request);
}
