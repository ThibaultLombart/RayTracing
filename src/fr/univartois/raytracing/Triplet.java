package fr.univartois.raytracing;

/**
 * The Triplet class represents a three-dimensional point or vector.
 */
public class Triplet {
    private double x;
    private double y;
    private double z;

    /**
     * Initializes a Triplet with the specified x, y, and z coordinates.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     */
    public Triplet(double x, double y, double z) { 
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the x-coordinate of the Triplet.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the Triplet.
     *
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }
    
    /**
     * Gets the z-coordinate of the Triplet.
     *
     * @return The z-coordinate.
     */
    public double getZ() {
        return z;
    }

	/*
	 * This method is used to make an addition between two triples.
	 */
	

	public Triplet addition(Triplet triple) {
		return new Triplet(this.x+triple.getX(),this.y+triple.getY(),this.z+triple.getZ());
	}
	
	/*
	 * This method is used to make a substraction between two triples.
	 */

	public Triplet substraction(Triplet triple) {
		return new Triplet(this.x-triple.getX(),this.y-triple.getY(),this.z-triple.getZ());
	}
	

	/*
	 * This method is used to make a multiplication of a triple with a scalar.
	 */
	
	public Triplet scalarMultiplication(double d) {
		return new Triplet(this.x*d,this.y*d,this.z*d);
	}
	
	
	/*
	 * This method is used to make the scalar product between two triples.
	 */
	public double scalarProduct(Triplet triple) {
		return (this.x*triple.getX()+this.y*triple.getY()+this.z*triple.getZ());
	}
	
	
	/*
	 * This method is used to make the vertical product between two triples.
	 */
	public Triplet vectorialProduct(Triplet triple) {
		return new Triplet(this.y*triple.getZ()-this.z*triple.getY(),
		                   this.z*triple.getX()-this.x*triple.getZ(),
		                   this.x*triple.getY()-this.y*triple.getX());
	}
	
	/*
	 * This method is used to make the schur product between two triples.
	 */
	
	public Triplet schurProduct(Triplet triple) {
		return new Triplet(this.x*triple.getX(),this.y*triple.getY(),this.z*triple.getZ());
	}
	
	/*
	 * This method is used to get the length/standard of a triple.
	 */
	
	public double length() {
		return (Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z));
	}
	
	/*
	 * This method is used to get the normalization of a triplet
	 */
	
	public Triplet standardization() {
		return (this.scalarMultiplication(1/this.length()));
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    return "" + this.x + " " + this.y + " " + this.z;
	}

}