package de.bht.fb6.cg1.raytracer.math;

import de.bht.fb6.cg1.raytracer.math.Point3D;
import de.bht.fb6.cg1.raytracer.math.Ray;
import de.bht.fb6.cg1.raytracer.math.Vector3D;

/**
 * This class represents a ray.
 * It is immutable, so no method call changes the current object.
 *
 * @author Hanna Prinz
 */

public class RayImpl implements Ray {
	
	/**
	 * The origin of the Ray, a Point.
	 */
	private final Point3D origin;
	
	/**
	 * The direction of the Ray, a Vector3D.
	 */
	private final Vector3D direction;

	/**
	 * The constructor for a ray.
	 * @param origin The origin. Must not be null!
	 * @param direction The direction. Must not be null!
	 */
	public RayImpl(final Point3D origin, final Vector3D direction){
		this.origin = origin;
		this.direction = direction;
	}
	
	@Override
	public Point3D at(final double t) {
		Double x = origin.getX() + t * direction.getX();
		Double y = origin.getY() + t * direction.getY();
		Double z = origin.getZ() + t * direction.getZ();
		return new Point3DImpl(x, y, z);
	}

	@Override
	public Vector3D getDirection() {
		return direction;
	}

	@Override
	public Point3D getOrigin() {
		return origin;
	}

	@Override
	public double tOf(final Point3D a) {
		Double d = a.sub(origin).dot(a.asNormal());
		Double e = direction.dot(a.asNormal());
		return d/e;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
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
		RayImpl other = (RayImpl) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RayImpl [origin=" + origin + ", direction=" + direction + "]";
	}
}
