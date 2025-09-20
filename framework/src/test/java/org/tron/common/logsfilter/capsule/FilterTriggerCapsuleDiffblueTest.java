package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilterTriggerCapsuleDiffblueTest {
  /**
   * Test {@link FilterTriggerCapsule#processFilterTrigger()}.
   *
   * <p>Method under test: {@link FilterTriggerCapsule#processFilterTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterTriggerCapsule.processFilterTrigger()"})
  public void testProcessFilterTrigger() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new FilterTriggerCapsule().processFilterTrigger());
  }
}
