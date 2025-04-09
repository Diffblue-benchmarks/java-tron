package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValidateScheduleExceptionDiffblueTest {
  /**
   * Test {@link ValidateScheduleException#ValidateScheduleException()}.
   * <p>
   * Method under test: {@link ValidateScheduleException#ValidateScheduleException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateScheduleException.<init>()"})
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
   * Test {@link ValidateScheduleException#ValidateScheduleException(String)}.
   * <p>
   * Method under test: {@link ValidateScheduleException#ValidateScheduleException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateScheduleException.<init>(String)"})
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
