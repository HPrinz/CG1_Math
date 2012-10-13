package de.bht.fb6.cg1.raytracer.math;


/**
 * This interface represents a 3d vector.
 *
 * An implementation of this interface is expected to be immutable, so no method call changes the current object.
 *
 * @author Stephan Rehfeld
 */
public interface Vector3D {

    /**
     * This method returns the magnitude of this. vector.
     *
     * @return The magnitude of this vector.
     */
    public double getMagnitude();

    /**
     * This method adds a vector to this vector and returns the result as a vector.
     *
     * @param rhs The vector that should be added to this vector. Must not be null.
     * @return The sum of both vectors. Never returns null.
     */
    public Vector3D add( final Vector3D rhs );

    /**
     * This method adds a normal to this vector and returns the result as a vector.
     *
     * @param rhs The normal that should be added to this vector. Must not be null.
     * @return The sum of this vector and the normal. Never returns null.
     */
    public Vector3D add( final Normal rhs );

    //public Vector3D add( final Point3D rhs );

    /**
     * This method subtracts a vector from this vector and returns the result as a vector.
     *
     * @param rhs The vector that should be added to this vector. Must not be null.
     * @return The result of the operation. Never returns null.
     */
    public Vector3D sub( final Vector3D rhs );

    /**
     * This methods multiples the elements of this vector with a scalar und return the result as a vector.
     *
     * @param rhs The factor.
     * @return The vector that was multiplied with the factor.
     */
    public Vector3D mul( final double rhs );

    /**
     * This methods divides the elements of this vector by a scalar und return the result as a vector.
     *
     * @param rhs The divisor.
     * @return The vector that was divided by the divisor.
     */
    public Vector3D div( final double rhs );

    /**
     * This method calculated the dot product between this vector and a given normal.
     *
     * @param rhs The right handed side of this operation. Must not be null.
     * @return The dot product between this vector and the normal. Never returns null.
     */
    public double dot( final Normal rhs );

    /**
     * This method calculated the dot product between this vector and a given vector.
     *
     * @param rhs The right handed side of this operation. Must not be null.
     * @return The dot product between this vector and the given vector. Never returns null.
     */
    public double dot( final Vector3D rhs );

    /**
     * This method calculated the cross product between this vector and a given vector and returns the result.
     *
     * @param rhs The other vector. Must not be null.
     * @return The cross product between both vectors. Must not be null.
     */
    public Vector3D cross( final Vector3D rhs );

    /**
     * This method converts this vector to a normal. The normal has the same x, y, and z elements.
     *
     * @return This vector as a normal. Never returns null.
     */
    public Normal asNormal();

    /**
     * This method converts this vector to a point. The point has the same x, y, and z elements.
     *
     * @return This vector as a point. Never returns null.
     */
    public Point3D asPoint();

    /**
     * This method returns a vector that is pointing in the same direction but hat the magnitude of 1.
     *
     * @return This vector with a normalized length. Never returns null.
     */
    public Vector3D normalized();

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
