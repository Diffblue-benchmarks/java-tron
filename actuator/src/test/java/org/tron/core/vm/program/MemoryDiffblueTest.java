package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.listener.CompositeProgramListener;
import org.tron.core.vm.program.listener.ProgramListener;
import org.tron.core.vm.trace.ProgramTraceListener;

public class MemoryDiffblueTest {
  /**
   * Test {@link Memory#read(int, int)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@code null}.</li>
   *   <li>When zero.</li>
   *   <li>Then {@link Memory} (default constructor) size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#read(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Memory.read(int, int)"})
  public void testRead_givenMemoryProgramListenerIsNull_whenZero_thenMemorySizeIsZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(null);

    // Act
    byte[] actualReadResult = memory.read(1, 0);

    // Assert
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
    assertArrayEquals(new byte[]{}, actualReadResult);
  }

  /**
   * Test {@link Memory#read(int, int)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When one.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#read(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Memory.read(int, int)"})
  public void testRead_givenMemory_whenOne_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange
    Memory memory = new Memory();

    // Act
    byte[] actualReadResult = memory.read(1, 3);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    assertEquals(1024, chunks.get(0).length);
    assertEquals(Integer.SIZE, memory.size());
    assertArrayEquals(new byte[]{0, 0, 0}, actualReadResult);
  }

  /**
   * Test {@link Memory#read(int, int)}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#read(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Memory.read(int, int)"})
  public void testRead_thenReturnArrayOfByteWithZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    byte[] actualReadResult = memory.read(1, 1);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    assertEquals(1024, chunks.get(0).length);
    assertEquals(Integer.SIZE, memory.size());
    assertArrayEquals(new byte[]{0}, actualReadResult);
  }

  /**
   * Test {@link Memory#write(int, byte[], int, boolean)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@link CompositeProgramListener} (default constructor).</li>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.write(int, byte[], int, boolean)"})
  public void testWrite_givenMemoryProgramListenerIsCompositeProgramListener_whenZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.write(19088743, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, false);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#write(int, byte[], int, boolean)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@code null}.</li>
   *   <li>When zero.</li>
   *   <li>Then {@link Memory} (default constructor) size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.write(int, byte[], int, boolean)"})
  public void testWrite_givenMemoryProgramListenerIsNull_whenZero_thenMemorySizeIsZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(null);

    // Act
    memory.write(19088743, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, false);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#write(int, byte[], int, boolean)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@link ProgramTraceListener#ProgramTraceListener(boolean)} with enabled is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.write(int, byte[], int, boolean)"})
  public void testWrite_givenMemoryProgramListenerIsProgramTraceListenerWithEnabledIsTrue() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new ProgramTraceListener(true));

    // Act
    memory.write(19088743, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, false);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#write(int, byte[], int, boolean)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@link Memory} (default constructor) Chunks size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.write(int, byte[], int, boolean)"})
  public void testWrite_givenMemory_whenAxaxaxaxBytesIsUtf8_thenMemoryChunksSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.write(3, "AXAXAXAX".getBytes("UTF-8"), 3, false);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    assertEquals(1024, chunks.get(0).length);
    assertEquals(Integer.SIZE, memory.size());
  }

  /**
   * Test {@link Memory#write(int, byte[], int, boolean)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then {@link Memory} (default constructor) size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.write(int, byte[], int, boolean)"})
  public void testWrite_givenMemory_whenEmptyArrayOfByte_thenMemorySizeIsZero() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.write(19088743, new byte[]{}, 3, true);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#write(int, byte[], int, boolean)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link Memory} (default constructor) size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.write(int, byte[], int, boolean)"})
  public void testWrite_givenMemory_whenTrue_thenMemorySizeIsZero() throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.write(19088743, "AXAXAXAX".getBytes("UTF-8"), 3, true);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#extendAndWrite(int, int, byte[])}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then second element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.extendAndWrite(int, int, byte[])"})
  public void testExtendAndWrite_givenMemory_whenAxaxaxaxBytesIsUtf8_thenSecondElementIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extendAndWrite(3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals(1024, getResult.length);
    assertEquals('A', getResult[9]);
    assertEquals('X', getResult[10]);
  }

  /**
   * Test {@link Memory#extendAndWrite(int, int, byte[])}.
   * <ul>
   *   <li>Then eleventh element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.extendAndWrite(int, int, byte[])"})
  public void testExtendAndWrite_thenEleventhElementIsZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.extendAndWrite(1, 0, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals(1024, getResult.length);
    assertEquals('A', getResult[1]);
    assertEquals('X', getResult[2]);
  }

  /**
   * Test {@link Memory#extend(int, int)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@link CompositeProgramListener} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.extend(int, int)"})
  public void testExtend_givenMemoryProgramListenerIsCompositeProgramListener() {
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
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@code null}.</li>
   *   <li>When zero.</li>
   *   <li>Then {@link Memory} (default constructor) size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.extend(int, int)"})
  public void testExtend_givenMemoryProgramListenerIsNull_whenZero_thenMemorySizeIsZero() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(null);

    // Act
    memory.extend(1, 0);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Test {@link Memory#extend(int, int)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link Memory} (default constructor) size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>When three.</li>
   *   <li>Then {@link Memory} (default constructor) Chunks size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link Memory#readWord(int)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) ProgramListener is {@link CompositeProgramListener} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#readWord(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Memory.readWord(int)"})
  public void testReadWord_givenMemoryProgramListenerIsCompositeProgramListener() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    DataWord actualReadWordResult = memory.readWord(1);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.getData());
  }

  /**
   * Test {@link Memory#readWord(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Last20Bytes is array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#readWord(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Memory.readWord(int)"})
  public void testReadWord_whenOne_thenReturnLast20BytesIsArrayOfByteWithZeroAndZero() {
    // Arrange and Act
    DataWord actualReadWordResult = (new Memory()).readWord(1);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualReadWordResult.getData());
  }

  /**
   * Test {@link Memory#readByte(int)}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) extend {@code 1024} and three.</li>
   *   <li>When one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#readByte(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte Memory.readByte(int)"})
  public void testReadByte_givenMemoryExtend1024AndThree_whenOne_thenReturnZero() {
    // Arrange
    Memory memory = new Memory();
    memory.extend(1024, 3);

    // Act and Assert
    assertEquals((byte) 0, memory.readByte(1));
  }

  /**
   * Test {@link Memory#toString()}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor) extend one and three.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Memory.toString()"})
  public void testToString_givenMemoryExtendOneAndThree_thenReturnAString() {
    // Arrange
    Memory memory = new Memory();
    memory.extend(1, 3);

    // Act and Assert
    assertEquals("0000 ???????? 00 00 00 00 00 00 00 00 \n" + "0008 ???????? 00 00 00 00 00 00 00 00 \n"
        + "0010 ???????? 00 00 00 00 00 00 00 00 \n" + "0018 ???????? 00 00 00 00 00 00 00 00 ", memory.toString());
  }

  /**
   * Test {@link Memory#toString()}.
   * <ul>
   *   <li>Given {@link Memory} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Memory#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Memory.toString()"})
  public void testToString_givenMemory_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Memory()).toString());
  }

  /**
   * Test {@link Memory#internalSize()}.
   * <p>
   * Method under test: {@link Memory#internalSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Memory.internalSize()"})
  public void testInternalSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new Memory()).internalSize());
  }

  /**
   * Test {@link Memory#getChunks()}.
   * <p>
   * Method under test: {@link Memory#getChunks()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Memory.getChunks()"})
  public void testGetChunks() {
    // Arrange, Act and Assert
    assertTrue((new Memory()).getChunks().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Memory}
   *   <li>{@link Memory#setProgramListener(ProgramListener)}
   *   <li>{@link Memory#size()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Memory.<init>()", "void Memory.setProgramListener(ProgramListener)", "int Memory.size()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Memory actualMemory = new Memory();
    actualMemory.setProgramListener(new CompositeProgramListener());

    // Assert
    assertEquals(0, actualMemory.size());
  }
}
