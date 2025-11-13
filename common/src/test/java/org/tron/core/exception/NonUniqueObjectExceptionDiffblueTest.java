package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NonUniqueObjectExceptionDiffblueTest {
  /**
   * Test {@link NonUniqueObjectException#NonUniqueObjectException()}.
   *
   * <p>Method under test: {@link NonUniqueObjectException#NonUniqueObjectException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonUniqueObjectException.<init>()"})
  public void testNewNonUniqueObjectException() {
    // Arrange and Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException();

    // Assert
    assertNull(actualNonUniqueObjectException.getLocalizedMessage());
    assertNull(actualNonUniqueObjectException.getMessage());
    assertNull(actualNonUniqueObjectException.getCause());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
  }

  /**
   * Test {@link NonUniqueObjectException#NonUniqueObjectException(String)}.
   *
   * <p>Method under test: {@link NonUniqueObjectException#NonUniqueObjectException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonUniqueObjectException.<init>(String)"})
  public void testNewNonUniqueObjectException2() {
    // Arrange and Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException("foo");

    // Assert
    assertEquals("foo", actualNonUniqueObjectException.getLocalizedMessage());
    assertEquals("foo", actualNonUniqueObjectException.getMessage());
    assertNull(actualNonUniqueObjectException.getCause());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
  }

  /**
   * Test {@link NonUniqueObjectException#NonUniqueObjectException(String, Throwable)}.
   *
   * <p>Method under test: {@link NonUniqueObjectException#NonUniqueObjectException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonUniqueObjectException.<init>(String, Throwable)"})
  public void testNewNonUniqueObjectException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NonUniqueObjectException actualNonUniqueObjectException =
        new NonUniqueObjectException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNonUniqueObjectException.getLocalizedMessage());
    assertEquals("An error occurred", actualNonUniqueObjectException.getMessage());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
    assertSame(cause, actualNonUniqueObjectException.getCause());
  }

  /**
   * Test {@link NonUniqueObjectException#NonUniqueObjectException(Throwable)}.
   *
   * <p>Method under test: {@link NonUniqueObjectException#NonUniqueObjectException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonUniqueObjectException.<init>(Throwable)"})
  public void testNewNonUniqueObjectException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NonUniqueObjectException actualNonUniqueObjectException = new NonUniqueObjectException(cause);

    // Assert
    assertEquals("", actualNonUniqueObjectException.getLocalizedMessage());
    assertEquals("", actualNonUniqueObjectException.getMessage());
    assertEquals(0, actualNonUniqueObjectException.getSuppressed().length);
    assertSame(cause, actualNonUniqueObjectException.getCause());
  }
}
