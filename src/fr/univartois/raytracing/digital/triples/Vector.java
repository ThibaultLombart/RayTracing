package fr.univartois.raytracing.digital.triples;

import fr.univartois.raytracing.Triplet;

/**
 * The Vector class represents a vector in a three-dimensional space using a Triplet.
 */
public class Vector {
    private Triplet triplet;

    /**
     * Constructs a Vector object with the specified Triplet.
     *
     * @param triplet The Triplet representing the vector's components.
     */
    public Vector(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Retrieves the Triplet associated with this Vector.
     *
     * @return The Triplet representing the vector's components.
     */
    public Triplet getTriplet() {
        return triplet;
    }

    /**
     * Sets the Triplet for this Vector.
     *
     * @param triplet The Triplet to set as the new components for the vector.
     */
    public void setTriplet(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Adds another Vector to this Vector and returns a new Vector.
     *
     * @param otherVector The Vector to add.
     * @return A new Vector representing the sum of this and the other Vector.
     */
    public Vector add(Vector otherVector) {
        return new Vector(this.triplet.addition(otherVector.getTriplet()));
    }

    /**
     * Adds a Point to this Vector and returns a new Point.
     *
     * @param otherPoint The Point to add to this Vector.
     * @return A new Point resulting from the addition of this Vector and the Point.
     */
    public Point add(Point otherPoint) {
        return new Point(this.triplet.addition(otherPoint.getTriplet()));
    }

    /**
     * Subtracts another Vector from this Vector and returns a new Vector.
     *
     * @param otherVector The Vector to subtract.
     * @return A new Vector representing the result of the subtraction.
     */
    public Vector substraction(Vector otherVector) {
        return new Vector(this.triplet.substraction(otherVector.getTriplet()));
    }

    /**
     * Multiplies each component of this Vector by a scalar value and returns a new Vector.
     *
     * @param d The scalar value to multiply with.
     * @return A new Vector resulting from the scalar multiplication.
     */
    public Vector multiplication(double d) {
        return new Vector(this.triplet.scalarMultiplication(d));
    }

    /**
     * Calculates the scalar product (dot product) with another Vector.
     *
     * @param otherVector The Vector to calculate the scalar product with.
     * @return The scalar product of this Vector and the other Vector.
     */
    public double scalarProduct(Vector otherVector) {
        return this.triplet.scalarProduct(otherVector.getTriplet());
    }

    /**
     * Calculates the vector product (cross product) with another Vector and returns a new Vector.
     *
     * @param otherVector The Vector to calculate the vector product with.
     * @return A new Vector representing the result of the vector product.
     */
    public Vector vectorProduct(Vector otherVector) {
        return new Vector(this.triplet.vectorialProduct(otherVector.getTriplet()));
    }

    /**
     * Calculates the length (magnitude) of this Vector.
     *
     * @return The length of this Vector.
     */
    public double length() {
        return this.triplet.length();
    }

    /**
     * Standardizes the Vector to have a length of 1 and returns a new Vector.
     *
     * @return A new Vector with a length of 1 representing the standardized vector.
     */
    public Vector standardization() {
        return new Vector(this.triplet.standardization());
    }
}
