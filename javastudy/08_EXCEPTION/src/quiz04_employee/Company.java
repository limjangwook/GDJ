package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {
	
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
	}
	
	public void addEmployee() throws EmployeeException {
		if(idx == employees.length) {
			throw new EmployeeException("호황", 1);
		}
		System.out.print("1.노예 2.노비 >>> ");
		int kind = sc.nextInt();
		System.out.print("싱싱한 노예 번호 >>> ");
		int empNo = sc.nextInt();
		System.out.print("싱싱한 노예 이름 >>> ");
		String name = sc.next();
		switch(kind) {
			case 1: System.out.print("쌀 >>> ");
					int salary = sc.nextInt();
					employees[idx++] = new Regular(empNo, name, salary);
					break;
			case 2: System.out.print("감자 >>> ");
					double hourPay = sc.nextDouble();
					System.out.print("수확시간 >>> ");
					int workTimes = sc.nextInt();
					Temporary temporary = new Temporary(empNo, name);
					temporary.setHourPay(hourPay);
					temporary.setWorkTimes(workTimes);
					employees[idx++] = temporary;
					break;
			default: throw new EmployeeException("삐빅~! 잘못된 선택입니다.", 3);
			}
			System.out.println("노예 획득 완료. 현재 획득한 노예 " + idx + "명");
	}
	
	public void dropEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("인력난", 2);
		}
		System.out.print("해방시킬 노예 번호 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i + 1, employees, i, idx - 1 - i);
				employees[--idx] = null;
				System.out.println("노예 해방 완료. 현재 획득한 노예 " + idx + "명");
			}
		}
		throw new EmployeeException("획득하지 못한 노예 입니다!", 4);
	}
	
	public void findEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("인력난", 2);
		}
		System.out.print("확인할 노예번호 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.out.println("노예 확인 완료. 확인한 노예 정보");
				System.out.println(employees[i]);
				return;
			}
		}
		throw new EmployeeException("획득하지 못한 노예 입니다!", 4);
	}
	
	public void printAllEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("인력난", 2);
		}
		int total = 0;
		System.out.println("전체 노예 목록(" + idx + "명)");
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i] + "[녹봉 : " + employees[i].getPay() + "]");
			total += employees[i].getPay();
		}
		System.out.println("내 피같은 쌀 " + total);
	}
	
	public void manage() {
		while(true) {
			try {
				System.out.print("1.노예추가 2.노예해방 3.노예조회 4.노예목록 0.종료 >>> ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1: addEmployee(); break;
				case 2: dropEmployee(); break;
				case 3: findEmployee(); break;
				case 4: printAllEmployee(); break;
				case 0: return;
				default : throw new RuntimeException("삐빅~! 오류입니다.");
				}
			} catch(EmployeeException e) {
				System.out.println(e.getMessage() + "[" + e.getErrorCode() + "]");
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("잘 좀 입력하세요");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
