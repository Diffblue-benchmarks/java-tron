package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RevokingStoreIllegalStateExceptionDiffblueTest {
  /**
   * Test {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(int)}.
   *
   * <p>Method under test: {@link
   * RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RevokingStoreIllegalStateException.<init>(int)"})
  public void testNewRevokingStoreIllegalStateException() {
    // Arrange and Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException =
        new RevokingStoreIllegalStateException(1);

    // Assert
    assertEquals(
        "activeSession 1 has to be greater than 0",
        actualRevokingStoreIllegalStateException.getLocalizedMessage());
    assertEquals(
        "activeSession 1 has to be greater than 0",
        actualRevokingStoreIllegalStateException.getMessage());
    assertNull(actualRevokingStoreIllegalStateException.getCause());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
  }

  /**
   * Test {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RevokingStoreIllegalStateException.<init>()",
    "void RevokingStoreIllegalStateException.<init>(String)",
    "void RevokingStoreIllegalStateException.<init>(String, Throwable)",
    "void RevokingStoreIllegalStateException.<init>(Throwable)"
  })
  public void testNewRevokingStoreIllegalStateException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException =
        new RevokingStoreIllegalStateException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRevokingStoreIllegalStateException.getMessage());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
    assertSame(cause, actualRevokingStoreIllegalStateException.getCause());
  }

  /**
   * Test {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RevokingStoreIllegalStateException.<init>()",
    "void RevokingStoreIllegalStateException.<init>(String)",
    "void RevokingStoreIllegalStateException.<init>(String, Throwable)",
    "void RevokingStoreIllegalStateException.<init>(Throwable)"
  })
  public void testNewRevokingStoreIllegalStateException_thenReturnMessageIsEmptyString() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException =
        new RevokingStoreIllegalStateException(cause);

    // Assert
    assertEquals("", actualRevokingStoreIllegalStateException.getMessage());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
    assertSame(cause, actualRevokingStoreIllegalStateException.getCause());
  }

  /**
   * Test {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RevokingStoreIllegalStateException#RevokingStoreIllegalStateException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RevokingStoreIllegalStateException.<init>()",
    "void RevokingStoreIllegalStateException.<init>(String)",
    "void RevokingStoreIllegalStateException.<init>(String, Throwable)",
    "void RevokingStoreIllegalStateException.<init>(Throwable)"
  })
  public void testNewRevokingStoreIllegalStateException_thenReturnMessageIsNull() {
    // Arrange and Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException =
        new RevokingStoreIllegalStateException();

    // Assert
    assertNull(actualRevokingStoreIllegalStateException.getMessage());
    assertNull(actualRevokingStoreIllegalStateException.getCause());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
  }

  /**
   * Test {@link RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Message is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RevokingStoreIllegalStateException#RevokingStoreIllegalStateException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RevokingStoreIllegalStateException.<init>()",
    "void RevokingStoreIllegalStateException.<init>(String)",
    "void RevokingStoreIllegalStateException.<init>(String, Throwable)",
    "void RevokingStoreIllegalStateException.<init>(Throwable)"
  })
  public void testNewRevokingStoreIllegalStateException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    RevokingStoreIllegalStateException actualRevokingStoreIllegalStateException =
        new RevokingStoreIllegalStateException("foo");

    // Assert
    assertEquals("foo", actualRevokingStoreIllegalStateException.getMessage());
    assertNull(actualRevokingStoreIllegalStateException.getCause());
    assertEquals(0, actualRevokingStoreIllegalStateException.getSuppressed().length);
  }
}
