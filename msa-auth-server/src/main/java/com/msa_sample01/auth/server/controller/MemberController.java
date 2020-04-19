package com.msa_sample01.auth.server.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@RequestMapping(value = { "/user" }, produces = "application/json")
	public Map<String, Object> user(OAuth2Authentication user) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		return userInfo;
	}
	
//	private MemberService memberService;
//
//    // 메인 페이지
//    @GetMapping("/")
//    public String index() {
//        return "/index";
//    }
//
//    // 회원가입 페이지
//    @GetMapping("/user/signup")
//    public String dispSignup() {
//        return "/signup";
//    }
//
//    // 회원가입 처리
//    @PostMapping("/user/signup")
//    public String execSignup(Member memberDto) {
////        memberService.joinUser(memberDto);
//
//        return "redirect:/user/login";
//    }
//
//    // 로그인 페이지
//    @GetMapping("/user/login")
//    public String dispLogin() {
//        return "/login";
//    }
//
//    // 로그인 결과 페이지
//    @GetMapping("/user/login/result")
//    public String dispLoginResult() {
//        return "/loginSuccess";
//    }
//
//    // 로그아웃 결과 페이지
//    @GetMapping("/user/logout/result")
//    public String dispLogout() {
//        return "/logout";
//    }
//
//    // 접근 거부 페이지
//    @GetMapping("/user/denied")
//    public String dispDenied() {
//        return "/denied";
//    }
//
//    // 내 정보 페이지
//    @GetMapping("/user/info")
//    public String dispMyInfo() {
//        return "/myinfo";
//    }
//
//    // 어드민 페이지
//    @GetMapping("/admin")
//    public String dispAdmin() {
//        return "/admin";
//    }

}
