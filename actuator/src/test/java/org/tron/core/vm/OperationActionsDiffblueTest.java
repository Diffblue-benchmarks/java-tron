package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyByte;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.ProgramResult;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.PrecompiledContracts.PrecompiledContract;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Program.ReturnDataCopyIllegalBoundsException;
import org.tron.core.vm.program.Program.StaticCallModificationException;
import org.tron.core.vm.program.Stack;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class OperationActionsDiffblueTest {
  /**
   * Test {@link OperationActions#stopAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#stopAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.stopAction(Program)"})
  public void testStopAction() throws UnsupportedEncodingException {
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
    OperationActions.stopAction(program);

    // Assert
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link OperationActions#addAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#add(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#add(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addAction(Program)"})
  public void testAddAction_givenDataWordAddDoesNothing_thenCallsAdd() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).add(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.addAction(program);

    // Assert
    verify(dataWord).add(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#addAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addAction(Program)"})
  public void testAddAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#addAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addAction(Program)"})
  public void testAddAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.addAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#mulAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#mul(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#mul(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulAction(Program)"})
  public void testMulAction_givenDataWordMulDoesNothing_thenCallsMul() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).mul(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.mulAction(program);

    // Assert
    verify(dataWord).mul(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#mulAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulAction(Program)"})
  public void testMulAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#mulAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulAction(Program)"})
  public void testMulAction_givenDataWordWithNumIsMinusOne() {
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
   * Test {@link OperationActions#mulAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulAction(Program)"})
  public void testMulAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#mulAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulAction(Program)"})
  public void testMulAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.mulAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#subAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sub(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sub(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#subAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.subAction(Program)"})
  public void testSubAction_givenDataWordSubDoesNothing_thenCallsSub() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sub(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.subAction(program);

    // Assert
    verify(dataWord).sub(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#subAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#subAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.subAction(Program)"})
  public void testSubAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#subAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#subAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.subAction(Program)"})
  public void testSubAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.subAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#divAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#div(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#div(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.divAction(Program)"})
  public void testDivAction_givenDataWordDivDoesNothing_thenCallsDiv() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).div(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.divAction(program);

    // Assert
    verify(dataWord).div(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#divAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.divAction(Program)"})
  public void testDivAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#divAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.divAction(Program)"})
  public void testDivAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#divAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#divAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.divAction(Program)"})
  public void testDivAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.divAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sdivAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sDiv(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sDiv(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sdivAction(Program)"})
  public void testSdivAction_givenDataWordSDivDoesNothing_thenCallsSDiv() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sDiv(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sdivAction(program);

    // Assert
    verify(dataWord).sDiv(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#sdivAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sdivAction(Program)"})
  public void testSdivAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#sdivAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sdivAction(Program)"})
  public void testSdivAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#sdivAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sdivAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sdivAction(Program)"})
  public void testSdivAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sdivAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#modAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#mod(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#mod(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.modAction(Program)"})
  public void testModAction_givenDataWordModDoesNothing_thenCallsMod() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).mod(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.modAction(program);

    // Assert
    verify(dataWord).mod(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#modAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.modAction(Program)"})
  public void testModAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#modAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.modAction(Program)"})
  public void testModAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#modAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#modAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.modAction(Program)"})
  public void testModAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.modAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sModAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sMod(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sMod(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sModAction(Program)"})
  public void testSModAction_givenDataWordSModDoesNothing_thenCallsSMod() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).sMod(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sModAction(program);

    // Assert
    verify(dataWord).sMod(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#sModAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sModAction(Program)"})
  public void testSModAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#sModAction(Program)}.
   * <ul>
   *   <li>Given ZERO sub {@link DataWord} with num is {@code A}.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sModAction(Program)"})
  public void testSModAction_givenZeroSubDataWordWithNumIsA_whenProgramStackPopReturnZero() {
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
   * Test {@link OperationActions#sModAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sModAction(Program)"})
  public void testSModAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#sModAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sModAction(Program)"})
  public void testSModAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sModAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#addModAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#addmod(DataWord, DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#addmod(DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addModAction(Program)"})
  public void testAddModAction_givenDataWordAddmodDoesNothing_thenCallsAddmod() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).addmod(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.addModAction(program);

    // Assert
    verify(dataWord).addmod(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#addModAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addModAction(Program)"})
  public void testAddModAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#addModAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addModAction(Program)"})
  public void testAddModAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#addModAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#addModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addModAction(Program)"})
  public void testAddModAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.addModAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#mulModAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#mulmod(DataWord, DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#mulmod(DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulModAction(Program)"})
  public void testMulModAction_givenDataWordMulmodDoesNothing_thenCallsMulmod() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).mulmod(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.mulModAction(program);

    // Assert
    verify(dataWord).mulmod(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#mulModAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulModAction(Program)"})
  public void testMulModAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#mulModAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulModAction(Program)"})
  public void testMulModAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#mulModAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mulModAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mulModAction(Program)"})
  public void testMulModAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.mulModAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#expAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#exp(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#exp(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.expAction(Program)"})
  public void testExpAction_givenDataWordExpDoesNothing_thenCallsExp() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).exp(Mockito.<DataWord>any());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.expAction(program);

    // Assert
    verify(dataWord).exp(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#expAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.expAction(Program)"})
  public void testExpAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#expAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.expAction(Program)"})
  public void testExpAction_givenDataWordWithNumIsMinusOne() {
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
   * Test {@link OperationActions#expAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.expAction(Program)"})
  public void testExpAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#expAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#expAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.expAction(Program)"})
  public void testExpAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.expAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#signExtendAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#signExtend(byte)} does nothing.</li>
   *   <li>Then calls {@link DataWord#signExtend(byte)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.signExtendAction(Program)"})
  public void testSignExtendAction_givenDataWordSignExtendDoesNothing_thenCallsSignExtend() {
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

    // Assert
    verify(dataWord).signExtend(eq((byte) 1));
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#signExtendAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.signExtendAction(Program)"})
  public void testSignExtendAction_givenDataWordWithNumIsA() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.signExtendAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#signExtendAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#stackPush(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.signExtendAction(Program)"})
  public void testSignExtendAction_givenZero_whenProgramStackPopReturnZero_thenCallsStackPush() {
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
   * Test {@link OperationActions#signExtendAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.signExtendAction(Program)"})
  public void testSignExtendAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    doThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(dataWord).signExtend(anyByte());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.signExtendAction(program));
    verify(dataWord).signExtend(eq((byte) 1));
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#signExtendAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#signExtendAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.signExtendAction(Program)"})
  public void testSignExtendAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.signExtendAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#ltAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.ltAction(Program)"})
  public void testLtAction_givenDataWordAndReturnZero_thenCallsAnd() {
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

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#ltAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.ltAction(Program)"})
  public void testLtAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#ltAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.ltAction(Program)"})
  public void testLtAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.ltAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#ltAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#ltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.ltAction(Program)"})
  public void testLtAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.ltAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#gtAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gtAction(Program)"})
  public void testGtAction_givenDataWordAndReturnZero_thenCallsAnd() {
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

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#gtAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gtAction(Program)"})
  public void testGtAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#gtAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gtAction(Program)"})
  public void testGtAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.gtAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#gtAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#gtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gtAction(Program)"})
  public void testGtAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.gtAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sltAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sltAction(Program)"})
  public void testSltAction_givenDataWordAndReturnZero_thenCallsAnd() {
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

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#sltAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sltAction(Program)"})
  public void testSltAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#sltAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sltAction(Program)"})
  public void testSltAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.sValue()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.sltAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#sltAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sltAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sltAction(Program)"})
  public void testSltAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sltAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sgtAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sgtAction(Program)"})
  public void testSgtAction_givenDataWordAndReturnZero_thenCallsAnd() {
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

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#sgtAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sgtAction(Program)"})
  public void testSgtAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#sgtAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sgtAction(Program)"})
  public void testSgtAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.sValue()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.sgtAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord, atLeast(1)).sValue();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#sgtAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sgtAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sgtAction(Program)"})
  public void testSgtAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sgtAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#eqAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} throw {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.eqAction(Program)"})
  public void testEqAction_givenDataWordAndThrowStaticCallModificationException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenThrow(new StaticCallModificationException());
    when(dataWord.xor(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.eqAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).xor(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#eqAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#xor(DataWord)} return {@link DataWord} with num is {@code A}.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.eqAction(Program)"})
  public void testEqAction_givenDataWordXorReturnDataWordWithNumIsA_thenCallsAnd() {
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

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).xor(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#eqAction(Program)}.
   * <ul>
   *   <li>Given {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.eqAction(Program)"})
  public void testEqAction_givenStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.eqAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#eqAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#eqAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.eqAction(Program)"})
  public void testEqAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#isZeroAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code false}.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#isZeroAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.isZeroAction(Program)"})
  public void testIsZeroAction_givenDataWordIsZeroReturnFalse_thenCallsAnd() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(false);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.isZeroAction(program);

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).isZero();
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#isZeroAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#isZeroAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.isZeroAction(Program)"})
  public void testIsZeroAction_givenDataWordWithNumIsA() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.isZeroAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#isZeroAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#isZeroAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.isZeroAction(Program)"})
  public void testIsZeroAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.isZeroAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#isZeroAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#isZeroAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.isZeroAction(Program)"})
  public void testIsZeroAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.isZeroAction(program));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#andAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#andAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.andAction(Program)"})
  public void testAndAction_givenDataWordAndReturnZero_thenCallsAnd() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.and(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.andAction(program);

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#andAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#andAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.andAction(Program)"})
  public void testAndAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#andAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#andAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.andAction(Program)"})
  public void testAndAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.andAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#orAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#or(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#or(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#orAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.orAction(Program)"})
  public void testOrAction_givenDataWordOrReturnZero_thenCallsOr() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.or(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.orAction(program);

    // Assert
    verify(dataWord).or(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#orAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#orAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.orAction(Program)"})
  public void testOrAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#orAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#orAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.orAction(Program)"})
  public void testOrAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.orAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#xorAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#xor(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#xor(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#xorAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.xorAction(Program)"})
  public void testXorAction_givenDataWordXorReturnZero_thenCallsXor() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.xor(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.xorAction(program);

    // Assert
    verify(dataWord).xor(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#xorAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#xorAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.xorAction(Program)"})
  public void testXorAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#xorAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#xorAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.xorAction(Program)"})
  public void testXorAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.xorAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#notAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#bnot()} does nothing.</li>
   *   <li>Then calls {@link DataWord#bnot()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#notAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.notAction(Program)"})
  public void testNotAction_givenDataWordBnotDoesNothing_thenCallsBnot() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    doNothing().when(dataWord).bnot();
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.notAction(program);

    // Assert
    verify(dataWord).bnot();
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#notAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#notAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.notAction(Program)"})
  public void testNotAction_givenDataWordWithNumIsA() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.notAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#notAction(Program)}.
   * <ul>
   *   <li>Given ZERO sub {@link DataWord} with num is {@code A}.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#notAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.notAction(Program)"})
  public void testNotAction_givenZeroSubDataWordWithNumIsA_whenProgramStackPopReturnZero() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    ZEROResult.sub(DataWord.of((byte) 'A'));
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(ZEROResult);

    // Act
    OperationActions.notAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#notAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#stackPop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#notAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.notAction(Program)"})
  public void testNotAction_givenZero_whenProgramStackPopReturnZero_thenCallsStackPop() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.notAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#byteAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#getData()} throw {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.byteAction(Program)"})
  public void testByteAction_givenDataWordGetDataThrowStaticCallModificationException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.getData()).thenThrow(new StaticCallModificationException());
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.byteAction(program));
    verify(dataWord).getData();
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#byteAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.byteAction(Program)"})
  public void testByteAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#byteAction(Program)}.
   * <ul>
   *   <li>Given {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.byteAction(Program)"})
  public void testByteAction_givenStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.byteAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#byteAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.byteAction(Program)"})
  public void testByteAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#byteAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#byteAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.byteAction(Program)"})
  public void testByteAction_thenThrowReturnDataCopyIllegalBoundsException() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.and(Mockito.<DataWord>any()))
        .thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    when(dataWord.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dataWord.intValue()).thenReturn(1);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.byteAction(program));
    verify(dataWord).and(isA(DataWord.class));
    verify(dataWord).getData();
    verify(dataWord).intValue();
    verify(dataWord).value();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#shlAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#shiftLeft(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#shiftLeft(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shlAction(Program)"})
  public void testShlAction_givenDataWordShiftLeftReturnZero_thenCallsShiftLeft() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.shiftLeft(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.shlAction(program);

    // Assert
    verify(dataWord).shiftLeft(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#shlAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shlAction(Program)"})
  public void testShlAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#shlAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shlAction(Program)"})
  public void testShlAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#shlAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shlAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shlAction(Program)"})
  public void testShlAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.shlAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#shrAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#shiftRight(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#shiftRight(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shrAction(Program)"})
  public void testShrAction_givenDataWordShiftRightReturnZero_thenCallsShiftRight() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.shiftRight(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.shrAction(program);

    // Assert
    verify(dataWord).shiftRight(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#shrAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shrAction(Program)"})
  public void testShrAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#shrAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shrAction(Program)"})
  public void testShrAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#shrAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#shrAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.shrAction(Program)"})
  public void testShrAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.shrAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sarAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#shiftRightSigned(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#shiftRightSigned(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sarAction(Program)"})
  public void testSarAction_givenDataWordShiftRightSignedReturnZero_thenCallsShiftRightSigned() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.shiftRightSigned(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.sarAction(program);

    // Assert
    verify(dataWord).shiftRightSigned(isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#sarAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sarAction(Program)"})
  public void testSarAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#sarAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sarAction(Program)"})
  public void testSarAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#sarAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sarAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sarAction(Program)"})
  public void testSarAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sarAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sha3Action(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return forty-two.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sha3Action(Program)"})
  public void testSha3Action_givenDataWordIntValueSafeReturnFortyTwo_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#sha3Action(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sha3Action(Program)"})
  public void testSha3Action_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#sha3Action(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sha3Action(Program)"})
  public void testSha3Action_givenZero_whenProgramStackPopReturnZero_thenCallsStep()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#sha3Action(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sha3Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sha3Action(Program)"})
  public void testSha3Action_thenThrowStaticCallModificationException() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sha3Action(program));
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#addressAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#addressAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addressAction(Program)"})
  public void testAddressAction() throws UnsupportedEncodingException {
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
    OperationActions.addressAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#addressAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#addressAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.addressAction(Program)"})
  public void testAddressAction2() throws UnsupportedEncodingException {
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
    OperationActions.addressAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#balanceAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getBalance(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link Program#getBalance(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#balanceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.balanceAction(Program)"})
  public void testBalanceAction_givenZero_whenProgramGetBalanceReturnZero_thenCallsGetBalance() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBalance(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.balanceAction(program);

    // Assert
    verify(program).getBalance(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#originAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#originAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.originAction(Program)"})
  public void testOriginAction() throws UnsupportedEncodingException {
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
    OperationActions.originAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#originAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#originAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.originAction(Program)"})
  public void testOriginAction2() throws UnsupportedEncodingException {
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
    OperationActions.originAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#callerAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callerAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callerAction(Program)"})
  public void testCallerAction() throws UnsupportedEncodingException {
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
    OperationActions.callerAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#callerAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callerAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callerAction(Program)"})
  public void testCallerAction2() throws UnsupportedEncodingException {
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
    OperationActions.callerAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#callValueAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callValueAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callValueAction(Program)"})
  public void testCallValueAction() throws UnsupportedEncodingException {
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
    OperationActions.callValueAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#callValueAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callValueAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callValueAction(Program)"})
  public void testCallValueAction2() throws UnsupportedEncodingException {
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
    OperationActions.callValueAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link OperationActions#callDataLoadAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>Then calls {@link Program#getDataValue(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callDataLoadAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataLoadAction(Program)"})
  public void testCallDataLoadAction_givenZero_thenCallsGetDataValue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getDataValue(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.callDataLoadAction(program);

    // Assert
    verify(program).getDataValue(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#callDataSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataSizeAction(Program)"})
  public void testCallDataSizeAction() throws UnsupportedEncodingException {
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
    OperationActions.callDataSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#callDataSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataSizeAction(Program)"})
  public void testCallDataSizeAction2() throws UnsupportedEncodingException {
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
    OperationActions.callDataSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#callDataSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callDataSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataSizeAction(Program)"})
  public void testCallDataSizeAction3() throws UnsupportedEncodingException {
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
    OperationActions.callDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
  }

  /**
   * Test {@link OperationActions#callDataCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataCopyAction(Program)"})
  public void testCallDataCopyAction_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.callDataCopyAction(program);

    // Assert
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#callDataCopyAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataCopyAction(Program)"})
  public void testCallDataCopyAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep()
      throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.callDataCopyAction(program);

    // Assert
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#callDataCopyAction(Program)}.
   * <ul>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataCopyAction(Program)"})
  public void testCallDataCopyAction_thenCallsIntValueSafe() throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord).intValueSafe();
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#callDataCopyAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callDataCopyAction(Program)"})
  public void testCallDataCopyAction_thenThrowStaticCallModificationException() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getDataCopy(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.callDataCopyAction(program));
    verify(program).getDataCopy(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#codeSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#codeSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeSizeAction(Program)"})
  public void testCodeSizeAction() throws UnsupportedEncodingException {
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
    OperationActions.codeSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", getResult.toHexString());
    assertEquals("08", getResult.toPrefixString());
    assertFalse(getResult.isZero());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
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
        data2);
  }

  /**
   * Test {@link OperationActions#codeSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#codeSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeSizeAction(Program)"})
  public void testCodeSizeAction2() throws UnsupportedEncodingException {
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
    OperationActions.codeSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getStack().size());
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link OperationActions#codeCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return eight.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeCopyAction(Program)"})
  public void testCodeCopyAction_givenDataWordIntValueSafeReturnEight_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCode();
    verify(program).memorySave(eq(8), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#codeCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return forty-two.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeCopyAction(Program)"})
  public void testCodeCopyAction_givenDataWordIntValueSafeReturnFortyTwo_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCode();
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#codeCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeCopyAction(Program)"})
  public void testCodeCopyAction_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.codeCopyAction(program);

    // Assert
    verify(program).getCode();
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#codeCopyAction(Program)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeCopyAction(Program)"})
  public void testCodeCopyAction_givenEmptyArrayOfByte() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn(new byte[]{});
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.codeCopyAction(program);

    // Assert
    verify(program).getCode();
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#codeCopyAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeCopyAction(Program)"})
  public void testCodeCopyAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep()
      throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.codeCopyAction(program);

    // Assert
    verify(program).getCode();
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#codeCopyAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#codeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.codeCopyAction(Program)"})
  public void testCodeCopyAction_thenThrowStaticCallModificationException() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getCode()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.codeCopyAction(program));
    verify(program).getCode();
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#returnDataSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#returnDataSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataSizeAction(Program)"})
  public void testReturnDataSizeAction() throws UnsupportedEncodingException {
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
    OperationActions.returnDataSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#returnDataSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#returnDataSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataSizeAction(Program)"})
  public void testReturnDataSizeAction2() throws UnsupportedEncodingException {
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
    OperationActions.returnDataSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_givenDataWord() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(null);
    when(program.getReturnDataBufferSize()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(mock(DataWord.class));

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.returnDataCopyAction(program));
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).getReturnDataBufferSize();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.returnDataCopyAction(program);

    // Assert
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_thenCallsIntValueSafe() throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord).intValueSafe();
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>Then calls {@link DataWord#longValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_thenCallsLongValueSafe() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(null);
    when(program.getReturnDataBufferSize()).thenReturn(dataWord);
    when(program.stackPop()).thenReturn(mock(DataWord.class));

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.returnDataCopyAction(program));
    verify(dataWord).longValueSafe();
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).getReturnDataBufferSize();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(null);
    when(program.getReturnDataBufferSize()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.returnDataCopyAction(program));
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).getReturnDataBufferSize();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_thenThrowStaticCallModificationException() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.returnDataCopyAction(program));
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#returnDataCopyAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnDataCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnDataCopyAction(Program)"})
  public void testReturnDataCopyAction_whenProgramStackPopReturnZero_thenCallsStep()
      throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getReturnDataBufferData(Mockito.<DataWord>any(), Mockito.<DataWord>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.returnDataCopyAction(program);

    // Assert
    verify(program).getReturnDataBufferData(isA(DataWord.class), isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#gasPriceAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#gasPriceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gasPriceAction(Program)"})
  public void testGasPriceAction() throws UnsupportedEncodingException {
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
    OperationActions.gasPriceAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#gasPriceAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#gasPriceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gasPriceAction(Program)"})
  public void testGasPriceAction2() throws UnsupportedEncodingException {
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
    OperationActions.gasPriceAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#extCodeSizeAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeSizeAction(Program)"})
  public void testExtCodeSizeAction_thenThrowStaticCallModificationException() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.extCodeSizeAction(program));
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#extCodeSizeAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#stackPush(DataWord)} does nothing.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeSizeAction(Program)"})
  public void testExtCodeSizeAction_whenProgramStackPushDoesNothing_thenCallsStep()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#extCodeCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return eight.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeCopyAction(Program)"})
  public void testExtCodeCopyAction_givenDataWordIntValueSafeReturnEight_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(8), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#extCodeCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeCopyAction(Program)"})
  public void testExtCodeCopyAction_givenDataWordIntValueSafeReturnFortyTwo() throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(42), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#extCodeCopyAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeCopyAction(Program)"})
  public void testExtCodeCopyAction_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(65), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#extCodeCopyAction(Program)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeCopyAction(Program)"})
  public void testExtCodeCopyAction_givenEmptyArrayOfByte() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn(new byte[]{});
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#extCodeCopyAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeCopyAction(Program)"})
  public void testExtCodeCopyAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep()
      throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    doNothing().when(program).step();
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.extCodeCopyAction(program);

    // Assert
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#extCodeCopyAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeCopyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeCopyAction(Program)"})
  public void testExtCodeCopyAction_thenThrowStaticCallModificationException() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.getCodeAt(Mockito.<DataWord>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.extCodeCopyAction(program));
    verify(program).getCodeAt(isA(DataWord.class));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#extCodeHashAction(Program)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link Program#getCodeHashAt(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#extCodeHashAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.extCodeHashAction(Program)"})
  public void testExtCodeHashAction_givenAxaxaxaxBytesIsUtf8_thenCallsGetCodeHashAt()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#blockHashAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.blockHashAction(Program)"})
  public void testBlockHashAction_givenDataWordWithNumIsA() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.blockHashAction(program);

    // Assert
    verify(program).getBlockHash(eq(65));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#blockHashAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#stackPush(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.blockHashAction(Program)"})
  public void testBlockHashAction_givenZero_whenProgramStackPopReturnZero_thenCallsStackPush() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.blockHashAction(program);

    // Assert
    verify(program).getBlockHash(eq(0));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#blockHashAction(Program)}.
   * <ul>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.blockHashAction(Program)"})
  public void testBlockHashAction_thenCallsIntValueSafe() {
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

    // Assert
    verify(dataWord).intValueSafe();
    verify(program).getBlockHash(eq(42));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#blockHashAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#blockHashAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.blockHashAction(Program)"})
  public void testBlockHashAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getBlockHash(anyInt())).thenThrow(new StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.blockHashAction(program));
    verify(program).getBlockHash(eq(0));
    verify(program).stackPop();
  }

  /**
   * Test {@link OperationActions#coinBaseAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#coinBaseAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.coinBaseAction(Program)"})
  public void testCoinBaseAction() throws UnsupportedEncodingException {
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
    OperationActions.coinBaseAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#coinBaseAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#coinBaseAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.coinBaseAction(Program)"})
  public void testCoinBaseAction2() throws UnsupportedEncodingException {
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
    OperationActions.coinBaseAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#timeStampAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#timeStampAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.timeStampAction(Program)"})
  public void testTimeStampAction() throws UnsupportedEncodingException {
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
    OperationActions.timeStampAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#timeStampAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#timeStampAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.timeStampAction(Program)"})
  public void testTimeStampAction2() throws UnsupportedEncodingException {
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
    OperationActions.timeStampAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, getResult.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, getResult.getData());
  }

  /**
   * Test {@link OperationActions#numberAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#numberAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.numberAction(Program)"})
  public void testNumberAction() throws UnsupportedEncodingException {
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
    OperationActions.numberAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'!'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#numberAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#numberAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.numberAction(Program)"})
  public void testNumberAction2() throws UnsupportedEncodingException {
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
    OperationActions.numberAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'!'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#difficultyAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#difficultyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.difficultyAction(Program)"})
  public void testDifficultyAction() throws UnsupportedEncodingException {
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
    OperationActions.difficultyAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#difficultyAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#difficultyAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.difficultyAction(Program)"})
  public void testDifficultyAction2() throws UnsupportedEncodingException {
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
    OperationActions.difficultyAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#gasLimitAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#gasLimitAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gasLimitAction(Program)"})
  public void testGasLimitAction() throws UnsupportedEncodingException {
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
    OperationActions.gasLimitAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#gasLimitAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#gasLimitAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gasLimitAction(Program)"})
  public void testGasLimitAction2() throws UnsupportedEncodingException {
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
    OperationActions.gasLimitAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#chainIdAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getChainId()} return ZERO.</li>
   *   <li>Then calls {@link Program#getChainId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#chainIdAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.chainIdAction(Program)"})
  public void testChainIdAction_givenZero_whenProgramGetChainIdReturnZero_thenCallsGetChainId() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getChainId()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.chainIdAction(program);

    // Assert
    verify(program).getChainId();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#selfBalanceAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#selfBalanceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.selfBalanceAction(Program)"})
  public void testSelfBalanceAction() throws UnsupportedEncodingException {
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
    OperationActions.selfBalanceAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#selfBalanceAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#selfBalanceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.selfBalanceAction(Program)"})
  public void testSelfBalanceAction2() throws UnsupportedEncodingException {
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
    OperationActions.selfBalanceAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#popAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#stackPop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#popAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.popAction(Program)"})
  public void testPopAction_givenZero_whenProgramStackPopReturnZero_thenCallsStackPop() {
    // Arrange
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).step();

    // Act
    OperationActions.popAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#mLoadAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#memoryLoad(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link Program#memoryLoad(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mLoadAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mLoadAction(Program)"})
  public void testMLoadAction_givenZero_whenProgramMemoryLoadReturnZero_thenCallsMemoryLoad() {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.mLoadAction(program);

    // Assert
    verify(program).memoryLoad(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#mStoreAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#memorySave(DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mStoreAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mStoreAction(Program)"})
  public void testMStoreAction_givenZero_whenProgramStackPopReturnZero_thenCallsMemorySave() {
    // Arrange
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memorySave(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.mStoreAction(program);

    // Assert
    verify(program).memorySave(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#mStore8Action(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mStore8Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mStore8Action(Program)"})
  public void testMStore8Action_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#mStore8Action(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mStore8Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mStore8Action(Program)"})
  public void testMStore8Action_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#mStore8Action(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#mStore8Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mStore8Action(Program)"})
  public void testMStore8Action_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).memorySave(anyInt(), Mockito.<byte[]>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.mStore8Action(program));
    verify(program).memorySave(eq(0), isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#sLoadAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#and(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link DataWord#and(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sLoadAction(Program)"})
  public void testSLoadAction_givenDataWordAndReturnZero_thenCallsAnd() {
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

    // Assert
    verify(dataWord).and(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sLoadAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sLoadAction(Program)"})
  public void testSLoadAction_givenZero_whenProgramStackPopReturnZero_thenCallsStep() {
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
   * Test {@link OperationActions#sLoadAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#storageLoad(DataWord)} return ZERO.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sLoadAction(Program)"})
  public void testSLoadAction_givenZero_whenProgramStorageLoadReturnZero_thenCallsStep() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.sLoadAction(program);

    // Assert
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sLoadAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sLoadAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sLoadAction(Program)"})
  public void testSLoadAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stackPush(Mockito.<DataWord>any());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sLoadAction(program));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sStoreAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code false}.</li>
   *   <li>Then calls {@link Program#stackPop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sStoreAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sStoreAction(Program)"})
  public void testSStoreAction_givenFalse_whenProgramIsStaticCallReturnFalse_thenCallsStackPop() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).step();
    doNothing().when(program).storageSave(Mockito.<DataWord>any(), Mockito.<DataWord>any());

    // Act
    OperationActions.sStoreAction(program);

    // Assert
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).storageSave(isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#sStoreAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#sStoreAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.sStoreAction(Program)"})
  public void testSStoreAction_givenTrue_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.sStoreAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#jumpAction(Program)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Program} {@link Program#verifyJumpDest(DataWord)} return one.</li>
   *   <li>Then calls {@link Program#setPC(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#jumpAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpAction(Program)"})
  public void testJumpAction_givenOne_whenProgramVerifyJumpDestReturnOne_thenCallsSetPC() {
    // Arrange
    Program program = mock(Program.class);
    when(program.verifyJumpDest(Mockito.<DataWord>any())).thenReturn(1);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).setPC(anyInt());

    // Act
    OperationActions.jumpAction(program);

    // Assert
    verify(program).setPC(eq(1));
    verify(program).stackPop();
    verify(program).verifyJumpDest(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#jumpIAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpIAction(Program)"})
  public void testJumpIAction_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(dataWord);

    // Act
    OperationActions.jumpIAction(program);

    // Assert
    verify(dataWord).isZero();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#jumpIAction(Program)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Program} {@link Program#verifyJumpDest(DataWord)} return one.</li>
   *   <li>Then calls {@link Program#setPC(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpIAction(Program)"})
  public void testJumpIAction_givenOne_whenProgramVerifyJumpDestReturnOne_thenCallsSetPC() {
    // Arrange
    Program program = mock(Program.class);
    when(program.verifyJumpDest(Mockito.<DataWord>any())).thenReturn(1);
    doNothing().when(program).setPC(anyInt());
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.jumpIAction(program);

    // Assert
    verify(program).setPC(eq(1));
    verify(program, atLeast(1)).stackPop();
    verify(program).verifyJumpDest(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#jumpIAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#step()} does nothing.</li>
   *   <li>Then calls {@link Program#step()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpIAction(Program)"})
  public void testJumpIAction_givenZero_whenProgramStepDoesNothing_thenCallsStep() {
    // Arrange
    Program program = mock(Program.class);
    doNothing().when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.jumpIAction(program);

    // Assert
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#jumpIAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpIAction(Program)"})
  public void testJumpIAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program).step();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.jumpIAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#jumpIAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#jumpIAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpIAction(Program)"})
  public void testJumpIAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.verifyJumpDest(Mockito.<DataWord>any())).thenThrow(new StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.jumpIAction(program));
    verify(program, atLeast(1)).stackPop();
    verify(program).verifyJumpDest(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#pcAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#pcAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.pcAction(Program)"})
  public void testPcAction() throws UnsupportedEncodingException {
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
    OperationActions.pcAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#pcAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#pcAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.pcAction(Program)"})
  public void testPcAction2() throws UnsupportedEncodingException {
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
    OperationActions.pcAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#mSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#mSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mSizeAction(Program)"})
  public void testMSizeAction() throws UnsupportedEncodingException {
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
    OperationActions.mSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#mSizeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#mSizeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.mSizeAction(Program)"})
  public void testMSizeAction2() throws UnsupportedEncodingException {
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
    OperationActions.mSizeAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#gasAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#gasAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gasAction(Program)"})
  public void testGasAction() throws UnsupportedEncodingException {
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
    OperationActions.gasAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'2'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#gasAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#gasAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.gasAction(Program)"})
  public void testGasAction2() throws UnsupportedEncodingException {
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
    OperationActions.gasAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'2'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2'},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#jumpDestAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#jumpDestAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpDestAction(Program)"})
  public void testJumpDestAction() throws UnsupportedEncodingException {
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
    OperationActions.jumpDestAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#jumpDestAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#jumpDestAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.jumpDestAction(Program)"})
  public void testJumpDestAction2() throws UnsupportedEncodingException {
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
    OperationActions.jumpDestAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link OperationActions#push0Action(Program)}.
   * <p>
   * Method under test: {@link OperationActions#push0Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.push0Action(Program)"})
  public void testPush0Action() throws UnsupportedEncodingException {
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
    OperationActions.push0Action(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#push0Action(Program)}.
   * <p>
   * Method under test: {@link OperationActions#push0Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.push0Action(Program)"})
  public void testPush0Action2() throws UnsupportedEncodingException {
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
    OperationActions.push0Action(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#pushAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#pushAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.pushAction(Program)"})
  public void testPushAction() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "`XAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    OperationActions.pushAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("0000000000000000000000000000000000000000000000000000000000000058", getResult.toHexString());
    assertEquals("58", getResult.toPrefixString());
    assertEquals(2, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.COINBASE, program.getCurrentOpIntValue());
    assertEquals('A', program.getCurrentOp());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
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
        data2);
  }

  /**
   * Test {@link OperationActions#pushAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#pushAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.pushAction(Program)"})
  public void testPushAction2() throws UnsupportedEncodingException {
    // Arrange
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, codeAddress,
        programInvoke, new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L,
            new HashMap<>()));

    // Act
    OperationActions.pushAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals("584158", getResult.toPrefixString());
    assertEquals("5841584158415800000000000000000000000000000000000000000000000000", getResult.toHexString());
    assertEquals(33, program.getPC());
    assertTrue(program.isStopped());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoLeadZeroesData());
    byte[] expectedNoEndZeroesData = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoEndZeroesData, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, getResult.getClonedData());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, data2);
  }

  /**
   * Test {@link OperationActions#dupAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#clone()} return ZERO.</li>
   *   <li>Then calls {@link DataWord#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#dupAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.dupAction(Program)"})
  public void testDupAction_givenDataWordCloneReturnZero_thenCallsClone() {
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

    // Assert
    verify(dataWord).clone();
    verify(program).getCurrentOpIntValue();
    verify(program).getStack();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#dupAction(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then calls {@link Program#getCurrentOpIntValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#dupAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.dupAction(Program)"})
  public void testDupAction_givenStackAddZero_thenCallsGetCurrentOpIntValue() {
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
   * Test {@link OperationActions#swapAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#swapAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.swapAction(Program)"})
  public void testSwapAction() throws UnsupportedEncodingException {
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
    OperationActions.swapAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#swapAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#swapAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.swapAction(Program)"})
  public void testSwapAction2() throws UnsupportedEncodingException {
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
    OperationActions.swapAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    assertEquals(1, program.getPC());
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link Program} {@link Program#getResult()} return createEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_givenA_whenProgramGetResultReturnCreateEmpty() throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>When {@link Program} {@link Program#getResult()} return createEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_givenCreateEmpty_whenProgramGetResultReturnCreateEmpty()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return forty-two.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_givenDataWordIntValueSafeReturnFortyTwo_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.getLast20Bytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.intValueSafe()).thenReturn(42);

    Stack stack = new Stack();
    stack.add(dataWord2);
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
    verify(dataWord2).intValueSafe();
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(42));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Given {@link ProgramResult} {@link ProgramResult#addLogInfo(LogInfo)} does nothing.</li>
   *   <li>Then calls {@link ProgramResult#addLogInfo(LogInfo)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_givenProgramResultAddLogInfoDoesNothing_thenCallsAddLogInfo()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then calls {@link DataWord#getLast20Bytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_givenStackAddDataWordWithNumIsA_thenCallsGetLast20Bytes()
      throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.getLast20Bytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
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
    verify(program).memoryChunk(eq(0), eq(65));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_givenTrue_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);
    when(program.getStack()).thenReturn(new Stack());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.logAction(program));
    verify(program).getStack();
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Then calls {@link DataWord#getLast20Bytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_thenCallsGetLast20Bytes() throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#logAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#logAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.logAction(Program)"})
  public void testLogAction_thenThrowReturnDataCopyIllegalBoundsException() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program).step();
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());
    when(program.isStaticCall()).thenReturn(false);
    when(program.getContractAddress()).thenReturn(DataWord.ZERO());
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.logAction(program));
    verify(program).getContractAddress();
    verify(program).getCurrentOpIntValue();
    verify(program).getResult();
    verify(program).getStack();
    verify(program).isStaticCall();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#tokenBalanceAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>Then calls {@link Program#getTokenBalance(DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#tokenBalanceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.tokenBalanceAction(Program)"})
  public void testTokenBalanceAction_givenZero_thenCallsGetTokenBalance() {
    // Arrange
    Program program = mock(Program.class);
    when(program.getTokenBalance(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.tokenBalanceAction(program);

    // Assert
    verify(program).getTokenBalance(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#callTokenValueAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callTokenValueAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenValueAction(Program)"})
  public void testCallTokenValueAction() throws UnsupportedEncodingException {
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

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    OperationActions.callTokenValueAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'*'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#callTokenValueAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callTokenValueAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenValueAction(Program)"})
  public void testCallTokenValueAction2() throws UnsupportedEncodingException {
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

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    OperationActions.callTokenValueAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{'*'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#callTokenIdAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callTokenIdAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenIdAction(Program)"})
  public void testCallTokenIdAction() throws UnsupportedEncodingException {
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

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    OperationActions.callTokenIdAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertFalse(program.isStopped());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    DataWord getResult = stack.get(0);
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
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#callTokenIdAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#callTokenIdAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenIdAction(Program)"})
  public void testCallTokenIdAction2() throws UnsupportedEncodingException {
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

    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(new byte[]{}, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act
    OperationActions.callTokenIdAction(program);

    // Assert
    assertEquals(0, program.getCurrentOpIntValue());
    assertEquals((byte) 0, program.getCurrentOp());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
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
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#isContractAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>Then calls {@link Program#isContract(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#isContractAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.isContractAction(Program)"})
  public void testIsContractAction_givenZero_thenCallsIsContract() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isContract(Mockito.<DataWord>any())).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stackPush(Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.isContractAction(program);

    // Assert
    verify(program).isContract(isA(DataWord.class));
    verify(program).stackPop();
    verify(program).stackPush(isA(DataWord.class));
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#freezeAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#freeze(DataWord, DataWord, DataWord)} return {@code false}.</li>
   *   <li>Then calls {@link Program#freeze(DataWord, DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#freezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.freezeAction(Program)"})
  public void testFreezeAction_givenFalse_whenProgramFreezeReturnFalse_thenCallsFreeze() {
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
   * Test {@link OperationActions#freezeAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Program} {@link Program#freeze(DataWord, DataWord, DataWord)} return {@code true}.</li>
   *   <li>Then calls {@link Program#freeze(DataWord, DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#freezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.freezeAction(Program)"})
  public void testFreezeAction_givenTrue_whenProgramFreezeReturnTrue_thenCallsFreeze() {
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
   * Test {@link OperationActions#unfreezeAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#unfreeze(DataWord, DataWord)} return {@code false}.</li>
   *   <li>Then calls {@link Program#stackPop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unfreezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unfreezeAction(Program)"})
  public void testUnfreezeAction_givenFalse_whenProgramUnfreezeReturnFalse_thenCallsStackPop() {
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
   * Test {@link OperationActions#unfreezeAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Program} {@link Program#unfreeze(DataWord, DataWord)} return {@code true}.</li>
   *   <li>Then calls {@link Program#stackPop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unfreezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unfreezeAction(Program)"})
  public void testUnfreezeAction_givenTrue_whenProgramUnfreezeReturnTrue_thenCallsStackPop() {
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
   * Test {@link OperationActions#freezeExpireTimeAction(Program)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link Program#freezeExpireTime(DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#freezeExpireTimeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.freezeExpireTimeAction(Program)"})
  public void testFreezeExpireTimeAction_givenOne_thenCallsFreezeExpireTime() {
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
   * Test {@link OperationActions#freezeBalanceV2Action(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.freezeBalanceV2Action(Program)"})
  public void testFreezeBalanceV2Action_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.freezeBalanceV2Action(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#freezeBalanceV2Action(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#freezeBalanceV2(DataWord, DataWord)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.freezeBalanceV2Action(Program)"})
  public void testFreezeBalanceV2Action_whenProgramFreezeBalanceV2ReturnFalse() {
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
   * Test {@link OperationActions#freezeBalanceV2Action(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#freezeBalanceV2(DataWord, DataWord)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#freezeBalanceV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.freezeBalanceV2Action(Program)"})
  public void testFreezeBalanceV2Action_whenProgramFreezeBalanceV2ReturnTrue() {
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
   * Test {@link OperationActions#unfreezeBalanceV2Action(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unfreezeBalanceV2Action(Program)"})
  public void testUnfreezeBalanceV2Action_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.unfreezeBalanceV2Action(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#unfreezeBalanceV2Action(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#unfreezeBalanceV2(DataWord, DataWord)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unfreezeBalanceV2Action(Program)"})
  public void testUnfreezeBalanceV2Action_whenProgramUnfreezeBalanceV2ReturnFalse() {
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
   * Test {@link OperationActions#unfreezeBalanceV2Action(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#unfreezeBalanceV2(DataWord, DataWord)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unfreezeBalanceV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unfreezeBalanceV2Action(Program)"})
  public void testUnfreezeBalanceV2Action_whenProgramUnfreezeBalanceV2ReturnTrue() {
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
   * Test {@link OperationActions#withdrawExpireUnfreezeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawExpireUnfreezeAction(Program)"})
  public void testWithdrawExpireUnfreezeAction() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
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
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
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
    DataWord getResult2 = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getData());
  }

  /**
   * Test {@link OperationActions#withdrawExpireUnfreezeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawExpireUnfreezeAction(Program)"})
  public void testWithdrawExpireUnfreezeAction2() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    Program program = new Program(new byte[]{}, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

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
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#withdrawExpireUnfreezeAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawExpireUnfreezeAction(Program)"})
  public void testWithdrawExpireUnfreezeAction3() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
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
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    DataWord getResult2 = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getData());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link OperationActions#withdrawExpireUnfreezeAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#withdrawExpireUnfreezeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawExpireUnfreezeAction(Program)"})
  public void testWithdrawExpireUnfreezeAction_thenThrowStaticCallModificationException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.withdrawExpireUnfreezeAction(
        new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction)));
    verify(internalTransaction).getNonce();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Test {@link OperationActions#cancelAllUnfreezeV2Action(Program)}.
   * <p>
   * Method under test: {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.cancelAllUnfreezeV2Action(Program)"})
  public void testCancelAllUnfreezeV2Action() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
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
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
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
    DataWord getResult2 = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0,
        0, 0, 0, 0, 0, 0}, getResult.getEncoded());
    assertArrayEquals(new byte[]{-59, -97, 'y', -66, -33, -119, -3, 'I', -35, 1, -6, 'k', 'L', 's', -36, 'Y', '\f', 'n',
        ']', 'O', -29, 'a', -83, -70, 'W', 23, 'Z', -72, -127, -78, -16, -94}, getResult.getHash());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getData());
  }

  /**
   * Test {@link OperationActions#cancelAllUnfreezeV2Action(Program)}.
   * <p>
   * Method under test: {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.cancelAllUnfreezeV2Action(Program)"})
  public void testCancelAllUnfreezeV2Action2() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    Program program = new Program(new byte[]{}, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

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
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    assertTrue(program.isStopped());
    DataWord getResult = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getData());
  }

  /**
   * Test {@link OperationActions#cancelAllUnfreezeV2Action(Program)}.
   * <p>
   * Method under test: {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.cancelAllUnfreezeV2Action(Program)"})
  public void testCancelAllUnfreezeV2Action3() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn(new byte[]{});
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getCallDeep()).thenReturn(1);
    when(programInvoke.isStaticCall()).thenReturn(false);
    when(programInvoke.getContractAddress()).thenReturn(dataWord);
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
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
    List<InternalTransaction> internalTransactions = program.getResult().getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    InternalTransaction getResult = internalTransactions.get(0);
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{}, getResult.getReceiveAddress());
    assertArrayEquals(new byte[]{}, getResult.getSender());
    assertArrayEquals(new byte[]{}, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getEncoded());
    DataWord getResult2 = stack.get(0);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult2.getData());
    assertArrayEquals(new byte[]{'w', -3, 'r', -97, 31, 'p', 'R', -122, -66, -91, 1, '$', '!', -78, -2, 15, '7', 'c',
        'q', 24, '#', '&', '0', 'F', '0', 'N', -100, 23, 'Q', Byte.MIN_VALUE, -34, 'O'}, getResult.getHash());
  }

  /**
   * Test {@link OperationActions#cancelAllUnfreezeV2Action(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#cancelAllUnfreezeV2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.cancelAllUnfreezeV2Action(Program)"})
  public void testCancelAllUnfreezeV2Action_givenTrue_thenThrowStaticCallModificationException()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions
        .cancelAllUnfreezeV2Action(new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction)));
    verify(internalTransaction).getNonce();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Test {@link OperationActions#delegateResourceAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateResourceAction(Program)"})
  public void testDelegateResourceAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.delegateResourceAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#delegateResourceAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#delegateResource(DataWord, DataWord, DataWord)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateResourceAction(Program)"})
  public void testDelegateResourceAction_whenProgramDelegateResourceReturnFalse() {
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
   * Test {@link OperationActions#delegateResourceAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#delegateResource(DataWord, DataWord, DataWord)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateResourceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateResourceAction(Program)"})
  public void testDelegateResourceAction_whenProgramDelegateResourceReturnTrue() {
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
   * Test {@link OperationActions#unDelegateResourceAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unDelegateResourceAction(Program)"})
  public void testUnDelegateResourceAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.unDelegateResourceAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#unDelegateResourceAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#unDelegateResource(DataWord, DataWord, DataWord)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unDelegateResourceAction(Program)"})
  public void testUnDelegateResourceAction_whenProgramUnDelegateResourceReturnFalse() {
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
   * Test {@link OperationActions#unDelegateResourceAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#unDelegateResource(DataWord, DataWord, DataWord)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#unDelegateResourceAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.unDelegateResourceAction(Program)"})
  public void testUnDelegateResourceAction_whenProgramUnDelegateResourceReturnTrue() {
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
   * Test {@link OperationActions#voteWitnessAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.voteWitnessAction(Program)"})
  public void testVoteWitnessAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#voteWitnessAction(Program)}.
   * <ul>
   *   <li>Given {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.voteWitnessAction(Program)"})
  public void testVoteWitnessAction_givenStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.voteWitness(anyInt(), anyInt(), anyInt(), anyInt())).thenThrow(new StaticCallModificationException());
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.voteWitnessAction(program));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).voteWitness(eq(0), eq(0), eq(0), eq(0));
  }

  /**
   * Test {@link OperationActions#voteWitnessAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#stackPush(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.voteWitnessAction(Program)"})
  public void testVoteWitnessAction_givenZero_whenProgramStackPopReturnZero_thenCallsStackPush() {
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
   * Test {@link OperationActions#voteWitnessAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#voteWitness(int, int, int, int)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.voteWitnessAction(Program)"})
  public void testVoteWitnessAction_givenZero_whenProgramVoteWitnessReturnFalse() {
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
   * Test {@link OperationActions#voteWitnessAction(Program)}.
   * <ul>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.voteWitnessAction(Program)"})
  public void testVoteWitnessAction_thenCallsIntValueSafe() {
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
   * Test {@link OperationActions#voteWitnessAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#voteWitnessAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.voteWitnessAction(Program)"})
  public void testVoteWitnessAction_whenProgramIsStaticCallReturnTrue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.voteWitnessAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#withdrawRewardAction(Program)}.
   * <p>
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawRewardAction(Program)"})
  public void testWithdrawRewardAction() throws UnsupportedEncodingException {
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
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getHash()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction);

    // Act
    OperationActions.withdrawRewardAction(program);

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
    verify(programInvoke).isStaticCall();
    verify(repository).newRepositoryChild();
    assertEquals(1, program.getResult().getInternalTransactions().size());
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(2L, program.getNonce());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#withdrawRewardAction(Program)}.
   * <ul>
   *   <li>When {@link ProgramInvoke} {@link ProgramInvoke#isStaticCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawRewardAction(Program)"})
  public void testWithdrawRewardAction_whenProgramInvokeIsStaticCallReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.isStaticCall()).thenReturn(true);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    InternalTransaction internalTransaction = mock(InternalTransaction.class);
    when(internalTransaction.getNonce()).thenReturn(1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions
        .withdrawRewardAction(new Program(ops, "AXAXAXAX".getBytes("UTF-8"), programInvoke, internalTransaction)));
    verify(internalTransaction).getNonce();
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(programInvoke).isStaticCall();
  }

  /**
   * Test {@link OperationActions#withdrawRewardAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code false}.</li>
   *   <li>Then calls {@link Program#stackPush(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawRewardAction(Program)"})
  public void testWithdrawRewardAction_whenProgramIsStaticCallReturnFalse_thenCallsStackPush() {
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
   * Test {@link OperationActions#withdrawRewardAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#withdrawRewardAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.withdrawRewardAction(Program)"})
  public void testWithdrawRewardAction_whenProgramIsStaticCallReturnTrue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.withdrawRewardAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#createAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link Program#createContract(DataWord, DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#createAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.createAction(Program)"})
  public void testCreateAction_givenFalse_thenCallsCreateContract() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).createContract(Mockito.<DataWord>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.createAction(program);

    // Assert
    verify(program).createContract(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#createAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#createAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.createAction(Program)"})
  public void testCreateAction_givenTrue_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.createAction(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#returnAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return forty-two.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnAction(Program)"})
  public void testReturnAction_givenDataWordIntValueSafeReturnFortyTwo_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
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

    // Assert
    verify(dataWord, atLeast(1)).intValueSafe();
    verify(program).memoryChunk(eq(42), eq(42));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#returnAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnAction(Program)"})
  public void testReturnAction_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act
    OperationActions.returnAction(program);

    // Assert
    verify(program).memoryChunk(eq(65), eq(65));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#returnAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#setHReturn(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnAction(Program)"})
  public void testReturnAction_givenZero_whenProgramStackPopReturnZero_thenCallsSetHReturn()
      throws UnsupportedEncodingException {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(program).setHReturn(Mockito.<byte[]>any());
    doNothing().when(program).step();
    doNothing().when(program).stop();
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act
    OperationActions.returnAction(program);

    // Assert
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#returnAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#returnAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.returnAction(Program)"})
  public void testReturnAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenThrow(new StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.returnAction(program));
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#create2Action(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link Program#createContract2(DataWord, DataWord, DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#create2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.create2Action(Program)"})
  public void testCreate2Action_givenFalse_thenCallsCreateContract2() {
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

    // Assert
    verify(program).createContract2(isA(DataWord.class), isA(DataWord.class), isA(DataWord.class), isA(DataWord.class));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#create2Action(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#create2Action(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.create2Action(Program)"})
  public void testCreate2Action_givenTrue_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.create2Action(program));
    verify(program).isStaticCall();
  }

  /**
   * Test {@link OperationActions#callAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callAction(Program)"})
  public void testCallAction_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
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
   * Test {@link OperationActions#callAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callAction(Program)"})
  public void testCallAction_givenDataWordWithNumIsA() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.callAction(program));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callAction(Program)"})
  public void testCallAction_givenFalse_whenProgramIsStaticCallReturnFalse() {
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
   * Test {@link OperationActions#callAction(Program)}.
   * <ul>
   *   <li>Given {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callAction(Program)"})
  public void testCallAction_givenStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program)
        .memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.callAction(program));
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callAction(Program)"})
  public void testCallAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.isZero()).thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.callAction(program));
    verify(dataWord).isZero();
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#callToAddress(MessageCall)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callAction(Program)"})
  public void testCallAction_whenProgramStackPopReturnZero_thenCallsCallToAddress() {
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
   * Test {@link OperationActions#callTokenAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenAction(Program)"})
  public void testCallTokenAction_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
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
   * Test {@link OperationActions#callTokenAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenAction(Program)"})
  public void testCallTokenAction_givenDataWordWithNumIsA() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);
    when(program.stackPop()).thenReturn(DataWord.of((byte) 'A'));

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.callTokenAction(program));
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callTokenAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenAction(Program)"})
  public void testCallTokenAction_givenFalse_whenProgramIsStaticCallReturnFalse() {
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
   * Test {@link OperationActions#callTokenAction(Program)}.
   * <ul>
   *   <li>Given {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenAction(Program)"})
  public void testCallTokenAction_givenStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program)
        .memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    when(program.isStaticCall()).thenReturn(true);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.callTokenAction(program));
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callTokenAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenAction(Program)"})
  public void testCallTokenAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    DataWord off = DataWord.ZERO();
    when(dataWord.isZero()).thenThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L));
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(dataWord);

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.callTokenAction(program));
    verify(dataWord).isZero();
    verify(program).getAdjustedCallEnergy();
    verify(program).isStaticCall();
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callTokenAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#callToAddress(MessageCall)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callTokenAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callTokenAction(Program)"})
  public void testCallTokenAction_whenProgramStackPopReturnZero_thenCallsCallToAddress() {
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
   * Test {@link OperationActions#callCodeAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#add(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#add(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callCodeAction(Program)"})
  public void testCallCodeAction_givenDataWordAddDoesNothing_thenCallsAdd() {
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
   * Test {@link OperationActions#callCodeAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callCodeAction(Program)"})
  public void testCallCodeAction_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
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
   * Test {@link OperationActions#callCodeAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callCodeAction(Program)"})
  public void testCallCodeAction_givenDataWordWithNumIsA() {
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
   * Test {@link OperationActions#callCodeAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callCodeAction(Program)"})
  public void testCallCodeAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program)
        .memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.callCodeAction(program));
    verify(program).getAdjustedCallEnergy();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#callCodeAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#stackPop()} return ZERO.</li>
   *   <li>Then calls {@link Program#callToAddress(MessageCall)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#callCodeAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.callCodeAction(Program)"})
  public void testCallCodeAction_whenProgramStackPopReturnZero_thenCallsCallToAddress() {
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
   * Test {@link OperationActions#delegateCallAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord}.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return {@link DataWord}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateCallAction(Program)"})
  public void testDelegateCallAction_givenDataWord_whenProgramStackPopReturnDataWord() {
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
   * Test {@link OperationActions#delegateCallAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateCallAction(Program)"})
  public void testDelegateCallAction_givenFalse_whenProgramIsConstantCallReturnFalse() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(false);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#delegateCallAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateCallAction(Program)"})
  public void testDelegateCallAction_givenTrue_whenProgramIsConstantCallReturnTrue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#delegateCallAction(Program)}.
   * <ul>
   *   <li>Given ZERO exp ZERO.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateCallAction(Program)"})
  public void testDelegateCallAction_givenZeroExpZero_whenProgramIsConstantCallReturnTrue() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    ZEROResult.exp(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(ZEROResult);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.delegateCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#delegateCallAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateCallAction(Program)"})
  public void testDelegateCallAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program)
        .callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.delegateCallAction(program));
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#delegateCallAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#callToAddress(MessageCall)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#delegateCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.delegateCallAction(Program)"})
  public void testDelegateCallAction_whenProgramCallToAddressDoesNothing() {
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
   * Test {@link OperationActions#staticCallAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord}.</li>
   *   <li>When {@link Program} {@link Program#stackPop()} return {@link DataWord}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.staticCallAction(Program)"})
  public void testStaticCallAction_givenDataWord_whenProgramStackPopReturnDataWord() {
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
   * Test {@link OperationActions#staticCallAction(Program)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.staticCallAction(Program)"})
  public void testStaticCallAction_givenFalse_whenProgramIsConstantCallReturnFalse() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(false);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#staticCallAction(Program)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.staticCallAction(Program)"})
  public void testStaticCallAction_givenTrue_whenProgramIsConstantCallReturnTrue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(null);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isNull(), isNull());
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#staticCallAction(Program)}.
   * <ul>
   *   <li>Given ZERO exp ZERO.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.staticCallAction(Program)"})
  public void testStaticCallAction_givenZeroExpZero_whenProgramIsConstantCallReturnTrue() {
    // Arrange
    DataWord ZEROResult = DataWord.ZERO();
    ZEROResult.exp(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(ZEROResult);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();

    // Act
    OperationActions.staticCallAction(program);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#staticCallAction(Program)}.
   * <ul>
   *   <li>Then throw {@link ReturnDataCopyIllegalBoundsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.staticCallAction(Program)"})
  public void testStaticCallAction_thenThrowReturnDataCopyIllegalBoundsException() {
    // Arrange
    Program program = mock(Program.class);
    DataWord off = DataWord.ZERO();
    doThrow(new ReturnDataCopyIllegalBoundsException(off, DataWord.ZERO(), 3L)).when(program)
        .callToAddress(Mockito.<MessageCall>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getAdjustedCallEnergy()).thenReturn(DataWord.ZERO());
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());

    // Act and Assert
    assertThrows(ReturnDataCopyIllegalBoundsException.class, () -> OperationActions.staticCallAction(program));
    verify(program).callToAddress(isA(MessageCall.class));
    verify(program).getAdjustedCallEnergy();
    verify(program).getCurrentOpIntValue();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#staticCallAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#callToAddress(MessageCall)} does nothing.</li>
   *   <li>Then calls {@link Program#callToAddress(MessageCall)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#staticCallAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.staticCallAction(Program)"})
  public void testStaticCallAction_whenProgramCallToAddressDoesNothing_thenCallsCallToAddress() {
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
   * Test {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)"})
  public void testExeCall_givenFalse_whenProgramIsConstantCallReturnFalse() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(false);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act
    OperationActions.exeCall(program, adjustedCallEnergy, null, value, DataWord.ZERO(), true);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}.
   * <ul>
   *   <li>Given forty-two.</li>
   *   <li>When {@link DataWord}.</li>
   *   <li>Then calls {@link Program#callToAddress(MessageCall)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)"})
  public void testExeCall_givenFortyTwo_whenDataWord_thenCallsCallToAddress() {
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
   * Test {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Program} {@link Program#isConstantCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)"})
  public void testExeCall_givenTrue_whenProgramIsConstantCallReturnTrue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenReturn(true);
    doNothing().when(program).callToPrecompiledAddress(Mockito.<MessageCall>any(), Mockito.<PrecompiledContract>any());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    doNothing().when(program).step();
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act
    OperationActions.exeCall(program, adjustedCallEnergy, null, value, DataWord.ZERO(), true);

    // Assert
    verify(program).callToPrecompiledAddress(isA(MessageCall.class), isA(PrecompiledContract.class));
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
  }

  /**
   * Test {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)"})
  public void testExeCall_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isConstantCall()).thenThrow(new StaticCallModificationException());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).memoryExpand(Mockito.<DataWord>any(), Mockito.<DataWord>any());
    DataWord adjustedCallEnergy = DataWord.ZERO();
    DataWord value = DataWord.ZERO();

    // Act and Assert
    assertThrows(StaticCallModificationException.class,
        () -> OperationActions.exeCall(program, adjustedCallEnergy, null, value, DataWord.ZERO(), true));
    verify(program).getCurrentOpIntValue();
    verify(program).isConstantCall();
    verify(program).memoryExpand(isA(DataWord.class), isA(DataWord.class));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#callToAddress(MessageCall)} does nothing.</li>
   *   <li>Then calls {@link Program#callToAddress(MessageCall)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.exeCall(Program, DataWord, DataWord, DataWord, DataWord, boolean)"})
  public void testExeCall_whenProgramCallToAddressDoesNothing_thenCallsCallToAddress() {
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
   * Test {@link OperationActions#revertAction(Program)}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>When {@link Program} {@link Program#getResult()} return createEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.revertAction(Program)"})
  public void testRevertAction_givenCreateEmpty_whenProgramGetResultReturnCreateEmpty()
      throws UnsupportedEncodingException {
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
   * Test {@link OperationActions#revertAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#intValueSafe()} return forty-two.</li>
   *   <li>Then calls {@link DataWord#intValueSafe()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.revertAction(Program)"})
  public void testRevertAction_givenDataWordIntValueSafeReturnFortyTwo_thenCallsIntValueSafe()
      throws UnsupportedEncodingException {
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

    // Assert
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
   * Test {@link OperationActions#revertAction(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.revertAction(Program)"})
  public void testRevertAction_givenDataWordWithNumIsA() throws UnsupportedEncodingException {
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

    // Assert
    verify(programResult).setRevert();
    verify(program).getResult();
    verify(program).memoryChunk(eq(65), eq(65));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#revertAction(Program)}.
   * <ul>
   *   <li>Given {@link ProgramResult} {@link ProgramResult#setRevert()} does nothing.</li>
   *   <li>Then calls {@link ProgramResult#setRevert()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.revertAction(Program)"})
  public void testRevertAction_givenProgramResultSetRevertDoesNothing_thenCallsSetRevert()
      throws UnsupportedEncodingException {
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

    // Assert
    verify(programResult).setRevert();
    verify(program).getResult();
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program).setHReturn(isA(byte[].class));
    verify(program, atLeast(1)).stackPop();
    verify(program).step();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#revertAction(Program)}.
   * <ul>
   *   <li>Then throw {@link StaticCallModificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#revertAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.revertAction(Program)"})
  public void testRevertAction_thenThrowStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    when(program.memoryChunk(anyInt(), anyInt())).thenThrow(new StaticCallModificationException());
    when(program.stackPop()).thenReturn(DataWord.ZERO());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.revertAction(program));
    verify(program).memoryChunk(eq(0), eq(0));
    verify(program, atLeast(1)).stackPop();
  }

  /**
   * Test {@link OperationActions#suicideAction(Program)}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>When {@link Program} {@link Program#getResult()} return createEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.suicideAction(Program)"})
  public void testSuicideAction_givenCreateEmpty_whenProgramGetResultReturnCreateEmpty() {
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
   * Test {@link OperationActions#suicideAction(Program)}.
   * <ul>
   *   <li>Given {@link ProgramResult} {@link ProgramResult#setRevert()} does nothing.</li>
   *   <li>Then calls {@link ProgramResult#setRevert()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.suicideAction(Program)"})
  public void testSuicideAction_givenProgramResultSetRevertDoesNothing_thenCallsSetRevert() {
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

    // Assert
    verify(programResult).setRevert();
    verify(program).canSuicide();
    verify(program).getResult();
    verify(program).isStaticCall();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#suicideAction(Program)}.
   * <ul>
   *   <li>Given {@link StaticCallModificationException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.suicideAction(Program)"})
  public void testSuicideAction_givenStaticCallModificationException() {
    // Arrange
    Program program = mock(Program.class);
    doThrow(new StaticCallModificationException()).when(program).stop();
    when(program.canSuicide()).thenReturn(false);
    when(program.isStaticCall()).thenReturn(false);
    when(program.getResult()).thenReturn(ProgramResult.createEmpty());

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.suicideAction(program));
    verify(program).canSuicide();
    verify(program).getResult();
    verify(program).isStaticCall();
    verify(program).stop();
  }

  /**
   * Test {@link OperationActions#suicideAction(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#canSuicide()} return {@code true}.</li>
   *   <li>Then calls {@link Program#stackPop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.suicideAction(Program)"})
  public void testSuicideAction_givenZero_whenProgramCanSuicideReturnTrue_thenCallsStackPop() {
    // Arrange
    Program program = mock(Program.class);
    when(program.stackPop()).thenReturn(DataWord.ZERO());
    doNothing().when(program).stop();
    doNothing().when(program).suicide(Mockito.<DataWord>any());
    when(program.canSuicide()).thenReturn(true);
    when(program.isStaticCall()).thenReturn(false);

    // Act
    OperationActions.suicideAction(program);

    // Assert
    verify(program).canSuicide();
    verify(program).isStaticCall();
    verify(program).stackPop();
    verify(program).stop();
    verify(program).suicide(isA(DataWord.class));
  }

  /**
   * Test {@link OperationActions#suicideAction(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#isStaticCall()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationActions#suicideAction(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationActions.suicideAction(Program)"})
  public void testSuicideAction_whenProgramIsStaticCallReturnTrue() {
    // Arrange
    Program program = mock(Program.class);
    when(program.isStaticCall()).thenReturn(true);

    // Act and Assert
    assertThrows(StaticCallModificationException.class, () -> OperationActions.suicideAction(program));
    verify(program).isStaticCall();
  }
}
