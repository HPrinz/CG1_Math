package main.java.de.bht.fb6.cg1.raytracer.math.impl;

import main.java.de.bht.fb6.cg1.raytracer.math.Point2D;

/**
 * This class represents a 2D point.
 * It is immutable, so no method call changes the current object.
 *
 * @author Hanna Prinz
 */

public class Point2DImpl implements Point2D {

	/**
	 * the x-coordinate of the 2D point
	 */
	private final double x;
	
	/**
	 * the y-coordinate of the 2D point
	 */
	private final double y;

	/**
	 * The constructor for a 2D point
	 * @param x the x-coordinate of the 2D point
	 * @param y the y-coordinate of the 2D point
	 */
	public Point2DImpl(final double x, final double y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2DImpl other = (Point2DImpl) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point2DImpl [x=" + x + ", y=" + y + "]";
	}
}
