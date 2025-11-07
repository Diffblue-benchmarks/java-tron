package org.tron.core.vm.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TypeDiffblueTest {
  /**
   * Method under test: {@link Type#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(type, type.clone());
  }

  /**
   * Method under test: {@link Type#isDirty()}
   */
  @Test
  public void testIsDirty() {
    // Arrange, Act and Assert
    assertTrue((new Type(1)).isDirty());
    assertFalse((new Type(0)).isDirty());
  }

  /**
   * Method under test: {@link Type#isNormal()}
   */
  @Test
  public void testIsNormal() {
    // Arrange, Act and Assert
    assertFalse((new Type(1)).isNormal());
  }

  /**
   * Method under test: {@link Type#isNormal()}
   */
  @Test
  public void testIsNormal2() {
    // Arrange
    Type type = new Type(1);
    type.setType(0);

    // Act and Assert
    assertTrue(type.isNormal());
  }

  /**
   * Method under test: {@link Type#isCreate()}
   */
  @Test
  public void testIsCreate() {
    // Arrange, Act and Assert
    assertFalse((new Type(1)).isCreate());
    assertTrue((new Type(2)).isCreate());
  }

  /**
   * Method under test: {@link Type#shouldCommit()}
   */
  @Test
  public void testShouldCommit() {
    // Arrange, Act and Assert
    assertTrue((new Type(1)).shouldCommit());
  }

  /**
   * Method under test: {@link Type#shouldCommit()}
   */
  @Test
  public void testShouldCommit2() {
    // Arrange
    Type type = new Type(1);
    type.setType(0);

    // Act and Assert
    assertFalse(type.shouldCommit());
  }

  /**
   * Method under test: {@link Type#setType(int)}
   */
  @Test
  public void testSetType() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertSame(type, type.setType(1));
  }

  /**
   * Method under test: {@link Type#setType(int)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertSame(type, type.setType(Type.UNKNOWN));
  }

  /**
   * Method under test: {@link Type#isValidType(int)}
   */
  @Test
  public void testIsValidType() {
    // Arrange, Act and Assert
    assertTrue((new Type(1)).isValidType(1));
    assertFalse((new Type(1)).isValidType(Type.UNKNOWN));
  }

  /**
   * Method under test: {@link Type#addType(int)}
   */
  @Test
  public void testAddType() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(3, type.addType(2));
    assertEquals(3, type.type);
    assertTrue(type.isCreate());
  }

  /**
   * Method under test: {@link Type#addType(int)}
   */
  @Test
  public void testAddType2() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(1, type.addType(Type.UNKNOWN));
    assertEquals(1, type.type);
    assertFalse(type.isCreate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type#equals(Object)}
   *   <li>{@link Type#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Type type = new Type(1);
    Type type2 = new Type(1);

    // Act and Assert
    assertEquals(type, type2);
    int expectedHashCodeResult = type.hashCode();
    assertEquals(expectedHashCodeResult, type2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type#equals(Object)}
   *   <li>{@link Type#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(type, type);
    int expectedHashCodeResult = type.hashCode();
    assertEquals(expectedHashCodeResult, type.hashCode());
  }

  /**
   * Method under test: {@link Type#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Type type = new Type(0);

    // Act and Assert
    assertNotEquals(type, new Type(1));
  }

  /**
   * Method under test: {@link Type#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Type(1), null);
  }

  /**
   * Method under test: {@link Type#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Type(1), "Different type to Type");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type#Type()}
   *   <li>{@link Type#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Type{type=0}", (new Type()).toString());
  }

  /**
   * Method under test: {@link Type#Type(int)}
   */
  @Test
  public void testNewType() {
    // Arrange and Act
    Type actualType = new Type(1);

    // Assert
    assertEquals(1, actualType.type);
    assertFalse(actualType.isCreate());
    assertFalse(actualType.isNormal());
    assertTrue(actualType.isDirty());
  }
}
