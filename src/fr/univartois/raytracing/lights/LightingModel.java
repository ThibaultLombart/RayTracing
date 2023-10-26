package fr.univartois.raytracing.lights;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

public interface LightingModel {
	Color calculateColor(Color color, Vector normal, Vector toLight);

	Vector getDirection();
}
