package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonRpcTooManyResultExceptionDiffblueTest {
  /**
   * Test {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException()}.
   *
   * <p>Method under test: {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcTooManyResultException.<init>()"})
  public void testNewJsonRpcTooManyResultException() {
    // Arrange and Act
    JsonRpcTooManyResultException actualJsonRpcTooManyResultException =
        new JsonRpcTooManyResultException();

    // Assert
    assertNull(actualJsonRpcTooManyResultException.getLocalizedMessage());
    assertNull(actualJsonRpcTooManyResultException.getMessage());
    assertNull(actualJsonRpcTooManyResultException.getCause());
    assertEquals(0, actualJsonRpcTooManyResultException.getSuppressed().length);
  }

  /**
   * Test {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException(String)}.
   *
   * <p>Method under test: {@link
   * JsonRpcTooManyResultException#JsonRpcTooManyResultException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcTooManyResultException.<init>(String)"})
  public void testNewJsonRpcTooManyResultException2() {
    // Arrange and Act
    JsonRpcTooManyResultException actualJsonRpcTooManyResultException =
        new JsonRpcTooManyResultException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getMessage());
    assertNull(actualJsonRpcTooManyResultException.getCause());
    assertEquals(0, actualJsonRpcTooManyResultException.getSuppressed().length);
  }

  /**
   * Test {@link JsonRpcTooManyResultException#JsonRpcTooManyResultException(String, Throwable)}.
   *
   * <p>Method under test: {@link
   * JsonRpcTooManyResultException#JsonRpcTooManyResultException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcTooManyResultException.<init>(String, Throwable)"})
  public void testNewJsonRpcTooManyResultException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    JsonRpcTooManyResultException actualJsonRpcTooManyResultException =
        new JsonRpcTooManyResultException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getLocalizedMessage());
    assertEquals("An error occurred", actualJsonRpcTooManyResultException.getMessage());
    assertEquals(0, actualJsonRpcTooManyResultException.getSuppressed().length);
    assertSame(cause, actualJsonRpcTooManyResultException.getCause());
  }
}
