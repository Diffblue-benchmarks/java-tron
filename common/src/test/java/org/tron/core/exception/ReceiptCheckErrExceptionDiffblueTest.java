package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ReceiptCheckErrExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ReceiptCheckErrException#ReceiptCheckErrException()}
   */
  @Test
  public void testNewReceiptCheckErrException() {
    // Arrange and Act
    ReceiptCheckErrException actualReceiptCheckErrException = new ReceiptCheckErrException();

    // Assert
    assertNull(actualReceiptCheckErrException.getMessage());
    assertNull(actualReceiptCheckErrException.getCause());
    assertEquals(0, actualReceiptCheckErrException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ReceiptCheckErrException#ReceiptCheckErrException(String)}
   */
  @Test
  public void testNewReceiptCheckErrException2() {
    // Arrange and Act
    ReceiptCheckErrException actualReceiptCheckErrException = new ReceiptCheckErrException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualReceiptCheckErrException.getMessage());
    assertNull(actualReceiptCheckErrException.getCause());
    assertEquals(0, actualReceiptCheckErrException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ReceiptCheckErrException#ReceiptCheckErrException(String, Throwable)}
   */
  @Test
  public void testNewReceiptCheckErrException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ReceiptCheckErrException actualReceiptCheckErrException = new ReceiptCheckErrException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualReceiptCheckErrException.getMessage());
    assertEquals(0, actualReceiptCheckErrException.getSuppressed().length);
    assertSame(cause, actualReceiptCheckErrException.getCause());
  }
}
