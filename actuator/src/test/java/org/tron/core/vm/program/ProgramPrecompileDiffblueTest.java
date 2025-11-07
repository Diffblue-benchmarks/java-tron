package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ProgramPrecompileDiffblueTest {
  /**
   * Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  public void testCompile() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("AXAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
    assertFalse(ProgramPrecompile.compile(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}).hasJumpDest(1));
    assertFalse(ProgramPrecompile.compile("[XAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
    assertFalse(ProgramPrecompile.compile("`XAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  public void testGetCode() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode("AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode(new byte[]{-13, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode("`XAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', -13}));
  }

  /**
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  public void testGetCode2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCode = ProgramPrecompile.getCode(new byte[]{-13, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Method under test: {@link ProgramPrecompile#hasJumpDest(int)}
   */
  @Test
  public void testHasJumpDest() {
    // Arrange, Act and Assert
    assertFalse((new ProgramPrecompile()).hasJumpDest(1));
    assertTrue(ProgramPrecompile.compile(new byte[]{'A', '[', 'A', 6, 'A', 6, 'A', 6}).hasJumpDest(1));
  }
}
