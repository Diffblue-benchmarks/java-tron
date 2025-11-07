package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BadBlockExceptionDiffblueTest {
  /**
   * Method under test: {@link BadBlockException#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(BadBlockException.TypeEnum.DEFAULT, (new BadBlockException()).getType());
  }

  /**
   * Method under test: {@link BadBlockException#BadBlockException()}
   */
  @Test
  public void testNewBadBlockException() {
    // Arrange and Act
    BadBlockException actualBadBlockException = new BadBlockException();

    // Assert
    assertNull(actualBadBlockException.getLocalizedMessage());
    assertNull(actualBadBlockException.getMessage());
    assertNull(actualBadBlockException.getCause());
    assertEquals(0, actualBadBlockException.getSuppressed().length);
    assertEquals(BadBlockException.TypeEnum.DEFAULT, actualBadBlockException.getType());
  }

  /**
   * Method under test: {@link BadBlockException#BadBlockException(String)}
   */
  @Test
  public void testNewBadBlockException2() {
    // Arrange and Act
    BadBlockException actualBadBlockException = new BadBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadBlockException.getMessage());
    assertNull(actualBadBlockException.getCause());
    assertEquals(0, actualBadBlockException.getSuppressed().length);
    assertEquals(BadBlockException.TypeEnum.DEFAULT, actualBadBlockException.getType());
  }

  /**
   * Method under test:
   * {@link BadBlockException#BadBlockException(BadBlockException.TypeEnum, String)}
   */
  @Test
  public void testNewBadBlockException3() {
    // Arrange and Act
    BadBlockException actualBadBlockException = new BadBlockException(
        BadBlockException.TypeEnum.CALC_MERKLE_ROOT_FAILED, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadBlockException.getMessage());
    assertNull(actualBadBlockException.getCause());
    assertEquals(0, actualBadBlockException.getSuppressed().length);
    assertEquals(BadBlockException.TypeEnum.CALC_MERKLE_ROOT_FAILED, actualBadBlockException.getType());
  }

  /**
   * Method under test: {@link BadBlockException.TypeEnum#getValue()}
   */
  @Test
  public void testTypeEnumGetValue() {
    // Arrange, Act and Assert
    assertEquals(1, BadBlockException.TypeEnum.valueOf("CALC_MERKLE_ROOT_FAILED").getValue().intValue());
  }
}
