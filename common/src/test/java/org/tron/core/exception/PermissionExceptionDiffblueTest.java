package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PermissionExceptionDiffblueTest {
  /**
   * Test {@link PermissionException#PermissionException()}.
   * <p>
   * Method under test: {@link PermissionException#PermissionException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PermissionException.<init>()"})
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
   * Test {@link PermissionException#PermissionException(String)}.
   * <p>
   * Method under test: {@link PermissionException#PermissionException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PermissionException.<init>(String)"})
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
