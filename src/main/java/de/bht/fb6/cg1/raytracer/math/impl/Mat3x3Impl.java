package main.java.de.bht.fb6.cg1.raytracer.math.impl;

import main.java.de.bht.fb6.cg1.raytracer.math.Mat3x3;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;

/**
 * This class represents a 3x3 matrix.
 * It is immutable, so no method call changes the current object.
 *
 * @author Hanna Prinz
 */
public class Mat3x3Impl implements Mat3x3 {
	
	/**
	 * the first column of the matrix.
	 */
	private final Vector3D col0;
	
	/**
	 * the second column of the matrix.
	 */
	private final Vector3D col1;
	
	/**
	 * the third column of the matrix.
	 */
	private final Vector3D col2;
	
	/**
	 * the constructor for a 3x3 matrix.
	 * @param col0 the first column of the matrix.
	 * @param col1 the second column of the matrix.
	 * @param col2 the third column of the matrix.
	 */
	public Mat3x3Impl(final Vector3D col0, final Vector3D col1, final Vector3D col2){
		this.col0 = col0;
		this.col1 = col1;
		this.col2 = col2;
	}
	
	@Override
	public double getDeterminant() {
		// see http://upload.wikimedia.org/wikipedia/de/math/4/9/a/49ab7622791164ebde57c921bc8f77b8.png
		double a = col0.getX() * col1.getY() * col2.getZ();
		double b = col1.getX() * col2.getY() * col0.getZ();
		double c = col2.getX() * col0.getY() * col1.getZ();
		
		double d = col2.getX() * col1.getY() * col0.getZ();
		double e = col1.getX() * col0.getY() * col2.getZ();
		double f = col0.getX() * col2.getY() * col1.getZ();
		
		return a + b + c - d - e - f;
	}

	@Override
	public Mat3x3 mul(final Mat3x3 matrix) {
		
	/*					 old0  	       old1  	     old2
						 x             x             x
						 y             y             y
						 z             z             z
	 col0  col1  col2
		                col0.x*old0.x	...
		x    x    x   + col1.x*old0.y	...
				 	  + col2.x*old0.z	...
						 
		 y	  y    y	...
		 z	  z    z	...

		 
	 */
		 
		Vector3D old0 = matrix.mul(new Vector3DImpl(1, 0, 0));
		Vector3D old1 = matrix.mul(new Vector3DImpl(0, 1, 0));
		Vector3D old2 = matrix.mul(new Vector3DImpl(0, 0, 1));
		
		double c0x = (col0.getX() * old0.getX()) + (col1.getX() * old0.getY()) + (col2.getX() * old0.getZ());
		double c0y = (col0.getY() * old0.getX()) + (col1.getY() * old0.getY()) + (col2.getY() * old0.getZ());
		double c0z = (col0.getZ() * old0.getX()) + (col1.getZ() * old0.getY()) + (col2.getZ() * old0.getZ());
		Vector3D newCol0 = new Vector3DImpl(c0x, c0y, c0z);
		
		double c1x = (col0.getX() * old1.getX()) + (col1.getX() * old1.getY()) + (col2.getX() * old1.getZ());
		double c1y = (col0.getY() * old1.getX()) + (col1.getY() * old1.getY()) + (col2.getY() * old1.getZ());
		double c1z = (col0.getZ() * old1.getX()) + (col1.getZ() * old1.getY()) + (col2.getZ() * old1.getZ());
		Vector3D newCol1 = new Vector3DImpl(c1x, c1y, c1z);
		
		double c2x = (col0.getX() * old2.getX()) + (col1.getX() * old2.getY()) + (col2.getX() * old2.getZ());
		double c2y = (col0.getY() * old2.getX()) + (col1.getY() * old2.getY()) + (col2.getY() * old2.getZ());
		double c2z = (col0.getZ() * old2.getX()) + (col1.getZ() * old2.getY()) + (col2.getZ() * old2.getZ());
		Vector3D newCol2 = new Vector3DImpl(c2x, c2y, c2z);
		
		return new Mat3x3Impl(newCol0, newCol1, newCol2);
	}

	@Override
	public Point3D mul(final Point3D point) {
		// see http://www.numerik.mathematik.uni-mainz.de/didaktikseminar/Gruppe6/Matrizen_Multiplikation-Dateien/image004.jpg
		Double x = point.getX();
		Double y = point.getY();
		Double z = point.getZ();
		Double newX = ((col0.getX() * x) + (col1.getX() * y) + (col2.getX() * z));
		Double newY = ((col0.getY() * x) + (col1.getY() * y) + (col2.getY() * z));
		Double newZ = ((col0.getZ() * x) + (col1.getZ() * y) + (col2.getZ() * z));
		return new Point3DImpl(newX, newY, newZ);
	}

	@Override
	public Vector3D mul(final Vector3D vector) {
		// see http://www.numerik.mathematik.uni-mainz.de/didaktikseminar/Gruppe6/Matrizen_Multiplikation-Dateien/image004.jpg
		Double x = vector.getX();
		Double y = vector.getY();
		Double z = vector.getZ();
		Double newX = ((col0.getX() * x) + (col1.getX() * y) + (col2.getX() * z));
		Double newY = ((col0.getY() * x) + (col1.getY() * y) + (col2.getY() * z));
		Double newZ = ((col0.getZ() * x) + (col1.getZ() * y) + (col2.getZ() * z));
		return new Vector3DImpl(newX, newY, newZ);
	}

	@Override
	public Mat3x3 replaceColumn0(final Vector3D newCol0) {
		System.out.println("" + newCol0.getX() + " " + newCol0.getY() + " " + newCol0.getZ() + " ");
		System.out.println("" + this.col1.getX() + " " + this.col1.getY() + " " + this.col1.getZ() + " ");
		System.out.println("" + this.col2.getX() + " " + this.col2.getY() + " " + this.col2.getZ() + " ");
		return new Mat3x3Impl(newCol0, this.col1, this.col2);
	}

	@Override
	public Mat3x3 replaceColumn1(final Vector3D newCol1) {
		return new Mat3x3Impl(this.col0, newCol1, this.col2);
	}

	@Override
	public Mat3x3 replaceColumn2(final Vector3D newCol2) {
		return new Mat3x3Impl(this.col0, this.col1, newCol2);
	}

	@Override
	public int hashCode() {
		@SuppressWarnings("unused")
		final int prime = 31;
		int result = 1;
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
		Mat3x3Impl other = (Mat3x3Impl) obj;
		if (col0 == null) {
			if (other.col0 != null)
				return false;
		} else if (!col0.equals(other.col0))
			return false;
		if (col1 == null) {
			if (other.col1 != null)
				return false;
		} else if (!col1.equals(other.col1))
			return false;
		if (col2 == null) {
			if (other.col2 != null)
				return false;
		} else if (!col2.equals(other.col2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mat3x3Impl [col0=" + col0 + ", col1=" + col1 + ", col2=" + col2
				+ "]";
	}
	
}
