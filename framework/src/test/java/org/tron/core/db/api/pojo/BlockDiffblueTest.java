package org.tron.core.db.api.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BlockDiffblueTest {
  /**
   * Test {@link Block#equals(Object)}, and {@link Block#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Block#equals(Object)}
   *   <li>{@link Block#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Block ofResult = Block.of();
    Block ofResult2 = Block.of();

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Block#equals(Object)}, and {@link Block#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Block#equals(Object)}
   *   <li>{@link Block#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Block ofResult = Block.of();
    ofResult.setId("42");

    Block ofResult2 = Block.of();
    ofResult2.setId("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Block#equals(Object)}, and {@link Block#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Block#equals(Object)}
   *   <li>{@link Block#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Block ofResult = Block.of();
    ofResult.setTransactionIds(new ArrayList<>());

    Block ofResult2 = Block.of();
    ofResult2.setTransactionIds(new ArrayList<>());

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Block#equals(Object)}, and {@link Block#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Block#equals(Object)}
   *   <li>{@link Block#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Block ofResult = Block.of();

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Block.of(), 1);
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Block ofResult = Block.of();
    ofResult.setId("42");

    // Act and Assert
    assertNotEquals(ofResult, Block.of());
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Block ofResult = Block.of();
    ofResult.setNumber(1L);

    // Act and Assert
    assertNotEquals(ofResult, Block.of());
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Block ofResult = Block.of();
    ofResult.setTransactionIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ofResult, Block.of());
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Block ofResult = Block.of();

    Block ofResult2 = Block.of();
    ofResult2.setId("42");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Block ofResult = Block.of();

    Block ofResult2 = Block.of();
    ofResult2.setTransactionIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Block.of(), null);
  }

  /**
   * Test {@link Block#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Block#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Block.equals(Object)", "int Block.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Block.of(), "Different type to Block");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Block#setId(String)}
   *   <li>{@link Block#setNumber(long)}
   *   <li>{@link Block#setTransactionIds(List)}
   *   <li>{@link Block#toString()}
   *   <li>{@link Block#getId()}
   *   <li>{@link Block#getNumber()}
   *   <li>{@link Block#getTransactionIds()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Block.getId()",
    "long Block.getNumber()",
    "List Block.getTransactionIds()",
    "void Block.setId(String)",
    "void Block.setNumber(long)",
    "void Block.setTransactionIds(List)",
    "String Block.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Block ofResult = Block.of();

    // Act
    ofResult.setId("42");
    ofResult.setNumber(1L);
    ArrayList<String> transactionIds = new ArrayList<>();
    ofResult.setTransactionIds(transactionIds);
    String actualToStringResult = ofResult.toString();
    String actualId = ofResult.getId();
    long actualNumber = ofResult.getNumber();
    List<String> actualTransactionIds = ofResult.getTransactionIds();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Block(id=42, number=1, transactionIds=[])", actualToStringResult);
    assertEquals(1L, actualNumber);
    assertTrue(actualTransactionIds.isEmpty());
    assertSame(transactionIds, actualTransactionIds);
  }

  /**
   * Test {@link Block#of()}.
   *
   * <p>Method under test: {@link Block#of()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Block Block.of()"})
  public void testOf() {
    // Arrange and Act
    Block actualOfResult = Block.of();

    // Assert
    assertNull(actualOfResult.getId());
    assertNull(actualOfResult.getTransactionIds());
    assertEquals(0L, actualOfResult.getNumber());
  }
}
