package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ContractSizeNotEqualToOneExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ContractSizeNotEqualToOneException#ContractSizeNotEqualToOneException()}
   */
  @Test
  public void testNewContractSizeNotEqualToOneException() {
    // Arrange and Act
    ContractSizeNotEqualToOneException actualContractSizeNotEqualToOneException = new ContractSizeNotEqualToOneException();

    // Assert
    assertNull(actualContractSizeNotEqualToOneException.getLocalizedMessage());
    assertNull(actualContractSizeNotEqualToOneException.getMessage());
    assertNull(actualContractSizeNotEqualToOneException.getCause());
    assertEquals(0, actualContractSizeNotEqualToOneException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ContractSizeNotEqualToOneException#ContractSizeNotEqualToOneException(String)}
   */
  @Test
  public void testNewContractSizeNotEqualToOneException2() {
    // Arrange and Act
    ContractSizeNotEqualToOneException actualContractSizeNotEqualToOneException = new ContractSizeNotEqualToOneException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualContractSizeNotEqualToOneException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractSizeNotEqualToOneException.getMessage());
    assertNull(actualContractSizeNotEqualToOneException.getCause());
    assertEquals(0, actualContractSizeNotEqualToOneException.getSuppressed().length);
  }
}
