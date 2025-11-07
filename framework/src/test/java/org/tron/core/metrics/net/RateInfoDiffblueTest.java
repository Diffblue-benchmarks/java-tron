package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class RateInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateInfo#equals(Object)}
   *   <li>{@link RateInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    RateInfo rateInfo2 = new RateInfo();

    // Act and Assert
    assertEquals(rateInfo, rateInfo2);
    int expectedHashCodeResult = rateInfo.hashCode();
    assertEquals(expectedHashCodeResult, rateInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateInfo#equals(Object)}
   *   <li>{@link RateInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateInfo rateInfo = new RateInfo();

    // Act and Assert
    assertEquals(rateInfo, rateInfo);
    int expectedHashCodeResult = rateInfo.hashCode();
    assertEquals(expectedHashCodeResult, rateInfo.hashCode());
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RateInfo(), 1);
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setMeanRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setOneMinuteRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setFiveMinuteRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setFifteenMinuteRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setCount(3L);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RateInfo(), null);
  }

  /**
   * Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RateInfo(), "Different type to RateInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RateInfo}
   *   <li>{@link RateInfo#setCount(long)}
   *   <li>{@link RateInfo#setFifteenMinuteRate(double)}
   *   <li>{@link RateInfo#setFiveMinuteRate(double)}
   *   <li>{@link RateInfo#setMeanRate(double)}
   *   <li>{@link RateInfo#setOneMinuteRate(double)}
   *   <li>{@link RateInfo#toString()}
   *   <li>{@link RateInfo#getCount()}
   *   <li>{@link RateInfo#getFifteenMinuteRate()}
   *   <li>{@link RateInfo#getFiveMinuteRate()}
   *   <li>{@link RateInfo#getMeanRate()}
   *   <li>{@link RateInfo#getOneMinuteRate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RateInfo actualRateInfo = new RateInfo();
    actualRateInfo.setCount(3L);
    actualRateInfo.setFifteenMinuteRate(10.0d);
    actualRateInfo.setFiveMinuteRate(10.0d);
    actualRateInfo.setMeanRate(10.0d);
    actualRateInfo.setOneMinuteRate(10.0d);
    String actualToStringResult = actualRateInfo.toString();
    long actualCount = actualRateInfo.getCount();
    double actualFifteenMinuteRate = actualRateInfo.getFifteenMinuteRate();
    double actualFiveMinuteRate = actualRateInfo.getFiveMinuteRate();
    double actualMeanRate = actualRateInfo.getMeanRate();

    // Assert that nothing has changed
    assertEquals("RateInfo(meanRate=10.0, oneMinuteRate=10.0, fiveMinuteRate=10.0, fifteenMinuteRate=10.0, count=3)",
        actualToStringResult);
    assertEquals(10.0d, actualFifteenMinuteRate, 0.0);
    assertEquals(10.0d, actualFiveMinuteRate, 0.0);
    assertEquals(10.0d, actualMeanRate, 0.0);
    assertEquals(10.0d, actualRateInfo.getOneMinuteRate(), 0.0);
    assertEquals(3L, actualCount);
  }
}
