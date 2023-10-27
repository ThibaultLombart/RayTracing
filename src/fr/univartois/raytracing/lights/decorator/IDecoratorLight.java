/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing.lights.decorator;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Le type IDecoratorLight
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public interface IDecoratorLight {
    
    Color calculateColor(IObjectStage shape, Vector toLight, Point p);

}

