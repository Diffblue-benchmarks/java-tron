package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TraitorPeerExceptionDiffblueTest {
  /**
   * Test {@link TraitorPeerException#TraitorPeerException()}.
   * <p>
   * Method under test: {@link TraitorPeerException#TraitorPeerException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TraitorPeerException.<init>()"})
  public void testNewTraitorPeerException() {
    // Arrange and Act
    TraitorPeerException actualTraitorPeerException = new TraitorPeerException();

    // Assert
    assertNull(actualTraitorPeerException.getLocalizedMessage());
    assertNull(actualTraitorPeerException.getMessage());
    assertNull(actualTraitorPeerException.getCause());
    assertEquals(0, actualTraitorPeerException.getSuppressed().length);
  }

  /**
   * Test {@link TraitorPeerException#TraitorPeerException(String)}.
   * <p>
   * Method under test: {@link TraitorPeerException#TraitorPeerException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TraitorPeerException.<init>(String)"})
  public void testNewTraitorPeerException2() {
    // Arrange and Act
    TraitorPeerException actualTraitorPeerException = new TraitorPeerException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTraitorPeerException.getLocalizedMessage());
    assertEquals("An error occurred", actualTraitorPeerException.getMessage());
    assertNull(actualTraitorPeerException.getCause());
    assertEquals(0, actualTraitorPeerException.getSuppressed().length);
  }

  /**
   * Test {@link TraitorPeerException#TraitorPeerException(String, Throwable)}.
   * <p>
   * Method under test: {@link TraitorPeerException#TraitorPeerException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TraitorPeerException.<init>(String, Throwable)"})
  public void testNewTraitorPeerException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TraitorPeerException actualTraitorPeerException = new TraitorPeerException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTraitorPeerException.getLocalizedMessage());
    assertEquals("An error occurred", actualTraitorPeerException.getMessage());
    assertEquals(0, actualTraitorPeerException.getSuppressed().length);
    assertSame(cause, actualTraitorPeerException.getCause());
  }
}
