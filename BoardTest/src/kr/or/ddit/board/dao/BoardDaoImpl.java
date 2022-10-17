package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil3;

public class BoardDaoImpl implements IBoardDao{

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			
			conn = JDBCUtil3.getConnection();
			
			String sql = " INSERT INTO BOARD(BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) " + 
					" VALUES (board_seq.nextVal, ?, ? , sysdate, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardContent());			
			cnt = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public boolean checkBoard(String boardNo) {
		
		boolean exist = false;
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " select count(*) as cnt "
					+ " from board "
					+ " where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt>0) {
				exist = true;
			}
					
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return exist;
	}

	@Override
	public List<BoardVO> searchMember(BoardVO bv) {
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql ="select * from board where 1=1";
			if(bv.getBoardNo() != null
					&& !bv.getBoardNo().equals("")) {
				sql += " and board_no = ? ";
			}
			if(bv.getBoardTitle() != null
					&& !bv.getBoardTitle().equals("")) {
				sql += " and board_title like '%' || ? || '%' ";
			}
			if(bv.getBoardWriter() != null
					&& !bv.getBoardWriter().equals("")) {
				sql += " and board_writer like '%' || ? || '%' ";
			}
			if(bv.getBoardContent() != null
					&& !bv.getBoardContent().equals("")) {
				sql += " and board_content like '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			if(bv.getBoardNo() != null
					&& !bv.getBoardNo().equals("")) {
				pstmt.setString(index++, bv.getBoardNo());
			}
			if(bv.getBoardTitle() != null
					&& !bv.getBoardTitle().equals("")) {
				pstmt.setString(index++, bv.getBoardTitle());
			}
			if(bv.getBoardWriter() != null
					&& !bv.getBoardWriter().equals("")) {
				pstmt.setString(index++, bv.getBoardWriter());
			}
			if(bv.getBoardContent() != null
					&& !bv.getBoardContent().equals("")) {
				pstmt.setString(index++, bv.getBoardContent());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardVO bv2 = new BoardVO();
				bv2.setBoardNo(rs.getString("board_no"));
				bv2.setBoardTitle(rs.getString("board_title"));
				bv2.setBoardWriter(rs.getString("board_writer"));
				bv2.setBoardContent(rs.getString("board_content"));
				
				boardList.add(bv2);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " UPDATE BOARD " + 
					" SET BOARD_TITLE = ?, " + 
					"    BOARD_WRITER = ?, " + 
					"    BOARD_CONTENT = ? " + 
					" WHERE BOARD_NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardContent());
			pstmt.setString(4, bv.getBoardNo());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteBoard(String boardNo) {
		
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " delete from board where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * from board";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setBoardNo(rs.getString("board_no"));
				bv.setBoardTitle(rs.getString("board_title"));
				bv.setBoardWriter(rs.getString("board_writer"));
				bv.setBoardDate(rs.getDate("board_date"));
				bv.setBoardContent(rs.getString("board_content"));
				
				boardList.add(bv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return boardList;
	}

}
