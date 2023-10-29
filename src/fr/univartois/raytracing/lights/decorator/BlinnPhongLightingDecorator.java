package fr.univartois.raytracing.lights.decorator;



import java.util.List;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.strategy.IStrategyLight;
import fr.univartois.raytracing.objects.IObjectStage;

public class BlinnPhongLightingDecorator implements IStrategyLight {
	
	

	 private IDecoratorLight decorated;
	    
	    public BlinnPhongLightingDecorator(LambertLight decorator) {
	        this.decorated = decorator;
	    }
	    
	    public Color calculateColor(IObjectStage shape, Vector toLight, Point p,List<Light> listLights) {
	        return decorated.calculateColor(shape, toLight, p, listLights);
	    }
	
	    
}
