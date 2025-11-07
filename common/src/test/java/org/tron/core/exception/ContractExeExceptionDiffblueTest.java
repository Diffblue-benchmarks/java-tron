package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ContractExeExceptionDiffblueTest {
  /**
   * Method under test: {@link ContractExeException#ContractExeException()}
   */
  @Test
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
   * Method under test: {@link ContractExeException#ContractExeException(String)}
   */
  @Test
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
