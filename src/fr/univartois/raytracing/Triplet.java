package fr.univartois.raytracing;

/*
 * Each comment is targeting the code just ABOVE.
 */

public class Triplet {
	private double x;
	private double y;
	private double z;
	
	/*
	 * Here is the initialization of the attributes x,y,z which are used to make the triple.
	 */
	
	public Triplet(double x, double y, double z) { 
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/*
	 * Here is the constructor of the triple with the 3 attributes we declared before.
	 */
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	/*
	 * Here are the 3 getters used to get each values of each points later in the methods.
	 */


	public Triplet addition(Triplet triple) {
		return new Triplet(this.getX()+triple.getX(),this.getY()+triple.getY(),this.getZ()+triple.getZ());
	}
	
	/*
	 * This method is used to make an addition between two triples.
	 */
	
	public Triplet substraction(Triplet triple) {
		return new Triplet(this.getX()-triple.getX(),this.getY()-triple.getY(),this.getZ()-triple.getZ());
	}
	
	/*
	 * This method is used to make a substraction between two triples.
	 */
	
	public Triplet scalarMultiplication(double d) {
		return new Triplet(d*this.getX(),d*this.getY(),d*this.getZ());
	}
	
	/*
	 * This method is used to make a multiplication of a triple with a scalar.
	 */
	
	public double scalarProduct(Triplet triple) {
		return (this.getX()*triple.getX()+this.getY()*triple.getY()+this.getZ()*triple.getZ());
	}
	
	/*
	 * This method is used to make the scalar product between two triples.
	 */
	
	public Triplet vectorialProduct(Triplet triple) {
		return new Triplet(this.getY()*triple.getZ()-this.getZ()*triple.getY(),this.getZ()*triple.getX()-this.getX()*triple.getZ(),this.getX()*triple.getY()-this.getY()*triple.getX());
	}
	
	/*
	 * This method is used to make the vertical product between two triples.
	 */
	
	public Triplet schurProduct(Triplet triple) {
		return new Triplet(this.getX()*triple.getX(),this.getY()*triple.getY(),this.getZ()*triple.getZ());
	}
	
	/*
	 * This method is used to make the schur product between two triples.
	 */
	
	public double length() {
		return (Math.sqrt(this.getX()*this.getX()+this.getY()*this.getY()+this.getZ()*this.getZ()));
	}
	
	/*
	 * This method is used to get the length/standard of a triple.
	 */
	
	public Triplet standardization() {
		return scalarMultiplication((1/this.length()));
	}
	
	/*
	 * This method is used to make the standardization of a triple.
	 */
}