package org.tron.common.crypto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.ECField;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.Fp;
import org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Point;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.crypto.ECKey.ECDSASignature;
import org.tron.common.crypto.ECKey.MissingPrivateKeyException;

public class ECKeyDiffblueTest {
  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}, and {@link ECDSASignature#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ECDSASignature#equals(Object)}
   *   <li>{@link ECDSASignature#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ECDSASignature ecdsaSignature2 = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertEquals(ecdsaSignature, ecdsaSignature2);
    int expectedHashCodeResult = ecdsaSignature.hashCode();
    assertEquals(expectedHashCodeResult, ecdsaSignature2.hashCode());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}, and {@link ECDSASignature#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ECDSASignature#equals(Object)}
   *   <li>{@link ECDSASignature#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertEquals(ecdsaSignature, ecdsaSignature);
    int expectedHashCodeResult = ecdsaSignature.hashCode();
    assertEquals(expectedHashCodeResult, ecdsaSignature.hashCode());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(BigInteger.valueOf(1L), ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNotEquals(ecdsaSignature, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER));
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        "Different type to ECDSASignature");
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#fromComponents(byte[], byte[], byte)} with {@code r}, {@code s}, {@code v}.
   * <p>
   * Method under test: {@link ECDSASignature#fromComponents(byte[], byte[], byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECDSASignature ECDSASignature.fromComponents(byte[], byte[], byte)"})
  public void testECDSASignatureFromComponentsWithRSV() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ECDSASignature actualFromComponentsResult = ECDSASignature.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415826", actualFromComponentsResult.toHex());
    BigInteger bigInteger = actualFromComponentsResult.r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertEquals(actualFromComponentsResult.r, actualFromComponentsResult.s);
    assertEquals('A', actualFromComponentsResult.v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#ECDSASignature(BigInteger, BigInteger)}.
   * <p>
   * Method under test: {@link ECDSASignature#ECDSASignature(BigInteger, BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECDSASignature.<init>(BigInteger, BigInteger)"})
  public void testECDSASignatureNewECDSASignature() {
    // Arrange and Act
    ECDSASignature actualEcdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Assert
    BigInteger bigInteger = actualEcdsaSignature.r;
    assertEquals("57896044618658097711785492504343953926418782139537452191302581570759080747168",
        bigInteger.toString());
    BigInteger bigInteger2 = actualEcdsaSignature.s;
    assertEquals("57896044618658097711785492504343953926418782139537452191302581570759080747168",
        bigInteger2.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals(5, bigInteger.getLowestSetBit());
    assertEquals(5, bigInteger2.getLowestSetBit());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ']', 'W',
        'n', 's', 'W', -92, 'P', 29, -33, -23, '/', 'F', 'h', 27, ' ', -96}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ']', 'W',
        'n', 's', 'W', -92, 'P', 29, -33, -23, '/', 'F', 'h', 27, ' ', -96}, bigInteger2.toByteArray());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#ECDSASignature(byte[], byte[], byte)}.
   * <p>
   * Method under test: {@link ECDSASignature#ECDSASignature(byte[], byte[], byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECDSASignature.<init>(byte[], byte[], byte)"})
  public void testECDSASignatureNewECDSASignature2() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ECDSASignature actualEcdsaSignature = new ECDSASignature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415826", actualEcdsaSignature.toHex());
    BigInteger bigInteger = actualEcdsaSignature.r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertEquals(actualEcdsaSignature.r, actualEcdsaSignature.s);
    assertEquals('A', actualEcdsaSignature.v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toBase64()}.
   * <p>
   * Method under test: {@link ECDSASignature#toBase64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ECDSASignature.toBase64()"})
  public void testECDSASignatureToBase64() {
    // Arrange, Act and Assert
    assertEquals("AH////////////////////9dV25zV6RQHd/pL0ZoGyCgf////////////////////11XbnNXpFAd3+kvRmgbIKA=",
        (new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toBase64());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toByteArray()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#toByteArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECDSASignature.toByteArray()"})
  public void testECDSASignatureToByteArray_givenA_thenReturnFirstElementIsZero() {
    // Arrange and Act
    byte[] actualToByteArrayResult = (new ECDSASignature(new byte[]{'A', 27, 'A', 27, 'A', 27, 'A', 27},
        new byte[]{'A', 27, 'A', 27, 'A', 27, 'A', 27}, (byte) 'A')).toByteArray();

    // Assert
    assertEquals((byte) 0, actualToByteArrayResult[0]);
    assertEquals((byte) 0, actualToByteArrayResult[1]);
    assertEquals((byte) 0, actualToByteArrayResult[10]);
    assertEquals((byte) 0, actualToByteArrayResult[11]);
    assertEquals((byte) 0, actualToByteArrayResult[12]);
    assertEquals((byte) 0, actualToByteArrayResult[13]);
    assertEquals((byte) 0, actualToByteArrayResult[14]);
    assertEquals((byte) 0, actualToByteArrayResult[15]);
    assertEquals((byte) 0, actualToByteArrayResult[17]);
    assertEquals((byte) 0, actualToByteArrayResult[18]);
    assertEquals((byte) 0, actualToByteArrayResult[19]);
    assertEquals((byte) 0, actualToByteArrayResult[2]);
    assertEquals((byte) 0, actualToByteArrayResult[20]);
    assertEquals((byte) 0, actualToByteArrayResult[21]);
    assertEquals((byte) 0, actualToByteArrayResult[22]);
    assertEquals((byte) 0, actualToByteArrayResult[23]);
    assertEquals((byte) 0, actualToByteArrayResult[3]);
    assertEquals((byte) 0, actualToByteArrayResult[4]);
    assertEquals((byte) 0, actualToByteArrayResult[40]);
    assertEquals((byte) 0, actualToByteArrayResult[41]);
    assertEquals((byte) 0, actualToByteArrayResult[42]);
    assertEquals((byte) 0, actualToByteArrayResult[43]);
    assertEquals((byte) 0, actualToByteArrayResult[44]);
    assertEquals((byte) 0, actualToByteArrayResult[45]);
    assertEquals((byte) 0, actualToByteArrayResult[46]);
    assertEquals((byte) 0, actualToByteArrayResult[47]);
    assertEquals((byte) 0, actualToByteArrayResult[48]);
    assertEquals((byte) 0, actualToByteArrayResult[49]);
    assertEquals((byte) 0, actualToByteArrayResult[5]);
    assertEquals((byte) 0, actualToByteArrayResult[50]);
    assertEquals((byte) 0, actualToByteArrayResult[51]);
    assertEquals((byte) 0, actualToByteArrayResult[52]);
    assertEquals((byte) 0, actualToByteArrayResult[53]);
    assertEquals((byte) 0, actualToByteArrayResult[54]);
    assertEquals((byte) 0, actualToByteArrayResult[55]);
    assertEquals((byte) 0, actualToByteArrayResult[6]);
    assertEquals((byte) 0, actualToByteArrayResult[7]);
    assertEquals((byte) 0, actualToByteArrayResult[8]);
    assertEquals((byte) 0, actualToByteArrayResult[9]);
    assertEquals((byte) 0, actualToByteArrayResult[Short.SIZE]);
    assertEquals((byte) 27, actualToByteArrayResult[57]);
    assertEquals((byte) 27, actualToByteArrayResult[59]);
    assertEquals((byte) 27, actualToByteArrayResult[63]);
    assertEquals(65, actualToByteArrayResult.length);
    assertEquals('&', actualToByteArrayResult[Double.SIZE]);
    assertEquals('A', actualToByteArrayResult[24]);
    assertEquals('A', actualToByteArrayResult[56]);
    assertEquals('A', actualToByteArrayResult[58]);
    assertEquals('A', actualToByteArrayResult[60]);
    assertEquals('A', actualToByteArrayResult[62]);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toByteArray()}.
   * <ul>
   *   <li>Then return second element is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#toByteArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECDSASignature.toByteArray()"})
  public void testECDSASignatureToByteArray_thenReturnSecondElementIsMinusOne() {
    // Arrange and Act
    byte[] actualToByteArrayResult = (new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toByteArray();

    // Assert
    assertEquals((byte) -1, actualToByteArrayResult[1]);
    assertEquals((byte) -1, actualToByteArrayResult[10]);
    assertEquals((byte) -1, actualToByteArrayResult[11]);
    assertEquals((byte) -1, actualToByteArrayResult[12]);
    assertEquals((byte) -1, actualToByteArrayResult[13]);
    assertEquals((byte) -1, actualToByteArrayResult[14]);
    assertEquals((byte) -1, actualToByteArrayResult[15]);
    assertEquals((byte) -1, actualToByteArrayResult[2]);
    assertEquals((byte) -1, actualToByteArrayResult[3]);
    assertEquals((byte) -1, actualToByteArrayResult[4]);
    assertEquals((byte) -1, actualToByteArrayResult[40]);
    assertEquals((byte) -1, actualToByteArrayResult[41]);
    assertEquals((byte) -1, actualToByteArrayResult[42]);
    assertEquals((byte) -1, actualToByteArrayResult[43]);
    assertEquals((byte) -1, actualToByteArrayResult[44]);
    assertEquals((byte) -1, actualToByteArrayResult[45]);
    assertEquals((byte) -1, actualToByteArrayResult[46]);
    assertEquals((byte) -1, actualToByteArrayResult[47]);
    assertEquals((byte) -1, actualToByteArrayResult[5]);
    assertEquals((byte) -1, actualToByteArrayResult[6]);
    assertEquals((byte) -1, actualToByteArrayResult[7]);
    assertEquals((byte) -1, actualToByteArrayResult[8]);
    assertEquals((byte) -1, actualToByteArrayResult[9]);
    assertEquals((byte) -23, actualToByteArrayResult[57]);
    assertEquals((byte) -33, actualToByteArrayResult[24]);
    assertEquals((byte) -33, actualToByteArrayResult[56]);
    assertEquals((byte) -92, actualToByteArrayResult[21]);
    assertEquals((byte) -92, actualToByteArrayResult[53]);
    assertEquals((byte) -96, actualToByteArrayResult[63]);
    assertEquals((byte) 0, actualToByteArrayResult[Double.SIZE]);
    assertEquals((byte) 29, actualToByteArrayResult[23]);
    assertEquals((byte) 29, actualToByteArrayResult[55]);
    assertEquals(65, actualToByteArrayResult.length);
    assertEquals(Byte.MAX_VALUE, actualToByteArrayResult[0]);
    assertEquals(' ', actualToByteArrayResult[62]);
    assertEquals('/', actualToByteArrayResult[58]);
    assertEquals('F', actualToByteArrayResult[59]);
    assertEquals('P', actualToByteArrayResult[22]);
    assertEquals('P', actualToByteArrayResult[54]);
    assertEquals('W', actualToByteArrayResult[17]);
    assertEquals('W', actualToByteArrayResult[20]);
    assertEquals('W', actualToByteArrayResult[49]);
    assertEquals('W', actualToByteArrayResult[52]);
    assertEquals(']', actualToByteArrayResult[48]);
    assertEquals(']', actualToByteArrayResult[Short.SIZE]);
    assertEquals('h', actualToByteArrayResult[60]);
    assertEquals('n', actualToByteArrayResult[18]);
    assertEquals('n', actualToByteArrayResult[50]);
    assertEquals('s', actualToByteArrayResult[19]);
    assertEquals('s', actualToByteArrayResult[51]);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toCanonicalised()}.
   * <p>
   * Method under test: {@link ECDSASignature#toCanonicalised()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECDSASignature ECDSASignature.toCanonicalised()"})
  public void testECDSASignatureToCanonicalised() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertSame(ecdsaSignature, ecdsaSignature.toCanonicalised());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toHex()}.
   * <p>
   * Method under test: {@link ECDSASignature#toHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ECDSASignature.toHex()"})
  public void testECDSASignatureToHex() {
    // Arrange, Act and Assert
    assertEquals(
        "7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07fffffffffffffffffffffffffffffff5d57"
            + "6e7357a4501ddfe92f46681b20a000",
        (new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toHex());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toHex()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#toHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ECDSASignature.toHex()"})
  public void testECDSASignatureToHex_givenA_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "000000000000000000000000000000000000000000000000411b411b411b411b000000000000000000000000000000000000"
            + "000000000000411b411b411b411b26",
        (new ECDSASignature(new byte[]{'A', 27, 'A', 27, 'A', 27, 'A', 27},
            new byte[]{'A', 27, 'A', 27, 'A', 27, 'A', 27}, (byte) 'A')).toHex());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents() {
    // Arrange, Act and Assert
    assertFalse((new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents2() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertTrue(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents3() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 28;

    // Act and Assert
    assertTrue(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents4() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(BigInteger.valueOf(-1L), ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertFalse(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents5() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(-1L));
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertFalse(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte() {
    // Arrange, Act and Assert
    assertFalse(ECDSASignature.validateComponents(BigInteger.valueOf(-1L), null, (byte) 27));
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ECDSASignature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 27));
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_whenA() {
    // Arrange, Act and Assert
    assertFalse(ECDSASignature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 'A'));
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <ul>
   *   <li>When twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_whenTwentyEight() {
    // Arrange, Act and Assert
    assertTrue(ECDSASignature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 28));
  }

  /**
   * Test MissingPrivateKeyException new {@link MissingPrivateKeyException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MissingPrivateKeyException}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MissingPrivateKeyException.<init>()"})
  public void testMissingPrivateKeyExceptionNewMissingPrivateKeyException() {
    // Arrange and Act
    MissingPrivateKeyException actualMissingPrivateKeyException = new MissingPrivateKeyException();

    // Assert
    assertNull(actualMissingPrivateKeyException.getMessage());
    assertNull(actualMissingPrivateKeyException.getCause());
    assertEquals(0, actualMissingPrivateKeyException.getSuppressed().length);
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();
    EllipticCurve ellipticCurve = new EllipticCurve(mock(ECField.class), ECKey.HALF_CURVE_ORDER,
        ECKey.HALF_CURVE_ORDER);

    BCDSTU4145PrivateKey privKey = new BCDSTU4145PrivateKey(new ECPrivateKeySpec(ECKey.HALF_CURVE_ORDER,
        new ECParameterSpec(ellipticCurve,
            new java.security.spec.ECPoint(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), ECKey.HALF_CURVE_ORDER,
            1)));

    // Act
    ECKey actualEcKey = new ECKey(provider, privKey, mock(ECPoint.class));

    // Assert
    BigInteger bigInteger = actualEcKey.HALF_CURVE_ORDER;
    ECParameterSpec params = privKey.getParams();
    assertSame(bigInteger, params.getOrder());
    java.security.spec.ECPoint generator = params.getGenerator();
    assertSame(bigInteger, generator.getAffineX());
    assertSame(bigInteger, generator.getAffineY());
    EllipticCurve curve = params.getCurve();
    assertSame(bigInteger, curve.getA());
    assertSame(bigInteger, curve.getB());
    assertSame(bigInteger, privKey.getD());
    assertSame(bigInteger, privKey.getS());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ']', 'W',
        'n', 's', 'W', -92, 'P', 29, -33, -23, '/', 'F', 'h', 27, ' ', -96}, actualEcKey.getPrivKeyBytes());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ']', 'W',
        'n', 's', 'W', -92, 'P', 29, -33, -23, '/', 'F', 'h', 27, ' ', -96}, actualEcKey.getPrivateKey());
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   * <ul>
   *   <li>Given {@code Algorithm}.</li>
   *   <li>When {@link AnnotatedPrivateKey} {@link AnnotatedPrivateKey#getAlgorithm()} return {@code Algorithm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_givenAlgorithm_whenAnnotatedPrivateKeyGetAlgorithmReturnAlgorithm() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("Algorithm");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ECKey(provider, privKey, mock(ECPoint.class)));

    verify(privKey, atLeast(1)).getAlgorithm();
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   * <ul>
   *   <li>Given {@code EC}.</li>
   *   <li>Then return not PubKeyOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_givenEc_thenReturnNotPubKeyOnly() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("EC");

    // Act
    ECKey actualEcKey = new ECKey(provider, privKey, mock(ECPoint.class));

    // Assert
    verify(privKey).getAlgorithm();
    assertNull(actualEcKey.getPrivKeyBytes());
    assertNull(actualEcKey.getPrivateKey());
    assertFalse(actualEcKey.isPubKeyOnly());
    assertTrue(actualEcKey.hasPrivKey());
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code EC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_givenIllegalArgumentExceptionWithEc() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenThrow(new IllegalArgumentException("EC"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ECKey(provider, privKey, mock(ECPoint.class)));

    verify(privKey).getAlgorithm();
  }

  /**
   * Test {@link ECKey#ECKey(Provider, SecureRandom)}.
   * <ul>
   *   <li>Then PubKeyPoint AffineXCoord return {@link SecP256K1FieldElement}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, SecureRandom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, SecureRandom)"})
  public void testNewECKey_thenPubKeyPointAffineXCoordReturnSecP256K1FieldElement() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    // Act and Assert
    ECPoint pubKeyPoint = (new ECKey(provider, new SecureRandom())).getPubKeyPoint();
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof SecP256K1FieldElement);
    assertTrue(pubKeyPoint instanceof SecP256K1Point);
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
  }

  /**
   * Test {@link ECKey#ECKey(byte[], boolean)}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return toStringWithPrivate is {@code pub:00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(byte[], boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(byte[], boolean)"})
  public void testNewECKey_whenArrayOfByteWithZero_thenReturnToStringWithPrivateIsPub00() {
    // Arrange and Act
    ECKey actualEcKey = new ECKey(new byte[]{0}, false);

    // Assert
    assertEquals("pub:00", actualEcKey.toStringWithPrivate());
    assertNull(actualEcKey.getPrivKeyBytes());
    assertNull(actualEcKey.getPrivateKey());
    assertFalse(actualEcKey.hasPrivKey());
    assertTrue(actualEcKey.isPubKeyOnly());
    assertArrayEquals(new byte[]{}, actualEcKey.getNodeId());
    assertArrayEquals(new byte[]{0}, actualEcKey.getPubKey());
    assertArrayEquals(
        new byte[]{'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123, -92, 'p'},
        actualEcKey.getAddress());
  }

  /**
   * Test {@link ECKey#ECKey(Provider, SecureRandom)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then PubKeyPoint return {@link SecP256K1Point}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, SecureRandom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, SecureRandom)"})
  public void testNewECKey_whenNull_thenPubKeyPointReturnSecP256K1Point() {
    // Arrange, Act and Assert
    assertTrue((new ECKey(new BouncyCastleProvider(), null)).getPubKeyPoint() instanceof SecP256K1Point);
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not hasPrivKey.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_whenNull_thenReturnNotHasPrivKey() {
    // Arrange and Act
    ECKey actualEcKey = new ECKey(new BouncyCastleProvider(), null, mock(ECPoint.class));

    // Assert
    assertNull(actualEcKey.getPrivKeyBytes());
    assertNull(actualEcKey.getPrivateKey());
    assertFalse(actualEcKey.hasPrivKey());
    assertTrue(actualEcKey.isPubKeyOnly());
  }

  /**
   * Test {@link ECKey#ECKey(BigInteger, ECPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(BigInteger, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(BigInteger, ECPoint)"})
  public void testNewECKey_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ECKey((BigInteger) null, null));

  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ECKey(new BouncyCastleProvider(), null, null));

  }

  /**
   * Test {@link ECKey#compressPoint(ECPoint)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#compressPoint(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECPoint ECKey.compressPoint(ECPoint)"})
  public void testCompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint uncompressed = mock(ECPoint.class);
    when(uncompressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.compressPoint(uncompressed));
    verify(uncompressed).getEncoded(eq(true));
  }

  /**
   * Test {@link ECKey#decompressPoint(ECPoint)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#decompressPoint(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECPoint ECKey.decompressPoint(ECPoint)"})
  public void testDecompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint compressed = mock(ECPoint.class);
    when(compressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.decompressPoint(compressed));
    verify(compressed).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#fromPrivate(byte[])} with {@code privKeyBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#fromPrivate(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPrivate(byte[])"})
  public void testFromPrivateWithPrivKeyBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ECKey.fromPrivate((byte[]) null));
  }

  /**
   * Test {@link ECKey#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)} with {@code BigInteger}, {@code ECPoint}.
   * <p>
   * Method under test: {@link ECKey#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)"})
  public void testFromPrivateAndPrecalculatedPublicWithBigIntegerECPoint() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.fromPrivateAndPrecalculatedPublic((BigInteger) null, null));
  }

  /**
   * Test {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <p>
   * Method under test: {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPrivateAndPrecalculatedPublic((byte[]) null, null));
  }

  /**
   * Test {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <p>
   * Method under test: {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.fromPrivateAndPrecalculatedPublic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test {@link ECKey#fromPublicOnly(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then PubKeyPoint return {@link Fp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#fromPublicOnly(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPublicOnly(byte[])"})
  public void testFromPublicOnlyWithByte_whenArrayOfByteWithZero_thenPubKeyPointReturnFp() {
    // Arrange and Act
    ECKey actualFromPublicOnlyResult = ECKey.fromPublicOnly(new byte[]{0});

    // Assert
    assertTrue(actualFromPublicOnlyResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:00", actualFromPublicOnlyResult.toStringWithPrivate());
    assertNull(actualFromPublicOnlyResult.getPrivKeyBytes());
    assertNull(actualFromPublicOnlyResult.getPrivateKey());
    assertFalse(actualFromPublicOnlyResult.hasPrivKey());
    assertFalse(actualFromPublicOnlyResult.isPubKeyCanonical());
    assertTrue(actualFromPublicOnlyResult.isPubKeyOnly());
    assertArrayEquals(new byte[]{}, actualFromPublicOnlyResult.getNodeId());
    assertArrayEquals(new byte[]{0}, actualFromPublicOnlyResult.getPubKey());
    assertArrayEquals(
        new byte[]{'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123, -92, 'p'},
        actualFromPublicOnlyResult.getAddress());
  }

  /**
   * Test {@link ECKey#fromPublicOnly(ECPoint)} with {@code ECPoint}.
   * <ul>
   *   <li>When {@link ECPoint}.</li>
   *   <li>Then return PrivKeyBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPublicOnly(ECPoint)"})
  public void testFromPublicOnlyWithECPoint_whenECPoint_thenReturnPrivKeyBytesIsNull() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);

    // Act
    ECKey actualFromPublicOnlyResult = ECKey.fromPublicOnly(pub);

    // Assert
    assertNull(actualFromPublicOnlyResult.getPrivKeyBytes());
    assertNull(actualFromPublicOnlyResult.getPrivateKey());
    assertNull(actualFromPublicOnlyResult.getPubKey());
    assertFalse(actualFromPublicOnlyResult.hasPrivKey());
    assertTrue(actualFromPublicOnlyResult.isPubKeyOnly());
    assertSame(pub, actualFromPublicOnlyResult.getPubKeyPoint());
  }

  /**
   * Test {@link ECKey#fromPublicOnly(ECPoint)} with {@code ECPoint}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromPublicOnly(ECPoint)"})
  public void testFromPublicOnlyWithECPoint_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly((ECPoint) null));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>Then return array of {@code byte} with three and minus thirty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithThreeAndMinusThirtyOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{3, -31, 26, 'n', 22, -32, '\\', 'D', 7, 'J', -63, 27, 'H', -39, '@', -123, -48, -87, -97, '\b', 'w',
            -35, 28, 'o', 'v', -3, '\r', -84, 'K', -75, '\t', 'd', -29},
        ECKey.publicKeyFromPrivate(BigInteger.valueOf(Long.MIN_VALUE), true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>Then return array of {@code byte} with three and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithThreeAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ';', 'x', -50, 'V', '?', -119, -96, -19, -108, 20,
        -11, -86, '(', -83, '\r', -106, -42, 'y', '_', -100, 'c'},
        ECKey.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>Then return forty-second element is minus one hundred four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnFortySecondElementIsMinusOneHundredFour() {
    // Arrange and Act
    byte[] actualPublicKeyFromPrivateResult = ECKey.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, false);

    // Assert
    assertEquals((byte) -104, actualPublicKeyFromPrivateResult[41]);
    assertEquals((byte) -108, actualPublicKeyFromPrivateResult[20]);
    assertEquals((byte) -119, actualPublicKeyFromPrivateResult[17]);
    assertEquals((byte) -119, actualPublicKeyFromPrivateResult[44]);
    assertEquals((byte) -11, actualPublicKeyFromPrivateResult[22]);
    assertEquals((byte) -13, actualPublicKeyFromPrivateResult[Double.SIZE]);
    assertEquals((byte) -14, actualPublicKeyFromPrivateResult[47]);
    assertEquals((byte) -19, actualPublicKeyFromPrivateResult[19]);
    assertEquals((byte) -1, actualPublicKeyFromPrivateResult[48]);
    assertEquals((byte) -35, actualPublicKeyFromPrivateResult[52]);
    assertEquals((byte) -35, actualPublicKeyFromPrivateResult[63]);
    assertEquals((byte) -39, actualPublicKeyFromPrivateResult[50]);
    assertEquals((byte) -4, actualPublicKeyFromPrivateResult[56]);
    assertEquals((byte) -50, actualPublicKeyFromPrivateResult[14]);
    assertEquals((byte) -50, actualPublicKeyFromPrivateResult[54]);
    assertEquals((byte) -54, actualPublicKeyFromPrivateResult[59]);
    assertEquals((byte) -55, actualPublicKeyFromPrivateResult[43]);
    assertEquals((byte) -57, actualPublicKeyFromPrivateResult[46]);
    assertEquals((byte) -82, actualPublicKeyFromPrivateResult[45]);
    assertEquals((byte) -86, actualPublicKeyFromPrivateResult[23]);
    assertEquals((byte) -96, actualPublicKeyFromPrivateResult[18]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[1]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[10]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[11]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[2]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[3]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[4]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[5]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[58]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[6]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[7]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[8]);
    assertEquals((byte) 0, actualPublicKeyFromPrivateResult[9]);
    assertEquals((byte) 14, actualPublicKeyFromPrivateResult[61]);
    assertEquals((byte) 16, actualPublicKeyFromPrivateResult[60]);
    assertEquals((byte) 20, actualPublicKeyFromPrivateResult[21]);
    assertEquals((byte) 27, actualPublicKeyFromPrivateResult[51]);
    assertEquals((byte) 2, actualPublicKeyFromPrivateResult[40]);
    assertEquals((byte) 2, actualPublicKeyFromPrivateResult[55]);
    assertEquals((byte) 4, actualPublicKeyFromPrivateResult[0]);
    assertEquals(65, actualPublicKeyFromPrivateResult.length);
    assertEquals((byte) 7, actualPublicKeyFromPrivateResult[57]);
    assertEquals('(', actualPublicKeyFromPrivateResult[24]);
    assertEquals('.', actualPublicKeyFromPrivateResult[49]);
    assertEquals(';', actualPublicKeyFromPrivateResult[12]);
    assertEquals('=', actualPublicKeyFromPrivateResult[42]);
    assertEquals('?', actualPublicKeyFromPrivateResult[Short.SIZE]);
    assertEquals('V', actualPublicKeyFromPrivateResult[15]);
    assertEquals('Y', actualPublicKeyFromPrivateResult[62]);
    assertEquals('i', actualPublicKeyFromPrivateResult[53]);
    assertEquals('x', actualPublicKeyFromPrivateResult[13]);
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return array of {@code byte} with two and {@code y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenValueOfOne_thenReturnArrayOfByteWithTwoAndY() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{2, 'y', -66, 'f', '~', -7, -36, -69, -84, 'U', -96, 'b', -107, -50, -121, 11, 7, 2, -101, -4, -37,
            '-', -50, '(', -39, 'Y', -14, -127, '[', 22, -8, 23, -104},
        ECKey.publicKeyFromPrivate(BigInteger.valueOf(1L), true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenValueOfZero_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0}, ECKey.publicKeyFromPrivate(BigInteger.valueOf(0L), true));
  }

  /**
   * Test {@link ECKey#pubBytesWithoutFormat(ECPoint)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_givenAxaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubBytesWithoutFormatResult = ECKey.pubBytesWithoutFormat(pubPoint);

    // Assert
    verify(pubPoint).getEncoded(eq(false));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualPubBytesWithoutFormatResult);
  }

  /**
   * Test {@link ECKey#pubBytesWithoutFormat(ECPoint)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.pubBytesWithoutFormat(pubPoint));
    verify(pubPoint).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#fromNodeId(byte[])}.
   * <p>
   * Method under test: {@link ECKey#fromNodeId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.fromNodeId(byte[])"})
  public void testFromNodeId() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromNodeId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#signatureToKeyBytes(byte[], ECDSASignature)} with {@code messageHash}, {@code sig}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#signatureToKeyBytes(byte[], ECDSASignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.signatureToKeyBytes(byte[], ECDSASignature)"})
  public void testSignatureToKeyBytesWithMessageHashSig_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange
    byte[] messageHash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.signatureToKeyBytes(messageHash,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)));
  }

  /**
   * Test {@link ECKey#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code signatureBase64}.
   * <p>
   * Method under test: {@link ECKey#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> ECKey.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link ECKey#signatureToAddress(byte[], ECDSASignature)} with {@code messageHash}, {@code sig}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#signatureToAddress(byte[], ECDSASignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.signatureToAddress(byte[], ECDSASignature)"})
  public void testSignatureToAddressWithMessageHashSig_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange
    byte[] messageHash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.signatureToAddress(messageHash,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)));
  }

  /**
   * Test {@link ECKey#signatureToAddress(byte[], String)} with {@code messageHash}, {@code signatureBase64}.
   * <ul>
   *   <li>Then throw {@link SignatureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_thenThrowSignatureException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> ECKey.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link ECKey#signatureToKey(byte[], String)}.
   * <ul>
   *   <li>When {@code Could not decode base64}.</li>
   *   <li>Then throw {@link SignatureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#signatureToKey(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.signatureToKey(byte[], String)"})
  public void testSignatureToKey_whenCouldNotDecodeBase64_thenThrowSignatureException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> ECKey.signatureToKey("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with four.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical(new byte[]{4}));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical(new byte[]{3}));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical(new byte[]{2}));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ECKey()).isPubKeyCanonical());
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte} with four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithFourAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn(new byte[]{4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte} with three and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithThreeAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte} with two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithTwoAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).isPubKeyCanonical());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -108, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -113, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -114, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -12, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -13, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -16, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -31, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -32, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -35, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -40, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -41, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -48, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -51, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -51, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -53, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -59, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -68, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -69, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -97, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) 15, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) 18, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) 20, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) 25, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals(',', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('<', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('U', actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('^', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('i', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('m', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('|', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('~', actualRecoverPubBytesFromSignatureResult[48]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature2() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(0,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals((byte) -101, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -105, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -108, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -10, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -111, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -114, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -124, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -18, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -24, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -41, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -42, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -59, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -73, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -78, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -86, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -93, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals((byte) 6, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals(Byte.MIN_VALUE, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('&', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('3', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('6', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('"', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('\b', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('b', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('h', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('o', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('s', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[21]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature3() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals((byte) -105, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -106, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -108, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -10, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -11, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -18, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -30, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -35, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -59, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -64, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -69, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -73, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -74, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -81, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -83, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -85, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) 0, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('#', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('$', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('2', actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals(':', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('=', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('>', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('K', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('S', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('T', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('\r', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('\t', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('a', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('b', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('v', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('v', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[63]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature4() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(BigInteger.valueOf(-1L), ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverPubBytesFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature5() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(-1L));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverPubBytesFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return eighth element is minus one hundred eleven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnEighthElementIsMinusOneHundredEleven() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Assert
    assertEquals((byte) -111, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -113, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -120, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -121, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -18, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -20, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -21, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -25, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -28, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) -38, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -42, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -52, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -54, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -62, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -85, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -96, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) 28, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) 30, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('$', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('-', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('/', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('C', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('D', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('H', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('U', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('\\', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('\b', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('i', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('y', actualRecoverPubBytesFromSignatureResult[6]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return fifty-fifth element is minus one hundred two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFiftyFifthElementIsMinusOneHundredTwo() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), new byte[]{});

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -112, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -116, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -3, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -77, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -92, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -9, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) 11, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) 30, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('6', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('8', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('C', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('\\', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('n', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('s', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('}', actualRecoverPubBytesFromSignatureResult[50]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return fifty-seventh element is minus eleven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFiftySeventhElementIsMinusEleven()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(BigInteger.valueOf(1L), ECKey.HALF_CURVE_ORDER);

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -11, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -12, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -24, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -27, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -38, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -50, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -51, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -59, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -70, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -71, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -87, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -89, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -89, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -8, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -95, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) 15, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) 31, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals((byte) 6, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals(',', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('-', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('/', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('/', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('1', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('3', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals(':', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('<', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('L', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('T', actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('\b', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('o', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('}', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('}', actualRecoverPubBytesFromSignatureResult[6]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return tenth element is minus one hundred two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnTenthElementIsMinusOneHundredTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(1L));

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = ECKey.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -111, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -126, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -30, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -34, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -36, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -38, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -64, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -70, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -71, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -74, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -81, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -84, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -86, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -97, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) 11, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) 21, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) 28, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) 5, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) 5, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('$', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('\'', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals(')', actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals('0', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('D', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('L', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('N', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('\r', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[7]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.recoverPubBytesFromSignature(-1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenTwo_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(ECKey.recoverPubBytesFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.recoverPubBytesFromSignature(0,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(BigInteger.valueOf(-1L), ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature2() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(-1L));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code c}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndC() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'c', -119, -36, '\b', 's', '}', 'i', -123, '>', -72, 'x', 'S', -66, '6', 'x', -33, 'A', 'k', 5,
            -73},
        ECKey.recoverAddressFromSignature(1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[]{}));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndCr() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(BigInteger.valueOf(1L), ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '\r', 'G', -52, -8, 26, -28, -11, 'O', 19, -49, -125, -84, -84, '\n', '-', 28,
        'l', '-', -24, 25}, ECKey.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndExclamationMark() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', '!', -4, -68, -21, -122, 'o', -47, -80, -117, -63, 'L', 'v', 't', ']', 'o', -114, -72, -2, -109,
            '\\'},
        ECKey.recoverAddressFromSignature(0, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus eighty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusEightyThree()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertArrayEquals(new byte[]{'A', -83, -3, -117, -99, -41, -19, -76, 'I', -126, 'h', -42, -75, 4, -90, 'O', '<',
        'p', -87, -12, '^'}, ECKey.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus fifty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusFiftyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', -54, -114, 'g', -12, 'S', -4, Byte.MAX_VALUE, -69, -93, -46, 's', -56, -75, -56, 'w', -72, -54,
            -62, -45, -1},
        ECKey.recoverAddressFromSignature(1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus thirty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusThirtyThree()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(1L));

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', -33, -3, 'Q', 6, 'O', -9, 'L', -45, 'Q', -62, '~', 'Y', -77, -72, -99, ']', -35, -45, 19, -104},
        ECKey.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndRightParenthesis() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', ')', 28, -53, -50, -108, 'o', 'i', 'q', 'v', -123, -43, -121, '$', '(', -127, '!', -91, 'b',
            'J', -111},
        ECKey.recoverAddressFromSignature(1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A',
                1}));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.recoverAddressFromSignature(-1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_whenTwo_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(ECKey.recoverAddressFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.recoverAddressFromSignature(0,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(BigInteger.valueOf(-1L), ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature2() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(-1L));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code c}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndC() {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), new byte[]{});

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:047fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07a1e93400ed43e38b02fb360433690"
        + "dff77d0bfd1e9a72982849497f5c578c7f", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', 'c', -119, -36, '\b', 's', '}', 'i', -123, '>', -72, 'x', 'S', -66, '6', 'x', -33,
        'A', 'k', 5, -73}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ']', 'W',
        'n', 's', 'W', -92, 'P', 29, -33, -23, '/', 'F', 'h', 27, ' ', -96, 'z', 30, -109, '@', 14, -44, '>', '8', -80,
        '/', -77, '`', 'C', '6', -112, -33, -9, '}', 11, -3, 30, -102, 'r', -104, '(', 'I', 'I', Byte.MAX_VALUE, '\\',
        'W', -116, Byte.MAX_VALUE}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndCr() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(BigInteger.valueOf(1L), ECKey.HALF_CURVE_ORDER);

    // Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04bee5da3f317d0f54ba2c3c4506cea75f3a5a28ed2f2d084c2cc7b0fcdf56f72fc4fc97c438e6c54933e86ff8df2f21"
        + "ef4d5aa9a7cd2e7df5c54ddfa1f4edb91f", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', '\r', 'G', -52, -8, 26, -28, -11, 'O', 19, -49, -125, -84, -84, '\n', '-', 28,
        'l', '-', -24, 25}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[]{-66, -27, -38, '?', '1', '}', 15, 'T', -70, ',', '<', 'E', 6, -50, -89, '_', ':', 'Z', '(', -19, '/',
            '-', '\b', 'L', ',', -57, -80, -4, -33, 'V', -9, '/', -60, -4, -105, -60, '8', -26, -59, 'I', '3', -24, 'o',
            -8, -33, '/', '!', -17, 'M', 'Z', -87, -89, -51, '.', '}', -11, -59, 'M', -33, -95, -12, -19, -71, 31},
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndExclamationMark()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(0, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:045f78f998e82a98b0d674aab189d762b206f66b747b9704ffbc43f3ba5bbd3312eff3429a3430b3c85ac533d5682608"
        + "946f739b60a3db8022919eb78e1084ee36", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', '!', -4, -68, -21, -122, 'o', -47, -80, -117, -63, 'L', 'v', 't', ']', 'o', -114,
        -72, -2, -109, '\\'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{'_', 'x', -7, -104, -24, '*', -104, -80, -42, 't', -86, -79, -119, -41, 'b', -78, 6,
        -10, 'k', 't', '{', -105, 4, -1, -68, 'C', -13, -70, '[', -67, '3', 18, -17, -13, 'B', -102, '4', '0', -77, -56,
        'Z', -59, '3', -43, 'h', '&', '\b', -108, 'o', 's', -101, '`', -93, -37, Byte.MIN_VALUE, '"', -111, -98, -73,
        -114, 16, -124, -18, '6'}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus eighty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusEightyThree()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:0414bee1bbcd8e5e55d0d847d70a12bc032e9fcd506d0fe0f31e34792c57429f3b3d4180790e2a756728699a3c2c193b"
        + "7ef0bd1057cb2e7c948fc5dd78130378f4", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', -83, -3, -117, -99, -41, -19, -76, 'I', -126, 'h', -42, -75, 4, -90, 'O', '<',
        'p', -87, -12, '^'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{20, -66, -31, -69, -51, -114, '^', 'U', -48, -40, 'G', -41, '\n', 18, -68, 3, '.', -97,
        -51, 'P', 'm', 15, -32, -13, 30, '4', 'y', ',', 'W', 'B', -97, ';', '=', 'A', Byte.MIN_VALUE, 'y', 14, '*', 'u',
        'g', '(', 'i', -102, '<', ',', 25, ';', '~', -16, -67, 16, 'W', -53, '.', '|', -108, -113, -59, -35, 'x', 19, 3,
        'x', -12}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus fifty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusFiftyFour() {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04006b4bb70362d532ee610a0924bb2a012e94ad9e373e2523c42b34adcf259638b298afb7e50a2157f653c59796760d"
        + "543db6ab7b01dd3aaf76e2f5c0459d7b13", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', -54, -114, 'g', -12, 'S', -4, Byte.MAX_VALUE, -69, -93, -46, 's', -56, -75, -56,
        'w', -72, -54, -62, -45, -1}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{0, 'k', 'K', -73, 3, 'b', -43, '2', -18, 'a', '\n', '\t', '$', -69, '*', 1, '.', -108,
        -83, -98, '7', '>', '%', '#', -60, '+', '4', -83, -49, '%', -106, '8', -78, -104, -81, -73, -27, '\n', '!', 'W',
        -10, 'S', -59, -105, -106, 'v', '\r', 'T', '=', -74, -85, '{', 1, -35, ':', -81, 'v', -30, -11, -64, 'E', -99,
        '{', 19}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus thirty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusThirtyThree()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, BigInteger.valueOf(1L));

    // Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:042903a2893baa78ed9a44c7b021c8beba2750bd64059fb9156975b9d69246fbf7cc4da891f30d78da242f91fe740bb6"
        + "ef30af0dd5dc05c082e24c014edfac1cde", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[]{'A', -33, -3, 'Q', 6, 'O', -9, 'L', -45, 'Q', -62, '~', 'Y', -77, -72, -99, ']', -35, -45, 19, -104},
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[]{')', 3, -94, -119, ';', -86, 'x', -19, -102, 'D', -57, -80, '!', -56, -66, -70, '\'', 'P', -67, 'd',
            5, -97, -71, 21, 'i', 'u', -71, -42, -110, 'F', -5, -9, -52, 'M', -88, -111, -13, '\r', 'x', -38, '$', '/',
            -111, -2, 't', 11, -74, -17, '0', -81, '\r', -43, -36, 5, -64, -126, -30, 'L', 1, 'N', -33, -84, 28, -34},
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndRightParenthesis() {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult = ECKey.recoverFromSignature(1,
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04eee74845437991eb2f9d502d87ed8f21db4521ab881c246440be77c3e760c2ae902cb4215235d74da0b1e90369451d"
        + "5fcaec44dad6cc640855e46b6b495cc21e", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', ')', 28, -53, -50, -108, 'o', 'i', 'q', 'v', -123, -43, -121, '$', '(', -127, '!',
        -91, 'b', 'J', -111}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-18, -25, 'H', 'E', 'C', 'y', -111, -21, '/', -99, 'P', '-', -121, -19, -113, '!', -37,
        'E', '!', -85, -120, 28, '$', 'd', '@', -66, 'w', -61, -25, '`', -62, -82, -112, ',', -76, '!', 'R', '5', -41,
        'M', -96, -79, -23, 3, 'i', 'E', 29, '_', -54, -20, 'D', -38, -42, -52, 'd', '\b', 'U', -28, 'k', 'k', 'I',
        '\\', -62, 30}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ECKey.recoverFromSignature(1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_whenTwo_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    ECDSASignature sig = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(ECKey.recoverFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#isPubKeyOnly()}.
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyOnly()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyOnly()"})
  public void testIsPubKeyOnly_givenECKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ECKey()).isPubKeyOnly());
  }

  /**
   * Test {@link ECKey#isPubKeyOnly()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#isPubKeyOnly()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.isPubKeyOnly()"})
  public void testIsPubKeyOnly_givenFromPublicOnlyECPoint_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ECKey.fromPublicOnly(mock(ECPoint.class)).isPubKeyOnly());
  }

  /**
   * Test {@link ECKey#hasPrivKey()}.
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#hasPrivKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.hasPrivKey()"})
  public void testHasPrivKey_givenECKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ECKey()).hasPrivKey());
  }

  /**
   * Test {@link ECKey#hasPrivKey()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#hasPrivKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.hasPrivKey()"})
  public void testHasPrivKey_givenFromPublicOnlyECPoint_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.fromPublicOnly(mock(ECPoint.class)).hasPrivKey());
  }

  /**
   * Test {@link ECKey#getAddress()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getAddress()"})
  public void testGetAddress_thenReturnArrayOfByteWithAAndNineteen() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualAddress = ECKey.fromPublicOnly(pub).getAddress();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertArrayEquals(new byte[]{'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31, -24,
        -124, '5', -121, -26}, actualAddress);
  }

  /**
   * Test {@link ECKey#getAddress()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getAddress()"})
  public void testGetAddress_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).getAddress());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#signHash(byte[])}.
   * <p>
   * Method under test: {@link ECKey#signHash(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ECKey.signHash(byte[])"})
  public void testSignHash() throws UnsupportedEncodingException {
    // Arrange
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ecKey.signHash("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#Base64toBytes(String)}.
   * <ul>
   *   <li>Then return forty-fifth element is minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#Base64toBytes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.Base64toBytes(String)"})
  public void testBase64toBytes_thenReturnFortyFifthElementIsMinusTwentyNine() {
    // Arrange and Act
    byte[] actualBase64toBytesResult = (new ECKey())
        .Base64toBytes("fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141");

    // Assert
    assertEquals((byte) -29, actualBase64toBytesResult[44]);
    assertEquals((byte) -33, actualBase64toBytesResult[1]);
    assertEquals((byte) -33, actualBase64toBytesResult[10]);
    assertEquals((byte) -33, actualBase64toBytesResult[13]);
    assertEquals((byte) -33, actualBase64toBytesResult[19]);
    assertEquals((byte) -33, actualBase64toBytesResult[4]);
    assertEquals((byte) -33, actualBase64toBytesResult[7]);
    assertEquals((byte) -33, actualBase64toBytesResult[Short.SIZE]);
    assertEquals((byte) -34, actualBase64toBytesResult[22]);
    assertEquals((byte) -6, actualBase64toBytesResult[43]);
    assertEquals((byte) -90, actualBase64toBytesResult[24]);
    assertEquals((byte) -9, actualBase64toBytesResult[0]);
    assertEquals((byte) -9, actualBase64toBytesResult[12]);
    assertEquals((byte) -9, actualBase64toBytesResult[15]);
    assertEquals((byte) -9, actualBase64toBytesResult[18]);
    assertEquals((byte) -9, actualBase64toBytesResult[21]);
    assertEquals((byte) -9, actualBase64toBytesResult[3]);
    assertEquals((byte) -9, actualBase64toBytesResult[6]);
    assertEquals((byte) -9, actualBase64toBytesResult[9]);
    assertEquals((byte) 0, actualBase64toBytesResult[47]);
    assertEquals((byte) 0, actualBase64toBytesResult[48]);
    assertEquals((byte) 0, actualBase64toBytesResult[49]);
    assertEquals((byte) 0, actualBase64toBytesResult[50]);
    assertEquals((byte) 0, actualBase64toBytesResult[51]);
    assertEquals((byte) 0, actualBase64toBytesResult[52]);
    assertEquals((byte) 0, actualBase64toBytesResult[53]);
    assertEquals((byte) 0, actualBase64toBytesResult[54]);
    assertEquals((byte) 0, actualBase64toBytesResult[55]);
    assertEquals((byte) 0, actualBase64toBytesResult[56]);
    assertEquals((byte) 0, actualBase64toBytesResult[57]);
    assertEquals((byte) 0, actualBase64toBytesResult[58]);
    assertEquals((byte) 0, actualBase64toBytesResult[59]);
    assertEquals((byte) 0, actualBase64toBytesResult[60]);
    assertEquals((byte) 0, actualBase64toBytesResult[61]);
    assertEquals((byte) 0, actualBase64toBytesResult[62]);
    assertEquals((byte) 0, actualBase64toBytesResult[63]);
    assertEquals((byte) 28, actualBase64toBytesResult[40]);
    assertEquals(65, actualBase64toBytesResult.length);
    assertEquals('5', actualBase64toBytesResult[46]);
    assertEquals('M', actualBase64toBytesResult[42]);
    assertEquals('^', actualBase64toBytesResult[45]);
    assertEquals('b', actualBase64toBytesResult[Double.SIZE]);
    assertEquals('m', actualBase64toBytesResult[23]);
    assertEquals('w', actualBase64toBytesResult[41]);
    assertEquals('}', actualBase64toBytesResult[11]);
    assertEquals('}', actualBase64toBytesResult[14]);
    assertEquals('}', actualBase64toBytesResult[17]);
    assertEquals('}', actualBase64toBytesResult[2]);
    assertEquals('}', actualBase64toBytesResult[20]);
    assertEquals('}', actualBase64toBytesResult[5]);
    assertEquals('}', actualBase64toBytesResult[8]);
  }

  /**
   * Test {@link ECKey#getNodeId()}.
   * <ul>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getNodeId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getNodeId()"})
  public void testGetNodeId_thenReturnXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualNodeId = ECKey.fromPublicOnly(pub).getNodeId();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualNodeId);
  }

  /**
   * Test {@link ECKey#getNodeId()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getNodeId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getNodeId()"})
  public void testGetNodeId_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).getNodeId());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#getPrivateKey()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPrivateKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getPrivateKey()"})
  public void testGetPrivateKey_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ECKey.fromPublicOnly(mock(ECPoint.class)).getPrivateKey());
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.</li>
   *   <li>Then return first element is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_givenECKey_thenReturnFirstElementIsFour() {
    // Arrange and Act
    byte[] actualPubKey = (new ECKey()).getPubKey();

    // Assert
    assertEquals((byte) 4, actualPubKey[0]);
    assertEquals(65, actualPubKey.length);
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   *   <li>Then return first element is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_givenIllegalArgumentExceptionWithFoo_thenReturnFirstElementIsFour() {
    // Arrange
    new IllegalArgumentException("foo");

    // Act
    byte[] actualPubKey = (new ECKey()).getPubKey();

    // Assert
    assertEquals((byte) 4, actualPubKey[0]);
    assertEquals(65, actualPubKey.length);
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubKey = ECKey.fromPublicOnly(pub).getPubKey();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPubKey);
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).getPubKey());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#getPrivKey()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then throw {@link MissingPrivateKeyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPrivKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger ECKey.getPrivKey()"})
  public void testGetPrivKey_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException() {
    // Arrange, Act and Assert
    assertThrows(MissingPrivateKeyException.class, () -> ECKey.fromPublicOnly(mock(ECPoint.class)).getPrivKey());
  }

  /**
   * Test {@link ECKey#toStringWithPrivate()}.
   * <ul>
   *   <li>Then return {@code pub:4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#toStringWithPrivate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ECKey.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenReturnPub4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringWithPrivateResult = ECKey.fromPublicOnly(pub).toStringWithPrivate();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertEquals("pub:4158415841584158", actualToStringWithPrivateResult);
  }

  /**
   * Test {@link ECKey#toStringWithPrivate()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#toStringWithPrivate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ECKey.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("pub:"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).toStringWithPrivate());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link ECKey#doSign(byte[])}.
   * <p>
   * Method under test: {@link ECKey#doSign(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECDSASignature ECKey.doSign(byte[])"})
  public void testDoSign() throws UnsupportedEncodingException {
    // Arrange
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ecKey.doSign("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#sign(byte[])}.
   * <p>
   * Method under test: {@link ECKey#sign(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECDSASignature ECKey.sign(byte[])"})
  public void testSign() throws UnsupportedEncodingException {
    // Arrange
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ecKey.sign("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#getPrivKeyBytes()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#getPrivKeyBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ECKey.getPrivKeyBytes()"})
  public void testGetPrivKeyBytes_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ECKey.fromPublicOnly(mock(ECPoint.class)).getPrivKeyBytes());
  }

  /**
   * Test {@link ECKey#equals(Object)}, and {@link ECKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ECKey#equals(Object)}
   *   <li>{@link ECKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.equals(Mockito.<ECPoint>any())).thenReturn(true);
    ECKey fromPublicOnlyResult = ECKey.fromPublicOnly(pub);
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertEquals(fromPublicOnlyResult, ecKey);
    int notExpectedHashCodeResult = fromPublicOnlyResult.hashCode();
    assertNotEquals(notExpectedHashCodeResult, ecKey.hashCode());
  }

  /**
   * Test {@link ECKey#equals(Object)}, and {@link ECKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ECKey#equals(Object)}
   *   <li>{@link ECKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertEquals(ecKey, ecKey);
    int expectedHashCodeResult = ecKey.hashCode();
    assertEquals(expectedHashCodeResult, ecKey.hashCode());
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertNotEquals(ecKey, new ECKey());
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.equals(Mockito.<ECPoint>any())).thenReturn(false);
    ECKey fromPublicOnlyResult = ECKey.fromPublicOnly(pub);

    // Act and Assert
    assertNotEquals(fromPublicOnlyResult, new ECKey());
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.equals(Mockito.<ECPoint>any())).thenThrow(new IllegalArgumentException("foo"));
    ECKey fromPublicOnlyResult = ECKey.fromPublicOnly(pub);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fromPublicOnlyResult.equals(new ECKey()));
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECKey(), null);
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECKey(), "Different type to ECKey");
  }
}
