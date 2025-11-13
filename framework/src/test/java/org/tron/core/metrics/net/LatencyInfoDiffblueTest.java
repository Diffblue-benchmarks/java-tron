package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LatencyInfoDiffblueTest {
  /**
   * Test {@link LatencyInfo#equals(Object)}, and {@link LatencyInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LatencyInfo#equals(Object)}
   *   <li>{@link LatencyInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertEquals(latencyInfo, latencyInfo2);
    assertEquals(latencyInfo.hashCode(), latencyInfo2.hashCode());
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}, and {@link LatencyInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LatencyInfo#equals(Object)}
   *   <li>{@link LatencyInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    // Act and Assert
    assertEquals(latencyInfo, latencyInfo);
    int expectedHashCodeResult = latencyInfo.hashCode();
    assertEquals(expectedHashCodeResult, latencyInfo.hashCode());
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(3);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(3);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(3);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    ArrayList<LatencyDetailInfo> detail = new ArrayList<>();
    detail.add(latencyDetailInfo);

    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(detail);
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(3);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(3);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(3);
    latencyInfo.setTotalCount(3);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(1);

    LatencyInfo latencyInfo2 = new LatencyInfo();
    latencyInfo2.setDelay1S(1);
    latencyInfo2.setDelay2S(1);
    latencyInfo2.setDelay3S(1);
    latencyInfo2.setDetail(new ArrayList<>());
    latencyInfo2.setTop75(1);
    latencyInfo2.setTop95(1);
    latencyInfo2.setTop99(1);
    latencyInfo2.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, latencyInfo2);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, null);
  }

  /**
   * Test {@link LatencyInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LatencyInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LatencyInfo.equals(Object)", "int LatencyInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LatencyInfo latencyInfo = new LatencyInfo();
    latencyInfo.setDelay1S(1);
    latencyInfo.setDelay2S(1);
    latencyInfo.setDelay3S(1);
    latencyInfo.setDetail(new ArrayList<>());
    latencyInfo.setTop75(1);
    latencyInfo.setTop95(1);
    latencyInfo.setTop99(1);
    latencyInfo.setTotalCount(3);

    // Act and Assert
    assertNotEquals(latencyInfo, "Different type to LatencyInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LatencyInfo}
   *   <li>{@link LatencyInfo#setDelay1S(int)}
   *   <li>{@link LatencyInfo#setDelay2S(int)}
   *   <li>{@link LatencyInfo#setDelay3S(int)}
   *   <li>{@link LatencyInfo#setDetail(List)}
   *   <li>{@link LatencyInfo#setTop75(int)}
   *   <li>{@link LatencyInfo#setTop95(int)}
   *   <li>{@link LatencyInfo#setTop99(int)}
   *   <li>{@link LatencyInfo#setTotalCount(int)}
   *   <li>{@link LatencyInfo#toString()}
   *   <li>{@link LatencyInfo#getDelay1S()}
   *   <li>{@link LatencyInfo#getDelay2S()}
   *   <li>{@link LatencyInfo#getDelay3S()}
   *   <li>{@link LatencyInfo#getDetail()}
   *   <li>{@link LatencyInfo#getTop75()}
   *   <li>{@link LatencyInfo#getTop95()}
   *   <li>{@link LatencyInfo#getTop99()}
   *   <li>{@link LatencyInfo#getTotalCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LatencyInfo.<init>()",
    "int LatencyInfo.getDelay1S()",
    "int LatencyInfo.getDelay2S()",
    "int LatencyInfo.getDelay3S()",
    "List LatencyInfo.getDetail()",
    "int LatencyInfo.getTop75()",
    "int LatencyInfo.getTop95()",
    "int LatencyInfo.getTop99()",
    "int LatencyInfo.getTotalCount()",
    "void LatencyInfo.setDelay1S(int)",
    "void LatencyInfo.setDelay2S(int)",
    "void LatencyInfo.setDelay3S(int)",
    "void LatencyInfo.setDetail(List)",
    "void LatencyInfo.setTop75(int)",
    "void LatencyInfo.setTop95(int)",
    "void LatencyInfo.setTop99(int)",
    "void LatencyInfo.setTotalCount(int)",
    "String LatencyInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LatencyInfo actualLatencyInfo = new LatencyInfo();
    actualLatencyInfo.setDelay1S(1);
    actualLatencyInfo.setDelay2S(1);
    actualLatencyInfo.setDelay3S(1);
    ArrayList<LatencyDetailInfo> detail = new ArrayList<>();
    actualLatencyInfo.setDetail(detail);
    actualLatencyInfo.setTop75(1);
    actualLatencyInfo.setTop95(1);
    actualLatencyInfo.setTop99(1);
    actualLatencyInfo.setTotalCount(3);
    String actualToStringResult = actualLatencyInfo.toString();
    int actualDelay1S = actualLatencyInfo.getDelay1S();
    int actualDelay2S = actualLatencyInfo.getDelay2S();
    int actualDelay3S = actualLatencyInfo.getDelay3S();
    List<LatencyDetailInfo> actualDetail = actualLatencyInfo.getDetail();
    int actualTop75 = actualLatencyInfo.getTop75();
    int actualTop95 = actualLatencyInfo.getTop95();
    int actualTop99 = actualLatencyInfo.getTop99();

    // Assert
    assertEquals(
        "LatencyInfo(top99=1, top95=1, top75=1, totalCount=3, delay1S=1, delay2S=1, delay3S=1, detail=[])",
        actualToStringResult);
    assertEquals(1, actualDelay1S);
    assertEquals(1, actualDelay2S);
    assertEquals(1, actualDelay3S);
    assertEquals(1, actualTop75);
    assertEquals(1, actualTop95);
    assertEquals(1, actualTop99);
    assertEquals(3, actualLatencyInfo.getTotalCount());
    assertTrue(actualDetail.isEmpty());
    assertSame(detail, actualDetail);
  }
}
