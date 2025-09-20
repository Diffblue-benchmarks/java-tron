package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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

  /**
   * Test {@link ContractLogTriggerCapsule#processTrigger()}.
   *
   * <ul>
   *   <li>Given {@link ContractLogTrigger} {@link ContractLogTrigger#getBlockNumber()} return
   *       {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ContractLogTriggerCapsule#processTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractLogTriggerCapsule.processTrigger()"})
  public void testProcessTrigger_givenContractLogTriggerGetBlockNumberReturnMax_value() {
    // Arrange
    ContractLogTrigger contractLogTrigger = mock(ContractLogTrigger.class);
    when(contractLogTrigger.getBlockNumber()).thenReturn(Long.MAX_VALUE);

    ContractLogTriggerCapsule contractLogTriggerCapsule =
        new ContractLogTriggerCapsule(mock(ContractLogTrigger.class));
    contractLogTriggerCapsule.setContractLogTrigger(contractLogTrigger);

    // Act
    contractLogTriggerCapsule.processTrigger();

    // Assert
    verify(contractLogTrigger).getBlockNumber();
  }

  /**
   * Test {@link ContractLogTriggerCapsule#processTrigger()}.
   *
   * <ul>
   *   <li>Given {@link ContractLogTrigger} {@link ContractLogTrigger#getBlockNumber()} return minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ContractLogTriggerCapsule#processTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractLogTriggerCapsule.processTrigger()"})
  public void testProcessTrigger_givenContractLogTriggerGetBlockNumberReturnMinusOne() {
    // Arrange
    ContractLogTrigger contractLogTrigger = mock(ContractLogTrigger.class);
    when(contractLogTrigger.getBlockNumber()).thenReturn(-1L);

    ContractLogTriggerCapsule contractLogTriggerCapsule =
        new ContractLogTriggerCapsule(mock(ContractLogTrigger.class));
    contractLogTriggerCapsule.setContractLogTrigger(contractLogTrigger);

    // Act
    contractLogTriggerCapsule.processTrigger();

    // Assert
    verify(contractLogTrigger).getBlockNumber();
  }
}
