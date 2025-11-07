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
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.capsule.ProtoCapsule;

public class ValueDiffblueTest {
  /**
   * Method under test: {@link Value#create(ProtoCapsule)}
   */
  @Test
  public void testCreate() {
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
   * Method under test: {@link Value#create(ProtoCapsule)}
   */
  @Test
  public void testCreate2() {
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
   * Method under test: {@link Value#create(ProtoCapsule, int)}
   */
  @Test
  public void testCreate3() {
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
   * Method under test: {@link Value#create(ProtoCapsule, int)}
   */
  @Test
  public void testCreate4() {
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
   * Method under test: {@link Value#create(byte[])}
   */
  @Test
  public void testCreate5() throws UnsupportedEncodingException {
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
   * Method under test: {@link Value#create(byte[])}
   */
  @Test
  public void testCreate6() {
    // Arrange and Act
    Value<byte[]> actualCreateResult = Value.create(new byte[]{});

    // Assert
    assertNull(actualCreateResult.getValue());
    assertNull(actualCreateResult.getType());
  }

  /**
   * Method under test: {@link Value#create(byte[], int)}
   */
  @Test
  public void testCreate7() throws UnsupportedEncodingException {
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
   * Method under test: {@link Value#create(byte[], int)}
   */
  @Test
  public void testCreate8() {
    // Arrange and Act
    Value<byte[]> actualCreateResult = Value.create(new byte[]{}, 1);

    // Assert
    assertNull(actualCreateResult.getValue());
    assertNull(actualCreateResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
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
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);

    // Act and Assert
    assertNotEquals(createResult, null);
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> createResult = Value.create(capsule, 1);

    // Act and Assert
    assertNotEquals(createResult, 1);
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
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
