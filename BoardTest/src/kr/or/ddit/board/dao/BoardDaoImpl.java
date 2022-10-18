package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.dao.MybatisDao;

public class BoardDaoImpl extends MybatisDao implements IBoardDao{

	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getinstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		
		return boardDao;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		
		return insert("board.insertBoard", bv);
	}

	@Override
	public boolean checkBoard(String boardNo) {
		
		boolean isExist = false;
		
		int cnt = (int) selectOne("board.checkBoard", boardNo);
		
		if(cnt > 0) {
			isExist = true;
		}
		
		return isExist;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		return update("board.updateBoard", bv);
	}

	@Override
	public int deleteBoard(String boardId) {
		
		return delete("board.deleteBoard", boardId);
	}

	@Override
	public List<BoardVO> selectList() {
		// TODO Auto-generated method stub
		return selectList("board.selectAllBoard", null);
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		// TODO Auto-generated method stub
		return selectList("board.searchBoard", bv);
	}
}
