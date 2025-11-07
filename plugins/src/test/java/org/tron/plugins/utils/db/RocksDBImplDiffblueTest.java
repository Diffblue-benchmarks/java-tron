package org.tron.plugins.utils.db;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.rocksdb.RocksDB;

public class RocksDBImplDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RocksDBImpl#RocksDBImpl(RocksDB, String)}
   *   <li>{@link RocksDBImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new RocksDBImpl(null, "Name")).getName());
  }
}
