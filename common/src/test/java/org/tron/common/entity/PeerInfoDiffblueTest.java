package org.tron.common.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PeerInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PeerInfo}
   *   <li>{@link PeerInfo#setActive(boolean)}
   *   <li>{@link PeerInfo#setAvgLatency(double)}
   *   <li>{@link PeerInfo#setBlockInPorcSize(int)}
   *   <li>{@link PeerInfo#setConnectTime(long)}
   *   <li>{@link PeerInfo#setDisconnectTimes(int)}
   *   <li>{@link PeerInfo#setHeadBlockTimeWeBothHave(long)}
   *   <li>{@link PeerInfo#setHeadBlockWeBothHave(String)}
   *   <li>{@link PeerInfo#setHost(String)}
   *   <li>{@link PeerInfo#setInFlow(long)}
   *   <li>{@link PeerInfo#setLastBlockUpdateTime(long)}
   *   <li>{@link PeerInfo#setLastSyncBlock(String)}
   *   <li>{@link PeerInfo#setLocalDisconnectReason(String)}
   *   <li>{@link PeerInfo#setNeedSyncFromPeer(boolean)}
   *   <li>{@link PeerInfo#setNeedSyncFromUs(boolean)}
   *   <li>{@link PeerInfo#setNodeCount(int)}
   *   <li>{@link PeerInfo#setNodeId(String)}
   *   <li>{@link PeerInfo#setPort(int)}
   *   <li>{@link PeerInfo#setRemainNum(long)}
   *   <li>{@link PeerInfo#setRemoteDisconnectReason(String)}
   *   <li>{@link PeerInfo#setScore(int)}
   *   <li>{@link PeerInfo#setSyncBlockRequestedSize(int)}
   *   <li>{@link PeerInfo#setSyncFlag(boolean)}
   *   <li>{@link PeerInfo#setSyncToFetchSize(int)}
   *   <li>{@link PeerInfo#setSyncToFetchSizePeekNum(long)}
   *   <li>{@link PeerInfo#setUnFetchSynNum(long)}
   *   <li>{@link PeerInfo#getAvgLatency()}
   *   <li>{@link PeerInfo#getBlockInPorcSize()}
   *   <li>{@link PeerInfo#getConnectTime()}
   *   <li>{@link PeerInfo#getDisconnectTimes()}
   *   <li>{@link PeerInfo#getHeadBlockTimeWeBothHave()}
   *   <li>{@link PeerInfo#getHeadBlockWeBothHave()}
   *   <li>{@link PeerInfo#getHost()}
   *   <li>{@link PeerInfo#getInFlow()}
   *   <li>{@link PeerInfo#getLastBlockUpdateTime()}
   *   <li>{@link PeerInfo#getLastSyncBlock()}
   *   <li>{@link PeerInfo#getLocalDisconnectReason()}
   *   <li>{@link PeerInfo#getNodeCount()}
   *   <li>{@link PeerInfo#getNodeId()}
   *   <li>{@link PeerInfo#getPort()}
   *   <li>{@link PeerInfo#getRemainNum()}
   *   <li>{@link PeerInfo#getRemoteDisconnectReason()}
   *   <li>{@link PeerInfo#getScore()}
   *   <li>{@link PeerInfo#getSyncBlockRequestedSize()}
   *   <li>{@link PeerInfo#getSyncToFetchSize()}
   *   <li>{@link PeerInfo#getSyncToFetchSizePeekNum()}
   *   <li>{@link PeerInfo#getUnFetchSynNum()}
   *   <li>{@link PeerInfo#isActive()}
   *   <li>{@link PeerInfo#isNeedSyncFromPeer()}
   *   <li>{@link PeerInfo#isNeedSyncFromUs()}
   *   <li>{@link PeerInfo#isSyncFlag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PeerInfo actualPeerInfo = new PeerInfo();
    PeerInfo actualSetActiveResult = actualPeerInfo.setActive(true);
    PeerInfo actualSetAvgLatencyResult = actualPeerInfo.setAvgLatency(10.0d);
    PeerInfo actualSetBlockInPorcSizeResult = actualPeerInfo.setBlockInPorcSize(3);
    PeerInfo actualSetConnectTimeResult = actualPeerInfo.setConnectTime(1L);
    PeerInfo actualSetDisconnectTimesResult = actualPeerInfo.setDisconnectTimes(1);
    PeerInfo actualSetHeadBlockTimeWeBothHaveResult = actualPeerInfo.setHeadBlockTimeWeBothHave(1L);
    PeerInfo actualSetHeadBlockWeBothHaveResult = actualPeerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    PeerInfo actualSetHostResult = actualPeerInfo.setHost("localhost");
    PeerInfo actualSetInFlowResult = actualPeerInfo.setInFlow(1L);
    PeerInfo actualSetLastBlockUpdateTimeResult = actualPeerInfo.setLastBlockUpdateTime(1L);
    PeerInfo actualSetLastSyncBlockResult = actualPeerInfo.setLastSyncBlock("Last Sync Block");
    PeerInfo actualSetLocalDisconnectReasonResult = actualPeerInfo.setLocalDisconnectReason("Just cause");
    PeerInfo actualSetNeedSyncFromPeerResult = actualPeerInfo.setNeedSyncFromPeer(true);
    PeerInfo actualSetNeedSyncFromUsResult = actualPeerInfo.setNeedSyncFromUs(true);
    PeerInfo actualSetNodeCountResult = actualPeerInfo.setNodeCount(3);
    PeerInfo actualSetNodeIdResult = actualPeerInfo.setNodeId("42");
    PeerInfo actualSetPortResult = actualPeerInfo.setPort(8080);
    PeerInfo actualSetRemainNumResult = actualPeerInfo.setRemainNum(1L);
    PeerInfo actualSetRemoteDisconnectReasonResult = actualPeerInfo.setRemoteDisconnectReason("Just cause");
    PeerInfo actualSetScoreResult = actualPeerInfo.setScore(3);
    PeerInfo actualSetSyncBlockRequestedSizeResult = actualPeerInfo.setSyncBlockRequestedSize(3);
    PeerInfo actualSetSyncFlagResult = actualPeerInfo.setSyncFlag(true);
    PeerInfo actualSetSyncToFetchSizeResult = actualPeerInfo.setSyncToFetchSize(3);
    PeerInfo actualSetSyncToFetchSizePeekNumResult = actualPeerInfo.setSyncToFetchSizePeekNum(3L);
    PeerInfo actualSetUnFetchSynNumResult = actualPeerInfo.setUnFetchSynNum(1L);
    double actualAvgLatency = actualPeerInfo.getAvgLatency();
    int actualBlockInPorcSize = actualPeerInfo.getBlockInPorcSize();
    long actualConnectTime = actualPeerInfo.getConnectTime();
    int actualDisconnectTimes = actualPeerInfo.getDisconnectTimes();
    long actualHeadBlockTimeWeBothHave = actualPeerInfo.getHeadBlockTimeWeBothHave();
    String actualHeadBlockWeBothHave = actualPeerInfo.getHeadBlockWeBothHave();
    String actualHost = actualPeerInfo.getHost();
    long actualInFlow = actualPeerInfo.getInFlow();
    long actualLastBlockUpdateTime = actualPeerInfo.getLastBlockUpdateTime();
    String actualLastSyncBlock = actualPeerInfo.getLastSyncBlock();
    String actualLocalDisconnectReason = actualPeerInfo.getLocalDisconnectReason();
    int actualNodeCount = actualPeerInfo.getNodeCount();
    String actualNodeId = actualPeerInfo.getNodeId();
    int actualPort = actualPeerInfo.getPort();
    long actualRemainNum = actualPeerInfo.getRemainNum();
    String actualRemoteDisconnectReason = actualPeerInfo.getRemoteDisconnectReason();
    int actualScore = actualPeerInfo.getScore();
    int actualSyncBlockRequestedSize = actualPeerInfo.getSyncBlockRequestedSize();
    int actualSyncToFetchSize = actualPeerInfo.getSyncToFetchSize();
    long actualSyncToFetchSizePeekNum = actualPeerInfo.getSyncToFetchSizePeekNum();
    long actualUnFetchSynNum = actualPeerInfo.getUnFetchSynNum();
    boolean actualIsActiveResult = actualPeerInfo.isActive();
    boolean actualIsNeedSyncFromPeerResult = actualPeerInfo.isNeedSyncFromPeer();
    boolean actualIsNeedSyncFromUsResult = actualPeerInfo.isNeedSyncFromUs();

    // Assert
    assertEquals("42", actualNodeId);
    assertEquals("Head Block We Both Have", actualHeadBlockWeBothHave);
    assertEquals("Just cause", actualLocalDisconnectReason);
    assertEquals("Just cause", actualRemoteDisconnectReason);
    assertEquals("Last Sync Block", actualLastSyncBlock);
    assertEquals("localhost", actualHost);
    assertEquals(1, actualDisconnectTimes);
    assertEquals(10.0d, actualAvgLatency, 0.0);
    assertEquals(1L, actualConnectTime);
    assertEquals(1L, actualHeadBlockTimeWeBothHave);
    assertEquals(1L, actualInFlow);
    assertEquals(1L, actualLastBlockUpdateTime);
    assertEquals(1L, actualRemainNum);
    assertEquals(1L, actualUnFetchSynNum);
    assertEquals(3, actualBlockInPorcSize);
    assertEquals(3, actualNodeCount);
    assertEquals(3, actualScore);
    assertEquals(3, actualSyncBlockRequestedSize);
    assertEquals(3, actualSyncToFetchSize);
    assertEquals(3L, actualSyncToFetchSizePeekNum);
    assertEquals(8080, actualPort);
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsNeedSyncFromPeerResult);
    assertTrue(actualIsNeedSyncFromUsResult);
    assertTrue(actualPeerInfo.isSyncFlag());
    assertSame(actualPeerInfo, actualSetActiveResult);
    assertSame(actualPeerInfo, actualSetAvgLatencyResult);
    assertSame(actualPeerInfo, actualSetBlockInPorcSizeResult);
    assertSame(actualPeerInfo, actualSetConnectTimeResult);
    assertSame(actualPeerInfo, actualSetDisconnectTimesResult);
    assertSame(actualPeerInfo, actualSetHeadBlockTimeWeBothHaveResult);
    assertSame(actualPeerInfo, actualSetHeadBlockWeBothHaveResult);
    assertSame(actualPeerInfo, actualSetHostResult);
    assertSame(actualPeerInfo, actualSetInFlowResult);
    assertSame(actualPeerInfo, actualSetLastBlockUpdateTimeResult);
    assertSame(actualPeerInfo, actualSetLastSyncBlockResult);
    assertSame(actualPeerInfo, actualSetLocalDisconnectReasonResult);
    assertSame(actualPeerInfo, actualSetNeedSyncFromPeerResult);
    assertSame(actualPeerInfo, actualSetNeedSyncFromUsResult);
    assertSame(actualPeerInfo, actualSetNodeCountResult);
    assertSame(actualPeerInfo, actualSetNodeIdResult);
    assertSame(actualPeerInfo, actualSetPortResult);
    assertSame(actualPeerInfo, actualSetRemainNumResult);
    assertSame(actualPeerInfo, actualSetRemoteDisconnectReasonResult);
    assertSame(actualPeerInfo, actualSetScoreResult);
    assertSame(actualPeerInfo, actualSetSyncBlockRequestedSizeResult);
    assertSame(actualPeerInfo, actualSetSyncFlagResult);
    assertSame(actualPeerInfo, actualSetSyncToFetchSizeResult);
    assertSame(actualPeerInfo, actualSetSyncToFetchSizePeekNumResult);
    assertSame(actualPeerInfo, actualSetUnFetchSynNumResult);
  }
}
