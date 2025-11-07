package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonRpcInvalidParamsExceptionDiffblueTest {
  /**
   * Test {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException()}.
   * <p>
   * Method under test: {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcInvalidParamsException.<init>()"})
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
   * Test {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException(String)}.
   * <p>
   * Method under test: {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcInvalidParamsException.<init>(String)"})
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
   * Test {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException(String, Throwable)}.
   * <p>
   * Method under test: {@link JsonRpcInvalidParamsException#JsonRpcInvalidParamsException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcInvalidParamsException.<init>(String, Throwable)"})
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
