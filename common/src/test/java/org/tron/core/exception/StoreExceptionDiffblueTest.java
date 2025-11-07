package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class StoreExceptionDiffblueTest {
  /**
   * Method under test: {@link StoreException#StoreException()}
   */
  @Test
  public void testNewStoreException() {
    // Arrange and Act
    StoreException actualStoreException = new StoreException();

    // Assert
    assertNull(actualStoreException.getMessage());
    assertNull(actualStoreException.getCause());
    assertEquals(0, actualStoreException.getSuppressed().length);
  }

  /**
   * Method under test: {@link StoreException#StoreException(String)}
   */
  @Test
  public void testNewStoreException2() {
    // Arrange and Act
    StoreException actualStoreException = new StoreException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualStoreException.getMessage());
    assertNull(actualStoreException.getCause());
    assertEquals(0, actualStoreException.getSuppressed().length);
  }

  /**
   * Method under test: {@link StoreException#StoreException(String, Throwable)}
   */
  @Test
  public void testNewStoreException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    StoreException actualStoreException = new StoreException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualStoreException.getMessage());
    assertEquals(0, actualStoreException.getSuppressed().length);
    assertSame(cause, actualStoreException.getCause());
  }

  /**
   * Method under test: {@link StoreException#StoreException(Throwable)}
   */
  @Test
  public void testNewStoreException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    StoreException actualStoreException = new StoreException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualStoreException.getMessage());
    assertEquals(0, actualStoreException.getSuppressed().length);
    assertSame(cause, actualStoreException.getCause());
  }
}
