package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class HighFreqExceptionDiffblueTest {
  /**
   * Method under test: {@link HighFreqException#HighFreqException()}
   */
  @Test
  public void testNewHighFreqException() {
    // Arrange and Act
    HighFreqException actualHighFreqException = new HighFreqException();

    // Assert
    assertNull(actualHighFreqException.getLocalizedMessage());
    assertNull(actualHighFreqException.getMessage());
    assertNull(actualHighFreqException.getCause());
    assertEquals(0, actualHighFreqException.getSuppressed().length);
  }

  /**
   * Method under test: {@link HighFreqException#HighFreqException(String)}
   */
  @Test
  public void testNewHighFreqException2() {
    // Arrange and Act
    HighFreqException actualHighFreqException = new HighFreqException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualHighFreqException.getLocalizedMessage());
    assertEquals("An error occurred", actualHighFreqException.getMessage());
    assertNull(actualHighFreqException.getCause());
    assertEquals(0, actualHighFreqException.getSuppressed().length);
  }
}
