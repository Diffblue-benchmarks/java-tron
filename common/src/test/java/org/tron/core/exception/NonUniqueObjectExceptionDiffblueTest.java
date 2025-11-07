package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class NonUniqueObjectExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link NonUniqueObjectException#NonUniqueObjectException()}
   */
  @Test
  public void testNewNonUniqueObjectException() {
    // Arrange and Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException();

    // Assert
    assertNull(actualNonUniqueObjectException.getLocalizedMessage());
    assertNull(actualNonUniqueObjectException.getMessage());
    assertNull(actualNonUniqueObjectException.getCause());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NonUniqueObjectException#NonUniqueObjectException(String)}
   */
  @Test
  public void testNewNonUniqueObjectException2() {
    // Arrange and Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException("foo");

    // Assert
    assertEquals("foo", actualNonUniqueObjectException.getLocalizedMessage());
    assertEquals("foo", actualNonUniqueObjectException.getMessage());
    assertNull(actualNonUniqueObjectException.getCause());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NonUniqueObjectException#NonUniqueObjectException(String, Throwable)}
   */
  @Test
  public void testNewNonUniqueObjectException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNonUniqueObjectException.getLocalizedMessage());
    assertEquals("An error occurred", actualNonUniqueObjectException.getMessage());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
    assertSame(cause, actualNonUniqueObjectException.getCause());
  }

  /**
   * Method under test:
   * {@link NonUniqueObjectException#NonUniqueObjectException(Throwable)}
   */
  @Test
  public void testNewNonUniqueObjectException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException(cause);

    // Assert
    assertEquals("", actualNonUniqueObjectException.getLocalizedMessage());
    assertEquals("", actualNonUniqueObjectException.getMessage());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
    assertSame(cause, actualNonUniqueObjectException.getCause());
  }
}
