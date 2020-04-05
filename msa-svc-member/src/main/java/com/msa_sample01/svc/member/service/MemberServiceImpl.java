package com.msa_sample01.svc.member.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msa_sample01.svc.member.client.OrderServiceClient;
import com.msa_sample01.svc.member.domain.Member;
import com.msa_sample01.svc.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrderServiceClient orderServiceClient;

	@Autowired
	private MemberRepository repository;
	
	private List<Member> users = Arrays.asList(new Member("james", "tester", "james@crossent.com"),
			new Member("john", "admin", "john@crossent.com"),
			new Member("harry", "developer", "harray@crossent.com"));

	@Override
	public List<Member> getMemberList() {
		return users;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Member findByName(String memberName) {
		Assert.hasLength(memberName, "memberName is null");
		
		Member member = new Member();
		
		log.debug("Member Name : {} ", memberName);
		
		member.setName(memberName);
		orderServiceClient.order(member.getName());
		
		return repository.findByName(memberName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createMember(Member member) {

		Member existing = repository.findByName(member.getName());
		Assert.isNull(existing, "memeber already exists: " + member.getName());

		repository.save(member);

		log.debug("new member has been created: " + member.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateMember(Member member) {

		Member existing = repository.findByName(member.getName());
		Assert.notNull(existing, "can't find member with name " + member.getName());

		repository.save(member);

		log.debug("Memeber {} changes has been saved", member.getName());

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteMember(String memberName) {

		Member existing = repository.findByName(memberName);
		Assert.notNull(existing, "can't find member with name " + memberName);

		repository.deleteById(memberName);

		log.debug("Memeber {} has been deleted", memberName);

	}
}
