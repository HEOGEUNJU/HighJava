package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public int registBoard(BoardVO bv) {
		int cnt = boardDao.insertBoard(bv);

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
		List<BoardVO> boardList = boardDao.searchMember(bv);
		return boardList;
	}

}
