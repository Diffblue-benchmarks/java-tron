package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonRpcMethodNotFoundExceptionDiffblueTest {
  /**
   * Test {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException()}.
   * <p>
   * Method under test: {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcMethodNotFoundException.<init>()"})
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
   * Test {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException(String)}.
   * <p>
   * Method under test: {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcMethodNotFoundException.<init>(String)"})
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
   * Test {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException(String, Throwable)}.
   * <p>
   * Method under test: {@link JsonRpcMethodNotFoundException#JsonRpcMethodNotFoundException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcMethodNotFoundException.<init>(String, Throwable)"})
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
