package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TooBigTransactionResultExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link TooBigTransactionResultException#TooBigTransactionResultException()}
   */
  @Test
  public void testNewTooBigTransactionResultException() {
    // Arrange and Act
    TooBigTransactionResultException actualTooBigTransactionResultException = new TooBigTransactionResultException();

    // Assert
    assertEquals("too big transaction result", actualTooBigTransactionResultException.getLocalizedMessage());
    assertEquals("too big transaction result", actualTooBigTransactionResultException.getMessage());
    assertNull(actualTooBigTransactionResultException.getCause());
    assertEquals(0, actualTooBigTransactionResultException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TooBigTransactionResultException#TooBigTransactionResultException(String)}
   */
  @Test
  public void testNewTooBigTransactionResultException2() {
    // Arrange and Act
    TooBigTransactionResultException actualTooBigTransactionResultException = new TooBigTransactionResultException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualTooBigTransactionResultException.getLocalizedMessage());
    assertEquals("An error occurred", actualTooBigTransactionResultException.getMessage());
    assertNull(actualTooBigTransactionResultException.getCause());
    assertEquals(0, actualTooBigTransactionResultException.getSuppressed().length);
  }
}
