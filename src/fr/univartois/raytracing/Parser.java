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

public class Parser {
	
	public static Scene lecture(String nomFichier) throws Exception{
		ComplicatedObjectBuilder scene = ComplicatedObjectBuilder.newInstance();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
			String line;
			
			while ((line = reader.readLine()) != null) {
			        Scanner scanner = new Scanner(line);
	                String token = null;
	                if (scanner.hasNext()) {
	                	token = scanner.next().trim();
	                }
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
	                		Triplet t1 = new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()));
	                		List<Light> l1 = scene.getLights();
	                		double x = 0;
	                		double y = 0;
	                		double z = 0;
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
	                		scene.addLight(new DirectionalLight(new Color(t1),(new Vector(new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()))))));
							}
	                	}
						break;
	                
					case "point":
	                	if (scanner.hasNext()) {
	                		Triplet t1 = new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()));
	                		List<Light> l1 = scene.getLights();
	                		double x = 0;
	                		double y = 0;
	                		double z = 0;
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
	                		scene.addLight(new LocalLight(new Color(t1),(new Point(new Triplet(Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()),Double.parseDouble(scanner.next().trim()))))));
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
							Color couleur = scene.getAmbient();
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
							Color couleur = scene.getAmbient();
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
							Color couleur = scene.getAmbient();
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
					}
	                scanner.close();
	        }
	            reader.close();
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
		return scene.build();
	  }
}
