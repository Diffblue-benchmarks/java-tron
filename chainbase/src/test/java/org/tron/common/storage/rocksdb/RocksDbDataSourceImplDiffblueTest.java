package org.tron.common.storage.rocksdb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.rocksdb.RocksDB;
import org.tron.core.db2.common.WrappedByteArray;

public class RocksDbDataSourceImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return DBName is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RocksDbDataSourceImpl#RocksDbDataSourceImpl()}
   *   <li>{@link RocksDbDataSourceImpl#setDBName(String)}
   *   <li>{@link RocksDbDataSourceImpl#getDBName()}
   *   <li>{@link RocksDbDataSourceImpl#getDatabase()}
   *   <li>{@link RocksDbDataSourceImpl#getEngine()}
   *   <li>{@link RocksDbDataSourceImpl#getName()}
   *   <li>{@link RocksDbDataSourceImpl#getTotal()}
   *   <li>{@link RocksDbDataSourceImpl#isAlive()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RocksDbDataSourceImpl.<init>()",
    "void RocksDbDataSourceImpl.<init>(String, String)",
    "String RocksDbDataSourceImpl.getDBName()",
    "RocksDB RocksDbDataSourceImpl.getDatabase()",
    "String RocksDbDataSourceImpl.getEngine()",
    "String RocksDbDataSourceImpl.getName()",
    "long RocksDbDataSourceImpl.getTotal()",
    "boolean RocksDbDataSourceImpl.isAlive()",
    "void RocksDbDataSourceImpl.setDBName(String)"
  })
  public void testGettersAndSetters_thenReturnDBNameIsNull() throws RuntimeException {
    // Arrange and Act
    RocksDbDataSourceImpl actualRocksDbDataSourceImpl = new RocksDbDataSourceImpl();
    actualRocksDbDataSourceImpl.setDBName("Name");
    String actualDBName = actualRocksDbDataSourceImpl.getDBName();
    RocksDB actualDatabase = actualRocksDbDataSourceImpl.getDatabase();
    String actualEngine = actualRocksDbDataSourceImpl.getEngine();
    String actualName = actualRocksDbDataSourceImpl.getName();
    long actualTotal = actualRocksDbDataSourceImpl.getTotal();

    // Assert
    assertEquals("ROCKSDB", actualEngine);
    assertNull(actualDBName);
    assertNull(actualName);
    assertNull(actualDatabase);
    assertEquals(0L, actualTotal);
    assertFalse(actualRocksDbDataSourceImpl.isAlive());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Parent Path}.
   *   <li>Then return DBName is {@code Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RocksDbDataSourceImpl#RocksDbDataSourceImpl(String, String)}
   *   <li>{@link RocksDbDataSourceImpl#setDBName(String)}
   *   <li>{@link RocksDbDataSourceImpl#getDBName()}
   *   <li>{@link RocksDbDataSourceImpl#getDatabase()}
   *   <li>{@link RocksDbDataSourceImpl#getEngine()}
   *   <li>{@link RocksDbDataSourceImpl#getName()}
   *   <li>{@link RocksDbDataSourceImpl#getTotal()}
   *   <li>{@link RocksDbDataSourceImpl#isAlive()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RocksDbDataSourceImpl.<init>()",
    "void RocksDbDataSourceImpl.<init>(String, String)",
    "String RocksDbDataSourceImpl.getDBName()",
    "RocksDB RocksDbDataSourceImpl.getDatabase()",
    "String RocksDbDataSourceImpl.getEngine()",
    "String RocksDbDataSourceImpl.getName()",
    "long RocksDbDataSourceImpl.getTotal()",
    "boolean RocksDbDataSourceImpl.isAlive()",
    "void RocksDbDataSourceImpl.setDBName(String)"
  })
  public void testGettersAndSetters_whenParentPath_thenReturnDBNameIsName()
      throws RuntimeException {
    // Arrange and Act
    RocksDbDataSourceImpl actualRocksDbDataSourceImpl =
        new RocksDbDataSourceImpl("Parent Path", "Name");
    actualRocksDbDataSourceImpl.setDBName("Name");
    String actualDBName = actualRocksDbDataSourceImpl.getDBName();
    RocksDB actualDatabase = actualRocksDbDataSourceImpl.getDatabase();
    String actualEngine = actualRocksDbDataSourceImpl.getEngine();
    String actualName = actualRocksDbDataSourceImpl.getName();
    long actualTotal = actualRocksDbDataSourceImpl.getTotal();

    // Assert
    assertEquals("Name", actualDBName);
    assertEquals("Name", actualName);
    assertEquals("ROCKSDB", actualEngine);
    assertNull(actualDatabase);
    assertEquals(0L, actualTotal);
    assertFalse(actualRocksDbDataSourceImpl.isAlive());
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getDbPath()}.
   *
   * <ul>
   *   <li>Then return toFile Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getDbPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.nio.file.Path RocksDbDataSourceImpl.getDbPath()"})
  public void testGetDbPath_thenReturnToFileNameIsName() {
    // Arrange, Act and Assert
    File toFileResult = new RocksDbDataSourceImpl("Parent Path", "Name").getDbPath().toFile();
    assertEquals("Name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getData(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] RocksDbDataSourceImpl.getData(byte[])"})
  public void testGetDataWithByte() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData =
        new RocksDbDataSourceImpl("Parent Path", "Name").getData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualData);
  }

  /**
   * Test {@link RocksDbDataSourceImpl#flush()}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RocksDbDataSourceImpl.flush()"})
  public void testFlush() {
    // Arrange, Act and Assert
    assertFalse(new RocksDbDataSourceImpl("Parent Path", "Name").flush());
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getKeysNext(byte[], long)}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getKeysNext(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List RocksDbDataSourceImpl.getKeysNext(byte[], long)"})
  public void testGetKeysNext() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        new RocksDbDataSourceImpl("Parent Path", "Name")
            .getKeysNext("AXAXAXAX".getBytes("UTF-8"), 1L)
            .isEmpty());
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getNext(byte[], long)}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getNext(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map RocksDbDataSourceImpl.getNext(byte[], long)"})
  public void testGetNext() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new RocksDbDataSourceImpl("Parent Path", "Name").getNext("AXAXAXAX".getBytes("UTF-8"), 1L));
  }

  /**
   * Test {@link RocksDbDataSourceImpl#prefixQuery(byte[])}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#prefixQuery(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map RocksDbDataSourceImpl.prefixQuery(byte[])"})
  public void testPrefixQuery() throws UnsupportedEncodingException {
    // Arrange and Act
    Map<WrappedByteArray, byte[]> actualPrefixQueryResult =
        new RocksDbDataSourceImpl("Parent Path", "Name").prefixQuery("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPrefixQueryResult);
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getlatestValues(long)}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getlatestValues(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set RocksDbDataSourceImpl.getlatestValues(long)"})
  public void testGetlatestValues() {
    // Arrange, Act and Assert
    assertNull(new RocksDbDataSourceImpl("Parent Path", "Name").getlatestValues(1L));
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getValuesNext(byte[], long)}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getValuesNext(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set RocksDbDataSourceImpl.getValuesNext(byte[], long)"})
  public void testGetValuesNext() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new RocksDbDataSourceImpl("Parent Path", "Name")
            .getValuesNext("AXAXAXAX".getBytes("UTF-8"), 1L));
  }

  /**
   * Test {@link RocksDbDataSourceImpl#getStats()}.
   *
   * <p>Method under test: {@link RocksDbDataSourceImpl#getStats()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List RocksDbDataSourceImpl.getStats()"})
  public void testGetStats() throws Exception {
    // Arrange, Act and Assert
    assertTrue(new RocksDbDataSourceImpl("Parent Path", "Name").getStats().isEmpty());
  }
}
