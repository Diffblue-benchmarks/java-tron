package org.tron.core.actuator;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnfreezeBalanceV2ActuatorDiffblueTest {
  /**
   * Test {@link UnfreezeBalanceV2Actuator#getUNFREEZE_MAX_TIMES()}.
   *
   * <p>Method under test: {@link UnfreezeBalanceV2Actuator#getUNFREEZE_MAX_TIMES()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnfreezeBalanceV2Actuator.getUNFREEZE_MAX_TIMES()"})
  public void testGetUNFREEZE_MAX_TIMES() {
    // Arrange, Act and Assert
    assertEquals(Integer.SIZE, UnfreezeBalanceV2Actuator.getUNFREEZE_MAX_TIMES());
  }
}
