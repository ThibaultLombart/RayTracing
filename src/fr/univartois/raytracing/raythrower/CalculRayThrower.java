/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.raythrower;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.reflect.ReflectedLight;
import fr.univartois.raytracing.lights.strategy.IStrategyLight;
import fr.univartois.raytracing.lights.strategy.NormalLighting;
import fr.univartois.raytracing.objects.IObjectStage;
import fr.univartois.raytracing.shadow.ShadowStrategy;
import fr.univartois.raytracing.shadow.ShadowWith;
import fr.univartois.raytracing.shadow.ShadowWithout;

/**
 * The CalculRayThrower class provides methods for performing ray tracing calculations and generating images.
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class CalculRayThrower {
	
	private CalculRayThrower() {
		// Utility Class
	}
    
    /**
     * Calculates the pixel height based on the field of view (FOV).
     *
     * @param fov The field of view in degrees.
     * @return The pixel height.
     */
    public static double realHeight(int fov) {
        double fovr = (fov * Math.PI) / 180;
        return 2*Math.tan(fovr/2);
    }
    
    public static double pixelHeight(double realHeight,int imgHeight) {
        return realHeight / imgHeight;
    }
    
    public static double realWidth(int imgWidth, double pixelHeight) {
        return imgWidth * pixelHeight;
    }
    
    public static double pixelWidth(int imgWidth, double realWidth) {
        return realWidth / imgWidth;
    }
    
    /**
     * Calculate the W vector for the camera.
     *
     * @param lookFrom The point representing the camera's position.
     * @param lookAt The point representing the camera's target.
     * @return The W vector.
     */
    public static Vector calculW(Point lookFrom, Point lookAt) {
        Vector w = lookFrom.substraction(lookAt);
        return w.standardization();
    }
    
    /**
     * Calculate the U vector for the camera.
     *
     * @param up The up vector for the camera.
     * @param w The W vector.
     * @return The U vector.
     */
    public static Vector calculU(Vector up, Vector w) {
        Vector u = up.vectorProduct(w);
        return u.standardization();
    }
    
    /**
     * Calculate the V vector for the camera.
     *
     * @param w The W vector.
     * @param u The U vector.
     * @return The V vector.
     */
    public static Vector calculV(Vector w, Vector u) {
        Vector v = w.vectorProduct(u);
        return v.standardization();
    }
    

    
    /**
     * Calculate the direction vector for a specific pixel in the scene.
     *
     * @param i The horizontal pixel position.
     * @param j The vertical pixel position.
     * @param scene The Scene object.
     * @return The direction vector.
     */
    public static Vector calculD(int i, int j, Scene scene) {
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        
        Vector up = scene.getUp();
        
        double realHeight = realHeight(scene.getFov());
        double pixelHeight = pixelHeight(realHeight, imgHeight);
        
        double realWidth = realWidth(imgWidth,pixelHeight);
        double pixelWidth = pixelWidth(imgWidth, realWidth);
        
        
        double a = -(realWidth/2) + ((i + 0.5) * pixelWidth);
        double b = (realHeight/2) - ((j + 0.5) * pixelHeight);
        
        
        
        Vector w = calculW(scene.getLookFrom(),scene.getLookAt());
        Vector u = calculU(up,w);
        Vector v = calculV(w,u);
        
        
        
        Vector d = u.multiplication(a).add(v.multiplication(b)).substraction(w);
        
        
        return d.standardization();
    }
    
    /**
     * Find the color by tracing rays through the scene.
     *
     * @param scene The Scene object.
     * @param d The direction vector.
     * @return The color determined by ray tracing.
     */
    public static fr.univartois.raytracing.digital.triples.Color objectIterator(Scene scene, Vector d,IStrategyLight model) {
    	List<IObjectStage> objects = scene.getShapes();
        double min = -1;
        ShadowStrategy shadow;
        if (scene.getShadow()) {
        	shadow = new ShadowWith();
        }
        else {
        	shadow = new ShadowWithout();
        }
        
        fr.univartois.raytracing.digital.triples.Color colorMin = new fr.univartois.raytracing.digital.triples.Color(new Triplet(0,0,0));

        
        for (int y = 0; y < objects.size(); y++) {
           IObjectStage object = objects.get(y);
           double t = object.calculateT(scene.getLookFrom(), d);
           Point p = null;
           if(t > -1) {
                p = d.multiplication(t).add(scene.getLookFrom());
            }
            if(p != null && (min == -1 || min > t)) {
            	min = t;
                
                List<Light> listLights = new ArrayList<>();
                for (int j=0; j<scene.getLights().size(); j++) {
                	
                	Light light = scene.getLights().get(j);
                    Point shadowPoint = null;
                    
                    shadowPoint = shadow.calculateShadowPoint(light,light.getLdir(p),scene, p);
                    
                    if(shadowPoint == null) {
                    	listLights.add(light);
                    }
                }
                ReflectedLight rf = new ReflectedLight(model,scene.getMaxDepth(),scene);
                colorMin = rf.calculateColor(object, d, p, listLights);
            }
            

        }
        
        
          
    	
        return colorMin;
    }
    
    /**
     * Generate an image of the scene using ray tracing.
     *
     * @param scene The Scene object to render.
     * @return A BufferedImage representing the rendered image.
     */
    public static BufferedImage getMyImage(Scene scene, SamplingStrategy samplingStrategy, int samples) {
        NormalLighting strategy = new NormalLighting(scene);
        IStrategyLight model = strategy.chooseModel();
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imgWidth; i++) {
            for(int j = 0; j < imgHeight; j++) {
            	fr.univartois.raytracing.digital.triples.Color totalColor = new fr.univartois.raytracing.digital.triples.Color(new Triplet(0,0,0));
            	if(samplingStrategy != null) {
            		List<Vector> listeSamples = samplingStrategy.generateSamples(samples);
                    for (int l = 0; l < listeSamples.size(); l++) {
                    	Vector dPrime = calculD(i,j,scene);
                        Triplet colAvant = objectIterator(scene, dPrime,model).getTriplet();

                        totalColor = totalColor.add(new fr.univartois.raytracing.digital.triples.Color(colAvant));
                    }
                    totalColor = totalColor.multiplication(1.0 / samples);
            	} else {
            		Vector d = calculD(i,j,scene);
            		totalColor = objectIterator(scene, d,model);
            	}
                float r = Math.min((float) totalColor.getTriplet().getX(),1);
                float g = Math.min((float) totalColor.getTriplet().getY(),1);
                float b = Math.min((float) totalColor.getTriplet().getZ(),1);
                Color col = new Color(r,g,b);

                int rgb = col.getRGB();
                image.setRGB(i, j, rgb);

            }
        }
        return image;
    }
}
