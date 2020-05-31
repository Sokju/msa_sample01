package com.msa_sample01.svc.member.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.msa_sample01.svc.member.domain.Member;

@Component
public class OrderServiceClientFallback implements OrderServiceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceClientFallback.class);

//    @Override
//    public ResponseEntity<Member> order(Member member) {
//        LOGGER.error("Error during order for member: {}", member.getName());
//        
//        return new ResponseEntity<Member>(member, HttpStatus.BAD_GATEWAY);
//        
//    }
    
    @Override
    public ResponseEntity<Member> order(String member) {
        LOGGER.error("Error during call order for member: {}", member);
        
        return new ResponseEntity<Member>(new Member(), HttpStatus.BAD_GATEWAY);
    }
}