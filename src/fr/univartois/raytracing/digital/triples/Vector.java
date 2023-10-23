package fr.univartois.raytracing.digital.triples;

import fr.univartois.raytracing.Triplet;

public class Vector {
	private Triplet triplet;
	
	public Vector(Triplet triplet) {
		this.triplet = triplet;
	}

	public Triplet getTriplet() {
		return triplet;
	}

	public void setTriplet(Triplet triplet) {
		this.triplet = triplet;
	}
	
	public void add(Vector otherVector) {
		setTriplet(this.triplet.addition(otherVector.getTriplet()));
	}
	
	public void substraction(Vector otherVector) {
		setTriplet(this.triplet.substraction(otherVector.getTriplet()));
	}
	
	
	public void multiplication(double d) {
		setTriplet(this.triplet.scalarMultiplication(d));
	}
	
	public double scalarProduct(Vector otherVector) {
		return this.triplet.scalarProduct(otherVector.getTriplet());
	}
	
	public void vectorProduct(Vector otherVector) {
		setTriplet(this.triplet.vectorialProduct(otherVector.getTriplet()));
	}
	
	public double length() {
		return this.triplet.length();
	}
	
	public void standardization() {
		setTriplet(this.triplet.standardization());
	}
}
