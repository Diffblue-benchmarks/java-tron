package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CacheStrategiesDiffblueTest {
  /**
   * Method under test: {@link CacheStrategies#getCacheStrategy(CacheType)}
   */
  @Test
  public void testGetCacheStrategy() {
    // Arrange, Act and Assert
    assertEquals(CacheStrategies.CACHE_STRATEGY_DEFAULT, CacheStrategies.getCacheStrategy(CacheType.witnessStandby));
    assertEquals("initialCapacity=100,maximumSize=100,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.recentBlock));
    assertEquals("initialCapacity=500,maximumSize=500,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.code));
    assertEquals("initialCapacity=10000,maximumSize=10000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.delegation));
    assertEquals("initialCapacity=20000,maximumSize=20000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.storageRow));
  }
}
