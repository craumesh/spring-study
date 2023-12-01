package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	// 테스트 전용 클래스
	
	// MemberDAO 객체 필요 => memberDAOImpl 객체가 주입(DI)
	@Inject
	private MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
//	@Test
	public void mybatis_첫쿼리구문실행_테스트() {		
		logger.info("테스트 결과 : " + mdao.getTime());
		logger.info("야호!");
		logger.debug("호야!");
	}
	
//	@Test
	public void 회원가입_테스트() {
		logger.debug("회원가입_테스트() - 호출");
		MemberVO vo = new MemberVO();
		vo.setUserid("admin6");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("admin@admin.com");
		
		mdao.insertMember(vo);
		
		logger.debug("회원가입_테스트() - 종료");
	}
	
//	@Test
	public void 로그인_테스트() {
		logger.debug("로그인_테스트() - 호출");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
//		MemberVO resultVO = mdao.loginMember(vo);
		MemberVO resultVO = mdao.loginMember("admin","1234");
		if(!resultVO.getUserid().equals("") && resultVO.getUserid() != null) {
			logger.debug(resultVO.getUserid() + " : 로그인 성공!");
		} else {
			logger.debug("로그인 실패!");
		}
		
		logger.debug("로그인_테스트() - 종료");
	}
	
//	@Test
	public void 회원정보조회_테스트() {
		logger.debug("회원정보조회_테스트() - 호출");
		logger.debug("사용자의 ID를 사용하여 회원정보 모두 조회");
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		
		MemberVO resultVO = mdao.getMember(vo);
		if(!resultVO.getUserid().equals("") && resultVO.getUserid() != null) {
			logger.debug("조회 성공 : " + resultVO);
		} else {
			logger.debug("조회 실패!");
		}
		logger.debug("회원정보조회_테스트() - 종료");
	}
	
//	@Test
	public void 회원정보_수정_테스트() {
		logger.debug("회원정보_수정_테스트() - 호출");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		vo.setUsername("이진수");
		vo.setUseremail("test1@test.com");
		mdao.updateMember(vo);
		
		logger.debug("회원정보_수정_테스트() - 종료");
	}
	
	@Test
	public void 회원정보_삭제_테스트() {
		logger.debug("회원정보_삭제_테스트() - 호출");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");	
		mdao.deleteMember(vo);
		
		logger.debug("회원정보_삭제_테스트() - 종료");
	}
}
