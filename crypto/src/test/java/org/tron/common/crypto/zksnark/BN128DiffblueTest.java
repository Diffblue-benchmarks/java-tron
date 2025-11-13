package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BN128DiffblueTest {
  /**
   * Test {@link BN128#toAffine()}.
   *
   * <p>Method under test: {@link BN128#toAffine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.toAffine()"})
  public void testToAffine() {
    // Arrange
    BN128Fp bn128Fp = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    BN128<Fp> actualToAffineResult = bn128Fp.toAffine();

    // Assert
    assertTrue(actualToAffineResult instanceof BN128Fp);
    assertTrue(bn128Fp.toEthNotation() instanceof BN128Fp);
    BN128<Fp> zeroResult = actualToAffineResult.zero();
    assertTrue(zeroResult instanceof BN128Fp);
    assertFalse(actualToAffineResult.isValid());
    assertFalse(actualToAffineResult.isZero());
    Fp expectedXResult = actualToAffineResult.x;
    assertSame(expectedXResult, actualToAffineResult.x());
    Fp expectedYResult = actualToAffineResult.y;
    assertSame(expectedYResult, actualToAffineResult.y());
    Fp fp = bn128Fp.z;
    assertSame(fp, bn128Fp.x());
    assertSame(fp, bn128Fp.y());
    Fp fp2 = actualToAffineResult.z;
    assertSame(fp2, actualToAffineResult.one());
    assertSame(fp2, bn128Fp.one());
    BN128<Fp> bn128 = ((BN128Fp) actualToAffineResult).ZERO;
    assertSame(bn128, zeroResult);
    assertSame(bn128, bn128Fp.zero());
  }

  /**
   * Test {@link BN128#toAffine()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@link BN128G1}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#toAffine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.toAffine()"})
  public void testToAffine_givenBn128g1WithPIsZero_thenReturnBn128g1() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    BN128G1 actualToAffineResult = bn128g1.toAffine();

    // Assert
    assertTrue(actualToAffineResult instanceof BN128G1);
    Fp fp = actualToAffineResult.y;
    assertSame(fp, actualToAffineResult.y());
    assertSame(fp, bn128g1.one());
    assertSame(fp, actualToAffineResult.one());
    Fp fp2 = actualToAffineResult.z;
    assertSame(fp2, bn128g1.x());
    assertSame(fp2, actualToAffineResult.x());
    assertSame(fp2, bn128g1.y());
    BN128<Fp> bn128 = ((BN128Fp) actualToAffineResult).ZERO;
    assertSame(bn128, bn128g1.toEthNotation());
    assertSame(bn128, actualToAffineResult.toEthNotation());
    assertSame(bn128, bn128g1.zero());
    assertSame(bn128, actualToAffineResult.zero());
  }

  /**
   * Test {@link BN128#toAffine()}.
   *
   * <ul>
   *   <li>Given {@link BN128Fp#ZERO}.
   *   <li>Then {@link BN128Fp#ZERO} {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#toAffine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.toAffine()"})
  public void testToAffine_givenZero_thenZeroBN128Fp() {
    // Arrange
    BN128<Fp> bn128 = BN128Fp.ZERO;

    // Act
    BN128<Fp> actualToAffineResult = bn128.toAffine();

    // Assert
    assertTrue(actualToAffineResult instanceof BN128Fp);
    assertTrue(bn128 instanceof BN128Fp);
    Fp fp = actualToAffineResult.y;
    assertSame(fp, actualToAffineResult.one());
    assertSame(fp, bn128.one());
    assertSame(fp, actualToAffineResult.y());
    Fp fp2 = actualToAffineResult.z;
    assertSame(fp2, actualToAffineResult.x());
    assertSame(fp2, bn128.x());
    assertSame(fp2, bn128.y());
    BN128<Fp> bn1282 = ((BN128Fp) actualToAffineResult).ZERO;
    assertSame(bn1282, actualToAffineResult.toEthNotation());
    assertSame(bn1282, bn128.toEthNotation());
    assertSame(bn1282, actualToAffineResult.zero());
    assertSame(bn1282, bn128.zero());
  }

  /**
   * Test {@link BN128#toEthNotation()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO} x is {@link BN128#z}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#toEthNotation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.toEthNotation()"})
  public void testToEthNotation_givenBn128g1WithPIsZero_thenBn128g1WithPIsZeroXIsZ() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    BN128<Fp> actualToEthNotationResult = bn128g1.toEthNotation();

    // Assert
    Fp fp = actualToEthNotationResult.z;
    assertSame(fp, bn128g1.x());
    assertSame(fp, bn128g1.y());
    BN128<Fp> bn128 = ((BN128Fp) actualToEthNotationResult).ZERO;
    assertSame(bn128, actualToEthNotationResult);
    assertSame(bn128, bn128g1.zero());
  }

  /**
   * Test {@link BN128#toEthNotation()}.
   *
   * <ul>
   *   <li>Then zero return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#toEthNotation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.toEthNotation()"})
  public void testToEthNotation_thenZeroReturnBN128Fp() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);

    // Act
    BN128<Fp> actualToEthNotationResult = bn128g1.toEthNotation();

    // Assert
    BN128<Fp> zeroResult = actualToEthNotationResult.zero();
    assertTrue(zeroResult instanceof BN128Fp);
    assertTrue(actualToEthNotationResult instanceof BN128G1);
    assertFalse(actualToEthNotationResult.isValid());
    assertFalse(actualToEthNotationResult.isZero());
    Fp expectedXResult = actualToEthNotationResult.x;
    assertSame(expectedXResult, actualToEthNotationResult.x());
    Fp expectedYResult = actualToEthNotationResult.y;
    assertSame(expectedYResult, actualToEthNotationResult.y());
    Fp fp = bn128g1.z;
    assertSame(fp, bn128g1.x());
    assertSame(fp, bn128g1.y());
    Fp fp2 = actualToEthNotationResult.z;
    assertSame(fp2, actualToEthNotationResult.one());
    assertSame(fp2, bn128g1.one());
    BN128<Fp> bn128 = ((BN128Fp) actualToEthNotationResult).ZERO;
    assertSame(bn128, zeroResult);
    assertSame(bn128, bn128g1.zero());
  }

  /**
   * Test {@link BN128#isOnCurve()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isOnCurve()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isOnCurve()"})
  public void testIsOnCurve_givenBn128g1WithPIsZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BN128G1(BN128Fp.ZERO).isOnCurve());
  }

  /**
   * Test {@link BN128#isOnCurve()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isOnCurve()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isOnCurve()"})
  public void testIsOnCurve_thenReturnFalse() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act and Assert
    assertFalse(new BN128G1(p).isOnCurve());
  }

  /**
   * Test {@link BN128#add(BN128)}.
   *
   * <p>Method under test: {@link BN128#add(BN128)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.add(BN128)"})
  public void testAdd() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.ZERO, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);
    BN128Fp o = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    BN128<Fp> actualAddResult = bn128g1.add(o);

    // Assert
    assertTrue(actualAddResult instanceof BN128Fp);
    assertTrue(o.toEthNotation() instanceof BN128Fp);
    Fp expectedXResult = actualAddResult.x;
    assertSame(expectedXResult, actualAddResult.x());
    Fp expectedYResult = actualAddResult.y;
    assertSame(expectedYResult, actualAddResult.y());
    Fp fp = o.z;
    assertSame(fp, o.x());
    assertSame(fp, o.y());
    BN128<Fp> bn128 = ((BN128Fp) actualAddResult).ZERO;
    assertSame(bn128, actualAddResult.toEthNotation());
    assertSame(bn128, actualAddResult.zero());
    assertSame(bn128, o.zero());
  }

  /**
   * Test {@link BN128#add(BN128)}.
   *
   * <ul>
   *   <li>Given {@link BN128Fp#BN128Fp(Fp, Fp, Fp)} with x is {@link Fp#ZERO} and y is {@link
   *       Fp#NON_RESIDUE} and z is {@link Fp#NON_RESIDUE}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#add(BN128)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.add(BN128)"})
  public void testAdd_givenBN128FpWithXIsZeroAndYIsNon_residueAndZIsNon_residue() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.ZERO, Fp.NON_RESIDUE, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);
    BN128Fp o = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    BN128<Fp> actualAddResult = bn128g1.add(o);

    // Assert
    assertTrue(actualAddResult instanceof BN128Fp);
    assertTrue(actualAddResult.toEthNotation() instanceof BN128Fp);
    BN128<Fp> zeroResult = actualAddResult.zero();
    assertTrue(zeroResult instanceof BN128Fp);
    Fp expectedXResult = actualAddResult.x;
    assertSame(expectedXResult, actualAddResult.x());
    Fp expectedYResult = actualAddResult.y;
    assertSame(expectedYResult, actualAddResult.y());
    assertSame(((BN128Fp) actualAddResult).ZERO, zeroResult);
  }

  /**
   * Test {@link BN128#add(BN128)}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>When {@link BN128Fp#ZERO}.
   *   <li>Then {@link BN128Fp#ZERO} {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#add(BN128)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.add(BN128)"})
  public void testAdd_givenBn128g1WithPIsZero_whenZero_thenZeroBN128Fp() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);
    BN128<Fp> o = BN128Fp.ZERO;

    // Act
    BN128<Fp> actualAddResult = bn128g1.add(o);

    // Assert
    assertTrue(o instanceof BN128Fp);
    Fp fp = actualAddResult.z;
    assertSame(fp, bn128g1.x());
    assertSame(fp, o.x());
    assertSame(fp, bn128g1.y());
    assertSame(fp, o.y());
    BN128<Fp> bn128 = ((BN128Fp) actualAddResult).ZERO;
    assertSame(bn128, actualAddResult);
    assertSame(bn128, bn128g1.toEthNotation());
    assertSame(bn128, o.toEthNotation());
    assertSame(bn128, o.zero());
    assertSame(bn128, bn128g1.zero());
  }

  /**
   * Test {@link BN128#add(BN128)}.
   *
   * <ul>
   *   <li>Then toEthNotation return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#add(BN128)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.add(BN128)"})
  public void testAdd_thenToEthNotationReturnBN128Fp() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);
    BN128Fp o = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    BN128<Fp> actualAddResult = bn128g1.add(o);

    // Assert
    assertTrue(actualAddResult instanceof BN128Fp);
    assertTrue(actualAddResult.toEthNotation() instanceof BN128Fp);
    BN128<Fp> zeroResult = actualAddResult.zero();
    assertTrue(zeroResult instanceof BN128Fp);
    Fp expectedXResult = actualAddResult.x;
    assertSame(expectedXResult, actualAddResult.x());
    Fp expectedYResult = actualAddResult.y;
    assertSame(expectedYResult, actualAddResult.y());
    assertSame(((BN128Fp) actualAddResult).ZERO, zeroResult);
  }

  /**
   * Test {@link BN128#add(BN128)}.
   *
   * <ul>
   *   <li>When {@link BN128Fp#ZERO}.
   *   <li>Then return {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#BN128Fp(Fp, Fp, Fp)}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#add(BN128)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.add(BN128)"})
  public void testAdd_whenZero_thenReturnBn128g1WithPIsBN128Fp() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);

    // Act
    BN128<Fp> actualAddResult = bn128g1.add(BN128Fp.ZERO);

    // Assert
    assertSame(bn128g1, actualAddResult);
  }

  /**
   * Test {@link BN128#mul(BigInteger)}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#mul(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.mul(BigInteger)"})
  public void testMul_givenBn128g1WithPIsZero_thenReturnBn128g1WithPIsZero() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    BN128<Fp> actualMulResult = bn128g1.mul(BN128G2.FR_NEG_ONE);

    // Assert
    assertSame(bn128g1, actualMulResult);
    Fp fp = actualMulResult.z;
    assertSame(fp, bn128g1.x());
    assertSame(fp, bn128g1.y());
    BN128<Fp> bn128 = ((BN128Fp) actualMulResult).ZERO;
    assertSame(bn128, bn128g1.toEthNotation());
    assertSame(bn128, bn128g1.zero());
  }

  /**
   * Test {@link BN128#mul(BigInteger)}.
   *
   * <ul>
   *   <li>Then return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#mul(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BN128 BN128.mul(BigInteger)"})
  public void testMul_thenReturnBN128Fp() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.ZERO, Fp.NON_RESIDUE);
    BN128G1 bn128g1 = new BN128G1(p);

    // Act
    BN128<Fp> actualMulResult = bn128g1.mul(BN128G2.FR_NEG_ONE);

    // Assert
    assertTrue(actualMulResult instanceof BN128Fp);
    assertTrue(actualMulResult.toAffine() instanceof BN128Fp);
    assertTrue(bn128g1.toEthNotation() instanceof BN128G1);
    Fp expectedXResult = actualMulResult.x;
    assertSame(expectedXResult, actualMulResult.x());
    Fp expectedYResult = bn128g1.y;
    assertSame(expectedYResult, bn128g1.y());
    Fp expectedYResult2 = actualMulResult.y;
    assertSame(expectedYResult2, actualMulResult.y());
    Fp expectedXResult2 = bn128g1.z;
    assertSame(expectedXResult2, bn128g1.x());
    BN128<Fp> bn128 = ((BN128Fp) actualMulResult).ZERO;
    assertSame(bn128, actualMulResult.toEthNotation());
    assertSame(bn128, actualMulResult.zero());
    assertSame(bn128, bn128g1.zero());
  }

  /**
   * Test {@link BN128#x()}.
   *
   * <p>Method under test: {@link BN128#x()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.common.crypto.zksnark.Field BN128.x()"})
  public void testX() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    Fp actualXResult = bn128g1.x();

    // Assert
    Fp fp = Fp.ZERO;
    assertSame(fp, actualXResult);
    assertSame(fp, bn128g1.y());
    assertSame(Fp._1, bn128g1.one());
    assertArrayEquals(new byte[] {0}, actualXResult.bytes());
  }

  /**
   * Test {@link BN128#y()}.
   *
   * <p>Method under test: {@link BN128#y()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.common.crypto.zksnark.Field BN128.y()"})
  public void testY() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);

    // Act
    Fp actualYResult = bn128g1.y();

    // Assert
    Fp fp = Fp.ZERO;
    assertSame(fp, bn128g1.x());
    assertSame(fp, actualYResult);
    assertSame(Fp._1, bn128g1.one());
    assertArrayEquals(new byte[] {0}, actualYResult.bytes());
  }

  /**
   * Test {@link BN128#isZero()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isZero()"})
  public void testIsZero_givenBn128g1WithPIsZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BN128G1(BN128Fp.ZERO).isZero());
  }

  /**
   * Test {@link BN128#isZero()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isZero()"})
  public void testIsZero_thenReturnFalse() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act and Assert
    assertFalse(new BN128G1(p).isZero());
  }

  /**
   * Test {@link BN128#isValid()}.
   *
   * <ul>
   *   <li>Given {@link BN128Fp#BN128Fp(Fp, Fp, Fp)} with x is {@link Fp#Fp(BigInteger)} and y is
   *       {@link Fp#NON_RESIDUE} and z is {@link Fp#NON_RESIDUE}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isValid()"})
  public void testIsValid_givenBN128FpWithXIsFpAndYIsNon_residueAndZIsNon_residue() {
    // Arrange
    BN128Fp p = new BN128Fp(new Fp(Params.P), Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act and Assert
    assertFalse(new BN128G1(p).isValid());
  }

  /**
   * Test {@link BN128#isValid()}.
   *
   * <ul>
   *   <li>Given {@link BN128Fp#BN128Fp(Fp, Fp, Fp)} with x is {@link Fp#NON_RESIDUE} and y is
   *       {@link Fp#Fp(BigInteger)} and z is {@link Fp#NON_RESIDUE}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isValid()"})
  public void testIsValid_givenBN128FpWithXIsNon_residueAndYIsFpAndZIsNon_residue() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, new Fp(Params.P), Fp.NON_RESIDUE);

    // Act and Assert
    assertFalse(new BN128G1(p).isValid());
  }

  /**
   * Test {@link BN128#isValid()}.
   *
   * <ul>
   *   <li>Given {@link BN128Fp#BN128Fp(Fp, Fp, Fp)} with x is {@link Fp#NON_RESIDUE} and y is
   *       {@link Fp#NON_RESIDUE} and z is {@link Fp#Fp(BigInteger)}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isValid()"})
  public void testIsValid_givenBN128FpWithXIsNon_residueAndYIsNon_residueAndZIsFp() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, new Fp(Params.P));

    // Act and Assert
    assertFalse(new BN128G1(p).isValid());
  }

  /**
   * Test {@link BN128#isValid()}.
   *
   * <ul>
   *   <li>Given {@link BN128Fp#BN128Fp(Fp, Fp, Fp)} with x is {@link Fp#NON_RESIDUE} and y is
   *       {@link Fp#NON_RESIDUE} and z is {@link Fp#NON_RESIDUE}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isValid()"})
  public void testIsValid_givenBN128FpWithXIsNon_residueAndYIsNon_residueAndZIsNon_residue() {
    // Arrange
    BN128Fp p = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act and Assert
    assertFalse(new BN128G1(p).isValid());
  }

  /**
   * Test {@link BN128#isValid()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#isValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.isValid()"})
  public void testIsValid_givenBn128g1WithPIsZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BN128G1(BN128Fp.ZERO).isValid());
  }

  /**
   * Test {@link BN128#toString()}.
   *
   * <ul>
   *   <li>Given {@link BN128G1#BN128G1(BN128)} with p is {@link BN128Fp#ZERO}.
   *   <li>Then return {@code (0; 0; 0)}.
   * </ul>
   *
   * <p>Method under test: {@link BN128#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BN128.toString()"})
  public void testToString_givenBn128g1WithPIsZero_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("(0; 0; 0)", new BN128G1(BN128Fp.ZERO).toString());
  }

  /**
   * Test {@link BN128#equals(Object)}, and {@link BN128#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BN128<Fp> bn128 = BN128Fp.ZERO;
    BN128<Fp> bn1282 = BN128Fp.ZERO;

    // Act and Assert
    assertEquals(bn128, bn1282);
    assertEquals(bn128.hashCode(), bn1282.hashCode());
  }

  /**
   * Test {@link BN128#equals(Object)}, and {@link BN128#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BN128G1 bn128g1 = new BN128G1(BN128Fp.ZERO);
    BN128<Fp> bn128 = BN128Fp.ZERO;

    // Act and Assert
    assertEquals(bn128g1, bn128);
    assertNotEquals(bn128g1.hashCode(), bn128.hashCode());
  }

  /**
   * Test {@link BN128#equals(Object)}, and {@link BN128#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BN128Fp bn128Fp = new BN128Fp(null, null, null);
    BN128Fp bn128Fp2 = mock(BN128Fp.class);

    // Act and Assert
    assertEquals(bn128Fp, bn128Fp2);
    assertNotEquals(bn128Fp.hashCode(), bn128Fp2.hashCode());
  }

  /**
   * Test {@link BN128#equals(Object)}, and {@link BN128#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BN128<Fp> bn128 = BN128Fp.ZERO;

    // Act and Assert
    assertEquals(bn128, bn128);
    int expectedHashCodeResult = bn128.hashCode();
    assertEquals(expectedHashCodeResult, bn128.hashCode());
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE), BN128Fp.ZERO);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(Fp.ZERO, Fp.NON_RESIDUE, Fp.NON_RESIDUE), BN128Fp.ZERO);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(null, Fp.NON_RESIDUE, Fp.NON_RESIDUE), BN128Fp.ZERO);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(Fp.ZERO, Fp.ZERO, Fp.NON_RESIDUE), BN128Fp.ZERO);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(Fp.ZERO, null, Fp.NON_RESIDUE), BN128Fp.ZERO);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(null, Fp.NON_RESIDUE, Fp.NON_RESIDUE), mock(BN128Fp.class));
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(Fp.ZERO, Fp.ZERO, null), BN128Fp.ZERO);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange, Act and Assert
    assertNotEquals(new BN128Fp(null, null, Fp.NON_RESIDUE), mock(BN128Fp.class));
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BN128Fp.ZERO, null);
  }

  /**
   * Test {@link BN128#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BN128#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BN128.equals(Object)"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BN128Fp.ZERO, "Different type to BN128");
  }
}
