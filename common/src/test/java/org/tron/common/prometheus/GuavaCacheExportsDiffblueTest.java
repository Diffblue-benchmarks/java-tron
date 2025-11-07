package org.tron.common.prometheus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.prometheus.client.Collector;
import io.prometheus.client.Collector.MetricFamilySamples;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class GuavaCacheExportsDiffblueTest {
  /**
   * Test {@link GuavaCacheExports#addHitRateMetrics(List, Predicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaCacheExports#addHitRateMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GuavaCacheExports.addHitRateMetrics(List, Predicate)"})
  public void testAddHitRateMetrics_givenFalse_whenPredicateTestReturnFalse_thenArrayListEmpty() {
    // Arrange
    GuavaCacheExports guavaCacheExports = new GuavaCacheExports();
    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    guavaCacheExports.addHitRateMetrics(sampleFamilies, nameFilter);

    // Assert that nothing has changed
    verify(nameFilter).test(eq("tron:guava_cache_hit_rate"));
    List<MetricFamilySamples> collectResult = guavaCacheExports.collect();
    assertEquals(3, collectResult.size());
    assertTrue(collectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.isEmpty());
  }

  /**
   * Test {@link GuavaCacheExports#addRequestMetrics(List, Predicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaCacheExports#addRequestMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GuavaCacheExports.addRequestMetrics(List, Predicate)"})
  public void testAddRequestMetrics_givenFalse_whenPredicateTestReturnFalse_thenArrayListEmpty() {
    // Arrange
    GuavaCacheExports guavaCacheExports = new GuavaCacheExports();
    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    guavaCacheExports.addRequestMetrics(sampleFamilies, nameFilter);

    // Assert that nothing has changed
    verify(nameFilter).test(eq("tron:guava_cache_request"));
    List<MetricFamilySamples> collectResult = guavaCacheExports.collect();
    assertEquals(3, collectResult.size());
    assertTrue(collectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.isEmpty());
  }

  /**
   * Test {@link GuavaCacheExports#addEvictionCountMetrics(List, Predicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaCacheExports#addEvictionCountMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GuavaCacheExports.addEvictionCountMetrics(List, Predicate)"})
  public void testAddEvictionCountMetrics_givenFalse_thenArrayListEmpty() {
    // Arrange
    GuavaCacheExports guavaCacheExports = new GuavaCacheExports();
    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    guavaCacheExports.addEvictionCountMetrics(sampleFamilies, nameFilter);

    // Assert that nothing has changed
    verify(nameFilter).test(eq("tron:guava_cache_eviction_count"));
    List<MetricFamilySamples> collectResult = guavaCacheExports.collect();
    assertEquals(3, collectResult.size());
    assertTrue(collectResult.get(2) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.isEmpty());
  }

  /**
   * Test {@link GuavaCacheExports#collect()}.
   * <p>
   * Method under test: {@link GuavaCacheExports#collect()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List GuavaCacheExports.collect()"})
  public void testCollect() {
    // Arrange and Act
    List<MetricFamilySamples> actualCollectResult = (new GuavaCacheExports()).collect();

    // Assert
    assertEquals(3, actualCollectResult.size());
    assertTrue(actualCollectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(2) instanceof GaugeMetricFamily);
  }

  /**
   * Test {@link GuavaCacheExports#collect(Predicate)} with {@code Predicate}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaCacheExports#collect(Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List GuavaCacheExports.collect(Predicate)"})
  public void testCollectWithPredicate_givenFalse_whenPredicateTestReturnFalse_thenReturnEmpty() {
    // Arrange
    GuavaCacheExports guavaCacheExports = new GuavaCacheExports();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    List<MetricFamilySamples> actualCollectResult = guavaCacheExports.collect(nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertTrue(actualCollectResult.isEmpty());
  }

  /**
   * Test {@link GuavaCacheExports#collect(Predicate)} with {@code Predicate}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaCacheExports#collect(Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List GuavaCacheExports.collect(Predicate)"})
  public void testCollectWithPredicate_givenTrue_thenReturnSizeIsThree() {
    // Arrange
    GuavaCacheExports guavaCacheExports = new GuavaCacheExports();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(true);

    // Act
    List<MetricFamilySamples> actualCollectResult = guavaCacheExports.collect(nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertEquals(3, actualCollectResult.size());
    assertTrue(actualCollectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(2) instanceof GaugeMetricFamily);
  }
}
