package main.java.de.bht.fb6.cg1.raytracer.math.impl;

import main.java.de.bht.fb6.cg1.raytracer.math.Normal;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;

/**
 * This class represents a normal-vector. It is immutable, so no method call
 * changes the current object.
 * 
 * @author Hanna Prinz
 */
public class NormalImpl implements Normal {

  /**
   * the x-coordinate of the normal.
   */
  private final double x;

  /**
   * the y-coordinate of the normal.
   */
  private final double y;

  /**
   * the z-coordinate of the normal.
   */
  private final double z;

  /**
   * The constructor for a normal.
   * 
   * @param x
   *          the x-coordinate of the normal.
   * @param y
   *          the y-coordinate of the normal.
   * @param z
   *          the z-coordinate of the normal.
   */
  public NormalImpl(final double x, final double y, final double z) {
    this.x = x;
    this.y = y;
    this.z = z;
    // test
  }

  @Override
  public Normal add(final Normal normal) {
    double newX = this.x + normal.getX();
    double newY = this.y + normal.getY();
    double newZ = this.z + normal.getZ();
    return new NormalImpl(newX, newY, newZ);
  }

  @Override
  public Point3D asPoint() {
    return new Point3DImpl(this.x, this.y, this.z);
  }

  @Override
  public Vector3D asVector() {
    return new Vector3DImpl(this.x, this.y, this.z);
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
  public Normal mul(final double factor) {
    double newX = this.x * factor;
    double newY = this.y * factor;
    double newZ = this.z * factor;
    return new NormalImpl(newX, newY, newZ);
  }

  @Override
  public Normal normalized() {
    // see http://oberprima.com/mathematik/vektoren-normieren-541/
    final double skalar = this.asVector().getMagnitude();
    final double newX = this.getX() / skalar;
    final double newY = this.getY() / skalar;
    final double newZ = this.getZ() / skalar;
    return new NormalImpl(newX, newY, newZ);
  }

  @Override
  public Vector3D reflect(final Vector3D vec) {
    Normal n = this.normalized();
    Double dot = vec.dot(n);
    Double newX = vec.getX() - Math.round(2 * dot * n.getX());
    Double newY = vec.getY() - Math.round(2 * dot * n.getY());
    Double newZ = vec.getZ() - Math.round(2 * dot * n.getZ());
    return new Vector3DImpl(newX, newY, newZ);
  }

  @Override
  public String toString() {
    return "NormalImpl [x=" + x + ", y=" + y + ", z=" + z + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(x);
    result = prime * result + (int) (temp ^ temp >>> 32);
    temp = Double.doubleToLongBits(y);
    result = prime * result + (int) (temp ^ temp >>> 32);
    temp = Double.doubleToLongBits(z);
    result = prime * result + (int) (temp ^ temp >>> 32);
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    NormalImpl other = (NormalImpl) obj;
    if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
      return false;
    }
    if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
      return false;
    }
    if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z)) {
      return false;
    }
    return true;
  }
}
