package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DupTransactionExceptionDiffblueTest {
  /**
   * Method under test: {@link DupTransactionException#DupTransactionException()}
   */
  @Test
  public void testNewDupTransactionException() {
    // Arrange and Act
    DupTransactionException actualDupTransactionException = new DupTransactionException();

    // Assert
    assertNull(actualDupTransactionException.getLocalizedMessage());
    assertNull(actualDupTransactionException.getMessage());
    assertNull(actualDupTransactionException.getCause());
    assertEquals(0, actualDupTransactionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link DupTransactionException#DupTransactionException(String)}
   */
  @Test
  public void testNewDupTransactionException2() {
    // Arrange and Act
    DupTransactionException actualDupTransactionException = new DupTransactionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDupTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualDupTransactionException.getMessage());
    assertNull(actualDupTransactionException.getCause());
    assertEquals(0, actualDupTransactionException.getSuppressed().length);
  }
}
