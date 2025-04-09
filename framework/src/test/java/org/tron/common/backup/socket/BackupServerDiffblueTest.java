package org.tron.common.backup.socket;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.backup.BackupManager;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BackupServerDiffblueTest {
  @Mock
  private BackupManager backupManager;

  @InjectMocks
  private BackupServer backupServer;

  /**
   * Test {@link BackupServer#close()}.
   * <p>
   * Method under test: {@link BackupServer#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BackupServer.close()"})
  public void testClose() {
    // Arrange
    doNothing().when(backupManager).stop();

    // Act
    backupServer.close();

    // Assert
    verify(backupManager).stop();
  }
}
