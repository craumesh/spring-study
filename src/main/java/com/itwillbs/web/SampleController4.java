package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController4 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doD
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD() {
		logger.debug("doD() 호출");
		
		// 연결되는 뷰페이지만 변경
//		return "/doE";
		// 맵핑 호출
		return "redirect:/doE";
		// 포워딩
//		return "forward:/doE";
	}
	
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public void doE() {
		logger.debug("doE() 호출");
	}
}