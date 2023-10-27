package fr.univartois.raytracing;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import fr.univartois.raytracing.builder.ComplicatedObjectBuilder;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.DirectionalLight;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.LocalLight;
import fr.univartois.raytracing.objects.Circle;
import fr.univartois.raytracing.objects.Plane;
import fr.univartois.raytracing.objects.Triangle;
import fr.univartois.raytracing.raythrower.CenterSampling;
import fr.univartois.raytracing.raythrower.GridSampling;
import fr.univartois.raytracing.raythrower.RandomSampling;
/**
 * The Parser class is responsible for reading scene information from a text file
 * and constructing a Scene object based on the provided data.
 */
public class Parser {

    /**
     * Reads a scene description from a file and constructs a Scene object.
     *
     * @param nomFichier The name of the file containing the scene description.
     * @return The constructed Scene object.
     * @throws Exception If there is an error while parsing the file or if values exceed certain limits.
     */

    public static Scene lecture(String nomFichier) throws Exception {
        ComplicatedObjectBuilder scene = ComplicatedObjectBuilder.newInstance();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
            String line;

            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                String token = null;
                if (scanner.hasNext()) {
                    token = scanner.next().trim();
                    
                    switch (token) {
                    case "size":
                        if (scanner.hasNext()) {
                            scene.setSizeX(Integer.parseInt(scanner.next().trim()));
                            scene.setSizeY(Integer.parseInt(scanner.next().trim()));
                        }
                        break;
                    case "output":

	                	if (scanner.hasNext()) {
	                		scene.setName(scanner.next().trim());
	                	}
				        break;
				    case "camera":
	                	if (scanner.hasNext()) {
	                		scene.setLookFrom(new Point(new Triplet(
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()))));
	                		
	                		scene.setLookAt(new Point(new Triplet(
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()))));
	                		
	                		scene.setUp(new Vector(new Triplet(
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()))));
	                		
	                		scene.setFov(Integer.parseInt(scanner.next().trim()));
	                	}
						break;
					
					case "ambient":
	                	if (scanner.hasNext()) {
	                		scene.setAmbient(new Color(new Triplet(
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()),
	                		        Double.parseDouble(scanner.next().trim()))));
	                	}
						break;
							
					case "diffuse" :
	                	if (scanner.hasNext()) {
	                		scene.setDiffuse(new Color(new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()))));
	                	}
						break;
	                
					case "specular":
	                	if (scanner.hasNext()) {
	                	    scene.setModel("Blinn");
	                		scene.setSpecular(new Color(new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()))));
	                	}
						break;
	                	
					case "shininess":
	                	if (scanner.hasNext()) {
	                		scene.setShininess(Integer.parseInt(scanner.next().trim()));
	                	}
						break;
	                
					case "directional":
	                	if (scanner.hasNext()) {
	                	    if(scene.getModel() == "Normal")
	                	        scene.setModel("Lambert");
	                		Triplet t1 = new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()));
	                		Triplet t2 = new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()));
	                		List<Light> l1 = scene.getLights();
	                		double x = t2.getX();
	                		double y = t2.getY();
	                		double z = t2.getZ();
	                		for( int i=0 ; i< l1.size() ; i++ ) {
	                			x = x + l1.get(i).getColor().getTriplet().getX();
	                			y = y + l1.get(i).getColor().getTriplet().getY();
	                			z = z + l1.get(i).getColor().getTriplet().getZ();
	                		}
							if (x>1 || y>1 || z>1) {
								scanner.close();
								throw new Exception("Valeur(s) supérieure(s) à 1");
							}
							else {
	                		scene.addLight(new DirectionalLight(new Color(t2),(new Vector(t1))));
							}
	                	}
						break;
	                
					case "point":
	                	if (scanner.hasNext()) {
	                	    if(scene.getModel() == "Normal")
                                scene.setModel("Lambert");
	                		Triplet t1 = new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()));
	                		Triplet t2 = new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()));
	                		List<Light> l1 = scene.getLights();
	                		double x = t2.getX();
	                		double y = t2.getY();
	                		double z = t2.getZ();
	                		for( int i=0 ; i< l1.size() ; i++ ) {
	                			x = x + l1.get(i).getColor().getTriplet().getX();
	                			y = y + l1.get(i).getColor().getTriplet().getY();
	                			z = z + l1.get(i).getColor().getTriplet().getZ();
	                		}
							if (x>1 || y>1 || z>1) {
								scanner.close();
								throw new Exception("Valeur(s) supérieure(s) à 1");
							}
							else {
	                		scene.addLight(new LocalLight(new Color(t2),(new Point(t1))));
							}
	                	}
						break;
	                
					case "maxverts":
			        	if (scanner.hasNext()) {
			        		scene.setMaxVerts(Integer.parseInt(scanner.next().trim()));
			        	}
						break;
	                
					case "vertex":
				    	if (scanner.hasNext()) {
				    		scene.addPoint(new Point(new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()))));
				    	}
						break;
				    
	
					case "tri":
						
						if (scanner.hasNext()) {
							Color couleur = scene.getDiffuse();
							if (couleur.getTriplet().getX()>1 || couleur.getTriplet().getY()>1 || couleur.getTriplet().getZ()>1) {
								scanner.close();
								throw new Exception("Valeur(s) supérieure(s) à 1");
							}
							else {
							Point[] listePoints = {scene.getPoints().get(Integer.parseInt(scanner.next().trim())),scene.getPoints().get(Integer.parseInt(scanner.next().trim())),scene.getPoints().get(Integer.parseInt(scanner.next().trim()))};
							scene.addShape(new Triangle(listePoints,couleur));
							} 
						}
						break;
					
					case "sphere":
						if (scanner.hasNext()) {
							Color couleur = scene.getDiffuse();
							scene.addShape(new Circle(new Point(new Triplet(
							        Double.parseDouble(scanner.next().trim()),
							        Double.parseDouble(scanner.next().trim()),
							        Double.parseDouble(scanner.next().trim())))
							        , 
							        Double.parseDouble(scanner.next().trim()) ,
							        couleur));
						}
						break;
					
					case "plane":
						if (scanner.hasNext()) {
							Color couleur = scene.getDiffuse();
							scene.addShape(new Plane(new Point(new Triplet(
							        Double.parseDouble(scanner.next().trim()),
							        Double.parseDouble(scanner.next().trim()),
							        Double.parseDouble(scanner.next().trim()))), 
							        new Vector(new Triplet(
							                Double.parseDouble(scanner.next().trim()),
							                Double.parseDouble(scanner.next().trim()),
							                Double.parseDouble(scanner.next().trim()))) ,
							        couleur));
						}
						break;
						
						
					case "sampling":
						if (scanner.hasNext()) {
							String verif = scanner.next().trim();
							if (verif.equals("middle")) {
								scene.setSamplingStrategy(new CenterSampling());
							}
							if (verif.equals("random")) {
								scene.setSamplingStrategy(new RandomSampling());
							}
							if (verif.equals("grid")) {
								scene.setSamplingStrategy(new GridSampling());
							}
					        if (scanner.hasNext()) {
					            scene.setSamples(Integer.parseInt(scanner.next().trim()));
					        }
						}
						break;
					}
	                scanner.close();
                }
	        }
	        reader.close();
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
		return scene.build();
	  }
}