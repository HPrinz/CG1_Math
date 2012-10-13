package de.bht.fb6.cg1.raytracer.math.impl.testing;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.bht.fb6.cg1.raytracer.math.Normal;
import de.bht.fb6.cg1.raytracer.math.Vector3D;
import de.bht.fb6.cg1.raytracer.math.impl.NormalImpl;
import de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

public class NormalImplTest extends TestCase {

  Normal n1;
  Normal n2;
  Normal n3;
  Normal n4;

  Vector3D v1;
  Vector3D v2;

  double dou1;
  double dou2;

  @Override
  @Before
  public void setUp() throws Exception {
    n1 = new NormalImpl(1, 2, 3);
    n2 = new NormalImpl(-0.5, 1, -1.5);
    n3 = new NormalImpl(1, -1, 0);
    n4 = new NormalImpl(1, 1, 1);

    v1 = new Vector3DImpl(1, -1, 1);
    v2 = new Vector3DImpl(1, 2, 3);

    dou1 = -2;
    dou2 = 0.5;
  }

  @Test
  public void test() {

    try {
      new NormalImpl(0, 0, 0);
      fail("Should have raised an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      System.out.println("Testing constructor.");
    }

    System.out.println("Testing multiplication.");
    assertTrue(n1.mul(dou1).equals(new NormalImpl(-2, -4, -6)));
    assertTrue(n2.mul(dou1).equals(new NormalImpl(1, -2, 3)));
    assertTrue(n3.mul(dou1).equals(new NormalImpl(-2, 2, 0)));
    assertTrue(n1.mul(dou2).equals(new NormalImpl(0.5, 1, 1.5)));
    assertTrue(n2.mul(dou2).equals(new NormalImpl(-0.25, 0.5, -0.75)));
    assertTrue(n3.mul(dou2).equals(new NormalImpl(0.5, -0.5, 0)));

    System.out.println("Testing addition.");
    assertTrue(n1.add(n1).equals(new NormalImpl(2, 4, 6)));
    assertTrue(n1.add(n2).equals(new NormalImpl(0.5, 3, 1.5)));
    assertTrue(n1.add(n3).equals(new NormalImpl(2, 1, 3)));

    System.out.println("Testing normalized.");
    assertTrue(n1.normalized().equals(new NormalImpl(1 / Math.sqrt(14d), 2 / Math.sqrt(14d), 3 / Math.sqrt(14d))));
    assertTrue(n2.normalized().equals(
        new NormalImpl(-0.5 / Math.sqrt(3.5d), 1 / Math.sqrt(3.5d), -1.5 / Math.sqrt(3.5d))));
    assertTrue(n3.normalized().equals(new NormalImpl(1 / Math.sqrt(2d), -1 / Math.sqrt(2d), 0)));

    System.out.println("Testing reflection.");
    Vector3D help = n4.reflect(v2);
    assertTrue(Math.abs(help.getX() + 3.0) < 1d / 1000000000000d);
    assertTrue(Math.abs(help.getY() + 2.0) < 1d / 1000000000000d);
    assertTrue(Math.abs(help.getZ() + 1.0) < 1d / 1000000000000d);

    System.out.println("Testing conversion.");
    assertTrue(n1.asPoint().equals(new Point3DImpl(1, 2, 3)));
    assertTrue(n2.asPoint().equals(new Point3DImpl(-0.5, 1, -1.5)));
    assertTrue(n3.asPoint().equals(new Point3DImpl(1, -1, 0)));

    assertTrue(n1.asVector().equals(new Vector3DImpl(1, 2, 3)));
    assertTrue(n2.asVector().equals(new Vector3DImpl(-0.5, 1, -1.5)));
    assertTrue(n3.asVector().equals(new Vector3DImpl(1, -1, 0)));

  }
}
