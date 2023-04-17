package com.kwm.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kwm.exam.demo.repository.MemberRepository;
import com.kwm.exam.demo.vo.Member;

@Service
public class MemberService {

	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
		
	}
	
//	public Member getMember(String loginId) {
//		return memberRepository.getMember(loginId);
//	}
//	
	 public List<Member> getMembers() {
	      return memberRepository.getMembers();
	   }
	 

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		return memberRepository.getLastInsertId();
	}
	
	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	
	 
	 
}
