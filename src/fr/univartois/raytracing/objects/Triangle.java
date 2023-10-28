/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.objects;

import java.util.Arrays;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

/**
 * The Triangle class represents a triangle in a 3D scene.
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Triangle implements IObjectStage {

    /**
     * The vertices of the triangle.
     */
    private Point[] points;

    /**
     * The color of the triangle.
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
     * Constructs a Triangle with the specified vertices and color.
     *
     * @param points The vertices of the triangle (array of 3 points).
     * @param color  The color of the triangle.
     */
    public Triangle(Point[] points, Color color, Color specular, int shininess) {
        this.points = Arrays.copyOf(points, 3);
        this.color = color;
        this.specular = specular;
        this.shininess = shininess;
    }

    /**
     * Retrieves the vertices of the Triangle.
     *
     * @return The vertices of the triangle (array of 3 points).
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * Sets the vertices of the Triangle.
     *
     * @param points The new vertices of the triangle (array of 3 points).
     */
    public void setPoints(Point[] points) {
        this.points = Arrays.copyOf(points, 3);
    }

    /**
     * Sets the color of the Triangle.
     *
     * @param color The new color for the triangle.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the color attribute of this Triangle instance.
     *
     * @return The color attribute of this Triangle instance.
     */
    @Override
    public Color getColor() {
        return color;
    }
    
    /**
     * @return Vector N
     */
    public Vector getN(Point p) {
        Point a = points[0];
        Point b = points[1];
        Point c = points[2];
        
        return b.substraction(a).vectorProduct(c.substraction(a)).standardization();
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.objects.IObjectStage#calculT(fr.univartois.raytracing.digital.triples.Point, fr.univartois.raytracing.digital.triples.Vector)
     */
    @Override
    public double calculateT(Point lookFrom, Vector d) {
        Point a = points[0];
        Point b = points[1];
        Point c = points[2];
        
        Vector n = getN(new Point(
        		new Triplet(-1,-1,-1)));
        
        Plane plane = new Plane(a,n,new Color(new Triplet(0,0,0)));
        
        double tPlane = plane.calculateT(lookFrom, d);
        
        Point p = d.multiplication(tPlane).add(lookFrom);
        
        //System.out.println(tPlane);
        
        Vector verif1a = b.substraction(a);
        Vector verif1b = p.substraction(a);
        Vector verif1c = verif1a.vectorProduct(verif1b);
        double verif1 = verif1c.scalarProduct(n);
        
        Vector verif2a = c.substraction(b);
        Vector verif2b = p.substraction(b);
        Vector verif2c = verif2a.vectorProduct(verif2b);
        double verif2 = verif2c.scalarProduct(n);
        
        Vector verif3a = a.substraction(c);
        Vector verif3b = p.substraction(c);
        Vector verif3c = verif3a.vectorProduct(verif3b);
        double verif3 = verif3c.scalarProduct(n);
        
        if(verif1 >= 0 && verif2 >= 0 && verif3 >= 0) {
            return tPlane;
        } else {
            return -1;
        }

    
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
