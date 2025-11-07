package org.tron.core.net.messagehandler;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetAddress;
import java.util.ArrayList;
import org.junit.Test;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.protos.Protocol;

public class InventoryMsgHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage() {
    // Arrange
    InventoryMsgHandler inventoryMsgHandler = new InventoryMsgHandler();
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.isNeedSyncFromPeer()).thenReturn(true);
    when(peer.isNeedSyncFromUs()).thenReturn(true);
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    inventoryMsgHandler.processMessage(peer, msg);

    // Assert
    verify(msg).getHashList();
    verify(msg, atLeast(1)).getInventoryType();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }

  /**
   * Method under test:
   * {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage2() {
    // Arrange
    InventoryMsgHandler inventoryMsgHandler = new InventoryMsgHandler();
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(true);
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.TRX);

    // Act
    inventoryMsgHandler.processMessage(peer, msg);

    // Assert
    verify(msg).getHashList();
    verify(msg, atLeast(1)).getInventoryType();
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).isNeedSyncFromPeer();
    verify(peer, atLeast(1)).isNeedSyncFromUs();
  }

  /**
   * Method under test:
   * {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage3() {
    // Arrange
    InventoryMsgHandler inventoryMsgHandler = new InventoryMsgHandler();
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(false);
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInventoryType()).thenReturn(Protocol.Inventory.InventoryType.BLOCK);

    // Act
    inventoryMsgHandler.processMessage(peer, msg);

    // Assert that nothing has changed
    verify(msg, atLeast(1)).getHashList();
    verify(msg, atLeast(1)).getInventoryType();
    verify(peer).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }
}
