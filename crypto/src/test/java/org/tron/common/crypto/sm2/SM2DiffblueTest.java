package org.tron.common.crypto.sm2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.security.SignatureException;
import java.security.spec.ECField;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.Fp;
import org.bouncycastle.math.ec.custom.djb.Curve25519FieldElement;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey;
import org.tron.common.crypto.ECKey.MissingPrivateKeyException;
import org.tron.common.crypto.sm2.SM2.SM2Signature;

public class SM2DiffblueTest {
  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   * <ul>
   *   <li>Given {@code Algorithm}.</li>
   *   <li>When {@link AnnotatedPrivateKey} {@link AnnotatedPrivateKey#getAlgorithm()} return {@code Algorithm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_givenAlgorithm_whenAnnotatedPrivateKeyGetAlgorithmReturnAlgorithm() {
    // Arrange
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("Algorithm");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2(privKey, mock(ECPoint.class)));

    verify(privKey, atLeast(1)).getAlgorithm();
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   * <ul>
   *   <li>Given {@code EC}.</li>
   *   <li>When {@link AnnotatedPrivateKey} {@link AnnotatedPrivateKey#getAlgorithm()} return {@code EC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_givenEc_whenAnnotatedPrivateKeyGetAlgorithmReturnEc() {
    // Arrange
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
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
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code EC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_givenIllegalArgumentExceptionWithEc() {
    // Arrange
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenThrow(new IllegalArgumentException("EC"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2(privKey, mock(ECPoint.class)));

    verify(privKey).getAlgorithm();
  }

  /**
   * Test {@link SM2#SM2(byte[], boolean)}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return toStringWithPrivate is {@code pub:00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(byte[], boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(byte[], boolean)"})
  public void testNewSm2_whenArrayOfByteWithZero_thenReturnToStringWithPrivateIsPub00() {
    // Arrange and Act
    SM2 actualSm2 = new SM2(new byte[]{0}, false);

    // Assert
    assertEquals("pub:00", actualSm2.toStringWithPrivate());
    assertNull(actualSm2.getPrivKeyBytes());
    assertNull(actualSm2.getPrivateKey());
    assertFalse(actualSm2.hasPrivKey());
    assertTrue(actualSm2.isPubKeyOnly());
    assertArrayEquals(new byte[]{}, actualSm2.getNodeId());
    assertArrayEquals(new byte[]{0}, actualSm2.getPubKey());
    assertArrayEquals(
        new byte[]{'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123, -92, 'p'},
        actualSm2.getAddress());
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   * <ul>
   *   <li>When {@link EllipticCurve#EllipticCurve(ECField, BigInteger, BigInteger)} with {@link ECField} and {@link ECKey#HALF_CURVE_ORDER} and {@link ECKey#HALF_CURVE_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_whenEllipticCurveWithECFieldAndHalf_curve_orderAndHalf_curve_order() {
    // Arrange
    EllipticCurve ellipticCurve = new EllipticCurve(mock(ECField.class), ECKey.HALF_CURVE_ORDER,
        ECKey.HALF_CURVE_ORDER);

    ECPoint pub = mock(ECPoint.class);

    // Act
    SM2 actualSm2 = new SM2(new BCDSTU4145PrivateKey(new ECPrivateKeySpec(ECKey.HALF_CURVE_ORDER,
        new ECParameterSpec(ellipticCurve,
            new java.security.spec.ECPoint(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), ECKey.HALF_CURVE_ORDER,
            1))),
        pub);

    // Assert
    assertNull(actualSm2.getPrivKeyBytes());
    assertNull(actualSm2.getPrivateKey());
    assertNull(actualSm2.getPubKey());
    assertFalse(actualSm2.isPubKeyOnly());
    assertTrue(actualSm2.hasPrivKey());
    assertSame(pub, actualSm2.getPubKeyPoint());
  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not hasPrivKey.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_whenNull_thenReturnNotHasPrivKey() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);

    // Act
    SM2 actualSm2 = new SM2((PrivateKey) null, pub);

    // Assert
    assertNull(actualSm2.getPrivKeyBytes());
    assertNull(actualSm2.getPrivateKey());
    assertNull(actualSm2.getPubKey());
    assertFalse(actualSm2.hasPrivKey());
    assertTrue(actualSm2.isPubKeyOnly());
    assertSame(pub, actualSm2.getPubKeyPoint());
  }

  /**
   * Test {@link SM2#SM2(BigInteger, ECPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(BigInteger, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(BigInteger, ECPoint)"})
  public void testNewSm2_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2((BigInteger) null, null));

  }

  /**
   * Test {@link SM2#SM2(PrivateKey, ECPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2.<init>(PrivateKey, ECPoint)"})
  public void testNewSm2_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2((PrivateKey) null, null));

  }

  /**
   * Test {@link SM2#compressPoint(ECPoint)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#compressPoint(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECPoint SM2.compressPoint(ECPoint)"})
  public void testCompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint uncompressed = mock(ECPoint.class);
    when(uncompressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.compressPoint(uncompressed));
    verify(uncompressed).getEncoded(eq(true));
  }

  /**
   * Test {@link SM2#decompressPoint(ECPoint)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#decompressPoint(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ECPoint SM2.decompressPoint(ECPoint)"})
  public void testDecompressPoint_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint compressed = mock(ECPoint.class);
    when(compressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.decompressPoint(compressed));
    verify(compressed).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#fromPrivate(byte[])} with {@code privKeyBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#fromPrivate(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromPrivate(byte[])"})
  public void testFromPrivateWithPrivKeyBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPrivate((byte[]) null));
  }

  /**
   * Test {@link SM2#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)} with {@code BigInteger}, {@code ECPoint}.
   * <p>
   * Method under test: {@link SM2#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)"})
  public void testFromPrivateAndPrecalculatedPublicWithBigIntegerECPoint() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPrivateAndPrecalculatedPublic((BigInteger) null, null));
  }

  /**
   * Test {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <p>
   * Method under test: {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPrivateAndPrecalculatedPublic((byte[]) null, null));
  }

  /**
   * Test {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <p>
   * Method under test: {@link SM2#fromPrivateAndPrecalculatedPublic(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromPrivateAndPrecalculatedPublic(byte[], byte[])"})
  public void testFromPrivateAndPrecalculatedPublicWithByteByte2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.fromPrivateAndPrecalculatedPublic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test {@link SM2#fromPublicOnly(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then PubKeyPoint return {@link Fp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#fromPublicOnly(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromPublicOnly(byte[])"})
  public void testFromPublicOnlyWithByte_whenArrayOfByteWithZero_thenPubKeyPointReturnFp() {
    // Arrange and Act
    SM2 actualFromPublicOnlyResult = SM2.fromPublicOnly(new byte[]{0});

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
   * Test {@link SM2#fromPublicOnly(ECPoint)} with {@code ECPoint}.
   * <ul>
   *   <li>When {@link ECPoint}.</li>
   *   <li>Then return PrivKeyBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#fromPublicOnly(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromPublicOnly(ECPoint)"})
  public void testFromPublicOnlyWithECPoint_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly((ECPoint) null));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>Then return array of {@code byte} with two and {@code ^}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_thenReturnArrayOfByteWithTwoAndCircumflexAccent() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{2, '^', 't', -93, 14, -45, -98, -101, 21, -7, -127, -31, 29, '9', -4, '(', '}', '%', -96, -28, -62,
            'A', 'r', -126, '\f', '"', 27, -84, 0, -63, -62, 'q', '7'},
        SM2.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return eighth element is minus one hundred one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenFalse_thenReturnEighthElementIsMinusOneHundredOne() {
    // Arrange and Act
    byte[] actualPublicKeyFromPrivateResult = SM2.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, false);

    // Assert
    assertEquals((byte) -101, actualPublicKeyFromPrivateResult[7]);
    assertEquals((byte) -110, actualPublicKeyFromPrivateResult[51]);
    assertEquals((byte) -111, actualPublicKeyFromPrivateResult[60]);
    assertEquals((byte) -118, actualPublicKeyFromPrivateResult[50]);
    assertEquals((byte) -126, actualPublicKeyFromPrivateResult[23]);
    assertEquals((byte) -127, actualPublicKeyFromPrivateResult[10]);
    assertEquals((byte) -28, actualPublicKeyFromPrivateResult[19]);
    assertEquals((byte) -29, actualPublicKeyFromPrivateResult[54]);
    assertEquals((byte) -31, actualPublicKeyFromPrivateResult[11]);
    assertEquals((byte) -39, actualPublicKeyFromPrivateResult[40]);
    assertEquals((byte) -39, actualPublicKeyFromPrivateResult[44]);
    assertEquals((byte) -40, actualPublicKeyFromPrivateResult[58]);
    assertEquals((byte) -45, actualPublicKeyFromPrivateResult[49]);
    assertEquals((byte) -45, actualPublicKeyFromPrivateResult[5]);
    assertEquals((byte) -4, actualPublicKeyFromPrivateResult[14]);
    assertEquals((byte) -5, actualPublicKeyFromPrivateResult[47]);
    assertEquals((byte) -5, actualPublicKeyFromPrivateResult[55]);
    assertEquals((byte) -60, actualPublicKeyFromPrivateResult[42]);
    assertEquals((byte) -62, actualPublicKeyFromPrivateResult[20]);
    assertEquals((byte) -62, actualPublicKeyFromPrivateResult[53]);
    assertEquals((byte) -66, actualPublicKeyFromPrivateResult[48]);
    assertEquals((byte) -66, actualPublicKeyFromPrivateResult[Double.SIZE]);
    assertEquals((byte) -7, actualPublicKeyFromPrivateResult[9]);
    assertEquals((byte) -80, actualPublicKeyFromPrivateResult[57]);
    assertEquals((byte) -81, actualPublicKeyFromPrivateResult[62]);
    assertEquals((byte) -93, actualPublicKeyFromPrivateResult[3]);
    assertEquals((byte) -96, actualPublicKeyFromPrivateResult[18]);
    assertEquals((byte) -98, actualPublicKeyFromPrivateResult[6]);
    assertEquals((byte) 14, actualPublicKeyFromPrivateResult[4]);
    assertEquals((byte) 21, actualPublicKeyFromPrivateResult[8]);
    assertEquals((byte) 29, actualPublicKeyFromPrivateResult[12]);
    assertEquals((byte) 4, actualPublicKeyFromPrivateResult[0]);
    assertEquals(65, actualPublicKeyFromPrivateResult.length);
    assertEquals('#', actualPublicKeyFromPrivateResult[46]);
    assertEquals('%', actualPublicKeyFromPrivateResult[17]);
    assertEquals('(', actualPublicKeyFromPrivateResult[15]);
    assertEquals(')', actualPublicKeyFromPrivateResult[41]);
    assertEquals('9', actualPublicKeyFromPrivateResult[13]);
    assertEquals(';', actualPublicKeyFromPrivateResult[43]);
    assertEquals('A', actualPublicKeyFromPrivateResult[21]);
    assertEquals('F', actualPublicKeyFromPrivateResult[45]);
    assertEquals('T', actualPublicKeyFromPrivateResult[59]);
    assertEquals('X', actualPublicKeyFromPrivateResult[61]);
    assertEquals('\f', actualPublicKeyFromPrivateResult[24]);
    assertEquals('^', actualPublicKeyFromPrivateResult[1]);
    assertEquals('`', actualPublicKeyFromPrivateResult[56]);
    assertEquals('i', actualPublicKeyFromPrivateResult[52]);
    assertEquals('o', actualPublicKeyFromPrivateResult[63]);
    assertEquals('r', actualPublicKeyFromPrivateResult[22]);
    assertEquals('t', actualPublicKeyFromPrivateResult[2]);
    assertEquals('}', actualPublicKeyFromPrivateResult[Short.SIZE]);
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>When valueOf minus one.</li>
   *   <li>Then return array of {@code byte} with three and {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenValueOfMinusOne_thenReturnArrayOfByteWithThreeAnd2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{3, '2', -60, -82, ',', 31, 25, -127, 25, '_', -103, 4, 'F', 'j', '9', -55, -108, -113, -29, 11, -65,
            -14, 'f', 11, -31, 'q', 'Z', 'E', -119, '3', 'L', 't', -57},
        SM2.publicKeyFromPrivate(BigInteger.valueOf(-1L), true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return array of {@code byte} with two and {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenValueOfOne_thenReturnArrayOfByteWithTwoAnd2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{2, '2', -60, -82, ',', 31, 25, -127, 25, '_', -103, 4, 'F', 'j', '9', -55, -108, -113, -29, 11, -65,
            -14, 'f', 11, -31, 'q', 'Z', 'E', -119, '3', 'L', 't', -57},
        SM2.publicKeyFromPrivate(BigInteger.valueOf(1L), true));
  }

  /**
   * Test {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.publicKeyFromPrivate(BigInteger, boolean)"})
  public void testPublicKeyFromPrivate_whenValueOfZero_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0}, SM2.publicKeyFromPrivate(BigInteger.valueOf(0L), true));
  }

  /**
   * Test {@link SM2#pubBytesWithoutFormat(ECPoint)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_givenAxaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubBytesWithoutFormatResult = SM2.pubBytesWithoutFormat(pubPoint);

    // Assert
    verify(pubPoint).getEncoded(eq(false));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualPubBytesWithoutFormatResult);
  }

  /**
   * Test {@link SM2#pubBytesWithoutFormat(ECPoint)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.pubBytesWithoutFormat(ECPoint)"})
  public void testPubBytesWithoutFormat_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.pubBytesWithoutFormat(pubPoint));
    verify(pubPoint).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#fromNodeId(byte[])}.
   * <p>
   * Method under test: {@link SM2#fromNodeId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.fromNodeId(byte[])"})
  public void testFromNodeId() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromNodeId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithAAndMin_value() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMax_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{Byte.MAX_VALUE, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMin_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX3() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX4() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, -1, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX5() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX6() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', 0, 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndX7() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithMinusOneAndZero() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with space and {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithSpaceAndMin_value() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{' ', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-eight and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithTwentyEightAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{28, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-seven and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithTwentySevenAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{27, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenAxaxaxaxBytesIsUtf8_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> SM2Signature.decodeFromDER("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenEmptyArrayOfByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> SM2Signature.decodeFromDER(new byte[]{}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenSpace_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, ' ', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test SM2Signature {@link SM2Signature#decodeFromDER(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.decodeFromDER(byte[])"})
  public void testSM2SignatureDecodeFromDER_whenXaxaxaxBytesIsUtf8_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> SM2Signature.decodeFromDER(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test SM2Signature {@link SM2Signature#fromComponents(byte[], byte[], byte)} with {@code r}, {@code s}, {@code v}.
   * <p>
   * Method under test: {@link SM2Signature#fromComponents(byte[], byte[], byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2Signature.fromComponents(byte[], byte[], byte)"})
  public void testSM2SignatureFromComponentsWithRSV() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SM2Signature actualFromComponentsResult = SM2Signature.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
   * Test SM2Signature {@link SM2Signature#SM2Signature(BigInteger, BigInteger)}.
   * <p>
   * Method under test: {@link SM2Signature#SM2Signature(BigInteger, BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2Signature.<init>(BigInteger, BigInteger)"})
  public void testSM2SignatureNewSM2Signature() {
    // Arrange and Act
    SM2Signature actualSm2Signature = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Assert
    BigInteger bigInteger = actualSm2Signature.r;
    assertEquals("57896044618658097711785492504343953926418782139537452191302581570759080747168",
        bigInteger.toString());
    BigInteger bigInteger2 = actualSm2Signature.s;
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
   * Test SM2Signature {@link SM2Signature#SM2Signature(byte[], byte[], byte)}.
   * <p>
   * Method under test: {@link SM2Signature#SM2Signature(byte[], byte[], byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SM2Signature.<init>(byte[], byte[], byte)"})
  public void testSM2SignatureNewSM2Signature2() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SM2Signature actualSm2Signature = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415826", actualSm2Signature.toHex());
    BigInteger bigInteger = actualSm2Signature.r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertEquals(actualSm2Signature.r, actualSm2Signature.s);
    assertEquals('A', actualSm2Signature.v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Test SM2Signature {@link SM2Signature#toBase64()}.
   * <ul>
   *   <li>Then return {@code AH////////////////////9dV25zV6RQHd/pL0ZoGyCgf////////////////////11XbnNXpFAd3+kvRmgbIKA=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#toBase64()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SM2Signature.toBase64()"})
  public void testSM2SignatureToBase64_thenReturnAh9dV25zV6RQHdPL0ZoGyCgf11XbnNXpFAd3KvRmgbIKA() {
    // Arrange, Act and Assert
    assertEquals("AH////////////////////9dV25zV6RQHd/pL0ZoGyCgf////////////////////11XbnNXpFAd3+kvRmgbIKA=",
        (new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toBase64());
  }

  /**
   * Test SM2Signature {@link SM2Signature#toByteArray()}.
   * <ul>
   *   <li>Then return first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#toByteArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2Signature.toByteArray()"})
  public void testSM2SignatureToByteArray_thenReturnFirstElementIsZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualToByteArrayResult = (new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A')).toByteArray();

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
    assertEquals(65, actualToByteArrayResult.length);
    assertEquals('&', actualToByteArrayResult[Double.SIZE]);
    assertEquals('A', actualToByteArrayResult[24]);
    assertEquals('A', actualToByteArrayResult[56]);
    assertEquals('A', actualToByteArrayResult[58]);
    assertEquals('A', actualToByteArrayResult[60]);
    assertEquals('A', actualToByteArrayResult[62]);
    assertEquals('X', actualToByteArrayResult[57]);
    assertEquals('X', actualToByteArrayResult[59]);
    assertEquals('X', actualToByteArrayResult[61]);
    assertEquals('X', actualToByteArrayResult[63]);
  }

  /**
   * Test SM2Signature {@link SM2Signature#toByteArray()}.
   * <ul>
   *   <li>Then return second element is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#toByteArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2Signature.toByteArray()"})
  public void testSM2SignatureToByteArray_thenReturnSecondElementIsMinusOne() {
    // Arrange and Act
    byte[] actualToByteArrayResult = (new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toByteArray();

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
   * Test SM2Signature {@link SM2Signature#toHex()}.
   * <p>
   * Method under test: {@link SM2Signature#toHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SM2Signature.toHex()"})
  public void testSM2SignatureToHex() {
    // Arrange, Act and Assert
    assertEquals(
        "7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07fffffffffffffffffffffffffffffff5d57"
            + "6e7357a4501ddfe92f46681b20a000",
        (new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toHex());
  }

  /**
   * Test SM2Signature {@link SM2Signature#toHex()}.
   * <p>
   * Method under test: {@link SM2Signature#toHex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SM2Signature.toHex()"})
  public void testSM2SignatureToHex2() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        (new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A')).toHex());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   * <p>
   * Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    sm2Signature.v = (byte) 27;

    // Act and Assert
    assertTrue(sm2Signature.validateComponents());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   * <p>
   * Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents2() {
    // Arrange
    SM2Signature sm2Signature = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    sm2Signature.v = (byte) 28;

    // Act and Assert
    assertTrue(sm2Signature.validateComponents());
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <p>
   * Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte() {
    // Arrange, Act and Assert
    assertFalse(SM2Signature.validateComponents(BigInteger.valueOf(-1L), null, (byte) 27));
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SM2Signature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 27));
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_whenA() {
    // Arrange, Act and Assert
    assertFalse(SM2Signature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 'A'));
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)} with {@code BigInteger}, {@code BigInteger}, {@code byte}.
   * <ul>
   *   <li>When twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#validateComponents(BigInteger, BigInteger, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents(BigInteger, BigInteger, byte)"})
  public void testSM2SignatureValidateComponentsWithBigIntegerBigIntegerByte_whenTwentyEight() {
    // Arrange, Act and Assert
    assertTrue(SM2Signature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 28));
  }

  /**
   * Test SM2Signature {@link SM2Signature#validateComponents()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2Signature#validateComponents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2Signature.validateComponents()"})
  public void testSM2SignatureValidateComponents_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).validateComponents());
  }

  /**
   * Test {@link SM2#signatureToKeyBytes(byte[], String)} with {@code messageHash}, {@code signatureBase64}.
   * <p>
   * Method under test: {@link SM2#signatureToKeyBytes(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.signatureToKeyBytes(byte[], String)"})
  public void testSignatureToKeyBytesWithMessageHashSignatureBase64()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SM2.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link SM2#hash(byte[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#hash(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.hash(byte[])"})
  public void testHash_thenThrowIllegalArgumentException() throws UnsupportedEncodingException {
    // Arrange
    ECPoint ecPoint = mock(ECPoint.class);
    when(ecPoint.getYCoord()).thenThrow(new IllegalArgumentException("foo"));
    when(ecPoint.getXCoord()).thenReturn(new Curve25519FieldElement());
    ECPoint pub = mock(ECPoint.class);
    when(pub.isInfinity()).thenReturn(false);
    when(pub.normalize()).thenReturn(ecPoint);
    when(pub.getCurve()).thenReturn(new SM2P256V1Curve());
    SM2 fromPublicOnlyResult = SM2.fromPublicOnly(pub);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fromPublicOnlyResult.hash("AXAXAXAX".getBytes("UTF-8")));
    verify(pub, atLeast(1)).getCurve();
    verify(ecPoint).getXCoord();
    verify(ecPoint).getYCoord();
    verify(pub).isInfinity();
    verify(pub).normalize();
  }

  /**
   * Test {@link SM2#getPrivateKey()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getPrivateKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getPrivateKey()"})
  public void testGetPrivateKey_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPublicOnly(mock(ECPoint.class)).getPrivateKey());
  }

  /**
   * Test {@link SM2#getPubKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getPubKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getPubKey()"})
  public void testGetPubKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPubKey = SM2.fromPublicOnly(pub).getPubKey();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPubKey);
  }

  /**
   * Test {@link SM2#getPubKey()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getPubKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getPubKey()"})
  public void testGetPubKey_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getPubKey());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#getAddress()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getAddress()"})
  public void testGetAddress_thenReturnArrayOfByteWithAAndNineteen() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualAddress = SM2.fromPublicOnly(pub).getAddress();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertArrayEquals(new byte[]{'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31, -24,
        -124, '5', -121, -26}, actualAddress);
  }

  /**
   * Test {@link SM2#getAddress()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getAddress()"})
  public void testGetAddress_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getAddress());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#signatureToAddress(byte[], String)} with {@code messageHash}, {@code signatureBase64}.
   * <ul>
   *   <li>Then throw {@link SignatureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#signatureToAddress(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.signatureToAddress(byte[], String)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64_thenThrowSignatureException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SM2.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link SM2#signatureToKey(byte[], String)} with {@code messageHash}, {@code signatureBase64}.
   * <ul>
   *   <li>Then throw {@link SignatureException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#signatureToKey(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.signatureToKey(byte[], String)"})
  public void testSignatureToKeyWithMessageHashSignatureBase64_thenThrowSignatureException()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SM2.signatureToKey("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Test {@link SM2#signMessage(byte[], String)}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then throw {@link ECKey.MissingPrivateKeyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#signMessage(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2.signMessage(byte[], String)"})
  public void testSignMessage_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException()
      throws UnsupportedEncodingException {
    // Arrange
    SM2 fromPublicOnlyResult = SM2.fromPublicOnly(mock(ECPoint.class));

    // Act and Assert
    assertThrows(MissingPrivateKeyException.class,
        () -> fromPublicOnlyResult.signMessage("AXAXAXAX".getBytes("UTF-8"), "User ID"));
  }

  /**
   * Test {@link SM2#signMsg(byte[], String)}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then throw {@link ECKey.MissingPrivateKeyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#signMsg(byte[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signature SM2.signMsg(byte[], String)"})
  public void testSignMsg_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException()
      throws UnsupportedEncodingException {
    // Arrange
    SM2 fromPublicOnlyResult = SM2.fromPublicOnly(mock(ECPoint.class));

    // Act and Assert
    assertThrows(MissingPrivateKeyException.class,
        () -> fromPublicOnlyResult.signMsg("AXAXAXAX".getBytes("UTF-8"), "User ID"));
  }

  /**
   * Test {@link SM2#getSM2SignerForHash()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getSM2SignerForHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2Signer SM2.getSM2SignerForHash()"})
  public void testGetSM2SignerForHash_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint ecPoint = mock(ECPoint.class);
    when(ecPoint.getYCoord()).thenThrow(new IllegalArgumentException("foo"));
    when(ecPoint.getXCoord()).thenReturn(new Curve25519FieldElement());
    ECPoint pub = mock(ECPoint.class);
    when(pub.isInfinity()).thenReturn(false);
    when(pub.normalize()).thenReturn(ecPoint);
    when(pub.getCurve()).thenReturn(new SM2P256V1Curve());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getSM2SignerForHash());
    verify(pub, atLeast(1)).getCurve();
    verify(ecPoint).getXCoord();
    verify(ecPoint).getYCoord();
    verify(pub).isInfinity();
    verify(pub).normalize();
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2Signature sig = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

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
   * <ul>
   *   <li>Then return fifteenth element is minus one hundred two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFifteenthElementIsMinusOneHundredTwo()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2Signature sig = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(0, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -116, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -118, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) -22, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -22, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -24, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -30, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -40, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -4, actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -64, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -69, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -92, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -9, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) 15, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) 17, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) 19, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) 23, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) 26, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('#', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('%', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('\'', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals(')', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('+', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('1', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('3', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('<', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('F', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals('H', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('J', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals('U', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('\f', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('o', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('z', actualRecoverPubBytesFromSignatureResult[15]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return fifth element is minus one hundred four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFifthElementIsMinusOneHundredFour()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -104, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -107, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -115, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -11, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -17, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -25, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -26, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) -29, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals((byte) -32, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -41, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -44, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -54, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -60, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -63, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -64, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -83, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -87, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) 0, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) 18, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) 25, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('&', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('+', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('+', actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals('.', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('2', actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('=', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('=', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals('A', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('F', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('N', actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals('N', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('O', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('P', actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals('R', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('S', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('W', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('i', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('x', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('z', actualRecoverPubBytesFromSignatureResult[7]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return forty-fifth element is minus one hundred two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFortyFifthElementIsMinusOneHundredTwo()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -110, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -120, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -13, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -28, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -34, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -35, actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals((byte) -37, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -3, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals((byte) -41, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) -47, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -52, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -54, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -57, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -66, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -68, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -69, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals((byte) -69, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) -81, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -95, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -99, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) 3, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('$', actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals('\'', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('*', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('/', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('1', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('7', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('9', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('X', actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals('"', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('b', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('c', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('d', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('i', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('q', actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals('q', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('~', actualRecoverPubBytesFromSignatureResult[21]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return forty-first element is minus one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnFortyFirstElementIsMinusOneHundred()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature("AXAXAXAX".getBytes("UTF-8"), new byte[]{}, (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -100, actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals((byte) -101, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -121, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -1, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) -30, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -34, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -36, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) -38, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -40, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -43, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) -47, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -64, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -65, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -6, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -85, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -90, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -91, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals((byte) 0, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) 11, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) 16, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) 24, actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('\'', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals(')', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('1', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('I', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('N', actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals('O', actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals('S', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('T', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('V', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('\r', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals(']', actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals('_', actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals('a', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('c', actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals('h', actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals('l', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('o', actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('s', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('w', actualRecoverPubBytesFromSignatureResult[7]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return sixteenth element is minus one hundred two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnSixteenthElementIsMinusOneHundredTwo() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1,
        new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals((byte) -102, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -109, actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals((byte) -10, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -117, actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals((byte) -119, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -127, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -13, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -14, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -38, actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals((byte) -39, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -48, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -58, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) -59, actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals((byte) -67, actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals((byte) -70, actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals((byte) -70, actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals((byte) -73, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -79, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -82, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) -85, actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals((byte) -8, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -94, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -98, actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals((byte) 15, actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals((byte) 1, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(':', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals('>', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals('E', actualRecoverPubBytesFromSignatureResult[40]);
    assertEquals('G', actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals('L', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('M', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('O', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('R', actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals('X', actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals('\r', actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals('b', actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals('k', actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('v', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('w', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals('w', actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals('{', actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals('|', actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals('}', actualRecoverPubBytesFromSignatureResult[5]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return twenty-third element is minus one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_thenReturnTwentyThirdElementIsMinusOneHundred()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1, sig,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals((byte) -100, actualRecoverPubBytesFromSignatureResult[22]);
    assertEquals((byte) -112, actualRecoverPubBytesFromSignatureResult[8]);
    assertEquals((byte) -124, actualRecoverPubBytesFromSignatureResult[23]);
    assertEquals((byte) -124, actualRecoverPubBytesFromSignatureResult[3]);
    assertEquals((byte) -125, actualRecoverPubBytesFromSignatureResult[62]);
    assertEquals((byte) -15, actualRecoverPubBytesFromSignatureResult[46]);
    assertEquals((byte) -19, actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals((byte) -23, actualRecoverPubBytesFromSignatureResult[19]);
    assertEquals((byte) -26, actualRecoverPubBytesFromSignatureResult[Double.SIZE]);
    assertEquals((byte) -27, actualRecoverPubBytesFromSignatureResult[15]);
    assertEquals((byte) -29, actualRecoverPubBytesFromSignatureResult[61]);
    assertEquals((byte) -2, actualRecoverPubBytesFromSignatureResult[14]);
    assertEquals((byte) -39, actualRecoverPubBytesFromSignatureResult[53]);
    assertEquals((byte) -3, actualRecoverPubBytesFromSignatureResult[20]);
    assertEquals((byte) -41, actualRecoverPubBytesFromSignatureResult[47]);
    assertEquals((byte) -65, actualRecoverPubBytesFromSignatureResult[11]);
    assertEquals((byte) -73, actualRecoverPubBytesFromSignatureResult[43]);
    assertEquals((byte) -77, actualRecoverPubBytesFromSignatureResult[21]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[10]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[44]);
    assertEquals((byte) -7, actualRecoverPubBytesFromSignatureResult[57]);
    assertEquals((byte) -84, actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals((byte) -84, actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals((byte) -96, actualRecoverPubBytesFromSignatureResult[4]);
    assertEquals((byte) -96, actualRecoverPubBytesFromSignatureResult[54]);
    assertEquals((byte) -96, actualRecoverPubBytesFromSignatureResult[59]);
    assertEquals((byte) 20, actualRecoverPubBytesFromSignatureResult[24]);
    assertEquals((byte) 26, actualRecoverPubBytesFromSignatureResult[58]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[17]);
    assertEquals((byte) 29, actualRecoverPubBytesFromSignatureResult[56]);
    assertEquals((byte) 30, actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals((byte) 30, actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals(Byte.MIN_VALUE, actualRecoverPubBytesFromSignatureResult[42]);
    assertEquals(' ', actualRecoverPubBytesFromSignatureResult[49]);
    assertEquals('@', actualRecoverPubBytesFromSignatureResult[45]);
    assertEquals('A', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('J', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals('V', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals('\f', actualRecoverPubBytesFromSignatureResult[63]);
    assertEquals('`', actualRecoverPubBytesFromSignatureResult[12]);
    assertEquals('b', actualRecoverPubBytesFromSignatureResult[1]);
    assertEquals('j', actualRecoverPubBytesFromSignatureResult[52]);
    assertEquals('l', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('l', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('q', actualRecoverPubBytesFromSignatureResult[9]);
    assertEquals('r', actualRecoverPubBytesFromSignatureResult[50]);
    assertEquals('t', actualRecoverPubBytesFromSignatureResult[51]);
    assertEquals('u', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('y', actualRecoverPubBytesFromSignatureResult[40]);
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.recoverPubBytesFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.recoverPubBytesFromSignature(1,
        new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverPubBytesFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverPubBytesFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverPubBytesFromSignature_whenTwo_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(SM2.recoverPubBytesFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#verify(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#verify(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.verify(byte[], byte[])"})
  public void testVerifyWithByteByte_thenThrowIllegalArgumentException() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));
    SM2 fromPublicOnlyResult = SM2.fromPublicOnly(pub);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fromPublicOnlyResult.verify(data, "AXAXAXAX".getBytes("UTF-8")));
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#verify(byte[], SM2Signature)} with {@code byte[]}, {@code SM2Signature}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#verify(byte[], SM2Signature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.verify(byte[], SM2Signature)"})
  public void testVerifyWithByteSM2Signature_thenThrowIllegalArgumentException() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));
    SM2 fromPublicOnlyResult = SM2.fromPublicOnly(pub);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fromPublicOnlyResult.verify("AXAXAXAX".getBytes("UTF-8"), (SM2Signature) null));
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with four.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[]{4}));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[]{3}));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When array of {@code byte} with two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenArrayOfByteWithTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[]{2}));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical(byte[])"})
  public void testIsPubKeyCanonicalWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte} with four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithFourAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn(new byte[]{4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte} with three and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithThreeAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return array of {@code byte} with two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnArrayOfByteWithTwoAndX() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   * <ul>
   *   <li>Given {@link ECPoint} {@link ECPoint#getEncoded(boolean)} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_givenECPointGetEncodedReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsPubKeyCanonicalResult = SM2.fromPublicOnly(pub).isPubKeyCanonical();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertFalse(actualIsPubKeyCanonicalResult);
  }

  /**
   * Test {@link SM2#isPubKeyCanonical()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyCanonical()"})
  public void testIsPubKeyCanonical_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).isPubKeyCanonical());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', -112, 'X', 'Q', '!', -86, ' ', -96, 'E', 3, 7, '\t', -114, 20, -48,
        Byte.MIN_VALUE, -91, -77, 'W', 'W', 6}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code &}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndAmpersand()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature("AXAXAXAX".getBytes("UTF-8"), new byte[]{}, (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '&', -73, -57, 't', 'z', 15, -58, -65, -123, -108, -86, -76, -30, -111, -10, '[',
        -98, 'h', -24, -121}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code @}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndCommercialAt()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '@', 'M', -68, -8, -95, -61, '\f', -122, 15, -108, -96, -109, '?', 'K', 19, 'p',
        '!', 2, -63, 'U'}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code h}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndH() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'h', -111, 7, -66, '(', -111, '}', 3, -80, 'X', -99, -47, 'K', 23, '9', 'x', '`',
        -107, '>', '>'}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus seventy-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusSeventyOne()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2Signature sig = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', -71, '9', '^', -19, -104, 29, 4, 'Q', -41, -117, -19, -49, '0', -48, '8', '_',
        -34, 30, -15, '9'}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and minus seventy-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndMinusSeventyThree() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', -73, -122, -34, -72, 'e', -10, -68, -94, 18, '{', -32, 'D', '<', 'o', -79, -95, -112, -52, -104,
            -117},
        SM2.recoverAddressFromSignature(1, new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code z}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_thenReturnArrayOfByteWithAAndZ() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2Signature sig = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'z', -35, ',', -33, 'q', '0', 29, Byte.MIN_VALUE, -14, 5, 'u', -61, '.', -127,
        -96, 'Z', '~', 4, '\t', -2}, SM2.recoverAddressFromSignature(0, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.recoverAddressFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.recoverAddressFromSignature(1,
        new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverAddressFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.recoverAddressFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverAddressFromSignature_whenTwo_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(SM2.recoverAddressFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04624a84a06c41569071f9bf60acfee51e1dace9fdb39c8414f90339a3050aa73b1ae5ff8d42aff579ed80b7f940f1d7"
        + "752072746ad9a06c1df91aa01ee3830ce6", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', -112, 'X', 'Q', '!', -86, ' ', -96, 'E', 3, 7, '\t', -114, 20, -48,
        Byte.MIN_VALUE, -91, -77, 'W', 'W', 6}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{'b', 'J', -124, -96, 'l', 'A', 'V', -112, 'q', -7, -65, '`', -84, -2, -27, 30, 29, -84,
        -23, -3, -77, -100, -124, 20, -7, 3, '9', -93, 5, '\n', -89, ';', 26, -27, -1, -115, 'B', -81, -11, 'y', -19,
        Byte.MIN_VALUE, -73, -7, '@', -15, -41, 'u', ' ', 'r', 't', 'j', -39, -96, 'l', 29, -7, 26, -96, 30, -29, -125,
        '\f', -26}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code &}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndAmpersand()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature("AXAXAXAX".getBytes("UTF-8"), new byte[]{}, (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04da316c5d3b56779a72a54e0d294fd1535fffd868a610bfffcf8b4e16abd2eeebb392f601bef1599c8749d5d5e20bab"
        + "215418d5616f9b9e3f63dc0027dec073fa", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', '&', -73, -57, 't', 'z', 15, -58, -65, -123, -108, -86, -76, -30, -111, -10, '[',
        -98, 'h', -24, -121}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(
        new byte[]{-38, '1', 'l', ']', ';', 'V', 'w', -102, 'r', -91, 'N', '\r', ')', 'O', -47, 'S', '_', -1, -40, 'h',
            -90, 16, -65, -1, -49, -117, 'N', 22, -85, -46, -18, -21, -77, -110, -10, 1, -66, -15, 'Y', -100, -121, 'I',
            -43, -43, -30, 11, -85, '!', 'T', 24, -43, 'a', 'o', -101, -98, '?', 'c', -36, 0, '\'', -34, -64, 's', -6},
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code @}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndCommercialAt()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:044ec452982e747a00e069c02bd7c12b1953e7413d5d5778ef861b0af108970c6b8a8fba9772d0b6128d3726475f325a"
        + "d4db04a9e6f5ad954e744fca463d50e33f", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', '@', 'M', -68, -8, -95, -61, '\f', -122, 15, -108, -96, -109, '?', 'K', 19, 'p',
        '!', 2, -63, 'U'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{'N', -60, 'R', -104, '.', 't', 'z', 0, -32, 'i', -64, '+', -41, -63, '+', 25, 'S', -25,
        'A', '=', ']', 'W', 'x', -17, -122, 27, '\n', -15, '\b', -105, '\f', 'k', -118, -113, -70, -105, 'r', -48, -74,
        18, -115, '7', '&', 'G', '_', '2', 'Z', -44, -37, 4, -87, -26, -11, -83, -107, 'N', 't', 'O', -54, 'F', '=',
        'P', -29, '?'}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code h}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndH() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:047149ffca69201dcc2721bcddbe9da1220320dbe47e3958d1eafb89b6753f8ea7000a2240dce8e33721bb929a2fbb88"
        + "c72afde9639de9d7246264f37131af04de", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', 'h', -111, 7, -66, '(', -111, '}', 3, -80, 'X', -99, -47, 'K', 23, '9', 'x', '`',
        -107, '>', '>'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{'q', 'I', -1, -54, 'i', ' ', 29, -52, '\'', '!', -68, -35, -66, -99, -95, '"', 3, ' ',
        -37, -28, '~', '9', 'X', -47, -22, -5, -119, -74, 'u', '?', -114, -89, 0, '\n', '"', '@', -36, -24, -29, '7',
        '!', -69, -110, -102, '/', -69, -120, -57, '*', -3, -23, 'c', -99, -23, -41, '$', 'b', 'd', -13, 'q', '1', -81,
        4, -34}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus seventy-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusSeventyOne()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2Signature sig = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04cbcf5e8822a171b6897f54cb0c4ec29d5130678020370e34118de7c719aa3fe41822c88f2761c6e3d3384c4110371b"
        + "452ed555141151fa3f23a27a98abcb749d", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', -71, '9', '^', -19, -104, 29, 4, 'Q', -41, -117, -19, -49, '0', -48, '8', '_',
        -34, 30, -15, '9'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-53, -49, '^', -120, '"', -95, 'q', -74, -119, Byte.MAX_VALUE, 'T', -53, '\f', 'N',
        -62, -99, 'Q', '0', 'g', Byte.MIN_VALUE, ' ', '7', 14, '4', 17, -115, -25, -57, 25, -86, '?', -28, 24, '"', -56,
        -113, '\'', 'a', -58, -29, -45, '8', 'L', 'A', 16, '7', 27, 'E', '.', -43, 'U', 20, 17, 'Q', -6, '?', '#', -94,
        'z', -104, -85, -53, 't', -99}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and minus seventy-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndMinusSeventyThree() {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1,
        new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04ab8b47b17d93c589ba6bf83e4df39a76c64c52d9b73bb10db8a2475b8680f8324050ecc146ea45454f7b6258ba1d81"
        + "bdda3a0f9e01d059aea27c3f7777f672f2", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', -73, -122, -34, -72, 'e', -10, -68, -94, 18, '{', -32, 'D', '<', 'o', -79, -95,
        -112, -52, -104, -117}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-85, -117, 'G', -79, '}', -109, -59, -119, -70, 'k', -8, '>', 'M', -13, -102, 'v', -58,
        'L', 'R', -39, -73, ';', -79, '\r', -72, -94, 'G', '[', -122, Byte.MIN_VALUE, -8, '2', '@', 'P', -20, -63, 'F',
        -22, 'E', 'E', 'O', '{', 'b', 'X', -70, 29, -127, -67, -38, ':', 15, -98, 1, -48, 'Y', -82, -94, '|', '?', 'w',
        'w', -10, 'r', -14}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>Then return Address is array of {@code byte} with {@code A} and {@code z}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_thenReturnAddressIsArrayOfByteWithAAndZ() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2Signature sig = new SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(0, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualRecoverFromSignatureResult.getPubKeyPoint() instanceof Fp);
    assertEquals("pub:04eaa48cf7fc0c5a4746c08a13179a7a5a116f2010ead837e908d208dab236604755078c644fe887ed0a31bbe8c73355"
        + "27101ae2482b4d5929574a25edfe230f3c", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertEquals(65, actualRecoverFromSignatureResult.getPubKey().length);
    assertArrayEquals(new byte[]{'A', 'z', -35, ',', -33, 'q', '0', 29, Byte.MIN_VALUE, -14, 5, 'u', -61, '.', -127,
        -96, 'Z', '~', 4, '\t', -2}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-22, -92, -116, -9, -4, '\f', 'Z', 'G', 'F', -64, -118, 19, 23, -102, 'z', 'Z', 17,
        'o', ' ', 16, -22, -40, '7', -23, '\b', -46, '\b', -38, -78, '6', '`', 'G', 'U', 7, -116, 'd', 'O', -24, -121,
        -19, '\n', '1', -69, -24, -57, '3', 'U', '\'', 16, 26, -30, 'H', '+', 'M', 'Y', ')', 'W', 'J', '%', -19, -2,
        '#', 15, '<'}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenMinusOne_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.recoverFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.recoverFromSignature(1, new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Test {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#recoverFromSignature(int, SM2Signature, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SM2 SM2.recoverFromSignature(int, SM2Signature, byte[])"})
  public void testRecoverFromSignature_whenTwo_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    SM2Signature sig = new SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(SM2.recoverFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SM2#isPubKeyOnly()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#isPubKeyOnly()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.isPubKeyOnly()"})
  public void testIsPubKeyOnly_givenFromPublicOnlyECPoint_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SM2.fromPublicOnly(mock(ECPoint.class)).isPubKeyOnly());
  }

  /**
   * Test {@link SM2#hasPrivKey()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#hasPrivKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SM2.hasPrivKey()"})
  public void testHasPrivKey_givenFromPublicOnlyECPoint_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SM2.fromPublicOnly(mock(ECPoint.class)).hasPrivKey());
  }

  /**
   * Test {@link SM2#getNodeId()}.
   * <ul>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getNodeId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getNodeId()"})
  public void testGetNodeId_thenReturnXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualNodeId = SM2.fromPublicOnly(pub).getNodeId();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualNodeId);
  }

  /**
   * Test {@link SM2#getNodeId()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getNodeId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getNodeId()"})
  public void testGetNodeId_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getNodeId());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#getPrivKey()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then throw {@link ECKey.MissingPrivateKeyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getPrivKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger SM2.getPrivKey()"})
  public void testGetPrivKey_givenFromPublicOnlyECPoint_thenThrowMissingPrivateKeyException() {
    // Arrange, Act and Assert
    assertThrows(MissingPrivateKeyException.class, () -> SM2.fromPublicOnly(mock(ECPoint.class)).getPrivKey());
  }

  /**
   * Test {@link SM2#toStringWithPrivate()}.
   * <ul>
   *   <li>Then return {@code pub:4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#toStringWithPrivate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SM2.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenReturnPub4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringWithPrivateResult = SM2.fromPublicOnly(pub).toStringWithPrivate();

    // Assert
    verify(pub).getEncoded(eq(false));
    assertEquals("pub:4158415841584158", actualToStringWithPrivateResult);
  }

  /**
   * Test {@link SM2#toStringWithPrivate()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#toStringWithPrivate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SM2.toStringWithPrivate()"})
  public void testToStringWithPrivate_thenThrowIllegalArgumentException() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("pub:"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).toStringWithPrivate());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Test {@link SM2#getPrivKeyBytes()}.
   * <ul>
   *   <li>Given fromPublicOnly {@link ECPoint}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SM2#getPrivKeyBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SM2.getPrivKeyBytes()"})
  public void testGetPrivKeyBytes_givenFromPublicOnlyECPoint_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPublicOnly(mock(ECPoint.class)).getPrivKeyBytes());
  }
}
