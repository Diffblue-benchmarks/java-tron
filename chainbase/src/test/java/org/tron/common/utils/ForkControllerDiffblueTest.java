package org.tron.common.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.config.Parameter;
import org.tron.core.config.Parameter.ForkBlockVersionEnum;

public class ForkControllerDiffblueTest {
  /**
   * Test {@link ForkController#pass(ForkBlockVersionEnum)} with {@code forkBlockVersionEnum}.
   * <ul>
   *   <li>When {@code ENERGY_LIMIT}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForkController#pass(ForkBlockVersionEnum)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ForkController.pass(ForkBlockVersionEnum)"})
  public void testPassWithForkBlockVersionEnum_whenEnergyLimit_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ForkController.instance().pass(ForkBlockVersionEnum.ENERGY_LIMIT));
  }

  /**
   * Test {@link ForkController#pass(int)} with {@code version}.
   * <p>
   * Method under test: {@link ForkController#pass(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ForkController.pass(int)"})
  public void testPassWithVersion() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ForkController.instance().pass(1));
  }

  /**
   * Test {@link ForkController#instance()}.
   * <p>
   * Method under test: {@link ForkController#instance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ForkController ForkController.instance()"})
  public void testInstance() {
    // Arrange, Act and Assert
    assertNull(ForkController.instance().getManager());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ForkController}
   *   <li>{@link ForkController#getManager()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ForkController.<init>()", "org.tron.core.ChainBaseManager ForkController.getManager()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new ForkController()).getManager());
  }
}
