package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ChainParameterEnumDiffblueTest {
  /**
   * Test {@link ChainParameterEnum#fromCode(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code TOTAL_NET_LIMIT}.
   * </ul>
   *
   * <p>Method under test: {@link ChainParameterEnum#fromCode(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ChainParameterEnum ChainParameterEnum.fromCode(long)"})
  public void testFromCode_whenOne_thenReturnTotalNetLimit() {
    // Arrange, Act and Assert
    assertEquals(ChainParameterEnum.TOTAL_NET_LIMIT, ChainParameterEnum.fromCode(1L));
  }

  /**
   * Test {@link ChainParameterEnum#fromCode(long)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code INVALID_PARAMETER_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link ChainParameterEnum#fromCode(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ChainParameterEnum ChainParameterEnum.fromCode(long)"})
  public void testFromCode_whenSix_thenReturnInvalidParameterKey() {
    // Arrange, Act and Assert
    assertEquals(ChainParameterEnum.INVALID_PARAMETER_KEY, ChainParameterEnum.fromCode(6L));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChainParameterEnum#getAction()}
   *   <li>{@link ChainParameterEnum#getCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.function.Function ChainParameterEnum.getAction()",
    "long ChainParameterEnum.getCode()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ChainParameterEnum valueOfResult = ChainParameterEnum.valueOf("INVALID_PARAMETER_KEY");

    // Act
    valueOfResult.getAction();

    // Assert
    assertEquals(0L, valueOfResult.getCode());
  }
}
