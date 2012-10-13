package de.bht.fb6.cg1.raytracer.math;

import junit.framework.TestCase;

import org.junit.Test;

import de.bht.fb6.cg1.raytracer.math.Point2D;

public class Point2DImplTest extends TestCase{
	Point2D point = new Point2DImpl(7, 4.3);

	@Test
	public void testPoint2DImpl() {
		assertNotNull(point);
	}

	@Test
	public void testGetX() {
		Double actual = point.getX();
		Double expected = 7.0;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetY() {
		Double actual = point.getY();
		Double expected = 4.3;
		assertEquals(expected, actual);
	}

}
