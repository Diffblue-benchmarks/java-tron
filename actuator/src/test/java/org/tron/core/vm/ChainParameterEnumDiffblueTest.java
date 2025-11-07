package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ChainParameterEnumDiffblueTest {
  /**
   * Method under test: {@link ChainParameterEnum#fromCode(long)}
   */
  @Test
  public void testFromCode() {
    // Arrange, Act and Assert
    assertEquals(ChainParameterEnum.TOTAL_NET_LIMIT, ChainParameterEnum.fromCode(1L));
    assertEquals(ChainParameterEnum.INVALID_PARAMETER_KEY, ChainParameterEnum.fromCode(6L));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ChainParameterEnum#getAction()}
   *   <li>{@link ChainParameterEnum#getCode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ChainParameterEnum valueOfResult = ChainParameterEnum.valueOf("INVALID_PARAMETER_KEY");

    // Act
    valueOfResult.getAction();

    // Assert
    assertEquals(0L, valueOfResult.getCode());
  }
}
