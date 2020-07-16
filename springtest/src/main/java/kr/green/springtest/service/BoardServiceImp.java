package kr.green.springtest.service;

import java.util.Date;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDao;
import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoardDetail(Integer num) {
		if(num == null) 
			return null;
		return boardDao.getBoardDetail(num);
	}

	

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.registerBoard(board);
		
	}

	@Override
	public BoardVo view(Integer num) {
		BoardVo board = getBoardDetail(num);
		if(board != null) {
			board.setViews(board.getViews()+1);
			boardDao.updateBoard(board);
		}
		return board;
	}

	@Override
	public void deleteBoard(Integer num) {
		BoardVo board = boardDao.getBoardDetail(num);
		if(board == null)
				return;
		board.setIsDel('Y');
		board.setDelDate(new Date());
		boardDao.updateBoard(board);;
		
	}

		@Override
		public void updateBoard(BoardVo board) {
			board.setIsDel('N');
			boardDao.updateBoard(board);
		
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
