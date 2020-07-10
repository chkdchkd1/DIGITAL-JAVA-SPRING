package kr.green.spring.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.vo.BoardVo;

@Service
public class boardServiceImp implements boardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo getBoard(Integer num) {
		// TODO Auto-generated method stub
		return boardDao.getBoard(num);
	}

	@Override
	public void increaseVievws(Integer num) {
		boardDao.increaseViews(num);
		
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.registerBoard(board);
		
	}

	@Override
	public void updateBoard(BoardVo board) {
		board.setIsDel('N');
		//수정할 때 setIsDel의 값을 주지 않기때문에 null이 들어간다. 그래서 N으로 넣어줘ㅑ야
		boardDao.updateBoard(board);
		/*dao한테 update~ 요청*/
		
	}

	@Override
	public void deleteBoard(Integer num) {
		 if(num != null) {
			 BoardVo board = boardDao.getBoard(num);
			 if(board != null) {
				 board.setIsDel('Y');
				 board.setDelDate(new Date());
				 boardDao.updateBoard(board);
			 }
		 }
		
	}
}
