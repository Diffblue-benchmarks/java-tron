package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;

public class BIUtilDiffblueTest {
  /**
   * Method under test: {@link BIUtil#isLessThan(BigInteger, BigInteger)}
   */
  @Test
  public void testIsLessThan() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isLessThan(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
    assertTrue(BIUtil.isLessThan(BigInteger.valueOf(1L), DataWord.MAX_VALUE));
  }

  /**
   * Method under test: {@link BIUtil#isZero(BigInteger)}
   */
  @Test
  public void testIsZero() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isZero(DataWord.MAX_VALUE));
    assertTrue(BIUtil.isZero(BigInteger.valueOf(0L)));
  }

  /**
   * Method under test: {@link BIUtil#isEqual(BigInteger, BigInteger)}
   */
  @Test
  public void testIsEqual() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isEqual(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
    assertFalse(BIUtil.isEqual(DataWord._2_256, DataWord.MAX_VALUE));
  }

  /**
   * Method under test: {@link BIUtil#isNotEqual(BigInteger, BigInteger)}
   */
  @Test
  public void testIsNotEqual() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isNotEqual(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
    assertTrue(BIUtil.isNotEqual(DataWord._2_256, DataWord.MAX_VALUE));
  }

  /**
   * Method under test: {@link BIUtil#isMoreThan(BigInteger, BigInteger)}
   */
  @Test
  public void testIsMoreThan() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isMoreThan(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
    assertTrue(BIUtil.isMoreThan(DataWord._2_256, DataWord.MAX_VALUE));
  }

  /**
   * Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  public void testSum() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(DataWord.MAX_VALUE, DataWord.MAX_VALUE);

    // Assert
    assertEquals("231584178474632390847141970017375815706539969331281128078915168015826259279870",
        actualSumResult.toString());
    assertEquals(1, actualSumResult.getLowestSetBit());
    assertEquals(1, actualSumResult.signum());
    assertArrayEquals(new byte[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2}, actualSumResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  public void testSum2() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(DataWord._2_256, DataWord.MAX_VALUE);

    // Assert
    assertEquals("231584178474632390847141970017375815706539969331281128078915168015826259279871",
        actualSumResult.toString());
    assertEquals(0, actualSumResult.getLowestSetBit());
    assertEquals(1, actualSumResult.signum());
    assertArrayEquals(new byte[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, actualSumResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  public void testSum3() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(BigInteger.valueOf(5L), DataWord.MAX_VALUE);

    // Assert
    assertEquals("115792089237316195423570985008687907853269984665640564039457584007913129639940",
        actualSumResult.toString());
    assertEquals(1, actualSumResult.signum());
    assertEquals(2, actualSumResult.getLowestSetBit());
    assertArrayEquals(
        new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
        actualSumResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#sum(BigInteger, BigInteger)}
   */
  @Test
  public void testSum4() {
    // Arrange and Act
    BigInteger actualSumResult = BIUtil.sum(DataWord._2_256, DataWord._2_256);

    // Assert
    assertEquals("231584178474632390847141970017375815706539969331281128078915168015826259279872",
        actualSumResult.toString());
    assertEquals(1, actualSumResult.signum());
    assertEquals(257, actualSumResult.getLowestSetBit());
    assertArrayEquals(
        new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualSumResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#toBI(long)}
   */
  @Test
  public void testToBI() {
    // Arrange and Act
    BigInteger actualToBIResult = BIUtil.toBI(1L);

    // Assert
    assertEquals("1", actualToBIResult.toString());
    assertEquals(0, actualToBIResult.getLowestSetBit());
    assertEquals(1, actualToBIResult.signum());
    assertArrayEquals(new byte[]{1}, actualToBIResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#toBI(byte[])}
   */
  @Test
  public void testToBI2() throws UnsupportedEncodingException {
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
   * Method under test: {@link BIUtil#isPositive(BigInteger)}
   */
  @Test
  public void testIsPositive() {
    // Arrange, Act and Assert
    assertTrue(BIUtil.isPositive(DataWord.MAX_VALUE));
    assertFalse(BIUtil.isPositive(BigInteger.valueOf(-1L)));
  }

  /**
   * Method under test: {@link BIUtil#isNotCovers(BigInteger, BigInteger)}
   */
  @Test
  public void testIsNotCovers() {
    // Arrange, Act and Assert
    assertFalse(BIUtil.isNotCovers(DataWord.MAX_VALUE, DataWord.MAX_VALUE));
    assertTrue(BIUtil.isNotCovers(BigInteger.valueOf(1L), DataWord.MAX_VALUE));
  }

  /**
   * Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  public void testMax() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(DataWord.MAX_VALUE, DataWord.MAX_VALUE);

    // Assert
    assertEquals("115792089237316195423570985008687907853269984665640564039457584007913129639935",
        actualMaxResult.toString());
    assertEquals(0, actualMaxResult.getLowestSetBit());
    assertEquals(1, actualMaxResult.signum());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, actualMaxResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  public void testMax2() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(DataWord._2_256, DataWord.MAX_VALUE);

    // Assert
    assertEquals("115792089237316195423570985008687907853269984665640564039457584007913129639936",
        actualMaxResult.toString());
    assertEquals(1, actualMaxResult.signum());
    assertEquals(256, actualMaxResult.getLowestSetBit());
    assertArrayEquals(
        new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualMaxResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  public void testMax3() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(BigInteger.valueOf(5L), DataWord.MAX_VALUE);

    // Assert
    assertEquals("115792089237316195423570985008687907853269984665640564039457584007913129639935",
        actualMaxResult.toString());
    assertEquals(0, actualMaxResult.getLowestSetBit());
    assertEquals(1, actualMaxResult.signum());
    assertArrayEquals(new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, actualMaxResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#max(BigInteger, BigInteger)}
   */
  @Test
  public void testMax4() {
    // Arrange and Act
    BigInteger actualMaxResult = BIUtil.max(DataWord._2_256, DataWord._2_256);

    // Assert
    assertEquals("115792089237316195423570985008687907853269984665640564039457584007913129639936",
        actualMaxResult.toString());
    assertEquals(1, actualMaxResult.signum());
    assertEquals(256, actualMaxResult.getLowestSetBit());
    assertArrayEquals(
        new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualMaxResult.toByteArray());
  }

  /**
   * Method under test: {@link BIUtil#addSafely(int, int)}
   */
  @Test
  public void testAddSafely() {
    // Arrange, Act and Assert
    assertEquals(4, BIUtil.addSafely(2, 2));
    assertEquals(Integer.MAX_VALUE, BIUtil.addSafely(Integer.MAX_VALUE, 2));
    assertEquals(6, BIUtil.addSafely(4, 2));
    assertEquals(1, BIUtil.addSafely(-1, 2));
  }
}
