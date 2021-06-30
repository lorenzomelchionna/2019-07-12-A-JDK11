package it.polito.tdp.food.model;

public class Congiunta implements Comparable<Congiunta>{

	private Food f;
	private Double w;
	
	public Congiunta(Food f, double w) {
		super();
		this.f = f;
		this.w = w;
	}

	public Food getF() {
		return f;
	}

	public void setF(Food f) {
		this.f = f;
	}

	public Double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	@Override
	public int compareTo(Congiunta other) {
		// TODO Auto-generated method stub
		return other.w.compareTo(this.w);
	}

	@Override
	public String toString() {
		return "Congiunta: " + f + " - peso:" + w;
	}
	
}
