package org.tron.core.vm.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type#Type()}
   *   <li>{@link Type#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Type.<init>()", "java.lang.String Type.toString()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Type{type=0}", (new Type()).toString());
  }

  /**
   * Test {@link Type#Type(int)}.
   * <p>
   * Method under test: {@link Type#Type(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Type.<init>(int)"})
  public void testNewType() {
    // Arrange and Act
    Type actualType = new Type(1);

    // Assert
    assertEquals(1, actualType.type);
    assertFalse(actualType.isCreate());
    assertFalse(actualType.isNormal());
    assertTrue(actualType.isDirty());
  }

  /**
   * Test {@link Type#clone()}.
   * <p>
   * Method under test: {@link Type#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Type Type.clone()"})
  public void testClone() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(type, type.clone());
  }

  /**
   * Test {@link Type#isDirty()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isDirty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isDirty()"})
  public void testIsDirty_givenTypeWithTypeIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Type(1)).isDirty());
  }

  /**
   * Test {@link Type#isDirty()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isDirty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isDirty()"})
  public void testIsDirty_givenTypeWithTypeIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Type(0)).isDirty());
  }

  /**
   * Test {@link Type#isNormal()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is one Type is zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isNormal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isNormal()"})
  public void testIsNormal_givenTypeWithTypeIsOneTypeIsZero_thenReturnTrue() {
    // Arrange
    Type type = new Type(1);
    type.setType(0);

    // Act and Assert
    assertTrue(type.isNormal());
  }

  /**
   * Test {@link Type#isNormal()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isNormal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isNormal()"})
  public void testIsNormal_givenTypeWithTypeIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Type(1)).isNormal());
  }

  /**
   * Test {@link Type#isCreate()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isCreate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isCreate()"})
  public void testIsCreate_givenTypeWithTypeIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Type(1)).isCreate());
  }

  /**
   * Test {@link Type#isCreate()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isCreate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isCreate()"})
  public void testIsCreate_givenTypeWithTypeIsTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Type(2)).isCreate());
  }

  /**
   * Test {@link Type#shouldCommit()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is one Type is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#shouldCommit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.shouldCommit()"})
  public void testShouldCommit_givenTypeWithTypeIsOneTypeIsZero_thenReturnFalse() {
    // Arrange
    Type type = new Type(1);
    type.setType(0);

    // Act and Assert
    assertFalse(type.shouldCommit());
  }

  /**
   * Test {@link Type#shouldCommit()}.
   * <ul>
   *   <li>Given {@link Type#Type(int)} with type is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#shouldCommit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.shouldCommit()"})
  public void testShouldCommit_givenTypeWithTypeIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Type(1)).shouldCommit());
  }

  /**
   * Test {@link Type#setType(int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#setType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Type Type.setType(int)"})
  public void testSetType_whenOne() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertSame(type, type.setType(1));
  }

  /**
   * Test {@link Type#setType(int)}.
   * <ul>
   *   <li>When {@link Type#UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#setType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Type Type.setType(int)"})
  public void testSetType_whenUnknown() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertSame(type, type.setType(Type.UNKNOWN));
  }

  /**
   * Test {@link Type#isValidType(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isValidType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isValidType(int)"})
  public void testIsValidType_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Type(1)).isValidType(1));
  }

  /**
   * Test {@link Type#isValidType(int)}.
   * <ul>
   *   <li>When {@link Type#UNKNOWN}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#isValidType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.isValidType(int)"})
  public void testIsValidType_whenUnknown_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Type(1)).isValidType(Type.UNKNOWN));
  }

  /**
   * Test {@link Type#addType(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#addType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Type.addType(int)"})
  public void testAddType_whenTwo_thenReturnThree() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(3, type.addType(2));
    assertEquals(3, type.type);
    assertTrue(type.isCreate());
  }

  /**
   * Test {@link Type#addType(int)}.
   * <ul>
   *   <li>When {@link Type#UNKNOWN}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#addType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Type.addType(int)"})
  public void testAddType_whenUnknown_thenReturnOne() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(1, type.addType(Type.UNKNOWN));
    assertEquals(1, type.type);
    assertFalse(type.isCreate());
  }

  /**
   * Test {@link Type#equals(Object)}, and {@link Type#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type#equals(Object)}
   *   <li>{@link Type#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.equals(Object)", "int Type.hashCode()"})
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
   * Test {@link Type#equals(Object)}, and {@link Type#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type#equals(Object)}
   *   <li>{@link Type#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.equals(Object)", "int Type.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Type type = new Type(1);

    // Act and Assert
    assertEquals(type, type);
    int expectedHashCodeResult = type.hashCode();
    assertEquals(expectedHashCodeResult, type.hashCode());
  }

  /**
   * Test {@link Type#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.equals(Object)", "int Type.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Type type = new Type(0);

    // Act and Assert
    assertNotEquals(type, new Type(1));
  }

  /**
   * Test {@link Type#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.equals(Object)", "int Type.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Type(1), null);
  }

  /**
   * Test {@link Type#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Type.equals(Object)", "int Type.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Type(1), "Different type to Type");
  }
}
