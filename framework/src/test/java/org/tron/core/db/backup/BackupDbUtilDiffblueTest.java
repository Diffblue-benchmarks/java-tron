package org.tron.core.db.backup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.db.RevokingDatabase;

@RunWith(MockitoJUnitRunner.class)
public class BackupDbUtilDiffblueTest {
  @InjectMocks
  private BackupDbUtil backupDbUtil;

  @Mock
  private RevokingDatabase revokingDatabase;

  /**
   * Method under test: {@link BackupDbUtil#getDB_BACKUP_STATE_DEFAULT()}
   */
  @Test
  public void testGetDB_BACKUP_STATE_DEFAULT() {
    // Arrange, Act and Assert
    assertEquals(11, BackupDbUtil.getDB_BACKUP_STATE_DEFAULT());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackupDbUtil#getDB_BACKUP_STATE()}
   *   <li>{@link BackupDbUtil#getDb()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link BackupDbUtil.State#getStatus()}
   */
  @Test
  public void testStateGetStatus() {
    // Arrange, Act and Assert
    assertEquals(1, BackupDbUtil.State.valueOf("BAKINGONE").getStatus());
  }

  /**
   * Method under test: {@link BackupDbUtil.State#valueOf(int)}
   */
  @Test
  public void testStateValueOf() {
    // Arrange, Act and Assert
    assertEquals(BackupDbUtil.State.BAKEDONE, BackupDbUtil.State.valueOf(42));
    assertEquals(BackupDbUtil.State.BAKINGONE, BackupDbUtil.State.valueOf(1));
    assertEquals(BackupDbUtil.State.BAKINGTWO, BackupDbUtil.State.valueOf(2));
    assertEquals(BackupDbUtil.State.BAKEDONE, BackupDbUtil.State.valueOf(11));
    assertEquals(BackupDbUtil.State.BAKEDTWO, BackupDbUtil.State.valueOf(22));
  }
}
