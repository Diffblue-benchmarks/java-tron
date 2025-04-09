package org.tron.common.prometheus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.prometheus.client.Collector;
import io.prometheus.client.Collector.MetricFamilySamples;
import io.prometheus.client.Collector.Type;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class OperatingSystemExportsDiffblueTest {
  /**
   * Test {@link OperatingSystemExports#OperatingSystemExports()}.
   * <p>
   * Method under test: {@link OperatingSystemExports#OperatingSystemExports()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperatingSystemExports.<init>()"})
  public void testNewOperatingSystemExports() {
    // Arrange, Act and Assert
    List<MetricFamilySamples> collectResult = (new OperatingSystemExports()).collect();
    assertEquals(8, collectResult.size());
    assertTrue(collectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(collectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(collectResult.get(2) instanceof GaugeMetricFamily);
    assertTrue(collectResult.get(5) instanceof GaugeMetricFamily);
    assertTrue(collectResult.get(6) instanceof GaugeMetricFamily);
    assertTrue(collectResult.get(7) instanceof GaugeMetricFamily);
  }

  /**
   * Test {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperatingSystemExports.addOperatingSystemMetrics(List, Predicate)"})
  public void testAddOperatingSystemMetrics_givenFalse_whenArrayList_thenArrayListEmpty() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();
    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert that nothing has changed
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertTrue(sampleFamilies.isEmpty());
  }

  /**
   * Test {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperatingSystemExports.addOperatingSystemMetrics(List, Predicate)"})
  public void testAddOperatingSystemMetrics_givenTrue_thenArrayListSizeIsEight() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();
    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(true);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertEquals(8, sampleFamilies.size());
    assertTrue(sampleFamilies.get(0) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(1) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(2) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(3) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(4) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(5) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(6) instanceof GaugeMetricFamily);
    assertTrue(sampleFamilies.get(7) instanceof GaugeMetricFamily);
  }

  /**
   * Test {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperatingSystemExports.addOperatingSystemMetrics(List, Predicate)"})
  public void testAddOperatingSystemMetrics_thenArrayListSizeIsOne() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();

    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    MetricFamilySamples metricFamilySamples = new MetricFamilySamples("system_available_cpus", Type.UNKNOWN,
        "system_available_cpus", new ArrayList<>());

    sampleFamilies.add(metricFamilySamples);
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert that nothing has changed
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertEquals(1, sampleFamilies.size());
    assertSame(metricFamilySamples, sampleFamilies.get(0));
  }

  /**
   * Test {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperatingSystemExports.addOperatingSystemMetrics(List, Predicate)"})
  public void testAddOperatingSystemMetrics_thenArrayListSizeIsTwo() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();

    ArrayList<MetricFamilySamples> sampleFamilies = new ArrayList<>();
    MetricFamilySamples metricFamilySamples = new MetricFamilySamples("system_available_cpus", Type.UNKNOWN,
        "system_available_cpus", new ArrayList<>());

    sampleFamilies.add(metricFamilySamples);
    MetricFamilySamples metricFamilySamples2 = new MetricFamilySamples("system_available_cpus", Type.UNKNOWN,
        "system_available_cpus", new ArrayList<>());

    sampleFamilies.add(metricFamilySamples2);
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert that nothing has changed
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertEquals(2, sampleFamilies.size());
    assertSame(metricFamilySamples, sampleFamilies.get(0));
    assertSame(metricFamilySamples2, sampleFamilies.get(1));
  }

  /**
   * Test {@link OperatingSystemExports#collect()}.
   * <p>
   * Method under test: {@link OperatingSystemExports#collect()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OperatingSystemExports.collect()"})
  public void testCollect() {
    // Arrange and Act
    List<MetricFamilySamples> actualCollectResult = (new OperatingSystemExports()).collect();

    // Assert
    assertEquals(8, actualCollectResult.size());
    assertTrue(actualCollectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(2) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(3) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(4) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(5) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(6) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(7) instanceof GaugeMetricFamily);
  }

  /**
   * Test {@link OperatingSystemExports#collect(Predicate)} with {@code Predicate}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#collect(Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OperatingSystemExports.collect(Predicate)"})
  public void testCollectWithPredicate_givenFalse_whenPredicateTestReturnFalse_thenReturnEmpty() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    List<MetricFamilySamples> actualCollectResult = operatingSystemExports.collect(nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertTrue(actualCollectResult.isEmpty());
  }

  /**
   * Test {@link OperatingSystemExports#collect(Predicate)} with {@code Predicate}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#collect(Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OperatingSystemExports.collect(Predicate)"})
  public void testCollectWithPredicate_givenTrue_whenPredicateTestReturnTrue() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(true);

    // Act
    List<MetricFamilySamples> actualCollectResult = operatingSystemExports.collect(nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertEquals(8, actualCollectResult.size());
    assertTrue(actualCollectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(2) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(3) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(4) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(5) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(6) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(7) instanceof GaugeMetricFamily);
  }

  /**
   * Test {@link OperatingSystemExports#collect(Predicate)} with {@code Predicate}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatingSystemExports#collect(Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OperatingSystemExports.collect(Predicate)"})
  public void testCollectWithPredicate_whenNull_thenReturnSizeIsEight() {
    // Arrange and Act
    List<MetricFamilySamples> actualCollectResult = (new OperatingSystemExports()).collect(null);

    // Assert
    assertEquals(8, actualCollectResult.size());
    assertTrue(actualCollectResult.get(0) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(1) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(2) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(3) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(4) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(5) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(6) instanceof GaugeMetricFamily);
    assertTrue(actualCollectResult.get(7) instanceof GaugeMetricFamily);
  }
}
