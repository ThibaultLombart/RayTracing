/**
 * Ce fichier fait partie du projet SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 * Tous droits réservés.
 */

package fr.univartois.raytracing;


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
        if(args.length == 1) {
            scene = Parser.lecture(args[0]);
        } else {
            throw new Exception("No args or too much args in Main.main()");
        }
        
        
        
    }
    
}

