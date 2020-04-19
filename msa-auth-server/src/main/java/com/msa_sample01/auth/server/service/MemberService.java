package com.msa_sample01.auth.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msa_sample01.auth.server.domain.Member;
import com.msa_sample01.auth.server.repository.MemberRepository;


@Service
//public class MemberService implements UserDetailsService {
public class MemberService {
    
//	private MemberRepository repository;
//
//    public void joinUser(Member memberDto) {
//        // 비밀번호 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
//
//        Member existing = repository.findByEmail(memberDto.getEmail());
//		Assert.isNull(existing, "user already exists: " + memberDto.getEmail());
//
//		repository.save(memberDto);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        
//        Member userEntity = repository.findByEmail(userEmail);
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (("admin@example.com").equals(userEmail)) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
//        }
//
//        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
//    }
}
