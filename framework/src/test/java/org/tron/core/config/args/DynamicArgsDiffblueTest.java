package org.tron.core.config.args;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DynamicArgsDiffblueTest {
  @InjectMocks private DynamicArgs dynamicArgs;

  @Mock private ScheduledExecutorService scheduledExecutorService;

  /**
   * Test {@link DynamicArgs#close()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledExecutorService} {@link
   *       ScheduledExecutorService#awaitTermination(long, TimeUnit)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicArgs#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicArgs.close()"})
  public void testClose_givenScheduledExecutorServiceAwaitTerminationReturnTrue()
      throws InterruptedException {
    // Arrange
    when(scheduledExecutorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(true);
    doNothing().when(scheduledExecutorService).shutdown();

    // Act
    dynamicArgs.close();

    // Assert
    verify(scheduledExecutorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(scheduledExecutorService).shutdown();
  }

  /**
   * Test {@link DynamicArgs#close()}.
   *
   * <ul>
   *   <li>Then calls {@link ScheduledExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicArgs#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicArgs.close()"})
  public void testClose_thenCallsShutdownNow() throws InterruptedException {
    // Arrange
    when(scheduledExecutorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(false);
    when(scheduledExecutorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(scheduledExecutorService).shutdown();

    // Act
    dynamicArgs.close();

    // Assert
    verify(scheduledExecutorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(scheduledExecutorService).shutdown();
    verify(scheduledExecutorService).shutdownNow();
  }
}
