package main.java.de.bht.fb6.cg1.raytracer.math.impl;

import main.java.de.bht.fb6.cg1.raytracer.math.Normal;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;

/**
 * This class represents a 3D vector.
 * It is immutable, so no method call changes the current object.
 *
 * @author Hanna Prinz
 */
public class Vector3DImpl implements Vector3D {
	
	/**
	 * the x-coordinate of the 3D vector.
	 */
	private final double x;
	
	/**
	 * the y-coordinate of the 3D vector.
	 */
	private final double y;
	
	/**
	 * the z-coordinate of the 3D vector.
	 */
	private final double z;
	
	/**
	 * The constructor for a 3D vector.
	 * @param x the x-coordinate of the 3D vector.
	 * @param y the y-coordinate of the 3D vector.
	 * @param z the z-coordinate of the 3D vector.
	 */
	public Vector3DImpl(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public Vector3D add(final Vector3D vector) {
		double newX = this.x + vector.getX();
		double newY = this.y + vector.getY();
		double newZ = this.z + vector.getZ();
		return new Vector3DImpl(newX, newY, newZ);
	}

	@Override
	public Vector3D add(final Normal normal) {
		double newX = this.x + normal.getX();
		double newY = this.y + normal.getY();
		double newZ = this.z + normal.getZ();
		return new Vector3DImpl(newX, newY, newZ);
	}

	@Override
	public Normal asNormal() {
		return new NormalImpl(this.x, this.y, this.z);
	}

	@Override
	public Point3D asPoint() {
		return new Point3DImpl(this.x, this.y, this.z);
	}

	@Override
	public Vector3D cross(final Vector3D vector) {
		// see http://upload.wikimedia.org/wikipedia/de/math/0/e/2/0e2a0d00bd71133647556851d8e0f293.png
		final double newX = (this.getY() * vector.getZ()) - (this.getZ() * vector.getY());
		final double newY = (this.getZ() * vector.getX()) - (this.getX() * vector.getZ());
		final double newZ = (this.getX() * vector.getY()) - (this.getY() * vector.getX());
		
		return new Vector3DImpl(newX, newY, newZ);
	}

	@Override
	public Vector3D div(final double skalar) {
		final double newX = this.getX() / skalar ;
		final double newY = this.getY() / skalar ;
		final double newZ = this.getZ() / skalar ;
		
		return new Vector3DImpl(newX, newY, newZ);
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
	public double dot(final Vector3D vector) {
		// see http://upload.wikimedia.org/wikipedia/de/math/5/f/d/5fd9e04d662dbc75094beee5cb854d6a.png
		final double newX = this.getX() * vector.getX();
		final double newY = this.getY() * vector.getY();
		final double newZ = this.getZ() * vector.getZ();
		
		return newX + newY + newZ;
	}

	@Override
	public double getMagnitude() {
		// see http://upload.wikimedia.org/wikipedia/de/math/7/6/1/76136352566425601d8f3d430605fd34.png
		final double newX = this.getX() * this.getX();
		final double newY = this.getY() * this.getY();
		final double newZ = this.getZ() * this.getZ();
		
		return Math.sqrt(newX + newY + newZ);
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
	public Vector3D mul(final double skalar) {
		// see http://upload.wikimedia.org/wikipedia/de/math/5/6/d/56dc8d7eb69d4bc21c6e834674dd8904.png
		final double newX = this.getX() * skalar ;
		final double newY = this.getY() * skalar ;
		final double newZ = this.getZ() * skalar ;
		
		return new Vector3DImpl(newX, newY, newZ);
	}

	@Override
	public Vector3D normalized() {
		// see http://oberprima.com/mathematik/vektoren-normieren-541/
		return this.div(this.getMagnitude());
	}

	@Override
	public Vector3D sub(final Vector3D vector) {
		// see http://upload.wikimedia.org/wikipedia/de/math/a/9/9/a99a0ac4c022d6bb1fc2806eb3cd4324.png
		final double newX = this.getX() - vector.getX() ;
		final double newY = this.getY() - vector.getY() ;
		final double newZ = this.getZ() - vector.getZ() ;
		
		return new Vector3DImpl(newX, newY, newZ);
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector3DImpl other = (Vector3DImpl) obj;
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
		return "Vector3DImpl [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
