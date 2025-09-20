package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FpDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp#Fp(BigInteger)}
   *   <li>{@link Fp#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Fp.<init>(BigInteger)", "String Fp.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Fp actualFp = new Fp(BN128G2.FR_NEG_ONE);
    String actualToStringResult = actualFp.toString();

    // Assert
    BigInteger bigInteger = actualFp.v;
    assertEquals(
        "21888242871839275222246405745257275088548364400416034343698204186575808495616",
        bigInteger.toString());
    assertEquals(
        "21888242871839275222246405745257275088548364400416034343698204186575808495616",
        actualToStringResult);
    assertEquals(1, bigInteger.signum());
    assertEquals(28, bigInteger.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
          '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0
        },
        bigInteger.toByteArray());
  }

  /**
   * Test {@link Fp#create(BigInteger)} with {@code BigInteger}.
   *
   * <p>Method under test: {@link Fp#create(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.create(BigInteger)"})
  public void testCreateWithBigInteger() {
    // Arrange and Act
    Fp actualCreateResult = Fp.create(BN128G2.FR_NEG_ONE);

    // Assert
    BigInteger bigInteger = actualCreateResult.v;
    assertEquals(
        "21888242871839275222246405745257275088548364400416034343698204186575808495616",
        bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(28, bigInteger.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
          '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', '(',
          '3', -24, 'H', 'y', -71, 'p', -111, 'C', -31, -11, -109, -16, 0, 0, 0
        },
        actualCreateResult.bytes());
  }

  /**
   * Test {@link Fp#create(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link Fp#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.create(byte[])"})
  public void testCreateWithByte() throws UnsupportedEncodingException {
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
   * Test {@link Fp#add(Fp)} with {@code Fp}.
   *
   * <p>Method under test: {@link Fp#add(Fp)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.add(Fp)"})
  public void testAddWithFp() {
    // Arrange and Act
    Fp actualAddResult = Fp.NON_RESIDUE.add(Fp.NON_RESIDUE);

    // Assert
    BigInteger bigInteger = actualAddResult.v;
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208581",
        bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'
        },
        actualAddResult.bytes());
  }

  /**
   * Test {@link Fp#mul(Fp2)} with {@code Fp2}.
   *
   * <p>Method under test: {@link Fp#mul(Fp2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp2 Fp.mul(Fp2)"})
  public void testMulWithFp2() {
    // Arrange and Act
    Fp2 actualMulResult = Fp.NON_RESIDUE.mul(Fp2.NON_RESIDUE);

    // Assert
    Fp fp = actualMulResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208574",
        bigInteger.toString());
    assertEquals(1, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertFalse(actualMulResult.isZero());
    assertTrue(actualMulResult.isValid());
    assertEquals(Fp.NON_RESIDUE, actualMulResult.b);
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
  }

  /**
   * Test {@link Fp#mul(Fp)} with {@code Fp}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>When {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@link Fp#_1}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#mul(Fp)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.mul(Fp)"})
  public void testMulWithFp_givenNon_residue_whenNon_residue_thenReturn_1() {
    // Arrange, Act and Assert
    assertEquals(Fp._1, Fp.NON_RESIDUE.mul(Fp.NON_RESIDUE));
  }

  /**
   * Test {@link Fp#sub(Fp)} with {@code Fp}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>When {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@link Fp#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#sub(Fp)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.sub(Fp)"})
  public void testSubWithFp_givenNon_residue_whenNon_residue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Fp.ZERO, Fp.NON_RESIDUE.sub(Fp.NON_RESIDUE));
  }

  /**
   * Test {@link Fp#squared()}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@link Fp#_1}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#squared()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.squared()"})
  public void testSquared_givenNon_residue_thenReturn_1() {
    // Arrange, Act and Assert
    assertEquals(Fp._1, Fp.NON_RESIDUE.squared());
  }

  /**
   * Test {@link Fp#dbl()}.
   *
   * <p>Method under test: {@link Fp#dbl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.dbl()"})
  public void testDbl() {
    // Arrange and Act
    Fp actualDblResult = Fp.NON_RESIDUE.dbl();

    // Assert
    BigInteger bigInteger = actualDblResult.v;
    assertEquals(
        "21888242871839275222246405745257275088696311157297823662689037894645226208581",
        bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'E'
        },
        actualDblResult.bytes());
  }

  /**
   * Test {@link Fp#inverse()}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@link Fp#NON_RESIDUE}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#inverse()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.inverse()"})
  public void testInverse_givenNon_residue_thenReturnNon_residue() {
    // Arrange, Act and Assert
    assertEquals(Fp.NON_RESIDUE, Fp.NON_RESIDUE.inverse());
  }

  /**
   * Test {@link Fp#negate()}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@link Fp#_1}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp Fp.negate()"})
  public void testNegate_givenNon_residue_thenReturn_1() {
    // Arrange, Act and Assert
    assertEquals(Fp._1, Fp.NON_RESIDUE.negate());
  }

  /**
   * Test {@link Fp#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.isZero()"})
  public void testIsZero_givenNon_residue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Fp.NON_RESIDUE.isZero());
  }

  /**
   * Test {@link Fp#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Fp#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#isZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.isZero()"})
  public void testIsZero_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp.ZERO.isZero());
  }

  /**
   * Test {@link Fp#isValid()}.
   *
   * <ul>
   *   <li>Given {@link Fp#Fp(BigInteger)} with v is {@link Params#P}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#isValid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.isValid()"})
  public void testIsValid_givenFpWithVIsP_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Fp(Params.P).isValid());
  }

  /**
   * Test {@link Fp#isValid()}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#isValid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.isValid()"})
  public void testIsValid_givenNon_residue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Fp.NON_RESIDUE.isValid());
  }

  /**
   * Test {@link Fp#bytes()}.
   *
   * <ul>
   *   <li>Given {@link Fp#NON_RESIDUE}.
   *   <li>Then return array of {@code byte} with {@code 0} and {@code d}.
   * </ul>
   *
   * <p>Method under test: {@link Fp#bytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Fp.bytes()"})
  public void testBytes_givenNon_residue_thenReturnArrayOfByteWith0AndD() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        Fp.NON_RESIDUE.bytes());
  }

  /**
   * Test {@link Fp#equals(Object)}, and {@link Fp#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp#equals(Object)}
   *   <li>{@link Fp#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp fp = Fp.NON_RESIDUE;
    Fp fp2 = Fp.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp, fp2);
    assertEquals(fp.hashCode(), fp2.hashCode());
  }

  /**
   * Test {@link Fp#equals(Object)}, and {@link Fp#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp#equals(Object)}
   *   <li>{@link Fp#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fp createResult = Fp.create(BN128G2.FR_NEG_ONE);
    Fp createResult2 = Fp.create(BN128G2.FR_NEG_ONE);

    // Act and Assert
    assertEquals(createResult, createResult2);
    assertEquals(createResult.hashCode(), createResult2.hashCode());
  }

  /**
   * Test {@link Fp#equals(Object)}, and {@link Fp#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fp#equals(Object)}
   *   <li>{@link Fp#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fp fp = Fp.NON_RESIDUE;

    // Act and Assert
    assertEquals(fp, fp);
    int expectedHashCodeResult = fp.hashCode();
    assertEquals(expectedHashCodeResult, fp.hashCode());
  }

  /**
   * Test {@link Fp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp.ZERO, Fp.NON_RESIDUE);
  }

  /**
   * Test {@link Fp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new Fp(null), Fp.NON_RESIDUE);
  }

  /**
   * Test {@link Fp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fp createResult = Fp.create((BigInteger) null);

    // Act and Assert
    assertEquals(createResult, Fp.create((BigInteger) null));
  }

  /**
   * Test {@link Fp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp.NON_RESIDUE, null);
  }

  /**
   * Test {@link Fp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fp#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Fp.equals(Object)", "int Fp.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Fp.NON_RESIDUE, "Different type to Fp");
  }
}
