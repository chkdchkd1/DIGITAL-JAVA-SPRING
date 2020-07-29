package kr.green.practice.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.BoardDao;
import kr.green.practice.vo.BoardVo;
import kr.green.practice.pagination.Criteria;
import kr.green.practice.pagination.PageMaker;

@Service
public class BoardServicelmp implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getboardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVo getBoardDetail(Integer num) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardDetail(num);
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.insertBoard(board);
		
	}

	@Override
	public void getBoardUpdate(BoardVo board) {
		boardDao.updateBoard(board);
		
	}


	@Override
	public void getBoardDelete(Integer num) {
		BoardVo board = getBoardDetail(num);
		board.setIsDel('Y');
		board.setDelDate(new Date());
		boardDao.updateBoard(board);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		PageMaker pm = new PageMaker();
		int totalCount = boardDao.getTotalCount(cri);
		pm.setCriteria(cri);
		pm.setTotalCount(totalCount);
		// setTotalCount를 설정하면 바로 calcData()이 실행되기 때문에 그전에 cri를 넣어주어야한다 그래야 nullpointexception 발생 X
		
		return pm;
	}

}
