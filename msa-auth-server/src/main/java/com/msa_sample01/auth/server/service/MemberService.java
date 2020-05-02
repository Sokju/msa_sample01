package com.msa_sample01.auth.server.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.msa_sample01.auth.server.domain.LoginUser;
import com.msa_sample01.auth.server.domain.Member;
import com.msa_sample01.auth.server.repository.MemberRepository;


@Service
public class MemberService implements UserDetailsService {
  
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private MemberRepository repository;

//    public void joinUser(Member memberDto) {
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
//
//        Member existing = repository.findByEmail(memberDto.getEmail());
//		Assert.isNull(existing, "user already exists: " + memberDto.getEmail());
//
//		repository.save(memberDto);
//    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        
    	Member user = repository.findByEmail(userEmail);
    	
		if (user == null) {
			log.debug("Member is null");
			throw new UsernameNotFoundException("UsernameNotFound [" + userEmail + "]");
		}
		
    	log.debug(user.getEmail());
    	log.debug(user.getPassword());

		
		LoginUser loginUser = createUser(user);	
		return loginUser;
		
    }
    
    private LoginUser createUser(Member user) {
		
    	LoginUser loginUser = new LoginUser(user);
		if (loginUser.getUserType().equals("1")) {
			loginUser.setRoles(Arrays.asList("ROLE_ADMIN"));
		}
		else if (loginUser.getUserType().equals("2")) {
			loginUser.setRoles(Arrays.asList("ROLE_TESTER"));
		} else {
			loginUser.setRoles(Arrays.asList("ROLE_USER"));
		}
		return loginUser;
	}
    
   
	public static void main(String[] args) {
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		String result = bcr.encode("abcd1234");  
		System.out.println("Encrypted Password === " + result);
		
		result	= PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("testoauth2");
		System.out.println("Encrypted Password === " + result);
		
	}
}
