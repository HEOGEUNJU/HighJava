package kr.or.ddit.basic;
@PrintAnnotation
public class Service {
	@PrintAnnotation
	public void method1() throws Exception {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	
	@PrintAnnotation("%") //value가 기본값이기 때문에 value하나만 값을 주어줄 때는 value = "?"가아니라 "?"만 입력해도 된다.
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value = "#", count = 25)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}
