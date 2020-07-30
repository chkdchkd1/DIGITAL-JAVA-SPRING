package kr.green.practice.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.practice.service.UserService;
import kr.green.practice.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @Autowired
	 UserService userService;

	@RequestMapping(value= "/" , method= RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpServletRequest request ) throws Exception{
	    mv.setViewName("/main/home");
	    
	    UserVo user = (UserVo)request.getSession().getAttribute("user");
		mv.addObject("user", user);


	    return mv;
	}
		
	
	@RequestMapping(value= "/", method = RequestMethod.POST)
	public ModelAndView homePost(ModelAndView mv, UserVo user) {
	    
		UserVo dbUser = userService.isSignin(user);
		
		if( dbUser != null) {
			mv.addObject("user", dbUser);
			mv.setViewName("redirect:/");
			System.out.println(dbUser);
		} else
			mv.setViewName("redirect:/");
	    return mv;
	}
	
	
	@RequestMapping(value= "/signout" , method= RequestMethod.GET)
	public ModelAndView signOutGet(ModelAndView mv, HttpServletRequest request ){
	    mv.setViewName("redirect:/");
	    
	    request.getSession().removeAttribute("user");
	
	    return mv;
	}
	
}
