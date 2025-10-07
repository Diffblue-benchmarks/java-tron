package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TooBigTransactionResultExceptionDiffblueTest {
  /**
   * Test {@link TooBigTransactionResultException#TooBigTransactionResultException()}.
   *
   * <p>Method under test: {@link
   * TooBigTransactionResultException#TooBigTransactionResultException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TooBigTransactionResultException.<init>()"})
  public void testNewTooBigTransactionResultException() {
    // Arrange and Act
    TooBigTransactionResultException actualTooBigTransactionResultException =
        new TooBigTransactionResultException();

    // Assert
    assertEquals(
        "too big transaction result", actualTooBigTransactionResultException.getLocalizedMessage());
    assertEquals("too big transaction result", actualTooBigTransactionResultException.getMessage());
    assertNull(actualTooBigTransactionResultException.getCause());
    assertEquals(0, actualTooBigTransactionResultException.getSuppressed().length);
  }

  /**
   * Test {@link TooBigTransactionResultException#TooBigTransactionResultException(String)}.
   *
   * <p>Method under test: {@link
   * TooBigTransactionResultException#TooBigTransactionResultException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TooBigTransactionResultException.<init>(String)"})
  public void testNewTooBigTransactionResultException2() {
    // Arrange and Act
    TooBigTransactionResultException actualTooBigTransactionResultException =
        new TooBigTransactionResultException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTooBigTransactionResultException.getLocalizedMessage());
    assertEquals("An error occurred", actualTooBigTransactionResultException.getMessage());
    assertNull(actualTooBigTransactionResultException.getCause());
    assertEquals(0, actualTooBigTransactionResultException.getSuppressed().length);
  }
}
