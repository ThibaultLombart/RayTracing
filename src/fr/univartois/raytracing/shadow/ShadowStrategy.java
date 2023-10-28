/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing.shadow;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.LocalLight;

/**
 * Le type ShadowStrategy
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public interface ShadowStrategy {
    
    Point calculateShadowPoint(LocalLight light, Vector d, Scene scene);

}

