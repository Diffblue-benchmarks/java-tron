package org.tron.common.storage.leveldb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.junit.Test;

public class LevelDbDataSourceImplDiffblueTest {
  /**
   * Method under test: {@link LevelDbDataSourceImpl#initDB()}
   */
  @Test
  public void testInitDB() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new LevelDbDataSourceImpl()).initDB());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#initDB()}
   */
  @Test
  public void testInitDB2() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();
    levelDbDataSourceImpl.setDBName("");

    // Act
    levelDbDataSourceImpl.initDB();

    // Assert
    assertTrue(levelDbDataSourceImpl.isAlive());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#getDbPath()}
   */
  @Test
  public void testGetDbPath() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();
    levelDbDataSourceImpl.setDBName("Name");

    // Act and Assert
    File toFileResult = levelDbDataSourceImpl.getDbPath().toFile();
    assertEquals("Name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#resetDb()}
   */
  @Test
  public void testResetDb() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();
    levelDbDataSourceImpl.setDBName("");

    // Act
    levelDbDataSourceImpl.resetDb();

    // Assert
    assertTrue(levelDbDataSourceImpl.isAlive());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#getlatestValues(long)}
   */
  @Test
  public void testGetlatestValues() {
    // Arrange, Act and Assert
    assertTrue((new LevelDbDataSourceImpl()).getlatestValues(0L).isEmpty());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#getValuesNext(byte[], long)}
   */
  @Test
  public void testGetValuesNext() {
    // Arrange, Act and Assert
    assertTrue(
        (new LevelDbDataSourceImpl()).getValuesNext(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0L).isEmpty());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#getKeysNext(byte[], long)}
   */
  @Test
  public void testGetKeysNext() {
    // Arrange, Act and Assert
    assertTrue(
        (new LevelDbDataSourceImpl()).getKeysNext(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0L).isEmpty());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#getNext(byte[], long)}
   */
  @Test
  public void testGetNext() {
    // Arrange, Act and Assert
    assertTrue((new LevelDbDataSourceImpl()).getNext(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0L).isEmpty());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#flush()}
   */
  @Test
  public void testFlush() {
    // Arrange, Act and Assert
    assertFalse((new LevelDbDataSourceImpl()).flush());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#getStats()}
   */
  @Test
  public void testGetStats() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new LevelDbDataSourceImpl()).getStats().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LevelDbDataSourceImpl#setDBName(String)}
   *   <li>{@link LevelDbDataSourceImpl#getDBName()}
   *   <li>{@link LevelDbDataSourceImpl#getEngine()}
   *   <li>{@link LevelDbDataSourceImpl#getName()}
   *   <li>{@link LevelDbDataSourceImpl#isAlive()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();

    // Act
    levelDbDataSourceImpl.setDBName("Name");
    String actualDBName = levelDbDataSourceImpl.getDBName();
    String actualEngine = levelDbDataSourceImpl.getEngine();
    String actualName = levelDbDataSourceImpl.getName();

    // Assert that nothing has changed
    assertEquals("LEVELDB", actualEngine);
    assertEquals("Name", actualDBName);
    assertEquals("Name", actualName);
    assertFalse(levelDbDataSourceImpl.isAlive());
  }

  /**
   * Method under test: {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()}
   */
  @Test
  public void testNewLevelDbDataSourceImpl() throws Exception {
    // Arrange and Act
    LevelDbDataSourceImpl actualLevelDbDataSourceImpl = new LevelDbDataSourceImpl();

    // Assert
    assertEquals("LEVELDB", actualLevelDbDataSourceImpl.getEngine());
    assertNull(actualLevelDbDataSourceImpl.getDBName());
    assertNull(actualLevelDbDataSourceImpl.getName());
    assertFalse(actualLevelDbDataSourceImpl.flush());
    assertFalse(actualLevelDbDataSourceImpl.isAlive());
    assertTrue(actualLevelDbDataSourceImpl.getStats().isEmpty());
  }
}
