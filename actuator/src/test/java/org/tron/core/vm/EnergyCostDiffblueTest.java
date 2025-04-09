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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Program.Exception;
import org.tron.core.vm.program.Program.OutOfEnergyException;
import org.tron.core.vm.program.Program.OutOfMemoryException;
import org.tron.core.vm.program.Stack;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Repository;

public class EnergyCostDiffblueTest {
  /**
   * Test {@link EnergyCost#getZeroTierCost(Program)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getZeroTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getZeroTierCost(Program)"})
  public void testGetZeroTierCost_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L,
        EnergyCost.getZeroTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
            1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getVeryLowTierCost(Program)}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getVeryLowTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getVeryLowTierCost(Program)"})
  public void testGetVeryLowTierCost_thenReturnThree() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3L,
        EnergyCost.getVeryLowTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
            1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getLowTierCost(Program)}.
   * <ul>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLowTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLowTierCost(Program)"})
  public void testGetLowTierCost_thenReturnFive() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(5L,
        EnergyCost.getLowTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getMidTierCost(Program)}.
   * <ul>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMidTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMidTierCost(Program)"})
  public void testGetMidTierCost_thenReturnEight() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8L,
        EnergyCost.getMidTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getBaseTierCost(Program)}.
   * <ul>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getBaseTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getBaseTierCost(Program)"})
  public void testGetBaseTierCost_thenReturnTwo() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(2L,
        EnergyCost.getBaseTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
            1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getExtTierCost(Program)}.
   * <ul>
   *   <li>Then return twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtTierCost(Program)"})
  public void testGetExtTierCost_thenReturnTwenty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(20L,
        EnergyCost.getExtTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getHighTierCost(Program)}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getHighTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getHighTierCost(Program)"})
  public void testGetHighTierCost_thenReturnTen() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10L,
        EnergyCost.getHighTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
            1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getSpecialTierCost(Program)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSpecialTierCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSpecialTierCost(Program)"})
  public void testGetSpecialTierCost_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L,
        EnergyCost.getSpecialTierCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
            1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getExpCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#bytesOccupied()} return one.</li>
   *   <li>Then calls {@link DataWord#bytesOccupied()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExpCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExpCost(Program)"})
  public void testGetExpCost_givenDataWordBytesOccupiedReturnOne_thenCallsBytesOccupied() {
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
   * Test {@link EnergyCost#getExpCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExpCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExpCost(Program)"})
  public void testGetExpCost_givenStackAddDataWordWithNumIsA_thenReturnTwenty() {
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
   * Test {@link EnergyCost#getExpCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>When {@link Program} {@link Program#getStack()} return {@link Stack} (default constructor).</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExpCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExpCost(Program)"})
  public void testGetExpCost_givenStackAddZero_whenProgramGetStackReturnStack_thenReturnTen() {
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
   * Test {@link EnergyCost#getExtCodeSizeCost(Program)}.
   * <ul>
   *   <li>Then return twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeSizeCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeSizeCost(Program)"})
  public void testGetExtCodeSizeCost_thenReturnTwenty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(20L,
        EnergyCost.getExtCodeSizeCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
            1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_givenDataWordIsZeroReturnTrue_thenReturnFortyTwo() {
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
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return forty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_givenDataWordValueReturnValueOfOne_thenReturnFortyFive() {
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
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return forty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_givenDataWordValueReturnValueOfOne_thenReturnFortyFive2() {
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
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_givenMinusSeventeen_whenProgramGetMemSizeReturnMinusSeventeen() {
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
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_givenStackAddDataWordWithNumIsA_thenReturnFiftySeven() {
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
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return thirty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_givenStackAddZero_thenReturnThirty() {
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
   * Test {@link EnergyCost#getSha3Cost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSha3Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSha3Cost(Program)"})
  public void testGetSha3Cost_thenThrowOutOfEnergyException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 30L, 30L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getSha3Cost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_givenDataWordIsZeroReturnTrue_thenReturnSix() {
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
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_givenDataWordValueReturnValueOfOne_thenReturnNine() {
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
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_givenDataWordValueReturnValueOfOne_thenReturnNine2() {
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
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_givenMinusSeventeen() {
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
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_givenStackAddDataWordWithNumIsA_thenReturnEighteen() {
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
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_givenStackAddZero_thenReturnZero() {
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
   * Test {@link EnergyCost#getCodeCopyCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCodeCopyCost(Program)"})
  public void testGetCodeCopyCost_thenThrowOutOfEnergyException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 3L, 3L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCodeCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_givenDataWordIsZeroReturnTrue_thenReturnSix() {
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
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_givenDataWordValueReturnValueOfOne_thenReturnNine() {
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
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_givenDataWordValueReturnValueOfOne_thenReturnNine2() {
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
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_givenMinusSeventeen() {
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
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_givenStackAddDataWordWithNumIsA_thenReturnEighteen() {
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
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_givenStackAddZero_thenReturnZero() {
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
   * Test {@link EnergyCost#getReturnDataCopyCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnDataCopyCost(Program)"})
  public void testGetReturnDataCopyCost_thenThrowOutOfEnergyException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 3L, 3L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getReturnDataCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_givenDataWordIsZeroReturnTrue_thenReturnSix() {
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
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_givenDataWordValueReturnValueOfOne_thenReturnNine() {
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
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_givenDataWordValueReturnValueOfOne_thenReturnNine2() {
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
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_givenMinusSeventeen() {
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
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_givenStackAddDataWordWithNumIsA_thenReturnEighteen() {
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
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_givenStackAddZero_thenReturnZero() {
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
   * Test {@link EnergyCost#getCallDataCopyCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallDataCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallDataCopyCost(Program)"})
  public void testGetCallDataCopyCost_thenThrowOutOfEnergyException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 3L, 3L));
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallDataCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return twenty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_givenDataWordIsZeroReturnTrue_thenReturnTwentySix() {
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
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_givenDataWordValueReturnValueOfOne_thenReturnTwentyNine() {
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
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_givenDataWordValueReturnValueOfOne_thenReturnTwentyNine2() {
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
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_givenMinusSeventeen() {
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
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return thirty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_givenStackAddDataWordWithNumIsA_thenReturnThirtyEight() {
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
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_givenStackAddZero_thenReturnTwenty() {
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
   * Test {@link EnergyCost#getExtCodeCopyCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeCopyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeCopyCost(Program)"})
  public void testGetExtCodeCopyCost_thenThrowOutOfEnergyException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValueSafe()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 20L, 20L));
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getExtCodeCopyCost(program));
    verify(dataWord).isZero();
    verify(dataWord).longValueSafe();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getExtCodeHashCost(Program)}.
   * <ul>
   *   <li>Then return four hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getExtCodeHashCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getExtCodeHashCost(Program)"})
  public void testGetExtCodeHashCost_thenReturnFourHundred() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(400L,
        EnergyCost.getExtCodeHashCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
            1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getMloadCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMloadCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMloadCost(Program)"})
  public void testGetMloadCost_givenDataWordValueReturnValueOfOne_thenReturnSix() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMloadCost = EnergyCost.getMloadCost(program);

    // Assert
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(6L, actualMloadCost);
  }

  /**
   * Test {@link EnergyCost#getMloadCost(Program)}.
   * <ul>
   *   <li>Given {@link Op#SHA3}.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return {@link Op#SHA3}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMloadCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMloadCost(Program)"})
  public void testGetMloadCost_givenSha3_whenProgramGetMemSizeReturnSha3_thenReturnZero() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(Op.SHA3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMloadCost = EnergyCost.getMloadCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualMloadCost);
  }

  /**
   * Test {@link EnergyCost#getMloadCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMloadCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMloadCost(Program)"})
  public void testGetMloadCost_givenStackAddZero_thenReturnThree() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMloadCost = EnergyCost.getMloadCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualMloadCost);
  }

  /**
   * Test {@link EnergyCost#getMloadCost2(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMloadCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMloadCost2(Program)"})
  public void testGetMloadCost2_givenDataWordValueReturnValueOfOne_thenReturnSeven() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMloadCost2 = EnergyCost.getMloadCost2(program);

    // Assert
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(7L, actualMloadCost2);
  }

  /**
   * Test {@link EnergyCost#getMloadCost2(Program)}.
   * <ul>
   *   <li>Given {@link Op#SHA3}.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return {@link Op#SHA3}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMloadCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMloadCost2(Program)"})
  public void testGetMloadCost2_givenSha3_whenProgramGetMemSizeReturnSha3_thenReturnOne() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(Op.SHA3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMloadCost2 = EnergyCost.getMloadCost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(1L, actualMloadCost2);
  }

  /**
   * Test {@link EnergyCost#getMloadCost2(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMloadCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMloadCost2(Program)"})
  public void testGetMloadCost2_givenStackAddZero_thenReturnFour() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMloadCost2 = EnergyCost.getMloadCost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(4L, actualMloadCost2);
  }

  /**
   * Test {@link EnergyCost#getMStoreCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStoreCost(Program)"})
  public void testGetMStoreCost_givenDataWordValueReturnValueOfOne_thenReturnSix() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStoreCost = EnergyCost.getMStoreCost(program);

    // Assert
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(6L, actualMStoreCost);
  }

  /**
   * Test {@link EnergyCost#getMStoreCost(Program)}.
   * <ul>
   *   <li>Given {@link Op#SHA3}.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return {@link Op#SHA3}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStoreCost(Program)"})
  public void testGetMStoreCost_givenSha3_whenProgramGetMemSizeReturnSha3_thenReturnZero() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(Op.SHA3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStoreCost = EnergyCost.getMStoreCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualMStoreCost);
  }

  /**
   * Test {@link EnergyCost#getMStoreCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStoreCost(Program)"})
  public void testGetMStoreCost_givenStackAddZero_thenReturnThree() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStoreCost = EnergyCost.getMStoreCost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualMStoreCost);
  }

  /**
   * Test {@link EnergyCost#getMStoreCost2(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStoreCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStoreCost2(Program)"})
  public void testGetMStoreCost2_givenDataWordValueReturnValueOfOne_thenReturnSeven() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStoreCost2 = EnergyCost.getMStoreCost2(program);

    // Assert
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(7L, actualMStoreCost2);
  }

  /**
   * Test {@link EnergyCost#getMStoreCost2(Program)}.
   * <ul>
   *   <li>Given {@link Op#SHA3}.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return {@link Op#SHA3}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStoreCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStoreCost2(Program)"})
  public void testGetMStoreCost2_givenSha3_whenProgramGetMemSizeReturnSha3_thenReturnOne() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(Op.SHA3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStoreCost2 = EnergyCost.getMStoreCost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(1L, actualMStoreCost2);
  }

  /**
   * Test {@link EnergyCost#getMStoreCost2(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStoreCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStoreCost2(Program)"})
  public void testGetMStoreCost2_givenStackAddZero_thenReturnFour() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStoreCost2 = EnergyCost.getMStoreCost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(4L, actualMStoreCost2);
  }

  /**
   * Test {@link EnergyCost#getMStore8Cost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then calls {@link DataWord#value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStore8Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStore8Cost(Program)"})
  public void testGetMStore8Cost_givenDataWordValueReturnValueOfOne_thenCallsValue() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStore8Cost = EnergyCost.getMStore8Cost(program);

    // Assert
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualMStore8Cost);
  }

  /**
   * Test {@link EnergyCost#getMStore8Cost(Program)}.
   * <ul>
   *   <li>Given {@link Op#SHA3}.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return {@link Op#SHA3}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStore8Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStore8Cost(Program)"})
  public void testGetMStore8Cost_givenSha3_whenProgramGetMemSizeReturnSha3_thenReturnZero() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(Op.SHA3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStore8Cost = EnergyCost.getMStore8Cost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(0L, actualMStore8Cost);
  }

  /**
   * Test {@link EnergyCost#getMStore8Cost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStore8Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStore8Cost(Program)"})
  public void testGetMStore8Cost_givenStackAddZero_thenReturnThree() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStore8Cost = EnergyCost.getMStore8Cost(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(3L, actualMStore8Cost);
  }

  /**
   * Test {@link EnergyCost#getMStore8Cost2(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then calls {@link DataWord#value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStore8Cost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStore8Cost2(Program)"})
  public void testGetMStore8Cost2_givenDataWordValueReturnValueOfOne_thenCallsValue() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord);
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStore8Cost2 = EnergyCost.getMStore8Cost2(program);

    // Assert
    verify(dataWord).value();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(4L, actualMStore8Cost2);
  }

  /**
   * Test {@link EnergyCost#getMStore8Cost2(Program)}.
   * <ul>
   *   <li>Given {@link Op#SHA3}.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return {@link Op#SHA3}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStore8Cost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStore8Cost2(Program)"})
  public void testGetMStore8Cost2_givenSha3_whenProgramGetMemSizeReturnSha3_thenReturnOne() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(Op.SHA3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStore8Cost2 = EnergyCost.getMStore8Cost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(1L, actualMStore8Cost2);
  }

  /**
   * Test {@link EnergyCost#getMStore8Cost2(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getMStore8Cost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getMStore8Cost2(Program)"})
  public void testGetMStore8Cost2_givenStackAddZero_thenReturnFour() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualMStore8Cost2 = EnergyCost.getMStore8Cost2(program);

    // Assert
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(4L, actualMStore8Cost2);
  }

  /**
   * Test {@link EnergyCost#getSloadCost(Program)}.
   * <ul>
   *   <li>Then return fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSloadCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSloadCost(Program)"})
  public void testGetSloadCost_thenReturnFifty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(50L,
        EnergyCost.getSloadCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getReturnCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnCost(Program)"})
  public void testGetReturnCost_givenDataWordIsZeroReturnTrue_thenReturnZero() {
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
   * Test {@link EnergyCost#getReturnCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnCost(Program)"})
  public void testGetReturnCost_givenDataWordValueReturnValueOfOne_thenReturnThree() {
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
   * Test {@link EnergyCost#getReturnCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnCost(Program)"})
  public void testGetReturnCost_givenDataWordValueReturnValueOfOne_thenReturnThree2() {
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
   * Test {@link EnergyCost#getReturnCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnCost(Program)"})
  public void testGetReturnCost_givenMinusSeventeen_whenProgramGetMemSizeReturnMinusSeventeen() {
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
   * Test {@link EnergyCost#getReturnCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnCost(Program)"})
  public void testGetReturnCost_givenStackAddDataWordWithNumIsA_thenReturnNine() {
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
   * Test {@link EnergyCost#getReturnCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getReturnCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getReturnCost(Program)"})
  public void testGetReturnCost_givenStackAddZero_thenReturnZero() {
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
   * Test {@link EnergyCost#getRevertCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getRevertCost(Program)"})
  public void testGetRevertCost_givenDataWordIsZeroReturnTrue_thenReturnZero() {
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
   * Test {@link EnergyCost#getRevertCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getRevertCost(Program)"})
  public void testGetRevertCost_givenDataWordValueReturnValueOfOne_thenReturnThree() {
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
   * Test {@link EnergyCost#getRevertCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getRevertCost(Program)"})
  public void testGetRevertCost_givenDataWordValueReturnValueOfOne_thenReturnThree2() {
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
   * Test {@link EnergyCost#getRevertCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getRevertCost(Program)"})
  public void testGetRevertCost_givenMinusSeventeen_whenProgramGetMemSizeReturnMinusSeventeen() {
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
   * Test {@link EnergyCost#getRevertCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getRevertCost(Program)"})
  public void testGetRevertCost_givenStackAddDataWordWithNumIsA_thenReturnNine() {
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
   * Test {@link EnergyCost#getRevertCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getRevertCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getRevertCost(Program)"})
  public void testGetRevertCost_givenStackAddZero_thenReturnZero() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code false}.</li>
   *   <li>Then return {@code 20000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_givenDataWordIsZeroReturnFalse_thenReturn20000() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_givenDataWordIsZeroReturnTrue_thenCallsIsZero2() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Program} {@link Program#storageLoad(DataWord)} return {@code null}.</li>
   *   <li>Then return {@code 5000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_givenNull_whenProgramStorageLoadReturnNull_thenReturn5000() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_givenStackAddDataWordWithNumIsA() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#storageLoad(DataWord)} return ZERO.</li>
   *   <li>Then return {@code 5000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_givenZero_whenProgramStorageLoadReturnZero_thenReturn5000() {
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
   * Test {@link EnergyCost#getSstoreCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSstoreCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSstoreCost(Program)"})
  public void testGetSstoreCost_thenThrowOutOfEnergyException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 2L, 2L));

    Stack stack = new Stack();
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.storageLoad(Mockito.<DataWord>any())).thenReturn(null);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getSstoreCost(program));
    verify(dataWord).isZero();
    verify(program).getStack();
    verify(program).storageLoad(isA(DataWord.class));
  }

  /**
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code false}.</li>
   *   <li>Then return {@code -43536}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_givenDataWordIsZeroReturnFalse_thenReturn43536() {
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
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code false}.</li>
   *   <li>Then return {@code -43536}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_givenDataWordIsZeroReturnFalse_thenReturn435362() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.value()).thenReturn(BigInteger.valueOf(1L));
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.isZero()).thenReturn(false);
    when(dataWord2.longValue()).thenReturn(42L);
    when(dataWord2.value()).thenReturn(BigInteger.valueOf(1L));

    Stack stack = new Stack();
    stack.add(dataWord2);
    stack.add(dataWord);
    DataWord dataWord3 = mock(DataWord.class);
    when(dataWord3.value()).thenReturn(BigInteger.valueOf(160L));
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord3);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualLogCost = EnergyCost.getLogCost(program);

    // Assert
    verify(dataWord2, atLeast(1)).isZero();
    verify(dataWord2).longValue();
    verify(dataWord3).value();
    verify(dataWord, atLeast(1)).value();
    verify(dataWord2, atLeast(1)).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    assertEquals(-43536L, actualLogCost);
  }

  /**
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return {@code -43539}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_givenDataWordIsZeroReturnTrue_thenReturn43539() {
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
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return {@code -43875}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_givenDataWordValueReturnValueOfOne_thenReturn43875() {
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
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return minus one.</li>
   *   <li>Then return {@code -43539}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_givenMinusOne_whenProgramGetMemSizeReturnMinusOne_thenReturn43539() {
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
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getEnergyLimitLeft()} return ZERO.</li>
   *   <li>Then return {@code -43875}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_givenZero_whenProgramGetEnergyLimitLeftReturnZero_thenReturn43875() {
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
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_thenThrowOutOfEnergyException() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getLogCost(program));
    verify(dataWord).longValueSafe();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_thenThrowOutOfEnergyException2() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getLogCost(program));
    verify(dataWord2).longValueSafe();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getLogCost(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfMemoryException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getLogCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getLogCost(Program)"})
  public void testGetLogCost_thenThrowOutOfMemoryException() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.longValue()).thenThrow(Exception.memoryOverflow(Op.LOG0));
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
    assertThrows(OutOfMemoryException.class, () -> EnergyCost.getLogCost(program));
    verify(dataWord).longValue();
    verify(dataWord2).value();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getSuicideCost(Program)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSuicideCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSuicideCost(Program)"})
  public void testGetSuicideCost_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L,
        EnergyCost.getSuicideCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getSuicideCost2(Program)}.
   * <ul>
   *   <li>Given {@link Repository} {@link Repository#getAccount(byte[])} return {@link AccountCapsule}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSuicideCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSuicideCost2(Program)"})
  public void testGetSuicideCost2_givenRepositoryGetAccountReturnAccountCapsule_thenReturnZero() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    Repository repository = mock(Repository.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(mock(AccountCapsule.class));
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
   * Test {@link EnergyCost#getSuicideCost2(Program)}.
   * <ul>
   *   <li>Given {@link Repository} {@link Repository#getAccount(byte[])} return {@code null}.</li>
   *   <li>Then return {@code 25000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSuicideCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSuicideCost2(Program)"})
  public void testGetSuicideCost2_givenRepositoryGetAccountReturnNull_thenReturn25000() {
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
   * Test {@link EnergyCost#getSuicideCost2(Program)}.
   * <ul>
   *   <li>Then throw {@link Program.OutOfEnergyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getSuicideCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getSuicideCost2(Program)"})
  public void testGetSuicideCost2_thenThrowOutOfEnergyException() throws UnsupportedEncodingException {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.toTronAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Stack stack = new Stack();
    stack.add(dataWord);
    Repository repository = mock(Repository.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenThrow(Exception.notEnoughSpendEnergy("Hint", 21L, 21L));
    Program program = mock(Program.class);
    when(program.getContractState()).thenReturn(repository);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getSuicideCost2(program));
    verify(dataWord).toTronAddress();
    verify(program).getContractState();
    verify(program).getStack();
    verify(repository).getAccount(isA(byte[].class));
  }

  /**
   * Test {@link EnergyCost#getBalanceCost(Program)}.
   * <ul>
   *   <li>Then return twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getBalanceCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getBalanceCost(Program)"})
  public void testGetBalanceCost_thenReturnTwenty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(20L,
        EnergyCost.getBalanceCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
            sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getUnfreezeCost(Program)}.
   * <ul>
   *   <li>Then return {@code 20000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getUnfreezeCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getUnfreezeCost(Program)"})
  public void testGetUnfreezeCost_thenReturn20000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(20000L,
        EnergyCost.getUnfreezeCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
            1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getFreezeExpireTimeCost(Program)}.
   * <ul>
   *   <li>Then return fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getFreezeExpireTimeCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getFreezeExpireTimeCost(Program)"})
  public void testGetFreezeExpireTimeCost_thenReturnFifty() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(50L,
        EnergyCost
            .getFreezeExpireTimeCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
                1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getFreezeBalanceV2Cost(Program)}.
   * <ul>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getFreezeBalanceV2Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getFreezeBalanceV2Cost(Program)"})
  public void testGetFreezeBalanceV2Cost_thenReturn10000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10000L,
        EnergyCost
            .getFreezeBalanceV2Cost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
                1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getUnfreezeBalanceV2Cost(Program)}.
   * <ul>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getUnfreezeBalanceV2Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getUnfreezeBalanceV2Cost(Program)"})
  public void testGetUnfreezeBalanceV2Cost_thenReturn10000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10000L,
        EnergyCost
            .getUnfreezeBalanceV2Cost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
                1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getWithdrawExpireUnfreezeCost(Program)}.
   * <ul>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getWithdrawExpireUnfreezeCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getWithdrawExpireUnfreezeCost(Program)"})
  public void testGetWithdrawExpireUnfreezeCost_thenReturn10000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10000L, EnergyCost
        .getWithdrawExpireUnfreezeCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
            1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getCancelAllUnfreezeV2Cost(Program)}.
   * <ul>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCancelAllUnfreezeV2Cost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCancelAllUnfreezeV2Cost(Program)"})
  public void testGetCancelAllUnfreezeV2Cost_thenReturn10000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10000L,
        EnergyCost
            .getCancelAllUnfreezeV2Cost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
                1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getDelegateResourceCost(Program)}.
   * <ul>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateResourceCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateResourceCost(Program)"})
  public void testGetDelegateResourceCost_thenReturn10000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10000L,
        EnergyCost
            .getDelegateResourceCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
                1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getUnDelegateResourceCost(Program)}.
   * <ul>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getUnDelegateResourceCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getUnDelegateResourceCost(Program)"})
  public void testGetUnDelegateResourceCost_thenReturn10000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10000L,
        EnergyCost
            .getUnDelegateResourceCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash,
                1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getVoteWitnessCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return {@code 30000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getVoteWitnessCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getVoteWitnessCost(Program)"})
  public void testGetVoteWitnessCost_givenStackAddZero_thenReturn30000() {
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
   * Test {@link EnergyCost#getVoteWitnessCost2(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return {@code 30003}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getVoteWitnessCost2(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getVoteWitnessCost2(Program)"})
  public void testGetVoteWitnessCost2_givenStackAddZero_thenReturn30003() {
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
   * Test {@link EnergyCost#getWithdrawRewardCost(Program)}.
   * <ul>
   *   <li>Then return {@code 20000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getWithdrawRewardCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getWithdrawRewardCost(Program)"})
  public void testGetWithdrawRewardCost_thenReturn20000() throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(20000L,
        EnergyCost
            .getWithdrawRewardCost(new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1,
                1, sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()))));
  }

  /**
   * Test {@link EnergyCost#getCreateCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then return {@code 32000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCreateCost(Program)"})
  public void testGetCreateCost_givenDataWordIsZeroReturnTrue_thenReturn32000() {
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
   * Test {@link EnergyCost#getCreateCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return {@code 32003}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCreateCost(Program)"})
  public void testGetCreateCost_givenDataWordValueReturnValueOfOne_thenReturn32003() {
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
   * Test {@link EnergyCost#getCreateCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#value()} return valueOf one.</li>
   *   <li>Then return {@code 32003}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCreateCost(Program)"})
  public void testGetCreateCost_givenDataWordValueReturnValueOfOne_thenReturn320032() {
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
   * Test {@link EnergyCost#getCreateCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   *   <li>When {@link Program} {@link Program#getMemSize()} return minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCreateCost(Program)"})
  public void testGetCreateCost_givenMinusSeventeen_whenProgramGetMemSizeReturnMinusSeventeen() {
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
   * Test {@link EnergyCost#getCreateCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   *   <li>Then return {@code 32009}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCreateCost(Program)"})
  public void testGetCreateCost_givenStackAddDataWordWithNumIsA_thenReturn32009() {
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
   * Test {@link EnergyCost#getCreateCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return {@code 32000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCreateCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCreateCost(Program)"})
  public void testGetCreateCost_givenStackAddZero_thenReturn32000() {
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
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 40L, 40L));
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallCost(program));
    verify(dataWord2).clone();
    verify(dataWord).isZero();
    verify(dataWord2).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#clone()} return ZERO.</li>
   *   <li>Then calls {@link DataWord#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenDataWordCloneReturnZero_thenCallsClone() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenReturn(DataWord.ZERO());
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
    long actualCallCost = EnergyCost.getCallCost(program);

    // Assert
    verify(dataWord2).clone();
    verify(dataWord).isZero();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualCallCost);
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#longValueSafe()} return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenDataWordLongValueSafeReturnTwo() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(2L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallCost(program));
    verify(dataWord).isZero();
    verify(dataWord2, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sub(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sub(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenDataWordSubDoesNothing_thenCallsSub() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
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
    long actualCallCost = EnergyCost.getCallCost(program);

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
    assertEquals(82L, actualCallCost);
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenDataWordWithNumIsA() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) 'A'));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallCost = EnergyCost.getCallCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord2).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualCallCost);
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenDataWordWithNumIsMinusOne() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) -1));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallCost = EnergyCost.getCallCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord2).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualCallCost);
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getCallEnergy(DataWord, DataWord)} return ZERO.</li>
   *   <li>Then return forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenZero_whenProgramGetCallEnergyReturnZero_thenReturnForty() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
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
    long actualCallCost = EnergyCost.getCallCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(40L, actualCallCost);
  }

  /**
   * Test {@link EnergyCost#getCallCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getEnergyLimitLeft()} return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallCost(Program)"})
  public void testGetCallCost_givenZero_whenProgramGetEnergyLimitLeftReturnZero() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.ZERO());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallCost(program));
    verify(dataWord).isZero();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 40L, 40L));
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord).clone();
    verify(dataWord).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#clone()} return ZERO.</li>
   *   <li>Then calls {@link DataWord#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordCloneReturnZero_thenCallsClone() {
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
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code false}.</li>
   *   <li>Then calls {@link DataWord#value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordIsZeroReturnFalse_thenCallsValue() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord).isZero();
    verify(dataWord2, atLeast(1)).longValueSafe();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
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
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#longValueSafe()} return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordLongValueSafeReturnThree() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sub(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sub(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordSubDoesNothing_thenCallsSub() {
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
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordWithNumIsA() {
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
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenDataWordWithNumIsMinusOne() {
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
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenMinusSeventeen() {
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
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenStackAddDataWordWithNumIsA() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getEnergyLimitLeft()} return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_givenZero_whenProgramGetEnergyLimitLeftReturnZero() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getStaticCallCost(program));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getStaticCallCost(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#getCallEnergy(DataWord, DataWord)} return ZERO.</li>
   *   <li>Then return forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getStaticCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getStaticCallCost(Program)"})
  public void testGetStaticCallCost_whenProgramGetCallEnergyReturnZero_thenReturnForty() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.clone()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 40L, 40L));
    when(dataWord.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord).clone();
    verify(dataWord).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#clone()} return ZERO.</li>
   *   <li>Then calls {@link DataWord#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordCloneReturnZero_thenCallsClone() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code false}.</li>
   *   <li>Then calls {@link DataWord#value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordIsZeroReturnFalse_thenCallsValue() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord).isZero();
    verify(dataWord2, atLeast(1)).longValueSafe();
    verify(dataWord).value();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link DataWord#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordIsZeroReturnTrue_thenCallsIsZero() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#longValueSafe()} return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordLongValueSafeReturnThree() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sub(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sub(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordSubDoesNothing_thenCallsSub() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordWithNumIsA() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenDataWordWithNumIsMinusOne() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given minus seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenMinusSeventeen() {
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
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenStackAddDataWordWithNumIsA() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(dataWord, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getEnergyLimitLeft()} return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_givenZero_whenProgramGetEnergyLimitLeftReturnZero() {
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
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getDelegateCallCost(program));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getDelegateCallCost(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#getCallEnergy(DataWord, DataWord)} return ZERO.</li>
   *   <li>Then return forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getDelegateCallCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getDelegateCallCost(Program)"})
  public void testGetDelegateCallCost_whenProgramGetCallEnergyReturnZero_thenReturnForty() {
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
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenThrow(Exception.notEnoughSpendEnergy("Hint", 40L, 40L));
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallTokenCost(program));
    verify(dataWord2).clone();
    verify(dataWord).isZero();
    verify(dataWord2).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#clone()} return ZERO.</li>
   *   <li>Then calls {@link DataWord#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_givenDataWordCloneReturnZero_thenCallsClone() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.clone()).thenReturn(DataWord.ZERO());
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
    long actualCallTokenCost = EnergyCost.getCallTokenCost(program);

    // Assert
    verify(dataWord2).clone();
    verify(dataWord).isZero();
    verify(dataWord3).longValueSafe();
    verify(dataWord2).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualCallTokenCost);
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#longValueSafe()} return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_givenDataWordLongValueSafeReturnTwo() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(2L);
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(dataWord2);
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallTokenCost(program));
    verify(dataWord).isZero();
    verify(dataWord2, atLeast(1)).longValueSafe();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} {@link DataWord#sub(DataWord)} does nothing.</li>
   *   <li>Then calls {@link DataWord#sub(DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_givenDataWordSubDoesNothing_thenCallsSub() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
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
    long actualCallTokenCost = EnergyCost.getCallTokenCost(program);

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
    assertEquals(82L, actualCallTokenCost);
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_givenDataWordWithNumIsA() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) 'A'));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallTokenCost = EnergyCost.getCallTokenCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord2).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualCallTokenCost);
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>Given {@link DataWord} with num is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_givenDataWordWithNumIsMinusOne() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord dataWord2 = mock(DataWord.class);
    when(dataWord2.longValueSafe()).thenReturn(42L);
    Program program = mock(Program.class);
    when(program.getCallEnergy(Mockito.<DataWord>any(), Mockito.<DataWord>any())).thenReturn(dataWord2);
    doNothing().when(program).setAdjustedCallEnergy(Mockito.<DataWord>any());
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.of((byte) -1));
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act
    long actualCallTokenCost = EnergyCost.getCallTokenCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(dataWord2).longValueSafe();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(82L, actualCallTokenCost);
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Program} {@link Program#getEnergyLimitLeft()} return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_givenZero_whenProgramGetEnergyLimitLeftReturnZero() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    Program program = mock(Program.class);
    when(program.getEnergyLimitLeft()).thenReturn(DataWord.ZERO());
    when(program.getCurrentOpIntValue()).thenReturn(42);
    when(program.getMemSize()).thenReturn(3);
    when(program.getStack()).thenReturn(stack);

    // Act and Assert
    assertThrows(OutOfEnergyException.class, () -> EnergyCost.getCallTokenCost(program));
    verify(dataWord).isZero();
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
  }

  /**
   * Test {@link EnergyCost#getCallTokenCost(Program)}.
   * <ul>
   *   <li>When {@link Program} {@link Program#getCallEnergy(DataWord, DataWord)} return ZERO.</li>
   *   <li>Then return forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCallTokenCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCallTokenCost(Program)"})
  public void testGetCallTokenCost_whenProgramGetCallEnergyReturnZero_thenReturnForty() {
    // Arrange
    DataWord dataWord = mock(DataWord.class);
    when(dataWord.isZero()).thenReturn(true);

    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(dataWord);
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
    long actualCallTokenCost = EnergyCost.getCallTokenCost(program);

    // Assert
    verify(dataWord).isZero();
    verify(program).getCallEnergy(isA(DataWord.class), isA(DataWord.class));
    verify(program).getCurrentOpIntValue();
    verify(program, atLeast(1)).getEnergyLimitLeft();
    verify(program).getMemSize();
    verify(program).getStack();
    verify(program).setAdjustedCallEnergy(isA(DataWord.class));
    assertEquals(40L, actualCallTokenCost);
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenZero_whenStackAddZero_thenReturnOne() throws UnsupportedEncodingException {
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
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act and Assert
    assertEquals(1L, EnergyCost.getCalculateCallCost(stack, program, 1L, 1));
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   * <ul>
   *   <li>Given ZERO.</li>
   *   <li>When {@link Stack} (default constructor) add ZERO.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenZero_whenStackAddZero_thenReturnOne2() throws UnsupportedEncodingException {
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
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    Program program = new Program(ops, codeAddress, programInvoke, new InternalTransaction(parentHash, 1, 1,
        sendAddress, transferToAddress, 42L, data, "Note", 1L, new HashMap<>()));

    // Act and Assert
    assertEquals(1L, EnergyCost.getCalculateCallCost(stack, program, 1L, 1));
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }
}
