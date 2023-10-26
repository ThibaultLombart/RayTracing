package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

public class LambertianLightingDecorator implements LightingModel{
	
	Color diffuseColor;
	Vector vector;

	
	public LambertianLightingDecorator(Vector vector) {
		super();
		this.vector = vector;
	}

	public Color calculateColor(Color point, Vector normal, Vector toLight) {
        double cosTheta = normal.scalarProduct(toLight);

        if (cosTheta < 0) {
            cosTheta = 0;
        }
        Color result = point.add(diffuseColor.multiplication(cosTheta));
        return result;
    }

	public Color getDiffuseColor() {
		return diffuseColor;
	}

	public void setDiffuseColor(Color diffuseColor) {
		this.diffuseColor = diffuseColor;
	}
    
	/*
	 * Directional lights have a consistent direction.
	 */
    public Vector getDirection() {
        return vector.standardization();
    }
    
}
