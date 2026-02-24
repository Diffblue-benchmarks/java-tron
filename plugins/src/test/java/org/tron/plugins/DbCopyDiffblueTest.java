package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbCopy.DbCopier;

public class DbCopyDiffblueTest {
  /**
   * Test DbCopier {@link DbCopier#doCopy()}.
   *
   * <ul>
   *   <li>Given {@link DbCopier#DbCopier(String, String, String)} with {@code Src Dir} and {@code
   *       Dst Dir} and {@code Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DbCopier#doCopy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCopier.doCopy()"})
  public void testDbCopierDoCopy_givenDbCopierWithSrcDirAndDstDirAndName_thenReturnTrue() {
    // Arrange
    DbCopier dbCopier = new DbCopier("Src Dir", "Dst Dir", "Name");

    // Act and Assert
    assertTrue(dbCopier.doCopy());
  }

  /**
   * Test DbCopier {@link DbCopier#name()}.
   *
   * <p>Method under test: {@link DbCopier#name()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DbCopier.name()"})
  public void testDbCopierName() {
    // Arrange
    DbCopier dbCopier = new DbCopier("Src Dir", "Dst Dir", "Name");

    // Act and Assert
    assertEquals("Name", dbCopier.name());
  }

  /**
   * Test DbCopier {@link DbCopier#DbCopier(String, String, String)}.
   *
   * <p>Method under test: {@link DbCopier#DbCopier(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCopier.<init>(String, String, String)"})
  public void testDbCopierNewDbCopier() {
    // Arrange and Act
    DbCopier actualDbCopier = new DbCopier("Src Dir", "Dst Dir", "Name");

    // Assert
    assertEquals("Name", actualDbCopier.name());
    assertTrue(actualDbCopier.doCopy());
  }

  /**
   * Test new {@link DbCopy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DbCopy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCopy.<init>()"})
  public void testNewDbCopy() {
    // Arrange, Act and Assert
    assertNull(new DbCopy().spec);
  }
}
