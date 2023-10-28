package fr.univartois.raytracing.digital.triples;

import fr.univartois.raytracing.Triplet;

/**
 * The Point class represents a point in a three-dimensional space using a Triplet.
 */
public class Point {
    private Triplet triplet;

    /**
     * Constructs a Point object with the specified Triplet.
     *
     * @param triplet The Triplet representing the point's coordinates.
     */
    public Point(Triplet triplet) {
        this.triplet = triplet;
    }


/**
 * Sets the Triplet for this Point.
 *
 * @param triplet The Triplet to set as the new coordinates for the point.
 */
public void setTriplet(Triplet triplet) {
    this.triplet = triplet;
}

/**
 * Calculates the vector representing the subtraction of another Point from this Point.
 *
 * @param otherPoint The Point to subtract from this Point.
 * @return A Vector representing the subtraction of the two Points.
 */
public Vector substraction(Point otherPoint) {
    return new Vector(this.triplet.substraction(otherPoint.getTriplet()));
}

/**
 * Multiplies the coordinates of this Point by a scalar value and returns a new Point.
 *
 * @param d The scalar value to multiply with.
 * @return A new Point resulting from the scalar multiplication.
 */
public Point multiplication(Double d) {
    return new Point(this.triplet.scalarMultiplication(d));
}
	
    /**
     * Retrieves the Triplet associated with this Point.
     *
     * @return The Triplet representing the point's coordinates.
     */
    public Triplet getTriplet() {
        return triplet;
    }
    
	@Override
    public String toString() {
        return this.triplet.toString();
	}
}