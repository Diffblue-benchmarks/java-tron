package org.tron.common.backup.socket;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.backup.BackupManager;

@RunWith(MockitoJUnitRunner.class)
public class BackupServerDiffblueTest {
  @Mock
  private BackupManager backupManager;

  @InjectMocks
  private BackupServer backupServer;

  /**
   * Method under test: {@link BackupServer#close()}
   */
  @Test
  public void testClose() {
    // Arrange
    doNothing().when(backupManager).stop();

    // Act
    backupServer.close();

    // Assert
    verify(backupManager).stop();
  }
}
