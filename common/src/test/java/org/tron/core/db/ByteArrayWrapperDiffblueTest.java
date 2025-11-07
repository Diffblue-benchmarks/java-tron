package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ByteArrayWrapperDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayWrapper#equals(Object)}
   *   <li>{@link ByteArrayWrapper#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayWrapper byteArrayWrapper2 = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(byteArrayWrapper, byteArrayWrapper2);
    int expectedHashCodeResult = byteArrayWrapper.hashCode();
    assertEquals(expectedHashCodeResult, byteArrayWrapper2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayWrapper#equals(Object)}
   *   <li>{@link ByteArrayWrapper#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(byteArrayWrapper, byteArrayWrapper);
    int expectedHashCodeResult = byteArrayWrapper.hashCode();
    assertEquals(expectedHashCodeResult, byteArrayWrapper.hashCode());
  }

  /**
   * Method under test: {@link ByteArrayWrapper#compareTo(ByteArrayWrapper)}
   */
  @Test
  public void testCompareTo() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(0, byteArrayWrapper.compareTo(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link ByteArrayWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(byteArrayWrapper, new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArrayWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Method under test: {@link ByteArrayWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8")), "Different type to ByteArrayWrapper");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteArrayWrapper#toString()}
   *   <li>{@link ByteArrayWrapper#getData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringResult = byteArrayWrapper.toString();
    byte[] actualData = byteArrayWrapper.getData();

    // Assert
    assertEquals("4158415841584158", actualToStringResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link ByteArrayWrapper#ByteArrayWrapper(byte[])}
   */
  @Test
  public void testNewByteArrayWrapper() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(data, (new ByteArrayWrapper(data)).getData());
  }

  /**
   * Method under test: {@link ByteArrayWrapper#ByteArrayWrapper(byte[])}
   */
  @Test
  public void testNewByteArrayWrapper2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ByteArrayWrapper(null));
  }
}
