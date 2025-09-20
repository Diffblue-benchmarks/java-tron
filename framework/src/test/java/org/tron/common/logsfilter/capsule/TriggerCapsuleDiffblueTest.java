package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TriggerCapsuleDiffblueTest {
  /**
   * Test {@link TriggerCapsule#processTrigger()}.
   *
   * <p>Method under test: {@link TriggerCapsule#processTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TriggerCapsule.processTrigger()"})
  public void testProcessTrigger() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new TriggerCapsule().processTrigger());
  }
}
