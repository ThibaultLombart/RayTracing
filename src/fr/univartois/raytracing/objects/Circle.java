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
    
    public double calculT(Scene scene,Vector d) {
        double a = 1;
        Point o = scene.getLookFrom();
        Point cc = point;
        
        Vector bVector = o.substraction(point);
        double b = bVector.scalarProduct(d)*2;
        
        Vector cVector1 = o.substraction(cc);
        double cVector2 = cVector1.scalarProduct(cVector1);
        double c = cVector2 - r*r;
        
        double delta = b*b - (4*a*c);
        
        if(delta < 0) {
            return -1;
        } else if (delta == 0) {
            double t = (-b) / 2*a;
            return t;
        } else {
            double t1 = (-b+Math.sqrt(delta)) / 2*a;
            double t2 = (-b-Math.sqrt(delta)) / 2*a;
            
            if(t2 > 0) {
                return t2;
            } else if (t1 > 0){
                return t1;
            } else {
                return -1;
            }
        }
    }
    
    
    
    
    
    

}

