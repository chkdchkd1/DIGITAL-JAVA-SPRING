package kr.green.practice.service;

import java.util.ArrayList;

import kr.green.practice.pagination.Criteria;
import kr.green.practice.pagination.PageMaker;
import kr.green.practice.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getboardList(Criteria cri);

	BoardVo getBoardDetail(Integer num);

	void registerBoard(BoardVo board);

	void getBoardUpdate(BoardVo board);

	void getBoardDelete(Integer num);

	PageMaker getPageMaker(Criteria cri);
	

}
