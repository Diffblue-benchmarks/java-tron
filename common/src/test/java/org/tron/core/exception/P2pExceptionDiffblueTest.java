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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Err Msg}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link P2pException#P2pException(TypeEnum, String)}
   *   <li>{@link P2pException#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void P2pException.<init>(TypeEnum, String)",
    "void P2pException.<init>(TypeEnum, String, Throwable)",
    "void P2pException.<init>(TypeEnum, Throwable)",
    "TypeEnum P2pException.getType()"
  })
  public void testGettersAndSetters_whenErrMsg_thenReturnCauseIsNull() {
    // Arrange and Act
    P2pException actualP2pException = new P2pException(TypeEnum.NO_SUCH_MESSAGE, "Err Msg");
    TypeEnum actualType = actualP2pException.getType();

    // Assert
    assertEquals("Err Msg", actualP2pException.getMessage());
    assertNull(actualP2pException.getCause());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(TypeEnum.NO_SUCH_MESSAGE, actualType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Err Msg}.
   *   <li>Then return Message is {@code Err Msg}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link P2pException#P2pException(TypeEnum, String, Throwable)}
   *   <li>{@link P2pException#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void P2pException.<init>(TypeEnum, String)",
    "void P2pException.<init>(TypeEnum, String, Throwable)",
    "void P2pException.<init>(TypeEnum, Throwable)",
    "TypeEnum P2pException.getType()"
  })
  public void testGettersAndSetters_whenErrMsg_thenReturnMessageIsErrMsg() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    P2pException actualP2pException =
        new P2pException(TypeEnum.NO_SUCH_MESSAGE, "Err Msg", throwable);
    TypeEnum actualType = actualP2pException.getType();

    // Assert
    assertEquals("Err Msg", actualP2pException.getMessage());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(TypeEnum.NO_SUCH_MESSAGE, actualType);
    assertSame(throwable, actualP2pException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link P2pException#P2pException(TypeEnum, Throwable)}
   *   <li>{@link P2pException#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void P2pException.<init>(TypeEnum, String)",
    "void P2pException.<init>(TypeEnum, String, Throwable)",
    "void P2pException.<init>(TypeEnum, Throwable)",
    "TypeEnum P2pException.getType()"
  })
  public void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    P2pException actualP2pException = new P2pException(TypeEnum.NO_SUCH_MESSAGE, throwable);
    TypeEnum actualType = actualP2pException.getType();

    // Assert
    assertEquals("java.lang.Throwable", actualP2pException.getMessage());
    assertEquals(0, actualP2pException.getSuppressed().length);
    assertEquals(TypeEnum.NO_SUCH_MESSAGE, actualType);
    assertSame(throwable, actualP2pException.getCause());
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
