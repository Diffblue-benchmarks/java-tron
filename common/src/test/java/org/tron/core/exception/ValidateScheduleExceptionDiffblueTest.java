package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ValidateScheduleExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ValidateScheduleException#ValidateScheduleException()}
   */
  @Test
  public void testNewValidateScheduleException() {
    // Arrange and Act
    ValidateScheduleException actualValidateScheduleException = new ValidateScheduleException();

    // Assert
    assertNull(actualValidateScheduleException.getLocalizedMessage());
    assertNull(actualValidateScheduleException.getMessage());
    assertNull(actualValidateScheduleException.getCause());
    assertEquals(0, actualValidateScheduleException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ValidateScheduleException#ValidateScheduleException(String)}
   */
  @Test
  public void testNewValidateScheduleException2() {
    // Arrange and Act
    ValidateScheduleException actualValidateScheduleException = new ValidateScheduleException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualValidateScheduleException.getLocalizedMessage());
    assertEquals("An error occurred", actualValidateScheduleException.getMessage());
    assertNull(actualValidateScheduleException.getCause());
    assertEquals(0, actualValidateScheduleException.getSuppressed().length);
  }
}
