package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

public class TronStatsManagerDiffblueTest {
  /**
   * Test {@link TronStatsManager#getNodeStatistics(InetAddress)}.
   * <ul>
   *   <li>When {@link InetAddress}.</li>
   *   <li>Then return LocalDisconnectReason is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronStatsManager#getNodeStatistics(InetAddress)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeStatistics TronStatsManager.getNodeStatistics(InetAddress)"})
  public void testGetNodeStatistics_whenInetAddress_thenReturnLocalDisconnectReasonIsNull() {
    // Arrange and Act
    NodeStatistics actualNodeStatistics = TronStatsManager.getNodeStatistics(mock(InetAddress.class));

    // Assert
    assertNull(actualNodeStatistics.getLocalDisconnectReason());
    assertNull(actualNodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualNodeStatistics.getDisconnectTimes());
    assertEquals(ReasonCode.UNKNOWN, actualNodeStatistics.getDisconnectReason());
  }
}
