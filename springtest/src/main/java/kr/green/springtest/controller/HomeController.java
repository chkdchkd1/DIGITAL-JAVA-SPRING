package kr.green.springtest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.UserService;
import kr.green.springtest.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/main/home");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public ModelAndView homePost(ModelAndView mv, UserVo user) {
		logger.info("URI:/");
		
		// Ambiguous handler methods mapped for -> requestMapping 중복 , value 는 물론 method도 중복되어선 X 
		//로그인 기능 ? = 입력받은 아이디와 비번으로 유저정보 검색해서 있으면 저장
		UserVo dbUser = userService.isSignin(user);
		
		if (dbUser != null ) {
			mv.setViewName("redirect:/board/list");
			mv.addObject("user", dbUser);
			// - jsp에서 ${user} 이런 식으로 사용 ㄱㄴ 
		}else {
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/user/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		logger.info("URI:/signin:Get");
		mv.setViewName("/main/home");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		logger.info("URI:/signup");
		mv.setViewName("/user/signup");
		return mv;
	}
	
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, UserVo user) {
		
		if(userService.signup(user)) {
			mv.setViewName("redirect:/");			
		}else {
			mv.setViewName("redirect:/user/signup");
			mv.addObject("user", user);
			System.out.println(user);
			
		}
		//아이디 중복검사하고 있으면(중복이면) 회원가입화면으로 돌아와 원래 기입한 정보 보여주기 

		return mv;
	}
	
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public ModelAndView logoutGEt(ModelAndView mv, HttpServletRequest request) {
		logger.info("URI:/logout");
		mv.setViewName("redirect:/");
		
		request.getSession().removeAttribute("user");
		
		return mv;
	}
	
	
	
	@RequestMapping(value ="/idCheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id){

	    Map<Object, Object> map = new HashMap<Object, Object>();
	    UserVo user = userService.getUser(id);
	    if(user == null ) 
	    	map.put("isUser",true);
	    else 
	    	map.put("isUser",false);
	    return map;
	}
	
	
//servlet-context.html
//beans: bean =  요소를 등록
//bean id랑 beans:ref bean이랑 일치 시켜주어야 한다 
//<interceptors> = 여러개의 interceptors가 온다 
	
	
	
}

