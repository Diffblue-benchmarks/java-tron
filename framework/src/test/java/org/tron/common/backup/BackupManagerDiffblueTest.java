package org.tron.common.backup;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.backup.BackupManager.BackupStatusEnum;
import org.tron.common.backup.socket.MessageHandler;

public class BackupManagerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackupManager#setMessageHandler(MessageHandler)}
   *   <li>{@link BackupManager#getStatus()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BackupStatusEnum BackupManager.getStatus()",
      "void BackupManager.setMessageHandler(MessageHandler)"})
  public void testGettersAndSetters() {
    // Arrange
    BackupManager backupManager = new BackupManager();
    NioDatagramChannel channel = new NioDatagramChannel();

    // Act
    backupManager.setMessageHandler(new MessageHandler(channel, new BackupManager()));

    // Assert
    assertEquals(BackupStatusEnum.MASTER, backupManager.getStatus());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackupManager#setMessageHandler(MessageHandler)}
   *   <li>{@link BackupManager#getStatus()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BackupStatusEnum BackupManager.getStatus()",
      "void BackupManager.setMessageHandler(MessageHandler)"})
  public void testGettersAndSetters2() {
    // Arrange
    BackupManager backupManager = new BackupManager();
    NioDatagramChannel channel = new NioDatagramChannel();

    // Act
    backupManager.setMessageHandler(new MessageHandler(channel, new BackupManager()));

    // Assert
    assertEquals(BackupStatusEnum.MASTER, backupManager.getStatus());
  }
}
