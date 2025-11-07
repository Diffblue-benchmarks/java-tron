package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class DisconnectionDetailInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DisconnectionDetailInfo#equals(Object)}
   *   <li>{@link DisconnectionDetailInfo#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = disconnectionDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, disconnectionDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DisconnectionDetailInfo#equals(Object)}
   *   <li>{@link DisconnectionDetailInfo#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = disconnectionDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, disconnectionDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DisconnectionDetailInfo#equals(Object)}
   *   <li>{@link DisconnectionDetailInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, null);
  }

  /**
   * Method under test: {@link DisconnectionDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DisconnectionDetailInfo disconnectionDetailInfo = new DisconnectionDetailInfo();
    disconnectionDetailInfo.setCount(3);
    disconnectionDetailInfo.setReason("Just cause");

    // Act and Assert
    assertNotEquals(disconnectionDetailInfo, "Different type to DisconnectionDetailInfo");
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    DisconnectionDetailInfo actualDisconnectionDetailInfo = new DisconnectionDetailInfo();
    actualDisconnectionDetailInfo.setCount(3);
    actualDisconnectionDetailInfo.setReason("Just cause");
    String actualToStringResult = actualDisconnectionDetailInfo.toString();
    int actualCount = actualDisconnectionDetailInfo.getCount();

    // Assert that nothing has changed
    assertEquals("DisconnectionDetailInfo(reason=Just cause, count=3)", actualToStringResult);
    assertEquals("Just cause", actualDisconnectionDetailInfo.getReason());
    assertEquals(3, actualCount);
  }
}
