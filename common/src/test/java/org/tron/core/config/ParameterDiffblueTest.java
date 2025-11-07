package org.tron.core.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ParameterDiffblueTest {
  /**
   * Method under test:
   * {@link Parameter.ForkBlockVersionEnum#getForkBlockVersionEnum(int)}
   */
  @Test
  public void testForkBlockVersionEnumGetForkBlockVersionEnum() {
    // Arrange, Act and Assert
    assertNull(Parameter.ForkBlockVersionEnum.getForkBlockVersionEnum(42));
    assertEquals(Parameter.ForkBlockVersionEnum.VERSION_4_3,
        Parameter.ForkBlockVersionEnum.getForkBlockVersionEnum(22));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Parameter.ForkBlockVersionEnum#getHardForkRate()}
   *   <li>{@link Parameter.ForkBlockVersionEnum#getHardForkTime()}
   *   <li>{@link Parameter.ForkBlockVersionEnum#getValue()}
   * </ul>
   */
  @Test
  public void testForkBlockVersionEnumGettersAndSetters() {
    // Arrange
    Parameter.ForkBlockVersionEnum valueOfResult = Parameter.ForkBlockVersionEnum.valueOf("ENERGY_LIMIT");

    // Act
    int actualHardForkRate = valueOfResult.getHardForkRate();
    long actualHardForkTime = valueOfResult.getHardForkTime();

    // Assert
    assertEquals(0, actualHardForkRate);
    assertEquals(5, valueOfResult.getValue());
    assertEquals(Parameter.ChainConstant.TRANSFER_FEE, actualHardForkTime);
  }
}
