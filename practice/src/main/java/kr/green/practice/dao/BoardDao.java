package kr.green.practice.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.practice.vo.BoardVo;
import kr.green.practice.pagination.Criteria;

public interface BoardDao {

	ArrayList<BoardVo> selectBoardList(@Param("cri")Criteria cri);

	BoardVo selectBoardDetail(@Param("num")Integer num);

	void insertBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo board);
	
	int getTotalCount(@Param("cri")Criteria cri);



}
