package test.java.de.bht.fb6.cg1.raytracer.math;

import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Ray;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.RayImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class RayImplTest{

	final Ray ray = new RayImpl(new Point3DImpl(1, 3, 2), new Vector3DImpl(10, 15, 8));
	
	@Test
	public void testRayImpl() {
		AssertJUnit.assertNotNull(ray);
	}

	@Test
	public void testAt() {
//		Point3D actual = ray.at(1);
//		Point3D expected = new Point3DImpl();
//		assertEquals(expected, actual);
	}

	@Test
	public void testGetDirection() {
		Vector3D actual = ray.getDirection();
		Vector3D expected = new Vector3DImpl(10, 15, 8);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetOrigin() {
		Point3D actual = ray.getOrigin();
		Point3D expected = new Point3DImpl(1, 3, 2);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testTOf() {
//		Double actual = ray.tOf(new Point3DImpl(5, 7.5, 4));
//		Double expected = 0.0;
//		assertEquals(expected, actual);
	}

}
