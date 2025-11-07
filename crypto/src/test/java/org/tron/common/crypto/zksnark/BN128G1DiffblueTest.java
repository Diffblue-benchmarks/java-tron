package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;

public class BN128G1DiffblueTest {
  /**
   * Method under test: {@link BN128G1#create(byte[], byte[])}
   */
  @Test
  public void testCreate() throws UnsupportedEncodingException {
    // Arrange
    byte[] x = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(BN128G1.create(x, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link BN128G1#create(byte[], byte[])}
   */
  @Test
  public void testCreate2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(BN128G1.create(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link BN128G1#create(byte[], byte[])}
   */
  @Test
  public void testCreate3() {
    // Arrange and Act
    BN128G1 actualCreateResult = BN128G1.create(new byte[]{}, new byte[]{});

    // Assert
    Fp oneResult = actualCreateResult.one();
    BigInteger bigInteger = oneResult.v;
    assertEquals("1", bigInteger.toString());
    Fp bResult = actualCreateResult.b();
    BigInteger bigInteger2 = bResult.v;
    assertEquals("3", bigInteger2.toString());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    BN128G1 toAffineResult = actualCreateResult.toAffine();
    BN128G1 toAffineResult2 = toAffineResult.toAffine();
    BN128G1 toAffineResult3 = toAffineResult2.toAffine();
    BN128G1 toAffineResult4 = toAffineResult3.toAffine();
    BN128G1 toAffineResult5 = toAffineResult4.toAffine();
    BN128G1 toAffineResult6 = toAffineResult5.toAffine();
    BN128G1 toAffineResult7 = toAffineResult6.toAffine();
    BN128G1 toAffineResult8 = toAffineResult7.toAffine();
    assertTrue(toAffineResult8.isValid());
    assertTrue(toAffineResult7.isValid());
    assertTrue(toAffineResult6.isValid());
    assertTrue(toAffineResult5.isValid());
    assertTrue(toAffineResult4.isValid());
    assertTrue(toAffineResult3.isValid());
    assertTrue(toAffineResult2.isValid());
    assertTrue(toAffineResult.isValid());
    assertTrue(actualCreateResult.isValid());
    assertTrue(toAffineResult8.isZero());
    assertTrue(toAffineResult7.isZero());
    assertTrue(toAffineResult6.isZero());
    assertTrue(toAffineResult5.isZero());
    assertTrue(toAffineResult4.isZero());
    assertTrue(toAffineResult3.isZero());
    assertTrue(toAffineResult2.isZero());
    assertTrue(toAffineResult.isZero());
    assertTrue(actualCreateResult.isZero());
    assertSame(bResult, toAffineResult8.b());
    assertSame(bResult, toAffineResult7.b());
    assertSame(bResult, toAffineResult6.b());
    assertSame(bResult, toAffineResult5.b());
    assertSame(bResult, toAffineResult4.b());
    assertSame(bResult, toAffineResult3.b());
    assertSame(bResult, toAffineResult2.b());
    assertSame(bResult, toAffineResult.b());
    assertSame(oneResult, toAffineResult8.y());
    assertSame(oneResult, toAffineResult7.y());
    assertSame(oneResult, toAffineResult6.y());
    assertSame(oneResult, toAffineResult5.y());
    assertSame(oneResult, toAffineResult4.y());
    assertSame(oneResult, toAffineResult3.y());
    assertSame(oneResult, toAffineResult2.y());
    assertSame(oneResult, toAffineResult.y());
    assertSame(oneResult, toAffineResult8.one());
    assertSame(oneResult, toAffineResult7.one());
    assertSame(oneResult, toAffineResult6.one());
    assertSame(oneResult, toAffineResult5.one());
    assertSame(oneResult, toAffineResult4.one());
    assertSame(oneResult, toAffineResult3.one());
    assertSame(oneResult, toAffineResult2.one());
    assertSame(oneResult, toAffineResult.one());
    BN128G1 toAffineResult9 = toAffineResult8.toAffine();
    assertSame(oneResult, toAffineResult9.y);
    assertSame(oneResult, toAffineResult8.y);
    assertSame(oneResult, toAffineResult7.y);
    assertSame(oneResult, toAffineResult6.y);
    assertSame(oneResult, toAffineResult5.y);
    assertSame(oneResult, toAffineResult4.y);
    assertSame(oneResult, toAffineResult3.y);
    assertSame(oneResult, toAffineResult2.y);
    assertSame(oneResult, toAffineResult.y);
    Fp fp = actualCreateResult.z;
    assertSame(fp, toAffineResult8.x());
    assertSame(fp, toAffineResult7.x());
    assertSame(fp, toAffineResult6.x());
    assertSame(fp, toAffineResult5.x());
    assertSame(fp, toAffineResult4.x());
    assertSame(fp, toAffineResult3.x());
    assertSame(fp, toAffineResult2.x());
    assertSame(fp, toAffineResult.x());
    assertSame(fp, actualCreateResult.x());
    assertSame(fp, actualCreateResult.y());
    assertSame(fp, toAffineResult9.x);
    assertSame(fp, toAffineResult8.x);
    assertSame(fp, toAffineResult7.x);
    assertSame(fp, toAffineResult6.x);
    assertSame(fp, toAffineResult5.x);
    assertSame(fp, toAffineResult4.x);
    assertSame(fp, toAffineResult3.x);
    assertSame(fp, toAffineResult2.x);
    assertSame(fp, toAffineResult.x);
    assertSame(fp, toAffineResult9.z);
    assertSame(fp, toAffineResult8.z);
    assertSame(fp, toAffineResult7.z);
    assertSame(fp, toAffineResult6.z);
    assertSame(fp, toAffineResult5.z);
    assertSame(fp, toAffineResult4.z);
    assertSame(fp, toAffineResult3.z);
    assertSame(fp, toAffineResult2.z);
    assertSame(fp, toAffineResult.z);
    BN128<Fp> bn128 = actualCreateResult.ZERO;
    assertSame(bn128, toAffineResult8.toEthNotation());
    assertSame(bn128, toAffineResult7.toEthNotation());
    assertSame(bn128, toAffineResult6.toEthNotation());
    assertSame(bn128, toAffineResult5.toEthNotation());
    assertSame(bn128, toAffineResult4.toEthNotation());
    assertSame(bn128, toAffineResult3.toEthNotation());
    assertSame(bn128, toAffineResult2.toEthNotation());
    assertSame(bn128, toAffineResult.toEthNotation());
    assertSame(bn128, actualCreateResult.toEthNotation());
    assertSame(bn128, toAffineResult8.zero());
    assertSame(bn128, toAffineResult7.zero());
    assertSame(bn128, toAffineResult6.zero());
    assertSame(bn128, toAffineResult5.zero());
    assertSame(bn128, toAffineResult4.zero());
    assertSame(bn128, toAffineResult3.zero());
    assertSame(bn128, toAffineResult2.zero());
    assertSame(bn128, toAffineResult.zero());
    assertSame(bn128, actualCreateResult.zero());
    assertArrayEquals(new byte[]{0}, actualCreateResult.x.bytes());
    assertArrayEquals(new byte[]{0}, actualCreateResult.y.bytes());
    assertArrayEquals(new byte[]{0}, actualCreateResult.z.bytes());
    assertArrayEquals(new byte[]{1}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{1}, oneResult.bytes());
    assertArrayEquals(new byte[]{3}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{3}, bResult.bytes());
  }

  /**
   * Method under test: {@link BN128G1#toAffine()}
   */
  @Test
  public void testToAffine() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    BN128G1 actualToAffineResult = bn128g1.toAffine();

    // Assert
    Fp bResult = actualToAffineResult.b();
    BigInteger bigInteger = bResult.v;
    assertEquals("3", bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertTrue(actualToAffineResult.isValid());
    assertTrue(actualToAffineResult.isZero());
    Fp fp = actualToAffineResult.y;
    assertSame(fp, actualToAffineResult.y());
    assertSame(fp, bn128g1.one());
    assertSame(fp, actualToAffineResult.one());
    Fp fp2 = actualToAffineResult.z;
    assertSame(fp2, bn128g1.x());
    assertSame(fp2, actualToAffineResult.x());
    assertSame(fp2, bn128g1.y());
    BN128<Fp> bn128 = actualToAffineResult.ZERO;
    assertSame(bn128, bn128g1.toEthNotation());
    assertSame(bn128, actualToAffineResult.toEthNotation());
    assertSame(bn128, bn128g1.zero());
    assertSame(bn128, actualToAffineResult.zero());
    assertArrayEquals(new byte[]{0}, actualToAffineResult.x.bytes());
    assertArrayEquals(new byte[]{0}, actualToAffineResult.z.bytes());
    assertArrayEquals(new byte[]{1}, actualToAffineResult.y.bytes());
    assertArrayEquals(new byte[]{3}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{3}, bResult.bytes());
  }

  /**
   * Method under test: {@link BN128G1#toAffine()}
   */
  @Test
  public void testToAffine2() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE));

    // Act
    BN128G1 actualToAffineResult = bn128g1.toAffine();

    // Assert
    BN128<Fp> toEthNotationResult = bn128g1.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128G1);
    BN128<Fp> toEthNotationResult2 = toEthNotationResult.toEthNotation();
    assertTrue(toEthNotationResult2 instanceof BN128G1);
    BN128<Fp> toEthNotationResult3 = toEthNotationResult2.toEthNotation();
    assertTrue(toEthNotationResult3 instanceof BN128G1);
    BN128<Fp> toEthNotationResult4 = toEthNotationResult3.toEthNotation();
    assertTrue(toEthNotationResult4 instanceof BN128G1);
    BN128<Fp> toEthNotationResult5 = toEthNotationResult4.toEthNotation();
    assertTrue(toEthNotationResult5 instanceof BN128G1);
    BN128<Fp> toEthNotationResult6 = toEthNotationResult5.toEthNotation();
    assertTrue(toEthNotationResult6 instanceof BN128G1);
    BN128<Fp> toEthNotationResult7 = toEthNotationResult6.toEthNotation();
    assertTrue(toEthNotationResult7 instanceof BN128G1);
    BN128<Fp> toEthNotationResult8 = toEthNotationResult7.toEthNotation();
    assertTrue(toEthNotationResult8 instanceof BN128G1);
    BN128<Fp> toEthNotationResult9 = toEthNotationResult8.toEthNotation();
    assertTrue(toEthNotationResult9 instanceof BN128G1);
    BN128<Fp> toEthNotationResult10 = actualToAffineResult.toEthNotation();
    BN128<Fp> toEthNotationResult11 = toEthNotationResult10.toEthNotation();
    BN128<Fp> toEthNotationResult12 = toEthNotationResult11.toEthNotation();
    BN128<Fp> toEthNotationResult13 = toEthNotationResult12.toEthNotation();
    BN128<Fp> toEthNotationResult14 = toEthNotationResult13.toEthNotation();
    BN128<Fp> toEthNotationResult15 = toEthNotationResult14.toEthNotation();
    BN128<Fp> toEthNotationResult16 = toEthNotationResult15.toEthNotation();
    BN128<Fp> toEthNotationResult17 = toEthNotationResult16.toEthNotation();
    BN128<Fp> toEthNotationResult18 = toEthNotationResult17.toEthNotation();
    assertTrue(toEthNotationResult18 instanceof BN128G1);
    assertTrue(toEthNotationResult17 instanceof BN128G1);
    assertTrue(toEthNotationResult16 instanceof BN128G1);
    assertTrue(toEthNotationResult15 instanceof BN128G1);
    assertTrue(toEthNotationResult14 instanceof BN128G1);
    assertTrue(toEthNotationResult13 instanceof BN128G1);
    assertTrue(toEthNotationResult12 instanceof BN128G1);
    assertTrue(toEthNotationResult11 instanceof BN128G1);
    assertTrue(toEthNotationResult10 instanceof BN128G1);
    Fp bResult = actualToAffineResult.b();
    BigInteger bigInteger = bResult.v;
    assertEquals("3", bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertFalse(toEthNotationResult17.isValid());
    assertFalse(toEthNotationResult16.isValid());
    assertFalse(toEthNotationResult15.isValid());
    assertFalse(toEthNotationResult14.isValid());
    assertFalse(toEthNotationResult13.isValid());
    assertFalse(toEthNotationResult12.isValid());
    assertFalse(toEthNotationResult11.isValid());
    assertFalse(toEthNotationResult10.isValid());
    assertFalse(actualToAffineResult.isValid());
    assertFalse(toEthNotationResult17.isZero());
    assertFalse(toEthNotationResult16.isZero());
    assertFalse(toEthNotationResult15.isZero());
    assertFalse(toEthNotationResult14.isZero());
    assertFalse(toEthNotationResult13.isZero());
    assertFalse(toEthNotationResult12.isZero());
    assertFalse(toEthNotationResult11.isZero());
    assertFalse(toEthNotationResult10.isZero());
    assertFalse(actualToAffineResult.isZero());
    Fp fp = actualToAffineResult.y;
    assertEquals(fp, toEthNotationResult16.y());
    assertEquals(fp, toEthNotationResult15.y());
    assertEquals(fp, toEthNotationResult14.y());
    assertEquals(fp, toEthNotationResult13.y());
    assertEquals(fp, toEthNotationResult12.y());
    assertEquals(fp, toEthNotationResult11.y());
    Fp yResult = toEthNotationResult10.y();
    assertEquals(fp, yResult);
    assertEquals(fp, actualToAffineResult.z);
    Fp fp2 = bn128g1.z;
    assertEquals(fp2, toEthNotationResult16.x());
    assertEquals(fp2, toEthNotationResult15.x());
    assertEquals(fp2, toEthNotationResult14.x());
    assertEquals(fp2, toEthNotationResult13.x());
    assertEquals(fp2, toEthNotationResult12.x());
    assertEquals(fp2, toEthNotationResult11.x());
    Fp xResult = toEthNotationResult10.x();
    assertEquals(fp2, xResult);
    assertEquals(fp2, actualToAffineResult.x);
    assertSame(xResult, ((BN128G1) toEthNotationResult10).x);
    assertSame(yResult, ((BN128G1) toEthNotationResult10).y);
    assertSame(bResult, toEthNotationResult17.b());
    assertSame(bResult, toEthNotationResult16.b());
    assertSame(bResult, toEthNotationResult15.b());
    assertSame(bResult, toEthNotationResult14.b());
    assertSame(bResult, toEthNotationResult13.b());
    assertSame(bResult, toEthNotationResult12.b());
    assertSame(bResult, toEthNotationResult11.b());
    assertSame(bResult, toEthNotationResult10.b());
    Fp expectedXResult = actualToAffineResult.x;
    assertSame(expectedXResult, actualToAffineResult.x());
    assertSame(fp, actualToAffineResult.y());
    Fp fp3 = actualToAffineResult.z;
    assertSame(fp3, toEthNotationResult.one());
    assertSame(fp3, toEthNotationResult2.one());
    assertSame(fp3, toEthNotationResult3.one());
    assertSame(fp3, toEthNotationResult4.one());
    assertSame(fp3, toEthNotationResult5.one());
    assertSame(fp3, toEthNotationResult6.one());
    assertSame(fp3, toEthNotationResult7.one());
    assertSame(fp3, toEthNotationResult8.one());
    assertSame(fp3, toEthNotationResult17.one());
    assertSame(fp3, toEthNotationResult16.one());
    assertSame(fp3, toEthNotationResult15.one());
    assertSame(fp3, toEthNotationResult14.one());
    assertSame(fp3, toEthNotationResult13.one());
    assertSame(fp3, toEthNotationResult12.one());
    assertSame(fp3, toEthNotationResult11.one());
    assertSame(fp3, toEthNotationResult10.one());
    assertSame(fp3, bn128g1.one());
    assertSame(fp3, actualToAffineResult.one());
    assertSame(fp3, ((BN128G1) toEthNotationResult).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult2).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult3).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult4).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult5).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult6).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult7).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult8).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult9).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult18).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult17).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult16).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult15).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult14).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult13).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult12).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult11).z);
    assertSame(fp3, ((BN128G1) toEthNotationResult10).z);
    BN128<Fp> bn128 = actualToAffineResult.ZERO;
    assertSame(bn128, toEthNotationResult.zero());
    assertSame(bn128, toEthNotationResult2.zero());
    assertSame(bn128, toEthNotationResult3.zero());
    assertSame(bn128, toEthNotationResult4.zero());
    assertSame(bn128, toEthNotationResult5.zero());
    assertSame(bn128, toEthNotationResult6.zero());
    assertSame(bn128, toEthNotationResult7.zero());
    assertSame(bn128, toEthNotationResult8.zero());
    assertSame(bn128, toEthNotationResult17.zero());
    assertSame(bn128, toEthNotationResult16.zero());
    assertSame(bn128, toEthNotationResult15.zero());
    assertSame(bn128, toEthNotationResult14.zero());
    assertSame(bn128, toEthNotationResult13.zero());
    assertSame(bn128, toEthNotationResult12.zero());
    assertSame(bn128, toEthNotationResult11.zero());
    assertSame(bn128, toEthNotationResult10.zero());
    assertSame(bn128, bn128g1.zero());
    assertSame(bn128, actualToAffineResult.zero());
    assertArrayEquals(new byte[]{1}, actualToAffineResult.y.bytes());
    assertArrayEquals(new byte[]{3}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{3}, bResult.bytes());
  }

  /**
   * Method under test: {@link BN128G1#BN128G1(BN128)}
   */
  @Test
  public void testNewBn128g1() {
    // Arrange
    BN128<Fp> p = BN128Fp.ZERO;

    // Act
    BN128G1 actualBn128g1 = new BN128G1(p);

    // Assert
    BN128<Fp> toAffineResult = p.toAffine();
    BN128<Fp> toAffineResult2 = toAffineResult.toAffine();
    BN128<Fp> toAffineResult3 = toAffineResult2.toAffine();
    BN128<Fp> toAffineResult4 = toAffineResult3.toAffine();
    BN128<Fp> toAffineResult5 = toAffineResult4.toAffine();
    BN128<Fp> toAffineResult6 = toAffineResult5.toAffine();
    BN128<Fp> toAffineResult7 = toAffineResult6.toAffine();
    BN128<Fp> toAffineResult8 = toAffineResult7.toAffine();
    BN128<Fp> toAffineResult9 = toAffineResult8.toAffine();
    assertTrue(toAffineResult9 instanceof BN128Fp);
    assertTrue(toAffineResult8 instanceof BN128Fp);
    assertTrue(toAffineResult7 instanceof BN128Fp);
    assertTrue(toAffineResult6 instanceof BN128Fp);
    assertTrue(toAffineResult5 instanceof BN128Fp);
    assertTrue(toAffineResult4 instanceof BN128Fp);
    assertTrue(toAffineResult3 instanceof BN128Fp);
    assertTrue(toAffineResult2 instanceof BN128Fp);
    assertTrue(toAffineResult instanceof BN128Fp);
    assertTrue(p instanceof BN128Fp);
    Fp oneResult = actualBn128g1.one();
    BigInteger bigInteger = oneResult.v;
    assertEquals("1", bigInteger.toString());
    Fp bResult = actualBn128g1.b();
    BigInteger bigInteger2 = bResult.v;
    assertEquals("3", bigInteger2.toString());
    assertEquals(0, bigInteger2.getLowestSetBit());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger2.signum());
    assertEquals(1, bigInteger.signum());
    assertTrue(actualBn128g1.isValid());
    BN128G1 toAffineResult10 = actualBn128g1.toAffine();
    assertTrue(toAffineResult10.isValid());
    BN128G1 toAffineResult11 = toAffineResult10.toAffine();
    assertTrue(toAffineResult11.isValid());
    BN128G1 toAffineResult12 = toAffineResult11.toAffine();
    assertTrue(toAffineResult12.isValid());
    BN128G1 toAffineResult13 = toAffineResult12.toAffine();
    assertTrue(toAffineResult13.isValid());
    BN128G1 toAffineResult14 = toAffineResult13.toAffine();
    assertTrue(toAffineResult14.isValid());
    BN128G1 toAffineResult15 = toAffineResult14.toAffine();
    assertTrue(toAffineResult15.isValid());
    BN128G1 toAffineResult16 = toAffineResult15.toAffine();
    assertTrue(toAffineResult16.isValid());
    BN128G1 toAffineResult17 = toAffineResult16.toAffine();
    assertTrue(toAffineResult17.isValid());
    assertTrue(actualBn128g1.isZero());
    assertTrue(toAffineResult10.isZero());
    assertTrue(toAffineResult11.isZero());
    assertTrue(toAffineResult12.isZero());
    assertTrue(toAffineResult13.isZero());
    assertTrue(toAffineResult14.isZero());
    assertTrue(toAffineResult15.isZero());
    assertTrue(toAffineResult16.isZero());
    assertTrue(toAffineResult17.isZero());
    assertSame(bResult, toAffineResult10.b());
    assertSame(bResult, toAffineResult11.b());
    assertSame(bResult, toAffineResult12.b());
    assertSame(bResult, toAffineResult13.b());
    assertSame(bResult, toAffineResult14.b());
    assertSame(bResult, toAffineResult15.b());
    assertSame(bResult, toAffineResult16.b());
    assertSame(bResult, toAffineResult17.b());
    assertSame(oneResult, toAffineResult10.y());
    assertSame(oneResult, toAffineResult11.y());
    assertSame(oneResult, toAffineResult12.y());
    assertSame(oneResult, toAffineResult13.y());
    assertSame(oneResult, toAffineResult14.y());
    assertSame(oneResult, toAffineResult15.y());
    assertSame(oneResult, toAffineResult16.y());
    assertSame(oneResult, toAffineResult17.y());
    assertSame(oneResult, toAffineResult10.one());
    assertSame(oneResult, toAffineResult11.one());
    assertSame(oneResult, toAffineResult12.one());
    assertSame(oneResult, toAffineResult13.one());
    assertSame(oneResult, toAffineResult14.one());
    assertSame(oneResult, toAffineResult15.one());
    assertSame(oneResult, toAffineResult16.one());
    assertSame(oneResult, toAffineResult17.one());
    assertSame(oneResult, toAffineResult10.y);
    assertSame(oneResult, toAffineResult11.y);
    assertSame(oneResult, toAffineResult12.y);
    assertSame(oneResult, toAffineResult13.y);
    assertSame(oneResult, toAffineResult14.y);
    assertSame(oneResult, toAffineResult15.y);
    assertSame(oneResult, toAffineResult16.y);
    assertSame(oneResult, toAffineResult17.y);
    BN128G1 toAffineResult18 = toAffineResult17.toAffine();
    assertSame(oneResult, toAffineResult18.y);
    Fp fp = actualBn128g1.z;
    assertSame(fp, actualBn128g1.x());
    assertSame(fp, toAffineResult8.x());
    assertSame(fp, toAffineResult7.x());
    assertSame(fp, toAffineResult6.x());
    assertSame(fp, toAffineResult5.x());
    assertSame(fp, toAffineResult4.x());
    assertSame(fp, toAffineResult3.x());
    assertSame(fp, toAffineResult2.x());
    assertSame(fp, toAffineResult.x());
    assertSame(fp, toAffineResult10.x());
    assertSame(fp, toAffineResult11.x());
    assertSame(fp, toAffineResult12.x());
    assertSame(fp, toAffineResult13.x());
    assertSame(fp, toAffineResult14.x());
    assertSame(fp, toAffineResult15.x());
    assertSame(fp, toAffineResult16.x());
    assertSame(fp, toAffineResult17.x());
    assertSame(fp, p.x());
    assertSame(fp, actualBn128g1.y());
    assertSame(fp, p.y());
    assertSame(fp, toAffineResult10.x);
    assertSame(fp, toAffineResult11.x);
    assertSame(fp, toAffineResult12.x);
    assertSame(fp, toAffineResult13.x);
    assertSame(fp, toAffineResult14.x);
    assertSame(fp, toAffineResult15.x);
    assertSame(fp, toAffineResult16.x);
    assertSame(fp, toAffineResult17.x);
    assertSame(fp, toAffineResult18.x);
    assertSame(fp, ((BN128Fp) toAffineResult9).x);
    assertSame(fp, ((BN128Fp) toAffineResult8).x);
    assertSame(fp, ((BN128Fp) toAffineResult7).x);
    assertSame(fp, ((BN128Fp) toAffineResult6).x);
    assertSame(fp, ((BN128Fp) toAffineResult5).x);
    assertSame(fp, ((BN128Fp) toAffineResult4).x);
    assertSame(fp, ((BN128Fp) toAffineResult3).x);
    assertSame(fp, ((BN128Fp) toAffineResult2).x);
    assertSame(fp, ((BN128Fp) toAffineResult).x);
    assertSame(fp, toAffineResult10.z);
    assertSame(fp, toAffineResult11.z);
    assertSame(fp, toAffineResult12.z);
    assertSame(fp, toAffineResult13.z);
    assertSame(fp, toAffineResult14.z);
    assertSame(fp, toAffineResult15.z);
    assertSame(fp, toAffineResult16.z);
    assertSame(fp, toAffineResult17.z);
    assertSame(fp, toAffineResult18.z);
    assertSame(fp, ((BN128Fp) toAffineResult9).z);
    assertSame(fp, ((BN128Fp) toAffineResult8).z);
    assertSame(fp, ((BN128Fp) toAffineResult7).z);
    assertSame(fp, ((BN128Fp) toAffineResult6).z);
    assertSame(fp, ((BN128Fp) toAffineResult5).z);
    assertSame(fp, ((BN128Fp) toAffineResult4).z);
    assertSame(fp, ((BN128Fp) toAffineResult3).z);
    assertSame(fp, ((BN128Fp) toAffineResult2).z);
    assertSame(fp, ((BN128Fp) toAffineResult).z);
    BN128<Fp> bn128 = actualBn128g1.ZERO;
    assertSame(bn128, actualBn128g1.toEthNotation());
    assertSame(bn128, toAffineResult8.toEthNotation());
    assertSame(bn128, toAffineResult7.toEthNotation());
    assertSame(bn128, toAffineResult6.toEthNotation());
    assertSame(bn128, toAffineResult5.toEthNotation());
    assertSame(bn128, toAffineResult4.toEthNotation());
    assertSame(bn128, toAffineResult3.toEthNotation());
    assertSame(bn128, toAffineResult2.toEthNotation());
    assertSame(bn128, toAffineResult.toEthNotation());
    assertSame(bn128, toAffineResult10.toEthNotation());
    assertSame(bn128, toAffineResult11.toEthNotation());
    assertSame(bn128, toAffineResult12.toEthNotation());
    assertSame(bn128, toAffineResult13.toEthNotation());
    assertSame(bn128, toAffineResult14.toEthNotation());
    assertSame(bn128, toAffineResult15.toEthNotation());
    assertSame(bn128, toAffineResult16.toEthNotation());
    assertSame(bn128, toAffineResult17.toEthNotation());
    assertSame(bn128, p.toEthNotation());
    assertSame(bn128, toAffineResult8.zero());
    assertSame(bn128, toAffineResult7.zero());
    assertSame(bn128, toAffineResult6.zero());
    assertSame(bn128, toAffineResult5.zero());
    assertSame(bn128, toAffineResult4.zero());
    assertSame(bn128, toAffineResult3.zero());
    assertSame(bn128, toAffineResult2.zero());
    assertSame(bn128, toAffineResult.zero());
    assertSame(bn128, p.zero());
    assertSame(bn128, actualBn128g1.zero());
    assertSame(bn128, toAffineResult10.zero());
    assertSame(bn128, toAffineResult11.zero());
    assertSame(bn128, toAffineResult12.zero());
    assertSame(bn128, toAffineResult13.zero());
    assertSame(bn128, toAffineResult14.zero());
    assertSame(bn128, toAffineResult15.zero());
    assertSame(bn128, toAffineResult16.zero());
    assertSame(bn128, toAffineResult17.zero());
    assertArrayEquals(new byte[]{0}, actualBn128g1.x.bytes());
    assertArrayEquals(new byte[]{0}, actualBn128g1.y.bytes());
    assertArrayEquals(new byte[]{0}, actualBn128g1.z.bytes());
    assertArrayEquals(new byte[]{1}, bigInteger.toByteArray());
    assertArrayEquals(new byte[]{1}, oneResult.bytes());
    assertArrayEquals(new byte[]{3}, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{3}, bResult.bytes());
  }
}
