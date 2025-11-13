package org.tron.common.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TronDBExceptionDiffblueTest {
  /**
   * Test {@link TronDBException#TronDBException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TronDBException#TronDBException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronDBException.<init>()",
    "void TronDBException.<init>(String)",
    "void TronDBException.<init>(String, Throwable)",
    "void TronDBException.<init>(Throwable)"
  })
  public void testNewTronDBException_thenReturnMessageIsNull() {
    // Arrange and Act
    TronDBException actualTronDBException = new TronDBException();

    // Assert
    assertNull(actualTronDBException.getMessage());
    assertNull(actualTronDBException.getCause());
    assertEquals(0, actualTronDBException.getSuppressed().length);
  }

  /**
   * Test {@link TronDBException#TronDBException(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Message is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TronDBException#TronDBException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronDBException.<init>()",
    "void TronDBException.<init>(String)",
    "void TronDBException.<init>(String, Throwable)",
    "void TronDBException.<init>(Throwable)"
  })
  public void testNewTronDBException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    TronDBException actualTronDBException = new TronDBException("foo");

    // Assert
    assertEquals("foo", actualTronDBException.getMessage());
    assertNull(actualTronDBException.getCause());
    assertEquals(0, actualTronDBException.getSuppressed().length);
  }

  /**
   * Test {@link TronDBException#TronDBException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Message is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TronDBException#TronDBException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronDBException.<init>()",
    "void TronDBException.<init>(String)",
    "void TronDBException.<init>(String, Throwable)",
    "void TronDBException.<init>(Throwable)"
  })
  public void testNewTronDBException_whenFoo_thenReturnMessageIsFoo2() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    TronDBException actualTronDBException = new TronDBException("foo", throwable);

    // Assert
    assertEquals("foo", actualTronDBException.getMessage());
    assertEquals(0, actualTronDBException.getSuppressed().length);
    assertSame(throwable, actualTronDBException.getCause());
  }

  /**
   * Test {@link TronDBException#TronDBException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link TronDBException#TronDBException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TronDBException.<init>()",
    "void TronDBException.<init>(String)",
    "void TronDBException.<init>(String, Throwable)",
    "void TronDBException.<init>(Throwable)"
  })
  public void testNewTronDBException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    TronDBException actualTronDBException = new TronDBException(throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualTronDBException.getMessage());
    assertEquals(0, actualTronDBException.getSuppressed().length);
    assertSame(throwable, actualTronDBException.getCause());
  }
}
