package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TaposExceptionDiffblueTest {
  /**
   * Test {@link TaposException#TaposException()}.
   * <p>
   * Method under test: {@link TaposException#TaposException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaposException.<init>()"})
  public void testNewTaposException() {
    // Arrange and Act
    TaposException actualTaposException = new TaposException();

    // Assert
    assertNull(actualTaposException.getLocalizedMessage());
    assertNull(actualTaposException.getMessage());
    assertNull(actualTaposException.getCause());
    assertEquals(0, actualTaposException.getSuppressed().length);
  }

  /**
   * Test {@link TaposException#TaposException(String)}.
   * <p>
   * Method under test: {@link TaposException#TaposException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaposException.<init>(String)"})
  public void testNewTaposException2() {
    // Arrange and Act
    TaposException actualTaposException = new TaposException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTaposException.getLocalizedMessage());
    assertEquals("An error occurred", actualTaposException.getMessage());
    assertNull(actualTaposException.getCause());
    assertEquals(0, actualTaposException.getSuppressed().length);
  }

  /**
   * Test {@link TaposException#TaposException(String, Throwable)}.
   * <p>
   * Method under test: {@link TaposException#TaposException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaposException.<init>(String, Throwable)"})
  public void testNewTaposException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaposException actualTaposException = new TaposException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTaposException.getLocalizedMessage());
    assertEquals("An error occurred", actualTaposException.getMessage());
    assertEquals(0, actualTaposException.getSuppressed().length);
    assertSame(cause, actualTaposException.getCause());
  }
}
