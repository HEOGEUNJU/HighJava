package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class RSPgame {

	public static boolean inputCheck = false;

	public static void main(String[] args) {
		
		Thread th1 = new DataPut();
		th1.start();
		
		Thread th2 = new Count();
		th2.start();
		
	}
}

/**
 * 데이터 입력을 받는 스레드 클래스
 */
class DataPut extends Thread {
	@Override
	public void run() {

		String str = JOptionPane.showInputDialog("가위 바위 보");
		System.out.println("당신: " + str);
		
		Random random = new Random();
		String Ai[] = { "가위", "바위", "보"};
		int com = random.nextInt(3);
		String result = "";
		if(str.equals(Ai[com])) {
			result = "비김";
		}else if(str.equals("가위")&&Ai[com].equals("보")
				||str.equals("보")&&Ai[com].equals("바위")
				||str.equals("바위")&&Ai[com].equals("가위")) {
			result = "당신이 이겼습니다";
		}else {
			result = "당신이 패배했습니다.";
		}
		System.out.println("컴퓨터 : " + Ai[com]);
		System.out.println(result);
		
		RSPgame.inputCheck = true;

	}
}

class Count extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {

			if (RSPgame.inputCheck == true) {
				return;
			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 10초가 경과되었는데도 입력이 없으면 프로그램을 종료합니다.
		System.out.println("5초가 지났습니다. 게임에서 패배하셨습니다..");
		System.exit(0);// 프로그램 종료.
	}
}

