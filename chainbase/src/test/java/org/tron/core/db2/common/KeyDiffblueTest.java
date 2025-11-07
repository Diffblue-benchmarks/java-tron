package org.tron.core.db2.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class KeyDiffblueTest {
  /**
   * Method under test: {@link Key#copyOf(byte[])}
   */
  @Test
  public void testCopyOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualCopyOfResult = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCopyOfResult.getBytes());
  }

  /**
   * Method under test: {@link Key#copyOf(byte[])}
   */
  @Test
  public void testCopyOf2() {
    // Arrange, Act and Assert
    assertNull(Key.copyOf(null).getBytes());
  }

  /**
   * Method under test: {@link Key#of(byte[])}
   */
  @Test
  public void testOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualOfResult = Key.of("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualOfResult.getBytes());
  }

  /**
   * Method under test: {@link Key#getBytes()}
   */
  @Test
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = Key.copyOf("AXAXAXAX".getBytes("UTF-8")).getBytes();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Method under test: {@link Key#getBytes()}
   */
  @Test
  public void testGetBytes2() {
    // Arrange, Act and Assert
    assertNull(Key.copyOf(null).getBytes());
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
    Key copyOfResult = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));
    Key copyOfResult2 = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult2);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult2.hashCode());
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
    Key copyOfResult = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult.hashCode());
  }

  /**
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Key copyOfResult = Key.copyOf(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNotEquals(copyOfResult, Key.copyOf("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.copyOf("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.copyOf("AXAXAXAX".getBytes("UTF-8")), "Different type to Key");
  }
}
