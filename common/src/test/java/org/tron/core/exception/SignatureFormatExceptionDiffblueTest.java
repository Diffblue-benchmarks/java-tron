package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SignatureFormatExceptionDiffblueTest {
  /**
   * Test {@link SignatureFormatException#SignatureFormatException()}.
   * <p>
   * Method under test: {@link SignatureFormatException#SignatureFormatException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SignatureFormatException.<init>()"})
  public void testNewSignatureFormatException() {
    // Arrange and Act
    SignatureFormatException actualSignatureFormatException = new SignatureFormatException();

    // Assert
    assertNull(actualSignatureFormatException.getLocalizedMessage());
    assertNull(actualSignatureFormatException.getMessage());
    assertNull(actualSignatureFormatException.getCause());
    assertEquals(0, actualSignatureFormatException.getSuppressed().length);
  }

  /**
   * Test {@link SignatureFormatException#SignatureFormatException(String)}.
   * <p>
   * Method under test: {@link SignatureFormatException#SignatureFormatException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SignatureFormatException.<init>(String)"})
  public void testNewSignatureFormatException2() {
    // Arrange and Act
    SignatureFormatException actualSignatureFormatException = new SignatureFormatException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSignatureFormatException.getLocalizedMessage());
    assertEquals("An error occurred", actualSignatureFormatException.getMessage());
    assertNull(actualSignatureFormatException.getCause());
    assertEquals(0, actualSignatureFormatException.getSuppressed().length);
  }
}
