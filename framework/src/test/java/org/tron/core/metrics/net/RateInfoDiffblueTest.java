package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MetricsInfo;

public class RateInfoDiffblueTest {
  /**
   * Test {@link RateInfo#toProtoEntity()}.
   *
   * <p>Method under test: {@link RateInfo#toProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricsInfo.RateInfo RateInfo.toProtoEntity()"})
  public void testToProtoEntity() {
    // Arrange and Act
    MetricsInfo.RateInfo actualToProtoEntityResult = new RateInfo().toProtoEntity();

    // Assert
    assertEquals("", actualToProtoEntityResult.getInitializationErrorString());
    assertEquals(0, actualToProtoEntityResult.getSerializedSize());
    assertEquals(0.0d, actualToProtoEntityResult.getFifteenMinuteRate(), 0.0);
    assertEquals(0.0d, actualToProtoEntityResult.getFiveMinuteRate(), 0.0);
    assertEquals(0.0d, actualToProtoEntityResult.getMeanRate(), 0.0);
    assertEquals(0.0d, actualToProtoEntityResult.getOneMinuteRate(), 0.0);
    assertEquals(0L, actualToProtoEntityResult.getCount());
    assertTrue(actualToProtoEntityResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoEntityResult.getAllFields().isEmpty());
    assertTrue(actualToProtoEntityResult.isInitialized());
    MetricsInfo.RateInfo actualDefaultInstanceForType =
        actualToProtoEntityResult.getDefaultInstanceForType();
    assertEquals(actualToProtoEntityResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link RateInfo#equals(Object)}, and {@link RateInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateInfo#equals(Object)}
   *   <li>{@link RateInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    RateInfo rateInfo2 = new RateInfo();

    // Act and Assert
    assertEquals(rateInfo, rateInfo2);
    assertEquals(rateInfo.hashCode(), rateInfo2.hashCode());
  }

  /**
   * Test {@link RateInfo#equals(Object)}, and {@link RateInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateInfo#equals(Object)}
   *   <li>{@link RateInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateInfo rateInfo = new RateInfo();

    // Act and Assert
    assertEquals(rateInfo, rateInfo);
    int expectedHashCodeResult = rateInfo.hashCode();
    assertEquals(expectedHashCodeResult, rateInfo.hashCode());
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RateInfo(), 1);
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setMeanRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setOneMinuteRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setFiveMinuteRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setFifteenMinuteRate(10.0d);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateInfo rateInfo = new RateInfo();
    rateInfo.setCount(3L);

    // Act and Assert
    assertNotEquals(rateInfo, new RateInfo());
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RateInfo(), null);
  }

  /**
   * Test {@link RateInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateInfo.equals(Object)", "int RateInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RateInfo(), "Different type to RateInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateInfo.<init>()",
    "long RateInfo.getCount()",
    "double RateInfo.getFifteenMinuteRate()",
    "double RateInfo.getFiveMinuteRate()",
    "double RateInfo.getMeanRate()",
    "double RateInfo.getOneMinuteRate()",
    "void RateInfo.setCount(long)",
    "void RateInfo.setFifteenMinuteRate(double)",
    "void RateInfo.setFiveMinuteRate(double)",
    "void RateInfo.setMeanRate(double)",
    "void RateInfo.setOneMinuteRate(double)",
    "String RateInfo.toString()"
  })
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

    // Assert
    assertEquals(
        "RateInfo(meanRate=10.0, oneMinuteRate=10.0, fiveMinuteRate=10.0, fifteenMinuteRate=10.0, count=3)",
        actualToStringResult);
    assertEquals(10.0d, actualFifteenMinuteRate, 0.0);
    assertEquals(10.0d, actualFiveMinuteRate, 0.0);
    assertEquals(10.0d, actualMeanRate, 0.0);
    assertEquals(10.0d, actualRateInfo.getOneMinuteRate(), 0.0);
    assertEquals(3L, actualCount);
  }
}
