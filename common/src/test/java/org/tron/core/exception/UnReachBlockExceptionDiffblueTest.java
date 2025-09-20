package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnReachBlockExceptionDiffblueTest {
  /**
   * Test {@link UnReachBlockException#UnReachBlockException()}.
   *
   * <p>Method under test: {@link UnReachBlockException#UnReachBlockException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnReachBlockException.<init>()"})
  public void testNewUnReachBlockException() {
    // Arrange and Act
    UnReachBlockException actualUnReachBlockException = new UnReachBlockException();

    // Assert
    assertNull(actualUnReachBlockException.getLocalizedMessage());
    assertNull(actualUnReachBlockException.getMessage());
    assertNull(actualUnReachBlockException.getCause());
    assertEquals(0, actualUnReachBlockException.getSuppressed().length);
  }

  /**
   * Test {@link UnReachBlockException#UnReachBlockException(String)}.
   *
   * <p>Method under test: {@link UnReachBlockException#UnReachBlockException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnReachBlockException.<init>(String)"})
  public void testNewUnReachBlockException2() {
    // Arrange and Act
    UnReachBlockException actualUnReachBlockException =
        new UnReachBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnReachBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnReachBlockException.getMessage());
    assertNull(actualUnReachBlockException.getCause());
    assertEquals(0, actualUnReachBlockException.getSuppressed().length);
  }

  /**
   * Test {@link UnReachBlockException#UnReachBlockException(String, Throwable)}.
   *
   * <p>Method under test: {@link UnReachBlockException#UnReachBlockException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnReachBlockException.<init>(String, Throwable)"})
  public void testNewUnReachBlockException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnReachBlockException actualUnReachBlockException =
        new UnReachBlockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUnReachBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnReachBlockException.getMessage());
    assertEquals(0, actualUnReachBlockException.getSuppressed().length);
    assertSame(cause, actualUnReachBlockException.getCause());
  }
}
