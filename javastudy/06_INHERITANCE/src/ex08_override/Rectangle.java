package ex08_override;

public class Rectangle extends Shape{
	
	private int width;
	private int heigth;
	
	public Rectangle(String type, int width, int heigth) {
		super(type);
		this.width = width;
		this.heigth = heigth;
	}

	@Override
	public double getArea() {
		
		return width * heigth;
	}

	@Override
	public void info() {
		super.info();
		System.out.println("너비 : " + width + ", 높이 : " + heigth);
		System.out.println("넓이 : " + getArea());
	}
	
	
	
	
}
