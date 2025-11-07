package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.tron.common.logsfilter.trigger.SolidityTrigger;

public class SolidityTriggerCapsuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SolidityTriggerCapsule#setSolidityTrigger(SolidityTrigger)}
   *   <li>{@link SolidityTriggerCapsule#getSolidityTrigger()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SolidityTriggerCapsule solidityTriggerCapsule = new SolidityTriggerCapsule(1L);

    SolidityTrigger solidityTrigger = new SolidityTrigger();
    solidityTrigger.setLatestSolidifiedBlockNumber(1L);
    solidityTrigger.setTimeStamp(10L);
    solidityTrigger.setTriggerName("Trigger Name");

    // Act
    solidityTriggerCapsule.setSolidityTrigger(solidityTrigger);

    // Assert that nothing has changed
    assertSame(solidityTrigger, solidityTriggerCapsule.getSolidityTrigger());
  }

  /**
   * Method under test: {@link SolidityTriggerCapsule#setTimeStamp(long)}
   */
  @Test
  public void testSetTimeStamp() {
    // Arrange
    SolidityTriggerCapsule solidityTriggerCapsule = new SolidityTriggerCapsule(1L);

    // Act
    solidityTriggerCapsule.setTimeStamp(10L);

    // Assert
    assertEquals(10L, solidityTriggerCapsule.getSolidityTrigger().getTimeStamp());
  }

  /**
   * Method under test:
   * {@link SolidityTriggerCapsule#SolidityTriggerCapsule(long)}
   */
  @Test
  public void testNewSolidityTriggerCapsule() {
    // Arrange, Act and Assert
    SolidityTrigger solidityTrigger = (new SolidityTriggerCapsule(1L)).getSolidityTrigger();
    assertEquals("solidityTrigger", solidityTrigger.getTriggerName());
    assertEquals(0L, solidityTrigger.getTimeStamp());
    assertEquals(1L, solidityTrigger.getLatestSolidifiedBlockNumber());
  }
}
