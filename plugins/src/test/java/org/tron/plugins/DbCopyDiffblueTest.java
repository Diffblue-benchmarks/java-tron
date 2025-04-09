package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbCopy.DbCopier;

public class DbCopyDiffblueTest {
  /**
   * Test DbCopier {@link DbCopier#doCopy()}.
   * <p>
   * Method under test: {@link DbCopier#doCopy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCopier.doCopy()"})
  public void testDbCopierDoCopy() {
    // Arrange, Act and Assert
    assertTrue((new DbCopier("Src Dir", "Dst Dir", "Name")).doCopy());
  }

  /**
   * Test DbCopier {@link DbCopier#name()}.
   * <p>
   * Method under test: {@link DbCopier#name()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DbCopier.name()"})
  public void testDbCopierName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DbCopier("Src Dir", "Dst Dir", "Name")).name());
  }

  /**
   * Test DbCopier {@link DbCopier#DbCopier(String, String, String)}.
   * <p>
   * Method under test: {@link DbCopier#DbCopier(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: default or parameterless constructor of {@link DbCopy}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbCopy.<init>()"})
  public void testNewDbCopy() {
    // Arrange, Act and Assert
    assertNull((new DbCopy()).spec);
  }
}
