package org.tron.core.services.ratelimiter.adapter;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.RuntimeData;

public class IPQPSRateLimiterAdapterDiffblueTest {
  /**
   * Test {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}.
   *
   * <ul>
   *   <li>Then return acquire {@link RuntimeData#RuntimeData(Object)} with o is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IPQPSRateLimiterAdapter.<init>(String)"})
  public void testNewIPQPSRateLimiterAdapter_thenReturnAcquireRuntimeDataWithOIs42() {
    // Arrange and Act
    IPQPSRateLimiterAdapter actualIpqpsRateLimiterAdapter =
        new IPQPSRateLimiterAdapter("Param String");
    boolean actualAcquireResult = actualIpqpsRateLimiterAdapter.acquire(new RuntimeData("42"));

    // Assert
    assertTrue(actualAcquireResult);
  }

  /**
   * Test {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IPQPSRateLimiterAdapter.<init>(String)"})
  public void testNewIPQPSRateLimiterAdapter_whenEmptyString() {
    // Arrange and Act
    IPQPSRateLimiterAdapter actualIpqpsRateLimiterAdapter = new IPQPSRateLimiterAdapter("");
    boolean actualAcquireResult = actualIpqpsRateLimiterAdapter.acquire(new RuntimeData("42"));

    // Assert
    assertTrue(actualAcquireResult);
  }

  /**
   * Test {@link IPQPSRateLimiterAdapter#acquire(RuntimeData)}.
   *
   * <ul>
   *   <li>Given {@link IPQPSRateLimiterAdapter#IPQPSRateLimiterAdapter(String)} with {@code Param
   *       String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IPQPSRateLimiterAdapter#acquire(RuntimeData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IPQPSRateLimiterAdapter.acquire(RuntimeData)"})
  public void testAcquire_givenIPQPSRateLimiterAdapterWithParamString_thenReturnTrue() {
    // Arrange
    IPQPSRateLimiterAdapter ipqpsRateLimiterAdapter = new IPQPSRateLimiterAdapter("Param String");

    // Act
    boolean actualAcquireResult = ipqpsRateLimiterAdapter.acquire(new RuntimeData("42"));

    // Assert
    assertTrue(actualAcquireResult);
  }
}
