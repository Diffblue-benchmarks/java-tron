package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbConvert.DbConverter;

public class DbConvertDiffblueTest {
  /**
   * Test DbConverter {@link DbConverter#name()}.
   *
   * <p>Method under test: {@link DbConverter#name()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DbConverter.name()"})
  public void testDbConverterName() {
    // Arrange
    DbConverter dbConverter = new DbConverter("Src Dir", "Dst Dir", "Name", true);

    // Act and Assert
    assertEquals("Name", dbConverter.name());
  }

  /**
   * Test DbConverter {@link DbConverter#DbConverter(String, String, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code Incomplete}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DbConverter#DbConverter(String, String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbConverter.<init>(String, String, String, boolean)"})
  public void testDbConverterNewDbConverter_whenIncomplete_thenReturnName() {
    // Arrange and Act
    DbConverter actualDbConverter = new DbConverter("Incomplete", "Dst Dir", "Name", true);

    // Assert
    assertEquals("Name", actualDbConverter.name());
  }
}
