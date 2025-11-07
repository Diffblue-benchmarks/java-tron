package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;

public class FpDiffblueTest {
  /**
   * Method under test: {@link Fp#create(BigInteger)}
   */
  @Test
  public void testCreate() {
    // Arrange and Act
    Fp actualCreateResult = Fp.create(BN128G2.FR_NEG_ONE);

    // Assert
    BigInteger bigInteger = actualCreateResult.v;
    assertEquals("21888242871839275222246405745257275088548364400416034343698204186575808495616",
        bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(28, bigInteger.getLowestSetBit());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
        '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
        '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0}, actualCreateResult.bytes());
  }

  /**
   * Method under test: {@link Fp#create(byte[])}
   */
  @Test
  public void testCreate2() throws UnsupportedEncodingException {
    // Arrange and Act
    Fp actualCreateResult = Fp.create("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    BigInteger bigInteger = actualCreateResult.v;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
    byte[] expectedBytesResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytesResult, actualCreateResult.bytes());
  }

  /**
   * Method under test: {@link Fp#add(Fp)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    Fp actualAddResult = Fp.NON_RESIDUE.add(Fp.NON_RESIDUE);

    // Assert
    BigInteger bigInteger = actualAddResult.v;
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208581",
        bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'}, actualAddResult.bytes());
  }

  /**
   * Method under test: {@link Fp#mul(Fp2)}
   */
  @Test
  public void testMul() {
    // Arrange
    Fp fp = Fp.NON_RESIDUE;

    // Act
    Fp2 actualMulResult = fp.mul(Fp2.NON_RESIDUE);

    // Assert
    Fp fp2 = actualMulResult.a;
    BigInteger bigInteger = fp2.v;
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208574",
        bigInteger.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertFalse(actualMulResult.isZero());
    assertTrue(actualMulResult.isValid());
    assertEquals(fp.NON_RESIDUE, actualMulResult.b);
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, '>'}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, '>'}, fp2.bytes());
  }

  /**
   * Method under test: {@link Fp#mul(Fp)}
   */
  @Test
  public void testMul2() {
    // Arrange and Act
    Fp actualMulResult = Fp.NON_RESIDUE.mul(Fp.NON_RESIDUE);

    // Assert
    assertEquals(actualMulResult._1, actualMulResult);
  }

  /**
   * Method under test: {@link Fp#sub(Fp)}
   */
  @Test
  public void testSub() {
    // Arrange and Act
    Fp actualSubResult = Fp.NON_RESIDUE.sub(Fp.NON_RESIDUE);

    // Assert
    assertEquals(actualSubResult.ZERO, actualSubResult);
  }

  /**
   * Method under test: {@link Fp#squared()}
   */
  @Test
  public void testSquared() {
    // Arrange and Act
    Fp actualSquaredResult = Fp.NON_RESIDUE.squared();

    // Assert
    assertEquals(actualSquaredResult._1, actualSquaredResult);
  }

  /**
   * Method under test: {@link Fp#dbl()}
   */
  @Test
  public void testDbl() {
    // Arrange and Act
    Fp actualDblResult = Fp.NON_RESIDUE.dbl();

    // Assert
    BigInteger bigInteger = actualDblResult.v;
    assertEquals("21888242871839275222246405745257275088696311157297823662689037894645226208581",
        bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'}, actualDblResult.bytes());
  }

  /**
   * Method under test: {@link Fp#inverse()}
   */
  @Test
  public void testInverse() {
    // Arrange and Act
    Fp actualInverseResult = Fp.NON_RESIDUE.inverse();

    // Assert
    assertEquals(actualInverseResult.NON_RESIDUE, actualInverseResult);
  }

  /**
   * Method under test: {@link Fp#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    Fp actualNegateResult = Fp.NON_RESIDUE.negate();

    // Assert
    assertEquals(actualNegateResult._1, actualNegateResult);
  }

  /**
   * Method under test: {@link Fp#isZero()}
   */
  @Test
  public void testIsZero() {
    // Arrange, Act and Assert
    assertFalse(Fp.NON_RESIDUE.isZero());
    assertTrue(Fp.ZERO.isZero());
  }

  /**
   * Method under test: {@link Fp#isValid()}
   */
  @Test
  public void testIsValid() {
    // Arrange, Act and Assert
    assertTrue(Fp.NON_RESIDUE.isValid());
    assertFalse(Fp.create(Params.P).isValid());
  }

  /**
   * Method under test: {@link Fp#bytes()}
   */
  @Test
  public void testBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
        -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'}, Fp.NON_RESIDUE.bytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp#equals(Object)}
   *   <li>{@link Fp#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp fp = Fp.NON_RESIDUE;
    Fp fp2 = Fp.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp, fp2);
    int expectedHashCodeResult = fp.hashCode();
    assertEquals(expectedHashCodeResult, fp2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp#equals(Object)}
   *   <li>{@link Fp#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp createResult = Fp.create(BN128G2.FR_NEG_ONE);
    Fp createResult2 = Fp.create(BN128G2.FR_NEG_ONE);

    // Act and Assert
    assertEquals(createResult, createResult2);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp#equals(Object)}
   *   <li>{@link Fp#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp fp = Fp.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp, fp);
    int expectedHashCodeResult = fp.hashCode();
    assertEquals(expectedHashCodeResult, fp.hashCode());
  }

  /**
   * Method under test: {@link Fp#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp.ZERO, Fp.NON_RESIDUE);
    assertNotEquals(Fp.create((BigInteger) null), Fp.NON_RESIDUE);
  }

  /**
   * Method under test: {@link Fp#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp createResult = Fp.create((BigInteger) null);

    // Act and Assert
    assertEquals(createResult, Fp.create((BigInteger) null));
  }

  /**
   * Method under test: {@link Fp#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp.NON_RESIDUE, null);
  }

  /**
   * Method under test: {@link Fp#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp.NON_RESIDUE, "Different type to Fp");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Fp#Fp(BigInteger)}
   *   <li>{@link Fp#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Fp actualFp = new Fp(BN128G2.FR_NEG_ONE);
    String actualToStringResult = actualFp.toString();

    // Assert
    BigInteger bigInteger = actualFp.v;
    assertEquals("21888242871839275222246405745257275088548364400416034343698204186575808495616",
        bigInteger.toString());
    assertEquals("21888242871839275222246405745257275088548364400416034343698204186575808495616", actualToStringResult);
    assertEquals(1, bigInteger.signum());
    assertEquals(28, bigInteger.getLowestSetBit());
    assertArrayEquals(new byte[]{'0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
        '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0}, bigInteger.toByteArray());
  }
}
