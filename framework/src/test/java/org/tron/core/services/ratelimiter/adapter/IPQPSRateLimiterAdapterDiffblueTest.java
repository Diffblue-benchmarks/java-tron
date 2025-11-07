package org.tron.core.services.ratelimiter.adapter;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.RuntimeData;

public class IPQPSRateLimiterAdapterDiffblueTest {
  /**
   * Test {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}.
   * <ul>
   *   <li>Then return acquire {@link RuntimeData#RuntimeData(Object)} with o is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IPQPSRateLimiterAdapter.<init>(String)"})
  public void testNewIPQPSRateLimiterAdapter_thenReturnAcquireRuntimeDataWithOIs42() {
    // Arrange and Act
    IPQPSRateLimiterAdapter actualIpqpsRateLimiterAdapter = new IPQPSRateLimiterAdapter("Param String");

    // Assert
    assertTrue(actualIpqpsRateLimiterAdapter.acquire(new RuntimeData("42")));
  }

  /**
   * Test {@link IPQPSRateLimiterAdapter#acquire(RuntimeData)}.
   * <ul>
   *   <li>When {@link RuntimeData#RuntimeData(Object)} with o is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQPSRateLimiterAdapter#acquire(RuntimeData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IPQPSRateLimiterAdapter.acquire(RuntimeData)"})
  public void testAcquire_whenRuntimeDataWithOIs42_thenReturnTrue() {
    // Arrange
    IPQPSRateLimiterAdapter ipqpsRateLimiterAdapter = new IPQPSRateLimiterAdapter("Param String");

    // Act and Assert
    assertTrue(ipqpsRateLimiterAdapter.acquire(new RuntimeData("42")));
  }
}
