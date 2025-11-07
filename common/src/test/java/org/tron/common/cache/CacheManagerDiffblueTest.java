package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import org.junit.Test;

public class CacheManagerDiffblueTest {
  /**
   * Method under test: {@link CacheManager#allocate(CacheType, String)}
   */
  @Test
  public void testAllocate() {
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
   * Method under test:
   * {@link CacheManager#allocate(CacheType, String, CacheLoader)}
   */
  @Test
  public void testAllocate2() {
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
   * Method under test: {@link CacheManager#release(TronCache)}
   */
  @Test
  public void testRelease() {
    // Arrange
    TronCache<?, ?> cache = mock(TronCache.class);
    doNothing().when(cache).invalidateAll();

    // Act
    CacheManager.release(cache);

    // Assert that nothing has changed
    verify(cache).invalidateAll();
  }
}
