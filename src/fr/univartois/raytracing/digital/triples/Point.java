package fr.univartois.raytracing.digital.triples;

import fr.univartois.raytracing.Triplet;

public class Point {
	private Triplet triplet;
	
	public Point(Triplet triplet) {
		this.triplet = triplet;
	}

	public Triplet getTriplet() {
		return triplet;
	}

	public void setTriplet(Triplet triplet) {
		this.triplet = triplet;
	}
	
	public void substraction(Point otherPoint) {
		setTriplet(this.triplet.substraction(otherPoint.getTriplet()));
	}
	
	public void multiplication(Double d) {
		setTriplet(this.triplet.scalarMultiplication(d));
	}
	
}
