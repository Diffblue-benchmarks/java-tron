package org.tron.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DbBackupConfigDiffblueTest {
  /**
   * Test {@link DbBackupConfig#getInstance()}.
   *
   * <p>Method under test: {@link DbBackupConfig#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DbBackupConfig DbBackupConfig.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    DbBackupConfig actualInstance = DbBackupConfig.getInstance();

    // Assert
    assertNull(actualInstance.getBak1path());
    assertNull(actualInstance.getBak2path());
    assertNull(actualInstance.getPropPath());
    assertEquals(0, actualInstance.getFrequency());
    assertFalse(actualInstance.isEnable());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DbBackupConfig}
   *   <li>{@link DbBackupConfig#setBak1path(String)}
   *   <li>{@link DbBackupConfig#setBak2path(String)}
   *   <li>{@link DbBackupConfig#setEnable(boolean)}
   *   <li>{@link DbBackupConfig#setFrequency(int)}
   *   <li>{@link DbBackupConfig#setPropPath(String)}
   *   <li>{@link DbBackupConfig#getBak1path()}
   *   <li>{@link DbBackupConfig#getBak2path()}
   *   <li>{@link DbBackupConfig#getFrequency()}
   *   <li>{@link DbBackupConfig#getPropPath()}
   *   <li>{@link DbBackupConfig#isEnable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DbBackupConfig.<init>()",
    "String DbBackupConfig.getBak1path()",
    "String DbBackupConfig.getBak2path()",
    "int DbBackupConfig.getFrequency()",
    "String DbBackupConfig.getPropPath()",
    "boolean DbBackupConfig.isEnable()",
    "void DbBackupConfig.setBak1path(String)",
    "void DbBackupConfig.setBak2path(String)",
    "void DbBackupConfig.setEnable(boolean)",
    "void DbBackupConfig.setFrequency(int)",
    "void DbBackupConfig.setPropPath(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DbBackupConfig actualDbBackupConfig = new DbBackupConfig();
    actualDbBackupConfig.setBak1path("Bak1path");
    actualDbBackupConfig.setBak2path("Bak2path");
    actualDbBackupConfig.setEnable(true);
    actualDbBackupConfig.setFrequency(1);
    actualDbBackupConfig.setPropPath("Prop Path");
    String actualBak1path = actualDbBackupConfig.getBak1path();
    String actualBak2path = actualDbBackupConfig.getBak2path();
    int actualFrequency = actualDbBackupConfig.getFrequency();
    String actualPropPath = actualDbBackupConfig.getPropPath();

    // Assert
    assertEquals("Bak1path", actualBak1path);
    assertEquals("Bak2path", actualBak2path);
    assertEquals("Prop Path", actualPropPath);
    assertEquals(1, actualFrequency);
    assertTrue(actualDbBackupConfig.isEnable());
  }
}
