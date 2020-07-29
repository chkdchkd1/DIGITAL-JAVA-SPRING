package kr.green.practice.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.practice.pagination.Criteria;
import kr.green.practice.pagination.PageMaker;
import kr.green.practice.service.BoardService;
import kr.green.practice.vo.BoardVo;
import kr.green.practice.utils.UploadFileUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//@Resource
	private String uploadPath = "C:\\Users\\Administrator\\Desktop\\upload";
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	 

	@RequestMapping(value= "/board/list",  method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri){
		
		mv.setViewName("/board/list");
		System.out.println(cri);
		PageMaker pm = boardService.getPageMaker(cri);
		
		ArrayList <BoardVo> list;
		list = boardService.getboardList(cri);
		mv.addObject("list", list);
		mv.addObject("pm", pm);
		System.out.println(pm);
		System.out.println(cri);
	
	    return mv;
	}

	
	@RequestMapping(value= "/board/detail",  method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num,Criteria cri){
		
		
		BoardVo board = boardService.getBoardDetail(num);
		mv.addObject("board", board);
		mv.addObject("cri", cri);
		System.out.println(cri);

		mv.setViewName("/board/detail");
	
	    return mv;
	}
	
	@RequestMapping(value= "/board/register",  method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv){
		
		mv.setViewName("/board/register");
	
	    return mv;
	}
	
	@RequestMapping(value= "/board/register",  method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv,BoardVo board, MultipartFile file2) throws IOException, Exception{
		
		String fileName = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(),file2.getBytes());
		board.setFile(fileName);
		boardService.registerBoard(board);
		mv.setViewName("redirect:/board/list");

	    return mv;
	}
	
	
	@RequestMapping(value= "/board/modify",  method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv,Integer num){

		BoardVo board = boardService.getBoardDetail(num);
		
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		System.out.println(board.getFile());

	    return mv;
	}
	
	
	@RequestMapping(value= "/board/modify",  method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVo board){

		boardService.getBoardUpdate(board);
		int num = board.getNum();
		mv.setViewName("redirect:/board/detail?num="+num);
		
	    return mv;
	}
	
	
	@RequestMapping(value= "/board/delete",  method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer num){

		boardService.getBoardDelete(num);
		mv.setViewName("redirect:/board/list");

	    return mv;
	}
	
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        
	        HttpHeaders headers = new HttpHeaders();
	        // HttpHeader라는 객체를 생성해서 이미지를 보낸다 
	        in = new FileInputStream(uploadPath+fileName);
	        //파일을 읽어옴 = fileinputStream

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
	
	
}
