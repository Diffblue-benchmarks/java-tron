package org.tron.common.backup;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.backup.BackupManager.BackupStatusEnum;

public class BackupManagerDiffblueTest {
  /**
   * Test {@link BackupManager#getStatus()}.
   *
   * <p>Method under test: {@link BackupManager#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "BackupStatusEnum BackupManager.getStatus()",
    "void BackupManager.setMessageHandler(org.tron.common.backup.socket.MessageHandler)"
  })
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertEquals(BackupStatusEnum.MASTER, new BackupManager().getStatus());
  }

  /**
   * Test {@link BackupManager#getStatus()}.
   *
   * <p>Method under test: {@link BackupManager#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "BackupStatusEnum BackupManager.getStatus()",
    "void BackupManager.setMessageHandler(org.tron.common.backup.socket.MessageHandler)"
  })
  public void testGetStatus2() {
    // Arrange, Act and Assert
    assertEquals(BackupStatusEnum.MASTER, new BackupManager().getStatus());
  }
}
