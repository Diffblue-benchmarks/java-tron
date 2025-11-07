package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TaposExceptionDiffblueTest {
  /**
   * Method under test: {@link TaposException#TaposException()}
   */
  @Test
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
   * Method under test: {@link TaposException#TaposException(String)}
   */
  @Test
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
   * Method under test: {@link TaposException#TaposException(String, Throwable)}
   */
  @Test
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
