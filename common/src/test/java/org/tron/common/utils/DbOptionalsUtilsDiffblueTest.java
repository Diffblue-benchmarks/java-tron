package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.DBComparator;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class DbOptionalsUtilsDiffblueTest {
  /**
   * Method under test: {@link DbOptionalsUtils#createDefaultDbOptions()}
   */
  @Test
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
    assertEquals(DbOptionalsUtils.DEFAULT_BLOCK_SIZE, actualCreateDefaultDbOptionsResult.blockSize());
    assertEquals(DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualCreateDefaultDbOptionsResult.cacheSize());
    assertEquals(DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualCreateDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE, actualCreateDefaultDbOptionsResult.writeBufferSize());
  }

  /**
   * Method under test:
   * {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  public void testNewDefaultDbOptions() {
    // Arrange and Act
    Options actualNewDefaultDbOptionsResult = DbOptionalsUtils.newDefaultDbOptions("Name",
        DbOptionalsUtils.createDefaultDbOptions());

    // Assert
    assertNull(actualNewDefaultDbOptionsResult.comparator());
    assertNull(actualNewDefaultDbOptionsResult.logger());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultDbOptionsResult.blockRestartInterval());
    assertEquals(DbOptionalsUtils.DEFAULT_BLOCK_SIZE, actualNewDefaultDbOptionsResult.blockSize());
    assertEquals(DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE, actualNewDefaultDbOptionsResult.writeBufferSize());
  }

  /**
   * Method under test:
   * {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  public void testNewDefaultDbOptions2() {
    // Arrange and Act
    Options actualNewDefaultDbOptionsResult = DbOptionalsUtils.newDefaultDbOptions("delegation",
        DbOptionalsUtils.createDefaultDbOptions());

    // Assert
    assertNull(actualNewDefaultDbOptionsResult.comparator());
    assertNull(actualNewDefaultDbOptionsResult.logger());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultDbOptionsResult.blockRestartInterval());
    assertEquals(DbOptionalsUtils.DEFAULT_BLOCK_SIZE, actualNewDefaultDbOptionsResult.blockSize());
    assertEquals(DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE_M, actualNewDefaultDbOptionsResult.writeBufferSize());
  }

  /**
   * Method under test:
   * {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  public void testNewDefaultDbOptions3() {
    // Arrange and Act
    Options actualNewDefaultDbOptionsResult = DbOptionalsUtils.newDefaultDbOptions("Name", new Options());

    // Assert
    assertNull(actualNewDefaultDbOptionsResult.comparator());
    assertNull(actualNewDefaultDbOptionsResult.logger());
    assertEquals(0L, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(1000, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(4194304, actualNewDefaultDbOptionsResult.writeBufferSize());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultDbOptionsResult.errorIfExists());
    assertFalse(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultDbOptionsResult.blockRestartInterval());
    assertEquals(DbOptionalsUtils.DEFAULT_BLOCK_SIZE, actualNewDefaultDbOptionsResult.blockSize());
  }

  /**
   * Method under test:
   * {@link DbOptionalsUtils#newDefaultDbOptions(String, Options)}
   */
  @Test
  public void testNewDefaultDbOptions4() {
    // Arrange
    Options defaultOptions = DbOptionalsUtils.createDefaultDbOptions();
    defaultOptions.comparator(mock(DBComparator.class));

    // Act
    Options actualNewDefaultDbOptionsResult = DbOptionalsUtils.newDefaultDbOptions("Name", defaultOptions);

    // Assert
    assertNull(actualNewDefaultDbOptionsResult.comparator());
    assertNull(actualNewDefaultDbOptionsResult.logger());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultDbOptionsResult.blockRestartInterval());
    assertEquals(DbOptionalsUtils.DEFAULT_BLOCK_SIZE, actualNewDefaultDbOptionsResult.blockSize());
    assertEquals(DbOptionalsUtils.DEFAULT_CACHE_SIZE, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(DbOptionalsUtils.DEFAULT_MAX_OPEN_FILES, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(DbOptionalsUtils.DEFAULT_WRITE_BUFFER_SIZE, actualNewDefaultDbOptionsResult.writeBufferSize());
  }
}
