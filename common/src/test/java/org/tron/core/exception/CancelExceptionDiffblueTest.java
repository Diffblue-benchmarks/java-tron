package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class CancelExceptionDiffblueTest {
  /**
   * Method under test: {@link CancelException#CancelException()}
   */
  @Test
  public void testNewCancelException() {
    // Arrange and Act
    CancelException actualCancelException = new CancelException();

    // Assert
    assertNull(actualCancelException.getLocalizedMessage());
    assertNull(actualCancelException.getMessage());
    assertNull(actualCancelException.getCause());
    assertEquals(0, actualCancelException.getSuppressed().length);
  }

  /**
   * Method under test: {@link CancelException#CancelException(String)}
   */
  @Test
  public void testNewCancelException2() {
    // Arrange and Act
    CancelException actualCancelException = new CancelException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCancelException.getLocalizedMessage());
    assertEquals("An error occurred", actualCancelException.getMessage());
    assertNull(actualCancelException.getCause());
    assertEquals(0, actualCancelException.getSuppressed().length);
  }
}
