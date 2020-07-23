package kr.green.spring.controller;

import java.io.FileInputStream;
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

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.UserService;
import kr.green.spring.service.boardService;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

@Controller
public class BoardController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private boardService BoardService;
	@Autowired
	private UserService userService;
//	@Resource
	private String uploadPath = "C:\\Users\\Administrator\\Desktop\\upload";
	
	//url주소와 쿼리스트링은 ?로 구분되며 변수와 값의 쌍으로 구성된다. 여러 쌍의 변수와 값을 전달할경우 각각의 쌍을 &로 구분해주면 된다.
	// 매개 변수를 전달하는 쿼리입니다. ?pagename=navigation는 'navigation'값을 pagename 매개 변수에 전달합니다. 
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri, HttpServletRequest request) {
		// 데이터를 전송하면 매개변수가 받는다 
		// list?page=11 의 page는 cri의 멤버 변수 page ,
		// 평소라면 integer page를 주고 list 그페이지의 리스트를 읽어 오게 하려했는데 cri로 줌으로써 멤버 변수와 이름이 같은걸 그냥 읽어오는~ 
		
		logger.info("URI:/board/list");
		 mv.setViewName("/board/list");
		 PageMaker pm = BoardService.getPageMaker(cri);
		 
		 ArrayList<BoardVo> list;
		 
		 list = BoardService.getBoardList(cri);
		 /*여기서 배열을 만드는게 아니라 데이터베이스가 만들어서 건네준걸 활용*/

		 mv.addObject("list",list);    
		 // mv를 리턴하면 전달받은 페이지 (*html, *jsp)에서 표현언어로 출력. 접근 가능 
		 // ex)mav.addobject("type","student") 에서 지정한 객체의 이름인 ${type} 를이용해서 값인 student를 가져올 수 있음
		 
		 mv.addObject("pm", pm);
		 // 화면에 pm 전달 
		 System.out.println(pm);		 
		return mv;
	}
	
	
//	http://localhost:8080/spring/board/detail?num=1 페이지 구현 -> 일단 requestMapping을 만들고 jsp 추가 
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num,Criteria cri) {
		// criteria cri = 현재 페이지 정보를 같이 넘겨준ㄷ ㅏ 
//		integer로 하는 이유는  null값을 넣을 수 있기 때문에 /board/detail? 으로와도 빈페이지를 보여주기위해서 int는 null X  
		logger.info("URI:/board/detail");
		
		BoardVo board = null;
		
		if(num!=null) {
			board = BoardService.getBoard(num);
			mv.addObject("board", board);
			if(board !=null) {
				// 조회(클릭이)가 됐다는 의미
				BoardService.increaseVievws(num);
				board.setViews(board.getViews()+1);
				//해당 변수에 접근 할 때 Getter와 Setter

 				}
		}
		
		 mv.setViewName("/board/detail");
		 mv.addObject("cri", cri);
		return mv;
	}
	
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
//		integer로 하는 이유는  null값을 넣을 수 있기 때문에 /board/detail? 으로와도 빈페이지를 보여주기위해서 int는 null X  
		logger.info("URI:/board/register:GET");
		 mv.setViewName("/board/register");
		 
		 
		return mv;
	}
	
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, HttpServletRequest request , MultipartFile file2) throws Exception  {
//		integer로 하는 이유는  null값을 넣을 수 있기 때문에 /board/detail? 으로와도 빈페이지를 보여주기위해서 int는 null X  
		logger.info("URI:/board/register");
		 mv.setViewName("redirect:/board/list");
		 /*redirect : 링크를 다시 보내는것 */
		 /*boardvo board를 매개변수로주면 name과 동일한게 있으면 그걸 보낸다 */
		 /*-- 항상 뭔가 수정한걸 적용할 때는 새로고침을 필수 */
		 String fileName = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(),file2.getBytes());
		 board.setFile(fileName);
		 BoardService.registerBoard(board,request);		
		 
		return mv;
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	/* a 태그는 get 방식 수정버튼의 a 태그*/
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, HttpServletRequest request) {
//		integer로 하는 이유는  null값을 넣을 수 있기 때문에 /board/detail? 으로와도 빈페이지를 보여주기위해서 int는 null X  
		logger.info("URI:/board/modify:GET");
		 mv.setViewName("/board/modify");
		 logger.info("전송된 글번호 :"+num);
		 BoardVo board = null;
		 UserVo user = userService.getUser(request);
		 if(num !=null) {
			 board = BoardService.getBoard(num);
			 if(user == null || !board.getWriter().equals(user.getId()))
				 mv.setViewName("redirect:/board/list");
		 }
		 mv.addObject("board", board);
	
		 
		return mv;
	}
	
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	/* 수정하기는 post 이기에 */
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVo board,HttpServletRequest request) {
		logger.info("URI:/board/modify:POST");
		 mv.setViewName("redirect:/board/list");
		 /*post는 보통 redirect로 같이 온다. redirect : 이 작업이 끝나면 여기로 가긔 (setviewname 여기를 보여줘라)*/
		 /*modify.jsp의 name이 BoardVo의 멤버 변수랑 같아야한다. BoardVo의 이름이 중요 X 같은게 중요*/
		 UserVo user = userService.getUser(request);
		 BoardService.updateBoard(board,user);
		 /*새로운 게시판 정보를 알려줄테니까 업데이트를 해라 ~*/
		 
		return mv;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer num, HttpServletRequest request) {
		logger.info("URI:/board/delete:GET");
		 mv.setViewName("redirect:/board/list");
	
		 BoardService.deleteBoard(num, userService.getUser(request));
		 /*삭제하고싶은 글 번호를 줄테니 동일한 넘버의 db를 지워라..?*/
		 /*컨트롤러 ->서비스에 역할 분담 */
		 
		return mv;
	}
	
	
	@RequestMapping(value = "/board/like")
	@ResponseBody
	public Map<Object, Object> boardLike(@RequestBody String num, HttpServletRequest request){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    UserVo user = userService.getUser(request);
	    if(user == null ) {
	    	map.put("isUser", false);
	  	
	    }else {
	    	map.put("isUser", true);
	    	int like = BoardService.updateLike(num,user.getId());
	    	map.put("like", like);
	    	
	    }

	    return map;
	    //@RequestBody는 매개변수를 몇개를 건내주어도 하나만 인식한다 
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
	
	
	/* controller > service > serviceImp > dao > mapper 순으로 진행 ,, !  */
	/* */
	

	}
