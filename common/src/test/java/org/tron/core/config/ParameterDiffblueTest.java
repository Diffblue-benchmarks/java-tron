package org.tron.core.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.config.Parameter.ChainConstant;
import org.tron.core.config.Parameter.ForkBlockVersionEnum;

public class ParameterDiffblueTest {
  /**
   * Test ForkBlockVersionEnum {@link ForkBlockVersionEnum#getForkBlockVersionEnum(int)}.
   *
   * <ul>
   *   <li>Then return {@code VERSION_4_3}.
   * </ul>
   *
   * <p>Method under test: {@link ForkBlockVersionEnum#getForkBlockVersionEnum(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ForkBlockVersionEnum ForkBlockVersionEnum.getForkBlockVersionEnum(int)"})
  public void testForkBlockVersionEnumGetForkBlockVersionEnum_thenReturnVersion43() {
    // Arrange, Act and Assert
    assertEquals(
        ForkBlockVersionEnum.VERSION_4_3, ForkBlockVersionEnum.getForkBlockVersionEnum(22));
  }

  /**
   * Test ForkBlockVersionEnum {@link ForkBlockVersionEnum#getForkBlockVersionEnum(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ForkBlockVersionEnum#getForkBlockVersionEnum(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ForkBlockVersionEnum ForkBlockVersionEnum.getForkBlockVersionEnum(int)"})
  public void testForkBlockVersionEnumGetForkBlockVersionEnum_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ForkBlockVersionEnum.getForkBlockVersionEnum(42));
  }

  /**
   * Test ForkBlockVersionEnum getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ForkBlockVersionEnum#getHardForkRate()}
   *   <li>{@link ForkBlockVersionEnum#getHardForkTime()}
   *   <li>{@link ForkBlockVersionEnum#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int ForkBlockVersionEnum.getHardForkRate()",
    "long ForkBlockVersionEnum.getHardForkTime()",
    "int ForkBlockVersionEnum.getValue()"
  })
  public void testForkBlockVersionEnumGettersAndSetters() {
    // Arrange
    ForkBlockVersionEnum valueOfResult = ForkBlockVersionEnum.valueOf("ENERGY_LIMIT");

    // Act
    int actualHardForkRate = valueOfResult.getHardForkRate();
    long actualHardForkTime = valueOfResult.getHardForkTime();

    // Assert
    assertEquals(0, actualHardForkRate);
    assertEquals(5, valueOfResult.getValue());
    assertEquals(ChainConstant.TRANSFER_FEE, actualHardForkTime);
  }
}
