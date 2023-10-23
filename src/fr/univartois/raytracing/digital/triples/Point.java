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
	
	public Vector substraction(Point otherPoint) {
		return new Vector(this.triplet.substraction(otherPoint.getTriplet()));
	}
	
	public Point multiplication(Double d) {
		return new Point(this.triplet.scalarMultiplication(d));
	}
	
}
