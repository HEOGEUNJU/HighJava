package kr.or.ddit.board;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardMain {

	private IBoardService boardService;
	private Scanner scan = new Scanner(System.in); 
	
	public BoardMain() {
		boardService = new BoardServiceImpl();
	}
	
	/**
	 * 메뉴 출력
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("=====================");
		System.out.println("  === 목 록 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 종료");
		System.out.println("=====================");
		System.out.print("원하는 작업의 번호 >> ");
	}
	
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice) {
			case 1: // 전체 목록 출력
				selectList();
				break;
			case 2: // 새글 작성
				insertBoard();
				break;
			case 3: // 글 수정
				updateBoard();
				break;
			case 4: // 글 삭제
				deleteBoard();
				break;
			case 5: // 글 검색
				searchBoard();
				break;
			case 6: // 종료
				System.out.println("작업을 끝마칩니다.");
				break;
			default :
				System.out.println("번호를 잘못 입력하였습니다. 다시입력하세요.");
			}
		} while(choice!=6);
		
	}
	
	/**
	 * 게시글을 검색하기 위한 메서드
	 */
	private void searchBoard() {
		
		scan.nextLine(); // 버퍼에 비우기
		System.out.println();
		System.out.println("검색할 게시글의 정보를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		
		String boardNo = scan.nextLine().trim();
		
		System.out.print("게시글 제목 >> ");
		String boardTitle = scan.nextLine().trim();
		
		System.out.print("작성자 >> ");
		String boardWriter = scan.nextLine().trim();
		
		System.out.print("내용 >> ");
		String boardContent = scan.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println(" 번 호\t제 목\t작성자\t내용");
		System.out.println("----------------------------------");
		
		List<BoardVO> boardList = boardService.searchBoard(bv);
		
		if(boardList.size()==0) {
			System.out.println("게시글 정보가 존재하지 않습니다.");
		}else {
			
			for(BoardVO bv2 : boardList) {
				System.out.println(bv2.getBoardNo() + "\t"
						+bv2.getBoardTitle() +"\t"
						+bv2.getBoardWriter() +"\t"
						+bv2.getBoardContent());
			}
		}
		
		System.out.println("----------------------------------");
		System.out.println("검색 작업 끝.");
	}
	
	/**
	 * 게시글을 삭제하기 위한 메서드
	 */
	private void deleteBoard() {
		
		System.out.println();
		System.out.println("삭제할 게시글 번호를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		
		String boardNo = scan.next();
		
		int cnt = boardService.romoveBoard(boardNo);
		
		if(cnt>0) {
			System.out.println(boardNo + "번 게시글 삭제 성공.");
		} else {
			System.out.println(boardNo + "번 게시글 삭제 실패!!");
		}
		
	}

	/**
	 * 글 수정하는 메서드
	 */
	private void updateBoard() {
		
		boolean exist =false;
		String boardNo = "";
	
		do {
			System.out.println();
			System.out.println("수정할 게시글 번호를 입력하세요.");
			System.out.print("게시글 번호 >> ");
		
			boardNo = scan.next();
		
			exist = boardService.checkBoard(boardNo);
			
			if(!exist) {
				System.out.println("게시글 번호가" + boardNo + " 인 게시글은 존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}
		} while(!exist);
		
		scan.nextLine();
		System.out.print("제목>> ");
		String boardTitle = scan.nextLine();
		
		System.out.print("작성자>> ");
		String boardWriter = scan.next();
		
		scan.nextLine();
		
		System.out.print("내용>> ");
		String boardContent = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boardService.modifyBoard(bv);
		
		if(cnt>0) {
			System.out.println(boardTitle + " 게시글 수정 성공.");
		} else {
			System.out.println(boardTitle + " 게시글 수정 실패!!");
		}
	
	}	

	/**
	 * 새 글을 작성하는 메서드
	 */
	private void insertBoard() {
		
		scan.nextLine();
		System.out.print("제목>> ");
		String boardTitle = scan.nextLine();
		
		System.out.print("작성자>> ");
		String boardWriter = scan.next();
		
		scan.nextLine();
		
		System.out.print("내용>> ");
		String boardContent = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boardService.registBoard(bv);
		
			if(cnt > 0) {
				System.out.println(boardTitle + " 게시글 작성 성공.");
			} else {
				System.out.println(boardTitle + " 게시글 작성 실패!!!");
			}
	}
	
	/**
	 * 전체 게시글 출력 메서드
	 */
	private void selectList() {
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println(" 번 호\t제 목\t작성자\t작성날짜\t\t내 용");
		System.out.println("-------------------------------------------------");
		
		List<BoardVO> boardList = boardService.selectList();
		
		if(boardList.size()==0) {
			System.out.println("게시글정보가 존재하지 않습니다.");
		} else {
			for (BoardVO bv : boardList) {
				System.out.println(bv.getBoardNo() +"\t"
						+ bv.getBoardTitle()+"\t"
						+ bv.getBoardWriter()+"\t"
						+ bv.getBoardDate()+"\t"
						+ bv.getBoardContent());
			}
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("출력 작업 끝.");
			
	}
	
	public static void main(String[] args) {
		new BoardMain().start();

	}
}


















