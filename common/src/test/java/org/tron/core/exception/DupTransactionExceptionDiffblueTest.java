package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DupTransactionExceptionDiffblueTest {
  /**
   * Test {@link DupTransactionException#DupTransactionException()}.
   * <p>
   * Method under test: {@link DupTransactionException#DupTransactionException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DupTransactionException.<init>()"})
  public void testNewDupTransactionException() {
    // Arrange and Act
    DupTransactionException actualDupTransactionException = new DupTransactionException();

    // Assert
    assertNull(actualDupTransactionException.getLocalizedMessage());
    assertNull(actualDupTransactionException.getMessage());
    assertNull(actualDupTransactionException.getCause());
    assertEquals(0, actualDupTransactionException.getSuppressed().length);
  }

  /**
   * Test {@link DupTransactionException#DupTransactionException(String)}.
   * <p>
   * Method under test: {@link DupTransactionException#DupTransactionException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DupTransactionException.<init>(String)"})
  public void testNewDupTransactionException2() {
    // Arrange and Act
    DupTransactionException actualDupTransactionException = new DupTransactionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDupTransactionException.getLocalizedMessage());
    assertEquals("An error occurred", actualDupTransactionException.getMessage());
    assertNull(actualDupTransactionException.getCause());
    assertEquals(0, actualDupTransactionException.getSuppressed().length);
  }
}
