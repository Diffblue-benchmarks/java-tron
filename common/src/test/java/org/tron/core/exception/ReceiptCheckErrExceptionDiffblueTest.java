package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReceiptCheckErrExceptionDiffblueTest {
  /**
   * Test {@link ReceiptCheckErrException#ReceiptCheckErrException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCheckErrException#ReceiptCheckErrException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReceiptCheckErrException.<init>()",
    "void ReceiptCheckErrException.<init>(String)",
    "void ReceiptCheckErrException.<init>(String, Throwable)"
  })
  public void testNewReceiptCheckErrException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ReceiptCheckErrException actualReceiptCheckErrException =
        new ReceiptCheckErrException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualReceiptCheckErrException.getMessage());
    assertNull(actualReceiptCheckErrException.getCause());
    assertEquals(0, actualReceiptCheckErrException.getSuppressed().length);
  }

  /**
   * Test {@link ReceiptCheckErrException#ReceiptCheckErrException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCheckErrException#ReceiptCheckErrException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReceiptCheckErrException.<init>()",
    "void ReceiptCheckErrException.<init>(String)",
    "void ReceiptCheckErrException.<init>(String, Throwable)"
  })
  public void testNewReceiptCheckErrException_thenReturnMessageIsNull() {
    // Arrange and Act
    ReceiptCheckErrException actualReceiptCheckErrException = new ReceiptCheckErrException();

    // Assert
    assertNull(actualReceiptCheckErrException.getMessage());
    assertNull(actualReceiptCheckErrException.getCause());
    assertEquals(0, actualReceiptCheckErrException.getSuppressed().length);
  }

  /**
   * Test {@link ReceiptCheckErrException#ReceiptCheckErrException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCheckErrException#ReceiptCheckErrException(String,
   * Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReceiptCheckErrException.<init>()",
    "void ReceiptCheckErrException.<init>(String)",
    "void ReceiptCheckErrException.<init>(String, Throwable)"
  })
  public void testNewReceiptCheckErrException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ReceiptCheckErrException actualReceiptCheckErrException =
        new ReceiptCheckErrException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualReceiptCheckErrException.getMessage());
    assertEquals(0, actualReceiptCheckErrException.getSuppressed().length);
    assertSame(cause, actualReceiptCheckErrException.getCause());
  }
}
