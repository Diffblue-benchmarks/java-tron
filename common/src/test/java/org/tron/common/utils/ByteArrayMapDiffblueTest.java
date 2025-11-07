package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class ByteArrayMapDiffblueTest {
  /**
   * Method under test: {@link ByteArrayMap#size()}
   */
  @Test
  public void testSize() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertEquals(0, objectMap.size());
  }

  /**
   * Method under test: {@link ByteArrayMap#size()}
   */
  @Test
  public void testSize2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<byte[], Object> m = new HashMap<>();
    m.computeIfPresent("AXAXAXAX".getBytes("UTF-8"), mock(BiFunction.class));

    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.putAll(m);

    // Act and Assert
    assertEquals(0, objectMap.size());
  }

  /**
   * Method under test: {@link ByteArrayMap#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#isEmpty()}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4}, "Value");

    // Act and Assert
    assertFalse(objectMap.isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#containsValue(Object)}
   */
  @Test
  public void testContainsValue() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertFalse(objectMap.containsValue("Value"));
  }

  /**
   * Method under test: {@link ByteArrayMap#containsValue(Object)}
   */
  @Test
  public void testContainsValue2() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[]{'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    // Act and Assert
    assertTrue(objectMap.containsValue("Value"));
  }

  /**
   * Method under test: {@link ByteArrayMap#put(byte[], Object)}
   */
  @Test
  public void testPut() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertNull(objectMap.put("AXAXAXAX".getBytes("UTF-8"), "Value"));
    assertEquals(1, objectMap.size());
  }

  /**
   * Method under test: {@link ByteArrayMap#put(byte[], Object)}
   */
  @Test
  public void testPut2() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put("AXAXAXAX".getBytes("UTF-8"), "Value");

    // Act
    Object actualPutResult = objectMap.put("AXAXAXAX".getBytes("UTF-8"), "Value");

    // Assert
    assertEquals(1, objectMap.size());
    assertEquals("Value", actualPutResult);
  }

  /**
   * Method under test: {@link ByteArrayMap#putAll(Map)}
   */
  @Test
  public void testPutAll() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act
    objectMap.putAll(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(objectMap.isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#putAll(Map)}
   */
  @Test
  public void testPutAll2() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    HashMap<byte[], Object> m = new HashMap<>();
    m.put("AXAXAXAX".getBytes("UTF-8"), "42");

    // Act
    objectMap.putAll(m);

    // Assert
    assertEquals(1, objectMap.size());
  }

  /**
   * Method under test: {@link ByteArrayMap#putAll(Map)}
   */
  @Test
  public void testPutAll3() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    HashMap<byte[], Object> m = new HashMap<>();
    m.computeIfPresent("AXAXAXAX".getBytes("UTF-8"), mock(BiFunction.class));
    m.put("AXAXAXAX".getBytes("UTF-8"), "42");

    // Act
    objectMap.putAll(m);

    // Assert
    assertEquals(1, objectMap.size());
  }

  /**
   * Method under test: {@link ByteArrayMap#keySet()}
   */
  @Test
  public void testKeySet() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.keySet().isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#keySet()}
   */
  @Test
  public void testKeySet2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<byte[], Object> m = new HashMap<>();
    m.computeIfPresent("AXAXAXAX".getBytes("UTF-8"), mock(BiFunction.class));

    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.putAll(m);

    // Act and Assert
    assertTrue(objectMap.keySet().isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#values()}
   */
  @Test
  public void testValues() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.values().isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#values()}
   */
  @Test
  public void testValues2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<byte[], Object> m = new HashMap<>();
    m.computeIfPresent("AXAXAXAX".getBytes("UTF-8"), mock(BiFunction.class));

    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.putAll(m);

    // Act and Assert
    assertTrue(objectMap.values().isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#entrySet()}
   */
  @Test
  public void testEntrySet() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.entrySet().isEmpty());
  }

  /**
   * Method under test: {@link ByteArrayMap#entrySet()}
   */
  @Test
  public void testEntrySet2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<byte[], Object> m = new HashMap<>();
    m.computeIfPresent("AXAXAXAX".getBytes("UTF-8"), mock(BiFunction.class));

    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.putAll(m);

    // Act and Assert
    assertTrue(objectMap.entrySet().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayMap#equals(Object)}
   *   <li>{@link ByteArrayMap#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    ByteArrayMap<Object> objectMap2 = new ByteArrayMap<>();

    // Act and Assert
    assertEquals(objectMap, objectMap2);
    int expectedHashCodeResult = objectMap.hashCode();
    assertEquals(expectedHashCodeResult, objectMap2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayMap#equals(Object)}
   *   <li>{@link ByteArrayMap#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertEquals(objectMap, objectMap);
    int expectedHashCodeResult = objectMap.hashCode();
    assertEquals(expectedHashCodeResult, objectMap.hashCode());
  }

  /**
   * Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[]{'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    // Act and Assert
    assertNotEquals(objectMap, new ByteArrayMap<>());
  }

  /**
   * Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[]{'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    ByteArrayMap<Object> objectMap2 = new ByteArrayMap<>();
    objectMap2.put(new byte[]{'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    // Act and Assert
    assertNotEquals(objectMap, objectMap2);
  }

  /**
   * Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertNotEquals(objectMap, null);
  }

  /**
   * Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertNotEquals(objectMap, "Different type to ByteArrayMap");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayMap#ByteArrayMap()}
   *   <li>{@link ByteArrayMap#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ByteArrayMap<Object> actualObjectMap = new ByteArrayMap<>();

    // Assert
    assertEquals("{}", actualObjectMap.toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayMap#ByteArrayMap(Map)}
   *   <li>{@link ByteArrayMap#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ByteArrayMap<Object> actualObjectMap = new ByteArrayMap<>(new HashMap<>());

    // Assert
    assertEquals("{}", actualObjectMap.toString());
  }
}
