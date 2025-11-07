package org.tron.core.vm.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigInteger;
import org.junit.Test;

public class OpDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Op}
   *   <li>{@link Op#setActions(OpActions)}
   *   <li>{@link Op#setCode(int)}
   *   <li>{@link Op#setDeep(int)}
   *   <li>{@link Op#setEnergy(BigInteger)}
   *   <li>{@link Op#setPc(int)}
   *   <li>{@link Op#getActions()}
   *   <li>{@link Op#getCode()}
   *   <li>{@link Op#getDeep()}
   *   <li>{@link Op#getEnergy()}
   *   <li>{@link Op#getPc()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Op actualOp = new Op();
    OpActions actions = new OpActions();
    actualOp.setActions(actions);
    actualOp.setCode(1);
    actualOp.setDeep(1);
    actualOp.setEnergy(BigInteger.valueOf(1L));
    actualOp.setPc(1);
    OpActions actualActions = actualOp.getActions();
    int actualCode = actualOp.getCode();
    int actualDeep = actualOp.getDeep();
    BigInteger actualEnergy = actualOp.getEnergy();

    // Assert that nothing has changed
    assertEquals(1, actualCode);
    assertEquals(1, actualDeep);
    assertEquals(1, actualOp.getPc());
    assertSame(actions, actualActions);
    assertSame(actualEnergy.ONE, actualEnergy);
  }
}
