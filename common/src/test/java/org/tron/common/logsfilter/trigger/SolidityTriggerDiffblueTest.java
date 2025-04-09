package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SolidityTriggerDiffblueTest {
  /**
   * Test new {@link SolidityTrigger} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SolidityTrigger}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolidityTrigger.<init>()"})
  public void testNewSolidityTrigger() {
    // Arrange and Act
    SolidityTrigger actualSolidityTrigger = new SolidityTrigger();

    // Assert
    assertEquals(0L, actualSolidityTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualSolidityTrigger.getTimeStamp());
    assertEquals(Trigger.SOLIDITY_TRIGGER_NAME, actualSolidityTrigger.getTriggerName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SolidityTrigger#setLatestSolidifiedBlockNumber(long)}
   *   <li>{@link SolidityTrigger#toString()}
   *   <li>{@link SolidityTrigger#getLatestSolidifiedBlockNumber()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long SolidityTrigger.getLatestSolidifiedBlockNumber()",
      "void SolidityTrigger.setLatestSolidifiedBlockNumber(long)", "String SolidityTrigger.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    SolidityTrigger solidityTrigger = new SolidityTrigger();

    // Act
    solidityTrigger.setLatestSolidifiedBlockNumber(1L);
    String actualToStringResult = solidityTrigger.toString();

    // Assert
    assertEquals("triggerName: solidityTriggertimestamp: 0, latestSolidifiedBlockNumber: 1", actualToStringResult);
    assertEquals(1L, solidityTrigger.getLatestSolidifiedBlockNumber());
  }
}
