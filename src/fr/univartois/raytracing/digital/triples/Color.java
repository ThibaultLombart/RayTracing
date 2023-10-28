package fr.univartois.raytracing.digital.triples;

import fr.univartois.raytracing.Triplet;

/**
 * The Color class represents a color in a three-dimensional space using a Triplet.
 */
public class Color {
    private Triplet triplet;

    /**
     * Constructs a Color object with the specified Triplet.
     *
     * @param triplet The Triplet representing the color.
     */
    public Color(Triplet triplet) {
        this.triplet = triplet;
    }


    /**
     * Sets the Triplet for this Color.
     *
     * @param triplet The Triplet to set.
     */
    public void setTriplet(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Adds the components of another Color to this Color and returns a new Color.
     *
     * @param otherColor The Color to add.
     * @return A new Color representing the sum of this and the other Color.
     */
    public Color add(Color otherColor) {
        return new Color(this.triplet.addition(otherColor.getTriplet()));
    }

    /**
     * Multiplies each component of this Color by a scalar value and returns a new Color.
     *
     * @param d The scalar value to multiply with.
     * @return A new Color resulting from the scalar multiplication.
     */
    public Color multiplication(Double d) {
        return new Color(this.triplet.scalarMultiplication(d));
    }

    /**
     * Performs the Schur product (component-wise multiplication) with another Color and returns a new Color.
     *
     * @param otherColor The Color to perform the Schur product with.
     * @return A new Color representing the Schur product of this and the other Color.
     */
    public Color schur(Color otherColor) {
        return new Color(this.triplet.schurProduct(otherColor.getTriplet()));
    }
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    return this.triplet.toString();
	}

    /**
     * Retrieves the Triplet associated with this Color.
     *+
     * @return The Triplet representing the color.
     */
    public Triplet getTriplet() {
        return triplet;
    }
}