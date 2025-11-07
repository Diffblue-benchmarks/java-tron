package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.ContractStateCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.exception.AccountResourceInsufficientException;
import org.tron.core.exception.TronException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.MessageCall;
import org.tron.core.vm.PrecompiledContracts;
import org.tron.core.vm.PrecompiledContracts.AvailableUnfreezeV2Size;
import org.tron.core.vm.PrecompiledContracts.PrecompiledContract;
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
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.core.vm.trace.Op;
import org.tron.core.vm.trace.OpActions;

public class ProgramDiffblueTest {
  /**
   * Test AssetIssueException {@link AssetIssueException#AssetIssueException(String, Object[])}.
   * <p>
   * Method under test: {@link AssetIssueException#AssetIssueException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueException.<init>(String, Object[])"})
  public void testAssetIssueExceptionNewAssetIssueException() {
    // Arrange and Act
    AssetIssueException actualAssetIssueException = new AssetIssueException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualAssetIssueException.getLocalizedMessage());
    assertEquals("An error occurred", actualAssetIssueException.getMessage());
    assertNull(actualAssetIssueException.getCause());
    assertEquals(0, actualAssetIssueException.getSuppressed().length);
  }

  /**
   * Test BadJumpDestinationException {@link BadJumpDestinationException#BadJumpDestinationException(String, Object[])}.
   * <p>
   * Method under test: {@link BadJumpDestinationException#BadJumpDestinationException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadJumpDestinationException.<init>(String, Object[])"})
  public void testBadJumpDestinationExceptionNewBadJumpDestinationException() {
    // Arrange and Act
    BadJumpDestinationException actualBadJumpDestinationException = new BadJumpDestinationException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualBadJumpDestinationException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadJumpDestinationException.getMessage());
    assertNull(actualBadJumpDestinationException.getCause());
    assertEquals(0, actualBadJumpDestinationException.getSuppressed().length);
  }

  /**
   * Test ByteCodeIterator getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ByteCodeIterator#ByteCodeIterator(byte[])}
   *   <li>{@link ByteCodeIterator#setPC(int)}
   *   <li>{@link ByteCodeIterator#getPC()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteCodeIterator.<init>(byte[])", "int ByteCodeIterator.getPC()",
      "void ByteCodeIterator.setPC(int)"})
  public void testByteCodeIteratorGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ByteCodeIterator actualByteCodeIterator = new ByteCodeIterator("AXAXAXAX".getBytes("UTF-8"));
    actualByteCodeIterator.setPC(1);

    // Assert
    assertEquals(1, actualByteCodeIterator.getPC());
  }

  /**
   * Test BytecodeExecutionException {@link BytecodeExecutionException#BytecodeExecutionException(String)}.
   * <p>
   * Method under test: {@link BytecodeExecutionException#BytecodeExecutionException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BytecodeExecutionException.<init>(String)"})
  public void testBytecodeExecutionExceptionNewBytecodeExecutionException() {
    // Arrange and Act
    BytecodeExecutionException actualBytecodeExecutionException = new BytecodeExecutionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBytecodeExecutionException.getMessage());
    assertNull(actualBytecodeExecutionException.getCause());
    assertEquals(0, actualBytecodeExecutionException.getSuppressed().length);
  }

  /**
   * Test BytecodeExecutionException {@link BytecodeExecutionException#BytecodeExecutionException(String, Object[])}.
   * <p>
   * Method under test: {@link BytecodeExecutionException#BytecodeExecutionException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BytecodeExecutionException.<init>(String, Object[])"})
  public void testBytecodeExecutionExceptionNewBytecodeExecutionException2() {
    // Arrange and Act
    BytecodeExecutionException actualBytecodeExecutionException = new BytecodeExecutionException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualBytecodeExecutionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBytecodeExecutionException.getMessage());
    assertNull(actualBytecodeExecutionException.getCause());
    assertEquals(0, actualBytecodeExecutionException.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#alreadyTimeOut()}.
   * <p>
   * Method under test: {@link Exception#alreadyTimeOut()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link Exception#badJumpDestination(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BadJumpDestinationException Exception.badJumpDestination(int)"})
  public void testExceptionBadJumpDestination() {
    // Arrange and Act
    BadJumpDestinationException actualBadJumpDestinationResult = Exception.badJumpDestination(1);

    // Assert
    assertEquals("Operation with pc isn't 'JUMPDEST': PC[1];", actualBadJumpDestinationResult.getLocalizedMessage());
    assertEquals("Operation with pc isn't 'JUMPDEST': PC[1];", actualBadJumpDestinationResult.getMessage());
    assertNull(actualBadJumpDestinationResult.getCause());
    assertEquals(0, actualBadJumpDestinationResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#contractExecuteException(TronException)}.
   * <p>
   * Method under test: {@link Exception#contractExecuteException(TronException)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PrecompiledContractException Exception.contractExecuteException(TronException)"})
  public void testExceptionContractExecuteException() {
    // Arrange and Act
    PrecompiledContractException actualContractExecuteExceptionResult = Exception
        .contractExecuteException(new AccountResourceInsufficientException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualContractExecuteExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualContractExecuteExceptionResult.getMessage());
    assertNull(actualContractExecuteExceptionResult.getCause());
    assertEquals(0, actualContractExecuteExceptionResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#contractValidateException(TronException)}.
   * <p>
   * Method under test: {@link Exception#contractValidateException(TronException)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PrecompiledContractException Exception.contractValidateException(TronException)"})
  public void testExceptionContractValidateException() {
    // Arrange and Act
    PrecompiledContractException actualContractValidateExceptionResult = Exception
        .contractValidateException(new AccountResourceInsufficientException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualContractValidateExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateExceptionResult.getMessage());
    assertNull(actualContractValidateExceptionResult.getCause());
    assertEquals(0, actualContractValidateExceptionResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#energyOverflow(BigInteger, BigInteger)}.
   * <p>
   * Method under test: {@link Exception#energyOverflow(BigInteger, BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutOfEnergyException Exception.energyOverflow(BigInteger, BigInteger)"})
  public void testExceptionEnergyOverflow() {
    // Arrange
    BigInteger actualEnergy = BigInteger.valueOf(1L);

    // Act
    OutOfEnergyException actualEnergyOverflowResult = Exception.energyOverflow(actualEnergy, BigInteger.valueOf(1L));

    // Assert
    assertEquals("Energy value overflow: actualEnergy[1], energyLimit[1];",
        actualEnergyOverflowResult.getLocalizedMessage());
    assertEquals("Energy value overflow: actualEnergy[1], energyLimit[1];", actualEnergyOverflowResult.getMessage());
    assertNull(actualEnergyOverflowResult.getCause());
    assertEquals(0, actualEnergyOverflowResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#invalidCodeException()}.
   * <p>
   * Method under test: {@link Exception#invalidCodeException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvalidCodeException Exception.invalidCodeException()"})
  public void testExceptionInvalidCodeException() {
    // Arrange and Act
    InvalidCodeException actualInvalidCodeExceptionResult = Exception.invalidCodeException();

    // Assert
    assertEquals("invalid code: must not begin with 0xef", actualInvalidCodeExceptionResult.getLocalizedMessage());
    assertEquals("invalid code: must not begin with 0xef", actualInvalidCodeExceptionResult.getMessage());
    assertNull(actualInvalidCodeExceptionResult.getCause());
    assertEquals(0, actualInvalidCodeExceptionResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#invalidOpCode(byte[])}.
   * <p>
   * Method under test: {@link Exception#invalidOpCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IllegalOperationException Exception.invalidOpCode(byte[])"})
  public void testExceptionInvalidOpCode() throws UnsupportedEncodingException {
    // Arrange and Act
    IllegalOperationException actualInvalidOpCodeResult = Exception.invalidOpCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getMessage());
    assertNull(actualInvalidOpCodeResult.getCause());
    assertEquals(0, actualInvalidOpCodeResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#memoryOverflow(int)}.
   * <p>
   * Method under test: {@link Exception#memoryOverflow(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutOfMemoryException Exception.memoryOverflow(int)"})
  public void testExceptionMemoryOverflow() {
    // Arrange and Act
    OutOfMemoryException actualMemoryOverflowResult = Exception.memoryOverflow(1);

    // Assert
    assertEquals("Out of Memory when 'ADD' operation executing", actualMemoryOverflowResult.getLocalizedMessage());
    assertEquals("Out of Memory when 'ADD' operation executing", actualMemoryOverflowResult.getMessage());
    assertNull(actualMemoryOverflowResult.getCause());
    assertEquals(0, actualMemoryOverflowResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#notEnoughSpendEnergy(String, long, long)}.
   * <p>
   * Method under test: {@link Exception#notEnoughSpendEnergy(String, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutOfEnergyException Exception.notEnoughSpendEnergy(String, long, long)"})
  public void testExceptionNotEnoughSpendEnergy() {
    // Arrange and Act
    OutOfEnergyException actualNotEnoughSpendEnergyResult = Exception.notEnoughSpendEnergy("Hint", 1L, 1L);

    // Assert
    assertEquals("Not enough energy for 'Hint' executing: needEnergy[1], leftEnergy[1];",
        actualNotEnoughSpendEnergyResult.getLocalizedMessage());
    assertEquals("Not enough energy for 'Hint' executing: needEnergy[1], leftEnergy[1];",
        actualNotEnoughSpendEnergyResult.getMessage());
    assertNull(actualNotEnoughSpendEnergyResult.getCause());
    assertEquals(0, actualNotEnoughSpendEnergyResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#notEnoughStorage()}.
   * <p>
   * Method under test: {@link Exception#notEnoughStorage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutOfStorageException Exception.notEnoughStorage()"})
  public void testExceptionNotEnoughStorage() {
    // Arrange and Act
    OutOfStorageException actualNotEnoughStorageResult = Exception.notEnoughStorage();

    // Assert
    assertEquals("Not enough ContractState resource", actualNotEnoughStorageResult.getLocalizedMessage());
    assertEquals("Not enough ContractState resource", actualNotEnoughStorageResult.getMessage());
    assertNull(actualNotEnoughStorageResult.getCause());
    assertEquals(0, actualNotEnoughStorageResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#notEnoughTime(String)}.
   * <p>
   * Method under test: {@link Exception#notEnoughTime(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutOfTimeException Exception.notEnoughTime(String)"})
  public void testExceptionNotEnoughTime() {
    // Arrange and Act
    OutOfTimeException actualNotEnoughTimeResult = Exception.notEnoughTime("Op");

    // Assert
    assertEquals("CPU timeout for 'Op' operation executing", actualNotEnoughTimeResult.getLocalizedMessage());
    assertEquals("CPU timeout for 'Op' operation executing", actualNotEnoughTimeResult.getMessage());
    assertNull(actualNotEnoughTimeResult.getCause());
    assertEquals(0, actualNotEnoughTimeResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#tooSmallStack(int, int)}.
   * <p>
   * Method under test: {@link Exception#tooSmallStack(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StackTooSmallException Exception.tooSmallStack(int, int)"})
  public void testExceptionTooSmallStack() {
    // Arrange and Act
    StackTooSmallException actualTooSmallStackResult = Exception.tooSmallStack(3, 3);

    // Assert
    assertEquals("Expected stack size 3 but actual 3;", actualTooSmallStackResult.getLocalizedMessage());
    assertEquals("Expected stack size 3 but actual 3;", actualTooSmallStackResult.getMessage());
    assertNull(actualTooSmallStackResult.getCause());
    assertEquals(0, actualTooSmallStackResult.getSuppressed().length);
  }

  /**
   * Test IllegalOperationException {@link IllegalOperationException#IllegalOperationException(String, Object[])}.
   * <p>
   * Method under test: {@link IllegalOperationException#IllegalOperationException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IllegalOperationException.<init>(String, Object[])"})
  public void testIllegalOperationExceptionNewIllegalOperationException() {
    // Arrange and Act
    IllegalOperationException actualIllegalOperationException = new IllegalOperationException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualIllegalOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualIllegalOperationException.getMessage());
    assertNull(actualIllegalOperationException.getCause());
    assertEquals(0, actualIllegalOperationException.getSuppressed().length);
  }

  /**
   * Test InvalidCodeException {@link InvalidCodeException#InvalidCodeException(String)}.
   * <p>
   * Method under test: {@link InvalidCodeException#InvalidCodeException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: default or parameterless constructor of {@link JVMStackOverFlowException}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JVMStackOverFlowException.<init>()"})
  public void testJVMStackOverFlowExceptionNewJVMStackOverFlowException() {
    // Arrange and Act
    JVMStackOverFlowException actualJvmStackOverFlowException = new JVMStackOverFlowException();

    // Assert
    assertEquals("StackOverflowError:  exceed default JVM stack size!", actualJvmStackOverFlowException.getMessage());
    assertNull(actualJvmStackOverFlowException.getCause());
    assertEquals(0, actualJvmStackOverFlowException.getSuppressed().length);
  }

  /**
   * Test {@link Program#Program(byte[], byte[], ProgramInvoke, InternalTransaction)}.
   * <ul>
   *   <li>Then ContractState return {@link ContractState}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#Program(byte[], byte[], ProgramInvoke, InternalTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.<init>(byte[], byte[], ProgramInvoke, InternalTransaction)"})
  public void testNewProgram_thenContractStateReturnContractState() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Program actualProgram = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

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
    byte[] expectedCode = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedCode, actualProgram.getCode());
    assertArrayEquals(new byte[]{}, actualProgram.getMemory());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualProgram.getContextAddress());
  }

  /**
   * Test {@link Program#formatBinData(byte[], int)}.
   * <ul>
   *   <li>When minus seventeen.</li>
   *   <li>Then return {@code ffffffef:4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#formatBinData(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Program.formatBinData(byte[], int)"})
  public void testFormatBinData_whenMinusSeventeen_thenReturnFfffffef4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("ffffffef:4158415841584158\n", Program.formatBinData("AXAXAXAX".getBytes("UTF-8"), -17));
  }

  /**
   * Test {@link Program#formatBinData(byte[], int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1: 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#formatBinData(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Program.formatBinData(byte[], int)"})
  public void testFormatBinData_whenOne_thenReturn14158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("1:      4158415841584158\n", Program.formatBinData("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link Program#getRootTransactionId()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getRootTransactionId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.getRootTransactionId()"})
  public void testGetRootTransactionId_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
    program.setRootTransactionId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualRootTransactionId = program.getRootTransactionId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRootTransactionId);
  }

  /**
   * Test OutOfEnergyException {@link OutOfEnergyException#OutOfEnergyException(String, Object[])}.
   * <p>
   * Method under test: {@link OutOfEnergyException#OutOfEnergyException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OutOfEnergyException.<init>(String, Object[])"})
  public void testOutOfEnergyExceptionNewOutOfEnergyException() {
    // Arrange and Act
    OutOfEnergyException actualOutOfEnergyException = new OutOfEnergyException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfEnergyException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfEnergyException.getMessage());
    assertNull(actualOutOfEnergyException.getCause());
    assertEquals(0, actualOutOfEnergyException.getSuppressed().length);
  }

  /**
   * Test OutOfMemoryException {@link OutOfMemoryException#OutOfMemoryException(String, Object[])}.
   * <p>
   * Method under test: {@link OutOfMemoryException#OutOfMemoryException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OutOfMemoryException.<init>(String, Object[])"})
  public void testOutOfMemoryExceptionNewOutOfMemoryException() {
    // Arrange and Act
    OutOfMemoryException actualOutOfMemoryException = new OutOfMemoryException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfMemoryException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfMemoryException.getMessage());
    assertNull(actualOutOfMemoryException.getCause());
    assertEquals(0, actualOutOfMemoryException.getSuppressed().length);
  }

  /**
   * Test OutOfStorageException {@link OutOfStorageException#OutOfStorageException(String, Object[])}.
   * <p>
   * Method under test: {@link OutOfStorageException#OutOfStorageException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OutOfStorageException.<init>(String, Object[])"})
  public void testOutOfStorageExceptionNewOutOfStorageException() {
    // Arrange and Act
    OutOfStorageException actualOutOfStorageException = new OutOfStorageException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfStorageException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfStorageException.getMessage());
    assertNull(actualOutOfStorageException.getCause());
    assertEquals(0, actualOutOfStorageException.getSuppressed().length);
  }

  /**
   * Test OutOfTimeException {@link OutOfTimeException#OutOfTimeException(String, Object[])}.
   * <p>
   * Method under test: {@link OutOfTimeException#OutOfTimeException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OutOfTimeException.<init>(String, Object[])"})
  public void testOutOfTimeExceptionNewOutOfTimeException() {
    // Arrange and Act
    OutOfTimeException actualOutOfTimeException = new OutOfTimeException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfTimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfTimeException.getMessage());
    assertNull(actualOutOfTimeException.getCause());
    assertEquals(0, actualOutOfTimeException.getSuppressed().length);
  }

  /**
   * Test PrecompiledContractException {@link PrecompiledContractException#PrecompiledContractException(String, Object[])}.
   * <p>
   * Method under test: {@link PrecompiledContractException#PrecompiledContractException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrecompiledContractException.<init>(String, Object[])"})
  public void testPrecompiledContractExceptionNewPrecompiledContractException() {
    // Arrange and Act
    PrecompiledContractException actualPrecompiledContractException = new PrecompiledContractException(
        "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualPrecompiledContractException.getLocalizedMessage());
    assertEquals("An error occurred", actualPrecompiledContractException.getMessage());
    assertNull(actualPrecompiledContractException.getCause());
    assertEquals(0, actualPrecompiledContractException.getSuppressed().length);
  }

  /**
   * Test ReturnDataCopyIllegalBoundsException {@link ReturnDataCopyIllegalBoundsException#ReturnDataCopyIllegalBoundsException(DataWord, DataWord, long)}.
   * <p>
   * Method under test: {@link ReturnDataCopyIllegalBoundsException#ReturnDataCopyIllegalBoundsException(DataWord, DataWord, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReturnDataCopyIllegalBoundsException.<init>(DataWord, DataWord, long)"})
  public void testReturnDataCopyIllegalBoundsExceptionNewReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord off = DataWord.ZERO();

    // Act
    ReturnDataCopyIllegalBoundsException actualReturnDataCopyIllegalBoundsException = new ReturnDataCopyIllegalBoundsException(
        off, DataWord.ZERO(), 3L);

    // Assert
    assertEquals("Illegal RETURNDATACOPY arguments: offset (000000000000000000000000000000000000000000000000000000"
        + "0000000000) + size (0000000000000000000000000000000000000000000000000000000000000000) > RETURNDATASIZE"
        + " (3)", actualReturnDataCopyIllegalBoundsException.getLocalizedMessage());
    assertEquals("Illegal RETURNDATACOPY arguments: offset (000000000000000000000000000000000000000000000000000000"
        + "0000000000) + size (0000000000000000000000000000000000000000000000000000000000000000) > RETURNDATASIZE"
        + " (3)", actualReturnDataCopyIllegalBoundsException.getMessage());
    assertNull(actualReturnDataCopyIllegalBoundsException.getCause());
    assertEquals(0, actualReturnDataCopyIllegalBoundsException.getSuppressed().length);
  }

  /**
   * Test {@link Program#setRootTransactionId(byte[])}.
   * <p>
   * Method under test: {@link Program#setRootTransactionId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.setRootTransactionId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedRootTransactionId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRootTransactionId, program.getRootTransactionId());
  }

  /**
   * Test {@link Program#getProgramPrecompile()}.
   * <p>
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile Program.getProgramPrecompile()"})
  public void testGetProgramPrecompile() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.isConstantCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>())))
            .getProgramPrecompile();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isConstantCall();
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Test {@link Program#getProgramPrecompile()}.
   * <p>
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile Program.getProgramPrecompile()"})
  public void testGetProgramPrecompile2() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.isConstantCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "[XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>())))
            .getProgramPrecompile();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isConstantCall();
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Test {@link Program#getProgramPrecompile()}.
   * <p>
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile Program.getProgramPrecompile()"})
  public void testGetProgramPrecompile3() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.isConstantCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "`XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>())))
            .getProgramPrecompile();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isConstantCall();
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Test {@link Program#getProgramPrecompile()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return not hasJumpDest one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramPrecompile Program.getProgramPrecompile()"})
  public void testGetProgramPrecompile_givenA_thenReturnNotHasJumpDestOne() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.isConstantCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data,
            "Note", 1L, new HashMap<>()))).getProgramPrecompile();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isConstantCall();
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Test {@link Program#getCallDeep()}.
   * <p>
   * Method under test: {@link Program#getCallDeep()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Program.getCallDeep()"})
  public void testGetCallDeep() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCallDeep());
  }

  /**
   * Test {@link Program#getCallDeep()}.
   * <ul>
   *   <li>Given {@link ContractState#ContractState(ProgramInvoke)} with programInvoke is {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCallDeep()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Program.getCallDeep()"})
  public void testGetCallDeep_givenContractStateWithProgramInvokeIsProgramInvokeMockImpl()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCallDeep());
  }

  /**
   * Test {@link Program#getStorageDiff()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getStorageDiff()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertTrue((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getStorageDiff().isEmpty());
  }

  /**
   * Test {@link Program#getOp(int)}.
   * <ul>
   *   <li>Then return {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getOp(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals('X', (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getOp(1));
  }

  /**
   * Test {@link Program#getOp(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getOp(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte Program.getOp(int)"})
  public void testGetOp_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals((byte) 0, (new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
        1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getOp(1));
  }

  /**
   * Test {@link Program#getCurrentOp()}.
   * <ul>
   *   <li>Then return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCurrentOp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals('A', (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCurrentOp());
  }

  /**
   * Test {@link Program#getCurrentOp()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCurrentOp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte Program.getCurrentOp()"})
  public void testGetCurrentOp_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals((byte) 0, (new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
        1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCurrentOp());
  }

  /**
   * Test {@link Program#getCurrentOpIntValue()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCurrentOpIntValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals(65, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCurrentOpIntValue());
  }

  /**
   * Test {@link Program#getCurrentOpIntValue()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCurrentOpIntValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Program.getCurrentOpIntValue()"})
  public void testGetCurrentOpIntValue_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, (new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCurrentOpIntValue());
  }

  /**
   * Test {@link Program#stackPush(byte[])} with {@code data}.
   * <p>
   * Method under test: {@link Program#stackPush(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.stackPush("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", getResult.toHexString());
    assertEquals("415841", getResult.toPrefixString());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data2);
  }

  /**
   * Test {@link Program#stackPush(DataWord)} with {@code stackWord}.
   * <p>
   * Method under test: {@link Program#stackPush(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
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
   * <p>
   * Method under test: {@link Program#stackPushZero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.stackPushZero();

    // Assert
    assertEquals(1, program.getStack().size());
  }

  /**
   * Test {@link Program#stackPushOne()}.
   * <p>
   * Method under test: {@link Program#stackPushOne()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.stackPushOne();

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", getResult.toHexString());
    assertEquals("01", getResult.toPrefixString());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data2);
  }

  /**
   * Test {@link Program#setPC(DataWord)} with {@code DataWord}.
   * <p>
   * Method under test: {@link Program#setPC(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.setPC(DataWord)"})
  public void testSetPCWithDataWord() throws UnsupportedEncodingException {
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
    program.setPC(DataWord.ZERO());

    // Assert that nothing has changed
    assertFalse(program.isStopped());
  }

  /**
   * Test {@link Program#setPC(DataWord)} with {@code DataWord}.
   * <p>
   * Method under test: {@link Program#setPC(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.setPC(DataWord)"})
  public void testSetPCWithDataWord2() throws UnsupportedEncodingException {
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
    program.setPC(DataWord.ZERO());

    // Assert
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link Program#setPC(int)} with {@code int}.
   * <p>
   * Method under test: {@link Program#setPC(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.setPC(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link Program#setPC(int)} with {@code int}.
   * <p>
   * Method under test: {@link Program#setPC(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.setPC(int)"})
  public void testSetPCWithInt2() throws UnsupportedEncodingException {
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
    program.setPC(1);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link Program#setHReturn(byte[])}.
   * <p>
   * Method under test: {@link Program#setHReturn(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    byte[] buff = "AXAXAXAX".getBytes("UTF-8");

    // Act
    program.setHReturn(buff);

    // Assert
    assertSame(buff, program.getResult().getHReturn());
  }

  /**
   * Test StackTooSmallException {@link StackTooSmallException#StackTooSmallException(String, Object[])}.
   * <p>
   * Method under test: {@link StackTooSmallException#StackTooSmallException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StackTooSmallException.<init>(String, Object[])"})
  public void testStackTooSmallExceptionNewStackTooSmallException() {
    // Arrange and Act
    StackTooSmallException actualStackTooSmallException = new StackTooSmallException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualStackTooSmallException.getLocalizedMessage());
    assertEquals("An error occurred", actualStackTooSmallException.getMessage());
    assertNull(actualStackTooSmallException.getCause());
    assertEquals(0, actualStackTooSmallException.getSuppressed().length);
  }

  /**
   * Test StaticCallModificationException new {@link StaticCallModificationException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StaticCallModificationException}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticCallModificationException.<init>()"})
  public void testStaticCallModificationExceptionNewStaticCallModificationException() {
    // Arrange and Act
    StaticCallModificationException actualStaticCallModificationException = new StaticCallModificationException();

    // Assert
    assertEquals("Attempt to call a state modifying opcode inside STATICCALL",
        actualStaticCallModificationException.getMessage());
    assertNull(actualStaticCallModificationException.getCause());
    assertEquals(0, actualStaticCallModificationException.getSuppressed().length);
  }

  /**
   * Test {@link Program#step()}.
   * <p>
   * Method under test: {@link Program#step()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.step();

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link Program#step()}.
   * <p>
   * Method under test: {@link Program#step()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.step()"})
  public void testStep2() throws UnsupportedEncodingException {
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
    program.step();

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link Program#sweep(int)}.
   * <p>
   * Method under test: {@link Program#sweep(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    byte[] actualSweepResult = program.sweep(1);

    // Assert
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
    assertArrayEquals(new byte[]{'A'}, actualSweepResult);
  }

  /**
   * Test {@link Program#sweep(int)}.
   * <p>
   * Method under test: {@link Program#sweep(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.sweep(int)"})
  public void testSweep2() throws UnsupportedEncodingException {
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
    byte[] actualSweepResult = program.sweep(1);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertTrue(program.isStopped());
    assertArrayEquals(new byte[]{0}, actualSweepResult);
  }

  /**
   * Test {@link Program#getMemSize()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getMemSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals(0, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getMemSize());
  }

  /**
   * Test {@link Program#memorySave(int, int, byte[])} with {@code addr}, {@code allocSize}, {@code value}.
   * <p>
   * Method under test: {@link Program#memorySave(int, int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.memorySave(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{}, program.getResult().getHReturn());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Test {@link Program#memorySave(DataWord, DataWord)} with {@code addrB}, {@code value}.
   * <p>
   * Method under test: {@link Program#memorySave(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord addrB = DataWord.ZERO();

    // Act
    program.memorySave(addrB, DataWord.ZERO());

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Test {@link Program#memorySave(int, byte[])} with {@code addr}, {@code value}.
   * <p>
   * Method under test: {@link Program#memorySave(int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.memorySave(1, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{}, program.getResult().getHReturn());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Test {@link Program#memoryLoad(DataWord)} with {@code addr}.
   * <ul>
   *   <li>Then return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#memoryLoad(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord addr = DataWord.ZERO();

    // Act and Assert
    assertEquals(addr, program.memoryLoad(addr));
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Test {@link Program#memoryLoad(int)} with {@code address}.
   * <p>
   * Method under test: {@link Program#memoryLoad(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(1);

    // Assert
    DataWord dataWord = actualMemoryLoadResult.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    assertEquals(dataWord, actualMemoryLoadResult);
    assertEquals(Double.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Test {@link Program#memoryChunk(int, int)}.
   * <p>
   * Method under test: {@link Program#memoryChunk(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    byte[] actualMemoryChunkResult = program.memoryChunk(2, 3);

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{}, program.getResult().getHReturn());
    assertArrayEquals(new byte[]{0, 0, 0}, actualMemoryChunkResult);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Test {@link Program#allocateMemory(int, int)}.
   * <p>
   * Method under test: {@link Program#allocateMemory(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.allocateMemory(2, 3);

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{}, program.getResult().getHReturn());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Test {@link Program#suicide(DataWord)}.
   * <p>
   * Method under test: {@link Program#suicide(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.suicide(DataWord)"})
  public void testSuicide() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenReturn(DataWord.ZERO());
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    Repository repository = mock(Repository.class);
    when(repository.getBalance(Mockito.<byte[]>any())).thenReturn(0L);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.suicide(DataWord.ZERO());

    // Assert
    verify(dataWord).clone();
    verify(dataWord).toTronAddress();
    verify(accountCapsule).getAssetMapV2();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getBalance(isA(byte[].class));
    ProgramResult result = program.getResult();
    List<InternalTransaction> internalTransactions = result.getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("suicide", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0L, getResult.getValue());
    assertEquals(1, result.getDeleteAccounts().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertFalse(getResult.isRejected());
    assertTrue(getResult.getTokenInfo().isEmpty());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-106, '5', -52, -61, 'c', ' ', -122, -17, -68, -39, -74, 22, -29, -110, -56, '/', -44,
        'x', -107, 6, '!', '\t', 'r', -110, 'F', -113, -16, 's', -7, 'b', -6, 15}, getResult.getHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Test {@link Program#suicide(DataWord)}.
   * <ul>
   *   <li>Then throw {@link BytecodeExecutionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#suicide(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.suicide(DataWord)"})
  public void testSuicide_thenThrowBytecodeExecutionException() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    Repository repository = mock(Repository.class);
    when(repository.getBalance(Mockito.<byte[]>any())).thenReturn(42L);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act and Assert
    assertThrows(BytecodeExecutionException.class, () -> program.suicide(DataWord.ZERO()));
    verify(dataWord).toTronAddress();
    verify(accountCapsule).getAssetMapV2();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getBalance(isA(byte[].class));
  }

  /**
   * Test {@link Program#canSuicide()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#canSuicide()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.canSuicide()"})
  public void testCanSuicide_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).canSuicide());
  }

  /**
   * Test {@link Program#spendEnergy(long, String)}.
   * <p>
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.spendEnergy(42L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", energyLimitLeft.toHexString());
    assertEquals("08", energyLimitLeft.toPrefixString());
    assertEquals(42L, program.getResult().getEnergyUsed());
    assertEquals(8L, program.getEnergylimitLeftLong());
    assertArrayEquals(new byte[]{'\b'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#spendEnergy(long, String)}.
   * <ul>
   *   <li>Given {@link ContractState#ContractState(ProgramInvoke)} with programInvoke is {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.spendEnergy(long, String)"})
  public void testSpendEnergy_givenContractStateWithProgramInvokeIsProgramInvokeMockImpl()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(OutOfEnergyException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).spendEnergy(42L, "Op Name"));
  }

  /**
   * Test {@link Program#spendEnergy(long, String)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then throw {@link OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.spendEnergy(long, String)"})
  public void testSpendEnergy_whenMax_value_thenThrowOutOfEnergyException() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(OutOfEnergyException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).spendEnergy(Long.MAX_VALUE, "Op Name"));
  }

  /**
   * Test {@link Program#spendEnergyWithPenalty(long, long, String)}.
   * <p>
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.spendEnergyWithPenalty(1L, 1L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000031", energyLimitLeft.toHexString());
    assertEquals("31", energyLimitLeft.toPrefixString());
    assertEquals(49L, program.getEnergylimitLeftLong());
    assertFalse(energyLimitLeft.isZero());
    assertArrayEquals(new byte[]{'1'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#spendEnergyWithPenalty(long, long, String)}.
   * <p>
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.spendEnergyWithPenalty(long, long, String)"})
  public void testSpendEnergyWithPenalty2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.spendEnergyWithPenalty(1L, 1L, "Op Name");

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
  }

  /**
   * Test {@link Program#spendEnergyWithPenalty(long, long, String)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then throw {@link OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.spendEnergyWithPenalty(long, long, String)"})
  public void testSpendEnergyWithPenalty_whenMax_value_thenThrowOutOfEnergyException()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(OutOfEnergyException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).spendEnergyWithPenalty(Long.MAX_VALUE, 1L,
                "Op Name"));
  }

  /**
   * Test {@link Program#spendAllEnergy()}.
   * <p>
   * Method under test: {@link Program#spendAllEnergy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.spendAllEnergy();

    // Assert
    assertEquals(50L, program.getResult().getEnergyUsed());
  }

  /**
   * Test {@link Program#spendAllEnergy()}.
   * <p>
   * Method under test: {@link Program#spendAllEnergy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.spendAllEnergy()"})
  public void testSpendAllEnergy2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.spendAllEnergy();

    // Assert
    assertEquals(1L, program.getResult().getEnergyUsed());
  }

  /**
   * Test {@link Program#refundEnergy(long, String)}.
   * <p>
   * Method under test: {@link Program#refundEnergy(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.refundEnergy(42L, "Cause");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("000000000000000000000000000000000000000000000000000000000000005c", energyLimitLeft.toHexString());
    assertEquals("5c", energyLimitLeft.toPrefixString());
    assertEquals(92L, program.getEnergylimitLeftLong());
    assertArrayEquals(new byte[]{'\\'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\\'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\\'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\\'},
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\\'},
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#refundEnergy(long, String)}.
   * <p>
   * Method under test: {@link Program#refundEnergy(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.refundEnergy(long, String)"})
  public void testRefundEnergy2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.refundEnergy(42L, "Cause");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002b", energyLimitLeft.toHexString());
    assertEquals("2b", energyLimitLeft.toPrefixString());
    assertEquals(43L, program.getEnergylimitLeftLong());
    assertArrayEquals(new byte[]{'+'}, energyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '+'},
        energyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '+'},
        energyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '+'},
        energyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '+'},
        energyLimitLeft.getData());
  }

  /**
   * Test {@link Program#storageSave(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#storageSave(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord word1 = DataWord.ZERO();

    // Act
    program.storageSave(word1, DataWord.ZERO());

    // Assert
    assertEquals(1, program.getStorageDiff().size());
  }

  /**
   * Test {@link Program#getCode()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act
    byte[] actualCode = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getCode();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Test {@link Program#getCodeAt(DataWord)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCodeAt(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.getCodeAt(DataWord)"})
  public void testGetCodeAt_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    byte[] actualCodeAt = program.getCodeAt(DataWord.ZERO());

    // Assert
    verify(repository).getCode(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCodeAt);
  }

  /**
   * Test {@link Program#getContextAddress()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code G}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getContextAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.getContextAddress()"})
  public void testGetContextAddress_thenReturnArrayOfByteWithAAndG() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getContextAddress());
  }

  /**
   * Test {@link Program#getContextAddress()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getContextAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.getContextAddress()"})
  public void testGetContextAddress_thenReturnArrayOfByteWithAAndZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getContextAddress());
  }

  /**
   * Test {@link Program#getContractAddress()}.
   * <p>
   * Method under test: {@link Program#getContractAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualContractAddress = program.getContractAddress();

    // Assert
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc",
        actualContractAddress.toHexString());
    assertEquals("41471f", actualContractAddress.toPrefixString());
    DataWord dataWord = actualContractAddress.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualContractAddress.getData();
    assertSame(data2, actualContractAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualContractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualContractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualContractAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, actualContractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data2);
  }

  /**
   * Test {@link Program#getContractAddress()}.
   * <p>
   * Method under test: {@link Program#getContractAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getContractAddress()"})
  public void testGetContractAddress2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualContractAddress = program.getContractAddress();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158",
        actualContractAddress.toHexString());
    assertEquals("415841", actualContractAddress.toPrefixString());
    DataWord dataWord = actualContractAddress.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualContractAddress.getData();
    assertSame(data2, actualContractAddress.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualContractAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualContractAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualContractAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualContractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data2);
  }

  /**
   * Test {@link Program#getBlockHash(int)}.
   * <ul>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getBlockHash(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getBlockHash(int)"})
  public void testGetBlockHash_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualBlockHash = program.getBlockHash(1);

    // Assert
    DataWord dataWord = actualBlockHash.ZERO;
    assertEquals(dataWord, actualBlockHash);
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Test {@link Program#getRewardBalance(DataWord)}.
   * <ul>
   *   <li>Then return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getRewardBalance(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getRewardBalance(DataWord)"})
  public void testGetRewardBalance_thenReturnZero() throws UnsupportedEncodingException {
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
    DataWord address = DataWord.ZERO();

    // Act and Assert
    assertEquals(address, program.getRewardBalance(address));
  }

  /**
   * Test {@link Program#getOriginAddress()}.
   * <p>
   * Method under test: {@link Program#getOriginAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualOriginAddress = program.getOriginAddress();

    // Assert
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", actualOriginAddress.toHexString());
    assertEquals("411397", actualOriginAddress.toPrefixString());
    assertFalse(actualOriginAddress.isNegative());
    assertFalse(actualOriginAddress.isZero());
    DataWord dataWord = actualOriginAddress.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualOriginAddress.getData();
    assertSame(data2, actualOriginAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, actualOriginAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, actualOriginAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data2);
  }

  /**
   * Test {@link Program#getCallerAddress()}.
   * <p>
   * Method under test: {@link Program#getCallerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualCallerAddress = program.getCallerAddress();

    // Assert
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", actualCallerAddress.toHexString());
    assertEquals("41885f", actualCallerAddress.toPrefixString());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualCallerAddress.isZero());
    DataWord dataWord = actualCallerAddress.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualCallerAddress.getData();
    assertSame(data2, actualCallerAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, actualCallerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, actualCallerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data2);
  }

  /**
   * Test {@link Program#getEnergylimitLeftLong()}.
   * <ul>
   *   <li>Then return fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getEnergylimitLeftLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals(50L, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getEnergylimitLeftLong());
  }

  /**
   * Test {@link Program#getEnergylimitLeftLong()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getEnergylimitLeftLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.getEnergylimitLeftLong()"})
  public void testGetEnergylimitLeftLong_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getEnergylimitLeftLong());
  }

  /**
   * Test {@link Program#getEnergyLimitLeft()}.
   * <p>
   * Method under test: {@link Program#getEnergyLimitLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualEnergyLimitLeft = program.getEnergyLimitLeft();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000032",
        actualEnergyLimitLeft.toHexString());
    assertEquals("32", actualEnergyLimitLeft.toPrefixString());
    DataWord dataWord = actualEnergyLimitLeft.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualEnergyLimitLeft.getData();
    assertSame(data2, actualEnergyLimitLeft.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'2'}, actualEnergyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        actualEnergyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        actualEnergyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        actualEnergyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        data2);
  }

  /**
   * Test {@link Program#getEnergyLimitLeft()}.
   * <p>
   * Method under test: {@link Program#getEnergyLimitLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getEnergyLimitLeft()"})
  public void testGetEnergyLimitLeft2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualEnergyLimitLeft = program.getEnergyLimitLeft();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001",
        actualEnergyLimitLeft.toHexString());
    assertEquals("01", actualEnergyLimitLeft.toPrefixString());
    DataWord dataWord = actualEnergyLimitLeft.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualEnergyLimitLeft.getData();
    assertSame(data2, actualEnergyLimitLeft.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualEnergyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualEnergyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualEnergyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualEnergyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data2);
  }

  /**
   * Test {@link Program#getVmShouldEndInUs()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getVmShouldEndInUs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.getVmShouldEndInUs()"})
  public void testGetVmShouldEndInUs_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getVmShouldEndInUs());
  }

  /**
   * Test {@link Program#getVmShouldEndInUs()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getVmShouldEndInUs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals(0L, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getVmShouldEndInUs());
  }

  /**
   * Test {@link Program#getCallValue()}.
   * <p>
   * Method under test: {@link Program#getCallValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualCallValue = program.getCallValue();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", actualCallValue.toHexString());
    assertEquals("0de0b6", actualCallValue.toPrefixString());
    DataWord dataWord = actualCallValue.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, actualCallValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, actualCallValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, actualCallValue.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, actualCallValue.getData());
  }

  /**
   * Test {@link Program#getCallValue()}.
   * <p>
   * Method under test: {@link Program#getCallValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getCallValue()"})
  public void testGetCallValue2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualCallValue = program.getCallValue();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", actualCallValue.toHexString());
    assertEquals("2a", actualCallValue.toPrefixString());
    DataWord dataWord = actualCallValue.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualCallValue.getData();
    assertSame(data2, actualCallValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'*'}, actualCallValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualCallValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualCallValue.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualCallValue.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data2);
  }

  /**
   * Test {@link Program#getDataSize()}.
   * <p>
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getDataSize()"})
  public void testGetDataSize() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    DataWord dataWord = actualDataSize.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualDataSize.getData();
    assertSame(data2, actualDataSize.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\b'}, actualDataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data2);
  }

  /**
   * Test {@link Program#getDataSize()}.
   * <p>
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getDataSize()"})
  public void testGetDataSize2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    DataWord expectedReturnDataBufferSize = actualDataSize.ZERO;
    assertEquals(expectedReturnDataBufferSize, program.getReturnDataBufferSize());
    byte[] data2 = actualDataSize.getData();
    assertSame(data2, actualDataSize.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\b'}, actualDataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data2);
  }

  /**
   * Test {@link Program#getDataSize()}.
   * <ul>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    DataWord dataWord = actualDataSize.ZERO;
    assertEquals(dataWord, actualDataSize);
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Test {@link Program#getDataValue(DataWord)}.
   * <ul>
   *   <li>Then return toPrefixString is {@code 415841}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getDataValue(DataWord)"})
  public void testGetDataValue_thenReturnToPrefixStringIs415841() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualDataValue = program.getDataValue(DataWord.ZERO());

    // Assert
    assertEquals("415841", actualDataValue.toPrefixString());
    assertEquals("4158415841584158000000000000000000000000000000000000000000000000", actualDataValue.toHexString());
    assertFalse(actualDataValue.isZero());
    byte[] data2 = actualDataValue.getData();
    assertSame(data2, actualDataValue.getNoLeadZeroesData());
    byte[] expectedNoEndZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoEndZeroesData, actualDataValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, actualDataValue.getClonedData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, data2);
  }

  /**
   * Test {@link Program#getDataValue(DataWord)}.
   * <ul>
   *   <li>Then return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord index = DataWord.ZERO();

    // Act and Assert
    assertEquals(index, program.getDataValue(index));
  }

  /**
   * Test {@link Program#getDataCopy(DataWord, DataWord)}.
   * <ul>
   *   <li>Given {@link ContractState#ContractState(ProgramInvoke)} with programInvoke is {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_givenContractStateWithProgramInvokeIsProgramInvokeMockImpl()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord offset = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(new byte[]{}, program.getDataCopy(offset, DataWord.ZERO()));
  }

  /**
   * Test {@link Program#getDataCopy(DataWord, DataWord)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord offset = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(new byte[]{}, program.getDataCopy(offset, DataWord.ZERO()));
  }

  /**
   * Test {@link Program#getReturnDataBufferSize()}.
   * <p>
   * Method under test: {@link Program#getReturnDataBufferSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualReturnDataBufferSize = program.getReturnDataBufferSize();

    // Assert
    DataWord dataWord = actualReturnDataBufferSize.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, actualReturnDataBufferSize);
  }

  /**
   * Test {@link Program#getReturnDataBufferData(DataWord, DataWord)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getReturnDataBufferData(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Program.getReturnDataBufferData(DataWord, DataWord)"})
  public void testGetReturnDataBufferData_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
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
    DataWord off = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(new byte[]{}, program.getReturnDataBufferData(off, DataWord.ZERO()));
  }

  /**
   * Test {@link Program#storageLoad(DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#clone()} return ZERO.</li>
   *   <li>When ZERO.</li>
   *   <li>Then calls {@link DataWord#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#storageLoad(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.storageLoad(DataWord)"})
  public void testStorageLoad_givenDataWordCloneReturnZero_whenZero_thenCallsClone()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DataWord dataWord2 = mock(DataWord.class);
    DataWord ZEROResult = DataWord.ZERO();
    when(dataWord2.clone()).thenReturn(ZEROResult);
    Repository repository = mock(Repository.class);
    when(repository.getStorageValue(Mockito.<byte[]>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualStorageLoadResult = program.storageLoad(DataWord.ZERO());

    // Assert
    verify(dataWord2).clone();
    verify(dataWord).toTronAddress();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getStorageValue(isA(byte[].class), isA(DataWord.class));
    assertSame(ZEROResult, actualStorageLoadResult);
  }

  /**
   * Test {@link Program#storageLoad(DataWord)}.
   * <ul>
   *   <li>Given {@link Repository} {@link Repository#getStorageValue(byte[], DataWord)} return {@code null}.</li>
   *   <li>When ZERO.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#storageLoad(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.storageLoad(DataWord)"})
  public void testStorageLoad_givenRepositoryGetStorageValueReturnNull_whenZero_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.getStorageValue(Mockito.<byte[]>any(), Mockito.<DataWord>any())).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualStorageLoadResult = program.storageLoad(DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getStorageValue(isA(byte[].class), isA(DataWord.class));
    assertNull(actualStorageLoadResult);
  }

  /**
   * Test {@link Program#storageLoad(DataWord)}.
   * <ul>
   *   <li>Given {@link Repository} {@link Repository#getStorageValue(byte[], DataWord)} return ZERO.</li>
   *   <li>When ZERO.</li>
   *   <li>Then return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#storageLoad(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.storageLoad(DataWord)"})
  public void testStorageLoad_givenRepositoryGetStorageValueReturnZero_whenZero_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    DataWord ZEROResult = DataWord.ZERO();
    when(repository.getStorageValue(Mockito.<byte[]>any(), Mockito.<DataWord>any())).thenReturn(ZEROResult);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualStorageLoadResult = program.storageLoad(DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getStorageValue(isA(byte[].class), isA(DataWord.class));
    assertEquals(ZEROResult, actualStorageLoadResult);
  }

  /**
   * Test {@link Program#getTokenValue()}.
   * <p>
   * Method under test: {@link Program#getTokenValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getTokenValue()"})
  public void testGetTokenValue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualTokenValue = program.getTokenValue();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", actualTokenValue.toHexString());
    assertEquals("2a", actualTokenValue.toPrefixString());
    assertFalse(actualTokenValue.isNegative());
    assertFalse(actualTokenValue.isZero());
    DataWord dataWord = actualTokenValue.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualTokenValue.getData();
    assertSame(data2, actualTokenValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'*'}, actualTokenValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualTokenValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualTokenValue.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualTokenValue.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data2);
  }

  /**
   * Test {@link Program#getTokenId()}.
   * <p>
   * Method under test: {@link Program#getTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getTokenId()"})
  public void testGetTokenId() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualTokenId = program.getTokenId();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", actualTokenId.toHexString());
    assertEquals("01", actualTokenId.toPrefixString());
    assertFalse(actualTokenId.isNegative());
    assertFalse(actualTokenId.isZero());
    DataWord dataWord = actualTokenId.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualTokenId.getData();
    assertSame(data2, actualTokenId.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualTokenId.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualTokenId.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualTokenId.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualTokenId.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data2);
  }

  /**
   * Test {@link Program#getPrevHash()}.
   * <p>
   * Method under test: {@link Program#getPrevHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getPrevHash()"})
  public void testGetPrevHash() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualPrevHash = program.getPrevHash();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualPrevHash.toHexString());
    assertEquals("415841", actualPrevHash.toPrefixString());
    assertFalse(actualPrevHash.isNegative());
    DataWord dataWord = actualPrevHash.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualPrevHash.getData();
    assertSame(data2, actualPrevHash.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualPrevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualPrevHash.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data2);
  }

  /**
   * Test {@link Program#getPrevHash()}.
   * <ul>
   *   <li>Then return toPrefixString is {@code 961cb1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getPrevHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getPrevHash()"})
  public void testGetPrevHash_thenReturnToPrefixStringIs961cb1() throws UnsupportedEncodingException {
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
    DataWord actualPrevHash = program.getPrevHash();

    // Assert
    assertEquals("961cb1", actualPrevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", actualPrevHash.toHexString());
    assertTrue(actualPrevHash.isNegative());
    DataWord dataWord = actualPrevHash.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualPrevHash.getData();
    assertSame(data2, actualPrevHash.getNoEndZeroesData());
    assertSame(data2, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, actualPrevHash.toTronAddress());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, actualPrevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data2);
  }

  /**
   * Test {@link Program#getCoinbase()}.
   * <p>
   * Method under test: {@link Program#getCoinbase()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualCoinbase = program.getCoinbase();

    // Assert
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", actualCoinbase.toHexString());
    assertEquals("e559de", actualCoinbase.toPrefixString());
    DataWord dataWord = actualCoinbase.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualCoinbase.getData();
    assertSame(data2, actualCoinbase.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        actualCoinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        actualCoinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, actualCoinbase.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, actualCoinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
  }

  /**
   * Test {@link Program#getCoinbase()}.
   * <p>
   * Method under test: {@link Program#getCoinbase()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getCoinbase()"})
  public void testGetCoinbase2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualCoinbase = program.getCoinbase();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualCoinbase.toHexString());
    assertEquals("415841", actualCoinbase.toPrefixString());
    DataWord dataWord = actualCoinbase.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualCoinbase.getData();
    assertSame(data2, actualCoinbase.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualCoinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCoinbase.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCoinbase.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualCoinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data2);
  }

  /**
   * Test {@link Program#getTimestamp()}.
   * <p>
   * Method under test: {@link Program#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualTimestamp = program.getTimestamp();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", actualTimestamp.toHexString());
    assertEquals("5387fe24", actualTimestamp.toPrefixString());
    DataWord dataWord = actualTimestamp.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualTimestamp.getData();
    assertSame(data2, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, actualTimestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data2);
  }

  /**
   * Test {@link Program#getTimestamp()}.
   * <p>
   * Method under test: {@link Program#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getTimestamp()"})
  public void testGetTimestamp2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualTimestamp = program.getTimestamp();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", actualTimestamp.toHexString());
    assertEquals("0a", actualTimestamp.toPrefixString());
    DataWord dataWord = actualTimestamp.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualTimestamp.getData();
    assertSame(data2, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\n'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        data2);
  }

  /**
   * Test {@link Program#getNumber()}.
   * <p>
   * Method under test: {@link Program#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualNumber = program.getNumber();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    DataWord dataWord = actualNumber.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualNumber.getData();
    assertSame(data2, actualNumber.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'!'}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data2);
  }

  /**
   * Test {@link Program#getNumber()}.
   * <p>
   * Method under test: {@link Program#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getNumber()"})
  public void testGetNumber2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualNumber = program.getNumber();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", actualNumber.toHexString());
    assertEquals("01", actualNumber.toPrefixString());
    DataWord dataWord = actualNumber.ZERO;
    assertEquals(dataWord, program.getDifficulty());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualNumber.getData();
    assertSame(data2, actualNumber.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data2);
  }

  /**
   * Test {@link Program#getDifficulty()}.
   * <p>
   * Method under test: {@link Program#getDifficulty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualDifficulty = program.getDifficulty();

    // Assert
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", actualDifficulty.toHexString());
    assertEquals("3ed290", actualDifficulty.toPrefixString());
    assertFalse(actualDifficulty.isZero());
    DataWord dataWord = actualDifficulty.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, program.getReturnDataBufferSize());
    byte[] data2 = actualDifficulty.getData();
    assertSame(data2, actualDifficulty.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, actualDifficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, actualDifficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data2);
  }

  /**
   * Test {@link Program#getDifficulty()}.
   * <ul>
   *   <li>Then return {@link DataWord#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getDifficulty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getDifficulty()"})
  public void testGetDifficulty_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    DataWord actualDifficulty = program.getDifficulty();

    // Assert
    DataWord dataWord = actualDifficulty.ZERO;
    assertEquals(dataWord, actualDifficulty);
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Test {@link Program#isStaticCall()}.
   * <p>
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.isStaticCall()"})
  public void testIsStaticCall() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).isStaticCall());
  }

  /**
   * Test {@link Program#isStaticCall()}.
   * <p>
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.isStaticCall()"})
  public void testIsStaticCall2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).isStaticCall());
  }

  /**
   * Test {@link Program#isStaticCall()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.isStaticCall()"})
  public void testIsStaticCall_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    DataWord address = DataWord.ZERO();
    DataWord origin = DataWord.ZERO();
    DataWord caller = DataWord.ZERO();
    DataWord balance = DataWord.ZERO();
    DataWord callValue = DataWord.ZERO();
    DataWord tokenValue = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    DataWord lastHash = DataWord.ZERO();
    DataWord coinbase = DataWord.ZERO();
    DataWord timestamp = DataWord.ZERO();
    DataWord number = DataWord.ZERO();
    DataWord difficulty = DataWord.ZERO();
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, balance, callValue, tokenValue,
        tokenId, msgData, lastHash, coinbase, timestamp, number, difficulty,
        new ContractState(new ProgramInvokeMockImpl()), 1, true, true, 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).isStaticCall());
  }

  /**
   * Test {@link Program#isConstantCall()}.
   * <p>
   * Method under test: {@link Program#isConstantCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.isConstantCall()"})
  public void testIsConstantCall() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).isConstantCall());
  }

  /**
   * Test {@link Program#isConstantCall()}.
   * <ul>
   *   <li>Given {@link ContractState#ContractState(ProgramInvoke)} with programInvoke is {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#isConstantCall()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.isConstantCall()"})
  public void testIsConstantCall_givenContractStateWithProgramInvokeIsProgramInvokeMockImpl()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).isConstantCall());
  }

  /**
   * Test {@link Program#setRuntimeFailure(RuntimeException)}.
   * <p>
   * Method under test: {@link Program#setRuntimeFailure(RuntimeException)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    RuntimeException e = new RuntimeException("foo");

    // Act
    program.setRuntimeFailure(e);

    // Assert
    assertSame(e, program.getResult().getException());
  }

  /**
   * Test {@link Program#memoryToString()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#memoryToString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals("", (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).memoryToString());
  }

  /**
   * Test {@link Program#saveOpTrace()}.
   * <p>
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

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
    assertArrayEquals(new byte[]{'2'}, energy.toByteArray());
  }

  /**
   * Test {@link Program#saveOpTrace()}.
   * <p>
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.saveOpTrace()"})
  public void testSaveOpTrace2() throws UnsupportedEncodingException {
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
    program.saveOpTrace();

    // Assert that nothing has changed
    assertTrue(program.getTrace().getOps().isEmpty());
  }

  /**
   * Test {@link Program#saveOpTrace()}.
   * <p>
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.saveOpTrace()"})
  public void testSaveOpTrace3() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.saveOpTrace();

    // Assert
    List<Op> ops2 = program.getTrace().getOps();
    assertEquals(1, ops2.size());
    Op getResult = ops2.get(0);
    BigInteger energy = getResult.getEnergy();
    assertEquals("1", energy.toString());
    assertEquals(0, energy.getLowestSetBit());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getPc());
    assertEquals(1, energy.signum());
    assertEquals(65, getResult.getCode());
    OpActions actions = getResult.getActions();
    assertTrue(actions.getMemory().isEmpty());
    assertTrue(actions.getStack().isEmpty());
    assertTrue(actions.getStorage().isEmpty());
    assertArrayEquals(new byte[]{1}, energy.toByteArray());
  }

  /**
   * Test {@link Program#createContract2(DataWord, DataWord, DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#createContract2(DataWord, DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.createContract2(DataWord, DataWord, DataWord, DataWord)"})
  public void testCreateContract2() throws UnsupportedEncodingException {
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
    DataWord value = DataWord.of((byte) 'A');
    DataWord memStart = DataWord.ZERO();
    DataWord memSize = DataWord.ZERO();
    DataWord salt = DataWord.ZERO();

    // Act
    program.createContract2(value, memStart, memSize, salt);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord expectedGetResult = salt.ZERO;
    assertEquals(expectedGetResult, stack.get(0));
  }

  /**
   * Test {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContract)}.
   * <p>
   * Method under test: {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)"})
  public void testCallToPrecompiledAddress() throws UnsupportedEncodingException {
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
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new AvailableUnfreezeV2Size());

    // Assert
    assertEquals(1, program.getStack().size());
  }

  /**
   * Test {@link Program#byTestingSuite()}.
   * <p>
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.byTestingSuite()"})
  public void testByTestingSuite() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).byTestingSuite());
  }

  /**
   * Test {@link Program#byTestingSuite()}.
   * <p>
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.byTestingSuite()"})
  public void testByTestingSuite2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).byTestingSuite());
  }

  /**
   * Test {@link Program#byTestingSuite()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.byTestingSuite()"})
  public void testByTestingSuite_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, true, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).byTestingSuite());
  }

  /**
   * Test {@link Program#isTokenTransfer(MessageCall)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#isTokenTransfer(MessageCall)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.isTokenTransfer(MessageCall)"})
  public void testIsTokenTransfer_thenReturnFalse() throws UnsupportedEncodingException {
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
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();

    // Act and Assert
    assertFalse(program.isTokenTransfer(
        new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(), true)));
  }

  /**
   * Test {@link Program#getCallEnergy(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord requestedEnergy = DataWord.ZERO();

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(requestedEnergy, DataWord.ZERO());

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getData());
  }

  /**
   * Test {@link Program#getCallEnergy(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord Program.getCallEnergy(DataWord, DataWord)"})
  public void testGetCallEnergy2() throws UnsupportedEncodingException {
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
    program.setContractVersion(1);

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(DataWord.ZERO(), null);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCallEnergy.getData());
  }

  /**
   * Test {@link Program#getCreateEnergy(DataWord)}.
   * <ul>
   *   <li>Then return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getCreateEnergy(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord availableEnergy = DataWord.ZERO();

    // Act and Assert
    assertSame(availableEnergy, program.getCreateEnergy(availableEnergy));
  }

  /**
   * Test {@link Program#getMemory()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertArrayEquals(new byte[]{}, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
        1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getMemory());
  }

  /**
   * Test {@link Program#initMem(byte[])}.
   * <p>
   * Method under test: {@link Program#initMem(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    program.initMem("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{}, program.getResult().getHReturn());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Test {@link Program#getVmStartInUs()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getVmStartInUs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.getVmStartInUs()"})
  public void testGetVmStartInUs_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L);

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getVmStartInUs());
  }

  /**
   * Test {@link Program#getVmStartInUs()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#getVmStartInUs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act and Assert
    assertEquals(0L, (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).getVmStartInUs());
  }

  /**
   * Test {@link Program#freeze(DataWord, DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    program.freeze(receiverAddress, frozenBalance, DataWord.ZERO());

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-106, '5', -52, -61, 'c', ' ', -122, -17, -68, -39, -74, 22, -29, -110, -56, '/', -44,
        'x', -107, 6, '!', '\t', 'r', -110, 'F', -113, -16, 's', -7, 'b', -6, 15}, getResult.getHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Test {@link Program#freeze(DataWord, DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.freeze(DataWord, DataWord, DataWord)"})
  public void testFreeze2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "@XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    program.freeze(receiverAddress, frozenBalance, DataWord.ZERO());

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-106, '5', -52, -61, 'c', ' ', -122, -17, -68, -39, -74, 22, -29, -110, -56, '/', -44,
        'x', -107, 6, '!', '\t', 'r', -110, 'F', -113, -16, 's', -7, 'b', -6, 15}, getResult.getHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Test TransferException {@link TransferException#TransferException(String, Object[])}.
   * <p>
   * Method under test: {@link TransferException#TransferException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

  /**
   * Test {@link Program#unfreeze(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#unfreeze(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreeze(DataWord, DataWord)"})
  public void testUnfreeze() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord receiverAddress = DataWord.ZERO();

    // Act
    boolean actualUnfreezeResult = program.unfreeze(receiverAddress, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("unfreezeForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertFalse(actualUnfreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-42, -86, -107, '8', -111, -78, -19, -83, -42, '\f', 'r', 'j', -16, 'C', '7', -47, '4',
        -94, -90, 'd', -19, 'O', -104, -46, '*', 'a', -43, -71, '{', -78, '[', -35}, getResult.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Test {@link Program#unfreeze(DataWord, DataWord)}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unfreeze(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreeze(DataWord, DataWord)"})
  public void testUnfreeze_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new TransferException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord receiverAddress = DataWord.ZERO();

    // Act and Assert
    assertThrows(TransferException.class, () -> program.unfreeze(receiverAddress, DataWord.ZERO()));
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#freezeExpireTime(DataWord, DataWord)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.freezeExpireTime(DataWord, DataWord)"})
  public void testFreezeExpireTime_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DelegatedResourceCapsule delegatedResourceCapsule = mock(DelegatedResourceCapsule.class);
    when(delegatedResourceCapsule.getExpireTimeForBandwidth()).thenReturn(1L);
    when(delegatedResourceCapsule.getFrozenBalanceForBandwidth()).thenReturn(1L);
    Repository repository = mock(Repository.class);
    when(repository.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord targetAddress = DataWord.ZERO();

    // Act
    long actualFreezeExpireTimeResult = program.freezeExpireTime(targetAddress, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(delegatedResourceCapsule).getExpireTimeForBandwidth();
    verify(delegatedResourceCapsule).getFrozenBalanceForBandwidth();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getDelegatedResource(isA(byte[].class));
    assertEquals(1L, actualFreezeExpireTimeResult);
  }

  /**
   * Test {@link Program#freezeExpireTime(DataWord, DataWord)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.freezeExpireTime(DataWord, DataWord)"})
  public void testFreezeExpireTime_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord targetAddress = DataWord.ZERO();

    // Act
    long actualFreezeExpireTimeResult = program.freezeExpireTime(targetAddress, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getDelegatedResource(isA(byte[].class));
    assertEquals(0L, actualFreezeExpireTimeResult);
  }

  /**
   * Test {@link Program#freezeExpireTime(DataWord, DataWord)}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.freezeExpireTime(DataWord, DataWord)"})
  public void testFreezeExpireTime_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DelegatedResourceCapsule delegatedResourceCapsule = mock(DelegatedResourceCapsule.class);
    when(delegatedResourceCapsule.getExpireTimeForBandwidth())
        .thenThrow(new TransferException("An error occurred", "Args"));
    when(delegatedResourceCapsule.getFrozenBalanceForBandwidth()).thenReturn(1L);
    Repository repository = mock(Repository.class);
    when(repository.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord targetAddress = DataWord.ZERO();

    // Act and Assert
    assertThrows(TransferException.class, () -> program.freezeExpireTime(targetAddress, DataWord.ZERO()));
    verify(dataWord).toTronAddress();
    verify(delegatedResourceCapsule).getExpireTimeForBandwidth();
    verify(delegatedResourceCapsule).getFrozenBalanceForBandwidth();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getDelegatedResource(isA(byte[].class));
  }

  /**
   * Test {@link Program#freezeBalanceV2(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    program.freezeBalanceV2(frozenBalance, DataWord.ZERO());

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-91, -96, 14, -35, 'X', 3, -91, 23, -31, -89, 'y', '@', 0, 7, -98, -64, '1', -50, 27,
        -127, -29, -44, -115, 'K', 'X', 21, 3, 25, -14, '8', -21, -1}, getResult.getHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 'G', 31, -45, -83, '>',
        -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Test {@link Program#freezeBalanceV2(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.freezeBalanceV2(DataWord, DataWord)"})
  public void testFreezeBalanceV22() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "@XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    program.freezeBalanceV2(frozenBalance, DataWord.ZERO());

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-91, -96, 14, -35, 'X', 3, -91, 23, -31, -89, 'y', '@', 0, 7, -98, -64, '1', -50, 27,
        -127, -29, -44, -115, 'K', 'X', 21, 3, 25, -14, '8', -21, -1}, getResult.getHash());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r', 'A', 'G', 31, -45, -83, '>',
        -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Test {@link Program#unfreezeBalanceV2(DataWord, DataWord)}.
   * <p>
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreezeBalanceV2(DataWord, DataWord)"})
  public void testUnfreezeBalanceV2() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#unfreezeBalanceV2(DataWord, DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#toTronAddress()} return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreezeBalanceV2(DataWord, DataWord)"})
  public void testUnfreezeBalanceV2_givenDataWordToTronAddressReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link Program#unfreezeBalanceV2(DataWord, DataWord)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#toTronAddress()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreezeBalanceV2(DataWord, DataWord)"})
  public void testUnfreezeBalanceV2_givenDataWordToTronAddressReturnNull() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link Program#unfreezeBalanceV2(DataWord, DataWord)}.
   * <ul>
   *   <li>Then calls {@link Repository#newRepositoryChild()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreezeBalanceV2(DataWord, DataWord)"})
  public void testUnfreezeBalanceV2_thenCallsNewRepositoryChild() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#unfreezeBalanceV2(DataWord, DataWord)}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unfreezeBalanceV2(DataWord, DataWord)"})
  public void testUnfreezeBalanceV2_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new TransferException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act and Assert
    assertThrows(TransferException.class, () -> program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO()));
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#withdrawExpireUnfreeze()}.
   * <p>
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawExpireUnfreeze()"})
  public void testWithdrawExpireUnfreeze() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.withdrawExpireUnfreeze();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#withdrawExpireUnfreeze()}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#toTronAddress()} return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawExpireUnfreeze()"})
  public void testWithdrawExpireUnfreeze_givenDataWordToTronAddressReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.withdrawExpireUnfreeze();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link Program#withdrawExpireUnfreeze()}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#toTronAddress()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawExpireUnfreeze()"})
  public void testWithdrawExpireUnfreeze_givenDataWordToTronAddressReturnNull() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.withdrawExpireUnfreeze();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link Program#withdrawExpireUnfreeze()}.
   * <ul>
   *   <li>Then calls {@link Repository#newRepositoryChild()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawExpireUnfreeze()"})
  public void testWithdrawExpireUnfreeze_thenCallsNewRepositoryChild() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.withdrawExpireUnfreeze();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#withdrawExpireUnfreeze()}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawExpireUnfreeze()"})
  public void testWithdrawExpireUnfreeze_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new TransferException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(TransferException.class,
        () -> (new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction))
            .withdrawExpireUnfreeze());
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#cancelAllUnfreezeV2Action()}.
   * <p>
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.cancelAllUnfreezeV2Action()"})
  public void testCancelAllUnfreezeV2Action() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.cancelAllUnfreezeV2Action();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#cancelAllUnfreezeV2Action()}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#toTronAddress()} return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.cancelAllUnfreezeV2Action()"})
  public void testCancelAllUnfreezeV2Action_givenDataWordToTronAddressReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.cancelAllUnfreezeV2Action();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link Program#cancelAllUnfreezeV2Action()}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#toTronAddress()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.cancelAllUnfreezeV2Action()"})
  public void testCancelAllUnfreezeV2Action_givenDataWordToTronAddressReturnNull() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.cancelAllUnfreezeV2Action();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link Program#cancelAllUnfreezeV2Action()}.
   * <ul>
   *   <li>Then calls {@link Repository#newRepositoryChild()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.cancelAllUnfreezeV2Action()"})
  public void testCancelAllUnfreezeV2Action_thenCallsNewRepositoryChild() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.cancelAllUnfreezeV2Action();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#cancelAllUnfreezeV2Action()}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.cancelAllUnfreezeV2Action()"})
  public void testCancelAllUnfreezeV2Action_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new TransferException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(TransferException.class,
        () -> (new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction))
            .cancelAllUnfreezeV2Action());
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#delegateResource(DataWord, DataWord, DataWord)}.
   * <ul>
   *   <li>Given {@link ArithmeticException#ArithmeticException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#delegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.delegateResource(DataWord, DataWord, DataWord)"})
  public void testDelegateResource_givenArithmeticExceptionWithFoo() throws UnsupportedEncodingException {
    // Arrange
    new ArithmeticException("foo");
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord receiverAddress = DataWord.ZERO();
    DataWord delegateBalance = DataWord.ZERO();

    // Act
    program.delegateResource(receiverAddress, delegateBalance, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-42, -86, -107, '8', -111, -78, -19, -83, -42, '\f', 'r', 'j', -16, 'C', '7', -47, '4',
        -94, -90, 'd', -19, 'O', -104, -46, '*', 'a', -43, -71, '{', -78, '[', -35}, getResult.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Test {@link Program#delegateResource(DataWord, DataWord, DataWord)}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#delegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.delegateResource(DataWord, DataWord, DataWord)"})
  public void testDelegateResource_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new TransferException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord receiverAddress = DataWord.ZERO();
    DataWord delegateBalance = DataWord.ZERO();

    // Act and Assert
    assertThrows(TransferException.class,
        () -> program.delegateResource(receiverAddress, delegateBalance, DataWord.ZERO()));
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#unDelegateResource(DataWord, DataWord, DataWord)}.
   * <ul>
   *   <li>Given {@link ArithmeticException#ArithmeticException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unDelegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unDelegateResource(DataWord, DataWord, DataWord)"})
  public void testUnDelegateResource_givenArithmeticExceptionWithFoo() throws UnsupportedEncodingException {
    // Arrange
    new ArithmeticException("foo");
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord receiverAddress = DataWord.ZERO();
    DataWord unDelegateBalance = DataWord.ZERO();

    // Act
    program.unDelegateResource(receiverAddress, unDelegateBalance, DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-42, -86, -107, '8', -111, -78, -19, -83, -42, '\f', 'r', 'j', -16, 'C', '7', -47, '4',
        -94, -90, 'd', -19, 'O', -104, -46, '*', 'a', -43, -71, '{', -78, '[', -35}, getResult.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Test {@link Program#unDelegateResource(DataWord, DataWord, DataWord)}.
   * <ul>
   *   <li>Then throw {@link TransferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#unDelegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.unDelegateResource(DataWord, DataWord, DataWord)"})
  public void testUnDelegateResource_thenThrowTransferException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new TransferException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);
    DataWord receiverAddress = DataWord.ZERO();
    DataWord unDelegateBalance = DataWord.ZERO();

    // Act and Assert
    assertThrows(TransferException.class,
        () -> program.unDelegateResource(receiverAddress, unDelegateBalance, DataWord.ZERO()));
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#voteWitness(int, int, int, int)}.
   * <ul>
   *   <li>Then throw {@link BytecodeExecutionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#voteWitness(int, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Program.voteWitness(int, int, int, int)"})
  public void testVoteWitness_thenThrowBytecodeExecutionException() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BytecodeExecutionException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
            transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).voteWitness(1, 3, 10, 10));
  }

  /**
   * Test {@link Program#withdrawReward()}.
   * <p>
   * Method under test: {@link Program#withdrawReward()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawReward()"})
  public void testWithdrawReward() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValue()).thenReturn(42L);
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.clone()).thenReturn(dataWord2);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getTimestamp()).thenReturn(dataWord3);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    long actualWithdrawRewardResult = program.withdrawReward();

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord3).clone();
    verify(dataWord2).longValue();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).getTimestamp();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawReward", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0L, getResult.getValue());
    assertEquals(0L, actualWithdrawRewardResult);
    assertEquals(1, getResult.getDeep());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Test {@link Program#withdrawReward()}.
   * <ul>
   *   <li>Then throw {@link AssetIssueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#withdrawReward()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Program.withdrawReward()"})
  public void testWithdrawReward_thenThrowAssetIssueException() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new AssetIssueException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(AssetIssueException.class,
        () -> (new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction)).withdrawReward());
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Test {@link Program#addContextContractUsage(long)}.
   * <ul>
   *   <li>Then calls {@link RepositoryImpl#getContractState(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Program#addContextContractUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Program.addContextContractUsage(long)"})
  public void testAddContextContractUsage_thenCallsGetContractState() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContractState(Mockito.<byte[]>any())).thenReturn(new ContractStateCapsule(1L));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    (new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))).addContextContractUsage(42L);

    // Assert
    verify(repository).getContractState(isA(byte[].class));
  }
}
