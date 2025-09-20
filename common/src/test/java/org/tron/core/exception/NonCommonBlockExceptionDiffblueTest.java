package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NonCommonBlockExceptionDiffblueTest {
  /**
   * Test {@link NonCommonBlockException#NonCommonBlockException()}.
   *
   * <p>Method under test: {@link NonCommonBlockException#NonCommonBlockException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonCommonBlockException.<init>()"})
  public void testNewNonCommonBlockException() {
    // Arrange and Act
    NonCommonBlockException actualNonCommonBlockException = new NonCommonBlockException();

    // Assert
    assertNull(actualNonCommonBlockException.getLocalizedMessage());
    assertNull(actualNonCommonBlockException.getMessage());
    assertNull(actualNonCommonBlockException.getCause());
    assertEquals(0, actualNonCommonBlockException.getSuppressed().length);
  }

  /**
   * Test {@link NonCommonBlockException#NonCommonBlockException(String)}.
   *
   * <p>Method under test: {@link NonCommonBlockException#NonCommonBlockException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonCommonBlockException.<init>(String)"})
  public void testNewNonCommonBlockException2() {
    // Arrange and Act
    NonCommonBlockException actualNonCommonBlockException =
        new NonCommonBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNonCommonBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualNonCommonBlockException.getMessage());
    assertNull(actualNonCommonBlockException.getCause());
    assertEquals(0, actualNonCommonBlockException.getSuppressed().length);
  }

  /**
   * Test {@link NonCommonBlockException#NonCommonBlockException(String, Throwable)}.
   *
   * <p>Method under test: {@link NonCommonBlockException#NonCommonBlockException(String,
   * Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonCommonBlockException.<init>(String, Throwable)"})
  public void testNewNonCommonBlockException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NonCommonBlockException actualNonCommonBlockException =
        new NonCommonBlockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNonCommonBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualNonCommonBlockException.getMessage());
    assertEquals(0, actualNonCommonBlockException.getSuppressed().length);
    assertSame(cause, actualNonCommonBlockException.getCause());
  }
}
