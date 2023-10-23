package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;

public abstract class Light {
	
	private Color color;
	
	
	public Light(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor(double r, double g, double b) {
		this.color = new Color(new Triplet(r,g,b));
	}
	
}
