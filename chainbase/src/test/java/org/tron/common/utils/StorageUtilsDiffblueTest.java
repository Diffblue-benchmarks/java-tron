package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StorageUtilsDiffblueTest {
  /**
   * Test {@link StorageUtils#getOutputDirectory()}.
   *
   * <p>Method under test: {@link StorageUtils#getOutputDirectory()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String StorageUtils.getOutputDirectory()"})
  public void testGetOutputDirectory() {
    // Arrange, Act and Assert
    assertEquals("output-directory/", StorageUtils.getOutputDirectory());
  }
}
