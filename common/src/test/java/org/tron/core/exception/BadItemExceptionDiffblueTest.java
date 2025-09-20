package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BadItemExceptionDiffblueTest {
  /**
   * Test {@link BadItemException#BadItemException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BadItemException#BadItemException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BadItemException.<init>()",
    "void BadItemException.<init>(String)",
    "void BadItemException.<init>(String, Throwable)"
  })
  public void testNewBadItemException_thenReturnMessageIsNull() {
    // Arrange and Act
    BadItemException actualBadItemException = new BadItemException();

    // Assert
    assertNull(actualBadItemException.getMessage());
    assertNull(actualBadItemException.getCause());
    assertEquals(0, actualBadItemException.getSuppressed().length);
  }

  /**
   * Test {@link BadItemException#BadItemException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BadItemException#BadItemException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BadItemException.<init>()",
    "void BadItemException.<init>(String)",
    "void BadItemException.<init>(String, Throwable)"
  })
  public void testNewBadItemException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    BadItemException actualBadItemException = new BadItemException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadItemException.getMessage());
    assertNull(actualBadItemException.getCause());
    assertEquals(0, actualBadItemException.getSuppressed().length);
  }

  /**
   * Test {@link BadItemException#BadItemException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link BadItemException#BadItemException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BadItemException.<init>()",
    "void BadItemException.<init>(String)",
    "void BadItemException.<init>(String, Throwable)"
  })
  public void testNewBadItemException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    BadItemException actualBadItemException = new BadItemException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualBadItemException.getMessage());
    assertEquals(0, actualBadItemException.getSuppressed().length);
    assertSame(cause, actualBadItemException.getCause());
  }
}
