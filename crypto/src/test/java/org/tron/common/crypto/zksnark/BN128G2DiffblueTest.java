package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BN128G2DiffblueTest {
  /**
   * Test {@link BN128G2#BN128G2(Fp2, Fp2, Fp2)}.
   * <p>
   * Method under test: {@link BN128G2#BN128G2(Fp2, Fp2, Fp2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BN128G2.<init>(Fp2, Fp2, Fp2)"})
  public void testNewBn128g2() {
    // Arrange and Act
    BN128G2 actualBn128g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Assert
    BN128G2 toAffineResult = actualBn128g2.toAffine();
    Fp2 yResult = toAffineResult.y();
    Fp fp = yResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals("12903776731702987355887083934295038437179086470483131023036785576200725266333",
        bigInteger.toString());
    Fp2 xResult = toAffineResult.x();
    Fp fp2 = xResult.b;
    BigInteger bigInteger2 = fp2.v;
    assertEquals("14681138511599513868579906292550611339979233093309515871315818100066920017952",
        bigInteger2.toString());
    Fp2 bResult = actualBn128g2.b();
    Fp fp3 = bResult.a;
    BigInteger bigInteger3 = fp3.v;
    assertEquals("19485874751759354771024239261021720505790618469301721065564631296452457478373",
        bigInteger3.toString());
    Fp fp4 = xResult.a;
    BigInteger bigInteger4 = fp4.v;
    assertEquals("21087453498479301738505683583845423561061080261299122796980902361914303298513",
        bigInteger4.toString());
    Fp fp5 = bResult.b;
    BigInteger bigInteger5 = fp5.v;
    assertEquals("266929791119991161246907387137283842545076965332900288569378510910307636690", bigInteger5.toString());
    Fp fp6 = yResult.b;
    BigInteger bigInteger6 = fp6.v;
    assertEquals("7493565599490483575492448843780822018765453343857761759594016245311319264152",
        bigInteger6.toString());
    assertEquals(0, bigInteger4.getLowestSetBit());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger3.getLowestSetBit());
    assertEquals(1, bigInteger5.getLowestSetBit());
    assertEquals(1, bigInteger4.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger3.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger6.signum());
    assertEquals(1, bigInteger5.signum());
    assertEquals(3, bigInteger6.getLowestSetBit());
    assertEquals(5, bigInteger2.getLowestSetBit());
    Fp2 fp23 = actualBn128g2.x;
    assertFalse(fp23.isZero());
    Fp2 fp24 = actualBn128g2.y;
    assertFalse(fp24.isZero());
    Fp2 fp25 = actualBn128g2.z;
    assertFalse(fp25.isZero());
    assertTrue(fp23.isValid());
    assertTrue(fp24.isValid());
    assertTrue(fp25.isValid());
    assertArrayEquals(new byte[]{0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O',
        -96, -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46}, bigInteger5.toByteArray());
    assertArrayEquals(new byte[]{0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O',
        -96, -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46}, fp5.bytes());
    assertArrayEquals(new byte[]{16, -111, '5', '4', 31, 'A', -52, 'u', ';', '7', -89, -57, -20, -122, -8, -113, -124,
        -88, -90, -60, -67, -52, Byte.MAX_VALUE, '#', -113, 'h', '1', '-', -67, -37, 'K', -104},
        bigInteger6.toByteArray());
    assertArrayEquals(new byte[]{16, -111, '5', '4', 31, 'A', -52, 'u', ';', '7', -89, -57, -20, -122, -8, -113, -124,
        -88, -90, -60, -67, -52, Byte.MAX_VALUE, '#', -113, 'h', '1', '-', -67, -37, 'K', -104}, fp6.bytes());
    assertArrayEquals(new byte[]{28, -121, 'G', '`', '4', 11, 'p', 22, '(', -107, -87, 'z', -124, 'c', -37, -99, 14,
        -79, -33, 'V', -55, -43, '!', '6', -56, -82, -122, 15, -103, -86, -1, -99}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{28, -121, 'G', '`', '4', 11, 'p', 22, '(', -107, -87, 'z', -124, 'c', -37, -99, 14,
        -79, -33, 'V', -55, -43, '!', '6', -56, -82, -122, 15, -103, -86, -1, -99}, fp.bytes());
    assertArrayEquals(new byte[]{' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14,
        27, '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14,
        27, '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '}, fp2.bytes());
    assertArrayEquals(new byte[]{'+', 20, -99, '@', -50, -72, -86, -82, -127, -66, 24, -103, 27, -32, 'j', -61, -75,
        -76, -59, -27, 'Y', -37, -17, -93, '2', 'g', -26, -36, '$', -95, '8', -27}, bigInteger3.toByteArray());
    assertArrayEquals(new byte[]{'+', 20, -99, '@', -50, -72, -86, -82, -127, -66, 24, -103, 27, -32, 'j', -61, -75,
        -76, -59, -27, 'Y', -37, -17, -93, '2', 'g', -26, -36, '$', -95, '8', -27}, fp3.bytes());
    assertArrayEquals(new byte[]{'.', -97, 19, 'b', '0', '^', -93, -85, 'P', -54, '6', -84, -76, -10, '^',
        Byte.MAX_VALUE, -95, -110, -119, 2, -72, -22, -127, -108, -114, '8', 'U', 3, 'G', '3', -69, -47},
        bigInteger4.toByteArray());
    assertArrayEquals(new byte[]{'.', -97, 19, 'b', '0', '^', -93, -85, 'P', -54, '6', -84, -76, -10, '^',
        Byte.MAX_VALUE, -95, -110, -119, 2, -72, -22, -127, -108, -114, '8', 'U', 3, 'G', '3', -69, -47}, fp4.bytes());
  }

  /**
   * Test {@link BN128G2#BN128G2(BN128)}.
   * <p>
   * Method under test: {@link BN128G2#BN128G2(BN128)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BN128G2.<init>(BN128)"})
  public void testNewBn128g22() {
    // Arrange
    BN128<Fp2> p = BN128Fp2.ZERO;

    // Act
    BN128G2 actualBn128g2 = new BN128G2(p);

    // Assert
    BN128<Fp2> toEthNotationResult = actualBn128g2.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128Fp2);
    assertTrue(p instanceof BN128Fp2);
    assertTrue(actualBn128g2.isValid());
    assertTrue(actualBn128g2.isZero());
    Fp2 fp2 = actualBn128g2.z;
    assertSame(fp2, actualBn128g2.x());
    assertSame(fp2, p.x());
    assertSame(fp2, actualBn128g2.y());
    assertSame(fp2, p.y());
    BN128<Fp2> bn128 = actualBn128g2.ZERO;
    assertSame(bn128, toEthNotationResult);
    assertSame(bn128, p.toEthNotation());
    assertSame(bn128, p.zero());
    assertSame(bn128, actualBn128g2.zero());
  }

  /**
   * Test {@link BN128G2#create(byte[], byte[], byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128G2#create(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128G2 BN128G2.create(byte[], byte[], byte[], byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    byte[] a = "AXAXAXAX".getBytes("UTF-8");
    byte[] b = "AXAXAXAX".getBytes("UTF-8");
    byte[] c = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(BN128G2.create(a, b, c, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BN128G2#create(byte[], byte[], byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128G2#create(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128G2 BN128G2.create(byte[], byte[], byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    byte[] b = "AXAXAXAX".getBytes("UTF-8");
    byte[] c = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(BN128G2.create(new byte[]{}, b, c, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BN128G2#create(byte[], byte[], byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128G2#create(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128G2 BN128G2.create(byte[], byte[], byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenReturnNull2() throws UnsupportedEncodingException {
    // Arrange
    byte[] c = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(BN128G2.create(new byte[]{}, new byte[]{}, c, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BN128G2#toAffine()}.
   * <ul>
   *   <li>Then toEthNotation return {@link BN128Fp2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128G2#toAffine()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128G2 BN128G2.toAffine()"})
  public void testToAffine_thenToEthNotationReturnBN128Fp2() {
    // Arrange
    BN128G2 bn128g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.ZERO);

    // Act
    BN128G2 actualToAffineResult = bn128g2.toAffine();

    // Assert
    BN128<Fp2> toEthNotationResult = actualToAffineResult.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128Fp2);
    assertTrue(actualToAffineResult.isValid());
    assertTrue(actualToAffineResult.isZero());
    Fp2 fp2 = actualToAffineResult.y;
    assertSame(fp2, actualToAffineResult.y());
    assertSame(fp2, bn128g2.one());
    assertSame(fp2, actualToAffineResult.one());
    Fp2 expectedXResult = actualToAffineResult.z;
    assertSame(expectedXResult, actualToAffineResult.x());
    BN128<Fp2> bn128 = actualToAffineResult.ZERO;
    assertSame(bn128, bn128g2.toEthNotation());
    assertSame(bn128, toEthNotationResult);
    assertSame(bn128, bn128g2.zero());
    assertSame(bn128, actualToAffineResult.zero());
  }

  /**
   * Test {@link BN128G2#toAffine()}.
   * <ul>
   *   <li>Then zero return {@link BN128Fp2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128G2#toAffine()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128G2 BN128G2.toAffine()"})
  public void testToAffine_thenZeroReturnBN128Fp2() {
    // Arrange
    BN128G2 bn128g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    BN128G2 actualToAffineResult = bn128g2.toAffine();

    // Assert
    BN128<Fp2> zeroResult = actualToAffineResult.zero();
    assertTrue(zeroResult instanceof BN128Fp2);
    assertTrue(bn128g2.toEthNotation() instanceof BN128G2);
    assertTrue(actualToAffineResult.toEthNotation() instanceof BN128G2);
    assertFalse(actualToAffineResult.isValid());
    assertFalse(actualToAffineResult.isZero());
    Fp2 expectedXResult = actualToAffineResult.x;
    assertSame(expectedXResult, actualToAffineResult.x());
    Fp2 expectedYResult = actualToAffineResult.y;
    assertSame(expectedYResult, actualToAffineResult.y());
    Fp2 fp2 = actualToAffineResult.z;
    assertSame(fp2, bn128g2.one());
    assertSame(fp2, actualToAffineResult.one());
    BN128<Fp2> bn128 = actualToAffineResult.ZERO;
    assertSame(bn128, bn128g2.zero());
    assertSame(bn128, zeroResult);
  }

  /**
   * Test {@link BN128G2#mulByP()}.
   * <ul>
   *   <li>Then zero return {@link BN128Fp2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BN128G2#mulByP()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128G2 BN128G2.mulByP()"})
  public void testMulByP_thenZeroReturnBN128Fp2() {
    // Arrange and Act
    BN128G2 actualMulByPResult = (new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE)).mulByP();

    // Assert
    BN128<Fp2> zeroResult = actualMulByPResult.zero();
    assertTrue(zeroResult instanceof BN128Fp2);
    assertTrue(actualMulByPResult.toEthNotation() instanceof BN128G2);
    assertFalse(actualMulByPResult.isValid());
    assertFalse(actualMulByPResult.isZero());
    Fp2 expectedXResult = actualMulByPResult.x;
    assertSame(expectedXResult, actualMulByPResult.x());
    Fp2 expectedYResult = actualMulByPResult.y;
    assertSame(expectedYResult, actualMulByPResult.y());
    assertSame(actualMulByPResult.ZERO, zeroResult);
  }
}
