package kr.green.springtest.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.vo.BoardVo;
import kr.green.springtest.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoardDetail(Integer num);

	void registerBoard(BoardVo board,HttpServletRequest request);

	BoardVo view(Integer num);

	void deleteBoard(Integer num, UserVo userVo);

	void updateBoard(BoardVo board, UserVo user);

	PageMaker getPageMaker(Criteria cri);

	int updateUp(Integer num, String id);

}
