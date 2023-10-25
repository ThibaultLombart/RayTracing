/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.objects;

import java.util.Arrays;

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
     * Constructs a Triangle with the specified vertices and color.
     *
     * @param points The vertices of the triangle (array of 3 points).
     * @param color  The color of the triangle.
     */
    public Triangle(Point[] points, Color color) {
        this.points = Arrays.copyOf(points, 3);
        this.color = color;
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
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.objects.IObjectStage#calculT(fr.univartois.raytracing.digital.triples.Point, fr.univartois.raytracing.digital.triples.Vector)
     */
    @Override
    public double calculT(Point lookFrom, Vector d) {
        Point a = points[0];
        Point b = points[1];
        Point c = points[2];
        
        Vector n = b.substraction(a).vectorProduct(c.substraction(a)).standardization();
    
        Point p = c;
        
        if(b.substraction(a).vectorProduct(p.substraction(a)).scalarProduct(n) < 0) {
            return -1;
        } else if (c.substraction(b).vectorProduct(p.substraction(b)).scalarProduct(n) < 0) {
            return -1;
        } else if (a.substraction(c).vectorProduct(p.substraction(c)).scalarProduct(n) < 0) {
            return -1;
        }
        
        return p.substraction(lookFrom).scalarProduct(n)/d.scalarProduct(n);

    
    }
}
