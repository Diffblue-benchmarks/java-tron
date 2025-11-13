package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ZkProofValidateExceptionDiffblueTest {
  /**
   * Test {@link ZkProofValidateException#ZkProofValidateException(String, boolean)}.
   *
   * <p>Method under test: {@link ZkProofValidateException#ZkProofValidateException(String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZkProofValidateException.<init>(String, boolean)"})
  public void testNewZkProofValidateException() {
    // Arrange and Act
    ZkProofValidateException actualZkProofValidateException =
        new ZkProofValidateException("An error occurred", true);

    // Assert
    assertEquals("An error occurred", actualZkProofValidateException.getLocalizedMessage());
    assertEquals("An error occurred", actualZkProofValidateException.getMessage());
    assertNull(actualZkProofValidateException.getCause());
    assertEquals(0, actualZkProofValidateException.getSuppressed().length);
    assertTrue(actualZkProofValidateException.isFirstValidated());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ZkProofValidateException#setFirstValidated(boolean)}
   *   <li>{@link ZkProofValidateException#isFirstValidated()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ZkProofValidateException.isFirstValidated()",
    "void ZkProofValidateException.setFirstValidated(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ZkProofValidateException zkProofValidateException =
        new ZkProofValidateException("An error occurred", true);

    // Act
    zkProofValidateException.setFirstValidated(true);

    // Assert
    assertTrue(zkProofValidateException.isFirstValidated());
  }
}
