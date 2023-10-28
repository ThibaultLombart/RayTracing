package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

public abstract class Light {
	/**
	 * Attribute color
	 */
	private Color color;
	
	/**
	 * constructor Light
	 * @param color Color
	 */
	public Light(Color color) {
		this.color = color;
	}
	/**
     * Get the color.
     *
     * @return Attribute color.
       
     */
	public Color getColor() {
		return color;
	}
	
	/**
     * Modify attribute color
     *
     * @param color new value color.
     */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
     * Modify attribute color
     *
     * @param r new value r.
     * @param g new value g.
     * @param b new value b.
     */
	public void setColor(double r, double g, double b) {
		this.color = new Color(new Triplet(r,g,b));
	}
	
	public LocalLight transformLocalLight() {
		if (this.getClass()==LocalLight.class) {
    		return (LocalLight) this;
		}
		return null;
	}

	public abstract Vector getLdir(Point p);
	
	
}
