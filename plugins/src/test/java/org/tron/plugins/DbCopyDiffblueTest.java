package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DbCopyDiffblueTest {
  /**
   * Method under test: {@link DbCopy.DbCopier#doCopy()}
   */
  @Test
  public void testDbCopierDoCopy() {
    // Arrange, Act and Assert
    assertTrue((new DbCopy.DbCopier("Src Dir", "Dst Dir", "Name")).doCopy());
  }

  /**
   * Method under test: {@link DbCopy.DbCopier#name()}
   */
  @Test
  public void testDbCopierName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DbCopy.DbCopier("Src Dir", "Dst Dir", "Name")).name());
  }

  /**
   * Method under test: {@link DbCopy.DbCopier#DbCopier(String, String, String)}
   */
  @Test
  public void testDbCopierNewDbCopier() {
    // Arrange and Act
    DbCopy.DbCopier actualDbCopier = new DbCopy.DbCopier("Src Dir", "Dst Dir", "Name");

    // Assert
    assertEquals("Name", actualDbCopier.name());
    assertTrue(actualDbCopier.doCopy());
  }

  /**
   * Method under test: default or parameterless constructor of {@link DbCopy}
   */
  @Test
  public void testNewDbCopy() {
    // Arrange, Act and Assert
    assertNull((new DbCopy()).spec);
  }
}
