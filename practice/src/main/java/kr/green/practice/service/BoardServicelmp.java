package kr.green.practice.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.BoardDao;
import kr.green.practice.vo.BoardVo;
import kr.green.practice.vo.UserVo;
import kr.green.practice.pagination.Criteria;
import kr.green.practice.pagination.PageMaker;

@Service
public class BoardServicelmp implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private UserService userService;
	

	@Override
	public ArrayList<BoardVo> getboardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVo getBoardDetail(Integer num) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardDetail(num);
	}

	
	@Override
	public void getBoardUpdate(BoardVo board, HttpServletRequest request ) {
		UserVo user = userService.getUser(request);
		board.setIsDel('N');
		board.setWriter(user.getId());
		System.out.println(user.getId());
		//등록할 때는 값을 받지않아도 디폴트값인 N을 넣지만 수정할 때 setIsDel의 값을 주지 않기때문에 null이 들어간다. 그래서 N으로 넣어줘ㅑ야
		boardDao.updateBoard(board);
		
	}


	@Override
	public void getBoardDelete(Integer num, UserVo userVo) {
		if(num != null && userVo != null) {
			BoardVo board = getBoardDetail(num);
			if (board != null && board.getWriter().equals(userVo.getId())) {
				board.setIsDel('Y');
				board.setDelDate(new Date());
				boardDao.updateBoard(board);
			} 
		}
			
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		PageMaker pm = new PageMaker();
		int totalCount = boardDao.getTotalCount(cri);
		pm.setCriteria(cri);
		pm.setTotalCount(totalCount);
		// setTotalCount를 설정하면 바로 calcData()이 실행되기 때문에 그전에 cri를 넣어주어야한다 그래야 nullpointexception 발생 X
		
		return pm;
	}

	@Override
	public void registerBoard(BoardVo board, HttpServletRequest request) {
		
		UserVo user = (UserVo)request.getSession().getAttribute("user");
		if (user == null) return ;
		
			board.setWriter(user.getId());
			boardDao.insertBoard(board);		
	}

	@Override
	public void getincreaseViews(Integer num) {
		boardDao.updateViews(num);
		
	}

	@Override
	public int updateLike(Integer num, String id) {
		// 이회원이 이미 좋아요를 눌렀는지 check -> 이걸 할려면 해당 게시물 번호와  해당 게시물을 좋아요 누를 사람의 정보를 가진 별도의 테이블이 필요함 
		if( boardDao.selectLike(num,id) == 0 ) {
			// 좋아요를 안눌렀으면 좋아요 +1
			boardDao.insertLike(num,id);
		} else {
			// 이미 눌렀으면
			return -1;
		}
		// 좋아요 버튼 눌렀으니까 
		// 해당 게시물의 like 속성도 업데이트 ( 직접+1 X / 게시물번호와 누른사람 아이디를 가진 테이블에서 해당 게시물이 몇번 등록 됐는지 를 세어 그걸 board테이블 like 속성에 업데이트한다) 
		boardDao.updateBoardByUp(num);
		BoardVo board = boardDao.selectBoardDetail(num);
		// 해당 게시물의 like 속성 값 반환
		return board.getLike();
		
	
	}

}
