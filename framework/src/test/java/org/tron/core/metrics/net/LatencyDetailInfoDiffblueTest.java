package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class LatencyDetailInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LatencyDetailInfo#equals(Object)}
   *   <li>{@link LatencyDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertEquals(latencyDetailInfo, latencyDetailInfo2);
    int expectedHashCodeResult = latencyDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, latencyDetailInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LatencyDetailInfo#equals(Object)}
   *   <li>{@link LatencyDetailInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(latencyDetailInfo, latencyDetailInfo);
    int expectedHashCodeResult = latencyDetailInfo.hashCode();
    assertEquals(expectedHashCodeResult, latencyDetailInfo.hashCode());
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(1);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(3);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(3);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(3);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(3);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(3);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(3);
    latencyDetailInfo.setWitness("Witness");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness(null);

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LatencyDetailInfo latencyDetailInfo = new LatencyDetailInfo();
    latencyDetailInfo.setCount(3);
    latencyDetailInfo.setDelay1S(1);
    latencyDetailInfo.setDelay2S(1);
    latencyDetailInfo.setDelay3S(1);
    latencyDetailInfo.setTop75(1);
    latencyDetailInfo.setTop95(1);
    latencyDetailInfo.setTop99(1);
    latencyDetailInfo.setWitness("org.tron.core.metrics.net.LatencyDetailInfo");

    LatencyDetailInfo latencyDetailInfo2 = new LatencyDetailInfo();
    latencyDetailInfo2.setCount(3);
    latencyDetailInfo2.setDelay1S(1);
    latencyDetailInfo2.setDelay2S(1);
    latencyDetailInfo2.setDelay3S(1);
    latencyDetailInfo2.setTop75(1);
    latencyDetailInfo2.setTop95(1);
    latencyDetailInfo2.setTop99(1);
    latencyDetailInfo2.setWitness("Witness");

    // Act and Assert
    assertNotEquals(latencyDetailInfo, latencyDetailInfo2);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(latencyDetailInfo, null);
  }

  /**
   * Method under test: {@link LatencyDetailInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(latencyDetailInfo, "Different type to LatencyDetailInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LatencyDetailInfo}
   *   <li>{@link LatencyDetailInfo#setCount(int)}
   *   <li>{@link LatencyDetailInfo#setDelay1S(int)}
   *   <li>{@link LatencyDetailInfo#setDelay2S(int)}
   *   <li>{@link LatencyDetailInfo#setDelay3S(int)}
   *   <li>{@link LatencyDetailInfo#setTop75(int)}
   *   <li>{@link LatencyDetailInfo#setTop95(int)}
   *   <li>{@link LatencyDetailInfo#setTop99(int)}
   *   <li>{@link LatencyDetailInfo#setWitness(String)}
   *   <li>{@link LatencyDetailInfo#toString()}
   *   <li>{@link LatencyDetailInfo#getCount()}
   *   <li>{@link LatencyDetailInfo#getDelay1S()}
   *   <li>{@link LatencyDetailInfo#getDelay2S()}
   *   <li>{@link LatencyDetailInfo#getDelay3S()}
   *   <li>{@link LatencyDetailInfo#getTop75()}
   *   <li>{@link LatencyDetailInfo#getTop95()}
   *   <li>{@link LatencyDetailInfo#getTop99()}
   *   <li>{@link LatencyDetailInfo#getWitness()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LatencyDetailInfo actualLatencyDetailInfo = new LatencyDetailInfo();
    actualLatencyDetailInfo.setCount(3);
    actualLatencyDetailInfo.setDelay1S(1);
    actualLatencyDetailInfo.setDelay2S(1);
    actualLatencyDetailInfo.setDelay3S(1);
    actualLatencyDetailInfo.setTop75(1);
    actualLatencyDetailInfo.setTop95(1);
    actualLatencyDetailInfo.setTop99(1);
    actualLatencyDetailInfo.setWitness("Witness");
    String actualToStringResult = actualLatencyDetailInfo.toString();
    int actualCount = actualLatencyDetailInfo.getCount();
    int actualDelay1S = actualLatencyDetailInfo.getDelay1S();
    int actualDelay2S = actualLatencyDetailInfo.getDelay2S();
    int actualDelay3S = actualLatencyDetailInfo.getDelay3S();
    int actualTop75 = actualLatencyDetailInfo.getTop75();
    int actualTop95 = actualLatencyDetailInfo.getTop95();
    int actualTop99 = actualLatencyDetailInfo.getTop99();

    // Assert that nothing has changed
    assertEquals(
        "LatencyDetailInfo(witness=Witness, top99=1, top95=1, top75=1, count=3, delay1S=1, delay2S=1," + " delay3S=1)",
        actualToStringResult);
    assertEquals("Witness", actualLatencyDetailInfo.getWitness());
    assertEquals(1, actualDelay1S);
    assertEquals(1, actualDelay2S);
    assertEquals(1, actualDelay3S);
    assertEquals(1, actualTop75);
    assertEquals(1, actualTop95);
    assertEquals(1, actualTop99);
    assertEquals(3, actualCount);
  }
}
