package fr.univartois.raytracing.lights;

public class LocalLight extends Light{
	
	private Point point;
	
	public LocalLight(Color color, Point point) {
		super(color);
		this.point = point;
	}

	public Point getVector() {
		return point;
	}
	
	public void setVector(Point point) {
		this.point = point;
	}

	public void setVector(double x, double y, double z) {
		this.point = new Point(x,y,z);
	}
	
}
