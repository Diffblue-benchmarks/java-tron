package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PropUtilDiffblueTest {
  /**
   * Test {@link PropUtil#readProperty(String, String)}.
   * <p>
   * Method under test: {@link PropUtil#readProperty(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PropUtil.readProperty(String, String)"})
  public void testReadProperty() {
    // Arrange, Act and Assert
    assertEquals("", PropUtil.readProperty("File", "Key"));
  }

  /**
   * Test {@link PropUtil#writeProperty(String, String, String)}.
   * <p>
   * Method under test: {@link PropUtil#writeProperty(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PropUtil.writeProperty(String, String, String)"})
  public void testWriteProperty() {
    // Arrange, Act and Assert
    assertFalse(PropUtil.writeProperty("File", "Key", "42"));
  }
}
