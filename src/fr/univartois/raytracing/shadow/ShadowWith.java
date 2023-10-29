/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.shadow;

import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.LocalLight;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Class ShadowWith
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class ShadowWith implements ShadowStrategy {

	public Point calculateShadowPoint(Light light, Vector d, Scene scene, Point p) {
		Point pPrime = null;
		double t;
		List<IObjectStage> objects = scene.getShapes();
		for (int i = 0; i < objects.size() ; i++) {
			t = objects.get(i).calculateT(p, d);
	        if(t > -1) {
	        	pPrime = d.multiplication(t).add(p);
	        }
		}
		return pPrime;
	}
}

