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
import fr.univartois.raytracing.lights.strategy.NormalLighting;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Le type LambertDecorator
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public abstract class LambertDecorator implements IDecoratorLight{
    
    private IDecoratorLight decorated;
    
    public LambertDecorator(NormalLighting decorated) {
        this.decorated = decorated;
    }

    public Color calculateColor(IObjectStage shape, Vector toLight, Point p) {
        return decorated.calculateColor(shape, toLight, p);
    }
    
}

