package kr.green.spring.controller;

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

import kr.green.spring.service.UserService;
import kr.green.spring.vo.UserVo;

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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView homePost(ModelAndView mv, UserVo user)  {
		logger.info("URI:/");
		UserVo dbUser = userService.isSignin(user);

		if(dbUser != null) {
			mv.setViewName("redirect:/board/list");
			mv.addObject("user", dbUser);
		}else 
			mv.setViewName("redirect:/");

		return mv;
	}
	

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv)  {
		logger.info("URI:/signup:GET");
		
		 mv.setViewName("/main/signup");

		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, UserVo user)  {
		logger.info("URI:/signup:POST");
		if(userService.signup(user)) {
			mv.setViewName("redirect:/");
		}else {
			//회원가입에 실패한경우 (아이디 중복 or 이메일 미기재)
			mv.setViewName("redirect:/signup");
			//redirect는 value로 넣어주어야 
			mv.addObject("user",user);
		}

		return mv;
	}
	
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request)  {
		logger.info("URI:/signout:GET");
		
		 mv.setViewName("redirect:/");
		 request.getSession().removeAttribute("user");

		return mv;
	}
	

	@RequestMapping(value ="/idCheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id){

	    Map<Object, Object> map = new HashMap<Object, Object>();
	    UserVo user = userService.getUser(id);
	    boolean check = user == null ? true : false;
	    map.put("check",check);
	    
	    return map;
	}
	
}
