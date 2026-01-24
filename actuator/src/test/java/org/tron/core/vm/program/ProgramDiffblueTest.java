package org.tron.core.vm.program;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Exception#invalidOpCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IllegalOperationException Exception.invalidOpCode(byte[])"})
  public void testExceptionInvalidOpCode_whenA() {
    // Arrange and Act
    IllegalOperationException actualInvalidOpCodeResult =
        Exception.invalidOpCode(
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1,
            (byte) 'A',
            (byte) 1);

    // Assert
    assertEquals(
        "Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getLocalizedMessage());
    assertEquals("Invalid operation code: opCode[41];", actualInvalidOpCodeResult.getMessage());
    assertNull(actualInvalidOpCodeResult.getCause());
    assertEquals(0, actualInvalidOpCodeResult.getSuppressed().length);
  }

  /**
   * Test Exception {@link Exception#invalidOpCode(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Exception#invalidOpCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IllegalOperationException Exception.invalidOpCode(byte[])"})
  public void testExceptionInvalidOpCode_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
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
   * Test Exception {@link Exception#memoryOverflow(int)}.
   *
   * <p>Method under test: {@link Exception#memoryOverflow(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OutOfMemoryException Exception.memoryOverflow(int)"})
  public void testExceptionMemoryOverflow2() {
    // Arrange and Act
    OutOfMemoryException actualMemoryOverflowResult = Exception.memoryOverflow(0);

    // Assert
    assertEquals(
        "Out of Memory when 'STOP' operation executing",
        actualMemoryOverflowResult.getLocalizedMessage());
    assertEquals(
        "Out of Memory when 'STOP' operation executing", actualMemoryOverflowResult.getMessage());
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
