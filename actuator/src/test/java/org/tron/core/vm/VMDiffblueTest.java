package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Program.IllegalOperationException;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;

public class VMDiffblueTest {
  /**
   * Test {@link VM#play(Program, JumpTable)}.
   * <p>
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VM.play(Program, JumpTable)"})
  public void testPlay() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    VM.play(program, new JumpTable());

    // Assert
    RuntimeException exception = program.getResult().getException();
    assertTrue(exception instanceof IllegalOperationException);
    assertEquals("Invalid operation code: opCode[41];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", exception.getMessage());
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.getData());
  }

  /**
   * Test {@link VM#play(Program, JumpTable)}.
   * <p>
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VM.play(Program, JumpTable)"})
  public void testPlay2() throws UnsupportedEncodingException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    VM.play(program, new JumpTable());

    // Assert
    RuntimeException exception = program.getResult().getException();
    assertTrue(exception instanceof IllegalOperationException);
    assertEquals("Invalid operation code: opCode[00];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[00];", exception.getMessage());
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        energyLimitLeft.getData());
  }
}
