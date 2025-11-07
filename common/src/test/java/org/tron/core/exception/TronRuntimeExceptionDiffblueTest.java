package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TronRuntimeExceptionDiffblueTest {
  /**
   * Method under test: {@link TronRuntimeException#TronRuntimeException()}
   */
  @Test
  public void testNewTronRuntimeException() {
    // Arrange and Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException();

    // Assert
    assertNull(actualTronRuntimeException.getMessage());
    assertNull(actualTronRuntimeException.getCause());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TronRuntimeException#TronRuntimeException(String)}
   */
  @Test
  public void testNewTronRuntimeException2() {
    // Arrange and Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTronRuntimeException.getMessage());
    assertNull(actualTronRuntimeException.getCause());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TronRuntimeException#TronRuntimeException(String, Throwable)}
   */
  @Test
  public void testNewTronRuntimeException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTronRuntimeException.getMessage());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
    assertSame(cause, actualTronRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link TronRuntimeException#TronRuntimeException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewTronRuntimeException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualTronRuntimeException.getMessage());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
    assertSame(cause, actualTronRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link TronRuntimeException#TronRuntimeException(Throwable)}
   */
  @Test
  public void testNewTronRuntimeException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTronRuntimeException.getMessage());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
    assertSame(cause, actualTronRuntimeException.getCause());
  }
}
