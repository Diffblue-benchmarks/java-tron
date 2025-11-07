package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BalanceInsufficientExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link BalanceInsufficientException#BalanceInsufficientException()}
   */
  @Test
  public void testNewBalanceInsufficientException() {
    // Arrange and Act
    BalanceInsufficientException actualBalanceInsufficientException = new BalanceInsufficientException();

    // Assert
    assertNull(actualBalanceInsufficientException.getLocalizedMessage());
    assertNull(actualBalanceInsufficientException.getMessage());
    assertNull(actualBalanceInsufficientException.getCause());
    assertEquals(0, actualBalanceInsufficientException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BalanceInsufficientException#BalanceInsufficientException(String)}
   */
  @Test
  public void testNewBalanceInsufficientException2() {
    // Arrange and Act
    BalanceInsufficientException actualBalanceInsufficientException = new BalanceInsufficientException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualBalanceInsufficientException.getLocalizedMessage());
    assertEquals("An error occurred", actualBalanceInsufficientException.getMessage());
    assertNull(actualBalanceInsufficientException.getCause());
    assertEquals(0, actualBalanceInsufficientException.getSuppressed().length);
  }
}
