package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ApiInfoDiffblueTest {
  /**
   * Test {@link ApiInfo#equals(Object)}, and {@link ApiInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiInfo#equals(Object)}
   *   <li>{@link ApiInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiInfo, apiInfo2);
    assertEquals(apiInfo.hashCode(), apiInfo2.hashCode());
  }

  /**
   * Test {@link ApiInfo#equals(Object)}, and {@link ApiInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiInfo#equals(Object)}
   *   <li>{@link ApiInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(null);
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(null);
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiInfo, apiInfo2);
    assertEquals(apiInfo.hashCode(), apiInfo2.hashCode());
  }

  /**
   * Test {@link ApiInfo#equals(Object)}, and {@link ApiInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiInfo#equals(Object)}
   *   <li>{@link ApiInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(null);
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(null);
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiInfo, apiInfo2);
    assertEquals(apiInfo.hashCode(), apiInfo2.hashCode());
  }

  /**
   * Test {@link ApiInfo#equals(Object)}, and {@link ApiInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiInfo#equals(Object)}
   *   <li>{@link ApiInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(null);

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(null);

    // Act and Assert
    assertEquals(apiInfo, apiInfo2);
    assertEquals(apiInfo.hashCode(), apiInfo2.hashCode());
  }

  /**
   * Test {@link ApiInfo#equals(Object)}, and {@link ApiInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiInfo#equals(Object)}
   *   <li>{@link ApiInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    // Act and Assert
    assertEquals(apiInfo, apiInfo);
    int expectedHashCodeResult = apiInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiInfo.hashCode());
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiDetailInfo apiDetailInfo = new ApiDetailInfo();
    apiDetailInfo.setFailQps(new RateInfo());
    apiDetailInfo.setName("Name");
    apiDetailInfo.setOutTraffic(new RateInfo());
    apiDetailInfo.setQps(new RateInfo());

    ArrayList<ApiDetailInfo> detail = new ArrayList<>();
    detail.add(apiDetailInfo);

    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(detail);
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(null);
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(mock(RateInfo.class));
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(null);
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(mock(RateInfo.class));
    apiInfo.setQps(new RateInfo());

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(null);

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(mock(RateInfo.class));

    ApiInfo apiInfo2 = new ApiInfo();
    apiInfo2.setDetail(new ArrayList<>());
    apiInfo2.setFailQps(new RateInfo());
    apiInfo2.setOutTraffic(new RateInfo());
    apiInfo2.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, apiInfo2);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, null);
  }

  /**
   * Test {@link ApiInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiInfo.equals(Object)", "int ApiInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiInfo apiInfo = new ApiInfo();
    apiInfo.setDetail(new ArrayList<>());
    apiInfo.setFailQps(new RateInfo());
    apiInfo.setOutTraffic(new RateInfo());
    apiInfo.setQps(new RateInfo());

    // Act and Assert
    assertNotEquals(apiInfo, "Different type to ApiInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ApiInfo}
   *   <li>{@link ApiInfo#setDetail(List)}
   *   <li>{@link ApiInfo#setFailQps(RateInfo)}
   *   <li>{@link ApiInfo#setOutTraffic(RateInfo)}
   *   <li>{@link ApiInfo#setQps(RateInfo)}
   *   <li>{@link ApiInfo#toString()}
   *   <li>{@link ApiInfo#getDetail()}
   *   <li>{@link ApiInfo#getFailQps()}
   *   <li>{@link ApiInfo#getOutTraffic()}
   *   <li>{@link ApiInfo#getQps()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiInfo.<init>()",
    "List ApiInfo.getDetail()",
    "RateInfo ApiInfo.getFailQps()",
    "RateInfo ApiInfo.getOutTraffic()",
    "RateInfo ApiInfo.getQps()",
    "void ApiInfo.setDetail(List)",
    "void ApiInfo.setFailQps(RateInfo)",
    "void ApiInfo.setOutTraffic(RateInfo)",
    "void ApiInfo.setQps(RateInfo)",
    "String ApiInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ApiInfo actualApiInfo = new ApiInfo();
    ArrayList<ApiDetailInfo> detail = new ArrayList<>();
    actualApiInfo.setDetail(detail);
    RateInfo failQps = new RateInfo();
    actualApiInfo.setFailQps(failQps);
    RateInfo outTraffic = new RateInfo();
    actualApiInfo.setOutTraffic(outTraffic);
    RateInfo qps = new RateInfo();
    actualApiInfo.setQps(qps);
    String actualToStringResult = actualApiInfo.toString();
    List<ApiDetailInfo> actualDetail = actualApiInfo.getDetail();
    RateInfo actualFailQps = actualApiInfo.getFailQps();
    RateInfo actualOutTraffic = actualApiInfo.getOutTraffic();
    RateInfo actualQps = actualApiInfo.getQps();

    // Assert
    assertEquals(
        "ApiInfo(qps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0,"
            + " count=0), failQps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0,"
            + " count=0), outTraffic=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0,"
            + " count=0), detail=[])",
        actualToStringResult);
    assertTrue(actualDetail.isEmpty());
    assertSame(detail, actualDetail);
    assertSame(failQps, actualFailQps);
    assertSame(outTraffic, actualOutTraffic);
    assertSame(qps, actualQps);
  }
}
