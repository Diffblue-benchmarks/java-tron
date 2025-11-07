package org.tron.core.capsule;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class BytesCapsuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BytesCapsule#BytesCapsule(byte[])}
   *   <li>{@link BytesCapsule#getData()}
   *   <li>{@link BytesCapsule#getInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    BytesCapsule actualBytesCapsule = new BytesCapsule(bytes);
    byte[] actualData = actualBytesCapsule.getData();

    // Assert
    assertNull(actualBytesCapsule.getInstance());
    assertSame(bytes, actualData);
  }
}
