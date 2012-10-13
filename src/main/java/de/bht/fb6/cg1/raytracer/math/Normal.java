package main.java.de.bht.fb6.cg1.raytracer.math;


/**
 * This interface represents a normal.
 *
 * An implementation of this interface is expected to be immutable, so no method call changes the current object.
 *
 * @author Stephan Rehfeld
 */
public interface Normal {

    /**
     * This method multiplies the normal with a scalar value and returns the result.
     *
     * @param rhs The scalar value that should be multiplied with each element of the normal.
     * @return The result of the multiplication. Never returns null.
     */
    public Normal mul( final double rhs );

    /**
     * This method adds a given normal to the current normal and returns the result.
     *
     * @param rhs The normal to add on this normal. Must not be null
     * @return The result. Never returns null.
     */
    public Normal add( final Normal rhs );

    /**
     * This method returns a normals that is pointing in the same direction but hat the magnitude of 1.
     *
     * @return This normal with a normalized length. Never returns null.
     */
    public Normal normalized();

    /**
     * This method reflects a given vector on this normal.
     *
     * @param v The vector to reflect. Must not be null.
     * @return The reflected vector. Never returns null.
     */
    public Vector3D reflect( final Vector3D v );


    /**
     * This method converts this normal to a vector. The vector has the same x, y, and z elements.
     *
     * @return This normal as a vector. Never returns null.
     */
    public Vector3D asVector();

    /**
     * This method converts this normal to a point. The point has the same x, y, and z elements.
     *
     * @return This normal as a point. Never returns null.
     */
    public Point3D asPoint();

    /**
     * This method returns the x element of this normal.
     *
     * @return The x element of this normal.
     */
    public double getX();

    /**
     * This method returns the y element of this normal.
     *
     * @return The y element of this normal.
     */
    public double getY();

    /**
     * This method returns the z element of this normal.
     *
     * @return The z element of this normal.
     */
    public double getZ();
}
