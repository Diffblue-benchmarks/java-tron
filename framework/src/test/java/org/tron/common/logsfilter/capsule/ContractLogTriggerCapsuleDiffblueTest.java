package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;

public class ContractLogTriggerCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link ContractLogTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    ContractLogTrigger contractLogTrigger = new ContractLogTrigger();
    ContractLogTriggerCapsule contractLogTriggerCapsule = new ContractLogTriggerCapsule(contractLogTrigger);

    // Act
    contractLogTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    ContractLogTrigger contractLogTrigger2 = contractLogTriggerCapsule.getContractLogTrigger();
    assertEquals(1L, contractLogTrigger2.getLatestSolidifiedBlockNumber());
    assertSame(contractLogTrigger, contractLogTrigger2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ContractLogTriggerCapsule#ContractLogTriggerCapsule(ContractLogTrigger)}
   *   <li>
   * {@link ContractLogTriggerCapsule#setContractLogTrigger(ContractLogTrigger)}
   *   <li>{@link ContractLogTriggerCapsule#getContractLogTrigger()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ContractLogTriggerCapsule actualContractLogTriggerCapsule = new ContractLogTriggerCapsule(new ContractLogTrigger());
    ContractLogTrigger contractLogTrigger = new ContractLogTrigger();
    actualContractLogTriggerCapsule.setContractLogTrigger(contractLogTrigger);

    // Assert that nothing has changed
    assertSame(contractLogTrigger, actualContractLogTriggerCapsule.getContractLogTrigger());
  }

  /**
   * Method under test: {@link ContractLogTriggerCapsule#processTrigger()}
   */
  @Test
  public void testProcessTrigger() {
    // Arrange
    ContractLogTrigger contractLogTrigger = mock(ContractLogTrigger.class);
    when(contractLogTrigger.getBlockNumber()).thenReturn(1L);

    // Act
    (new ContractLogTriggerCapsule(contractLogTrigger)).processTrigger();

    // Assert that nothing has changed
    verify(contractLogTrigger).getBlockNumber();
  }
}
