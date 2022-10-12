package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:/D_Other/digda.jpg");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		long startTime = System.currentTimeMillis();
		try {
			fos = new FileOutputStream("d:/D_Other/복사본_digda3.jpg");
			bos = new BufferedOutputStream(fos, 5);

			for (char ch = '1'; ch <= '9'; ch++) {
				bos.write(ch);
			}
			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
				bos.flush();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
				bos.close();
				long endTime = System.currentTimeMillis();
				System.out.println("파일 복사 끝...");
				System.out.println("경과 시간 : " + (endTime - startTime));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}