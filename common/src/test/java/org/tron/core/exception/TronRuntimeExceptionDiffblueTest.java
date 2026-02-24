package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TronRuntimeExceptionDiffblueTest {
  /**
   * Test {@link TronRuntimeException#TronRuntimeException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TronRuntimeException#TronRuntimeException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronRuntimeException.<init>()",
    "void TronRuntimeException.<init>(String)",
    "void TronRuntimeException.<init>(String, Throwable)",
    "void TronRuntimeException.<init>(String, Throwable, boolean, boolean)",
    "void TronRuntimeException.<init>(Throwable)"
  })
  public void testNewTronRuntimeException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronRuntimeException actualTronRuntimeException =
        new TronRuntimeException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTronRuntimeException.getMessage());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
    assertSame(cause, actualTronRuntimeException.getCause());
  }

  /**
   * Test {@link TronRuntimeException#TronRuntimeException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TronRuntimeException#TronRuntimeException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronRuntimeException.<init>()",
    "void TronRuntimeException.<init>(String)",
    "void TronRuntimeException.<init>(String, Throwable)",
    "void TronRuntimeException.<init>(String, Throwable, boolean, boolean)",
    "void TronRuntimeException.<init>(Throwable)"
  })
  public void testNewTronRuntimeException_thenReturnMessageIsNull() {
    // Arrange and Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException();

    // Assert
    assertNull(actualTronRuntimeException.getMessage());
    assertNull(actualTronRuntimeException.getCause());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
  }

  /**
   * Test {@link TronRuntimeException#TronRuntimeException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TronRuntimeException#TronRuntimeException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronRuntimeException.<init>()",
    "void TronRuntimeException.<init>(String)",
    "void TronRuntimeException.<init>(String, Throwable)",
    "void TronRuntimeException.<init>(String, Throwable, boolean, boolean)",
    "void TronRuntimeException.<init>(Throwable)"
  })
  public void testNewTronRuntimeException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTronRuntimeException.getMessage());
    assertNull(actualTronRuntimeException.getCause());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
  }

  /**
   * Test {@link TronRuntimeException#TronRuntimeException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link TronRuntimeException#TronRuntimeException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronRuntimeException.<init>()",
    "void TronRuntimeException.<init>(String)",
    "void TronRuntimeException.<init>(String, Throwable)",
    "void TronRuntimeException.<init>(String, Throwable, boolean, boolean)",
    "void TronRuntimeException.<init>(Throwable)"
  })
  public void testNewTronRuntimeException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronRuntimeException actualTronRuntimeException = new TronRuntimeException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTronRuntimeException.getMessage());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
    assertSame(cause, actualTronRuntimeException.getCause());
  }

  /**
   * Test {@link TronRuntimeException#TronRuntimeException(String, Throwable, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TronRuntimeException#TronRuntimeException(String, Throwable,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronRuntimeException.<init>()",
    "void TronRuntimeException.<init>(String)",
    "void TronRuntimeException.<init>(String, Throwable)",
    "void TronRuntimeException.<init>(String, Throwable, boolean, boolean)",
    "void TronRuntimeException.<init>(Throwable)"
  })
  public void testNewTronRuntimeException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TronRuntimeException actualTronRuntimeException =
        new TronRuntimeException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualTronRuntimeException.getMessage());
    assertEquals(0, actualTronRuntimeException.getSuppressed().length);
    assertSame(cause, actualTronRuntimeException.getCause());
  }
}
