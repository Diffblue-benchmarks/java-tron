package org.tron.common.prometheus;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.prometheus.client.Histogram;
import io.prometheus.client.Histogram.Timer;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MetricsHistogramDiffblueTest {
  /**
   * Test {@link MetricsHistogram#startTimer(String, String[])}.
   *
   * <p>Method under test: {@link MetricsHistogram#startTimer(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Histogram.Timer MetricsHistogram.startTimer(String, String[])"})
  public void testStartTimer() {
    // Arrange, Act and Assert
    assertNull(MetricsHistogram.startTimer("Key", "Labels"));
  }

  /**
   * Test {@link MetricsHistogram#observeDuration(Timer)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHistogram#observeDuration(Histogram.Timer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsHistogram.observeDuration(Histogram.Timer)"})
  public void testObserveDuration_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    Timer startTimer = mock(Timer.class);
    when(startTimer.observeDuration()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> MetricsHistogram.observeDuration(startTimer));
    verify(startTimer).observeDuration();
  }

  /**
   * Test {@link MetricsHistogram#observeDuration(Timer)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link Histogram.Timer} {@link Histogram.Timer#observeDuration()} return ten.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHistogram#observeDuration(Histogram.Timer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
}
