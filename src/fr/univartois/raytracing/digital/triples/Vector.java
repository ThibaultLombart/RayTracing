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
	
	public Vector add(Vector otherVector) {
		return new Vector(this.triplet.addition(otherVector.getTriplet()));
	}
	
	public Point add(Point otherPoint) {
		return new Point(this.triplet.addition(otherPoint.getTriplet()));
	}
	
	public Vector substraction(Vector otherVector) {
		return new Vector(this.triplet.substraction(otherVector.getTriplet()));
	}
	
	
	public Vector multiplication(double d) {
		return new Vector(this.triplet.scalarMultiplication(d));
	}
	
	public double scalarProduct(Vector otherVector) {
		return this.triplet.scalarProduct(otherVector.getTriplet());
	}
	
	public Vector vectorProduct(Vector otherVector) {
		return new Vector(this.triplet.vectorialProduct(otherVector.getTriplet()));
	}
	
	public double length() {
		return this.triplet.length();
	}
	
	public Vector standardization() {
		return new Vector(this.triplet.standardization());
	}
	
	@Override
    public String toString() {
        // TODO Auto-generated method stub.
        return this.triplet.toString();
    }
}
