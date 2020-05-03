package com.msa_sample01.auth.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msa_sample01.auth.server.domain.Member;

//@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Query("SELECT DISTINCT u FROM Member u WHERE u.email = :email")
	Member findByUsername(@Param("email") String email);

}

