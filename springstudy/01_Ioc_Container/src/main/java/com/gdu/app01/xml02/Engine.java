package com.gdu.app01.xml02;

public class Engine {
	
	// field
	private String fuel;       // 연료(디젤, 가솔린)
	private double efficency;  // 연비(12.3)
	private int cc;			   // 배기량(2000)
	
	// method(getter/setter)
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public double getEfficency() {
		return efficency;
	}
	public void setEfficency(double efficency) {
		this.efficency = efficency;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
}
