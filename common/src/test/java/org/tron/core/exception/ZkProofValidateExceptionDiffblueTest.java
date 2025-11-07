package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ZkProofValidateExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ZkProofValidateException#setFirstValidated(boolean)}
   *   <li>{@link ZkProofValidateException#isFirstValidated()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ZkProofValidateException zkProofValidateException = new ZkProofValidateException("An error occurred", true);

    // Act
    zkProofValidateException.setFirstValidated(true);

    // Assert that nothing has changed
    assertTrue(zkProofValidateException.isFirstValidated());
  }

  /**
   * Method under test:
   * {@link ZkProofValidateException#ZkProofValidateException(String, boolean)}
   */
  @Test
  public void testNewZkProofValidateException() {
    // Arrange and Act
    ZkProofValidateException actualZkProofValidateException = new ZkProofValidateException("An error occurred", true);

    // Assert
    assertEquals("An error occurred", actualZkProofValidateException.getLocalizedMessage());
    assertEquals("An error occurred", actualZkProofValidateException.getMessage());
    assertNull(actualZkProofValidateException.getCause());
    assertEquals(0, actualZkProofValidateException.getSuppressed().length);
    assertTrue(actualZkProofValidateException.isFirstValidated());
  }
}
