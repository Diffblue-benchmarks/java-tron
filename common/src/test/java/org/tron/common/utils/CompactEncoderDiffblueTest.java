package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class CompactEncoderDiffblueTest {
  /**
   * Method under test: {@link CompactEncoder#packNibbles(byte[])}
   */
  @Test
  public void testPackNibbles() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 'h', 'h', 'h', 'h'}, CompactEncoder.packNibbles("AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(new byte[]{'q', -63, -63, -63},
        CompactEncoder.packNibbles(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 16}));
  }

  /**
   * Method under test: {@link CompactEncoder#hasTerminator(byte[])}
   */
  @Test
  public void testHasTerminator() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(CompactEncoder.hasTerminator("AXAXAXAX".getBytes("UTF-8")));
    assertTrue(CompactEncoder.hasTerminator(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link CompactEncoder#unpackToNibbles(byte[])}
   */
  @Test
  public void testUnpackToNibbles() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 16},
        CompactEncoder.unpackToNibbles("AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(new byte[]{5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b'},
        CompactEncoder.unpackToNibbles(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertArrayEquals(new byte[]{0, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b'},
        CompactEncoder.unpackToNibbles(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link CompactEncoder#binToNibbles(byte[])}
   */
  @Test
  public void testBinToNibbles() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 16},
        CompactEncoder.binToNibbles("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CompactEncoder#binToNibblesNoTerminator(byte[])}
   */
  @Test
  public void testBinToNibblesNoTerminator() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b'},
        CompactEncoder.binToNibblesNoTerminator("AXAXAXAX".getBytes("UTF-8")));
  }
}
