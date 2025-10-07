package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DbOptionalsUtilsDiffblueTest {
  /**
   * Test {@link DbOptionalsUtils#createDefaultDbOptions()}.
   *
   * <p>Method under test: {@link DbOptionalsUtils#createDefaultDbOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options DbOptionalsUtils.createDefaultDbOptions()"})
  public void testCreateDefaultDbOptions() {
    // Arrange and Act
    Options actualCreateDefaultDbOptionsResult = DbOptionalsUtils.createDefaultDbOptions();

    // Assert
    assertNull(actualCreateDefaultDbOptionsResult.comparator());
    assertNull(actualCreateDefaultDbOptionsResult.logger());
    assertEquals(CompressionType.SNAPPY, actualCreateDefaultDbOptionsResult.compressionType());
    assertFalse(actualCreateDefaultDbOptionsResult.errorIfExists());
    assertTrue(actualCreateDefaultDbOptionsResult.createIfMissing());
    assertTrue(actualCreateDefaultDbOptionsResult.paranoidChecks());
    assertTrue(actualCreateDefaultDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualCreateDefaultDbOptionsResult.blockRestartInterval());
    assertEquals(
        DbOptionalsUtils.DEFAULT_BLOCK_SIZE, actualCreateDefaultDbOptionsResult.blockSize());
    assertEquals(
        DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualCreateDefaultDbOptionsResult.cacheSize());
    assertEquals(
        DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualCreateDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(
        DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE,
        actualCreateDefaultDbOptionsResult.writeBufferSize());
  }

  /**
   * Test {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}.
   *
   * <ul>
   *   <li>Then return writeBufferSize is {@link DbOptionalsUtils#DEFAULT_WRITE_BUFFER_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options DbOptionalsUtils.newDefaultDbOptions(String, Options)"})
  public void testNewDefaultDbOptions_thenReturnWriteBufferSizeIsDefault_write_buffer_size() {
    // Arrange and Act
    Options actualNewDefaultDbOptionsResult =
        DbOptionalsUtils.newDefaultDbOptions("Name", DbOptionalsUtils.createDefaultDbOptions());

    // Assert
    assertTrue(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertEquals(DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(
        DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(
        DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE,
        actualNewDefaultDbOptionsResult.writeBufferSize());
  }

  /**
   * Test {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}.
   *
   * <ul>
   *   <li>Then return writeBufferSize is {@link DbOptionalsUtils#DEFAULT_WRITE_BUFFER_SIZE_M}.
   * </ul>
   *
   * <p>Method under test: {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options DbOptionalsUtils.newDefaultDbOptions(String, Options)"})
  public void testNewDefaultDbOptions_thenReturnWriteBufferSizeIsDefault_write_buffer_size_m() {
    // Arrange and Act
    Options actualNewDefaultDbOptionsResult =
        DbOptionalsUtils.newDefaultDbOptions(
            "delegation", DbOptionalsUtils.createDefaultDbOptions());

    // Assert
    assertTrue(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertEquals(DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(
        DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(
        DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE_M,
        actualNewDefaultDbOptionsResult.writeBufferSize());
  }

  /**
   * Test {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}.
   *
   * <ul>
   *   <li>When {@link Options} (default constructor).
   *   <li>Then return cacheSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options DbOptionalsUtils.newDefaultDbOptions(String, Options)"})
  public void testNewDefaultDbOptions_whenOptions_thenReturnCacheSizeIsZero() {
    // Arrange and Act
    Options actualNewDefaultDbOptionsResult =
        DbOptionalsUtils.newDefaultDbOptions("Name", new Options());

    // Assert
    assertEquals(0L, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(1000, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(4194304, actualNewDefaultDbOptionsResult.writeBufferSize());
    assertFalse(actualNewDefaultDbOptionsResult.paranoidChecks());
  }
}
