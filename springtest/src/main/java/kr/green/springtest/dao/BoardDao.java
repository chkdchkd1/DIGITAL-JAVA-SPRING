package kr.green.springtest.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoardDetail(@Param("num")Integer num);

	void registerBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo board);

}
