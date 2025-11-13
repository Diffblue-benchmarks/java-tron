package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TronCacheDiffblueTest {
  /**
   * Test {@link TronCache#TronCache(CacheType, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return stats evictionCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#TronCache(CacheType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TronCache.<init>(CacheType, String)"})
  public void testNewTronCache_whenEmptyString_thenReturnStatsEvictionCountIsZero() {
    // Arrange and Act
    TronCache<Object, Object> actualTronCache = new TronCache<>(CacheType.witnessStandby, "");

    // Assert
    CacheStats statsResult = actualTronCache.stats();
    assertEquals(0L, statsResult.evictionCount());
    assertEquals(0L, statsResult.hitCount());
    assertEquals(0L, statsResult.loadExceptionCount());
    assertEquals(0L, statsResult.loadSuccessCount());
    assertEquals(0L, statsResult.missCount());
    assertEquals(0L, statsResult.totalLoadTime());
    assertEquals(CacheType.witnessStandby, actualTronCache.getName());
  }

  /**
   * Test {@link TronCache#TronCache(CacheType, String, CacheLoader)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return stats evictionCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#TronCache(CacheType, String, CacheLoader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TronCache.<init>(CacheType, String, CacheLoader)"})
  public void testNewTronCache_whenEmptyString_thenReturnStatsEvictionCountIsZero2() {
    // Arrange and Act
    TronCache<Object, Object> actualTronCache =
        new TronCache<>(CacheType.witnessStandby, "", mock(CacheLoader.class));

    // Assert
    CacheStats statsResult = actualTronCache.stats();
    assertEquals(0L, statsResult.evictionCount());
    assertEquals(0L, statsResult.hitCount());
    assertEquals(0L, statsResult.loadExceptionCount());
    assertEquals(0L, statsResult.loadSuccessCount());
    assertEquals(0L, statsResult.missCount());
    assertEquals(0L, statsResult.totalLoadTime());
    assertEquals(CacheType.witnessStandby, actualTronCache.getName());
  }

  /**
   * Test {@link TronCache#getIfPresent(Object)}.
   *
   * <ul>
   *   <li>Given allocate {@code witnessStandby} and empty string {@code 42} is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#getIfPresent(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TronCache.getIfPresent(Object)"})
  public void testGetIfPresent_givenAllocateWitnessStandbyAndEmptyString42Is42_thenReturn42() {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");
    allocateResult.put("42", "42");

    // Act and Assert
    assertEquals("42", allocateResult.getIfPresent("42"));
  }

  /**
   * Test {@link TronCache#getIfPresent(Object)}.
   *
   * <ul>
   *   <li>Given allocate {@code witnessStandby} and empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#getIfPresent(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TronCache.getIfPresent(Object)"})
  public void testGetIfPresent_givenAllocateWitnessStandbyAndEmptyString_thenReturnNull() {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");

    // Act and Assert
    assertNull(allocateResult.getIfPresent("42"));
  }

  /**
   * Test {@link TronCache#get(Object, Callable)}.
   *
   * <ul>
   *   <li>Given allocate {@code witnessStandby} and empty string {@code 42} is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#get(Object, Callable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TronCache.get(Object, Callable)"})
  public void testGet_givenAllocateWitnessStandbyAndEmptyString42Is42_thenReturn42()
      throws ExecutionException {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");
    allocateResult.put("42", "42");

    // Act and Assert
    assertEquals("42", allocateResult.get("42", mock(Callable.class)));
  }

  /**
   * Test {@link TronCache#get(Object, Callable)}.
   *
   * <ul>
   *   <li>Given {@code Call}.
   *   <li>When {@link Callable} {@link Callable#call()} return {@code Call}.
   *   <li>Then return {@code Call}.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#get(Object, Callable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TronCache.get(Object, Callable)"})
  public void testGet_givenCall_whenCallableCallReturnCall_thenReturnCall() throws Exception {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");

    Callable<Object> loader = mock(Callable.class);
    when(loader.call()).thenReturn("Call");

    // Act
    Object actualGetResult = allocateResult.get("42", loader);

    // Assert
    verify(loader).call();
    assertEquals("Call", actualGetResult);
  }

  /**
   * Test {@link TronCache#stats()}.
   *
   * <ul>
   *   <li>Then return evictionCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link TronCache#stats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheStats TronCache.stats()"})
  public void testStats_thenReturnEvictionCountIsZero() {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");

    // Act
    CacheStats actualStatsResult = allocateResult.stats();

    // Assert
    assertEquals(0L, actualStatsResult.evictionCount());
    assertEquals(0L, actualStatsResult.hitCount());
    assertEquals(0L, actualStatsResult.loadExceptionCount());
    assertEquals(0L, actualStatsResult.loadSuccessCount());
    assertEquals(0L, actualStatsResult.missCount());
    assertEquals(0L, actualStatsResult.totalLoadTime());
  }
}
