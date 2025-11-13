package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AccountResourceInsufficientExceptionDiffblueTest {
  /**
   * Test {@link AccountResourceInsufficientException#AccountResourceInsufficientException(String)}.
   *
   * <p>Method under test: {@link
   * AccountResourceInsufficientException#AccountResourceInsufficientException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountResourceInsufficientException.<init>(String)"})
  public void testNewAccountResourceInsufficientException() {
    // Arrange and Act
    AccountResourceInsufficientException actualAccountResourceInsufficientException =
        new AccountResourceInsufficientException("An error occurred");

    // Assert
    assertEquals(
        "An error occurred", actualAccountResourceInsufficientException.getLocalizedMessage());
    assertEquals("An error occurred", actualAccountResourceInsufficientException.getMessage());
    assertNull(actualAccountResourceInsufficientException.getCause());
    assertEquals(0, actualAccountResourceInsufficientException.getSuppressed().length);
  }
}
