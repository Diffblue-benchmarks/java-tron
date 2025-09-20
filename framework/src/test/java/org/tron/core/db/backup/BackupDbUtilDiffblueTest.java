package org.tron.core.db.backup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db.backup.BackupDbUtil.State;

public class BackupDbUtilDiffblueTest {
  /**
   * Test {@link BackupDbUtil#getDB_BACKUP_STATE_DEFAULT()}.
   *
   * <p>Method under test: {@link BackupDbUtil#getDB_BACKUP_STATE_DEFAULT()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BackupDbUtil.getDB_BACKUP_STATE_DEFAULT()"})
  public void testGetDB_BACKUP_STATE_DEFAULT() {
    // Arrange, Act and Assert
    assertEquals(11, BackupDbUtil.getDB_BACKUP_STATE_DEFAULT());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackupDbUtil#getDB_BACKUP_STATE()}
   *   <li>{@link BackupDbUtil#getDb()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String BackupDbUtil.getDB_BACKUP_STATE()",
    "org.tron.core.db.RevokingDatabase BackupDbUtil.getDb()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BackupDbUtil backupDbUtil = new BackupDbUtil();

    // Act
    String actualDB_BACKUP_STATE = backupDbUtil.getDB_BACKUP_STATE();

    // Assert
    assertEquals("DB", actualDB_BACKUP_STATE);
    assertNull(backupDbUtil.getDb());
  }

  /**
   * Test State {@link State#getStatus()}.
   *
   * <p>Method under test: {@link State#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int State.getStatus()"})
  public void testStateGetStatus() {
    // Arrange, Act and Assert
    assertEquals(1, State.valueOf("BAKINGONE").getStatus());
  }

  /**
   * Test State {@link State#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When eleven.
   *   <li>Then return {@code BAKEDONE}.
   * </ul>
   *
   * <p>Method under test: {@link State#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State State.valueOf(int)"})
  public void testStateValueOfWithValue_whenEleven_thenReturnBakedone() {
    // Arrange, Act and Assert
    assertEquals(State.BAKEDONE, State.valueOf(11));
  }

  /**
   * Test State {@link State#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code BAKEDONE}.
   * </ul>
   *
   * <p>Method under test: {@link State#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State State.valueOf(int)"})
  public void testStateValueOfWithValue_whenFortyTwo_thenReturnBakedone() {
    // Arrange, Act and Assert
    assertEquals(State.BAKEDONE, State.valueOf(42));
  }

  /**
   * Test State {@link State#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code BAKINGONE}.
   * </ul>
   *
   * <p>Method under test: {@link State#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State State.valueOf(int)"})
  public void testStateValueOfWithValue_whenOne_thenReturnBakingone() {
    // Arrange, Act and Assert
    assertEquals(State.BAKINGONE, State.valueOf(1));
  }

  /**
   * Test State {@link State#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When twenty-two.
   *   <li>Then return {@code BAKEDTWO}.
   * </ul>
   *
   * <p>Method under test: {@link State#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State State.valueOf(int)"})
  public void testStateValueOfWithValue_whenTwentyTwo_thenReturnBakedtwo() {
    // Arrange, Act and Assert
    assertEquals(State.BAKEDTWO, State.valueOf(22));
  }

  /**
   * Test State {@link State#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code BAKINGTWO}.
   * </ul>
   *
   * <p>Method under test: {@link State#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State State.valueOf(int)"})
  public void testStateValueOfWithValue_whenTwo_thenReturnBakingtwo() {
    // Arrange, Act and Assert
    assertEquals(State.BAKINGTWO, State.valueOf(2));
  }
}
