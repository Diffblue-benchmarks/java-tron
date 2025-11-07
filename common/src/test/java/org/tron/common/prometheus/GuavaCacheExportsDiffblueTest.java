package org.tron.common.prometheus;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.prometheus.client.Collector;
import io.prometheus.client.Predicate;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class GuavaCacheExportsDiffblueTest {
  /**
   * Method under test: {@link GuavaCacheExports#collect(Predicate)}
   */
  @Test
  public void testCollect() {
    // Arrange
    GuavaCacheExports guavaCacheExports = new GuavaCacheExports();
    Predicate<String> nameFilter = mock(Predicate.class);
    when(nameFilter.test(Mockito.<String>any())).thenReturn(false);

    // Act
    List<Collector.MetricFamilySamples> actualCollectResult = guavaCacheExports.collect(nameFilter);

    // Assert
    verify(nameFilter, atLeast(1)).test(Mockito.<String>any());
    assertTrue(actualCollectResult.isEmpty());
  }
}
