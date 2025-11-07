package org.tron.core.store;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class StoreFactoryDiffblueTest {
  /**
   * Method under test: {@link StoreFactory#getInstance()}
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(StoreFactory.getInstance().getInstance());
  }
}
