package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

public class TronCacheDiffblueTest {
  /**
   * Method under test: {@link TronCache#getIfPresent(Object)}
   */
  @Test
  public void testGetIfPresent() {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");

    // Act and Assert
    assertNull(allocateResult.getIfPresent("42"));
  }

  /**
   * Method under test: {@link TronCache#getIfPresent(Object)}
   */
  @Test
  public void testGetIfPresent2() {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");
    allocateResult.put("42", "42");

    // Act and Assert
    assertEquals("42", allocateResult.getIfPresent("42"));
  }

  /**
   * Method under test: {@link TronCache#get(Object, Callable)}
   */
  @Test
  public void testGet() throws Exception {
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
   * Method under test: {@link TronCache#get(Object, Callable)}
   */
  @Test
  public void testGet2() throws ExecutionException {
    // Arrange
    TronCache<Object, Object> allocateResult = CacheManager.allocate(CacheType.witnessStandby, "");
    allocateResult.put("42", "42");

    // Act and Assert
    assertEquals("42", allocateResult.get("42", mock(Callable.class)));
  }

  /**
   * Method under test: {@link TronCache#stats()}
   */
  @Test
  public void testStats() {
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

  /**
   * Method under test: {@link TronCache#TronCache(CacheType, String)}
   */
  @Test
  public void testNewTronCache() {
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
   * Method under test:
   * {@link TronCache#TronCache(CacheType, String, CacheLoader)}
   */
  @Test
  public void testNewTronCache2() {
    // Arrange and Act
    TronCache<Object, Object> actualTronCache = new TronCache<>(CacheType.witnessStandby, "", mock(CacheLoader.class));

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
}
