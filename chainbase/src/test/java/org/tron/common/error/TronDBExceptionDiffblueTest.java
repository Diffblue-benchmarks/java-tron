package org.tron.common.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TronDBExceptionDiffblueTest {
  /**
   * Method under test: {@link TronDBException#TronDBException()}
   */
  @Test
  public void testNewTronDBException() {
    // Arrange and Act
    TronDBException actualTronDBException = new TronDBException();

    // Assert
    assertNull(actualTronDBException.getMessage());
    assertNull(actualTronDBException.getCause());
    assertEquals(0, actualTronDBException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TronDBException#TronDBException(String)}
   */
  @Test
  public void testNewTronDBException2() {
    // Arrange and Act
    TronDBException actualTronDBException = new TronDBException("foo");

    // Assert
    assertEquals("foo", actualTronDBException.getMessage());
    assertNull(actualTronDBException.getCause());
    assertEquals(0, actualTronDBException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TronDBException#TronDBException(String, Throwable)}
   */
  @Test
  public void testNewTronDBException3() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    TronDBException actualTronDBException = new TronDBException("foo", throwable);

    // Assert
    assertEquals("foo", actualTronDBException.getMessage());
    assertEquals(0, actualTronDBException.getSuppressed().length);
    assertSame(throwable, actualTronDBException.getCause());
  }

  /**
   * Method under test: {@link TronDBException#TronDBException(Throwable)}
   */
  @Test
  public void testNewTronDBException4() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    TronDBException actualTronDBException = new TronDBException(throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualTronDBException.getMessage());
    assertEquals(0, actualTronDBException.getSuppressed().length);
    assertSame(throwable, actualTronDBException.getCause());
  }
}
