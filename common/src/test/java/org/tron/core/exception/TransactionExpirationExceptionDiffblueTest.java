package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TransactionExpirationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionExpirationException#TransactionExpirationException()}
   */
  @Test
  public void testNewTransactionExpirationException() {
    // Arrange and Act
    TransactionExpirationException actualTransactionExpirationException = new TransactionExpirationException();

    // Assert
    assertNull(actualTransactionExpirationException.getLocalizedMessage());
    assertNull(actualTransactionExpirationException.getMessage());
    assertNull(actualTransactionExpirationException.getCause());
    assertEquals(0, actualTransactionExpirationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TransactionExpirationException#TransactionExpirationException(String)}
   */
  @Test
  public void testNewTransactionExpirationException2() {
    // Arrange and Act
    TransactionExpirationException actualTransactionExpirationException = new TransactionExpirationException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualTransactionExpirationException.getLocalizedMessage());
    assertEquals("An error occurred", actualTransactionExpirationException.getMessage());
    assertNull(actualTransactionExpirationException.getCause());
    assertEquals(0, actualTransactionExpirationException.getSuppressed().length);
  }
}
