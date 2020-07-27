package kr.green.springtest.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.service.UserService;
import kr.green.springtest.utils.UploadFileUtils;
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
	@Autowired
	private UserService userService;
//	@Resource
	private String uploadPath = "C:\\Users\\Administrator\\Desktop\\upload";

	@RequestMapping(value = "/board/list",method = RequestMethod.GET)
	public ModelAndView BoardListGet(ModelAndView mv,Criteria cri) {
		logger.info("URI:/list");
		mv.setViewName("/board/list"); // 저 위치와 연결 
		
		PageMaker pm = boardService.getPageMaker(cri);
		//컨트롤러가 알고 있는건 현재 페이지 정보이기에 이걸줄테니 서비스 ㅇㅇ 토탈카운트 구해와서 페이지메이커 만들어라 
		ArrayList<BoardVo> list;
		list = boardService.getBoardList(cri);
		mv.addObject("list", list);
		mv.addObject("pm", pm);
		System.out.println(pm);
		return mv;
	}
	
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView BoardDetailGet(ModelAndView mv, Integer num, Criteria cri) {
		logger.info("URI:/board/detail");
		mv.setViewName("/board/detail"); // 저 위치와 연결 
		
		BoardVo board = null;
		board = boardService.view(num);
		mv.addObject("board", board);
		mv.addObject("cri", cri);
		//mv.addobject () = 화면에 정보를 넘긴다 
		
		return mv;
	}
	
	
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView BoardRegisterGet(ModelAndView mv) {
		logger.info("URI:/board/register");
		mv.setViewName("/board/register"); // 저 위치와 연결 
		
		return mv;
	}
	
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView BoardRegisterPost(ModelAndView mv, BoardVo board,HttpServletRequest request, MultipartFile file2) throws Exception {
		logger.info("URI:/board/register");
		mv.setViewName("redirect:/board/list"); // 저 위치와 연결 

		String fileName = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(),file2.getBytes()); 
		board.setFile(fileName);
		boardService.registerBoard(board,request);
		
		return mv;
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		mv.setViewName("/board/modify");
		BoardVo board = boardService.getBoardDetail(num);
		mv.addObject("board",board);
		UserVo user = userService.getUser(request);
		if(board == null || !user.getId().equals(board.getwriter())) {
			mv.setViewName("redirect:/board/list"); 
			//리다이렉트(redirect) 클라이언트가 새로 페이지를 요청한 것과 같은 방식으로 페이지가 이동됨 
			// - request, response가 유지되지 않는다 (새로 만들어짐)
			// - 이동된 url가 화면에 보인다
			
		}
		return mv;
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyGet(ModelAndView mv, BoardVo board,HttpServletRequest request,MultipartFile file2) throws IOException, Exception  {
		mv.setViewName("redirect:/board/list");
		UserVo user = userService.getUser(request);
		
	
			if(file2.getOriginalFilename().length() != 0) {
				String fileName = UploadFileUtils.uploadFile(uploadPath,file2.getOriginalFilename(),file2.getBytes()); 
				board.setFile(fileName); 
				} else if (board.getFile().length() == 0) {
					System.out.println(file2.getOriginalFilename()); 
					board.setFile(null);
					}
		
			// if(!file2.getOriginalFilename().equals("")) {
			// ~~   }
			//	else if ((board.getFile() == null ||board.getFile().equals(""))
			//}
			
			/*
			 * 변수(variable)를 초기화(initialize)하는 관점에서 null은 어떠한 값으로도 초기화 되지 않았다. "" 는 빈 값으로
			 * 초기화 되었다. 의 차이가 있습니다. 때문에 null 은 원칙적으로 ""와 비교할 수 없는 것입니다.
			 */
		boardService.updateBoard(board,user);
		 System.out.println(board);
		 System.out.println(file2.getOriginalFilename());
		return mv;
	}
	
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView BoardDeleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
				
		boardService.deleteBoard(num, userService.getUser(request));
		mv.setViewName("redirect:/board/list"); 
		// 저 위치와 연결 
		return mv;
	}
	
	
	@RequestMapping(value ="/board/up" , method = RequestMethod.POST)
	//method를 생략하면 get post 둘다 ㄱㄴ 하지만 추천수를 GET으로 주면 외부에서 URL로 접근해서 추천수를 올릴 수 있기 때문에 (다른아이디로 URL바꾸면 ㄱㄴ) POST로 해주는 것이 좋다 
	@ResponseBody
	public Map<Object, Object> upCount(@RequestBody Integer num,HttpServletRequest request){

	    Map<Object, Object> map = new HashMap<Object, Object>();
	    //현재 로그인중인 유저 정보 
	    UserVo user = userService.getUser(request);
	    if (user == null)
	    	map.put("usercheck",false);
	    else {
	    	map.put("usercheck",true);
	    	int up = boardService.updateUp(num, user.getId());
	    	map.put("upcount",up);
	    }
	    // 클릭하고 로그인을 했을 경우 true, 내가 누른 게시물의 좋아요수 총합을 보낸다 . 
	    return map;
	}
	
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        // 
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        //다운로드 시 저장할 파일명
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        //헤더에 컨텐츠 타입을 설정
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        //헤더 정보를 추가 
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	        // ResponseEntity 객체 생성, 전송할 파일, 헤더 정보, 헤더 상태 
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
	
}


