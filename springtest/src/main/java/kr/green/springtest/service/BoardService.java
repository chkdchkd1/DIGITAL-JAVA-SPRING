package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoardDetail(Integer num);

	void registerBoard(BoardVo board);

	BoardVo view(Integer num);

	void deleteBoard(Integer num);

	void updateBoard(BoardVo board);

	PageMaker getPageMaker(Criteria cri);

}
