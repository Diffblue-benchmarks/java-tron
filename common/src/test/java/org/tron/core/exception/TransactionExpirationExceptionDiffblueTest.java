package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TransactionExpirationExceptionDiffblueTest {
  /**
   * Test {@link TransactionExpirationException#TransactionExpirationException()}.
   *
   * <p>Method under test: {@link TransactionExpirationException#TransactionExpirationException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionExpirationException.<init>()"})
  public void testNewTransactionExpirationException() {
    // Arrange and Act
    TransactionExpirationException actualTransactionExpirationException =
        new TransactionExpirationException();

    // Assert
    assertNull(actualTransactionExpirationException.getLocalizedMessage());
    assertNull(actualTransactionExpirationException.getMessage());
    assertNull(actualTransactionExpirationException.getCause());
    assertEquals(0, actualTransactionExpirationException.getSuppressed().length);
  }

  /**
   * Test {@link TransactionExpirationException#TransactionExpirationException(String)}.
   *
   * <p>Method under test: {@link
   * TransactionExpirationException#TransactionExpirationException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionExpirationException.<init>(String)"})
  public void testNewTransactionExpirationException2() {
    // Arrange and Act
    TransactionExpirationException actualTransactionExpirationException =
        new TransactionExpirationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTransactionExpirationException.getLocalizedMessage());
    assertEquals("An error occurred", actualTransactionExpirationException.getMessage());
    assertNull(actualTransactionExpirationException.getCause());
    assertEquals(0, actualTransactionExpirationException.getSuppressed().length);
  }
}
