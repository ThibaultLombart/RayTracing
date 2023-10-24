/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.raythrower;

import java.awt.Color;
import java.awt.image.BufferedImage;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;

/**
 * CalculRayThrower class
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class CalculRayThrower {
    
    public static double pixelHeight(int fov) {
        double fovr = (fov * Math.PI) / 180;
        
        return Math.tan(fovr/2);
    }
    
    public static Vector calculW(Point lookFrom, Point lookAt) {
        Vector w = lookFrom.substraction(lookAt);
        w.standardization();
        return w;
    }
    
    public static Vector calculU(Vector up, Vector w) {
        Vector u = up.vectorProduct(w);
        u.standardization();
        return u;
    }
    
    public static Vector calculV(Vector w, Vector u) {
        Vector v = w.vectorProduct(u);
        v.standardization();
        return v;
    }
    
    public static Vector calculD(int i, int j, Scene scene) {
        double pixelHeight = pixelHeight(scene.getFov());
        
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        
        double pixelWidth = pixelHeight*(imgWidth/imgHeight);
        
        
        double a = (-(imgWidth/2) + (i + 0.5) * pixelWidth);
        double b = ((imgHeight/2) - (j + 0.5) * pixelHeight);
        
        Vector w = calculW(scene.getLookFrom(),scene.getLookAt());
        Vector u = calculU(scene.getUp(),w);
        Vector v = calculV(w,u);
        
        Vector res1 = u.multiplication(a);
        Vector res2 = v.multiplication(b);
        
        Vector d = res1.add(res2);
        d = d.substraction(v);
        
        return d;
    }
    
    public static BufferedImage getMyImage(Scene scene) {
        
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        
        BufferedImage image = new BufferedImage(imgWidth,imgHeight,BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < imgWidth; i++) {
            for(int j = 0; j < imgHeight; j++) {
                Vector d = calculD(i,j,scene);
                /*Point p
                if(p != null) {
                    Color black = new Color(0,0,0);
                    int rgb = black.getRGB();
                    image.setRGB(i,j,rgb);
                } else {
                    Color black = new Color(0,0,0);
                    int rgb = black.getRGB();
                    image.setRGB(i,j,rgb);
                }
                */
                Color black = new Color(0,0,0);
                int rgb = black.getRGB();
                image.setRGB(i,j,rgb);
            }
        }
        return image;
    }

}

