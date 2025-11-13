package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheStrategiesDiffblueTest {
  /**
   * Test {@link CacheStrategies#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link CacheStrategies#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CacheStrategies.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=100,maximumSize=100,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.recentBlock));
  }

  /**
   * Test {@link CacheStrategies#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link CacheStrategies#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CacheStrategies.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy2() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=500,maximumSize=500,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.code));
  }

  /**
   * Test {@link CacheStrategies#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link CacheStrategies#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CacheStrategies.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy3() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=10000,maximumSize=10000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.delegation));
  }

  /**
   * Test {@link CacheStrategies#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link CacheStrategies#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CacheStrategies.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy4() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=20000,maximumSize=20000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        CacheStrategies.getCacheStrategy(CacheType.storageRow));
  }

  /**
   * Test {@link CacheStrategies#getCacheStrategy(CacheType)}.
   *
   * <ul>
   *   <li>When {@code witnessStandby}.
   *   <li>Then return {@link CacheStrategies#CACHE_STRATEGY_DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link CacheStrategies#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CacheStrategies.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy_whenWitnessStandby_thenReturnCache_strategy_default() {
    // Arrange, Act and Assert
    assertEquals(
        CacheStrategies.CACHE_STRATEGY_DEFAULT,
        CacheStrategies.getCacheStrategy(CacheType.witnessStandby));
  }
}
