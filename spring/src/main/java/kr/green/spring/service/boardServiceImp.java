package kr.green.spring.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

@Service
public class boardServiceImp implements boardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoard(Integer num) {
		return boardDao.getBoard(num);
	}
	

	@Override
	public void increaseVievws(Integer num) {
		boardDao.increaseViews(num);
		
	}

	@Override
	public void registerBoard(BoardVo board, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo user = (UserVo)session.getAttribute("user");
		// 선택한 요소(element)의 특정 속성(attribute)의 값을 가져옵니다
		if( user == null ) return ;
		board.setWriter(user.getId());
		boardDao.registerBoard(board);
		
	}


	@Override
	public void deleteBoard(Integer num,UserVo userVo) {
		 if(num != null && userVo != null) {
			 BoardVo board = boardDao.getBoard(num);
			 if(board != null && board.getWriter().equals(userVo.getId())) {
				 board.setIsDel('Y');
				 board.setDelDate(new Date());
				 boardDao.updateBoard(board);
			 }
		 }
		// == 주소값 equals 내용 자바에서 문자열을 비교하려면 equals
	}

	@Override
	public void updateBoard(BoardVo board,UserVo user) {
			board.setWriter(user.getId()); 
			board.setIsDel('N');
			//수정할 때 setIsDel의 값을 주지 않기때문에 null이 들어간다. 그래서 N으로 넣어줘ㅑ야
			boardDao.updateBoard(board);
			/*dao한테 update~ 요청*/
		
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		PageMaker pm = new PageMaker();
		int totalCount = boardDao.getTotalCount(cri);
		pm.setCriteria(cri);
		pm.setTotalCount(totalCount);
		return pm;
	}


}
