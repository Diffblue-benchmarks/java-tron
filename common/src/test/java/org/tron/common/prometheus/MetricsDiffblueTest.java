package org.tron.common.prometheus;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.prometheus.client.Histogram;
import org.junit.Test;

public class MetricsDiffblueTest {
  /**
   * Method under test: {@link Metrics#enabled()}
   */
  @Test
  public void testEnabled() {
    // Arrange, Act and Assert
    assertTrue(Metrics.enabled());
  }

  /**
   * Method under test: {@link Metrics#histogramStartTimer(String, String[])}
   */
  @Test
  public void testHistogramStartTimer() {
    // Arrange, Act and Assert
    assertNull(Metrics.histogramStartTimer("Key", "Labels"));
  }

  /**
   * Method under test: {@link Metrics#histogramObserve(Histogram.Timer)}
   */
  @Test
  public void testHistogramObserve() {
    // Arrange
    Histogram.Timer startTimer = mock(Histogram.Timer.class);
    when(startTimer.observeDuration()).thenReturn(10.0d);

    // Act
    Metrics.histogramObserve(startTimer);

    // Assert that nothing has changed
    verify(startTimer).observeDuration();
  }

  /**
   * Method under test: {@link Metrics#histogramObserve(Histogram.Timer)}
   */
  @Test
  public void testHistogramObserve2() {
    // Arrange
    Histogram.Timer startTimer = mock(Histogram.Timer.class);
    when(startTimer.observeDuration()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> Metrics.histogramObserve(startTimer));
    verify(startTimer).observeDuration();
  }
}
