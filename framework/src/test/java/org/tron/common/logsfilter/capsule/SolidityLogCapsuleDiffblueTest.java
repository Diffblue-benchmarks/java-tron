package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;

public class SolidityLogCapsuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SolidityLogCapsule#SolidityLogCapsule(ContractLogTrigger)}
   *   <li>{@link SolidityLogCapsule#setSolidityLogTrigger(ContractLogTrigger)}
   *   <li>{@link SolidityLogCapsule#getSolidityLogTrigger()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SolidityLogCapsule actualSolidityLogCapsule = new SolidityLogCapsule(new ContractLogTrigger());
    ContractLogTrigger solidityLogTrigger = new ContractLogTrigger();
    actualSolidityLogCapsule.setSolidityLogTrigger(solidityLogTrigger);

    // Assert that nothing has changed
    assertSame(solidityLogTrigger, actualSolidityLogCapsule.getSolidityLogTrigger());
  }
}
