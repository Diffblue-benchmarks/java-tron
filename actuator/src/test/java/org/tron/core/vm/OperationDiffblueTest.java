package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.InternalTransaction;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.protos.Protocol;

public class OperationDiffblueTest {
  /**
   * Method under test: {@link Operation#getEnergyCost(Program)}
   */
  @Test
  public void testGetEnergyCost() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Function<Program, Long> cost = mock(Function.class);
    when(cost.apply(Mockito.<Program>any())).thenReturn(1L);
    Operation operation = new Operation(1, 1, 1, cost, mock(Consumer.class));
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act
    long actualEnergyCost = operation.getEnergyCost(
        new Program(ops, codeAddress, programInvoke, new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)));

    // Assert
    verify(cost).apply(isA(Program.class));
    assertEquals(1L, actualEnergyCost);
  }

  /**
   * Method under test: {@link Operation#execute(Program)}
   */
  @Test
  public void testExecute() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    Consumer<Program> action = mock(Consumer.class);
    doNothing().when(action).accept(Mockito.<Program>any());
    Operation operation = new Operation(1, 1, 1, mock(Function.class), action);
    byte[] ops = "AXAXAXAX".getBytes("UTF-8");
    byte[] codeAddress = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeMockImpl programInvoke = new ProgramInvokeMockImpl();

    // Act
    operation.execute(new Program(ops, codeAddress, programInvoke, new InternalTransaction(
        Protocol.Transaction.getDefaultInstance(), InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)));

    // Assert that nothing has changed
    verify(action).accept(isA(Program.class));
  }

  /**
   * Method under test: {@link Operation#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class))).isEnabled());
  }

  /**
   * Method under test: {@link Operation#isEnabled()}
   */
  @Test
  public void testIsEnabled2() {
    // Arrange
    BooleanSupplier enabled = mock(BooleanSupplier.class);
    when(enabled.getAsBoolean()).thenReturn(true);

    // Act
    boolean actualIsEnabledResult = (new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class), enabled))
        .isEnabled();

    // Assert
    verify(enabled).getAsBoolean();
    assertTrue(actualIsEnabledResult);
  }

  /**
   * Method under test: {@link Operation#isEnabled()}
   */
  @Test
  public void testIsEnabled3() {
    // Arrange
    BooleanSupplier enabled = mock(BooleanSupplier.class);
    when(enabled.getAsBoolean()).thenReturn(false);

    // Act
    boolean actualIsEnabledResult = (new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class), enabled))
        .isEnabled();

    // Assert
    verify(enabled).getAsBoolean();
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link Operation#Operation(int, int, int, Function, Consumer, BooleanSupplier)}
   *   <li>{@link Operation#getOpcode()}
   *   <li>{@link Operation#getRequire()}
   *   <li>{@link Operation#getRet()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Operation actualOperation = new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class),
        mock(BooleanSupplier.class));
    int actualOpcode = actualOperation.getOpcode();
    int actualRequire = actualOperation.getRequire();

    // Assert
    assertEquals(1, actualOpcode);
    assertEquals(1, actualRequire);
    assertEquals(1, actualOperation.getRet());
  }

  /**
   * Method under test:
   * {@link Operation#Operation(int, int, int, Function, Consumer)}
   */
  @Test
  public void testNewOperation() {
    // Arrange and Act
    Operation actualOperation = new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class));

    // Assert
    assertEquals(1, actualOperation.getOpcode());
    assertEquals(1, actualOperation.getRequire());
    assertEquals(1, actualOperation.getRet());
    assertTrue(actualOperation.isEnabled());
  }
}
