package umc.umc.study.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import umc.umc.study.domain.Gender;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Users;
import umc.umc.study.domain.enums.Role;
import umc.umc.study.repository.MemberRepository;
import umc.umc.study.repository.UsersRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest); // 카카오에서 제공하는 사용자 정보를 OAuth2User 객체로 받아옴

//        Map<String, Object> attributes = oAuth2User.getAttributes();
//        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
//
//        String nickname = (String) properties.get("nickname"); // 사용자 정보 중 nickname 뽑아옴
//        String email = nickname + "@kakao.com"; // 임시 이메일 생성

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 구글/카카오 구분
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email;
        String nickname;

        if ("kakao".equals(registrationId)) {
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            nickname = (String) properties.get("nickname"); // 카카오 nickname
            email = nickname + "@kakao.com"; // 카카오 임시 이메일
        }  else if ("naver".equals(registrationId)) {
            Map<String, Object> response = (Map<String, Object>) attributes.get("response"); // 네이버는 'response' 키 하위에 데이터가 있음
            nickname = (String) response.get("name"); // 네이버 name
            email = (String) response.get("email"); // 네이버 email
        } else {
            throw new OAuth2AuthenticationException("Unsupported provider: " + registrationId);
        }

        // 사용자 정보 저장 또는 업데이트
        Member member = saveOrUpdateUser(email, nickname); // 사용자 정보를 데이터베이스에 저장하거나 업데이트

        // 이메일을 Principal로 사용하기 위해 attributes 수정
        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("email", email);

        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "email"  // email Principal로 설정
        );
    }

    private Member saveOrUpdateUser(String email, String nickname) {
        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .name(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                        .gender(Gender.NONE)  // 기본값 설정
                        .address("소셜로그인")  // 기본값 설정
                        .specAddress("소셜로그인")  // 기본값 설정
                        .role(Role.USER)
                        .build());

        return memberRepository.save(member);
    }
}