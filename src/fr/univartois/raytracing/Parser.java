package fr.univartois.raytracing;

import java.io.*;
import java.util.Scanner;

public class Parser {
	
	public static Scene lecture(String nomFichier){
		Scene scene = new Scene();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
			String line;
			while ((line = reader.readLine()) != null) {
	                Scanner scanner = new Scanner(line);
	                if (scanner.hasNext()) {
	                	String token = scanner.next().trim();
	                }
	                switch (token) {
	                case "size":
	                	if (scanner.hasNext()) {
	                		scene.setSize(scanner.next().trim());
	                	}
			            break;
                    case "output":
	                	if (scanner.hasNext()) {
	                		scene.setOutput(scanner.next().trim());
	                	}
				        break;
				    case "camera":
	                	if (scanner.hasNext()) {
	                		scene.setCamera(scanner.next().trim());
	                	}
						break;
					
					case "ambient":
	                	if (scanner.hasNext()) {
	                		scene.setAmbient(scanner.next().trim());
	                	}
						break;
							
					case "diffuse" :
	                	if (scanner.hasNext()) {
	                		scene.setDiffuse(scanner.next().trim());
	                	}
						break;
	                
					case "specular":
	                	if (scanner.hasNext()) {
	                		scene.setSize(scanner.next().trim());
	                	}
						break;
	                	
					case "shininess":
	                	if (scanner.hasNext()) {
	                		scene.setShininess(scanner.next().trim());
	                	}
						break;
	                
					case "directional":
	                	if (scanner.hasNext()) {
	                		scene.setDirectional(scanner.next().trim());
	                	}
						break;
	                
					case "point":
	                	if (scanner.hasNext()) {
	                		scene.setPoint(scanner.next().trim());
	                	}
						break;
	                
					case "maxverts":
			        	if (scanner.hasNext()) {
			        		scene.setMaxverts(scanner.next().trim());
			        	}
						break;
	                
					case "vertex":
				    	if (scanner.hasNext()) {
				    		scene.setVertex(scanner.next().trim());
				    	}
						break;
				    
	
					case "tri":
						if (scanner.hasNext()) {
							scene.setTri(scanner.next().trim());
						}
						break;
					
					case "sphere":
						if (scanner.hasNext()) {
							scene.setSphere(scanner.next().trim());
						}
						break;
					
					case "plane":
						if (scanner.hasNext()) {
							scene.setPlane(scanner.next().trim());
						}
						break;
					}
	        }
	        scanner.close();    
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
		return scene;
	  }
}
