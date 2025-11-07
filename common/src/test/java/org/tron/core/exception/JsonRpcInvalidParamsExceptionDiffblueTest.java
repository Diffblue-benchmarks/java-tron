package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class JsonRpcInvalidParamsExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException()}
   */
  @Test
  public void testNewJsonRpcInvalidParamsException() {
    // Arrange and Act
    JsonRpcInvalidParamsException actualJsonRpcInvalidParamsException = new JsonRpcInvalidParamsException();

    // Assert
    assertNull(actualJsonRpcInvalidParamsException.getLocalizedMessage());
    assertNull(actualJsonRpcInvalidParamsException.getMessage());
    assertNull(actualJsonRpcInvalidParamsException.getCause());
    assertEquals(0, actualJsonRpcInvalidParamsException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException(String)}
   */
  @Test
  public void testNewJsonRpcInvalidParamsException2() {
    // Arrange and Act
    JsonRpcInvalidParamsException actualJsonRpcInvalidParamsException = new JsonRpcInvalidParamsException("Msg");

    // Assert
    assertEquals("Msg", actualJsonRpcInvalidParamsException.getLocalizedMessage());
    assertEquals("Msg", actualJsonRpcInvalidParamsException.getMessage());
    assertNull(actualJsonRpcInvalidParamsException.getCause());
    assertEquals(0, actualJsonRpcInvalidParamsException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException(String, Throwable)}
   */
  @Test
  public void testNewJsonRpcInvalidParamsException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcInvalidParamsException actualJsonRpcInvalidParamsException = new JsonRpcInvalidParamsException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcInvalidParamsException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInvalidParamsException.getMessage());
    assertEquals(0, actualJsonRpcInvalidParamsException.getSuppressed().length);
    assertSame(cause, actualJsonRpcInvalidParamsException.getCause());
  }
}
