package test01;

public class Test01 {

	public static void main(String[] args) {
		
		// 문제1. String serial의 첫 번째 글자가 "1"이면 "남자", "2"이면 "여자"를 출력하시오
		
		// 예시
		// 1234567은 남자입니다.
		
		String serial ="3234567";
		if(serial.startsWith("1")) {
			System.out.println("남자");
		} else if (serial.startsWith("2")) {
			System.out.println("여자");
			
		}
		
		

	}

}
