package com.msa_sample01.svc.member.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    public void order(String member) {
        LOGGER.error("Error during call order for member: {}", member);
    }
}
