package test.java.de.bht.fb6.cg1.raytracer.math;

import main.java.de.bht.fb6.cg1.raytracer.math.Normal;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.NormalImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class Point3DImplTest{

	Point3D point = new Point3DImpl(7, 3, 8);

	@Test
	public void testPoint3DImpl() {
		AssertJUnit.assertNotNull("Punkt darf nicht null sein", point);
	}

	@Test
	public void testAdd() {
		Point3D actual = point.add(new Vector3DImpl(6, 4.2, 8));
		Point3D expected = new Point3DImpl(13,7.2,16);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAsNormal() {
		Normal actual = point.asNormal();
		Normal expected = new NormalImpl(7, 3, 8);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testAsVector() {
		Vector3D actual = point.asVector();
		Vector3D expected = new Vector3DImpl(7, 3, 8);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testDot() {
		Double actual = point.dot(new NormalImpl(2,9,1));
		Double expected = 49.0;
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetX() {
		Double expected = 7.0;
		Double actual = point.getX();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetY() {
		Double expected = 3.0;
		Double actual = point.getY();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetZ() {
		Double expected = 8.0;
		Double actual = point.getZ();
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testSubPoint3D() {
		Vector3D actual = point.sub(new Point3DImpl(5, 10, 7));
		Vector3D expected = new Vector3DImpl(2, -7, 1);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testSubVector3D() {
		Point3D actual = point.sub(new Vector3DImpl(5, 10, 7));
		Point3D expected = new Point3DImpl(2, -7, 1);
		AssertJUnit.assertEquals(expected, actual);
	}

}
