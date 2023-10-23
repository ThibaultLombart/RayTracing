package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Vector;

public class DirectionalLight extends Light{
	
	private Vector vector;
	
	public DirectionalLight(Color color, Vector vector) {
		super(color);
		this.vector = vector;
	}

	public Vector getVector() {
		return vector;
	}
	
	public void setVector(Vector vector) {
		this.vector = vector;
	}

	public void setVector(double x, double y, double z) {
		this.vector = new Vector(new Triplet(x,y,z));
	}
	
}
