package org.tron.core.vm;

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
import static org.mockito.Mockito.anyByte;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Stack;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;

public class OperationActionsDiffblueTest {
  /**
   * Method under test: {@link OperationActions#stopAction(Program)}
   */
  @Test
  public void testStopAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.stopAction(program);

    // Assert
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#stopAction(Program)}
   */
  @Test
  public void testStopAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.stopAction(program);

    // Assert
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#addAction(Program)}
   */
  @Test
  public void testAddAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.addAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#addAction(Program)}
   */
  @Test
  public void testAddAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.addAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#addAction(Program)}
   */
  @Test
  public void testAddAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).add(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.addAction(program);

    // Assert that nothing has changed
    verify(dataWord).add(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  public void testMulAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.mulAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  public void testMulAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.mulAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  public void testMulAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.mulAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  public void testMulAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).mul(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.mulAction(program);

    // Assert that nothing has changed
    verify(dataWord).mul(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  public void testMulAction5() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) -1));

    // Act
    OperationActions.mulAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#subAction(Program)}
   */
  @Test
  public void testSubAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.subAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#subAction(Program)}
   */
  @Test
  public void testSubAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.subAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#subAction(Program)}
   */
  @Test
  public void testSubAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sub(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.subAction(program);

    // Assert that nothing has changed
    verify(dataWord).sub(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  public void testDivAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.divAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  public void testDivAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.divAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  public void testDivAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.divAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  public void testDivAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).div(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.divAction(program);

    // Assert that nothing has changed
    verify(dataWord).div(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  public void testSdivAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sdivAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  public void testSdivAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sdivAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  public void testSdivAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.sdivAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  public void testSdivAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sDiv(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sdivAction(program);

    // Assert that nothing has changed
    verify(dataWord).sDiv(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  public void testModAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.modAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  public void testModAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.modAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  public void testModAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.modAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  public void testModAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).mod(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.modAction(program);

    // Assert that nothing has changed
    verify(dataWord).mod(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  public void testSModAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  public void testSModAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sModAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  public void testSModAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.sModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  public void testSModAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sMod(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sModAction(program);

    // Assert that nothing has changed
    verify(dataWord).sMod(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  public void testSModAction5() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    ZEROResult.sub(DataWord.of((byte) 'A'));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(ZEROResult);

    // Act
    OperationActions.sModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  public void testAddModAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.addModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  public void testAddModAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.addModAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  public void testAddModAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.addModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  public void testAddModAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).addmod(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.addModAction(program);

    // Assert that nothing has changed
    verify(dataWord).addmod(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  public void testMulModAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.mulModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  public void testMulModAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.mulModAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  public void testMulModAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.mulModAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  public void testMulModAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).mulmod(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.mulModAction(program);

    // Assert that nothing has changed
    verify(dataWord).mulmod(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  public void testExpAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.expAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  public void testExpAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.expAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  public void testExpAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.expAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  public void testExpAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).exp(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.expAction(program);

    // Assert that nothing has changed
    verify(dataWord).exp(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  public void testExpAction5() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) -1));

    // Act
    OperationActions.expAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  public void testSignExtendAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.signExtendAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  public void testSignExtendAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.signExtendAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  public void testSignExtendAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.signExtendAction(program);

    // Assert that nothing has changed
    verify(program).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  public void testSignExtendAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).signExtend(anyByte());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.signExtendAction(program);

    // Assert that nothing has changed
    verify(dataWord).signExtend(eq((byte) 1));
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  public void testSignExtendAction5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    doThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(dataWord)
        .signExtend(anyByte());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.signExtendAction(program));
    verify(dataWord).signExtend(eq((byte) 1));
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  public void testLtAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.ltAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  public void testLtAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.ltAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  public void testLtAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.ltAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  public void testLtAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.ltAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  public void testGtAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.gtAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  public void testGtAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.gtAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  public void testGtAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.gtAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  public void testGtAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.gtAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  public void testSltAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sltAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  public void testSltAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sltAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  public void testSltAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(dataWord.sValue()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sltAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  public void testSltAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.sValue()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.sltAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  public void testSgtAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sgtAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  public void testSgtAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sgtAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  public void testSgtAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(dataWord.sValue()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sgtAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  public void testSgtAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.sValue()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.sgtAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  public void testEqAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.eqAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  public void testEqAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.eqAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  public void testEqAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenThrow(new Program.StaticCallModificationException());
    when(dataWord.xor(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.eqAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).xor(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  public void testEqAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(dataWord.xor(Mockito.<DataWord>any())).thenReturn(DataWord.of((byte) 'A'));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.eqAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).xor(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#isZeroAction(Program)}
   */
  @Test
  public void testIsZeroAction() throws UnsupportedEncodingException, ContractValidateException {
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
    OperationActions.isZeroAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", getResult.toHexString());
    assertEquals("01", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    byte[] clonedData = getResult.getClonedData();
    assertEquals((byte) 1, clonedData[31]);
    byte[] data = getResult.getData();
    assertEquals((byte) 1, data[31]);
    byte[] last20Bytes = getResult.getLast20Bytes();
    assertEquals((byte) 1, last20Bytes[Op.SGT]);
    byte[] toTronAddressResult = getResult.toTronAddress();
    assertEquals((byte) 1, toTronAddressResult[Op.EQ]);
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertEquals(Op.EQ, last20Bytes.length);
    assertEquals(Op.ISZERO, toTronAddressResult.length);
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals(Op.SHA3, clonedData.length);
    assertEquals(Op.SHA3, data.length);
    assertEquals('X', program.getCurrentOp());
    assertArrayEquals(new byte[]{1}, getResult.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link OperationActions#isZeroAction(Program)}
   */
  @Test
  public void testIsZeroAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
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
    OperationActions.isZeroAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", getResult.toHexString());
    assertEquals("01", getResult.toPrefixString());
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    byte[] clonedData = getResult.getClonedData();
    assertEquals((byte) 1, clonedData[31]);
    byte[] data = getResult.getData();
    assertEquals((byte) 1, data[31]);
    byte[] last20Bytes = getResult.getLast20Bytes();
    assertEquals((byte) 1, last20Bytes[Op.SGT]);
    byte[] toTronAddressResult = getResult.toTronAddress();
    assertEquals((byte) 1, toTronAddressResult[Op.EQ]);
    assertFalse(getResult.isZero());
    assertTrue(program.isStopped());
    assertEquals(Op.EQ, last20Bytes.length);
    assertEquals(Op.ISZERO, toTronAddressResult.length);
    assertEquals(Op.SHA3, clonedData.length);
    assertEquals(Op.SHA3, data.length);
    assertArrayEquals(new byte[]{1}, getResult.getNoLeadZeroesData());
  }

  /**
   * Method under test: {@link OperationActions#andAction(Program)}
   */
  @Test
  public void testAndAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.andAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#andAction(Program)}
   */
  @Test
  public void testAndAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.andAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#andAction(Program)}
   */
  @Test
  public void testAndAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.andAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#orAction(Program)}
   */
  @Test
  public void testOrAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.orAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#orAction(Program)}
   */
  @Test
  public void testOrAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.orAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#orAction(Program)}
   */
  @Test
  public void testOrAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.or(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.orAction(program);

    // Assert that nothing has changed
    verify(dataWord).or(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#xorAction(Program)}
   */
  @Test
  public void testXorAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.xorAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#xorAction(Program)}
   */
  @Test
  public void testXorAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.xorAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#xorAction(Program)}
   */
  @Test
  public void testXorAction3() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.xor(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.xorAction(program);

    // Assert that nothing has changed
    verify(dataWord).xor(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#notAction(Program)}
   */
  @Test
  public void testNotAction() throws UnsupportedEncodingException, ContractValidateException {
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
    OperationActions.notAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("ffffff", getResult.toPrefixString());
    assertEquals("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", getResult.toHexString());
    byte[] toTronAddressResult = getResult.toTronAddress();
    assertEquals((byte) -1, toTronAddressResult[1]);
    assertEquals((byte) -1, toTronAddressResult[12]);
    assertEquals((byte) -1, toTronAddressResult[13]);
    assertEquals((byte) -1, toTronAddressResult[14]);
    assertEquals((byte) -1, toTronAddressResult[15]);
    assertEquals((byte) -1, toTronAddressResult[2]);
    assertEquals((byte) -1, toTronAddressResult[3]);
    assertEquals((byte) -1, toTronAddressResult[4]);
    assertEquals((byte) -1, toTronAddressResult[5]);
    assertEquals((byte) -1, toTronAddressResult[6]);
    assertEquals((byte) -1, toTronAddressResult[7]);
    assertEquals((byte) -1, toTronAddressResult[8]);
    assertEquals((byte) -1, toTronAddressResult[Op.EQ]);
    assertEquals((byte) -1, toTronAddressResult[Op.EXP]);
    assertEquals((byte) -1, toTronAddressResult[Op.GT]);
    assertEquals((byte) -1, toTronAddressResult[Op.LT]);
    assertEquals((byte) -1, toTronAddressResult[Op.MULMOD]);
    assertEquals((byte) -1, toTronAddressResult[Op.SGT]);
    assertEquals((byte) -1, toTronAddressResult[Op.SIGNEXTEND]);
    assertEquals((byte) -1, toTronAddressResult[Op.SLT]);
    assertEquals(1, program.getPC());
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertTrue(getResult.isNegative());
    assertEquals(Op.ISZERO, toTronAddressResult.length);
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertSame(data, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, getResult.getClonedData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, data);
  }

  /**
   * Method under test: {@link OperationActions#notAction(Program)}
   */
  @Test
  public void testNotAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
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
    OperationActions.notAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("ffffff", getResult.toPrefixString());
    assertEquals("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", getResult.toHexString());
    byte[] toTronAddressResult = getResult.toTronAddress();
    assertEquals((byte) -1, toTronAddressResult[1]);
    assertEquals((byte) -1, toTronAddressResult[12]);
    assertEquals((byte) -1, toTronAddressResult[13]);
    assertEquals((byte) -1, toTronAddressResult[14]);
    assertEquals((byte) -1, toTronAddressResult[15]);
    assertEquals((byte) -1, toTronAddressResult[2]);
    assertEquals((byte) -1, toTronAddressResult[3]);
    assertEquals((byte) -1, toTronAddressResult[4]);
    assertEquals((byte) -1, toTronAddressResult[5]);
    assertEquals((byte) -1, toTronAddressResult[6]);
    assertEquals((byte) -1, toTronAddressResult[7]);
    assertEquals((byte) -1, toTronAddressResult[8]);
    assertEquals((byte) -1, toTronAddressResult[Op.EQ]);
    assertEquals((byte) -1, toTronAddressResult[Op.EXP]);
    assertEquals((byte) -1, toTronAddressResult[Op.GT]);
    assertEquals((byte) -1, toTronAddressResult[Op.LT]);
    assertEquals((byte) -1, toTronAddressResult[Op.MULMOD]);
    assertEquals((byte) -1, toTronAddressResult[Op.SGT]);
    assertEquals((byte) -1, toTronAddressResult[Op.SIGNEXTEND]);
    assertEquals((byte) -1, toTronAddressResult[Op.SLT]);
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isZero());
    assertTrue(getResult.isNegative());
    assertTrue(program.isStopped());
    assertEquals(Op.ISZERO, toTronAddressResult.length);
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertSame(data, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, getResult.getClonedData());
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, data);
  }

  /**
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  public void testByteAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.byteAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  public void testByteAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.byteAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  public void testByteAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.byteAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  public void testByteAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.getData()).thenThrow(new Program.StaticCallModificationException());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.byteAction(program));
    verify(dataWord).getData();
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  public void testByteAction5() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dataWord.intValue()).thenReturn(1);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.byteAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).getData();
    verify(dataWord).intValue();
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  public void testShlAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.shlAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  public void testShlAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.shlAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  public void testShlAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.shlAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  public void testShlAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.shiftLeft(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.shlAction(program);

    // Assert that nothing has changed
    verify(dataWord).shiftLeft(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  public void testShrAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.shrAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  public void testShrAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.shrAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  public void testShrAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.shrAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  public void testShrAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.shiftRight(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.shrAction(program);

    // Assert that nothing has changed
    verify(dataWord).shiftRight(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  public void testSarAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sarAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  public void testSarAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sarAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  public void testSarAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.sarAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  public void testSarAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.shiftRightSigned(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sarAction(program);

    // Assert that nothing has changed
    verify(dataWord).shiftRightSigned(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  public void testSha3Action() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sha3Action(program);

    // Assert
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  public void testSha3Action2() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sha3Action(program));
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  public void testSha3Action3() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.sha3Action(program);

    // Assert
    verify(program).memoryChunk(eq(65), eq(65));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  public void testSha3Action4() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sha3Action(program);

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).memoryChunk(eq(42), eq(42));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#addressAction(Program)}
   */
  @Test
  public void testAddressAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.addressAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#addressAction(Program)}
   */
  @Test
  public void testAddressAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.addressAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#addressAction(Program)}
   */
  @Test
  public void testAddressAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.addressAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#balanceAction(Program)}
   */
  @Test
  public void testBalanceAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBalance(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.balanceAction(program);

    // Assert that nothing has changed
    verify(program).getBalance(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#originAction(Program)}
   */
  @Test
  public void testOriginAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.originAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#originAction(Program)}
   */
  @Test
  public void testOriginAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.originAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#originAction(Program)}
   */
  @Test
  public void testOriginAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.originAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callerAction(Program)}
   */
  @Test
  public void testCallerAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callerAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("000000000000000000000000885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", getResult.toHexString());
    assertEquals("885f93", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
  }

  /**
   * Method under test: {@link OperationActions#callerAction(Program)}
   */
  @Test
  public void testCallerAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callerAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("000000000000000000000000885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", getResult.toHexString());
    assertEquals("885f93", getResult.toPrefixString());
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertTrue(program.isStopped());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
  }

  /**
   * Method under test: {@link OperationActions#callerAction(Program)}
   */
  @Test
  public void testCallerAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.callerAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("000000000000000000000000885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", getResult.toHexString());
    assertEquals("885f93", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
  }

  /**
   * Method under test: {@link OperationActions#callValueAction(Program)}
   */
  @Test
  public void testCallValueAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callValueAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callValueAction(Program)}
   */
  @Test
  public void testCallValueAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callValueAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#callValueAction(Program)}
   */
  @Test
  public void testCallValueAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.callValueAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callDataLoadAction(Program)}
   */
  @Test
  public void testCallDataLoadAction() throws UnsupportedEncodingException, ContractValidateException {
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
    OperationActions.callDataLoadAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callDataLoadAction(Program)}
   */
  @Test
  public void testCallDataLoadAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
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
    OperationActions.callDataLoadAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  public void testCallDataSizeAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  public void testCallDataSizeAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callDataSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  public void testCallDataSizeAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"));
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  public void testCallDataSizeAction4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.callDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  public void testCallDataCopyAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callDataCopyAction(program);

    // Assert that nothing has changed
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  public void testCallDataCopyAction2() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.callDataCopyAction(program));
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  public void testCallDataCopyAction3() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.callDataCopyAction(program);

    // Assert that nothing has changed
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  public void testCallDataCopyAction4() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.callDataCopyAction(program);

    // Assert that nothing has changed
    verify(dataWord).intValueSafe();
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#codeSizeAction(Program)}
   */
  @Test
  public void testCodeSizeAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.codeSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", getResult.toHexString());
    assertEquals("08", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\b'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data);
  }

  /**
   * Method under test: {@link OperationActions#codeSizeAction(Program)}
   */
  @Test
  public void testCodeSizeAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.codeSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#codeSizeAction(Program)}
   */
  @Test
  public void testCodeSizeAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.codeSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", getResult.toHexString());
    assertEquals("08", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\b'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data);
  }

  /**
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  public void testCodeCopyAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.codeCopyAction(program);

    // Assert that nothing has changed
    verify(program).getCode();
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  public void testCodeCopyAction2() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.codeCopyAction(program));
    verify(program).getCode();
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  public void testCodeCopyAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn(new byte[]{});
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.codeCopyAction(program);

    // Assert that nothing has changed
    verify(program).getCode();
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  public void testCodeCopyAction4() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.codeCopyAction(program);

    // Assert that nothing has changed
    verify(program).getCode();
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  public void testCodeCopyAction5() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.codeCopyAction(program);

    // Assert that nothing has changed
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCode();
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  public void testCodeCopyAction6() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(8);
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.codeCopyAction(program);

    // Assert that nothing has changed
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCode();
    verify(program).memorySave(eq(8), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#returnDataSizeAction(Program)}
   */
  @Test
  public void testReturnDataSizeAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.returnDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#returnDataSizeAction(Program)}
   */
  @Test
  public void testReturnDataSizeAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.returnDataSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#returnDataSizeAction(Program)}
   */
  @Test
  public void testReturnDataSizeAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.returnDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  public void testReturnDataCopyAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.returnDataCopyAction(program);

    // Assert that nothing has changed
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  public void testReturnDataCopyAction2() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.returnDataCopyAction(program));
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  public void testReturnDataCopyAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(null);
    when(program.getReturnDataBufferSize()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class,
        () -> OperationActions.returnDataCopyAction(program));
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).getReturnDataBufferSize();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  public void testReturnDataCopyAction4() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.returnDataCopyAction(program);

    // Assert that nothing has changed
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  public void testReturnDataCopyAction5() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.returnDataCopyAction(program);

    // Assert that nothing has changed
    verify(dataWord).intValueSafe();
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  public void testReturnDataCopyAction6() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(null);
    when(program.getReturnDataBufferSize()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(mock(DataWord.class));

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class,
        () -> OperationActions.returnDataCopyAction(program));
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).getReturnDataBufferSize();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#gasPriceAction(Program)}
   */
  @Test
  public void testGasPriceAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.gasPriceAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#gasPriceAction(Program)}
   */
  @Test
  public void testGasPriceAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.gasPriceAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#gasPriceAction(Program)}
   */
  @Test
  public void testGasPriceAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.gasPriceAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#extCodeSizeAction(Program)}
   */
  @Test
  public void testExtCodeSizeAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.extCodeSizeAction(program);

    // Assert
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#extCodeSizeAction(Program)}
   */
  @Test
  public void testExtCodeSizeAction2() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.extCodeSizeAction(program));
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  public void testExtCodeCopyAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert that nothing has changed
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  public void testExtCodeCopyAction2() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.extCodeCopyAction(program));
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  public void testExtCodeCopyAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn(new byte[]{});
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert that nothing has changed
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  public void testExtCodeCopyAction4() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert that nothing has changed
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  public void testExtCodeCopyAction5() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert that nothing has changed
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  public void testExtCodeCopyAction6() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(8);
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert that nothing has changed
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(8), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#extCodeHashAction(Program)}
   */
  @Test
  public void testExtCodeHashAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCodeHashAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.extCodeHashAction(program);

    // Assert
    verify(program).getCodeHashAt(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  public void testBlockHashAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.blockHashAction(program);

    // Assert that nothing has changed
    verify(program).getBlockHash(eq(0));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  public void testBlockHashAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenThrow(new Program.StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.blockHashAction(program));
    verify(program).getBlockHash(eq(0));
    verify(program).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  public void testBlockHashAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.blockHashAction(program);

    // Assert that nothing has changed
    verify(program).getBlockHash(eq(65));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  public void testBlockHashAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.blockHashAction(program);

    // Assert that nothing has changed
    verify(dataWord).intValueSafe();
    verify(program).getBlockHash(eq(42));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#coinBaseAction(Program)}
   */
  @Test
  public void testCoinBaseAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.coinBaseAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#coinBaseAction(Program)}
   */
  @Test
  public void testCoinBaseAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.coinBaseAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#coinBaseAction(Program)}
   */
  @Test
  public void testCoinBaseAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.coinBaseAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#timeStampAction(Program)}
   */
  @Test
  public void testTimeStampAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.timeStampAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#timeStampAction(Program)}
   */
  @Test
  public void testTimeStampAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.timeStampAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#timeStampAction(Program)}
   */
  @Test
  public void testTimeStampAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.timeStampAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#numberAction(Program)}
   */
  @Test
  public void testNumberAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.numberAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#numberAction(Program)}
   */
  @Test
  public void testNumberAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.numberAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#numberAction(Program)}
   */
  @Test
  public void testNumberAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.numberAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#difficultyAction(Program)}
   */
  @Test
  public void testDifficultyAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.difficultyAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#difficultyAction(Program)}
   */
  @Test
  public void testDifficultyAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.difficultyAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#difficultyAction(Program)}
   */
  @Test
  public void testDifficultyAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.difficultyAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#gasLimitAction(Program)}
   */
  @Test
  public void testGasLimitAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.gasLimitAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#gasLimitAction(Program)}
   */
  @Test
  public void testGasLimitAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.gasLimitAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#gasLimitAction(Program)}
   */
  @Test
  public void testGasLimitAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.gasLimitAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#chainIdAction(Program)}
   */
  @Test
  public void testChainIdAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.chainIdAction(program);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#chainIdAction(Program)}
   */
  @Test
  public void testChainIdAction2() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.chainIdAction(program);

    // Assert
    verify(blockCapsule).getBlockId();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(ZEROResult, stack.get(0));
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#chainIdAction(Program)}
   */
  @Test
  public void testChainIdAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    DataWord ZEROResult = DataWord.ZERO();
    when(programInvoke.getContractAddress()).thenReturn(ZEROResult);
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.chainIdAction(program);

    // Assert
    verify(blockCapsule).getBlockId();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
    assertEquals(ZEROResult, stack.get(0));
  }

  /**
   * Method under test: {@link OperationActions#chainIdAction(Program)}
   */
  @Test
  public void testChainIdAction4() throws UnsupportedEncodingException, ContractValidateException {
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
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.chainIdAction(program);

    // Assert
    verify(blockId).getBytes();
    verify(blockCapsule).getBlockId();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(0L));
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#chainIdAction(Program)}
   */
  @Test
  public void testChainIdAction5() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getChainId()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.chainIdAction(program);

    // Assert that nothing has changed
    verify(program).getChainId();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#selfBalanceAction(Program)}
   */
  @Test
  public void testSelfBalanceAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.selfBalanceAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#selfBalanceAction(Program)}
   */
  @Test
  public void testSelfBalanceAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.selfBalanceAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#selfBalanceAction(Program)}
   */
  @Test
  public void testSelfBalanceAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.selfBalanceAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#popAction(Program)}
   */
  @Test
  public void testPopAction() throws UnsupportedEncodingException, ContractValidateException {
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
    OperationActions.popAction(program);

    // Assert
    List<Descriptors.EnumDescriptor> enumTypes = program.getResult()
        .getRet()
        .getInstance()
        .getDescriptorForType()
        .getEnumTypes();
    assertEquals(2, enumTypes.size());
    DescriptorProtos.EnumDescriptorProto toProtoResult = enumTypes.get(1).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("contractResult", toProtoResult.getName());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertTrue(program.getStack().isEmpty());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#popAction(Program)}
   */
  @Test
  public void testPopAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
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
    OperationActions.popAction(program);

    // Assert
    List<Descriptors.EnumDescriptor> enumTypes = program.getResult()
        .getRet()
        .getInstance()
        .getDescriptorForType()
        .getEnumTypes();
    assertEquals(2, enumTypes.size());
    DescriptorProtos.EnumDescriptorProto toProtoResult = enumTypes.get(1).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("contractResult", toProtoResult.getName());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.getStack().isEmpty());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#mLoadAction(Program)}
   */
  @Test
  public void testMLoadAction() throws UnsupportedEncodingException, ContractValidateException {
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
    OperationActions.mLoadAction(program);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals(Op.SHA3, program.getMemSize());
    assertEquals('X', program.getCurrentOp());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link OperationActions#mLoadAction(Program)}
   */
  @Test
  public void testMLoadAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
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
    OperationActions.mLoadAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals(0, program.getResult().getHReturn().length);
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
    assertEquals(Op.SHA3, program.getMemSize());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        program.getMemory());
  }

  /**
   * Method under test: {@link OperationActions#mLoadAction(Program)}
   */
  @Test
  public void testMLoadAction3() throws UnsupportedEncodingException, ContractValidateException {
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

    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.mLoadAction(program);

    // Assert
    assertEquals(0, program.getResult().getHReturn().length);
    byte[] memory = program.getMemory();
    assertEquals((byte) 0, memory[0]);
    assertEquals((byte) 0, memory[1]);
    assertEquals((byte) 0, memory[12]);
    assertEquals((byte) 0, memory[13]);
    assertEquals((byte) 0, memory[14]);
    assertEquals((byte) 0, memory[15]);
    assertEquals((byte) 0, memory[2]);
    assertEquals((byte) 0, memory[3]);
    assertEquals((byte) 0, memory[4]);
    assertEquals((byte) 0, memory[5]);
    assertEquals((byte) 0, memory[6]);
    assertEquals((byte) 0, memory[7]);
    assertEquals((byte) 0, memory[8]);
    assertEquals((byte) 0, memory[Op.AND]);
    assertEquals((byte) 0, memory[Op.EQ]);
    assertEquals((byte) 0, memory[Op.EXP]);
    assertEquals((byte) 0, memory[Op.GT]);
    assertEquals((byte) 0, memory[Op.ISZERO]);
    assertEquals((byte) 0, memory[Op.LT]);
    assertEquals((byte) 0, memory[Op.MULMOD]);
    assertEquals((byte) 0, memory[Op.OR]);
    assertEquals((byte) 0, memory[Op.SGT]);
    assertEquals((byte) 0, memory[Op.SIGNEXTEND]);
    assertEquals((byte) 0, memory[Op.SLT]);
    assertEquals((byte) 0, memory[Op.XOR]);
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals(Op.PUSH1, program.getMemSize());
    assertEquals(Op.PUSH1, memory.length);
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#mStoreAction(Program)}
   */
  @Test
  public void testMStoreAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memorySave(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.mStoreAction(program);

    // Assert that nothing has changed
    verify(program).memorySave(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mStore8Action(Program)}
   */
  @Test
  public void testMStore8Action() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.mStore8Action(program);

    // Assert
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#mStore8Action(Program)}
   */
  @Test
  public void testMStore8Action2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.mStore8Action(program));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#mStore8Action(Program)}
   */
  @Test
  public void testMStore8Action3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.mStore8Action(program);

    // Assert
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  public void testSLoadAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sLoadAction(program);

    // Assert that nothing has changed
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  public void testSLoadAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sLoadAction(program));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  public void testSLoadAction3() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);

    // Act
    OperationActions.sLoadAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  public void testSLoadAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);

    // Act
    OperationActions.sLoadAction(program);

    // Assert that nothing has changed
    verify(dataWord).and(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#sStoreAction(Program)}
   */
  @Test
  public void testSStoreAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sStoreAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#sStoreAction(Program)}
   */
  @Test
  public void testSStoreAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.sStoreAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#sStoreAction(Program)}
   */
  @Test
  public void testSStoreAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).step();
    doNothing().when(program).storageSave(Mockito.<DataWord>any(), Mockito.<DataWord>any());

    // Act
    OperationActions.sStoreAction(program);

    // Assert that nothing has changed
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).storageSave(isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#jumpAction(Program)}
   */
  @Test
  public void testJumpAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.verifyJumpDest(Mockito.<DataWord>any())).thenReturn(1);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).setPC(anyInt());

    // Act
    OperationActions.jumpAction(program);

    // Assert that nothing has changed
    verify(program).setPC(eq(1));
    verify(program).stackPop();
    verify(program).verifyJumpDest(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  public void testJumpIAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.jumpIAction(program);

    // Assert that nothing has changed
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  public void testJumpIAction2() {
    // Arrange
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.jumpIAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  public void testJumpIAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.verifyJumpDest(Mockito.<DataWord>any())).thenReturn(1);
    doNothing().when(program).setPC(anyInt());
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.jumpIAction(program);

    // Assert that nothing has changed
    verify(program).setPC(eq(1));
    verify(program, atLeast(1)).stackPop();
    verify(program).verifyJumpDest(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  public void testJumpIAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.jumpIAction(program);

    // Assert that nothing has changed
    verify(dataWord).isZero();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  public void testJumpIAction5() {
    // Arrange
    Program program = mock(Program.class);
    when(program.verifyJumpDest(Mockito.<DataWord>any())).thenThrow(new Program.StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.jumpIAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).verifyJumpDest(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#pcAction(Program)}
   */
  @Test
  public void testPcAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.pcAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#pcAction(Program)}
   */
  @Test
  public void testPcAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.pcAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#pcAction(Program)}
   */
  @Test
  public void testPcAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.pcAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#mSizeAction(Program)}
   */
  @Test
  public void testMSizeAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.mSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#mSizeAction(Program)}
   */
  @Test
  public void testMSizeAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.mSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#mSizeAction(Program)}
   */
  @Test
  public void testMSizeAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.mSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#gasAction(Program)}
   */
  @Test
  public void testGasAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.gasAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#gasAction(Program)}
   */
  @Test
  public void testGasAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.gasAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#gasAction(Program)}
   */
  @Test
  public void testGasAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.gasAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#jumpDestAction(Program)}
   */
  @Test
  public void testJumpDestAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.jumpDestAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#jumpDestAction(Program)}
   */
  @Test
  public void testJumpDestAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.jumpDestAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#jumpDestAction(Program)}
   */
  @Test
  public void testJumpDestAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.jumpDestAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#push0Action(Program)}
   */
  @Test
  public void testPush0Action() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.push0Action(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#push0Action(Program)}
   */
  @Test
  public void testPush0Action2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.push0Action(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#push0Action(Program)}
   */
  @Test
  public void testPush0Action3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.push0Action(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#pushAction(Program)}
   */
  @Test
  public void testPushAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "`XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.pushAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000058", getResult.toHexString());
    assertEquals("58", getResult.toPrefixString());
    assertEquals(2, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertEquals(Op.COINBASE, program.getCurrentOpIntValue());
    assertEquals('A', program.getCurrentOp());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'X'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'X'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'X'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'X'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'X'},
        data);
  }

  /**
   * Method under test: {@link OperationActions#pushAction(Program)}
   */
  @Test
  public void testPushAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, codeAddress,
        programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.pushAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("584158", getResult.toPrefixString());
    assertEquals("5841584158415800000000000000000000000000000000000000000000000000", getResult.toHexString());
    assertEquals(33, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertTrue(program.isStopped());
    byte[] data = getResult.getData();
    assertSame(data, getResult.getNoLeadZeroesData());
    byte[] expectedNoEndZeroesData = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoEndZeroesData, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, getResult.getClonedData());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, data);
  }

  /**
   * Method under test: {@link OperationActions#dupAction(Program)}
   */
  @Test
  public void testDupAction() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getCurrentOpIntValue()).thenReturn(Op.DUP1);
    when(program.getStack()).thenReturn(stack);

    // Act
    OperationActions.dupAction(program);

    // Assert
    verify(program).getCurrentOpIntValue();
    verify(program).getStack();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#dupAction(Program)}
   */
  @Test
  public void testDupAction2() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenReturn(DataWord.ZERO());

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getCurrentOpIntValue()).thenReturn(Op.DUP1);
    when(program.getStack()).thenReturn(stack);

    // Act
    OperationActions.dupAction(program);

    // Assert that nothing has changed
    verify(dataWord).clone();
    verify(program).getCurrentOpIntValue();
    verify(program).getStack();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#swapAction(Program)}
   */
  @Test
  public void testSwapAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.swapAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#swapAction(Program)}
   */
  @Test
  public void testSwapAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.swapAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#swapAction(Program)}
   */
  @Test
  public void testSwapAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.swapAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#swapAction(Program)}
   */
  @Test
  public void testSwapAction4() throws UnsupportedEncodingException, ContractValidateException {
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
    MessageCall msg = new MessageCall(Op.SUICIDE, energy, codeAddress2, endowment, inDataOffs, inDataSize,
        DataWord.ZERO(), true);

    program.callToPrecompiledAddress(msg, new PrecompiledContracts.AvailableUnfreezeV2Size());
    program.addListener(mock(Program.ProgramOutListener.class));

    // Act
    OperationActions.swapAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.logAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);
    when(program.getStack()).thenReturn(new Stack());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.logAction(program));
    verify(program).getStack();
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction3() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());
    when(program.isStaticCall()).thenReturn(false);
    when(program.getContractAddress()).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act
    OperationActions.logAction(program);

    // Assert
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction4() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());
    when(program.isStaticCall()).thenReturn(false);
    when(program.getContractAddress()).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.logAction(program));
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction5() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addLogInfo(new LogInfo(new byte[]{'A', -96, 'A', -96, 'A', -96, 'A', -96}, new ArrayList<>(),
        new byte[]{'A', -96, 'A', -96, 'A', -96, 'A', -96}));
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getResult()).thenReturn(createEmptyResult);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getContractAddress()).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act
    OperationActions.logAction(program);

    // Assert
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction6() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    ProgramResult programResult = mock(ProgramResult.class);
    doNothing().when(programResult).addLogInfo(Mockito.<LogInfo>any());
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getResult()).thenReturn(programResult);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getContractAddress()).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act
    OperationActions.logAction(program);

    // Assert
    verify(programResult).addLogInfo(isA(LogInfo.class));
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  public void testLogAction7() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.getLast20Bytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    ProgramResult programResult = mock(ProgramResult.class);
    doNothing().when(programResult).addLogInfo(Mockito.<LogInfo>any());
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getResult()).thenReturn(programResult);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getContractAddress()).thenReturn(dataWord);
    when(program.getStack()).thenReturn(stack);

    // Act
    OperationActions.logAction(program);

    // Assert
    verify(programResult).addLogInfo(isA(LogInfo.class));
    verify(dataWord).getLast20Bytes();
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#tokenBalanceAction(Program)}
   */
  @Test
  public void testTokenBalanceAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getTokenBalance(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.tokenBalanceAction(program);

    // Assert that nothing has changed
    verify(program).getTokenBalance(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callTokenValueAction(Program)}
   */
  @Test
  public void testCallTokenValueAction() throws UnsupportedEncodingException, ContractValidateException {
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
        lastHash, coinbase, 10L, 1L, RepositoryImpl.createRoot(StoreFactory.getInstance()), 1L, 1L, 1L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callTokenValueAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callTokenValueAction(Program)}
   */
  @Test
  public void testCallTokenValueAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, RepositoryImpl.createRoot(StoreFactory.getInstance()), 1L, 1L, 1L);

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callTokenValueAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#callTokenIdAction(Program)}
   */
  @Test
  public void testCallTokenIdAction() throws UnsupportedEncodingException, ContractValidateException {
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
        lastHash, coinbase, 10L, 1L, RepositoryImpl.createRoot(StoreFactory.getInstance()), 1L, 1L, 1L);

    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callTokenIdAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Method under test: {@link OperationActions#callTokenIdAction(Program)}
   */
  @Test
  public void testCallTokenIdAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvoke = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, RepositoryImpl.createRoot(StoreFactory.getInstance()), 1L, 1L, 1L);

    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.callTokenIdAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Method under test: {@link OperationActions#isContractAction(Program)}
   */
  @Test
  public void testIsContractAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isContract(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.isContractAction(program);

    // Assert that nothing has changed
    verify(program).isContract(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#freezeAction(Program)}
   */
  @Test
  public void testFreezeAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.freeze(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.freezeAction(program);

    // Assert
    verify(program).freeze(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#freezeAction(Program)}
   */
  @Test
  public void testFreezeAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.freeze(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.freezeAction(program);

    // Assert
    verify(program).freeze(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#unfreezeAction(Program)}
   */
  @Test
  public void testUnfreezeAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.unfreeze(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.unfreezeAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).unfreeze(isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#unfreezeAction(Program)}
   */
  @Test
  public void testUnfreezeAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.unfreeze(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.unfreezeAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).unfreeze(isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#freezeExpireTimeAction(Program)}
   */
  @Test
  public void testFreezeExpireTimeAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.freezeExpireTime(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(1L);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.freezeExpireTimeAction(program);

    // Assert
    verify(program).freezeExpireTime(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  public void testFreezeBalanceV2Action() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.freezeBalanceV2Action(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  public void testFreezeBalanceV2Action2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.freezeBalanceV2Action(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  public void testFreezeBalanceV2Action3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.freezeBalanceV2(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(true);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.freezeBalanceV2Action(program);

    // Assert
    verify(program).freezeBalanceV2(isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  public void testFreezeBalanceV2Action4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.freezeBalanceV2(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(false);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.freezeBalanceV2Action(program);

    // Assert
    verify(program).freezeBalanceV2(isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  public void testUnfreezeBalanceV2Action() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.unfreezeBalanceV2Action(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  public void testUnfreezeBalanceV2Action2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class,
        () -> OperationActions.unfreezeBalanceV2Action(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  public void testUnfreezeBalanceV2Action3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.unfreezeBalanceV2(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.unfreezeBalanceV2Action(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).unfreezeBalanceV2(isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  public void testUnfreezeBalanceV2Action4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.unfreezeBalanceV2(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.unfreezeBalanceV2Action(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).unfreezeBalanceV2(isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test:
   * {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  public void testWithdrawExpireUnfreezeAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.withdrawExpireUnfreezeAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test:
   * {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  public void testWithdrawExpireUnfreezeAction2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.withdrawExpireUnfreezeAction(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawExpireUnfreeze", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(program.isStopped());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test:
   * {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  public void testWithdrawExpireUnfreezeAction3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.withdrawExpireUnfreezeAction(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("withdrawExpireUnfreeze", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertTrue(program.isStopped());
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
   * Method under test:
   * {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  public void testWithdrawExpireUnfreezeAction4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.withdrawExpireUnfreezeAction(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(program.isStopped());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test:
   * {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  public void testWithdrawExpireUnfreezeAction5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(null);
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.withdrawExpireUnfreezeAction(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(program.isStopped());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test:
   * {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  public void testWithdrawExpireUnfreezeAction6() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    OperationActions.withdrawExpireUnfreezeAction(program);

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  public void testCancelAllUnfreezeV2Action() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.cancelAllUnfreezeV2Action(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test:
   * {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  public void testCancelAllUnfreezeV2Action2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.cancelAllUnfreezeV2Action(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(program.isStopped());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test:
   * {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  public void testCancelAllUnfreezeV2Action3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.cancelAllUnfreezeV2Action(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    InternalTransaction getResult = internalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("cancelAllUnfreezeV2", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals(0, getResult.getData().length);
    assertEquals(0L, getResult.getValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertTrue(program.isStopped());
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
   * Method under test:
   * {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  public void testCancelAllUnfreezeV2Action4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.cancelAllUnfreezeV2Action(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(program.isStopped());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test:
   * {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
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
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.cancelAllUnfreezeV2Action(program);

    // Assert
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertFalse(program.isStopped());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test:
   * {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  public void testCancelAllUnfreezeV2Action6() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Repository repository = mock(Repository.class);
    when(repository.newRepositoryChild()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    OperationActions.cancelAllUnfreezeV2Action(program);

    // Assert
    verify(internalTransaction).getHash();
    verify(internalTransaction).getNonce();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(2L, getResult.getNonce());
    assertEquals(2L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  public void testDelegateResourceAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.delegateResourceAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  public void testDelegateResourceAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.delegateResourceAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  public void testDelegateResourceAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.delegateResource(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn(true);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateResourceAction(program);

    // Assert
    verify(program).delegateResource(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  public void testDelegateResourceAction4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.delegateResource(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn(false);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateResourceAction(program);

    // Assert
    verify(program).delegateResource(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  public void testUnDelegateResourceAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.unDelegateResourceAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  public void testUnDelegateResourceAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class,
        () -> OperationActions.unDelegateResourceAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  public void testUnDelegateResourceAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.unDelegateResource(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.unDelegateResourceAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).unDelegateResource(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  public void testUnDelegateResourceAction4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.unDelegateResource(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.unDelegateResourceAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).unDelegateResource(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.voteWitnessAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.voteWitnessAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.voteWitness(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(true);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.voteWitnessAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).voteWitness(eq(0), eq(0), eq(0), eq(0));
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.voteWitness(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(false);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.voteWitnessAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).voteWitness(eq(0), eq(0), eq(0), eq(0));
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction5() {
    // Arrange
    Program program = mock(Program.class);
    when(program.voteWitness(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(true);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.voteWitnessAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).voteWitness(eq(65), eq(65), eq(65), eq(65));
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    when(program.voteWitness(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(true);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.voteWitnessAction(program);

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).voteWitness(eq(42), eq(42), eq(42), eq(42));
  }

  /**
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  public void testVoteWitnessAction7() {
    // Arrange
    Program program = mock(Program.class);
    when(program.voteWitness(anyInt(), anyInt(), anyInt(), anyInt()))
        .thenThrow(new Program.StaticCallModificationException());
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.voteWitnessAction(program));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).voteWitness(eq(0), eq(0), eq(0), eq(0));
  }

  /**
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  public void testWithdrawRewardAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.withdrawRewardAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  public void testWithdrawRewardAction2() throws UnsupportedEncodingException, ContractValidateException {
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
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(repository);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE));

    // Act
    OperationActions.withdrawRewardAction(program);

    // Assert
    verify(dataWord3).clone();
    verify(dataWord2).longValue();
    verify(dataWord).toTronAddress();
    verify(programInvoke).getCallDeep();
    verify(programInvoke, atLeast(1)).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).getTimestamp();
    verify(programInvoke).isStaticCall();
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
    assertEquals(1, program.getStack().size());
    assertEquals(1, getResult.getDeep());
    assertEquals(1, program.getPC());
    assertEquals(1L, getResult.getNonce());
    assertEquals(1L, program.getNonce());
    assertTrue(getResult.getTokenInfo().isEmpty());
    assertTrue(getResult.isRejected());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
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
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  public void testWithdrawRewardAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.withdrawRewardAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  public void testWithdrawRewardAction4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.withdrawReward()).thenReturn(1L);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.withdrawRewardAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).withdrawReward();
  }

  /**
   * Method under test: {@link OperationActions#createAction(Program)}
   */
  @Test
  public void testCreateAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.createAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#createAction(Program)}
   */
  @Test
  public void testCreateAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.createAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#createAction(Program)}
   */
  @Test
  public void testCreateAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).createContract(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.createAction(program);

    // Assert that nothing has changed
    verify(program).createContract(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  public void testReturnAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.returnAction(program);

    // Assert that nothing has changed
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  public void testReturnAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenThrow(new Program.StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.returnAction(program));
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  public void testReturnAction3() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.returnAction(program);

    // Assert that nothing has changed
    verify(program).memoryChunk(eq(65), eq(65));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  public void testReturnAction4() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.returnAction(program);

    // Assert that nothing has changed
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).memoryChunk(eq(42), eq(42));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#create2Action(Program)}
   */
  @Test
  public void testCreate2Action() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.create2Action(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#create2Action(Program)}
   */
  @Test
  public void testCreate2Action2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.create2Action(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#create2Action(Program)}
   */
  @Test
  public void testCreate2Action3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program)
        .createContract2(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any(),
            Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.create2Action(program);

    // Assert that nothing has changed
    verify(program).createContract2(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  public void testCallAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  public void testCallAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program)
        .memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.callAction(program));
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  public void testCallAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(false);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  public void testCallAction4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.callAction(program));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  public void testCallAction5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.callAction(program);

    // Assert
    verify(dataWord, atLeast(1)).isZero();
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  public void testCallAction6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.isZero()).thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.callAction(program));
    verify(dataWord).isZero();
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  public void testCallTokenAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callTokenAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  public void testCallTokenAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program)
        .memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.callTokenAction(program));
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  public void testCallTokenAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(false);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callTokenAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  public void testCallTokenAction4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.callTokenAction(program));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  public void testCallTokenAction5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.callTokenAction(program);

    // Assert
    verify(dataWord, atLeast(1)).isZero();
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  public void testCallTokenAction6() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.isZero()).thenThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.callTokenAction(program));
    verify(dataWord).isZero();
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  public void testCallCodeAction() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callCodeAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  public void testCallCodeAction2() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program)
        .memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.callCodeAction(program));
    verify(program).getAdjustedCallEnergy();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  public void testCallCodeAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.callCodeAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  public void testCallCodeAction4() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.callCodeAction(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  public void testCallCodeAction5() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).add(Mockito.<DataWord>any());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.isZero()).thenReturn(false);
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.getAdjustedCallEnergy()).thenReturn(dataWord);
    when(program.stackPop()).thenReturn(dataWord2);

    // Act
    OperationActions.callCodeAction(program);

    // Assert
    verify(dataWord).add(isA(DataWord.class));
    verify(dataWord2).isZero();
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  public void testDelegateCallAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  public void testDelegateCallAction2() {
    // Arrange
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program)
        .callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class,
        () -> OperationActions.delegateCallAction(program));
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  public void testDelegateCallAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  public void testDelegateCallAction4() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(mock(DataWord.class));
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  public void testDelegateCallAction5() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    ZEROResult.exp(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(ZEROResult);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  public void testDelegateCallAction6() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(false);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  public void testStaticCallAction() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  public void testStaticCallAction2() {
    // Arrange
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new Program.ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program)
        .callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());

    // Act and Assert
    assertThrows(Program.ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.staticCallAction(program));
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  public void testStaticCallAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  public void testStaticCallAction4() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(mock(DataWord.class));
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  public void testStaticCallAction5() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    ZEROResult.exp(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(ZEROResult);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  public void testStaticCallAction6() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(false);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test:
   * {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  public void testExeCall() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord codeAddress = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act
    OperationActions.exeCall(program, adjustedCallEnergy, codeAddress, value, DataWord.ZERO(), true);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test:
   * {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  public void testExeCall2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act
    OperationActions.exeCall(program, adjustedCallEnergy, null, value, DataWord.ZERO(), true);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test:
   * {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  public void testExeCall3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(false);
    doNothing().when(program)
        .callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContracts.PrecompiledContract>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act
    OperationActions.exeCall(program, adjustedCallEnergy, null, value, DataWord.ZERO(), true);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class),
        isA(PrecompiledContracts.PrecompiledContract.class));
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test:
   * {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  public void testExeCall4() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).callToAddress(Mockito.<MessageCall>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord codeAddress = mock(DataWord.class);
    DataWord value = DataWord.ZERO();

    // Act
    OperationActions.exeCall(program, adjustedCallEnergy, codeAddress, value, DataWord.ZERO(), true);

    // Assert
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Method under test:
   * {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  public void testExeCall5() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenThrow(new Program.StaticCallModificationException());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class,
        () -> OperationActions.exeCall(program, adjustedCallEnergy, null, value, DataWord.ZERO(), true));
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  public void testRevertAction() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.revertAction(program);

    // Assert
    verify(program).getResult();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  public void testRevertAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenThrow(new Program.StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.revertAction(program));
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  public void testRevertAction3() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult programResult = mock(ProgramResult.class);
    doNothing().when(programResult).setRevert();
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getResult()).thenReturn(programResult);
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.revertAction(program);

    // Assert that nothing has changed
    verify(programResult).setRevert();
    verify(program).getResult();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  public void testRevertAction4() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult programResult = mock(ProgramResult.class);
    doNothing().when(programResult).setRevert();
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getResult()).thenReturn(programResult);
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.revertAction(program);

    // Assert that nothing has changed
    verify(programResult).setRevert();
    verify(program).getResult();
    verify(program).memoryChunk(eq(65), eq(65));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  public void testRevertAction5() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.intValueSafe()).thenReturn(42);
    ProgramResult programResult = mock(ProgramResult.class);
    doNothing().when(programResult).setRevert();
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getResult()).thenReturn(programResult);
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.revertAction(program);

    // Assert that nothing has changed
    verify(programResult).setRevert();
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getResult();
    verify(program).memoryChunk(eq(42), eq(42));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  public void testSuicideAction() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.suicideAction(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE))));
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  public void testSuicideAction2() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.suicideAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  public void testSuicideAction3() {
    // Arrange
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stop();
    doNothing().when(program).suicide(Mockito.<DataWord>any());
    when(program.canSuicide()).thenReturn(true);
    when(program.isStaticCall()).thenReturn(false);

    // Act
    OperationActions.suicideAction(program);

    // Assert that nothing has changed
    verify(program).canSuicide();
    verify(program).isStaticCall();
    verify(program).stackPop();
    verify(program).stop();
    verify(program).suicide(isA(DataWord.class));
  }

  /**
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  public void testSuicideAction4() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stop();
    when(program.canSuicide()).thenReturn(false);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());

    // Act
    OperationActions.suicideAction(program);

    // Assert
    verify(program).canSuicide();
    verify(program).getResult();
    verify(program).isStaticCall();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  public void testSuicideAction5() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new Program.StaticCallModificationException()).when(program).stop();
    when(program.canSuicide()).thenReturn(false);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());

    // Act and Assert
    assertThrows(Program.StaticCallModificationException.class, () -> OperationActions.suicideAction(program));
    verify(program).canSuicide();
    verify(program).getResult();
    verify(program).isStaticCall();
    verify(program).stop();
  }

  /**
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  public void testSuicideAction6() {
    // Arrange
    ProgramResult programResult = mock(ProgramResult.class);
    doNothing().when(programResult).setRevert();
    Program program = mock(Program.class);
    doNothing().when(program).stop();
    when(program.canSuicide()).thenReturn(false);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getResult()).thenReturn(programResult);

    // Act
    OperationActions.suicideAction(program);

    // Assert that nothing has changed
    verify(programResult).setRevert();
    verify(program).canSuicide();
    verify(program).getResult();
    verify(program).isStaticCall();
    verify(program).stop();
  }
}
