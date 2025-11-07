package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db.Manager;
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;

@RunWith(MockitoJUnitRunner.class)
public class WalletOnCursorDiffblueTest {
  @Mock
  private Manager manager;

  @InjectMocks
  private WalletOnPBFT walletOnPBFT;

  /**
   * Method under test: {@link WalletOnCursor#futureGet(Runnable)}
   */
  @Test
  public void testFutureGet() {
    // Arrange
    doNothing().when(manager).resetCursor();
    doNothing().when(manager).setCursor(Mockito.<Chainbase.Cursor>any());
    Runnable runnable = mock(Runnable.class);
    doNothing().when(runnable).run();

    // Act
    walletOnPBFT.futureGet(runnable);

    // Assert that nothing has changed
    verify(runnable).run();
    verify(manager).resetCursor();
    verify(manager).setCursor(eq(Chainbase.Cursor.PBFT));
  }

  /**
   * Method under test:
   * {@link WalletOnCursor#futureGet(WalletOnCursor.TronCallable)}
   */
  @Test
  public void testFutureGet2() {
    // Arrange
    doNothing().when(manager).resetCursor();
    doNothing().when(manager).setCursor(Mockito.<Chainbase.Cursor>any());
    WalletOnCursor.TronCallable<Object> callable = mock(WalletOnCursor.TronCallable.class);
    when(callable.call()).thenReturn("Call");

    // Act
    Object actualFutureGetResult = walletOnPBFT.futureGet(callable);

    // Assert
    verify(manager).resetCursor();
    verify(manager).setCursor(eq(Chainbase.Cursor.PBFT));
    verify(callable).call();
    assertEquals("Call", actualFutureGetResult);
  }
}
