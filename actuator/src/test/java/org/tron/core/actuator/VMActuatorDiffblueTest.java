package org.tron.core.actuator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction;
import org.tron.common.runtime.InternalTransaction.TrxType;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;

public class VMActuatorDiffblueTest {
  /**
   * Test {@link VMActuator#VMActuator(boolean)}.
   * <p>
   * Method under test: {@link VMActuator#VMActuator(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VMActuator.<init>(boolean)"})
  public void testNewVMActuator() {
    // Arrange and Act
    VMActuator actualVmActuator = new VMActuator(true);

    // Assert
    assertNull(actualVmActuator.getTrxType());
    assertTrue(actualVmActuator.isConstantCall());
  }

  /**
   * Test {@link VMActuator#validate(Object)}.
   * <p>
   * Method under test: {@link VMActuator#validate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VMActuator.validate(Object)"})
  public void testValidate() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new VMActuator(true)).validate(null));
  }

  /**
   * Test {@link VMActuator#execute(Object)}.
   * <p>
   * Method under test: {@link VMActuator#execute(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VMActuator.execute(Object)"})
  public void testExecute() throws ContractExeException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new VMActuator(true)).execute(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VMActuator#setConstantCall(boolean)}
   *   <li>{@link VMActuator#setEnableEventListener(boolean)}
   *   <li>{@link VMActuator#setTrxType(TrxType)}
   *   <li>{@link VMActuator#getTrxType()}
   *   <li>{@link VMActuator#isConstantCall()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrxType VMActuator.getTrxType()", "boolean VMActuator.isConstantCall()",
      "void VMActuator.setConstantCall(boolean)", "void VMActuator.setEnableEventListener(boolean)",
      "void VMActuator.setTrxType(TrxType)"})
  public void testGettersAndSetters() {
    // Arrange
    VMActuator vmActuator = new VMActuator(true);

    // Act
    vmActuator.setConstantCall(true);
    vmActuator.setEnableEventListener(true);
    vmActuator.setTrxType(TrxType.TRX_PRECOMPILED_TYPE);
    TrxType actualTrxType = vmActuator.getTrxType();

    // Assert
    assertEquals(TrxType.TRX_PRECOMPILED_TYPE, actualTrxType);
    assertTrue(vmActuator.isConstantCall());
  }
}
