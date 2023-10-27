package fr.univartois.raytracing.raythrower;

import java.util.List;

import fr.univartois.raytracing.digital.triples.Vector;

public interface SamplingStrategy {
	List<Vector> generateSamples(int samples);
}

