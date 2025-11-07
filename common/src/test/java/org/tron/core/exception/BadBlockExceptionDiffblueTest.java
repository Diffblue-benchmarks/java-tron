package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadBlockException.TypeEnum;

public class BadBlockExceptionDiffblueTest {
  /**
   * Test {@link BadBlockException#BadBlockException()}.
   * <p>
   * Method under test: {@link BadBlockException#BadBlockException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadBlockException.<init>()"})
  public void testNewBadBlockException() {
    // Arrange and Act
    BadBlockException actualBadBlockException = new BadBlockException();

    // Assert
    assertNull(actualBadBlockException.getLocalizedMessage());
    assertNull(actualBadBlockException.getMessage());
    assertNull(actualBadBlockException.getCause());
    assertEquals(0, actualBadBlockException.getSuppressed().length);
    assertEquals(TypeEnum.DEFAULT, actualBadBlockException.getType());
  }

  /**
   * Test {@link BadBlockException#BadBlockException(String)}.
   * <p>
   * Method under test: {@link BadBlockException#BadBlockException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadBlockException.<init>(String)"})
  public void testNewBadBlockException2() {
    // Arrange and Act
    BadBlockException actualBadBlockException = new BadBlockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadBlockException.getMessage());
    assertNull(actualBadBlockException.getCause());
    assertEquals(0, actualBadBlockException.getSuppressed().length);
    assertEquals(TypeEnum.DEFAULT, actualBadBlockException.getType());
  }

  /**
   * Test {@link BadBlockException#BadBlockException(TypeEnum, String)}.
   * <p>
   * Method under test: {@link BadBlockException#BadBlockException(TypeEnum, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadBlockException.<init>(TypeEnum, String)"})
  public void testNewBadBlockException3() {
    // Arrange and Act
    BadBlockException actualBadBlockException = new BadBlockException(TypeEnum.CALC_MERKLE_ROOT_FAILED,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualBadBlockException.getLocalizedMessage());
    assertEquals("An error occurred", actualBadBlockException.getMessage());
    assertNull(actualBadBlockException.getCause());
    assertEquals(0, actualBadBlockException.getSuppressed().length);
    assertEquals(TypeEnum.CALC_MERKLE_ROOT_FAILED, actualBadBlockException.getType());
  }

  /**
   * Test {@link BadBlockException#getType()}.
   * <p>
   * Method under test: {@link BadBlockException#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeEnum BadBlockException.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(TypeEnum.DEFAULT, (new BadBlockException()).getType());
  }

  /**
   * Test TypeEnum {@link TypeEnum#getValue()}.
   * <p>
   * Method under test: {@link TypeEnum#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer TypeEnum.getValue()"})
  public void testTypeEnumGetValue() {
    // Arrange, Act and Assert
    assertEquals(1, TypeEnum.valueOf("CALC_MERKLE_ROOT_FAILED").getValue().intValue());
  }
}
