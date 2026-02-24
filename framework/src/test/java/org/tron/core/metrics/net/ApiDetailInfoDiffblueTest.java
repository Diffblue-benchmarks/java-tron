package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ApiDetailInfoDiffblueTest {
  /**
   * Test {@link ApiDetailInfo#equals(Object)}, and {@link ApiDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
    assertEquals(apiDetailInfo.hashCode(), apiDetailInfo2.hashCode());
  }

  /**
   * Test {@link ApiDetailInfo#equals(Object)}, and {@link ApiDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
    assertEquals(apiDetailInfo.hashCode(), apiDetailInfo2.hashCode());
  }

  /**
   * Test {@link ApiDetailInfo#equals(Object)}, and {@link ApiDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
    assertEquals(apiDetailInfo.hashCode(), apiDetailInfo2.hashCode());
  }

  /**
   * Test {@link ApiDetailInfo#equals(Object)}, and {@link ApiDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
    assertEquals(apiDetailInfo.hashCode(), apiDetailInfo2.hashCode());
  }

  /**
   * Test {@link ApiDetailInfo#equals(Object)}, and {@link ApiDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
    assertEquals(apiDetailInfo.hashCode(), apiDetailInfo2.hashCode());
  }

  /**
   * Test {@link ApiDetailInfo#equals(Object)}, and {@link ApiDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiDetailInfo#equals(Object)}
   *   <li>{@link ApiDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test {@link ApiDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiDetailInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiDetailInfo.equals(Object)", "int ApiDetailInfo.hashCode()"})
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiDetailInfo.<init>()",
    "RateInfo ApiDetailInfo.getFailQps()",
    "String ApiDetailInfo.getName()",
    "RateInfo ApiDetailInfo.getOutTraffic()",
    "RateInfo ApiDetailInfo.getQps()",
    "void ApiDetailInfo.setFailQps(RateInfo)",
    "void ApiDetailInfo.setName(String)",
    "void ApiDetailInfo.setOutTraffic(RateInfo)",
    "void ApiDetailInfo.setQps(RateInfo)",
    "String ApiDetailInfo.toString()"
  })
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

    // Assert
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
