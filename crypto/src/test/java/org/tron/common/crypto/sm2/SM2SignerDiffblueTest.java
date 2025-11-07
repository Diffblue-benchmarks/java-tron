package org.tron.common.crypto.sm2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.math.ec.custom.djb.Curve25519;
import org.bouncycastle.math.ec.custom.djb.Curve25519Point;
import org.junit.Test;
import org.tron.common.crypto.ECKey;

public class SM2SignerDiffblueTest {
  /**
   * Method under test: {@link SM2Signer#generateHashSignature(byte[])}
   */
  @Test
  public void testGenerateHashSignature() throws UnsupportedEncodingException {
    // Arrange
    SM2Signer sm2Signer = new SM2Signer();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> sm2Signer.generateHashSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link SM2Signer#createBasePointMultiplier()}
   */
  @Test
  public void testCreateBasePointMultiplier() {
    // Arrange and Act
    ECMultiplier actualCreateBasePointMultiplierResult = (new SM2Signer()).createBasePointMultiplier();
    ECPoint ecPoint = mock(ECPoint.class);
    when(ecPoint.isInfinity()).thenReturn(true);
    Curve25519 curve25519 = new Curve25519();
    when(ecPoint.getCurve()).thenReturn(curve25519);
    ECPoint actualMultiplyResult = actualCreateBasePointMultiplierResult.multiply(ecPoint, ECKey.HALF_CURVE_ORDER);

    // Assert
    verify(ecPoint).getCurve();
    verify(ecPoint).isInfinity();
    assertTrue(actualCreateBasePointMultiplierResult instanceof FixedPointCombMultiplier);
    assertTrue(actualMultiplyResult instanceof Curve25519Point);
    ECPoint detachedPoint = actualMultiplyResult.getDetachedPoint();
    assertTrue(detachedPoint instanceof Curve25519Point);
    ECPoint detachedPoint2 = detachedPoint.getDetachedPoint();
    assertTrue(detachedPoint2 instanceof Curve25519Point);
    assertNull(detachedPoint.getCurve());
    assertNull(actualMultiplyResult.getAffineXCoord());
    assertNull(detachedPoint.getAffineXCoord());
    assertNull(actualMultiplyResult.getAffineYCoord());
    assertNull(detachedPoint.getAffineYCoord());
    assertNull(actualMultiplyResult.getRawXCoord());
    assertNull(detachedPoint.getRawXCoord());
    assertNull(actualMultiplyResult.getRawYCoord());
    assertNull(detachedPoint.getRawYCoord());
    assertNull(actualMultiplyResult.getXCoord());
    assertNull(detachedPoint.getXCoord());
    assertNull(actualMultiplyResult.getYCoord());
    assertNull(detachedPoint.getYCoord());
    ECFieldElement[] zCoords = actualMultiplyResult.getZCoords();
    assertEquals(0, zCoords.length);
    assertTrue(actualMultiplyResult.isInfinity());
    assertTrue(detachedPoint.isInfinity());
    assertTrue(actualMultiplyResult.isNormalized());
    assertTrue(detachedPoint.isNormalized());
    assertEquals(detachedPoint2, detachedPoint2);
    assertSame(curve25519, actualMultiplyResult.getCurve());
    assertSame(zCoords, detachedPoint.getZCoords());
  }

  /**
   * Method under test: {@link SM2Signer#calculateE(byte[])}
   */
  @Test
  public void testCalculateE() throws UnsupportedEncodingException {
    // Arrange
    SM2Signer sm2Signer = new SM2Signer();

    // Act
    BigInteger actualCalculateEResult = sm2Signer.calculateE("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4708585257725083992", actualCalculateEResult.toString());
    assertEquals(1, actualCalculateEResult.signum());
    assertEquals(3, actualCalculateEResult.getLowestSetBit());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, actualCalculateEResult.toByteArray());
  }

  /**
   * Method under test: default or parameterless constructor of {@link SM2Signer}
   */
  @Test
  public void testNewSM2Signer() {
    // Arrange, Act and Assert
    assertTrue((new SM2Signer()).createBasePointMultiplier() instanceof FixedPointCombMultiplier);
  }
}
