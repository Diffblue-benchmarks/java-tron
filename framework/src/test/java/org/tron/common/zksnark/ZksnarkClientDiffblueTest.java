package org.tron.common.zksnark;

import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ZksnarkClientDiffblueTest {
  /**
   * Method under test: {@link ZksnarkClient#getInstance()}
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ZksnarkClient actualInstance = ZksnarkClient.getInstance().getInstance();

    // Assert
    assertSame(actualInstance.instance, actualInstance);
  }
}
