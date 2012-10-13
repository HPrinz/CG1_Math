package main.java.de.bht.fb6.cg1.raytracer.math;

/**
 * This interface represents a 3x3 matrix.
 *
 * An implementation of this interface is expected to be immutable, so no method call changes the current object.
 *
 * @author Stephan Rehfeld
 */
public interface Mat3x3 {

    /**
     * This method creates a new matrix based on the current matrix, but replaces the left column with a given column.
     *
     * @param with The new left column. Must not be null.
     * @return The matrix with the replaced left column. Never returns null.
     */
    public Mat3x3 replaceColumn0( final Vector3D with );

    /**
     * This method creates a new matrix based on the current matrix, but replaces the middle column with a given column.
     *
     * @param with The new middle column. Must not be null.
     * @return The matrix with the replaced middle column. Never returns null.
     */
    public Mat3x3 replaceColumn1( final Vector3D with );

    /**
     * This method creates a new matrix based on the current matrix, but replaces the right column with a given column.
     *
     * @param with The new right column. Must not be null.
     * @return The matrix with the replaced right column. Never returns null.
     */
    public Mat3x3 replaceColumn2( final Vector3D with );

    /**
     * This method multiplies the current matrix with the given matrix and returns the result.
     *
     * @param rhs The left handed side of the operation. Must not be null.
     * @return The result of the matrix multiplication. Never returns null.
     */
    public Mat3x3 mul( final Mat3x3 rhs );

    /**
     * This method multiplied the current matrix with a given point and returns the result.
     *
     * @param rhs The point. Must not be null.
     * @return The result of the multiplication. Never returns null.
     */
    public Point3D mul( final Point3D rhs );

    /**
     * This method multiplied the current matrix with a given vector and returns the result.
     *
     * @param rhs The vector. Must not be null.
     * @return The result of the multiplication. Never returns null.
     */
    public Vector3D mul( final Vector3D rhs );

    /**
     * This method return the determinant of the matrix.
     *
     * @return The determinant of the matrix.
     */
    public double getDeterminant();

}
