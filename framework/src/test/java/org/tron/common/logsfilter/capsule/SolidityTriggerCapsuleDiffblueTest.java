package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.SolidityTrigger;

public class SolidityTriggerCapsuleDiffblueTest {
  /**
   * Test {@link SolidityTriggerCapsule#SolidityTriggerCapsule(long)}.
   *
   * <p>Method under test: {@link SolidityTriggerCapsule#SolidityTriggerCapsule(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolidityTriggerCapsule.<init>(long)"})
  public void testNewSolidityTriggerCapsule() {
    // Arrange, Act and Assert
    SolidityTrigger solidityTrigger = new SolidityTriggerCapsule(1L).getSolidityTrigger();
    assertEquals("solidityTrigger", solidityTrigger.getTriggerName());
    assertEquals(0L, solidityTrigger.getTimeStamp());
    assertEquals(1L, solidityTrigger.getLatestSolidifiedBlockNumber());
  }

  /**
   * Test {@link SolidityTriggerCapsule#setTimeStamp(long)}.
   *
   * <p>Method under test: {@link SolidityTriggerCapsule#setTimeStamp(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolidityTriggerCapsule.setTimeStamp(long)"})
  public void testSetTimeStamp() {
    // Arrange
    SolidityTriggerCapsule solidityTriggerCapsule = new SolidityTriggerCapsule(1L);

    // Act
    solidityTriggerCapsule.setTimeStamp(10L);

    // Assert
    assertEquals(10L, solidityTriggerCapsule.getSolidityTrigger().getTimeStamp());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SolidityTriggerCapsule#setSolidityTrigger(SolidityTrigger)}
   *   <li>{@link SolidityTriggerCapsule#getSolidityTrigger()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolidityTrigger SolidityTriggerCapsule.getSolidityTrigger()",
    "void SolidityTriggerCapsule.setSolidityTrigger(SolidityTrigger)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SolidityTriggerCapsule solidityTriggerCapsule = new SolidityTriggerCapsule(1L);

    SolidityTrigger solidityTrigger = new SolidityTrigger();
    solidityTrigger.setLatestSolidifiedBlockNumber(1L);
    solidityTrigger.setTimeStamp(10L);
    solidityTrigger.setTriggerName("Trigger Name");

    // Act
    solidityTriggerCapsule.setSolidityTrigger(solidityTrigger);

    // Assert
    assertSame(solidityTrigger, solidityTriggerCapsule.getSolidityTrigger());
  }
}
