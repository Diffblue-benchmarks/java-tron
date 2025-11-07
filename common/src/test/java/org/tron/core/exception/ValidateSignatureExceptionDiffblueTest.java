package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ValidateSignatureExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ValidateSignatureException#ValidateSignatureException()}
   */
  @Test
  public void testNewValidateSignatureException() {
    // Arrange and Act
    ValidateSignatureException actualValidateSignatureException = new ValidateSignatureException();

    // Assert
    assertNull(actualValidateSignatureException.getLocalizedMessage());
    assertNull(actualValidateSignatureException.getMessage());
    assertNull(actualValidateSignatureException.getCause());
    assertEquals(0, actualValidateSignatureException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ValidateSignatureException#ValidateSignatureException(String)}
   */
  @Test
  public void testNewValidateSignatureException2() {
    // Arrange and Act
    ValidateSignatureException actualValidateSignatureException = new ValidateSignatureException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualValidateSignatureException.getLocalizedMessage());
    assertEquals("An error occurred", actualValidateSignatureException.getMessage());
    assertNull(actualValidateSignatureException.getCause());
    assertEquals(0, actualValidateSignatureException.getSuppressed().length);
  }
}
