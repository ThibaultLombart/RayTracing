package fr.univartois.raytracing.raythrower;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Vector;

import java.util.ArrayList;
import java.util.List;

public class GridSampling implements SamplingStrategy {

    @Override
    public List<Vector> generateSamples(int numSamples) {
        int gridSize = (int) Math.sqrt(numSamples);
        List<Vector> samples = new ArrayList<>();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                double u = (i + 0.5) / gridSize;
                double v = (j + 0.5) / gridSize;

                Vector sampleVector = new Vector(new Triplet(u, v, 0));
                samples.add(sampleVector);
            }
        }

        return samples;
    }
}
