package de.bht.fb6.cg1.raytracer.math;


/**
 * This interface represents a ray.
 *
 * An implementation of this interface is expected to be immutable, so no method call changes the current object.
 *
 * @author Stephan Rehfeld
 */
public interface Ray {

    /**
     * This method returns a point on the way for a given parameter t.
     *
     * @param t The parameter t.
     * @return The point on the ray at the parameter t. Never returns null.
     */
    public Point3D at( final double t );

    /**
     * This method returns a t for a given point on the ray.
     *
     * @param point The point. Must not be null.
     * @return The t parameter of the given point.
     */
    public double tOf( final Point3D point );

    /**
     * This method returns the origin of the ray.
     *
     * @return The origin of the ray. Never returns null.
     */
    public Point3D getOrigin();

    /**
     * This method returns the direction of the ray.
     *
     * @return The direction of the ray. Never returns null.
     */
    public Vector3D getDirection();
}
