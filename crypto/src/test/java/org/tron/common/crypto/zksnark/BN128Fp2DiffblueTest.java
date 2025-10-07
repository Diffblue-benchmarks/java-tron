package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BN128Fp2DiffblueTest {
  /**
   * Test {@link BN128Fp2#BN128Fp2(Fp2, Fp2, Fp2)}.
   *
   * <p>Method under test: {@link BN128Fp2#BN128Fp2(Fp2, Fp2, Fp2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BN128Fp2.<init>(Fp2, Fp2, Fp2)"})
  public void testNewBN128Fp2() {
    // Arrange and Act
    BN128Fp2 actualBn128Fp2 = new BN128Fp2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Assert
    BN128<Fp2> toAffineResult = actualBn128Fp2.toAffine();
    Fp2 yResult = toAffineResult.y();
    Fp fp = yResult.a;
    BigInteger bigInteger = fp.v;
    assertEquals(
        "12903776731702987355887083934295038437179086470483131023036785576200725266333",
        bigInteger.toString());
    Fp2 xResult = toAffineResult.x();
    Fp fp2 = xResult.b;
    BigInteger bigInteger2 = fp2.v;
    assertEquals(
        "14681138511599513868579906292550611339979233093309515871315818100066920017952",
        bigInteger2.toString());
    Fp2 bResult = actualBn128Fp2.b();
    Fp fp3 = bResult.a;
    BigInteger bigInteger3 = fp3.v;
    assertEquals(
        "19485874751759354771024239261021720505790618469301721065564631296452457478373",
        bigInteger3.toString());
    Fp fp4 = xResult.a;
    BigInteger bigInteger4 = fp4.v;
    assertEquals(
        "21087453498479301738505683583845423561061080261299122796980902361914303298513",
        bigInteger4.toString());
    Fp fp5 = bResult.b;
    BigInteger bigInteger5 = fp5.v;
    assertEquals(
        "266929791119991161246907387137283842545076965332900288569378510910307636690",
        bigInteger5.toString());
    Fp fp6 = yResult.b;
    BigInteger bigInteger6 = fp6.v;
    assertEquals(
        "7493565599490483575492448843780822018765453343857761759594016245311319264152",
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
    Fp2 fp23 = actualBn128Fp2.x;
    assertFalse(fp23.isZero());
    Fp2 fp24 = actualBn128Fp2.y;
    assertFalse(fp24.isZero());
    Fp2 fp25 = actualBn128Fp2.z;
    assertFalse(fp25.isZero());
    assertTrue(fp23.isValid());
    assertTrue(fp24.isValid());
    assertTrue(fp25.isValid());
    assertArrayEquals(
        new byte[] {
          0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O', -96,
          -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46
        },
        bigInteger5.toByteArray());
    assertArrayEquals(
        new byte[] {
          0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O', -96,
          -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46
        },
        fp5.bytes());
    assertArrayEquals(
        new byte[] {
          16,
          -111,
          '5',
          '4',
          31,
          'A',
          -52,
          'u',
          ';',
          '7',
          -89,
          -57,
          -20,
          -122,
          -8,
          -113,
          -124,
          -88,
          -90,
          -60,
          -67,
          -52,
          Byte.MAX_VALUE,
          '#',
          -113,
          'h',
          '1',
          '-',
          -67,
          -37,
          'K',
          -104
        },
        bigInteger6.toByteArray());
    assertArrayEquals(
        new byte[] {
          16,
          -111,
          '5',
          '4',
          31,
          'A',
          -52,
          'u',
          ';',
          '7',
          -89,
          -57,
          -20,
          -122,
          -8,
          -113,
          -124,
          -88,
          -90,
          -60,
          -67,
          -52,
          Byte.MAX_VALUE,
          '#',
          -113,
          'h',
          '1',
          '-',
          -67,
          -37,
          'K',
          -104
        },
        fp6.bytes());
    assertArrayEquals(
        new byte[] {
          28, -121, 'G', '`', '4', 11, 'p', 22, '(', -107, -87, 'z', -124, 'c', -37, -99, 14, -79,
          -33, 'V', -55, -43, '!', '6', -56, -82, -122, 15, -103, -86, -1, -99
        },
        bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          28, -121, 'G', '`', '4', 11, 'p', 22, '(', -107, -87, 'z', -124, 'c', -37, -99, 14, -79,
          -33, 'V', -55, -43, '!', '6', -56, -82, -122, 15, -103, -86, -1, -99
        },
        fp.bytes());
    assertArrayEquals(
        new byte[] {
          ' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14, 27,
          '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '
        },
        bigInteger2.toByteArray());
    assertArrayEquals(
        new byte[] {
          ' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14, 27,
          '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '
        },
        fp2.bytes());
    assertArrayEquals(
        new byte[] {
          '+', 20, -99, '@', -50, -72, -86, -82, -127, -66, 24, -103, 27, -32, 'j', -61, -75, -76,
          -59, -27, 'Y', -37, -17, -93, '2', 'g', -26, -36, '$', -95, '8', -27
        },
        bigInteger3.toByteArray());
    assertArrayEquals(
        new byte[] {
          '+', 20, -99, '@', -50, -72, -86, -82, -127, -66, 24, -103, 27, -32, 'j', -61, -75, -76,
          -59, -27, 'Y', -37, -17, -93, '2', 'g', -26, -36, '$', -95, '8', -27
        },
        fp3.bytes());
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
        bigInteger4.toByteArray());
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
        fp4.bytes());
  }

  /**
   * Test {@link BN128Fp2#BN128Fp2(BigInteger, BigInteger, BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BN128Fp2#BN128Fp2(BigInteger, BigInteger, BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BN128Fp2.<init>(BigInteger, BigInteger, BigInteger, BigInteger)"})
  public void testNewBN128Fp22() {
    // Arrange and Act
    BN128Fp2 actualBn128Fp2 =
        new BN128Fp2(
            BN128G2.FR_NEG_ONE, BN128G2.FR_NEG_ONE, BN128G2.FR_NEG_ONE, BN128G2.FR_NEG_ONE);

    // Assert
    assertTrue(actualBn128Fp2.toAffine() instanceof BN128Fp2);
    assertTrue(actualBn128Fp2.toEthNotation() instanceof BN128Fp2);
    BN128<Fp2> zeroResult = actualBn128Fp2.zero();
    assertTrue(zeroResult instanceof BN128Fp2);
    assertFalse(actualBn128Fp2.isValid());
    assertFalse(actualBn128Fp2.isZero());
    Fp2 fp2 = actualBn128Fp2.x;
    assertEquals(fp2, actualBn128Fp2.y);
    assertSame(fp2, actualBn128Fp2.x());
    Fp2 expectedYResult = actualBn128Fp2.y;
    assertSame(expectedYResult, actualBn128Fp2.y());
    Fp2 expectedOneResult = actualBn128Fp2.z;
    assertSame(expectedOneResult, actualBn128Fp2.one());
    assertSame(BN128Fp2.ZERO, zeroResult);
  }

  /**
   * Test {@link BN128Fp2#create(byte[], byte[], byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link BN128Fp2#create(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128Fp2.create(byte[], byte[], byte[], byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    BN128<Fp2> actualCreateResult =
        BN128Fp2.create(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128Fp2#create(byte[], byte[], byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link BN128Fp2#create(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128Fp2.create(byte[], byte[], byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange and Act
    BN128<Fp2> actualCreateResult =
        BN128Fp2.create(
            new byte[] {},
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128Fp2#create(byte[], byte[], byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link BN128Fp2#create(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128Fp2.create(byte[], byte[], byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte2() throws UnsupportedEncodingException {
    // Arrange and Act
    BN128<Fp2> actualCreateResult =
        BN128Fp2.create(
            new byte[] {},
            new byte[] {},
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128Fp2#zero()}.
   *
   * <p>Method under test: {@link BN128Fp2#zero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128Fp2.zero()"})
  public void testZero() {
    // Arrange
    BN128Fp2 bn128Fp2 = new BN128Fp2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    BN128<Fp2> actualZeroResult = bn128Fp2.zero();

    // Assert
    assertSame(((BN128Fp2) actualZeroResult).ZERO, actualZeroResult);
  }

  /**
   * Test {@link BN128Fp2#instance(Fp2, Fp2, Fp2)} with {@code Fp2}, {@code Fp2}, {@code Fp2}.
   *
   * <p>Method under test: {@link BN128Fp2#instance(Fp2, Fp2, Fp2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128Fp2.instance(Fp2, Fp2, Fp2)"})
  public void testInstanceWithFp2Fp2Fp2() {
    // Arrange
    BN128Fp2 bn128Fp2 = new BN128Fp2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    BN128<Fp2> actualInstanceResult =
        bn128Fp2.instance(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Assert
    assertTrue(actualInstanceResult.toAffine() instanceof BN128Fp2);
    assertTrue(actualInstanceResult.toEthNotation() instanceof BN128Fp2);
    BN128<Fp2> zeroResult = actualInstanceResult.zero();
    assertTrue(zeroResult instanceof BN128Fp2);
    assertTrue(actualInstanceResult instanceof BN128Fp2);
    assertFalse(actualInstanceResult.isValid());
    assertFalse(actualInstanceResult.isZero());
    Fp2 fp2 = actualInstanceResult.z;
    assertSame(fp2, actualInstanceResult.x());
    assertSame(fp2, actualInstanceResult.y());
    assertSame(((BN128Fp2) actualInstanceResult).ZERO, zeroResult);
    assertSame(Fp2._1, actualInstanceResult.one());
  }

  /**
   * Test {@link BN128Fp2#b()}.
   *
   * <p>Method under test: {@link BN128Fp2#b()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 BN128Fp2.b()"})
  public void testB() {
    // Arrange
    BN128Fp2 bn128Fp2 = new BN128Fp2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    Fp2 actualBResult = bn128Fp2.b();

    // Assert
    assertFalse(actualBResult.isZero());
    assertTrue(actualBResult.isValid());
    Fp2 fp2 = Fp2.NON_RESIDUE;
    assertSame(fp2, bn128Fp2.x());
    assertSame(fp2, bn128Fp2.y());
    assertSame(Fp2._1, bn128Fp2.one());
  }

  /**
   * Test {@link BN128Fp2#one()}.
   *
   * <p>Method under test: {@link BN128Fp2#one()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Fp2 BN128Fp2.one()"})
  public void testOne() {
    // Arrange
    BN128Fp2 bn128Fp2 = new BN128Fp2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    Fp2 actualOneResult = bn128Fp2.one();

    // Assert
    Fp2 fp2 = Fp2.NON_RESIDUE;
    assertSame(fp2, bn128Fp2.x());
    assertSame(fp2, bn128Fp2.y());
    assertSame(Fp2._1, actualOneResult);
  }
}
