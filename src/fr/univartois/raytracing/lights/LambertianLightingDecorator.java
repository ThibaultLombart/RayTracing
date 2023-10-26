package fr.univartois.raytracing.lights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

public class LambertianLightingDecorator implements LightingModel{
	
    List<Light> lights = new ArrayList<>();
    Scene scene;
	
	public LambertianLightingDecorator(List<Light> list, Scene scene) {
		this.lights = list;
		this.scene = scene;
	}


	
    
	public List<Light> getLights() {
		return lights;
	}

	public void setLights(List<Light> lights) {
	    this.lights = lights;
	}
	
	
	/**
	 * @param shape
	 * @return
	 */
	public Color calculateLambert(IObjectStage shape, Light light, Vector toLight) {
	    
	    Point pIntersection = toLight.multiplication(shape.calculateT(o,toLight)).add();
	    
	    Vector n = shape.getN(pIntersection);
	    
	    Vector ldir = light.getLdir(p);
	    
	    return light.getColor().multiplication(Math.max(n.scalarProduct(ldir),0));
	}

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.lights.LightingModel#calculateColor(fr.univartois.raytracing.objects.IObjectStage, fr.univartois.raytracing.digital.triples.Vector)
     */
    @Override
    public Color calculateColor(IObjectStage shape, Vector toLight) {
        double cosTheta = normal.scalarProduct(toLight);

        if (cosTheta < 0) {
            cosTheta = 0;
        }
        if(lights.size() >= 1) {
            
        }
        Color sommeColor = calculateLambert(shape, lights.get(0), toLight);
        
        for (int i = 1; i < lights.size(); i++) {
            sommeColor.add(calculateLambert(shape, lights.get(i), toLight));
        }
        return sommeColor.schur(shape.getColor()).add(scene.getAmbient());
    }

}
