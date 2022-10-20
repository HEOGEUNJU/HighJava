 package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{
	
	private static BoardServiceImpl boardService;
	
	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = BoardDaoImpl.getinstance();
	}
	
//	public static IBoardService getInstance() {
//		if(boardService == null) {
//			boardService = new BoardServiceImpl();
//		}
//		return boardService;
//	}
	
	@Override
	public int registBoard(BoardVO bv) {
		
		int cnt = boardDao.insertBoard(bv);

		if (cnt > 0) {
			
		}
		return cnt;
	}

	@Override
	public boolean checkBoard(String boardNo) {
		
		boolean exist = boardDao.checkBoard(boardNo);
		
		return exist;
	}

	@Override
	public int modifyBoard(BoardVO bv) {
		
		int cnt = boardDao.updateBoard(bv);
		
		return cnt;
	}

	@Override
	public int romoveBoard(String boardNo) {
		
		int cnt = boardDao.deleteBoard(boardNo);
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectList() {
		
		List<BoardVO> boardList = boardDao.selectList();
		
		return boardList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> boardList = boardDao.searchBoard(bv);
		
		return boardList;
	}

}
