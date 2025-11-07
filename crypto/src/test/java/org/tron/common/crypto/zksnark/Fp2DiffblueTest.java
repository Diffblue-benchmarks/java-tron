package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;

public class Fp2DiffblueTest {
  /**
   * Method under test: {@link Fp2#create(BigInteger, BigInteger)}
   */
  @Test
  public void testCreate() {
    // Arrange
    BigInteger bb = BN128G2.FR_NEG_ONE;

    // Act
    Fp2 actualCreateResult = Fp2.create(BN128G2.FR_NEG_ONE, bb);

    // Assert
    assertFalse(actualCreateResult.isZero());
    assertTrue(actualCreateResult.isValid());
    assertEquals(actualCreateResult.a, actualCreateResult.b);
    Fp fp = actualCreateResult.a;
    assertSame(bb, fp.v);
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
        '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0}, fp.bytes());
  }

  /**
   * Method under test: {@link Fp2#create(byte[], byte[])}
   */
  @Test
  public void testCreate2() throws UnsupportedEncodingException {
    // Arrange
    byte[] aa = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Fp2 actualCreateResult = Fp2.create(aa, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Fp fp = actualCreateResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertFalse(actualCreateResult.isZero());
    assertTrue(actualCreateResult.isValid());
    assertEquals(actualCreateResult.a, actualCreateResult.b);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
    byte[] expectedBytesResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytesResult, fp.bytes());
  }

  /**
   * Method under test: {@link Fp2#squared()}
   */
  @Test
  public void testSquared() {
    // Arrange and Act
    Fp2 actualSquaredResult = Fp2.NON_RESIDUE.squared();

    // Assert
    Fp fp = actualSquaredResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals("18", bigInteger.toString());
    Fp fp2 = actualSquaredResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("80", bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(4, bigInteger2.getLowestSetBit());
    assertFalse(actualSquaredResult.isZero());
    assertTrue(actualSquaredResult.isValid());
    assertArrayEquals(new byte[]{18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{18}, fp.bytes());
    assertArrayEquals(new byte[]{'P'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{'P'}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#mul(Fp2)}
   */
  @Test
  public void testMul() {
    // Arrange and Act
    Fp2 actualMulResult = Fp2.NON_RESIDUE.mul(Fp2.NON_RESIDUE);

    // Assert
    Fp fp = actualMulResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals("18", bigInteger.toString());
    Fp fp2 = actualMulResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("80", bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(4, bigInteger2.getLowestSetBit());
    assertFalse(actualMulResult.isZero());
    assertTrue(actualMulResult.isValid());
    assertArrayEquals(new byte[]{18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{18}, fp.bytes());
    assertArrayEquals(new byte[]{'P'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{'P'}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#add(Fp2)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    Fp2 actualAddResult = Fp2.NON_RESIDUE.add(Fp2.NON_RESIDUE);

    // Assert
    Fp fp = actualAddResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals("18", bigInteger.toString());
    Fp fp2 = actualAddResult.b;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("2", bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertFalse(actualAddResult.isZero());
    assertTrue(actualAddResult.isValid());
    assertArrayEquals(new byte[]{18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{18}, fp.bytes());
    assertArrayEquals(new byte[]{2}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{2}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#sub(Fp2)}
   */
  @Test
  public void testSub() {
    // Arrange and Act
    Fp2 actualSubResult = Fp2.NON_RESIDUE.sub(Fp2.NON_RESIDUE);

    // Assert
    assertEquals(actualSubResult.ZERO, actualSubResult);
  }

  /**
   * Method under test: {@link Fp2#dbl()}
   */
  @Test
  public void testDbl() {
    // Arrange and Act
    Fp2 actualDblResult = Fp2.NON_RESIDUE.dbl();

    // Assert
    Fp fp = actualDblResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals("18", bigInteger.toString());
    Fp fp2 = actualDblResult.b;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("2", bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertFalse(actualDblResult.isZero());
    assertTrue(actualDblResult.isValid());
    assertArrayEquals(new byte[]{18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{18}, fp.bytes());
    assertArrayEquals(new byte[]{2}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{2}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#inverse()}
   */
  @Test
  public void testInverse() {
    // Arrange and Act
    Fp2 actualInverseResult = Fp2.NON_RESIDUE.inverse();

    // Assert
    Fp fp = actualInverseResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals("14681138511599513868579906292550611339979233093309515871315818100066920017952",
        bigInteger.toString());
    Fp fp2 = actualInverseResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("21087453498479301738505683583845423561061080261299122796980902361914303298513",
        bigInteger2.toString());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(5, bigInteger.getLowestSetBit());
    assertFalse(actualInverseResult.isZero());
    assertTrue(actualInverseResult.isValid());
    assertArrayEquals(new byte[]{' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14,
        27, '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14,
        27, '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '}, fp.bytes());
    assertArrayEquals(new byte[]{'.', -97, 19, 'b', '0', '^', -93, -85, 'P', -54, '6', -84, -76, -10, '^',
        Byte.MAX_VALUE, -95, -110, -119, 2, -72, -22, -127, -108, -114, '8', 'U', 3, 'G', '3', -69, -47},
        bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{'.', -97, 19, 'b', '0', '^', -93, -85, 'P', -54, '6', -84, -76, -10, '^',
        Byte.MAX_VALUE, -95, -110, -119, 2, -72, -22, -127, -108, -114, '8', 'U', 3, 'G', '3', -69, -47}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    Fp2 actualNegateResult = Fp2.NON_RESIDUE.negate();

    // Assert
    Fp fp = actualNegateResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208574",
        bigInteger.toString());
    Fp fp2 = actualNegateResult.b;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208582",
        bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertFalse(actualNegateResult.isZero());
    assertTrue(actualNegateResult.isValid());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, '>'}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, '>'}, fp.bytes());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#isZero()}
   */
  @Test
  public void testIsZero() {
    // Arrange, Act and Assert
    assertFalse(Fp2.NON_RESIDUE.isZero());
    assertTrue(Fp2.ZERO.isZero());
    assertFalse(Fp2.create(null, BN128G2.FR_NEG_ONE).isZero());
    assertFalse(Fp2.create(new byte[]{}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}).isZero());
    assertTrue(Fp2.create(new byte[]{}, new byte[]{}).isZero());
  }

  /**
   * Method under test: {@link Fp2#isValid()}
   */
  @Test
  public void testIsValid() {
    // Arrange, Act and Assert
    assertTrue(Fp2.NON_RESIDUE.isValid());
    assertFalse(Fp2.create(Params.P, BN128G2.FR_NEG_ONE).isValid());
    assertFalse(Fp2.create(BN128G2.FR_NEG_ONE, Params.P).isValid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp2#equals(Object)}
   *   <li>{@link Fp2#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp2 fp2 = Fp2.NON_RESIDUE;
    Fp2 fp22 = Fp2.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp2, fp22);
    int expectedHashCodeResult = fp2.hashCode();
    assertEquals(expectedHashCodeResult, fp22.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp2#equals(Object)}
   *   <li>{@link Fp2#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp2 fp2 = Fp6.NON_RESIDUE;
    Fp2 fp22 = Fp2.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp2, fp22);
    int expectedHashCodeResult = fp2.hashCode();
    assertEquals(expectedHashCodeResult, fp22.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp2#equals(Object)}
   *   <li>{@link Fp2#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp2 fp2 = Fp2.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp2, fp2);
    int expectedHashCodeResult = fp2.hashCode();
    assertEquals(expectedHashCodeResult, fp2.hashCode());
  }

  /**
   * Method under test: {@link Fp2#frobeniusMap(int)}
   */
  @Test
  public void testFrobeniusMap() {
    // Arrange and Act
    Fp2 actualFrobeniusMapResult = Fp2.NON_RESIDUE.frobeniusMap(1);

    // Assert
    Fp fp = actualFrobeniusMapResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208582",
        bigInteger.toString());
    Fp fp2 = actualFrobeniusMapResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("9", bigInteger2.toString());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertFalse(actualFrobeniusMapResult.isZero());
    assertTrue(actualFrobeniusMapResult.isValid());
    assertArrayEquals(new byte[]{'\t'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{'\t'}, fp2.bytes());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, fp.bytes());
  }

  /**
   * Method under test: {@link Fp2#mulByNonResidue()}
   */
  @Test
  public void testMulByNonResidue() {
    // Arrange and Act
    Fp2 actualMulByNonResidueResult = Fp2.NON_RESIDUE.mulByNonResidue();

    // Assert
    Fp fp = actualMulByNonResidueResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals("18", bigInteger.toString());
    Fp fp2 = actualMulByNonResidueResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("80", bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(4, bigInteger2.getLowestSetBit());
    assertFalse(actualMulByNonResidueResult.isZero());
    assertTrue(actualMulByNonResidueResult.isValid());
    assertArrayEquals(new byte[]{18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{18}, fp.bytes());
    assertArrayEquals(new byte[]{'P'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{'P'}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp2#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp2.ZERO, Fp2.NON_RESIDUE);
    assertNotEquals(Fp2.ZERO, mock(Fp.class));
  }

  /**
   * Method under test: {@link Fp2#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp2.NON_RESIDUE, null);
  }

  /**
   * Method under test: {@link Fp2#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp2.NON_RESIDUE, "Different type to Fp2");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp2#Fp2(Fp, Fp)}
   *   <li>{@link Fp2#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Fp2 actualFp2 = new Fp2(Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Assert
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208582i + 2188824287183927522"
        + "2246405745257275088696311157297823662689037894645226208582", actualFp2.toString());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, actualFp2.a.bytes());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, actualFp2.b.bytes());
  }

  /**
   * Method under test: {@link Fp2#Fp2(BigInteger, BigInteger)}
   */
  @Test
  public void testNewFp2() {
    // Arrange
    BigInteger b = BN128G2.FR_NEG_ONE;

    // Act
    Fp2 actualFp2 = new Fp2(BN128G2.FR_NEG_ONE, b);

    // Assert
    assertFalse(actualFp2.isZero());
    assertTrue(actualFp2.isValid());
    assertEquals(actualFp2.a, actualFp2.b);
    Fp fp = actualFp2.a;
    assertSame(b, fp.v);
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
        '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0}, fp.bytes());
  }
}
