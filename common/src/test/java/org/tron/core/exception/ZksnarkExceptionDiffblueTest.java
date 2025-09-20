package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ZksnarkExceptionDiffblueTest {
  /**
   * Test {@link ZksnarkException#ZksnarkException()}.
   *
   * <p>Method under test: {@link ZksnarkException#ZksnarkException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZksnarkException.<init>()"})
  public void testNewZksnarkException() {
    // Arrange and Act
    ZksnarkException actualZksnarkException = new ZksnarkException();

    // Assert
    assertNull(actualZksnarkException.getLocalizedMessage());
    assertNull(actualZksnarkException.getMessage());
    assertNull(actualZksnarkException.getCause());
    assertEquals(0, actualZksnarkException.getSuppressed().length);
  }

  /**
   * Test {@link ZksnarkException#ZksnarkException(String)}.
   *
   * <p>Method under test: {@link ZksnarkException#ZksnarkException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZksnarkException.<init>(String)"})
  public void testNewZksnarkException2() {
    // Arrange and Act
    ZksnarkException actualZksnarkException = new ZksnarkException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualZksnarkException.getLocalizedMessage());
    assertEquals("An error occurred", actualZksnarkException.getMessage());
    assertNull(actualZksnarkException.getCause());
    assertEquals(0, actualZksnarkException.getSuppressed().length);
  }
}
