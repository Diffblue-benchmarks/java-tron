package org.tron.core.services.ratelimiter.adapter;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.core.services.ratelimiter.RuntimeData;

public class IPQPSRateLimiterAdapterDiffblueTest {
  /**
   * Method under test: {@link IPQPSRateLimiterAdapter#acquire(RuntimeData)}
   */
  @Test
  public void testAcquire() {
    // Arrange
    IPQPSRateLimiterAdapter ipqpsRateLimiterAdapter = new IPQPSRateLimiterAdapter("Param String");

    // Act and Assert
    assertTrue(ipqpsRateLimiterAdapter.acquire(new RuntimeData("42")));
  }

  /**
   * Method under test:
   * {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}
   */
  @Test
  public void testNewIPQPSRateLimiterAdapter() {
    // Arrange and Act
    IPQPSRateLimiterAdapter actualIpqpsRateLimiterAdapter = new IPQPSRateLimiterAdapter("Param String");

    // Assert
    assertTrue(actualIpqpsRateLimiterAdapter.acquire(new RuntimeData("42")));
  }
}
