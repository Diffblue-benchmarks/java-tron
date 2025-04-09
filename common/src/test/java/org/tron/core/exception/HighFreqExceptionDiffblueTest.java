package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HighFreqExceptionDiffblueTest {
  /**
   * Test {@link HighFreqException#HighFreqException()}.
   * <p>
   * Method under test: {@link HighFreqException#HighFreqException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HighFreqException.<init>()"})
  public void testNewHighFreqException() {
    // Arrange and Act
    HighFreqException actualHighFreqException = new HighFreqException();

    // Assert
    assertNull(actualHighFreqException.getLocalizedMessage());
    assertNull(actualHighFreqException.getMessage());
    assertNull(actualHighFreqException.getCause());
    assertEquals(0, actualHighFreqException.getSuppressed().length);
  }

  /**
   * Test {@link HighFreqException#HighFreqException(String)}.
   * <p>
   * Method under test: {@link HighFreqException#HighFreqException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HighFreqException.<init>(String)"})
  public void testNewHighFreqException2() {
    // Arrange and Act
    HighFreqException actualHighFreqException = new HighFreqException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualHighFreqException.getLocalizedMessage());
    assertEquals("An error occurred", actualHighFreqException.getMessage());
    assertNull(actualHighFreqException.getCause());
    assertEquals(0, actualHighFreqException.getSuppressed().length);
  }
}
