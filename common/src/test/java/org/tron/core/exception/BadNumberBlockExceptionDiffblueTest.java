package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BadNumberBlockExceptionDiffblueTest {
  /**
   * Method under test: {@link BadNumberBlockException#BadNumberBlockException()}
   */
  @Test
  public void testNewBadNumberBlockException() {
    // Arrange and Act
    BadNumberBlockException actualBadNumberBlockException = new BadNumberBlockException();

    // Assert
    assertNull(actualBadNumberBlockException.getLocalizedMessage());
    assertNull(actualBadNumberBlockException.getMessage());
    assertNull(actualBadNumberBlockException.getCause());
    assertEquals(0, actualBadNumberBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BadNumberBlockException#BadNumberBlockException(String)}
   */
  @Test
  public void testNewBadNumberBlockException2() {
    // Arrange and Act
    BadNumberBlockException actualBadNumberBlockException = new BadNumberBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadNumberBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadNumberBlockException.getMessage());
    assertNull(actualBadNumberBlockException.getCause());
    assertEquals(0, actualBadNumberBlockException.getSuppressed().length);
  }
}
