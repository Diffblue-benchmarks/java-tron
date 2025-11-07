package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SignatureFormatExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link SignatureFormatException#SignatureFormatException()}
   */
  @Test
  public void testNewSignatureFormatException() {
    // Arrange and Act
    SignatureFormatException actualSignatureFormatException = new SignatureFormatException();

    // Assert
    assertNull(actualSignatureFormatException.getLocalizedMessage());
    assertNull(actualSignatureFormatException.getMessage());
    assertNull(actualSignatureFormatException.getCause());
    assertEquals(0, actualSignatureFormatException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link SignatureFormatException#SignatureFormatException(String)}
   */
  @Test
  public void testNewSignatureFormatException2() {
    // Arrange and Act
    SignatureFormatException actualSignatureFormatException = new SignatureFormatException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSignatureFormatException.getLocalizedMessage());
    assertEquals("An error occurred", actualSignatureFormatException.getMessage());
    assertNull(actualSignatureFormatException.getCause());
    assertEquals(0, actualSignatureFormatException.getSuppressed().length);
  }
}
