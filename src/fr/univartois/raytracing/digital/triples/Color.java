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
	
	public Color add(Color otherColor) {
		return new Color(this.triplet.addition(otherColor.getTriplet()));
	}
	
	public Color multiplication(Double d) {
		return new Color(this.triplet.scalarMultiplication(d));
	}
	
	public Color schur(Color otherColor) {
		return new Color(this.triplet.schurProduct(otherColor.getTriplet()));
	}
}
