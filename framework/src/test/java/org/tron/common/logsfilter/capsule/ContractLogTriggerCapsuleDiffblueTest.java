package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;

public class ContractLogTriggerCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContractLogTriggerCapsule#ContractLogTriggerCapsule(ContractLogTrigger)}
   *   <li>{@link ContractLogTriggerCapsule#setContractLogTrigger(ContractLogTrigger)}
   *   <li>{@link ContractLogTriggerCapsule#getContractLogTrigger()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ContractLogTriggerCapsule.<init>(ContractLogTrigger)",
    "ContractLogTrigger ContractLogTriggerCapsule.getContractLogTrigger()",
    "void ContractLogTriggerCapsule.setContractLogTrigger(ContractLogTrigger)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ContractLogTriggerCapsule actualContractLogTriggerCapsule =
        new ContractLogTriggerCapsule(new ContractLogTrigger());
    ContractLogTrigger contractLogTrigger = new ContractLogTrigger();
    actualContractLogTriggerCapsule.setContractLogTrigger(contractLogTrigger);

    // Assert
    assertSame(contractLogTrigger, actualContractLogTriggerCapsule.getContractLogTrigger());
  }

  /**
   * Test {@link ContractLogTriggerCapsule#setLatestSolidifiedBlockNumber(long)}.
   *
   * <p>Method under test: {@link ContractLogTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractLogTriggerCapsule.setLatestSolidifiedBlockNumber(long)"})
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    ContractLogTriggerCapsule contractLogTriggerCapsule =
        new ContractLogTriggerCapsule(new ContractLogTrigger());

    // Act
    contractLogTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    assertEquals(
        1L, contractLogTriggerCapsule.getContractLogTrigger().getLatestSolidifiedBlockNumber());
  }
}
