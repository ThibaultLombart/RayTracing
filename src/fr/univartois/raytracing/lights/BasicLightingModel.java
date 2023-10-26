package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

/*
 * We are using a strategy for the design pattern. 
 * So we make an interface with 2 classes that redefine the method calculateColor for when we calculate the color with the basic model
 * or with the lambertian model.
 */
public class BasicLightingModel implements LightingModel{

	Point point;
	
	
	public BasicLightingModel(Point point) {
		this.point = point;
	}

	public Color calculateColor(Color color, Vector normal, Vector toLight) {
		return color;
	}
	
	/*
	 * Calculate the direction vector from the light to the point.
	 */
    public Vector getDirection() {
        return point.substraction(new Point(point.getTriplet().standardization()));
    }
    
}
