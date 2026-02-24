package org.tron.plugins;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DbRootDiffblueTest {
  /**
   * Test new {@link DbRoot} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DbRoot}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbRoot.<init>()"})
  public void testNewDbRoot() {
    // Arrange, Act and Assert
    assertNull(new DbRoot().spec);
  }
}
