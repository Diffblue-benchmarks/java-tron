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

public class MetricsDiffblueTest {
  /**
   * Test {@link Metrics#histogramStartTimer(String, String[])}.
   *
   * <p>Method under test: {@link Metrics#histogramStartTimer(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Histogram.Timer Metrics.histogramStartTimer(String, String[])"})
  public void testHistogramStartTimer() {
    // Arrange, Act and Assert
    assertNull(Metrics.histogramStartTimer("Key", "Labels"));
  }

  /**
   * Test {@link Metrics#histogramObserve(Timer)} with {@code startTimer}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link Histogram.Timer} {@link Histogram.Timer#observeDuration()} return ten.
   * </ul>
   *
   * <p>Method under test: {@link Metrics#histogramObserve(Histogram.Timer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Metrics.histogramObserve(Histogram.Timer)"})
  public void testHistogramObserveWithStartTimer_givenTen_whenTimerObserveDurationReturnTen() {
    // Arrange
    Timer startTimer = mock(Timer.class);
    when(startTimer.observeDuration()).thenReturn(10.0d);

    // Act
    Metrics.histogramObserve(startTimer);

    // Assert
    verify(startTimer).observeDuration();
  }

  /**
   * Test {@link Metrics#histogramObserve(Timer)} with {@code startTimer}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Metrics#histogramObserve(Histogram.Timer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Metrics.histogramObserve(Histogram.Timer)"})
  public void testHistogramObserveWithStartTimer_thenThrowIllegalStateException() {
    // Arrange
    Timer startTimer = mock(Timer.class);
    when(startTimer.observeDuration()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> Metrics.histogramObserve(startTimer));
    verify(startTimer).observeDuration();
  }

  /**
   * Test {@link Metrics#histogramObserve(Timer)} with {@code startTimer}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Metrics#histogramObserve(Histogram.Timer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Metrics.histogramObserve(Histogram.Timer)"})
  public void testHistogramObserveWithStartTimer_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    Metrics.histogramObserve(null);
  }
}
