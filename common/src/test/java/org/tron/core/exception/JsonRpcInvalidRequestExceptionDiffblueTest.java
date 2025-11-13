package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonRpcInvalidRequestExceptionDiffblueTest {
  /**
   * Test {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException()}.
   *
   * <p>Method under test: {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcInvalidRequestException.<init>()"})
  public void testNewJsonRpcInvalidRequestException() {
    // Arrange and Act
    JsonRpcInvalidRequestException actualJsonRpcInvalidRequestException =
        new JsonRpcInvalidRequestException();

    // Assert
    assertNull(actualJsonRpcInvalidRequestException.getLocalizedMessage());
    assertNull(actualJsonRpcInvalidRequestException.getMessage());
    assertNull(actualJsonRpcInvalidRequestException.getCause());
    assertEquals(0, actualJsonRpcInvalidRequestException.getSuppressed().length);
  }

  /**
   * Test {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException(String)}.
   *
   * <p>Method under test: {@link
   * JsonRpcInvalidRequestException#JsonRpcInvalidRequestException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcInvalidRequestException.<init>(String)"})
  public void testNewJsonRpcInvalidRequestException2() {
    // Arrange and Act
    JsonRpcInvalidRequestException actualJsonRpcInvalidRequestException =
        new JsonRpcInvalidRequestException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getMessage());
    assertNull(actualJsonRpcInvalidRequestException.getCause());
    assertEquals(0, actualJsonRpcInvalidRequestException.getSuppressed().length);
  }

  /**
   * Test {@link JsonRpcInvalidRequestException#JsonRpcInvalidRequestException(String, Throwable)}.
   *
   * <p>Method under test: {@link
   * JsonRpcInvalidRequestException#JsonRpcInvalidRequestException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcInvalidRequestException.<init>(String, Throwable)"})
  public void testNewJsonRpcInvalidRequestException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcInvalidRequestException actualJsonRpcInvalidRequestException =
        new JsonRpcInvalidRequestException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcInvalidRequestException.getMessage());
    assertEquals(0, actualJsonRpcInvalidRequestException.getSuppressed().length);
    assertSame(cause, actualJsonRpcInvalidRequestException.getCause());
  }
}
