package ex10_this;

public class Rectangle {
	
	// 필드
	private int width;
	private int heigth;
	
	// 생성자
	public Rectangle(int width, int heigth) {
		this.width = width;
		this.heigth = heigth;
	}
	
	public Rectangle(int n) {
		this(n, n);  // 인수  2개인 다른 생성자를 호출한
	}
	
	// 메소드
	public int getArea() {
		return width * heigth;
	}
	public int getCircimference() {
		return 2 * (width + heigth);
	}

}
