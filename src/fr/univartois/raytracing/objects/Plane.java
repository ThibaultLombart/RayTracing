/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.objects;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

/**
 * The Plane class represents a 2D plane in a 3D scene.
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Plane implements IObjectStage {
    
    /**
     * The point on the plane.
     */
    private Point point;
    
    /**
     * The normal vector of the plane.
     */
    private Vector vector;

    /**
     * The color of the plane.
     */
    private Color color;
    
    /**
     * Attribute specular...
     */
    private Color specular;
    
    /**
     * Attribute shininess...
     */
    private int shininess;

    /**
     * Constructs a Plane with the specified point, normal vector, and color.
     *
     * @param point  The point on the plane.
     * @param vector The normal vector of the plane.
     * @param color  The color of the plane.
     */
    public Plane(Point point, Vector vector, Color color, Color specular, int shininess) {
        this.point = point;
        this.vector = vector;
        this.color = color;
        this.specular = specular;
        this.shininess = shininess;
    }

    /**
     * Retrieves the point attribute of the Plane.
     *
     * @return The point on the plane.
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Sets the point attribute of the Plane.
     *
     * @param point The new value for the point on the plane.
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * Retrieves the vector attribute of the Plane.
     *
     * @return The normal vector of the plane.
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Sets the vector attribute of the Plane.
     *
     * @param vector The new value for the normal vector of the plane.
     */
    public void setVector(Vector vector) {
        this.vector = vector;
    }

    /**
     * Gets the color attribute of this Plane instance.
     *
     * @return The color attribute of this Plane instance.
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color attribute of this Plane instance.
     *
     * @param color The new value of the color attribute for this Plane instance.
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.objects.IObjectStage#calculT(fr.univartois.raytracing.digital.triples.Point, fr.univartois.raytracing.digital.triples.Vector)
     */
    @Override
    public double calculateT(Point lookFrom, Vector d) {
        Vector n = this.vector;
        Point q = this.point;
        
        if(d.scalarProduct(n) == 0) {
            return -1;
        }
        
        return q.substraction(lookFrom).scalarProduct(n)/d.scalarProduct(n);
    }

    /**
     * @return Vector N
     */
    public Vector getN(Point p) {
        return vector;
    }

	@Override
	public Color getSpecular() {
		// TODO Auto-generated method stub
		return specular;
	}

	@Override
	public int getShininess() {
		// TODO Auto-generated method stub
		return shininess;
	}
    
    

}
