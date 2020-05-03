package com.msa_sample01.svc.member.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msa_sample01.svc.member.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

	Member findByEmail(String email);
	
	Member findByName(String memberName);
	
	List<Member> findAll();

}
