package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.P2pException.TypeEnum;

public class P2pExceptionDiffblueTest {
  /**
   * Test {@link P2pException#P2pException(TypeEnum, String)}.
   *
   * <p>Method under test: {@link P2pException#P2pException(TypeEnum, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void P2pException.<init>(TypeEnum, String)"})
  public void testNewP2pException() {
    // Arrange and Act
    P2pException actualP2pException = new P2pException(TypeEnum.NO_SUCH_MESSAGE, "Err Msg");

    // Assert
    assertEquals("Err Msg", actualP2pException.getLocalizedMessage());
    assertEquals("Err Msg", actualP2pException.getMessage());
    assertNull(actualP2pException.getCause());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(TypeEnum.NO_SUCH_MESSAGE, actualP2pException.getType());
  }

  /**
   * Test {@link P2pException#P2pException(TypeEnum, String, Throwable)}.
   *
   * <p>Method under test: {@link P2pException#P2pException(TypeEnum, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void P2pException.<init>(TypeEnum, String, Throwable)"})
  public void testNewP2pException2() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    P2pException actualP2pException =
        new P2pException(TypeEnum.NO_SUCH_MESSAGE, "Err Msg", throwable);

    // Assert
    assertEquals("Err Msg", actualP2pException.getLocalizedMessage());
    assertEquals("Err Msg", actualP2pException.getMessage());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(TypeEnum.NO_SUCH_MESSAGE, actualP2pException.getType());
    assertSame(throwable, actualP2pException.getCause());
  }

  /**
   * Test {@link P2pException#P2pException(TypeEnum, Throwable)}.
   *
   * <p>Method under test: {@link P2pException#P2pException(TypeEnum, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void P2pException.<init>(TypeEnum, Throwable)"})
  public void testNewP2pException3() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    P2pException actualP2pException = new P2pException(TypeEnum.NO_SUCH_MESSAGE, throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualP2pException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualP2pException.getMessage());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(TypeEnum.NO_SUCH_MESSAGE, actualP2pException.getType());
    assertSame(throwable, actualP2pException.getCause());
  }

  /**
   * Test {@link P2pException#getType()}.
   *
   * <p>Method under test: {@link P2pException#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeEnum P2pException.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        TypeEnum.NO_SUCH_MESSAGE, new P2pException(TypeEnum.NO_SUCH_MESSAGE, "Err Msg").getType());
  }

  /**
   * Test TypeEnum getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeEnum#toString()}
   *   <li>{@link TypeEnum#getDesc()}
   *   <li>{@link TypeEnum#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TypeEnum.getDesc()",
    "java.lang.Integer TypeEnum.getValue()",
    "String TypeEnum.toString()"
  })
  public void testTypeEnumGettersAndSetters() {
    // Arrange
    TypeEnum valueOfResult = TypeEnum.valueOf("NO_SUCH_MESSAGE");

    // Act
    String actualToStringResult = valueOfResult.toString();
    String actualDesc = valueOfResult.getDesc();

    // Assert
    assertEquals("1, no such message", actualToStringResult);
    assertEquals("no such message", actualDesc);
    assertEquals(1, valueOfResult.getValue().intValue());
  }
}
