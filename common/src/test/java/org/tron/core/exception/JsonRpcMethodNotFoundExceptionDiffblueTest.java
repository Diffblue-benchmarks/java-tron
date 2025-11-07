package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class JsonRpcMethodNotFoundExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException()}
   */
  @Test
  public void testNewJsonRpcMethodNotFoundException() {
    // Arrange and Act
    JsonRpcMethodNotFoundException actualJsonRpcMethodNotFoundException = new JsonRpcMethodNotFoundException();

    // Assert
    assertNull(actualJsonRpcMethodNotFoundException.getLocalizedMessage());
    assertNull(actualJsonRpcMethodNotFoundException.getMessage());
    assertNull(actualJsonRpcMethodNotFoundException.getCause());
    assertEquals(0, actualJsonRpcMethodNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException(String)}
   */
  @Test
  public void testNewJsonRpcMethodNotFoundException2() {
    // Arrange and Act
    JsonRpcMethodNotFoundException actualJsonRpcMethodNotFoundException = new JsonRpcMethodNotFoundException("Msg");

    // Assert
    assertEquals("Msg", actualJsonRpcMethodNotFoundException.getLocalizedMessage());
    assertEquals("Msg", actualJsonRpcMethodNotFoundException.getMessage());
    assertNull(actualJsonRpcMethodNotFoundException.getCause());
    assertEquals(0, actualJsonRpcMethodNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewJsonRpcMethodNotFoundException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcMethodNotFoundException actualJsonRpcMethodNotFoundException = new JsonRpcMethodNotFoundException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcMethodNotFoundException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcMethodNotFoundException.getMessage());
    assertEquals(0, actualJsonRpcMethodNotFoundException.getSuppressed().length);
    assertSame(cause, actualJsonRpcMethodNotFoundException.getCause());
  }
}
