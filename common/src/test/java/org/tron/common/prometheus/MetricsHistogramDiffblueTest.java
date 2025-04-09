package org.tron.common.prometheus;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.prometheus.client.Histogram;
import io.prometheus.client.Histogram.Timer;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MetricsHistogramDiffblueTest {
  /**
   * Test {@link MetricsHistogram#startTimer(String, String[])}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricsHistogram#startTimer(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Histogram.Timer MetricsHistogram.startTimer(String, String[])"})
  public void testStartTimer_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MetricsHistogram.startTimer("Key", "Labels"));
  }

  /**
   * Test {@link MetricsHistogram#observeDuration(Timer)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link Histogram.Timer} {@link Histogram.Timer#observeDuration()} return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricsHistogram#observeDuration(Histogram.Timer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsHistogram.observeDuration(Histogram.Timer)"})
  public void testObserveDuration_givenTen_whenTimerObserveDurationReturnTen() {
    // Arrange
    Timer startTimer = mock(Timer.class);
    when(startTimer.observeDuration()).thenReturn(10.0d);

    // Act
    MetricsHistogram.observeDuration(startTimer);

    // Assert
    verify(startTimer).observeDuration();
  }

  /**
   * Test {@link MetricsHistogram#observeDuration(Timer)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricsHistogram#observeDuration(Histogram.Timer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsHistogram.observeDuration(Histogram.Timer)"})
  public void testObserveDuration_thenThrowIllegalStateException() {
    // Arrange
    Timer startTimer = mock(Timer.class);
    when(startTimer.observeDuration()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> MetricsHistogram.observeDuration(startTimer));
    verify(startTimer).observeDuration();
  }
}
