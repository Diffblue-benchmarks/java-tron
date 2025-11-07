package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class WitnessInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#equals(Object)}
   *   <li>{@link WitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("42 Main St", 1);
    WitnessInfo witnessInfo2 = new WitnessInfo("42 Main St", 1);

    // Act and Assert
    assertEquals(witnessInfo, witnessInfo2);
    int expectedHashCodeResult = witnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, witnessInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#equals(Object)}
   *   <li>{@link WitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo(null, 1);
    WitnessInfo witnessInfo2 = new WitnessInfo(null, 1);

    // Act and Assert
    assertEquals(witnessInfo, witnessInfo2);
    int expectedHashCodeResult = witnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, witnessInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#equals(Object)}
   *   <li>{@link WitnessInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("42 Main St", 1);

    // Act and Assert
    assertEquals(witnessInfo, witnessInfo);
    int expectedHashCodeResult = witnessInfo.hashCode();
    assertEquals(expectedHashCodeResult, witnessInfo.hashCode());
  }

  /**
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("17 High St", 1);

    // Act and Assert
    assertNotEquals(witnessInfo, new WitnessInfo("42 Main St", 1));
  }

  /**
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo(null, 1);

    // Act and Assert
    assertNotEquals(witnessInfo, new WitnessInfo("42 Main St", 1));
  }

  /**
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WitnessInfo witnessInfo = new WitnessInfo("42 Main St", 3);

    // Act and Assert
    assertNotEquals(witnessInfo, new WitnessInfo("42 Main St", 1));
  }

  /**
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WitnessInfo("42 Main St", 1), null);
  }

  /**
   * Method under test: {@link WitnessInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WitnessInfo("42 Main St", 1), "Different type to WitnessInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessInfo#WitnessInfo(String, int)}
   *   <li>{@link WitnessInfo#setAddress(String)}
   *   <li>{@link WitnessInfo#setVersion(int)}
   *   <li>{@link WitnessInfo#toString()}
   *   <li>{@link WitnessInfo#getAddress()}
   *   <li>{@link WitnessInfo#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WitnessInfo actualWitnessInfo = new WitnessInfo("42 Main St", 1);
    actualWitnessInfo.setAddress("42 Main St");
    actualWitnessInfo.setVersion(1);
    String actualToStringResult = actualWitnessInfo.toString();
    String actualAddress = actualWitnessInfo.getAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("WitnessInfo(address=42 Main St, version=1)", actualToStringResult);
    assertEquals(1, actualWitnessInfo.getVersion());
  }
}
