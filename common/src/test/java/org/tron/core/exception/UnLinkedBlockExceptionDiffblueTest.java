package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UnLinkedBlockExceptionDiffblueTest {
  /**
   * Method under test: {@link UnLinkedBlockException#UnLinkedBlockException()}
   */
  @Test
  public void testNewUnLinkedBlockException() {
    // Arrange and Act
    UnLinkedBlockException actualUnLinkedBlockException = new UnLinkedBlockException();

    // Assert
    assertNull(actualUnLinkedBlockException.getLocalizedMessage());
    assertNull(actualUnLinkedBlockException.getMessage());
    assertNull(actualUnLinkedBlockException.getCause());
    assertEquals(0, actualUnLinkedBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link UnLinkedBlockException#UnLinkedBlockException(String)}
   */
  @Test
  public void testNewUnLinkedBlockException2() {
    // Arrange and Act
    UnLinkedBlockException actualUnLinkedBlockException = new UnLinkedBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnLinkedBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnLinkedBlockException.getMessage());
    assertNull(actualUnLinkedBlockException.getCause());
    assertEquals(0, actualUnLinkedBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link UnLinkedBlockException#UnLinkedBlockException(String, Throwable)}
   */
  @Test
  public void testNewUnLinkedBlockException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnLinkedBlockException actualUnLinkedBlockException = new UnLinkedBlockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUnLinkedBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnLinkedBlockException.getMessage());
    assertEquals(0, actualUnLinkedBlockException.getSuppressed().length);
    assertSame(cause, actualUnLinkedBlockException.getCause());
  }
}
