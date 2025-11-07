package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.net.InetAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class TronStatsManagerDiffblueTest {
  @InjectMocks
  private TronStatsManager tronStatsManager;

  /**
   * Method under test: {@link TronStatsManager#getNodeStatistics(InetAddress)}
   */
  @Test
  public void testGetNodeStatistics() {
    // Arrange and Act
    NodeStatistics actualNodeStatistics = TronStatsManager.getNodeStatistics(mock(InetAddress.class));

    // Assert
    assertNull(actualNodeStatistics.getLocalDisconnectReason());
    assertNull(actualNodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualNodeStatistics.getDisconnectTimes());
    assertEquals(Protocol.ReasonCode.UNKNOWN, actualNodeStatistics.getDisconnectReason());
  }
}
