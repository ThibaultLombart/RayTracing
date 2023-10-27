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

/**
 * Class ComplicatedObjectBuilder
 *
 * @author thibault.lombart
 *
 * @version 0.1.0
 */
public class ComplicatedObjectBuilder {
    
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
    
    /**
     * Shadow Attribute 
     */
    private boolean shadow = false;
    
    private String model = "Normal";
    
    
    public String getModel() {
        return model;
    }



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
    
    
}

