package kr.green.practice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.BoardDao;
import kr.green.practice.vo.BoardVo;

@Service
public class BoardServicelmp implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getboardList() {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList();
	}

}
