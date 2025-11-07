package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.math.BigInteger;
import org.junit.Test;

public class Fp12DiffblueTest {
  /**
   * Method under test: {@link Fp12#squared()}
   */
  @Test
  public void testSquared() {
    // Arrange and Act
    Fp12 actualSquaredResult = Fp12.ZERO.squared();

    // Assert
    assertEquals(actualSquaredResult.ZERO, actualSquaredResult);
  }

  /**
   * Method under test: {@link Fp12#dbl()}
   */
  @Test
  public void testDbl() {
    // Arrange, Act and Assert
    assertNull(Fp12.ZERO.dbl());
  }

  /**
   * Method under test: {@link Fp12#mulBy024(Fp2, Fp2, Fp2)}
   */
  @Test
  public void testMulBy024() {
    // Arrange and Act
    Fp12 actualMulBy024Result = Fp12.ZERO.mulBy024(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Assert
    assertEquals(actualMulBy024Result.ZERO, actualMulBy024Result);
  }

  /**
   * Method under test: {@link Fp12#add(Fp12)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    Fp12 actualAddResult = Fp12.ZERO.add(Fp12.ZERO);

    // Assert
    assertEquals(actualAddResult.ZERO, actualAddResult);
  }

  /**
   * Method under test: {@link Fp12#mul(Fp12)}
   */
  @Test
  public void testMul() {
    // Arrange and Act
    Fp12 actualMulResult = Fp12.ZERO.mul(Fp12.ZERO);

    // Assert
    assertEquals(actualMulResult.ZERO, actualMulResult);
  }

  /**
   * Method under test: {@link Fp12#sub(Fp12)}
   */
  @Test
  public void testSub() {
    // Arrange and Act
    Fp12 actualSubResult = Fp12.ZERO.sub(Fp12.ZERO);

    // Assert
    assertEquals(actualSubResult.ZERO, actualSubResult);
  }

  /**
   * Method under test: {@link Fp12#inverse()}
   */
  @Test
  public void testInverse() {
    // Arrange and Act
    Fp12 actualInverseResult = Fp12._1.inverse();

    // Assert
    assertEquals(actualInverseResult._1, actualInverseResult);
  }

  /**
   * Method under test: {@link Fp12#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    Fp12 actualNegateResult = Fp12.ZERO.negate();

    // Assert
    assertEquals(actualNegateResult.ZERO, actualNegateResult);
  }

  /**
   * Method under test: {@link Fp12#isZero()}
   */
  @Test
  public void testIsZero() {
    // Arrange, Act and Assert
    assertTrue(Fp12.ZERO.isZero());
    assertFalse(Fp12._1.isZero());
    assertTrue((new Fp12(Fp6.ZERO, Fp6.ZERO)).isZero());
    assertFalse((new Fp12(null, Fp6.ZERO)).isZero());
    assertFalse((new Fp12(Fp6.ZERO, Fp6._1)).isZero());
    assertFalse((new Fp12(Fp6.ZERO, null)).isZero());
    assertFalse((new Fp12(new Fp6(Fp2.ZERO, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE), Fp6.ZERO)).isZero());
    assertFalse((new Fp12(new Fp6(Fp2.ZERO, Fp2.ZERO, Fp2.NON_RESIDUE), Fp6.ZERO)).isZero());
    assertFalse((new Fp12(new Fp6(Fp2.ZERO, null, Fp2.NON_RESIDUE), Fp6.ZERO)).isZero());
    assertFalse((new Fp12(new Fp6(null, Fp2.ZERO, Fp2.NON_RESIDUE), Fp6.ZERO)).isZero());
    assertTrue((new Fp12(new Fp6(Fp2.ZERO, Fp2.ZERO, Fp2.ZERO), Fp6.ZERO)).isZero());
    assertFalse((new Fp12(new Fp6(Fp2.ZERO, Fp2.ZERO, null), Fp6.ZERO)).isZero());
  }

  /**
   * Method under test: {@link Fp12#isValid()}
   */
  @Test
  public void testIsValid() {
    // Arrange, Act and Assert
    assertTrue(Fp12.ZERO.isValid());
    assertFalse((new Fp12(new Fp6(Fp2.create(Params.P, BN128G2.FR_NEG_ONE), Fp2.NON_RESIDUE, null), null)).isValid());
    assertFalse((new Fp12(new Fp6(Fp2.create(BN128G2.FR_NEG_ONE, Params.P), Fp2.NON_RESIDUE, null), null)).isValid());
  }

  /**
   * Method under test: {@link Fp12#frobeniusMap(int)}
   */
  @Test
  public void testFrobeniusMap() {
    // Arrange and Act
    Fp12 actualFrobeniusMapResult = Fp12.ZERO.frobeniusMap(1);

    // Assert
    assertEquals(actualFrobeniusMapResult.ZERO, actualFrobeniusMapResult);
  }

  /**
   * Method under test: {@link Fp12#cyclotomicSquared()}
   */
  @Test
  public void testCyclotomicSquared() {
    // Arrange and Act
    Fp12 actualCyclotomicSquaredResult = Fp12.ZERO.cyclotomicSquared();

    // Assert
    assertEquals(actualCyclotomicSquaredResult.ZERO, actualCyclotomicSquaredResult);
  }

  /**
   * Method under test: {@link Fp12#cyclotomicExp(BigInteger)}
   */
  @Test
  public void testCyclotomicExp() {
    // Arrange and Act
    Fp12 actualCyclotomicExpResult = Fp12.ZERO.cyclotomicExp(BigInteger.valueOf(1L));

    // Assert
    assertEquals(actualCyclotomicExpResult.ZERO, actualCyclotomicExpResult);
  }

  /**
   * Method under test: {@link Fp12#unitaryInverse()}
   */
  @Test
  public void testUnitaryInverse() {
    // Arrange and Act
    Fp12 actualUnitaryInverseResult = Fp12.ZERO.unitaryInverse();

    // Assert
    assertEquals(actualUnitaryInverseResult.ZERO, actualUnitaryInverseResult);
  }

  /**
   * Method under test: {@link Fp12#negExp(BigInteger)}
   */
  @Test
  public void testNegExp() {
    // Arrange and Act
    Fp12 actualNegExpResult = Fp12.ZERO.negExp(BigInteger.valueOf(1L));

    // Assert
    assertEquals(actualNegExpResult.ZERO, actualNegExpResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp12#equals(Object)}
   *   <li>{@link Fp12#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp12 fp12 = Fp12.ZERO;
    Fp12 fp122 = Fp12.ZERO;

    // Act and Assert
    assertEquals(fp12, fp122);
    int expectedHashCodeResult = fp12.hashCode();
    assertEquals(expectedHashCodeResult, fp122.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp12#equals(Object)}
   *   <li>{@link Fp12#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp12 fp12 = new Fp12(Fp6.ZERO, Fp6.ZERO);
    Fp12 fp122 = Fp12.ZERO;

    // Act and Assert
    assertEquals(fp12, fp122);
    int expectedHashCodeResult = fp12.hashCode();
    assertEquals(expectedHashCodeResult, fp122.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp12#equals(Object)}
   *   <li>{@link Fp12#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp12 fp12 = Fp12.ZERO;

    // Act and Assert
    assertEquals(fp12, fp12);
    int expectedHashCodeResult = fp12.hashCode();
    assertEquals(expectedHashCodeResult, fp12.hashCode());
  }

  /**
   * Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp12._1, Fp12.ZERO);
    assertNotEquals(Fp12._1, mock(Fp6.class));
    assertNotEquals(new Fp12(null, Fp6.ZERO), Fp12.ZERO);
    assertNotEquals(new Fp12(Fp6.ZERO, Fp6._1), Fp12.ZERO);
    assertNotEquals(new Fp12(Fp6.ZERO, null), Fp12.ZERO);
  }

  /**
   * Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp12.ZERO, null);
  }

  /**
   * Method under test: {@link Fp12#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp12.ZERO, "Different type to Fp12");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp12#Fp12(Fp6, Fp6)}
   *   <li>{@link Fp12#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Fp12 actualFp12 = new Fp12(Fp6.ZERO, Fp6.ZERO);

    // Assert
    assertEquals("Fp12 (0; 0)\n     (0; 0)\n     (0; 0)\n     (0; 0)\n     (0; 0)\n     (0; 0)\n",
        actualFp12.toString());
    Fp6 fp6 = actualFp12.a;
    assertTrue(fp6.isValid());
    Fp6 fp62 = actualFp12.b;
    assertTrue(fp62.isValid());
    assertTrue(fp6.isZero());
    assertTrue(fp62.isZero());
  }
}
