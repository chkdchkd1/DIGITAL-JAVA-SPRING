package kr.green.practice.controller;

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
	    
	    UserVo user = userService.getUser(request);
		if (user == null ) {
			mv.setViewName("/main/home");
		} else {
		mv.setViewName("/user/sucLogin");
		}   
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
	
	
	@RequestMapping(value= "/signup" , method= RequestMethod.GET)
	public ModelAndView signUpGet(ModelAndView mv, HttpServletRequest request){
	    
		UserVo user = userService.getUser(request);
		if (user == null ) {
			mv.setViewName("/user/signup");
		} else {
		mv.setViewName("/user/sucLogin");
		}   
	    return mv;
	}
	
	
	@RequestMapping(value= "/signup" , method= RequestMethod.POST)
	public ModelAndView signUpPost(ModelAndView mv,UserVo user){
	    
		// 이미 존재하는 회원인지, 또는 잘못된 값이 들어오지 않았는지  확인후 있으면 다시 회원가입 홈페이지로 없으면 alert 후에  로그인창으로 
		if (userService.signUp(user)) {
			mv.setViewName("redirect:/");
		} else {
			mv.setViewName("redirect:/signup");
			mv.addObject("user", user);
		}   
	    return mv;
	}
	
	
	
	@RequestMapping(value= "/sucLogin" , method= RequestMethod.GET)
	public ModelAndView sucLoginGet(ModelAndView mv){
	    mv.setViewName("/user/sucLogin");
	    
	    return mv;
	}
	
	
	@RequestMapping(value= "/userInfo" , method= RequestMethod.GET)
	public ModelAndView userInfoGet(ModelAndView mv, HttpServletRequest request){
		UserVo user = userService.getUser(request);
		mv.addObject("userInfo", user);
	    mv.setViewName("/user/userInfo");
	
	    return mv;
	}
	
	
	@RequestMapping(value= "/userInfo" , method= RequestMethod.POST)
	public ModelAndView userInfoPost(ModelAndView mv, UserVo user){
		
		// 중복된 비밀번호를 등록하려는경우 막는 처리도 해줘야 ㅇㅇ ..
		if(userService.modifyInfo(user)) {
			mv.setViewName("redirect:/");
		}else
			mv.setViewName("redirect:/userInfo");
	    return mv;
	}
	
	
	
	@RequestMapping(value ="/idCheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    if(userService.getUser(id) != null)
	        map.put("isId", false);
	    else
	    	map.put("isId", true);
	    System.out.println(id);
	    return map;
	}
	
	@RequestMapping(value ="/pwCheck")
	@ResponseBody
	public Map<Object, Object> pwcheck(@RequestBody TestVo test){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	   UserVo user = userService.getUser(test.getId());
	  if(userService.checkPw(user,test.getPw())) {
		  map.put("isCheck",true);
	  }else 
	    map.put("isCheck",false);
	    return map;
	}
	

	
}


class TestVo {
	private String id;
	private String pw;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "TestVo [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
}
