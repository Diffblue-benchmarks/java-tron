package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ByteArrayMapDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ByteArrayMap#ByteArrayMap()}
   *   <li>{@link ByteArrayMap#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ByteArrayMap.<init>()",
    "void ByteArrayMap.<init>(Map)",
    "java.lang.String ByteArrayMap.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ByteArrayMap<Object> actualObjectMap = new ByteArrayMap<>();

    // Assert
    assertEquals("{}", actualObjectMap.toString());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ByteArrayMap#ByteArrayMap(Map)}
   *   <li>{@link ByteArrayMap#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ByteArrayMap.<init>()",
    "void ByteArrayMap.<init>(Map)",
    "java.lang.String ByteArrayMap.toString()"
  })
  public void testGettersAndSetters_whenHashMap() {
    // Arrange and Act
    ByteArrayMap<Object> actualObjectMap = new ByteArrayMap<>(new HashMap<>());

    // Assert
    assertEquals("{}", actualObjectMap.toString());
  }

  /**
   * Test {@link ByteArrayMap#size()}.
   *
   * <p>Method under test: {@link ByteArrayMap#size()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteArrayMap.size()"})
  public void testSize() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertEquals(0, objectMap.size());
  }

  /**
   * Test {@link ByteArrayMap#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.isEmpty()"})
  public void testIsEmpty_givenA_thenReturnFalse() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[] {'A', 4, 'A', 4, 'A', 4, 'A', 4}, "Value");

    // Act and Assert
    assertFalse(objectMap.isEmpty());
  }

  /**
   * Test {@link ByteArrayMap#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayMap#ByteArrayMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.isEmpty()"})
  public void testIsEmpty_givenByteArrayMap_thenReturnTrue() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.isEmpty());
  }

  /**
   * Test {@link ByteArrayMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#containsValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.containsValue(Object)"})
  public void testContainsValue_givenA_thenReturnTrue() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[] {'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    // Act and Assert
    assertTrue(objectMap.containsValue("Value"));
  }

  /**
   * Test {@link ByteArrayMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayMap#ByteArrayMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#containsValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.containsValue(Object)"})
  public void testContainsValue_givenByteArrayMap_thenReturnFalse() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertFalse(objectMap.containsValue("Value"));
  }

  /**
   * Test {@link ByteArrayMap#put(byte[], Object)} with {@code byte[]}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayMap#ByteArrayMap()}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#put(byte[], Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ByteArrayMap.put(byte[], Object)"})
  public void testPutWithByteObject_givenByteArrayMap_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertNull(objectMap.put("AXAXAXAX".getBytes("UTF-8"), "Value"));
    assertEquals(1, objectMap.size());
  }

  /**
   * Test {@link ByteArrayMap#put(byte[], Object)} with {@code byte[]}, {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#put(byte[], Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ByteArrayMap.put(byte[], Object)"})
  public void testPutWithByteObject_thenReturnValue() throws UnsupportedEncodingException {
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
   * Test {@link ByteArrayMap#putAll(Map)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link ByteArrayMap#ByteArrayMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#putAll(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteArrayMap.putAll(Map)"})
  public void testPutAll_givenAxaxaxaxBytesIsUtf8_thenByteArrayMapSizeIsOne()
      throws UnsupportedEncodingException {
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
   * Test {@link ByteArrayMap#putAll(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ByteArrayMap#ByteArrayMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#putAll(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteArrayMap.putAll(Map)"})
  public void testPutAll_whenHashMap_thenByteArrayMapEmpty() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act
    objectMap.putAll(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(objectMap.isEmpty());
  }

  /**
   * Test {@link ByteArrayMap#keySet()}.
   *
   * <p>Method under test: {@link ByteArrayMap#keySet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ByteArrayMap.keySet()"})
  public void testKeySet() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.keySet().isEmpty());
  }

  /**
   * Test {@link ByteArrayMap#values()}.
   *
   * <p>Method under test: {@link ByteArrayMap#values()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection ByteArrayMap.values()"})
  public void testValues() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.values().isEmpty());
  }

  /**
   * Test {@link ByteArrayMap#entrySet()}.
   *
   * <p>Method under test: {@link ByteArrayMap#entrySet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ByteArrayMap.entrySet()"})
  public void testEntrySet() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertTrue(objectMap.entrySet().isEmpty());
  }

  /**
   * Test {@link ByteArrayMap#equals(Object)}, and {@link ByteArrayMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ByteArrayMap#equals(Object)}
   *   <li>{@link ByteArrayMap#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.equals(Object)", "int ByteArrayMap.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    ByteArrayMap<Object> objectMap2 = new ByteArrayMap<>();

    // Act and Assert
    assertEquals(objectMap, objectMap2);
    assertEquals(objectMap.hashCode(), objectMap2.hashCode());
  }

  /**
   * Test {@link ByteArrayMap#equals(Object)}, and {@link ByteArrayMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ByteArrayMap#equals(Object)}
   *   <li>{@link ByteArrayMap#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.equals(Object)", "int ByteArrayMap.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertEquals(objectMap, objectMap);
    int expectedHashCodeResult = objectMap.hashCode();
    assertEquals(expectedHashCodeResult, objectMap.hashCode());
  }

  /**
   * Test {@link ByteArrayMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.equals(Object)", "int ByteArrayMap.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[] {'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    // Act and Assert
    assertNotEquals(objectMap, new ByteArrayMap<>());
  }

  /**
   * Test {@link ByteArrayMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.equals(Object)", "int ByteArrayMap.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();
    objectMap.put(new byte[] {'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    ByteArrayMap<Object> objectMap2 = new ByteArrayMap<>();
    objectMap2.put(new byte[] {'A', 5, 'A', 5, 'A', 5, 'A', 5}, "Value");

    // Act and Assert
    assertNotEquals(objectMap, objectMap2);
  }

  /**
   * Test {@link ByteArrayMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.equals(Object)", "int ByteArrayMap.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertNotEquals(objectMap, null);
  }

  /**
   * Test {@link ByteArrayMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayMap#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArrayMap.equals(Object)", "int ByteArrayMap.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ByteArrayMap<Object> objectMap = new ByteArrayMap<>();

    // Act and Assert
    assertNotEquals(objectMap, "Different type to ByteArrayMap");
  }
}
