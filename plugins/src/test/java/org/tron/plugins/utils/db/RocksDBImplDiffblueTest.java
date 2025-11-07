package org.tron.plugins.utils.db;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.rocksdb.RocksDB;

public class RocksDBImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RocksDBImpl#RocksDBImpl(RocksDB, String)}
   *   <li>{@link RocksDBImpl#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RocksDBImpl.<init>(RocksDB, String)", "String RocksDBImpl.getName()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new RocksDBImpl(null, "Name")).getName());
  }
}
