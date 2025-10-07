package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProgramPrecompileDiffblueTest {
  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenA() {
    // Arrange, Act and Assert
    assertFalse(
        ProgramPrecompile.compile(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})
            .hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("AXAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   *
   * <ul>
   *   <li>When {@code [XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("[XAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#compile(byte[])}.
   *
   * <ul>
   *   <li>When {@code `XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#compile(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramPrecompile ProgramPrecompile.compile(byte[])"})
  public void testCompile_whenXaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ProgramPrecompile.compile("`XAXAXAX".getBytes("UTF-8")).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#getCode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus thirteen and zero.
   *   <li>Then return {@code AXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#getCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProgramPrecompile.getCode(byte[])"})
  public void testGetCode_whenArrayOfByteWithMinusThirteenAndZero_thenReturnAxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAX".getBytes("UTF-8"),
        ProgramPrecompile.getCode(new byte[] {-13, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ProgramPrecompile#hasJumpDest(int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#hasJumpDest(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProgramPrecompile.hasJumpDest(int)"})
  public void testHasJumpDest_givenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ProgramPrecompile.compile(new byte[] {'A', '[', 'A', 6, 'A', 6, 'A', 6}).hasJumpDest(1));
  }

  /**
   * Test {@link ProgramPrecompile#hasJumpDest(int)}.
   *
   * <ul>
   *   <li>Given {@link ProgramPrecompile} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramPrecompile#hasJumpDest(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProgramPrecompile.hasJumpDest(int)"})
  public void testHasJumpDest_givenProgramPrecompile_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ProgramPrecompile().hasJumpDest(1));
  }
}
