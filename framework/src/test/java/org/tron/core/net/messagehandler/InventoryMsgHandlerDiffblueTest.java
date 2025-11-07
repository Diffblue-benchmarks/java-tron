package org.tron.core.net.messagehandler;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

@RunWith(MockitoJUnitRunner.class)
public class InventoryMsgHandlerDiffblueTest {
  @InjectMocks
  private InventoryMsgHandler inventoryMsgHandler;

  @Mock
  private TronNetDelegate tronNetDelegate;

  @Mock
  private TransactionsMsgHandler transactionsMsgHandler;

  /**
   * Test {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@link TransactionsMsgHandler} {@link TransactionsMsgHandler#isBusy()} return {@code false}.</li>
   *   <li>Then calls {@link TransactionsMsgHandler#isBusy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenTransactionsMsgHandlerIsBusyReturnFalse_thenCallsIsBusy() {
    // Arrange
    when(transactionsMsgHandler.isBusy()).thenReturn(false);
    when(tronNetDelegate.isBlockUnsolidified()).thenReturn(false);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(false);

    // Act
    inventoryMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(tronNetDelegate).isBlockUnsolidified();
    verify(transactionsMsgHandler).isBusy();
    verify(peer).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }

  /**
   * Test {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@link TransactionsMsgHandler} {@link TransactionsMsgHandler#isBusy()} return {@code true}.</li>
   *   <li>Then calls {@link TransactionsMsgHandler#isBusy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenTransactionsMsgHandlerIsBusyReturnTrue_thenCallsIsBusy() {
    // Arrange
    when(transactionsMsgHandler.isBusy()).thenReturn(true);
    when(tronNetDelegate.isBlockUnsolidified()).thenReturn(false);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(false);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    inventoryMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(tronNetDelegate).isBlockUnsolidified();
    verify(transactionsMsgHandler).isBusy();
    verify(peer).getInetAddress();
    verify(peer).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }

  /**
   * Test {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#isBlockUnsolidified()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenTronNetDelegateIsBlockUnsolidifiedReturnTrue() {
    // Arrange
    when(tronNetDelegate.isBlockUnsolidified()).thenReturn(true);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(false);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    inventoryMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(tronNetDelegate).isBlockUnsolidified();
    verify(peer).getInetAddress();
    verify(peer).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }

  /**
   * Test {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link PeerConnection} {@link PeerConnection#isNeedSyncFromPeer()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenTrue_whenPeerConnectionIsNeedSyncFromPeerReturnTrue() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(true);
    when(peer.isNeedSyncFromUs()).thenReturn(true);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    inventoryMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }

  /**
   * Test {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link PeerConnection} {@link PeerConnection#isNeedSyncFromUs()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenTrue_whenPeerConnectionIsNeedSyncFromUsReturnTrue() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(true);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    inventoryMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(peer).getInetAddress();
    verify(peer, atLeast(1)).isNeedSyncFromPeer();
    verify(peer, atLeast(1)).isNeedSyncFromUs();
  }

  /**
   * Test {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>When {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)} with hashList is {@link ArrayList#ArrayList()} and type is {@code BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_whenFetchInvDataMessageWithHashListIsArrayListAndTypeIsBlock() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.isNeedSyncFromPeer()).thenReturn(false);
    when(peer.isNeedSyncFromUs()).thenReturn(false);

    // Act
    inventoryMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.BLOCK));

    // Assert
    verify(peer).isNeedSyncFromPeer();
    verify(peer).isNeedSyncFromUs();
  }
}
