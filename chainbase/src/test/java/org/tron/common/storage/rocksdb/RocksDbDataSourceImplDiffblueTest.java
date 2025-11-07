package org.tron.common.storage.rocksdb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class RocksDbDataSourceImplDiffblueTest {
  /**
   * Method under test: {@link RocksDbDataSourceImpl#getDbPath()}
   */
  @Test
  public void testGetDbPath() {
    // Arrange, Act and Assert
    File toFileResult = (new RocksDbDataSourceImpl("Parent Path", "Name")).getDbPath().toFile();
    assertEquals("Name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#getData(byte[])}
   */
  @Test
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange
    RocksDbDataSourceImpl rocksDbDataSourceImpl = new RocksDbDataSourceImpl("Parent Path", "Name");

    // Act and Assert
    assertNull(rocksDbDataSourceImpl.getData("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#flush()}
   */
  @Test
  public void testFlush() {
    // Arrange, Act and Assert
    assertFalse((new RocksDbDataSourceImpl("Parent Path", "Name")).flush());
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#getKeysNext(byte[], long)}
   */
  @Test
  public void testGetKeysNext() throws UnsupportedEncodingException {
    // Arrange
    RocksDbDataSourceImpl rocksDbDataSourceImpl = new RocksDbDataSourceImpl("Parent Path", "Name");

    // Act and Assert
    assertTrue(rocksDbDataSourceImpl.getKeysNext("AXAXAXAX".getBytes("UTF-8"), 1L).isEmpty());
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#getNext(byte[], long)}
   */
  @Test
  public void testGetNext() throws UnsupportedEncodingException {
    // Arrange
    RocksDbDataSourceImpl rocksDbDataSourceImpl = new RocksDbDataSourceImpl("Parent Path", "Name");

    // Act and Assert
    assertNull(rocksDbDataSourceImpl.getNext("AXAXAXAX".getBytes("UTF-8"), 1L));
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#prefixQuery(byte[])}
   */
  @Test
  public void testPrefixQuery() throws UnsupportedEncodingException {
    // Arrange
    RocksDbDataSourceImpl rocksDbDataSourceImpl = new RocksDbDataSourceImpl("Parent Path", "Name");

    // Act and Assert
    assertNull(rocksDbDataSourceImpl.prefixQuery("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#getlatestValues(long)}
   */
  @Test
  public void testGetlatestValues() {
    // Arrange, Act and Assert
    assertNull((new RocksDbDataSourceImpl("Parent Path", "Name")).getlatestValues(1L));
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#getValuesNext(byte[], long)}
   */
  @Test
  public void testGetValuesNext() throws UnsupportedEncodingException {
    // Arrange
    RocksDbDataSourceImpl rocksDbDataSourceImpl = new RocksDbDataSourceImpl("Parent Path", "Name");

    // Act and Assert
    assertNull(rocksDbDataSourceImpl.getValuesNext("AXAXAXAX".getBytes("UTF-8"), 1L));
  }

  /**
   * Method under test: {@link RocksDbDataSourceImpl#getStats()}
   */
  @Test
  public void testGetStats() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new RocksDbDataSourceImpl("Parent Path", "Name")).getStats().isEmpty());
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() throws RuntimeException {
    // Arrange and Act
    RocksDbDataSourceImpl actualRocksDbDataSourceImpl = new RocksDbDataSourceImpl();
    actualRocksDbDataSourceImpl.setDBName("Name");
    actualRocksDbDataSourceImpl.getDBName();
    actualRocksDbDataSourceImpl.getDatabase();
    String actualEngine = actualRocksDbDataSourceImpl.getEngine();
    actualRocksDbDataSourceImpl.getName();
    long actualTotal = actualRocksDbDataSourceImpl.getTotal();

    // Assert that nothing has changed
    assertEquals("ROCKSDB", actualEngine);
    assertEquals(0L, actualTotal);
    assertFalse(actualRocksDbDataSourceImpl.isAlive());
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters2() throws RuntimeException {
    // Arrange and Act
    RocksDbDataSourceImpl actualRocksDbDataSourceImpl = new RocksDbDataSourceImpl("Parent Path", "Name");
    actualRocksDbDataSourceImpl.setDBName("Name");
    String actualDBName = actualRocksDbDataSourceImpl.getDBName();
    actualRocksDbDataSourceImpl.getDatabase();
    String actualEngine = actualRocksDbDataSourceImpl.getEngine();
    String actualName = actualRocksDbDataSourceImpl.getName();
    long actualTotal = actualRocksDbDataSourceImpl.getTotal();

    // Assert that nothing has changed
    assertEquals("Name", actualDBName);
    assertEquals("Name", actualName);
    assertEquals("ROCKSDB", actualEngine);
    assertEquals(0L, actualTotal);
    assertFalse(actualRocksDbDataSourceImpl.isAlive());
  }
}
