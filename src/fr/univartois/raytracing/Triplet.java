package fr.univartois.raytracing;

public class Triplet {
	private double X;
	private double Y;
	private double Z;
	
	public Triplet(double x, double y, double z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
	public double getX() {
		return X;
	}

	public double getY() {
		return Y;
	}

	public double getZ() {
		return Z;
	}


	public Triplet addition(Triplet triple) {
		return new Triplet(this.getX()+triple.getX(),this.getY()+triple.getY(),this.getZ()+triple.getZ());
	}
	
	public Triplet substraction(Triplet triple) {
		return new Triplet(this.getX()-triple.getX(),this.getY()-triple.getY(),this.getZ()-triple.getZ());
	}
	
	public Triplet scalarMultiplication(double d) {
		return new Triplet(d*this.getX(),d*this.getY(),d*this.getZ());
	}
	
	public double scalarProduct(Triplet triple) {
		return (this.getX()*triple.getX()+this.getY()*triple.getY()+this.getZ()*triple.getZ());
	}
	
	public Triplet vectorialProduct(Triplet triple) {
		return new Triplet(this.getY()*triple.getZ()-this.getZ()*triple.getY(),this.getZ()*triple.getX()-this.getX()*triple.getZ(),this.getX()*triple.getY()-this.getY()*triple.getX());
	}
	
	public Triplet schurProduct(Triplet triple) {
		return new Triplet(this.getX()*triple.getX(),this.getY()*triple.getY(),this.getZ()*triple.getZ());
	}
	
	public double length() {
		return (Math.sqrt(this.getX()*this.getX()+this.getY()*this.getY()+this.getZ()*this.getZ()));
	}
	
	public Triplet standardization() {
		return scalarMultiplication((1/this.length()));
	}
}