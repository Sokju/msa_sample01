package com.msa_sample01.svc.member.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//name 				: 서비스ID 혹은 논리적인 이름, spring-cloud의 eureka, ribbon에 사용
//url 				: 실제 호출할 서비스의 URL, eureka, ribbon을 사용하지 않고서도 동작
//decode404 		: 404응답이 올 때 FeignExeption을 발생시킬지, 아니면 응답을 decode할 지 여부
//configuration 	: feign configuration class 지정
//fallback 			: hystrix fallback class 지정
//fallbackFactory 	: hystrix fallbak factory 지정

@FeignClient(name = "msa-svc-order", fallback = OrderServiceClientFallback.class)
public interface OrderServiceClient {

//	@RequestMapping(value = "/order", method = RequestMethod.POST)
//	ResponseEntity<Member> order(@RequestBody Member member);

	@RequestMapping(value = "/v1/order", method = RequestMethod.POST)
	void order(String member);

}
