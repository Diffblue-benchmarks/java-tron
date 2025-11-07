package org.tron.core.db2.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class WrappedByteArrayDiffblueTest {
  /**
   * Method under test: {@link WrappedByteArray#of(byte[])}
   */
  @Test
  public void testOf() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(bytes, WrappedByteArray.of(bytes).getBytes());
  }

  /**
   * Method under test: {@link WrappedByteArray#copyOf(byte[])}
   */
  @Test
  public void testCopyOf() throws UnsupportedEncodingException {
    // Arrange and Act
    WrappedByteArray actualCopyOfResult = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCopyOfResult.getBytes());
  }

  /**
   * Method under test: {@link WrappedByteArray#copyOf(byte[])}
   */
  @Test
  public void testCopyOf2() {
    // Arrange, Act and Assert
    assertNull(WrappedByteArray.copyOf(null).getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WrappedByteArray#equals(Object)}
   *   <li>{@link WrappedByteArray#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray copyOfResult = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));
    WrappedByteArray copyOfResult2 = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult2);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WrappedByteArray#equals(Object)}
   *   <li>{@link WrappedByteArray#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray copyOfResult = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult.hashCode());
  }

  /**
   * Method under test: {@link WrappedByteArray#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray copyOfResult = WrappedByteArray.copyOf("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(copyOfResult, WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link WrappedByteArray#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Method under test: {@link WrappedByteArray#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")), "Different type to WrappedByteArray");
  }

  /**
   * Method under test: {@link WrappedByteArray#getBytes()}
   */
  @Test
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")).getBytes();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }
}
