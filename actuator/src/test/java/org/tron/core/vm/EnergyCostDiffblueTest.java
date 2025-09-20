package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Program.OutOfEnergyException;
import org.tron.core.vm.program.Stack;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;

public class EnergyCostDiffblueTest {
  /**
   * Test {@link EnergyCost#getZeroTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getZeroTierCost(Program)}
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

    Program ignored =
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
    assertEquals(0L, EnergyCost.getZeroTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getVeryLowTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getVeryLowTierCost(Program)}
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

    Program ignored =
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
    assertEquals(3L, EnergyCost.getVeryLowTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getLowTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getLowTierCost(Program)}
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

    Program ignored =
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
    assertEquals(5L, EnergyCost.getLowTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getMidTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getMidTierCost(Program)}
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

    Program ignored =
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
    assertEquals(8L, EnergyCost.getMidTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getBaseTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getBaseTierCost(Program)}
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

    Program ignored =
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
    assertEquals(2L, EnergyCost.getBaseTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getExtTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return twenty.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getExtTierCost(Program)}
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

    Program ignored =
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
    assertEquals(20L, EnergyCost.getExtTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getHighTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getHighTierCost(Program)}
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

    Program ignored =
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
    assertEquals(10L, EnergyCost.getHighTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getSpecialTierCost(Program)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getSpecialTierCost(Program)}
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

    Program ignored =
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
    assertEquals(1L, EnergyCost.getSpecialTierCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getExtCodeSizeCost(Program)}.
   *
   * <ul>
   *   <li>Then return twenty.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getExtCodeSizeCost(Program)}
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

    Program ignored =
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
    assertEquals(20L, EnergyCost.getExtCodeSizeCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getExtCodeHashCost(Program)}.
   *
   * <ul>
   *   <li>Then return four hundred.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getExtCodeHashCost(Program)}
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

    Program ignored =
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
    assertEquals(400L, EnergyCost.getExtCodeHashCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getSloadCost(Program)}.
   *
   * <ul>
   *   <li>Then return fifty.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getSloadCost(Program)}
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

    Program ignored =
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
    assertEquals(50L, EnergyCost.getSloadCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getSuicideCost(Program)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getSuicideCost(Program)}
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

    Program ignored =
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
    assertEquals(0L, EnergyCost.getSuicideCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getBalanceCost(Program)}.
   *
   * <ul>
   *   <li>Then return twenty.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getBalanceCost(Program)}
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

    Program ignored =
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
    assertEquals(20L, EnergyCost.getBalanceCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getUnfreezeCost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 20000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getUnfreezeCost(Program)}
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

    Program ignored =
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
    assertEquals(20000L, EnergyCost.getUnfreezeCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getFreezeExpireTimeCost(Program)}.
   *
   * <ul>
   *   <li>Then return fifty.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getFreezeExpireTimeCost(Program)}
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

    Program ignored =
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
    assertEquals(50L, EnergyCost.getFreezeExpireTimeCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getFreezeBalanceV2Cost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getFreezeBalanceV2Cost(Program)}
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

    Program ignored =
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
    assertEquals(10000L, EnergyCost.getFreezeBalanceV2Cost(ignored));
  }

  /**
   * Test {@link EnergyCost#getUnfreezeBalanceV2Cost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getUnfreezeBalanceV2Cost(Program)}
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

    Program ignored =
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
    assertEquals(10000L, EnergyCost.getUnfreezeBalanceV2Cost(ignored));
  }

  /**
   * Test {@link EnergyCost#getWithdrawExpireUnfreezeCost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getWithdrawExpireUnfreezeCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getWithdrawExpireUnfreezeCost(Program)"})
  public void testGetWithdrawExpireUnfreezeCost_thenReturn10000()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program ignored =
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
    assertEquals(10000L, EnergyCost.getWithdrawExpireUnfreezeCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getCancelAllUnfreezeV2Cost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCancelAllUnfreezeV2Cost(Program)}
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

    Program ignored =
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
    assertEquals(10000L, EnergyCost.getCancelAllUnfreezeV2Cost(ignored));
  }

  /**
   * Test {@link EnergyCost#getDelegateResourceCost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getDelegateResourceCost(Program)}
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

    Program ignored =
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
    assertEquals(10000L, EnergyCost.getDelegateResourceCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getUnDelegateResourceCost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getUnDelegateResourceCost(Program)}
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

    Program ignored =
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
    assertEquals(10000L, EnergyCost.getUnDelegateResourceCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getWithdrawRewardCost(Program)}.
   *
   * <ul>
   *   <li>Then return {@code 20000}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getWithdrawRewardCost(Program)}
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

    Program ignored =
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
    assertEquals(20000L, EnergyCost.getWithdrawRewardCost(ignored));
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost() throws UnsupportedEncodingException {
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost2() throws UnsupportedEncodingException {
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost3() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.of((byte) 'A'));
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    DataWord adjustedCallEnergy = program.getAdjustedCallEnergy();
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000031",
        adjustedCallEnergy.toHexString());
    assertEquals("31", adjustedCallEnergy.toPrefixString());
    assertEquals(50L, actualCalculateCallCost);
    assertFalse(adjustedCallEnergy.isNegative());
    assertFalse(adjustedCallEnergy.isZero());
    byte[] data2 = adjustedCallEnergy.getData();
    assertSame(data2, adjustedCallEnergy.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'1'}, adjustedCallEnergy.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        adjustedCallEnergy.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1'},
        adjustedCallEnergy.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '1'
        },
        adjustedCallEnergy.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '1'
        },
        data2);
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost4() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            new byte[] {},
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenDataWordWithNumIsA_thenReturnTen()
      throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.of((byte) 'A'));
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(10L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenMax_value() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);

    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    programInvoke.setEnergyLimit(Long.MAX_VALUE);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenMinusOne() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);

    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    programInvoke.setEnergyLimit(-1L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenOne() throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    Program program =
        new Program(
            new byte[] {},
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
    program.setContractVersion(1);

    // Act
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <ul>
   *   <li>Given two hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenTwoHundredFiftyFive()
      throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);

    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    programInvoke.setEnergyLimit(255L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
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
    long actualCalculateCallCost = EnergyCost.getCalculateCallCost(stack, program, 1L, 1);

    // Assert
    assertEquals(1L, actualCalculateCallCost);
    assertSame(ZEROResult, program.getAdjustedCallEnergy());
  }

  /**
   * Test {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then throw {@link Program.OutOfEnergyException}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyCost#getCalculateCallCost(Stack, Program, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EnergyCost.getCalculateCallCost(Stack, Program, long, int)"})
  public void testGetCalculateCallCost_givenZero_thenThrowOutOfEnergyException()
      throws UnsupportedEncodingException {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());
    stack.add(DataWord.ZERO());

    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();
    programInvoke.setEnergyLimit(0L);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
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
    assertThrows(
        OutOfEnergyException.class, () -> EnergyCost.getCalculateCallCost(stack, program, 1L, 1));
  }
}
