package org.tron.core.db.api.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WitnessDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setAddress("42 Main St");
    Witness ofResult2 = Witness.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setPublicKey("Public Key");
    Witness ofResult2 = Witness.of();
    ofResult2.setPublicKey("Public Key");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setUrl("https://example.org/example");
    Witness ofResult2 = Witness.of();
    ofResult2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Witness ofResult = Witness.of();

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Witness.of(), 1);
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setPublicKey("Public Key");

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setJobs(true);

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();
    ofResult2.setPublicKey("Public Key");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();
    ofResult2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Witness.of(), null);
  }

  /**
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Witness.of(), "Different type to Witness");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#setAddress(String)}
   *   <li>{@link Witness#setJobs(boolean)}
   *   <li>{@link Witness#setPublicKey(String)}
   *   <li>{@link Witness#setUrl(String)}
   *   <li>{@link Witness#toString()}
   *   <li>{@link Witness#getAddress()}
   *   <li>{@link Witness#getPublicKey()}
   *   <li>{@link Witness#getUrl()}
   *   <li>{@link Witness#isJobs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Witness ofResult = Witness.of();

    // Act
    ofResult.setAddress("42 Main St");
    ofResult.setJobs(true);
    ofResult.setPublicKey("Public Key");
    ofResult.setUrl("https://example.org/example");
    String actualToStringResult = ofResult.toString();
    String actualAddress = ofResult.getAddress();
    String actualPublicKey = ofResult.getPublicKey();
    String actualUrl = ofResult.getUrl();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("Public Key", actualPublicKey);
    assertEquals("Witness(address=42 Main St, publicKey=Public Key, url=https://example.org/example, jobs=true)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualUrl);
    assertTrue(ofResult.isJobs());
  }

  /**
   * Method under test: {@link Witness#of()}
   */
  @Test
  public void testOf() {
    // Arrange and Act
    Witness actualOfResult = Witness.of();

    // Assert
    assertNull(actualOfResult.getAddress());
    assertNull(actualOfResult.getPublicKey());
    assertNull(actualOfResult.getUrl());
    assertFalse(actualOfResult.isJobs());
  }
}
