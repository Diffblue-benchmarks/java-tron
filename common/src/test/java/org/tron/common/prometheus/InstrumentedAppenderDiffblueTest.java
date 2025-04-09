package org.tron.common.prometheus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstrumentedAppenderDiffblueTest {
  /**
   * Test new {@link InstrumentedAppender} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link InstrumentedAppender}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstrumentedAppender.<init>()"})
  public void testNewInstrumentedAppender() {
    // Arrange and Act
    InstrumentedAppender actualInstrumentedAppender = new InstrumentedAppender();

    // Assert
    assertNull(actualInstrumentedAppender.getContext());
    assertNull(actualInstrumentedAppender.getStatusManager());
    assertNull(actualInstrumentedAppender.getName());
    assertFalse(actualInstrumentedAppender.isStarted());
    assertTrue(actualInstrumentedAppender.getCopyOfAttachedFiltersList().isEmpty());
  }
}
