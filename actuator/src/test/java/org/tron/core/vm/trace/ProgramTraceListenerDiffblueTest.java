package org.tron.core.vm.trace;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ProgramTraceListenerDiffblueTest {
  /**
   * Method under test: {@link ProgramTraceListener#resetActions()}
   */
  @Test
  public void testResetActions() {
    // Arrange and Act
    OpActions actualResetActionsResult = (new ProgramTraceListener(true)).resetActions();

    // Assert
    assertTrue(actualResetActionsResult.getMemory().isEmpty());
    assertTrue(actualResetActionsResult.getStack().isEmpty());
    assertTrue(actualResetActionsResult.getStorage().isEmpty());
  }
}
