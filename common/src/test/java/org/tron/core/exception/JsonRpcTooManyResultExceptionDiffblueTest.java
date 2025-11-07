package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class JsonRpcTooManyResultExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException()}
   */
  @Test
  public void testNewJsonRpcTooManyResultException() {
    // Arrange and Act
    JsonRpcTooManyResultException actualJsonRpcTooManyResultException = new JsonRpcTooManyResultException();

    // Assert
    assertNull(actualJsonRpcTooManyResultException.getLocalizedMessage());
    assertNull(actualJsonRpcTooManyResultException.getMessage());
    assertNull(actualJsonRpcTooManyResultException.getCause());
    assertEquals(0, actualJsonRpcTooManyResultException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException(String)}
   */
  @Test
  public void testNewJsonRpcTooManyResultException2() {
    // Arrange and Act
    JsonRpcTooManyResultException actualJsonRpcTooManyResultException = new JsonRpcTooManyResultException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getMessage());
    assertNull(actualJsonRpcTooManyResultException.getCause());
    assertEquals(0, actualJsonRpcTooManyResultException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException(String, Throwable)}
   */
  @Test
  public void testNewJsonRpcTooManyResultException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcTooManyResultException actualJsonRpcTooManyResultException = new JsonRpcTooManyResultException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getMessage());
    assertEquals(0, actualJsonRpcTooManyResultException.getSuppressed().length);
    assertSame(cause, actualJsonRpcTooManyResultException.getCause());
  }
}
