/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing.lights.strategy;

import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.decorator.BlinnPhongLight;
import fr.univartois.raytracing.lights.decorator.IDecoratorLight;
import fr.univartois.raytracing.objects.IObjectStage;
import fr.univartois.raytracing.lights.decorator.LambertLight;

/**
 * Le type NormalLighting
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class NormalLighting implements IStrategyLight,IDecoratorLight{
    
    private Scene scene;
    
    
    public NormalLighting(Scene scene) {
        this.scene = scene;
    }
    


    public IStrategyLight chooseModel() {
        IStrategyLight strategy = null;
        if(scene.getModel().equals("Normal")) {
            strategy = this;
        } else if (scene.getModel().equals("Lambert")){
            strategy = new LambertLight(this);
        } else if (scene.getModel().equals("Blinn")) {
            LambertLight stratLambert = new LambertLight(this);
            strategy = new BlinnPhongLight(scene, stratLambert);
        }
        return strategy;
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.lights.decorator.IDecoratorLight#calculateColorDecorator(fr.univartois.raytracing.objects.IObjectStage, fr.univartois.raytracing.digital.triples.Vector, fr.univartois.raytracing.digital.triples.Point)
     */
    @Override
    public Color calculateColor(IObjectStage shape, Vector toLight, Point p,List<Light> listLights) {
        return scene.getAmbient();
    }

}

