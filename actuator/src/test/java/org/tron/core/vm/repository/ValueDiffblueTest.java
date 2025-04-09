package org.tron.core.vm.repository;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.ProtoCapsule;

public class ValueDiffblueTest {
  /**
   * Test {@link Value#create(ProtoCapsule, int)} with {@code capsule}, {@code type}.
   * <ul>
   *   <li>Given {@code Instance}.</li>
   *   <li>Then return Value is {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(ProtoCapsule, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(ProtoCapsule, int)"})
  public void testCreateWithCapsuleType_givenInstance_thenReturnValueIsInstance() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");

    // Act
    Value<Object> actualCreateResult = Value.create(capsule, 1);

    // Assert
    verify(capsule).getInstance();
    assertEquals("Instance", actualCreateResult.getValue());
    Type type = actualCreateResult.getType();
    assertEquals(1, type.type);
    assertFalse(type.isCreate());
    assertFalse(type.isNormal());
    assertTrue(type.isDirty());
  }

  /**
   * Test {@link Value#create(ProtoCapsule, int)} with {@code capsule}, {@code type}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(ProtoCapsule, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(ProtoCapsule, int)"})
  public void testCreateWithCapsuleType_givenNull_thenReturnValueIsNull() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn(null);

    // Act
    Value<Object> actualCreateResult = Value.create(capsule, 1);

    // Assert
    verify(capsule).getInstance();
    assertNull(actualCreateResult.getValue());
    assertNull(actualCreateResult.getType());
  }

  /**
   * Test {@link Value#create(ProtoCapsule)} with {@code capsule}.
   * <ul>
   *   <li>Given {@code Instance}.</li>
   *   <li>Then return Value is {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(ProtoCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(ProtoCapsule)"})
  public void testCreateWithCapsule_givenInstance_thenReturnValueIsInstance() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");

    // Act
    Value<Object> actualCreateResult = Value.create(capsule);

    // Assert
    verify(capsule).getInstance();
    assertEquals("Instance", actualCreateResult.getValue());
    Type type = actualCreateResult.getType();
    assertEquals(0, type.type);
    assertFalse(type.isCreate());
    assertFalse(type.isDirty());
    assertTrue(type.isNormal());
  }

  /**
   * Test {@link Value#create(ProtoCapsule)} with {@code capsule}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(ProtoCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(ProtoCapsule)"})
  public void testCreateWithCapsule_givenNull_thenReturnValueIsNull() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn(null);

    // Act
    Value<Object> actualCreateResult = Value.create(capsule);

    // Assert
    verify(capsule).getInstance();
    assertNull(actualCreateResult.getValue());
    assertNull(actualCreateResult.getType());
  }

  /**
   * Test {@link Value#create(byte[], int)} with {@code value}, {@code type}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Type {@link Type#type} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(byte[], int)"})
  public void testCreateWithValueType_whenAxaxaxaxBytesIsUtf8_thenReturnTypeTypeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Value<byte[]> actualCreateResult = Value.create("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    Type type = actualCreateResult.getType();
    assertEquals(1, type.type);
    assertFalse(type.isCreate());
    assertFalse(type.isNormal());
    assertTrue(type.isDirty());
    byte[] expectedValue = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue, actualCreateResult.getValue());
  }

  /**
   * Test {@link Value#create(byte[], int)} with {@code value}, {@code type}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(byte[], int)"})
  public void testCreateWithValueType_whenEmptyArrayOfByte_thenReturnValueIsNull() {
    // Arrange and Act
    Value<byte[]> actualCreateResult = Value.create(new byte[]{}, 1);

    // Assert
    assertNull(actualCreateResult.getValue());
    assertNull(actualCreateResult.getType());
  }

  /**
   * Test {@link Value#create(byte[])} with {@code value}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Type {@link Type#type} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(byte[])"})
  public void testCreateWithValue_whenAxaxaxaxBytesIsUtf8_thenReturnTypeTypeIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Value<byte[]> actualCreateResult = Value.create("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Type type = actualCreateResult.getType();
    assertEquals(0, type.type);
    assertFalse(type.isCreate());
    assertFalse(type.isDirty());
    assertTrue(type.isNormal());
    byte[] expectedValue = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue, actualCreateResult.getValue());
  }

  /**
   * Test {@link Value#create(byte[])} with {@code value}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.create(byte[])"})
  public void testCreateWithValue_whenEmptyArrayOfByte_thenReturnValueIsNull() {
    // Arrange and Act
    Value<byte[]> actualCreateResult = Value.create(new byte[]{});

    // Assert
    assertNull(actualCreateResult.getValue());
    assertNull(actualCreateResult.getType());
  }

  /**
   * Test {@link Value#equals(Object)}, and {@link Value#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> createResult2 = Value.create(capsule2, 1);

    // Act and Assert
    assertEquals(createResult, createResult2);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult2.hashCode());
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn(null);
    Value<Object> createResult = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> createResult2 = Value.create(capsule2, 1);

    // Act and Assert
    assertNotEquals(createResult, createResult2);
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);

    // Act and Assert
    assertNotEquals(createResult, null);
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);

    // Act and Assert
    assertNotEquals(createResult, 1);
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn(createResult);
    Value<Object> createResult2 = Value.create(capsule2, 1);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> createResult3 = Value.create(capsule3, 1);

    // Act and Assert
    assertNotEquals(createResult2, createResult3);
  }
}
