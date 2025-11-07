package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolidityTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SolidityTrigger#setLatestSolidifiedBlockNumber(long)}
   *   <li>{@link SolidityTrigger#toString()}
   *   <li>{@link SolidityTrigger#getLatestSolidifiedBlockNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SolidityTrigger solidityTrigger = new SolidityTrigger();

    // Act
    solidityTrigger.setLatestSolidifiedBlockNumber(1L);
    String actualToStringResult = solidityTrigger.toString();

    // Assert that nothing has changed
    assertEquals("triggerName: solidityTriggertimestamp: 0, latestSolidifiedBlockNumber: 1", actualToStringResult);
    assertEquals(1L, solidityTrigger.getLatestSolidifiedBlockNumber());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SolidityTrigger}
   */
  @Test
  public void testNewSolidityTrigger() {
    // Arrange and Act
    SolidityTrigger actualSolidityTrigger = new SolidityTrigger();

    // Assert
    assertEquals(0L, actualSolidityTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualSolidityTrigger.getTimeStamp());
    assertEquals(Trigger.SOLIDITY_TRIGGER_NAME, actualSolidityTrigger.getTriggerName());
  }
}
