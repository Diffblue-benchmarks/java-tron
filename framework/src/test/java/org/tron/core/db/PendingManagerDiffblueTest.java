package org.tron.core.db;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.tron.common.utils.SessionOptional;

public class PendingManagerDiffblueTest {
  /**
   * Method under test: {@link PendingManager#PendingManager(Manager)}
   */
  @Test
  public void testNewPendingManager() {
    // Arrange
    Manager db = mock(Manager.class);
    when(db.getShieldedTransInPendingCounts()).thenReturn(new AtomicInteger(1));
    when(db.getSession()).thenReturn(SessionOptional.instance());

    // Act
    new PendingManager(db);

    // Assert
    verify(db).getSession();
    verify(db).getShieldedTransInPendingCounts();
  }
}
