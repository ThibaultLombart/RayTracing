package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

public class DirectionalLight extends Light{
	/**
	 * Attribute vector
	 */
	private Vector vector;
	/**
	 * constructor Light
	 * @param color Color
	 * @param vector Vector
	 */
	public DirectionalLight(Color color, Vector vector) {
		super(color);
		this.vector = vector;
	}
	/**
     * Get the vector.
     *
     * @return Attribute vector.
       
     */
	public Vector getVector() {
		return vector;
	}
	/**
     * Modify attribute vector
     *
     * @param Vector new value vector.
     */
	public void setVector(Vector vector) {
		this.vector = vector;
	}
	/**
     * Modify attribute vector
     *
     * @param x new value x.
     * @param y new value y.
     * @param z new value z.
     */
	public void setVector(double x, double y, double z) {
		this.vector = new Vector(new Triplet(x,y,z));
	}
	
	/*
	 * Using the legacy method to get the color of the light
	 */
    public Color getColor() {
        return super.getColor();
    }
	
	
}
