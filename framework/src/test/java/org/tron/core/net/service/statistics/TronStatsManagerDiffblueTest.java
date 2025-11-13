package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

@RunWith(MockitoJUnitRunner.class)
public class TronStatsManagerDiffblueTest {
  @Mock private ScheduledExecutorService scheduledExecutorService;

  @InjectMocks private TronStatsManager tronStatsManager;

  /**
   * Test {@link TronStatsManager#getNodeStatistics(InetAddress)}.
   *
   * <ul>
   *   <li>When {@link InetAddress}.
   *   <li>Then return LocalDisconnectReason is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TronStatsManager#getNodeStatistics(InetAddress)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeStatistics TronStatsManager.getNodeStatistics(InetAddress)"})
  public void testGetNodeStatistics_whenInetAddress_thenReturnLocalDisconnectReasonIsNull() {
    // Arrange and Act
    NodeStatistics actualNodeStatistics =
        TronStatsManager.getNodeStatistics(mock(InetAddress.class));

    // Assert
    assertNull(actualNodeStatistics.getLocalDisconnectReason());
    assertNull(actualNodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualNodeStatistics.getDisconnectTimes());
    assertEquals(ReasonCode.UNKNOWN, actualNodeStatistics.getDisconnectReason());
  }

  /**
   * Test {@link TronStatsManager#init()}.
   *
   * <p>Method under test: {@link TronStatsManager#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TronStatsManager.init()"})
  public void testInit() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            scheduledExecutorService.scheduleWithFixedDelay(
                Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    tronStatsManager.init();

    // Assert
    verify(scheduledExecutorService)
        .scheduleWithFixedDelay(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.SECONDS));
  }

  /**
   * Test {@link TronStatsManager#close()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledExecutorService} {@link
   *       ScheduledExecutorService#awaitTermination(long, TimeUnit)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronStatsManager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TronStatsManager.close()"})
  public void testClose_givenScheduledExecutorServiceAwaitTerminationReturnTrue()
      throws InterruptedException {
    // Arrange
    when(scheduledExecutorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(true);
    doNothing().when(scheduledExecutorService).shutdown();

    // Act
    tronStatsManager.close();

    // Assert
    verify(scheduledExecutorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(scheduledExecutorService).shutdown();
  }

  /**
   * Test {@link TronStatsManager#close()}.
   *
   * <ul>
   *   <li>Then calls {@link ScheduledExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link TronStatsManager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TronStatsManager.close()"})
  public void testClose_thenCallsShutdownNow() throws InterruptedException {
    // Arrange
    when(scheduledExecutorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(false);
    when(scheduledExecutorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(scheduledExecutorService).shutdown();

    // Act
    tronStatsManager.close();

    // Assert
    verify(scheduledExecutorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(scheduledExecutorService).shutdown();
    verify(scheduledExecutorService).shutdownNow();
  }
}
