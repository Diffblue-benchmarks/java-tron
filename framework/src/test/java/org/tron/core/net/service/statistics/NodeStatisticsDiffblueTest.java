package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.net.InetAddress;
import org.junit.Test;
import org.tron.protos.Protocol;

public class NodeStatisticsDiffblueTest {
  /**
   * Method under test: {@link NodeStatistics#getDisconnectReason()}
   */
  @Test
  public void testGetDisconnectReason() {
    // Arrange, Act and Assert
    assertEquals(Protocol.ReasonCode.UNKNOWN, (new NodeStatistics()).getDisconnectReason());
    assertEquals(Protocol.ReasonCode.UNKNOWN,
        TronStatsManager.getNodeStatistics(mock(InetAddress.class)).getDisconnectReason());
  }

  /**
   * Method under test: {@link NodeStatistics#getDisconnectReason()}
   */
  @Test
  public void testGetDisconnectReason2() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();
    nodeStatistics.nodeDisconnectedLocal(null);
    nodeStatistics.nodeDisconnectedRemote(Protocol.ReasonCode.REQUESTED);

    // Act and Assert
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
  }

  /**
   * Method under test: {@link NodeStatistics#getDisconnectReason()}
   */
  @Test
  public void testGetDisconnectReason3() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();
    nodeStatistics.nodeDisconnectedLocal(Protocol.ReasonCode.REQUESTED);
    nodeStatistics.nodeDisconnectedRemote(null);

    // Act and Assert
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
  }

  /**
   * Method under test:
   * {@link NodeStatistics#nodeDisconnectedRemote(Protocol.ReasonCode)}
   */
  @Test
  public void testNodeDisconnectedRemote() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();

    // Act
    nodeStatistics.nodeDisconnectedRemote(Protocol.ReasonCode.REQUESTED);

    // Assert
    assertEquals(1, nodeStatistics.getDisconnectTimes());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getRemoteDisconnectReason());
  }

  /**
   * Method under test:
   * {@link NodeStatistics#nodeDisconnectedRemote(Protocol.ReasonCode)}
   */
  @Test
  public void testNodeDisconnectedRemote2() {
    // Arrange
    NodeStatistics nodeStatistics = TronStatsManager.getNodeStatistics(mock(InetAddress.class));

    // Act
    nodeStatistics.nodeDisconnectedRemote(Protocol.ReasonCode.REQUESTED);

    // Assert
    assertEquals(1, nodeStatistics.getDisconnectTimes());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getRemoteDisconnectReason());
  }

  /**
   * Method under test:
   * {@link NodeStatistics#nodeDisconnectedLocal(Protocol.ReasonCode)}
   */
  @Test
  public void testNodeDisconnectedLocal() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();

    // Act
    nodeStatistics.nodeDisconnectedLocal(Protocol.ReasonCode.REQUESTED);

    // Assert
    assertEquals(1, nodeStatistics.getDisconnectTimes());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getLocalDisconnectReason());
  }

  /**
   * Method under test:
   * {@link NodeStatistics#nodeDisconnectedLocal(Protocol.ReasonCode)}
   */
  @Test
  public void testNodeDisconnectedLocal2() {
    // Arrange
    NodeStatistics nodeStatistics = TronStatsManager.getNodeStatistics(mock(InetAddress.class));

    // Act
    nodeStatistics.nodeDisconnectedLocal(Protocol.ReasonCode.REQUESTED);

    // Assert
    assertEquals(1, nodeStatistics.getDisconnectTimes());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, nodeStatistics.getLocalDisconnectReason());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeStatistics#toString()}
   *   <li>{@link NodeStatistics#getDisconnectTimes()}
   *   <li>{@link NodeStatistics#getLocalDisconnectReason()}
   *   <li>{@link NodeStatistics#getRemoteDisconnectReason()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();

    // Act
    nodeStatistics.toString();
    int actualDisconnectTimes = nodeStatistics.getDisconnectTimes();
    Protocol.ReasonCode actualLocalDisconnectReason = nodeStatistics.getLocalDisconnectReason();

    // Assert
    assertNull(actualLocalDisconnectReason);
    assertNull(nodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualDisconnectTimes);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NodeStatistics}
   */
  @Test
  public void testNewNodeStatistics() {
    // Arrange and Act
    NodeStatistics actualNodeStatistics = new NodeStatistics();

    // Assert
    assertNull(actualNodeStatistics.getLocalDisconnectReason());
    assertNull(actualNodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualNodeStatistics.getDisconnectTimes());
    assertEquals(Protocol.ReasonCode.UNKNOWN, actualNodeStatistics.getDisconnectReason());
  }
}
