package com.itwillbs.web;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doD"
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(/* @ModelAttribute("msg") String msg */ RedirectAttributes rttr /*, Model model */) {
		logger.debug("doD() 호출");
		
		rttr.addFlashAttribute("msg","아이터월");
//		model.addAttribute("msg2","itwill");
		
		// addAttribute() : URI표시O, (Model, RedirectAttributes) 둘다 사용가능, F5 데이터 유지
		// addFlashAttribute() : URI표시X, (RedirectAttributes)만 사용 가능, F5 데이터 사라짐
		
		// 연결되는 뷰페이지만 변경
//		return "/doE";
		// 맵핑 호출
		return "redirect:/doE";
		// 포워딩
//		return "forward:/doE";
	}
	
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public void doE(@ModelAttribute("msg") String msg) {
		logger.debug("doE() 호출");
		
		logger.debug("msg : "+msg);
	}
	
	// http://localhost:8088/web/doF?data=1234"
	// http://localhost:8088/web/doF?data=1234&data=2222"
	@RequestMapping(value = "/doF", method = RequestMethod.GET)
	public void doF(@RequestParam("data") ArrayList<Integer> data/* @RequestParam("data") int[] data *//* @RequestParam("data") int data *//* @ModelAttribute("data") int data */) {
		logger.debug("doF() 호출");
		logger.debug("data : "+data);
//		logger.debug("data0 : "+data[0]);
//		logger.debug("data1 : "+data[1]);
//		logger.debug("data : "+(data+100));
	}
}
