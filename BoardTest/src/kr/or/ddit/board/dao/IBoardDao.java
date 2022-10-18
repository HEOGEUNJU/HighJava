package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행후 결과를 작성하여 서비스에 전달하는
 * DAO의 Interface.
 *
 */
public interface IBoardDao {

	/**
	 * BoardVO에 담겨진 데이터를 DB에 insert하는 메서드
	 * @param bv DB에 insert할 데이터가 저장된 BoardVO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환됨.
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 주어진 게시글번호가 존재하는지 여부를 알아내기 위한 메서드
	 * @param boardNo 확인대상 회원ID
	 * @return 해당 회원ID가 있으면 true, 없으면 false
	 */
	public boolean checkBoard(String boardNo);
	
	/**
	 * 하나의 BoardVO객체를 이용하여 DB정보를 update하는 메서드
	 * @param bv update할 회원정보가 들어있는 BoardVO객체
	 * @return 작업성공 : 1, 작업실패: 0
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 게시글번호를 매개변수로 받아서 해당 게시글 정보를 삭제하는 메서드
	 * @param boardNo 삭제할 회원ID
	 * @return 작업성공: 1 , 작업실패: 0
	 */
	public int deleteBoard(String boardNo);
	
	/**
	 * DB에 테이블에 존재하는 전체 게시글정보를 조회하기 위한 메서드
	 * @return 게시글정보를 담고있는 List타입의 객체
	 */
	public List<BoardVO> selectList();
	
	/**
	 * MemberVO에 담긴 데이터를 이용하여 게시글정보를 검색하는 메서드
	 * @param bv 게시글정보를 검색하기 위한 데이터
	 * @return 검색된 결과를 담고 있는 List타입의 객체
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
}
