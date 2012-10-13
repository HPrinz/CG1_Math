package de.bht.fb6.cg1.raytracer.math;

import de.bht.fb6.cg1.raytracer.math.Normal;
import de.bht.fb6.cg1.raytracer.math.Point3D;
import de.bht.fb6.cg1.raytracer.math.Vector3D;

/**
 * This class represents a 3D point.
 * It is immutable, so no method call changes the current object.
 *
 * @author Hanna Prinz
 */

public class Point3DImpl implements Point3D {
	
	/**
	 * the x-coordinate of the 3D point.
	 */
	private final double x;
	
	/**
	 * the y-coordinate of the 3D point.
	 */
	private final double y;
	
	/**
	 * the z-coordinate of the 3D point.
	 */
	private final double z;
	
	/**
	 * The constructor for a 3D point.
	 * @param x the x-coordinate of the 3D point.
	 * @param y the y-coordinate of the 3D point.
	 * @param z the z-coordinate of the 3D point.
	 */
	public Point3DImpl(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public Point3D add(final Vector3D vector) {
		double newX = this.x + vector.getX();
		double newY = this.y + vector.getY();
		double newZ = this.z + vector.getZ();
		return new Point3DImpl(newX, newY, newZ);
	}

	@Override
	public Normal asNormal() {
		return new NormalImpl(this.x, this.y, this.z);
	}

	@Override
	public Vector3D asVector() {
		return new Vector3DImpl(this.x, this.y, this.z);
	}

	@Override
	public double dot(final Normal normal) {
		// see http://upload.wikimedia.org/wikipedia/de/math/5/f/d/5fd9e04d662dbc75094beee5cb854d6a.png
		final double newX = this.getX() * normal.getX();
		final double newY = this.getY() * normal.getY();
		final double newZ = this.getZ() * normal.getZ();
		
		return newX + newY + newZ;
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
	public double getZ() {
		return z;
	}

	@Override
	public Vector3D sub(final Point3D point) {
		// see http://upload.wikimedia.org/wikipedia/de/math/a/9/9/a99a0ac4c022d6bb1fc2806eb3cd4324.png
		final double newX = this.getX() - point.getX() ;
		final double newY = this.getY() - point.getY() ;
		final double newZ = this.getZ() - point.getZ() ;
		
		return new Vector3DImpl(newX, newY, newZ);
	}

	@Override
	public Point3D sub(final Vector3D vector) {
		// see http://upload.wikimedia.org/wikipedia/de/math/a/9/9/a99a0ac4c022d6bb1fc2806eb3cd4324.png
		final double newX = this.getX() - vector.getX() ;
		final double newY = this.getY() - vector.getY() ;
		final double newZ = this.getZ() - vector.getZ() ;
		
		return new Point3DImpl(newX, newY, newZ);
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
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3DImpl other = (Point3DImpl) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point3DImpl [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
