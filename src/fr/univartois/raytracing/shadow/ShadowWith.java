/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing.shadow;

import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.LocalLight;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Le type ShadowWith
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class ShadowWith implements ShadowStrategy {

	public Point calculateShadowPoint(LocalLight light, Vector d, Scene scene) {
		Point p = null;
		double t;
		List<IObjectStage> objects = scene.getShapes();
		for (int i = 0; i < objects.size() ; i++) {
			t = objects.get(i).calculateT(light.getPoint(), d);
	        if(t == -1) {
	            p = d.multiplication(t).add(light.getPoint());
	        }
		}
		return p;
	}
}

