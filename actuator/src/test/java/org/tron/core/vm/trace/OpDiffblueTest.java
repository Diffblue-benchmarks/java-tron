package org.tron.core.vm.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OpDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Op.<init>()",
    "OpActions Op.getActions()",
    "int Op.getCode()",
    "int Op.getDeep()",
    "BigInteger Op.getEnergy()",
    "int Op.getPc()",
    "void Op.setActions(OpActions)",
    "void Op.setCode(int)",
    "void Op.setDeep(int)",
    "void Op.setEnergy(BigInteger)",
    "void Op.setPc(int)"
  })
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

    // Assert
    assertEquals(1, actualCode);
    assertEquals(1, actualDeep);
    assertEquals(1, actualOp.getPc());
    assertSame(actions, actualActions);
    assertSame(BigInteger.ONE, actualEnergy);
  }
}
