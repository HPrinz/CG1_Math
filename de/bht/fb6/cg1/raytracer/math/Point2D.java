package de.bht.fb6.cg1.raytracer.math;


/**
 * This interface represents a 2D point.
 *
 * An implementation of this interface is expected to be immutable, so no method call changes the current object.
 *
 * @author Stephan Rehfeld
 */
public interface Point2D {


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

}
