package com.itwillbs.aop;

import javax.inject.Inject;

import org.springframework.aop.framework.ProxyFactoryBean;

public class CalcTest {	

	@Inject
	private ProxyFactoryBean bean;

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		MyCalculator calc = new MyCalculator();
		
		calc.add(10,20);
		
//		System.out.println(bean);
	}

}
