package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ItemNotFoundExceptionDiffblueTest {
  /**
   * Method under test: {@link ItemNotFoundException#ItemNotFoundException()}
   */
  @Test
  public void testNewItemNotFoundException() {
    // Arrange and Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException();

    // Assert
    assertNull(actualItemNotFoundException.getMessage());
    assertNull(actualItemNotFoundException.getCause());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ItemNotFoundException#ItemNotFoundException(String)}
   */
  @Test
  public void testNewItemNotFoundException2() {
    // Arrange and Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualItemNotFoundException.getMessage());
    assertNull(actualItemNotFoundException.getCause());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ItemNotFoundException#ItemNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewItemNotFoundException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualItemNotFoundException.getMessage());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
    assertSame(cause, actualItemNotFoundException.getCause());
  }
}
