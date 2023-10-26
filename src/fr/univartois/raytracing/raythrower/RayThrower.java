package fr.univartois.raytracing.raythrower;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.univartois.raytracing.Scene;

/**
 * The RayThrower class is responsible for generating and saving images of a scene using ray tracing.
 */
public class RayThrower {

    /**
     * Renders the specified scene using ray tracing and saves the result as an image in the same directory.
     *
     * @param scene The Scene object to be rendered.
     */
    public static void rayThrower(Scene scene) {
        try {
            // Retrieve image
            BufferedImage image = CalculRayThrower.getMyImage(scene);
            File outputfile = new File(scene.getName());
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            // Handle the exception, e.g., by logging an error or taking appropriate action.
        }
    }
}
