package org.tron.core.net.messagehandler;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.exception.P2pException;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.adv.BlockMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.adv.AdvService;
import org.tron.core.net.service.fetchblock.FetchBlockService;
import org.tron.core.net.service.relay.RelayService;
import org.tron.core.net.service.sync.SyncService;
import org.tron.core.services.WitnessProductBlockService;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class BlockMsgHandlerDiffblueTest {
  @Mock
  private AdvService advService;

  @InjectMocks
  private BlockMsgHandler blockMsgHandler;

  @Mock
  private FetchBlockService fetchBlockService;

  @Mock
  private RelayService relayService;

  @Mock
  private SyncService syncService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  @Mock
  private WitnessProductBlockService witnessProductBlockService;

  /**
   * Method under test:
   * {@link BlockMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage() throws P2pException {
    // Arrange
    doNothing().when(syncService).processBlock(Mockito.<PeerConnection>any(), Mockito.<BlockMessage>any());

    HashMap<BlockCapsule.BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockCapsule.BlockId(), -1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncBlockInProcess()).thenReturn(new HashSet<>());
    when(peer.isRelayPeer()).thenReturn(true);
    when(peer.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(blockCapsule.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    blockMsgHandler.processMessage(peer, msg);

    // Assert
    verify(blockCapsule).getInstance();
    verify(blockCapsule).getTimeStamp();
    verify(msg).getBlockCapsule();
    verify(msg).getBlockId();
    verify(peer).getSyncBlockInProcess();
    verify(peer, atLeast(1)).getSyncBlockRequested();
    verify(peer).isRelayPeer();
    verify(syncService).processBlock(isA(PeerConnection.class), isA(BlockMessage.class));
  }

  /**
   * Method under test:
   * {@link BlockMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage2() throws P2pException {
    // Arrange
    doNothing().when(syncService).processBlock(Mockito.<PeerConnection>any(), Mockito.<BlockMessage>any());

    HashMap<BlockCapsule.BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockCapsule.BlockId(), -1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getSyncBlockInProcess()).thenReturn(new HashSet<>());
    when(peer.isRelayPeer()).thenReturn(false);
    when(peer.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(blockCapsule.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    blockMsgHandler.processMessage(peer, msg);

    // Assert
    verify(blockCapsule).getInstance();
    verify(blockCapsule).getTimeStamp();
    verify(msg).getBlockCapsule();
    verify(msg, atLeast(1)).getBlockId();
    verify(peer).getSyncBlockInProcess();
    verify(peer, atLeast(1)).getSyncBlockRequested();
    verify(peer).isRelayPeer();
    verify(syncService).processBlock(isA(PeerConnection.class), isA(BlockMessage.class));
  }

  /**
   * Method under test:
   * {@link BlockMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage3() throws P2pException {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(Long.MAX_VALUE);
    when(blockCapsule.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act and Assert
    assertThrows(P2pException.class, () -> blockMsgHandler.processMessage(peer, msg));
    verify(blockCapsule).getInstance();
    verify(blockCapsule).getTimeStamp();
    verify(msg).getBlockCapsule();
    verify(msg, atLeast(1)).getBlockId();
    verify(peer).getInetSocketAddress();
  }

  /**
   * Method under test:
   * {@link BlockMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage4() throws P2pException {
    // Arrange
    HashMap<BlockCapsule.BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockCapsule.BlockId(), -1L);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isRelayPeer()).thenReturn(false);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    when(peer.getAdvInvRequest()).thenReturn(new HashMap<>());
    when(peer.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(blockCapsule.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());
    BlockMessage msg = mock(BlockMessage.class);
    when(msg.getBlockCapsule()).thenReturn(blockCapsule);
    when(msg.getBlockId()).thenReturn(mock(BlockCapsule.BlockId.class));

    // Act and Assert
    assertThrows(P2pException.class, () -> blockMsgHandler.processMessage(peer, msg));
    verify(blockCapsule).getInstance();
    verify(blockCapsule).getTimeStamp();
    verify(msg).getBlockCapsule();
    verify(msg, atLeast(1)).getBlockId();
    verify(peer).getAdvInvRequest();
    verify(peer).getInetSocketAddress();
    verify(peer).getSyncBlockRequested();
    verify(peer).isRelayPeer();
  }
}
