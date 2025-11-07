package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class DbArchiveDiffblueTest {
  /**
   * Method under test: {@link DbArchive.ArchiveManifest#checkManifest(String)}
   */
  @Test
  public void testArchiveManifestCheckManifest() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new DbArchive.ArchiveManifest("Src", "Name", 3, 3)).checkManifest("Dir"));
  }

  /**
   * Method under test:
   * {@link DbArchive.ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  public void testArchiveManifestNewArchiveManifest() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new DbArchive.ArchiveManifest("Src", "Name", 3, 3)).checkManifest("Dir"));
    assertFalse((new DbArchive.ArchiveManifest("Src", "Name", 0, -1)).checkManifest("Dir"));
    assertFalse((new DbArchive.ArchiveManifest("Src", "Name", -1, 0)).checkManifest("Dir"));
  }

  /**
   * Method under test:
   * {@link DbArchive.ArchiveManifest#newDefaultLevelDbOptions()}
   */
  @Test
  public void testArchiveManifestNewDefaultLevelDbOptions() {
    // Arrange and Act
    Options actualNewDefaultLevelDbOptionsResult = DbArchive.ArchiveManifest.newDefaultLevelDbOptions();

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
   * Method under test: default or parameterless constructor of {@link DbArchive}
   */
  @Test
  public void testNewDbArchive() {
    // Arrange, Act and Assert
    assertNull((new DbArchive()).spec);
  }
}
