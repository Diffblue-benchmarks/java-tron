package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TriggerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Trigger}
   *   <li>{@link Trigger#setTimeStamp(long)}
   *   <li>{@link Trigger#setTriggerName(String)}
   *   <li>{@link Trigger#getTimeStamp()}
   *   <li>{@link Trigger#getTriggerName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Trigger.<init>()",
    "long Trigger.getTimeStamp()",
    "String Trigger.getTriggerName()",
    "void Trigger.setTimeStamp(long)",
    "void Trigger.setTriggerName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Trigger actualTrigger = new Trigger();
    actualTrigger.setTimeStamp(10L);
    actualTrigger.setTriggerName("Trigger Name");
    long actualTimeStamp = actualTrigger.getTimeStamp();

    // Assert
    assertEquals("Trigger Name", actualTrigger.getTriggerName());
    assertEquals(10L, actualTimeStamp);
  }
}
