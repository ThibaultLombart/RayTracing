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
 * Class Plane
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Plane implements IObjectStage {
    
    /**
     * Attribute point...
     */
    private Point point;
    
    /**
     * Attribute vector...
     */
    private Vector vector;

    /**
     * Attribute color...
     */
    private Color color;

    /**
     * Plane Constructor.
     * @param point Point point
     * @param vector Vector vector
     * @param color Color color
     */
    public Plane(Point point, Vector vector, Color color) {
        this.point = point;
        this.vector = vector;
        this.color = color;
    }

    
    /**
     * Give point Attribute
     *
     * @return Attribute point
     */
    public Point getPoint() {
        return point;
    }


    /**
     * Modify attribute point
     *
     * @param point new value point
     */
    public void setPoint(Point point) {
        this.point = point;
    }
    
    /**
     * Give vector Attribute
     *
     * @return Attribute vector
     */
    public Vector getVector() {
        return vector;
    }


    
    /**
     * Modify attribute vector
     *
     * @param vector new value vector
     */
    public void setVector(Vector vector) {
        this.vector = vector;
    }


    /**
     * Donne l'attribut color de cette instance de Plane.
     *
     * @return L'attribut color de cette instance de Plane.
     */
    @Override
    public Color getColor() {
        return color;
    }


    
    /**
     * Modifie l'attribut color de cette instance de Plane.
     *
     * @param color La nouvelle valeur de l'attribut color pour cette instance de Plane.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    
    
    
    
}

