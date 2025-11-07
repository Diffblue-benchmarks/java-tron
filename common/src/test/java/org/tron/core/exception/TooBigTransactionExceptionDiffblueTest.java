package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TooBigTransactionExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link TooBigTransactionException#TooBigTransactionException()}
   */
  @Test
  public void testNewTooBigTransactionException() {
    // Arrange and Act
    TooBigTransactionException actualTooBigTransactionException = new TooBigTransactionException();

    // Assert
    assertNull(actualTooBigTransactionException.getLocalizedMessage());
    assertNull(actualTooBigTransactionException.getMessage());
    assertNull(actualTooBigTransactionException.getCause());
    assertEquals(0, actualTooBigTransactionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TooBigTransactionException#TooBigTransactionException(String)}
   */
  @Test
  public void testNewTooBigTransactionException2() {
    // Arrange and Act
    TooBigTransactionException actualTooBigTransactionException = new TooBigTransactionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTooBigTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualTooBigTransactionException.getMessage());
    assertNull(actualTooBigTransactionException.getCause());
    assertEquals(0, actualTooBigTransactionException.getSuppressed().length);
  }
}
