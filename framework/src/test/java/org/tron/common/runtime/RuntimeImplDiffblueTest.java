package org.tron.common.runtime;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RuntimeImplDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuntimeImpl}
   *   <li>{@link RuntimeImpl#getActuator2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new RuntimeImpl()).getActuator2());
  }
}
