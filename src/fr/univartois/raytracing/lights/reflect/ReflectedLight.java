package fr.univartois.raytracing.lights.reflect;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.decorator.IDecoratorLight;
import fr.univartois.raytracing.lights.strategy.IStrategyLight;
import fr.univartois.raytracing.objects.IObjectStage;

public class ReflectedLight implements IDecoratorLight{
	
	private IStrategyLight model;
	private int maxDepth;
	
	private Vector r;
	private IObjectStage shape;
	
	public ReflectedLight(IStrategyLight model, int maxDepth) {
		this.model = model;
		this.maxDepth = maxDepth;
	}

	@Override
	public Color calculateColor(IObjectStage shape, Vector toLight, Point p) {
		Vector n = shape.getN(p);
		Vector r = n.multiplication(2*n.scalarProduct(toLight.multiplication(-1))).add(toLight).standardization();
		
		double t = shape.calculateT(p, r);
		
		Triplet specular = shape.getSpecular().getTriplet();
		
		double specularX = specular.getX();
		double specularY = specular.getY();
		double specularZ = specular.getZ();
		
		if(t > 0 && (specularX > 0 || specularY > 0 || specularZ > 0) && maxDepth > 1) {
			this.r = r;
			this.shape = shape;
			return recursifColor(1,p,t);
		} else {
			return model.calculateColor(shape, toLight, p);
		}
	}

	private Color recursifColor(int depth, Point p, double t) {
		if(depth >= maxDepth) {
			return new Color(new Triplet(0,0,0));
		} else {
			Point pPrime = r.multiplication(t).add(p);
			return shape.getSpecular().schur(recursifColor(depth+1,pPrime,t)).add(model.calculateColor(shape, r, p));
		}
	}

}
