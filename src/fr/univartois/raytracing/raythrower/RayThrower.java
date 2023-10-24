package fr.univartois.raytracing.raythrower;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.univartois.raytracing.Scene;

public class RayThrower {
	
	public static void rayThrower(Scene scene) {
		try {
			// Retrieve image
			BufferedImage image = CalculRayThrower.getMyImage(scene);
			File outputfile = new File(scene.getName());
			ImageIO.write(image, "png", outputfile);
			} 
		catch (IOException e) {
			// ...
			}
		
	}

}
