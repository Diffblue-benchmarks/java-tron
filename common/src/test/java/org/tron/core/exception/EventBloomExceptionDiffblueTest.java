package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EventBloomExceptionDiffblueTest {
  /**
   * Test {@link EventBloomException#EventBloomException()}.
   * <p>
   * Method under test: {@link EventBloomException#EventBloomException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventBloomException.<init>()"})
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
   * Test {@link EventBloomException#EventBloomException(String)}.
   * <p>
   * Method under test: {@link EventBloomException#EventBloomException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventBloomException.<init>(String)"})
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
   * Test {@link EventBloomException#EventBloomException(String, Throwable)}.
   * <p>
   * Method under test: {@link EventBloomException#EventBloomException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventBloomException.<init>(String, Throwable)"})
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
