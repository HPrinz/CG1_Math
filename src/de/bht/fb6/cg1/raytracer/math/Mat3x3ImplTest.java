/**
 * 
 */
package de.bht.fb6.cg1.raytracer.math;

import junit.framework.TestCase;

import org.junit.Test;

import de.bht.fb6.cg1.raytracer.math.Mat3x3;
import de.bht.fb6.cg1.raytracer.math.Point3D;
import de.bht.fb6.cg1.raytracer.math.Vector3D;

/**
 * @author Hanna
 *
 */
public class Mat3x3ImplTest extends TestCase{

	final Mat3x3 mat = new Mat3x3Impl(new Vector3DImpl(1, 5, 2), new Vector3DImpl(7, 3, 8), new Vector3DImpl(4, 3, 0));

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#Mat3x3Impl(de.bht.fb6.cg1.raytracer.math.Vector3D, de.bht.fb6.cg1.raytracer.math.Vector3D, de.bht.fb6.cg1.raytracer.math.Vector3D)}.
	 */
	@Test
	public void testMat3x3Impl() {
		assertNotNull(mat.getDeterminant());
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#getDeterminant()}.
	 */
	@Test
	public void testGetDeterminant() {
		Double actual = mat.getDeterminant();
		Double expected = 154.0;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#mul(de.bht.fb6.cg1.raytracer.math.Mat3x3)}.
	 */
	@Test
	public void testMulMat3x3() {
		Mat3x3 actual = mat.mul(new Mat3x3Impl(new Vector3DImpl(3, 4, 8), new Vector3DImpl(1, 23, 5), new Vector3DImpl(9, 2, 11)));
		Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(63, 51, 38), new Vector3DImpl(182, 89, 186), new Vector3DImpl(67, 84, 34));
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#mul(de.bht.fb6.cg1.raytracer.math.Point3D)}.
	 */
	@Test
	public void testMulPoint3D() {
		Point3D actual = mat.mul(new Point3DImpl(4.0, 7.3, 9.0));
		Point3D expected = new Point3DImpl(91.1, 68.9, 66.4);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#mul(de.bht.fb6.cg1.raytracer.math.Vector3D)}.
	 */
	@Test
	public void testMulVector3D() {
		Vector3D actual = mat.mul(new Vector3DImpl(4, 7.3, 9));
		Vector3D expected = new Vector3DImpl(91.1, 68.9, 66.4);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#replaceColumn0(de.bht.fb6.cg1.raytracer.math.Vector3D)}.
	 */
	@Test
	public void testReplaceColumn0() {
		Mat3x3 actual = mat.replaceColumn0(new Vector3DImpl(1, 2, 3));
		Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(1, 2, 3),  new Vector3DImpl(7, 3, 8), new Vector3DImpl(4, 3, 0));
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#replaceColumn1(de.bht.fb6.cg1.raytracer.math.Vector3D)}.
	 */
	@Test
	public void testReplaceColumn1() {
		Mat3x3 actual = mat.replaceColumn1(new Vector3DImpl(1, 2, 3));
		Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(1, 5, 2), new Vector3DImpl(1, 2, 3), new Vector3DImpl(4, 3, 0));
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.bht.fb6.cg1.raytracer.math.Mat3x3Impl#replaceColumn2(de.bht.fb6.cg1.raytracer.math.Vector3D)}.
	 */
	@Test
	public void testReplaceColumn2() {
		Mat3x3 actual = mat.replaceColumn2(new Vector3DImpl(1.0, 2.0, 3.0));
		Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(1.0, 5.0, 2.0), new Vector3DImpl(7.0, 3.0, 8.0), new Vector3DImpl(1.0, 2.0, 3.0));
		assertEquals(expected, actual);
	}

}
