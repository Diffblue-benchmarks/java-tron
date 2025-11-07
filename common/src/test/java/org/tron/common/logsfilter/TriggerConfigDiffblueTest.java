package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TriggerConfig}
   *   <li>{@link TriggerConfig#setEnabled(boolean)}
   *   <li>{@link TriggerConfig#setEthCompatible(boolean)}
   *   <li>{@link TriggerConfig#setRedundancy(boolean)}
   *   <li>{@link TriggerConfig#setSolidified(boolean)}
   *   <li>{@link TriggerConfig#setTopic(String)}
   *   <li>{@link TriggerConfig#setTriggerName(String)}
   *   <li>{@link TriggerConfig#getTopic()}
   *   <li>{@link TriggerConfig#getTriggerName()}
   *   <li>{@link TriggerConfig#isEnabled()}
   *   <li>{@link TriggerConfig#isEthCompatible()}
   *   <li>{@link TriggerConfig#isRedundancy()}
   *   <li>{@link TriggerConfig#isSolidified()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TriggerConfig actualTriggerConfig = new TriggerConfig();
    actualTriggerConfig.setEnabled(true);
    actualTriggerConfig.setEthCompatible(true);
    actualTriggerConfig.setRedundancy(true);
    actualTriggerConfig.setSolidified(true);
    actualTriggerConfig.setTopic("Topic");
    actualTriggerConfig.setTriggerName("Trigger Name");
    String actualTopic = actualTriggerConfig.getTopic();
    String actualTriggerName = actualTriggerConfig.getTriggerName();
    boolean actualIsEnabledResult = actualTriggerConfig.isEnabled();
    boolean actualIsEthCompatibleResult = actualTriggerConfig.isEthCompatible();
    boolean actualIsRedundancyResult = actualTriggerConfig.isRedundancy();

    // Assert that nothing has changed
    assertEquals("Topic", actualTopic);
    assertEquals("Trigger Name", actualTriggerName);
    assertTrue(actualIsEnabledResult);
    assertTrue(actualIsEthCompatibleResult);
    assertTrue(actualIsRedundancyResult);
    assertTrue(actualTriggerConfig.isSolidified());
  }
}
