package kr.green.springtest.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.service.UserService;
import kr.green.springtest.vo.BoardVo;
import kr.green.springtest.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	

	@RequestMapping(value = "/board/list",method = RequestMethod.GET)
	public ModelAndView BoardListGet(ModelAndView mv) {
		logger.info("URI:/list");
		mv.setViewName("/board/list"); // 저 위치와 연결 
		
		ArrayList<BoardVo> list;
		list = boardService.getBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView BoardDetailGet(ModelAndView mv, Integer num) {
		logger.info("URI:/board/detail");
		mv.setViewName("/board/detail"); // 저 위치와 연결 
		
		BoardVo board = null;
		board = boardService.view(num);
		mv.addObject("board", board);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView BoardRegisterGet(ModelAndView mv) {
		logger.info("URI:/board/register");
		mv.setViewName("/board/register"); // 저 위치와 연결 
		
		return mv;
	}
	
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView BoardRegisterPost(ModelAndView mv, BoardVo board) {
		logger.info("URI:/board/register");
		mv.setViewName("redirect:/board/list"); // 저 위치와 연결 

		boardService.registerBoard(board);
		
		return mv;
	}
	
}


