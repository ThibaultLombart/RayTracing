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

    /**
     * Adds this Triplet to another Triplet and returns a new Triplet.
     *
     * @param triple The Triplet to add.
     * @return A new Triplet representing the addition of this and the provided Triplet.
     */
    public Triplet addition(Triplet triple) {
        return new Triplet(this.getX() + triple.getX(), this.getY() + triple.getY(), this.getZ() + triple.getZ());
    }

    /**
     * Subtracts another Triplet from this Triplet and returns a new Triplet.
     *
     * @param triple The Triplet to subtract.
     * @return A new Triplet representing the subtraction of this and the provided Triplet.
     */
    public Triplet substraction(Triplet triple) {
        return new Triplet(this.getX() - triple.getX(), this.getY() - triple.getY(), this.getZ() - triple.getZ());
    }

    /**
     * Multiplies this Triplet by a scalar value and returns a new Triplet.
     *
     * @param d The scalar value to multiply with.
     * @return A new Triplet resulting from the scalar multiplication.
     */
    public Triplet scalarMultiplication(double d) {
        return new Triplet(d * this.getX(), d * this.getY(), d * this.getZ());
    }

    /**
     * Calculates the scalar product (dot product) with another Triplet.
     *
     * @param triple The Triplet to calculate the scalar product with.
     * @return The scalar product of this Triplet and the provided Triplet.
     */
    public double scalarProduct(Triplet triple) {
        return (this.getX() * triple.getX() + this.getY() * triple.getY() + this.getZ() * triple.getZ());
    }

    /**
     * Calculates the vector product (cross product) with another Triplet and returns a new Triplet.
     *
     * @param triple The Triplet to calculate the vector product with.
     * @return A new Triplet representing the result of the vector product.
     */
    public Triplet vectorialProduct(Triplet triple) {
        return new Triplet(
            this.getY() * triple.getZ() - this.getZ() * triple.getY(),
            this.getZ() * triple.getX() - this.getX() * triple.getZ(),
            this.getX() * triple.getY() - this.getY() * triple.getX()
        );
    }

    /**
     * Calculates the Schur product (component-wise multiplication) with another Triplet and returns a new Triplet.
     *
     * @param triple The Triplet to calculate the Schur product with.
     * @return A new Triplet representing the result of the Schur product.
     */
    public Triplet schurProduct(Triplet triple) {
        return new Triplet(this.getX() * triple.getX(), this.getY() * triple.getY(), this.getZ() * triple.getZ());
    }

    /**
     * Calculates the length (magnitude) of this Triplet.
     *
     * @return The length of this Triplet.
     */
    public double length() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ());
    }

    /**
     * Standardizes this Triplet to have a length of 1 and returns a new Triplet.
     *
     * @return A new Triplet with a length of 1 representing the standardized vector.
     */
    public Triplet standardization() {
        return scalarMultiplication(1 / this.length());
    }
}
