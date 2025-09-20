package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ArchiveManifestDiffblueTest {
  /**
   * Test {@link ArchiveManifest#newDefaultLevelDbOptions()}.
   *
   * <p>Method under test: {@link ArchiveManifest#newDefaultLevelDbOptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Options ArchiveManifest.newDefaultLevelDbOptions()"})
  public void testNewDefaultLevelDbOptions() {
    // Arrange and Act
    Options actualNewDefaultLevelDbOptionsResult = ArchiveManifest.newDefaultLevelDbOptions();

    // Assert
    assertNull(actualNewDefaultLevelDbOptionsResult.comparator());
    assertNull(actualNewDefaultLevelDbOptionsResult.logger());
    assertEquals(1000, actualNewDefaultLevelDbOptionsResult.maxOpenFiles());
    assertEquals(10485760, actualNewDefaultLevelDbOptionsResult.writeBufferSize());
    assertEquals(10485760L, actualNewDefaultLevelDbOptionsResult.cacheSize());
    assertEquals(128, actualNewDefaultLevelDbOptionsResult.maxManifestSize());
    assertEquals(4096, actualNewDefaultLevelDbOptionsResult.blockSize());
    assertEquals(64000, actualNewDefaultLevelDbOptionsResult.maxBatchSize());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultLevelDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultLevelDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultLevelDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultLevelDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultLevelDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultLevelDbOptionsResult.blockRestartInterval());
  }

  /**
   * Test {@link ArchiveManifest#readProperty(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ArchiveManifest#readProperty(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArchiveManifest.readProperty(String, String)"})
  public void testReadProperty_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ArchiveManifest.readProperty("", "Key"));
  }

  /**
   * Test {@link ArchiveManifest#readProperty(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ArchiveManifest#readProperty(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArchiveManifest.readProperty(String, String)"})
  public void testReadProperty_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ArchiveManifest.readProperty("File", null));
  }
}
