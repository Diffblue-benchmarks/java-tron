package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class JsonRpcInvalidRequestExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException()}
   */
  @Test
  public void testNewJsonRpcInvalidRequestException() {
    // Arrange and Act
    JsonRpcInvalidRequestException actualJsonRpcInvalidRequestException = new JsonRpcInvalidRequestException();

    // Assert
    assertNull(actualJsonRpcInvalidRequestException.getLocalizedMessage());
    assertNull(actualJsonRpcInvalidRequestException.getMessage());
    assertNull(actualJsonRpcInvalidRequestException.getCause());
    assertEquals(0, actualJsonRpcInvalidRequestException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException(String)}
   */
  @Test
  public void testNewJsonRpcInvalidRequestException2() {
    // Arrange and Act
    JsonRpcInvalidRequestException actualJsonRpcInvalidRequestException = new JsonRpcInvalidRequestException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getMessage());
    assertNull(actualJsonRpcInvalidRequestException.getCause());
    assertEquals(0, actualJsonRpcInvalidRequestException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException(String, Throwable)}
   */
  @Test
  public void testNewJsonRpcInvalidRequestException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcInvalidRequestException actualJsonRpcInvalidRequestException = new JsonRpcInvalidRequestException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getMessage());
    assertEquals(0, actualJsonRpcInvalidRequestException.getSuppressed().length);
    assertSame(cause, actualJsonRpcInvalidRequestException.getCause());
  }
}
