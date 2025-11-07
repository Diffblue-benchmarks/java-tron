package org.tron.core.db.api.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TransactionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Transaction#equals(Object)}
   *   <li>{@link Transaction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Transaction ofResult = Transaction.of();
    Transaction ofResult2 = Transaction.of();

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Transaction#equals(Object)}
   *   <li>{@link Transaction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Transaction ofResult = Transaction.of();
    ofResult.setId("42");
    Transaction ofResult2 = Transaction.of();
    ofResult2.setId("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Transaction#equals(Object)}
   *   <li>{@link Transaction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Transaction ofResult = Transaction.of();
    ofResult.setFrom("jane.doe@example.org");
    Transaction ofResult2 = Transaction.of();
    ofResult2.setFrom("jane.doe@example.org");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Transaction#equals(Object)}
   *   <li>{@link Transaction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Transaction ofResult = Transaction.of();
    ofResult.setTo("alice.liddell@example.org");
    Transaction ofResult2 = Transaction.of();
    ofResult2.setTo("alice.liddell@example.org");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Transaction#equals(Object)}
   *   <li>{@link Transaction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Transaction ofResult = Transaction.of();

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Transaction.of(), 1);
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Transaction ofResult = Transaction.of();
    ofResult.setId("42");

    // Act and Assert
    assertNotEquals(ofResult, Transaction.of());
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Transaction ofResult = Transaction.of();
    ofResult.setFrom("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(ofResult, Transaction.of());
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Transaction ofResult = Transaction.of();
    ofResult.setTo("alice.liddell@example.org");

    // Act and Assert
    assertNotEquals(ofResult, Transaction.of());
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Transaction ofResult = Transaction.of();
    Transaction ofResult2 = Transaction.of();
    ofResult2.setId("42");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Transaction ofResult = Transaction.of();
    Transaction ofResult2 = Transaction.of();
    ofResult2.setFrom("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Transaction ofResult = Transaction.of();
    Transaction ofResult2 = Transaction.of();
    ofResult2.setTo("alice.liddell@example.org");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Transaction.of(), null);
  }

  /**
   * Method under test: {@link Transaction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Transaction.of(), "Different type to Transaction");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Transaction#setFrom(String)}
   *   <li>{@link Transaction#setId(String)}
   *   <li>{@link Transaction#setTo(String)}
   *   <li>{@link Transaction#toString()}
   *   <li>{@link Transaction#getFrom()}
   *   <li>{@link Transaction#getId()}
   *   <li>{@link Transaction#getTo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Transaction ofResult = Transaction.of();

    // Act
    ofResult.setFrom("jane.doe@example.org");
    ofResult.setId("42");
    ofResult.setTo("alice.liddell@example.org");
    String actualToStringResult = ofResult.toString();
    String actualFrom = ofResult.getFrom();
    String actualId = ofResult.getId();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("Transaction(id=42, from=jane.doe@example.org, to=alice.liddell@example.org)", actualToStringResult);
    assertEquals("alice.liddell@example.org", ofResult.getTo());
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Method under test: {@link Transaction#of()}
   */
  @Test
  public void testOf() {
    // Arrange and Act
    Transaction actualOfResult = Transaction.of();

    // Assert
    assertNull(actualOfResult.getFrom());
    assertNull(actualOfResult.getId());
    assertNull(actualOfResult.getTo());
  }
}
