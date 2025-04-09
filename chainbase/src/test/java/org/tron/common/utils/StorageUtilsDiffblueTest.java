package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StorageUtilsDiffblueTest {
  /**
   * Test {@link StorageUtils#getOutputDirectory()}.
   * <p>
   * Method under test: {@link StorageUtils#getOutputDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String StorageUtils.getOutputDirectory()"})
  public void testGetOutputDirectory() {
    // Arrange, Act and Assert
    assertEquals("output-directory/", StorageUtils.getOutputDirectory());
  }
}
