package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
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
import org.tron.core.vm.program.Stack;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;

public class OperationActionsDiffblueTest {
  /**
   * Test {@link OperationActions#stopAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#stopAction(Program)}
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
    OperationActions.stopAction(program);

    // Assert
    assertTrue(program.isStopped());
  }

  /**
   * Test {@link OperationActions#addressAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#addressAction(Program)}
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
    OperationActions.addressAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#originAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#originAction(Program)}
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
    OperationActions.originAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#callerAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#callerAction(Program)}
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
    OperationActions.callerAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals(
        "000000000000000000000000885f93eed577f2fc341ebb9a5c9b2ce4465d96c4",
        getResult.toHexString());
    assertEquals("885f93", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
          ']', -106, -60
        },
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
          ']', -106, -60
        },
        getResult.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
          'F', ']', -106, -60
        },
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69,
          -102, '\\', -101, ',', -28, 'F', ']', -106, -60
        },
        getResult.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69,
          -102, '\\', -101, ',', -28, 'F', ']', -106, -60
        },
        data2);
  }

  /**
   * Test {@link OperationActions#callValueAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#callValueAction(Program)}
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
    OperationActions.callValueAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#callDataSizeAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#callDataSizeAction(Program)}
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
    OperationActions.callDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#codeSizeAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#codeSizeAction(Program)}
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
    OperationActions.codeSizeAction(program);

    // Assert
    Stack stack = program.getStack();
    assertEquals(1, stack.size());
    DataWord getResult = stack.get(0);
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000008",
        getResult.toHexString());
    assertEquals("08", getResult.toPrefixString());
    assertEquals(1, program.getPC());
    assertFalse(getResult.isNegative());
    assertFalse(getResult.isZero());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
    byte[] data2 = getResult.getData();
    assertSame(data2, getResult.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'\b'}, getResult.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        getResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\b'
        },
        getResult.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\b'
        },
        data2);
  }

  /**
   * Test {@link OperationActions#returnDataSizeAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#returnDataSizeAction(Program)}
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
    OperationActions.returnDataSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#gasPriceAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#gasPriceAction(Program)}
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
    OperationActions.gasPriceAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#coinBaseAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#coinBaseAction(Program)}
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
    OperationActions.coinBaseAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#timeStampAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#timeStampAction(Program)}
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
    OperationActions.timeStampAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#numberAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#numberAction(Program)}
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
    OperationActions.numberAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#difficultyAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#difficultyAction(Program)}
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
    OperationActions.difficultyAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#gasLimitAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#gasLimitAction(Program)}
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
    OperationActions.gasLimitAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#selfBalanceAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#selfBalanceAction(Program)}
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
    OperationActions.selfBalanceAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#pcAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#pcAction(Program)}
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
    OperationActions.pcAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#mSizeAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#mSizeAction(Program)}
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
    OperationActions.mSizeAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#gasAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#gasAction(Program)}
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
    OperationActions.gasAction(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#jumpDestAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#jumpDestAction(Program)}
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
    OperationActions.jumpDestAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#push0Action(Program)}.
   *
   * <p>Method under test: {@link OperationActions#push0Action(Program)}
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
    OperationActions.push0Action(program);

    // Assert
    assertEquals(1, program.getStack().size());
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }

  /**
   * Test {@link OperationActions#swapAction(Program)}.
   *
   * <p>Method under test: {@link OperationActions#swapAction(Program)}
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
    OperationActions.swapAction(program);

    // Assert
    assertEquals(1, program.getPC());
    assertEquals(Op.PC, program.getCurrentOpIntValue());
    assertEquals('X', program.getCurrentOp());
  }
}
