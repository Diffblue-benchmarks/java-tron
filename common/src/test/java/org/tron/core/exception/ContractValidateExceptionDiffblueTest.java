package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractValidateExceptionDiffblueTest {
  /**
   * Test {@link ContractValidateException#ContractValidateException()}.
   *
   * <p>Method under test: {@link ContractValidateException#ContractValidateException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractValidateException.<init>()"})
  public void testNewContractValidateException() {
    // Arrange and Act
    ContractValidateException actualContractValidateException = new ContractValidateException();

    // Assert
    assertNull(actualContractValidateException.getLocalizedMessage());
    assertNull(actualContractValidateException.getMessage());
    assertNull(actualContractValidateException.getCause());
    assertEquals(0, actualContractValidateException.getSuppressed().length);
  }

  /**
   * Test {@link ContractValidateException#ContractValidateException(String)}.
   *
   * <p>Method under test: {@link ContractValidateException#ContractValidateException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractValidateException.<init>(String)"})
  public void testNewContractValidateException2() {
    // Arrange and Act
    ContractValidateException actualContractValidateException =
        new ContractValidateException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualContractValidateException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateException.getMessage());
    assertNull(actualContractValidateException.getCause());
    assertEquals(0, actualContractValidateException.getSuppressed().length);
  }

  /**
   * Test {@link ContractValidateException#ContractValidateException(String, Throwable)}.
   *
   * <p>Method under test: {@link ContractValidateException#ContractValidateException(String,
   * Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractValidateException.<init>(String, Throwable)"})
  public void testNewContractValidateException3() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    ContractValidateException actualContractValidateException =
        new ContractValidateException("An error occurred", throwable);

    // Assert
    assertEquals("An error occurred", actualContractValidateException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractValidateException.getMessage());
    assertEquals(0, actualContractValidateException.getSuppressed().length);
    assertSame(throwable, actualContractValidateException.getCause());
  }
}
