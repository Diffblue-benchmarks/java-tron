package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StoreExceptionDiffblueTest {
  /**
   * Test {@link StoreException#StoreException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreException#StoreException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreException.<init>()", "void StoreException.<init>(String)",
      "void StoreException.<init>(String, Throwable)", "void StoreException.<init>(Throwable)"})
  public void testNewStoreException_thenReturnMessageIsNull() {
    // Arrange and Act
    StoreException actualStoreException = new StoreException();

    // Assert
    assertNull(actualStoreException.getMessage());
    assertNull(actualStoreException.getCause());
    assertEquals(0, actualStoreException.getSuppressed().length);
  }

  /**
   * Test {@link StoreException#StoreException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreException#StoreException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreException.<init>()", "void StoreException.<init>(String)",
      "void StoreException.<init>(String, Throwable)", "void StoreException.<init>(Throwable)"})
  public void testNewStoreException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    StoreException actualStoreException = new StoreException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualStoreException.getMessage());
    assertNull(actualStoreException.getCause());
    assertEquals(0, actualStoreException.getSuppressed().length);
  }

  /**
   * Test {@link StoreException#StoreException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreException#StoreException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreException.<init>()", "void StoreException.<init>(String)",
      "void StoreException.<init>(String, Throwable)", "void StoreException.<init>(Throwable)"})
  public void testNewStoreException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
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
   * Test {@link StoreException#StoreException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreException#StoreException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StoreException.<init>()", "void StoreException.<init>(String)",
      "void StoreException.<init>(String, Throwable)", "void StoreException.<init>(Throwable)"})
  public void testNewStoreException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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
