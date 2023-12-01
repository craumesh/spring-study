package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : 스프링에게 해당파일이 MemberDAO 역할을 수행하는 객체로 인식되게함

@Repository
public class MemberDAOImpl implements MemberDAO {

	// DB연결정보(자동연결, mapper접근...) 처리하는 객체 필요
	// => root-context.xml에서 생성되어있는 객체(빈)를 주입
	@Inject
	private SqlSession sqlSession;	
	
	// mapper 위치정보
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Override
	public String getTime() {
		// DB연결
		// SQL구문 작성 -> mapper.XML파일
		// SQL 실행
		// sqlSession.selectOne("SQL구문의 위치정보");
		String time = sqlSession.selectOne(NAMESPACE + ".getTime");
		
		logger.debug("getTime() 호출");
		logger.debug("time : " + time);
		
		return time;
	}

	@Override
	public void insertMember(MemberVO vo) {
		logger.debug("insertMember(MemberVO vo) 호출");
		logger.debug("mybatis가 mapper에 접근");
		logger.debug("sql 구문 실행");
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
		logger.debug("sql 구문 실행결과 발생");
		logger.debug("insertMember(MemberVO vo) 종료");
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug("MemberVO loginMember(MemberVO vo) 호출");
		logger.debug("mybatis(DAO)가 mapper에 접근");
		logger.debug("sql 구문 실행");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		logger.debug("MemberVO loginMember(MemberVO vo) 종료");
		return resultVO;
	}

	@Override
	public MemberVO loginMember(String userid, String userpw) {
		logger.debug("MemberVO loginMember(String userid, String userpw) 호출");
		logger.debug("mybatis(DAO)가 mapper에 접근");
		logger.debug("sql 구문 실행");
//		MemberVO sendVO = new MemberVO();
//		sendVO.setUserid(userid);
//		sendVO.setUserpw(userpw);
		
		// 전달된 정보가 하나의 객체(VO) 저장이 불가능한 경우 => ex) JOIN
		// => 하나의 형태로 만들어서 mapper로 전달
		// Map 컬렉션 사용
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
//		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", sendVO);
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", paramMap);
		logger.debug("MemberVO loginMember(String userid, String userpw) 종료");
		return resultVO;
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		logger.debug("MemberVO getMember(MemberVO vo) 호출");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".getMember", vo);
		logger.debug("MemberVO getMember(MemberVO vo) 종료");
		return resultVO;
	}

	@Override
	public void updateMember(MemberVO vo) {
		logger.debug("void editMember(MemberVO vo) 호출");
		MemberVO getVO = sqlSession.selectOne(NAMESPACE + ".getMember", vo);
		if(getVO.getUserid() != null && !getVO.getUserid().equals("")) {
			sqlSession.update(NAMESPACE + ".updateMember", vo);
			logger.debug("정보 수정 성공!");
		} else {
			logger.debug("해당 계정은 존재하지 않습니다!");
		}
		logger.debug("void editMember(MemberVO vo) 종료");
	}

	@Override
	public void deleteMember(MemberVO vo) {
		logger.debug("void deleteMember(MemberVO vo) 호출");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		if(resultVO.getUserid() != null && !resultVO.getUserid().equals("")) {
			sqlSession.delete(NAMESPACE + ".deleteMember", vo);
			logger.debug("회원 탈퇴 성공!");
		} else {
			logger.debug("해당 계정은 존재하지 않습니다!");
		}		
		logger.debug("void deleteMember(MemberVO vo) 종료");
		
	}	
		
}
