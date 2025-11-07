package org.tron.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DbBackupConfigDiffblueTest {
  /**
   * Method under test: {@link DbBackupConfig#getInstance()}
   */
  @Test
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
   * Method under test:
   * {@link DbBackupConfig#initArgs(boolean, String, String, String, int)}
   */
  @Test
  public void testInitArgs() {
    // Arrange
    DbBackupConfig instance = DbBackupConfig.getInstance();

    // Act and Assert
    assertSame(instance, instance.initArgs(false, "Prop Path", "Bak1path", "Bak2path", 1));
  }

  /**
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Bak1path", actualBak1path);
    assertEquals("Bak2path", actualBak2path);
    assertEquals("Prop Path", actualPropPath);
    assertEquals(1, actualFrequency);
    assertTrue(actualDbBackupConfig.isEnable());
  }
}
