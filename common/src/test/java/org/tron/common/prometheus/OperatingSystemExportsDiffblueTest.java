package org.tron.common.prometheus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class OperatingSystemExportsDiffblueTest {
  /**
   * Method under test:
   * {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  public void testAddOperatingSystemMetrics() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();
    ArrayList<Collector.MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    List<Collector.MetricFamilySamples> collectResult = operatingSystemExports.collect();
    assertEquals(8, collectResult.size());
    Collector.MetricFamilySamples getResult = collectResult.get(0);
    assertTrue(getResult instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult2 = collectResult.get(1);
    assertTrue(getResult2 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult3 = collectResult.get(2);
    assertTrue(getResult3 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult4 = collectResult.get(5);
    assertTrue(getResult4 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult5 = collectResult.get(6);
    assertTrue(getResult5 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult6 = collectResult.get(7);
    assertTrue(getResult6 instanceof GaugeMetricFamily);
    List<Collector.MetricFamilySamples.Sample> sampleList = ((GaugeMetricFamily) getResult).samples;
    assertEquals(1, sampleList.size());
    assertEquals(1, ((GaugeMetricFamily) getResult2).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult3).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult4).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult5).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult6).samples.size());
    assertTrue(sampleFamilies.isEmpty());
    assertTrue(sampleList.get(0).labelNames.isEmpty());
  }

  /**
   * Method under test:
   * {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  public void testAddOperatingSystemMetrics2() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();

    ArrayList<Collector.MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Collector.MetricFamilySamples metricFamilySamples = new Collector.MetricFamilySamples("system_available_cpus",
        Collector.Type.UNKNOWN, "system_available_cpus", new ArrayList<>());

    sampleFamilies.add(metricFamilySamples);
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    List<Collector.MetricFamilySamples> collectResult = operatingSystemExports.collect();
    assertEquals(8, collectResult.size());
    Collector.MetricFamilySamples getResult = collectResult.get(0);
    assertTrue(getResult instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult2 = collectResult.get(1);
    assertTrue(getResult2 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult3 = collectResult.get(2);
    assertTrue(getResult3 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult4 = collectResult.get(5);
    assertTrue(getResult4 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult5 = collectResult.get(6);
    assertTrue(getResult5 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult6 = collectResult.get(7);
    assertTrue(getResult6 instanceof GaugeMetricFamily);
    assertEquals(1, sampleFamilies.size());
    List<Collector.MetricFamilySamples.Sample> sampleList = ((GaugeMetricFamily) getResult).samples;
    assertEquals(1, sampleList.size());
    assertEquals(1, ((GaugeMetricFamily) getResult2).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult3).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult4).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult5).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult6).samples.size());
    assertTrue(sampleList.get(0).labelNames.isEmpty());
    assertSame(metricFamilySamples, sampleFamilies.get(0));
  }

  /**
   * Method under test:
   * {@link OperatingSystemExports#addOperatingSystemMetrics(List, Predicate)}
   */
  @Test
  public void testAddOperatingSystemMetrics3() {
    // Arrange
    OperatingSystemExports operatingSystemExports = new OperatingSystemExports();

    ArrayList<Collector.MetricFamilySamples> sampleFamilies = new ArrayList<>();
    Collector.MetricFamilySamples metricFamilySamples = new Collector.MetricFamilySamples("system_available_cpus",
        Collector.Type.UNKNOWN, "system_available_cpus", new ArrayList<>());

    sampleFamilies.add(metricFamilySamples);
    Collector.MetricFamilySamples metricFamilySamples2 = new Collector.MetricFamilySamples("system_available_cpus",
        Collector.Type.UNKNOWN, "system_available_cpus", new ArrayList<>());

    sampleFamilies.add(metricFamilySamples2);
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    operatingSystemExports.addOperatingSystemMetrics(sampleFamilies, nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    List<Collector.MetricFamilySamples> collectResult = operatingSystemExports.collect();
    assertEquals(8, collectResult.size());
    Collector.MetricFamilySamples getResult = collectResult.get(0);
    assertTrue(getResult instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult2 = collectResult.get(1);
    assertTrue(getResult2 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult3 = collectResult.get(2);
    assertTrue(getResult3 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult4 = collectResult.get(5);
    assertTrue(getResult4 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult5 = collectResult.get(6);
    assertTrue(getResult5 instanceof GaugeMetricFamily);
    Collector.MetricFamilySamples getResult6 = collectResult.get(7);
    assertTrue(getResult6 instanceof GaugeMetricFamily);
    List<Collector.MetricFamilySamples.Sample> sampleList = ((GaugeMetricFamily) getResult).samples;
    assertEquals(1, sampleList.size());
    assertEquals(1, ((GaugeMetricFamily) getResult2).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult3).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult4).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult5).samples.size());
    assertEquals(1, ((GaugeMetricFamily) getResult6).samples.size());
    assertEquals(2, sampleFamilies.size());
    assertTrue(sampleList.get(0).labelNames.isEmpty());
    assertSame(metricFamilySamples, sampleFamilies.get(0));
    assertSame(metricFamilySamples2, sampleFamilies.get(1));
  }
}
