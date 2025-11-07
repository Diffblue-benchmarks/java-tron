package org.tron.common.backup;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.socket.nio.NioDatagramChannel;
import java.net.InetSocketAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.common.backup.message.KeepAliveMessage;
import org.tron.common.backup.message.UdpMessageTypeEnum;
import org.tron.common.backup.socket.MessageHandler;
import org.tron.common.backup.socket.UdpEvent;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {BackupManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BackupManagerDiffblueTest {
  @Autowired
  private BackupManager backupManager;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackupManager#setMessageHandler(MessageHandler)}
   *   <li>{@link BackupManager#getStatus()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    BackupManager backupManager = new BackupManager();
    NioDatagramChannel channel = new NioDatagramChannel();

    // Act
    backupManager.setMessageHandler(new MessageHandler(channel, new BackupManager()));

    // Assert that nothing has changed
    assertEquals(BackupManager.BackupStatusEnum.MASTER, backupManager.getStatus());
  }

  /**
   * Method under test:
   * {@link BackupManager#setStatus(BackupManager.BackupStatusEnum)}
   */
  @Test
  public void testSetStatus() {
    // Arrange and Act
    backupManager.setStatus(BackupManager.BackupStatusEnum.INIT);

    // Assert
    assertEquals(BackupManager.BackupStatusEnum.INIT, backupManager.getStatus());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackupManager#setMessageHandler(MessageHandler)}
   *   <li>{@link BackupManager#getStatus()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BackupManager backupManager = new BackupManager();
    NioDatagramChannel channel = new NioDatagramChannel();

    // Act
    backupManager.setMessageHandler(new MessageHandler(channel, new BackupManager()));

    // Assert that nothing has changed
    assertEquals(BackupManager.BackupStatusEnum.MASTER, backupManager.getStatus());
  }

  /**
   * Method under test: {@link BackupManager#handleEvent(UdpEvent)}
   */
  @Test
  public void testHandleEvent() {
    // Arrange
    KeepAliveMessage message = mock(KeepAliveMessage.class);
    when(message.getType()).thenReturn(UdpMessageTypeEnum.BACKUP_KEEP_ALIVE);

    // Act
    backupManager.handleEvent(new UdpEvent(message, InetSocketAddress.createUnresolved("foo", 1)));

    // Assert that nothing has changed
    verify(message).getType();
  }

  /**
   * Method under test: {@link BackupManager#handleEvent(UdpEvent)}
   */
  @Test
  public void testHandleEvent2() {
    // Arrange
    KeepAliveMessage message = mock(KeepAliveMessage.class);
    when(message.getType()).thenReturn(UdpMessageTypeEnum.UNKNOWN);

    // Act
    backupManager.handleEvent(new UdpEvent(message, InetSocketAddress.createUnresolved("foo", 1)));

    // Assert that nothing has changed
    verify(message, atLeast(1)).getType();
  }
}
