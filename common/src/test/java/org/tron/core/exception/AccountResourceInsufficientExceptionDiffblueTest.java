package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AccountResourceInsufficientExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link AccountResourceInsufficientException#AccountResourceInsufficientException(String)}
   */
  @Test
  public void testNewAccountResourceInsufficientException() {
    // Arrange and Act
    AccountResourceInsufficientException actualAccountResourceInsufficientException = new AccountResourceInsufficientException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualAccountResourceInsufficientException.getLocalizedMessage());
    assertEquals("An error occurred", actualAccountResourceInsufficientException.getMessage());
    assertNull(actualAccountResourceInsufficientException.getCause());
    assertEquals(0, actualAccountResourceInsufficientException.getSuppressed().length);
  }
}
