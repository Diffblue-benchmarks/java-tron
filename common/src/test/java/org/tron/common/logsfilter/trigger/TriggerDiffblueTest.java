package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Trigger}
   *   <li>{@link Trigger#setTimeStamp(long)}
   *   <li>{@link Trigger#setTriggerName(String)}
   *   <li>{@link Trigger#getTimeStamp()}
   *   <li>{@link Trigger#getTriggerName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Trigger actualTrigger = new Trigger();
    actualTrigger.setTimeStamp(10L);
    actualTrigger.setTriggerName("Trigger Name");
    long actualTimeStamp = actualTrigger.getTimeStamp();

    // Assert that nothing has changed
    assertEquals("Trigger Name", actualTrigger.getTriggerName());
    assertEquals(10L, actualTimeStamp);
  }
}
