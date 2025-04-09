package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbArchive.ArchiveManifest;

public class DbArchiveDiffblueTest {
  /**
   * Test ArchiveManifest {@link ArchiveManifest#checkManifest(String)}.
   * <p>
   * Method under test: {@link ArchiveManifest#checkManifest(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArchiveManifest.checkManifest(String)"})
  public void testArchiveManifestCheckManifest() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 3, 3)).checkManifest("Dir"));
  }

  /**
   * Test ArchiveManifest {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArchiveManifest.<init>(String, String, int, int)"})
  public void testArchiveManifestNewArchiveManifest_whenMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", -1, 0)).checkManifest("Dir"));
  }

  /**
   * Test ArchiveManifest {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArchiveManifest.<init>(String, String, int, int)"})
  public void testArchiveManifestNewArchiveManifest_whenThree() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 3, 3)).checkManifest("Dir"));
  }

  /**
   * Test ArchiveManifest {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArchiveManifest.<init>(String, String, int, int)"})
  public void testArchiveManifestNewArchiveManifest_whenZero() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 0, -1)).checkManifest("Dir"));
  }

  /**
   * Test ArchiveManifest {@link ArchiveManifest#newDefaultLevelDbOptions()}.
   * <p>
   * Method under test: {@link ArchiveManifest#newDefaultLevelDbOptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Options ArchiveManifest.newDefaultLevelDbOptions()"})
  public void testArchiveManifestNewDefaultLevelDbOptions() {
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
   * Test new {@link DbArchive} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link DbArchive}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbArchive.<init>()"})
  public void testNewDbArchive() {
    // Arrange, Act and Assert
    assertNull((new DbArchive()).spec);
  }
}
