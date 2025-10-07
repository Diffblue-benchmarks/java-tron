package org.tron.core.vm.trace;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProgramTraceListenerDiffblueTest {
  /**
   * Test {@link ProgramTraceListener#resetActions()}.
   *
   * <p>Method under test: {@link ProgramTraceListener#resetActions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OpActions ProgramTraceListener.resetActions()"})
  public void testResetActions() {
    // Arrange and Act
    OpActions actualResetActionsResult = new ProgramTraceListener(true).resetActions();

    // Assert
    assertTrue(actualResetActionsResult.getMemory().isEmpty());
    assertTrue(actualResetActionsResult.getStack().isEmpty());
    assertTrue(actualResetActionsResult.getStorage().isEmpty());
  }
}
