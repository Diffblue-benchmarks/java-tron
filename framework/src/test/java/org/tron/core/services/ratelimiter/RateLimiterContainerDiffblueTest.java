package org.tron.core.services.ratelimiter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.services.ratelimiter.adapter.IRateLimiter;

public class RateLimiterContainerDiffblueTest {
  /**
   * Test {@link RateLimiterContainer#add(String, String, IRateLimiter)}.
   *
   * <p>Method under test: {@link RateLimiterContainer#add(String, String, IRateLimiter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterContainer.add(String, String, IRateLimiter)"})
  public void testAdd() {
    // Arrange
    RateLimiterContainer rateLimiterContainer = new RateLimiterContainer();
    IRateLimiter rateLimiter = mock(IRateLimiter.class);

    // Act
    rateLimiterContainer.add("Prefix", "Method", rateLimiter);

    // Assert
    Map<String, IRateLimiter> map = rateLimiterContainer.getMap();
    assertEquals(1, map.size());
    assertSame(rateLimiter, map.get("PrefixMethod"));
  }

  /**
   * Test {@link RateLimiterContainer#get(String, String)}.
   *
   * <ul>
   *   <li>Given {@link IRateLimiter} {@link IRateLimiter#acquire(RuntimeData)} return {@code true}.
   *   <li>Then return acquire {@link RuntimeData#RuntimeData(Object)} with o is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterContainer#get(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IRateLimiter RateLimiterContainer.get(String, String)"})
  public void testGet_givenIRateLimiterAcquireReturnTrue_thenReturnAcquireRuntimeDataWithOIs42() {
    // Arrange
    IRateLimiter rateLimiter = mock(IRateLimiter.class);
    when(rateLimiter.acquire(Mockito.<RuntimeData>any())).thenReturn(true);

    RateLimiterContainer rateLimiterContainer = new RateLimiterContainer();
    rateLimiterContainer.add("Prefix", "Method", rateLimiter);
    rateLimiterContainer.add("42", "42", mock(IRateLimiter.class));

    // Act
    IRateLimiter actualGetResult = rateLimiterContainer.get("Prefix", "Method");
    RuntimeData runtimeData = new RuntimeData("42");
    boolean actualAcquireResult = actualGetResult.acquire(runtimeData);

    // Assert
    verify(rateLimiter).acquire(isA(RuntimeData.class));
    assertEquals("", runtimeData.getRemoteAddr());
    Map<String, IRateLimiter> map = rateLimiterContainer.getMap();
    assertEquals(2, map.size());
    assertTrue(map.containsKey("4242"));
    assertTrue(map.containsKey("PrefixMethod"));
    assertTrue(actualAcquireResult);
  }

  /**
   * Test {@link RateLimiterContainer#get(String, String)}.
   *
   * <ul>
   *   <li>Then return not acquire {@link RuntimeData#RuntimeData(Object)} with o is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterContainer#get(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IRateLimiter RateLimiterContainer.get(String, String)"})
  public void testGet_thenReturnNotAcquireRuntimeDataWithOIs42() {
    // Arrange
    IRateLimiter rateLimiter = mock(IRateLimiter.class);
    when(rateLimiter.acquire(Mockito.<RuntimeData>any())).thenReturn(false);

    RateLimiterContainer rateLimiterContainer = new RateLimiterContainer();
    rateLimiterContainer.add("Prefix", "Method", rateLimiter);
    rateLimiterContainer.add("42", "42", mock(IRateLimiter.class));

    // Act
    IRateLimiter actualGetResult = rateLimiterContainer.get("Prefix", "Method");
    RuntimeData runtimeData = new RuntimeData("42");
    boolean actualAcquireResult = actualGetResult.acquire(runtimeData);

    // Assert
    verify(rateLimiter).acquire(isA(RuntimeData.class));
    assertEquals("", runtimeData.getRemoteAddr());
    Map<String, IRateLimiter> map = rateLimiterContainer.getMap();
    assertEquals(2, map.size());
    assertFalse(actualAcquireResult);
    assertTrue(map.containsKey("4242"));
    assertTrue(map.containsKey("PrefixMethod"));
  }

  /**
   * Test {@link RateLimiterContainer#get(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterContainer#get(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IRateLimiter RateLimiterContainer.get(String, String)"})
  public void testGet_thenReturnNull() {
    // Arrange
    RateLimiterContainer rateLimiterContainer = new RateLimiterContainer();

    // Act and Assert
    assertNull(rateLimiterContainer.get("Prefix", "Method"));
    assertTrue(rateLimiterContainer.getMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterContainer#getMap()}.
   *
   * <p>Method under test: {@link RateLimiterContainer#getMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map RateLimiterContainer.getMap()"})
  public void testGetMap() {
    // Arrange, Act and Assert
    assertTrue(new RateLimiterContainer().getMap().isEmpty());
  }
}
