package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProgramPrecompileDiffblueTest {
  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenA() {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("AXAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   * <ul>
   *   <li>When {@code [XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("[XAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   * <ul>
   *   <li>When {@code `XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenXaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("`XAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenArrayOfByteWithAAndX_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', -13}));
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenArrayOfByteWithMinusOneAndX_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus thirteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenArrayOfByteWithMinusThirteenAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode(new byte[]{-13, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus thirteen and zero.</li>
   *   <li>Then return {@code AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenArrayOfByteWithMinusThirteenAndZero_thenReturnAxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCode = ProgramPrecompile.getCode(new byte[]{-13, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithZeroAndZero()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   * <ul>
   *   <li>When {@code `XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenXaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithZeroAndZero()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ProgramPrecompile.getCode("`XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ProgramPrecompile#hasJumpDest(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#hasJumpDest(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramPrecompile.hasJumpDest(int)"})
  public void testHasJumpDest_givenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ProgramPrecompile.compile(new byte[]{'A', '[', 'A', 6, 'A', 6, 'A', 6}).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#hasJumpDest(int)}.
   * <ul>
   *   <li>Given {@link ProgramPrecompile} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramPrecompile#hasJumpDest(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramPrecompile.hasJumpDest(int)"})
  public void testHasJumpDest_givenProgramPrecompile_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProgramPrecompile()).hasJumpDest(1));
  }
}
