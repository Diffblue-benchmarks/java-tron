package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.ContractCapsule;
import org.tron.core.capsule.ContractStateCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.core.exception.AccountResourceInsufficientException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.exception.TronException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.MessageCall;
import org.tron.core.vm.PrecompiledContracts;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.core.vm.trace.Op;
import org.tron.core.vm.trace.OpActions;
import org.tron.protos.Protocol;
import org.tron.protos.contract.SmartContractOuterClass;

public class ProgramDiffblueTest {
  /**
   * Method under test:
   * {@link Program.AssetIssueException#AssetIssueException(String, Object[])}
   */
  @Test
  public void testAssetIssueExceptionNewAssetIssueException() {
    // Arrange and Act
    Program.AssetIssueException actualAssetIssueException = new Program.AssetIssueException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualAssetIssueException.getLocalizedMessage());
    assertEquals("An error occurred", actualAssetIssueException.getMessage());
    assertNull(actualAssetIssueException.getCause());
    assertEquals(0, actualAssetIssueException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.BadJumpDestinationException#BadJumpDestinationException(String, Object[])}
   */
  @Test
  public void testBadJumpDestinationExceptionNewBadJumpDestinationException() {
    // Arrange and Act
    Program.BadJumpDestinationException actualBadJumpDestinationException = new Program.BadJumpDestinationException(
        "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualBadJumpDestinationException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadJumpDestinationException.getMessage());
    assertNull(actualBadJumpDestinationException.getCause());
    assertEquals(0, actualBadJumpDestinationException.getSuppressed().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Program.ByteCodeIterator#ByteCodeIterator(byte[])}
   *   <li>{@link Program.ByteCodeIterator#setPC(int)}
   *   <li>{@link Program.ByteCodeIterator#getPC()}
   * </ul>
   */
  @Test
  public void testByteCodeIteratorGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    Program.ByteCodeIterator actualByteCodeIterator = new Program.ByteCodeIterator("AXAXAXAX".getBytes("UTF-8"));
    actualByteCodeIterator.setPC(1);

    // Assert that nothing has changed
    assertEquals(1, actualByteCodeIterator.getPC());
  }

  /**
   * Method under test:
   * {@link Program.BytecodeExecutionException#BytecodeExecutionException(String)}
   */
  @Test
  public void testBytecodeExecutionExceptionNewBytecodeExecutionException() {
    // Arrange and Act
    Program.BytecodeExecutionException actualBytecodeExecutionException = new Program.BytecodeExecutionException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualBytecodeExecutionException.getMessage());
    assertNull(actualBytecodeExecutionException.getCause());
    assertEquals(0, actualBytecodeExecutionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.BytecodeExecutionException#BytecodeExecutionException(String, Object[])}
   */
  @Test
  public void testBytecodeExecutionExceptionNewBytecodeExecutionException2() {
    // Arrange and Act
    Program.BytecodeExecutionException actualBytecodeExecutionException = new Program.BytecodeExecutionException(
        "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualBytecodeExecutionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBytecodeExecutionException.getMessage());
    assertNull(actualBytecodeExecutionException.getCause());
    assertEquals(0, actualBytecodeExecutionException.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#alreadyTimeOut()}
   */
  @Test
  public void testExceptionAlreadyTimeOut() {
    // Arrange and Act
    Program.OutOfTimeException actualAlreadyTimeOutResult = Program.Exception.alreadyTimeOut();

    // Assert
    assertEquals("Already Time Out", actualAlreadyTimeOutResult.getLocalizedMessage());
    assertEquals("Already Time Out", actualAlreadyTimeOutResult.getMessage());
    assertNull(actualAlreadyTimeOutResult.getCause());
    assertEquals(0, actualAlreadyTimeOutResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#badJumpDestination(int)}
   */
  @Test
  public void testExceptionBadJumpDestination() {
    // Arrange and Act
    Program.BadJumpDestinationException actualBadJumpDestinationResult = Program.Exception.badJumpDestination(1);

    // Assert
    assertEquals("Operation with pc isn't 'JUMPDEST': PC[1];", actualBadJumpDestinationResult.getLocalizedMessage());
    assertEquals("Operation with pc isn't 'JUMPDEST': PC[1];", actualBadJumpDestinationResult.getMessage());
    assertNull(actualBadJumpDestinationResult.getCause());
    assertEquals(0, actualBadJumpDestinationResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.Exception#contractExecuteException(TronException)}
   */
  @Test
  public void testExceptionContractExecuteException() {
    // Arrange and Act
    Program.PrecompiledContractException actualContractExecuteExceptionResult = Program.Exception
        .contractExecuteException(new AccountResourceInsufficientException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualContractExecuteExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualContractExecuteExceptionResult.getMessage());
    assertNull(actualContractExecuteExceptionResult.getCause());
    assertEquals(0, actualContractExecuteExceptionResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.Exception#contractValidateException(TronException)}
   */
  @Test
  public void testExceptionContractValidateException() {
    // Arrange and Act
    Program.PrecompiledContractException actualContractValidateExceptionResult = Program.Exception
        .contractValidateException(new AccountResourceInsufficientException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualContractValidateExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateExceptionResult.getMessage());
    assertNull(actualContractValidateExceptionResult.getCause());
    assertEquals(0, actualContractValidateExceptionResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.Exception#energyOverflow(BigInteger, BigInteger)}
   */
  @Test
  public void testExceptionEnergyOverflow() {
    // Arrange
    BigInteger actualEnergy = BigInteger.valueOf(1L);

    // Act
    Program.OutOfEnergyException actualEnergyOverflowResult = Program.Exception.energyOverflow(actualEnergy,
        BigInteger.valueOf(1L));

    // Assert
    assertEquals("Energy value overflow: actualEnergy[1], energyLimit[1];",
        actualEnergyOverflowResult.getLocalizedMessage());
    assertEquals("Energy value overflow: actualEnergy[1], energyLimit[1];", actualEnergyOverflowResult.getMessage());
    assertNull(actualEnergyOverflowResult.getCause());
    assertEquals(0, actualEnergyOverflowResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#invalidCodeException()}
   */
  @Test
  public void testExceptionInvalidCodeException() {
    // Arrange and Act
    Program.InvalidCodeException actualInvalidCodeExceptionResult = Program.Exception.invalidCodeException();

    // Assert
    assertEquals("invalid code: must not begin with 0xef", actualInvalidCodeExceptionResult.getLocalizedMessage());
    assertEquals("invalid code: must not begin with 0xef", actualInvalidCodeExceptionResult.getMessage());
    assertNull(actualInvalidCodeExceptionResult.getCause());
    assertEquals(0, actualInvalidCodeExceptionResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#invalidOpCode(byte[])}
   */
  @Test
  public void testExceptionInvalidOpCode() throws UnsupportedEncodingException {
    // Arrange and Act
    Program.IllegalOperationException actualInvalidOpCodeResult = Program.Exception
        .invalidOpCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getMessage());
    assertNull(actualInvalidOpCodeResult.getCause());
    assertEquals(0, actualInvalidOpCodeResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#memoryOverflow(int)}
   */
  @Test
  public void testExceptionMemoryOverflow() {
    // Arrange and Act
    Program.OutOfMemoryException actualMemoryOverflowResult = Program.Exception.memoryOverflow(1);

    // Assert
    assertEquals("Out of Memory when 'ADD' operation executing", actualMemoryOverflowResult.getLocalizedMessage());
    assertEquals("Out of Memory when 'ADD' operation executing", actualMemoryOverflowResult.getMessage());
    assertNull(actualMemoryOverflowResult.getCause());
    assertEquals(0, actualMemoryOverflowResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.Exception#notEnoughSpendEnergy(String, long, long)}
   */
  @Test
  public void testExceptionNotEnoughSpendEnergy() {
    // Arrange and Act
    Program.OutOfEnergyException actualNotEnoughSpendEnergyResult = Program.Exception.notEnoughSpendEnergy("Hint", 1L,
        1L);

    // Assert
    assertEquals("Not enough energy for 'Hint' executing: needEnergy[1], leftEnergy[1];",
        actualNotEnoughSpendEnergyResult.getLocalizedMessage());
    assertEquals("Not enough energy for 'Hint' executing: needEnergy[1], leftEnergy[1];",
        actualNotEnoughSpendEnergyResult.getMessage());
    assertNull(actualNotEnoughSpendEnergyResult.getCause());
    assertEquals(0, actualNotEnoughSpendEnergyResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#notEnoughStorage()}
   */
  @Test
  public void testExceptionNotEnoughStorage() {
    // Arrange and Act
    Program.OutOfStorageException actualNotEnoughStorageResult = Program.Exception.notEnoughStorage();

    // Assert
    assertEquals("Not enough ContractState resource", actualNotEnoughStorageResult.getLocalizedMessage());
    assertEquals("Not enough ContractState resource", actualNotEnoughStorageResult.getMessage());
    assertNull(actualNotEnoughStorageResult.getCause());
    assertEquals(0, actualNotEnoughStorageResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#notEnoughTime(String)}
   */
  @Test
  public void testExceptionNotEnoughTime() {
    // Arrange and Act
    Program.OutOfTimeException actualNotEnoughTimeResult = Program.Exception.notEnoughTime("Op");

    // Assert
    assertEquals("CPU timeout for 'Op' operation executing", actualNotEnoughTimeResult.getLocalizedMessage());
    assertEquals("CPU timeout for 'Op' operation executing", actualNotEnoughTimeResult.getMessage());
    assertNull(actualNotEnoughTimeResult.getCause());
    assertEquals(0, actualNotEnoughTimeResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program.Exception#tooSmallStack(int, int)}
   */
  @Test
  public void testExceptionTooSmallStack() {
    // Arrange and Act
    Program.StackTooSmallException actualTooSmallStackResult = Program.Exception.tooSmallStack(3, 3);

    // Assert
    assertEquals("Expected stack size 3 but actual 3;", actualTooSmallStackResult.getLocalizedMessage());
    assertEquals("Expected stack size 3 but actual 3;", actualTooSmallStackResult.getMessage());
    assertNull(actualTooSmallStackResult.getCause());
    assertEquals(0, actualTooSmallStackResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program#formatBinData(byte[], int)}
   */
  @Test
  public void testFormatBinData() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("1:      4158415841584158\n", Program.formatBinData("AXAXAXAX".getBytes("UTF-8"), 1));
    assertEquals("ffffffef:4158415841584158\n", Program.formatBinData("AXAXAXAX".getBytes("UTF-8"), -17));
  }

  /**
   * Method under test: {@link Program#getRootTransactionId()}
   */
  @Test
  public void testGetRootTransactionId() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.setRootTransactionId("AXAXAXAX".getBytes("UTF-8"));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    byte[] actualRootTransactionId = program.getRootTransactionId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRootTransactionId);
  }

  /**
   * Method under test:
   * {@link Program.IllegalOperationException#IllegalOperationException(String, Object[])}
   */
  @Test
  public void testIllegalOperationExceptionNewIllegalOperationException() {
    // Arrange and Act
    Program.IllegalOperationException actualIllegalOperationException = new Program.IllegalOperationException(
        "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualIllegalOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualIllegalOperationException.getMessage());
    assertNull(actualIllegalOperationException.getCause());
    assertEquals(0, actualIllegalOperationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.InvalidCodeException#InvalidCodeException(String)}
   */
  @Test
  public void testInvalidCodeExceptionNewInvalidCodeException() {
    // Arrange and Act
    Program.InvalidCodeException actualInvalidCodeException = new Program.InvalidCodeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidCodeException.getMessage());
    assertNull(actualInvalidCodeException.getCause());
    assertEquals(0, actualInvalidCodeException.getSuppressed().length);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Program.JVMStackOverFlowException}
   */
  @Test
  public void testJVMStackOverFlowExceptionNewJVMStackOverFlowException() {
    // Arrange and Act
    Program.JVMStackOverFlowException actualJvmStackOverFlowException = new Program.JVMStackOverFlowException();

    // Assert
    assertEquals("StackOverflowError:  exceed default JVM stack size!", actualJvmStackOverFlowException.getMessage());
    assertNull(actualJvmStackOverFlowException.getCause());
    assertEquals(0, actualJvmStackOverFlowException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.OutOfEnergyException#OutOfEnergyException(String, Object[])}
   */
  @Test
  public void testOutOfEnergyExceptionNewOutOfEnergyException() {
    // Arrange and Act
    Program.OutOfEnergyException actualOutOfEnergyException = new Program.OutOfEnergyException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfEnergyException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfEnergyException.getMessage());
    assertNull(actualOutOfEnergyException.getCause());
    assertEquals(0, actualOutOfEnergyException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.OutOfMemoryException#OutOfMemoryException(String, Object[])}
   */
  @Test
  public void testOutOfMemoryExceptionNewOutOfMemoryException() {
    // Arrange and Act
    Program.OutOfMemoryException actualOutOfMemoryException = new Program.OutOfMemoryException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfMemoryException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfMemoryException.getMessage());
    assertNull(actualOutOfMemoryException.getCause());
    assertEquals(0, actualOutOfMemoryException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.OutOfStorageException#OutOfStorageException(String, Object[])}
   */
  @Test
  public void testOutOfStorageExceptionNewOutOfStorageException() {
    // Arrange and Act
    Program.OutOfStorageException actualOutOfStorageException = new Program.OutOfStorageException("An error occurred",
        "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfStorageException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfStorageException.getMessage());
    assertNull(actualOutOfStorageException.getCause());
    assertEquals(0, actualOutOfStorageException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.OutOfTimeException#OutOfTimeException(String, Object[])}
   */
  @Test
  public void testOutOfTimeExceptionNewOutOfTimeException() {
    // Arrange and Act
    Program.OutOfTimeException actualOutOfTimeException = new Program.OutOfTimeException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualOutOfTimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualOutOfTimeException.getMessage());
    assertNull(actualOutOfTimeException.getCause());
    assertEquals(0, actualOutOfTimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.PrecompiledContractException#PrecompiledContractException(String, Object[])}
   */
  @Test
  public void testPrecompiledContractExceptionNewPrecompiledContractException() {
    // Arrange and Act
    Program.PrecompiledContractException actualPrecompiledContractException = new Program.PrecompiledContractException(
        "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualPrecompiledContractException.getLocalizedMessage());
    assertEquals("An error occurred", actualPrecompiledContractException.getMessage());
    assertNull(actualPrecompiledContractException.getCause());
    assertEquals(0, actualPrecompiledContractException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.ReturnDataCopyIllegalBoundsException#ReturnDataCopyIllegalBoundsException(DataWord, DataWord, long)}
   */
  @Test
  public void testReturnDataCopyIllegalBoundsExceptionNewReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord off = DataWord.ZERO();

    // Act
    Program.ReturnDataCopyIllegalBoundsException actualReturnDataCopyIllegalBoundsException = new Program.ReturnDataCopyIllegalBoundsException(
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
   * Method under test: {@link Program#setRootTransactionId(byte[])}
   */
  @Test
  public void testSetRootTransactionId() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.setRootTransactionId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedRootTransactionId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRootTransactionId, program.getRootTransactionId());
  }

  /**
   * Method under test: {@link Program#setRootTransactionId(byte[])}
   */
  @Test
  public void testSetRootTransactionId2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.setRootTransactionId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedRootTransactionId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRootTransactionId, program.getRootTransactionId());
  }

  /**
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  public void testGetProgramPrecompile() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new RepositoryImpl(StoreFactory.getInstance(), repository),
        3L, 3L, 3L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
            .getProgramPrecompile();

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  public void testGetProgramPrecompile2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new RepositoryImpl(StoreFactory.getInstance(), repository),
        3L, 3L, 3L);

    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getProgramPrecompile();

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  public void testGetProgramPrecompile3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new RepositoryImpl(StoreFactory.getInstance(), repository),
        3L, 3L, 3L);

    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(new byte[]{-17, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getProgramPrecompile();

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  public void testGetProgramPrecompile4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new RepositoryImpl(StoreFactory.getInstance(), repository),
        3L, 3L, 3L);

    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(
        new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, codeAddress, programInvoke,
        new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getProgramPrecompile();

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Method under test: {@link Program#getProgramPrecompile()}
   */
  @Test
  public void testGetProgramPrecompile5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{3, 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new RepositoryImpl(StoreFactory.getInstance(), repository),
        3L, 3L, 3L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramPrecompile actualProgramPrecompile = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
            .getProgramPrecompile();

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertFalse(actualProgramPrecompile.hasJumpDest(1));
  }

  /**
   * Method under test: {@link Program#getCallDeep()}
   */
  @Test
  public void testGetCallDeep() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCallDeep());
  }

  /**
   * Method under test: {@link Program#getCallDeep()}
   */
  @Test
  public void testGetCallDeep2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(0,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCallDeep());
  }

  /**
   * Method under test: {@link Program#getCallDeep()}
   */
  @Test
  public void testGetCallDeep3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0, program.getCallDeep());
  }

  /**
   * Method under test: {@link Program#getStorageDiff()}
   */
  @Test
  public void testGetStorageDiff() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertTrue(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getStorageDiff().isEmpty());
  }

  /**
   * Method under test: {@link Program#getStorageDiff()}
   */
  @Test
  public void testGetStorageDiff2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertTrue(program.getStorageDiff().isEmpty());
  }

  /**
   * Method under test: {@link Program#getOp(int)}
   */
  @Test
  public void testGetOp() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals('X',
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getOp(1));
  }

  /**
   * Method under test: {@link Program#getOp(int)}
   */
  @Test
  public void testGetOp2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals((byte) 0, (new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getOp(1));
  }

  /**
   * Method under test: {@link Program#getOp(int)}
   */
  @Test
  public void testGetOp3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals('X', program.getOp(1));
  }

  /**
   * Method under test: {@link Program#getCurrentOp()}
   */
  @Test
  public void testGetCurrentOp() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals('A',
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCurrentOp());
  }

  /**
   * Method under test: {@link Program#getCurrentOp()}
   */
  @Test
  public void testGetCurrentOp2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals((byte) 0,
        (new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .getCurrentOp());
  }

  /**
   * Method under test: {@link Program#getCurrentOp()}
   */
  @Test
  public void testGetCurrentOp3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals('A', program.getCurrentOp());
  }

  /**
   * Method under test: {@link Program#getCurrentOpIntValue()}
   */
  @Test
  public void testGetCurrentOpIntValue() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(65,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCurrentOpIntValue());
  }

  /**
   * Method under test: {@link Program#getCurrentOpIntValue()}
   */
  @Test
  public void testGetCurrentOpIntValue2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0,
        (new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .getCurrentOpIntValue());
  }

  /**
   * Method under test: {@link Program#getCurrentOpIntValue()}
   */
  @Test
  public void testGetCurrentOpIntValue3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(65, program.getCurrentOpIntValue());
  }

  /**
   * Method under test: {@link Program#stackPush(DataWord)}
   */
  @Test
  public void testStackPush() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord stackWord = DataWord.ZERO();

    // Act
    program.stackPush(stackWord);

    // Assert that nothing has changed
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertSame(stackWord, stack.get(0));
  }

  /**
   * Method under test: {@link Program#stackPush(DataWord)}
   */
  @Test
  public void testStackPush2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord stackWord = DataWord.ZERO();

    // Act
    program.stackPush(stackWord);

    // Assert that nothing has changed
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertSame(stackWord, stack.get(0));
  }

  /**
   * Method under test: {@link Program#stackPush(byte[])}
   */
  @Test
  public void testStackPush3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Method under test: {@link Program#stackPush(byte[])}
   */
  @Test
  public void testStackPush4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

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
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Method under test: {@link Program#stackPushZero()}
   */
  @Test
  public void testStackPushZero() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.stackPushZero();

    // Assert
    assertEquals(1, program.getStack().size());
  }

  /**
   * Method under test: {@link Program#stackPushZero()}
   */
  @Test
  public void testStackPushZero2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.stackPushZero();

    // Assert
    assertEquals(1, program.getStack().size());
  }

  /**
   * Method under test: {@link Program#stackPushOne()}
   */
  @Test
  public void testStackPushOne() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#stackPushOne()}
   */
  @Test
  public void testStackPushOne2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

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
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#setPC(int)}
   */
  @Test
  public void testSetPC() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.setPC(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link Program#setPC(int)}
   */
  @Test
  public void testSetPC2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.setPC(1);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link Program#setPC(int)}
   */
  @Test
  public void testSetPC3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.setPC(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link Program#setPC(DataWord)}
   */
  @Test
  public void testSetPC4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.setPC(DataWord.ZERO());

    // Assert
    assertFalse(program.isStopped());
  }

  /**
   * Method under test: {@link Program#setPC(DataWord)}
   */
  @Test
  public void testSetPC5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.setPC(DataWord.ZERO());

    // Assert
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link Program#setPC(DataWord)}
   */
  @Test
  public void testSetPC6() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.setPC(DataWord.ZERO());

    // Assert
    assertFalse(program.isStopped());
  }

  /**
   * Method under test: {@link Program#setHReturn(byte[])}
   */
  @Test
  public void testSetHReturn() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    byte[] buff = "AXAXAXAX".getBytes("UTF-8");

    // Act
    program.setHReturn(buff);

    // Assert
    assertSame(buff, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#setHReturn(byte[])}
   */
  @Test
  public void testSetHReturn2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    byte[] buff = "AXAXAXAX".getBytes("UTF-8");

    // Act
    program.setHReturn(buff);

    // Assert
    assertSame(buff, program.getResult().getHReturn());
  }

  /**
   * Method under test:
   * {@link Program.StackTooLargeException#StackTooLargeException(Program, String)}
   */
  @Test
  public void testStackTooLargeExceptionNewStackTooLargeException()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act
    Program.StackTooLargeException actualStackTooLargeException = (new Program(ops, codeAddress, programInvoke,
        new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualStackTooLargeException.getMessage());
    assertNull(actualStackTooLargeException.getCause());
    assertEquals(0, actualStackTooLargeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link Program.StackTooSmallException#StackTooSmallException(String, Object[])}
   */
  @Test
  public void testStackTooSmallExceptionNewStackTooSmallException() {
    // Arrange and Act
    Program.StackTooSmallException actualStackTooSmallException = new Program.StackTooSmallException(
        "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualStackTooSmallException.getLocalizedMessage());
    assertEquals("An error occurred", actualStackTooSmallException.getMessage());
    assertNull(actualStackTooSmallException.getCause());
    assertEquals(0, actualStackTooSmallException.getSuppressed().length);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Program.StaticCallModificationException}
   */
  @Test
  public void testStaticCallModificationExceptionNewStaticCallModificationException() {
    // Arrange and Act
    Program.StaticCallModificationException actualStaticCallModificationException = new Program.StaticCallModificationException();

    // Assert
    assertEquals("Attempt to call a state modifying opcode inside STATICCALL",
        actualStaticCallModificationException.getMessage());
    assertNull(actualStaticCallModificationException.getCause());
    assertEquals(0, actualStaticCallModificationException.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program#step()}
   */
  @Test
  public void testStep() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.step();

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link Program#step()}
   */
  @Test
  public void testStep2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.step();

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link Program#step()}
   */
  @Test
  public void testStep3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.step();

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link Program#sweep(int)}
   */
  @Test
  public void testSweep() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    byte[] actualSweepResult = program.sweep(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
    assertArrayEquals(new byte[]{'A'}, actualSweepResult);
  }

  /**
   * Method under test: {@link Program#sweep(int)}
   */
  @Test
  public void testSweep2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    byte[] actualSweepResult = program.sweep(1);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
    assertArrayEquals(new byte[]{0}, actualSweepResult);
  }

  /**
   * Method under test: {@link Program#sweep(int)}
   */
  @Test
  public void testSweep3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    byte[] actualSweepResult = program.sweep(1);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(88, program.getCurrentOpIntValue());
    assertFalse(program.isStopped());
    assertEquals('X', program.getCurrentOp());
    assertArrayEquals(new byte[]{'A'}, actualSweepResult);
  }

  /**
   * Method under test: {@link Program#stackPop()}
   */
  @Test
  public void testStackPop() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualStackPopResult = program.stackPop();

    // Assert
    assertTrue(program.getStack().isEmpty());
    assertEquals(energy, actualStackPopResult);
  }

  /**
   * Method under test:
   * {@link Program.TransferException#TransferException(String, Object[])}
   */
  @Test
  public void testTransferExceptionNewTransferException() {
    // Arrange and Act
    Program.TransferException actualTransferException = new Program.TransferException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualTransferException.getLocalizedMessage());
    assertEquals("An error occurred", actualTransferException.getMessage());
    assertNull(actualTransferException.getCause());
    assertEquals(0, actualTransferException.getSuppressed().length);
  }

  /**
   * Method under test: {@link Program#verifyStackSize(int)}
   */
  @Test
  public void testVerifyStackSize() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).verifyStackSize(0);

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#verifyStackOverflow(int, int)}
   */
  @Test
  public void testVerifyStackOverflow() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .verifyStackOverflow(1, Integer.MIN_VALUE));
  }

  /**
   * Method under test: {@link Program#getMemSize()}
   */
  @Test
  public void testGetMemSize() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getMemSize());
  }

  /**
   * Method under test: {@link Program#getMemSize()}
   */
  @Test
  public void testGetMemSize2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0, program.getMemSize());
  }

  /**
   * Method under test: {@link Program#memorySave(int, int, byte[])}
   */
  @Test
  public void testMemorySave() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.memorySave(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySave(int, int, byte[])}
   */
  @Test
  public void testMemorySave2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.memorySave(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySave(int, int, byte[])}
   */
  @Test
  public void testMemorySave3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.memorySave(1, 0, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySave(int, byte[])}
   */
  @Test
  public void testMemorySave4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.memorySave(1, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySave(int, byte[])}
   */
  @Test
  public void testMemorySave5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.memorySave(1, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySave(int, byte[])}
   */
  @Test
  public void testMemorySave6() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.memorySave(1, new byte[]{});

    // Assert that nothing has changed
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#memorySave(DataWord, DataWord)}
   */
  @Test
  public void testMemorySave7() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord addrB = DataWord.ZERO();

    // Act
    program.memorySave(addrB, DataWord.ZERO());

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySave(DataWord, DataWord)}
   */
  @Test
  public void testMemorySave8() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord addrB = DataWord.ZERO();

    // Act
    program.memorySave(addrB, DataWord.ZERO());

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memorySaveLimited(int, byte[], int)}
   */
  @Test
  public void testMemorySaveLimited() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.memorySaveLimited(1, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#memorySaveLimited(int, byte[], int)}
   */
  @Test
  public void testMemorySaveLimited2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).memorySaveLimited(1, new byte[]{}, 3);

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#memoryExpand(DataWord, DataWord)}
   */
  @Test
  public void testMemoryExpand() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord outDataOffs = DataWord.ZERO();

    // Act
    program.memoryExpand(outDataOffs, DataWord.ZERO());

    // Assert that nothing has changed
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#memoryExpand(DataWord, DataWord)}
   */
  @Test
  public void testMemoryExpand2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord outDataOffs = DataWord.ZERO();

    // Act
    program.memoryExpand(outDataOffs, DataWord.ZERO());

    // Assert that nothing has changed
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#memoryExpand(DataWord, DataWord)}
   */
  @Test
  public void testMemoryExpand3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord outDataOffs = DataWord.ZERO();

    // Act
    program.memoryExpand(outDataOffs, DataWord.of((byte) 'A'));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    byte[] memory = program.getMemory();
    assertEquals((byte) 0, memory[0]);
    assertEquals((byte) 0, memory[1]);
    assertEquals((byte) 0, memory[10]);
    assertEquals((byte) 0, memory[11]);
    assertEquals((byte) 0, memory[12]);
    assertEquals((byte) 0, memory[13]);
    assertEquals((byte) 0, memory[14]);
    assertEquals((byte) 0, memory[15]);
    assertEquals((byte) 0, memory[17]);
    assertEquals((byte) 0, memory[18]);
    assertEquals((byte) 0, memory[19]);
    assertEquals((byte) 0, memory[2]);
    assertEquals((byte) 0, memory[20]);
    assertEquals((byte) 0, memory[21]);
    assertEquals((byte) 0, memory[22]);
    assertEquals((byte) 0, memory[23]);
    assertEquals((byte) 0, memory[24]);
    assertEquals((byte) 0, memory[3]);
    assertEquals((byte) 0, memory[4]);
    assertEquals((byte) 0, memory[5]);
    assertEquals((byte) 0, memory[6]);
    assertEquals((byte) 0, memory[7]);
    assertEquals((byte) 0, memory[71]);
    assertEquals((byte) 0, memory[72]);
    assertEquals((byte) 0, memory[73]);
    assertEquals((byte) 0, memory[74]);
    assertEquals((byte) 0, memory[75]);
    assertEquals((byte) 0, memory[76]);
    assertEquals((byte) 0, memory[77]);
    assertEquals((byte) 0, memory[78]);
    assertEquals((byte) 0, memory[79]);
    assertEquals((byte) 0, memory[8]);
    assertEquals((byte) 0, memory[80]);
    assertEquals((byte) 0, memory[81]);
    assertEquals((byte) 0, memory[82]);
    assertEquals((byte) 0, memory[83]);
    assertEquals((byte) 0, memory[84]);
    assertEquals((byte) 0, memory[85]);
    assertEquals((byte) 0, memory[86]);
    assertEquals((byte) 0, memory[87]);
    assertEquals((byte) 0, memory[88]);
    assertEquals((byte) 0, memory[89]);
    assertEquals((byte) 0, memory[9]);
    assertEquals((byte) 0, memory[90]);
    assertEquals((byte) 0, memory[91]);
    assertEquals((byte) 0, memory[92]);
    assertEquals((byte) 0, memory[93]);
    assertEquals((byte) 0, memory[94]);
    assertEquals((byte) 0, memory[95]);
    assertEquals((byte) 0, memory[Short.SIZE]);
    assertEquals(96, program.getMemSize());
    assertEquals(96, memory.length);
  }

  /**
   * Method under test: {@link Program#memoryLoad(int)}
   */
  @Test
  public void testMemoryLoad() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(1);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    DataWord dataWord = actualMemoryLoadResult.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, actualMemoryLoadResult);
    assertEquals(Double.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memoryLoad(int)}
   */
  @Test
  public void testMemoryLoad2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(1);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    DataWord dataWord = actualMemoryLoadResult.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, actualMemoryLoadResult);
    assertEquals(Double.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memoryLoad(DataWord)}
   */
  @Test
  public void testMemoryLoad3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord addr = DataWord.ZERO();

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(addr);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(addr, actualMemoryLoadResult);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memoryLoad(DataWord)}
   */
  @Test
  public void testMemoryLoad4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord addr = DataWord.ZERO();

    // Act
    DataWord actualMemoryLoadResult = program.memoryLoad(addr);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(addr, actualMemoryLoadResult);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memoryChunk(int, int)}
   */
  @Test
  public void testMemoryChunk() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    byte[] actualMemoryChunkResult = program.memoryChunk(2, 3);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 0, 0}, actualMemoryChunkResult);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memoryChunk(int, int)}
   */
  @Test
  public void testMemoryChunk2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    byte[] actualMemoryChunkResult = program.memoryChunk(2, 3);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{0, 0, 0}, actualMemoryChunkResult);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#memoryChunk(int, int)}
   */
  @Test
  public void testMemoryChunk3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    byte[] actualMemoryChunkResult = program.memoryChunk(2, 0);

    // Assert
    assertEquals(0, program.getMemSize());
    assertEquals(0, actualMemoryChunkResult.length);
  }

  /**
   * Method under test: {@link Program#allocateMemory(int, int)}
   */
  @Test
  public void testAllocateMemory() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.allocateMemory(2, 3);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#allocateMemory(int, int)}
   */
  @Test
  public void testAllocateMemory2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.allocateMemory(2, 3);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link Program#allocateMemory(int, int)}
   */
  @Test
  public void testAllocateMemory3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.allocateMemory(-17, 3);

    // Assert that nothing has changed
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#allocateMemory(int, int)}
   */
  @Test
  public void testAllocateMemory4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.allocateMemory(2, 0);

    // Assert that nothing has changed
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#suicide(DataWord)}
   */
  @Test
  public void testSuicide() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act and Assert
    assertThrows(Program.BytecodeExecutionException.class, () -> program.suicide(DataWord.ZERO()));
    verify(dataWord).toTronAddress();
    verify(accountCapsule).getAssetMapV2();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getBalance(isA(byte[].class));
  }

  /**
   * Method under test: {@link Program#suicide(DataWord)}
   */
  @Test
  public void testSuicide2() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, result.getDeleteAccounts().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(getResult.isRejected());
    assertTrue(getResult.getTokenInfo().isEmpty());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#suicide(DataWord)}
   */
  @Test
  public void testSuicide3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenReturn(null);
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, result.getDeleteAccounts().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(getResult.isRejected());
    assertTrue(getResult.getTokenInfo().isEmpty());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#suicide(DataWord)}
   */
  @Test
  public void testSuicide4() throws UnsupportedEncodingException {
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
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    program.suicide(DataWord.ZERO());

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, result.getDeleteAccounts().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertFalse(getResult.isRejected());
    assertTrue(getResult.getTokenInfo().isEmpty());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
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
   * Method under test: {@link Program#canSuicide()}
   */
  @Test
  public void testCanSuicide() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertTrue(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).canSuicide());
  }

  /**
   * Method under test: {@link Program#canSuicide()}
   */
  @Test
  public void testCanSuicide2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertTrue(program.canSuicide());
  }

  /**
   * Method under test:
   * {@link Program#createContract(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testCreateContract() throws UnsupportedEncodingException, ContractValidateException {
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
    byte[] msgData = "A@A@A@A@".getBytes("UTF-8");
    DataWord lastHash = DataWord.ZERO();
    DataWord coinbase = DataWord.ZERO();
    DataWord timestamp = DataWord.ZERO();
    DataWord number = DataWord.ZERO();
    DataWord difficulty = DataWord.ZERO();
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, balance, callValue, tokenValue,
        tokenId, msgData, lastHash, coinbase, timestamp, number, difficulty,
        new ContractState(new ProgramInvokeMockImpl()), Double.SIZE, true, true, 64L, 64L, 64L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord value = DataWord.ZERO();
    DataWord memStart = DataWord.ZERO();

    // Act
    program.createContract(value, memStart, DataWord.ZERO());

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(address, stack.get(0));
  }

  /**
   * Method under test:
   * {@link Program#refundEnergyAfterVM(DataWord, ProgramResult)}
   */
  @Test
  public void testRefundEnergyAfterVM() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord energyLimit = DataWord.ZERO();

    // Act
    program.refundEnergyAfterVM(energyLimit, ProgramResult.createEmpty());

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#callToAddress(MessageCall)}
   */
  @Test
  public void testCallToAddress() throws UnsupportedEncodingException, ContractValidateException {
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
    byte[] msgData = "A@A@A@A@".getBytes("UTF-8");
    DataWord lastHash = DataWord.ZERO();
    DataWord coinbase = DataWord.ZERO();
    DataWord timestamp = DataWord.ZERO();
    DataWord number = DataWord.ZERO();
    DataWord difficulty = DataWord.ZERO();
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, balance, callValue, tokenValue,
        tokenId, msgData, lastHash, coinbase, timestamp, number, difficulty,
        new ContractState(new ProgramInvokeMockImpl()), Double.SIZE, true, true, 64L, 64L, 64L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord energy = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();

    // Act
    program.callToAddress(new MessageCall(1, energy, null, endowment, inDataOffs, inDataSize, DataWord.ZERO(), true));

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(address, stack.get(0));
  }

  /**
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  public void testSpendEnergy() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.spendEnergy(42L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", energyLimitLeft.toHexString());
    assertEquals("08", energyLimitLeft.toPrefixString());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(42L, program.getResult().getEnergyUsed());
    assertEquals(8L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('\b', clonedData[31]);
    assertEquals('\b', data[31]);
    assertEquals('\b', last20Bytes[19]);
    assertEquals('\b', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'\b'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  public void testSpendEnergy2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A*A*A*A*".getBytes("UTF-8");
    byte[] origin = "A*A*A*A*".getBytes("UTF-8");
    byte[] caller = "A*A*A*A*".getBytes("UTF-8");
    byte[] msgData = "A*A*A*A*".getBytes("UTF-8");
    byte[] lastHash = "A*A*A*A*".getBytes("UTF-8");
    byte[] coinbase = "A*A*A*A*".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 42L, new ContractState(new ProgramInvokeMockImpl()), 42L, 42L, 42L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.spendEnergy(42L, "Op Name");

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(42L, program.getResult().getEnergyUsed());
  }

  /**
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  public void testSpendEnergy3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.spendEnergy(42L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", energyLimitLeft.toHexString());
    assertEquals("08", energyLimitLeft.toPrefixString());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(42L, program.getResult().getEnergyUsed());
    assertEquals(8L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('\b', clonedData[31]);
    assertEquals('\b', data[31]);
    assertEquals('\b', last20Bytes[19]);
    assertEquals('\b', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'\b'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#spendEnergy(long, String)}
   */
  @Test
  public void testSpendEnergy4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .spendEnergy(Long.MAX_VALUE, "Op Name"));
  }

  /**
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  public void testSpendEnergyWithPenalty() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.spendEnergyWithPenalty(1L, 1L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000031", energyLimitLeft.toHexString());
    assertEquals("31", energyLimitLeft.toPrefixString());
    ProgramResult result = program.getResult();
    assertEquals(1L, result.getEnergyPenaltyTotal());
    assertEquals(1L, result.getEnergyUsed());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(49L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('1', clonedData[31]);
    assertEquals('1', data[31]);
    assertEquals('1', last20Bytes[19]);
    assertEquals('1', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'1'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  public void testSpendEnergyWithPenalty2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L,
        1L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.spendEnergyWithPenalty(1L, 1L, "Op Name");

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
    ProgramResult result = program.getResult();
    assertEquals(1L, result.getEnergyPenaltyTotal());
    assertEquals(1L, result.getEnergyUsed());
  }

  /**
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  public void testSpendEnergyWithPenalty3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.spendEnergyWithPenalty(1L, 1L, "Op Name");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000031", energyLimitLeft.toHexString());
    assertEquals("31", energyLimitLeft.toPrefixString());
    ProgramResult result = program.getResult();
    assertEquals(1L, result.getEnergyPenaltyTotal());
    assertEquals(1L, result.getEnergyUsed());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(49L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('1', clonedData[31]);
    assertEquals('1', data[31]);
    assertEquals('1', last20Bytes[19]);
    assertEquals('1', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'1'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#spendEnergyWithPenalty(long, long, String)}
   */
  @Test
  public void testSpendEnergyWithPenalty4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class,
        () -> (new Program(ops, codeAddress, programInvoke,
            new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).spendEnergyWithPenalty(Long.MAX_VALUE, 1L,
                    "Op Name"));
  }

  /**
   * Method under test: {@link Program#checkCPUTimeLimit(String)}
   */
  @Test
  public void testCheckCPUTimeLimit() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getVmShouldEndInUs()).thenReturn(Long.MAX_VALUE);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).checkCPUTimeLimit("Op Name");

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).getVmShouldEndInUs();
  }

  /**
   * Method under test: {@link Program#spendAllEnergy()}
   */
  @Test
  public void testSpendAllEnergy() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.spendAllEnergy();

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, program.getResult().getEnergyUsed());
  }

  /**
   * Method under test: {@link Program#spendAllEnergy()}
   */
  @Test
  public void testSpendAllEnergy2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 8L, new ContractState(new ProgramInvokeMockImpl()), 8L, 8L, 8L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.spendAllEnergy();

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(8L, program.getResult().getEnergyUsed());
  }

  /**
   * Method under test: {@link Program#spendAllEnergy()}
   */
  @Test
  public void testSpendAllEnergy3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.spendAllEnergy();

    // Assert
    assertEquals(0L, program.getEnergylimitLeftLong());
    assertEquals(50L, program.getResult().getEnergyUsed());
  }

  /**
   * Method under test: {@link Program#refundEnergy(long, String)}
   */
  @Test
  public void testRefundEnergy() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.refundEnergy(42L, "Cause");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("000000000000000000000000000000000000000000000000000000000000005c", energyLimitLeft.toHexString());
    assertEquals("5c", energyLimitLeft.toPrefixString());
    assertEquals(-42L, program.getResult().getEnergyUsed());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(92L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('\\', clonedData[31]);
    assertEquals('\\', data[31]);
    assertEquals('\\', last20Bytes[19]);
    assertEquals('\\', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'\\'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#refundEnergy(long, String)}
   */
  @Test
  public void testRefundEnergy2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new ContractState(new ProgramInvokeMockImpl()), 3L, 3L,
        3L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.refundEnergy(42L, "Cause");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002d", energyLimitLeft.toHexString());
    assertEquals("2d", energyLimitLeft.toPrefixString());
    assertEquals(-42L, program.getResult().getEnergyUsed());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(45L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('-', clonedData[31]);
    assertEquals('-', data[31]);
    assertEquals('-', last20Bytes[19]);
    assertEquals('-', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'-'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#refundEnergy(long, String)}
   */
  @Test
  public void testRefundEnergy3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.refundEnergy(42L, "Cause");

    // Assert
    DataWord energyLimitLeft = program.getEnergyLimitLeft();
    assertEquals("000000000000000000000000000000000000000000000000000000000000005c", energyLimitLeft.toHexString());
    assertEquals("5c", energyLimitLeft.toPrefixString());
    assertEquals(-42L, program.getResult().getEnergyUsed());
    byte[] last20Bytes = energyLimitLeft.getLast20Bytes();
    assertEquals(20, last20Bytes.length);
    byte[] toTronAddressResult = energyLimitLeft.toTronAddress();
    assertEquals(21, toTronAddressResult.length);
    assertEquals(92L, program.getEnergylimitLeftLong());
    byte[] clonedData = energyLimitLeft.getClonedData();
    assertEquals(Integer.SIZE, clonedData.length);
    byte[] data = energyLimitLeft.getData();
    assertEquals(Integer.SIZE, data.length);
    assertEquals('\\', clonedData[31]);
    assertEquals('\\', data[31]);
    assertEquals('\\', last20Bytes[19]);
    assertEquals('\\', toTronAddressResult[20]);
    assertArrayEquals(new byte[]{'\\'}, energyLimitLeft.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link Program#storageSave(DataWord, DataWord)}
   */
  @Test
  public void testStorageSave() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord word1 = DataWord.ZERO();

    // Act
    program.storageSave(word1, DataWord.ZERO());

    // Assert
    assertEquals(1, program.getStorageDiff().size());
    Protocol.Transaction.Result instance = program.getResult().getRet().getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(2, descriptorForType.getEnumTypes().size());
    assertTrue(instance.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(instance, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Program#storageSave(DataWord, DataWord)}
   */
  @Test
  public void testStorageSave2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord word1 = DataWord.ZERO();

    // Act
    program.storageSave(word1, DataWord.ZERO());

    // Assert
    assertEquals(1, program.getStorageDiff().size());
    Protocol.Transaction.Result instance = program.getResult().getRet().getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(2, descriptorForType.getEnumTypes().size());
    assertTrue(instance.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals(instance, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Program#getCode()}
   */
  @Test
  public void testGetCode() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act
    byte[] actualCode = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCode();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Method under test: {@link Program#getCode()}
   */
  @Test
  public void testGetCode2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    byte[] actualCode = program.getCode();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Method under test: {@link Program#getCodeAt(DataWord)}
   */
  @Test
  public void testGetCodeAt() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 42L, 42L, 42L,
        1L, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 10L, 21L,
        new RepositoryImpl(StoreFactory.getInstance(), repository), 21L, 21L, 21L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    byte[] actualCodeAt = program.getCodeAt(DataWord.ZERO());

    // Assert
    verify(repository).getCode(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCodeAt);
  }

  /**
   * Method under test: {@link Program#getCodeHashAt(DataWord)}
   */
  @Test
  public void testGetCodeHashAt() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 42L, 42L, 42L,
        1L, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 10L, 21L,
        new RepositoryImpl(StoreFactory.getInstance(), repository), 21L, 21L, 21L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    byte[] actualCodeHashAt = program.getCodeHashAt(DataWord.ZERO());

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getCode(isA(byte[].class));
    verify(repository).getContract(isA(byte[].class));
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualCodeHashAt);
  }

  /**
   * Method under test: {@link Program#getCodeHashAt(DataWord)}
   */
  @Test
  public void testGetCodeHashAt2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    when(repository.getCode(Mockito.<byte[]>any()))
        .thenThrow(
            (new Program(new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
                programInvoke,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    ProgramInvokeImpl programInvoke2 = new ProgramInvokeImpl(new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 42L, 42L, 42L,
        1L, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 10L, 21L,
        new RepositoryImpl(StoreFactory.getInstance(), repository), 21L, 21L, 21L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke2, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class, () -> program.getCodeHashAt(DataWord.ZERO()));
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getCode(isA(byte[].class));
    verify(repository).getContract(isA(byte[].class));
  }

  /**
   * Method under test: {@link Program#getCodeHash()}
   */
  @Test
  public void testGetCodeHash() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualCodeHash = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCodeHash();

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualCodeHash);
  }

  /**
   * Method under test: {@link Program#getCodeHash()}
   */
  @Test
  public void testGetCodeHash2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualCodeHash = (new Program(ops, null, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getCodeHash();

    // Assert
    verify(repository).getContract(isNull());
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualCodeHash);
  }

  /**
   * Method under test: {@link Program#getContextAddress()}
   */
  @Test
  public void testGetContextAddress() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getContextAddress());
  }

  /**
   * Method under test: {@link Program#getContextAddress()}
   */
  @Test
  public void testGetContextAddress2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    // Act and Assert
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getContextAddress());
  }

  /**
   * Method under test: {@link Program#getContextAddress()}
   */
  @Test
  public void testGetContextAddress3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        program.getContextAddress());
  }

  /**
   * Method under test: {@link Program#getContractAddress()}
   */
  @Test
  public void testGetContractAddress() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualContractAddress = program.getContractAddress();

    // Assert
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc",
        actualContractAddress.toHexString());
    assertEquals("41471f", actualContractAddress.toPrefixString());
    assertFalse(actualContractAddress.isNegative());
    assertFalse(actualContractAddress.isZero());
    DataWord expectedDataSize = actualContractAddress.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualContractAddress.getData();
    assertSame(data, actualContractAddress.getNoEndZeroesData());
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
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data);
  }

  /**
   * Method under test: {@link Program#getContractAddress()}
   */
  @Test
  public void testGetContractAddress2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualContractAddress = program.getContractAddress();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004120412041204120",
        actualContractAddress.toHexString());
    assertEquals("412041", actualContractAddress.toPrefixString());
    assertFalse(actualContractAddress.isNegative());
    assertFalse(actualContractAddress.isZero());
    DataWord expectedDifficulty = actualContractAddress.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualContractAddress.getData();
    assertSame(data, actualContractAddress.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "A A A A ".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualContractAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        actualContractAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        actualContractAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A',
        ' ', 'A', ' ', 'A', ' '}, actualContractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A',
        ' ', 'A', ' ', 'A', ' '}, data);
  }

  /**
   * Method under test: {@link Program#getContractAddress()}
   */
  @Test
  public void testGetContractAddress3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualContractAddress = program.getContractAddress();

    // Assert
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc",
        actualContractAddress.toHexString());
    assertEquals("41471f", actualContractAddress.toPrefixString());
    assertFalse(actualContractAddress.isNegative());
    assertFalse(actualContractAddress.isZero());
    DataWord expectedDataSize = actualContractAddress.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualContractAddress.getData();
    assertSame(data, actualContractAddress.getNoEndZeroesData());
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
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data);
  }

  /**
   * Method under test: {@link Program#getBlockHash(int)}
   */
  @Test
  public void testGetBlockHash() throws UnsupportedEncodingException, ContractValidateException {
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
    byte[] msgData = "A!A!A!A!".getBytes("UTF-8");
    DataWord lastHash = DataWord.ZERO();
    DataWord coinbase = DataWord.ZERO();
    DataWord timestamp = DataWord.ZERO();
    DataWord number = DataWord.ZERO();
    DataWord difficulty = DataWord.ZERO();
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, balance, callValue, tokenValue,
        tokenId, msgData, lastHash, coinbase, timestamp, number, difficulty,
        new ContractState(new ProgramInvokeMockImpl()), 33, true, true, 33L, 33L, 33L);

    // Act and Assert
    assertEquals(address,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getBlockHash(1));
  }

  /**
   * Method under test: {@link Program#getBalance(DataWord)}
   */
  @Test
  public void testGetBalance() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 42L, 42L, 42L,
        1L, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 10L, 21L,
        new RepositoryImpl(StoreFactory.getInstance(), repository), 21L, 21L, 21L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord address = DataWord.ZERO();

    // Act
    DataWord actualBalance = program.getBalance(address);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(address, actualBalance);
  }

  /**
   * Method under test: {@link Program#getRewardBalance(DataWord)}
   */
  @Test
  public void testGetRewardBalance() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord address = DataWord.ZERO();

    // Act and Assert
    assertEquals(address, program.getRewardBalance(address));
  }

  /**
   * Method under test: {@link Program#getRewardBalance(DataWord)}
   */
  @Test
  public void testGetRewardBalance2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord address = DataWord.ZERO();

    // Act and Assert
    assertEquals(address, program.getRewardBalance(address));
  }

  /**
   * Method under test: {@link Program#isContract(DataWord)}
   */
  @Test
  public void testIsContract() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 42L, 42L, 42L,
        1L, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21},
        new byte[]{'A', 21, 'A', 21, 'A', 21, 'A', 21}, 10L, 21L,
        new RepositoryImpl(StoreFactory.getInstance(), repository), 21L, 21L, 21L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualIsContractResult = program.isContract(DataWord.ZERO());

    // Assert
    verify(repository).getContract(isA(byte[].class));
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001",
        actualIsContractResult.toHexString());
    assertEquals("01", actualIsContractResult.toPrefixString());
    assertFalse(actualIsContractResult.isNegative());
    assertFalse(actualIsContractResult.isZero());
    byte[] data = actualIsContractResult.getData();
    assertSame(data, actualIsContractResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualIsContractResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualIsContractResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualIsContractResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualIsContractResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data);
  }

  /**
   * Method under test: {@link Program#isSRCandidate(DataWord)}
   */
  @Test
  public void testIsSRCandidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualIsSRCandidateResult = program.isSRCandidate(DataWord.ZERO());

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getWitness(isA(byte[].class));
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001",
        actualIsSRCandidateResult.toHexString());
    assertEquals("01", actualIsSRCandidateResult.toPrefixString());
    assertFalse(actualIsSRCandidateResult.isNegative());
    assertFalse(actualIsSRCandidateResult.isZero());
    byte[] data = actualIsSRCandidateResult.getData();
    assertSame(data, actualIsSRCandidateResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{1}, actualIsSRCandidateResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualIsSRCandidateResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualIsSRCandidateResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualIsSRCandidateResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data);
  }

  /**
   * Method under test: {@link Program#isSRCandidate(DataWord)}
   */
  @Test
  public void testIsSRCandidate2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getWitness(Mockito.<byte[]>any())).thenReturn(null);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    DataWord ZEROResult = DataWord.ZERO();
    when(programInvoke.getContractAddress()).thenReturn(ZEROResult);
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualIsSRCandidateResult = program.isSRCandidate(DataWord.ZERO());

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getWitness(isA(byte[].class));
    assertEquals(ZEROResult, actualIsSRCandidateResult);
  }

  /**
   * Method under test: {@link Program#getOriginAddress()}
   */
  @Test
  public void testGetOriginAddress() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualOriginAddress = program.getOriginAddress();

    // Assert
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", actualOriginAddress.toHexString());
    assertEquals("411397", actualOriginAddress.toPrefixString());
    assertFalse(actualOriginAddress.isNegative());
    assertFalse(actualOriginAddress.isZero());
    DataWord expectedDataSize = actualOriginAddress.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualOriginAddress.getData();
    assertSame(data, actualOriginAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, actualOriginAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, actualOriginAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data);
  }

  /**
   * Method under test: {@link Program#getOriginAddress()}
   */
  @Test
  public void testGetOriginAddress2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualOriginAddress = program.getOriginAddress();

    // Assert
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", actualOriginAddress.toHexString());
    assertEquals("411397", actualOriginAddress.toPrefixString());
    assertFalse(actualOriginAddress.isNegative());
    assertFalse(actualOriginAddress.isZero());
    DataWord expectedDataSize = actualOriginAddress.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualOriginAddress.getData();
    assertSame(data, actualOriginAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, actualOriginAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, actualOriginAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data);
  }

  /**
   * Method under test: {@link Program#getCallerAddress()}
   */
  @Test
  public void testGetCallerAddress() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualCallerAddress = program.getCallerAddress();

    // Assert
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", actualCallerAddress.toHexString());
    assertEquals("41885f", actualCallerAddress.toPrefixString());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualCallerAddress.isZero());
    DataWord expectedDataSize = actualCallerAddress.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualCallerAddress.getData();
    assertSame(data, actualCallerAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, actualCallerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, actualCallerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
  }

  /**
   * Method under test: {@link Program#getCallerAddress()}
   */
  @Test
  public void testGetCallerAddress2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualCallerAddress = program.getCallerAddress();

    // Assert
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", actualCallerAddress.toHexString());
    assertEquals("41885f", actualCallerAddress.toPrefixString());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualCallerAddress.isZero());
    DataWord expectedDataSize = actualCallerAddress.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualCallerAddress.getData();
    assertSame(data, actualCallerAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, actualCallerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, actualCallerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
  }

  /**
   * Method under test: {@link Program#getChainId()}
   */
  @Test
  public void testGetChainId() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    DataWord actualChainId = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getChainId();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    assertEquals("00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", actualChainId.toHexString());
    assertEquals("9afbf4", actualChainId.toPrefixString());
    assertFalse(actualChainId.isNegative());
    assertFalse(actualChainId.isZero());
    byte[] data = actualChainId.getData();
    assertSame(data, actualChainId.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27,
        'x', 'R', -72, 'U'}, actualChainId.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103,
        27, 'x', 'R', -72, 'U'}, actualChainId.toTronAddress());
    assertArrayEquals(new byte[]{-102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, actualChainId.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, actualChainId.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, data);
  }

  /**
   * Method under test: {@link Program#getChainId()}
   */
  @Test
  public void testGetChainId2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    DataWord ZEROResult = DataWord.ZERO();
    when(programInvoke.getContractAddress()).thenReturn(ZEROResult);
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    DataWord actualChainId = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getChainId();

    // Assert
    verify(blockCapsule).getBlockId();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    assertEquals(ZEROResult, actualChainId);
  }

  /**
   * Method under test: {@link Program#getChainId()}
   */
  @Test
  public void testGetChainId3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    DataWord actualChainId = (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getChainId();

    // Assert
    verify(blockId).getBytes();
    verify(blockCapsule).getBlockId();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualChainId.toHexString());
    assertEquals("415841", actualChainId.toPrefixString());
    assertFalse(actualChainId.isNegative());
    assertFalse(actualChainId.isZero());
    byte[] data = actualChainId.getData();
    assertSame(data, actualChainId.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualChainId.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualChainId.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualChainId.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualChainId.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Method under test: {@link Program#getEnergylimitLeftLong()}
   */
  @Test
  public void testGetEnergylimitLeftLong() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(50L,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getEnergylimitLeftLong());
  }

  /**
   * Method under test: {@link Program#getEnergylimitLeftLong()}
   */
  @Test
  public void testGetEnergylimitLeftLong2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(1L,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getEnergylimitLeftLong());
  }

  /**
   * Method under test: {@link Program#getEnergylimitLeftLong()}
   */
  @Test
  public void testGetEnergylimitLeftLong3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(50L, program.getEnergylimitLeftLong());
  }

  /**
   * Method under test: {@link Program#getEnergyLimitLeft()}
   */
  @Test
  public void testGetEnergyLimitLeft() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualEnergyLimitLeft = program.getEnergyLimitLeft();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000032",
        actualEnergyLimitLeft.toHexString());
    assertEquals("32", actualEnergyLimitLeft.toPrefixString());
    assertFalse(actualEnergyLimitLeft.isNegative());
    assertFalse(actualEnergyLimitLeft.isZero());
    DataWord expectedDataSize = actualEnergyLimitLeft.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualEnergyLimitLeft.getData();
    assertSame(data, actualEnergyLimitLeft.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getEnergyLimitLeft()}
   */
  @Test
  public void testGetEnergyLimitLeft2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 8L, new ContractState(new ProgramInvokeMockImpl()), 8L, 8L, 8L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualEnergyLimitLeft = program.getEnergyLimitLeft();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008",
        actualEnergyLimitLeft.toHexString());
    assertEquals("08", actualEnergyLimitLeft.toPrefixString());
    assertFalse(actualEnergyLimitLeft.isNegative());
    assertFalse(actualEnergyLimitLeft.isZero());
    DataWord expectedDifficulty = actualEnergyLimitLeft.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualEnergyLimitLeft.getData();
    assertSame(data, actualEnergyLimitLeft.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\b'}, actualEnergyLimitLeft.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualEnergyLimitLeft.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualEnergyLimitLeft.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualEnergyLimitLeft.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data);
  }

  /**
   * Method under test: {@link Program#getEnergyLimitLeft()}
   */
  @Test
  public void testGetEnergyLimitLeft3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualEnergyLimitLeft = program.getEnergyLimitLeft();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000032",
        actualEnergyLimitLeft.toHexString());
    assertEquals("32", actualEnergyLimitLeft.toPrefixString());
    assertFalse(actualEnergyLimitLeft.isNegative());
    assertFalse(actualEnergyLimitLeft.isZero());
    DataWord expectedDataSize = actualEnergyLimitLeft.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualEnergyLimitLeft.getData();
    assertSame(data, actualEnergyLimitLeft.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getVmShouldEndInUs()}
   */
  @Test
  public void testGetVmShouldEndInUs() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0L,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getVmShouldEndInUs());
  }

  /**
   * Method under test: {@link Program#getVmShouldEndInUs()}
   */
  @Test
  public void testGetVmShouldEndInUs2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(1L,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getVmShouldEndInUs());
  }

  /**
   * Method under test: {@link Program#getVmShouldEndInUs()}
   */
  @Test
  public void testGetVmShouldEndInUs3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0L, program.getVmShouldEndInUs());
  }

  /**
   * Method under test: {@link Program#getCallValue()}
   */
  @Test
  public void testGetCallValue() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualCallValue = program.getCallValue();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", actualCallValue.toHexString());
    assertEquals("0de0b6", actualCallValue.toPrefixString());
    assertFalse(actualCallValue.isNegative());
    assertFalse(actualCallValue.isZero());
    DataWord expectedDataSize = actualCallValue.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
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
   * Method under test: {@link Program#getCallValue()}
   */
  @Test
  public void testGetCallValue2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualCallValue = program.getCallValue();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", actualCallValue.toHexString());
    assertEquals("2a", actualCallValue.toPrefixString());
    assertFalse(actualCallValue.isNegative());
    assertFalse(actualCallValue.isZero());
    DataWord expectedDifficulty = actualCallValue.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualCallValue.getData();
    assertSame(data, actualCallValue.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getCallValue()}
   */
  @Test
  public void testGetCallValue3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualCallValue = program.getCallValue();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", actualCallValue.toHexString());
    assertEquals("0de0b6", actualCallValue.toPrefixString());
    assertFalse(actualCallValue.isNegative());
    assertFalse(actualCallValue.isZero());
    DataWord expectedDataSize = actualCallValue.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
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
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  public void testGetDataSize() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    DataWord dataWord = actualDataSize.ZERO;
    assertEquals(dataWord, actualDataSize);
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  public void testGetDataSize2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", actualDataSize.toHexString());
    assertEquals("08", actualDataSize.toPrefixString());
    assertFalse(actualDataSize.isNegative());
    assertFalse(actualDataSize.isZero());
    DataWord expectedDifficulty = actualDataSize.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualDataSize.getData();
    assertSame(data, actualDataSize.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  public void testGetDataSize3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"));
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", actualDataSize.toHexString());
    assertEquals("08", actualDataSize.toPrefixString());
    assertFalse(actualDataSize.isNegative());
    assertFalse(actualDataSize.isZero());
    DataWord expectedReturnDataBufferSize = actualDataSize.ZERO;
    assertEquals(expectedReturnDataBufferSize, program.getReturnDataBufferSize());
    byte[] data = actualDataSize.getData();
    assertSame(data, actualDataSize.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getDataSize()}
   */
  @Test
  public void testGetDataSize4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualDataSize = program.getDataSize();

    // Assert
    DataWord dataWord = actualDataSize.ZERO;
    assertEquals(dataWord, actualDataSize);
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Method under test: {@link Program#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord index = DataWord.ZERO();

    // Act and Assert
    assertEquals(index, program.getDataValue(index));
  }

  /**
   * Method under test: {@link Program#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualDataValue = program.getDataValue(DataWord.ZERO());

    // Assert
    assertEquals("412041", actualDataValue.toPrefixString());
    assertEquals("4120412041204120000000000000000000000000000000000000000000000000", actualDataValue.toHexString());
    assertFalse(actualDataValue.isNegative());
    assertFalse(actualDataValue.isZero());
    byte[] data = actualDataValue.getData();
    assertSame(data, actualDataValue.getNoLeadZeroesData());
    byte[] expectedNoEndZeroesData = "A A A A ".getBytes("UTF-8");
    assertArrayEquals(expectedNoEndZeroesData, actualDataValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.toTronAddress());
    assertArrayEquals(new byte[]{'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, actualDataValue.getClonedData());
    assertArrayEquals(new byte[]{'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, data);
  }

  /**
   * Method under test: {@link Program#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord index = DataWord.ZERO();

    // Act and Assert
    assertEquals(index, program.getDataValue(index));
  }

  /**
   * Method under test: {@link Program#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord offset = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, program.getDataCopy(offset, DataWord.ZERO()).length);
  }

  /**
   * Method under test: {@link Program#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L,
        1L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord offset = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, program.getDataCopy(offset, DataWord.ZERO()).length);
  }

  /**
   * Method under test: {@link Program#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord offset = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, program.getDataCopy(offset, DataWord.ZERO()).length);
  }

  /**
   * Method under test: {@link Program#getReturnDataBufferSize()}
   */
  @Test
  public void testGetReturnDataBufferSize() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualReturnDataBufferSize = program.getReturnDataBufferSize();

    // Assert
    DataWord dataWord = actualReturnDataBufferSize.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, actualReturnDataBufferSize);
  }

  /**
   * Method under test: {@link Program#getReturnDataBufferSize()}
   */
  @Test
  public void testGetReturnDataBufferSize2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualReturnDataBufferSize = program.getReturnDataBufferSize();

    // Assert
    DataWord dataWord = actualReturnDataBufferSize.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, actualReturnDataBufferSize);
  }

  /**
   * Method under test:
   * {@link Program#getReturnDataBufferData(DataWord, DataWord)}
   */
  @Test
  public void testGetReturnDataBufferData() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord off = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, program.getReturnDataBufferData(off, DataWord.ZERO()).length);
  }

  /**
   * Method under test:
   * {@link Program#getReturnDataBufferData(DataWord, DataWord)}
   */
  @Test
  public void testGetReturnDataBufferData2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord off = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, program.getReturnDataBufferData(off, DataWord.ZERO()).length);
  }

  /**
   * Method under test:
   * {@link Program#getReturnDataBufferData(DataWord, DataWord)}
   */
  @Test
  public void testGetReturnDataBufferData3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord off = DataWord.of((byte) 'A');

    // Act and Assert
    assertNull(program.getReturnDataBufferData(off, DataWord.ZERO()));
  }

  /**
   * Method under test: {@link Program#storageLoad(DataWord)}
   */
  @Test
  public void testStorageLoad() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
   * Method under test: {@link Program#storageLoad(DataWord)}
   */
  @Test
  public void testStorageLoad2() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
   * Method under test: {@link Program#storageLoad(DataWord)}
   */
  @Test
  public void testStorageLoad3() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
   * Method under test: {@link Program#getTokenBalance(DataWord, DataWord)}
   */
  @Test
  public void testGetTokenBalance() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(null);
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 10L, 2L, new RepositoryImpl(StoreFactory.getInstance(), repository),
        2L, 2L, 2L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord address = DataWord.ZERO();

    // Act
    DataWord actualTokenBalance = program.getTokenBalance(address, DataWord.ZERO());

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(address, actualTokenBalance);
  }

  /**
   * Method under test: {@link Program#getTokenValue()}
   */
  @Test
  public void testGetTokenValue() throws UnsupportedEncodingException, ContractValidateException {
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

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualTokenValue = program.getTokenValue();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", actualTokenValue.toHexString());
    assertEquals("2a", actualTokenValue.toPrefixString());
    assertFalse(actualTokenValue.isNegative());
    assertFalse(actualTokenValue.isZero());
    DataWord expectedDifficulty = actualTokenValue.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualTokenValue.getData();
    assertSame(data, actualTokenValue.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getTokenId()}
   */
  @Test
  public void testGetTokenId() throws UnsupportedEncodingException, ContractValidateException {
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

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualTokenId = program.getTokenId();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", actualTokenId.toHexString());
    assertEquals("01", actualTokenId.toPrefixString());
    assertFalse(actualTokenId.isNegative());
    assertFalse(actualTokenId.isZero());
    DataWord expectedDifficulty = actualTokenId.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualTokenId.getData();
    assertSame(data, actualTokenId.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getPrevHash()}
   */
  @Test
  public void testGetPrevHash() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualPrevHash = program.getPrevHash();

    // Assert
    assertEquals("961cb1", actualPrevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", actualPrevHash.toHexString());
    assertFalse(actualPrevHash.isZero());
    assertTrue(actualPrevHash.isNegative());
    DataWord expectedDataSize = actualPrevHash.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualPrevHash.getData();
    assertSame(data, actualPrevHash.getNoEndZeroesData());
    assertSame(data, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, actualPrevHash.toTronAddress());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, actualPrevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data);
  }

  /**
   * Method under test: {@link Program#getPrevHash()}
   */
  @Test
  public void testGetPrevHash2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualPrevHash = program.getPrevHash();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004120412041204120", actualPrevHash.toHexString());
    assertEquals("412041", actualPrevHash.toPrefixString());
    assertFalse(actualPrevHash.isNegative());
    assertFalse(actualPrevHash.isZero());
    DataWord expectedDifficulty = actualPrevHash.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualPrevHash.getData();
    assertSame(data, actualPrevHash.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "A A A A ".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        actualPrevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A',
        ' ', 'A', ' ', 'A', ' '}, actualPrevHash.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A',
        ' ', 'A', ' ', 'A', ' '}, data);
  }

  /**
   * Method under test: {@link Program#getPrevHash()}
   */
  @Test
  public void testGetPrevHash3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualPrevHash = program.getPrevHash();

    // Assert
    assertEquals("961cb1", actualPrevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", actualPrevHash.toHexString());
    assertFalse(actualPrevHash.isZero());
    assertTrue(actualPrevHash.isNegative());
    DataWord expectedDataSize = actualPrevHash.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualPrevHash.getData();
    assertSame(data, actualPrevHash.getNoEndZeroesData());
    assertSame(data, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, actualPrevHash.toTronAddress());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, actualPrevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data);
  }

  /**
   * Method under test: {@link Program#getCoinbase()}
   */
  @Test
  public void testGetCoinbase() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualCoinbase = program.getCoinbase();

    // Assert
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", actualCoinbase.toHexString());
    assertEquals("e559de", actualCoinbase.toPrefixString());
    assertFalse(actualCoinbase.isNegative());
    assertFalse(actualCoinbase.isZero());
    DataWord expectedDataSize = actualCoinbase.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualCoinbase.getData();
    assertSame(data, actualCoinbase.getNoEndZeroesData());
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
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data);
  }

  /**
   * Method under test: {@link Program#getCoinbase()}
   */
  @Test
  public void testGetCoinbase2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualCoinbase = program.getCoinbase();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000004120412041204120", actualCoinbase.toHexString());
    assertEquals("412041", actualCoinbase.toPrefixString());
    assertFalse(actualCoinbase.isNegative());
    assertFalse(actualCoinbase.isZero());
    DataWord expectedDifficulty = actualCoinbase.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualCoinbase.getData();
    assertSame(data, actualCoinbase.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "A A A A ".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualCoinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        actualCoinbase.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' '},
        actualCoinbase.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A',
        ' ', 'A', ' ', 'A', ' '}, actualCoinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', ' ', 'A',
        ' ', 'A', ' ', 'A', ' '}, data);
  }

  /**
   * Method under test: {@link Program#getCoinbase()}
   */
  @Test
  public void testGetCoinbase3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualCoinbase = program.getCoinbase();

    // Assert
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", actualCoinbase.toHexString());
    assertEquals("e559de", actualCoinbase.toPrefixString());
    assertFalse(actualCoinbase.isNegative());
    assertFalse(actualCoinbase.isZero());
    DataWord expectedDataSize = actualCoinbase.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualCoinbase.getData();
    assertSame(data, actualCoinbase.getNoEndZeroesData());
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
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data);
  }

  /**
   * Method under test: {@link Program#getTimestamp()}
   */
  @Test
  public void testGetTimestamp() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualTimestamp = program.getTimestamp();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", actualTimestamp.toHexString());
    assertEquals("5387fe24", actualTimestamp.toPrefixString());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualTimestamp.isZero());
    DataWord expectedDataSize = actualTimestamp.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualTimestamp.getData();
    assertSame(data, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, actualTimestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data);
  }

  /**
   * Method under test: {@link Program#getTimestamp()}
   */
  @Test
  public void testGetTimestamp2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A$A$A$A$".getBytes("UTF-8");
    byte[] origin = "A$A$A$A$".getBytes("UTF-8");
    byte[] caller = "A$A$A$A$".getBytes("UTF-8");
    byte[] msgData = "A$A$A$A$".getBytes("UTF-8");
    byte[] lastHash = "A$A$A$A$".getBytes("UTF-8");
    byte[] coinbase = "A$A$A$A$".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1401421348L, new ContractState(new ProgramInvokeMockImpl()), 1401421348L, 1401421348L,
        1401421348L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualTimestamp = program.getTimestamp();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", actualTimestamp.toHexString());
    assertEquals("0a", actualTimestamp.toPrefixString());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualTimestamp.isZero());
    DataWord expectedDifficulty = actualTimestamp.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualTimestamp.getData();
    assertSame(data, actualTimestamp.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getTimestamp()}
   */
  @Test
  public void testGetTimestamp3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualTimestamp = program.getTimestamp();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", actualTimestamp.toHexString());
    assertEquals("5387fe24", actualTimestamp.toPrefixString());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualTimestamp.isZero());
    DataWord expectedDataSize = actualTimestamp.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualTimestamp.getData();
    assertSame(data, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, actualTimestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data);
  }

  /**
   * Method under test: {@link Program#getNumber()}
   */
  @Test
  public void testGetNumber() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualNumber = program.getNumber();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualNumber.isZero());
    DataWord expectedDataSize = actualNumber.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualNumber.getData();
    assertSame(data, actualNumber.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getNumber()}
   */
  @Test
  public void testGetNumber2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A!A!A!A!".getBytes("UTF-8");
    byte[] origin = "A!A!A!A!".getBytes("UTF-8");
    byte[] caller = "A!A!A!A!".getBytes("UTF-8");
    byte[] msgData = "A!A!A!A!".getBytes("UTF-8");
    byte[] lastHash = "A!A!A!A!".getBytes("UTF-8");
    byte[] coinbase = "A!A!A!A!".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 33L, new ContractState(new ProgramInvokeMockImpl()), 33L, 33L, 33L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualNumber = program.getNumber();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualNumber.isZero());
    DataWord expectedDifficulty = actualNumber.ZERO;
    assertEquals(expectedDifficulty, program.getDifficulty());
    byte[] data = actualNumber.getData();
    assertSame(data, actualNumber.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getNumber()}
   */
  @Test
  public void testGetNumber3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualNumber = program.getNumber();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualNumber.isZero());
    DataWord expectedDataSize = actualNumber.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualNumber.getData();
    assertSame(data, actualNumber.getNoEndZeroesData());
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
        data);
  }

  /**
   * Method under test: {@link Program#getDifficulty()}
   */
  @Test
  public void testGetDifficulty() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualDifficulty = program.getDifficulty();

    // Assert
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", actualDifficulty.toHexString());
    assertEquals("3ed290", actualDifficulty.toPrefixString());
    assertFalse(actualDifficulty.isNegative());
    assertFalse(actualDifficulty.isZero());
    DataWord expectedDataSize = actualDifficulty.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualDifficulty.getData();
    assertSame(data, actualDifficulty.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, actualDifficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, actualDifficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data);
  }

  /**
   * Method under test: {@link Program#getDifficulty()}
   */
  @Test
  public void testGetDifficulty2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    DataWord actualDifficulty = program.getDifficulty();

    // Assert
    DataWord dataWord = actualDifficulty.ZERO;
    assertEquals(dataWord, actualDifficulty);
    assertEquals(dataWord, program.getReturnDataBufferSize());
  }

  /**
   * Method under test: {@link Program#getDifficulty()}
   */
  @Test
  public void testGetDifficulty3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    DataWord actualDifficulty = program.getDifficulty();

    // Assert
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", actualDifficulty.toHexString());
    assertEquals("3ed290", actualDifficulty.toPrefixString());
    assertFalse(actualDifficulty.isNegative());
    assertFalse(actualDifficulty.isZero());
    DataWord expectedDataSize = actualDifficulty.ZERO;
    assertEquals(expectedDataSize, program.getDataSize());
    byte[] data = actualDifficulty.getData();
    assertSame(data, actualDifficulty.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, actualDifficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, actualDifficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data);
  }

  /**
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  public void testIsStaticCall() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertFalse(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).isStaticCall());
  }

  /**
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  public void testIsStaticCall2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new ContractState(new ProgramInvokeMockImpl()), 3L, 3L,
        3L);

    // Act and Assert
    assertFalse(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).isStaticCall());
  }

  /**
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  public void testIsStaticCall3() throws UnsupportedEncodingException, ContractValidateException {
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
    DataWord lastHash = DataWord.ZERO();
    DataWord coinbase = DataWord.ZERO();
    DataWord timestamp = DataWord.ZERO();
    DataWord number = DataWord.ZERO();
    DataWord difficulty = DataWord.ZERO();
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, balance, callValue, tokenValue,
        tokenId, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, lastHash, coinbase, timestamp, number, difficulty,
        new ContractState(new ProgramInvokeMockImpl()), 3, true, true, 3L, 3L, 3L);

    // Act and Assert
    assertTrue(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).isStaticCall());
  }

  /**
   * Method under test: {@link Program#isStaticCall()}
   */
  @Test
  public void testIsStaticCall4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertFalse(program.isStaticCall());
  }

  /**
   * Method under test: {@link Program#isConstantCall()}
   */
  @Test
  public void testIsConstantCall() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertFalse(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).isConstantCall());
  }

  /**
   * Method under test: {@link Program#isConstantCall()}
   */
  @Test
  public void testIsConstantCall2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, 10L, 3L, new ContractState(new ProgramInvokeMockImpl()), 3L, 3L,
        3L);

    // Act and Assert
    assertFalse(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).isConstantCall());
  }

  /**
   * Method under test: {@link Program#isConstantCall()}
   */
  @Test
  public void testIsConstantCall3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertFalse(program.isConstantCall());
  }

  /**
   * Method under test: {@link Program#setRuntimeFailure(RuntimeException)}
   */
  @Test
  public void testSetRuntimeFailure() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    RuntimeException e = new RuntimeException("foo");

    // Act
    program.setRuntimeFailure(e);

    // Assert
    assertSame(e, program.getResult().getException());
  }

  /**
   * Method under test: {@link Program#setRuntimeFailure(RuntimeException)}
   */
  @Test
  public void testSetRuntimeFailure2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    RuntimeException e = new RuntimeException("foo");

    // Act
    program.setRuntimeFailure(e);

    // Assert
    assertSame(e, program.getResult().getException());
  }

  /**
   * Method under test: {@link Program#memoryToString()}
   */
  @Test
  public void testMemoryToString() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals("",
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).memoryToString());
  }

  /**
   * Method under test: {@link Program#memoryToString()}
   */
  @Test
  public void testMemoryToString2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals("", program.memoryToString());
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace() throws UnsupportedEncodingException, ContractValidateException {
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
    program.fullTrace();

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] ops = "\bXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    program.fullTrace();

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>0858415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(null, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    program.fullTrace();

    // Assert
    verify(listener)
        .output(eq("\n -- OPS --     \n  >>\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
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

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    program.fullTrace();

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl("AXAXAXAX".getBytes("UTF-8"));

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act
    program.fullTrace();

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace6() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    doNothing().when(listener).output(Mockito.<String>any());
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.setPC(320);
    program.addListener(listener);

    // Act
    program.fullTrace();

    // Assert
    verify(listener).output(eq(
        "\n[Op: STOP]\n -- OPS --     \n 4158415841584158 >>\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace7() throws UnsupportedEncodingException, ContractValidateException {
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
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());
    program.addListener(listener);

    // Act
    program.fullTrace();

    // Assert
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n 0000000000000000000000000000000000000000000000000000000000000000\n\n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#fullTrace()}
   */
  @Test
  public void testFullTrace8() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Program.ProgramOutListener listener = mock(Program.ProgramOutListener.class);
    byte[] ops = "A@A@A@A@".getBytes("UTF-8");
    byte[] codeAddress = "A@A@A@A@".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    doThrow((new Program(ops, codeAddress, programInvoke,
        new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException("An error occurred"))
                .when(listener)
                .output(Mockito.<String>any());
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();

    Program program = new Program(ops2, codeAddress2, programInvoke2, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(listener);

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class, () -> program.fullTrace());
    verify(listener).output(eq(
        "\n -- OPS --     \n  >>4158415841584158\n -- STACK --   \n -- MEMORY --  \n\n  HReturn: \n  msg.data: \n\n  Spent Energy: 0"));
  }

  /**
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  public void testSaveOpTrace() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

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
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  public void testSaveOpTrace2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.saveOpTrace();

    // Assert that nothing has changed
    assertTrue(program.getTrace().getOps().isEmpty());
  }

  /**
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  public void testSaveOpTrace3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 8L, new ContractState(new ProgramInvokeMockImpl()), 8L, 8L, 8L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.saveOpTrace();

    // Assert
    List<Op> ops2 = program.getTrace().getOps();
    assertEquals(1, ops2.size());
    Op getResult = ops2.get(0);
    BigInteger energy = getResult.getEnergy();
    assertEquals("8", energy.toString());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getPc());
    assertEquals(1, energy.signum());
    assertEquals(3, energy.getLowestSetBit());
    assertEquals(65, getResult.getCode());
    OpActions actions = getResult.getActions();
    assertTrue(actions.getMemory().isEmpty());
    assertTrue(actions.getStack().isEmpty());
    assertTrue(actions.getStorage().isEmpty());
    assertArrayEquals(new byte[]{'\b'}, energy.toByteArray());
  }

  /**
   * Method under test: {@link Program#saveOpTrace()}
   */
  @Test
  public void testSaveOpTrace4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

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
   * Method under test:
   * {@link Program#createContract2(DataWord, DataWord, DataWord, DataWord)}
   */
  @Test
  public void testCreateContract2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(energy, stack.get(0));
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(energy, stack.get(0));
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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
    MessageCall msg = new MessageCall(242, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(energy, stack.get(0));
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.of((byte) 'A');
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(energy, stack.get(0));
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.of((byte) 'A');
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    byte[] memory = program.getMemory();
    assertEquals((byte) 0, memory[0]);
    assertEquals((byte) 0, memory[1]);
    assertEquals((byte) 0, memory[10]);
    assertEquals((byte) 0, memory[11]);
    assertEquals((byte) 0, memory[12]);
    assertEquals((byte) 0, memory[13]);
    assertEquals((byte) 0, memory[14]);
    assertEquals((byte) 0, memory[15]);
    assertEquals((byte) 0, memory[17]);
    assertEquals((byte) 0, memory[18]);
    assertEquals((byte) 0, memory[19]);
    assertEquals((byte) 0, memory[2]);
    assertEquals((byte) 0, memory[20]);
    assertEquals((byte) 0, memory[21]);
    assertEquals((byte) 0, memory[22]);
    assertEquals((byte) 0, memory[23]);
    assertEquals((byte) 0, memory[24]);
    assertEquals((byte) 0, memory[3]);
    assertEquals((byte) 0, memory[4]);
    assertEquals((byte) 0, memory[5]);
    assertEquals((byte) 0, memory[6]);
    assertEquals((byte) 0, memory[7]);
    assertEquals((byte) 0, memory[71]);
    assertEquals((byte) 0, memory[72]);
    assertEquals((byte) 0, memory[73]);
    assertEquals((byte) 0, memory[74]);
    assertEquals((byte) 0, memory[75]);
    assertEquals((byte) 0, memory[76]);
    assertEquals((byte) 0, memory[77]);
    assertEquals((byte) 0, memory[78]);
    assertEquals((byte) 0, memory[79]);
    assertEquals((byte) 0, memory[8]);
    assertEquals((byte) 0, memory[80]);
    assertEquals((byte) 0, memory[81]);
    assertEquals((byte) 0, memory[82]);
    assertEquals((byte) 0, memory[83]);
    assertEquals((byte) 0, memory[84]);
    assertEquals((byte) 0, memory[85]);
    assertEquals((byte) 0, memory[86]);
    assertEquals((byte) 0, memory[87]);
    assertEquals((byte) 0, memory[88]);
    assertEquals((byte) 0, memory[89]);
    assertEquals((byte) 0, memory[9]);
    assertEquals((byte) 0, memory[90]);
    assertEquals((byte) 0, memory[91]);
    assertEquals((byte) 0, memory[92]);
    assertEquals((byte) 0, memory[93]);
    assertEquals((byte) 0, memory[94]);
    assertEquals((byte) 0, memory[95]);
    assertEquals((byte) 0, memory[Short.SIZE]);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(96, program.getMemSize());
    assertEquals(96, memory.length);
    assertEquals(energy, stack.get(0));
  }

  /**
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress6() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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
    MessageCall msg = new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.BN128Addition());

    // Assert
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(energy, stack.get(0));
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test:
   * {@link Program#callToPrecompiledAddress(MessageCall, PrecompiledContracts.PrecompiledContract)}
   */
  @Test
  public void testCallToPrecompiledAddress7() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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
    MessageCall msg = new MessageCall(244, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(),
        true);

    // Act
    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());

    // Assert
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(energy, stack.get(0));
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  public void testByTestingSuite() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertFalse(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).byTestingSuite());
  }

  /**
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  public void testByTestingSuite2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 10L, 2L, new ContractState(new ProgramInvokeMockImpl()), 2L, 2L,
        2L);

    // Act and Assert
    assertFalse(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).byTestingSuite());
  }

  /**
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  public void testByTestingSuite3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 42L, 42L, 42L, 1L,
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 10L, 2L, new ContractState(new ProgramInvokeMockImpl()), 2L, 2L,
        true, 2L);

    // Act and Assert
    assertTrue(
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).byTestingSuite());
  }

  /**
   * Method under test: {@link Program#byTestingSuite()}
   */
  @Test
  public void testByTestingSuite4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertFalse(program.byTestingSuite());
  }

  /**
   * Method under test: {@link Program#checkTokenId(MessageCall)}
   */
  @Test
  public void testCheckTokenId() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress2 = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();

    // Act
    program.checkTokenId(
        new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(), true));

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#isTokenTransfer(MessageCall)}
   */
  @Test
  public void testIsTokenTransfer() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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

    // Act and Assert
    assertFalse(program.isTokenTransfer(
        new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.ZERO(), true)));
  }

  /**
   * Method under test: {@link Program#isTokenTransfer(MessageCall)}
   */
  @Test
  public void testIsTokenTransfer2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
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
   * Method under test: {@link Program#isTokenTransfer(MessageCall)}
   */
  @Test
  public void testIsTokenTransfer3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
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

    // Act and Assert
    assertTrue(program.isTokenTransfer(
        new MessageCall(1, energy, codeAddress2, endowment, inDataOffs, inDataSize, DataWord.of((byte) 'A'), true)));
  }

  /**
   * Method under test: {@link Program#checkTokenIdInTokenBalance(DataWord)}
   */
  @Test
  public void testCheckTokenIdInTokenBalance() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.checkTokenIdInTokenBalance(DataWord.ZERO());

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  public void testGetCallEnergy() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord requestedEnergy = DataWord.ZERO();

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(requestedEnergy, DataWord.ZERO());

    // Assert
    assertEquals(requestedEnergy, program.getDataSize());
    assertSame(requestedEnergy, actualCallEnergy);
  }

  /**
   * Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  public void testGetCallEnergy2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.setContractVersion(1);
    DataWord requestedEnergy = DataWord.ZERO();

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(requestedEnergy, null);

    // Assert
    assertEquals(requestedEnergy, program.getDataSize());
    assertSame(requestedEnergy, actualCallEnergy);
  }

  /**
   * Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  public void testGetCallEnergy3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord requestedEnergy = DataWord.ZERO();

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(requestedEnergy, DataWord.ZERO());

    // Assert
    assertEquals(requestedEnergy, program.getDataSize());
    assertSame(requestedEnergy, actualCallEnergy);
  }

  /**
   * Method under test: {@link Program#getCallEnergy(DataWord, DataWord)}
   */
  @Test
  public void testGetCallEnergy4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord requestedEnergy = DataWord.of((byte) 'A');
    DataWord availableEnergy = DataWord.ZERO();

    // Act
    DataWord actualCallEnergy = program.getCallEnergy(requestedEnergy, availableEnergy);

    // Assert
    DataWord dataWord = actualCallEnergy.ZERO;
    assertEquals(dataWord, program.getDataSize());
    assertEquals(dataWord, availableEnergy);
    assertSame(availableEnergy, actualCallEnergy);
  }

  /**
   * Method under test: {@link Program#getCreateEnergy(DataWord)}
   */
  @Test
  public void testGetCreateEnergy() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord availableEnergy = DataWord.ZERO();

    // Act and Assert
    assertSame(availableEnergy, program.getCreateEnergy(availableEnergy));
  }

  /**
   * Method under test: {@link Program#getCreateEnergy(DataWord)}
   */
  @Test
  public void testGetCreateEnergy2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
    DataWord availableEnergy = DataWord.ZERO();

    // Act and Assert
    assertSame(availableEnergy, program.getCreateEnergy(availableEnergy));
  }

  /**
   * Method under test: {@link Program#getMemory()}
   */
  @Test
  public void testGetMemory() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getMemory().length);
  }

  /**
   * Method under test: {@link Program#getMemory()}
   */
  @Test
  public void testGetMemory2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0, program.getMemory().length);
  }

  /**
   * Method under test: {@link Program#initMem(byte[])}
   */
  @Test
  public void testInitMem() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.initMem("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#initMem(byte[])}
   */
  @Test
  public void testInitMem2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    program.initMem("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(Integer.SIZE, program.getMemSize());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, program.getMemory());
  }

  /**
   * Method under test: {@link Program#initMem(byte[])}
   */
  @Test
  public void testInitMem3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    program.initMem(new byte[]{});

    // Assert that nothing has changed
    assertEquals(0, program.getMemSize());
    byte[] memory = program.getMemory();
    assertEquals(0, memory.length);
    assertSame(memory, program.getResult().getHReturn());
  }

  /**
   * Method under test: {@link Program#getVmStartInUs()}
   */
  @Test
  public void testGetVmStartInUs() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0L,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getVmStartInUs());
  }

  /**
   * Method under test: {@link Program#getVmStartInUs()}
   */
  @Test
  public void testGetVmStartInUs2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(1L,
        (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).getVmStartInUs());
  }

  /**
   * Method under test: {@link Program#getVmStartInUs()}
   */
  @Test
  public void testGetVmStartInUs3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0L, program.getVmStartInUs());
  }

  /**
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testFreeze() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testFreeze2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "@XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testFreeze3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testFreeze4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord frozenBalance = DataWord.of((byte) 'A');

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
    assertEquals(0, getResult.getData().length);
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertEquals(65L, getResult.getValue());
    assertFalse(actualFreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{31, -35, -14, -116, -26, 'B', -112, 'I', '3', 'X', 'V', -75, '`', -126, -3, '5', -31,
        -89, '7', '%', -33, 'N', '*', 'F', -81, '%', -47, -99, '\f', -33, 16, -81}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A'}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freeze(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testFreeze5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    boolean actualFreezeResult = program.freeze(receiverAddress, frozenBalance, DataWord.of((byte) 'A'));

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("freezeForUnknownType", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#unfreeze(DataWord, DataWord)}
   */
  @Test
  public void testUnfreeze() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();
    when(programInvoke.getCallDeep())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke2,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops2, codeAddress2, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class, () -> program.unfreeze(receiverAddress, DataWord.ZERO()));
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#unfreeze(DataWord, DataWord)}
   */
  @Test
  public void testUnfreeze2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();

    // Act
    boolean actualUnfreezeResult = program.unfreeze(receiverAddress, DataWord.ZERO());

    // Assert
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualUnfreezeResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  public void testFreezeExpireTime() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  public void testFreezeExpireTime2() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  public void testFreezeExpireTime3() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  public void testFreezeExpireTime4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DelegatedResourceCapsule delegatedResourceCapsule = mock(DelegatedResourceCapsule.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    when(delegatedResourceCapsule.getExpireTimeForBandwidth())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(delegatedResourceCapsule.getFrozenBalanceForBandwidth()).thenReturn(1L);
    Repository repository = mock(Repository.class);
    when(repository.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(dataWord);
    when(programInvoke2.getDeposit()).thenReturn(repository);
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops2, codeAddress2, programInvoke2, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord targetAddress = DataWord.ZERO();

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class, () -> program.freezeExpireTime(targetAddress, DataWord.ZERO()));
    verify(dataWord).toTronAddress();
    verify(delegatedResourceCapsule).getExpireTimeForBandwidth();
    verify(delegatedResourceCapsule).getFrozenBalanceForBandwidth();
    verify(programInvoke2, atLeast(1)).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(repository).getDelegatedResource(isA(byte[].class));
  }

  /**
   * Method under test: {@link Program#freezeExpireTime(DataWord, DataWord)}
   */
  @Test
  public void testFreezeExpireTime5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord targetAddress = mock(DataWord.class);
    when(targetAddress.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualFreezeExpireTimeResult = program.freezeExpireTime(targetAddress, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(targetAddress).toTronAddress();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualFreezeExpireTimeResult);
  }

  /**
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testFreezeBalanceV2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'\b', -2, -77, 'G', -2, -37, -123, -48, -80, '6', -58, ')', -71, -105, -26, '"', -61,
        'u', 'M', 19, 2, 'G', '\'', 'W', 19, 'I', -33, 'C', 28, '_', 31, -79}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'G', 31, -45, -83, '>', -98,
        -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testFreezeBalanceV22() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "@XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'\b', -2, -77, 'G', -2, -37, -123, -48, -80, '6', -58, ')', -71, -105, -26, '"', -61,
        'u', 'M', 19, 2, 'G', '\'', 'W', 19, 'I', -33, 'C', 28, '_', 31, -79}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'G', 31, -45, -83, '>', -98,
        -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testFreezeBalanceV23() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'\b', -2, -77, 'G', -2, -37, -123, -48, -80, '6', -58, ')', -71, -105, -26, '"', -61,
        'u', 'M', 19, 2, 'G', '\'', 'W', 19, 'I', -33, 'C', 28, '_', 31, -79}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'G', 31, -45, -83, '>', -98,
        -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testFreezeBalanceV24() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord frozenBalance = DataWord.of((byte) 'A');

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
    assertEquals(0, getResult.getData().length);
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertEquals(65L, getResult.getValue());
    assertFalse(actualFreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'?', -112, '5', -76, -81, -83, 'k', ':', '?', '/', -125, -57, -8, -24, -61, -95, 6,
        -45, 'G', -96, -124, '5', 'z', 29, '\t', -85, -22, -46, -28, 29, -51, -103}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'G', 31, -45, -83, '>', -98,
        -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 'A'},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#freezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testFreezeBalanceV25() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord frozenBalance = DataWord.ZERO();

    // Act
    boolean actualFreezeBalanceV2Result = program.freezeBalanceV2(frozenBalance, DataWord.of((byte) 'A'));

    // Assert
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("freezeBalanceV2ForUnknownType", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getDeep());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualFreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getReceiveAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getSender());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'\b', -2, -77, 'G', -2, -37, -123, -48, -80, '6', -58, ')', -71, -105, -26, '"', -61,
        'u', 'M', 19, 2, 'G', '\'', 'W', 19, 'I', -33, 'C', 28, '_', 31, -79}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'G', 31, -45, -83, '>', -98,
        -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testUnfreezeBalanceV2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();
    when(programInvoke.getCallDeep())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke2,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops2, codeAddress2, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class,
        () -> program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO()));
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testUnfreezeBalanceV22() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    boolean actualUnfreezeBalanceV2Result = program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("unfreezeBalanceV2ForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualUnfreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testUnfreezeBalanceV23() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    boolean actualUnfreezeBalanceV2Result = program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("unfreezeBalanceV2ForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0, getResult.getReceiveAddress().length);
    assertEquals(0, getResult.getSender().length);
    assertEquals(0, getResult.getTransferToAddress().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualUnfreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{-102, -126, -35, -22, '\t', '0', -5, -92, '.', -87, -4, 'W', -41, -14, -110, '+', -10,
        'm', -59, -57, '"', -126, 28, -108, '\r', '\b', 'P', 'Y', -13, -108, '\f', 16}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testUnfreezeBalanceV24() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    boolean actualUnfreezeBalanceV2Result = program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("unfreezeBalanceV2ForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0, getResult.getReceiveAddress().length);
    assertEquals(0, getResult.getSender().length);
    assertEquals(0, getResult.getTransferToAddress().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualUnfreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{-102, -126, -35, -22, '\t', '0', -5, -92, '.', -87, -4, 'W', -41, -14, -110, '+', -10,
        'm', -59, -57, '"', -126, 28, -108, '\r', '\b', 'P', 'Y', -13, -108, '\f', 16}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#unfreezeBalanceV2(DataWord, DataWord)}
   */
  @Test
  public void testUnfreezeBalanceV25() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord unfreezeBalance = DataWord.ZERO();

    // Act
    boolean actualUnfreezeBalanceV2Result = program.unfreezeBalanceV2(unfreezeBalance, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("unfreezeBalanceV2ForBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualUnfreezeBalanceV2Result);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  public void testWithdrawExpireUnfreeze() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();
    when(programInvoke.getCallDeep())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke2,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class,
        () -> (new Program(ops2, codeAddress2, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .withdrawExpireUnfreeze());
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  public void testWithdrawExpireUnfreeze2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    long actualWithdrawExpireUnfreezeResult = program.withdrawExpireUnfreeze();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawExpireUnfreeze", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(0L, actualWithdrawExpireUnfreezeResult);
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  public void testWithdrawExpireUnfreeze3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    long actualWithdrawExpireUnfreezeResult = program.withdrawExpireUnfreeze();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawExpireUnfreeze", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0, getResult.getReceiveAddress().length);
    assertEquals(0, getResult.getSender().length);
    assertEquals(0, getResult.getTransferToAddress().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(0L, actualWithdrawExpireUnfreezeResult);
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{-102, -126, -35, -22, '\t', '0', -5, -92, '.', -87, -4, 'W', -41, -14, -110, '+', -10,
        'm', -59, -57, '"', -126, 28, -108, '\r', '\b', 'P', 'Y', -13, -108, '\f', 16}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  public void testWithdrawExpireUnfreeze4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    long actualWithdrawExpireUnfreezeResult = program.withdrawExpireUnfreeze();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawExpireUnfreeze", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0, getResult.getReceiveAddress().length);
    assertEquals(0, getResult.getSender().length);
    assertEquals(0, getResult.getTransferToAddress().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(0L, actualWithdrawExpireUnfreezeResult);
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{-102, -126, -35, -22, '\t', '0', -5, -92, '.', -87, -4, 'W', -41, -14, -110, '+', -10,
        'm', -59, -57, '"', -126, 28, -108, '\r', '\b', 'P', 'Y', -13, -108, '\f', 16}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#withdrawExpireUnfreeze()}
   */
  @Test
  public void testWithdrawExpireUnfreeze5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    long actualWithdrawExpireUnfreezeResult = program.withdrawExpireUnfreeze();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawExpireUnfreeze", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(0L, actualWithdrawExpireUnfreezeResult);
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  public void testCancelAllUnfreezeV2Action() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();
    when(programInvoke.getCallDeep())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke2,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class,
        () -> (new Program(ops2, codeAddress2, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .cancelAllUnfreezeV2Action());
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  public void testCancelAllUnfreezeV2Action2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    boolean actualCancelAllUnfreezeV2ActionResult = program.cancelAllUnfreezeV2Action();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualCancelAllUnfreezeV2ActionResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  public void testCancelAllUnfreezeV2Action3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    boolean actualCancelAllUnfreezeV2ActionResult = program.cancelAllUnfreezeV2Action();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0, getResult.getReceiveAddress().length);
    assertEquals(0, getResult.getSender().length);
    assertEquals(0, getResult.getTransferToAddress().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualCancelAllUnfreezeV2ActionResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{-102, -126, -35, -22, '\t', '0', -5, -92, '.', -87, -4, 'W', -41, -14, -110, '+', -10,
        'm', -59, -57, '"', -126, 28, -108, '\r', '\b', 'P', 'Y', -13, -108, '\f', 16}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  public void testCancelAllUnfreezeV2Action4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    boolean actualCancelAllUnfreezeV2ActionResult = program.cancelAllUnfreezeV2Action();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0, getResult.getReceiveAddress().length);
    assertEquals(0, getResult.getSender().length);
    assertEquals(0, getResult.getTransferToAddress().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualCancelAllUnfreezeV2ActionResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertArrayEquals(new byte[]{-102, -126, -35, -22, '\t', '0', -5, -92, '.', -87, -4, 'W', -41, -14, -110, '+', -10,
        'm', -59, -57, '"', -126, 28, -108, '\r', '\b', 'P', 'Y', -13, -108, '\f', 16}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  public void testCancelAllUnfreezeV2Action5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    boolean actualCancelAllUnfreezeV2ActionResult = program.cancelAllUnfreezeV2Action();

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualCancelAllUnfreezeV2ActionResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#cancelAllUnfreezeV2Action()}
   */
  @Test
  public void testCancelAllUnfreezeV2Action6() throws UnsupportedEncodingException {
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
    boolean actualCancelAllUnfreezeV2ActionResult = program.cancelAllUnfreezeV2Action();

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
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertFalse(actualCancelAllUnfreezeV2ActionResult);
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
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
  }

  /**
   * Method under test:
   * {@link Program#delegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testDelegateResource() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();
    when(programInvoke.getCallDeep())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke2,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops2, codeAddress2, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord delegateBalance = DataWord.ZERO();

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class,
        () -> program.delegateResource(receiverAddress, delegateBalance, DataWord.ZERO()));
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link Program#delegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testDelegateResource2() throws UnsupportedEncodingException, ContractValidateException {
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
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord delegateBalance = DataWord.ZERO();

    // Act
    boolean actualDelegateResourceResult = program.delegateResource(receiverAddress, delegateBalance, DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("delegateResourceOfBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualDelegateResourceResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test:
   * {@link Program#unDelegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testUnDelegateResource() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke2 = new ProgramInvokeMockImpl();
    when(programInvoke.getCallDeep())
        .thenThrow(
            (new Program(ops, codeAddress, programInvoke2,
                new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
                    InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).new StackTooLargeException(
                        "An error occurred"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress2 = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops2, codeAddress2, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord unDelegateBalance = DataWord.ZERO();

    // Act and Assert
    assertThrows(Program.StackTooLargeException.class,
        () -> program.unDelegateResource(receiverAddress, unDelegateBalance, DataWord.ZERO()));
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link Program#unDelegateResource(DataWord, DataWord, DataWord)}
   */
  @Test
  public void testUnDelegateResource2() throws UnsupportedEncodingException, ContractValidateException {
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
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    DataWord receiverAddress = DataWord.ZERO();
    DataWord unDelegateBalance = DataWord.ZERO();

    // Act
    boolean actualUnDelegateResourceResult = program.unDelegateResource(receiverAddress, unDelegateBalance,
        DataWord.ZERO());

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repository).newRepositoryChild();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("unDelegateResourceOfBandwidth", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(actualUnDelegateResourceResult);
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{-36, 'H', '-', '/', -39, -95, 'C', -4, -31, -22, '\n', -22, 31, 'w', 'h', 'o', -76,
        '5', -94, 't', 27, '&', 29, -38, -12, -54, -29, -5, -87, 22, -114, -36}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#voteWitness(int, int, int, int)}
   */
  @Test
  public void testVoteWitness() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertThrows(Program.BytecodeExecutionException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .voteWitness(1, 3, 10, 10));
  }

  /**
   * Method under test: {@link Program#withdrawReward()}
   */
  @Test
  public void testWithdrawReward() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenThrow(new Program.AssetIssueException("An error occurred", "Args"));
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.AssetIssueException.class,
        () -> (new Program(ops, codeAddress, programInvoke, new InternalTransaction(
            Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)))
                .withdrawReward());
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link Program#withdrawReward()}
   */
  @Test
  public void testWithdrawReward2() throws UnsupportedEncodingException, ContractValidateException {
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
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    long actualWithdrawRewardResult = program.withdrawReward();

    // Assert
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
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(0L, actualWithdrawRewardResult);
    assertEquals(1, getResult.getDeep());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, getResult.getParentHash());
    assertArrayEquals(new byte[]{'5', 'q', -37, -13, '-', 'p', -22, 29, ',', -92, -101, '?', 'o', -114, 'l', -23, '=',
        -49, -82, -109, 24, 7, 25, 'U', -52, -34, '\r', -120, ' ', -78, -104, 'U'}, getResult.getHash());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getEncoded());
  }

  /**
   * Method under test: {@link Program#addContextContractUsage(long)}
   */
  @Test
  public void testAddContextContractUsage() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContractState(Mockito.<byte[]>any())).thenReturn(new ContractStateCapsule(1L));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "A A A A ".getBytes("UTF-8"), 10L, 32L, deposit, 32L, 32L, 32L);

    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    (new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))).addContextContractUsage(42L);

    // Assert
    verify(repository).getContractState(isA(byte[].class));
  }
}
