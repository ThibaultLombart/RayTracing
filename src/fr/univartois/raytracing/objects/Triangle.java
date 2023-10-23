/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.objects;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;

/**
 * Class Triangle
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Triangle implements IObjectStage {

    /**
     * Attribute point...
     */
    private Point point;
    
    /**
     * Attribute color...
     */
    private Color color;

    /**
     * Triangle Constructor.
     * @param point Point point
     * @param color Color color
     */
    public Triangle(Point point, Color color) {
        super();
        this.point = point;
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
     * Modify attribute color
     *
     * @param color new value color
     */
    public void setColor(Color color) {
        this.color = color;
    }



    /*
     * (non-Javadoc)
     * 
     * @see fr.univartois.raytracing.objects.IObjectStage#getColor()
     */
    @Override
    public Color getColor() {
        // TODO Auto-generated method stub.
        return color;
    }
    
    
    
}

