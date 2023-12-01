package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	// 추상메서드로 처리동작 선언
	
	// DB의 시간정보 조회
	String getTime();
	
	// 회원가입 처리동작
	void insertMember(MemberVO vo);
	
	// 로그인 처리동작
	MemberVO loginMember(MemberVO vo);
	MemberVO loginMember(String userid, String userpw);
	
	// 회원정보 조회
	MemberVO getMember(MemberVO vo);
	
	// 회원정보 수정
	void updateMember(MemberVO vo);
	
	// 회원정보 삭제
	void deleteMember(MemberVO vo);
}
