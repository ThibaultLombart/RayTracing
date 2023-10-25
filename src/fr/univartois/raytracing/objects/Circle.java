/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.objects;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

/**
 * Class Circle
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Circle implements IObjectStage {

    /**
     * Attribute point...
     */
    private Point point;

    /**
     * Attribute r...
     */
    private double r;

    /**
     * Attribute color...
     */
    private Color color;

    /**
     * Circle Constructor.
     * 
     * @param point point
     * @param r radius
     * @param color Color color
     */
    public Circle(Point point, double r, Color color) {
        super();
        this.point = point;
        this.r = r;
        this.color = color;
    }

    /**
     * Give color attribute
     *
     * @return Attribute color.
     */
    @Override
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
     * Give attribute point
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
     * Give attribute r.
     *
     * @return Attribute r
     */
    public double getR() {
        return r;
    }

    /**
     * Modify attribute r
     *
     * @param r new value r
     */
    public void setR(double r) {
        this.r = r;
    }

    /**
     * @param lookFrom lookFrom
     * @param d Vector D
     * @return T
     */
    public double calculT(Point lookFrom, Vector d) {
        Point o = lookFrom;
        Point cc = this.point;

        double b = ((o.substraction(cc)).multiplication(2)).scalarProduct(d) ;
        
        double c = ((o.substraction(cc)).scalarProduct(o.substraction(cc))) - (this.r*this.r);
        
        double delta = (b * b) - (4 * c);
        
        //System.out.println(delta);
        //System.out.println(a + "   " + b + "   " + c);


        if (delta < 0) {
            return -1;
        } else if (delta == 0) {
            double t = (-b) / 2;
            return t;
        } else {
            double t1 = (-b + Math.sqrt(delta)) / 2;
            double t2 = (-b - Math.sqrt(delta)) / 2;

            if (t2 > 0) {
                return t2;
            } else if (t1 > 0) {
                return t1;
            } else {
                return -1;
            }
        }
    }

}
