package fr.univartois.raytracing.lights.reflect;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.decorator.IDecoratorLight;
import fr.univartois.raytracing.lights.strategy.IStrategyLight;
import fr.univartois.raytracing.objects.IObjectStage;
import fr.univartois.raytracing.shadow.ShadowStrategy;
import fr.univartois.raytracing.shadow.ShadowWith;
import fr.univartois.raytracing.shadow.ShadowWithout;

public class ReflectedLight implements IDecoratorLight{
	
	private IStrategyLight model;
	private int maxDepth;
	
	private Vector r;
	private IObjectStage shape;
	private Scene scene;
	
	public ReflectedLight(IStrategyLight model, int maxDepth,Scene scene) {
		this.model = model;
		this.maxDepth = maxDepth;
		this.scene = scene;
	}

	@Override
	public Color calculateColor(IObjectStage shape, Vector toLight, Point p, List<Light> listLights) {
		Vector n = shape.getN(p);
		r = n.multiplication(2*n.scalarProduct(toLight.multiplication(-1))).add(toLight).standardization();
		
		double t = shape.calculateT(p, r);
		
		Triplet specular = shape.getSpecular().getTriplet();
		
		double specularX = specular.getX();
		double specularY = specular.getY();
		double specularZ = specular.getZ();
		
		if(t > 0 && (specularX > 0 || specularY > 0 || specularZ > 0) && maxDepth > 1) {
			this.shape = shape;
			return model.calculateColor(shape, toLight, p,listLights).add(recursifColor(1,p,listLights));
		} else {
			return model.calculateColor(shape, toLight, p,listLights);
		}
	}

	private Color recursifColor(int depth, Point p, List<Light> listLights) {
		if(depth >= maxDepth) {
			return new Color(new Triplet(0,0,0));
		} else {
			List<IObjectStage> objects = scene.getShapes();
			double min = -1;
			double tPrime;
			IObjectStage minObject = null;
			for (int y = 0; y < objects.size(); y++) {
				IObjectStage object = objects.get(y);
				tPrime = object.calculateT(p, r);
				double e = Math.pow(10, -2);
				if(tPrime > e && (min == -1 || min > tPrime)) {
					min = tPrime;
					minObject = object;
				}
				
			}
			if(minObject != null) {
				this.shape = minObject;
				tPrime = min;
				
				// SHADOW
				ShadowStrategy shadow;
				if (scene.getShadow()) {
		        	shadow = new ShadowWith();
		        }
				else {
		        	shadow = new ShadowWithout();
		        }
				
				// LIGHTS
				List<Light> listLightsTwo = new ArrayList<>();
                for (int j=0; j<scene.getLights().size(); j++) {
                	
                	Light light = scene.getLights().get(j);
                    Point shadowPoint = null;
                    
                    shadowPoint = shadow.calculateShadowPoint(light,light.getLdir(p),scene, p);
                    
                    if(shadowPoint == null) {
                    	listLightsTwo.add(light);
                    }
                }
				
                // CALCULATIONS
				Point pPrime = r.multiplication(tPrime).add(p);
				Vector nPrime = shape.getN(pPrime);
				Vector rBefore = this.r;
				this.r = nPrime.multiplication(2*nPrime.scalarProduct(r.multiplication(-1))).add(r).standardization();
				return shape.getSpecular().schur(recursifColor(depth+1,pPrime,listLightsTwo)).add(model.calculateColor(shape, rBefore, p,listLights));
			} else {
				return new Color(new Triplet(0,0,0));
			}
			
		}
	}

}
