package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class PairDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>("Key", "Value");
    Pair<Object, Object> pair2 = new Pair<>("Key", "Value");

    // Act and Assert
    assertEquals(pair, pair2);
    int expectedHashCodeResult = pair.hashCode();
    assertEquals(expectedHashCodeResult, pair2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>("Key", "Value");

    // Act and Assert
    assertEquals(pair, pair);
    int expectedHashCodeResult = pair.hashCode();
    assertEquals(expectedHashCodeResult, pair.hashCode());
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>(1, "Value");

    // Act and Assert
    assertNotEquals(pair, new Pair<>("Key", "Value"));
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>(new Pair<>("Key", "Value"), "Value");

    // Act and Assert
    assertNotEquals(pair, new Pair<>("Key", "Value"));
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>("Key", DecodeUtil.ADDRESS_SIZE);

    // Act and Assert
    assertNotEquals(pair, new Pair<>("Key", "Value"));
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>("Key", new Pair<>("Key", "Value"));

    // Act and Assert
    assertNotEquals(pair, new Pair<>("Key", "Value"));
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>("Key", "Value");

    // Act and Assert
    assertNotEquals(pair, null);
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>("Key", "Value");

    // Act and Assert
    assertNotEquals(pair, "Different type to Pair");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#Pair(Object, Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getKey()}
   *   <li>{@link Pair#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("Key", "Value");
    String actualToStringResult = actualPair.toString();
    Object actualKey = actualPair.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Key=Value", actualToStringResult);
    assertEquals("Value", actualPair.getValue());
  }
}
