package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDao;
import kr.green.springtest.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ArrayList<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo getBoardDetail(Integer num) {
		// TODO Auto-generated method stub
		return boardDao.getBoardDetail(num);
	}

	@Override
	public void increaseView(Integer num) {
		boardDao.increaseView(num);
		
	}

	

}