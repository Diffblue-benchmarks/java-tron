package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class Base58DiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Base58#encode(byte[])}
   *   <li>{@link Base58#decode(String)}
   * </ul>
   */
  @Test
  public void testEncodeAndDecode() throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange
    byte[] input = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(input, Base58.decode(Base58.encode(input)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Base58#encode(byte[])}
   *   <li>{@link Base58#decode(String)}
   * </ul>
   */
  @Test
  public void testEncodeAndDecode2() throws IllegalArgumentException {
    // Arrange
    byte[] input = new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertArrayEquals(input, Base58.decode(Base58.encode(input)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Base58#encode(byte[])}
   *   <li>{@link Base58#decode(String)}
   * </ul>
   */
  @Test
  public void testEncodeAndDecode3() throws IllegalArgumentException {
    // Arrange
    byte[] input = new byte[]{};

    // Act and Assert
    assertArrayEquals(input, Base58.decode(Base58.encode(input)));
  }
}
