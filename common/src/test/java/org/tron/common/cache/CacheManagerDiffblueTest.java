package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheManagerDiffblueTest {
  /**
   * Test {@link CacheManager#allocate(CacheType, String, CacheLoader)} with {@code name}, {@code strategy}, {@code loader}.
   * <ul>
   *   <li>Then return stats evictionCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheManager#allocate(CacheType, String, CacheLoader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronCache CacheManager.allocate(CacheType, String, CacheLoader)"})
  public void testAllocateWithNameStrategyLoader_thenReturnStatsEvictionCountIsZero() {
    // Arrange and Act
    TronCache<Object, Object> actualAllocateResult = CacheManager.<Object, Object>allocate(CacheType.witnessStandby, "",
        mock(CacheLoader.class));

    // Assert
    CacheStats statsResult = actualAllocateResult.stats();
    assertEquals(0L, statsResult.evictionCount());
    assertEquals(0L, statsResult.hitCount());
    assertEquals(0L, statsResult.loadExceptionCount());
    assertEquals(0L, statsResult.loadSuccessCount());
    assertEquals(0L, statsResult.missCount());
    assertEquals(0L, statsResult.totalLoadTime());
    assertEquals(CacheType.witnessStandby, actualAllocateResult.getName());
  }

  /**
   * Test {@link CacheManager#allocate(CacheType, String)} with {@code name}, {@code strategy}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return stats evictionCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheManager#allocate(CacheType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronCache CacheManager.allocate(CacheType, String)"})
  public void testAllocateWithNameStrategy_whenEmptyString_thenReturnStatsEvictionCountIsZero() {
    // Arrange and Act
    TronCache<Object, Object> actualAllocateResult = CacheManager.allocate(CacheType.witnessStandby, "");

    // Assert
    CacheStats statsResult = actualAllocateResult.stats();
    assertEquals(0L, statsResult.evictionCount());
    assertEquals(0L, statsResult.hitCount());
    assertEquals(0L, statsResult.loadExceptionCount());
    assertEquals(0L, statsResult.loadSuccessCount());
    assertEquals(0L, statsResult.missCount());
    assertEquals(0L, statsResult.totalLoadTime());
    assertEquals(CacheType.witnessStandby, actualAllocateResult.getName());
  }

  /**
   * Test {@link CacheManager#release(TronCache)}.
   * <ul>
   *   <li>When {@link TronCache} {@link TronCache#invalidateAll()} does nothing.</li>
   *   <li>Then calls {@link TronCache#invalidateAll()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheManager#release(TronCache)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CacheManager.release(TronCache)"})
  public void testRelease_whenTronCacheInvalidateAllDoesNothing_thenCallsInvalidateAll() {
    // Arrange
    TronCache<?, ?> cache = mock(TronCache.class);
    doNothing().when(cache).invalidateAll();

    // Act
    CacheManager.release(cache);

    // Assert
    verify(cache).invalidateAll();
  }
}
