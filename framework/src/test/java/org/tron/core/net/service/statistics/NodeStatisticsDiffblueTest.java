package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

public class NodeStatisticsDiffblueTest {
  /**
   * Test {@link NodeStatistics#getDisconnectReason()}.
   *
   * <p>Method under test: {@link NodeStatistics#getDisconnectReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.ReasonCode NodeStatistics.getDisconnectReason()"})
  public void testGetDisconnectReason() {
    // Arrange
    NodeStatistics nodeStatistics = TronStatsManager.getNodeStatistics(mock(InetAddress.class));
    nodeStatistics.nodeDisconnectedLocal(null);
    nodeStatistics.nodeDisconnectedRemote(ReasonCode.REQUESTED);

    // Act and Assert
    assertEquals(ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
  }

  /**
   * Test {@link NodeStatistics#getDisconnectReason()}.
   *
   * <p>Method under test: {@link NodeStatistics#getDisconnectReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.ReasonCode NodeStatistics.getDisconnectReason()"})
  public void testGetDisconnectReason2() {
    // Arrange
    NodeStatistics nodeStatistics = TronStatsManager.getNodeStatistics(mock(InetAddress.class));
    nodeStatistics.nodeDisconnectedLocal(ReasonCode.REQUESTED);
    nodeStatistics.nodeDisconnectedRemote(null);

    // Act and Assert
    assertEquals(ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
  }

  /**
   * Test {@link NodeStatistics#getDisconnectReason()}.
   *
   * <ul>
   *   <li>Given {@link NodeStatistics} (default constructor).
   *   <li>Then return {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link NodeStatistics#getDisconnectReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.ReasonCode NodeStatistics.getDisconnectReason()"})
  public void testGetDisconnectReason_givenNodeStatistics_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.UNKNOWN, new NodeStatistics().getDisconnectReason());
  }

  /**
   * Test {@link NodeStatistics#nodeDisconnectedRemote(ReasonCode)}.
   *
   * <p>Method under test: {@link NodeStatistics#nodeDisconnectedRemote(Protocol.ReasonCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeStatistics.nodeDisconnectedRemote(Protocol.ReasonCode)"})
  public void testNodeDisconnectedRemote() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();

    // Act
    nodeStatistics.nodeDisconnectedRemote(ReasonCode.REQUESTED);

    // Assert
    assertEquals(1, nodeStatistics.getDisconnectTimes());
    assertEquals(ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
    assertEquals(ReasonCode.REQUESTED, nodeStatistics.getRemoteDisconnectReason());
  }

  /**
   * Test {@link NodeStatistics#nodeDisconnectedLocal(ReasonCode)}.
   *
   * <p>Method under test: {@link NodeStatistics#nodeDisconnectedLocal(Protocol.ReasonCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeStatistics.nodeDisconnectedLocal(Protocol.ReasonCode)"})
  public void testNodeDisconnectedLocal() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();

    // Act
    nodeStatistics.nodeDisconnectedLocal(ReasonCode.REQUESTED);

    // Assert
    assertEquals(1, nodeStatistics.getDisconnectTimes());
    assertEquals(ReasonCode.REQUESTED, nodeStatistics.getDisconnectReason());
    assertEquals(ReasonCode.REQUESTED, nodeStatistics.getLocalDisconnectReason());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeStatistics#toString()}
   *   <li>{@link NodeStatistics#getDisconnectTimes()}
   *   <li>{@link NodeStatistics#getLocalDisconnectReason()}
   *   <li>{@link NodeStatistics#getRemoteDisconnectReason()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int NodeStatistics.getDisconnectTimes()",
    "Protocol.ReasonCode NodeStatistics.getLocalDisconnectReason()",
    "Protocol.ReasonCode NodeStatistics.getRemoteDisconnectReason()",
    "java.lang.String NodeStatistics.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    NodeStatistics nodeStatistics = new NodeStatistics();

    // Act
    nodeStatistics.toString();
    int actualDisconnectTimes = nodeStatistics.getDisconnectTimes();
    ReasonCode actualLocalDisconnectReason = nodeStatistics.getLocalDisconnectReason();

    // Assert
    assertNull(actualLocalDisconnectReason);
    assertNull(nodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualDisconnectTimes);
  }

  /**
   * Test new {@link NodeStatistics} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NodeStatistics}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeStatistics.<init>()"})
  public void testNewNodeStatistics() {
    // Arrange and Act
    NodeStatistics actualNodeStatistics = new NodeStatistics();

    // Assert
    assertNull(actualNodeStatistics.getLocalDisconnectReason());
    assertNull(actualNodeStatistics.getRemoteDisconnectReason());
    assertEquals(0, actualNodeStatistics.getDisconnectTimes());
    assertEquals(ReasonCode.UNKNOWN, actualNodeStatistics.getDisconnectReason());
  }
}
