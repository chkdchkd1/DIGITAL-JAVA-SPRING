package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(@Param("num")Integer num);

	void increaseViews(@Param("num")Integer num);

	void registerBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo board);

	void deleteBoard(@Param("num")Integer num);
	
	/*@Param은 매개변수가 2개 이상 올 때 꼭 붙여줘야한다.*/

}
