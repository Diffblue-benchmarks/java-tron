package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.listener.CompositeProgramListener;
import org.tron.core.vm.program.listener.ProgramListener;
import org.tron.core.vm.trace.ProgramTraceListener;

public class MemoryDiffblueTest {
  /**
   * Method under test: {@link Memory#read(int, int)}
   */
  @Test
  public void testRead() {
    // Arrange
    Memory memory = new Memory();

    // Act
    byte[] actualReadResult = memory.read(1, 3);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
    assertArrayEquals(new byte[]{0, 0, 0}, actualReadResult);
  }

  /**
   * Method under test: {@link Memory#read(int, int)}
   */
  @Test
  public void testRead2() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(null);

    // Act
    byte[] actualReadResult = memory.read(1, 0);

    // Assert
    assertEquals(0, memory.size());
    assertEquals(0, actualReadResult.length);
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Method under test: {@link Memory#read(int, int)}
   */
  @Test
  public void testRead3() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    byte[] actualReadResult = memory.read(1, 1);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
    assertArrayEquals(new byte[]{0}, actualReadResult);
  }

  /**
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  public void testWrite() throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.write(19088743, "AXAXAXAX".getBytes("UTF-8"), 3, true);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  public void testWrite2() {
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
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  public void testWrite3() {
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
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  public void testWrite4() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.write(19088743, new byte[]{}, 3, true);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  public void testWrite5() throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.write(3, "AXAXAXAX".getBytes("UTF-8"), 3, false);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
    assertEquals('A', getResult[3]);
    assertEquals('A', getResult[5]);
    assertEquals('X', getResult[4]);
  }

  /**
   * Method under test: {@link Memory#write(int, byte[], int, boolean)}
   */
  @Test
  public void testWrite6() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new ProgramTraceListener(true));

    // Act
    memory.write(19088743, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, false);

    // Assert
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  public void testExtendAndWrite() throws UnsupportedEncodingException {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extendAndWrite(3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
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
   * Method under test: {@link Memory#extendAndWrite(int, int, byte[])}
   */
  @Test
  public void testExtendAndWrite2() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.extendAndWrite(1, 0, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
    assertEquals('A', getResult[1]);
    assertEquals('A', getResult[3]);
    assertEquals('A', getResult[5]);
    assertEquals('A', getResult[7]);
    assertEquals('X', getResult[2]);
    assertEquals('X', getResult[4]);
    assertEquals('X', getResult[6]);
    assertEquals('X', getResult[8]);
  }

  /**
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  public void testExtend() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extend(1, 3);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
  }

  /**
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  public void testExtend2() {
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
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  public void testExtend3() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    memory.extend(1, 1);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(Integer.SIZE, memory.size());
  }

  /**
   * Method under test: {@link Memory#extend(int, int)}
   */
  @Test
  public void testExtend4() {
    // Arrange
    Memory memory = new Memory();

    // Act
    memory.extend(Integer.MIN_VALUE, 3);

    // Assert that nothing has changed
    assertEquals(0, memory.size());
    assertTrue(memory.getChunks().isEmpty());
  }

  /**
   * Method under test: {@link Memory#readWord(int)}
   */
  @Test
  public void testReadWord() {
    // Arrange
    Memory memory = new Memory();

    // Act
    DataWord actualReadWordResult = memory.readWord(1);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(actualReadWordResult.ZERO, actualReadWordResult);
    assertEquals(Double.SIZE, memory.size());
  }

  /**
   * Method under test: {@link Memory#readWord(int)}
   */
  @Test
  public void testReadWord2() {
    // Arrange
    Memory memory = new Memory();
    memory.setProgramListener(new CompositeProgramListener());

    // Act
    DataWord actualReadWordResult = memory.readWord(1);

    // Assert
    List<byte[]> chunks = memory.getChunks();
    assertEquals(1, chunks.size());
    byte[] getResult = chunks.get(0);
    assertEquals((byte) 0, getResult[0]);
    assertEquals((byte) 0, getResult[1]);
    assertEquals((byte) 0, getResult[10]);
    assertEquals((byte) 0, getResult[1000]);
    assertEquals((byte) 0, getResult[1001]);
    assertEquals((byte) 0, getResult[1002]);
    assertEquals((byte) 0, getResult[1003]);
    assertEquals((byte) 0, getResult[1004]);
    assertEquals((byte) 0, getResult[1005]);
    assertEquals((byte) 0, getResult[1006]);
    assertEquals((byte) 0, getResult[1007]);
    assertEquals((byte) 0, getResult[1008]);
    assertEquals((byte) 0, getResult[1009]);
    assertEquals((byte) 0, getResult[1010]);
    assertEquals((byte) 0, getResult[1011]);
    assertEquals((byte) 0, getResult[1012]);
    assertEquals((byte) 0, getResult[1013]);
    assertEquals((byte) 0, getResult[1014]);
    assertEquals((byte) 0, getResult[1015]);
    assertEquals((byte) 0, getResult[1016]);
    assertEquals((byte) 0, getResult[1017]);
    assertEquals((byte) 0, getResult[1018]);
    assertEquals((byte) 0, getResult[1019]);
    assertEquals((byte) 0, getResult[1020]);
    assertEquals((byte) 0, getResult[1021]);
    assertEquals((byte) 0, getResult[1022]);
    assertEquals((byte) 0, getResult[11]);
    assertEquals((byte) 0, getResult[12]);
    assertEquals((byte) 0, getResult[13]);
    assertEquals((byte) 0, getResult[14]);
    assertEquals((byte) 0, getResult[15]);
    assertEquals((byte) 0, getResult[17]);
    assertEquals((byte) 0, getResult[18]);
    assertEquals((byte) 0, getResult[19]);
    assertEquals((byte) 0, getResult[2]);
    assertEquals((byte) 0, getResult[20]);
    assertEquals((byte) 0, getResult[21]);
    assertEquals((byte) 0, getResult[22]);
    assertEquals((byte) 0, getResult[23]);
    assertEquals((byte) 0, getResult[24]);
    assertEquals((byte) 0, getResult[3]);
    assertEquals((byte) 0, getResult[4]);
    assertEquals((byte) 0, getResult[5]);
    assertEquals((byte) 0, getResult[6]);
    assertEquals((byte) 0, getResult[7]);
    assertEquals((byte) 0, getResult[8]);
    assertEquals((byte) 0, getResult[9]);
    assertEquals((byte) 0, getResult[999]);
    assertEquals((byte) 0, getResult[Double.MAX_EXPONENT]);
    assertEquals((byte) 0, getResult[Short.SIZE]);
    assertEquals(1024, getResult.length);
    assertEquals(actualReadWordResult.ZERO, actualReadWordResult);
    assertEquals(Double.SIZE, memory.size());
  }

  /**
   * Method under test: {@link Memory#readByte(int)}
   */
  @Test
  public void testReadByte() {
    // Arrange
    Memory memory = new Memory();
    memory.extend(1024, 3);

    // Act and Assert
    assertEquals((byte) 0, memory.readByte(1));
  }

  /**
   * Method under test: {@link Memory#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new Memory()).toString());
  }

  /**
   * Method under test: {@link Memory#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    Memory memory = new Memory();
    memory.extend(1, 3);

    // Act and Assert
    assertEquals("0000 ???????? 00 00 00 00 00 00 00 00 \n" + "0008 ???????? 00 00 00 00 00 00 00 00 \n"
        + "0010 ???????? 00 00 00 00 00 00 00 00 \n" + "0018 ???????? 00 00 00 00 00 00 00 00 ", memory.toString());
  }

  /**
   * Method under test: {@link Memory#internalSize()}
   */
  @Test
  public void testInternalSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new Memory()).internalSize());
  }

  /**
   * Method under test: {@link Memory#getChunks()}
   */
  @Test
  public void testGetChunks() {
    // Arrange, Act and Assert
    assertTrue((new Memory()).getChunks().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Memory}
   *   <li>{@link Memory#setProgramListener(ProgramListener)}
   *   <li>{@link Memory#size()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Memory actualMemory = new Memory();
    actualMemory.setProgramListener(new CompositeProgramListener());

    // Assert that nothing has changed
    assertEquals(0, actualMemory.size());
  }
}
