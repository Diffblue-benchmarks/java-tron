package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class FilterTriggerCapsuleDiffblueTest {
  /**
   * Method under test: {@link FilterTriggerCapsule#processFilterTrigger()}
   */
  @Test
  public void testProcessFilterTrigger() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new FilterTriggerCapsule()).processFilterTrigger());
  }
}
