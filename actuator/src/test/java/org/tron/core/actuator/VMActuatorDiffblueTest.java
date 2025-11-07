package org.tron.core.actuator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.common.runtime.InternalTransaction;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;

public class VMActuatorDiffblueTest {
  /**
   * Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  public void testValidate() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new VMActuator(true)).validate(null));
  }

  /**
   * Method under test: {@link VMActuator#execute(Object)}
   */
  @Test
  public void testExecute() throws ContractExeException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new VMActuator(true)).execute(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VMActuator#setConstantCall(boolean)}
   *   <li>{@link VMActuator#setEnableEventListener(boolean)}
   *   <li>{@link VMActuator#setTrxType(InternalTransaction.TrxType)}
   *   <li>{@link VMActuator#getTrxType()}
   *   <li>{@link VMActuator#isConstantCall()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    // Act
    vmActuator.setConstantCall(true);
    vmActuator.setEnableEventListener(true);
    vmActuator.setTrxType(InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE);
    InternalTransaction.TrxType actualTrxType = vmActuator.getTrxType();

    // Assert that nothing has changed
    assertEquals(InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE, actualTrxType);
    assertTrue(vmActuator.isConstantCall());
  }

  /**
   * Method under test: {@link VMActuator#VMActuator(boolean)}
   */
  @Test
  public void testNewVMActuator() {
    // Arrange and Act
    VMActuator actualVmActuator = new VMActuator(true);

    // Assert
    assertNull(actualVmActuator.getTrxType());
    assertTrue(actualVmActuator.isConstantCall());
  }
}
