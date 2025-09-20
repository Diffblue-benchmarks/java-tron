package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BalanceInsufficientExceptionDiffblueTest {
  /**
   * Test {@link BalanceInsufficientException#BalanceInsufficientException()}.
   *
   * <p>Method under test: {@link BalanceInsufficientException#BalanceInsufficientException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BalanceInsufficientException.<init>()"})
  public void testNewBalanceInsufficientException() {
    // Arrange and Act
    BalanceInsufficientException actualBalanceInsufficientException =
        new BalanceInsufficientException();

    // Assert
    assertNull(actualBalanceInsufficientException.getLocalizedMessage());
    assertNull(actualBalanceInsufficientException.getMessage());
    assertNull(actualBalanceInsufficientException.getCause());
    assertEquals(0, actualBalanceInsufficientException.getSuppressed().length);
  }

  /**
   * Test {@link BalanceInsufficientException#BalanceInsufficientException(String)}.
   *
   * <p>Method under test: {@link BalanceInsufficientException#BalanceInsufficientException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BalanceInsufficientException.<init>(String)"})
  public void testNewBalanceInsufficientException2() {
    // Arrange and Act
    BalanceInsufficientException actualBalanceInsufficientException =
        new BalanceInsufficientException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBalanceInsufficientException.getLocalizedMessage());
    assertEquals("An error occurred", actualBalanceInsufficientException.getMessage());
    assertNull(actualBalanceInsufficientException.getCause());
    assertEquals(0, actualBalanceInsufficientException.getSuppressed().length);
  }
}
