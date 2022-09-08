package parking;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ParkingLot {
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot(String name) {
		sc = new Scanner(System.in);
		cars = new Car[10];
		this.name = name;
		
	}
	
	public void addCar() {
		if(idx == cars.length) {
			throw new RuntimeException("더 이상 차량 등록이 불가능합니다.");
		}
		System.out.println("전체 등록된 차량" + (idx) + "대");
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		System.out.print("모델 >>> ");
		String model = sc.next();
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		System.out.println("차량번호" + carNo + "차량이 등록되었습니다.");
	}
	
	public void deleteCar() {
		if(idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		System.out.print("제거할 차량번호 >>> ");
		String carDel = sc.next();
		sc.nextLine();
		for(int i = 0; i < idx; i++) {
			if(carDel.equals(cars[i].getCarNo())) {
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호 " + carDel + "차량이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
	}
	
	public void printAllCars() {
		if(idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		System.out.println(name + " 차량 목록");
		for(int i = 0; i < idx; i++) {
			System.out.println(cars[i]);
		}
	}
	
	public void manage() {
		while(true) {
			try {
				System.out.print("1.추가 2.삭제 3.전체 0.종료 >>> ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1: addCar(); break;
				case 2: deleteCar(); break;
				case 3: printAllCars();break;
				case 0: System.out.println( name +"을 이용해주셔서 감사합니다.");
						return;
				default: System.out.println("존재하지 않는 메뉴입니다.");
				}
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("다시 눌러주십시오.");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
