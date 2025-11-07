package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class BadTransactionExceptionDiffblueTest {
  /**
   * Method under test: {@link BadTransactionException#BadTransactionException()}
   */
  @Test
  public void testNewBadTransactionException() {
    // Arrange and Act
    BadTransactionException actualBadTransactionException = new BadTransactionException();

    // Assert
    assertNull(actualBadTransactionException.getLocalizedMessage());
    assertNull(actualBadTransactionException.getMessage());
    assertNull(actualBadTransactionException.getCause());
    assertEquals(0, actualBadTransactionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BadTransactionException#BadTransactionException(String)}
   */
  @Test
  public void testNewBadTransactionException2() {
    // Arrange and Act
    BadTransactionException actualBadTransactionException = new BadTransactionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadTransactionException.getMessage());
    assertNull(actualBadTransactionException.getCause());
    assertEquals(0, actualBadTransactionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BadTransactionException#BadTransactionException(String, Throwable)}
   */
  @Test
  public void testNewBadTransactionException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    BadTransactionException actualBadTransactionException = new BadTransactionException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualBadTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadTransactionException.getMessage());
    assertEquals(0, actualBadTransactionException.getSuppressed().length);
    assertSame(cause, actualBadTransactionException.getCause());
  }
}
