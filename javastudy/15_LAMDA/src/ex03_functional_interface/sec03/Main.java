package ex03_functional_interface.sec03;

public class Main {

	public static void main(String[] args) {

		MyInterface3 my = () -> 10;
		System.out.println(my.method());
		
		MyInterface3 me = () -> {
			
			int a = 20;
			return a;
		};
		System.out.println(me.method());
	}

}
