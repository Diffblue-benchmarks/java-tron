package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UnReachBlockExceptionDiffblueTest {
  /**
   * Method under test: {@link UnReachBlockException#UnReachBlockException()}
   */
  @Test
  public void testNewUnReachBlockException() {
    // Arrange and Act
    UnReachBlockException actualUnReachBlockException = new UnReachBlockException();

    // Assert
    assertNull(actualUnReachBlockException.getLocalizedMessage());
    assertNull(actualUnReachBlockException.getMessage());
    assertNull(actualUnReachBlockException.getCause());
    assertEquals(0, actualUnReachBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link UnReachBlockException#UnReachBlockException(String)}
   */
  @Test
  public void testNewUnReachBlockException2() {
    // Arrange and Act
    UnReachBlockException actualUnReachBlockException = new UnReachBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnReachBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnReachBlockException.getMessage());
    assertNull(actualUnReachBlockException.getCause());
    assertEquals(0, actualUnReachBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link UnReachBlockException#UnReachBlockException(String, Throwable)}
   */
  @Test
  public void testNewUnReachBlockException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnReachBlockException actualUnReachBlockException = new UnReachBlockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUnReachBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnReachBlockException.getMessage());
    assertEquals(0, actualUnReachBlockException.getSuppressed().length);
    assertSame(cause, actualUnReachBlockException.getCause());
  }
}
