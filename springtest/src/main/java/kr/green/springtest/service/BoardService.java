package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoardDetail(Integer num);

	void registerBoard(BoardVo board);

	BoardVo view(Integer num);

}
