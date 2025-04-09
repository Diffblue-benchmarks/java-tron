package org.tron.core.vm.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MUtilDiffblueTest {
  /**
   * Test {@link MUtil#isNullOrEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNullOrEmpty(String)"})
  public void testIsNullOrEmpty_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNullOrEmpty(""));
  }

  /**
   * Test {@link MUtil#isNullOrEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNullOrEmpty(String)"})
  public void testIsNullOrEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNullOrEmpty(null));
  }

  /**
   * Test {@link MUtil#isNullOrEmpty(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNullOrEmpty(String)"})
  public void testIsNullOrEmpty_whenStr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNullOrEmpty("Str"));
  }

  /**
   * Test {@link MUtil#isNotNullOrEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNotNullOrEmpty(String)"})
  public void testIsNotNullOrEmpty_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNotNullOrEmpty(""));
  }

  /**
   * Test {@link MUtil#isNotNullOrEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNotNullOrEmpty(String)"})
  public void testIsNotNullOrEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNotNullOrEmpty(null));
  }

  /**
   * Test {@link MUtil#isNotNullOrEmpty(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNotNullOrEmpty(String)"})
  public void testIsNotNullOrEmpty_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNotNullOrEmpty("Str"));
  }
}
