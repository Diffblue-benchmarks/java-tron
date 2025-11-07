package org.tron.core.net.peer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.cache.Cache;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.overlay.message.Message;
import org.tron.common.utils.Pair;
import org.tron.common.utils.Sha256Hash;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.message.adv.TransactionsMessage;
import org.tron.core.net.message.handshake.HelloMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.message.keepalive.PongMessage;
import org.tron.core.net.service.adv.AdvService;
import org.tron.core.net.service.statistics.MessageStatistics;
import org.tron.core.net.service.statistics.PeerStatistics;
import org.tron.core.net.service.sync.SyncService;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class PeerConnectionDiffblueTest {
  @Mock
  private AdvService advService;

  @InjectMocks
  private PeerConnection peerConnection;

  @Mock
  private SyncService syncService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Method under test:
   * {@link PeerConnection#setBlockBothHave(BlockCapsule.BlockId)}
   */
  @Test
  public void testSetBlockBothHave() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();

    // Act
    peerConnection.setBlockBothHave(blockId);

    // Assert
    assertSame(blockId, peerConnection.getBlockBothHave());
  }

  /**
   * Method under test:
   * {@link PeerConnection#setBlockBothHave(BlockCapsule.BlockId)}
   */
  @Test
  public void testSetBlockBothHave2() {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);

    // Act
    peerConnection.setBlockBothHave(blockId);

    // Assert
    assertSame(blockId, peerConnection.getBlockBothHave());
  }

  /**
   * Method under test: {@link PeerConnection#isIdle()}
   */
  @Test
  public void testIsIdle() {
    // Arrange, Act and Assert
    assertTrue(peerConnection.isIdle());
  }

  /**
   * Method under test: {@link PeerConnection#isSyncIdle()}
   */
  @Test
  public void testIsSyncIdle() {
    // Arrange, Act and Assert
    assertTrue(peerConnection.isSyncIdle());
  }

  /**
   * Method under test: {@link PeerConnection#onConnect()}
   */
  @Test
  public void testOnConnect() {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    HelloMessage helloMessageSend = mock(HelloMessage.class);
    when(helloMessageSend.getHeadBlockId()).thenReturn(blockId);
    HelloMessage helloMessageReceive = mock(HelloMessage.class);
    when(helloMessageReceive.getHeadBlockId()).thenReturn(new BlockCapsule.BlockId());

    PeerConnection peerConnection = new PeerConnection();
    peerConnection.setHelloMessageReceive(helloMessageReceive);
    peerConnection.setHelloMessageSend(helloMessageSend);

    // Act
    peerConnection.onConnect();

    // Assert
    verify(blockId).getNum();
    verify(helloMessageReceive).getHeadBlockId();
    verify(helloMessageSend).getHeadBlockId();
    assertEquals(TronState.SYNC_COMPLETED, peerConnection.getTronState());
    assertFalse(peerConnection.isNeedSyncFromPeer());
    assertFalse(peerConnection.isSyncFinish());
    assertTrue(peerConnection.isNeedSyncFromUs());
  }

  /**
   * Method under test: {@link PeerConnection#onConnect()}
   */
  @Test
  public void testOnConnect2() {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    HelloMessage helloMessageSend = mock(HelloMessage.class);
    when(helloMessageSend.getHeadBlockId()).thenReturn(blockId);
    BlockCapsule.BlockId blockId2 = mock(BlockCapsule.BlockId.class);
    when(blockId2.getNum()).thenReturn(1L);
    HelloMessage helloMessageReceive = mock(HelloMessage.class);
    when(helloMessageReceive.getHeadBlockId()).thenReturn(blockId2);

    PeerConnection peerConnection = new PeerConnection();
    peerConnection.setHelloMessageReceive(helloMessageReceive);
    peerConnection.setHelloMessageSend(helloMessageSend);

    // Act
    peerConnection.onConnect();

    // Assert
    verify(blockId2).getNum();
    verify(blockId).getNum();
    verify(helloMessageReceive).getHeadBlockId();
    verify(helloMessageSend).getHeadBlockId();
    assertEquals(TronState.SYNC_COMPLETED, peerConnection.getTronState());
    assertFalse(peerConnection.isNeedSyncFromPeer());
    assertFalse(peerConnection.isNeedSyncFromUs());
    assertTrue(peerConnection.isSyncFinish());
  }

  /**
   * Method under test: {@link PeerConnection#isSyncFinish()}
   */
  @Test
  public void testIsSyncFinish() {
    // Arrange, Act and Assert
    assertFalse(peerConnection.isSyncFinish());
  }

  /**
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  public void testNeedToLog() {
    // Arrange, Act and Assert
    assertFalse(PeerConnection.needToLog(new PingMessage()));
    assertTrue(PeerConnection.needToLog(null));
    assertFalse(PeerConnection.needToLog(mock(PingMessage.class)));
    assertFalse(PeerConnection.needToLog(new PongMessage()));
    assertFalse(PeerConnection.needToLog(new PbftMessage()));
    assertFalse(PeerConnection.needToLog(new TransactionsMessage(new ArrayList<>())));
    assertFalse(PeerConnection.needToLog(new FetchInvDataMessage(Protocol.Inventory.getDefaultInstance())));
  }

  /**
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  public void testNeedToLog2() {
    // Arrange
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    boolean actualNeedToLogResult = PeerConnection.needToLog(msg);

    // Assert
    verify(msg).getInventoryType();
    assertFalse(actualNeedToLogResult);
  }

  /**
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  public void testNeedToLog3() {
    // Arrange
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    boolean actualNeedToLogResult = PeerConnection.needToLog(msg);

    // Assert
    verify(msg).getInventoryType();
    assertTrue(actualNeedToLogResult);
  }

  /**
   * Method under test:
   * {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}
   */
  @Test
  public void testCheckAndPutAdvInvRequest() {
    // Arrange and Act
    peerConnection.checkAndPutAdvInvRequest(new Item(new BlockCapsule.BlockId(), Protocol.Inventory.InventoryType.TRX),
        42L);

    // Assert
    assertEquals(1, peerConnection.getAdvInvRequest().size());
    assertFalse(peerConnection.isIdle());
  }

  /**
   * Method under test:
   * {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}
   */
  @Test
  public void testCheckAndPutAdvInvRequest2() {
    // Arrange and Act
    boolean actualCheckAndPutAdvInvRequestResult = peerConnection
        .checkAndPutAdvInvRequest(new Item(mock(Sha256Hash.class), Protocol.Inventory.InventoryType.TRX), 42L);

    // Assert
    assertFalse(peerConnection.isIdle());
    assertTrue(actualCheckAndPutAdvInvRequestResult);
  }

  /**
   * Method under test:
   * {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}
   */
  @Test
  public void testCheckAndPutAdvInvRequest3() {
    // Arrange and Act
    boolean actualCheckAndPutAdvInvRequestResult = peerConnection.checkAndPutAdvInvRequest(mock(Item.class), 42L);

    // Assert
    assertFalse(peerConnection.isIdle());
    assertTrue(actualCheckAndPutAdvInvRequestResult);
  }

  /**
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PeerConnection(), 1);
  }

  /**
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(NullPointerException.class, () -> (new PeerConnection()).equals(new PeerConnection()));
  }

  /**
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PeerConnection(), null);
  }

  /**
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PeerConnection(), "Different type to PeerConnection");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PeerConnection#setAddress(ByteString)}
   *   <li>{@link PeerConnection#setAdvInvReceive(Cache)}
   *   <li>{@link PeerConnection#setAdvInvRequest(Map)}
   *   <li>{@link PeerConnection#setAdvInvSpread(Cache)}
   *   <li>{@link PeerConnection#setBadPeer(boolean)}
   *   <li>{@link PeerConnection#setFastForwardBlock(BlockCapsule.BlockId)}
   *   <li>{@link PeerConnection#setFetchAble(boolean)}
   *   <li>{@link PeerConnection#setLastInteractiveTime(long)}
   *   <li>{@link PeerConnection#setLastSyncBlockId(BlockCapsule.BlockId)}
   *   <li>{@link PeerConnection#setNeedSyncFromPeer(boolean)}
   *   <li>{@link PeerConnection#setNeedSyncFromUs(boolean)}
   *   <li>{@link PeerConnection#setRelayPeer(boolean)}
   *   <li>{@link PeerConnection#setRemainNum(long)}
   *   <li>{@link PeerConnection#setSyncBlockInProcess(Set)}
   *   <li>{@link PeerConnection#setSyncBlockRequested(Map)}
   *   <li>{@link PeerConnection#setSyncBlockToFetch(Deque)}
   *   <li>{@link PeerConnection#setSyncChainRequested(Pair)}
   *   <li>{@link PeerConnection#setTronState(TronState)}
   *   <li>{@link PeerConnection#getAddress()}
   *   <li>{@link PeerConnection#getAdvInvReceive()}
   *   <li>{@link PeerConnection#getAdvInvRequest()}
   *   <li>{@link PeerConnection#getAdvInvSpread()}
   *   <li>{@link PeerConnection#getBlockBothHave()}
   *   <li>{@link PeerConnection#getBlockBothHaveUpdateTime()}
   *   <li>{@link PeerConnection#getChannel()}
   *   <li>{@link PeerConnection#getHelloMessageReceive()}
   *   <li>{@link PeerConnection#getHelloMessageSend()}
   *   <li>{@link PeerConnection#getLastInteractiveTime()}
   *   <li>{@link PeerConnection#getLastSyncBlockId()}
   *   <li>{@link PeerConnection#getNodeStatistics()}
   *   <li>{@link PeerConnection#getPeerStatistics()}
   *   <li>{@link PeerConnection#getRemainNum()}
   *   <li>{@link PeerConnection#getSyncBlockIdCache()}
   *   <li>{@link PeerConnection#getSyncBlockInProcess()}
   *   <li>{@link PeerConnection#getSyncBlockRequested()}
   *   <li>{@link PeerConnection#getSyncBlockToFetch()}
   *   <li>{@link PeerConnection#getSyncChainRequested()}
   *   <li>{@link PeerConnection#getTronState()}
   *   <li>{@link PeerConnection#isBadPeer()}
   *   <li>{@link PeerConnection#isFetchAble()}
   *   <li>{@link PeerConnection#isNeedSyncFromPeer()}
   *   <li>{@link PeerConnection#isNeedSyncFromUs()}
   *   <li>{@link PeerConnection#isRelayPeer()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PeerConnection peerConnection = new PeerConnection();

    // Act
    peerConnection.setAddress(null);
    Cache<Item, Long> advInvReceive = mock(Cache.class);
    peerConnection.setAdvInvReceive(advInvReceive);
    HashMap<Item, Long> advInvRequest = new HashMap<>();
    peerConnection.setAdvInvRequest(advInvRequest);
    Cache<Item, Long> advInvSpread = mock(Cache.class);
    peerConnection.setAdvInvSpread(advInvSpread);
    peerConnection.setBadPeer(true);
    BlockCapsule.BlockId fastForwardBlock = new BlockCapsule.BlockId();
    peerConnection.setFastForwardBlock(fastForwardBlock);
    peerConnection.setFetchAble(true);
    peerConnection.setLastInteractiveTime(1L);
    BlockCapsule.BlockId lastSyncBlockId = new BlockCapsule.BlockId();
    peerConnection.setLastSyncBlockId(lastSyncBlockId);
    peerConnection.setNeedSyncFromPeer(true);
    peerConnection.setNeedSyncFromUs(true);
    peerConnection.setRelayPeer(true);
    peerConnection.setRemainNum(1L);
    HashSet<BlockCapsule.BlockId> syncBlockInProcess = new HashSet<>();
    peerConnection.setSyncBlockInProcess(syncBlockInProcess);
    HashMap<BlockCapsule.BlockId, Long> syncBlockRequested = new HashMap<>();
    peerConnection.setSyncBlockRequested(syncBlockRequested);
    LinkedList<BlockCapsule.BlockId> syncBlockToFetch = new LinkedList<>();
    peerConnection.setSyncBlockToFetch(syncBlockToFetch);
    Pair<Deque<BlockCapsule.BlockId>, Long> syncChainRequested = new Pair<>(new LinkedList<>(), 42L);

    peerConnection.setSyncChainRequested(syncChainRequested);
    peerConnection.setTronState(TronState.INIT);
    peerConnection.getAddress();
    Cache<Item, Long> actualAdvInvReceive = peerConnection.getAdvInvReceive();
    Map<Item, Long> actualAdvInvRequest = peerConnection.getAdvInvRequest();
    Cache<Item, Long> actualAdvInvSpread = peerConnection.getAdvInvSpread();
    BlockCapsule.BlockId actualBlockBothHave = peerConnection.getBlockBothHave();
    peerConnection.getBlockBothHaveUpdateTime();
    peerConnection.getChannel();
    peerConnection.getHelloMessageReceive();
    peerConnection.getHelloMessageSend();
    long actualLastInteractiveTime = peerConnection.getLastInteractiveTime();
    BlockCapsule.BlockId actualLastSyncBlockId = peerConnection.getLastSyncBlockId();
    peerConnection.getNodeStatistics();
    PeerStatistics actualPeerStatistics = peerConnection.getPeerStatistics();
    long actualRemainNum = peerConnection.getRemainNum();
    peerConnection.getSyncBlockIdCache();
    Set<BlockCapsule.BlockId> actualSyncBlockInProcess = peerConnection.getSyncBlockInProcess();
    Map<BlockCapsule.BlockId, Long> actualSyncBlockRequested = peerConnection.getSyncBlockRequested();
    Deque<BlockCapsule.BlockId> actualSyncBlockToFetch = peerConnection.getSyncBlockToFetch();
    Pair<Deque<BlockCapsule.BlockId>, Long> actualSyncChainRequested = peerConnection.getSyncChainRequested();
    TronState actualTronState = peerConnection.getTronState();
    boolean actualIsBadPeerResult = peerConnection.isBadPeer();
    boolean actualIsFetchAbleResult = peerConnection.isFetchAble();
    boolean actualIsNeedSyncFromPeerResult = peerConnection.isNeedSyncFromPeer();
    boolean actualIsNeedSyncFromUsResult = peerConnection.isNeedSyncFromUs();
    boolean actualIsRelayPeerResult = peerConnection.isRelayPeer();

    // Assert that nothing has changed
    assertTrue(actualSyncBlockToFetch instanceof List);
    MessageStatistics messageStatistics = actualPeerStatistics.messageStatistics;
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInHello.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutHello.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlock.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockChainInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInMessage.getTotalCount());
    assertEquals(0L, messageStatistics.tronInSyncBlockChain.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrx.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxs.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutAdvBlock.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlock.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockChainInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutMessage.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutSyncBlockChain.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrx.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxs.getTotalCount());
    assertEquals(1L, actualLastInteractiveTime);
    assertEquals(1L, actualRemainNum);
    assertEquals(TronState.INIT, actualTronState);
    assertTrue(actualAdvInvRequest.isEmpty());
    assertTrue(actualSyncBlockRequested.isEmpty());
    assertTrue(actualSyncBlockInProcess.isEmpty());
    assertTrue(actualIsBadPeerResult);
    assertTrue(actualIsFetchAbleResult);
    assertTrue(actualIsNeedSyncFromPeerResult);
    assertTrue(actualIsNeedSyncFromUsResult);
    assertTrue(actualIsRelayPeerResult);
    assertEquals(fastForwardBlock, actualBlockBothHave);
    assertSame(advInvRequest, actualAdvInvRequest);
    assertSame(syncBlockRequested, actualSyncBlockRequested);
    assertSame(syncBlockInProcess, actualSyncBlockInProcess);
    assertSame(syncBlockToFetch, actualSyncBlockToFetch);
    assertSame(syncChainRequested, actualSyncChainRequested);
    assertSame(lastSyncBlockId, actualLastSyncBlockId);
    assertSame(advInvReceive, actualAdvInvReceive);
    assertSame(advInvSpread, actualAdvInvSpread);
  }
}
