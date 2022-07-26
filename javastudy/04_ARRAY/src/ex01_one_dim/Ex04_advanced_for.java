package ex01_one_dim;

public class Ex04_advanced_for {

	public static void main(String[] args) {
		
		String[] friends = {"라이언", "프로도", "어피치"};
		
		// 일반 for문
		for(int i = 0; i < friends.length; i++) {
			System.out.println((i + 1) + "번째친구 - " + friends[i]);
		}
		
		// 향상 for문
		for(String friend : friends) { // frineds 배열의 모든 요소를 하니씩 String friends로 옮긴다.
			System.out.println(friend);
		}
	}

}
