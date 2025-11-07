package org.tron.core.actuator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UnfreezeBalanceV2ActuatorDiffblueTest {
  /**
   * Method under test: {@link UnfreezeBalanceV2Actuator#getUNFREEZE_MAX_TIMES()}
   */
  @Test
  public void testGetUNFREEZE_MAX_TIMES() {
    // Arrange, Act and Assert
    assertEquals(Integer.SIZE, UnfreezeBalanceV2Actuator.getUNFREEZE_MAX_TIMES());
  }
}
