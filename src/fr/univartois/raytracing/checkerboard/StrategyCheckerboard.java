package fr.univartois.raytracing.checkerboard;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Interface for Checkerboard Strategy.
 * Implementations of this interface are responsible for calculating the color of points on a checkerboard pattern.
 */
public interface StrategyCheckerboard {
    /**
     * Calculate the color of a point on the checkerboard pattern.
     *
     * @param shape The object stage.
     * @param toLight The vector to the light source.
     * @param p The point on the checkerboard.
     * @param size The size of the checkerboard squares.
     * @param color1 The color of the first square.
     * @param color2 The color of the second square.
     * @return The calculated color for the given point on the checkerboard.
     */
    public Color calculateColor(IObjectStage shape, Vector toLight, Point p, Double size, Color color1, Color color2);
}