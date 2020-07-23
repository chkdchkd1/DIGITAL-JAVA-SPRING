package kr.green.springtest.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDao;
import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.vo.BoardVo;
import kr.green.springtest.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoardDetail(Integer num) {
		if(num == null) 
			return null;
		return boardDao.getBoardDetail(num);
	}

	

	@Override
	public void registerBoard(BoardVo board, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo user = (UserVo)session.getAttribute("user");
		if(user == null ) return ; 
		board.setwriter(user.getId());
		boardDao.registerBoard(board);
		
	}

	@Override
	public BoardVo view(Integer num) {
		BoardVo board = getBoardDetail(num);
		if(board != null) {
			board.setViews(board.getViews()+1);
			boardDao.updateBoard(board);
		}
		return board;
	}

	@Override
	public void deleteBoard(Integer num, UserVo user) {
		if(num != null && user != null) {
			BoardVo board = boardDao.getBoardDetail(num);
				if(board == null || !user.getId().equals(board.getwriter())) return;
			board.setIsDel('Y');
			board.setDelDate(new Date());
			boardDao.updateBoard(board);;
		}
	}

		@Override
		public void updateBoard(BoardVo board, UserVo user) {
		
			board.setwriter(user.getId());
			board.setIsDel('N');
			boardDao.updateBoard(board);
		
	}

		@Override
		public PageMaker getPageMaker(Criteria cri) {
			PageMaker pm = new PageMaker();
			int totalCount = boardDao.getTotalCount(cri);
			pm.setCriteria(cri);
			pm.setTotalCount(totalCount);
			
			return pm;
		}

		@Override
		public int updateUp(Integer num, String id) {
			//일단 내가 이글을 추천 버튼 누른적이 있는지 조회 (DB UP table) 
			if( boardDao.selectUp(num,id) == 0) {
				// 누른적 이없으면 DB Up table에 추가한다.
				boardDao.insertUp(num,id);
				//Dao의 메서드명은 select 나 insert 처럼 쿼리문 기능과 관련된 이름이랑 지으면 좋다  
			}else { 
				return -1;
			}
			// board 테이블 up 속성도 업데이트 해준다. 
			// 업데이트할때 board.up이 새로 카운트 되기 때문에 게시글정보를 가져와서 다시 업데이트한다. 그래고 업데이트한걸 다시 가져와서 거기서 getUp을 한다 (그래야 바로 추천수 올라간게 보임) (방법1)

//			BoardVo board = boardDao.getBoardDetail(num);
//			boardDao.updateBoard(board);
//			board = boardDao.getBoardDetail(num);
			
			
			// 또는 게시글의 추천수만 업데이트 (방법 2)
			boardDao.updateBoardByUp(num);
			BoardVo board = boardDao.getBoardDetail(num);
			return board.getUp();
		}

		
	

}
