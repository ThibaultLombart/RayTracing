/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import fr.univartois.raytracing.raythrower.CenterSampling;
import fr.univartois.raytracing.raythrower.RayThrower;

/**
 * Le type Main
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Main {

    /**
     * @param args Command Line
     * @throws Exception Exception if no args or too much args
     */
    public static void main(String[] args) throws Exception {
        
        Scene scene;
        scene = Parser.lecture("src/fr/univartois/resources/test.txt");
        /*
        if(args.length == 1) {
            scene = Parser.lecture(args[0]);
        } else {
            throw new Exception("No args or too much args in Main.main()");
        }
        
        try {
            BufferedImage image = CalculRayThrower.getMyImage(scene);
            File outputfile = new File("output.png");
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            //..
        }
        System.out.println("FAIT");
        */
        
        if (scene.getSamplingStrategy()==null) {
        	scene.setSamplingStrategy(new CenterSampling());
        }
        
        if (scene.getSamples()==0) {
        	scene.setSamples(1);
        }
        
        RayThrower.rayThrower(scene,scene.getSamplingStrategy(),scene.getSamples());
        System.out.println("FINI");
        
        
        
        
        
        
    }
    
}

