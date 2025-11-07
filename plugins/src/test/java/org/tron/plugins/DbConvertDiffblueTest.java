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
   * <p>
   * Method under test: {@link DbConverter#name()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DbConverter.name()"})
  public void testDbConverterName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DbConverter("Src Dir", "Dst Dir", "Name", true)).name());
  }

  /**
   * Test DbConverter {@link DbConverter#DbConverter(String, String, String, boolean)}.
   * <p>
   * Method under test: {@link DbConverter#DbConverter(String, String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbConverter.<init>(String, String, String, boolean)"})
  public void testDbConverterNewDbConverter() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DbConverter("Src Dir", "Dst Dir", "Name", true)).name());
  }
}
