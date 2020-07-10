package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVo;

public interface boardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(Integer num);

	void increaseVievws(Integer num);

	void registerBoard(BoardVo board);

	void updateBoard(BoardVo board);

	void deleteBoard(Integer num);

}
