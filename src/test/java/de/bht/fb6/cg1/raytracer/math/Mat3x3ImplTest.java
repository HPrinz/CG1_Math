package test.java.de.bht.fb6.cg1.raytracer.math;

import main.java.de.bht.fb6.cg1.raytracer.math.Mat3x3;
import main.java.de.bht.fb6.cg1.raytracer.math.Point3D;
import main.java.de.bht.fb6.cg1.raytracer.math.Vector3D;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Point3DImpl;
import main.java.de.bht.fb6.cg1.raytracer.math.impl.Vector3DImpl;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Hanna
 * 
 */
public class Mat3x3ImplTest {

  final Mat3x3 mat = new Mat3x3Impl(new Vector3DImpl(1, 5, 2), new Vector3DImpl(7, 3, 8), new Vector3DImpl(4, 3, 0));

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#Mat3x3Impl(main.java.de.bht.fb6.cg1.raytracer.math.Vector3D, main.java.de.bht.fb6.cg1.raytracer.math.Vector3D, main.java.de.bht.fb6.cg1.raytracer.math.Vector3D)}
   * .
   */
  @Test
  public void testMat3x3Impl() {
    assertNotNull(mat.getDeterminant());
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#getDeterminant()}
   * .
   */
  @Test
  public void testGetDeterminant() {
    Double actual = mat.getDeterminant();
    Double expected = 154.0;
    AssertJUnit.assertEquals(expected, actual);
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#mul(main.java.de.bht.fb6.cg1.raytracer.math.Mat3x3)}
   * .
   */
  @Test
  public void testMulMat3x3() {
    Mat3x3 actual = mat.mul(new Mat3x3Impl(new Vector3DImpl(3, 4, 8), new Vector3DImpl(1, 23, 5), new Vector3DImpl(9,
        2, 11)));
    Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(63, 51, 38), new Vector3DImpl(182, 89, 186), new Vector3DImpl(67,
        84, 34));
    AssertJUnit.assertEquals(expected, actual);
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#mul(main.java.de.bht.fb6.cg1.raytracer.math.Point3D)}
   * .
   */
  @Test
  public void testMulPoint3D() {
    Point3D actual = mat.mul(new Point3DImpl(4.0, 7.3, 9.0));
    Point3D expected = new Point3DImpl(91.1, 68.9, 66.4);
    AssertJUnit.assertEquals(expected, actual);
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#mul(main.java.de.bht.fb6.cg1.raytracer.math.Vector3D)}
   * .
   */
  @Test
  public void testMulVector3D() {
    Vector3D actual = mat.mul(new Vector3DImpl(4, 7.3, 9));
    Vector3D expected = new Vector3DImpl(91.1, 68.9, 66.4);
    AssertJUnit.assertEquals(expected, actual);
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#replaceColumn0(main.java.de.bht.fb6.cg1.raytracer.math.Vector3D)}
   * .
   */
  @Test
  public void testReplaceColumn0() {
    Mat3x3 actual = mat.replaceColumn0(new Vector3DImpl(1, 2, 3));
    Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(1, 2, 3), new Vector3DImpl(7, 3, 8), new Vector3DImpl(4, 3, 0));
    AssertJUnit.assertEquals(expected, actual);
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#replaceColumn1(main.java.de.bht.fb6.cg1.raytracer.math.Vector3D)}
   * .
   */
  @Test
  public void testReplaceColumn1() {
    Mat3x3 actual = mat.replaceColumn1(new Vector3DImpl(1, 2, 3));
    Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(1, 5, 2), new Vector3DImpl(1, 2, 3), new Vector3DImpl(4, 3, 0));
    AssertJUnit.assertEquals(expected, actual);
  }

  /**
   * Test method for
   * {@link main.java.de.bht.fb6.cg1.raytracer.math.impl.Mat3x3Impl#replaceColumn2(main.java.de.bht.fb6.cg1.raytracer.math.Vector3D)}
   * .
   */
  @Test
  public void testReplaceColumn2() {
    Mat3x3 actual = mat.replaceColumn2(new Vector3DImpl(1.0, 2.0, 3.0));
    Mat3x3 expected = new Mat3x3Impl(new Vector3DImpl(1.0, 5.0, 2.0), new Vector3DImpl(7.0, 3.0, 8.0),
        new Vector3DImpl(1.0, 2.0, 3.0));
    AssertJUnit.assertEquals(expected, actual);
  }

}
