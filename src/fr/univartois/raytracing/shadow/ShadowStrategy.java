/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.shadow;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;

/**
 * Interface ShadowStrategy
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public interface ShadowStrategy {
    
    Point calculateShadowPoint(Light light, Vector d, Scene scene, Point p);

}

