package fr.univartois.raytracing.raythrower;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Vector;

public class CenterSampling implements SamplingStrategy {
    public List<Vector> generateSamples(int samples) {
        List<Vector> samplesList = new ArrayList<>();
        Vector centerVector = new Vector(new Triplet(0, 0, 1));
        samplesList.add(centerVector);
        return samplesList;
    }
}
