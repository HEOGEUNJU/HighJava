import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			int i = scanner.nextInt();
			if (i >= 1 && i <= 9) {
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + "*" + j + " = " + i * j);
				}
				return;
			} else {
				System.out.println("다시 입력해주세요");
			}
		}
	}

}
