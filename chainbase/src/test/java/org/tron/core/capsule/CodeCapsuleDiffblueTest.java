package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class CodeCapsuleDiffblueTest {
  /**
   * Method under test: {@link CodeCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualInstance = (new CodeCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInstance);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeCapsule#CodeCapsule(byte[])}
   *   <li>{@link CodeCapsule#toString()}
   *   <li>{@link CodeCapsule#getData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CodeCapsule actualCodeCapsule = new CodeCapsule(code);
    String actualToStringResult = actualCodeCapsule.toString();

    // Assert
    assertEquals("[65, 88, 65, 88, 65, 88, 65, 88]", actualToStringResult);
    assertSame(code, actualCodeCapsule.getData());
    assertSame(code, actualCodeCapsule.getInstance());
  }
}
