package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BadNumberBlockExceptionDiffblueTest {
  /**
   * Test {@link BadNumberBlockException#BadNumberBlockException()}.
   *
   * <p>Method under test: {@link BadNumberBlockException#BadNumberBlockException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BadNumberBlockException.<init>()"})
  public void testNewBadNumberBlockException() {
    // Arrange and Act
    BadNumberBlockException actualBadNumberBlockException = new BadNumberBlockException();

    // Assert
    assertNull(actualBadNumberBlockException.getLocalizedMessage());
    assertNull(actualBadNumberBlockException.getMessage());
    assertNull(actualBadNumberBlockException.getCause());
    assertEquals(0, actualBadNumberBlockException.getSuppressed().length);
  }

  /**
   * Test {@link BadNumberBlockException#BadNumberBlockException(String)}.
   *
   * <p>Method under test: {@link BadNumberBlockException#BadNumberBlockException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BadNumberBlockException.<init>(String)"})
  public void testNewBadNumberBlockException2() {
    // Arrange and Act
    BadNumberBlockException actualBadNumberBlockException =
        new BadNumberBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadNumberBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadNumberBlockException.getMessage());
    assertNull(actualBadNumberBlockException.getCause());
    assertEquals(0, actualBadNumberBlockException.getSuppressed().length);
  }
}
