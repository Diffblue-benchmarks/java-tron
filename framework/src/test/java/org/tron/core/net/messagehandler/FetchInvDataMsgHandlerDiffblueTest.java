package org.tron.core.net.messagehandler;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetAddress;
import java.util.ArrayList;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.consensus.ConsensusDelegate;
import org.tron.core.exception.P2pException;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.MessageTypes;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.adv.AdvService;
import org.tron.core.net.service.statistics.MessageCount;
import org.tron.core.net.service.statistics.PeerStatistics;
import org.tron.core.net.service.sync.SyncService;
import org.tron.protos.Protocol;

public class FetchInvDataMsgHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage() throws P2pException {
    // Arrange
    FetchInvDataMsgHandler fetchInvDataMsgHandler = new FetchInvDataMsgHandler();
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "tronNetDelegate", mock(TronNetDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "syncService", mock(SyncService.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "consensusDelegate", mock(ConsensusDelegate.class));
    AdvService advService = mock(AdvService.class);
    when(advService.getTrxCount()).thenReturn(new MessageCount());
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "advService", advService);
    PeerConnection peer = new PeerConnection();

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(Protocol.Inventory.getDefaultInstance()));

    // Assert
    verify(advService).getTrxCount();
  }

  /**
   * Method under test:
   * {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage2() throws P2pException {
    // Arrange
    FetchInvDataMsgHandler fetchInvDataMsgHandler = new FetchInvDataMsgHandler();
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "tronNetDelegate", mock(TronNetDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "syncService", mock(SyncService.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "consensusDelegate", mock(ConsensusDelegate.class));
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(3);
    AdvService advService = mock(AdvService.class);
    when(advService.getTrxCount()).thenReturn(messageCount);
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "advService", advService);
    PeerConnection peer = new PeerConnection();

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(Protocol.Inventory.getDefaultInstance()));

    // Assert
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }

  /**
   * Method under test:
   * {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage3() throws P2pException {
    // Arrange
    FetchInvDataMsgHandler fetchInvDataMsgHandler = new FetchInvDataMsgHandler();
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "tronNetDelegate", mock(TronNetDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "syncService", mock(SyncService.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "consensusDelegate", mock(ConsensusDelegate.class));
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(3);
    AdvService advService = mock(AdvService.class);
    when(advService.getTrxCount()).thenReturn(messageCount);
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "advService", advService);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getPeerStatistics()).thenReturn(new PeerStatistics());

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(Protocol.Inventory.getDefaultInstance()));

    // Assert
    verify(peer).getPeerStatistics();
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }

  /**
   * Method under test:
   * {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage4() throws P2pException {
    // Arrange
    FetchInvDataMsgHandler fetchInvDataMsgHandler = new FetchInvDataMsgHandler();
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "tronNetDelegate", mock(TronNetDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "syncService", mock(SyncService.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "consensusDelegate", mock(ConsensusDelegate.class));
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(-1);
    AdvService advService = mock(AdvService.class);
    when(advService.getTrxCount()).thenReturn(messageCount);
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "advService", advService);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getPeerStatistics()).thenReturn(new PeerStatistics());

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(Protocol.Inventory.getDefaultInstance()));

    // Assert
    verify(peer).getInetAddress();
    verify(peer).getPeerStatistics();
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }

  /**
   * Method under test:
   * {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage5() throws P2pException {
    // Arrange
    FetchInvDataMsgHandler fetchInvDataMsgHandler = new FetchInvDataMsgHandler();
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "tronNetDelegate", mock(TronNetDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "syncService", mock(SyncService.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "consensusDelegate", mock(ConsensusDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "advService", mock(AdvService.class));
    PeerConnection peer = mock(PeerConnection.class);
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInvMessageType()).thenReturn(MessageTypes.FIRST);
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    fetchInvDataMsgHandler.processMessage(peer, msg);

    // Assert that nothing has changed
    verify(msg, atLeast(1)).getHashList();
    verify(msg).getInvMessageType();
    verify(msg).getInventoryType();
  }

  /**
   * Method under test:
   * {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage6() throws P2pException {
    // Arrange
    FetchInvDataMsgHandler fetchInvDataMsgHandler = new FetchInvDataMsgHandler();
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "tronNetDelegate", mock(TronNetDelegate.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "syncService", mock(SyncService.class));
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "consensusDelegate", mock(ConsensusDelegate.class));
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(-1);
    AdvService advService = mock(AdvService.class);
    when(advService.getTrxCount()).thenReturn(messageCount);
    ReflectionTestUtils.setField(fetchInvDataMsgHandler, "advService", advService);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getPeerStatistics()).thenReturn(new PeerStatistics());
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInvMessageType()).thenReturn(MessageTypes.TRX);
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    fetchInvDataMsgHandler.processMessage(peer, msg);

    // Assert
    verify(msg, atLeast(1)).getHashList();
    verify(msg).getInvMessageType();
    verify(msg).getInventoryType();
    verify(peer).getInetAddress();
    verify(peer).getPeerStatistics();
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }
}
