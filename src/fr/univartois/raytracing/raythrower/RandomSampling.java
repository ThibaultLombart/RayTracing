package fr.univartois.raytracing.raythrower;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Vector;

public class RandomSampling implements SamplingStrategy {

	private final Random random = new Random();

    public List<Vector> generateSamples(int numSamples) {
        List<Vector> samples = new ArrayList<>();

        for (int i = 0; i < numSamples; i++) {
            double u = random.nextDouble();
            double v = random.nextDouble();

            Vector sampleVector = new Vector(new Triplet(u, v, 0));
            samples.add(sampleVector);
        }

        return samples;
    }
}
