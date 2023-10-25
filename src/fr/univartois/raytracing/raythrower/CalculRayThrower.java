/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.raythrower;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.objects.Circle;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * The CalculRayThrower class provides methods for performing ray tracing calculations and generating images.
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class CalculRayThrower {
    
    /**
     * Calculates the pixel height based on the field of view (FOV).
     *
     * @param fov The field of view in degrees.
     * @return The pixel height.
     */
    public static double pixelHeight(int fov) {
        double fovr = (fov * Math.PI) / 180;
        return Math.tan(fovr/2);
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
        w.standardization();
        return w;
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
        u.standardization();
        return u;
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
        v.standardization();
        return v;
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
        double pixelHeight = pixelHeight(scene.getFov());
        
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        
        double pixelWidth = pixelHeight * (imgWidth / imgHeight);
        
        double a = (-(imgWidth/2) + (i + 0.5) * pixelWidth);
        double b = ((imgHeight/2) - (j + 0.5) * pixelHeight);
        
        Vector w = calculW(scene.getLookFrom(), scene.getLookAt());
        Vector u = calculU(scene.getUp(), w);
        Vector v = calculV(w, u);
        
        Vector res1 = u.multiplication(a);
        Vector res2 = v.multiplication(b);
        
        Vector d = res1.add(res2);
        d = d.substraction(v);
        
        return d;
    }
    
    /**
     * Find the color by tracing rays through the scene.
     *
     * @param scene The Scene object.
     * @param d The direction vector.
     * @return The color determined by ray tracing.
     */
    public static fr.univartois.raytracing.digital.triples.Color parcoursObjets(Scene scene, Vector d) {
        List<IObjectStage> objects = scene.getShapes();
        double min = -1;
        fr.univartois.raytracing.digital.triples.Color colorMin = new fr.univartois.raytracing.digital.triples.Color(new Triplet(0,0,0));
        for (int y = 0; y < objects.size(); y++) {
            Circle object = (Circle) objects.get(y);
            double t = object.calculT(scene.getLookFrom(), d);
            if(t != -1) {
                if(min == -1) {
                    min = t;
                    colorMin = object.getColor();
                } else if(min > t) {
                    min = t;
                    colorMin = object.getColor();
                }
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
    public static BufferedImage getMyImage(Scene scene) {
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                Vector d = calculD(i, j, scene);
                Triplet colAvant = parcoursObjets(scene, d).getTriplet();
                Color col = new Color((int) colAvant.getX(), (int) colAvant.getY(), (int) colAvant.getZ());
                int rgb = col.getRGB();
                image.setRGB(i, j, rgb);
            }
        }
        return image;
    }
}
