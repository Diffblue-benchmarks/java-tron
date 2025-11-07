package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class P2pExceptionDiffblueTest {
  /**
   * Method under test: {@link P2pException#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(P2pException.TypeEnum.NO_SUCH_MESSAGE,
        (new P2pException(P2pException.TypeEnum.NO_SUCH_MESSAGE, "Err Msg")).getType());
  }

  /**
   * Method under test:
   * {@link P2pException#P2pException(P2pException.TypeEnum, String)}
   */
  @Test
  public void testNewP2pException() {
    // Arrange and Act
    P2pException actualP2pException = new P2pException(P2pException.TypeEnum.NO_SUCH_MESSAGE, "Err Msg");

    // Assert
    assertEquals("Err Msg", actualP2pException.getLocalizedMessage());
    assertEquals("Err Msg", actualP2pException.getMessage());
    assertNull(actualP2pException.getCause());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(P2pException.TypeEnum.NO_SUCH_MESSAGE, actualP2pException.getType());
  }

  /**
   * Method under test:
   * {@link P2pException#P2pException(P2pException.TypeEnum, String, Throwable)}
   */
  @Test
  public void testNewP2pException2() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    P2pException actualP2pException = new P2pException(P2pException.TypeEnum.NO_SUCH_MESSAGE, "Err Msg", throwable);

    // Assert
    assertEquals("Err Msg", actualP2pException.getLocalizedMessage());
    assertEquals("Err Msg", actualP2pException.getMessage());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(P2pException.TypeEnum.NO_SUCH_MESSAGE, actualP2pException.getType());
    assertSame(throwable, actualP2pException.getCause());
  }

  /**
   * Method under test:
   * {@link P2pException#P2pException(P2pException.TypeEnum, Throwable)}
   */
  @Test
  public void testNewP2pException3() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    P2pException actualP2pException = new P2pException(P2pException.TypeEnum.NO_SUCH_MESSAGE, throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualP2pException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualP2pException.getMessage());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(P2pException.TypeEnum.NO_SUCH_MESSAGE, actualP2pException.getType());
    assertSame(throwable, actualP2pException.getCause());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link P2pException.TypeEnum#toString()}
   *   <li>{@link P2pException.TypeEnum#getDesc()}
   *   <li>{@link P2pException.TypeEnum#getValue()}
   * </ul>
   */
  @Test
  public void testTypeEnumGettersAndSetters() {
    // Arrange
    P2pException.TypeEnum valueOfResult = P2pException.TypeEnum.valueOf("NO_SUCH_MESSAGE");

    // Act
    String actualToStringResult = valueOfResult.toString();
    String actualDesc = valueOfResult.getDesc();

    // Assert
    assertEquals("1, no such message", actualToStringResult);
    assertEquals("no such message", actualDesc);
    assertEquals(1, valueOfResult.getValue().intValue());
  }
}
