package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;

public class SolidityLogCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SolidityLogCapsule#SolidityLogCapsule(ContractLogTrigger)}
   *   <li>{@link SolidityLogCapsule#setSolidityLogTrigger(ContractLogTrigger)}
   *   <li>{@link SolidityLogCapsule#getSolidityLogTrigger()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolidityLogCapsule.<init>(ContractLogTrigger)",
      "ContractLogTrigger SolidityLogCapsule.getSolidityLogTrigger()",
      "void SolidityLogCapsule.setSolidityLogTrigger(ContractLogTrigger)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SolidityLogCapsule actualSolidityLogCapsule = new SolidityLogCapsule(new ContractLogTrigger());
    ContractLogTrigger solidityLogTrigger = new ContractLogTrigger();
    actualSolidityLogCapsule.setSolidityLogTrigger(solidityLogTrigger);

    // Assert
    assertSame(solidityLogTrigger, actualSolidityLogCapsule.getSolidityLogTrigger());
  }
}
