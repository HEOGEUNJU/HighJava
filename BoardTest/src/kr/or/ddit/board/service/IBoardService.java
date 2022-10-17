package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {

	/**
	 * 게시글 등록을 위한 메서드
	 * @param bv 등록할 데이터가 저장된 BoardVO객체
	 * @return 게시글 등록이 성공하면 1 이상의 값이 반환됨.
	 */
	public int registBoard(BoardVO bv);
	
	/**
	 * 주어진 게시글번호가 존재하는지 알아내기 위한 메서드
	 * @param boardNo 확인대상 게시글번호
	 * @return 해당 게시글 번호가 있으면 true, 없으면 false
	 */
	public boolean checkBoard(String boardNo);
	
	/**
	 * 게시글을 수정하기 위한 메서드
	 * @param bv update할 게시글 정보가 들어있는 BoardVO객체
	 * @return 작업성공 :1, 작업실패: 0
	 */
	public int modifyBoard(BoardVO bv);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 삭제하는 메서드
	 * @param BoardNo 삭제할 게시글 번호
	 * @return 작업성공: 1 , 작업실패: 0
	 */
	public int romoveBoard(String BoardNo);
	
	/**
	 * 전체 게시글정보를 조회하기 위한 메서드
	 * @return 회원정보를 담고있는 List타입의 객체
	 */
	public List<BoardVO> selectList();
	
	/**
	 * BoardVO에 담긴 데이터를 이용하여 게시글정보를 검색하는 메서드
	 * @param bv 게시글정보를 검색하기 위한 데이터
	 * @return 검색된 결과를 담고 있는 List타입의 객체
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
}
