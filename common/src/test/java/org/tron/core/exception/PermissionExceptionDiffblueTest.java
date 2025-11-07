package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PermissionExceptionDiffblueTest {
  /**
   * Method under test: {@link PermissionException#PermissionException()}
   */
  @Test
  public void testNewPermissionException() {
    // Arrange and Act
    PermissionException actualPermissionException = new PermissionException();

    // Assert
    assertNull(actualPermissionException.getLocalizedMessage());
    assertNull(actualPermissionException.getMessage());
    assertNull(actualPermissionException.getCause());
    assertEquals(0, actualPermissionException.getSuppressed().length);
  }

  /**
   * Method under test: {@link PermissionException#PermissionException(String)}
   */
  @Test
  public void testNewPermissionException2() {
    // Arrange and Act
    PermissionException actualPermissionException = new PermissionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualPermissionException.getLocalizedMessage());
    assertEquals("An error occurred", actualPermissionException.getMessage());
    assertNull(actualPermissionException.getCause());
    assertEquals(0, actualPermissionException.getSuppressed().length);
  }
}
