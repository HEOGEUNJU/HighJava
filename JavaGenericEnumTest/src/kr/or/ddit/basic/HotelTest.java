package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private Scanner scan;
	private Map<String, Hotel> HotelCheckIn;

	public HotelTest() {
		scan = new Scanner(System.in);
		HotelCheckIn = new HashMap<String, Hotel>();
	}

	public void checkInMenu() {
		System.out.println("*******************************************");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");

	}

	public void startMenu() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();

		while (true) {

			checkInMenu(); // 메뉴 출력

			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				checkIn(); // 체크인
				break;
			case 2:
				checkOut(); // 체크아웃
				break;
			case 3:
				roomCon(); // 객실상태
				break;
			case 4:
				System.out.println();
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}

	private void roomCon() {
		System.out.println();
		Set<String> keySet = HotelCheckIn.keySet();

		if (keySet.size() == 0) {
			System.out.println("등록된 정보가 없습니다.");
		} else {
			Iterator<String> it = keySet.iterator();

			while (it.hasNext()) {
				String roomNum = it.next();
				Hotel h = HotelCheckIn.get(roomNum);

				System.out.println("방번호 : " + h.getRoomNum() + ", 투숙객 : " + h.getName());
			}
		}
	}

	private void checkOut() {
		System.out.println();
		System.out.println("어느방에 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 =>");
		String roomNum = scan.next();

		if (HotelCheckIn.remove(roomNum) == null) {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
		} else {
			System.out.println("체크아웃 되었습니다.");
		}
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 =>");
		String roomNum = scan.next();

		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력=>");
		String name = scan.next();

		if (HotelCheckIn.get(roomNum) != null) {
			System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
			return;
		}

		Hotel h = new Hotel(roomNum, name);

		HotelCheckIn.put(roomNum, h);
		System.out.println("체크인 되었습니다.");
	}

	public static void main(String[] args) {
		new HotelTest().startMenu();

	}
}

/**
 * 체크인 정보를 저장하기 위한 VO 클래스
 */
class Hotel {
	private String roomNum;
	private String name;

	public Hotel(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((roomNum == null) ? 0 : roomNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roomNum == null) {
			if (other.roomNum != null)
				return false;
		} else if (!roomNum.equals(other.roomNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "hotel [roomNum=" + roomNum + ", name=" + name + "]";
	}

}