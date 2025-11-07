package org.tron.core.services.ratelimiter.adapter;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.core.services.ratelimiter.RuntimeData;

public class GlobalPreemptibleAdapterDiffblueTest {
  /**
   * Method under test: {@link GlobalPreemptibleAdapter#acquire(RuntimeData)}
   */
  @Test
  public void testAcquire() {
    // Arrange
    GlobalPreemptibleAdapter globalPreemptibleAdapter = new GlobalPreemptibleAdapter("Param String");

    // Act and Assert
    assertTrue(globalPreemptibleAdapter.acquire(new RuntimeData("42")));
  }

  /**
   * Method under test:
   * {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}
   */
  @Test
  public void testNewGlobalPreemptibleAdapter() {
    // Arrange, Act and Assert
    assertTrue((new GlobalPreemptibleAdapter("Param String")).acquire(null));
    assertTrue((new GlobalPreemptibleAdapter(null)).acquire(null));
    assertTrue((new GlobalPreemptibleAdapter("UUU=UUU")).acquire(null));
  }
}
