package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class ApiDetailInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiDetailInfo, apiDetailInfo2);
    int expectedHashCodeResult = apiDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(null);
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(null);
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiDetailInfo, apiDetailInfo2);
    int expectedHashCodeResult = apiDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName(null);
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName(null);
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiDetailInfo, apiDetailInfo2);
    int expectedHashCodeResult = apiDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(null);
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(null);
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiDetailInfo, apiDetailInfo2);
    int expectedHashCodeResult = apiDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(null);

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(null);

    // Act and Assert
    assertEquals(apiDetailInfo, apiDetailInfo2);
    int expectedHashCodeResult = apiDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiDetailInfo, apiDetailInfo);
    int expectedHashCodeResult = apiDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiDetailInfo.hashCode());
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(null);
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(mock(RateInfo.class));
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName(null);
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("org.tron.core.metrics.net.ApiDetailInfo");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(null);
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(mock(RateInfo.class));
    apiDetailInfo.setQps(new RateInfo());

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(null);

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(mock(RateInfo.class));

    ApiDetailInfo apiDetailInfo2 = new ApiDetailInfo();
    apiDetailInfo2.setFailQps(new RateInfo());
    apiDetailInfo2.setName("Name");
    apiDetailInfo2.setOutTraffic(new RateInfo());
    apiDetailInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, apiDetailInfo2);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, null);
  }

  /**
   * Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiDetailInfo, "Different type to ApiDetailInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ApiDetailInfo}
   *   <li>{@link ApiDetailInfo#setFailQps(RateInfo)}
   *   <li>{@link ApiDetailInfo#setName(String)}
   *   <li>{@link ApiDetailInfo#setOutTraffic(RateInfo)}
   *   <li>{@link ApiDetailInfo#setQps(RateInfo)}
   *   <li>{@link ApiDetailInfo#toString()}
   *   <li>{@link ApiDetailInfo#getFailQps()}
   *   <li>{@link ApiDetailInfo#getName()}
   *   <li>{@link ApiDetailInfo#getOutTraffic()}
   *   <li>{@link ApiDetailInfo#getQps()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ApiDetailInfo actualApiDetailInfo = new ApiDetailInfo();
    RateInfo failQps = new RateInfo();
    actualApiDetailInfo.setFailQps(failQps);
    actualApiDetailInfo.setName("Name");
    RateInfo outTraffic = new RateInfo();
    actualApiDetailInfo.setOutTraffic(outTraffic);
    RateInfo qps = new RateInfo();
    actualApiDetailInfo.setQps(qps);
    String actualToStringResult = actualApiDetailInfo.toString();
    RateInfo actualFailQps = actualApiDetailInfo.getFailQps();
    String actualName = actualApiDetailInfo.getName();
    RateInfo actualOutTraffic = actualApiDetailInfo.getOutTraffic();

    // Assert that nothing has changed
    assertEquals(
        "ApiDetailInfo(name=Name, qps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate"
            + "=0.0, count=0), failQps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0,"
            + " count=0), outTraffic=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0,"
            + " count=0))",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertSame(failQps, actualFailQps);
    assertSame(outTraffic, actualOutTraffic);
    assertSame(qps, actualApiDetailInfo.getQps());
  }
}
