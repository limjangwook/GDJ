package prac1;

import java.util.Scanner;

public class Prac1_01 {

	public static void q1() {
		
		// 1. 점수와 학년을 입력받아 60점 이상이면 합격, 60점 미만이면 불합격을 출력하시오.
		// 4학년인 경우 70점 이상이어야 합격이다.
		// 예시
		// 점수를 입력하세요(0~100) >>> 65
		// 학년을 입력하세요(1~4) >>> 1
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요(0~100) >>> ");
		int score = sc.nextInt();
		
		System.out.print("학년을 입력하세요 >>> ");
		int year = sc.nextInt();
		
		if(score >= 60) {
			if (year != 4)
				System.out.println("합격");
			else if (score >= 70)
				System.out.println("합격");
			else
				System.out.println("불합격");
		} else {
			System.out.println("불합격");
		}
		
		sc.close();
		
	}
	
	public static void q2() {
		
		// 2. 커피 메뉴를 입력받아 가격을 알려주는 프로그램을 구현하시오. switch 문을 이용
		// 하여 구현하시요
		// (에스프레소, 카푸치노, 카페라떼는 3500원, 아메리카노는 2000원이다.)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("무슨 커피 드릴까요? >>> ");
		String order = sc.next();
		String price;
		
		switch(order) {
		case "에스프레소" : 
		case "카푸치노" :
		case "카페라떼" : price = "3500원" ; break;
		case "아메리카노" : price = "2500원" ; break;
		default : price = "없는 메뉴";
		}
		System.out.println(order + "는 " + price + "입니다.");
		sc.close();
	}
	
	public static void q3() {
		
		// 3. 돈을 입력받아 오만원궝, 만원권, 오천원권, 천원권, 오백원 동전, 백원 동전,
		// 오십원 동전, 십원 동전, 오원 동전, 일원 동전이 각각 몇 개로 변환되는지 출력하시오.
		// 이 때 반드시 다음과 같은 배열을 사용하여 반복문으로 처리하시오.
		// int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		int[] count = new int[unit.length];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력하시오 >>> ");
		int money = sc.nextInt();
		
		for(int i= 0; i < unit.length; i++) {
			count[i] = money / unit[i];
			money = money % unit[i];
			System.out.println(unit[i] + "원 " + count[i] + "개");
		}
		
		sc.close();
	}
	
	
	public static void q4() {	
		
		// 4. 정수를 몇 개 저장할지(최대 100개) 입력받아서 해달 길이를 가진 배열을 생성하고,
		// 이곳에 1에서 100사이 범위의 정수를 랜덤하게 삽입하시오. 같은 값은 생성하지 
		// 못하도록 설정하고 생성된 배열을 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 개 생성할까요? ");
		int count = sc.nextInt();
		
		if(count < 1 || count > 100) {
			System.out.println("1~100 사이만 가능합니다.");
			return;
		}
		
		int[] arr = new int[count];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			if(exists(arr, i, random)) {
				i--;
				continue;
			}
			arr[i] = random;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 10 ==0)
				System.out.println();
			System.out.println(arr[i] + "\t");
		}
		
		
	} 
	
	public static boolean exists(int[] arr, int idx, int random) {
		
		for(int i = 0; i <= idx; i++)
			if(arr[i] == random)
				return true;
		
		return false;
		
	}
	
	public static void q6() {
		
		String[] yut = {
				"", "도", "개", "걸", "윷", "모"
				
		};
		
		int total = 0;
		
		while(true) {
			
			int move = (int)(Math.random() * 5) +1;
			
			total += move;
			
			if(move <= 3) {
				System.out.println(yut[move] + "," + total + "칸 움직임");
				break;
			} else {
				System.out.println(yut[move] + ", ");
			}
		}
	}
	
	public static void q7() {
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		Player p1 = new Player("강아지");
		Player p2 = new Player("고양이");
		
		double res1 = p1.turn();
		double res2 = p2.turn();
		
		if(Math.abs(res1 - 10) < Math.abs(res2 - 10)) {
			System.out.println(p1.getName() + "님 승리." + res1 + "초 소요.");
		} else {
			System.out.println(p2.getName() + "님 승리." + res2 + "초 소요.");
		}
		sc.close();
		
	}
	
	public static void q8() {
		
		Watch watch = new Watch(16, 15, 30);
		
		watch.addHour(2);
		watch.addMinute(2);
		watch.addSecond(2);
		
		watch.see();
		
	}
	
	public static void q9() {
		
		BankAccount me = new BankAccount("1234", 10000);
		BankAccount mom = new BankAccount("4321", 100000);
		
		me.deposit(10000);
		me.deposit(-100);
		
		me.withdraw(5000);
		me.withdraw(100);
		
		me.inquiry();
		
		mom.transfer(me, 5000);
		mom.transfer(me, -100);
		mom.transfer(me, 100000000);
		
		mom.inquiry();
		me.inquiry();
		
	}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static void main(String[] args) {
			System.out.println("=====문제1=====");
			//q1();
			System.out.println("=====문제2=====");
			//q2();
			System.out.println("=====문제3=====");
			//q3();
			System.out.println("=====문제4=====");
			//q4();
			System.out.println("=====문제5=====");
			//q5();
			System.out.println("=====문제6=====");
			//q6();
			System.out.println("=====문제7=====");
			//q7();
			System.out.println("=====문제8=====");
			//q8();
			System.out.println("=====문제9=====");
			q9();
			System.out.println("=====문제10=====");
			//q10();

	}

}
