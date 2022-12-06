package ex03_functional_interface.sec01;

public class Main {

	public static void main(String[] args) {
		
		MyInterface1 my = () -> System.out.println("자고 싶다!!!");
		my.method();
		
		MyInterface1 me = () -> System.out.println("빨래해야해!!!");
		me.method();
		
	}

}
