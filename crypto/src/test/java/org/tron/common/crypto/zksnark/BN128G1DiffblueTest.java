package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BN128G1DiffblueTest {
  /**
   * Test {@link BN128G1#BN128G1(BN128)}.
   *
   * <p>Method under test: {@link BN128G1#BN128G1(BN128)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BN128G1.<init>(BN128)"})
  public void testNewBn128g1() {
    // Arrange
    BN128<Fp> p = BN128Fp.ZERO;

    // Act
    BN128G1 actualBn128g1 = new BN128G1(p);

    // Assert
    BN128<Fp> toEthNotationResult = actualBn128g1.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128Fp);
    assertTrue(p instanceof BN128Fp);
    assertTrue(actualBn128g1.isValid());
    assertTrue(actualBn128g1.isZero());
    Fp fp = actualBn128g1.z;
    assertSame(fp, actualBn128g1.x());
    assertSame(fp, p.x());
    assertSame(fp, actualBn128g1.y());
    assertSame(fp, p.y());
    BN128<Fp> bn128 = BN128Fp.ZERO;
    assertSame(bn128, toEthNotationResult);
    assertSame(bn128, actualBn128g1.zero());
  }

  /**
   * Test {@link BN128G1#create(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BN128G1#create(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128G1 BN128G1.create(byte[], byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    BN128G1 actualCreateResult =
        BN128G1.create("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128G1#create(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BN128G1#create(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128G1 BN128G1.create(byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange and Act
    BN128G1 actualCreateResult = BN128G1.create(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128G1#create(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then toEthNotation return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128G1#create(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128G1 BN128G1.create(byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenToEthNotationReturnBN128Fp() {
    // Arrange and Act
    BN128G1 actualCreateResult = BN128G1.create(new byte[] {}, new byte[] {});

    // Assert
    BN128<Fp> toEthNotationResult = actualCreateResult.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128Fp);
    assertTrue(actualCreateResult.isValid());
    assertTrue(actualCreateResult.isZero());
    Fp fp = actualCreateResult.z;
    assertSame(fp, actualCreateResult.x());
    assertSame(fp, actualCreateResult.y());
    BN128<Fp> bn128 = BN128Fp.ZERO;
    assertSame(bn128, toEthNotationResult);
    assertSame(bn128, actualCreateResult.zero());
  }

  /**
   * Test {@link BN128G1#toAffine()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then toEthNotation return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128G1#toAffine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128G1 BN128G1.toAffine()"})
  public void testToAffine_givenBn128g1WithPIsZero_thenToEthNotationReturnBN128Fp() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    BN128G1 actualToAffineResult = bn128g1.toAffine();

    // Assert
    BN128<Fp> toEthNotationResult = actualToAffineResult.toEthNotation();
    assertTrue(toEthNotationResult instanceof BN128Fp);
    assertTrue(actualToAffineResult.isValid());
    assertTrue(actualToAffineResult.isZero());
    assertSame(toEthNotationResult, actualToAffineResult.zero());
    Fp fp = actualToAffineResult.y;
    assertSame(fp, actualToAffineResult.y());
    assertSame(fp, bn128g1.one());
    assertSame(fp, actualToAffineResult.one());
    Fp fp2 = actualToAffineResult.z;
    assertSame(fp2, bn128g1.x());
    assertSame(fp2, actualToAffineResult.x());
    assertSame(fp2, bn128g1.y());
    assertSame(BN128Fp.ZERO, toEthNotationResult);
  }

  /**
   * Test {@link BN128G1#toAffine()}.
   *
   * <ul>
   *   <li>Then zero return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128G1#toAffine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128G1 BN128G1.toAffine()"})
  public void testToAffine_thenZeroReturnBN128Fp() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);

    // Act
    BN128G1 actualToAffineResult = bn128g1.toAffine();

    // Assert
    assertTrue(actualToAffineResult.zero() instanceof BN128Fp);
    assertTrue(actualToAffineResult.toEthNotation() instanceof BN128G1);
    assertFalse(actualToAffineResult.isValid());
    assertFalse(actualToAffineResult.isZero());
    Fp fp = bn128g1.z;
    assertEquals(fp, actualToAffineResult.x);
    Fp expectedXResult = actualToAffineResult.x;
    assertSame(expectedXResult, actualToAffineResult.x());
    Fp expectedYResult = actualToAffineResult.y;
    assertSame(expectedYResult, actualToAffineResult.y());
    assertSame(fp, bn128g1.x());
    assertSame(fp, bn128g1.y());
    Fp fp2 = actualToAffineResult.z;
    assertSame(fp2, bn128g1.one());
    assertSame(fp2, actualToAffineResult.one());
  }
}
