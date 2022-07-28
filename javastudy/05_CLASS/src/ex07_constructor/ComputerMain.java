package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer myCom = new Computer("gram", 1500);
		myCom.printComputerStatus();
		
		Computer yourCom = new Computer();
		yourCom.printComputerStatus();		
		
	}

}
