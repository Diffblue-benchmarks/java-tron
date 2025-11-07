package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class TriggerCapsuleDiffblueTest {
  /**
   * Method under test: {@link TriggerCapsule#processTrigger()}
   */
  @Test
  public void testProcessTrigger() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new TriggerCapsule()).processTrigger());
  }
}
