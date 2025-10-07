package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CancelExceptionDiffblueTest {
  /**
   * Test {@link CancelException#CancelException()}.
   *
   * <p>Method under test: {@link CancelException#CancelException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CancelException.<init>()"})
  public void testNewCancelException() {
    // Arrange and Act
    CancelException actualCancelException = new CancelException();

    // Assert
    assertNull(actualCancelException.getLocalizedMessage());
    assertNull(actualCancelException.getMessage());
    assertNull(actualCancelException.getCause());
    assertEquals(0, actualCancelException.getSuppressed().length);
  }

  /**
   * Test {@link CancelException#CancelException(String)}.
   *
   * <p>Method under test: {@link CancelException#CancelException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CancelException.<init>(String)"})
  public void testNewCancelException2() {
    // Arrange and Act
    CancelException actualCancelException = new CancelException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCancelException.getLocalizedMessage());
    assertEquals("An error occurred", actualCancelException.getMessage());
    assertNull(actualCancelException.getCause());
    assertEquals(0, actualCancelException.getSuppressed().length);
  }
}
