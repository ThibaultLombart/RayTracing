/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import fr.univartois.raytracing.exceptions.MainException;
import fr.univartois.raytracing.raythrower.CalculRayThrower;
import fr.univartois.raytracing.raythrower.CenterSampling;


/**
 * Main Class
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Main {
	
	private static  final Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * @param args Command Line
     * @throws Exception Exception if no args or too much args
     */
    public static void main(String[] args) throws Exception {
    	
        Scene scene;
        
        if(args.length == 1) {
            scene = Parser.reading(args[0]);
        } else {
            throw new MainException("No args or too much args in Main.main()");
        }
        
        try {
            BufferedImage image = CalculRayThrower.getMyImage(scene, scene.getSamplingStrategy(), scene.getSamples());
            File outputfile = new File(scene.getName());
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            //..
        }
        
        
        if (scene.getSamplingStrategy()==null) {
        	scene.setSamplingStrategy(new CenterSampling());
        }
        
        if (scene.getSamples()==0) {
        	scene.setSamples(1);
        }
        
        String generated = String.format("Picture %s Generated", scene.getName());
        logger.log(Level.INFO,generated);
        
        
        
        
        
    }
    
}

