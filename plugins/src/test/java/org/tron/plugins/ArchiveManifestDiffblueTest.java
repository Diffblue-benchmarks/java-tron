package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class ArchiveManifestDiffblueTest {
  /**
   * Method under test: {@link ArchiveManifest#call()}
   */
  @Test
  public void testCall() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new ArchiveManifest("Src", "Name", 3, 3)).call());
  }

  /**
   * Method under test: {@link ArchiveManifest#newDefaultLevelDbOptions()}
   */
  @Test
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
   * Method under test: {@link ArchiveManifest#checkManifest(String)}
   */
  @Test
  public void testCheckManifest() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 3, 3)).checkManifest("Dir"));
  }

  /**
   * Method under test: {@link ArchiveManifest#doArchive()}
   */
  @Test
  public void testDoArchive() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new ArchiveManifest("Src", "Name", 3, 3)).doArchive());
  }

  /**
   * Method under test: {@link ArchiveManifest#checkEngine()}
   */
  @Test
  public void testCheckEngine() {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 3, 3)).checkEngine());
  }

  /**
   * Method under test: {@link ArchiveManifest#readProperty(String, String)}
   */
  @Test
  public void testReadProperty() {
    // Arrange, Act and Assert
    assertEquals("", ArchiveManifest.readProperty("File", "Key"));
  }

  /**
   * Method under test:
   * {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  public void testNewArchiveManifest() throws Exception {
    // Arrange and Act
    ArchiveManifest actualArchiveManifest = new ArchiveManifest("Src", "Name", 3, 3);

    // Assert
    assertFalse(actualArchiveManifest.checkEngine());
    assertTrue(actualArchiveManifest.call());
    assertTrue(actualArchiveManifest.doArchive());
  }

  /**
   * Method under test:
   * {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  public void testNewArchiveManifest2() throws Exception {
    // Arrange and Act
    ArchiveManifest actualArchiveManifest = new ArchiveManifest("Src", "Name", 0, -1);

    // Assert
    assertFalse(actualArchiveManifest.checkEngine());
    assertTrue(actualArchiveManifest.call());
    assertTrue(actualArchiveManifest.doArchive());
  }

  /**
   * Method under test:
   * {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  public void testNewArchiveManifest3() throws Exception {
    // Arrange and Act
    ArchiveManifest actualArchiveManifest = new ArchiveManifest("Src", "Name", -1, 0);

    // Assert
    assertFalse(actualArchiveManifest.checkEngine());
    assertTrue(actualArchiveManifest.call());
    assertTrue(actualArchiveManifest.doArchive());
  }
}
