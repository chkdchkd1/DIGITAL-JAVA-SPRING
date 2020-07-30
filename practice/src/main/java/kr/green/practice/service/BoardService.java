package kr.green.practice.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.practice.pagination.Criteria;
import kr.green.practice.pagination.PageMaker;
import kr.green.practice.vo.BoardVo;
import kr.green.practice.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getboardList(Criteria cri);

	BoardVo getBoardDetail(Integer num);

	void registerBoard(BoardVo board, HttpServletRequest request);

	void getBoardUpdate(BoardVo board, HttpServletRequest request);

	void getBoardDelete(Integer num, UserVo userVo);

	PageMaker getPageMaker(Criteria cri);

	void getincreaseViews(Integer num);

	int updateLike(Integer num, String id);
	

}
