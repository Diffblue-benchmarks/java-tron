package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Stack;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Repository;
import org.tron.protos.Protocol;

public class EnergyCostDiffblueTest {
  /**
   * Method under test: {@link EnergyCost#getZeroTierCost(Program)}
   */
  @Test
  public void testGetZeroTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0L, EnergyCost.getZeroTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getZeroTierCost(Program)}
   */
  @Test
  public void testGetZeroTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0L, EnergyCost.getZeroTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getVeryLowTierCost(Program)}
   */
  @Test
  public void testGetVeryLowTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(3L, EnergyCost.getVeryLowTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getVeryLowTierCost(Program)}
   */
  @Test
  public void testGetVeryLowTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(3L, EnergyCost.getVeryLowTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getLowTierCost(Program)}
   */
  @Test
  public void testGetLowTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(5L, EnergyCost.getLowTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getLowTierCost(Program)}
   */
  @Test
  public void testGetLowTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(5L, EnergyCost.getLowTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getMidTierCost(Program)}
   */
  @Test
  public void testGetMidTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(8L, EnergyCost.getMidTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getMidTierCost(Program)}
   */
  @Test
  public void testGetMidTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(8L, EnergyCost.getMidTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getBaseTierCost(Program)}
   */
  @Test
  public void testGetBaseTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(2L, EnergyCost.getBaseTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getBaseTierCost(Program)}
   */
  @Test
  public void testGetBaseTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(2L, EnergyCost.getBaseTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getExtTierCost(Program)}
   */
  @Test
  public void testGetExtTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(20L, EnergyCost.getExtTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getExtTierCost(Program)}
   */
  @Test
  public void testGetExtTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(20L, EnergyCost.getExtTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getHighTierCost(Program)}
   */
  @Test
  public void testGetHighTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10L, EnergyCost.getHighTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getHighTierCost(Program)}
   */
  @Test
  public void testGetHighTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10L, EnergyCost.getHighTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getSpecialTierCost(Program)}
   */
  @Test
  public void testGetSpecialTierCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(1L, EnergyCost.getSpecialTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getSpecialTierCost(Program)}
   */
  @Test
  public void testGetSpecialTierCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(1L, EnergyCost.getSpecialTierCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getExpCost(Program)}
   */
  @Test
  public void testGetExpCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExpCost = EnergyCost.getExpCost(program);

    // Assert
    verify(program).getStack();
    assertEquals(10L, actualExpCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExpCost(Program)}
   */
  @Test
  public void testGetExpCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExpCost = EnergyCost.getExpCost(program);

    // Assert
    verify(program).getStack();
    assertEquals(20L, actualExpCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExpCost(Program)}
   */
  @Test
  public void testGetExpCost3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.bytesOccupied()).thenReturn(1);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExpCost = EnergyCost.getExpCost(program);

    // Assert
    verify(dataWord).bytesOccupied();
    verify(program).getStack();
    assertEquals(20L, actualExpCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeSizeCost(Program)}
   */
  @Test
  public void testGetExtCodeSizeCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(20L, EnergyCost.getExtCodeSizeCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeSizeCost(Program)}
   */
  @Test
  public void testGetExtCodeSizeCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(20L, EnergyCost.getExtCodeSizeCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSha3Cost = EnergyCost.getSha3Cost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(30L, actualSha3Cost);
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSha3Cost = EnergyCost.getSha3Cost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(30L, actualSha3Cost);
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSha3Cost = EnergyCost.getSha3Cost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(57L, actualSha3Cost);
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSha3Cost = EnergyCost.getSha3Cost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(42L, actualSha3Cost);
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 30L, 30L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getSha3Cost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSha3Cost = EnergyCost.getSha3Cost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(45L, actualSha3Cost);
  }

  /**
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  public void testGetSha3Cost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSha3Cost = EnergyCost.getSha3Cost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(45L, actualSha3Cost);
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCodeCopyCost = EnergyCost.getCodeCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCodeCopyCost = EnergyCost.getCodeCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCodeCopyCost = EnergyCost.getCodeCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(18L, actualCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCodeCopyCost = EnergyCost.getCodeCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(6L, actualCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 3L, 3L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getCodeCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCodeCopyCost = EnergyCost.getCodeCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  public void testGetCodeCopyCost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCodeCopyCost = EnergyCost.getCodeCopyCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnDataCopyCost = EnergyCost.getReturnDataCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualReturnDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnDataCopyCost = EnergyCost.getReturnDataCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualReturnDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnDataCopyCost = EnergyCost.getReturnDataCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(18L, actualReturnDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnDataCopyCost = EnergyCost.getReturnDataCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(6L, actualReturnDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 3L, 3L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getReturnDataCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnDataCopyCost = EnergyCost.getReturnDataCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualReturnDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  public void testGetReturnDataCopyCost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnDataCopyCost = EnergyCost.getReturnDataCopyCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualReturnDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallDataCopyCost = EnergyCost.getCallDataCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualCallDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallDataCopyCost = EnergyCost.getCallDataCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualCallDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallDataCopyCost = EnergyCost.getCallDataCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(18L, actualCallDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallDataCopyCost = EnergyCost.getCallDataCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(6L, actualCallDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 3L, 3L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getCallDataCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallDataCopyCost = EnergyCost.getCallDataCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualCallDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  public void testGetCallDataCopyCost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallDataCopyCost = EnergyCost.getCallDataCopyCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualCallDataCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExtCodeCopyCost = EnergyCost.getExtCodeCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(20L, actualExtCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExtCodeCopyCost = EnergyCost.getExtCodeCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(20L, actualExtCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExtCodeCopyCost = EnergyCost.getExtCodeCopyCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(38L, actualExtCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExtCodeCopyCost = EnergyCost.getExtCodeCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(26L, actualExtCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 20L, 20L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getExtCodeCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExtCodeCopyCost = EnergyCost.getExtCodeCopyCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(29L, actualExtCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  public void testGetExtCodeCopyCost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualExtCodeCopyCost = EnergyCost.getExtCodeCopyCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(29L, actualExtCodeCopyCost);
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeHashCost(Program)}
   */
  @Test
  public void testGetExtCodeHashCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(400L, EnergyCost.getExtCodeHashCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getExtCodeHashCost(Program)}
   */
  @Test
  public void testGetExtCodeHashCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(400L, EnergyCost.getExtCodeHashCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getMloadCost(Program)}
   */
  @Test
  public void testGetMloadCost() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(3L, EnergyCost.getMloadCost(program));
  }

  /**
   * Method under test: {@link EnergyCost#getMloadCost2(Program)}
   */
  @Test
  public void testGetMloadCost2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(4L, EnergyCost.getMloadCost2(program));
  }

  /**
   * Method under test: {@link EnergyCost#getMStoreCost(Program)}
   */
  @Test
  public void testGetMStoreCost() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(3L, EnergyCost.getMStoreCost(program));
  }

  /**
   * Method under test: {@link EnergyCost#getMStoreCost2(Program)}
   */
  @Test
  public void testGetMStoreCost2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(4L, EnergyCost.getMStoreCost2(program));
  }

  /**
   * Method under test: {@link EnergyCost#getMStore8Cost(Program)}
   */
  @Test
  public void testGetMStore8Cost() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(3L, EnergyCost.getMStore8Cost(program));
  }

  /**
   * Method under test: {@link EnergyCost#getMStore8Cost2(Program)}
   */
  @Test
  public void testGetMStore8Cost2() throws UnsupportedEncodingException, ContractValidateException {
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

    // Act and Assert
    assertEquals(4L, EnergyCost.getMStore8Cost2(program));
  }

  /**
   * Method under test: {@link EnergyCost#getSloadCost(Program)}
   */
  @Test
  public void testGetSloadCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(50L, EnergyCost.getSloadCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getSloadCost(Program)}
   */
  @Test
  public void testGetSloadCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(50L, EnergyCost.getSloadCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  public void testGetReturnCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnCost = EnergyCost.getReturnCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualReturnCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  public void testGetReturnCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnCost = EnergyCost.getReturnCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualReturnCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  public void testGetReturnCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnCost = EnergyCost.getReturnCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualReturnCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  public void testGetReturnCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnCost = EnergyCost.getReturnCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualReturnCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  public void testGetReturnCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnCost = EnergyCost.getReturnCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualReturnCost);
  }

  /**
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  public void testGetReturnCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualReturnCost = EnergyCost.getReturnCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualReturnCost);
  }

  /**
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  public void testGetRevertCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualRevertCost = EnergyCost.getRevertCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualRevertCost);
  }

  /**
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  public void testGetRevertCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualRevertCost = EnergyCost.getRevertCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualRevertCost);
  }

  /**
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  public void testGetRevertCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualRevertCost = EnergyCost.getRevertCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(9L, actualRevertCost);
  }

  /**
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  public void testGetRevertCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualRevertCost = EnergyCost.getRevertCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualRevertCost);
  }

  /**
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  public void testGetRevertCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualRevertCost = EnergyCost.getRevertCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualRevertCost);
  }

  /**
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  public void testGetRevertCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualRevertCost = EnergyCost.getRevertCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualRevertCost);
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSstoreCost = EnergyCost.getSstoreCost(program);

    // Assert
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
    assertEquals(5000L, actualSstoreCost);
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSstoreCost = EnergyCost.getSstoreCost(program);

    // Assert
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
    assertEquals(5000L, actualSstoreCost);
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSstoreCost = EnergyCost.getSstoreCost(program);

    // Assert
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
    assertEquals(5000L, actualSstoreCost);
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSstoreCost = EnergyCost.getSstoreCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
    assertEquals(5000L, actualSstoreCost);
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSstoreCost = EnergyCost.getSstoreCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
    assertEquals(5000L, actualSstoreCost);
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 2L, 2L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getSstoreCost(program));
    verify(dataWord).isZero();
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  public void testGetSstoreCost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSstoreCost = EnergyCost.getSstoreCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
    assertEquals(20000L, actualSstoreCost);
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.ZERO());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualLogCost = EnergyCost.getLogCost(program);

    // Assert
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(-43875L, actualLogCost);
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualLogCost = EnergyCost.getLogCost(program);

    // Assert
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(-43875L, actualLogCost);
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(-1L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getLogCost(program));
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(-1L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getLogCost(program));
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    when(dataWord.longValue()).thenReturn(42L);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(160L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualLogCost = EnergyCost.getLogCost(program);

    // Assert
    verify(dataWord, atLeast(1)).isZero();
    verify(dataWord).longValue();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(-43539L, actualLogCost);
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    when(dataWord.longValue()).thenReturn(42L);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(160L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(-1);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualLogCost = EnergyCost.getLogCost(program);

    // Assert
    verify(dataWord, atLeast(1)).isZero();
    verify(dataWord).longValue();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(-43539L, actualLogCost);
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost7() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.longValue()).thenReturn(42L);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(160L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualLogCost = EnergyCost.getLogCost(program);

    // Assert
    verify(dataWord, atLeast(1)).isZero();
    verify(dataWord).longValue();
    verify(dataWord2).value();
    verify(dataWord, atLeast(1)).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(-43536L, actualLogCost);
  }

  /**
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  public void testGetLogCost8() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValue()).thenThrow(Program.Exception.memoryOverflow(Op.LOG0));
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(160L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfMemoryException.class, () -> EnergyCost.getLogCost(program));
    verify(dataWord).longValue();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getSuicideCost(Program)}
   */
  @Test
  public void testGetSuicideCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(0L, EnergyCost.getSuicideCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getSuicideCost(Program)}
   */
  @Test
  public void testGetSuicideCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(0L, EnergyCost.getSuicideCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getSuicideCost2(Program)}
   */
  @Test
  public void testGetSuicideCost22() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Repository repository = mock(Repository.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    Program program = mock(Program.class);
    when(program.getContractState()).thenReturn(repository);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSuicideCost2 = EnergyCost.getSuicideCost2(program);

    // Assert
    verify(program).getContractState();
    verify(program).getStack();
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualSuicideCost2);
  }

  /**
   * Method under test: {@link EnergyCost#getSuicideCost2(Program)}
   */
  @Test
  public void testGetSuicideCost23() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Repository repository = mock(Repository.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(null);
    Program program = mock(Program.class);
    when(program.getContractState()).thenReturn(repository);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSuicideCost2 = EnergyCost.getSuicideCost2(program);

    // Assert
    verify(program).getContractState();
    verify(program).getStack();
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(25000L, actualSuicideCost2);
  }

  /**
   * Method under test: {@link EnergyCost#getSuicideCost2(Program)}
   */
  @Test
  public void testGetSuicideCost24() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Stack stack = new Stack();
    stack.add(dataWord);
    Repository repository = mock(Repository.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    Program program = mock(Program.class);
    when(program.getContractState()).thenReturn(repository);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualSuicideCost2 = EnergyCost.getSuicideCost2(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(program).getContractState();
    verify(program).getStack();
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualSuicideCost2);
  }

  /**
   * Method under test: {@link EnergyCost#getBalanceCost(Program)}
   */
  @Test
  public void testGetBalanceCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(20L, EnergyCost.getBalanceCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getBalanceCost(Program)}
   */
  @Test
  public void testGetBalanceCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(20L, EnergyCost.getBalanceCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getUnfreezeCost(Program)}
   */
  @Test
  public void testGetUnfreezeCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(20000L, EnergyCost.getUnfreezeCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getUnfreezeCost(Program)}
   */
  @Test
  public void testGetUnfreezeCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(20000L, EnergyCost.getUnfreezeCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getFreezeExpireTimeCost(Program)}
   */
  @Test
  public void testGetFreezeExpireTimeCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(50L, EnergyCost.getFreezeExpireTimeCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getFreezeExpireTimeCost(Program)}
   */
  @Test
  public void testGetFreezeExpireTimeCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(50L, EnergyCost.getFreezeExpireTimeCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getFreezeBalanceV2Cost(Program)}
   */
  @Test
  public void testGetFreezeBalanceV2Cost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10000L, EnergyCost.getFreezeBalanceV2Cost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getFreezeBalanceV2Cost(Program)}
   */
  @Test
  public void testGetFreezeBalanceV2Cost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10000L, EnergyCost.getFreezeBalanceV2Cost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getUnfreezeBalanceV2Cost(Program)}
   */
  @Test
  public void testGetUnfreezeBalanceV2Cost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10000L, EnergyCost.getUnfreezeBalanceV2Cost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getUnfreezeBalanceV2Cost(Program)}
   */
  @Test
  public void testGetUnfreezeBalanceV2Cost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10000L, EnergyCost.getUnfreezeBalanceV2Cost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getWithdrawExpireUnfreezeCost(Program)}
   */
  @Test
  public void testGetWithdrawExpireUnfreezeCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10000L, EnergyCost.getWithdrawExpireUnfreezeCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getWithdrawExpireUnfreezeCost(Program)}
   */
  @Test
  public void testGetWithdrawExpireUnfreezeCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10000L, EnergyCost.getWithdrawExpireUnfreezeCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getCancelAllUnfreezeV2Cost(Program)}
   */
  @Test
  public void testGetCancelAllUnfreezeV2Cost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10000L, EnergyCost.getCancelAllUnfreezeV2Cost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getCancelAllUnfreezeV2Cost(Program)}
   */
  @Test
  public void testGetCancelAllUnfreezeV2Cost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10000L, EnergyCost.getCancelAllUnfreezeV2Cost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateResourceCost(Program)}
   */
  @Test
  public void testGetDelegateResourceCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10000L, EnergyCost.getDelegateResourceCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateResourceCost(Program)}
   */
  @Test
  public void testGetDelegateResourceCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10000L, EnergyCost.getDelegateResourceCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getUnDelegateResourceCost(Program)}
   */
  @Test
  public void testGetUnDelegateResourceCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(10000L, EnergyCost.getUnDelegateResourceCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getUnDelegateResourceCost(Program)}
   */
  @Test
  public void testGetUnDelegateResourceCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(10000L, EnergyCost.getUnDelegateResourceCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getVoteWitnessCost(Program)}
   */
  @Test
  public void testGetVoteWitnessCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualVoteWitnessCost = EnergyCost.getVoteWitnessCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(30000L, actualVoteWitnessCost);
  }

  /**
   * Method under test: {@link EnergyCost#getVoteWitnessCost2(Program)}
   */
  @Test
  public void testGetVoteWitnessCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualVoteWitnessCost2 = EnergyCost.getVoteWitnessCost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(30003L, actualVoteWitnessCost2);
  }

  /**
   * Method under test: {@link EnergyCost#getWithdrawRewardCost(Program)}
   */
  @Test
  public void testGetWithdrawRewardCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act and Assert
    assertEquals(20000L, EnergyCost.getWithdrawRewardCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
  }

  /**
   * Method under test: {@link EnergyCost#getWithdrawRewardCost(Program)}
   */
  @Test
  public void testGetWithdrawRewardCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program ignored = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    ignored.addListener(mock(Program.ProgramOutListener.class));

    // Act and Assert
    assertEquals(20000L, EnergyCost.getWithdrawRewardCost(ignored));
  }

  /**
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  public void testGetCreateCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCreateCost = EnergyCost.getCreateCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(32000L, actualCreateCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  public void testGetCreateCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCreateCost = EnergyCost.getCreateCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(32000L, actualCreateCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  public void testGetCreateCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCreateCost = EnergyCost.getCreateCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(32009L, actualCreateCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  public void testGetCreateCost4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCreateCost = EnergyCost.getCreateCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(32000L, actualCreateCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  public void testGetCreateCost5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCreateCost = EnergyCost.getCreateCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(32003L, actualCreateCost);
  }

  /**
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  public void testGetCreateCost6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCreateCost = EnergyCost.getCreateCost(program);

    // Assert
    verify(dataWord2).isZero();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(32003L, actualCreateCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.ZERO());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) 'A'));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(40L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) 'A'));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(dataWord).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost4() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) -1));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(dataWord).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost5() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenReturn(DataWord.ZERO());
    when(dataWord.longValueSafe()).thenReturn(42L);
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(dataWord).clone();
    verify(dataWord2).longValueSafe();
    verify(dataWord).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost6() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 40L, 40L));
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord).clone();
    verify(dataWord).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost7() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sub(Mockito.<DataWord>any());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenReturn(dataWord);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord3);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(dataWord2).clone();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).longValueSafe();
    verify(dataWord).sub(isA(DataWord.class));
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost8() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(3L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost9() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sub(Mockito.<DataWord>any());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenReturn(dataWord);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord3);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(dataWord2).clone();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).longValueSafe();
    verify(dataWord).sub(isA(DataWord.class));
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost10() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost11() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    doNothing().when(dataWord2).sub(Mockito.<DataWord>any());
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.clone()).thenReturn(dataWord2);
    when(dataWord3.longValueSafe()).thenReturn(42L);
    DataWord dataWord4 = mock(DataWord.class);
    when(dataWord4.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord4);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord3);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualStaticCallCost = EnergyCost.getStaticCallCost(program);

    // Assert
    verify(dataWord3).clone();
    verify(dataWord).isZero();
    verify(dataWord4).longValueSafe();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).sub(isA(DataWord.class));
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualStaticCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  public void testGetStaticCallCost12() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord).isZero();
    verify(dataWord2, atLeast(1)).longValueSafe();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.ZERO());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) 'A'));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(40L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost3() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) 'A'));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(dataWord).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost4() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) -1));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(dataWord).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost5() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenReturn(DataWord.ZERO());
    when(dataWord.longValueSafe()).thenReturn(42L);
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(dataWord).clone();
    verify(dataWord2).longValueSafe();
    verify(dataWord).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost6() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenThrow(Program.Exception.notEnoughSpendEnergy("Hint", 40L, 40L));
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord).clone();
    verify(dataWord).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost7() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sub(Mockito.<DataWord>any());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenReturn(dataWord);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord3);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(dataWord2).clone();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).longValueSafe();
    verify(dataWord).sub(isA(DataWord.class));
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost8() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(3L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost9() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sub(Mockito.<DataWord>any());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenReturn(dataWord);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord3);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(-17);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(dataWord2).clone();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).longValueSafe();
    verify(dataWord).sub(isA(DataWord.class));
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost10() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost11() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    doNothing().when(dataWord2).sub(Mockito.<DataWord>any());
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.clone()).thenReturn(dataWord2);
    when(dataWord3.longValueSafe()).thenReturn(42L);
    DataWord dataWord4 = mock(DataWord.class);
    when(dataWord4.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord4);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(dataWord3);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualDelegateCallCost = EnergyCost.getDelegateCallCost(program);

    // Assert
    verify(dataWord3).clone();
    verify(dataWord).isZero();
    verify(dataWord4).longValueSafe();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).sub(isA(DataWord.class));
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualDelegateCallCost);
  }

  /**
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  public void testGetDelegateCallCost12() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord).isZero();
    verify(dataWord2, atLeast(1)).longValueSafe();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Method under test:
   * {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  public void testGetCalculateCallCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act and Assert
    assertEquals(1L, EnergyCost.getCalculateCallCost(stack, program, 1L, 1));
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Method under test:
   * {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  public void testGetCalculateCallCost2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act and Assert
    assertEquals(1L, EnergyCost.getCalculateCallCost(stack, program, 1L, 1));
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }
}
