package com.msa_sample01.svc.member.service;

import java.util.List;

import com.msa_sample01.svc.member.domain.Member;

public interface MemberService {

	List<Member> getMemberList();
	
	/**
	 * 멤버검색
	 *
	 * @param memberName
	 * @return Member
	 */
	Member findByName(String memberName);

	/**
	 * 멤버생성
	 *
	 * @param memeber
	 */
	void createMember(Member member);

	/**
	 * 멤버수정
	 *
	 * @param memeber
	 */
	void updateMember(Member member);
	
	/**
	 * 멤버삭제
	 *
	 * @param memberName
	 */
	void deleteMember(String memeberName);
}
