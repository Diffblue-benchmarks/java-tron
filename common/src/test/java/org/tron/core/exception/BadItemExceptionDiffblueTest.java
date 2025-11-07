package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class BadItemExceptionDiffblueTest {
  /**
   * Method under test: {@link BadItemException#BadItemException()}
   */
  @Test
  public void testNewBadItemException() {
    // Arrange and Act
    BadItemException actualBadItemException = new BadItemException();

    // Assert
    assertNull(actualBadItemException.getMessage());
    assertNull(actualBadItemException.getCause());
    assertEquals(0, actualBadItemException.getSuppressed().length);
  }

  /**
   * Method under test: {@link BadItemException#BadItemException(String)}
   */
  @Test
  public void testNewBadItemException2() {
    // Arrange and Act
    BadItemException actualBadItemException = new BadItemException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadItemException.getMessage());
    assertNull(actualBadItemException.getCause());
    assertEquals(0, actualBadItemException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BadItemException#BadItemException(String, Throwable)}
   */
  @Test
  public void testNewBadItemException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    BadItemException actualBadItemException = new BadItemException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualBadItemException.getMessage());
    assertEquals(0, actualBadItemException.getSuppressed().length);
    assertSame(cause, actualBadItemException.getCause());
  }
}
