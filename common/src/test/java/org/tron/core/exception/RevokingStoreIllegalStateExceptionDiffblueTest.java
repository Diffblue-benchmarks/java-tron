package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class RevokingStoreIllegalStateExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException()}
   */
  @Test
  public void testNewRevokingStoreIllegalStateException() {
    // Arrange and Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException = new RevokingStoreIllegalStateException();

    // Assert
    assertNull(actualRevokingStoreIllegalStateException.getMessage());
    assertNull(actualRevokingStoreIllegalStateException.getCause());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(String)}
   */
  @Test
  public void testNewRevokingStoreIllegalStateException2() {
    // Arrange and Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException = new RevokingStoreIllegalStateException(
        "foo");

    // Assert
    assertEquals("foo", actualRevokingStoreIllegalStateException.getMessage());
    assertNull(actualRevokingStoreIllegalStateException.getCause());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(String, Throwable)}
   */
  @Test
  public void testNewRevokingStoreIllegalStateException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException = new RevokingStoreIllegalStateException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRevokingStoreIllegalStateException.getMessage());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
    assertSame(cause, actualRevokingStoreIllegalStateException.getCause());
  }

  /**
   * Method under test:
   * {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(Throwable)}
   */
  @Test
  public void testNewRevokingStoreIllegalStateException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException = new RevokingStoreIllegalStateException(
        cause);

    // Assert
    assertEquals("", actualRevokingStoreIllegalStateException.getMessage());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
    assertSame(cause, actualRevokingStoreIllegalStateException.getCause());
  }

  /**
   * Method under test:
   * {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(int)}
   */
  @Test
  public void testNewRevokingStoreIllegalStateException5() {
    // Arrange and Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException = new RevokingStoreIllegalStateException(
        1);

    // Assert
    assertEquals("activeSession 1 has to be greater than 0",
        actualRevokingStoreIllegalStateException.getLocalizedMessage());
    assertEquals("activeSession 1 has to be greater than 0", actualRevokingStoreIllegalStateException.getMessage());
    assertNull(actualRevokingStoreIllegalStateException.getCause());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
  }
}
