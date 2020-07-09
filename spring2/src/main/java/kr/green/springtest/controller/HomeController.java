package kr.green.springtest;

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

import kr.springtest.Service.studentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private studentService StudentService;
	// 앞이랑 이름이랑 완전히 같으면  X 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ModelAndView home (ModelAndView mv, String num) {
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "테스트");
	    
	
		String name = StudentService.getName(num);
	    logger.info("조호된 학생의 이름 :" +name);
	    
	    return mv;
	}


}
