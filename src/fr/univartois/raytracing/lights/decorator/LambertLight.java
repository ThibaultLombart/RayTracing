/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing.lights.decorator;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.strategy.IStrategyLight;
import fr.univartois.raytracing.lights.strategy.NormalLighting;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Le type LambertLight
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class LambertLight extends LambertDecorator implements IStrategyLight{
    
    List<Light> lights = new ArrayList<>();
    
    public LambertLight(List<Light> lights, NormalLighting decorated) {
        super(decorated);
        this.lights = lights;
    }
    
    /**
     * @param shape
     * @return
     */
    public Color calculateLambert(IObjectStage shape, Light light, Point p) {
        
        Vector ldir = light.getLdir(p);
        Vector n = shape.getN(p);

        return light.getColor().multiplication(Math.max(n.scalarProduct(ldir),0));
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.lights.decorator.IDecoratorLight#calculateColorDecorator(fr.univartois.raytracing.objects.IObjectStage, fr.univartois.raytracing.digital.triples.Vector, fr.univartois.raytracing.digital.triples.Point)
     */
    @Override
    public Color calculateColor(IObjectStage shape, Vector toLight, Point p) {
        Color la = super.calculateColor(shape, toLight, p);
        
        
        Color sommeColor = calculateLambert(shape, lights.get(0),p);
        
        for (int i = 1; i < lights.size(); i++) {
            sommeColor = sommeColor.add(calculateLambert(shape, lights.get(i),p));
        }
        return sommeColor.schur(shape.getColor()).add(la);
    }

}

