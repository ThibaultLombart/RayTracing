package fr.univartois.raytracing.lights.reflect;

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

public class ReflectedLight implements IDecoratorLight{
	
	private IStrategyLight model;
	private int maxDepth;
	
	private Vector r;
	private IObjectStage shape;
	private List<Light> listLights;
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
		this.listLights = listLights;
		
		double t = shape.calculateT(p, r);
		
		Triplet specular = shape.getSpecular().getTriplet();
		
		double specularX = specular.getX();
		double specularY = specular.getY();
		double specularZ = specular.getZ();
		
		if(t > 0 && (specularX > 0 || specularY > 0 || specularZ > 0) && maxDepth > 1) {
			this.shape = shape;
			return recursifColor(1,p,t);
		} else {
			return model.calculateColor(shape, toLight, p,listLights);
		}
	}

	private Color recursifColor(int depth, Point p, double t) {
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
				
				Point pPrime = r.multiplication(tPrime).add(p);
				Vector nPrime = shape.getN(pPrime);
				Vector rBefore = this.r;
				this.r = nPrime.multiplication(2*nPrime.scalarProduct(r.multiplication(-1))).add(r).standardization();
				return shape.getSpecular().schur(recursifColor(depth+1,pPrime,tPrime)).add(model.calculateColor(shape, rBefore, p,listLights));
			} else {
				return new Color(new Triplet(0,0,0));
			}
			
		}
	}

}
