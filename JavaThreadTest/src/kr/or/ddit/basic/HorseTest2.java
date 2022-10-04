package kr.or.ddit.basic;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	
	public class HorseTest2 extends Thread {

		static int currRank = 1;

		public static void main(String[] args) {
			// 말 10마리 만들기
			List<Horse> race = new ArrayList<Horse>();
			for (int i = 1; i <= 10; i++) {
				race.add(new Horse(i));
			}

			// 데몬 스레드 설정 후 익명 자식 객체를 만들어 Thread의 run()을 Override
			Thread daemon = new Thread() {
				@Override
				public void run() {
					// 트랙이 50개라 일단 50초로 설정해서 돌려보기
					for (int i = 0; i < 50; i++) {
						System.out.println("**************" + (i+1) + "초 **************");
						// 위에서 만든 말 객체 10개가 가진 각각의 '1초마다의 진행된 구간' 가져오기
						for (int j = 0; j < 10; j++) {
							System.out.print(j + 1 + "번 말\t");
							print((race.get(j)));
						}
						// 1초씩 텀 주기
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				// Horse 클래스로 만들어진 horse 객체의 track 배열을 출력하는 메서드
				public void print(Horse horse) {
					for (String str : horse.track) {
						System.out.print(str);
					}
					System.out.println();
				}

			};
			// 데몬 스레드 시작(1초가 지나고부터 나옴)
			daemon.setDaemon(true);
			daemon.start();

			// Horse의 run을 스레드로 실행
			for (Thread th : race) {
				th.start();
			}
			// Race의 메인 메서드가 끝나지 않게끔 만들기
			for (Thread th : race) {
				try {
					th.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Collections.sort(race);
			System.out.println("******************************************");
			System.out.println("경기 끝...");
			System.out.println("-----------------------");
			System.out.println("경기 결과");
			System.out.println();
			System.out.println("=======================");
			System.out.println("순위\t:\t이름");
			System.out.println("-----------------------");
			for (Horse horse : race) {
				System.out.println(horse.getRank() + "\t:\t" + horse.getNum() + "번 말");
			}
		}
	}

	/**
	 * Horse 클래스
	 */

	class Horse extends Thread implements Comparable<Horse> {
		private int num = 0;
		private int rank = 1;
		String[] track = new String[50];
//		List<String> track = new ArrayList<String>();

		public Horse() {

		}

		public Horse(int num) {
			super();
			this.num = num;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				track[i] = "-";
			}

			for (int i = 0; i < 50; i++) {
				track[i] = ">";
				try {
					track[i - 1] = "-";
				} catch (ArrayIndexOutOfBoundsException e) {
					track[i] = ">";
				}

				try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			setRank(HorseTest2.currRank++);
		}

		public static void print(String[] track) {
			for (String str : track) {
				System.out.print(str);
			}
			System.out.println();
		}

		@Override
		public int compareTo(Horse horse) {
			return new Integer(this.getRank()).compareTo(horse.getRank());
		}
	}

