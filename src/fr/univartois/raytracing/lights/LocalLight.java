package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;

public class LocalLight extends Light{
	/**
	 * Attribute point
	 */
	private Point point;
	/**
	 * constructor LocalLight
	 * @param color Color
	 * @param point Point
	 */
	public LocalLight(Color color, Point point) {
		super(color);
		this.point = point;
	}
	/**
     * Get the point.
     *
     * @return Attribute point.
       
     */
	public Point getPoint() {
		return point;
	}
	
	/**
     * Modify attribute point
     *
     * @param point new value point.
     */
	public void setPoint(Point point) {
		this.point = point;
	}
	
	/**
     * Modify attribute point
     *
     * @param x new value x.
     * @param y new value y.
     * @param z new value z.
     */
	public void setPoint(double x, double y, double z) {
		this.point = new Point(new Triplet(x,y,z));
	}
	
}
