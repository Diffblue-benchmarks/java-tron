package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PropUtilDiffblueTest {
  /**
   * Test {@link PropUtil#readProperty(String, String)}.
   *
   * <ul>
   *   <li>When {@code ISO-8859-1}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PropUtil#readProperty(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PropUtil.readProperty(String, String)"})
  public void testReadProperty_whenIso88591_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", PropUtil.readProperty("ISO-8859-1", "Key"));
  }

  /**
   * Test {@link PropUtil#readProperty(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PropUtil#readProperty(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PropUtil.readProperty(String, String)"})
  public void testReadProperty_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", PropUtil.readProperty("File", null));
  }

  /**
   * Test {@link PropUtil#writeProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PropUtil#writeProperty(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropUtil.writeProperty(String, String, String)"})
  public void testWriteProperty_whenUtf8_thenReturnFalse() {
    // Arrange and Act
    boolean actualWritePropertyResult = PropUtil.writeProperty("UTF-8", "Key", "42");

    // Assert
    assertFalse(actualWritePropertyResult);
  }
}
