package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class NonCommonBlockExceptionDiffblueTest {
  /**
   * Method under test: {@link NonCommonBlockException#NonCommonBlockException()}
   */
  @Test
  public void testNewNonCommonBlockException() {
    // Arrange and Act
    NonCommonBlockException actualNonCommonBlockException = new NonCommonBlockException();

    // Assert
    assertNull(actualNonCommonBlockException.getLocalizedMessage());
    assertNull(actualNonCommonBlockException.getMessage());
    assertNull(actualNonCommonBlockException.getCause());
    assertEquals(0, actualNonCommonBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NonCommonBlockException#NonCommonBlockException(String)}
   */
  @Test
  public void testNewNonCommonBlockException2() {
    // Arrange and Act
    NonCommonBlockException actualNonCommonBlockException = new NonCommonBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNonCommonBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualNonCommonBlockException.getMessage());
    assertNull(actualNonCommonBlockException.getCause());
    assertEquals(0, actualNonCommonBlockException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NonCommonBlockException#NonCommonBlockException(String, Throwable)}
   */
  @Test
  public void testNewNonCommonBlockException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NonCommonBlockException actualNonCommonBlockException = new NonCommonBlockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNonCommonBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualNonCommonBlockException.getMessage());
    assertEquals(0, actualNonCommonBlockException.getSuppressed().length);
    assertSame(cause, actualNonCommonBlockException.getCause());
  }
}
