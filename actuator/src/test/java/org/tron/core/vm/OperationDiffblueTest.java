package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;

public class OperationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Operation#Operation(int, int, int, Function, Consumer, BooleanSupplier)}
   *   <li>{@link Operation#getOpcode()}
   *   <li>{@link Operation#getRequire()}
   *   <li>{@link Operation#getRet()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Operation.<init>(int, int, int, Function, Consumer, BooleanSupplier)",
    "int Operation.getOpcode()",
    "int Operation.getRequire()",
    "int Operation.getRet()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Operation actualOperation =
        new Operation(
            1, 1, 1, mock(Function.class), mock(Consumer.class), mock(BooleanSupplier.class));
    int actualOpcode = actualOperation.getOpcode();
    int actualRequire = actualOperation.getRequire();

    // Assert
    assertEquals(1, actualOpcode);
    assertEquals(1, actualRequire);
    assertEquals(1, actualOperation.getRet());
  }

  /**
   * Test {@link Operation#Operation(int, int, int, Function, Consumer)}.
   *
   * <p>Method under test: {@link Operation#Operation(int, int, int, Function, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Operation.<init>(int, int, int, Function, Consumer)"})
  public void testNewOperation() {
    // Arrange and Act
    Operation actualOperation = new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class));

    // Assert
    assertEquals(1, actualOperation.getOpcode());
    assertEquals(1, actualOperation.getRequire());
    assertEquals(1, actualOperation.getRet());
    assertTrue(actualOperation.isEnabled());
  }

  /**
   * Test {@link Operation#getEnergyCost(Program)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Operation#getEnergyCost(Program)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Operation.getEnergyCost(Program)"})
  public void testGetEnergyCost_givenFunctionApplyReturnOne_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange
    Function<Program, Long> cost = mock(Function.class);
    when(cost.apply(Mockito.<Program>any())).thenReturn(1L);
    Operation operation = new Operation(1, 1, 1, cost, mock(Consumer.class));
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
    long actualEnergyCost = operation.getEnergyCost(program);

    // Assert
    verify(cost).apply(isA(Program.class));
    assertEquals(1L, actualEnergyCost);
  }

  /**
   * Test {@link Operation#isEnabled()}.
   *
   * <p>Method under test: {@link Operation#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class)).isEnabled());
  }

  /**
   * Test {@link Operation#isEnabled()}.
   *
   * <ul>
   *   <li>Given {@link BooleanSupplier} {@link BooleanSupplier#getAsBoolean()} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Operation#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.isEnabled()"})
  public void testIsEnabled_givenBooleanSupplierGetAsBooleanReturnFalse_thenReturnFalse() {
    // Arrange
    BooleanSupplier enabled = mock(BooleanSupplier.class);
    when(enabled.getAsBoolean()).thenReturn(false);

    // Act
    boolean actualIsEnabledResult =
        new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class), enabled).isEnabled();

    // Assert
    verify(enabled).getAsBoolean();
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link Operation#isEnabled()}.
   *
   * <ul>
   *   <li>Given {@link BooleanSupplier} {@link BooleanSupplier#getAsBoolean()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Operation#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.isEnabled()"})
  public void testIsEnabled_givenBooleanSupplierGetAsBooleanReturnTrue_thenReturnTrue() {
    // Arrange
    BooleanSupplier enabled = mock(BooleanSupplier.class);
    when(enabled.getAsBoolean()).thenReturn(true);

    // Act
    boolean actualIsEnabledResult =
        new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class), enabled).isEnabled();

    // Assert
    verify(enabled).getAsBoolean();
    assertTrue(actualIsEnabledResult);
  }
}
