package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Fp2DiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp2#Fp2(Fp, Fp)}
   *   <li>{@link Fp2#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Fp2.<init>(Fp, Fp)", "java.lang.String Fp2.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Fp2 actualFp2 = new Fp2(Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Assert
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208582i + 2188824287183927522"
            + "2246405745257275088696311157297823662689037894645226208582",
        actualFp2.toString());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        actualFp2.a.bytes());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        actualFp2.b.bytes());
  }

  /**
   * Test {@link Fp2#Fp2(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link Fp2#Fp2(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Fp2.<init>(BigInteger, BigInteger)"})
  public void testNewFp2() {
    // Arrange
    BigInteger b = BN128G2.FR_NEG_ONE;

    // Act
    Fp2 actualFp2 = new Fp2(BN128G2.FR_NEG_ONE, b);

    // Assert
    assertFalse(actualFp2.isZero());
    assertTrue(actualFp2.isValid());
    Fp expectedFp = actualFp2.a;
    assertEquals(expectedFp, actualFp2.b);
    Fp fp = actualFp2.a;
    assertSame(b, fp.v);
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
          '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0
        },
        fp.bytes());
  }

  /**
   * Test {@link Fp2#create(BigInteger, BigInteger)} with {@code BigInteger}, {@code BigInteger}.
   *
   * <p>Method under test: {@link Fp2#create(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.create(BigInteger, BigInteger)"})
  public void testCreateWithBigIntegerBigInteger() {
    // Arrange
    BigInteger bb = BN128G2.FR_NEG_ONE;

    // Act
    Fp2 actualCreateResult = Fp2.create(BN128G2.FR_NEG_ONE, bb);

    // Assert
    assertFalse(actualCreateResult.isZero());
    assertTrue(actualCreateResult.isValid());
    Fp expectedFp = actualCreateResult.a;
    assertEquals(expectedFp, actualCreateResult.b);
    Fp fp = actualCreateResult.a;
    assertSame(bb, fp.v);
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
          '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0
        },
        fp.bytes());
  }

  /**
   * Test {@link Fp2#create(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <p>Method under test: {@link Fp2#create(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.create(byte[], byte[])"})
  public void testCreateWithByteByte() throws UnsupportedEncodingException {
    // Arrange and Act
    Fp2 actualCreateResult = Fp2.create("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Fp fp = actualCreateResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertFalse(actualCreateResult.isZero());
    assertTrue(actualCreateResult.isValid());
    Fp expectedFp = actualCreateResult.a;
    assertEquals(expectedFp, actualCreateResult.b);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
    byte[] expectedBytesResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytesResult, fp.bytes());
  }

  /**
   * Test {@link Fp2#squared()}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp2#b} {@link Fp#v} toString is {@code 18}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#squared()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.squared()"})
  public void testSquared_givenNon_residue_thenReturnBVToStringIs18() {
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
    assertArrayEquals(new byte[] {18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {18}, fp.bytes());
    assertArrayEquals(new byte[] {'P'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[] {'P'}, fp2.bytes());
  }

  /**
   * Test {@link Fp2#mul(Fp2)} with {@code Fp2}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>When {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp2#b} {@link Fp#v} toString is {@code 18}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#mul(Fp2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.mul(Fp2)"})
  public void testMulWithFp2_givenNon_residue_whenNon_residue_thenReturnBVToStringIs18() {
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
    assertArrayEquals(new byte[] {18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {18}, fp.bytes());
    assertArrayEquals(new byte[] {'P'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[] {'P'}, fp2.bytes());
  }

  /**
   * Test {@link Fp2#add(Fp2)} with {@code Fp2}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>When {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp2#a} {@link Fp#v} toString is {@code 18}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#add(Fp2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.add(Fp2)"})
  public void testAddWithFp2_givenNon_residue_whenNon_residue_thenReturnAVToStringIs18() {
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
    assertArrayEquals(new byte[] {18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {18}, fp.bytes());
    assertArrayEquals(new byte[] {2}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[] {2}, fp2.bytes());
  }

  /**
   * Test {@link Fp2#sub(Fp2)} with {@code Fp2}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>When {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp2#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#sub(Fp2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.sub(Fp2)"})
  public void testSubWithFp2_givenNon_residue_whenNon_residue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp2.ZERO, Fp2.NON_RESIDUE.sub(Fp2.NON_RESIDUE));
  }

  /**
   * Test {@link Fp2#dbl()}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp2#a} {@link Fp#v} toString is {@code 18}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#dbl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.dbl()"})
  public void testDbl_givenNon_residue_thenReturnAVToStringIs18() {
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
    assertArrayEquals(new byte[] {18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {18}, fp.bytes());
    assertArrayEquals(new byte[] {2}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[] {2}, fp2.bytes());
  }

  /**
   * Test {@link Fp2#inverse()}.
   *
   * <p>Method under test: {@link Fp2#inverse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.inverse()"})
  public void testInverse() {
    // Arrange and Act
    Fp2 actualInverseResult = Fp2.NON_RESIDUE.inverse();

    // Assert
    Fp fp = actualInverseResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals(
        "14681138511599513868579906292550611339979233093309515871315818100066920017952",
        bigInteger.toString());
    Fp fp2 = actualInverseResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals(
        "21087453498479301738505683583845423561061080261299122796980902361914303298513",
        bigInteger2.toString());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(5, bigInteger.getLowestSetBit());
    assertFalse(actualInverseResult.isZero());
    assertTrue(actualInverseResult.isValid());
    assertArrayEquals(
        new byte[] {
          ' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14, 27,
          '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          ' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14, 27,
          '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '
        },
        fp.bytes());
    assertArrayEquals(
        new byte[] {
          '.',
          -97,
          19,
          'b',
          '0',
          '^',
          -93,
          -85,
          'P',
          -54,
          '6',
          -84,
          -76,
          -10,
          '^',
          Byte.MAX_VALUE,
          -95,
          -110,
          -119,
          2,
          -72,
          -22,
          -127,
          -108,
          -114,
          '8',
          'U',
          3,
          'G',
          '3',
          -69,
          -47
        },
        bigInteger2.toByteArray());
    assertArrayEquals(
        new byte[] {
          '.',
          -97,
          19,
          'b',
          '0',
          '^',
          -93,
          -85,
          'P',
          -54,
          '6',
          -84,
          -76,
          -10,
          '^',
          Byte.MAX_VALUE,
          -95,
          -110,
          -119,
          2,
          -72,
          -22,
          -127,
          -108,
          -114,
          '8',
          'U',
          3,
          'G',
          '3',
          -69,
          -47
        },
        fp2.bytes());
  }

  /**
   * Test {@link Fp2#negate()}.
   *
   * <p>Method under test: {@link Fp2#negate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.negate()"})
  public void testNegate() {
    // Arrange and Act
    Fp2 actualNegateResult = Fp2.NON_RESIDUE.negate();

    // Assert
    Fp fp = actualNegateResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208574",
        bigInteger.toString());
    Fp fp2 = actualNegateResult.b;
    BigInteger bigInteger2 = fp2.v;
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208582",
        bigInteger2.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertFalse(actualNegateResult.isZero());
    assertTrue(actualNegateResult.isValid());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, '>'
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, '>'
        },
        fp.bytes());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        bigInteger2.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        fp2.bytes());
  }

  /**
   * Test {@link Fp2#isZero()}.
   *
   * <ul>
   *   <li>Given create {@link ECConstants#ZERO} and {@link BN128G2#FR_NEG_ONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isZero()"})
  public void testIsZero_givenCreateZeroAndFr_neg_one_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp2.create(ECConstants.ZERO, BN128G2.FR_NEG_ONE).isZero());
  }

  /**
   * Test {@link Fp2#isZero()}.
   *
   * <ul>
   *   <li>Given create {@link ECConstants#ZERO} and {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isZero()"})
  public void testIsZero_givenCreateZeroAndNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp2.create(ECConstants.ZERO, null).isZero());
  }

  /**
   * Test {@link Fp2#isZero()}.
   *
   * <ul>
   *   <li>Given create {@link ECConstants#ZERO} and {@link ECConstants#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isZero()"})
  public void testIsZero_givenCreateZeroAndZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp2.create(ECConstants.ZERO, ECConstants.ZERO).isZero());
  }

  /**
   * Test {@link Fp2#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isZero()"})
  public void testIsZero_givenNon_residue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp2.NON_RESIDUE.isZero());
  }

  /**
   * Test {@link Fp2#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp2#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isZero()"})
  public void testIsZero_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp2.ZERO.isZero());
  }

  /**
   * Test {@link Fp2#isValid()}.
   *
   * <ul>
   *   <li>Given create {@link BN128G2#FR_NEG_ONE} and {@link Params#P}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isValid()"})
  public void testIsValid_givenCreateFr_neg_oneAndP_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp2.create(BN128G2.FR_NEG_ONE, Params.P).isValid());
  }

  /**
   * Test {@link Fp2#isValid()}.
   *
   * <ul>
   *   <li>Given create {@link Params#P} and {@link BN128G2#FR_NEG_ONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isValid()"})
  public void testIsValid_givenCreatePAndFr_neg_one_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp2.create(Params.P, BN128G2.FR_NEG_ONE).isValid());
  }

  /**
   * Test {@link Fp2#isValid()}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.isValid()"})
  public void testIsValid_givenNon_residue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp2.NON_RESIDUE.isValid());
  }

  /**
   * Test {@link Fp2#equals(Object)}, and {@link Fp2#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp2#equals(Object)}
   *   <li>{@link Fp2#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.equals(Object)", "int Fp2.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp2 fp2 = Fp2.NON_RESIDUE;
    Fp2 fp22 = Fp2.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp2, fp22);
    assertEquals(fp2.hashCode(), fp22.hashCode());
  }

  /**
   * Test {@link Fp2#equals(Object)}, and {@link Fp2#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp2#equals(Object)}
   *   <li>{@link Fp2#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.equals(Object)", "int Fp2.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp2 fp2 = Fp6.NON_RESIDUE;
    Fp2 fp22 = Fp2.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp2, fp22);
    assertEquals(fp2.hashCode(), fp22.hashCode());
  }

  /**
   * Test {@link Fp2#equals(Object)}, and {@link Fp2#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp2#equals(Object)}
   *   <li>{@link Fp2#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.equals(Object)", "int Fp2.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp2 fp2 = Fp2.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp2, fp2);
    int expectedHashCodeResult = fp2.hashCode();
    assertEquals(expectedHashCodeResult, fp2.hashCode());
  }

  /**
   * Test {@link Fp2#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.equals(Object)", "int Fp2.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp2.ZERO, Fp2.NON_RESIDUE);
  }

  /**
   * Test {@link Fp2#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.equals(Object)", "int Fp2.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp2.NON_RESIDUE, null);
  }

  /**
   * Test {@link Fp2#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Fp2.equals(Object)", "int Fp2.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp2.NON_RESIDUE, "Different type to Fp2");
  }

  /**
   * Test {@link Fp2#frobeniusMap(int)}.
   *
   * <p>Method under test: {@link Fp2#frobeniusMap(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.frobeniusMap(int)"})
  public void testFrobeniusMap() {
    // Arrange and Act
    Fp2 actualFrobeniusMapResult = Fp2.NON_RESIDUE.frobeniusMap(1);

    // Assert
    Fp fp = actualFrobeniusMapResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208582",
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
    assertArrayEquals(new byte[] {'\t'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[] {'\t'}, fp2.bytes());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        fp.bytes());
  }

  /**
   * Test {@link Fp2#mulByNonResidue()}.
   *
   * <ul>
   *   <li>Given {@link Fp2#NON_RESIDUE}.
   *   <li>Then return {@link Fp2#b} {@link Fp#v} toString is {@code 18}.
   * </ul>
   *
   * <p>Method under test: {@link Fp2#mulByNonResidue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 Fp2.mulByNonResidue()"})
  public void testMulByNonResidue_givenNon_residue_thenReturnBVToStringIs18() {
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
    assertArrayEquals(new byte[] {18}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {18}, fp.bytes());
    assertArrayEquals(new byte[] {'P'}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[] {'P'}, fp2.bytes());
  }
}
