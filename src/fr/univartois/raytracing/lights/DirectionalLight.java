package fr.univartois.raytracing.lights;

public class DirectionalLight extends Light{
	
	private Vector vector;
	
	public DirectionalLight(Color color, Vector vector) {
		super(color);
		this.vector = vector;
	}

	public Vector getVector() {
		return vector;
	}
	
	public void setVector(Vector vector) {
		this.vector = vector;
	}

	public void setVector(double x, double y, double z) {
		this.vector = new Triplet(x,y,z);
	}
	
}
