package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.db.Manager;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db2.core.Chainbase.Cursor;
import org.tron.core.services.WalletOnCursor.TronCallable;
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class WalletOnCursorDiffblueTest {
  @Mock private Manager manager;

  @InjectMocks private WalletOnPBFT walletOnPBFT;

  /**
   * Test {@link WalletOnCursor#futureGet(TronCallable)} with {@code callable}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#resetCursor()} does nothing.
   *   <li>Then return {@code Call}.
   * </ul>
   *
   * <p>Method under test: {@link WalletOnCursor#futureGet(TronCallable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WalletOnCursor.futureGet(TronCallable)"})
  public void testFutureGetWithCallable_givenManagerResetCursorDoesNothing_thenReturnCall() {
    // Arrange
    doNothing().when(manager).resetCursor();
    doNothing().when(manager).setCursor(Mockito.<Cursor>any());

    TronCallable<Object> callable = mock(TronCallable.class);
    when(callable.call()).thenReturn("Call");

    // Act
    Object actualFutureGetResult = walletOnPBFT.futureGet(callable);

    // Assert
    verify(manager).resetCursor();
    verify(manager).setCursor(Cursor.PBFT);
    verify(callable).call();
    assertEquals("Call", actualFutureGetResult);
  }

  /**
   * Test {@link WalletOnCursor#futureGet(Runnable)} with {@code runnable}.
   *
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.
   *   <li>Then calls {@link Runnable#run()}.
   * </ul>
   *
   * <p>Method under test: {@link WalletOnCursor#futureGet(Runnable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalletOnCursor.futureGet(Runnable)"})
  public void testFutureGetWithRunnable_whenRunnableRunDoesNothing_thenCallsRun() {
    // Arrange
    doNothing().when(manager).resetCursor();
    doNothing().when(manager).setCursor(Mockito.<Cursor>any());

    Runnable runnable = mock(Runnable.class);
    doNothing().when(runnable).run();

    // Act
    walletOnPBFT.futureGet(runnable);

    // Assert
    verify(runnable).run();
    verify(manager).resetCursor();
    verify(manager).setCursor(Cursor.PBFT);
  }
}
