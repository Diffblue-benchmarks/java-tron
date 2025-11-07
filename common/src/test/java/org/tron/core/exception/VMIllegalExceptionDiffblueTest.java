package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class VMIllegalExceptionDiffblueTest {
  /**
   * Method under test: {@link VMIllegalException#VMIllegalException()}
   */
  @Test
  public void testNewVMIllegalException() {
    // Arrange and Act
    VMIllegalException actualVmIllegalException = new VMIllegalException();

    // Assert
    assertNull(actualVmIllegalException.getLocalizedMessage());
    assertNull(actualVmIllegalException.getMessage());
    assertNull(actualVmIllegalException.getCause());
    assertEquals(0, actualVmIllegalException.getSuppressed().length);
  }

  /**
   * Method under test: {@link VMIllegalException#VMIllegalException(String)}
   */
  @Test
  public void testNewVMIllegalException2() {
    // Arrange and Act
    VMIllegalException actualVmIllegalException = new VMIllegalException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualVmIllegalException.getLocalizedMessage());
    assertEquals("An error occurred", actualVmIllegalException.getMessage());
    assertNull(actualVmIllegalException.getCause());
    assertEquals(0, actualVmIllegalException.getSuppressed().length);
  }
}
