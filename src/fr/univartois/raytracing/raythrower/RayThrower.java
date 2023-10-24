package fr.univartois.raytracing.raythrower;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RayThrower {
	
	public void rayThrower() {
		try {
			// Retrieve image
			BufferedImage image = getMyImage();
			File outputfile = new File("output.png");
			ImageIO.write(image, "png", outputfile);
			} 
		catch (IOException e) {
			// ...
			}
		
	}

}
