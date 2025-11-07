package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.protos.Protocol;

public class VMDiffblueTest {
  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    VM.play(program, new JumpTable());

    // Assert
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    assertEquals("Invalid operation code: opCode[41];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    VM.play(program, new JumpTable());

    // Assert
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    assertEquals("Invalid operation code: opCode[00];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[00];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    VM.play(program, new JumpTable());

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 50"));
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    assertEquals("Invalid operation code: opCode[41];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, codeAddress, programInvoke,
        new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    VM.play(program, new JumpTable());

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>0258415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 50"));
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    assertEquals("Invalid operation code: opCode[02];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[02];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    VM.play(program, new JumpTable());

    // Assert
    verify(listener)
        .output(eq("\n -- OPS --     \n  >>\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n\n  Spent Energy: 50"));
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    assertEquals("Invalid operation code: opCode[00];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[00];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay6() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    VM.play(program, new JumpTable());

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: 4110411041104110\n\n  Spent Energy: 50"));
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("00", energyLimitLeft.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", energyLimitLeft.toHexString());
    assertEquals("Invalid operation code: opCode[41];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals((byte) 0, clonedData[31]);
    byte[] data = energyLimitLeft.getData();
    assertEquals((byte) 0, data[31]);
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals((byte) 0, last20Bytes[Op.SGT]);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals((byte) 0, toTronAddressResult[Op.EQ]);
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(energyLimitLeft.isZero());
    assertTrue(program.isStopped());
    assertEquals(energyLimitLeft, program.getReturnDataBufferSize());
    assertEquals(Op.EQ, last20Bytes.length);
    assertEquals(Op.ISZERO, toTronAddressResult.length);
    assertEquals(Op.SHA3, clonedData.length);
    assertEquals(Op.SHA3, data.length);
    byte[] noEndZeroesData = energyLimitLeft.getNoEndZeroesData();
    assertSame(noEndZeroesData, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay7() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.setPC(10000);
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    VM.play(program, new JumpTable());

    // Assert that nothing has changed
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000032", energyLimitLeft.toHexString());
    assertEquals("32", energyLimitLeft.toPrefixString());
    assertEquals(0L, program.getResult().getEnergyUsed());
    assertEquals(1, energyLimitLeft.getNoLeadZeroesData().length);
    assertEquals(50L, program.getEnergylimitLeftLong());
    assertFalse(energyLimitLeft.isZero());
    assertTrue(program.isStopped());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(Op.EQ, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(Op.ISZERO, toTronAddressResult.length);
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Op.SHA3, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Op.SHA3, data.length);
    assertEquals('2', clonedData[31]);
    assertEquals('2', data[31]);
    assertEquals('2', last20Bytes[Op.SGT]);
    assertEquals('2', toTronAddressResult[Op.EQ]);
    assertSame(data, energyLimitLeft.getNoEndZeroesData());
  }

  /**
   * Method under test: {@link VM#play(Program, JumpTable)}
   */
  @Test
  public void testPlay8() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    MessageCall msg = new MessageCall(10000, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());
    program.addListener(listener);

    // Act
    VM.play(program, new JumpTable());

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n 0000000000000000000000000000000000000000000000000000000000000000\n\n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 50"));
    ProgramResult result = program.getResult();
    RuntimeException exception = result.getException();
    assertTrue(exception instanceof Program.IllegalOperationException);
    assertEquals("Invalid operation code: opCode[41];", exception.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", exception.getMessage());
    assertNull(exception.getCause());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, result.getEnergyUsed());
    assertTrue(program.isStopped());
    assertEquals(energy, program.getEnergyLimitLeft());
  }
}
