package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TraitorPeerExceptionDiffblueTest {
  /**
   * Method under test: {@link TraitorPeerException#TraitorPeerException()}
   */
  @Test
  public void testNewTraitorPeerException() {
    // Arrange and Act
    TraitorPeerException actualTraitorPeerException = new TraitorPeerException();

    // Assert
    assertNull(actualTraitorPeerException.getLocalizedMessage());
    assertNull(actualTraitorPeerException.getMessage());
    assertNull(actualTraitorPeerException.getCause());
    assertEquals(0, actualTraitorPeerException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TraitorPeerException#TraitorPeerException(String)}
   */
  @Test
  public void testNewTraitorPeerException2() {
    // Arrange and Act
    TraitorPeerException actualTraitorPeerException = new TraitorPeerException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTraitorPeerException.getLocalizedMessage());
    assertEquals("An error occurred", actualTraitorPeerException.getMessage());
    assertNull(actualTraitorPeerException.getCause());
    assertEquals(0, actualTraitorPeerException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TraitorPeerException#TraitorPeerException(String, Throwable)}
   */
  @Test
  public void testNewTraitorPeerException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TraitorPeerException actualTraitorPeerException = new TraitorPeerException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTraitorPeerException.getLocalizedMessage());
    assertEquals("An error occurred", actualTraitorPeerException.getMessage());
    assertEquals(0, actualTraitorPeerException.getSuppressed().length);
    assertSame(cause, actualTraitorPeerException.getCause());
  }
}
