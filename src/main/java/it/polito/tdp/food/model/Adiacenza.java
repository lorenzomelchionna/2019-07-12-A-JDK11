package it.polito.tdp.food.model;

public class Adiacenza {

	private Food f1;
	private Food f2;
	private double w;
	
	public Adiacenza(Food f1, Food f2, double w) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.w = w;
	}

	public Food getF1() {
		return f1;
	}

	public void setF1(Food f1) {
		this.f1 = f1;
	}

	public Food getF2() {
		return f2;
	}

	public void setF2(Food f2) {
		this.f2 = f2;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}
	
}
