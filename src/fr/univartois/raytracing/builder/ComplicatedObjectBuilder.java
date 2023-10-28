/**
 * Project SAE RayTracing.
 *
 * (c) 2023 thibault.lombart
 */

package fr.univartois.raytracing.builder;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.Triplet;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.objects.IObjectStage;
import fr.univartois.raytracing.raythrower.SamplingStrategy;

/**
 * Class ComplicatedObjectBuilder
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class ComplicatedObjectBuilder {
    
	/**
	 * The width of the rendering image.
	 */
	private int sizeX;

	/**
	 * The height of the rendering image.
	 */
	private int sizeY;

	/**
	 * The field of view (FOV) for rendering.
	 */
	private int fov;

	/**
	 * The shininess attribute, representing the material shininess. The default value is 0.
	 */
	private int shininess = 0;

	/**
	 * The maximum number of verts for rendering. The default value is 0.
	 */
	private int maxVerts = 0;

	/**
	 * The name of the output image file. The default value is "output.png."
	 */
	private String name = "output.png";

	/**
	 * The camera's look-from point.
	 */
	private Point lookFrom;

	/**
	 * The camera's look-at point.
	 */
	private Point lookAt;

	/**
	 * The up vector for the camera.
	 */
	private Vector up;

	/**
	 * The ambient color for rendering. The default is black.
	 */
	private Color ambient = new Color(new Triplet(0, 0, 0));

	/**
	 * The diffuse color for rendering. The default is black.
	 */
	private Color diffuse = new Color(new Triplet(0, 0, 0));

	/**
	 * The specular color for rendering. The default is black.
	 */
	private Color specular = new Color(new Triplet(0, 0, 0));

	/**
	 * The list of lights used in the scene.
	 */
	private List<Light> lights = new ArrayList<>();

	/**
	 * The list of points in the scene.
	 */
	private List<Point> points = new ArrayList<>();

	/**
	 * The list of shapes or objects in the scene.
	 */
	private List<IObjectStage> shapes = new ArrayList<>();

	/**
	 * A flag indicating whether shadows should be enabled. The default is false (disabled).
	 */
	private boolean shadow = false;

	/**
	 * The maximum depth for rendering, indicating the level of recursion. The default value is 1.
	 */
	private int maxDepth = 1;
    

    /**
     * The strategy used for sampling during rendering. It is initially set to null.
     */
    private SamplingStrategy samplingStrategy = null;

    /**
     * The number of samples used during rendering. The default value is 0.
     */
    private int samples = 0;

    /**
     * The rendering model. The default value is "Normal."
     */
    private String model = "Normal";

    /**
     * Gets the current rendering model.
     *
     * @return The current rendering model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the rendering model to be used.
     *
     * @param model The rendering model to set.
     */
    public void setModel(String model) {
        this.model = model;
    }
    

    
    
    /**
     * constructor ComplicatedObjectBuilder.
     */
    private ComplicatedObjectBuilder() {
        // 
    }
    
    /**
     * @return new Scene
     */
    public Scene build() {
        return new Scene(this);
    }
    
    /**
     * @return new ComplicatedObjectBuilder
     */
    public static final ComplicatedObjectBuilder newInstance() {
        return new ComplicatedObjectBuilder();
    }
    
    /**
     * @return shadow
     */
    public boolean getShadow() {
        return shadow;
    }
    
    /**
     * @param shadow Boolean shadow true or false
     */
    public void setShadow(boolean shadow) {
        this.shadow = shadow;
    }
    
    
    /**
     * Gets the current sampling strategy used for rendering.
     *
     * @return The current SamplingStrategy for rendering.
     */
    public SamplingStrategy getSamplingStrategy() {
        return samplingStrategy;
    }

    /**
     * Sets the sampling strategy to be used for rendering.
     *
     * @param samplingStrategy The SamplingStrategy to set for rendering.
     */
    public void setSamplingStrategy(SamplingStrategy samplingStrategy) {
        this.samplingStrategy = samplingStrategy;
    }

    /**
     * Gets the number of samples used for rendering.
     *
     * @return The number of samples used for rendering.
     */
    public int getSamples() {
        return samples;
    }

    /**
     * Sets the number of samples to be used for rendering.
     *
     * @param samples The number of samples to set for rendering.
     */
    public void setSamples(int samples) {
        this.samples = samples;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setSizeX(int sizeX) {
        this.sizeX = sizeX;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setSizeY(int sizeY) {
        this.sizeY = sizeY;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setFov(int fov) {
        this.fov = fov;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setShininess(int shininess) {
        this.shininess = shininess;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setMaxVerts(int maxVerts) {
        this.maxVerts = maxVerts;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setName(String name) {
        this.name = name;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setLookAt(Point lookAt) {
        this.lookAt = lookAt;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setUp(Vector up) {
        this.up = up;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setAmbient(Color ambient) {
        this.ambient = ambient;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setDiffuse(Color diffuse) {
        this.diffuse = diffuse;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setSpecular(Color specular) {
        this.specular = specular;
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setLights(List<Light> lights) {
        this.lights = lights;
        return this;
    }

    /**
     * add Attribute light to lights .
     *
     * @param light new value Attribute light .
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder addLight(Light light) {
        this.lights.add(light);
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setPoints(List<Point> points) {
        this.points = points;
        return this;
    }
    
    /**
     * add Attribute point to points .
     *
     * @param point new value Attribute point .
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder addPoint(Point point) {
        this.points.add(point);
        return this;
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
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder setShapes(List<IObjectStage> shapes) {
        this.shapes = shapes;
        return this;
    }
    
    /**
     * add Attribute shape to shapes .
     *
     * @param shape new value Attribute shape .
     * @return ComplicatedObjectBuilder
     */
    public ComplicatedObjectBuilder addShape(IObjectStage shape) {
        this.shapes.add(shape);
        return this;
    }



    /**
     * Sets the maximum depth
     *
     * @param maxDepth The maximum depth
     * @return This ComplicatedObjectBuilder object
     */
    public ComplicatedObjectBuilder setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
        return this;
    }

    /**
     * Gets the maximum depth
     *
     * @return The maximum depth
     */
    public int getMaxDepth() {
        return maxDepth;
    }
    
    
}

