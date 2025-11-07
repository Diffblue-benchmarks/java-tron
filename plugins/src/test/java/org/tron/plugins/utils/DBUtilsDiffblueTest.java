package org.tron.plugins.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class DBUtilsDiffblueTest {
  /**
   * Method under test: {@link DBUtils#newDefaultLevelDbOptions()}
   */
  @Test
  public void testNewDefaultLevelDbOptions() {
    // Arrange and Act
    Options actualNewDefaultLevelDbOptionsResult = DBUtils.newDefaultLevelDbOptions();

    // Assert
    assertNull(actualNewDefaultLevelDbOptionsResult.comparator());
    assertNull(actualNewDefaultLevelDbOptionsResult.logger());
    assertEquals(0, actualNewDefaultLevelDbOptionsResult.maxManifestSize());
    assertEquals(1000, actualNewDefaultLevelDbOptionsResult.maxOpenFiles());
    assertEquals(10485760, actualNewDefaultLevelDbOptionsResult.writeBufferSize());
    assertEquals(10485760L, actualNewDefaultLevelDbOptionsResult.cacheSize());
    assertEquals(4096, actualNewDefaultLevelDbOptionsResult.blockSize());
    assertEquals(80000, actualNewDefaultLevelDbOptionsResult.maxBatchSize());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultLevelDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultLevelDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultLevelDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultLevelDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultLevelDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultLevelDbOptionsResult.blockRestartInterval());
  }

  /**
   * Method under test: {@link DBUtils.Operator#getValue()}
   */
  @Test
  public void testOperatorGetValue() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, DBUtils.Operator.valueOf("CREATE").getValue());
  }

  /**
   * Method under test: {@link DBUtils.Operator#valueOf(byte)}
   */
  @Test
  public void testOperatorValueOf() {
    // Arrange, Act and Assert
    assertNull(DBUtils.Operator.valueOf((byte) 'A'));
    assertEquals(DBUtils.Operator.CREATE, DBUtils.Operator.valueOf((byte) 0));
    assertEquals(DBUtils.Operator.MODIFY, DBUtils.Operator.valueOf((byte) 1));
    assertEquals(DBUtils.Operator.DELETE, DBUtils.Operator.valueOf((byte) 2));
    assertEquals(DBUtils.Operator.PUT, DBUtils.Operator.valueOf((byte) 3));
  }
}
