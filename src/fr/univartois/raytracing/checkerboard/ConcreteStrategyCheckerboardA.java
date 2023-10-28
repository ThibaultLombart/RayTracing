package fr.univartois.raytracing.checkerboard;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Concrete implementation of the Checkerboard Strategy (StrategyCheckerboard).
 * This strategy calculates the color of a point on the checkerboard based on its position.
 */
public class ConcreteStrategyCheckerboardA implements StrategyCheckerboard {

    /**
     * Calculate the color of a point on the checkerboard.
     *
     * @param shape The object stage.
     * @param toLight The vector to the light source.
     * @param p The point on the checkerboard.
     * @param size The size of the checkerboard squares.
     * @param color1 The color of the first square.
     * @param color2 The color of the second square.
     * @return The calculated color based on the checkerboard position.
     */
    @Override
    public Color calculateColor(IObjectStage shape, Vector toLight, Point p, Double size, Color color1, Color color2) {
        if (p.getTriplet().getX() < size && p.getTriplet().getZ() < size || (p.getTriplet().getX() > size && p.getTriplet().getZ() > size)) {
            return color1;
        }
        return color2;
    }
}