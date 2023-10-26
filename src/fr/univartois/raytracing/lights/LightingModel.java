package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

public interface LightingModel {
	
	Color calculateColor(IObjectStage shapes, Vector toLight, Point p);

}
