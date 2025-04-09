package org.tron.core.net.service.sync;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.overlay.message.Message;
import org.tron.common.utils.Pair;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.exception.P2pException;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.adv.BlockMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.peer.TronState;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SyncServiceDiffblueTest {
  @InjectMocks
  private SyncService syncService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with key is {@link LinkedList#LinkedList()} and value is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenPairWithKeyIsLinkedListAndValueIsFortyTwo() {
    // Arrange
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    when(peer.getSyncChainRequested()).thenReturn(new Pair<>(new LinkedList<>(), 42L));
    doNothing().when(peer).setBlockBothHave(Mockito.<BlockId>any());
    doNothing().when(peer).setRemainNum(anyLong());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    doNothing().when(peer).setNeedSyncFromPeer(anyBoolean());
    doNothing().when(peer).setTronState(Mockito.<TronState>any());
    when(peer.getTronState()).thenReturn(TronState.INIT);

    // Act
    syncService.startSync(peer);

    // Assert
    verify(tronNetDelegate).getGenesisBlockId();
    verify(peer).getInetSocketAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(eq(true));
    verify(peer).setRemainNum(eq(0L));
    verify(peer).setTronState(eq(TronState.SYNCING));
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   * <ul>
   *   <li>Given {@code SYNCING}.</li>
   *   <li>When {@link PeerConnection} {@link PeerConnection#getTronState()} return {@code SYNCING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenSyncing_whenPeerConnectionGetTronStateReturnSyncing() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    when(peer.getTronState()).thenReturn(TronState.SYNCING);

    // Act
    syncService.startSync(peer);

    // Assert
    verify(peer).getInetSocketAddress();
    verify(peer).getTronState();
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getForkLock()} return {@code null}.</li>
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenTronNetDelegateGetForkLockReturnNull_thenCallsDisconnect() {
    // Arrange
    when(tronNetDelegate.getForkLock()).thenReturn(null);
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    doNothing().when(peer).setBlockBothHave(Mockito.<BlockId>any());
    doNothing().when(peer).setRemainNum(anyLong());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    doNothing().when(peer).setNeedSyncFromPeer(anyBoolean());
    doNothing().when(peer).setTronState(Mockito.<TronState>any());
    when(peer.getTronState()).thenReturn(TronState.INIT);

    // Act
    syncService.startSync(peer);

    // Assert
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getInetAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(eq(true));
    verify(peer).setRemainNum(eq(0L));
    verify(peer).setTronState(eq(TronState.SYNCING));
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   * <ul>
   *   <li>Given createUnresolved {@code foo} and one.</li>
   *   <li>Then calls {@link PeerConnection#getInetSocketAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenCreateUnresolvedFooAndOne_thenCallsGetInetSocketAddress() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    when(peer.getSyncChainRequested()).thenReturn(new Pair<>(new LinkedList<>(), 42L));

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(peer).getInetSocketAddress();
    verify(peer).getSyncChainRequested();
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   * <ul>
   *   <li>Given {@link LinkedList#LinkedList()}.</li>
   *   <li>When {@link PeerConnection} {@link PeerConnection#getBlockBothHave()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenLinkedList_whenPeerConnectionGetBlockBothHaveReturnNull() {
    // Arrange
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(null);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getBlockIdByNum(long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenTronNetDelegateGetBlockIdByNumReturnNull() throws P2pException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getNum()).thenReturn(1L);
    when(tronNetDelegate.getBlockIdByNum(anyLong())).thenReturn(null);
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId2);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(-1L);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    BlockId blockId3 = mock(BlockId.class);
    when(blockId3.getNum()).thenReturn(1L);
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(blockId3);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(blockId).getNum();
    verify(blockId2, atLeast(1)).getNum();
    verify(blockId3, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getBlockIdByNum(eq(0L));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate, atLeast(1)).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).setSyncChainRequested(isA(Pair.class));
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getForkLock()} return {@code null}.</li>
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenTronNetDelegateGetForkLockReturnNull_thenCallsDisconnect() {
    // Arrange
    when(tronNetDelegate.getForkLock()).thenReturn(null);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(tronNetDelegate).getForkLock();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getInetAddress();
    verify(peer).getSyncChainRequested();
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   * <ul>
   *   <li>Then calls {@link Sha256Hash#getByteString()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_thenCallsGetByteString() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(null);
    when(blockId.getNum()).thenReturn(1L);
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getNum()).thenReturn(1L);
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(blockId2);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(blockId).getByteString();
    verify(blockId).getNum();
    verify(blockId2, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate, atLeast(1)).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).setSyncChainRequested(isA(Pair.class));
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   * <ul>
   *   <li>Then calls {@link PeerConnection#sendMessage(Message)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_thenCallsSendMessage() throws P2pException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getNum()).thenReturn(1L);
    when(tronNetDelegate.getBlockIdByNum(anyLong())).thenReturn(new BlockId());
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId2);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(-1L);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    LinkedList<BlockId> blockIdList = new LinkedList<>();
    blockIdList.add(new BlockId());
    BlockId blockId3 = mock(BlockId.class);
    when(blockId3.getNum()).thenReturn(1L);
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).sendMessage(Mockito.<Message>any());
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getSyncBlockToFetch()).thenReturn(blockIdList);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(blockId3);

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(blockId2).getNum();
    verify(blockId).getNum();
    verify(blockId3, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getBlockIdByNum(eq(0L));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate, atLeast(1)).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).getBlockBothHave();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).sendMessage(isA(Message.class));
    verify(peer).setSyncChainRequested(isA(Pair.class));
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>When {@link PeerConnection} (default constructor).</li>
   *   <li>Then calls {@link BlockCapsule#getData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenAxaxaxaxBytesIsUtf8_whenPeerConnection_thenCallsGetData()
      throws UnsupportedEncodingException {
    // Arrange
    PeerConnection peer = new PeerConnection();
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given createUnresolved {@code foo} and one.</li>
   *   <li>Then calls {@link PeerConnection#getInetSocketAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenCreateUnresolvedFooAndOne_thenCallsGetInetSocketAddress()
      throws UnsupportedEncodingException {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    when(peer.getSyncChainRequested()).thenReturn(new Pair<>(new LinkedList<>(), 42L));
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(peer).getInetSocketAddress();
    verify(peer).getRemainNum();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PeerConnection} {@link PeerConnection#isSyncIdle()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenFalse_whenPeerConnectionIsSyncIdleReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isSyncIdle()).thenReturn(false);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link LinkedList#LinkedList()} add {@link BlockId#BlockId()}.</li>
   *   <li>Then calls {@link PeerConnection#getRemainNum()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenLinkedListAddBlockId_thenCallsGetRemainNum() throws UnsupportedEncodingException {
    // Arrange
    LinkedList<BlockId> blockIdList = new LinkedList<>();
    blockIdList.add(new BlockId());
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncBlockToFetch()).thenReturn(blockIdList);
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(peer).getRemainNum();
    verify(peer).getSyncBlockToFetch();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#containBlockInMainChain(BlockId)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateContainBlockInMainChainReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(null);
    when(blockId.getNum()).thenReturn(1L);
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getNum()).thenReturn(1L);
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(blockId2);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(blockId).getByteString();
    verify(block).getData();
    verify(blockId).getNum();
    verify(blockId2, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate, atLeast(1)).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
    verify(peer).setSyncChainRequested(isA(Pair.class));
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getForkLock()} return {@code null}.</li>
   *   <li>Then calls {@link TronNetDelegate#getForkLock()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetForkLockReturnNull_thenCallsGetForkLock()
      throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getForkLock()).thenReturn(null);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(tronNetDelegate).getForkLock();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getHeadBlockId()} return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetHeadBlockIdReturnBlockId() throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getHeadBlockId()).thenReturn(new BlockId());
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(new BlockId());
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getHeadBlockId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetHeadBlockIdReturnNull() throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getHeadBlockId()).thenReturn(null);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(new BlockId());
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getKhaosDbHeadBlockId()} return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetKhaosDbHeadBlockIdReturnBlockId()
      throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(null);
    when(blockId.getNum()).thenReturn(1L);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(new BlockId());
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(new BlockId());
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(blockId).getByteString();
    verify(block).getData();
    verify(blockId, atLeast(1)).getNum();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate, atLeast(1)).getHeadBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
    verify(peer).setSyncChainRequested(isA(Pair.class));
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getKhaosDbHeadBlockId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetKhaosDbHeadBlockIdReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(null);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(new BlockId());
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(blockId).getNum();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>When {@link BlockMessage}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_whenBlockMessage() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(null);
    when(blockId.getNum()).thenReturn(1L);
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getNum()).thenReturn(1L);
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(blockId2);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);

    // Act
    syncService.processBlock(peer, mock(BlockMessage.class));

    // Assert
    verify(blockId).getByteString();
    verify(blockId).getNum();
    verify(blockId2, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate, atLeast(1)).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
    verify(peer).setSyncChainRequested(isA(Pair.class));
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   * <ul>
   *   <li>When {@link PeerConnection} {@link PeerConnection#getBlockBothHave()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_whenPeerConnectionGetBlockBothHaveReturnNull() throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getBlockBothHave()).thenReturn(null);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(eq(ReasonCode.SYNC_FAIL));
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link BlockId#BlockId()} is one.</li>
   *   <li>Then calls {@link PeerConnection#getSyncBlockRequested()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMapBlockIdIsOne_thenCallsGetSyncBlockRequested() {
    // Arrange
    HashMap<BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockId(), 1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);

    // Act
    syncService.onDisconnect(peer);

    // Assert
    verify(peer, atLeast(1)).getSyncBlockRequested();
  }

  /**
   * Test {@link SyncService#onDisconnect(PeerConnection)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PeerConnection#getSyncBlockRequested()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SyncService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMap_thenCallsGetSyncBlockRequested() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncBlockRequested()).thenReturn(new HashMap<>());

    // Act
    syncService.onDisconnect(peer);

    // Assert
    verify(peer).getSyncBlockRequested();
  }
}
