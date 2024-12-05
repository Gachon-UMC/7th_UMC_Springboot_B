package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.spring.service.member.MemberCommandService;
import umc.spring.web.dto.MemberRequestDTO;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/members/signup")
    public String joinMember(@Valid @ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model) {

        // 바인딩 오류 출력
//        if (bindingResult.hasErrors()) {
//            bindingResult.getAllErrors().forEach(error -> System.out.println("Binding Error: " + error.toString()));
//            return "signup";
//        }
//        System.out.println("Request: " + request);
//        System.out.println("Password: " + request.getPassword());
//        System.out.println("request.getName() = " + request.getName());
//        System.out.println("request.getAddress() = " + request.getAddress());
//        System.out.println("request.getSpecAddress() = " + request.getSpecAddress());
//        System.out.println("request.getEmail() = " + request.getEmail());
//        System.out.println("request.getPreferCategory() = " + request.getPreferCategory());

        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지
            return "signup";
        }

        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이지를 유지
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

//    @GetMapping("/signup")
//    public String signupPage(Model model) {
//        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
//        return "signup";
//    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}