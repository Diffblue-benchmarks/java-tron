package org.tron.consensus.dpos;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DposTaskDiffblueTest {
  @InjectMocks private DposTask dposTask;

  @Mock private ExecutorService executorService;

  /**
   * Test {@link DposTask#stop()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code false}.
   *   <li>Then calls {@link ExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link DposTask#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DposTask.stop()"})
  public void testStop_givenExecutorServiceAwaitTerminationReturnFalse_thenCallsShutdownNow()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(false);
    when(executorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(executorService).shutdown();

    // Act
    dposTask.stop();

    // Assert
    verify(executorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(executorService).shutdownNow();
  }

  /**
   * Test {@link DposTask#stop()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DposTask#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DposTask.stop()"})
  public void testStop_givenExecutorServiceAwaitTerminationReturnTrue()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(executorService).shutdown();

    // Act
    dposTask.stop();

    // Assert
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
  }

  /**
   * Test {@link DposTask#stop()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       throw {@link InterruptedException#InterruptedException()}.
   * </ul>
   *
   * <p>Method under test: {@link DposTask#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DposTask.stop()"})
  public void testStop_givenExecutorServiceAwaitTerminationThrowInterruptedException()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenThrow(new InterruptedException());
    when(executorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(executorService).shutdown();

    // Act
    dposTask.stop();

    // Assert
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(executorService).shutdownNow();
  }
}
