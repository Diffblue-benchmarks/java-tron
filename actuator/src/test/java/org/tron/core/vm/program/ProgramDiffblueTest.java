package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.exception.AccountResourceInsufficientException;
import org.tron.core.exception.TronException;
import org.tron.core.vm.program.Program.AssetIssueException;
import org.tron.core.vm.program.Program.BadJumpDestinationException;
import org.tron.core.vm.program.Program.ByteCodeIterator;
import org.tron.core.vm.program.Program.BytecodeExecutionException;
import org.tron.core.vm.program.Program.Exception;
import org.tron.core.vm.program.Program.IllegalOperationException;
import org.tron.core.vm.program.Program.InvalidCodeException;
import org.tron.core.vm.program.Program.JVMStackOverFlowException;
import org.tron.core.vm.program.Program.OutOfEnergyException;
import org.tron.core.vm.program.Program.OutOfMemoryException;
import org.tron.core.vm.program.Program.OutOfStorageException;
import org.tron.core.vm.program.Program.OutOfTimeException;
import org.tron.core.vm.program.Program.PrecompiledContractException;
import org.tron.core.vm.program.Program.ReturnDataCopyIllegalBoundsException;
import org.tron.core.vm.program.Program.StackTooSmallException;
import org.tron.core.vm.program.Program.StaticCallModificationException;
import org.tron.core.vm.program.Program.TransferException;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.trace.Op;
import org.tron.core.vm.trace.OpActions;

public class ProgramDiffblueTest {
  /**
   * Test AssetIssueException {@link AssetIssueException#AssetIssueException(String, Object[])}.
   *
   * <p>Method under test: {@link AssetIssueException#AssetIssueException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetIssueException.<init>(String, Object[])"})
  public void testAssetIssueExceptionNewAssetIssueException() {
    // Arrange and Act
    AssetIssueException actualAssetIssueException =
        new AssetIssueException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualAssetIssueException.getLocalizedMessage());
    assertEquals("An error occurred", actualAssetIssueException.getMessage());
    assertNull(actualAssetIssueException.getCause());
    assertEquals(0, actualAssetIssueException.getSuppressed().length);
  }

  /**
   * Test BadJumpDestinationException {@link
   * BadJumpDestinationException#BadJumpDestinationException(String, Object[])}.
   *
   * <p>Method under test: {@link BadJumpDestinationException#BadJumpDestinationException(String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BadJumpDestinationException.<init>(String, Object[])"})
  public void testBadJumpDestinationExceptionNewBadJumpDestinationException() {
    // Arrange and Act
    BadJumpDestinationException actualBadJumpDestinationException =
        new BadJumpDestinationException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualBadJumpDestinationException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadJumpDestinationException.getMessage());
    assertNull(actualBadJumpDestinationException.getCause());
    assertEquals(0, actualBadJumpDestinationException.getSuppressed().length);
  }

  /**
   * Test ByteCodeIterator getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ByteCodeIterator#ByteCodeIterator(byte[])}
   *   <li>{@link ByteCodeIterator#setPC(int)}
   *   <li>{@link ByteCodeIterator#getPC()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ByteCodeIterator.<init>(byte[])",
    "int ByteCodeIterator.getPC()",
    "void ByteCodeIterator.setPC(int)"
  })
  public void testByteCodeIteratorGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ByteCodeIterator actualByteCodeIterator = new ByteCodeIterator("AXAXAXAX".getBytes("UTF-8"));
    actualByteCodeIterator.setPC(1);

    // Assert
    assertEquals(1, actualByteCodeIterator.getPC());
  }

  /**
   * Test BytecodeExecutionException {@link
   * BytecodeExecutionException#BytecodeExecutionException(String)}.
   *
   * <p>Method under test: {@link BytecodeExecutionException#BytecodeExecutionException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BytecodeExecutionException.<init>(String)"})
  public void testBytecodeExecutionExceptionNewBytecodeExecutionException() {
    // Arrange and Act
    BytecodeExecutionException actualBytecodeExecutionException =
        new BytecodeExecutionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBytecodeExecutionException.getMessage());
    assertNull(actualBytecodeExecutionException.getCause());
    assertEquals(0, actualBytecodeExecutionException.getSuppressed().length);
  }

  /**
   * Test BytecodeExecutionException {@link
   * BytecodeExecutionException#BytecodeExecutionException(String, Object[])}.
   *
   * <p>Method under test: {@link BytecodeExecutionException#BytecodeExecutionException(String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BytecodeExecutionException.<init>(String, Object[])"})
  public void testBytecodeExecutionExceptionNewBytecodeExecutionException2() {
    // Arrange and Act
    BytecodeExecutionException actualBytecodeExecutionException =
        new BytecodeExecutionException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualBytecodeExecutionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBytecodeExecutionException.getMessage());
    assertNull(actualBytecodeExecutionException.getCause());
    assertEquals(0, actualBytecodeExecutionException.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#alreadyTimeOut()}.
   *
   * <p>Method under test: {@link Exception#alreadyTimeOut()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfTimeException Exception.alreadyTimeOut()"})
  public void testExceptionAlreadyTimeOut() {
    // Arrange and Act
    OutOfTimeException actualAlreadyTimeOutResult = Exception.alreadyTimeOut();

    // Assert
    assertEquals("Already Time Out", actualAlreadyTimeOutResult.getLocalizedMessage());
    assertEquals("Already Time Out", actualAlreadyTimeOutResult.getMessage());
    assertNull(actualAlreadyTimeOutResult.getCause());
    assertEquals(0, actualAlreadyTimeOutResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#badJumpDestination(int)}.
   *
   * <p>Method under test: {@link Exception#badJumpDestination(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BadJumpDestinationException Exception.badJumpDestination(int)"})
  public void testExceptionBadJumpDestination() {
    // Arrange and Act
    BadJumpDestinationException actualBadJumpDestinationResult = Exception.badJumpDestination(1);

    // Assert
    assertEquals(
        "Operation with pc isn't 'JUMPDEST': PC[1];",
        actualBadJumpDestinationResult.getLocalizedMessage());
    assertEquals(
        "Operation with pc isn't 'JUMPDEST': PC[1];", actualBadJumpDestinationResult.getMessage());
    assertNull(actualBadJumpDestinationResult.getCause());
    assertEquals(0, actualBadJumpDestinationResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#contractExecuteException(TronException)}.
   *
   * <p>Method under test: {@link Exception#contractExecuteException(TronException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrecompiledContractException Exception.contractExecuteException(TronException)"
  })
  public void testExceptionContractExecuteException() {
    // Arrange and Act
    PrecompiledContractException actualContractExecuteExceptionResult =
        Exception.contractExecuteException(
            new AccountResourceInsufficientException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualContractExecuteExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualContractExecuteExceptionResult.getMessage());
    assertNull(actualContractExecuteExceptionResult.getCause());
    assertEquals(0, actualContractExecuteExceptionResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#contractValidateException(TronException)}.
   *
   * <p>Method under test: {@link Exception#contractValidateException(TronException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrecompiledContractException Exception.contractValidateException(TronException)"
  })
  public void testExceptionContractValidateException() {
    // Arrange and Act
    PrecompiledContractException actualContractValidateExceptionResult =
        Exception.contractValidateException(
            new AccountResourceInsufficientException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualContractValidateExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateExceptionResult.getMessage());
    assertNull(actualContractValidateExceptionResult.getCause());
    assertEquals(0, actualContractValidateExceptionResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#energyOverflow(BigInteger, BigInteger)}.
   *
   * <p>Method under test: {@link Exception#energyOverflow(BigInteger, BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfEnergyException Exception.energyOverflow(BigInteger, BigInteger)"})
  public void testExceptionEnergyOverflow() {
    // Arrange and Act
    OutOfEnergyException actualEnergyOverflowResult =
        Exception.energyOverflow(BigInteger.valueOf(1L), BigInteger.valueOf(1L));

    // Assert
    assertEquals(
        "Energy value overflow: actualEnergy[1], energyLimit[1];",
        actualEnergyOverflowResult.getLocalizedMessage());
    assertEquals(
        "Energy value overflow: actualEnergy[1], energyLimit[1];",
        actualEnergyOverflowResult.getMessage());
    assertNull(actualEnergyOverflowResult.getCause());
    assertEquals(0, actualEnergyOverflowResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#invalidCodeException()}.
   *
   * <p>Method under test: {@link Exception#invalidCodeException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InvalidCodeException Exception.invalidCodeException()"})
  public void testExceptionInvalidCodeException() {
    // Arrange and Act
    InvalidCodeException actualInvalidCodeExceptionResult = Exception.invalidCodeException();

    // Assert
    assertEquals(
        "invalid code: must not begin with 0xef",
        actualInvalidCodeExceptionResult.getLocalizedMessage());
    assertEquals(
        "invalid code: must not begin with 0xef", actualInvalidCodeExceptionResult.getMessage());
    assertNull(actualInvalidCodeExceptionResult.getCause());
    assertEquals(0, actualInvalidCodeExceptionResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#invalidOpCode(byte[])}.
   *
   * <p>Method under test: {@link Exception#invalidOpCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IllegalOperationException Exception.invalidOpCode(byte[])"})
  public void testExceptionInvalidOpCode() throws UnsupportedEncodingException {
    // Arrange and Act
    IllegalOperationException actualInvalidOpCodeResult =
        Exception.invalidOpCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getMessage());
    assertNull(actualInvalidOpCodeResult.getCause());
    assertEquals(0, actualInvalidOpCodeResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#memoryOverflow(int)}.
   *
   * <p>Method under test: {@link Exception#memoryOverflow(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfMemoryException Exception.memoryOverflow(int)"})
  public void testExceptionMemoryOverflow() {
    // Arrange and Act
    OutOfMemoryException actualMemoryOverflowResult = Exception.memoryOverflow(1);

    // Assert
    assertEquals(
        "Out of Memory when 'ADD' operation executing",
        actualMemoryOverflowResult.getLocalizedMessage());
    assertEquals(
        "Out of Memory when 'ADD' operation executing", actualMemoryOverflowResult.getMessage());
    assertNull(actualMemoryOverflowResult.getCause());
    assertEquals(0, actualMemoryOverflowResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#notEnoughSpendEnergy(String, long, long)}.
   *
   * <p>Method under test: {@link Exception#notEnoughSpendEnergy(String, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfEnergyException Exception.notEnoughSpendEnergy(String, long, long)"})
  public void testExceptionNotEnoughSpendEnergy() {
    // Arrange and Act
    OutOfEnergyException actualNotEnoughSpendEnergyResult =
        Exception.notEnoughSpendEnergy("Hint", 1L, 1L);

    // Assert
    assertEquals(
        "Not enough energy for 'Hint' executing: needEnergy[1], leftEnergy[1];",
        actualNotEnoughSpendEnergyResult.getLocalizedMessage());
    assertEquals(
        "Not enough energy for 'Hint' executing: needEnergy[1], leftEnergy[1];",
        actualNotEnoughSpendEnergyResult.getMessage());
    assertNull(actualNotEnoughSpendEnergyResult.getCause());
    assertEquals(0, actualNotEnoughSpendEnergyResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#notEnoughStorage()}.
   *
   * <p>Method under test: {@link Exception#notEnoughStorage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfStorageException Exception.notEnoughStorage()"})
  public void testExceptionNotEnoughStorage() {
    // Arrange and Act
    OutOfStorageException actualNotEnoughStorageResult = Exception.notEnoughStorage();

    // Assert
    assertEquals(
        "Not enough ContractState resource", actualNotEnoughStorageResult.getLocalizedMessage());
    assertEquals("Not enough ContractState resource", actualNotEnoughStorageResult.getMessage());
    assertNull(actualNotEnoughStorageResult.getCause());
    assertEquals(0, actualNotEnoughStorageResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#notEnoughTime(String)}.
   *
   * <p>Method under test: {@link Exception#notEnoughTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfTimeException Exception.notEnoughTime(String)"})
  public void testExceptionNotEnoughTime() {
    // Arrange and Act
    OutOfTimeException actualNotEnoughTimeResult = Exception.notEnoughTime("Op");

    // Assert
    assertEquals(
        "CPU timeout for 'Op' operation executing",
        actualNotEnoughTimeResult.getLocalizedMessage());
    assertEquals(
        "CPU timeout for 'Op' operation executing", actualNotEnoughTimeResult.getMessage());
    assertNull(actualNotEnoughTimeResult.getCause());
    assertEquals(0, actualNotEnoughTimeResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#tooSmallStack(int, int)}.
   *
   * <p>Method under test: {@link Exception#tooSmallStack(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StackTooSmallException Exception.tooSmallStack(int, int)"})
  public void testExceptionTooSmallStack() {
    // Arrange and Act
    StackTooSmallException actualTooSmallStackResult = Exception.tooSmallStack(3, 3);

    // Assert
    assertEquals(
        "Expected stack size 3 but actual 3;", actualTooSmallStackResult.getLocalizedMessage());
    assertEquals("Expected stack size 3 but actual 3;", actualTooSmallStackResult.getMessage());
    assertNull(actualTooSmallStackResult.getCause());
    assertEquals(0, actualTooSmallStackResult.getSuppressed().length);
  }

  /**
   * Test IllegalOperationException {@link
   * IllegalOperationException#IllegalOperationException(String, Object[])}.
   *
   * <p>Method under test: {@link IllegalOperationException#IllegalOperationException(String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IllegalOperationException.<init>(String, Object[])"})
  public void testIllegalOperationExceptionNewIllegalOperationException() {
    // Arrange and Act
    IllegalOperationException actualIllegalOperationException =
        new IllegalOperationException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualIllegalOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualIllegalOperationException.getMessage());
    assertNull(actualIllegalOperationException.getCause());
    assertEquals(0, actualIllegalOperationException.getSuppressed().length);
  }

  /**
   * Test InvalidCodeException {@link InvalidCodeException#InvalidCodeException(String)}.
   *
   * <p>Method under test: {@link InvalidCodeException#InvalidCodeException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvalidCodeException.<init>(String)"})
  public void testInvalidCodeExceptionNewInvalidCodeException() {
    // Arrange and Act
    InvalidCodeException actualInvalidCodeException = new InvalidCodeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidCodeException.getMessage());
    assertNull(actualInvalidCodeException.getCause());
    assertEquals(0, actualInvalidCodeException.getSuppressed().length);
  }

  /**
   * Test JVMStackOverFlowException new {@link JVMStackOverFlowException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link JVMStackOverFlowException}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JVMStackOverFlowException.<init>()"})
  public void testJVMStackOverFlowExceptionNewJVMStackOverFlowException() {
    // Arrange and Act
    JVMStackOverFlowException actualJvmStackOverFlowException = new JVMStackOverFlowException();

    // Assert
    assertEquals(
        "StackOverflowError:  exceed default JVM stack size!",
        actualJvmStackOverFlowException.getMessage());
    assertNull(actualJvmStackOverFlowException.getCause());
    assertEquals(0, actualJvmStackOverFlowException.getSuppressed().length);
  }

  /**
   * Test {@link Program#Program(byte[], byte[], ProgramInvoke, InternalTransaction)}.
   *
   * <ul>
   *   <li>Then ContractState return {@link ContractState}.
   * </ul>
   *
   * <p>Method under test: {@link Program#Program(byte[], byte[], ProgramInvoke,
   * InternalTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.<init>(byte[], byte[], ProgramInvoke, InternalTransaction)"})
  public void testNewProgram_thenContractStateReturnContractState()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Program actualProgram =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Assert
    assertTrue(actualProgram.getContractState() instanceof ContractState);
    assertNull(actualProgram.getAdjustedCallEnergy());
    assertEquals(0, actualProgram.getCallDeep());
    assertEquals(0, actualProgram.getContractVersion());
    assertEquals(0, actualProgram.getMemSize());
    assertEquals(0, actualProgram.getPC());
    assertEquals(0L, actualProgram.getCallPenaltyEnergy());
    assertEquals(0L, actualProgram.getContextContractFactor());
    assertEquals(0L, actualProgram.getVmShouldEndInUs());
    assertEquals(0L, actualProgram.getVmStartInUs());
    assertEquals((byte) 0, actualProgram.getLastOp());
    assertEquals((byte) 0, actualProgram.getPreviouslyExecutedOp());
    assertEquals(1L, actualProgram.getNonce());
    assertEquals(50L, actualProgram.getEnergylimitLeftLong());
    assertEquals(65, actualProgram.getCurrentOpIntValue());
    assertFalse(actualProgram.isConstantCall());
    assertFalse(actualProgram.isStaticCall());
    assertFalse(actualProgram.isStopped());
    assertTrue(actualProgram.getStorageDiff().isEmpty());
    assertTrue(actualProgram.getStack().isEmpty());
    assertEquals('A', actualProgram.getCurrentOp());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualProgram.getCode());
    assertArrayEquals(new byte[] {}, actualProgram.getMemory());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        actualProgram.getContextAddress());
  }

  /**
   * Test {@link Program#formatBinData(byte[], int)}.
   *
   * <ul>
   *   <li>When minus seventeen.
   *   <li>Then return {@code ffffffef:4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link Program#formatBinData(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Program.formatBinData(byte[], int)"})
  public void testFormatBinData_whenMinusSeventeen_thenReturnFfffffef4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "ffffffef:4158415841584158\n", Program.formatBinData("AXAXAXAX".getBytes("UTF-8"), -17));
  }

  /**
   * Test {@link Program#formatBinData(byte[], int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 1: 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link Program#formatBinData(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Program.formatBinData(byte[], int)"})
  public void testFormatBinData_whenOne_thenReturn14158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "1:      4158415841584158\n", Program.formatBinData("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test OutOfEnergyException {@link OutOfEnergyException#OutOfEnergyException(String, Object[])}.
   *
   * <p>Method under test: {@link OutOfEnergyException#OutOfEnergyException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OutOfEnergyException.<init>(String, Object[])"})
  public void testOutOfEnergyExceptionNewOutOfEnergyException() {
    // Arrange and Act
    OutOfEnergyException actualOutOfEnergyException =
        new OutOfEnergyException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfEnergyException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfEnergyException.getMessage());
    assertNull(actualOutOfEnergyException.getCause());
    assertEquals(0, actualOutOfEnergyException.getSuppressed().length);
  }

  /**
   * Test OutOfMemoryException {@link OutOfMemoryException#OutOfMemoryException(String, Object[])}.
   *
   * <p>Method under test: {@link OutOfMemoryException#OutOfMemoryException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OutOfMemoryException.<init>(String, Object[])"})
  public void testOutOfMemoryExceptionNewOutOfMemoryException() {
    // Arrange and Act
    OutOfMemoryException actualOutOfMemoryException =
        new OutOfMemoryException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfMemoryException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfMemoryException.getMessage());
    assertNull(actualOutOfMemoryException.getCause());
    assertEquals(0, actualOutOfMemoryException.getSuppressed().length);
  }

  /**
   * Test OutOfStorageException {@link OutOfStorageException#OutOfStorageException(String,
   * Object[])}.
   *
   * <p>Method under test: {@link OutOfStorageException#OutOfStorageException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OutOfStorageException.<init>(String, Object[])"})
  public void testOutOfStorageExceptionNewOutOfStorageException() {
    // Arrange and Act
    OutOfStorageException actualOutOfStorageException =
        new OutOfStorageException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfStorageException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfStorageException.getMessage());
    assertNull(actualOutOfStorageException.getCause());
    assertEquals(0, actualOutOfStorageException.getSuppressed().length);
  }

  /**
   * Test OutOfTimeException {@link OutOfTimeException#OutOfTimeException(String, Object[])}.
   *
   * <p>Method under test: {@link OutOfTimeException#OutOfTimeException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OutOfTimeException.<init>(String, Object[])"})
  public void testOutOfTimeExceptionNewOutOfTimeException() {
    // Arrange and Act
    OutOfTimeException actualOutOfTimeException =
        new OutOfTimeException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfTimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfTimeException.getMessage());
    assertNull(actualOutOfTimeException.getCause());
    assertEquals(0, actualOutOfTimeException.getSuppressed().length);
  }

  /**
   * Test PrecompiledContractException {@link
   * PrecompiledContractException#PrecompiledContractException(String, Object[])}.
   *
   * <p>Method under test: {@link PrecompiledContractException#PrecompiledContractException(String,
   * Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrecompiledContractException.<init>(String, Object[])"})
  public void testPrecompiledContractExceptionNewPrecompiledContractException() {
    // Arrange and Act
    PrecompiledContractException actualPrecompiledContractException =
        new PrecompiledContractException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualPrecompiledContractException.getLocalizedMessage());
    assertEquals("An error occurred", actualPrecompiledContractException.getMessage());
    assertNull(actualPrecompiledContractException.getCause());
    assertEquals(0, actualPrecompiledContractException.getSuppressed().length);
  }

  /**
   * Test ReturnDataCopyIllegalBoundsException {@link
   * ReturnDataCopyIllegalBoundsException#ReturnDataCopyIllegalBoundsException(DataWord, DataWord,
   * long)}.
   *
   * <p>Method under test: {@link
   * ReturnDataCopyIllegalBoundsException#ReturnDataCopyIllegalBoundsException(DataWord, DataWord,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReturnDataCopyIllegalBoundsException.<init>(DataWord, DataWord, long)"})
  public void testReturnDataCopyIllegalBoundsExceptionNewReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord off = DataWord.ZERO();

    // Act
    ReturnDataCopyIllegalBoundsException actualReturnDataCopyIllegalBoundsException =
        new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L);

    // Assert
    assertEquals(
        "Illegal RETURNDATACOPY arguments: offset (000000000000000000000000000000000000000000000000000000"
            + "0000000000) + size (0000000000000000000000000000000000000000000000000000000000000000) > RETURNDATASIZE"
            + " (3)",
        actualReturnDataCopyIllegalBoundsException.getLocalizedMessage());
    assertEquals(
        "Illegal RETURNDATACOPY arguments: offset (000000000000000000000000000000000000000000000000000000"
            + "0000000000) + size (0000000000000000000000000000000000000000000000000000000000000000) > RETURNDATASIZE"
            + " (3)",
        actualReturnDataCopyIllegalBoundsException.getMessage());
    assertNull(actualReturnDataCopyIllegalBoundsException.getCause());
    assertEquals(0, actualReturnDataCopyIllegalBoundsException.getSuppressed().length);
  }

  /**
   * Test {@link Program#setRootTransactionId(byte[])}.
   *
   * <p>Method under test: {@link Program#setRootTransactionId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.setRootTransactionId(byte[])"})
  public void testSetRootTransactionId() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.setRootTransactionId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), program.getRootTransactionId());
  }

  /**
   * Test {@link Program#getCallDeep()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Program#getCallDeep()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Program.getCallDeep()"})
  public void testGetCallDeep_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals(0, program.getCallDeep());
  }

  /**
   * Test {@link Program#getStorageDiff()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Program#getStorageDiff()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map Program.getStorageDiff()"})
  public void testGetStorageDiff_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertTrue(program.getStorageDiff().isEmpty());
  }

  /**
   * Test {@link Program#getOp(int)}.
   *
   * <ul>
   *   <li>Then return {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getOp(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Program.getOp(int)"})
  public void testGetOp_thenReturnX() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals('X', program.getOp(1));
  }

  /**
   * Test {@link Program#getCurrentOp()}.
   *
   * <ul>
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getCurrentOp()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Program.getCurrentOp()"})
  public void testGetCurrentOp_thenReturnA() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals('A', program.getCurrentOp());
  }

  /**
   * Test {@link Program#getCurrentOpIntValue()}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link Program#getCurrentOpIntValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Program.getCurrentOpIntValue()"})
  public void testGetCurrentOpIntValue_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals(65, program.getCurrentOpIntValue());
  }

  /**
   * Test {@link Program#stackPush(byte[])} with {@code data}.
   *
   * <p>Method under test: {@link Program#stackPush(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.stackPush(byte[])"})
  public void testStackPushWithData() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.stackPush("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158",
        getResult.toHexString());
    assertEquals("415841", getResult.toPrefixString());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), getResult.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        getResult.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        data2);
  }

  /**
   * Test {@link Program#stackPush(DataWord)} with {@code stackWord}.
   *
   * <p>Method under test: {@link Program#stackPush(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.stackPush(DataWord)"})
  public void testStackPushWithStackWord() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord stackWord = DataWord.ZERO();

    // Act
    program.stackPush(stackWord);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertSame(stackWord, stack.get(0));
  }

  /**
   * Test {@link Program#stackPushZero()}.
   *
   * <p>Method under test: {@link Program#stackPushZero()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.stackPushZero()"})
  public void testStackPushZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.stackPushZero();

    // Assert
    assertEquals(1, program.getStack().size());
  }

  /**
   * Test {@link Program#stackPushOne()}.
   *
   * <p>Method under test: {@link Program#stackPushOne()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.stackPushOne()"})
  public void testStackPushOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.stackPushOne();

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000001",
        getResult.toHexString());
    assertEquals("01", getResult.toPrefixString());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[] {1}, getResult.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 1
        },
        getResult.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 1
        },
        data2);
  }

  /**
   * Test {@link Program#setPC(int)} with {@code int}.
   *
   * <p>Method under test: {@link Program#setPC(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.setPC(int)"})
  public void testSetPCWithInt() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.setPC(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link Program#setHReturn(byte[])}.
   *
   * <p>Method under test: {@link Program#setHReturn(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.setHReturn(byte[])"})
  public void testSetHReturn() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    byte[] buff = "AXAXAXAX".getBytes("UTF-8");

    // Act
    program.setHReturn(buff);

    // Assert
    assertSame(buff, program.getResult().getHReturn());
  }

  /**
   * Test StackTooSmallException {@link StackTooSmallException#StackTooSmallException(String,
   * Object[])}.
   *
   * <p>Method under test: {@link StackTooSmallException#StackTooSmallException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackTooSmallException.<init>(String, Object[])"})
  public void testStackTooSmallExceptionNewStackTooSmallException() {
    // Arrange and Act
    StackTooSmallException actualStackTooSmallException =
        new StackTooSmallException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualStackTooSmallException.getLocalizedMessage());
    assertEquals("An error occurred", actualStackTooSmallException.getMessage());
    assertNull(actualStackTooSmallException.getCause());
    assertEquals(0, actualStackTooSmallException.getSuppressed().length);
  }

  /**
   * Test StaticCallModificationException new {@link StaticCallModificationException} (default
   * constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * StaticCallModificationException}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticCallModificationException.<init>()"})
  public void testStaticCallModificationExceptionNewStaticCallModificationException() {
    // Arrange and Act
    StaticCallModificationException actualStaticCallModificationException =
        new StaticCallModificationException();

    // Assert
    assertEquals(
        "Attempt to call a state modifying opcode inside STATICCALL",
        actualStaticCallModificationException.getMessage());
    assertNull(actualStaticCallModificationException.getCause());
    assertEquals(0, actualStaticCallModificationException.getSuppressed().length);
  }

  /**
   * Test {@link Program#step()}.
   *
   * <p>Method under test: {@link Program#step()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.step()"})
  public void testStep() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.step();

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link Program#sweep(int)}.
   *
   * <p>Method under test: {@link Program#sweep(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.sweep(int)"})
  public void testSweep() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    byte[] actualSweepResult = program.sweep(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    assertArrayEquals(new byte[] {'A'}, actualSweepResult);
  }

  /**
   * Test {@link Program#getMemSize()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Program#getMemSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Program.getMemSize()"})
  public void testGetMemSize_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals(0, program.getMemSize());
  }

  /**
   * Test {@link Program#memorySave(int, int, byte[])} with {@code addr}, {@code allocSize}, {@code
   * value}.
   *
   * <p>Method under test: {@link Program#memorySave(int, int, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.memorySave(int, int, byte[])"})
  public void testMemorySaveWithAddrAllocSizeValue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.memorySave(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[] {}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[] {
          0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#memorySave(DataWord, DataWord)} with {@code addrB}, {@code value}.
   *
   * <p>Method under test: {@link Program#memorySave(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.memorySave(DataWord, DataWord)"})
  public void testMemorySaveWithAddrBValue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord addrB = DataWord.ZERO();

    // Act
    program.memorySave(addrB, DataWord.ZERO());

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[] {}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#memorySave(int, byte[])} with {@code addr}, {@code value}.
   *
   * <p>Method under test: {@link Program#memorySave(int, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.memorySave(int, byte[])"})
  public void testMemorySaveWithAddrValue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.memorySave(1, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[] {}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[] {
          0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#memoryLoad(DataWord)} with {@code addr}.
   *
   * <ul>
   *   <li>Then return ZERO.
   * </ul>
   *
   * <p>Method under test: {@link Program#memoryLoad(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.memoryLoad(DataWord)"})
  public void testMemoryLoadWithAddr_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord addr = DataWord.ZERO();

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(addr);

    // Assert
    assertEquals(addr, actualMemoryLoadResult);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#memoryLoad(int)} with {@code address}.
   *
   * <p>Method under test: {@link Program#memoryLoad(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.memoryLoad(int)"})
  public void testMemoryLoadWithAddress() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(1);

    // Assert
    assertEquals(Double.SIZE, program.getMemSize());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    assertEquals(dataWord, actualMemoryLoadResult);
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#memoryChunk(int, int)}.
   *
   * <p>Method under test: {@link Program#memoryChunk(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.memoryChunk(int, int)"})
  public void testMemoryChunk() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    byte[] actualMemoryChunkResult = program.memoryChunk(2, 3);

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[] {}, program.getResult().getHReturn());
    assertArrayEquals(new byte[] {0, 0, 0}, actualMemoryChunkResult);
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#allocateMemory(int, int)}.
   *
   * <p>Method under test: {@link Program#allocateMemory(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.allocateMemory(int, int)"})
  public void testAllocateMemory() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.allocateMemory(2, 3);

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[] {}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#spendEnergy(long, String)}.
   *
   * <p>Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.spendEnergy(long, String)"})
  public void testSpendEnergy() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.spendEnergy(42L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000008",
        energyLimitLeft.toHexString());
    assertEquals("08", energyLimitLeft.toPrefixString());
    assertEquals(42L, program.getResult().getEnergyUsed());
    assertEquals(8L, program.getEnergylimitLeftLong());
    assertArrayEquals(new byte[] {'\b'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\b'
        },
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\b'
        },
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#spendEnergyWithPenalty(long, long, String)}.
   *
   * <p>Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.spendEnergyWithPenalty(long, long, String)"})
  public void testSpendEnergyWithPenalty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.spendEnergyWithPenalty(1L, 1L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000031",
        energyLimitLeft.toHexString());
    assertEquals("31", energyLimitLeft.toPrefixString());
    ProgramResult result = program.getResult();
    assertEquals(1L, result.getEnergyPenaltyTotal());
    assertEquals(1L, result.getEnergyUsed());
    assertEquals(49L, program.getEnergylimitLeftLong());
    assertArrayEquals(new byte[] {'1'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '1'
        },
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '1'
        },
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#spendAllEnergy()}.
   *
   * <p>Method under test: {@link Program#spendAllEnergy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.spendAllEnergy()"})
  public void testSpendAllEnergy() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.spendAllEnergy();

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, program.getResult().getEnergyUsed());
  }

  /**
   * Test {@link Program#refundEnergy(long, String)}.
   *
   * <p>Method under test: {@link Program#refundEnergy(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.refundEnergy(long, String)"})
  public void testRefundEnergy() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.refundEnergy(42L, "Cause");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals(
        "000000000000000000000000000000000000000000000000000000000000005c",
        energyLimitLeft.toHexString());
    assertEquals("5c", energyLimitLeft.toPrefixString());
    assertEquals(-42L, program.getResult().getEnergyUsed());
    assertEquals(92L, program.getEnergylimitLeftLong());
    assertArrayEquals(new byte[] {'\\'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\\'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\\'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\\'
        },
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\\'
        },
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#storageSave(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link Program#storageSave(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.storageSave(DataWord, DataWord)"})
  public void testStorageSave() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord word1 = DataWord.ZERO();

    // Act
    program.storageSave(word1, DataWord.ZERO());

    // Assert
    assertEquals(1, program.getStorageDiff().size());
  }

  /**
   * Test {@link Program#getCode()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.getCode()"})
  public void testGetCode_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), program.getCode());
  }

  /**
   * Test {@link Program#getContextAddress()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code G}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getContextAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.getContextAddress()"})
  public void testGetContextAddress_thenReturnArrayOfByteWithAAndG()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        program.getContextAddress());
  }

  /**
   * Test {@link Program#getContractAddress()}.
   *
   * <p>Method under test: {@link Program#getContractAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getContractAddress()"})
  public void testGetContractAddress() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualContractAddress = program.getContractAddress();

    // Assert
    assertEquals(
        "000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc",
        actualContractAddress.toHexString());
    assertEquals("41471f", actualContractAddress.toPrefixString());
    assertFalse(actualContractAddress.isNegative());
    assertFalse(actualContractAddress.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualContractAddress.getData();
    assertSame(data2, actualContractAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4,
          -52
        },
        actualContractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        actualContractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        actualContractAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
          '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52
        },
        actualContractAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
          '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52
        },
        data2);
  }

  /**
   * Test {@link Program#getOriginAddress()}.
   *
   * <p>Method under test: {@link Program#getOriginAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getOriginAddress()"})
  public void testGetOriginAddress() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualOriginAddress = program.getOriginAddress();

    // Assert
    assertEquals(
        "00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f",
        actualOriginAddress.toHexString());
    assertEquals("411397", actualOriginAddress.toPrefixString());
    assertFalse(actualOriginAddress.isNegative());
    assertFalse(actualOriginAddress.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualOriginAddress.getData();
    assertSame(data2, actualOriginAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41, 'c',
          -39, -51, '_'
        },
        actualOriginAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
          'c', -39, -51, '_'
        },
        actualOriginAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
          'c', -39, -51, '_'
        },
        actualOriginAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
          'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'
        },
        actualOriginAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
          'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'
        },
        data2);
  }

  /**
   * Test {@link Program#getCallerAddress()}.
   *
   * <p>Method under test: {@link Program#getCallerAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getCallerAddress()"})
  public void testGetCallerAddress() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualCallerAddress = program.getCallerAddress();

    // Assert
    assertEquals(
        "000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4",
        actualCallerAddress.toHexString());
    assertEquals("41885f", actualCallerAddress.toPrefixString());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualCallerAddress.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualCallerAddress.getData();
    assertSame(data2, actualCallerAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
          ']', -106, -60
        },
        actualCallerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
          'F', ']', -106, -60
        },
        actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
          'F', ']', -106, -60
        },
        actualCallerAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
          -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60
        },
        actualCallerAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
          -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60
        },
        data2);
  }

  /**
   * Test {@link Program#getEnergylimitLeftLong()}.
   *
   * <ul>
   *   <li>Then return fifty.
   * </ul>
   *
   * <p>Method under test: {@link Program#getEnergylimitLeftLong()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Program.getEnergylimitLeftLong()"})
  public void testGetEnergylimitLeftLong_thenReturnFifty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals(50L, program.getEnergylimitLeftLong());
  }

  /**
   * Test {@link Program#getEnergyLimitLeft()}.
   *
   * <p>Method under test: {@link Program#getEnergyLimitLeft()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getEnergyLimitLeft()"})
  public void testGetEnergyLimitLeft() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualEnergyLimitLeft = program.getEnergyLimitLeft();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000032",
        actualEnergyLimitLeft.toHexString());
    assertEquals("32", actualEnergyLimitLeft.toPrefixString());
    assertFalse(actualEnergyLimitLeft.isNegative());
    assertFalse(actualEnergyLimitLeft.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualEnergyLimitLeft.getData();
    assertSame(data2, actualEnergyLimitLeft.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'2'}, actualEnergyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        actualEnergyLimitLeft.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        actualEnergyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '2'
        },
        actualEnergyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '2'
        },
        data2);
  }

  /**
   * Test {@link Program#getVmShouldEndInUs()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Program#getVmShouldEndInUs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Program.getVmShouldEndInUs()"})
  public void testGetVmShouldEndInUs_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals(0L, program.getVmShouldEndInUs());
  }

  /**
   * Test {@link Program#getCallValue()}.
   *
   * <p>Method under test: {@link Program#getCallValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getCallValue()"})
  public void testGetCallValue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualCallValue = program.getCallValue();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000de0b6b3a7640000",
        actualCallValue.toHexString());
    assertEquals("0de0b6", actualCallValue.toPrefixString());
    assertFalse(actualCallValue.isNegative());
    assertFalse(actualCallValue.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    assertArrayEquals(
        new byte[] {'\r', -32, -74, -77, -89, 'd', 0, 0}, actualCallValue.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd'
        },
        actualCallValue.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd', 0, 0
        },
        actualCallValue.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd', 0, 0
        },
        actualCallValue.getData());
  }

  /**
   * Test {@link Program#getDataSize()}.
   *
   * <ul>
   *   <li>Then return {@link DataWord#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getDataSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getDataSize()"})
  public void testGetDataSize_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Test {@link Program#getDataValue(DataWord)}.
   *
   * <ul>
   *   <li>Then return ZERO.
   * </ul>
   *
   * <p>Method under test: {@link Program#getDataValue(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getDataValue(DataWord)"})
  public void testGetDataValue_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord index = DataWord.ZERO();

    // Act
    DataWord actualDataValue = program.getDataValue(index);

    // Assert
    assertEquals(index, actualDataValue);
  }

  /**
   * Test {@link Program#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord offset = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(new byte[] {}, program.getDataCopy(offset, DataWord.ZERO()));
  }

  /**
   * Test {@link Program#getReturnDataBufferSize()}.
   *
   * <p>Method under test: {@link Program#getReturnDataBufferSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getReturnDataBufferSize()"})
  public void testGetReturnDataBufferSize() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualReturnDataBufferSize = program.getReturnDataBufferSize();

    // Assert
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, actualReturnDataBufferSize);
  }

  /**
   * Test {@link Program#getReturnDataBufferData(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getReturnDataBufferData(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.getReturnDataBufferData(DataWord, DataWord)"})
  public void testGetReturnDataBufferData_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord off = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(new byte[] {}, program.getReturnDataBufferData(off, DataWord.ZERO()));
  }

  /**
   * Test {@link Program#getPrevHash()}.
   *
   * <ul>
   *   <li>Then return toPrefixString is {@code 961cb1}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getPrevHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getPrevHash()"})
  public void testGetPrevHash_thenReturnToPrefixStringIs961cb1()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualPrevHash = program.getPrevHash();

    // Assert
    assertEquals("961cb1", actualPrevHash.toPrefixString());
    assertEquals(
        "961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c",
        actualPrevHash.toHexString());
    assertFalse(actualPrevHash.isZero());
    assertTrue(actualPrevHash.isNegative());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualPrevHash.getData();
    assertSame(data2, actualPrevHash.getNoEndZeroesData());
    assertSame(data2, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46,
          -69, 28
        },
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F',
          -46, -69, 28
        },
        actualPrevHash.toTronAddress());
    assertArrayEquals(
        new byte[] {
          -106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24, -120,
          '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28
        },
        actualPrevHash.getClonedData());
    assertArrayEquals(
        new byte[] {
          -106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24, -120,
          '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28
        },
        data2);
  }

  /**
   * Test {@link Program#getCoinbase()}.
   *
   * <p>Method under test: {@link Program#getCoinbase()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getCoinbase()"})
  public void testGetCoinbase() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualCoinbase = program.getCoinbase();

    // Assert
    assertEquals(
        "000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e",
        actualCoinbase.toHexString());
    assertEquals("e559de", actualCoinbase.toPrefixString());
    assertFalse(actualCoinbase.isNegative());
    assertFalse(actualCoinbase.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualCoinbase.getData();
    assertSame(data2, actualCoinbase.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104,
          -20, '?', 30
        },
        actualCoinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104,
          -20, '?', 30
        },
        actualCoinbase.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
          -104, -20, '?', 30
        },
        actualCoinbase.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
          'h', -48, '}', -16, 't', '*', -104, -20, '?', 30
        },
        actualCoinbase.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
          'h', -48, '}', -16, 't', '*', -104, -20, '?', 30
        },
        data2);
  }

  /**
   * Test {@link Program#getTimestamp()}.
   *
   * <p>Method under test: {@link Program#getTimestamp()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getTimestamp()"})
  public void testGetTimestamp() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualTimestamp = program.getTimestamp();

    // Assert
    assertEquals(
        "000000000000000000000000000000000000000000000000000000005387fe24",
        actualTimestamp.toHexString());
    assertEquals("5387fe24", actualTimestamp.toPrefixString());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualTimestamp.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualTimestamp.getData();
    assertSame(data2, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'S', -121, -2, '$'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S',
          -121, -2, '$'
        },
        actualTimestamp.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S',
          -121, -2, '$'
        },
        data2);
  }

  /**
   * Test {@link Program#getNumber()}.
   *
   * <p>Method under test: {@link Program#getNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getNumber()"})
  public void testGetNumber() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualNumber = program.getNumber();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000021",
        actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualNumber.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualNumber.getData();
    assertSame(data2, actualNumber.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'!'}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '!'
        },
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '!'
        },
        data2);
  }

  /**
   * Test {@link Program#getDifficulty()}.
   *
   * <p>Method under test: {@link Program#getDifficulty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getDifficulty()"})
  public void testGetDifficulty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    DataWord actualDifficulty = program.getDifficulty();

    // Assert
    assertEquals(
        "00000000000000000000000000000000000000000000000000000000003ed290",
        actualDifficulty.toHexString());
    assertEquals("3ed290", actualDifficulty.toPrefixString());
    assertFalse(actualDifficulty.isNegative());
    assertFalse(actualDifficulty.isZero());
    DataWord dataWord = DataWord.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualDifficulty.getData();
    assertSame(data2, actualDifficulty.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'>', -46, -112}, actualDifficulty.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          '>', -46, -112
        },
        actualDifficulty.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          '>', -46, -112
        },
        data2);
  }

  /**
   * Test {@link Program#isStaticCall()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Program#isStaticCall()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Program.isStaticCall()"})
  public void testIsStaticCall_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertFalse(program.isStaticCall());
  }

  /**
   * Test {@link Program#isConstantCall()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Program#isConstantCall()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Program.isConstantCall()"})
  public void testIsConstantCall_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertFalse(program.isConstantCall());
  }

  /**
   * Test {@link Program#setRuntimeFailure(RuntimeException)}.
   *
   * <p>Method under test: {@link Program#setRuntimeFailure(RuntimeException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.setRuntimeFailure(RuntimeException)"})
  public void testSetRuntimeFailure() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    RuntimeException e = new RuntimeException();

    // Act
    program.setRuntimeFailure(e);

    // Assert
    assertSame(e, program.getResult().getException());
  }

  /**
   * Test {@link Program#memoryToString()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Program#memoryToString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Program.memoryToString()"})
  public void testMemoryToString_thenReturnEmptyString() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals("", program.memoryToString());
  }

  /**
   * Test {@link Program#saveOpTrace()}.
   *
   * <p>Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.saveOpTrace()"})
  public void testSaveOpTrace() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.saveOpTrace();

    // Assert
    List<Op> ops2 = program.getTrace().getOps();
    assertEquals(1, ops2.size());
    Op getResult = ops2.get(0);
    BigInteger energy = getResult.getEnergy();
    assertEquals("50", energy.toString());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getPc());
    assertEquals(1, energy.getLowestSetBit());
    assertEquals(1, energy.signum());
    assertEquals(65, getResult.getCode());
    OpActions actions = getResult.getActions();
    assertTrue(actions.getMemory().isEmpty());
    assertTrue(actions.getStack().isEmpty());
    assertTrue(actions.getStorage().isEmpty());
    assertArrayEquals(new byte[] {'2'}, energy.toByteArray());
  }

  /**
   * Test {@link Program#byTestingSuite()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Program.byTestingSuite()"})
  public void testByTestingSuite_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertFalse(program.byTestingSuite());
  }

  /**
   * Test {@link Program#getCallEnergy(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getCallEnergy(DataWord, DataWord)"})
  public void testGetCallEnergy() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord requestedEnergy = DataWord.ZERO();

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(requestedEnergy, DataWord.ZERO());

    // Assert
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualCallEnergy.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualCallEnergy.getData());
  }

  /**
   * Test {@link Program#getCreateEnergy(DataWord)}.
   *
   * <ul>
   *   <li>Then return ZERO.
   * </ul>
   *
   * <p>Method under test: {@link Program#getCreateEnergy(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Program.getCreateEnergy(DataWord)"})
  public void testGetCreateEnergy_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord availableEnergy = DataWord.ZERO();

    // Act
    DataWord actualCreateEnergy = program.getCreateEnergy(availableEnergy);

    // Assert
    assertSame(availableEnergy, actualCreateEnergy);
  }

  /**
   * Test {@link Program#getMemory()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Program#getMemory()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Program.getMemory()"})
  public void testGetMemory_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertArrayEquals(new byte[] {}, program.getMemory());
  }

  /**
   * Test {@link Program#initMem(byte[])}.
   *
   * <p>Method under test: {@link Program#initMem(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Program.initMem(byte[])"})
  public void testInitMem() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act
    program.initMem("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[] {}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        program.getMemory());
  }

  /**
   * Test {@link Program#getVmStartInUs()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Program#getVmStartInUs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long Program.getVmStartInUs()"})
  public void testGetVmStartInUs_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));

    // Act and Assert
    assertEquals(0L, program.getVmStartInUs());
  }

  /**
   * Test {@link Program#freeze(DataWord, DataWord, DataWord)}.
   *
   * <p>Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Program.freeze(DataWord, DataWord, DataWord)"})
  public void testFreeze() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    boolean actualFreezeResult = program.freeze(receiverAddress, frozenBalance, DataWord.ZERO());

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("freezeForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getIndex());
    assertEquals(0L, getResult.getValue());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertFalse(actualFreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[] {}, getResult.getData());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        getResult.getSender());
    assertArrayEquals(
        new byte[] {
          -106, '5', -52, -61, 'c', ' ', -122, -17, -68, -39, -74, 22, -29, -110, -56, '/', -44,
          'x', -107, 6, '!', '\t', 'r', -110, 'F', -113, -16, 's', -7, 'b', -6, 15
        },
        getResult.getHash());
    assertArrayEquals(
        new byte[] {
          -86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X',
          '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'
        },
        getResult.getParentHash());
    assertArrayEquals(
        new byte[] {
          -86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X',
          '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        getResult.getEncoded());
  }

  /**
   * Test {@link Program#freezeBalanceV2(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Program.freezeBalanceV2(DataWord, DataWord)"})
  public void testFreezeBalanceV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            ops,
            codeAddress,
            programInvoke,
            new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>()));
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    boolean actualFreezeBalanceV2Result = program.freezeBalanceV2(frozenBalance, DataWord.ZERO());

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("freezeBalanceV2ForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getIndex());
    assertEquals(0L, getResult.getValue());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertFalse(actualFreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[] {}, getResult.getData());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        getResult.getSender());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[] {
          -86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X',
          '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'
        },
        getResult.getParentHash());
    assertArrayEquals(
        new byte[] {
          -91, -96, 14, -35, 'X', 3, -91, 23, -31, -89, 'y', '@', 0, 7, -98, -64, '1', -50, 27,
          -127, -29, -44, -115, 'K', 'X', 21, 3, 25, -14, '8', -21, -1
        },
        getResult.getHash());
    assertArrayEquals(
        new byte[] {
          -86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X',
          '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 'G', 31,
          -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        getResult.getEncoded());
  }

  /**
   * Test TransferException {@link TransferException#TransferException(String, Object[])}.
   *
   * <p>Method under test: {@link TransferException#TransferException(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransferException.<init>(String, Object[])"})
  public void testTransferExceptionNewTransferException() {
    // Arrange and Act
    TransferException actualTransferException = new TransferException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualTransferException.getLocalizedMessage());
    assertEquals("An error occurred", actualTransferException.getMessage());
    assertNull(actualTransferException.getCause());
    assertEquals(0, actualTransferException.getSuppressed().length);
  }
}
