package de.bht.fb6.cg1.raytracer.math;

/**
 * This interface represents a 3d point.
 *
 * An implementation of this interface is expected to be immutable, so no method call changes the current object.
 *
 * @author Stephan Rehfeld
 */
public interface Point3D {

    /**
     * This method adds a vector to this point and returns the result as a point.
     *
     * @param rhs The vector that should be added to this point. Must not be null.
     * @return The resulting point. Never returns null.
     */
    public Point3D add( final Vector3D rhs );

    /**
     * This method subtracts a point from this point and returns the result as a vector.
     *
     * @param rhs The point that should be subtracted from this point. Must not be null.
     * @return The resulting vector. Never returns null.
     */
    public Vector3D sub( final Point3D rhs );

    /**
     * This method subtracts a vector from this point and returns the result as a point.
     *
     * @param rhs The vector that should be subtracted this point. Must not be null.
     * @return The resulting point. Never returns null.
     */
    public Point3D sub( final Vector3D rhs );

    /**
     * This method calculated the dot product between this point and a given normal.
     *
     * @param rhs The right handed side of this operation. Must not be null.
     * @return The dot product between this point and the normal. Never returns null.
     */
    public double dot( final Normal rhs );

    /**
     * This method converts this point to a vector. The vector has the same x, y, and z elements.
     *
     * @return This point as a vector. Never returns null.
     */
    public Vector3D asVector();

    /**
     * This method converts this point to a normal. The normal has the same x, y, and z elements.
     *
     * @return This point as a normal. Never returns null.
     */
    public Normal asNormal();

    /**
     * This method returns the x element of this point.
     *
     * @return The x element of this point.
     */
    public double getX();

    /**
     * This method returns the y element of this point.
     *
     * @return The y element of this point.
     */
    public double getY();

    /**
     * This method returns the z element of this point.
     *
     * @return The z element of this point.
     */
    public double getZ();
}
