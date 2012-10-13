package test.java.de.bht.fb6.cg1.raytracer.math;

import main.java.de.bht.fb6.cg1.raytracer.math.Point2D;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Point2DImpl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class Point2DImplTest{
	Point2D point = new Point2DImpl(7, 4.3);

	@Test
	public void testPoint2DImpl() {
		AssertJUnit.assertNotNull(point);
	}

	@Test
	public void testGetX() {
		Double actual = point.getX();
		Double expected = 7.0;
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test
	public void testGetY() {
		Double actual = point.getY();
		Double expected = 4.3;
		AssertJUnit.assertEquals(expected, actual);
	}

}
