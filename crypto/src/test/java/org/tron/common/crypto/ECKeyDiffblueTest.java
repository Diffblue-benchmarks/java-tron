package org.tron.common.crypto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.ssl.PemPrivateKey;
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
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.Fp;
import org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Point;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey.ECDSASignature;
import org.tron.common.crypto.ECKey.MissingPrivateKeyException;

public class ECKeyDiffblueTest {
  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}, and {@link
   * ECDSASignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ECDSASignature#equals(Object)}
   *   <li>{@link ECDSASignature#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ECDSASignature ecdsaSignature2 =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertEquals(ecdsaSignature, ecdsaSignature2);
    assertEquals(ecdsaSignature.hashCode(), ecdsaSignature2.hashCode());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}, and {@link
   * ECDSASignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ECDSASignature#equals(Object)}
   *   <li>{@link ECDSASignature#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertEquals(ecdsaSignature, ecdsaSignature);
    int expectedHashCodeResult = ecdsaSignature.hashCode();
    assertEquals(expectedHashCodeResult, ecdsaSignature.hashCode());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECConstants.EIGHT, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNotEquals(
        ecdsaSignature, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER));
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.equals(Object)", "int ECDSASignature.hashCode()"})
  public void testECDSASignatureEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        "Different type to ECDSASignature");
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#fromComponents(byte[], byte[], byte)} with {@code r},
   * {@code s}, {@code v}.
   *
   * <p>Method under test: {@link ECDSASignature#fromComponents(byte[], byte[], byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECDSASignature ECDSASignature.fromComponents(byte[], byte[], byte)"})
  public void testECDSASignatureFromComponentsWithRSV() throws UnsupportedEncodingException {
    // Arrange and Act
    ECDSASignature actualFromComponentsResult =
        ECDSASignature.fromComponents(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        actualFromComponentsResult.toHex());
    BigInteger bigInteger = actualFromComponentsResult.r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    BigInteger expectedBigInteger = actualFromComponentsResult.r;
    assertEquals(expectedBigInteger, actualFromComponentsResult.s);
    assertEquals('A', actualFromComponentsResult.v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#ECDSASignature(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link ECDSASignature#ECDSASignature(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECDSASignature.<init>(BigInteger, BigInteger)"})
  public void testECDSASignatureNewECDSASignature() {
    // Arrange and Act
    ECDSASignature actualEcdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Assert
    BigInteger bigInteger = actualEcdsaSignature.r;
    assertEquals(
        "57896044618658097711785492504343953926418782139537452191302581570759080747168",
        bigInteger.toString());
    BigInteger bigInteger2 = actualEcdsaSignature.s;
    assertEquals(
        "57896044618658097711785492504343953926418782139537452191302581570759080747168",
        bigInteger2.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals(5, bigInteger.getLowestSetBit());
    assertEquals(5, bigInteger2.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          Byte.MAX_VALUE,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          ']',
          'W',
          'n',
          's',
          'W',
          -92,
          'P',
          29,
          -33,
          -23,
          '/',
          'F',
          'h',
          27,
          ' ',
          -96
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          Byte.MAX_VALUE,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          ']',
          'W',
          'n',
          's',
          'W',
          -92,
          'P',
          29,
          -33,
          -23,
          '/',
          'F',
          'h',
          27,
          ' ',
          -96
        },
        bigInteger2.toByteArray());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#ECDSASignature(byte[], byte[], byte)}.
   *
   * <p>Method under test: {@link ECDSASignature#ECDSASignature(byte[], byte[], byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECDSASignature.<init>(byte[], byte[], byte)"})
  public void testECDSASignatureNewECDSASignature2() throws UnsupportedEncodingException {
    // Arrange and Act
    ECDSASignature actualEcdsaSignature =
        new ECDSASignature("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        actualEcdsaSignature.toHex());
    BigInteger bigInteger = actualEcdsaSignature.r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    BigInteger expectedBigInteger = actualEcdsaSignature.r;
    assertEquals(expectedBigInteger, actualEcdsaSignature.s);
    assertEquals('A', actualEcdsaSignature.v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toBase64()}.
   *
   * <p>Method under test: {@link ECDSASignature#toBase64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ECDSASignature.toBase64()"})
  public void testECDSASignatureToBase64() {
    // Arrange, Act and Assert
    assertEquals(
        "AH////////////////////9dV25zV6RQHd/pL0ZoGyCgf////////////////////11XbnNXpFAd3+kvRmgbIKA=",
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER).toBase64());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toByteArray()}.
   *
   * <p>Method under test: {@link ECDSASignature#toByteArray()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECDSASignature.toByteArray()"})
  public void testECDSASignatureToByteArray() {
    // Arrange and Act
    byte[] actualToByteArrayResult =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER).toByteArray();

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
    assertEquals((byte) 27, actualToByteArrayResult[61]);
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
   * Test ECDSASignature {@link ECDSASignature#toByteArray()}.
   *
   * <p>Method under test: {@link ECDSASignature#toByteArray()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECDSASignature.toByteArray()"})
  public void testECDSASignatureToByteArray2() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 27;

    // Act
    byte[] actualToByteArrayResult = ecdsaSignature.toByteArray();

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
    assertEquals((byte) 27, actualToByteArrayResult[61]);
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
   *
   * <p>Method under test: {@link ECDSASignature#toCanonicalised()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECDSASignature ECDSASignature.toCanonicalised()"})
  public void testECDSASignatureToCanonicalised() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act
    ECDSASignature actualToCanonicalisedResult = ecdsaSignature.toCanonicalised();

    // Assert
    assertSame(ecdsaSignature, actualToCanonicalisedResult);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toHex()}.
   *
   * <p>Method under test: {@link ECDSASignature#toHex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ECDSASignature.toHex()"})
  public void testECDSASignatureToHex() {
    // Arrange, Act and Assert
    assertEquals(
        "7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07fffffffffffffffffffffffffffffff5d57"
            + "6e7357a4501ddfe92f46681b20a000",
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER).toHex());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#toHex()}.
   *
   * <p>Method under test: {@link ECDSASignature#toHex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ECDSASignature.toHex()"})
  public void testECDSASignatureToHex2() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertEquals(
        "7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07fffffffffffffffffffffffffffffff5d57"
            + "6e7357a4501ddfe92f46681b20a000",
        ecdsaSignature.toHex());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents() {
    // Arrange, Act and Assert
    assertFalse(
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER).validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents2() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertTrue(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents3() {
    // Arrange
    ECDSASignature ecdsaSignature =
        new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 28;

    // Act and Assert
    assertTrue(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents4() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECConstants.ZERO, ECKey.HALF_CURVE_ORDER);
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertFalse(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents()}.
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents()"})
  public void testECDSASignatureValidateComponents5() {
    // Arrange
    ECDSASignature ecdsaSignature = new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.ZERO);
    ecdsaSignature.v = (byte) 27;

    // Act and Assert
    assertFalse(ecdsaSignature.validateComponents());
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   * with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_thenReturnTrue() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        ECDSASignature.validateComponents(
            ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 27);

    // Assert
    assertTrue(actualValidateComponentsResult);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   * with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_whenA() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        ECDSASignature.validateComponents(
            ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 'A');

    // Assert
    assertFalse(actualValidateComponentsResult);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   * with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_whenTwentyEight() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        ECDSASignature.validateComponents(
            ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 28);

    // Assert
    assertTrue(actualValidateComponentsResult);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   * with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_whenZero() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        ECDSASignature.validateComponents(ECConstants.ZERO, ECKey.HALF_CURVE_ORDER, (byte) 27);

    // Assert
    assertFalse(actualValidateComponentsResult);
  }

  /**
   * Test ECDSASignature {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   * with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ECDSASignature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECDSASignature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testECDSASignatureValidateComponentsWithBigIntegerBigIntegerByte_whenZero2() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        ECDSASignature.validateComponents(ECKey.HALF_CURVE_ORDER, ECConstants.ZERO, (byte) 27);

    // Assert
    assertFalse(actualValidateComponentsResult);
  }

  /**
   * Test MissingPrivateKeyException new {@link MissingPrivateKeyException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MissingPrivateKeyException}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code Algorithm}.
   *   <li>When {@link PemPrivateKey} {@link PemPrivateKey#getAlgorithm()} return {@code Algorithm}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_givenAlgorithm_whenPemPrivateKeyGetAlgorithmReturnAlgorithm() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    PemPrivateKey privKey = mock(PemPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("Algorithm");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ECKey(provider, privKey, mock(ECPoint.class)));
    verify(privKey, atLeast(1)).getAlgorithm();
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>Given {@code EC}.
   *   <li>Then return PrivKeyBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_givenEc_thenReturnPrivKeyBytesIsNull() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    PemPrivateKey privKey = mock(PemPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("EC");
    ECPoint pub = mock(ECPoint.class);

    // Act
    ECKey actualEcKey = new ECKey(provider, privKey, pub);

    // Assert
    verify(privKey).getAlgorithm();
    assertNull(actualEcKey.getPrivKeyBytes());
    assertNull(actualEcKey.getPrivateKey());
    assertNull(actualEcKey.getPubKey());
    assertFalse(actualEcKey.isPubKeyOnly());
    assertTrue(actualEcKey.hasPrivKey());
    assertSame(pub, actualEcKey.getPubKeyPoint());
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_givenIllegalArgumentException() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    PemPrivateKey privKey = mock(PemPrivateKey.class);
    when(privKey.getAlgorithm()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ECKey(provider, privKey, mock(ECPoint.class)));
    verify(privKey).getAlgorithm();
  }

  /**
   * Test {@link ECKey#ECKey(Provider, SecureRandom)}.
   *
   * <ul>
   *   <li>Then PubKeyPoint AffineYCoord return {@link SecP256K1FieldElement}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, SecureRandom)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, SecureRandom)"})
  public void testNewECKey_thenPubKeyPointAffineYCoordReturnSecP256K1FieldElement() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();

    // Act
    ECKey actualEcKey = new ECKey(provider, new SecureRandom());

    // Assert
    ECPoint pubKeyPoint = actualEcKey.getPubKeyPoint();
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof SecP256K1FieldElement);
    assertTrue(pubKeyPoint instanceof SecP256K1Point);
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
  }

  /**
   * Test {@link ECKey#ECKey(byte[], boolean)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return toStringWithPrivate is {@code pub:00}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(byte[], boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(byte[], boolean)"})
  public void testNewECKey_whenArrayOfByteWithZero_thenReturnToStringWithPrivateIsPub00() {
    // Arrange
    byte[] key = new byte[] {0};

    // Act
    ECKey actualEcKey = new ECKey(key, false);

    // Assert
    assertEquals("pub:00", actualEcKey.toStringWithPrivate());
    assertNull(actualEcKey.getPrivKeyBytes());
    assertNull(actualEcKey.getPrivateKey());
    assertFalse(actualEcKey.hasPrivKey());
    assertTrue(actualEcKey.isPubKeyOnly());
    assertArrayEquals(new byte[] {}, actualEcKey.getNodeId());
    assertArrayEquals(new byte[] {0}, actualEcKey.getPubKey());
    assertArrayEquals(
        new byte[] {
          'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123,
          -92, 'p'
        },
        actualEcKey.getAddress());
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>When {@link EllipticCurve#EllipticCurve(ECField, BigInteger, BigInteger)} with {@link
   *       ECField} and {@link ECKey#HALF_CURVE_ORDER} and {@link ECKey#HALF_CURVE_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_whenEllipticCurveWithECFieldAndHalf_curve_orderAndHalf_curve_order() {
    // Arrange
    BouncyCastleProvider provider = new BouncyCastleProvider();
    EllipticCurve ellipticCurve =
        new EllipticCurve(mock(ECField.class), ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    ECParameterSpec ecParameterSpec =
        new ECParameterSpec(
            ellipticCurve,
            new java.security.spec.ECPoint(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            ECKey.HALF_CURVE_ORDER,
            1);
    ECPrivateKeySpec ecPrivateKeySpec =
        new ECPrivateKeySpec(ECKey.HALF_CURVE_ORDER, ecParameterSpec);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ECKey(provider, new BCDSTU4145PrivateKey(ecPrivateKeySpec), null));
  }

  /**
   * Test {@link ECKey#ECKey(Provider, SecureRandom)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then PubKeyPoint return {@link SecP256K1Point}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, SecureRandom)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, SecureRandom)"})
  public void testNewECKey_whenNull_thenPubKeyPointReturnSecP256K1Point() {
    // Arrange and Act
    ECKey actualEcKey = new ECKey(new BouncyCastleProvider(), null);

    // Assert
    assertTrue(actualEcKey.getPubKeyPoint() instanceof SecP256K1Point);
  }

  /**
   * Test {@link ECKey#ECKey(BigInteger, ECPoint)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(BigInteger, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(BigInteger, ECPoint)"})
  public void testNewECKey_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ECKey((BigInteger) null, null));
  }

  /**
   * Test {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#ECKey(Provider, PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ECKey.<init>(Provider, PrivateKey, ECPoint)"})
  public void testNewECKey_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ECKey(new BouncyCastleProvider(), null, null));
  }

  /**
   * Test {@link ECKey#compressPoint(ECPoint)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#compressPoint(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECPoint ECKey.compressPoint(ECPoint)"})
  public void testCompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint uncompressed = mock(ECPoint.class);
    when(uncompressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.compressPoint(uncompressed));
    verify(uncompressed).getEncoded(true);
  }

  /**
   * Test {@link ECKey#decompressPoint(ECPoint)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#decompressPoint(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECPoint ECKey.decompressPoint(ECPoint)"})
  public void testDecompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint compressed = mock(ECPoint.class);
    when(compressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.decompressPoint(compressed));
    verify(compressed).getEncoded(false);
  }

  /**
   * Test {@link ECKey#fromPrivate(byte[])} with {@code privKeyBytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#fromPrivate(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromPrivate(byte[])"})
  public void testFromPrivateWithPrivKeyBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ECKey.fromPrivate((byte[]) null));
  }

  /**
   * Test {@link ECKey#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)} with {@code
   * BigInteger}, {@code ECPoint}.
   *
   * <p>Method under test: {@link ECKey#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)"})
  public void testFromPrivateAndPrecalculatedPublicWithBigIntegerECPoint() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ECKey.fromPrivateAndPrecalculatedPublic((BigInteger) null, null));
  }

  /**
   * Test {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]},
   * {@code byte[]}.
   *
   * <p>Method under test: {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.fromPrivateAndPrecalculatedPublic(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]},
   * {@code byte[]}.
   *
   * <p>Method under test: {@link ECKey#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ECKey.fromPrivateAndPrecalculatedPublic(null, new byte[] {0}));
  }

  /**
   * Test {@link ECKey#fromPublicOnly(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then PubKeyPoint return {@link Fp}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#fromPublicOnly(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromPublicOnly(byte[])"})
  public void testFromPublicOnlyWithByte_whenArrayOfByteWithZero_thenPubKeyPointReturnFp() {
    // Arrange and Act
    ECKey actualFromPublicOnlyResult = ECKey.fromPublicOnly(new byte[] {0});

    // Assert
    assertTrue(actualFromPublicOnlyResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:00", actualFromPublicOnlyResult.toStringWithPrivate());
    assertNull(actualFromPublicOnlyResult.getPrivKeyBytes());
    assertNull(actualFromPublicOnlyResult.getPrivateKey());
    assertFalse(actualFromPublicOnlyResult.hasPrivKey());
    assertFalse(actualFromPublicOnlyResult.isPubKeyCanonical());
    assertTrue(actualFromPublicOnlyResult.isPubKeyOnly());
    assertArrayEquals(new byte[] {}, actualFromPublicOnlyResult.getNodeId());
    assertArrayEquals(new byte[] {0}, actualFromPublicOnlyResult.getPubKey());
    assertArrayEquals(
        new byte[] {
          'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123,
          -92, 'p'
        },
        actualFromPublicOnlyResult.getAddress());
  }

  /**
   * Test {@link ECKey#fromPublicOnly(ECPoint)} with {@code ECPoint}.
   *
   * <ul>
   *   <li>When {@link ECPoint}.
   *   <li>Then return PrivKeyBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromPublicOnly(ECPoint)"})
  public void testFromPublicOnlyWithECPoint_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly((ECPoint) null));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with three and zero.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithThreeAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ';', 'x', -50, 'V', '?', -119, -96, -19, -108, 20,
          -11, -86, '(', -83, '\r', -106, -42, 'y', '_', -100, 'c'
        },
        ECKey.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with two and {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithTwoAndExclamationMark() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2, '!', '}', -81, -112, -34, -73, ';', -33, -117, 'g', '\t', -69, 'B', '\t', '?', -33,
          -81, -10, 'W', '?', -44, '{', 'c', 14, '-', '?', -35, 'J', -127, -109, -89, 'M'
        },
        ECKey.publicKeyFromPrivate(BigInteger.valueOf(Long.MAX_VALUE), true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with two and minus twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithTwoAndMinusTwentyEight() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2,
          -28,
          -109,
          -37,
          -15,
          -63,
          '\r',
          Byte.MIN_VALUE,
          -13,
          'X',
          30,
          'I',
          4,
          -109,
          11,
          20,
          4,
          -52,
          'l',
          19,
          -112,
          14,
          -32,
          'u',
          -124,
          't',
          -6,
          -108,
          -85,
          -24,
          -60,
          -51,
          19
        },
        ECKey.publicKeyFromPrivate(ECConstants.FOUR, true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>Then return forty-second element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnFortySecondElementIsMinusOneHundredFour() {
    // Arrange and Act
    byte[] actualPublicKeyFromPrivateResult =
        ECKey.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, false);

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
   *
   * <ul>
   *   <li>When {@link ECConstants#EIGHT}.
   *   <li>Then return array of {@code byte} with two and {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenEight_thenReturnArrayOfByteWithTwoAndSlash() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2, '/', 1, -27, -31, '\\', -54, '5', 29, -81, -13, -124, '?', -73, 15, '<', '/', '\n', 27,
          -35, 5, -27, -81, -120, -118, 'g', 'x', 'N', -13, -31, '\n', '*', 1
        },
        ECKey.publicKeyFromPrivate(ECConstants.EIGHT, true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ONE}.
   *   <li>Then return array of {@code byte} with two and {@code y}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenOne_thenReturnArrayOfByteWithTwoAndY() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2, 'y', -66, 'f', '~', -7, -36, -69, -84, 'U', -96, 'b', -107, -50, -121, 11, 7, 2, -101,
          -4, -37, '-', -50, '(', -39, 'Y', -14, -127, '[', 22, -8, 23, -104
        },
        ECKey.publicKeyFromPrivate(ECConstants.ONE, true));
  }

  /**
   * Test {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenZero_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0}, ECKey.publicKeyFromPrivate(ECConstants.ZERO, true));
  }

  /**
   * Test {@link ECKey#pubBytesWithoutFormat(ECPoint)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_givenAxaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubBytesWithoutFormatResult = ECKey.pubBytesWithoutFormat(pubPoint);

    // Assert
    verify(pubPoint).getEncoded(false);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualPubBytesWithoutFormatResult);
  }

  /**
   * Test {@link ECKey#pubBytesWithoutFormat(ECPoint)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.pubBytesWithoutFormat(pubPoint));
    verify(pubPoint).getEncoded(false);
  }

  /**
   * Test {@link ECKey#fromNodeId(byte[])}.
   *
   * <p>Method under test: {@link ECKey#fromNodeId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.fromNodeId(byte[])"})
  public void testFromNodeId() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ECKey.fromNodeId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#signatureToKeyBytes(byte[], ECDSASignature)} with {@code messageHash}, {@code
   * sig}.
   *
   * <p>Method under test: {@link ECKey#signatureToKeyBytes(byte[], ECDSASignature)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToKeyBytes(byte[], ECDSASignature)"})
  public void testSignatureToKeyBytesWithMessageHashSig()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange
    byte[] messageHash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.signatureToKeyBytes(
                messageHash, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)));
  }

  /**
   * Test {@link ECKey#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <p>Method under test: {@link ECKey#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () ->
            ECKey.signatureToKeyBytes(
                "AXAXAXAX".getBytes("UTF-8"), "java.security.interfaces.ECPublicKey"));
  }

  /**
   * Test {@link ECKey#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code Could not decode base64}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64_whenCouldNotDecodeBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> ECKey.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link ECKey#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64_whenEmptyString()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> ECKey.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), ""));
  }

  /**
   * Test {@link ECKey#signatureToAddress(byte[], ECDSASignature)} with {@code messageHash}, {@code
   * sig}.
   *
   * <p>Method under test: {@link ECKey#signatureToAddress(byte[], ECDSASignature)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToAddress(byte[], ECDSASignature)"})
  public void testSignatureToAddressWithMessageHashSig()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange
    byte[] messageHash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.signatureToAddress(
                messageHash, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)));
  }

  /**
   * Test {@link ECKey#signatureToAddress(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <p>Method under test: {@link ECKey#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () ->
            ECKey.signatureToAddress(
                "AXAXAXAX".getBytes("UTF-8"), "java.security.interfaces.ECPublicKey"));
  }

  /**
   * Test {@link ECKey#signatureToAddress(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code Could not decode base64}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_whenCouldNotDecodeBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> ECKey.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link ECKey#signatureToAddress(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_whenEmptyString()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class, () -> ECKey.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), ""));
  }

  /**
   * Test {@link ECKey#signatureToKey(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code Could not decode base64}.
   *   <li>Then throw {@link SignatureException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToKey(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.signatureToKey(byte[], String)"})
  public void testSignatureToKey_whenCouldNotDecodeBase64_thenThrowSignatureException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> ECKey.signatureToKey("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link ECKey#signatureToKey(byte[], String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link SignatureException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToKey(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.signatureToKey(byte[], String)"})
  public void testSignatureToKey_whenEmptyString_thenThrowSignatureException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class, () -> ECKey.signatureToKey("AXAXAXAX".getBytes("UTF-8"), ""));
  }

  /**
   * Test {@link ECKey#signatureToKey(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code java.security.interfaces.ECPublicKey}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#signatureToKey(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.signatureToKey(byte[], String)"})
  public void testSignatureToKey_whenJavaSecurityInterfacesECPublicKey()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () ->
            ECKey.signatureToKey(
                "AXAXAXAX".getBytes("UTF-8"), "java.security.interfaces.ECPublicKey"));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with four.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical(new byte[] {4}));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical(new byte[] {3}));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical(new byte[] {2}));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ECKey.isPubKeyCanonical("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ECKey().isPubKeyCanonical());
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte}
   *       with four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithFourAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean()))
        .thenReturn(new byte[] {4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte}
   *       with three and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithThreeAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean()))
        .thenReturn(new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte}
   *       with two and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithTwoAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean()))
        .thenReturn(new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsPubKeyCanonicalResult = ECKey.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link ECKey#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).isPubKeyCanonical());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
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
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[17]);
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
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature2() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            0,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

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
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1,
            new ECDSASignature(ECConstants.THREE, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -116, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -124, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -125, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -127, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -127, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -16, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -22, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -26, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -3, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -44, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -49, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -5, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -68, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -6, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -70, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -75, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -76, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -86, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -97, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) 22, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) 24, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) 26, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('\'', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals(',', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals(',', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('0', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('5', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('6', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('<', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('F', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('H', actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('O', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('R', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('Y', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('\\', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('m', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('y', actualRecoverPubBytesFromSignatureResult[21]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -107, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -109, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -118, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -118, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -120, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -12, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -14, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -40, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -42, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -44, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -48, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -5, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -60, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -77, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -85, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -89, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -91, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -92, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) 21, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) 21, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) 26, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) 27, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals((byte) 6, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('2', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals(':', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('"', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('y', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('z', actualRecoverPubBytesFromSignatureResult[6]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature5() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.THREE),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -106, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -111, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -114, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -11, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -125, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -13, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -16, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -20, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -30, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -32, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -45, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -50, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -52, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -54, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -63, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -63, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -70, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -84, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -90, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) 0, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) 17, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) 17, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('+', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('-', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('3', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('9', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('Q', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('Y', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('m', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('n', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('w', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('|', actualRecoverPubBytesFromSignatureResult[54]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature6() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            2, new ECDSASignature(ECConstants.FOUR, ECConstants.TWO), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -105, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -106, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -109, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -109, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -41, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -49, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -51, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -53, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -58, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -59, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -5, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -60, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -6, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -8, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -91, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) 0, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) 17, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) 20, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) 24, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) 28, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) 5, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals((byte) 7, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals(Byte.MIN_VALUE, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('-', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('5', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('T', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('V', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('Y', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('\t', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('a', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('|', actualRecoverPubBytesFromSignatureResult[63]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnArrayOfByteWithZero() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.ZERO), new byte[] {});

    // Assert
    assertArrayEquals(new byte[] {0}, actualRecoverPubBytesFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return fifty-fifth element is minus one hundred two.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFiftyFifthElementIsMinusOneHundredTwo() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), new byte[] {});

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
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) 30, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('/', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('6', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('8', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('C', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('n', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('s', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('}', actualRecoverPubBytesFromSignatureResult[50]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return minus one hundred three.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnMinusOneHundredThree()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            1,
            new ECDSASignature(ECConstants.EIGHT, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -103, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -116, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -121, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -121, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -125, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -125, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) -15, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -18, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) -29, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -39, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -40, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -45, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -63, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -6, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -92, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) 15, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) 22, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) 23, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('$', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('&', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('H', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('H', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('J', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('N', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('S', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('X', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('[', actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals('\b', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('^', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('i', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('l', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('l', actualRecoverPubBytesFromSignatureResult[57]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return seventh element is minus one hundred one.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnSeventhElementIsMinusOneHundredOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            2,
            new ECDSASignature(ECConstants.FOUR, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -101, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -106, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -122, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -29, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -38, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -44, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -45, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -48, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -55, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -58, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -64, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -65, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -76, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) -84, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -97, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) 15, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) 24, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) 2, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) 5, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(Byte.MIN_VALUE, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('(', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('3', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('K', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('Q', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('V', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('\\', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('\b', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('\r', actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('l', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('p', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('p', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('s', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('w', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('~', actualRecoverPubBytesFromSignatureResult[40]);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.recoverPubBytesFromSignature(
                -1,
                new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenTwo_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        ECKey.recoverPubBytesFromSignature(
            2,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualRecoverPubBytesFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverPubBytesFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverPubBytesFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.recoverPubBytesFromSignature(
                0, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAnd2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', '2', -2, '|', 'n', 'K', -12, 7, 'j', 4, -54, 3, 'S', -123, '9', -126, 7, 'X', -108,
          19, 'Y'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndB()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            2, new ECDSASignature(ECConstants.FOUR, ECConstants.TWO), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'B', -74, -45, '4', -50, 'd', 3, 'J', '+', -38, 'Y', -81, -64, '|', 'K', '~', 'S',
          -60, -79, -94
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code `}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndBacktick()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            2,
            new ECDSASignature(ECConstants.FOUR, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', '`', -87, -71, '5', -17, ')', 15, '[', '^', '6', -126, -17, 'g', -126, -66, '<', 'm',
          -114, -92, -92
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code c}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndC() {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), new byte[] {});

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'c', -119, -36, '\b', 's', '}', 'i', -123, '>', -72, 'x', 'S', -66, '6', 'x', -33,
          'A', 'k', 5, -73
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndExclamationMark() {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            0,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', '!', -4, -68, -21, -122, 'o', -47, -80, -117, -63, 'L', 'v', 't', ']', 'o', -114,
          -72, -2, -109, '\\'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code <}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndLessThanSign()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1,
            new ECDSASignature(ECConstants.EIGHT, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', '<', 'x', 'G', -114, -96, -45, 'l', -64, -51, '\\', -38, '9', -125, -95, 'q', 'Y',
          -106, 'E', ']', -26
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus eighty-three.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusEightyThree()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -83, -3, -117, -99, -41, -19, -76, 'I', -126, 'h', -42, -75, 4, -90, 'O', '<', 'p',
          -87, -12, '^'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1,
            new ECDSASignature(ECConstants.THREE, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -65, 'B', 'h', -47, '0', -16, -20, '!', -55, '\f', ']', '1', -1, 'm', -92, 'L', 4,
          '{', -54, -99
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusThirtySix() {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.ZERO), new byte[] {});

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123,
          -92, 'p'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus three.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusThree()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.THREE),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -3, -67, -53, -3, -17, -3, 'v', '#', -60, 24, -127, '%', -75, 'a', -49, '"', 5, 'U',
          '1', -46
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.recoverAddressFromSignature(
                -1,
                new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_whenTwo_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        ECKey.recoverAddressFromSignature(
            2,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverAddressFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.recoverAddressFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverAddressFromSignature_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.recoverAddressFromSignature(
                0, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then PubKeyPoint Curve return {@link ECCurve.Fp}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenPubKeyPointCurveReturnFp() {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.ZERO), new byte[] {});

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    assertTrue(pubKeyPoint.getCurve() instanceof ECCurve.Fp);
    assertTrue(pubKeyPoint.getDetachedPoint() instanceof Fp);
    assertTrue(pubKeyPoint instanceof Fp);
    assertEquals("pub:00", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(pubKeyPoint.getAffineXCoord());
    assertNull(pubKeyPoint.getAffineYCoord());
    assertNull(pubKeyPoint.getRawXCoord());
    assertNull(pubKeyPoint.getRawYCoord());
    assertNull(pubKeyPoint.getXCoord());
    assertNull(pubKeyPoint.getYCoord());
    assertEquals(0, pubKeyPoint.getZCoords().length);
    assertFalse(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(pubKeyPoint.isInfinity());
    assertArrayEquals(new byte[] {}, actualRecoverFromSignatureResult.getNodeId());
    assertArrayEquals(new byte[] {0}, actualRecoverFromSignatureResult.getPubKey());
    assertArrayEquals(
        new byte[] {
          'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123,
          -92, 'p'
        },
        actualRecoverFromSignatureResult.getAddress());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAnd2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:048a931a15a47a22c88ab1d8d425fe03157906ab1dc78895f2b2ac475293147aaf019ed8105f3e21b3f45798a7325da5"
            + "6bd62a0b012e2e1b3abddbc4fb89d047be",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', '2', -2, '|', 'n', 'K', -12, 7, 'j', 4, -54, 3, 'S', -123, '9', -126, 7, 'X', -108,
          19, 'Y'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -118, -109, 26, 21, -92, 'z', '"', -56, -118, -79, -40, -44, '%', -2, 3, 21, 'y', 6, -85,
          29, -57, -120, -107, -14, -78, -84, 'G', 'R', -109, 20, 'z', -81, 1, -98, -40, 16, '_',
          '>', '!', -77, -12, 'W', -104, -89, '2', ']', -91, 'k', -42, '*', 11, 1, '.', '.', 27,
          ':', -67, -37, -60, -5, -119, -48, 'G', -66
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndB()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            2, new ECDSASignature(ECConstants.FOUR, ECConstants.TWO), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:040049c613c818edcf802d61fb031dcbdf1114bdc507c87b1c07e3ab825f777428524718263ea21a7856be6b05979ecd"
            + "49a596fe5493c4f8fa9309593545477cd7",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', 'B', -74, -45, '4', -50, 'd', 3, 'J', '+', -38, 'Y', -81, -64, '|', 'K', '~', 'S',
          -60, -79, -94
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          0,
          'I',
          -58,
          19,
          -56,
          24,
          -19,
          -49,
          Byte.MIN_VALUE,
          '-',
          'a',
          -5,
          3,
          29,
          -53,
          -33,
          17,
          20,
          -67,
          -59,
          7,
          -56,
          '{',
          28,
          7,
          -29,
          -85,
          -126,
          '_',
          'w',
          't',
          '(',
          'R',
          'G',
          24,
          '&',
          '>',
          -94,
          26,
          'x',
          'V',
          -66,
          'k',
          5,
          -105,
          -98,
          -51,
          'I',
          -91,
          -106,
          -2,
          'T',
          -109,
          -60,
          -8,
          -6,
          -109,
          '\t',
          'Y',
          '5',
          'E',
          'G',
          '|',
          -41
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code `}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndBacktick()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            2,
            new ECDSASignature(ECConstants.FOUR, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:04acb13b80bf9b96d086db0133da56257770c928d3bd2805509daa956277ed7cd796b5a994b687d37e515c9f08d4b0c8"
            + "184b0f6ce3c60d6047c067b48902737b70",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', '`', -87, -71, '5', -17, ')', 15, '[', '^', '6', -126, -17, 'g', -126, -66, '<', 'm',
          -114, -92, -92
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -84,
          -79,
          ';',
          Byte.MIN_VALUE,
          -65,
          -101,
          -106,
          -48,
          -122,
          -37,
          1,
          '3',
          -38,
          'V',
          '%',
          'w',
          'p',
          -55,
          '(',
          -45,
          -67,
          '(',
          5,
          'P',
          -99,
          -86,
          -107,
          'b',
          'w',
          -19,
          '|',
          -41,
          -106,
          -75,
          -87,
          -108,
          -74,
          -121,
          -45,
          '~',
          'Q',
          '\\',
          -97,
          '\b',
          -44,
          -80,
          -56,
          24,
          'K',
          15,
          'l',
          -29,
          -58,
          '\r',
          '`',
          'G',
          -64,
          'g',
          -76,
          -119,
          2,
          's',
          '{',
          'p'
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code c}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndC() {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), new byte[] {});

    // Assert
    assertEquals(
        "pub:047fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07a1e93400ed43e38b02fb360433690"
            + "dff77d0bfd1e9a72982849497f5c578c7f",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', 'c', -119, -36, '\b', 's', '}', 'i', -123, '>', -72, 'x', 'S', -66, '6', 'x', -33,
          'A', 'k', 5, -73
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          Byte.MAX_VALUE,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          ']',
          'W',
          'n',
          's',
          'W',
          -92,
          'P',
          29,
          -33,
          -23,
          '/',
          'F',
          'h',
          27,
          ' ',
          -96,
          'z',
          30,
          -109,
          '@',
          14,
          -44,
          '>',
          '8',
          -80,
          '/',
          -77,
          '`',
          'C',
          '6',
          -112,
          -33,
          -9,
          '}',
          11,
          -3,
          30,
          -102,
          'r',
          -104,
          '(',
          'I',
          'I',
          Byte.MAX_VALUE,
          '\\',
          'W',
          -116,
          Byte.MAX_VALUE
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndExclamationMark()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            0,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:045f78f998e82a98b0d674aab189d762b206f66b747b9704ffbc43f3ba5bbd3312eff3429a3430b3c85ac533d5682608"
            + "946f739b60a3db8022919eb78e1084ee36",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', '!', -4, -68, -21, -122, 'o', -47, -80, -117, -63, 'L', 'v', 't', ']', 'o', -114,
          -72, -2, -109, '\\'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          '_',
          'x',
          -7,
          -104,
          -24,
          '*',
          -104,
          -80,
          -42,
          't',
          -86,
          -79,
          -119,
          -41,
          'b',
          -78,
          6,
          -10,
          'k',
          't',
          '{',
          -105,
          4,
          -1,
          -68,
          'C',
          -13,
          -70,
          '[',
          -67,
          '3',
          18,
          -17,
          -13,
          'B',
          -102,
          '4',
          '0',
          -77,
          -56,
          'Z',
          -59,
          '3',
          -43,
          'h',
          '&',
          '\b',
          -108,
          'o',
          's',
          -101,
          '`',
          -93,
          -37,
          Byte.MIN_VALUE,
          '"',
          -111,
          -98,
          -73,
          -114,
          16,
          -124,
          -18,
          '6'
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code <}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndLessThanSign()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1,
            new ECDSASignature(ECConstants.EIGHT, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:04a275a25bd948e389d303c1d8fa585399eeb1088387a2136c342fa52bc2c8852bbfa98acf605f9b87c7c5698c3f83f1"
            + "4a1760f9164e0fa4576c283f0a2426485e",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', '<', 'x', 'G', -114, -96, -45, 'l', -64, -51, '\\', -38, '9', -125, -95, 'q', 'Y',
          -106, 'E', ']', -26
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -94, 'u', -94, '[', -39, 'H', -29, -119, -45, 3, -63, -40, -6, 'X', 'S', -103, -18, -79,
          '\b', -125, -121, -94, 19, 'l', '4', '/', -91, '+', -62, -56, -123, '+', -65, -87, -118,
          -49, '`', '_', -101, -121, -57, -59, 'i', -116, '?', -125, -15, 'J', 23, '`', -7, 22, 'N',
          15, -92, 'W', 'l', '(', '?', '\n', '$', '&', 'H', '^'
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus eighty-three.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusEightyThree()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:0414bee1bbcd8e5e55d0d847d70a12bc032e9fcd506d0fe0f31e34792c57429f3b3d4180790e2a756728699a3c2c193b"
            + "7ef0bd1057cb2e7c948fc5dd78130378f4",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', -83, -3, -117, -99, -41, -19, -76, 'I', -126, 'h', -42, -75, 4, -90, 'O', '<', 'p',
          -87, -12, '^'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          20,
          -66,
          -31,
          -69,
          -51,
          -114,
          '^',
          'U',
          -48,
          -40,
          'G',
          -41,
          '\n',
          18,
          -68,
          3,
          '.',
          -97,
          -51,
          'P',
          'm',
          15,
          -32,
          -13,
          30,
          '4',
          'y',
          ',',
          'W',
          'B',
          -97,
          ';',
          '=',
          'A',
          Byte.MIN_VALUE,
          'y',
          14,
          '*',
          'u',
          'g',
          '(',
          'i',
          -102,
          '<',
          ',',
          25,
          ';',
          '~',
          -16,
          -67,
          16,
          'W',
          -53,
          '.',
          '|',
          -108,
          -113,
          -59,
          -35,
          'x',
          19,
          3,
          'x',
          -12
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1,
            new ECDSASignature(ECConstants.THREE, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:04ea755ff94d81184827f0b43c4f5281fa6d9f8c1679fdd4aa650d2fd5e386d0115a582afa608e3459469fbde6b53078"
            + "83bdb05fcf84dffb351a5c362c9abcba2c",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', -65, 'B', 'h', -47, '0', -16, -20, '!', -55, '\f', ']', '1', -1, 'm', -92, 'L', 4,
          '{', -54, -99
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -22, 'u', '_', -7, 'M', -127, 24, 'H', '\'', -16, -76, '<', 'O', 'R', -127, -6, 'm', -97,
          -116, 22, 'y', -3, -44, -86, 'e', '\r', '/', -43, -29, -122, -48, 17, 'Z', 'X', '*', -6,
          '`', -114, '4', 'Y', 'F', -97, -67, -26, -75, '0', 'x', -125, -67, -80, '_', -49, -124,
          -33, -5, '5', 26, '\\', '6', ',', -102, -68, -70, ','
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus three.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusThree()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            1,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECConstants.THREE),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "pub:04e983ecf56dc70af36eac0025113f622d5de0035dc1c72accc3b2bd0eeb007c3534a96e06de43eb2b9151ca8e6433ba"
            + "592ad3c89dce7cf0479639e2775ca6c111",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', -3, -67, -53, -3, -17, -3, 'v', '#', -60, 24, -127, '%', -75, 'a', -49, '"', 5, 'U',
          '1', -46
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -23, -125, -20, -11, 'm', -57, '\n', -13, 'n', -84, 0, '%', 17, '?', 'b', '-', ']', -32,
          3, ']', -63, -57, '*', -52, -61, -78, -67, 14, -21, 0, '|', '5', '4', -87, 'n', 6, -34,
          'C', -21, '+', -111, 'Q', -54, -114, 'd', '3', -70, 'Y', '*', -45, -56, -99, -50, '|',
          -16, 'G', -106, '9', -30, 'w', '\\', -90, -63, 17
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.recoverFromSignature(
                -1,
                new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ECKey.recoverFromSignature(
                1, new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#recoverFromSignature(int, ECDSASignature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECKey ECKey.recoverFromSignature(int, ECDSASignature, byte[])"})
  public void testRecoverFromSignature_whenTwo_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ECKey actualRecoverFromSignatureResult =
        ECKey.recoverFromSignature(
            2,
            new ECDSASignature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualRecoverFromSignatureResult);
  }

  /**
   * Test {@link ECKey#isPubKeyOnly()}.
   *
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyOnly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyOnly()"})
  public void testIsPubKeyOnly_givenECKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ECKey().isPubKeyOnly());
  }

  /**
   * Test {@link ECKey#isPubKeyOnly()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#isPubKeyOnly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.isPubKeyOnly()"})
  public void testIsPubKeyOnly_givenFromPublicOnlyECPoint_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ECKey.fromPublicOnly(mock(ECPoint.class)).isPubKeyOnly());
  }

  /**
   * Test {@link ECKey#hasPrivKey()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#hasPrivKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.hasPrivKey()"})
  public void testHasPrivKey_givenFromPublicOnlyECPoint_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ECKey.fromPublicOnly(mock(ECPoint.class)).hasPrivKey());
  }

  /**
   * Test {@link ECKey#getAddress()}.
   *
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getAddress()"})
  public void testGetAddress_givenECKey_thenDoesNotThrow() {
    // Arrange, Act and Assert
    new ECKey().getAddress();
  }

  /**
   * Test {@link ECKey#getAddress()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and nineteen.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getAddress()"})
  public void testGetAddress_thenReturnArrayOfByteWithAAndNineteen()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualAddress = ECKey.fromPublicOnly(pub).getAddress();

    // Assert
    verify(pub).getEncoded(false);
    assertArrayEquals(
        new byte[] {
          'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31, -24, -124,
          '5', -121, -26
        },
        actualAddress);
  }

  /**
   * Test {@link ECKey#getAddress()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getAddress()"})
  public void testGetAddress_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).getAddress());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link ECKey#signHash(byte[])}.
   *
   * <p>Method under test: {@link ECKey#signHash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ECKey.signHash(byte[])"})
  public void testSignHash() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ECKey().signHash("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#Base64toBytes(String)}.
   *
   * <ul>
   *   <li>Then return forty-fifth element is minus twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#Base64toBytes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.Base64toBytes(String)"})
  public void testBase64toBytes_thenReturnFortyFifthElementIsMinusTwentyNine() {
    // Arrange and Act
    byte[] actualBase64toBytesResult =
        new ECKey()
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
   *
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getNodeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getNodeId()"})
  public void testGetNodeId_givenECKey_thenDoesNotThrow() {
    // Arrange, Act and Assert
    new ECKey().getNodeId();
  }

  /**
   * Test {@link ECKey#getNodeId()}.
   *
   * <ul>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getNodeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getNodeId()"})
  public void testGetNodeId_thenReturnXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualNodeId = ECKey.fromPublicOnly(pub).getNodeId();

    // Assert
    verify(pub).getEncoded(false);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualNodeId);
  }

  /**
   * Test {@link ECKey#getNodeId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getNodeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getNodeId()"})
  public void testGetNodeId_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).getNodeId());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link ECKey#getPrivateKey()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getPrivateKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getPrivateKey()"})
  public void testGetPrivateKey_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ECKey.fromPublicOnly(mock(ECPoint.class)).getPrivateKey());
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   *
   * <ul>
   *   <li>Given {@link ECKey#ECKey()}.
   *   <li>Then return first element is four.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_givenECKey_thenReturnFirstElementIsFour() {
    // Arrange and Act
    byte[] actualPubKey = new ECKey().getPubKey();

    // Assert
    assertEquals((byte) 4, actualPubKey[0]);
    assertEquals(65, actualPubKey.length);
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubKey = ECKey.fromPublicOnly(pub).getPubKey();

    // Assert
    verify(pub).getEncoded(false);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPubKey);
  }

  /**
   * Test {@link ECKey#getPubKey()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getPubKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getPubKey()"})
  public void testGetPubKey_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).getPubKey());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link ECKey#getPrivKey()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then throw {@link MissingPrivateKeyException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getPrivKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger ECKey.getPrivKey()"})
  public void testGetPrivKey_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException() {
    // Arrange, Act and Assert
    assertThrows(
        MissingPrivateKeyException.class,
        () -> ECKey.fromPublicOnly(mock(ECPoint.class)).getPrivKey());
  }

  /**
   * Test {@link ECKey#toStringWithPrivate()}.
   *
   * <ul>
   *   <li>Then return {@code pub:4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#toStringWithPrivate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ECKey.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenReturnPub4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringWithPrivateResult = ECKey.fromPublicOnly(pub).toStringWithPrivate();

    // Assert
    verify(pub).getEncoded(false);
    assertEquals("pub:4158415841584158", actualToStringWithPrivateResult);
  }

  /**
   * Test {@link ECKey#toStringWithPrivate()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#toStringWithPrivate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ECKey.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ECKey.fromPublicOnly(pub).toStringWithPrivate());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link ECKey#doSign(byte[])}.
   *
   * <p>Method under test: {@link ECKey#doSign(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECDSASignature ECKey.doSign(byte[])"})
  public void testDoSign() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ECKey().doSign("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#sign(byte[])}.
   *
   * <p>Method under test: {@link ECKey#sign(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECDSASignature ECKey.sign(byte[])"})
  public void testSign() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ECKey().sign("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ECKey#getPrivKeyBytes()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#getPrivKeyBytes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ECKey.getPrivKeyBytes()"})
  public void testGetPrivKeyBytes_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ECKey.fromPublicOnly(mock(ECPoint.class)).getPrivKeyBytes());
  }

  /**
   * Test {@link ECKey#equals(Object)}, and {@link ECKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ECKey#equals(Object)}
   *   <li>{@link ECKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ECKey ecKey = new ECKey();

    // Act and Assert
    assertNotEquals(ecKey, new ECKey());
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECKey(), null);
  }

  /**
   * Test {@link ECKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ECKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ECKey.equals(Object)", "int ECKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ECKey(), "Different type to ECKey");
  }
}
