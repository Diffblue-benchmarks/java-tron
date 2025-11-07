package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;

public class ResourceProcessorDiffblueTest {
  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}, {@code windowSize}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNowWindowSize_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 5L, 5L, 3L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}, {@code windowSize}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNowWindowSize_whenOne_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(6L, (new BandwidthProcessor(new ChainBaseManager())).increase(1L, 5L, 5L, 5L, 3L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}, {@code windowSize}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNowWindowSize_whenTwo_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 2L, 5L, 3L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}, {@code windowSize}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNowWindowSize_whenTwo_thenReturnSeven() {
    // Arrange, Act and Assert
    assertEquals(7L, (new BandwidthProcessor(new ChainBaseManager())).increase(2L, 5L, 5L, 5L, 3L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}, {@code windowSize}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNowWindowSize_whenZero_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(0L, 5L, 5L, 5L, 3L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNow_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 5L, 5L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}.
   * <ul>
   *   <li>When {@code 17600}.</li>
   *   <li>Then return {@code 17605}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNow_when17600_thenReturn17605() {
    // Arrange, Act and Assert
    assertEquals(17605L, (new BandwidthProcessor(new ChainBaseManager())).increase(17600L, 5L, 5L, 5L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNow_whenMax_value_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 17600L, Long.MAX_VALUE));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNow_whenOne_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(6L, (new BandwidthProcessor(new ChainBaseManager())).increase(1L, 5L, 5L, 5L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNow_whenOne_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10L, (new BandwidthProcessor(new ChainBaseManager())).increase(5L, 5L, 1L, 5L));
  }

  /**
   * Test {@link ResourceProcessor#increase(long, long, long, long)} with {@code lastUsage}, {@code usage}, {@code lastTime}, {@code now}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceProcessor#increase(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceProcessor.increase(long, long, long, long)"})
  public void testIncreaseWithLastUsageUsageLastTimeNow_whenZero_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, (new BandwidthProcessor(new ChainBaseManager())).increase(0L, 5L, 5L, 5L));
  }
}
