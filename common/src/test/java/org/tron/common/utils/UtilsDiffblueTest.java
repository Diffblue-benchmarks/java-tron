package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class UtilsDiffblueTest {
  /**
   * Method under test: {@link Utils#getBytes(char[])}
   */
  @Test
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = Utils.getBytes("AZAZ".toCharArray());

    // Assert
    assertArrayEquals("AZAZ".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Method under test: {@link Utils#getIdShort(String)}
   */
  @Test
  public void testGetIdShort() {
    // Arrange, Act and Assert
    assertEquals("<null>", Utils.getIdShort(null));
    assertEquals("42<null>", Utils.getIdShort("42<null>"));
  }

  /**
   * Method under test: {@link Utils#clone(byte[])}
   */
  @Test
  public void testClone() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCloneResult = Utils.clone("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCloneResult);
  }

  /**
   * Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  public void testAlign() {
    // Arrange, Act and Assert
    assertEquals("foo", Utils.align("foo", 'A', 3, true));
    assertEquals("A42", Utils.align("42", 'A', 3, true));
    assertEquals("42A", Utils.align("42", 'A', 3, false));
  }

  /**
   * Method under test: {@link Utils#repeat(String, int)}
   */
  @Test
  public void testRepeat() {
    // Arrange, Act and Assert
    assertEquals("foo", Utils.repeat("foo", 1));
  }
}
