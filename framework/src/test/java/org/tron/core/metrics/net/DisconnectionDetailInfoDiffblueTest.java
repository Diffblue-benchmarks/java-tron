package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DisconnectionDetailInfoDiffblueTest {
  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}, and {@link
   * DisconnectionDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DisconnectionDetailInfo#equals(Object)}
   *   <li>{@link DisconnectionDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Just cause");

    DisconnectionDetailInfo disconnectionDetailInfo2 = new DisconnectionDetailInfo();
    disconnectionDetailInfo2.setCount(3);
    disconnectionDetailInfo2.setReason("Just cause");

    // Act and Assert
    assertEquals(disconnectionDetailInfo, disconnectionDetailInfo2);
    assertEquals(disconnectionDetailInfo.hashCode(), disconnectionDetailInfo2.hashCode());
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}, and {@link
   * DisconnectionDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DisconnectionDetailInfo#equals(Object)}
   *   <li>{@link DisconnectionDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason(null);

    DisconnectionDetailInfo disconnectionDetailInfo2 = new DisconnectionDetailInfo();
    disconnectionDetailInfo2.setCount(3);
    disconnectionDetailInfo2.setReason(null);

    // Act and Assert
    assertEquals(disconnectionDetailInfo, disconnectionDetailInfo2);
    assertEquals(disconnectionDetailInfo.hashCode(), disconnectionDetailInfo2.hashCode());
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}, and {@link
   * DisconnectionDetailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DisconnectionDetailInfo#equals(Object)}
   *   <li>{@link DisconnectionDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Just cause");

    // Act and Assert
    assertEquals(disconnectionDetailInfo, disconnectionDetailInfo);
    int expectedHashCodeResult = disconnectionDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, disconnectionDetailInfo.hashCode());
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(1);
    disconnectionDetailInfo.setReason("Just cause");

    DisconnectionDetailInfo disconnectionDetailInfo2 = new DisconnectionDetailInfo();
    disconnectionDetailInfo2.setCount(3);
    disconnectionDetailInfo2.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, disconnectionDetailInfo2);
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Reason");

    DisconnectionDetailInfo disconnectionDetailInfo2 = new DisconnectionDetailInfo();
    disconnectionDetailInfo2.setCount(3);
    disconnectionDetailInfo2.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, disconnectionDetailInfo2);
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason(null);

    DisconnectionDetailInfo disconnectionDetailInfo2 = new DisconnectionDetailInfo();
    disconnectionDetailInfo2.setCount(3);
    disconnectionDetailInfo2.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, disconnectionDetailInfo2);
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, null);
  }

  /**
   * Test {@link DisconnectionDetailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DisconnectionDetailInfo.equals(Object)",
    "int DisconnectionDetailInfo.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, "Different type to DisconnectionDetailInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DisconnectionDetailInfo}
   *   <li>{@link DisconnectionDetailInfo#setCount(int)}
   *   <li>{@link DisconnectionDetailInfo#setReason(String)}
   *   <li>{@link DisconnectionDetailInfo#toString()}
   *   <li>{@link DisconnectionDetailInfo#getCount()}
   *   <li>{@link DisconnectionDetailInfo#getReason()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DisconnectionDetailInfo.<init>()",
    "int DisconnectionDetailInfo.getCount()",
    "String DisconnectionDetailInfo.getReason()",
    "void DisconnectionDetailInfo.setCount(int)",
    "void DisconnectionDetailInfo.setReason(String)",
    "String DisconnectionDetailInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DisconnectionDetailInfo actualDisconnectionDetailInfo = new DisconnectionDetailInfo();
    actualDisconnectionDetailInfo.setCount(3);
    actualDisconnectionDetailInfo.setReason("Just cause");
    String actualToStringResult = actualDisconnectionDetailInfo.toString();
    int actualCount = actualDisconnectionDetailInfo.getCount();

    // Assert
    assertEquals("DisconnectionDetailInfo(reason=Just cause, count=3)", actualToStringResult);
    assertEquals("Just cause", actualDisconnectionDetailInfo.getReason());
    assertEquals(3, actualCount);
  }
}
