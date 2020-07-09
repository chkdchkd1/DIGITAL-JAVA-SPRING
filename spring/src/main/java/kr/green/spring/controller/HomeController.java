package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	// -> 객체를 생성하는 역할 
	private UserService userService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv)  {
		logger.info("URI:/");
		
		 mv.setViewName("/main/home");

		return mv;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testGet(ModelAndView mv,String id,String pw)  {
		logger.info("URI:/test");
		 mv.setViewName("/main/test");
		 mv.addObject("title","테스트");
		 logger.info("전송된 아이디 : "+id);
		 logger.info("전송된 비밀번호 : "+pw);
		 
		 String userPw = userService.getPW(id);
		 logger.info("조회된 비밀번호: "+userPw);
		 
		 //현재 데이터베이스에 있는 사람이 몇명인지 조회하는 코드 
		 int count = userService.getCount();
		 logger.info("회원 수 :"+count);
		 
		 
		 //해당  아이디 회원이 현재 데이터베이스에 존재 여부 
		 String check = userService.getCheck(id);
		 logger.info(" 가입여부  : " +check); 
		 
		 // mapper - dao가 자료형이 일치해야하고 & controller - service(serviceImp)이 일치하기만 하면 된다.
		 

		return mv;
	}
	
}
