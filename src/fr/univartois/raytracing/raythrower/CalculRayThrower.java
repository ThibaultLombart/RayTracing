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
 * CalculRayThrower class
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class CalculRayThrower {
    
    public static double realHeight(int fov) {
        double fovr = (fov * Math.PI) / 180;
        
        return 2*Math.tan(fovr/2);
    }
    
    public static double realWidth(int imgWidth, double pixelHeight) {
        return imgWidth * pixelHeight;
    }
    
    public static double pixelHeight(double realHeight,int imgHeight) {
        return realHeight / imgHeight;
    }
    
    public static double pixelWidth(int imgWidth, double realWidth) {
        return realWidth / imgWidth;
    }
    
    public static Vector calculW(Point lookFrom, Point lookAt) {
        Vector w = lookFrom.substraction(lookAt).standardization();
        return w;
    }
    
    public static Vector calculU(Vector up, Vector w) {
        Vector u = up.vectorProduct(w).standardization();
        return u;
    }
    
    public static Vector calculV(Vector w, Vector u) {
        Vector v = w.vectorProduct(u).standardization();
        return v;
    }
    
    public static Vector calculD(int i, int j, Scene scene) {
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        
        double realHeight = realHeight(scene.getFov());
        double pixelHeight = pixelHeight(realHeight, imgHeight);
        
        double realWidth = realWidth(imgWidth,pixelHeight);
        double pixelWidth = pixelWidth(imgWidth, realWidth);
        
        
        double a = (-(realWidth/2) + (i + 0.5) * pixelWidth);
        double b = ((realHeight/2) - (j + 0.5) * pixelHeight);
        
        
        Vector w = calculW(scene.getLookFrom(),scene.getLookAt());
        Vector u = calculU(scene.getUp(),w);
        Vector v = calculV(w,u);
        
        Vector res1 = u.multiplication(a);
        Vector res2 = v.multiplication(b);
        
        Vector d = res1.add(res2).substraction(v).standardization();
        
        return d;
    }
    
    public static fr.univartois.raytracing.digital.triples.Color parcoursObjets(Scene scene, Vector d) {
        List<IObjectStage> objects = scene.getShapes();
        double min = -1;
        fr.univartois.raytracing.digital.triples.Color colorMin = new fr.univartois.raytracing.digital.triples.Color(new Triplet(0,0,0));
        for (int y = 0; y < objects.size(); y ++) {
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
    
    public static BufferedImage getMyImage(Scene scene) {
        
        int imgWidth = scene.getSizeX();
        int imgHeight = scene.getSizeY();
        
        BufferedImage image = new BufferedImage(imgWidth,imgHeight,BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < imgWidth; i++) {
            for(int j = 0; j < imgHeight; j++) {
                Vector d = calculD(i,j,scene);
                Triplet colAvant = parcoursObjets(scene,d).getTriplet();
                Color col = new Color((int) Math.round(colAvant.getX()),(int) Math.round(colAvant.getY()),(int) Math.round(colAvant.getZ()));
                int rgb = col.getRGB();
                image.setRGB(i,j,rgb);
            }
        }
        return image;
    }

}

