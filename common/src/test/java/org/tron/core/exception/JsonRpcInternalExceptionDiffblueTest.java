package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class JsonRpcInternalExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link JsonRpcInternalException#JsonRpcInternalException()}
   */
  @Test
  public void testNewJsonRpcInternalException() {
    // Arrange and Act
    JsonRpcInternalException actualJsonRpcInternalException = new JsonRpcInternalException();

    // Assert
    assertNull(actualJsonRpcInternalException.getLocalizedMessage());
    assertNull(actualJsonRpcInternalException.getMessage());
    assertNull(actualJsonRpcInternalException.getCause());
    assertEquals(0, actualJsonRpcInternalException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcInternalException#JsonRpcInternalException(String)}
   */
  @Test
  public void testNewJsonRpcInternalException2() {
    // Arrange and Act
    JsonRpcInternalException actualJsonRpcInternalException = new JsonRpcInternalException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJsonRpcInternalException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInternalException.getMessage());
    assertNull(actualJsonRpcInternalException.getCause());
    assertEquals(0, actualJsonRpcInternalException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcInternalException#JsonRpcInternalException(String, Throwable)}
   */
  @Test
  public void testNewJsonRpcInternalException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcInternalException actualJsonRpcInternalException = new JsonRpcInternalException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcInternalException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInternalException.getMessage());
    assertEquals(0, actualJsonRpcInternalException.getSuppressed().length);
    assertSame(cause, actualJsonRpcInternalException.getCause());
  }
}
