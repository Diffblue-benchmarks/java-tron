package org.tron.common.prometheus;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.prometheus.client.Histogram;
import org.junit.Test;

public class MetricsHistogramDiffblueTest {
  /**
   * Method under test: {@link MetricsHistogram#startTimer(String, String[])}
   */
  @Test
  public void testStartTimer() {
    // Arrange, Act and Assert
    assertNull(MetricsHistogram.startTimer("Key", "Labels"));
  }

  /**
   * Method under test: {@link MetricsHistogram#observeDuration(Histogram.Timer)}
   */
  @Test
  public void testObserveDuration() {
    // Arrange
    Histogram.Timer startTimer = mock(Histogram.Timer.class);
    when(startTimer.observeDuration()).thenReturn(10.0d);

    // Act
    MetricsHistogram.observeDuration(startTimer);

    // Assert that nothing has changed
    verify(startTimer).observeDuration();
  }

  /**
   * Method under test: {@link MetricsHistogram#observeDuration(Histogram.Timer)}
   */
  @Test
  public void testObserveDuration2() {
    // Arrange
    Histogram.Timer startTimer = mock(Histogram.Timer.class);
    when(startTimer.observeDuration()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> MetricsHistogram.observeDuration(startTimer));
    verify(startTimer).observeDuration();
  }
}
