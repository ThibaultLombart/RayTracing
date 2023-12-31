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
     * Attribute specular...
     */
    private Color specular;
    
    /**
     * Attribute shininess...
     */
    private int shininess;

    /**
     * Circle Constructor.
     * 
     * @param point point
     * @param r radius
     * @param color Color color
     */
    public Circle(Point point, double r, Color color, Color specular, int shininess) {
        super();
        this.point = point;
        this.r = r;
        this.color = color;
        this.specular = specular;
        this.shininess = shininess;
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
    public double calculateT(Point lookFrom, Vector d) {
        Point o = lookFrom;
        
        Point cc = this.point;
        
        Vector oc = o.substraction(cc);

        double b = (oc).multiplication(2).scalarProduct(d) ;
        
        double c = (oc).scalarProduct(oc) - (this.r*this.r);
        
        
        double delta = (b * b) - (4 * c);
        

        if (delta < 0) {
            return -1;
        } else if (delta == 0) {
            return (-b) / 2;
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

    /**
     * @param p intersection P
     * @return Vector N
     */
    public Vector getN(Point p) {
        return p.substraction(point).standardization();
    }

	@Override
	public Color getSpecular() {
		return specular;
	}

	@Override
	public int getShininess() {
		return shininess;
	}

}
