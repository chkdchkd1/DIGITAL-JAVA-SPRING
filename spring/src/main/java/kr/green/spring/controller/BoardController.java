package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.boardService;
import kr.green.spring.vo.BoardVo;

@Controller
public class BoardController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private boardService BoardService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
		logger.info("URI:/board/list");
		
		 mv.setViewName("/board/list");
		 ArrayList<BoardVo> list;
		 list = BoardService.getBoardList();
		 /*여기서 배열을 만드는게 아니라 데이터베이스가 만들어서 건네준걸 활용*/

		 mv.addObject("list",list);    
		 // mv를 리턴하면 전달받은 페이지 (*html, *jsp)에서 표현언어로 출력. 접근 가능 
		 // ex)mav.addobject("type","student") 에서 지정한 객체의 이름인 ${type} 를이용해서 값인 student를 가져올 수 있음
		 // 
		 
		 
		return mv;
	}
	
	
//	http://localhost:8080/spring/board/detail?num=1 페이지 구현 -> 일단 requestMapping을 만들고 jsp 추가 
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num) {
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
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board) {
//		integer로 하는 이유는  null값을 넣을 수 있기 때문에 /board/detail? 으로와도 빈페이지를 보여주기위해서 int는 null X  
		logger.info("URI:/board/register");
		 mv.setViewName("redirect:/board/list");
		 /*redirect : 링크를 다시 보내는것 */
		 /*boardvo board를 매개변수로주면 name과 동일한게 있으면 그걸 보낸다 */
		 /*-- 항상 뭔가 수정한걸 적용할 때는 새로고침을 필수 */
		 System.out.println(board);
		 BoardService.registerBoard(board);
		
		 
		return mv;
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	/* a 태그는 get 방식 수정버튼의 a 태그*/
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
//		integer로 하는 이유는  null값을 넣을 수 있기 때문에 /board/detail? 으로와도 빈페이지를 보여주기위해서 int는 null X  
		logger.info("URI:/board/modify:GET");
		 mv.setViewName("/board/modify");
		 
		 logger.info("전송된 글번호 :"+num);
		 BoardVo board = null;
		 if(num !=null) {
			 board = BoardService.getBoard(num);
		 }
		 mv.addObject("board", board);
	
		 
		return mv;
	}
	
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	/* 수정하기는 post 이기에 */
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVo board) {
		logger.info("URI:/board/modify:POST");
		 mv.setViewName("redirect:/board/list");
		 /*post는 보통 redirect로 같이 온다. redirect : 이 작업이 끝나면 여기로 가긔 */
		 /*modify.jsp의 name이 BoardVo의 멤버 변수랑 같아야한다. BoardVo의 이름이 중요 X 같은게 중요*/
		 BoardService.updateBoard(board);
		 /*새로운 게시판 정보를 알려줄테니까 업데이트를 해라 ~*/
		 
		return mv;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer num) {
		logger.info("URI:/board/delete:GET");
		 mv.setViewName("redirect:/board/list");
	
		 BoardService.deleteBoard(num);
		 /*삭제하고싶은 글 번호를 줄테니 동일한 넘버의 db를 지워라..?*/
		 /*컨트롤러 ->서비스에 역할 분담 */
		 
		return mv;
	}
	
	
	/* controller > service > serviceImp > dao > mapper 순으로 진행 ,, !  */
	/* */
	
	
 

}
