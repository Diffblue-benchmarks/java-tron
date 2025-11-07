package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class EventBloomExceptionDiffblueTest {
  /**
   * Method under test: {@link EventBloomException#EventBloomException()}
   */
  @Test
  public void testNewEventBloomException() {
    // Arrange and Act
    EventBloomException actualEventBloomException = new EventBloomException();

    // Assert
    assertNull(actualEventBloomException.getLocalizedMessage());
    assertNull(actualEventBloomException.getMessage());
    assertNull(actualEventBloomException.getCause());
    assertEquals(0, actualEventBloomException.getSuppressed().length);
  }

  /**
   * Method under test: {@link EventBloomException#EventBloomException(String)}
   */
  @Test
  public void testNewEventBloomException2() {
    // Arrange and Act
    EventBloomException actualEventBloomException = new EventBloomException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualEventBloomException.getLocalizedMessage());
    assertEquals("An error occurred", actualEventBloomException.getMessage());
    assertNull(actualEventBloomException.getCause());
    assertEquals(0, actualEventBloomException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EventBloomException#EventBloomException(String, Throwable)}
   */
  @Test
  public void testNewEventBloomException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EventBloomException actualEventBloomException = new EventBloomException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualEventBloomException.getLocalizedMessage());
    assertEquals("An error occurred", actualEventBloomException.getMessage());
    assertEquals(0, actualEventBloomException.getSuppressed().length);
    assertSame(cause, actualEventBloomException.getCause());
  }
}
