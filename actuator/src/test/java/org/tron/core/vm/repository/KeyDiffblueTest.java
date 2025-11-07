package org.tron.core.vm.repository;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class KeyDiffblueTest {
  /**
   * Method under test: {@link Key#create(byte[])}
   */
  @Test
  public void testCreate() throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualCreateResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualCreateResult.getData());
  }

  /**
   * Method under test: {@link Key#create(byte[])}
   */
  @Test
  public void testCreate2() {
    // Arrange, Act and Assert
    assertEquals(0, Key.create(null).getData().length);
  }

  /**
   * Method under test: {@link Key#create(byte[])}
   */
  @Test
  public void testCreate3() {
    // Arrange, Act and Assert
    assertEquals(0, Key.create(new byte[]{}).getData().length);
  }

  /**
   * Method under test: {@link Key#clone()}
   */
  @Test
  public void testClone() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult.clone());
  }

  /**
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(createResult, Key.create("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.create("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.create("AXAXAXAX".getBytes("UTF-8")), "Different type to Key");
  }

  /**
   * Method under test: {@link Key#getData()}
   */
  @Test
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = Key.create("AXAXAXAX".getBytes("UTF-8")).getData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));
    Key createResult2 = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult2);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Key createResult = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Method under test: {@link Key#Key(byte[])}
   */
  @Test
  public void testNewKey() throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualKey = new Key("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualKey.getData());
  }

  /**
   * Method under test: {@link Key#Key(byte[])}
   */
  @Test
  public void testNewKey2() {
    // Arrange, Act and Assert
    assertEquals(0, (new Key(null)).getData().length);
  }

  /**
   * Method under test: {@link Key#Key(byte[])}
   */
  @Test
  public void testNewKey3() {
    // Arrange, Act and Assert
    assertEquals(0, (new Key(new byte[]{})).getData().length);
  }
}
