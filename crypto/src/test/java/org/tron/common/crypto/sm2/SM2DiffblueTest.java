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
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafL2RMultiplier;
import org.bouncycastle.math.ec.custom.djb.Curve25519FieldElement;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve;
import org.junit.Test;
import org.tron.common.crypto.ECKey;

public class SM2DiffblueTest {
  /**
   * Method under test: {@link SM2#compressPoint(ECPoint)}
   */
  @Test
  public void testCompressPoint() {
    // Arrange
    ECPoint uncompressed = mock(ECPoint.class);
    when(uncompressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.compressPoint(uncompressed));
    verify(uncompressed).getEncoded(eq(true));
  }

  /**
   * Method under test: {@link SM2#decompressPoint(ECPoint)}
   */
  @Test
  public void testDecompressPoint() {
    // Arrange
    ECPoint compressed = mock(ECPoint.class);
    when(compressed.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.decompressPoint(compressed));
    verify(compressed).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#fromPrivate(byte[])}
   */
  @Test
  public void testFromPrivate() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPrivate((byte[]) null));
  }

  /**
   * Method under test:
   * {@link SM2#fromPrivateAndPrecalculatedPublic(BigInteger, ECPoint)}
   */
  @Test
  public void testFromPrivateAndPrecalculatedPublic() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPrivateAndPrecalculatedPublic((BigInteger) null, null));
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPrivateAndPrecalculatedPublic((byte[]) null, null));
    assertThrows(IllegalArgumentException.class,
        () -> SM2.fromPrivateAndPrecalculatedPublic(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Method under test: {@link SM2#fromPublicOnly(ECPoint)}
   */
  @Test
  public void testFromPublicOnly() {
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
   * Method under test: {@link SM2#fromPublicOnly(ECPoint)}
   */
  @Test
  public void testFromPublicOnly2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly((ECPoint) null));
  }

  /**
   * Method under test: {@link SM2#fromPublicOnly(byte[])}
   */
  @Test
  public void testFromPublicOnly3() {
    // Arrange and Act
    SM2 actualFromPublicOnlyResult = SM2.fromPublicOnly(new byte[]{0});

    // Assert
    ECPoint pubKeyPoint = actualFromPublicOnlyResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement a = curve.getA();
    assertTrue(a instanceof ECFieldElement.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECPoint detachedPoint = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = a.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult.toString());
    BigInteger q = ((ECCurve.Fp) curve).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult2 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult2.toString());
    assertEquals("Fp", a.getFieldName());
    assertEquals("Fp", b.getFieldName());
    assertEquals("pub:00", actualFromPublicOnlyResult.toStringWithPrivate());
    assertNull(actualFromPublicOnlyResult.getPrivKeyBytes());
    assertNull(actualFromPublicOnlyResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(pubKeyPoint.getAffineXCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(pubKeyPoint.getAffineYCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(pubKeyPoint.getRawXCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(pubKeyPoint.getRawYCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(pubKeyPoint.getXCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(pubKeyPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    assertEquals(0, q.getLowestSetBit());
    assertEquals(0, toBigIntegerResult2.getLowestSetBit());
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    assertEquals(0, zCoords.length);
    assertEquals(0, actualFromPublicOnlyResult.getNodeId().length);
    assertEquals(1, q.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, a.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(4, curve.getCoordinateSystem());
    assertFalse(a.isZero());
    assertFalse(b.isZero());
    assertFalse(actualFromPublicOnlyResult.hasPrivKey());
    assertFalse(actualFromPublicOnlyResult.isPubKeyCanonical());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(pubKeyPoint.isInfinity());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualFromPublicOnlyResult.isPubKeyOnly());
    assertEquals(detachedPoint2, detachedPoint2);
    assertSame(q, ((ECFieldElement.Fp) a).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(zCoords, detachedPoint.getZCoords());
    assertSame(pubKeyPoint, curve.getInfinity());
    assertArrayEquals(new byte[]{0}, actualFromPublicOnlyResult.getPubKey());
    assertArrayEquals(
        new byte[]{'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123, -92, 'p'},
        actualFromPublicOnlyResult.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, a.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  public void testPublicKeyFromPrivate() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{2, '^', 't', -93, 14, -45, -98, -101, 21, -7, -127, -31, 29, '9', -4, '(', '}', '%', -96, -28, -62,
            'A', 'r', -126, '\f', '"', 27, -84, 0, -63, -62, 'q', '7'},
        SM2.publicKeyFromPrivate(ECKey.HALF_CURVE_ORDER, true));
    assertArrayEquals(
        new byte[]{2, '2', -60, -82, ',', 31, 25, -127, 25, '_', -103, 4, 'F', 'j', '9', -55, -108, -113, -29, 11, -65,
            -14, 'f', 11, -31, 'q', 'Z', 'E', -119, '3', 'L', 't', -57},
        SM2.publicKeyFromPrivate(BigInteger.valueOf(1L), true));
    assertArrayEquals(new byte[]{0}, SM2.publicKeyFromPrivate(BigInteger.valueOf(0L), true));
    assertArrayEquals(
        new byte[]{3, '2', -60, -82, ',', 31, 25, -127, 25, '_', -103, 4, 'F', 'j', '9', -55, -108, -113, -29, 11, -65,
            -14, 'f', 11, -31, 'q', 'Z', 'E', -119, '3', 'L', 't', -57},
        SM2.publicKeyFromPrivate(BigInteger.valueOf(-1L), true));
  }

  /**
   * Method under test: {@link SM2#publicKeyFromPrivate(BigInteger, boolean)}
   */
  @Test
  public void testPublicKeyFromPrivate2() {
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
   * Method under test: {@link SM2#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  public void testPubBytesWithoutFormat() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#pubBytesWithoutFormat(ECPoint)}
   */
  @Test
  public void testPubBytesWithoutFormat2() {
    // Arrange
    ECPoint pubPoint = mock(ECPoint.class);
    when(pubPoint.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.pubBytesWithoutFormat(pubPoint));
    verify(pubPoint).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#fromNodeId(byte[])}
   */
  @Test
  public void testFromNodeId() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromNodeId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link SM2.SM2Signature#decodeFromDER(byte[])}
   */
  @Test
  public void testSM2SignatureDecodeFromDER() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> SM2.SM2Signature.decodeFromDER("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{27, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{28, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class, () -> SM2.SM2Signature.decodeFromDER(" XAXAXAX".getBytes("UTF-8")));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class, () -> SM2.SM2Signature.decodeFromDER(new byte[]{}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{' ', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{Byte.MAX_VALUE, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 0, 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, -1, 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, ' ', 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', 0, 'X', 'A', 'X'}));
    assertThrows(RuntimeException.class,
        () -> SM2.SM2Signature.decodeFromDER(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', Byte.MIN_VALUE, 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link SM2.SM2Signature#fromComponents(byte[], byte[], byte)}
   */
  @Test
  public void testSM2SignatureFromComponents() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SM2.SM2Signature actualFromComponentsResult = SM2.SM2Signature.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"),
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
   * Method under test:
   * {@link SM2.SM2Signature#SM2Signature(BigInteger, BigInteger)}
   */
  @Test
  public void testSM2SignatureNewSM2Signature() {
    // Arrange and Act
    SM2.SM2Signature actualSm2Signature = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

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
   * Method under test:
   * {@link SM2.SM2Signature#SM2Signature(byte[], byte[], byte)}
   */
  @Test
  public void testSM2SignatureNewSM2Signature2() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SM2.SM2Signature actualSm2Signature = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
   * Method under test: {@link SM2.SM2Signature#toBase64()}
   */
  @Test
  public void testSM2SignatureToBase64() {
    // Arrange, Act and Assert
    assertEquals("AH////////////////////9dV25zV6RQHd/pL0ZoGyCgf////////////////////11XbnNXpFAd3+kvRmgbIKA=",
        (new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toBase64());
  }

  /**
   * Method under test: {@link SM2.SM2Signature#toByteArray()}
   */
  @Test
  public void testSM2SignatureToByteArray() {
    // Arrange and Act
    byte[] actualToByteArrayResult = (new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER))
        .toByteArray();

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
   * Method under test: {@link SM2.SM2Signature#toByteArray()}
   */
  @Test
  public void testSM2SignatureToByteArray2() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualToByteArrayResult = (new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A')).toByteArray();

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
   * Method under test: {@link SM2.SM2Signature#toHex()}
   */
  @Test
  public void testSM2SignatureToHex() {
    // Arrange, Act and Assert
    assertEquals(
        "7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a07fffffffffffffffffffffffffffffff5d57"
            + "6e7357a4501ddfe92f46681b20a000",
        (new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).toHex());
  }

  /**
   * Method under test: {@link SM2.SM2Signature#toHex()}
   */
  @Test
  public void testSM2SignatureToHex2() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        (new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A')).toHex());
  }

  /**
   * Method under test: {@link SM2.SM2Signature#validateComponents()}
   */
  @Test
  public void testSM2SignatureValidateComponents() {
    // Arrange, Act and Assert
    assertFalse((new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER)).validateComponents());
    assertFalse(SM2.SM2Signature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 'A'));
    assertTrue(SM2.SM2Signature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 27));
    assertTrue(SM2.SM2Signature.validateComponents(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER, (byte) 28));
    assertFalse(SM2.SM2Signature.validateComponents(BigInteger.valueOf(-1L), null, (byte) 27));
  }

  /**
   * Method under test: {@link SM2.SM2Signature#validateComponents()}
   */
  @Test
  public void testSM2SignatureValidateComponents2() {
    // Arrange
    SM2.SM2Signature sm2Signature = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    sm2Signature.v = (byte) 27;

    // Act and Assert
    assertTrue(sm2Signature.validateComponents());
  }

  /**
   * Method under test: {@link SM2.SM2Signature#validateComponents()}
   */
  @Test
  public void testSM2SignatureValidateComponents3() {
    // Arrange
    SM2.SM2Signature sm2Signature = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);
    sm2Signature.v = (byte) 28;

    // Act and Assert
    assertTrue(sm2Signature.validateComponents());
  }

  /**
   * Method under test: {@link SM2#signatureToKeyBytes(byte[], String)}
   */
  @Test
  public void testSignatureToKeyBytes() throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SM2.signatureToKeyBytes("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Method under test: {@link SM2#hash(byte[])}
   */
  @Test
  public void testHash() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#getPrivateKey()}
   */
  @Test
  public void testGetPrivateKey() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPublicOnly(mock(ECPoint.class)).getPrivateKey());
  }

  /**
   * Method under test: {@link SM2#getPubKey()}
   */
  @Test
  public void testGetPubKey() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#getPubKey()}
   */
  @Test
  public void testGetPubKey2() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getPubKey());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#getAddress()}
   */
  @Test
  public void testGetAddress() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#getAddress()}
   */
  @Test
  public void testGetAddress2() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getAddress());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#signatureToAddress(byte[], String)}
   */
  @Test
  public void testSignatureToAddress() throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SM2.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Method under test: {@link SM2#signatureToKey(byte[], String)}
   */
  @Test
  public void testSignatureToKey() throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SM2.signatureToKey("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64"));
  }

  /**
   * Method under test: {@link SM2#getSM2SignerForHash()}
   */
  @Test
  public void testGetSM2SignerForHash() {
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
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2.SM2Signature sig = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
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
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature2() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(SM2.recoverPubBytesFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature3() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.recoverPubBytesFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature4() {
    // Arrange and Act
    byte[] actualRecoverPubBytesFromSignatureResult = SM2.recoverPubBytesFromSignature(1,
        new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
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
    assertEquals('Y', actualRecoverPubBytesFromSignatureResult[55]);
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
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.recoverPubBytesFromSignature(1,
        new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature6() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2.SM2Signature sig = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
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
    assertEquals('Y', actualRecoverPubBytesFromSignatureResult[55]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[7]);
    assertEquals('Z', actualRecoverPubBytesFromSignatureResult[Short.SIZE]);
    assertEquals('\f', actualRecoverPubBytesFromSignatureResult[6]);
    assertEquals('\n', actualRecoverPubBytesFromSignatureResult[41]);
    assertEquals('o', actualRecoverPubBytesFromSignatureResult[18]);
    assertEquals('z', actualRecoverPubBytesFromSignatureResult[15]);
  }

  /**
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature7() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
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
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature8() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
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
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature9() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
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
   * Method under test:
   * {@link SM2#recoverPubBytesFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverPubBytesFromSignature10() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature("AXAXAXAX".getBytes("UTF-8"), new byte[]{}, (byte) 'A');

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
    assertEquals((byte) 4, actualRecoverPubBytesFromSignatureResult[0]);
    assertEquals(65, actualRecoverPubBytesFromSignatureResult.length);
    assertEquals('!', actualRecoverPubBytesFromSignatureResult[48]);
    assertEquals('\'', actualRecoverPubBytesFromSignatureResult[60]);
    assertEquals(')', actualRecoverPubBytesFromSignatureResult[13]);
    assertEquals('1', actualRecoverPubBytesFromSignatureResult[2]);
    assertEquals(';', actualRecoverPubBytesFromSignatureResult[5]);
    assertEquals('?', actualRecoverPubBytesFromSignatureResult[56]);
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
   * Method under test: {@link SM2#verify(byte[], SM2.SM2Signature)}
   */
  @Test
  public void testVerify() throws UnsupportedEncodingException {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));
    SM2 fromPublicOnlyResult = SM2.fromPublicOnly(pub);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fromPublicOnlyResult.verify("AXAXAXAX".getBytes("UTF-8"), (SM2.SM2Signature) null));
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#verify(byte[], byte[])}
   */
  @Test
  public void testVerify2() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  public void testIsPubKeyCanonical() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  public void testIsPubKeyCanonical2() {
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
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  public void testIsPubKeyCanonical3() {
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
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  public void testIsPubKeyCanonical4() {
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
   * Method under test: {@link SM2#isPubKeyCanonical()}
   */
  @Test
  public void testIsPubKeyCanonical5() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).isPubKeyCanonical());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  public void testIsPubKeyCanonical6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  public void testIsPubKeyCanonical7() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[]{4}));
  }

  /**
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  public void testIsPubKeyCanonical8() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[]{2}));
  }

  /**
   * Method under test: {@link SM2#isPubKeyCanonical(byte[])}
   */
  @Test
  public void testIsPubKeyCanonical9() {
    // Arrange, Act and Assert
    assertFalse(SM2.isPubKeyCanonical(new byte[]{3}));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2.SM2Signature sig = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', -71, '9', '^', -19, -104, 29, 4, 'Q', -41, -117, -19, -49, '0', -48, '8', '_',
        -34, 30, -15, '9'}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature2() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(SM2.recoverAddressFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature3() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.recoverAddressFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature4() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', -73, -122, -34, -72, 'e', -10, -68, -94, 18, '{', -32, 'D', '<', 'o', -79, -95, -112, -52, -104,
            -117},
        SM2.recoverAddressFromSignature(1, new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
            new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.recoverAddressFromSignature(1,
        new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature6() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2.SM2Signature sig = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'z', -35, ',', -33, 'q', '0', 29, Byte.MIN_VALUE, -14, 5, 'u', -61, '.', -127,
        -96, 'Z', '~', 4, '\t', -2}, SM2.recoverAddressFromSignature(0, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature7() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '@', 'M', -68, -8, -95, -61, '\f', -122, 15, -108, -96, -109, '?', 'K', 19, 'p',
        '!', 2, -63, 'U'}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature8() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', -112, 'X', 'Q', '!', -86, ' ', -96, 'E', 3, 7, '\t', -114, 20, -48,
        Byte.MIN_VALUE, -91, -77, 'W', 'W', 6}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature9() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 'h', -111, 7, -66, '(', -111, '}', 3, -80, 'X', -99, -47, 'K', 23, '9', 'x', '`',
        -107, '>', '>'}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverAddressFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverAddressFromSignature10() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature("AXAXAXAX".getBytes("UTF-8"), new byte[]{}, (byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '&', -73, -57, 't', 'z', 15, -58, -65, -123, -108, -86, -76, -30, -111, -10, '[',
        -98, 'h', -24, -121}, SM2.recoverAddressFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2.SM2Signature sig = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = affineYCoord.toBigInteger();
    assertEquals("10916965374889992367867313499159821723508973592071707844677328250430676497565",
        toBigIntegerResult2.toString());
    BigInteger toBigIntegerResult3 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult3.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult4 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineXCoord.toBigInteger();
    assertEquals("92185898039168579646457644174049822361969566108764130440651427680777319104484",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:04cbcf5e8822a171b6897f54cb0c4ec29d5130678020370e34118de7c719aa3fe41822c88f2761c6e3d3384c4110371b"
        + "452ed555141151fa3f23a27a98abcb749d", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -104, pubKey[60]);
    assertEquals((byte) -119, pubKey[9]);
    assertEquals((byte) -120, pubKey[4]);
    assertEquals((byte) -29, pubKey[40]);
    assertEquals((byte) -43, pubKey[50]);
    assertEquals((byte) -45, pubKey[41]);
    assertEquals((byte) -49, pubKey[2]);
    assertEquals((byte) -53, pubKey[1]);
    assertEquals((byte) -53, pubKey[12]);
    assertEquals((byte) -53, pubKey[62]);
    assertEquals((byte) -62, pubKey[15]);
    assertEquals((byte) -6, pubKey[55]);
    assertEquals((byte) -74, pubKey[8]);
    assertEquals((byte) -85, pubKey[61]);
    assertEquals((byte) -94, pubKey[58]);
    assertEquals((byte) -95, pubKey[6]);
    assertEquals((byte) -99, pubKey[Double.SIZE]);
    assertEquals((byte) -99, pubKey[Short.SIZE]);
    assertEquals(0, toBigIntegerResult4.getLowestSetBit());
    assertEquals(0, toBigIntegerResult2.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, q.signum());
    assertEquals((byte) 14, pubKey[23]);
    assertEquals((byte) 16, pubKey[45]);
    assertEquals((byte) 17, pubKey[53]);
    assertEquals(2, toBigIntegerResult5.getLowestSetBit());
    assertEquals(2, toBigIntegerResult3.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals((byte) 20, pubKey[52]);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals((byte) 27, pubKey[47]);
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals(Byte.MAX_VALUE, pubKey[10]);
    assertEquals(Byte.MIN_VALUE, pubKey[20]);
    assertEquals(' ', pubKey[21]);
    assertEquals('#', pubKey[57]);
    assertEquals('.', pubKey[49]);
    assertEquals('0', pubKey[18]);
    assertEquals('4', pubKey[24]);
    assertEquals('7', pubKey[22]);
    assertEquals('7', pubKey[46]);
    assertEquals('8', pubKey[42]);
    assertEquals('?', pubKey[56]);
    assertEquals('A', pubKey[44]);
    assertEquals('E', pubKey[48]);
    assertEquals('L', pubKey[43]);
    assertEquals('N', pubKey[14]);
    assertEquals('Q', pubKey[17]);
    assertEquals('Q', pubKey[54]);
    assertEquals('T', pubKey[11]);
    assertEquals('U', pubKey[51]);
    assertEquals('"', pubKey[5]);
    assertEquals('\f', pubKey[13]);
    assertEquals('^', pubKey[3]);
    assertEquals('g', pubKey[19]);
    assertEquals('q', pubKey[7]);
    assertEquals('t', pubKey[63]);
    assertEquals('z', pubKey[59]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', -71, '9', '^', -19, -104, 29, 4, 'Q', -41, -117, -19, -49, '0', -48, '8', '_',
        -34, 30, -15, '9'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(
        new byte[]{-53, -49, '^', -120, '"', -95, 'q', -74, -119, Byte.MAX_VALUE, 'T', -53, '\f', 'N', -62, -99, 'Q',
            '0', 'g', Byte.MIN_VALUE, ' ', '7', 14, '4', 17, -115, -25, -57, 25, -86, '?', -28},
        affineXCoord.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{24, '"', -56, -113, '\'', 'a', -58, -29, -45, '8', 'L', 'A', 16, '7', 27, 'E', '.',
        -43, 'U', 20, 17, 'Q', -6, '?', '#', -94, 'z', -104, -85, -53, 't', -99}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{24, '"', -56, -113, '\'', 'a', -58, -29, -45, '8', 'L', 'A', 16, '7', 27, 'E', '.',
        -43, 'U', 20, 17, 'Q', -6, '?', '#', -94, 'z', -104, -85, -53, 't', -99}, affineYCoord.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult4.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult3.toByteArray());
    assertArrayEquals(
        new byte[]{0, -53, -49, '^', -120, '"', -95, 'q', -74, -119, Byte.MAX_VALUE, 'T', -53, '\f', 'N', -62, -99, 'Q',
            '0', 'g', Byte.MIN_VALUE, ' ', '7', 14, '4', 17, -115, -25, -57, 25, -86, '?', -28},
        toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{-53, -49, '^', -120, '"', -95, 'q', -74, -119, Byte.MAX_VALUE, 'T', -53, '\f', 'N',
        -62, -99, 'Q', '0', 'g', Byte.MIN_VALUE, ' ', '7', 14, '4', 17, -115, -25, -57, 25, -86, '?', -28, 24, '"', -56,
        -113, '\'', 'a', -58, -29, -45, '8', 'L', 'A', 16, '7', 27, 'E', '.', -43, 'U', 20, 17, 'Q', -6, '?', '#', -94,
        'z', -104, -85, -53, 't', -99}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature2() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertNull(SM2.recoverFromSignature(2, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature3() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.recoverFromSignature(-1, sig, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature4() {
    // Arrange and Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1,
        new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER),
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult2.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult3 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult3.toString());
    BigInteger toBigIntegerResult4 = affineYCoord.toBigInteger();
    assertEquals("29091004097387102682582984478631774139917336749079075115981022919788047266546",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineXCoord.toBigInteger();
    assertEquals("77591583658868756231722568869622156763039616306593434925270069257115254454322",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:04ab8b47b17d93c589ba6bf83e4df39a76c64c52d9b73bb10db8a2475b8680f8324050ecc146ea45454f7b6258ba1d81"
        + "bdda3a0f9e01d059aea27c3f7777f672f2", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -102, pubKey[15]);
    assertEquals((byte) -109, pubKey[6]);
    assertEquals((byte) -10, pubKey[62]);
    assertEquals((byte) -117, pubKey[2]);
    assertEquals((byte) -119, pubKey[8]);
    assertEquals((byte) -127, pubKey[47]);
    assertEquals((byte) -13, pubKey[14]);
    assertEquals((byte) -14, pubKey[Double.SIZE]);
    assertEquals((byte) -38, pubKey[49]);
    assertEquals((byte) -39, pubKey[20]);
    assertEquals((byte) -48, pubKey[54]);
    assertEquals((byte) -58, pubKey[17]);
    assertEquals((byte) -59, pubKey[7]);
    assertEquals((byte) -67, pubKey[48]);
    assertEquals((byte) -70, pubKey[45]);
    assertEquals((byte) -70, pubKey[9]);
    assertEquals((byte) -73, pubKey[21]);
    assertEquals((byte) -79, pubKey[23]);
    assertEquals((byte) -79, pubKey[4]);
    assertEquals((byte) -82, pubKey[56]);
    assertEquals((byte) -85, pubKey[1]);
    assertEquals((byte) -8, pubKey[11]);
    assertEquals((byte) -94, pubKey[57]);
    assertEquals((byte) -98, pubKey[52]);
    assertEquals(0, toBigIntegerResult3.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals(1, toBigIntegerResult5.getLowestSetBit());
    assertEquals(1, toBigIntegerResult4.getLowestSetBit());
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, q.signum());
    assertEquals((byte) 15, pubKey[51]);
    assertEquals((byte) 1, pubKey[53]);
    assertEquals(2, toBigIntegerResult2.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals((byte) 29, pubKey[46]);
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals(':', pubKey[50]);
    assertEquals(';', pubKey[22]);
    assertEquals('>', pubKey[12]);
    assertEquals('?', pubKey[59]);
    assertEquals('E', pubKey[40]);
    assertEquals('G', pubKey[3]);
    assertEquals('L', pubKey[18]);
    assertEquals('M', pubKey[13]);
    assertEquals('O', pubKey[41]);
    assertEquals('R', pubKey[19]);
    assertEquals('X', pubKey[44]);
    assertEquals('Y', pubKey[55]);
    assertEquals('\r', pubKey[24]);
    assertEquals('b', pubKey[43]);
    assertEquals('k', pubKey[10]);
    assertEquals('r', pubKey[63]);
    assertEquals('v', pubKey[Short.SIZE]);
    assertEquals('w', pubKey[60]);
    assertEquals('w', pubKey[61]);
    assertEquals('{', pubKey[42]);
    assertEquals('|', pubKey[58]);
    assertEquals('}', pubKey[5]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', -73, -122, -34, -72, 'e', -10, -68, -94, 18, '{', -32, 'D', '<', 'o', -79, -95,
        -112, -52, -104, -117}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(new byte[]{-85, -117, 'G', -79, '}', -109, -59, -119, -70, 'k', -8, '>', 'M', -13, -102, 'v', -58,
        'L', 'R', -39, -73, ';', -79, '\r', -72, -94, 'G', '[', -122, Byte.MIN_VALUE, -8, '2'},
        affineXCoord.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult3.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{'@', 'P', -20, -63, 'F', -22, 'E', 'E', 'O', '{', 'b', 'X', -70, 29, -127, -67, -38,
        ':', 15, -98, 1, -48, 'Y', -82, -94, '|', '?', 'w', 'w', -10, 'r', -14}, toBigIntegerResult4.toByteArray());
    assertArrayEquals(new byte[]{'@', 'P', -20, -63, 'F', -22, 'E', 'E', 'O', '{', 'b', 'X', -70, 29, -127, -67, -38,
        ':', 15, -98, 1, -48, 'Y', -82, -94, '|', '?', 'w', 'w', -10, 'r', -14}, affineYCoord.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(
        new byte[]{0, -85, -117, 'G', -79, '}', -109, -59, -119, -70, 'k', -8, '>', 'M', -13, -102, 'v', -58, 'L', 'R',
            -39, -73, ';', -79, '\r', -72, -94, 'G', '[', -122, Byte.MIN_VALUE, -8, '2'},
        toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{-85, -117, 'G', -79, '}', -109, -59, -119, -70, 'k', -8, '>', 'M', -13, -102, 'v', -58,
        'L', 'R', -39, -73, ';', -79, '\r', -72, -94, 'G', '[', -122, Byte.MIN_VALUE, -8, '2', '@', 'P', -20, -63, 'F',
        -22, 'E', 'E', 'O', '{', 'b', 'X', -70, 29, -127, -67, -38, ':', 15, -98, 1, -48, 'Y', -82, -94, '|', '?', 'w',
        'w', -10, 'r', -14}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SM2.recoverFromSignature(1, new SM2.SM2Signature(ECKey.HALF_CURVE_ORDER, ECKey.HALF_CURVE_ORDER), null));
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature6() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");
    SM2.SM2Signature sig = new SM2.SM2Signature(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(0, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = affineXCoord.toBigInteger();
    assertEquals("106131942417247146460529202222873328262823494183705233753186754097975674691655",
        toBigIntegerResult2.toString());
    BigInteger toBigIntegerResult3 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult3.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult4 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineYCoord.toBigInteger();
    assertEquals("38459929007929637826733553840448826500061930447915485616422482613704178470716",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:04eaa48cf7fc0c5a4746c08a13179a7a5a116f2010ead837e908d208dab236604755078c644fe887ed0a31bbe8c73355"
        + "27101ae2482b4d5929574a25edfe230f3c", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -102, pubKey[14]);
    assertEquals((byte) -116, pubKey[3]);
    assertEquals((byte) -118, pubKey[11]);
    assertEquals((byte) -19, pubKey[40]);
    assertEquals((byte) -19, pubKey[60]);
    assertEquals((byte) -22, pubKey[1]);
    assertEquals((byte) -22, pubKey[21]);
    assertEquals((byte) -23, pubKey[24]);
    assertEquals((byte) -24, pubKey[44]);
    assertEquals((byte) -2, pubKey[61]);
    assertEquals((byte) -30, pubKey[51]);
    assertEquals((byte) -40, pubKey[22]);
    assertEquals((byte) -4, pubKey[5]);
    assertEquals((byte) -57, pubKey[45]);
    assertEquals((byte) -64, pubKey[10]);
    assertEquals((byte) -69, pubKey[43]);
    assertEquals((byte) -92, pubKey[2]);
    assertEquals((byte) -9, pubKey[4]);
    assertEquals(0, toBigIntegerResult4.getLowestSetBit());
    assertEquals(0, toBigIntegerResult2.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, q.signum());
    assertEquals((byte) 15, pubKey[63]);
    assertEquals((byte) 16, pubKey[20]);
    assertEquals((byte) 16, pubKey[49]);
    assertEquals((byte) 17, pubKey[17]);
    assertEquals((byte) 19, pubKey[12]);
    assertEquals(2, toBigIntegerResult5.getLowestSetBit());
    assertEquals(2, toBigIntegerResult3.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals((byte) 23, pubKey[13]);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals((byte) 26, pubKey[50]);
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals(' ', pubKey[19]);
    assertEquals('#', pubKey[62]);
    assertEquals('%', pubKey[59]);
    assertEquals('\'', pubKey[48]);
    assertEquals(')', pubKey[56]);
    assertEquals('+', pubKey[53]);
    assertEquals('1', pubKey[42]);
    assertEquals('3', pubKey[46]);
    assertEquals('7', pubKey[23]);
    assertEquals('<', pubKey[Double.SIZE]);
    assertEquals('F', pubKey[9]);
    assertEquals('G', pubKey[8]);
    assertEquals('H', pubKey[52]);
    assertEquals('J', pubKey[58]);
    assertEquals('M', pubKey[54]);
    assertEquals('U', pubKey[47]);
    assertEquals('W', pubKey[57]);
    assertEquals('Y', pubKey[55]);
    assertEquals('Z', pubKey[7]);
    assertEquals('Z', pubKey[Short.SIZE]);
    assertEquals('\f', pubKey[6]);
    assertEquals('\n', pubKey[41]);
    assertEquals('o', pubKey[18]);
    assertEquals('z', pubKey[15]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', 'z', -35, ',', -33, 'q', '0', 29, Byte.MIN_VALUE, -14, 5, 'u', -61, '.', -127,
        -96, 'Z', '~', 4, '\t', -2}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(new byte[]{-22, -92, -116, -9, -4, '\f', 'Z', 'G', 'F', -64, -118, 19, 23, -102, 'z', 'Z', 17,
        'o', ' ', 16, -22, -40, '7', -23, '\b', -46, '\b', -38, -78, '6', '`', 'G'}, affineXCoord.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult4.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{'U', 7, -116, 'd', 'O', -24, -121, -19, '\n', '1', -69, -24, -57, '3', 'U', '\'', 16,
        26, -30, 'H', '+', 'M', 'Y', ')', 'W', 'J', '%', -19, -2, '#', 15, '<'}, toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{'U', 7, -116, 'd', 'O', -24, -121, -19, '\n', '1', -69, -24, -57, '3', 'U', '\'', 16,
        26, -30, 'H', '+', 'M', 'Y', ')', 'W', 'J', '%', -19, -2, '#', 15, '<'}, affineYCoord.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult3.toByteArray());
    assertArrayEquals(new byte[]{0, -22, -92, -116, -9, -4, '\f', 'Z', 'G', 'F', -64, -118, 19, 23, -102, 'z', 'Z', 17,
        'o', ' ', 16, -22, -40, '7', -23, '\b', -46, '\b', -38, -78, '6', '`', 'G'}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{-22, -92, -116, -9, -4, '\f', 'Z', 'G', 'F', -64, -118, 19, 23, -102, 'z', 'Z', 17,
        'o', ' ', 16, -22, -40, '7', -23, '\b', -46, '\b', -38, -78, '6', '`', 'G', 'U', 7, -116, 'd', 'O', -24, -121,
        -19, '\n', '1', -69, -24, -57, '3', 'U', '\'', 16, 26, -30, 'H', '+', 'M', 'Y', ')', 'W', 'J', '%', -19, -2,
        '#', 15, '<'}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature7() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult2.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult3 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult3.toString());
    BigInteger toBigIntegerResult4 = affineXCoord.toBigInteger();
    assertEquals("35627274260195952955705367324742615767090293595613969088061937392808367688811",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineYCoord.toBigInteger();
    assertEquals("62673120042617980405630918094520033317141141418472554415673099963605563007807",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:044ec452982e747a00e069c02bd7c12b1953e7413d5d5778ef861b0af108970c6b8a8fba9772d0b6128d3726475f325a"
        + "d4db04a9e6f5ad954e744fca463d50e33f", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -104, pubKey[4]);
    assertEquals((byte) -107, pubKey[55]);
    assertEquals((byte) -115, pubKey[41]);
    assertEquals((byte) -11, pubKey[53]);
    assertEquals((byte) -17, pubKey[24]);
    assertEquals((byte) -25, pubKey[18]);
    assertEquals((byte) -26, pubKey[52]);
    assertEquals((byte) -29, pubKey[63]);
    assertEquals((byte) -32, pubKey[9]);
    assertEquals((byte) -37, pubKey[49]);
    assertEquals((byte) -41, pubKey[13]);
    assertEquals((byte) -44, pubKey[48]);
    assertEquals((byte) -54, pubKey[59]);
    assertEquals((byte) -60, pubKey[2]);
    assertEquals((byte) -63, pubKey[14]);
    assertEquals((byte) -64, pubKey[11]);
    assertEquals((byte) -83, pubKey[54]);
    assertEquals((byte) -87, pubKey[51]);
    assertEquals(0, toBigIntegerResult3.getLowestSetBit());
    assertEquals(0, toBigIntegerResult4.getLowestSetBit());
    assertEquals(0, toBigIntegerResult5.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals((byte) 0, pubKey[8]);
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, q.signum());
    assertEquals((byte) 18, pubKey[40]);
    assertEquals(2, toBigIntegerResult2.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals((byte) 25, pubKey[Short.SIZE]);
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals((byte) 4, pubKey[50]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals('&', pubKey[43]);
    assertEquals('+', pubKey[12]);
    assertEquals('+', pubKey[15]);
    assertEquals('.', pubKey[5]);
    assertEquals('2', pubKey[46]);
    assertEquals('7', pubKey[42]);
    assertEquals('=', pubKey[20]);
    assertEquals('=', pubKey[61]);
    assertEquals('?', pubKey[Double.SIZE]);
    assertEquals('A', pubKey[19]);
    assertEquals('F', pubKey[60]);
    assertEquals('G', pubKey[44]);
    assertEquals('N', pubKey[1]);
    assertEquals('N', pubKey[56]);
    assertEquals('O', pubKey[58]);
    assertEquals('P', pubKey[62]);
    assertEquals('R', pubKey[3]);
    assertEquals('S', pubKey[17]);
    assertEquals('W', pubKey[22]);
    assertEquals('Z', pubKey[47]);
    assertEquals(']', pubKey[21]);
    assertEquals('_', pubKey[45]);
    assertEquals('i', pubKey[10]);
    assertEquals('t', pubKey[57]);
    assertEquals('t', pubKey[6]);
    assertEquals('x', pubKey[23]);
    assertEquals('z', pubKey[7]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', '@', 'M', -68, -8, -95, -61, '\f', -122, 15, -108, -96, -109, '?', 'K', 19, 'p',
        '!', 2, -63, 'U'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-118, -113, -70, -105, 'r', -48, -74, 18, -115, '7', '&', 'G', '_', '2', 'Z', -44, -37,
        4, -87, -26, -11, -83, -107, 'N', 't', 'O', -54, 'F', '=', 'P', -29, '?'}, affineYCoord.getEncoded());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult3.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{'N', -60, 'R', -104, '.', 't', 'z', 0, -32, 'i', -64, '+', -41, -63, '+', 25, 'S', -25,
        'A', '=', ']', 'W', 'x', -17, -122, 27, '\n', -15, '\b', -105, '\f', 'k'}, toBigIntegerResult4.toByteArray());
    assertArrayEquals(new byte[]{'N', -60, 'R', -104, '.', 't', 'z', 0, -32, 'i', -64, '+', -41, -63, '+', 25, 'S', -25,
        'A', '=', ']', 'W', 'x', -17, -122, 27, '\n', -15, '\b', -105, '\f', 'k'}, affineXCoord.getEncoded());
    assertArrayEquals(new byte[]{0, -118, -113, -70, -105, 'r', -48, -74, 18, -115, '7', '&', 'G', '_', '2', 'Z', -44,
        -37, 4, -87, -26, -11, -83, -107, 'N', 't', 'O', -54, 'F', '=', 'P', -29, '?'},
        toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{'N', -60, 'R', -104, '.', 't', 'z', 0, -32, 'i', -64, '+', -41, -63, '+', 25, 'S', -25,
        'A', '=', ']', 'W', 'x', -17, -122, 27, '\n', -15, '\b', -105, '\f', 'k', -118, -113, -70, -105, 'r', -48, -74,
        18, -115, '7', '&', 'G', '_', '2', 'Z', -44, -37, 4, -87, -26, -11, -83, -107, 'N', 't', 'O', -54, 'F', '=',
        'P', -29, '?'}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature8() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult2.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult3 = affineYCoord.toBigInteger();
    assertEquals("12166505794693084310868292612225511519652473845197872448523546574480646278374",
        toBigIntegerResult3.toString());
    BigInteger toBigIntegerResult4 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineXCoord.toBigInteger();
    assertEquals("44458321199463555652127015181211541353587746885181156188571946621906465761083",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:04624a84a06c41569071f9bf60acfee51e1dace9fdb39c8414f90339a3050aa73b1ae5ff8d42aff579ed80b7f940f1d7"
        + "752072746ad9a06c1df91aa01ee3830ce6", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -100, pubKey[22]);
    assertEquals((byte) -112, pubKey[8]);
    assertEquals((byte) -124, pubKey[23]);
    assertEquals((byte) -124, pubKey[3]);
    assertEquals((byte) -125, pubKey[62]);
    assertEquals((byte) -15, pubKey[46]);
    assertEquals((byte) -19, pubKey[41]);
    assertEquals((byte) -23, pubKey[19]);
    assertEquals((byte) -26, pubKey[Double.SIZE]);
    assertEquals((byte) -27, pubKey[15]);
    assertEquals((byte) -29, pubKey[61]);
    assertEquals((byte) -2, pubKey[14]);
    assertEquals((byte) -39, pubKey[53]);
    assertEquals((byte) -3, pubKey[20]);
    assertEquals((byte) -41, pubKey[47]);
    assertEquals((byte) -65, pubKey[11]);
    assertEquals((byte) -73, pubKey[43]);
    assertEquals((byte) -77, pubKey[21]);
    assertEquals((byte) -7, pubKey[10]);
    assertEquals((byte) -7, pubKey[44]);
    assertEquals((byte) -7, pubKey[57]);
    assertEquals((byte) -84, pubKey[13]);
    assertEquals((byte) -84, pubKey[18]);
    assertEquals((byte) -96, pubKey[4]);
    assertEquals((byte) -96, pubKey[54]);
    assertEquals((byte) -96, pubKey[59]);
    assertEquals(0, toBigIntegerResult4.getLowestSetBit());
    assertEquals(0, toBigIntegerResult5.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals(1, toBigIntegerResult3.getLowestSetBit());
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, q.signum());
    assertEquals(2, toBigIntegerResult2.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals((byte) 20, pubKey[24]);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals((byte) 26, pubKey[58]);
    assertEquals((byte) 29, pubKey[17]);
    assertEquals((byte) 29, pubKey[56]);
    assertEquals((byte) 30, pubKey[60]);
    assertEquals((byte) 30, pubKey[Short.SIZE]);
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals(Byte.MIN_VALUE, pubKey[42]);
    assertEquals(' ', pubKey[49]);
    assertEquals('@', pubKey[45]);
    assertEquals('A', pubKey[6]);
    assertEquals('J', pubKey[2]);
    assertEquals('V', pubKey[7]);
    assertEquals('\f', pubKey[63]);
    assertEquals('`', pubKey[12]);
    assertEquals('b', pubKey[1]);
    assertEquals('j', pubKey[52]);
    assertEquals('l', pubKey[5]);
    assertEquals('l', pubKey[55]);
    assertEquals('q', pubKey[9]);
    assertEquals('r', pubKey[50]);
    assertEquals('t', pubKey[51]);
    assertEquals('u', pubKey[48]);
    assertEquals('y', pubKey[40]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', -112, 'X', 'Q', '!', -86, ' ', -96, 'E', 3, 7, '\t', -114, 20, -48,
        Byte.MIN_VALUE, -91, -77, 'W', 'W', 6}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{26, -27, -1, -115, 'B', -81, -11, 'y', -19, Byte.MIN_VALUE, -73, -7, '@', -15, -41,
        'u', ' ', 'r', 't', 'j', -39, -96, 'l', 29, -7, 26, -96, 30, -29, -125, '\f', -26},
        toBigIntegerResult3.toByteArray());
    assertArrayEquals(new byte[]{26, -27, -1, -115, 'B', -81, -11, 'y', -19, Byte.MIN_VALUE, -73, -7, '@', -15, -41,
        'u', ' ', 'r', 't', 'j', -39, -96, 'l', 29, -7, 26, -96, 30, -29, -125, '\f', -26}, affineYCoord.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult4.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{'b', 'J', -124, -96, 'l', 'A', 'V', -112, 'q', -7, -65, '`', -84, -2, -27, 30, 29, -84,
        -23, -3, -77, -100, -124, 20, -7, 3, '9', -93, 5, '\n', -89, ';'}, toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{'b', 'J', -124, -96, 'l', 'A', 'V', -112, 'q', -7, -65, '`', -84, -2, -27, 30, 29, -84,
        -23, -3, -77, -100, -124, 20, -7, 3, '9', -93, 5, '\n', -89, ';'}, affineXCoord.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{'b', 'J', -124, -96, 'l', 'A', 'V', -112, 'q', -7, -65, '`', -84, -2, -27, 30, 29, -84,
        -23, -3, -77, -100, -124, 20, -7, 3, '9', -93, 5, '\n', -89, ';', 26, -27, -1, -115, 'B', -81, -11, 'y', -19,
        Byte.MIN_VALUE, -73, -7, '@', -15, -41, 'u', ' ', 'r', 't', 'j', -39, -96, 'l', 29, -7, 26, -96, 30, -29, -125,
        '\f', -26}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature9() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature(new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult2.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult3 = affineYCoord.toBigInteger();
    assertEquals("17904878724669972516529414082669655296082426185148920670000496712145110238",
        toBigIntegerResult3.toString());
    BigInteger toBigIntegerResult4 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineXCoord.toBigInteger();
    assertEquals("51242097127936584844788865638531044651931863495614191445112643633705509686951",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:047149ffca69201dcc2721bcddbe9da1220320dbe47e3958d1eafb89b6753f8ea7000a2240dce8e33721bb929a2fbb88"
        + "c72afde9639de9d7246264f37131af04de", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -102, pubKey[44]);
    assertEquals((byte) -110, pubKey[43]);
    assertEquals((byte) -120, pubKey[47]);
    assertEquals((byte) -13, pubKey[59]);
    assertEquals((byte) -1, pubKey[3]);
    assertEquals((byte) -23, pubKey[51]);
    assertEquals((byte) -23, pubKey[54]);
    assertEquals((byte) -28, pubKey[20]);
    assertEquals((byte) -34, pubKey[Double.SIZE]);
    assertEquals((byte) -35, pubKey[12]);
    assertEquals((byte) -37, pubKey[19]);
    assertEquals((byte) -3, pubKey[50]);
    assertEquals((byte) -41, pubKey[55]);
    assertEquals((byte) -47, pubKey[24]);
    assertEquals((byte) -52, pubKey[8]);
    assertEquals((byte) -54, pubKey[4]);
    assertEquals((byte) -57, pubKey[48]);
    assertEquals((byte) -66, pubKey[13]);
    assertEquals((byte) -68, pubKey[11]);
    assertEquals((byte) -69, pubKey[42]);
    assertEquals((byte) -69, pubKey[46]);
    assertEquals((byte) -81, pubKey[62]);
    assertEquals((byte) -95, pubKey[15]);
    assertEquals((byte) -99, pubKey[14]);
    assertEquals((byte) -99, pubKey[53]);
    assertEquals(0, toBigIntegerResult4.getLowestSetBit());
    assertEquals(0, toBigIntegerResult5.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals(1, toBigIntegerResult3.getLowestSetBit());
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, q.signum());
    assertEquals(2, toBigIntegerResult2.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals((byte) 29, pubKey[7]);
    assertEquals((byte) 3, pubKey[17]);
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals((byte) 4, pubKey[63]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals(' ', pubKey[18]);
    assertEquals(' ', pubKey[6]);
    assertEquals('!', pubKey[10]);
    assertEquals('!', pubKey[41]);
    assertEquals('$', pubKey[56]);
    assertEquals('\'', pubKey[9]);
    assertEquals('*', pubKey[49]);
    assertEquals('/', pubKey[45]);
    assertEquals('1', pubKey[61]);
    assertEquals('7', pubKey[40]);
    assertEquals('9', pubKey[22]);
    assertEquals('I', pubKey[2]);
    assertEquals('X', pubKey[23]);
    assertEquals('"', pubKey[Short.SIZE]);
    assertEquals('b', pubKey[57]);
    assertEquals('c', pubKey[52]);
    assertEquals('d', pubKey[58]);
    assertEquals('i', pubKey[5]);
    assertEquals('q', pubKey[1]);
    assertEquals('q', pubKey[60]);
    assertEquals('~', pubKey[21]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', 'h', -111, 7, -66, '(', -111, '}', 3, -80, 'X', -99, -47, 'K', 23, '9', 'x', '`',
        -107, '>', '>'}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{'\n', '"', '@', -36, -24, -29, '7', '!', -69, -110, -102, '/', -69, -120, -57, '*', -3,
        -23, 'c', -99, -23, -41, '$', 'b', 'd', -13, 'q', '1', -81, 4, -34}, toBigIntegerResult3.toByteArray());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{0, '\n', '"', '@', -36, -24, -29, '7', '!', -69, -110, -102, '/', -69, -120, -57, '*',
        -3, -23, 'c', -99, -23, -41, '$', 'b', 'd', -13, 'q', '1', -81, 4, -34}, affineYCoord.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult4.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{'q', 'I', -1, -54, 'i', ' ', 29, -52, '\'', '!', -68, -35, -66, -99, -95, '"', 3, ' ',
        -37, -28, '~', '9', 'X', -47, -22, -5, -119, -74, 'u', '?', -114, -89}, toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{'q', 'I', -1, -54, 'i', ' ', 29, -52, '\'', '!', -68, -35, -66, -99, -95, '"', 3, ' ',
        -37, -28, '~', '9', 'X', -47, -22, -5, -119, -74, 'u', '?', -114, -89}, affineXCoord.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{'q', 'I', -1, -54, 'i', ' ', 29, -52, '\'', '!', -68, -35, -66, -99, -95, '"', 3, ' ',
        -37, -28, '~', '9', 'X', -47, -22, -5, -119, -74, 'u', '?', -114, -89, 0, '\n', '"', '@', -36, -24, -29, '7',
        '!', -69, -110, -102, '/', -69, -120, -57, '*', -3, -23, 'c', -99, -23, -41, '$', 'b', 'd', -13, 'q', '1', -81,
        4, -34}, actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test:
   * {@link SM2#recoverFromSignature(int, SM2.SM2Signature, byte[])}
   */
  @Test
  public void testRecoverFromSignature10() throws UnsupportedEncodingException {
    // Arrange
    SM2.SM2Signature sig = new SM2.SM2Signature("AXAXAXAX".getBytes("UTF-8"), new byte[]{}, (byte) 'A');

    // Act
    SM2 actualRecoverFromSignatureResult = SM2.recoverFromSignature(1, sig, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ECPoint pubKeyPoint = actualRecoverFromSignatureResult.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECFieldElement affineXCoord = pubKeyPoint.getAffineXCoord();
    assertTrue(affineXCoord instanceof ECFieldElement.Fp);
    ECFieldElement affineYCoord = pubKeyPoint.getAffineYCoord();
    assertTrue(affineYCoord instanceof ECFieldElement.Fp);
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    ECFieldElement ecFieldElement = zCoords[0];
    assertTrue(ecFieldElement instanceof ECFieldElement.Fp);
    ECFieldElement ecFieldElement2 = zCoords[1];
    assertTrue(ecFieldElement2 instanceof ECFieldElement.Fp);
    ECPoint infinity = curve.getInfinity();
    assertTrue(infinity instanceof ECPoint.Fp);
    ECPoint detachedPoint = infinity.getDetachedPoint();
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    ECPoint detachedPoint3 = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint4 = detachedPoint3.getDetachedPoint();
    assertTrue(detachedPoint4 instanceof ECPoint.Fp);
    assertTrue(detachedPoint3 instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = ecFieldElement.toBigInteger();
    assertEquals("1", toBigIntegerResult.toString());
    BigInteger toBigIntegerResult2 = ecFieldElement2.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult2.toString());
    BigInteger q = ((ECFieldElement.Fp) affineXCoord).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult3 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult3.toString());
    BigInteger toBigIntegerResult4 = affineYCoord.toBigInteger();
    assertEquals("81223657444532205843422075145389225766898502306434683390874965504674769171450",
        toBigIntegerResult4.toString());
    BigInteger toBigIntegerResult5 = affineXCoord.toBigInteger();
    assertEquals("98691524399455702674972111300442476025694300386514708804848052876911890853611",
        toBigIntegerResult5.toString());
    assertEquals("Fp", b.getFieldName());
    assertEquals("Fp", affineXCoord.getFieldName());
    assertEquals("Fp", affineYCoord.getFieldName());
    assertEquals("Fp", ecFieldElement.getFieldName());
    assertEquals("Fp", ecFieldElement2.getFieldName());
    assertEquals("pub:04da316c5d3b56779a72a54e0d294fd1535fffd868a610bfffcf8b4e16abd2eeebb392f601bef1599c8749d5d5e20bab"
        + "215418d5616f9b9e3f63dc0027dec073fa", actualRecoverFromSignatureResult.toStringWithPrivate());
    assertNull(actualRecoverFromSignatureResult.getPrivKeyBytes());
    assertNull(actualRecoverFromSignatureResult.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint3.getCurve());
    assertNull(infinity.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(infinity.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(infinity.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(infinity.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(infinity.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(infinity.getYCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    byte[] pubKey = actualRecoverFromSignatureResult.getPubKey();
    assertEquals((byte) -100, pubKey[40]);
    assertEquals((byte) -101, pubKey[54]);
    assertEquals((byte) -102, pubKey[8]);
    assertEquals((byte) -121, pubKey[41]);
    assertEquals((byte) -1, pubKey[18]);
    assertEquals((byte) -1, pubKey[24]);
    assertEquals((byte) -30, pubKey[45]);
    assertEquals((byte) -34, pubKey[61]);
    assertEquals((byte) -36, pubKey[58]);
    assertEquals((byte) -38, pubKey[1]);
    assertEquals((byte) -40, pubKey[19]);
    assertEquals((byte) -43, pubKey[43]);
    assertEquals((byte) -43, pubKey[44]);
    assertEquals((byte) -43, pubKey[51]);
    assertEquals((byte) -47, pubKey[15]);
    assertEquals((byte) -64, pubKey[62]);
    assertEquals((byte) -65, pubKey[23]);
    assertEquals((byte) -6, pubKey[Double.SIZE]);
    assertEquals((byte) -85, pubKey[47]);
    assertEquals((byte) -90, pubKey[21]);
    assertEquals((byte) -91, pubKey[10]);
    assertEquals((byte) -98, pubKey[55]);
    assertEquals(0, toBigIntegerResult3.getLowestSetBit());
    assertEquals(0, toBigIntegerResult5.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, q.getLowestSetBit());
    ECFieldElement[] zCoords2 = detachedPoint3.getZCoords();
    assertEquals(0, zCoords2.length);
    assertEquals((byte) 0, pubKey[59]);
    assertEquals(1, toBigIntegerResult4.getLowestSetBit());
    assertEquals(1, toBigIntegerResult3.signum());
    assertEquals(1, toBigIntegerResult5.signum());
    assertEquals(1, toBigIntegerResult4.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(1, q.signum());
    assertEquals((byte) 11, pubKey[46]);
    assertEquals((byte) 16, pubKey[22]);
    assertEquals(2, toBigIntegerResult2.getLowestSetBit());
    assertEquals(2, zCoords.length);
    assertEquals((byte) 24, pubKey[50]);
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(256, affineXCoord.getFieldSize());
    assertEquals(256, affineYCoord.getFieldSize());
    assertEquals(256, ecFieldElement.getFieldSize());
    assertEquals(256, ecFieldElement2.getFieldSize());
    assertEquals(4, curve.getCoordinateSystem());
    assertEquals((byte) 4, pubKey[0]);
    assertEquals(65, pubKey.length);
    assertFalse(b.isZero());
    assertFalse(affineXCoord.isZero());
    assertFalse(affineYCoord.isZero());
    assertFalse(ecFieldElement.isZero());
    assertFalse(ecFieldElement2.isZero());
    assertFalse(detachedPoint3.isInfinity());
    assertFalse(pubKeyPoint.isInfinity());
    assertFalse(actualRecoverFromSignatureResult.hasPrivKey());
    assertTrue(infinity.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(infinity.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(detachedPoint3.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyCanonical());
    assertTrue(actualRecoverFromSignatureResult.isPubKeyOnly());
    assertEquals('!', pubKey[48]);
    assertEquals('\'', pubKey[60]);
    assertEquals(')', pubKey[13]);
    assertEquals('1', pubKey[2]);
    assertEquals(';', pubKey[5]);
    assertEquals('?', pubKey[56]);
    assertEquals('I', pubKey[42]);
    assertEquals('N', pubKey[11]);
    assertEquals('O', pubKey[14]);
    assertEquals('S', pubKey[Short.SIZE]);
    assertEquals('T', pubKey[49]);
    assertEquals('V', pubKey[6]);
    assertEquals('\r', pubKey[12]);
    assertEquals(']', pubKey[4]);
    assertEquals('_', pubKey[17]);
    assertEquals('a', pubKey[52]);
    assertEquals('c', pubKey[57]);
    assertEquals('h', pubKey[20]);
    assertEquals('l', pubKey[3]);
    assertEquals('o', pubKey[53]);
    assertEquals('r', pubKey[9]);
    assertEquals('s', pubKey[63]);
    assertEquals('w', pubKey[7]);
    assertEquals(detachedPoint2, detachedPoint2);
    assertEquals(detachedPoint4, detachedPoint4);
    assertSame(q, ((ECCurve.Fp) curve).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(q, ((ECFieldElement.Fp) affineYCoord).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement).getQ());
    assertSame(q, ((ECFieldElement.Fp) ecFieldElement2).getQ());
    assertSame(zCoords2, infinity.getZCoords());
    assertSame(zCoords2, detachedPoint.getZCoords());
    assertSame(curve, infinity.getCurve());
    assertSame(affineXCoord, detachedPoint3.getAffineXCoord());
    assertSame(affineXCoord, detachedPoint3.getRawXCoord());
    assertSame(affineXCoord, pubKeyPoint.getRawXCoord());
    assertSame(affineXCoord, detachedPoint3.getXCoord());
    assertSame(affineXCoord, pubKeyPoint.getXCoord());
    assertSame(affineYCoord, detachedPoint3.getAffineYCoord());
    assertSame(affineYCoord, detachedPoint3.getRawYCoord());
    assertSame(affineYCoord, pubKeyPoint.getRawYCoord());
    assertSame(affineYCoord, detachedPoint3.getYCoord());
    assertSame(affineYCoord, pubKeyPoint.getYCoord());
    assertSame(ecFieldElement2, curve.getA());
    assertArrayEquals(new byte[]{1}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'A', '&', -73, -57, 't', 'z', 15, -58, -65, -123, -108, -86, -76, -30, -111, -10, '[',
        -98, 'h', -24, -121}, actualRecoverFromSignatureResult.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, ecFieldElement2.getEncoded());
    assertArrayEquals(new byte[]{-38, '1', 'l', ']', ';', 'V', 'w', -102, 'r', -91, 'N', '\r', ')', 'O', -47, 'S', '_',
        -1, -40, 'h', -90, 16, -65, -1, -49, -117, 'N', 22, -85, -46, -18, -21}, affineXCoord.getEncoded());
    assertArrayEquals(new byte[]{-77, -110, -10, 1, -66, -15, 'Y', -100, -121, 'I', -43, -43, -30, 11, -85, '!', 'T',
        24, -43, 'a', 'o', -101, -98, '?', 'c', -36, 0, '\'', -34, -64, 's', -6}, affineYCoord.getEncoded());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        ecFieldElement.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult3.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{0, -38, '1', 'l', ']', ';', 'V', 'w', -102, 'r', -91, 'N', '\r', ')', 'O', -47, 'S',
        '_', -1, -40, 'h', -90, 16, -65, -1, -49, -117, 'N', 22, -85, -46, -18, -21},
        toBigIntegerResult5.toByteArray());
    assertArrayEquals(new byte[]{0, -77, -110, -10, 1, -66, -15, 'Y', -100, -121, 'I', -43, -43, -30, 11, -85, '!', 'T',
        24, -43, 'a', 'o', -101, -98, '?', 'c', -36, 0, '\'', -34, -64, 's', -6}, toBigIntegerResult4.toByteArray());
    assertArrayEquals(
        new byte[]{-38, '1', 'l', ']', ';', 'V', 'w', -102, 'r', -91, 'N', '\r', ')', 'O', -47, 'S', '_', -1, -40, 'h',
            -90, 16, -65, -1, -49, -117, 'N', 22, -85, -46, -18, -21, -77, -110, -10, 1, -66, -15, 'Y', -100, -121, 'I',
            -43, -43, -30, 11, -85, '!', 'T', 24, -43, 'a', 'o', -101, -98, '?', 'c', -36, 0, '\'', -34, -64, 's', -6},
        actualRecoverFromSignatureResult.getNodeId());
  }

  /**
   * Method under test: {@link SM2#isPubKeyOnly()}
   */
  @Test
  public void testIsPubKeyOnly() {
    // Arrange, Act and Assert
    assertTrue(SM2.fromPublicOnly(mock(ECPoint.class)).isPubKeyOnly());
  }

  /**
   * Method under test: {@link SM2#hasPrivKey()}
   */
  @Test
  public void testHasPrivKey() {
    // Arrange, Act and Assert
    assertFalse(SM2.fromPublicOnly(mock(ECPoint.class)).hasPrivKey());
  }

  /**
   * Method under test: {@link SM2#getNodeId()}
   */
  @Test
  public void testGetNodeId() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#getNodeId()}
   */
  @Test
  public void testGetNodeId2() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).getNodeId());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#getPrivKey()}
   */
  @Test
  public void testGetPrivKey() {
    // Arrange, Act and Assert
    assertThrows(ECKey.MissingPrivateKeyException.class, () -> SM2.fromPublicOnly(mock(ECPoint.class)).getPrivKey());
  }

  /**
   * Method under test: {@link SM2#toStringWithPrivate()}
   */
  @Test
  public void testToStringWithPrivate() throws UnsupportedEncodingException {
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
   * Method under test: {@link SM2#toStringWithPrivate()}
   */
  @Test
  public void testToStringWithPrivate2() {
    // Arrange
    ECPoint pub = mock(ECPoint.class);
    when(pub.getEncoded(anyBoolean())).thenThrow(new IllegalArgumentException("pub:"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SM2.fromPublicOnly(pub).toStringWithPrivate());
    verify(pub).getEncoded(eq(false));
  }

  /**
   * Method under test: {@link SM2#getPrivKeyBytes()}
   */
  @Test
  public void testGetPrivKeyBytes() {
    // Arrange, Act and Assert
    assertNull(SM2.fromPublicOnly(mock(ECPoint.class)).getPrivKeyBytes());
  }

  /**
   * Method under test: {@link SM2#SM2(BigInteger, ECPoint)}
   */
  @Test
  public void testNewSm2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2((BigInteger) null, null));

    assertThrows(IllegalArgumentException.class, () -> new SM2((PrivateKey) null, null));
  }

  /**
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  public void testNewSm22() {
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
   * Method under test:
   * {@link SM2#SM2(PrivateKey, org.bouncycastle.math.ec.ECPoint)}
   */
  @Test
  public void testNewSm23() {
    // Arrange
    EllipticCurve ellipticCurve = new EllipticCurve(mock(ECField.class), ECKey.HALF_CURVE_ORDER,
        ECKey.HALF_CURVE_ORDER);

    org.bouncycastle.math.ec.ECPoint pub = mock(org.bouncycastle.math.ec.ECPoint.class);

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
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  public void testNewSm24() {
    // Arrange
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenReturn("Algorithm");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2(privKey, mock(ECPoint.class)));

    verify(privKey, atLeast(1)).getAlgorithm();
  }

  /**
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  public void testNewSm25() {
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
   * Method under test: {@link SM2#SM2(PrivateKey, ECPoint)}
   */
  @Test
  public void testNewSm26() {
    // Arrange
    AnnotatedPrivateKey privKey = mock(AnnotatedPrivateKey.class);
    when(privKey.getAlgorithm()).thenThrow(new IllegalArgumentException("EC"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SM2(privKey, mock(ECPoint.class)));

    verify(privKey).getAlgorithm();
  }

  /**
   * Method under test: {@link SM2#SM2(byte[], boolean)}
   */
  @Test
  public void testNewSm27() {
    // Arrange and Act
    SM2 actualSm2 = new SM2(new byte[]{0}, false);

    // Assert
    ECPoint pubKeyPoint = actualSm2.getPubKeyPoint();
    ECCurve curve = pubKeyPoint.getCurve();
    assertTrue(curve instanceof ECCurve.Fp);
    ECFieldElement a = curve.getA();
    assertTrue(a instanceof ECFieldElement.Fp);
    ECFieldElement b = curve.getB();
    assertTrue(b instanceof ECFieldElement.Fp);
    ECPoint detachedPoint = pubKeyPoint.getDetachedPoint();
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof ECPoint.Fp);
    assertTrue(detachedPoint instanceof ECPoint.Fp);
    assertTrue(pubKeyPoint instanceof ECPoint.Fp);
    assertTrue(curve.getMultiplier() instanceof WNafL2RMultiplier);
    BigInteger toBigIntegerResult = a.toBigInteger();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991996",
        toBigIntegerResult.toString());
    BigInteger q = ((ECCurve.Fp) curve).getQ();
    assertEquals("115792089210356248756420345214020892766250353991924191454421193933289684991999", q.toString());
    BigInteger toBigIntegerResult2 = b.toBigInteger();
    assertEquals("18505919022281880113072981827955639221458448578012075254857346196103069175443",
        toBigIntegerResult2.toString());
    assertEquals("Fp", a.getFieldName());
    assertEquals("Fp", b.getFieldName());
    assertEquals("pub:00", actualSm2.toStringWithPrivate());
    assertNull(actualSm2.getPrivKeyBytes());
    assertNull(actualSm2.getPrivateKey());
    assertNull(curve.getCofactor());
    assertNull(curve.getOrder());
    assertNull(detachedPoint.getCurve());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(pubKeyPoint.getAffineXCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(pubKeyPoint.getAffineYCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(pubKeyPoint.getRawXCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(pubKeyPoint.getRawYCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(pubKeyPoint.getXCoord());
    assertNull(detachedPoint.getYCoord());
    assertNull(pubKeyPoint.getYCoord());
    assertNull(curve.getEndomorphism());
    assertEquals(0, q.getLowestSetBit());
    assertEquals(0, toBigIntegerResult2.getLowestSetBit());
    ECFieldElement[] zCoords = pubKeyPoint.getZCoords();
    assertEquals(0, zCoords.length);
    assertEquals(0, actualSm2.getNodeId().length);
    assertEquals(1, q.signum());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(1, toBigIntegerResult2.signum());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertEquals(256, curve.getFieldSize());
    assertEquals(256, a.getFieldSize());
    assertEquals(256, b.getFieldSize());
    assertEquals(4, curve.getCoordinateSystem());
    assertFalse(a.isZero());
    assertFalse(b.isZero());
    assertFalse(actualSm2.hasPrivKey());
    assertFalse(actualSm2.isPubKeyCanonical());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(pubKeyPoint.isInfinity());
    assertTrue(detachedPoint.isNormalized());
    assertTrue(pubKeyPoint.isNormalized());
    assertTrue(actualSm2.isPubKeyOnly());
    assertEquals(detachedPoint2, detachedPoint2);
    assertSame(q, ((ECFieldElement.Fp) a).getQ());
    assertSame(q, ((ECFieldElement.Fp) b).getQ());
    assertSame(zCoords, detachedPoint.getZCoords());
    assertSame(pubKeyPoint, curve.getInfinity());
    assertArrayEquals(new byte[]{0}, actualSm2.getPubKey());
    assertArrayEquals(
        new byte[]{'A', -36, -57, 3, -64, -27, 0, -74, 'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123, -92, 'p'},
        actualSm2.getAddress());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0,
        0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, a.getEncoded());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109},
        toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{'(', -23, -6, -98, -99, -97, '^', '4', 'M', 'Z', -98, 'K', -49, 'e', '\t', -89, -13,
        -105, -119, -11, 21, -85, -113, -110, -35, -68, -67, 'A', 'M', -108, 14, -109}, b.getEncoded());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1}, q.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0,
        0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -4}, toBigIntegerResult.toByteArray());
  }
}
