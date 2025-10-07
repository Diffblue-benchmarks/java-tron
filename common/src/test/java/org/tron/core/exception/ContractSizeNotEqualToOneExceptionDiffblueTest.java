package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractSizeNotEqualToOneExceptionDiffblueTest {
  /**
   * Test {@link ContractSizeNotEqualToOneException#ContractSizeNotEqualToOneException()}.
   *
   * <p>Method under test: {@link
   * ContractSizeNotEqualToOneException#ContractSizeNotEqualToOneException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractSizeNotEqualToOneException.<init>()"})
  public void testNewContractSizeNotEqualToOneException() {
    // Arrange and Act
    ContractSizeNotEqualToOneException actualContractSizeNotEqualToOneException =
        new ContractSizeNotEqualToOneException();

    // Assert
    assertNull(actualContractSizeNotEqualToOneException.getLocalizedMessage());
    assertNull(actualContractSizeNotEqualToOneException.getMessage());
    assertNull(actualContractSizeNotEqualToOneException.getCause());
    assertEquals(0, actualContractSizeNotEqualToOneException.getSuppressed().length);
  }

  /**
   * Test {@link ContractSizeNotEqualToOneException#ContractSizeNotEqualToOneException(String)}.
   *
   * <p>Method under test: {@link
   * ContractSizeNotEqualToOneException#ContractSizeNotEqualToOneException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractSizeNotEqualToOneException.<init>(String)"})
  public void testNewContractSizeNotEqualToOneException2() {
    // Arrange and Act
    ContractSizeNotEqualToOneException actualContractSizeNotEqualToOneException =
        new ContractSizeNotEqualToOneException("An error occurred");

    // Assert
    assertEquals(
        "An error occurred", actualContractSizeNotEqualToOneException.getLocalizedMessage());
    assertEquals("An error occurred", actualContractSizeNotEqualToOneException.getMessage());
    assertNull(actualContractSizeNotEqualToOneException.getCause());
    assertEquals(0, actualContractSizeNotEqualToOneException.getSuppressed().length);
  }
}
