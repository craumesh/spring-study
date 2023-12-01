package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MyBatisTest {
	
	// DB 연결, mybatis 사용 => sqlSessionFactoryBean 객체 필요
	@Inject
	private SqlSessionFactory sqlFactory;
	// => sqlSessionFactoryBean -> SqlSessionFactory 객체로 업캐스팅
	
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void mybatis_connectTest() {
		System.out.println(sqlFactory);
//		SqlSession session = sqlFactory.openSession();
//		session.insert(statement);
		System.out.println(sqlSession);
	}
}
