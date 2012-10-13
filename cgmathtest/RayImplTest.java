package de.bht.fb6.cg1.raytracer.math.impl.testing;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.bht.fb6.cg1.raytracer.math.Point3D;
import de.bht.fb6.cg1.raytracer.math.Ray;
import de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import de.bht.fb6.cg1.raytracer.math.impl.RayImpl;
import de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

public class RayImplTest extends TestCase {

  Ray r1;
  Ray r2;
  Ray r3;

  Point3D p1;
  Point3D p2;
  Point3D p3;

  @Override
  @Before
  public void setUp() throws Exception {
    r1 = new RayImpl(new Point3DImpl(1, 1, 1), new Vector3DImpl(1, 2, 3));
    r2 = new RayImpl(new Point3DImpl(0, 0, 0), new Vector3DImpl(-1, -2, -3));
    r3 = new RayImpl(new Point3DImpl(1, 1, 1), new Vector3DImpl(0, 1, 0));
    p1 = new Point3DImpl(2, 3, 4);
    p2 = new Point3DImpl(-3, -6, -9);
    p3 = new Point3DImpl(1, 4, 1);

  }

  @Test
  public void test() {
    System.out.println("Testing at(t).");
    assertTrue(r1.at(1).equals(p1));
    assertTrue(r2.at(3).equals(p2));

    System.out.println("Testing Point3D.");
    assertTrue(r1.tOf(p1) == 1);
    assertTrue(r2.tOf(p2) == 3);

    try {
      r2.tOf(p1);
      fail("Should have raised an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      System.out.println("Testing exceptions.");
    }

    try {
      r1.tOf(p2);
      fail("Should have raised an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      System.out.println("Testing exceptions.");
    }
  }

}
