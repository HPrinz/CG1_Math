package test.java.de.bht.fb6.cg1.raytracer.math;

import main.java.de.bht.fb6.cg1.raytracer.math.Normal;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.NormalImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class NormalImplTest {
	
	Normal norm = new NormalImpl(7, 3, 8);
	
	@Test
	public void testNormalImpl() {
		AssertJUnit.assertNotNull("Normale darf nicht null sein", norm);
	}

	@Test
	public void testAdd() {
		Normal actual = norm.add(new NormalImpl(6, 4.2, 8));
		Normal expected = new NormalImpl(13,7.2,16);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAsPoint() {
		Point3D actual = norm.asPoint();
		Point3D expected = new Point3DImpl(7, 3, 8);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAsVector() {
		Vector3D actual = norm.asVector();
		Vector3D expected = new Vector3DImpl(7, 3, 8);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetX() {
		Double expected = 7.0;
		Double actual = norm.getX();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetY() {
		Double expected = 3.0;
		Double actual = norm.getY();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetZ() {
		Double expected = 8.0;
		Double actual = norm.getZ();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testMul() {
		Normal actual = norm.mul(3.5);
		Normal expected = new NormalImpl(24.5, 10.5, 28);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testNormalized() {
		Normal actual = norm.normalized();
		Double mag = norm.asVector().getMagnitude();
		Normal expected = new NormalImpl(7/mag, 3/mag, 8/mag);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testReflect() {
		Normal n4 = new NormalImpl(1, 1, 1);
		Vector3D actual = n4.reflect(new Vector3DImpl(1, 2, 3));
	    System.out.println("Vector: " + actual.getX() +" " + actual.getY() + " "+ actual.getZ());
	}

}
