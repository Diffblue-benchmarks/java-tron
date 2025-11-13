package org.tron.core.db;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.tron.core.ChainBaseManager;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ManagerDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private ExecutorService executorService;

  @InjectMocks private Manager manager;

  @Mock private RevokingDatabase revokingDatabase;

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#shutdown()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenChainBaseManagerShutdownThrowIllegalArgumentException()
      throws InterruptedException {
    // Arrange
    doThrow(new IllegalArgumentException()).when(chainBaseManager).shutdown();
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(executorService).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(chainBaseManager).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code false}.
   *   <li>Then calls {@link ExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenExecutorServiceAwaitTerminationReturnFalse_thenCallsShutdownNow()
      throws InterruptedException {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doNothing().when(revokingDatabase).shutdown();
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(false);
    when(executorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(executorService).shutdown();

    // Act
    manager.close();

    // Assert
    verify(executorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(executorService).shutdownNow();
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#shutdown()} does nothing.
   *   <li>Then calls {@link RevokingDatabase#shutdown()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenRevokingDatabaseShutdownDoesNothing_thenCallsShutdown()
      throws InterruptedException {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doNothing().when(revokingDatabase).shutdown();
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(executorService).shutdown();

    // Act
    manager.close();

    // Assert
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   *
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#shutdown()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Manager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenRevokingDatabaseShutdownThrowIllegalArgumentException()
      throws InterruptedException {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doThrow(new IllegalArgumentException()).when(revokingDatabase).shutdown();
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(executorService).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }
}
