package org.tron.core.net.service.sync;

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
import java.util.ArrayList;
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
import org.tron.common.utils.Pair;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.exception.P2pException;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.adv.BlockMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.peer.TronState;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SyncServiceDiffblueTest {
  @InjectMocks private SyncService syncService;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.
   *   <li>Then calls {@link TronNetDelegate#getBlockChainHashesOnFork(BlockId)}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenArrayListAddBlockId_thenCallsGetBlockChainHashesOnFork()
      throws P2pException {
    // Arrange
    ArrayList<BlockId> blockIdList = new ArrayList<>();
    blockIdList.add(new BlockId());
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(false);
    when(tronNetDelegate.getBlockChainHashesOnFork(Mockito.<BlockId>any())).thenReturn(blockIdList);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getBlockChainHashesOnFork(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link BlockId} {@link BlockId#getNum()} return zero.
   *   <li>Then calls {@link BlockId#getByteString()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenBlockIdGetNumReturnZero_thenCallsGetByteString() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);

    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getByteString()).thenReturn(null);
    when(blockId2.getNum()).thenReturn(1L);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId2);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    BlockId blockId3 = mock(BlockId.class);
    when(blockId3.getNum()).thenReturn(0L);

    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId3);
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
    verify(blockId2).getByteString();
    verify(blockId2).getNum();
    verify(blockId).getNum();
    verify(blockId3).getNum();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setSyncChainRequested(isA(Pair.class));
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link BlockId} {@link BlockId#getString()} return {@code String}.
   *   <li>Then calls {@link BlockId#getString()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenBlockIdGetStringReturnString_thenCallsGetString()
      throws P2pException {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(false);
    when(tronNetDelegate.getBlockChainHashesOnFork(Mockito.<BlockId>any()))
        .thenReturn(new ArrayList<>());
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId).getNum();
    verify(blockId).getString();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getBlockChainHashesOnFork(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>When {@link PeerConnection} {@link PeerConnection#getBlockBothHave()} return {@link
   *       BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenBlockId_whenPeerConnectionGetBlockBothHaveReturnBlockId() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);

    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getByteString()).thenReturn(null);
    when(blockId2.getNum()).thenReturn(1L);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId2);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(new BlockId());
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
    verify(blockId2).getByteString();
    verify(blockId2).getNum();
    verify(blockId).getNum();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setSyncChainRequested(isA(Pair.class));
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@code SYNCING}.
   *   <li>When {@link PeerConnection} {@link PeerConnection#getTronState()} return {@code SYNCING}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
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
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#containBlockInMainChain(BlockId)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenTronNetDelegateContainBlockInMainChainReturnTrue() {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getForkLock()} return {@code null}.
   *   <li>Then calls {@link TronNetDelegate#getForkLock()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenTronNetDelegateGetForkLockReturnNull_thenCallsGetForkLock() {
    // Arrange
    when(tronNetDelegate.getForkLock()).thenReturn(null);
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getInetAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getSyncBeginNumber()} return minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_givenTronNetDelegateGetSyncBeginNumberReturnMinusOne()
      throws P2pException {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(false);
    when(tronNetDelegate.getBlockChainHashesOnFork(Mockito.<BlockId>any()))
        .thenReturn(new ArrayList<>());
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(-1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId).getNum();
    verify(blockId).getString();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getBlockChainHashesOnFork(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getGenesisBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>Then calls {@link PeerConnection#getInetSocketAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_thenCallsGetInetSocketAddress() {
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
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#startSync(PeerConnection)}.
   *
   * <ul>
   *   <li>When {@link PeerConnection} {@link PeerConnection#getBlockBothHave()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#startSync(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.startSync(PeerConnection)"})
  public void testStartSync_whenPeerConnectionGetBlockBothHaveReturnNull() {
    // Arrange
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");
    when(tronNetDelegate.getGenesisBlockId()).thenReturn(mock(BlockId.class));

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(null);
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
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).getTronState();
    verify(peer).setBlockBothHave(isA(BlockId.class));
    verify(peer).setNeedSyncFromPeer(true);
    verify(peer).setRemainNum(0L);
    verify(peer).setTronState(TronState.SYNCING);
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   *
   * <ul>
   *   <li>Given createUnresolved {@code foo} and one.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenCreateUnresolvedFooAndOne() {
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
   *
   * <ul>
   *   <li>Given {@link LinkedList#LinkedList()}.
   *   <li>Then calls {@link TronNetDelegate#getSyncBeginNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenLinkedList_thenCallsGetSyncBeginNumber() {
    // Arrange
    when(tronNetDelegate.getSyncBeginNumber()).thenThrow(new RuntimeException());
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getBlockBothHave()).thenReturn(new BlockId());
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenRuntimeException() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenThrow(new RuntimeException());
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getSyncChainRequested()).thenReturn(new Pair<>(new LinkedList<>(), 42L));
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());

    // Act
    syncService.syncNext(peer);

    // Assert
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getInetAddress();
    verify(peer).getInetSocketAddress();
    verify(peer).getSyncChainRequested();
  }

  /**
   * Test {@link SyncService#syncNext(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getForkLock()} return {@code null}.
   *   <li>Then calls {@link TronNetDelegate#getForkLock()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#syncNext(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.syncNext(PeerConnection)"})
  public void testSyncNext_givenTronNetDelegateGetForkLockReturnNull_thenCallsGetForkLock() {
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getInetAddress();
    verify(peer).getSyncChainRequested();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>When {@link PeerConnection} (default constructor).
   *   <li>Then calls {@link BlockCapsule#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
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
   *
   * <ul>
   *   <li>Given {@link BlockId} {@link BlockId#getByteString()} return {@code null}.
   *   <li>Then calls {@link BlockId#getByteString()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenBlockIdGetByteStringReturnNull_thenCallsGetByteString()
      throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);

    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getByteString()).thenReturn(null);
    when(blockId2.getNum()).thenReturn(1L);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId2);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(blockId2).getByteString();
    verify(block).getData();
    verify(blockId2).getNum();
    verify(blockId).getNum();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
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
   *
   * <ul>
   *   <li>Given {@link BlockId} {@link BlockId#getNum()} return zero.
   *   <li>Then calls {@link BlockId#getByteString()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenBlockIdGetNumReturnZero_thenCallsGetByteString()
      throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(1L);

    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getByteString()).thenReturn(null);
    when(blockId2.getNum()).thenReturn(1L);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(blockId2);
    when(tronNetDelegate.getHeadBlockId()).thenReturn(blockId);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    BlockId blockId3 = mock(BlockId.class);
    when(blockId3.getNum()).thenReturn(0L);

    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).setSyncChainRequested(Mockito.<Pair<Deque<BlockId>, Long>>any());
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId3);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(blockId2).getByteString();
    verify(block).getData();
    verify(blockId2).getNum();
    verify(blockId).getNum();
    verify(blockId3).getNum();
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getHeadBlockId();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
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
   *
   * <ul>
   *   <li>Given createUnresolved {@code foo} and one.
   *   <li>Then calls {@link PeerConnection#getInetSocketAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
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
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PeerConnection} {@link PeerConnection#isSyncIdle()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
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
   *
   * <ul>
   *   <li>Given {@link LinkedList#LinkedList()} add {@link BlockId#BlockId()}.
   *   <li>Then calls {@link PeerConnection#getSyncBlockToFetch()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenLinkedListAddBlockId_thenCallsGetSyncBlockToFetch()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link SyncService} (default constructor).
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenSyncService_thenCallsDisconnect()
      throws UnsupportedEncodingException {
    // Arrange
    SyncService syncService = new SyncService();

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#containBlockInMainChain(BlockId)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateContainBlockInMainChainReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getHeadBlockId()} return {@link
   *       BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetHeadBlockIdReturnBlockId()
      throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getHeadBlockId()).thenReturn(new BlockId());
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getHeadBlockId()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetHeadBlockIdReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getHeadBlockId()).thenReturn(null);
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getKhaosDbHeadBlockId()} return
   *       {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
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
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
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
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getKhaosDbHeadBlockId()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
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
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#getSyncBeginNumber()} return minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenTronNetDelegateGetSyncBeginNumberReturnMinusOne()
      throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(-1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link PeerConnection} {@link PeerConnection#getRemainNum()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_givenZero_whenPeerConnectionGetRemainNumReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getRemainNum()).thenReturn(0L);
    when(peer.isSyncIdle()).thenReturn(true);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    syncService.processBlock(peer, new BlockMessage(block));

    // Assert
    verify(block).getData();
    verify(peer).getRemainNum();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>Then calls {@link BlockId#getString()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_thenCallsGetString()
      throws UnsupportedEncodingException, P2pException {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(false);
    when(tronNetDelegate.getBlockChainHashesOnFork(Mockito.<BlockId>any()))
        .thenReturn(new ArrayList<>());
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
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
    verify(blockId).getString();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getBlockChainHashesOnFork(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>When {@link BlockMessage}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_whenBlockMessage() {
    // Arrange
    when(tronNetDelegate.containBlockInMainChain(Mockito.<BlockId>any())).thenReturn(true);
    when(tronNetDelegate.getKhaosDbHeadBlockId()).thenReturn(mock(BlockId.class));
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    BlockId blockId = mock(BlockId.class);
    when(blockId.getNum()).thenReturn(-1L);

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getBlockBothHave()).thenReturn(blockId);
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getSyncBlockToFetch()).thenReturn(new LinkedList<>());
    when(peer.getRemainNum()).thenReturn(1L);
    when(peer.isSyncIdle()).thenReturn(true);

    // Act
    syncService.processBlock(peer, mock(BlockMessage.class));

    // Assert
    verify(blockId, atLeast(1)).getNum();
    verify(tronNetDelegate).containBlockInMainChain(isA(BlockId.class));
    verify(tronNetDelegate).getForkLock();
    verify(tronNetDelegate).getKhaosDbHeadBlockId();
    verify(tronNetDelegate).getSyncBeginNumber();
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#processBlock(PeerConnection, BlockMessage)}.
   *
   * <ul>
   *   <li>When {@link PeerConnection} {@link PeerConnection#getBlockBothHave()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#processBlock(PeerConnection, BlockMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.processBlock(PeerConnection, BlockMessage)"})
  public void testProcessBlock_whenPeerConnectionGetBlockBothHaveReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(tronNetDelegate.getSyncBeginNumber()).thenReturn(1L);
    when(tronNetDelegate.getForkLock()).thenReturn("Fork Lock");

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncChainRequested()).thenReturn(null);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
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
    verify(peer).disconnect(ReasonCode.SYNC_FAIL);
    verify(peer).getBlockBothHave();
    verify(peer).getInetAddress();
    verify(peer).getRemainNum();
    verify(peer, atLeast(1)).getSyncBlockToFetch();
    verify(peer).getSyncChainRequested();
    verify(peer).isSyncIdle();
  }

  /**
   * Test {@link SyncService#onDisconnect(PeerConnection)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link BlockId#BlockId()} is one.
   *   <li>Then calls {@link PeerConnection#getSyncBlockRequested()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#onDisconnect(PeerConnection)}
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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link BlockId} is twenty-nine.
   *   <li>Then calls {@link PeerConnection#getSyncBlockRequested()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#onDisconnect(PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncService.onDisconnect(PeerConnection)"})
  public void testOnDisconnect_givenHashMapBlockIdIsTwentyNine_thenCallsGetSyncBlockRequested() {
    // Arrange
    HashMap<BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(mock(BlockId.class), 29L);
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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link PeerConnection#getSyncBlockRequested()}.
   * </ul>
   *
   * <p>Method under test: {@link SyncService#onDisconnect(PeerConnection)}
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
