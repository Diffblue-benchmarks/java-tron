package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TronExceptionDiffblueTest {
  /**
   * Method under test: {@link TronException#TronException()}
   */
  @Test
  public void testNewTronException() {
    // Arrange and Act
    TronException actualTronException = new TronException();

    // Assert
    assertNull(actualTronException.getLocalizedMessage());
    assertNull(actualTronException.getMessage());
    assertNull(actualTronException.getCause());
    assertEquals(0, actualTronException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TronException#TronException(String)}
   */
  @Test
  public void testNewTronException2() {
    // Arrange and Act
    TronException actualTronException = new TronException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTronException.getLocalizedMessage());
    assertEquals("An error occurred", actualTronException.getMessage());
    assertNull(actualTronException.getCause());
    assertEquals(0, actualTronException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TronException#TronException(String, Throwable)}
   */
  @Test
  public void testNewTronException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronException actualTronException = new TronException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTronException.getLocalizedMessage());
    assertEquals("An error occurred", actualTronException.getMessage());
    assertEquals(0, actualTronException.getSuppressed().length);
    assertSame(cause, actualTronException.getCause());
  }
}
