package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonRpcInternalExceptionDiffblueTest {
  /**
   * Test {@link JsonRpcInternalException#JsonRpcInternalException()}.
   *
   * <p>Method under test: {@link JsonRpcInternalException#JsonRpcInternalException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcInternalException.<init>()"})
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
   * Test {@link JsonRpcInternalException#JsonRpcInternalException(String)}.
   *
   * <p>Method under test: {@link JsonRpcInternalException#JsonRpcInternalException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcInternalException.<init>(String)"})
  public void testNewJsonRpcInternalException2() {
    // Arrange and Act
    JsonRpcInternalException actualJsonRpcInternalException =
        new JsonRpcInternalException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJsonRpcInternalException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInternalException.getMessage());
    assertNull(actualJsonRpcInternalException.getCause());
    assertEquals(0, actualJsonRpcInternalException.getSuppressed().length);
  }

  /**
   * Test {@link JsonRpcInternalException#JsonRpcInternalException(String, Throwable)}.
   *
   * <p>Method under test: {@link JsonRpcInternalException#JsonRpcInternalException(String,
   * Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcInternalException.<init>(String, Throwable)"})
  public void testNewJsonRpcInternalException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcInternalException actualJsonRpcInternalException =
        new JsonRpcInternalException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcInternalException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInternalException.getMessage());
    assertEquals(0, actualJsonRpcInternalException.getSuppressed().length);
    assertSame(cause, actualJsonRpcInternalException.getCause());
  }
}
