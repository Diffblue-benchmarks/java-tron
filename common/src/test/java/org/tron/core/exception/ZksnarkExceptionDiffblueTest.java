package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ZksnarkExceptionDiffblueTest {
  /**
   * Method under test: {@link ZksnarkException#ZksnarkException()}
   */
  @Test
  public void testNewZksnarkException() {
    // Arrange and Act
    ZksnarkException actualZksnarkException = new ZksnarkException();

    // Assert
    assertNull(actualZksnarkException.getLocalizedMessage());
    assertNull(actualZksnarkException.getMessage());
    assertNull(actualZksnarkException.getCause());
    assertEquals(0, actualZksnarkException.getSuppressed().length);
  }

  /**
   * Method under test: {@link ZksnarkException#ZksnarkException(String)}
   */
  @Test
  public void testNewZksnarkException2() {
    // Arrange and Act
    ZksnarkException actualZksnarkException = new ZksnarkException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualZksnarkException.getLocalizedMessage());
    assertEquals("An error occurred", actualZksnarkException.getMessage());
    assertNull(actualZksnarkException.getCause());
    assertEquals(0, actualZksnarkException.getSuppressed().length);
  }
}
