package org.tron.core.db.api.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssetIssueDiffblueTest {
  /**
   * Test {@link AssetIssue#equals(Object)}, and {@link AssetIssue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetIssue#equals(Object)}
   *   <li>{@link AssetIssue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    AssetIssue ofResult2 = AssetIssue.of();

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}, and {@link AssetIssue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetIssue#equals(Object)}
   *   <li>{@link AssetIssue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    ofResult.setName("Name");

    AssetIssue ofResult2 = AssetIssue.of();
    ofResult2.setName("Name");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}, and {@link AssetIssue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetIssue#equals(Object)}
   *   <li>{@link AssetIssue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    ofResult.setAddress("42 Main St");

    AssetIssue ofResult2 = AssetIssue.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}, and {@link AssetIssue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetIssue#equals(Object)}
   *   <li>{@link AssetIssue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssue.of(), 1);
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    ofResult.setName("Name");

    // Act and Assert
    assertNotEquals(ofResult, AssetIssue.of());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    ofResult.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, AssetIssue.of());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    ofResult.setStart(1L);

    // Act and Assert
    assertNotEquals(ofResult, AssetIssue.of());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();
    ofResult.setEnd(1L);

    // Act and Assert
    assertNotEquals(ofResult, AssetIssue.of());
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();

    AssetIssue ofResult2 = AssetIssue.of();
    ofResult2.setName("Name");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();

    AssetIssue ofResult2 = AssetIssue.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssue.of(), null);
  }

  /**
   * Test {@link AssetIssue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssue.equals(Object)", "int AssetIssue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssue.of(), "Different type to AssetIssue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetIssue#setAddress(String)}
   *   <li>{@link AssetIssue#setEnd(long)}
   *   <li>{@link AssetIssue#setName(String)}
   *   <li>{@link AssetIssue#setStart(long)}
   *   <li>{@link AssetIssue#toString()}
   *   <li>{@link AssetIssue#getAddress()}
   *   <li>{@link AssetIssue#getEnd()}
   *   <li>{@link AssetIssue#getName()}
   *   <li>{@link AssetIssue#getStart()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String AssetIssue.getAddress()",
    "long AssetIssue.getEnd()",
    "String AssetIssue.getName()",
    "long AssetIssue.getStart()",
    "void AssetIssue.setAddress(String)",
    "void AssetIssue.setEnd(long)",
    "void AssetIssue.setName(String)",
    "void AssetIssue.setStart(long)",
    "String AssetIssue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    AssetIssue ofResult = AssetIssue.of();

    // Act
    ofResult.setAddress("42 Main St");
    ofResult.setEnd(1L);
    ofResult.setName("Name");
    ofResult.setStart(1L);
    String actualToStringResult = ofResult.toString();
    String actualAddress = ofResult.getAddress();
    long actualEnd = ofResult.getEnd();
    String actualName = ofResult.getName();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("AssetIssue(name=Name, address=42 Main St, start=1, end=1)", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1L, actualEnd);
    assertEquals(1L, ofResult.getStart());
  }

  /**
   * Test {@link AssetIssue#of()}.
   *
   * <p>Method under test: {@link AssetIssue#of()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssue AssetIssue.of()"})
  public void testOf() {
    // Arrange and Act
    AssetIssue actualOfResult = AssetIssue.of();

    // Assert
    assertNull(actualOfResult.getAddress());
    assertNull(actualOfResult.getName());
    assertEquals(0L, actualOfResult.getEnd());
    assertEquals(0L, actualOfResult.getStart());
  }
}
