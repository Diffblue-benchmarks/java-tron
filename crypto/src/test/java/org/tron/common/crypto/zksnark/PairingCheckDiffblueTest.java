package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.zksnark.PairingCheck.EllCoeffs;
import org.tron.common.crypto.zksnark.PairingCheck.Pair;
import org.tron.common.crypto.zksnark.PairingCheck.Precomputed;

public class PairingCheckDiffblueTest {
  /**
   * Test {@link PairingCheck#create()}.
   *
   * <p>Method under test: {@link PairingCheck#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PairingCheck PairingCheck.create()"})
  public void testCreate() {
    // Arrange and Act
    PairingCheck actualCreateResult = PairingCheck.create();

    // Assert
    Fp12 fp12 = actualCreateResult.product;
    assertNull(fp12.dbl());
    assertFalse(fp12.isZero());
    Fp6 fp6 = fp12.a;
    assertFalse(fp6.isZero());
    assertTrue(actualCreateResult.pairs.isEmpty());
    assertTrue(fp12.isValid());
    assertTrue(fp6.isValid());
    Fp6 fp62 = fp12.b;
    assertTrue(fp62.isValid());
    assertTrue(fp62.isZero());
  }

  /**
   * Test EllCoeffs {@link EllCoeffs#EllCoeffs(Fp2, Fp2, Fp2)}.
   *
   * <p>Method under test: {@link EllCoeffs#EllCoeffs(Fp2, Fp2, Fp2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EllCoeffs.<init>(Fp2, Fp2, Fp2)"})
  public void testEllCoeffsNewEllCoeffs() {
    // Arrange and Act
    EllCoeffs actualEllCoeffs = new EllCoeffs(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Assert
    Fp2 fp2 = actualEllCoeffs.ell0;
    assertFalse(fp2.isZero());
    Fp2 fp22 = actualEllCoeffs.ellVV;
    assertFalse(fp22.isZero());
    Fp2 fp23 = actualEllCoeffs.ellVW;
    assertFalse(fp23.isZero());
    assertTrue(fp2.isValid());
    assertTrue(fp22.isValid());
    assertTrue(fp23.isValid());
  }

  /**
   * Test Pair {@link Pair#millerLoop()}.
   *
   * <p>Method under test: {@link Pair#millerLoop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp12 Pair.millerLoop()"})
  public void testPairMillerLoop() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);
    BN128G1 g1 = new BN128G1(p);
    BN128G2 g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.ZERO);

    // Act
    Fp12 actualMillerLoopResult = Pair.of(g1, g2).millerLoop();

    // Assert
    Fp2 fp2 = g2.z;
    Fp6 fp6 = actualMillerLoopResult.b;
    assertSame(fp2, fp6.a);
    Fp6 fp62 = actualMillerLoopResult.a;
    assertSame(fp2, fp62.b);
    assertSame(fp2, fp6.b);
    assertSame(fp2, fp62.c);
    assertSame(fp2, fp6.c);
    Fp2 fp22 = fp62.a;
    Fp fp = fp22.b;
    assertArrayEquals(new byte[] {0}, fp.v.toByteArray());
    assertArrayEquals(new byte[] {0}, fp.bytes());
    Fp fp3 = fp22.a;
    assertArrayEquals(new byte[] {1}, fp3.v.toByteArray());
    assertArrayEquals(new byte[] {1}, fp3.bytes());
  }

  /**
   * Test Pair {@link Pair#millerLoop()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@link Fp12#a} {@link Fp6#b} {@link Fp2#a} is {@link BN128G1#BN128G1(BN128)}
   *       with p is {@link BN128Fp#ZERO} {@link BN128#z}.
   * </ul>
   *
   * <p>Method under test: {@link Pair#millerLoop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp12 Pair.millerLoop()"})
  public void testPairMillerLoop_givenBn128g1WithPIsZero_thenReturnABAIsBn128g1WithPIsZeroZ() {
    // Arrange
    BN128G1 g1 = new BN128G1(BN128Fp.ZERO);
    BN128G2 g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act and Assert
    Fp fp = g1.z;
    Fp6 fp6 = Pair.of(g1, g2).millerLoop().a;
    Fp2 fp2 = fp6.b;
    assertSame(fp, fp2.a);
    Fp2 fp22 = fp6.a;
    Fp fp3 = fp22.b;
    assertSame(fp, fp3);
    assertSame(fp, fp2.b);
    assertArrayEquals(new byte[] {0}, fp3.bytes());
    assertArrayEquals(new byte[] {1}, fp22.a.bytes());
  }

  /**
   * Test Pair {@link Pair#Pair(BN128G1, BN128G2)}.
   *
   * <p>Method under test: {@link Pair#Pair(BN128G1, BN128G2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Pair.<init>(BN128G1, BN128G2)"})
  public void testPairNewPair() {
    // Arrange
    BN128G1 g1 = new BN128G1(BN128Fp.ZERO);
    BN128G2 g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    Pair actualPair = new Pair(g1, g2);

    // Assert
    BN128G2 bn128g2 = actualPair.g2;
    BN128G2 toAffineResult = bn128g2.toAffine();
    BN128G2 toAffineResult2 = toAffineResult.toAffine();
    BN128G2 toAffineResult3 = toAffineResult2.toAffine();
    BN128G2 toAffineResult4 = toAffineResult3.toAffine();
    BN128G2 toAffineResult5 = toAffineResult4.toAffine();
    BN128G2 toAffineResult6 = toAffineResult5.toAffine();
    BN128G2 toAffineResult7 = toAffineResult6.toAffine();
    assertTrue(toAffineResult7.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult6.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult5.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult4.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult3.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult2.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult.toEthNotation() instanceof BN128G2);
    BN128<Fp2> toEthNotationResult = bn128g2.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128G2);
    BN128G1 bn128g1 = actualPair.g1;
    Fp oneResult = bn128g1.one();
    BigInteger bigInteger = oneResult.v;
    assertEquals("1", bigInteger.toString());
    Fp2 yResult = toAffineResult.y();
    Fp fp = yResult.a;
    BigInteger bigInteger2 = fp.v;
    assertEquals(
        "12903776731702987355887083934295038437179086470483131023036785576200725266333",
        bigInteger2.toString());
    Fp2 xResult = toAffineResult.x();
    Fp fp2 = xResult.b;
    BigInteger bigInteger3 = fp2.v;
    assertEquals(
        "14681138511599513868579906292550611339979233093309515871315818100066920017952",
        bigInteger3.toString());
    Fp2 bResult = bn128g2.b();
    Fp fp3 = bResult.a;
    BigInteger bigInteger4 = fp3.v;
    assertEquals(
        "19485874751759354771024239261021720505790618469301721065564631296452457478373",
        bigInteger4.toString());
    Fp fp4 = xResult.a;
    BigInteger bigInteger5 = fp4.v;
    assertEquals(
        "21087453498479301738505683583845423561061080261299122796980902361914303298513",
        bigInteger5.toString());
    Fp fp5 = bResult.b;
    BigInteger bigInteger6 = fp5.v;
    assertEquals(
        "266929791119991161246907387137283842545076965332900288569378510910307636690",
        bigInteger6.toString());
    Fp bResult2 = bn128g1.b();
    BigInteger bigInteger7 = bResult2.v;
    assertEquals("3", bigInteger7.toString());
    Fp fp6 = yResult.b;
    BigInteger bigInteger8 = fp6.v;
    assertEquals(
        "7493565599490483575492448843780822018765453343857761759594016245311319264152",
        bigInteger8.toString());
    assertEquals(0, bigInteger7.getLowestSetBit());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger5.getLowestSetBit());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(0, bigInteger4.getLowestSetBit());
    assertEquals(1, bigInteger6.getLowestSetBit());
    assertEquals(1, bigInteger7.signum());
    assertEquals(1, bigInteger.signum());
    assertEquals(1, bigInteger5.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger4.signum());
    assertEquals(1, bigInteger3.signum());
    assertEquals(1, bigInteger8.signum());
    assertEquals(1, bigInteger6.signum());
    assertEquals(3, bigInteger8.getLowestSetBit());
    assertEquals(5, bigInteger3.getLowestSetBit());
    assertFalse(toAffineResult7.isValid());
    assertFalse(toAffineResult6.isValid());
    assertFalse(toAffineResult5.isValid());
    assertFalse(toAffineResult4.isValid());
    assertFalse(toAffineResult3.isValid());
    assertFalse(toAffineResult2.isValid());
    assertFalse(toAffineResult.isValid());
    assertFalse(bn128g2.isValid());
    assertFalse(toAffineResult7.isZero());
    assertFalse(toAffineResult6.isZero());
    assertFalse(toAffineResult5.isZero());
    assertFalse(toAffineResult4.isZero());
    assertFalse(toAffineResult3.isZero());
    assertFalse(toAffineResult2.isZero());
    assertFalse(toAffineResult.isZero());
    assertFalse(bn128g2.isZero());
    assertFalse(xResult.isZero());
    assertFalse(yResult.isZero());
    assertFalse(bResult.isZero());
    Fp2 oneResult2 = bn128g2.one();
    assertFalse(oneResult2.isZero());
    BN128G1 toAffineResult8 = bn128g1.toAffine();
    BN128G1 toAffineResult9 = toAffineResult8.toAffine();
    BN128G1 toAffineResult10 = toAffineResult9.toAffine();
    BN128G1 toAffineResult11 = toAffineResult10.toAffine();
    BN128G1 toAffineResult12 = toAffineResult11.toAffine();
    BN128G1 toAffineResult13 = toAffineResult12.toAffine();
    BN128G1 toAffineResult14 = toAffineResult13.toAffine();
    assertTrue(toAffineResult14.isValid());
    assertTrue(toAffineResult13.isValid());
    assertTrue(toAffineResult12.isValid());
    assertTrue(toAffineResult11.isValid());
    assertTrue(toAffineResult10.isValid());
    assertTrue(toAffineResult9.isValid());
    assertTrue(toAffineResult8.isValid());
    assertTrue(bn128g1.isValid());
    assertTrue(toAffineResult14.isZero());
    assertTrue(toAffineResult13.isZero());
    assertTrue(toAffineResult12.isZero());
    assertTrue(toAffineResult11.isZero());
    assertTrue(toAffineResult10.isZero());
    assertTrue(toAffineResult9.isZero());
    assertTrue(toAffineResult8.isZero());
    assertTrue(bn128g1.isZero());
    assertTrue(xResult.isValid());
    assertTrue(yResult.isValid());
    assertTrue(bResult.isValid());
    assertTrue(oneResult2.isValid());
    Fp2 expectedFp2 = toEthNotationResult.x();
    assertSame(expectedFp2, ((BN128G2) toEthNotationResult).x);
    assertSame(toEthNotationResult.y(), ((BN128G2) toEthNotationResult).y);
    BN128<Fp> bn128 = BN128Fp.ZERO;
    assertSame(bn128, toAffineResult14.toEthNotation());
    assertSame(bn128, toAffineResult13.toEthNotation());
    assertSame(bn128, toAffineResult12.toEthNotation());
    assertSame(bn128, toAffineResult11.toEthNotation());
    assertSame(bn128, toAffineResult10.toEthNotation());
    assertSame(bn128, toAffineResult9.toEthNotation());
    assertSame(bn128, toAffineResult8.toEthNotation());
    assertSame(bn128, bn128g1.toEthNotation());
    assertSame(bn128, toAffineResult14.zero());
    assertSame(bn128, toAffineResult13.zero());
    assertSame(bn128, toAffineResult12.zero());
    assertSame(bn128, toAffineResult11.zero());
    assertSame(bn128, toAffineResult10.zero());
    assertSame(bn128, toAffineResult9.zero());
    assertSame(bn128, toAffineResult8.zero());
    assertSame(bn128, bn128g1.zero());
    BN128<Fp2> bn1282 = BN128Fp2.ZERO;
    assertSame(bn1282, toAffineResult7.zero());
    assertSame(bn1282, toAffineResult6.zero());
    assertSame(bn1282, toAffineResult5.zero());
    assertSame(bn1282, toAffineResult4.zero());
    assertSame(bn1282, toAffineResult3.zero());
    assertSame(bn1282, toAffineResult2.zero());
    assertSame(bn1282, toAffineResult.zero());
    assertSame(bn1282, bn128g2.zero());
    assertArrayEquals(new byte[] {1}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {1}, oneResult.bytes());
    assertArrayEquals(new byte[] {3}, bigInteger7.toByteArray());
    assertArrayEquals(new byte[] {3}, bResult2.bytes());
    assertArrayEquals(
        new byte[] {
          0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O', -96,
          -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46
        },
        bigInteger6.toByteArray());
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
        bigInteger8.toByteArray());
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
        bigInteger2.toByteArray());
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
        bigInteger3.toByteArray());
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
        bigInteger4.toByteArray());
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
        bigInteger5.toByteArray());
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
   * Test Pair {@link Pair#of(BN128G1, BN128G2)}.
   *
   * <p>Method under test: {@link Pair#of(BN128G1, BN128G2)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Pair.of(BN128G1, BN128G2)"})
  public void testPairOf() {
    // Arrange
    BN128G1 g1 = new BN128G1(BN128Fp.ZERO);
    BN128G2 g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    Pair actualOfResult = Pair.of(g1, g2);

    // Assert
    BN128G1 bn128g1 = actualOfResult.g1;
    BN128<Fp> toEthNotationResult = bn128g1.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128Fp);
    BN128G2 bn128g2 = actualOfResult.g2;
    BN128<Fp2> zeroResult = bn128g2.zero();
    assertTrue(zeroResult instanceof BN128Fp2);
    assertTrue(bn128g2.toEthNotation() instanceof BN128G2);
    assertFalse(bn128g2.isValid());
    assertFalse(bn128g2.isZero());
    assertTrue(bn128g1.isValid());
    assertTrue(bn128g1.isZero());
    Fp fp = g1.z;
    assertSame(fp, bn128g1.x());
    assertSame(fp, bn128g1.y());
    assertSame(fp, bn128g1.x);
    assertSame(fp, bn128g1.y);
    assertSame(fp, bn128g1.z);
    Fp2 fp2 = g2.z;
    assertSame(fp2, bn128g2.x());
    assertSame(fp2, bn128g2.y());
    assertSame(fp2, bn128g2.x);
    assertSame(fp2, bn128g2.y);
    assertSame(fp2, bn128g2.z);
    BN128<Fp> bn128 = BN128Fp.ZERO;
    assertSame(bn128, toEthNotationResult);
    assertSame(bn128, bn128g1.zero());
    assertSame(BN128Fp2.ZERO, zeroResult);
  }

  /**
   * Test Precomputed {@link Precomputed#Precomputed(BN128G2, EllCoeffs)}.
   *
   * <p>Method under test: {@link Precomputed#Precomputed(BN128G2, EllCoeffs)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Precomputed.<init>(BN128G2, EllCoeffs)"})
  public void testPrecomputedNewPrecomputed() {
    // Arrange
    BN128G2 g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);
    EllCoeffs coeffs = new EllCoeffs(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    Precomputed actualPrecomputed = new Precomputed(g2, coeffs);

    // Assert
    BN128G2 bn128g2 = actualPrecomputed.g2;
    BN128G2 toAffineResult = bn128g2.toAffine();
    BN128G2 toAffineResult2 = toAffineResult.toAffine();
    BN128G2 toAffineResult3 = toAffineResult2.toAffine();
    BN128G2 toAffineResult4 = toAffineResult3.toAffine();
    BN128G2 toAffineResult5 = toAffineResult4.toAffine();
    BN128G2 toAffineResult6 = toAffineResult5.toAffine();
    BN128G2 toAffineResult7 = toAffineResult6.toAffine();
    assertTrue(toAffineResult7.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult6.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult5.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult4.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult3.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult2.toEthNotation() instanceof BN128G2);
    assertTrue(toAffineResult.toEthNotation() instanceof BN128G2);
    BN128<Fp2> toEthNotationResult = bn128g2.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128G2);
    Fp2 oneResult = bn128g2.one();
    Fp fp = oneResult.b;
    BigInteger bigInteger = fp.v;
    assertEquals("0", bigInteger.toString());
    Fp2 yResult = toAffineResult.y();
    Fp fp2 = yResult.a;
    BigInteger bigInteger2 = fp2.v;
    assertEquals(
        "12903776731702987355887083934295038437179086470483131023036785576200725266333",
        bigInteger2.toString());
    Fp2 xResult = toAffineResult.x();
    Fp fp3 = xResult.b;
    BigInteger bigInteger3 = fp3.v;
    assertEquals(
        "14681138511599513868579906292550611339979233093309515871315818100066920017952",
        bigInteger3.toString());
    Fp2 bResult = bn128g2.b();
    Fp fp4 = bResult.a;
    BigInteger bigInteger4 = fp4.v;
    assertEquals(
        "19485874751759354771024239261021720505790618469301721065564631296452457478373",
        bigInteger4.toString());
    Fp fp5 = xResult.a;
    BigInteger bigInteger5 = fp5.v;
    assertEquals(
        "21087453498479301738505683583845423561061080261299122796980902361914303298513",
        bigInteger5.toString());
    Fp fp6 = bResult.b;
    BigInteger bigInteger6 = fp6.v;
    assertEquals(
        "266929791119991161246907387137283842545076965332900288569378510910307636690",
        bigInteger6.toString());
    Fp fp7 = yResult.b;
    BigInteger bigInteger7 = fp7.v;
    assertEquals(
        "7493565599490483575492448843780822018765453343857761759594016245311319264152",
        bigInteger7.toString());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger5.getLowestSetBit());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(0, bigInteger4.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    assertEquals(1, bigInteger6.getLowestSetBit());
    assertEquals(1, bigInteger5.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger4.signum());
    assertEquals(1, bigInteger3.signum());
    assertEquals(1, bigInteger7.signum());
    assertEquals(1, bigInteger6.signum());
    assertEquals(3, bigInteger7.getLowestSetBit());
    assertEquals(5, bigInteger3.getLowestSetBit());
    assertFalse(toAffineResult7.isValid());
    assertFalse(toAffineResult6.isValid());
    assertFalse(toAffineResult5.isValid());
    assertFalse(toAffineResult4.isValid());
    assertFalse(toAffineResult3.isValid());
    assertFalse(toAffineResult2.isValid());
    assertFalse(toAffineResult.isValid());
    assertFalse(bn128g2.isValid());
    assertFalse(toAffineResult7.isZero());
    assertFalse(toAffineResult6.isZero());
    assertFalse(toAffineResult5.isZero());
    assertFalse(toAffineResult4.isZero());
    assertFalse(toAffineResult3.isZero());
    assertFalse(toAffineResult2.isZero());
    assertFalse(toAffineResult.isZero());
    assertFalse(bn128g2.isZero());
    assertFalse(xResult.isZero());
    assertFalse(yResult.isZero());
    assertFalse(bResult.isZero());
    assertFalse(oneResult.isZero());
    assertTrue(xResult.isValid());
    assertTrue(yResult.isValid());
    assertTrue(bResult.isValid());
    assertTrue(oneResult.isValid());
    Fp2 expectedFp2 = toEthNotationResult.x();
    assertSame(expectedFp2, ((BN128G2) toEthNotationResult).x);
    assertSame(toEthNotationResult.y(), ((BN128G2) toEthNotationResult).y);
    BN128<Fp2> bn128 = BN128Fp2.ZERO;
    assertSame(bn128, toAffineResult7.zero());
    assertSame(bn128, toAffineResult6.zero());
    assertSame(bn128, toAffineResult5.zero());
    assertSame(bn128, toAffineResult4.zero());
    assertSame(bn128, toAffineResult3.zero());
    assertSame(bn128, toAffineResult2.zero());
    assertSame(bn128, toAffineResult.zero());
    assertSame(bn128, bn128g2.zero());
    assertArrayEquals(new byte[] {0}, bigInteger.toByteArray());
    assertArrayEquals(new byte[] {0}, fp.bytes());
    assertArrayEquals(
        new byte[] {
          0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O', -96,
          -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46
        },
        bigInteger6.toByteArray());
    assertArrayEquals(
        new byte[] {
          0, -105, 19, -80, ':', -16, -2, -44, -51, ',', -81, -83, -18, -40, -3, -12, -89, 'O', -96,
          -124, -27, '-', 24, 'R', -28, -94, -67, 6, -123, -61, 21, -46
        },
        fp6.bytes());
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
        bigInteger7.toByteArray());
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
        fp7.bytes());
    assertArrayEquals(
        new byte[] {
          28, -121, 'G', '`', '4', 11, 'p', 22, '(', -107, -87, 'z', -124, 'c', -37, -99, 14, -79,
          -33, 'V', -55, -43, '!', '6', -56, -82, -122, 15, -103, -86, -1, -99
        },
        bigInteger2.toByteArray());
    assertArrayEquals(
        new byte[] {
          28, -121, 'G', '`', '4', 11, 'p', 22, '(', -107, -87, 'z', -124, 'c', -37, -99, 14, -79,
          -33, 'V', -55, -43, '!', '6', -56, -82, -122, 15, -103, -86, -1, -99
        },
        fp2.bytes());
    assertArrayEquals(
        new byte[] {
          ' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14, 27,
          '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '
        },
        bigInteger3.toByteArray());
    assertArrayEquals(
        new byte[] {
          ' ', 'u', ':', -36, -87, -58, -65, -72, 20, -103, -66, '^', 'P', -98, -113, -113, -14, 27,
          '|', -115, '<', -80, '9', -49, 30, -10, -100, 'f', -68, -23, -80, ' '
        },
        fp3.bytes());
    assertArrayEquals(
        new byte[] {
          '+', 20, -99, '@', -50, -72, -86, -82, -127, -66, 24, -103, 27, -32, 'j', -61, -75, -76,
          -59, -27, 'Y', -37, -17, -93, '2', 'g', -26, -36, '$', -95, '8', -27
        },
        bigInteger4.toByteArray());
    assertArrayEquals(
        new byte[] {
          '+', 20, -99, '@', -50, -72, -86, -82, -127, -66, 24, -103, 27, -32, 'j', -61, -75, -76,
          -59, -27, 'Y', -37, -17, -93, '2', 'g', -26, -36, '$', -95, '8', -27
        },
        fp4.bytes());
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
        bigInteger5.toByteArray());
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
        fp5.bytes());
  }

  /**
   * Test Precomputed {@link Precomputed#of(BN128G2, EllCoeffs)}.
   *
   * <p>Method under test: {@link Precomputed#of(BN128G2, EllCoeffs)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Precomputed Precomputed.of(BN128G2, EllCoeffs)"})
  public void testPrecomputedOf() {
    // Arrange
    BN128G2 g2 = new BN128G2(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);
    EllCoeffs coeffs = new EllCoeffs(Fp2.NON_RESIDUE, Fp2.NON_RESIDUE, Fp2.NON_RESIDUE);

    // Act
    Precomputed actualOfResult = Precomputed.of(g2, coeffs);

    // Assert
    BN128G2 bn128g2 = actualOfResult.g2;
    BN128<Fp2> zeroResult = bn128g2.zero();
    assertTrue(zeroResult instanceof BN128Fp2);
    assertTrue(bn128g2.toEthNotation() instanceof BN128G2);
    assertFalse(bn128g2.isValid());
    assertFalse(bn128g2.isZero());
    Fp2 fp2 = coeffs.ellVW;
    assertSame(fp2, bn128g2.x());
    assertSame(fp2, bn128g2.y());
    assertSame(fp2, bn128g2.x);
    assertSame(fp2, bn128g2.y);
    assertSame(fp2, bn128g2.z);
    EllCoeffs ellCoeffs = actualOfResult.coeffs;
    assertSame(fp2, ellCoeffs.ell0);
    assertSame(fp2, ellCoeffs.ellVV);
    assertSame(fp2, ellCoeffs.ellVW);
    assertSame(BN128Fp2.ZERO, zeroResult);
  }

  /**
   * Test {@link PairingCheck#result()}.
   *
   * <p>Method under test: {@link PairingCheck#result()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PairingCheck.result()"})
  public void testResult() {
    // Arrange, Act and Assert
    assertEquals(1, PairingCheck.create().result());
  }
}
