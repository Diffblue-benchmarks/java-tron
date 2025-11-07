package org.tron.common.crypto.jce;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.junit.Test;

public class ECAlgorithmParametersDiffblueTest {
  /**
   * Method under test: {@link ECAlgorithmParameters#getParameterSpec()}
   */
  @Test
  public void testGetParameterSpec() {
    // Arrange and Act
    ECParameterSpec actualParameterSpec = ECAlgorithmParameters.getParameterSpec();

    // Assert
    EllipticCurve curve = actualParameterSpec.getCurve();
    ECField field = curve.getField();
    assertTrue(field instanceof ECFieldFp);
    BigInteger a = curve.getA();
    assertEquals("0", a.toString());
    BigInteger order = actualParameterSpec.getOrder();
    assertEquals("115792089237316195423570985008687907852837564279074904382605163141518161494337", order.toString());
    BigInteger p = ((ECFieldFp) field).getP();
    assertEquals("115792089237316195423570985008687907853269984665640564039457584007908834671663", p.toString());
    ECPoint generator = actualParameterSpec.getGenerator();
    BigInteger affineY = generator.getAffineY();
    assertEquals("32670510020758816978083085130507043184471273380659243275938904335757337482424", affineY.toString());
    BigInteger affineX = generator.getAffineX();
    assertEquals("55066263022277343669578718895168534326250603453777594175500187360389116729240", affineX.toString());
    BigInteger b = curve.getB();
    assertEquals("7", b.toString());
    assertNull(curve.getSeed());
    assertEquals(-1, a.getLowestSetBit());
    assertEquals(0, p.getLowestSetBit());
    assertEquals(0, order.getLowestSetBit());
    assertEquals(0, b.getLowestSetBit());
    assertEquals(0, a.signum());
    assertEquals(1, p.signum());
    assertEquals(1, order.signum());
    assertEquals(1, affineX.signum());
    assertEquals(1, affineY.signum());
    assertEquals(1, b.signum());
    assertEquals(1, actualParameterSpec.getCofactor());
    assertEquals(256, field.getFieldSize());
    assertEquals(3, affineX.getLowestSetBit());
    assertEquals(3, affineY.getLowestSetBit());
    assertArrayEquals(new byte[]{0}, a.toByteArray());
    assertArrayEquals(new byte[]{7}, b.toByteArray());
    assertArrayEquals(new byte[]{'H', ':', -38, 'w', '&', -93, -60, 'e', ']', -92, -5, -4, 14, 17, '\b', -88, -3, 23,
        -76, 'H', -90, -123, 'T', 25, -100, 'G', -48, -113, -5, 16, -44, -72}, affineY.toByteArray());
    assertArrayEquals(new byte[]{'y', -66, 'f', '~', -7, -36, -69, -84, 'U', -96, 'b', -107, -50, -121, 11, 7, 2, -101,
        -4, -37, '-', -50, '(', -39, 'Y', -14, -127, '[', 22, -8, 23, -104}, affineX.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -2, -1, -1, -4, '/'}, p.toByteArray());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -70, -82, -36, -26,
        -81, 'H', -96, ';', -65, -46, '^', -116, -48, '6', 'A', 'A'}, order.toByteArray());
  }

  /**
   * Method under test: {@link ECAlgorithmParameters#getASN1Encoding()}
   */
  @Test
  public void testGetASN1Encoding() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{6, 5, '+', -127, 4, 0, '\n'}, ECAlgorithmParameters.getASN1Encoding());
  }
}
