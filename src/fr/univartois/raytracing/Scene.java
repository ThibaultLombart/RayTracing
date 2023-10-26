package fr.univartois.raytracing;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.builder.ComplicatedObjectBuilder;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.LightingModel;
import fr.univartois.raytracing.objects.IObjectStage;

/**
 * Class Scene
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class Scene {
	
	/**
	 * Attribute sizeX
	 */
	private int sizeX;
	/**
     * Attribute sizeY
     */
	private int sizeY;
	/**
     * Attribute fov
     */
	private int fov;
	/**
     * Attribute shininess
     */
	private int shininess = 0;
	/**
     * Attribute maxVerts
     */
	private int maxVerts = 0; 
	/**
     * Attribute name
     */
	private String name = "output.png";
	/**
     * Attribute lookFrom
     */
	private Point lookFrom;
	/**
     * Attribute lookAt
     */
	private Point lookAt;
	/**
     * Attribute up
     */
	private Vector up;
	/**
     * Attribute ambient
     */
	private Color ambient = new Color(new Triplet(0,0,0));
	/**
     * Attribute diffuse
     */
	private Color diffuse = new Color(new Triplet(0,0,0));
	/**
     * Attribute specular
     */
	private Color specular = new Color(new Triplet(0,0,0));
	/**
     * Attribute lights
     */
	private List<Light> lights = new ArrayList<>();
	/**
     * Attribute points
     */
	private List<Point> points = new ArrayList<>();
	/**
     * Attribute shapes
     */
	private List<IObjectStage> shapes = new ArrayList<>();
	
	private LightingModel model;
	
	
	public LightingModel getModel() {
		return model;
	}



	public void setModel(LightingModel model) {
		this.model = model;
	}



	/**
	 * constructor Scene
	 * @param builder ComplicatedObjectBuilder
	 */
	public Scene(ComplicatedObjectBuilder builder) {
		super();
		this.sizeX = builder.getSizeX();
		this.sizeY = builder.getSizeY();
		this.name = builder.getName();
		this.shininess = builder.getShininess();
		this.maxVerts = builder.getMaxVerts();
		this.ambient = builder.getAmbient();
		this.diffuse = builder.getDiffuse();
		this.specular = builder.getSpecular();
		this.lookFrom = builder.getLookFrom();
		this.lookAt = builder.getLookAt();
		this.up = builder.getUp();
		this.fov = builder.getFov();
		this.lights = builder.getLights();
		this.points = builder.getPoints();
		this.shapes = builder.getShapes();
		
	}


    
    /**
     * Give Attribute sizeX .
     *
     * @return Attribute sizeX .
     */
    public int getSizeX() {
        return sizeX;
    }

    
    /**
     * Modify Attribute sizeX .
     *
     * @param sizeX new value Attribute sizeX .
     */
    public  void setSizeX(int sizeX) {
        this.sizeX = sizeX;
         
    }

    
    /**
     * Give Attribute sizeY .
     *
     * @return Attribute sizeY .
     */
    public int getSizeY() {
        return sizeY;
    }

    
    /**
     * Modify Attribute sizeY .
     *
     * @param sizeY new value Attribute sizeY .
     */
    public  void setSizeY(int sizeY) {
        this.sizeY = sizeY;
         
    }

    
    /**
     * Give Attribute fov .
     *
     * @return Attribute fov .
     */
    public int getFov() {
        return fov;
    }

    
    /**
     * Modify Attribute fov .
     *
     * @param fov new value Attribute fov .
     */
    public  void setFov(int fov) {
        this.fov = fov;
         
    }

    
    /**
     * Give Attribute shininess .
     *
     * @return Attribute shininess .
     */
    public int getShininess() {
        return shininess;
    }

    
    /**
     * Modify Attribute shininess .
     *
     * @param shininess new value Attribute shininess .
       
     */
    public  void setShininess(int shininess) {
        this.shininess = shininess;
         
    }

    
    /**
     * Give Attribute maxVerts .
     *
     * @return Attribute maxVerts .
     */
    public int getMaxVerts() {
        return maxVerts;
    }

    
    /**
     * Modify Attribute maxVerts .
     *
     * @param maxVerts new value Attribute maxVerts .
       
     */
    public  void setMaxVerts(int maxVerts) {
        this.maxVerts = maxVerts;
         
    }

    
    /**
     * Give Attribute name .
     *
     * @return Attribute name .
     */
    public String getName() {
        return name;
    }

    
    /**
     * Modify Attribute name .
     *
     * @param name new value Attribute name .
       
     */
    public  void setName(String name) {
        this.name = name;
         
    }

    
    /**
     * Give Attribute lookFrom .
     *
     * @return Attribute lookFrom .
     */
    public Point getLookFrom() {
        return lookFrom;
    }

    
    /**
     * Modify Attribute lookFrom .
     *
     * @param lookFrom new value Attribute lookFrom .
       
     */
    public  void setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
         
    }

    
    /**
     * Give Attribute lookAt .
     *
     * @return Attribute lookAt .
     */
    public Point getLookAt() {
        return lookAt;
    }

    
    /**
     * Modify Attribute lookAt .
     *
     * @param lookAt new value Attribute lookAt .
       
     */
    public  void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
         
    }

    
    /**
     * Give Attribute up .
     *
     * @return Attribute up .
     */
    public Vector getUp() {
        return up;
    }

    
    /**
     * Modify Attribute up .
     *
     * @param up new value Attribute up .
       
     */
    public  void setUp(Vector up) {
        this.up = up;
         
    }

    
    /**
     * Give Attribute ambient .
     *
     * @return Attribute ambient .
     */
    public Color getAmbient() {
        return ambient;
    }

    
    /**
     * Modify Attribute ambient .
     *
     * @param ambient new value Attribute ambient .
       
     */
    public  void setAmbient(Color ambient) {
        this.ambient = ambient;
         
    }

    
    /**
     * Give Attribute diffuse .
     *
     * @return Attribute diffuse .
     */
    public Color getDiffuse() {
        return diffuse;
    }

    
    /**
     * Modify Attribute diffuse .
     *
     * @param diffuse new value Attribute diffuse .
       
     */
    public  void setDiffuse(Color diffuse) {
        this.diffuse = diffuse;
         
    }

    
    /**
     * Give Attribute specular .
     *
     * @return Attribute specular .
     */
    public Color getSpecular() {
        return specular;
    }

    
    /**
     * Modify Attribute specular .
     *
     * @param specular new value Attribute specular .
       
     */
    public  void setSpecular(Color specular) {
        this.specular = specular;
         
    }

    
    /**
     * Give Attribute lights .
     *
     * @return Attribute lights .
     */
    public List<Light> getLights() {
        return lights;
    }

    
    /**
     * Modify Attribute lights .
     *
     * @param lights new value Attribute lights .
       
     */
    public  void setLights(List<Light> lights) {
        this.lights = lights;
         
    }

    
    /**
     * Give Attribute points .
     *
     * @return Attribute points .
     */
    public List<Point> getPoints() {
        return points;
    }

    
    /**
     * Modify Attribute points .
     *
     * @param points new value Attribute points .
       
     */
    public  void setPoints(List<Point> points) {
        this.points = points;
         
    }
    
    /**
     * Give Attribute shapes .
     *
     * @return Attribute shapes .
     */
    public List<IObjectStage> getShapes() {
        return shapes;
    }

    
    /**
     * Modify Attribute shapes .
     *
     * @param shapes new value Attribute shapes .
       
     */
    public  void setShapes(List<IObjectStage> shapes) {
        this.shapes = shapes;
         
    }
}
