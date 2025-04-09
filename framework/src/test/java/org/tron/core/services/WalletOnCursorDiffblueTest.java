package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.db.Manager;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db2.core.Chainbase.Cursor;
import org.tron.core.services.WalletOnCursor.TronCallable;
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;

@RunWith(MockitoJUnitRunner.class)
public class WalletOnCursorDiffblueTest {
  @Mock
  private Manager manager;

  @InjectMocks
  private WalletOnPBFT walletOnPBFT;

  /**
   * Test {@link WalletOnCursor#futureGet(TronCallable)} with {@code callable}.
   * <p>
   * Method under test: {@link WalletOnCursor#futureGet(TronCallable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object WalletOnCursor.futureGet(TronCallable)"})
  public void testFutureGetWithCallable() {
    // Arrange
    doNothing().when(manager).resetCursor();
    doNothing().when(manager).setCursor(Mockito.<Cursor>any());
    TronCallable<Object> callable = mock(TronCallable.class);
    when(callable.call()).thenReturn("Call");

    // Act
    Object actualFutureGetResult = walletOnPBFT.futureGet(callable);

    // Assert
    verify(manager).resetCursor();
    verify(manager).setCursor(eq(Cursor.PBFT));
    verify(callable).call();
    assertEquals("Call", actualFutureGetResult);
  }

  /**
   * Test {@link WalletOnCursor#futureGet(Runnable)} with {@code runnable}.
   * <p>
   * Method under test: {@link WalletOnCursor#futureGet(Runnable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletOnCursor.futureGet(Runnable)"})
  public void testFutureGetWithRunnable() {
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
    verify(manager).setCursor(eq(Cursor.PBFT));
  }
}
