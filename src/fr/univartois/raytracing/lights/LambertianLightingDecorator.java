package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

public class LambertianLightingDecorator implements LightingModel{
	
	Light light;
	
	public LambertianLightingDecorator(DirectionalLight light) {
		this.light=light;
	}

	public Color calculateColor(Color point, Vector normal, Vector toLight) {
        double cosTheta = normal.scalarProduct(toLight);

        if (cosTheta < 0) {
            cosTheta = 0;
        }
        Color result = point.add(this.light.getColor().multiplication(cosTheta));
        return result;
    }

	
    
	public DirectionalLight getLight() {
		return light;
	}

	public void setLight(DirectionalLight light) {
		this.light = light;
	}
}
