package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;

public class BIUtilDiffblueTest {
  /**
   * Test {@link BIUtil#isLessThan(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isLessThan(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isLessThan(BigInteger, BigInteger)"})
  public void testIsLessThan_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isLessThan(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isLessThan(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isLessThan(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isLessThan(BigInteger, BigInteger)"})
  public void testIsLessThan_whenValueOfOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isLessThan(BigInteger.valueOf(1L), DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isZero(BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isZero(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isZero(BigInteger)"})
  public void testIsZero_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isZero(DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isZero(BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isZero(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isZero(BigInteger)"})
  public void testIsZero_whenValueOfZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isZero(BigInteger.valueOf(0L)));
  }

  /**
   * Test {@link BIUtil#isEqual(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isEqual(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isEqual(BigInteger, BigInteger)"})
  public void testIsEqual_whenMax_value_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isEqual(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isEqual(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#_2_256}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isEqual(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isEqual(BigInteger, BigInteger)"})
  public void testIsEqual_when_2_256_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isEqual(DataWord._2_256, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isNotEqual(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isNotEqual(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isNotEqual(BigInteger, BigInteger)"})
  public void testIsNotEqual_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isNotEqual(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isNotEqual(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#_2_256}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isNotEqual(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isNotEqual(BigInteger, BigInteger)"})
  public void testIsNotEqual_when_2_256_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isNotEqual(DataWord._2_256, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isMoreThan(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isMoreThan(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isMoreThan(BigInteger, BigInteger)"})
  public void testIsMoreThan_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isMoreThan(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isMoreThan(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#_2_256}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isMoreThan(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isMoreThan(BigInteger, BigInteger)"})
  public void testIsMoreThan_when_2_256_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isMoreThan(DataWord._2_256, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#sum(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.sum(BigInteger, BigInteger)"})
  public void testSum() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(DataWord.MAX_VALUE, DataWord.MAX_VALUE);

    // Assert
    assertEquals(
        "231584178474632390847141970017375815706539969331281128078915168015826259279870",
        actualSumResult.toString());
    assertEquals(1, actualSumResult.getLowestSetBit());
    assertEquals(1, actualSumResult.signum());
    assertArrayEquals(
        new byte[] {
          1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
          -1, -1, -1, -1, -1, -1, -1, -1, -1, -2
        },
        actualSumResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#sum(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.sum(BigInteger, BigInteger)"})
  public void testSum2() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(DataWord._2_256, DataWord.MAX_VALUE);

    // Assert
    assertEquals(
        "231584178474632390847141970017375815706539969331281128078915168015826259279871",
        actualSumResult.toString());
    assertEquals(0, actualSumResult.getLowestSetBit());
    assertEquals(1, actualSumResult.signum());
    assertArrayEquals(
        new byte[] {
          1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
          -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
        },
        actualSumResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#sum(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.sum(BigInteger, BigInteger)"})
  public void testSum3() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(BigInteger.valueOf(5L), DataWord.MAX_VALUE);

    // Assert
    assertEquals(
        "115792089237316195423570985008687907853269984665640564039457584007913129639940",
        actualSumResult.toString());
    assertEquals(1, actualSumResult.signum());
    assertEquals(2, actualSumResult.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 4
        },
        actualSumResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#sum(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.sum(BigInteger, BigInteger)"})
  public void testSum4() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(DataWord._2_256, DataWord._2_256);

    // Assert
    assertEquals(
        "231584178474632390847141970017375815706539969331281128078915168015826259279872",
        actualSumResult.toString());
    assertEquals(1, actualSumResult.signum());
    assertEquals(257, actualSumResult.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0
        },
        actualSumResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#toBI(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link BIUtil#toBI(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.toBI(byte[])"})
  public void testToBIWithByte() throws UnsupportedEncodingException {
    // Arrange and Act
    BigInteger actualToBIResult = BIUtil.toBI("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4708585257725083992", actualToBIResult.toString());
    assertEquals(1, actualToBIResult.signum());
    assertEquals(3, actualToBIResult.getLowestSetBit());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, actualToBIResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#toBI(long)} with {@code long}.
   *
   * <p>Method under test: {@link BIUtil#toBI(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.toBI(long)"})
  public void testToBIWithLong() {
    // Arrange and Act
    BigInteger actualToBIResult = BIUtil.toBI(1L);

    // Assert
    assertEquals("1", actualToBIResult.toString());
    assertEquals(0, actualToBIResult.getLowestSetBit());
    assertEquals(1, actualToBIResult.signum());
    assertArrayEquals(new byte[] {1}, actualToBIResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#isPositive(BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isPositive(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isPositive(BigInteger)"})
  public void testIsPositive_whenMax_value_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isPositive(DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isPositive(BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isPositive(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isPositive(BigInteger)"})
  public void testIsPositive_whenValueOfMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isPositive(BigInteger.valueOf(-1L)));
  }

  /**
   * Test {@link BIUtil#isNotCovers(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isNotCovers(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isNotCovers(BigInteger, BigInteger)"})
  public void testIsNotCovers_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isNotCovers(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#isNotCovers(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#isNotCovers(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BIUtil.isNotCovers(BigInteger, BigInteger)"})
  public void testIsNotCovers_whenValueOfOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isNotCovers(BigInteger.valueOf(1L), DataWord.MAX_VALUE));
  }

  /**
   * Test {@link BIUtil#max(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.max(BigInteger, BigInteger)"})
  public void testMax() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(DataWord.MAX_VALUE, DataWord.MAX_VALUE);

    // Assert
    assertEquals(
        "115792089237316195423570985008687907853269984665640564039457584007913129639935",
        actualMaxResult.toString());
    assertEquals(0, actualMaxResult.getLowestSetBit());
    assertEquals(1, actualMaxResult.signum());
    assertArrayEquals(
        new byte[] {
          0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
          -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
        },
        actualMaxResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#max(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.max(BigInteger, BigInteger)"})
  public void testMax2() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(DataWord._2_256, DataWord.MAX_VALUE);

    // Assert
    assertEquals(
        "115792089237316195423570985008687907853269984665640564039457584007913129639936",
        actualMaxResult.toString());
    assertEquals(1, actualMaxResult.signum());
    assertEquals(256, actualMaxResult.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0
        },
        actualMaxResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#max(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.max(BigInteger, BigInteger)"})
  public void testMax3() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(DataWord._2_256, DataWord._2_256);

    // Assert
    assertEquals(
        "115792089237316195423570985008687907853269984665640564039457584007913129639936",
        actualMaxResult.toString());
    assertEquals(1, actualMaxResult.signum());
    assertEquals(256, actualMaxResult.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0
        },
        actualMaxResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#max(BigInteger, BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf five.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger BIUtil.max(BigInteger, BigInteger)"})
  public void testMax_whenValueOfFive() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(BigInteger.valueOf(5L), DataWord.MAX_VALUE);

    // Assert
    assertEquals(
        "115792089237316195423570985008687907853269984665640564039457584007913129639935",
        actualMaxResult.toString());
    assertEquals(0, actualMaxResult.getLowestSetBit());
    assertEquals(1, actualMaxResult.signum());
    assertArrayEquals(
        new byte[] {
          0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
          -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
        },
        actualMaxResult.toByteArray());
  }

  /**
   * Test {@link BIUtil#addSafely(int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#addSafely(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BIUtil.addSafely(int, int)"})
  public void testAddSafely_whenFour_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(6, BIUtil.addSafely(4, 2));
  }

  /**
   * Test {@link BIUtil#addSafely(int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MAX_VALUE}.
   *   <li>Then return {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#addSafely(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BIUtil.addSafely(int, int)"})
  public void testAddSafely_whenMax_value_thenReturnMax_value() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, BIUtil.addSafely(Integer.MAX_VALUE, 2));
  }

  /**
   * Test {@link BIUtil#addSafely(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#addSafely(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BIUtil.addSafely(int, int)"})
  public void testAddSafely_whenMinusOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, BIUtil.addSafely(-1, 2));
  }

  /**
   * Test {@link BIUtil#addSafely(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link BIUtil#addSafely(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BIUtil.addSafely(int, int)"})
  public void testAddSafely_whenTwo_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, BIUtil.addSafely(2, 2));
  }
}
