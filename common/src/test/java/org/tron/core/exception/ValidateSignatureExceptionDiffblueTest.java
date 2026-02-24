package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValidateSignatureExceptionDiffblueTest {
  /**
   * Test {@link ValidateSignatureException#ValidateSignatureException()}.
   *
   * <p>Method under test: {@link ValidateSignatureException#ValidateSignatureException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateSignatureException.<init>()"})
  public void testNewValidateSignatureException() {
    // Arrange and Act
    ValidateSignatureException actualValidateSignatureException = new ValidateSignatureException();

    // Assert
    assertNull(actualValidateSignatureException.getLocalizedMessage());
    assertNull(actualValidateSignatureException.getMessage());
    assertNull(actualValidateSignatureException.getCause());
    assertEquals(0, actualValidateSignatureException.getSuppressed().length);
  }

  /**
   * Test {@link ValidateSignatureException#ValidateSignatureException(String)}.
   *
   * <p>Method under test: {@link ValidateSignatureException#ValidateSignatureException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateSignatureException.<init>(String)"})
  public void testNewValidateSignatureException2() {
    // Arrange and Act
    ValidateSignatureException actualValidateSignatureException =
        new ValidateSignatureException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualValidateSignatureException.getLocalizedMessage());
    assertEquals("An error occurred", actualValidateSignatureException.getMessage());
    assertNull(actualValidateSignatureException.getCause());
    assertEquals(0, actualValidateSignatureException.getSuppressed().length);
  }
}
