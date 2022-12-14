package kr.or.ddit.basic;

public class T09ThreadDaemonTest {
	public static void main(String[] args) {
		
		AutoSaveThread autoSave = new AutoSaveThread();
		
		// 데몬스레드로 설정하기(start() 호출 전에 설정한다.)
		autoSave.setDaemon(true);
		autoSave.start();
		
		try {
			for(int i=1; i<=20; i++) {
				System.out.println("작업" + i);
				
				Thread.sleep(1000);
				
			}
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("메인 스레드 종료...");
//		System.exit(0);
	}
}

/**
 * 자동 저장 기능 제공하는 스레드(3초에 한번씩 저장하기)
 */
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장합니다...");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			save(); // 자동저장 기능 호출
		}

	}

}
