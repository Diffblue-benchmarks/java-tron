package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnLinkedBlockExceptionDiffblueTest {
  /**
   * Test {@link UnLinkedBlockException#UnLinkedBlockException()}.
   * <p>
   * Method under test: {@link UnLinkedBlockException#UnLinkedBlockException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnLinkedBlockException.<init>()"})
  public void testNewUnLinkedBlockException() {
    // Arrange and Act
    UnLinkedBlockException actualUnLinkedBlockException = new UnLinkedBlockException();

    // Assert
    assertNull(actualUnLinkedBlockException.getLocalizedMessage());
    assertNull(actualUnLinkedBlockException.getMessage());
    assertNull(actualUnLinkedBlockException.getCause());
    assertEquals(0, actualUnLinkedBlockException.getSuppressed().length);
  }

  /**
   * Test {@link UnLinkedBlockException#UnLinkedBlockException(String)}.
   * <p>
   * Method under test: {@link UnLinkedBlockException#UnLinkedBlockException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnLinkedBlockException.<init>(String)"})
  public void testNewUnLinkedBlockException2() {
    // Arrange and Act
    UnLinkedBlockException actualUnLinkedBlockException = new UnLinkedBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnLinkedBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnLinkedBlockException.getMessage());
    assertNull(actualUnLinkedBlockException.getCause());
    assertEquals(0, actualUnLinkedBlockException.getSuppressed().length);
  }

  /**
   * Test {@link UnLinkedBlockException#UnLinkedBlockException(String, Throwable)}.
   * <p>
   * Method under test: {@link UnLinkedBlockException#UnLinkedBlockException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnLinkedBlockException.<init>(String, Throwable)"})
  public void testNewUnLinkedBlockException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnLinkedBlockException actualUnLinkedBlockException = new UnLinkedBlockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUnLinkedBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualUnLinkedBlockException.getMessage());
    assertEquals(0, actualUnLinkedBlockException.getSuppressed().length);
    assertSame(cause, actualUnLinkedBlockException.getCause());
  }
}
