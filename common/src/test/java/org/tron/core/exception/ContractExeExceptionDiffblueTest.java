package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractExeExceptionDiffblueTest {
  /**
   * Test {@link ContractExeException#ContractExeException()}.
   *
   * <p>Method under test: {@link ContractExeException#ContractExeException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractExeException.<init>()"})
  public void testNewContractExeException() {
    // Arrange and Act
    ContractExeException actualContractExeException = new ContractExeException();

    // Assert
    assertNull(actualContractExeException.getLocalizedMessage());
    assertNull(actualContractExeException.getMessage());
    assertNull(actualContractExeException.getCause());
    assertEquals(0, actualContractExeException.getSuppressed().length);
  }

  /**
   * Test {@link ContractExeException#ContractExeException(String)}.
   *
   * <p>Method under test: {@link ContractExeException#ContractExeException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractExeException.<init>(String)"})
  public void testNewContractExeException2() {
    // Arrange and Act
    ContractExeException actualContractExeException = new ContractExeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualContractExeException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractExeException.getMessage());
    assertNull(actualContractExeException.getCause());
    assertEquals(0, actualContractExeException.getSuppressed().length);
  }
}
