package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ContractValidateExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ContractValidateException#ContractValidateException()}
   */
  @Test
  public void testNewContractValidateException() {
    // Arrange and Act
    ContractValidateException actualContractValidateException = new ContractValidateException();

    // Assert
    assertNull(actualContractValidateException.getLocalizedMessage());
    assertNull(actualContractValidateException.getMessage());
    assertNull(actualContractValidateException.getCause());
    assertEquals(0, actualContractValidateException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ContractValidateException#ContractValidateException(String)}
   */
  @Test
  public void testNewContractValidateException2() {
    // Arrange and Act
    ContractValidateException actualContractValidateException = new ContractValidateException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualContractValidateException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateException.getMessage());
    assertNull(actualContractValidateException.getCause());
    assertEquals(0, actualContractValidateException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ContractValidateException#ContractValidateException(String, Throwable)}
   */
  @Test
  public void testNewContractValidateException3() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    ContractValidateException actualContractValidateException = new ContractValidateException("An error occurred",
        throwable);

    // Assert
    assertEquals("An error occurred", actualContractValidateException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateException.getMessage());
    assertEquals(0, actualContractValidateException.getSuppressed().length);
    assertSame(throwable, actualContractValidateException.getCause());
  }
}
