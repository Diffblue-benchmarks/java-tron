package org.tron.core.vm.program;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.vm.program.listener.CompositeProgramListener;
import org.tron.core.vm.program.listener.ProgramListener;

public class MemoryDiffblueTest {
  /**
   * Test {@link Memory#extendAndWrite(int, int, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@link
   *       CompositeProgramListener} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extendAndWrite(int, int, byte[])"})
  public void testExtendAndWrite_givenMemoryProgramListenerIsCompositeProgramListener()
      throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.extendAndWrite(3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals(1024, getResult.length);
    assertEquals('A', getResult[3]);
    assertEquals('A', getResult[5]);
    assertEquals('A', getResult[7]);
    assertEquals('A', getResult[9]);
    assertEquals('X', getResult[10]);
    assertEquals('X', getResult[4]);
    assertEquals('X', getResult[6]);
    assertEquals('X', getResult[8]);
  }

  /**
   * Test {@link Memory#extendAndWrite(int, int, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Memory} (default constructor).
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then fourth element is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extendAndWrite(int, int, byte[])"})
  public void testExtendAndWrite_givenMemory_whenAxaxaxaxBytesIsUtf8_thenFourthElementIsA()
      throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extendAndWrite(3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals(1024, getResult.length);
    assertEquals('A', getResult[3]);
    assertEquals('A', getResult[5]);
    assertEquals('A', getResult[7]);
    assertEquals('A', getResult[9]);
    assertEquals('X', getResult[10]);
    assertEquals('X', getResult[4]);
    assertEquals('X', getResult[6]);
    assertEquals('X', getResult[8]);
  }

  /**
   * Test {@link Memory#extendAndWrite(int, int, byte[])}.
   *
   * <ul>
   *   <li>Given {@link Memory} (default constructor).
   *   <li>When empty array of {@code byte}.
   *   <li>Then eleventh element is zero.
   * </ul>
   *
   * <p>Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extendAndWrite(int, int, byte[])"})
  public void testExtendAndWrite_givenMemory_whenEmptyArrayOfByte_thenEleventhElementIsZero() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extendAndWrite(3, 3, new byte[] {});

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals(1024, getResult.length);
  }

  /**
   * Test {@link Memory#extend(int, int)}.
   *
   * <ul>
   *   <li>Given {@link Memory} (default constructor).
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link Memory} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extend(int, int)"})
  public void testExtend_givenMemory_whenMin_value_thenMemorySizeIsZero() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extend(Integer.MIN_VALUE, 3);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#extend(int, int)}.
   *
   * <ul>
   *   <li>Given {@link Memory} (default constructor).
   *   <li>When three.
   *   <li>Then {@link Memory} (default constructor) Chunks size is one.
   * </ul>
   *
   * <p>Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extend(int, int)"})
  public void testExtend_givenMemory_whenThree_thenMemoryChunksSizeIsOne() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extend(1, 3);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    assertEquals(1024, chunks.get(0).length);
    assertEquals(Integer.SIZE, memory.size());
  }

  /**
   * Test {@link Memory#extend(int, int)}.
   *
   * <ul>
   *   <li>Then {@link Memory} (default constructor) Chunks size is one.
   * </ul>
   *
   * <p>Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extend(int, int)"})
  public void testExtend_thenMemoryChunksSizeIsOne() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.extend(1, 1);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    assertEquals(1024, chunks.get(0).length);
    assertEquals(Integer.SIZE, memory.size());
  }

  /**
   * Test {@link Memory#extend(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link Memory} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Memory.extend(int, int)"})
  public void testExtend_whenZero_thenMemorySizeIsZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.extend(1, 0);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#internalSize()}.
   *
   * <p>Method under test: {@link Memory#internalSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Memory.internalSize()"})
  public void testInternalSize() {
    // Arrange, Act and Assert
    assertEquals(0, new Memory().internalSize());
  }

  /**
   * Test {@link Memory#getChunks()}.
   *
   * <p>Method under test: {@link Memory#getChunks()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List Memory.getChunks()"})
  public void testGetChunks() {
    // Arrange, Act and Assert
    assertTrue(new Memory().getChunks().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Memory}
   *   <li>{@link Memory#setProgramListener(ProgramListener)}
   *   <li>{@link Memory#size()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Memory.<init>()",
    "void Memory.setProgramListener(ProgramListener)",
    "int Memory.size()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Memory actualMemory = new Memory();
    actualMemory.setProgramListener(new CompositeProgramListener());

    // Assert
    assertEquals(0, actualMemory.size());
  }
}
