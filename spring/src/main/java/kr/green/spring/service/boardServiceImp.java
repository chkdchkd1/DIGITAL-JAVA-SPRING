package kr.green.spring.service;

import java.util.ArrayList;

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
}
