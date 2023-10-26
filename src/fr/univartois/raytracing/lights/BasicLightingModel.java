package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

/*
 * We are using a strategy for the design pattern. 
 * So we make an interface with 2 classes that redefine the method calculateColor for when we calculate the color with the basic model
 * or with the lambertian model.
 */
public class BasicLightingModel implements LightingModel{
	
	private Color ambient;
	
	
    /**
     * Crée une nouvelle instance de BasicLightingModel.
     */
    public BasicLightingModel(Color ambient) {
        // TODO Auto-generated constructor stub.
        this.ambient = ambient;
    }
	

	@Override
	public Color calculateColor(IObjectStage shapes, Vector toLight, Point p) {
		// TODO Auto-generated method stub
		return this.ambient;
	}

}
