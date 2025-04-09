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

public class ArchiveManifestDiffblueTest {
  /**
   * Test {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArchiveManifest.<init>(String, String, int, int)"})
  public void testNewArchiveManifest_whenMinusOne() throws Exception {
    // Arrange and Act
    ArchiveManifest actualArchiveManifest = new ArchiveManifest("Src", "Name", -1, 0);

    // Assert
    assertFalse(actualArchiveManifest.checkEngine());
    assertTrue(actualArchiveManifest.call());
    assertTrue(actualArchiveManifest.doArchive());
  }

  /**
   * Test {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArchiveManifest.<init>(String, String, int, int)"})
  public void testNewArchiveManifest_whenThree() throws Exception {
    // Arrange and Act
    ArchiveManifest actualArchiveManifest = new ArchiveManifest("Src", "Name", 3, 3);

    // Assert
    assertFalse(actualArchiveManifest.checkEngine());
    assertTrue(actualArchiveManifest.call());
    assertTrue(actualArchiveManifest.doArchive());
  }

  /**
   * Test {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveManifest#ArchiveManifest(String, String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArchiveManifest.<init>(String, String, int, int)"})
  public void testNewArchiveManifest_whenZero() throws Exception {
    // Arrange and Act
    ArchiveManifest actualArchiveManifest = new ArchiveManifest("Src", "Name", 0, -1);

    // Assert
    assertFalse(actualArchiveManifest.checkEngine());
    assertTrue(actualArchiveManifest.call());
    assertTrue(actualArchiveManifest.doArchive());
  }

  /**
   * Test {@link ArchiveManifest#call()}.
   * <p>
   * Method under test: {@link ArchiveManifest#call()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ArchiveManifest.call()"})
  public void testCall() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new ArchiveManifest("Src", "Name", 3, 3)).call());
  }

  /**
   * Test {@link ArchiveManifest#newDefaultLevelDbOptions()}.
   * <p>
   * Method under test: {@link ArchiveManifest#newDefaultLevelDbOptions()}
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
   * Test {@link ArchiveManifest#checkManifest(String)}.
   * <p>
   * Method under test: {@link ArchiveManifest#checkManifest(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArchiveManifest.checkManifest(String)"})
  public void testCheckManifest() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 3, 3)).checkManifest("Dir"));
  }

  /**
   * Test {@link ArchiveManifest#doArchive()}.
   * <p>
   * Method under test: {@link ArchiveManifest#doArchive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArchiveManifest.doArchive()"})
  public void testDoArchive() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new ArchiveManifest("Src", "Name", 3, 3)).doArchive());
  }

  /**
   * Test {@link ArchiveManifest#checkEngine()}.
   * <p>
   * Method under test: {@link ArchiveManifest#checkEngine()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArchiveManifest.checkEngine()"})
  public void testCheckEngine() {
    // Arrange, Act and Assert
    assertFalse((new ArchiveManifest("Src", "Name", 3, 3)).checkEngine());
  }

  /**
   * Test {@link ArchiveManifest#readProperty(String, String)}.
   * <p>
   * Method under test: {@link ArchiveManifest#readProperty(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArchiveManifest.readProperty(String, String)"})
  public void testReadProperty() {
    // Arrange, Act and Assert
    assertEquals("", ArchiveManifest.readProperty("File", "Key"));
  }
}
