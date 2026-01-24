package org.tron.core.vm.repository;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.ProtoCapsule;

public class ValueDiffblueTest {
  /**
   * Test {@link Value#create(ProtoCapsule, int)} with {@code capsule}, {@code type}.
   *
   * <ul>
   *   <li>Given {@code Instance}.
   *   <li>Then return Value is {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link Value#create(ProtoCapsule, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link Value#create(ProtoCapsule)} with {@code capsule}.
   *
   * <ul>
   *   <li>Given {@code Instance}.
   *   <li>Then return Value is {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link Value#create(ProtoCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link Value#create(byte[], int)} with {@code value}, {@code type}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Type {@link Type#type} is one.
   * </ul>
   *
   * <p>Method under test: {@link Value#create(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateResult.getValue());
  }

  /**
   * Test {@link Value#create(byte[])} with {@code value}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Type {@link Type#type} is zero.
   * </ul>
   *
   * <p>Method under test: {@link Value#create(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateResult.getValue());
  }

  /**
   * Test {@link Value#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);

    // Act and Assert
    assertNotEquals(createResult, "Obj");
  }

  /**
   * Test {@link Value#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Value#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);

    // Act and Assert
    assertNotEquals(createResult, null);
  }
}
