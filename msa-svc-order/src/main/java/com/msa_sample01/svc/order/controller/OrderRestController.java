package com.msa_sample01.svc.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa_sample01.svc.order.domain.OrderCVO;
import com.msa_sample01.svc.order.service.OrderServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderRestController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
//	@Autowired
//	private KafkaProducer kafkaProducer;
	
	@HystrixCommand
	@RequestMapping(value = "/v1/order", method = RequestMethod.POST)
//	public ResponseEntity<OrderCVO> order(@RequestBody OrderCVO orderCVO) {
//		
//		//order
//		orderServiceImpl.order(orderCVO);
//
//		//kafka
//		//kafkaProducer.send("kafka-pub", orderCVO);
//		
//		return new ResponseEntity<OrderCVO>(orderCVO, HttpStatus.OK);
//	}
	public ResponseEntity<OrderCVO> order(@RequestBody String member) {
		
		log.debug("member : {}", member);
		//order
		//orderServiceImpl.order(orderCVO);

		//kafka
		//kafkaProducer.send("kafka-pub", orderCVO);
		
		OrderCVO orderCVO = new OrderCVO();
		orderCVO.setMemberName(member);
		orderCVO.setOrderName("order");
		
		return new ResponseEntity<OrderCVO>(orderCVO, HttpStatus.OK);
		
	}
}
