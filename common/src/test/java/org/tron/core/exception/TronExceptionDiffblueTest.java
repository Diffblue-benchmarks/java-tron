package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TronExceptionDiffblueTest {
  /**
   * Test {@link TronException#TronException()}.
   *
   * <p>Method under test: {@link TronException#TronException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronException.<init>()"})
  public void testNewTronException() {
    // Arrange and Act
    TronException actualTronException = new TronException();

    // Assert
    assertNull(actualTronException.getLocalizedMessage());
    assertNull(actualTronException.getMessage());
    assertNull(actualTronException.getCause());
    assertEquals(0, actualTronException.getSuppressed().length);
  }

  /**
   * Test {@link TronException#TronException(String)}.
   *
   * <p>Method under test: {@link TronException#TronException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronException.<init>(String)"})
  public void testNewTronException2() {
    // Arrange and Act
    TronException actualTronException = new TronException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTronException.getLocalizedMessage());
    assertEquals("An error occurred", actualTronException.getMessage());
    assertNull(actualTronException.getCause());
    assertEquals(0, actualTronException.getSuppressed().length);
  }

  /**
   * Test {@link TronException#TronException(String, Throwable)}.
   *
   * <p>Method under test: {@link TronException#TronException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronException.<init>(String, Throwable)"})
  public void testNewTronException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronException actualTronException = new TronException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTronException.getLocalizedMessage());
    assertEquals("An error occurred", actualTronException.getMessage());
    assertEquals(0, actualTronException.getSuppressed().length);
    assertSame(cause, actualTronException.getCause());
  }
}
