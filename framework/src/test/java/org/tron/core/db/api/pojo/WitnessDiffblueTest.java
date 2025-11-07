package org.tron.core.db.api.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WitnessDiffblueTest {
  /**
   * Test {@link Witness#equals(Object)}, and {@link Witness#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
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
   * Test {@link Witness#equals(Object)}, and {@link Witness#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
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
   * Test {@link Witness#equals(Object)}, and {@link Witness#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
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
   * Test {@link Witness#equals(Object)}, and {@link Witness#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
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
   * Test {@link Witness#equals(Object)}, and {@link Witness#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Witness#equals(Object)}
   *   <li>{@link Witness#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Witness ofResult = Witness.of();

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Witness.of(), 1);
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setPublicKey("Public Key");

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Witness ofResult = Witness.of();
    ofResult.setJobs(true);

    // Act and Assert
    assertNotEquals(ofResult, Witness.of());
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();
    ofResult2.setPublicKey("Public Key");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Witness ofResult = Witness.of();
    Witness ofResult2 = Witness.of();
    ofResult2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Witness.of(), null);
  }

  /**
   * Test {@link Witness#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Witness#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Witness.equals(Object)", "int Witness.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Witness.of(), "Different type to Witness");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Witness.getAddress()", "String Witness.getPublicKey()", "String Witness.getUrl()",
      "boolean Witness.isJobs()", "void Witness.setAddress(String)", "void Witness.setJobs(boolean)",
      "void Witness.setPublicKey(String)", "void Witness.setUrl(String)", "String Witness.toString()"})
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

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("Public Key", actualPublicKey);
    assertEquals("Witness(address=42 Main St, publicKey=Public Key, url=https://example.org/example, jobs=true)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualUrl);
    assertTrue(ofResult.isJobs());
  }

  /**
   * Test {@link Witness#of()}.
   * <p>
   * Method under test: {@link Witness#of()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Witness Witness.of()"})
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
