package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VMIllegalExceptionDiffblueTest {
  /**
   * Test {@link VMIllegalException#VMIllegalException()}.
   *
   * <p>Method under test: {@link VMIllegalException#VMIllegalException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VMIllegalException.<init>()"})
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
   * Test {@link VMIllegalException#VMIllegalException(String)}.
   *
   * <p>Method under test: {@link VMIllegalException#VMIllegalException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VMIllegalException.<init>(String)"})
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
