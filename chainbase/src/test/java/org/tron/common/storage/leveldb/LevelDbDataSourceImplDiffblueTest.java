package org.tron.common.storage.leveldb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LevelDbDataSourceImplDiffblueTest {
  /**
   * Test {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()}.
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LevelDbDataSourceImpl.<init>()"})
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

  /**
   * Test {@link LevelDbDataSourceImpl#initDB()}.
   * <ul>
   *   <li>Given {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#initDB()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LevelDbDataSourceImpl.initDB()"})
  public void testInitDB_givenLevelDbDataSourceImpl_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new LevelDbDataSourceImpl()).initDB());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#initDB()}.
   * <ul>
   *   <li>Then {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()} Alive.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#initDB()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LevelDbDataSourceImpl.initDB()"})
  public void testInitDB_thenLevelDbDataSourceImplAlive() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();
    levelDbDataSourceImpl.setDBName("");

    // Act
    levelDbDataSourceImpl.initDB();

    // Assert
    assertTrue(levelDbDataSourceImpl.isAlive());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#getDbPath()}.
   * <ul>
   *   <li>Given {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()} DBName is {@code Name}.</li>
   *   <li>Then return toFile Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#getDbPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.nio.file.Path LevelDbDataSourceImpl.getDbPath()"})
  public void testGetDbPath_givenLevelDbDataSourceImplDBNameIsName_thenReturnToFileNameIsName() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();
    levelDbDataSourceImpl.setDBName("Name");

    // Act and Assert
    File toFileResult = levelDbDataSourceImpl.getDbPath().toFile();
    assertEquals("Name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#resetDb()}.
   * <ul>
   *   <li>Then {@link LevelDbDataSourceImpl#LevelDbDataSourceImpl()} Alive.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#resetDb()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LevelDbDataSourceImpl.resetDb()"})
  public void testResetDb_thenLevelDbDataSourceImplAlive() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();
    levelDbDataSourceImpl.setDBName("");

    // Act
    levelDbDataSourceImpl.resetDb();

    // Assert
    assertTrue(levelDbDataSourceImpl.isAlive());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LevelDbDataSourceImpl.getDBName()", "String LevelDbDataSourceImpl.getEngine()",
      "String LevelDbDataSourceImpl.getName()", "boolean LevelDbDataSourceImpl.isAlive()",
      "void LevelDbDataSourceImpl.setDBName(String)"})
  public void testGettersAndSetters() {
    // Arrange
    LevelDbDataSourceImpl levelDbDataSourceImpl = new LevelDbDataSourceImpl();

    // Act
    levelDbDataSourceImpl.setDBName("Name");
    String actualDBName = levelDbDataSourceImpl.getDBName();
    String actualEngine = levelDbDataSourceImpl.getEngine();
    String actualName = levelDbDataSourceImpl.getName();

    // Assert
    assertEquals("LEVELDB", actualEngine);
    assertEquals("Name", actualDBName);
    assertEquals("Name", actualName);
    assertFalse(levelDbDataSourceImpl.isAlive());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#getlatestValues(long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#getlatestValues(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set LevelDbDataSourceImpl.getlatestValues(long)"})
  public void testGetlatestValues_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LevelDbDataSourceImpl()).getlatestValues(0L).isEmpty());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#getValuesNext(byte[], long)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#getValuesNext(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set LevelDbDataSourceImpl.getValuesNext(byte[], long)"})
  public void testGetValuesNext_whenA_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new LevelDbDataSourceImpl()).getValuesNext(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0L).isEmpty());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#getKeysNext(byte[], long)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#getKeysNext(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List LevelDbDataSourceImpl.getKeysNext(byte[], long)"})
  public void testGetKeysNext_whenA_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new LevelDbDataSourceImpl()).getKeysNext(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0L).isEmpty());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#getNext(byte[], long)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#getNext(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map LevelDbDataSourceImpl.getNext(byte[], long)"})
  public void testGetNext_whenA_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LevelDbDataSourceImpl()).getNext(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0L).isEmpty());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#flush()}.
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LevelDbDataSourceImpl.flush()"})
  public void testFlush() {
    // Arrange, Act and Assert
    assertFalse((new LevelDbDataSourceImpl()).flush());
  }

  /**
   * Test {@link LevelDbDataSourceImpl#getStats()}.
   * <p>
   * Method under test: {@link LevelDbDataSourceImpl#getStats()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List LevelDbDataSourceImpl.getStats()"})
  public void testGetStats() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new LevelDbDataSourceImpl()).getStats().isEmpty());
  }
}
