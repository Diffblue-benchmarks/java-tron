package org.tron.core.net.peer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.overlay.message.Message;
import org.tron.common.utils.Pair;
import org.tron.common.utils.Sha256Hash;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.message.adv.InventoryMessage;
import org.tron.core.net.message.adv.TransactionsMessage;
import org.tron.core.net.message.handshake.HelloMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.message.keepalive.PongMessage;
import org.tron.core.net.service.statistics.MessageStatistics;
import org.tron.core.net.service.statistics.NodeStatistics;
import org.tron.core.net.service.statistics.PeerStatistics;
import org.tron.p2p.connection.Channel;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PeerConnectionDiffblueTest {
  @InjectMocks
  private PeerConnection peerConnection;

  /**
   * Test {@link PeerConnection#setBlockBothHave(BlockId)}.
   * <p>
   * Method under test: {@link PeerConnection#setBlockBothHave(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PeerConnection.setBlockBothHave(BlockId)"})
  public void testSetBlockBothHave() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act
    peerConnection.setBlockBothHave(blockId);

    // Assert
    assertSame(blockId, peerConnection.getBlockBothHave());
  }

  /**
   * Test {@link PeerConnection#isIdle()}.
   * <ul>
   *   <li>Given {@link PeerConnection}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isIdle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isIdle()"})
  public void testIsIdle_givenPeerConnection_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(peerConnection.isIdle());
  }

  /**
   * Test {@link PeerConnection#isIdle()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isIdle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isIdle()"})
  public void testIsIdle_thenReturnFalse() {
    // Arrange
    peerConnection.setSyncChainRequested(new Pair<>(new LinkedList<>(), 42L));

    // Act and Assert
    assertFalse(peerConnection.isIdle());
  }

  /**
   * Test {@link PeerConnection#isSyncIdle()}.
   * <ul>
   *   <li>Given {@link PeerConnection}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isSyncIdle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isSyncIdle()"})
  public void testIsSyncIdle_givenPeerConnection_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(peerConnection.isSyncIdle());
  }

  /**
   * Test {@link PeerConnection#isSyncIdle()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isSyncIdle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isSyncIdle()"})
  public void testIsSyncIdle_thenReturnFalse() {
    // Arrange
    peerConnection.setSyncChainRequested(new Pair<>(new LinkedList<>(), 42L));

    // Act and Assert
    assertFalse(peerConnection.isSyncIdle());
  }

  /**
   * Test {@link PeerConnection#onConnect()}.
   * <ul>
   *   <li>Then not {@link PeerConnection} (default constructor) NeedSyncFromUs.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#onConnect()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PeerConnection.onConnect()"})
  public void testOnConnect_thenNotPeerConnectionNeedSyncFromUs() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    HelloMessage helloMessageSend = mock(HelloMessage.class);
    when(helloMessageSend.getHeadBlockId()).thenReturn(blockId);
    BlockId blockId2 = mock(BlockId.class);
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
   * Test {@link PeerConnection#onConnect()}.
   * <ul>
   *   <li>Then not {@link PeerConnection} (default constructor) SyncFinish.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#onConnect()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PeerConnection.onConnect()"})
  public void testOnConnect_thenNotPeerConnectionSyncFinish() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    HelloMessage helloMessageSend = mock(HelloMessage.class);
    when(helloMessageSend.getHeadBlockId()).thenReturn(blockId);
    HelloMessage helloMessageReceive = mock(HelloMessage.class);
    when(helloMessageReceive.getHeadBlockId()).thenReturn(new BlockId());

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
   * Test {@link PeerConnection#isSyncFinish()}.
   * <ul>
   *   <li>Given {@link PeerConnection} NeedSyncFromUs is {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isSyncFinish()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isSyncFinish()"})
  public void testIsSyncFinish_givenPeerConnectionNeedSyncFromUsIsFalse_thenReturnTrue() {
    // Arrange
    peerConnection.setNeedSyncFromPeer(false);
    peerConnection.setNeedSyncFromUs(false);

    // Act and Assert
    assertTrue(peerConnection.isSyncFinish());
  }

  /**
   * Test {@link PeerConnection#isSyncFinish()}.
   * <ul>
   *   <li>Given {@link PeerConnection} NeedSyncFromUs is {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isSyncFinish()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isSyncFinish()"})
  public void testIsSyncFinish_givenPeerConnectionNeedSyncFromUsIsTrue_thenReturnFalse() {
    // Arrange
    peerConnection.setNeedSyncFromPeer(false);
    peerConnection.setNeedSyncFromUs(true);

    // Act and Assert
    assertFalse(peerConnection.isSyncFinish());
  }

  /**
   * Test {@link PeerConnection#isSyncFinish()}.
   * <ul>
   *   <li>Given {@link PeerConnection}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#isSyncFinish()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.isSyncFinish()"})
  public void testIsSyncFinish_givenPeerConnection_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(peerConnection.isSyncFinish());
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>Given {@code BLOCK}.</li>
   *   <li>When {@link FetchInvDataMessage} {@link InventoryMessage#getInventoryType()} return {@code BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_givenBlock_whenFetchInvDataMessageGetInventoryTypeReturnBlock() {
    // Arrange
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getInventoryType()).thenReturn(InventoryType.BLOCK);

    // Act
    boolean actualNeedToLogResult = PeerConnection.needToLog(msg);

    // Assert
    verify(msg).getInventoryType();
    assertTrue(actualNeedToLogResult);
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>Given {@code TRX}.</li>
   *   <li>When {@link FetchInvDataMessage} {@link InventoryMessage#getInventoryType()} return {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_givenTrx_whenFetchInvDataMessageGetInventoryTypeReturnTrx() {
    // Arrange
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getInventoryType()).thenReturn(InventoryType.TRX);

    // Act
    boolean actualNeedToLogResult = PeerConnection.needToLog(msg);

    // Assert
    verify(msg).getInventoryType();
    assertFalse(actualNeedToLogResult);
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>When {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)} with hashList is {@link ArrayList#ArrayList()} and type is {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_whenFetchInvDataMessageWithHashListIsArrayListAndTypeIsTrx() {
    // Arrange, Act and Assert
    assertFalse(PeerConnection.needToLog(new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX)));
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PeerConnection.needToLog(null));
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>When {@link PbftMessage#PbftMessage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_whenPbftMessage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PeerConnection.needToLog(new PbftMessage()));
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>When {@link PingMessage#PingMessage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_whenPingMessage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PeerConnection.needToLog(new PingMessage()));
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>When {@link PongMessage#PongMessage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_whenPongMessage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PeerConnection.needToLog(new PongMessage()));
  }

  /**
   * Test {@link PeerConnection#needToLog(Message)}.
   * <ul>
   *   <li>When {@link TransactionsMessage#TransactionsMessage(List)} with trxs is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#needToLog(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.needToLog(Message)"})
  public void testNeedToLog_whenTransactionsMessageWithTrxsIsArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PeerConnection.needToLog(new TransactionsMessage(new ArrayList<>())));
  }

  /**
   * Test {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}.
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link BlockId#BlockId()} and type is {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.checkAndPutAdvInvRequest(Item, Long)"})
  public void testCheckAndPutAdvInvRequest_whenItemWithHashIsBlockIdAndTypeIsTrx() {
    // Arrange and Act
    boolean actualCheckAndPutAdvInvRequestResult = peerConnection
        .checkAndPutAdvInvRequest(new Item(new BlockId(), InventoryType.TRX), 42L);

    // Assert
    assertEquals(1, peerConnection.getAdvInvRequest().size());
    assertFalse(peerConnection.isIdle());
    assertTrue(actualCheckAndPutAdvInvRequestResult);
  }

  /**
   * Test {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}.
   * <ul>
   *   <li>When {@link Item#Item(Sha256Hash, InventoryType)} with hash is {@link Sha256Hash} and type is {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.checkAndPutAdvInvRequest(Item, Long)"})
  public void testCheckAndPutAdvInvRequest_whenItemWithHashIsSha256HashAndTypeIsTrx() {
    // Arrange and Act
    boolean actualCheckAndPutAdvInvRequestResult = peerConnection
        .checkAndPutAdvInvRequest(new Item(mock(Sha256Hash.class), InventoryType.TRX), 42L);

    // Assert
    assertEquals(1, peerConnection.getAdvInvRequest().size());
    assertFalse(peerConnection.isIdle());
    assertTrue(actualCheckAndPutAdvInvRequestResult);
  }

  /**
   * Test {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}.
   * <ul>
   *   <li>When {@link Item}.</li>
   *   <li>Then {@link PeerConnection} AdvInvRequest size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#checkAndPutAdvInvRequest(Item, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.checkAndPutAdvInvRequest(Item, Long)"})
  public void testCheckAndPutAdvInvRequest_whenItem_thenPeerConnectionAdvInvRequestSizeIsOne() {
    // Arrange and Act
    boolean actualCheckAndPutAdvInvRequestResult = peerConnection.checkAndPutAdvInvRequest(mock(Item.class), 42L);

    // Assert
    assertEquals(1, peerConnection.getAdvInvRequest().size());
    assertFalse(peerConnection.isIdle());
    assertTrue(actualCheckAndPutAdvInvRequestResult);
  }

  /**
   * Test {@link PeerConnection#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.equals(Object)", "int PeerConnection.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PeerConnection(), 1);
  }

  /**
   * Test {@link PeerConnection#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.equals(Object)", "int PeerConnection.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PeerConnection(), null);
  }

  /**
   * Test {@link PeerConnection#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.equals(Object)", "int PeerConnection.hashCode()"})
  public void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(NullPointerException.class, () -> (new PeerConnection()).equals(new PeerConnection()));
  }

  /**
   * Test {@link PeerConnection#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PeerConnection#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PeerConnection.equals(Object)", "int PeerConnection.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PeerConnection(), "Different type to PeerConnection");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PeerConnection#setAddress(ByteString)}
   *   <li>{@link PeerConnection#setAdvInvReceive(Cache)}
   *   <li>{@link PeerConnection#setAdvInvRequest(Map)}
   *   <li>{@link PeerConnection#setAdvInvSpread(Cache)}
   *   <li>{@link PeerConnection#setBadPeer(boolean)}
   *   <li>{@link PeerConnection#setFastForwardBlock(BlockId)}
   *   <li>{@link PeerConnection#setFetchAble(boolean)}
   *   <li>{@link PeerConnection#setLastInteractiveTime(long)}
   *   <li>{@link PeerConnection#setLastSyncBlockId(BlockId)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString PeerConnection.getAddress()", "Cache PeerConnection.getAdvInvReceive()",
      "Map PeerConnection.getAdvInvRequest()", "Cache PeerConnection.getAdvInvSpread()",
      "BlockId PeerConnection.getBlockBothHave()", "long PeerConnection.getBlockBothHaveUpdateTime()",
      "Channel PeerConnection.getChannel()", "HelloMessage PeerConnection.getHelloMessageReceive()",
      "HelloMessage PeerConnection.getHelloMessageSend()", "long PeerConnection.getLastInteractiveTime()",
      "BlockId PeerConnection.getLastSyncBlockId()", "NodeStatistics PeerConnection.getNodeStatistics()",
      "PeerStatistics PeerConnection.getPeerStatistics()", "long PeerConnection.getRemainNum()",
      "Cache PeerConnection.getSyncBlockIdCache()", "Set PeerConnection.getSyncBlockInProcess()",
      "Map PeerConnection.getSyncBlockRequested()", "Deque PeerConnection.getSyncBlockToFetch()",
      "Pair PeerConnection.getSyncChainRequested()", "TronState PeerConnection.getTronState()",
      "boolean PeerConnection.isBadPeer()", "boolean PeerConnection.isFetchAble()",
      "boolean PeerConnection.isNeedSyncFromPeer()", "boolean PeerConnection.isNeedSyncFromUs()",
      "boolean PeerConnection.isRelayPeer()", "void PeerConnection.setAddress(ByteString)",
      "void PeerConnection.setAdvInvReceive(Cache)", "void PeerConnection.setAdvInvRequest(Map)",
      "void PeerConnection.setAdvInvSpread(Cache)", "void PeerConnection.setBadPeer(boolean)",
      "void PeerConnection.setFastForwardBlock(BlockId)", "void PeerConnection.setFetchAble(boolean)",
      "void PeerConnection.setHelloMessageReceive(HelloMessage)",
      "void PeerConnection.setHelloMessageSend(HelloMessage)", "void PeerConnection.setLastInteractiveTime(long)",
      "void PeerConnection.setLastSyncBlockId(BlockId)", "void PeerConnection.setNeedSyncFromPeer(boolean)",
      "void PeerConnection.setNeedSyncFromUs(boolean)", "void PeerConnection.setRelayPeer(boolean)",
      "void PeerConnection.setRemainNum(long)", "void PeerConnection.setSyncBlockInProcess(Set)",
      "void PeerConnection.setSyncBlockRequested(Map)", "void PeerConnection.setSyncBlockToFetch(Deque)",
      "void PeerConnection.setSyncChainRequested(Pair)", "void PeerConnection.setTronState(TronState)"})
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
    BlockId fastForwardBlock = new BlockId();
    peerConnection.setFastForwardBlock(fastForwardBlock);
    peerConnection.setFetchAble(true);
    peerConnection.setLastInteractiveTime(1L);
    BlockId lastSyncBlockId = new BlockId();
    peerConnection.setLastSyncBlockId(lastSyncBlockId);
    peerConnection.setNeedSyncFromPeer(true);
    peerConnection.setNeedSyncFromUs(true);
    peerConnection.setRelayPeer(true);
    peerConnection.setRemainNum(1L);
    HashSet<BlockId> syncBlockInProcess = new HashSet<>();
    peerConnection.setSyncBlockInProcess(syncBlockInProcess);
    HashMap<BlockId, Long> syncBlockRequested = new HashMap<>();
    peerConnection.setSyncBlockRequested(syncBlockRequested);
    LinkedList<BlockId> syncBlockToFetch = new LinkedList<>();
    peerConnection.setSyncBlockToFetch(syncBlockToFetch);
    Pair<Deque<BlockId>, Long> syncChainRequested = new Pair<>(new LinkedList<>(), 42L);

    peerConnection.setSyncChainRequested(syncChainRequested);
    peerConnection.setTronState(TronState.INIT);
    ByteString actualAddress = peerConnection.getAddress();
    Cache<Item, Long> actualAdvInvReceive = peerConnection.getAdvInvReceive();
    Map<Item, Long> actualAdvInvRequest = peerConnection.getAdvInvRequest();
    Cache<Item, Long> actualAdvInvSpread = peerConnection.getAdvInvSpread();
    BlockId actualBlockBothHave = peerConnection.getBlockBothHave();
    peerConnection.getBlockBothHaveUpdateTime();
    Channel actualChannel = peerConnection.getChannel();
    HelloMessage actualHelloMessageReceive = peerConnection.getHelloMessageReceive();
    HelloMessage actualHelloMessageSend = peerConnection.getHelloMessageSend();
    long actualLastInteractiveTime = peerConnection.getLastInteractiveTime();
    BlockId actualLastSyncBlockId = peerConnection.getLastSyncBlockId();
    NodeStatistics actualNodeStatistics = peerConnection.getNodeStatistics();
    PeerStatistics actualPeerStatistics = peerConnection.getPeerStatistics();
    long actualRemainNum = peerConnection.getRemainNum();
    peerConnection.getSyncBlockIdCache();
    Set<BlockId> actualSyncBlockInProcess = peerConnection.getSyncBlockInProcess();
    Map<BlockId, Long> actualSyncBlockRequested = peerConnection.getSyncBlockRequested();
    Deque<BlockId> actualSyncBlockToFetch = peerConnection.getSyncBlockToFetch();
    Pair<Deque<BlockId>, Long> actualSyncChainRequested = peerConnection.getSyncChainRequested();
    TronState actualTronState = peerConnection.getTronState();
    boolean actualIsBadPeerResult = peerConnection.isBadPeer();
    boolean actualIsFetchAbleResult = peerConnection.isFetchAble();
    boolean actualIsNeedSyncFromPeerResult = peerConnection.isNeedSyncFromPeer();
    boolean actualIsNeedSyncFromUsResult = peerConnection.isNeedSyncFromUs();
    boolean actualIsRelayPeerResult = peerConnection.isRelayPeer();

    // Assert
    assertTrue(actualSyncBlockToFetch instanceof List);
    assertNull(actualAddress);
    assertNull(actualHelloMessageReceive);
    assertNull(actualHelloMessageSend);
    assertNull(actualNodeStatistics);
    assertNull(actualChannel);
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
