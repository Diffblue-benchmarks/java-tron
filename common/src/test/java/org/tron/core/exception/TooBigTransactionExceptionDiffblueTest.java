package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TooBigTransactionExceptionDiffblueTest {
  /**
   * Test {@link TooBigTransactionException#TooBigTransactionException()}.
   * <p>
   * Method under test: {@link TooBigTransactionException#TooBigTransactionException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TooBigTransactionException.<init>()"})
  public void testNewTooBigTransactionException() {
    // Arrange and Act
    TooBigTransactionException actualTooBigTransactionException = new TooBigTransactionException();

    // Assert
    assertNull(actualTooBigTransactionException.getLocalizedMessage());
    assertNull(actualTooBigTransactionException.getMessage());
    assertNull(actualTooBigTransactionException.getCause());
    assertEquals(0, actualTooBigTransactionException.getSuppressed().length);
  }

  /**
   * Test {@link TooBigTransactionException#TooBigTransactionException(String)}.
   * <p>
   * Method under test: {@link TooBigTransactionException#TooBigTransactionException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TooBigTransactionException.<init>(String)"})
  public void testNewTooBigTransactionException2() {
    // Arrange and Act
    TooBigTransactionException actualTooBigTransactionException = new TooBigTransactionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTooBigTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualTooBigTransactionException.getMessage());
    assertNull(actualTooBigTransactionException.getCause());
    assertEquals(0, actualTooBigTransactionException.getSuppressed().length);
  }
}
