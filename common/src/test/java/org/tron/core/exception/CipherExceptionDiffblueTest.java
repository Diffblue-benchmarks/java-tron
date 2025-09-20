package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CipherExceptionDiffblueTest {
  /**
   * Test {@link CipherException#CipherException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CipherException#CipherException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CipherException.<init>(String)",
    "void CipherException.<init>(String, Throwable)",
    "void CipherException.<init>(Throwable)"
  })
  public void testNewCipherException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    CipherException actualCipherException = new CipherException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCipherException.getMessage());
    assertNull(actualCipherException.getCause());
    assertEquals(0, actualCipherException.getSuppressed().length);
  }

  /**
   * Test {@link CipherException#CipherException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link CipherException#CipherException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CipherException.<init>(String)",
    "void CipherException.<init>(String, Throwable)",
    "void CipherException.<init>(Throwable)"
  })
  public void testNewCipherException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CipherException actualCipherException = new CipherException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCipherException.getMessage());
    assertEquals(0, actualCipherException.getSuppressed().length);
    assertSame(cause, actualCipherException.getCause());
  }

  /**
   * Test {@link CipherException#CipherException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link CipherException#CipherException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CipherException.<init>(String)",
    "void CipherException.<init>(String, Throwable)",
    "void CipherException.<init>(Throwable)"
  })
  public void testNewCipherException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CipherException actualCipherException = new CipherException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCipherException.getMessage());
    assertEquals(0, actualCipherException.getSuppressed().length);
    assertSame(cause, actualCipherException.getCause());
  }
}
