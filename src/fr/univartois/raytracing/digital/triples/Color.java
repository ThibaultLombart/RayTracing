package fr.univartois.raytracing.digital.triples;

import fr.univartois.raytracing.Triplet;

public class Color {
	private Triplet triplet;
	
	public Color(Triplet triplet) {
		this.triplet = triplet;
	}

	public Triplet getTriplet() {
		return triplet;
	}

	public void setTriplet(Triplet triplet) {
		this.triplet = triplet;
	}
	
	public void add(Color otherColor) {
		setTriplet(this.triplet.addition(otherColor.getTriplet()));
	}
	
	public void multiplication(Double d) {
		setTriplet(this.triplet.scalarMultiplication(d));
	}
	
	public void schur(Color otherColor) {
		setTriplet(this.triplet.schurProduct(otherColor.getTriplet()));
	}
}
