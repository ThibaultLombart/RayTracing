package fr.univartois.raytracing.checkerboard;


import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

public class ConcreteStrategyCheckerboardA implements StrategyCheckerboard{

	@Override
	public Color calculateColor(IObjectStage shape, Vector toLight, Point p, Double taille, Color color1, Color color2) {
		if (p.getTriplet().getX() < taille && p.getTriplet().getZ() < taille || (p.getTriplet().getX() > taille && p.getTriplet().getZ() > taille)){
			return color1;
		}
		return color2;
	}


}
