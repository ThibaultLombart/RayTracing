package fr.univartois.raytracing;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.objects.IObjectStage;

public class Scene {
	
	private int sizeX;
	private int sizeY;
	private int fov;
	private int shininess = 0;
	private int maxVerts = 0; 
	private String name = "output.png";
	private Triplet lookFrom;
	private Triplet lookAt;
	private Triplet up;
	private Color ambient = new Color(new Triplet(0,0,0));
	private Color diffuse = new Color(new Triplet(0,0,0));
	private Color specular = new Color(new Triplet(0,0,0));
	private List<Light> lights = new ArrayList<Light>();
	private List<Point> points = new ArrayList<Point>();
	private List<IObjectStage> shapes = new ArrayList<IObjectStage>();
	
	public Scene(int sizeX, int sizeY, String name, Triplet lookFrom, Triplet lookAt, Triplet up, int fov) {
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.name = name;
		this.lookFrom=lookFrom;
		this.lookAt=lookAt;
		this.up=up;
		this.fov=fov;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getFov() {
		return fov;
	}

	public void setFov(int fov) {
		this.fov = fov;
	}

	public int getShininess() {
		return shininess;
	}

	public void setShininess(int shininess) {
		this.shininess = shininess;
	}

	public int getMaxVerts() {
		return maxVerts;
	}

	public void setMaxVerts(int maxVerts) {
		this.maxVerts = maxVerts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Triplet getLookFrom() {
		return lookFrom;
	}

	public void setLookFrom(Triplet lookFrom) {
		this.lookFrom = lookFrom;
	}

	public Triplet getLookAt() {
		return lookAt;
	}

	public void setLookAt(Triplet lookAt) {
		this.lookAt = lookAt;
	}

	public Triplet getUp() {
		return up;
	}

	public void setUp(Triplet up) {
		this.up = up;
	}

	public Color getAmbient() {
		return ambient;
	}

	public void setAmbient(Color ambient) {
		this.ambient = ambient;
	}

	public Color getDiffuse() {
		return diffuse;
	}

	public void setDiffuse(Color diffuse) {
		this.diffuse = diffuse;
	}

	public Color getSpecular() {
		return specular;
	}

	public void setSpecular(Color specular) {
		this.specular = specular;
	}

	public List<Light> getLights() {
		return lights;
	}

	public void setLights(ArrayList<Light> lights) {
		this.lights = lights;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public List<IObjectStage> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<IObjectStage> shapes) {
		this.shapes = shapes;
	}
}
