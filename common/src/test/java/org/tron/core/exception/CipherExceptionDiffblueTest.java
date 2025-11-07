package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CipherExceptionDiffblueTest {
  /**
   * Method under test: {@link CipherException#CipherException(String)}
   */
  @Test
  public void testNewCipherException() {
    // Arrange and Act
    CipherException actualCipherException = new CipherException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCipherException.getMessage());
    assertNull(actualCipherException.getCause());
    assertEquals(0, actualCipherException.getSuppressed().length);
  }

  /**
   * Method under test: {@link CipherException#CipherException(String, Throwable)}
   */
  @Test
  public void testNewCipherException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CipherException actualCipherException = new CipherException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCipherException.getMessage());
    assertEquals(0, actualCipherException.getSuppressed().length);
    assertSame(cause, actualCipherException.getCause());
  }

  /**
   * Method under test: {@link CipherException#CipherException(Throwable)}
   */
  @Test
  public void testNewCipherException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CipherException actualCipherException = new CipherException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCipherException.getMessage());
    assertEquals(0, actualCipherException.getSuppressed().length);
    assertSame(cause, actualCipherException.getCause());
  }
}
