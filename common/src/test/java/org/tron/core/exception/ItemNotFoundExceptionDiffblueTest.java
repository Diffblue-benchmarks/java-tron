package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ItemNotFoundExceptionDiffblueTest {
  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ItemNotFoundException#ItemNotFoundException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemNotFoundException.<init>()",
    "void ItemNotFoundException.<init>(String)",
    "void ItemNotFoundException.<init>(String, Throwable)"
  })
  public void testNewItemNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ItemNotFoundException actualItemNotFoundException =
        new ItemNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualItemNotFoundException.getMessage());
    assertNull(actualItemNotFoundException.getCause());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ItemNotFoundException#ItemNotFoundException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemNotFoundException.<init>()",
    "void ItemNotFoundException.<init>(String)",
    "void ItemNotFoundException.<init>(String, Throwable)"
  })
  public void testNewItemNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException();

    // Assert
    assertNull(actualItemNotFoundException.getMessage());
    assertNull(actualItemNotFoundException.getCause());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link ItemNotFoundException#ItemNotFoundException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ItemNotFoundException#ItemNotFoundException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemNotFoundException.<init>()",
    "void ItemNotFoundException.<init>(String)",
    "void ItemNotFoundException.<init>(String, Throwable)"
  })
  public void testNewItemNotFoundException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ItemNotFoundException actualItemNotFoundException =
        new ItemNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualItemNotFoundException.getMessage());
    assertEquals(0, actualItemNotFoundException.getSuppressed().length);
    assertSame(cause, actualItemNotFoundException.getCause());
  }
}
