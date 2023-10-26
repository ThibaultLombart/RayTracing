/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.objects;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

/**
 * Interface ObjectStage
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public interface IObjectStage {

    /**
     * @return Color
     */
    Color getColor();
    
    /**
     * @param lookFrom lookFrom
     * @param d d 
     * @return T
     */
    double calculateT(Point lookFrom, Vector d);
    
    Vector getN(Point p);
    
}

