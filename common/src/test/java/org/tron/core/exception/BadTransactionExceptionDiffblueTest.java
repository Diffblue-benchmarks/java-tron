package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BadTransactionExceptionDiffblueTest {
  /**
   * Test {@link BadTransactionException#BadTransactionException()}.
   * <p>
   * Method under test: {@link BadTransactionException#BadTransactionException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadTransactionException.<init>()"})
  public void testNewBadTransactionException() {
    // Arrange and Act
    BadTransactionException actualBadTransactionException = new BadTransactionException();

    // Assert
    assertNull(actualBadTransactionException.getLocalizedMessage());
    assertNull(actualBadTransactionException.getMessage());
    assertNull(actualBadTransactionException.getCause());
    assertEquals(0, actualBadTransactionException.getSuppressed().length);
  }

  /**
   * Test {@link BadTransactionException#BadTransactionException(String)}.
   * <p>
   * Method under test: {@link BadTransactionException#BadTransactionException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadTransactionException.<init>(String)"})
  public void testNewBadTransactionException2() {
    // Arrange and Act
    BadTransactionException actualBadTransactionException = new BadTransactionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadTransactionException.getMessage());
    assertNull(actualBadTransactionException.getCause());
    assertEquals(0, actualBadTransactionException.getSuppressed().length);
  }

  /**
   * Test {@link BadTransactionException#BadTransactionException(String, Throwable)}.
   * <p>
   * Method under test: {@link BadTransactionException#BadTransactionException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadTransactionException.<init>(String, Throwable)"})
  public void testNewBadTransactionException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    BadTransactionException actualBadTransactionException = new BadTransactionException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualBadTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadTransactionException.getMessage());
    assertEquals(0, actualBadTransactionException.getSuppressed().length);
    assertSame(cause, actualBadTransactionException.getCause());
  }
}
