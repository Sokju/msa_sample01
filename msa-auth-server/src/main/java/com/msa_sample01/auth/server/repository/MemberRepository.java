package com.msa_sample01.auth.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msa_sample01.auth.server.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {

	Member findByEmail(String email);

}
