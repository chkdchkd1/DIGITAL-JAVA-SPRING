package kr.green.practice.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.practice.service.BoardService;
import kr.green.practice.vo.BoardVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	 

	@RequestMapping(value= "/board/list",  method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv){
		
		
		mv.setViewName("/board/list");
		ArrayList <BoardVo> list;
		list = boardService.getboardList();
		mv.addObject("list", list);
		System.out.println(list);
	
	   
	    return mv;
	}


	
}
