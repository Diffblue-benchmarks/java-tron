package org.tron.common.crypto.sm2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.security.SignatureException;
import java.security.spec.ECField;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.Fp;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey;
import org.tron.common.crypto.ECKey.MissingPrivateKeyException;
import org.tron.common.crypto.sm2.SM2.SM2Signature;

public class SM2DiffblueTest {
  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>Given {@code Algorithm}.
   *   <li>When {@link PemPrivateKey} {@link PemPrivateKey#getAlgorithm()} return {@code Algorithm}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_givenAlgorithm_whenPemPrivateKeyGetAlgorithmReturnAlgorithm() {
    // Arrange
    PemPrivateKey privKey = mock(PemPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("Algorithm");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2(privKey, mock(ECPoint.class)));
    verify(privKey, atLeast(1)).getAlgorithm();
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>Given {@code EC}.
   *   <li>Then return PrivKeyBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_givenEc_thenReturnPrivKeyBytesIsNull() {
    // Arrange
    PemPrivateKey privKey = mock(PemPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("EC");
    ECPoint pub = mock(ECPoint.class);

    // Act
    SM2 actualSm2 = new SM2(privKey, pub);

    // Assert
    verify(privKey).getAlgorithm();
    assertNull(actualSm2.getPrivKeyBytes());
    assertNull(actualSm2.getPrivateKey());
    assertNull(actualSm2.getPubKey());
    assertFalse(actualSm2.isPubKeyOnly());
    assertTrue(actualSm2.hasPrivKey());
    assertSame(pub, actualSm2.getPubKeyPoint());
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_givenIllegalArgumentException() {
    // Arrange
    PemPrivateKey privKey = mock(PemPrivateKey.class);
    when(privKey.getAlgorithm()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2(privKey, mock(ECPoint.class)));
    verify(privKey).getAlgorithm();
  }

  /**
   * Test {@link SM2#SM2(byte[], boolean)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return toStringWithPrivate is {@code pub:00}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(byte[], boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(byte[], boolean)"})
  public void testNewSm2_whenArrayOfByteWithZero_thenReturnToStringWithPrivateIsPub00() {
    // Arrange
    byte[] key = new byte[] {0};

    // Act
    SM2 actualSm2 = new SM2(key, false);

    // Assert
    assertEquals("pub:00", actualSm2.toStringWithPrivate());
    assertNull(actualSm2.getPrivKeyBytes());
    assertNull(actualSm2.getPrivateKey());
    assertFalse(actualSm2.hasPrivKey());
    assertTrue(actualSm2.isPubKeyOnly());
    assertArrayEquals(new byte[] {}, actualSm2.getNodeId());
    assertArrayEquals(new byte[] {0}, actualSm2.getPubKey());
    assertArrayEquals(
        new byte[] {
          'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123,
          -92, 'p'
        },
        actualSm2.getAddress());
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>When {@link EllipticCurve#EllipticCurve(ECField, BigInteger, BigInteger)} with {@link
   *       ECField} and {@link ECConstants#EIGHT} and {@link ECConstants#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_whenEllipticCurveWithECFieldAndEightAndEight() {
    // Arrange
    EllipticCurve ellipticCurve =
        new EllipticCurve(mock(ECField.class), ECConstants.EIGHT, ECConstants.EIGHT);
    ECParameterSpec ecParameterSpec =
        new ECParameterSpec(
            ellipticCurve,
            new java.security.spec.ECPoint(ECConstants.EIGHT, ECConstants.EIGHT),
            ECConstants.EIGHT,
            1);
    ECPrivateKeySpec ecPrivateKeySpec = new ECPrivateKeySpec(ECConstants.EIGHT, ecParameterSpec);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new SM2(new BCDSTU4145PrivateKey(ecPrivateKeySpec), null));
  }

  /**
   * Test {@link SM2#SM2(BigInteger, ECPoint)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(BigInteger, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(BigInteger, ECPoint)"})
  public void testNewSm2_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2((BigInteger) null, null));
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2((PrivateKey) null, null));
  }

  /**
   * Test {@link SM2#compressPoint(ECPoint)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#compressPoint(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECPoint SM2.compressPoint(ECPoint)"})
  public void testCompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint uncompressed = mock(ECPoint.class);
    when(uncompressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.compressPoint(uncompressed));
    verify(uncompressed).getEncoded(true);
  }

  /**
   * Test {@link SM2#decompressPoint(ECPoint)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#decompressPoint(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ECPoint SM2.decompressPoint(ECPoint)"})
  public void testDecompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint compressed = mock(ECPoint.class);
    when(compressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.decompressPoint(compressed));
    verify(compressed).getEncoded(false);
  }

  /**
   * Test {@link SM2#fromPrivate(byte[])} with {@code privKeyBytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#fromPrivate(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPrivate(byte[])"})
  public void testFromPrivateWithPrivKeyBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPrivate((byte[]) null));
  }

  /**
   * Test {@link SM2#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)} with {@code
   * BigInteger}, {@code ECPoint}.
   *
   * <p>Method under test: {@link SM2#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)"})
  public void testFromPrivateAndPrecalculatedPublicWithBigIntegerECPoint() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.fromPrivateAndPrecalculatedPublic((BigInteger) null, null));
  }

  /**
   * Test {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]}, {@code
   * byte[]}.
   *
   * <p>Method under test: {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.fromPrivateAndPrecalculatedPublic(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]}, {@code
   * byte[]}.
   *
   * <p>Method under test: {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.fromPrivateAndPrecalculatedPublic(null, new byte[] {0}));
  }

  /**
   * Test {@link SM2#fromPublicOnly(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then PubKeyPoint return {@link Fp}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#fromPublicOnly(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPublicOnly(byte[])"})
  public void testFromPublicOnlyWithByte_whenArrayOfByteWithZero_thenPubKeyPointReturnFp() {
    // Arrange and Act
    SM2 actualFromPublicOnlyResult = SM2.fromPublicOnly(new byte[] {0});

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
   * Test {@link SM2#fromPublicOnly(ECPoint)} with {@code ECPoint}.
   *
   * <ul>
   *   <li>When {@link ECPoint}.
   *   <li>Then return PrivKeyBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPublicOnly(ECPoint)"})
  public void testFromPublicOnlyWithECPoint_whenECPoint_thenReturnPrivKeyBytesIsNull() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);

    // Act
    SM2 actualFromPublicOnlyResult = SM2.fromPublicOnly(pub);

    // Assert
    assertNull(actualFromPublicOnlyResult.getPrivKeyBytes());
    assertNull(actualFromPublicOnlyResult.getPrivateKey());
    assertNull(actualFromPublicOnlyResult.getPubKey());
    assertFalse(actualFromPublicOnlyResult.hasPrivKey());
    assertTrue(actualFromPublicOnlyResult.isPubKeyOnly());
    assertSame(pub, actualFromPublicOnlyResult.getPubKeyPoint());
  }

  /**
   * Test {@link SM2#fromPublicOnly(ECPoint)} with {@code ECPoint}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromPublicOnly(ECPoint)"})
  public void testFromPublicOnlyWithECPoint_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly((ECPoint) null));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with two and {@code ^}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithTwoAndCircumflexAccent() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2, '^', 't', -93, 14, -45, -98, -101, 21, -7, -127, -31, 29, '9', -4, '(', '}', '%', -96,
          -28, -62, 'A', 'r', -126, '\f', '"', 27, -84, 0, -63, -62, 'q', '7'
        },
        SM2.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with two and minus seventy-one.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithTwoAndMinusSeventyOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2, -71, -61, -6, -21, 'K', 22, 16, 'q', '=', -76, '3', '=', 'N', -122, 14, 'd', -44, -22,
          '5', -42, '\f', 28, ')', -69, 'g', ']', -126, '-', -19, 11, -71, 22
        },
        SM2.publicKeyFromPrivate(ECConstants.EIGHT, true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return forty-first element is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenFalse_thenReturnFortyFirstElementIsMinusOneHundred() {
    // Arrange and Act
    byte[] actualPublicKeyFromPrivateResult = SM2.publicKeyFromPrivate(ECConstants.EIGHT, false);

    // Assert
    assertEquals((byte) -100, actualPublicKeyFromPrivateResult[40]);
    assertEquals((byte) -102, actualPublicKeyFromPrivateResult[45]);
    assertEquals((byte) -111, actualPublicKeyFromPrivateResult[42]);
    assertEquals((byte) -122, actualPublicKeyFromPrivateResult[14]);
    assertEquals((byte) -14, actualPublicKeyFromPrivateResult[47]);
    assertEquals((byte) -21, actualPublicKeyFromPrivateResult[4]);
    assertEquals((byte) -22, actualPublicKeyFromPrivateResult[18]);
    assertEquals((byte) -32, actualPublicKeyFromPrivateResult[56]);
    assertEquals((byte) -34, actualPublicKeyFromPrivateResult[44]);
    assertEquals((byte) -42, actualPublicKeyFromPrivateResult[20]);
    assertEquals((byte) -44, actualPublicKeyFromPrivateResult[17]);
    assertEquals((byte) -45, actualPublicKeyFromPrivateResult[62]);
    assertEquals((byte) -46, actualPublicKeyFromPrivateResult[43]);
    assertEquals((byte) -49, actualPublicKeyFromPrivateResult[61]);
    assertEquals((byte) -52, actualPublicKeyFromPrivateResult[46]);
    assertEquals((byte) -61, actualPublicKeyFromPrivateResult[2]);
    assertEquals((byte) -66, actualPublicKeyFromPrivateResult[48]);
    assertEquals((byte) -69, actualPublicKeyFromPrivateResult[24]);
    assertEquals((byte) -6, actualPublicKeyFromPrivateResult[3]);
    assertEquals((byte) -71, actualPublicKeyFromPrivateResult[1]);
    assertEquals((byte) -76, actualPublicKeyFromPrivateResult[10]);
    assertEquals((byte) -77, actualPublicKeyFromPrivateResult[55]);
    assertEquals((byte) -88, actualPublicKeyFromPrivateResult[51]);
    assertEquals((byte) -94, actualPublicKeyFromPrivateResult[60]);
    assertEquals((byte) -96, actualPublicKeyFromPrivateResult[52]);
    assertEquals((byte) 14, actualPublicKeyFromPrivateResult[15]);
    assertEquals((byte) 16, actualPublicKeyFromPrivateResult[7]);
    assertEquals((byte) 22, actualPublicKeyFromPrivateResult[6]);
    assertEquals((byte) 26, actualPublicKeyFromPrivateResult[63]);
    assertEquals((byte) 28, actualPublicKeyFromPrivateResult[22]);
    assertEquals((byte) 3, actualPublicKeyFromPrivateResult[49]);
    assertEquals((byte) 4, actualPublicKeyFromPrivateResult[0]);
    assertEquals(65, actualPublicKeyFromPrivateResult.length);
    assertEquals('$', actualPublicKeyFromPrivateResult[41]);
    assertEquals('$', actualPublicKeyFromPrivateResult[54]);
    assertEquals('(', actualPublicKeyFromPrivateResult[58]);
    assertEquals(')', actualPublicKeyFromPrivateResult[23]);
    assertEquals('0', actualPublicKeyFromPrivateResult[53]);
    assertEquals('3', actualPublicKeyFromPrivateResult[11]);
    assertEquals('5', actualPublicKeyFromPrivateResult[19]);
    assertEquals('<', actualPublicKeyFromPrivateResult[57]);
    assertEquals('=', actualPublicKeyFromPrivateResult[12]);
    assertEquals('=', actualPublicKeyFromPrivateResult[9]);
    assertEquals('>', actualPublicKeyFromPrivateResult[Double.SIZE]);
    assertEquals('K', actualPublicKeyFromPrivateResult[5]);
    assertEquals('N', actualPublicKeyFromPrivateResult[13]);
    assertEquals('\f', actualPublicKeyFromPrivateResult[21]);
    assertEquals('d', actualPublicKeyFromPrivateResult[Short.SIZE]);
    assertEquals('f', actualPublicKeyFromPrivateResult[50]);
    assertEquals('m', actualPublicKeyFromPrivateResult[59]);
    assertEquals('q', actualPublicKeyFromPrivateResult[8]);
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#FOUR}.
   *   <li>Then return array of {@code byte} with three and minus sixty-two.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenFour_thenReturnArrayOfByteWithThreeAndMinusSixtyTwo() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          3, -62, '9', 'P', 'q', 5, -58, -125, '$', '*', -127, 5, '/', -10, 'A', -19, 'i', 0, -102,
          '\b', 'J', -43, -52, -109, '}', -78, 22, 'F', -51, '4', -96, -50, -43
        },
        SM2.publicKeyFromPrivate(ECConstants.FOUR, true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ONE}.
   *   <li>Then return array of {@code byte} with two and {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenOne_thenReturnArrayOfByteWithTwoAnd2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          2, '2', -60, -82, ',', 31, 25, -127, 25, '_', -103, 4, 'F', 'j', '9', -55, -108, -113,
          -29, 11, -65, -14, 'f', 11, -31, 'q', 'Z', 'E', -119, '3', 'L', 't', -57
        },
        SM2.publicKeyFromPrivate(ECConstants.ONE, true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#TWO}.
   *   <li>Then return array of {@code byte} with three and {@code V}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenTwo_thenReturnArrayOfByteWithThreeAndV() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          3, 'V', -50, -3, '`', -41, -56, '|', 0, '\r', 'X', -17, 'W', -6, 's', -70, 'M', -100,
          '\r', -6, '\b', -64, -118, 's', '1', 'I', '\\', '.', 29, -93, -14, -67, 'R'
        },
        SM2.publicKeyFromPrivate(ECConstants.TWO, true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When valueOf minus one.
   *   <li>Then return array of {@code byte} with three and {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenValueOfMinusOne_thenReturnArrayOfByteWithThreeAnd2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          3, '2', -60, -82, ',', 31, 25, -127, 25, '_', -103, 4, 'F', 'j', '9', -55, -108, -113,
          -29, 11, -65, -14, 'f', 11, -31, 'q', 'Z', 'E', -119, '3', 'L', 't', -57
        },
        SM2.publicKeyFromPrivate(BigInteger.valueOf(-1L), true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenZero_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0}, SM2.publicKeyFromPrivate(ECConstants.ZERO, true));
  }

  /**
   * Test {@link SM2#pubBytesWithoutFormat(ECPoint)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_givenAxaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubBytesWithoutFormatResult = SM2.pubBytesWithoutFormat(pubPoint);

    // Assert
    verify(pubPoint).getEncoded(false);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualPubBytesWithoutFormatResult);
  }

  /**
   * Test {@link SM2#pubBytesWithoutFormat(ECPoint)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.pubBytesWithoutFormat(pubPoint));
    verify(pubPoint).getEncoded(false);
  }

  /**
   * Test {@link SM2#fromNodeId(byte[])}.
   *
   * <p>Method under test: {@link SM2#fromNodeId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.fromNodeId(byte[])"})
  public void testFromNodeId() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SM2.fromNodeId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithAAndMin_value() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMax_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {Byte.MAX_VALUE, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMin_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and minus one.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX3() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX4() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX5() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX6() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX7() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(new byte[] {-1, 'X', Byte.MIN_VALUE, -1, 0, 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX8() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, -1, -1, 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX9() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(new byte[] {-1, 'X', Byte.MIN_VALUE, -1, 'A', 0, 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and zero.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndZero() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {-1, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with space and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithSpaceAndMin_value() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {' ', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with space and zero.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithSpaceAndZero() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {' ', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-eight and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithTwentyEightAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {28, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-seven and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithTwentySevenAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {27, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenAxaxaxaxBytesIsUtf8_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> SM2Signature.decodeFromDER("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenEmptyArrayOfByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> SM2Signature.decodeFromDER(new byte[] {}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenSpace_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            SM2Signature.decodeFromDER(
                new byte[] {-1, 'X', Byte.MIN_VALUE, ' ', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenXaxaxaxBytesIsUtf8_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> SM2Signature.decodeFromDER(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test SM2Signature {@link SM2Signature#fromComponents(byte[], byte[], byte)} with {@code r},
   * {@code s}, {@code v}.
   *
   * <p>Method under test: {@link SM2Signature#fromComponents(byte[], byte[], byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2Signature.fromComponents(byte[], byte[], byte)"})
  public void testSM2SignatureFromComponentsWithRSV() throws UnsupportedEncodingException {
    // Arrange and Act
    SM2Signature actualFromComponentsResult =
        SM2Signature.fromComponents(
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
   * Test SM2Signature {@link SM2Signature#SM2Signature(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link SM2Signature#SM2Signature(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2Signature.<init>(BigInteger, BigInteger)"})
  public void testSM2SignatureNewSM2Signature() {
    // Arrange and Act
    SM2Signature actualSm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);

    // Assert
    BigInteger bigInteger = actualSm2Signature.r;
    assertEquals("8", bigInteger.toString());
    BigInteger bigInteger2 = actualSm2Signature.s;
    assertEquals("8", bigInteger2.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertEquals(3, bigInteger2.getLowestSetBit());
    assertArrayEquals(new byte[] {'\b'}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {'\b'}, bigInteger2.toByteArray());
  }

  /**
   * Test SM2Signature {@link SM2Signature#SM2Signature(byte[], byte[], byte)}.
   *
   * <p>Method under test: {@link SM2Signature#SM2Signature(byte[], byte[], byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SM2Signature.<init>(byte[], byte[], byte)"})
  public void testSM2SignatureNewSM2Signature2() throws UnsupportedEncodingException {
    // Arrange and Act
    SM2Signature actualSm2Signature =
        new SM2Signature("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        actualSm2Signature.toHex());
    BigInteger bigInteger = actualSm2Signature.r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    BigInteger expectedBigInteger = actualSm2Signature.r;
    assertEquals(expectedBigInteger, actualSm2Signature.s);
    assertEquals('A', actualSm2Signature.v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Test SM2Signature {@link SM2Signature#toBase64()}.
   *
   * <p>Method under test: {@link SM2Signature#toBase64()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SM2Signature.toBase64()"})
  public void testSM2SignatureToBase64() {
    // Arrange, Act and Assert
    assertEquals(
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAg=",
        new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT).toBase64());
  }

  /**
   * Test SM2Signature {@link SM2Signature#toByteArray()}.
   *
   * <p>Method under test: {@link SM2Signature#toByteArray()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2Signature.toByteArray()"})
  public void testSM2SignatureToByteArray() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);
    sm2Signature.v = (byte) 27;

    // Act
    byte[] actualToByteArrayResult = sm2Signature.toByteArray();

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
    assertEquals((byte) 0, actualToByteArrayResult[24]);
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
    assertEquals((byte) 0, actualToByteArrayResult[56]);
    assertEquals((byte) 0, actualToByteArrayResult[57]);
    assertEquals((byte) 0, actualToByteArrayResult[58]);
    assertEquals((byte) 0, actualToByteArrayResult[59]);
    assertEquals((byte) 0, actualToByteArrayResult[6]);
    assertEquals((byte) 0, actualToByteArrayResult[60]);
    assertEquals((byte) 0, actualToByteArrayResult[61]);
    assertEquals((byte) 0, actualToByteArrayResult[62]);
    assertEquals((byte) 0, actualToByteArrayResult[7]);
    assertEquals((byte) 0, actualToByteArrayResult[8]);
    assertEquals((byte) 0, actualToByteArrayResult[9]);
    assertEquals((byte) 0, actualToByteArrayResult[Double.SIZE]);
    assertEquals((byte) 0, actualToByteArrayResult[Short.SIZE]);
    assertEquals(65, actualToByteArrayResult.length);
    assertEquals('\b', actualToByteArrayResult[63]);
  }

  /**
   * Test SM2Signature {@link SM2Signature#toByteArray()}.
   *
   * <ul>
   *   <li>Then return twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#toByteArray()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2Signature.toByteArray()"})
  public void testSM2SignatureToByteArray_thenReturnTwentySix() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);
    sm2Signature.v = (byte) 26;

    // Act
    byte[] actualToByteArrayResult = sm2Signature.toByteArray();

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
    assertEquals((byte) 0, actualToByteArrayResult[24]);
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
    assertEquals((byte) 0, actualToByteArrayResult[56]);
    assertEquals((byte) 0, actualToByteArrayResult[57]);
    assertEquals((byte) 0, actualToByteArrayResult[58]);
    assertEquals((byte) 0, actualToByteArrayResult[59]);
    assertEquals((byte) 0, actualToByteArrayResult[6]);
    assertEquals((byte) 0, actualToByteArrayResult[60]);
    assertEquals((byte) 0, actualToByteArrayResult[61]);
    assertEquals((byte) 0, actualToByteArrayResult[62]);
    assertEquals((byte) 0, actualToByteArrayResult[7]);
    assertEquals((byte) 0, actualToByteArrayResult[8]);
    assertEquals((byte) 0, actualToByteArrayResult[9]);
    assertEquals((byte) 0, actualToByteArrayResult[Short.SIZE]);
    assertEquals((byte) 26, actualToByteArrayResult[Double.SIZE]);
    assertEquals(65, actualToByteArrayResult.length);
    assertEquals('\b', actualToByteArrayResult[63]);
  }

  /**
   * Test SM2Signature {@link SM2Signature#toHex()}.
   *
   * <ul>
   *   <li>Given {@link SM2Signature#SM2Signature(BigInteger, BigInteger)} with r is {@link
   *       ECConstants#EIGHT} and s is {@link ECConstants#EIGHT} {@link SM2Signature#v} is
   *       twenty-seven.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#toHex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SM2Signature.toHex()"})
  public void testSM2SignatureToHex_givenSM2SignatureWithRIsEightAndSIsEightVIsTwentySeven() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);
    sm2Signature.v = (byte) 27;

    // Act and Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000008000000000000000000000000000000000000"
            + "000000000000000000000000000800",
        sm2Signature.toHex());
  }

  /**
   * Test SM2Signature {@link SM2Signature#toHex()}.
   *
   * <ul>
   *   <li>Given {@link SM2Signature#SM2Signature(BigInteger, BigInteger)} with r is {@link
   *       ECConstants#EIGHT} and s is {@link ECConstants#EIGHT} {@link SM2Signature#v} is
   *       twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#toHex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SM2Signature.toHex()"})
  public void testSM2SignatureToHex_givenSM2SignatureWithRIsEightAndSIsEightVIsTwentySix() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);
    sm2Signature.v = (byte) 26;

    // Act and Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000008000000000000000000000000000000000000"
            + "00000000000000000000000000081a",
        sm2Signature.toHex());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   *
   * <p>Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);
    sm2Signature.v = (byte) 27;

    // Act and Assert
    assertTrue(sm2Signature.validateComponents());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   *
   * <p>Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents2() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT);
    sm2Signature.v = (byte) 28;

    // Act and Assert
    assertTrue(sm2Signature.validateComponents());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   *
   * <p>Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents3() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.ZERO, ECConstants.EIGHT);
    sm2Signature.v = (byte) 27;

    // Act and Assert
    assertFalse(sm2Signature.validateComponents());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   *
   * <p>Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents4() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECConstants.EIGHT, ECConstants.ZERO);
    sm2Signature.v = (byte) 27;

    // Act and Assert
    assertFalse(sm2Signature.validateComponents());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with
   * {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_thenReturnTrue() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        SM2Signature.validateComponents(ECConstants.EIGHT, ECConstants.EIGHT, (byte) 27);

    // Assert
    assertTrue(actualValidateComponentsResult);
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with
   * {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_whenA() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        SM2Signature.validateComponents(ECConstants.EIGHT, ECConstants.EIGHT, (byte) 'A');

    // Assert
    assertFalse(actualValidateComponentsResult);
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with
   * {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_whenTwentyEight() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        SM2Signature.validateComponents(ECConstants.EIGHT, ECConstants.EIGHT, (byte) 28);

    // Assert
    assertTrue(actualValidateComponentsResult);
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with
   * {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_whenZero() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        SM2Signature.validateComponents(ECConstants.ZERO, ECConstants.EIGHT, (byte) 27);

    // Assert
    assertFalse(actualValidateComponentsResult);
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with
   * {@code BigInteger}, {@code BigInteger}, {@code byte}.
   *
   * <ul>
   *   <li>When {@link ECConstants#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_whenZero2() {
    // Arrange and Act
    boolean actualValidateComponentsResult =
        SM2Signature.validateComponents(ECConstants.EIGHT, ECConstants.ZERO, (byte) 27);

    // Assert
    assertFalse(actualValidateComponentsResult);
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   *
   * <ul>
   *   <li>Given {@link SM2Signature#SM2Signature(BigInteger, BigInteger)} with r is {@link
   *       ECConstants#EIGHT} and s is {@link ECConstants#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents_givenSM2SignatureWithRIsEightAndSIsEight() {
    // Arrange, Act and Assert
    assertFalse(new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT).validateComponents());
  }

  /**
   * Test {@link SM2#signatureToKeyBytes(byte[], SM2Signature)} with {@code messageHash}, {@code
   * sig}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKeyBytes(byte[], SM2Signature)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToKeyBytes(byte[], SM2Signature)"})
  public void testSignatureToKeyBytesWithMessageHashSig_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), (SM2Signature) null));
  }

  /**
   * Test {@link SM2#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code Could not decode base64}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64_whenCouldNotDecodeBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> SM2.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link SM2#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64_whenEmptyString()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class, () -> SM2.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), ""));
  }

  /**
   * Test {@link SM2#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code PrivateKey}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64_whenJavaSecurityPrivateKey()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> SM2.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), "java.security.PrivateKey"));
  }

  /**
   * Test {@link SM2#hash(byte[])}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getCurve()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#hash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.hash(byte[])"})
  public void testHash_givenECPointGetCurveThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getCurve()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.fromPublicOnly(pub).hash("AXAXAXAX".getBytes("UTF-8")));
    verify(pub).getCurve();
  }

  /**
   * Test {@link SM2#hash(byte[])}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getXCoord()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link ECPoint#getXCoord()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#hash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.hash(byte[])"})
  public void testHash_givenECPointGetXCoordThrowIllegalArgumentException_thenCallsGetXCoord()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint ecPoint = mock(ECPoint.class);
    when(ecPoint.getXCoord()).thenThrow(new IllegalArgumentException());

    ECPoint pub = mock(ECPoint.class);
    when(pub.isInfinity()).thenReturn(false);
    when(pub.normalize()).thenReturn(ecPoint);
    when(pub.getCurve()).thenReturn(new SM2P256V1Curve());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.fromPublicOnly(pub).hash("AXAXAXAX".getBytes("UTF-8")));
    verify(pub, atLeast(1)).getCurve();
    verify(ecPoint).getXCoord();
    verify(pub).isInfinity();
    verify(pub).normalize();
  }

  /**
   * Test {@link SM2#hash(byte[])}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#isInfinity()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link ECPoint#isInfinity()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#hash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.hash(byte[])"})
  public void testHash_givenECPointIsInfinityThrowIllegalArgumentException_thenCallsIsInfinity()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.isInfinity()).thenThrow(new IllegalArgumentException());
    when(pub.getCurve()).thenReturn(new SM2P256V1Curve());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.fromPublicOnly(pub).hash("AXAXAXAX".getBytes("UTF-8")));
    verify(pub, atLeast(1)).getCurve();
    verify(pub).isInfinity();
  }

  /**
   * Test {@link SM2#getPrivateKey()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getPrivateKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getPrivateKey()"})
  public void testGetPrivateKey_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPublicOnly(mock(ECPoint.class)).getPrivateKey());
  }

  /**
   * Test {@link SM2#getPubKey()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getPubKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getPubKey()"})
  public void testGetPubKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubKey = SM2.fromPublicOnly(pub).getPubKey();

    // Assert
    verify(pub).getEncoded(false);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPubKey);
  }

  /**
   * Test {@link SM2#getPubKey()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getPubKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getPubKey()"})
  public void testGetPubKey_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getPubKey());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#getAddress()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and nineteen.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getAddress()"})
  public void testGetAddress_thenReturnArrayOfByteWithAAndNineteen()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualAddress = SM2.fromPublicOnly(pub).getAddress();

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
   * Test {@link SM2#getAddress()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getAddress()"})
  public void testGetAddress_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getAddress());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#signatureToAddress(byte[], SM2Signature)} with {@code messageHash}, {@code
   * sig}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToAddress(byte[], SM2Signature)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToAddress(byte[], SM2Signature)"})
  public void testSignatureToAddressWithMessageHashSig_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), (SM2Signature) null));
  }

  /**
   * Test {@link SM2#signatureToAddress(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code Could not decode base64}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_whenCouldNotDecodeBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> SM2.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link SM2#signatureToAddress(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_whenEmptyString()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class, () -> SM2.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), ""));
  }

  /**
   * Test {@link SM2#signatureToAddress(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code PrivateKey}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_whenJavaSecurityPrivateKey()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> SM2.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "java.security.PrivateKey"));
  }

  /**
   * Test {@link SM2#signatureToKey(byte[], SM2Signature)} with {@code messageHash}, {@code sig}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKey(byte[], SM2Signature)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.signatureToKey(byte[], SM2Signature)"})
  public void testSignatureToKeyWithMessageHashSig_whenNull_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.signatureToKey("AXAXAXAX".getBytes("UTF-8"), (SM2Signature) null));
  }

  /**
   * Test {@link SM2#signatureToKey(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code Could not decode base64}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKey(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.signatureToKey(byte[], String)"})
  public void testSignatureToKeyWithMessageHashSignatureBase64_whenCouldNotDecodeBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> SM2.signatureToKey("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link SM2#signatureToKey(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKey(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.signatureToKey(byte[], String)"})
  public void testSignatureToKeyWithMessageHashSignatureBase64_whenEmptyString()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class, () -> SM2.signatureToKey("AXAXAXAX".getBytes("UTF-8"), ""));
  }

  /**
   * Test {@link SM2#signatureToKey(byte[], String)} with {@code messageHash}, {@code
   * signatureBase64}.
   *
   * <ul>
   *   <li>When {@code PrivateKey}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signatureToKey(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.signatureToKey(byte[], String)"})
  public void testSignatureToKeyWithMessageHashSignatureBase64_whenJavaSecurityPrivateKey()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () -> SM2.signatureToKey("AXAXAXAX".getBytes("UTF-8"), "java.security.PrivateKey"));
  }

  /**
   * Test {@link SM2#signMessage(byte[], String)}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then throw {@link ECKey.MissingPrivateKeyException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signMessage(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2.signMessage(byte[], String)"})
  public void testSignMessage_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        MissingPrivateKeyException.class,
        () ->
            SM2.fromPublicOnly(mock(ECPoint.class))
                .signMessage("AXAXAXAX".getBytes("UTF-8"), "User ID"));
  }

  /**
   * Test {@link SM2#signMsg(byte[], String)}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then throw {@link ECKey.MissingPrivateKeyException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#signMsg(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signature SM2.signMsg(byte[], String)"})
  public void testSignMsg_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        MissingPrivateKeyException.class,
        () ->
            SM2.fromPublicOnly(mock(ECPoint.class))
                .signMsg("AXAXAXAX".getBytes("UTF-8"), "User ID"));
  }

  /**
   * Test {@link SM2#getSM2SignerForHash()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getCurve()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getSM2SignerForHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signer SM2.getSM2SignerForHash()"})
  public void testGetSM2SignerForHash_givenECPointGetCurveThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getCurve()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getSM2SignerForHash());
    verify(pub).getCurve();
  }

  /**
   * Test {@link SM2#getSM2SignerForHash()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#isInfinity()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getSM2SignerForHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signer SM2.getSM2SignerForHash()"})
  public void testGetSM2SignerForHash_givenECPointIsInfinityThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.isInfinity()).thenThrow(new IllegalArgumentException());
    when(pub.getCurve()).thenReturn(new SM2P256V1Curve());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getSM2SignerForHash());
    verify(pub, atLeast(1)).getCurve();
    verify(pub).isInfinity();
  }

  /**
   * Test {@link SM2#getSM2SignerForHash()}.
   *
   * <ul>
   *   <li>Then calls {@link ECPoint#getXCoord()}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getSM2SignerForHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2Signer SM2.getSM2SignerForHash()"})
  public void testGetSM2SignerForHash_thenCallsGetXCoord() {
    // Arrange
    ECPoint ecPoint = mock(ECPoint.class);
    when(ecPoint.getXCoord()).thenThrow(new IllegalArgumentException());

    ECPoint pub = mock(ECPoint.class);
    when(pub.isInfinity()).thenReturn(false);
    when(pub.normalize()).thenReturn(ecPoint);
    when(pub.getCurve()).thenReturn(new SM2P256V1Curve());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getSM2SignerForHash());
    verify(pub, atLeast(1)).getCurve();
    verify(ecPoint).getXCoord();
    verify(pub).isInfinity();
    verify(pub).normalize();
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(
            1,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -121, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -122, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -24, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -26, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -36, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -36, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -44, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -4, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -54, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -58, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -5, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -74, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -75, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -83, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -86, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -89, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -91, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) 11, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) 17, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) 21, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) 28, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('@', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('D', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('J', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('K', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('Q', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('X', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('\\', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('\f', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('\r', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('^', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('^', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals('n', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('p', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('p', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('w', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('~', actualRecoverPubBytesFromSignatureResult[54]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature2() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig =
        new SM2Signature("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -120, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -29, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -45, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -49, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -53, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -53, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -53, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -62, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -6, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -74, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -85, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -95, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) 14, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) 17, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) 20, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) 27, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(Byte.MAX_VALUE, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals(Byte.MIN_VALUE, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('#', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('0', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('4', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('8', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('A', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('L', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('N', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('Q', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('Q', actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals('T', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('U', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('"', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('\f', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('^', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('q', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('z', actualRecoverPubBytesFromSignatureResult[59]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(
            0,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -106, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -10, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -123, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -21, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -25, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) -26, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -49, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -51, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -58, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -63, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -65, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -6, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -83, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -8, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -90, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -91, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -92, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) 18, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) 23, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) 25, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) 27, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) 27, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals((byte) 6, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) 6, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('/', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('1', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('2', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('=', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('J', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('[', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('\\', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('j', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('s', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('u', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('v', actualRecoverPubBytesFromSignatureResult[15]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return fifty-sixth element is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFiftySixthElementIsMinusOneHundred()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(
            1, new SM2Signature(ECConstants.EIGHT, ECConstants.ZERO), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -100, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -101, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) -10, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -112, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -116, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -14, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -15, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -22, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -24, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -28, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -4, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -54, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -55, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -55, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -56, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -62, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -65, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -72, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -72, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -77, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -77, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -87, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) 2, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals((byte) 6, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) 7, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('&', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals(')', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('+', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('3', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('A', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('F', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('F', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('V', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('a', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('n', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('p', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[12]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return forty-second element is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFortySecondElementIsMinusOneHundred()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(
            1, new SM2Signature(ECConstants.FOUR, ECConstants.EIGHT), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -100, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -103, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -106, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -117, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -120, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -122, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -124, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -127, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -15, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -15, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -18, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -46, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -4, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -52, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) -52, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -55, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -62, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -63, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -74, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -78, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -87, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) 14, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) 24, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) 24, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(',', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals(':', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('B', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('L', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('V', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('e', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('|', actualRecoverPubBytesFromSignatureResult[63]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return ninth element is minus one hundred one.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnNinthElementIsMinusOneHundredOne() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(
            1,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals((byte) -101, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -108, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -11, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -121, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -125, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -12, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -24, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -27, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -29, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -33, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -49, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -51, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -72, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -80, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -8, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) 0, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) 21, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(Byte.MIN_VALUE, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('&', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('+', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('-', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('6', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('9', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('<', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('C', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('D', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('T', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('U', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('Y', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('[', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('"', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('g', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('q', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals('~', actualRecoverPubBytesFromSignatureResult[57]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.recoverPubBytesFromSignature(
                -1,
                new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.recoverPubBytesFromSignature(
                1, new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT), null));
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenTwo_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult =
        SM2.recoverPubBytesFromSignature(
            2,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualRecoverPubBytesFromSignatureResult);
  }

  /**
   * Test {@link SM2#verify(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#verify(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.verify(byte[], byte[])"})
  public void testVerifyWithByteByte_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.fromPublicOnly(pub)
                .verify("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#verify(byte[], SM2Signature)} with {@code byte[]}, {@code SM2Signature}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#verify(byte[], SM2Signature)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.verify(byte[], SM2Signature)"})
  public void testVerifyWithByteSM2Signature_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SM2.fromPublicOnly(pub).verify("AXAXAXAX".getBytes("UTF-8"), (SM2Signature) null));
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with four.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[] {4}));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[] {3}));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[] {2}));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte}
   *       with four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithFourAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean()))
        .thenReturn(new byte[] {4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte}
   *       with three and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithThreeAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean()))
        .thenReturn(new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte}
   *       with two and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithTwoAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean()))
        .thenReturn(new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(false);
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).isPubKeyCanonical());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAnd9()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(
            1, new SM2Signature(ECConstants.FOUR, ECConstants.EIGHT), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', '9', '\f', -124, 15, -65, ']', -60, -64, -39, 19, -58, '}', -56, 'v', -64, 'P', -13,
          -16, -20, 'K'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndComma()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(
            1,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', ',', -118, '\r', 'j', -69, 'W', 'W', -40, 'z', -23, '\r', '3', 28, -80, 'I', -23,
          '\f', 'n', -105, 'S'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusFortyNine()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(
            1, new SM2Signature(ECConstants.EIGHT, ECConstants.ZERO), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -49, 'C', '@', -57, '/', -92, -12, -108, 24, -116, 'M', -35, 6, -125, ',', -26, '8',
          -15, -6, ';'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus ninety-two.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusNinetyTwo()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(
            0,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          -92,
          -15,
          Byte.MAX_VALUE,
          -100,
          -33,
          -81,
          23,
          27,
          -38,
          'K',
          'J',
          -43,
          ';',
          23,
          -27,
          22,
          '\f',
          -46,
          3,
          'a'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus seventy-one.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusSeventyOne()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig =
        new SM2Signature("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -71, '9', '^', -19, -104, 29, 4, 'Q', -41, -117, -19, -49, '0', -48, '8', '_', -34,
          30, -15, '9'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.recoverAddressFromSignature(
                -1,
                new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.recoverAddressFromSignature(
                1, new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT), null));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenTwo_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(
            2,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with {@code A} and minus eighty.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenX_thenReturnArrayOfByteWithAAndMinusEighty() {
    // Arrange and Act
    byte[] actualRecoverAddressFromSignatureResult =
        SM2.recoverAddressFromSignature(
            1,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', -80, -70, -72, 'R', '=', 'm', 'G', -37, 'u', -97, 'T', ')', 'X', -124, 'v', '|', -60,
          -4, '7', ';'
        },
        actualRecoverAddressFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAnd9()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(
            1, new SM2Signature(ECConstants.FOUR, ECConstants.EIGHT), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals(
        "pub:04846786b25d4c10cc998b0e54bed23b6b74c2812eee2ce9fe90c4d30f864e537db0fe75fbc06a4ec19cb66bd52ecc65"
            + "965618c9fc10f142883abda99ef1187c64",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', '9', '\f', -124, 15, -65, ']', -60, -64, -39, 19, -58, '}', -56, 'v', -64, 'P', -13,
          -16, -20, 'K'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -124, 'g', -122, -78, ']', 'L', 16, -52, -103, -117, 14, 'T', -66, -46, ';', 'k', 't',
          -62, -127, '.', -18, ',', -23, -2, -112, -60, -45, 15, -122, 'N', 'S', '}', -80, -2, 'u',
          -5, -64, 'j', 'N', -63, -100, -74, 'k', -43, '.', -52, 'e', -106, 'V', 24, -55, -4, 16,
          -15, 'B', -120, ':', -67, -87, -98, -15, 24, '|', 'd'
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndComma()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(
            1,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals(
        "pub:04a22a0ca5700d5f0170584b7751dc40b6e686bd6eca4aadaa3f0c7059bab38e94bbbb80c9b395cfb5fbd4131c5e15c6"
            + "0b4487dc110a7e205cfea7b15ee8899efc",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', ',', -118, '\r', 'j', -69, 'W', 'W', -40, 'z', -23, '\r', '3', 28, -80, 'I', -23,
          '\f', 'n', -105, 'S'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -94,
          '*',
          '\f',
          -91,
          'p',
          '\r',
          '_',
          1,
          'p',
          'X',
          'K',
          'w',
          'Q',
          -36,
          '@',
          -74,
          -26,
          -122,
          -67,
          'n',
          -54,
          'J',
          -83,
          -86,
          '?',
          '\f',
          'p',
          'Y',
          -70,
          -77,
          -114,
          -108,
          -69,
          -69,
          Byte.MIN_VALUE,
          -55,
          -77,
          -107,
          -49,
          -75,
          -5,
          -44,
          19,
          28,
          '^',
          21,
          -58,
          11,
          'D',
          -121,
          -36,
          17,
          '\n',
          '~',
          ' ',
          '\\',
          -2,
          -89,
          -79,
          '^',
          -24,
          -119,
          -98,
          -4
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusFortyNine()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(
            1, new SM2Signature(ECConstants.EIGHT, ECConstants.ZERO), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals(
        "pub:04fc26e40646c8bfc9e8ea5f720102339bdff270b346c90725b085af65017dd925ee251a3571c6715ff6f96167605d90"
            + "296efe2bf1418c9cb856cab8dba945c2b3",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', -49, 'C', '@', -57, '/', -92, -12, -108, 24, -116, 'M', -35, 6, -125, ',', -26, '8',
          -15, -6, ';'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -4, '&', -28, 6, 'F', -56, -65, -55, -24, -22, '_', 'r', 1, 2, '3', -101, -33, -14, 'p',
          -77, 'F', -55, 7, '%', -80, -123, -81, 'e', 1, '}', -39, '%', -18, '%', 26, '5', 'q', -58,
          'q', '_', -10, -7, 'a', 'g', '`', ']', -112, ')', 'n', -2, '+', -15, 'A', -116, -100, -72,
          'V', -54, -72, -37, -87, 'E', -62, -77
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus ninety-two.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusNinetyTwo()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(
            0,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals(
        "pub:04c65ce9cf6431a406202f12a5faf67606e7016a4a1b25bff896ee5af41364da46281bbbd3ff8f3517a619982eeb3dc1"
            + "b0327585675b96ad9acd2e1bbe647273e6",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A',
          -92,
          -15,
          Byte.MAX_VALUE,
          -100,
          -33,
          -81,
          23,
          27,
          -38,
          'K',
          'J',
          -43,
          ';',
          23,
          -27,
          22,
          '\f',
          -46,
          3,
          'a'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -58, '\\', -23, -49, 'd', '1', -92, 6, ' ', '/', 18, -91, -6, -10, 'v', 6, -25, 1, 'j',
          'J', 27, '%', -65, -8, -106, -18, 'Z', -12, 19, 'd', -38, 'F', '(', 27, -69, -45, -1,
          -113, '5', 23, -90, 25, -104, '.', -21, '=', -63, -80, '2', 'u', -123, 'g', '[', -106,
          -83, -102, -51, '.', 27, -66, 'd', 'r', 's', -26
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus seventy-one.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusSeventyOne()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig =
        new SM2Signature("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals(
        "pub:04cbcf5e8822a171b6897f54cb0c4ec29d5130678020370e34118de7c719aa3fe41822c88f2761c6e3d3384c4110371b"
            + "452ed555141151fa3f23a27a98abcb749d",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', -71, '9', '^', -19, -104, 29, 4, 'Q', -41, -117, -19, -49, '0', -48, '8', '_', -34,
          30, -15, '9'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          -53,
          -49,
          '^',
          -120,
          '"',
          -95,
          'q',
          -74,
          -119,
          Byte.MAX_VALUE,
          'T',
          -53,
          '\f',
          'N',
          -62,
          -99,
          'Q',
          '0',
          'g',
          Byte.MIN_VALUE,
          ' ',
          '7',
          14,
          '4',
          17,
          -115,
          -25,
          -57,
          25,
          -86,
          '?',
          -28,
          24,
          '"',
          -56,
          -113,
          '\'',
          'a',
          -58,
          -29,
          -45,
          '8',
          'L',
          'A',
          16,
          '7',
          27,
          'E',
          '.',
          -43,
          'U',
          20,
          17,
          'Q',
          -6,
          '?',
          '#',
          -94,
          'z',
          -104,
          -85,
          -53,
          't',
          -99
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.recoverFromSignature(
                -1,
                new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            SM2.recoverFromSignature(
                1, new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT), null));
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenTwo_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(
            2,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualRecoverFromSignatureResult);
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus eighty.
   * </ul>
   *
   * <p>Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenX_thenReturnAddressIsArrayOfByteWithAAndMinusEighty() {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult =
        SM2.recoverFromSignature(
            1,
            new SM2Signature(ECConstants.EIGHT, ECConstants.EIGHT),
            new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals(
        "pub:040059f87b3667139b94b05554e34de837262a542d989e742e522ca218f26bb1696bdcf543c53e88df5f87e522ff71f5"
            + "f4472eb844cd155b807e4383394dcf2b3c",
        actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(
        new byte[] {
          'A', -80, -70, -72, 'R', '=', 'm', 'G', -37, 'u', -97, 'T', ')', 'X', -124, 'v', '|', -60,
          -4, '7', ';'
        },
        actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[] {
          0,
          'Y',
          -8,
          '{',
          '6',
          'g',
          19,
          -101,
          -108,
          -80,
          'U',
          'T',
          -29,
          'M',
          -24,
          '7',
          '&',
          '*',
          'T',
          '-',
          -104,
          -98,
          't',
          '.',
          'R',
          ',',
          -94,
          24,
          -14,
          'k',
          -79,
          'i',
          'k',
          -36,
          -11,
          'C',
          -59,
          '>',
          -120,
          -33,
          '_',
          -121,
          -27,
          '"',
          -1,
          'q',
          -11,
          -12,
          'G',
          '.',
          -72,
          'D',
          -51,
          21,
          '[',
          Byte.MIN_VALUE,
          '~',
          'C',
          -125,
          '9',
          'M',
          -49,
          '+',
          '<'
        },
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#isPubKeyOnly()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#isPubKeyOnly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.isPubKeyOnly()"})
  public void testIsPubKeyOnly_givenFromPublicOnlyECPoint_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SM2.fromPublicOnly(mock(ECPoint.class)).isPubKeyOnly());
  }

  /**
   * Test {@link SM2#hasPrivKey()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#hasPrivKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SM2.hasPrivKey()"})
  public void testHasPrivKey_givenFromPublicOnlyECPoint_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.fromPublicOnly(mock(ECPoint.class)).hasPrivKey());
  }

  /**
   * Test {@link SM2#getNodeId()}.
   *
   * <ul>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getNodeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getNodeId()"})
  public void testGetNodeId_thenReturnXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualNodeId = SM2.fromPublicOnly(pub).getNodeId();

    // Assert
    verify(pub).getEncoded(false);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualNodeId);
  }

  /**
   * Test {@link SM2#getNodeId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getNodeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getNodeId()"})
  public void testGetNodeId_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getNodeId());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#getPrivKey()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then throw {@link ECKey.MissingPrivateKeyException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getPrivKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger SM2.getPrivKey()"})
  public void testGetPrivKey_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException() {
    // Arrange, Act and Assert
    assertThrows(
        MissingPrivateKeyException.class,
        () -> SM2.fromPublicOnly(mock(ECPoint.class)).getPrivKey());
  }

  /**
   * Test {@link SM2#toStringWithPrivate()}.
   *
   * <ul>
   *   <li>Then return {@code pub:4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#toStringWithPrivate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SM2.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenReturnPub4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringWithPrivateResult = SM2.fromPublicOnly(pub).toStringWithPrivate();

    // Assert
    verify(pub).getEncoded(false);
    assertEquals("pub:4158415841584158", actualToStringWithPrivateResult);
  }

  /**
   * Test {@link SM2#toStringWithPrivate()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#toStringWithPrivate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SM2.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).toStringWithPrivate());
    verify(pub).getEncoded(false);
  }

  /**
   * Test {@link SM2#getPrivKeyBytes()}.
   *
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SM2#getPrivKeyBytes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SM2.getPrivKeyBytes()"})
  public void testGetPrivKeyBytes_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPublicOnly(mock(ECPoint.class)).getPrivKeyBytes());
  }
}
