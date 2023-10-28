package fr.univartois.raytracing.lights.decorator;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.raytracing.Scene;
import fr.univartois.raytracing.digital.triples.Color;
import fr.univartois.raytracing.digital.triples.Point;
import fr.univartois.raytracing.digital.triples.Vector;
import fr.univartois.raytracing.lights.Light;
import fr.univartois.raytracing.lights.strategy.IStrategyLight;
import fr.univartois.raytracing.objects.IObjectStage;

public class BlinnPhongLight extends BlinnPhongLightingDecorator implements IStrategyLight{

	List<Light> lights = new ArrayList<>();
    Scene scene;
	
	public BlinnPhongLight(List<Light> list, Scene scene, LambertLight decorator) {
		super(decorator);
		this.lights = list;
		this.scene = scene;
	}
	
	/**
	 * @param shape
	 * @return Color
	 */
	public Color calculateBlinnPhong(IObjectStage shape, Light light, Point p, Vector d) {
	    
		Vector ldir = light.getLdir(p);
	    Vector n = shape.getN(p);
	    Vector eyedir = d.multiplication(-1);
	    Vector h = ldir.add(eyedir).standardization();

	    return shape.getSpecular().schur(light.getColor().multiplication(Math.pow(Math.max(n.scalarProduct(h),0),shape.getShininess())));
	}
	
	public List<Light> getLights() {
		return lights;
	}

	public void setLights(List<Light> lights) {
	    this.lights = lights;
	}
	
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.raytracing.lights.LightingModel#calculateColor(fr.univartois.raytracing.objects.IObjectStage, fr.univartois.raytracing.digital.triples.Vector)
     */
    @Override
	public Color calculateColor(IObjectStage shape, Vector toLight, Point p) {

    	
        Color sommeColorLambert = super.calculateColor(shape, toLight, p);
        Color sommeColorBlinnPhong = calculateBlinnPhong(shape, lights.get(0),p, toLight);
        Color sommeColor;
        for (int i = 1; i < lights.size(); i++) {
            sommeColorBlinnPhong = sommeColorBlinnPhong.add(calculateBlinnPhong(shape, lights.get(i),p,toLight));
        }
        sommeColor = sommeColorLambert.add(sommeColorBlinnPhong);
        return sommeColor;
    }
    
}
