package test.java.de.bht.fb6.cg1.raytracer.math;

import main.java.de.bht.fb6.cg1.raytracer.math.Normal;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.NormalImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class Vector3DImplTest{

	final Vector3D vector = new Vector3DImpl(4, 9.5, 7);
	
	@Test
	public void testVector3DImpl() {
		AssertJUnit.assertNotNull(vector);
	}

	@Test
	public void testAddVector3D() {
		Vector3D actual = vector.add(new Vector3DImpl(3, 16, 9));
		Vector3D expected = new Vector3DImpl(7, 25.5,16);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAddNormal() {
		Vector3D actual = vector.add(new NormalImpl(3, 16, 9));
		Vector3D expected = new Vector3DImpl(7, 25.5,16);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAsNormal() {
		Normal actual = vector.asNormal();
		Normal expected = new NormalImpl(4, 9.5, 7);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAsPoint() {
		Point3D actual = vector.asPoint();
		Point3D expected = new Point3DImpl(4, 9.5, 7);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testCross() {
		Vector3D actual = vector.cross(new Vector3DImpl(2, 4, 7));
		Vector3D expected = new Vector3DImpl(38.5,-14,-3);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testDiv() {
		Vector3D actual = vector.div(2);
		Vector3D expected = new Vector3DImpl( 2, 4.75, 3.5 );
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testDotNormal() {
		Double actual = vector.dot(new NormalImpl(4, 7, 1));
		Double expected = 89.5;
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testDotVector3D() {
		Double actual = vector.dot(new Vector3DImpl(4, 7, 1));
		Double expected = 89.5;
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetMagnitude() {
		Double actual = vector.getMagnitude();
		Double expected = 12.4599358;
		AssertJUnit.assertEquals(expected, actual, 0.1);
	}

	@Test
	public void testGetX() {
		Double expected = 4.0;
		Double actual = vector.getX();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetY() {
		Double expected = 9.5;
		Double actual = vector.getY();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetZ() {
		Double expected = 7.0;
		Double actual = vector.getZ();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testMul() {
		Vector3D actual = vector.mul(2.5);
		Vector3D expected = new Vector3DImpl(10, 23.75, 17.5);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testNormalized() {
		Vector3D actual = vector.normalized();
		Double mag = vector.getMagnitude();
		Vector3D expected = new Vector3DImpl(4/mag, 9.5/mag, 7/mag);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testSub() {
		Vector3D actual = vector.sub(new Vector3DImpl(4, 3.5, 2));
		Vector3D expected = new Vector3DImpl(0, 6, 5);
		AssertJUnit.assertEquals(expected, actual);
	}
	
	//System.out.println("Norm " + actual.getX() + " " + actual.getY() + " " + actual.getZ());

}
