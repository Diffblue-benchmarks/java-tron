package org.tron.core.net.messagehandler;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.MessageTypes;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.message.adv.InventoryMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.adv.AdvService;
import org.tron.core.net.service.statistics.MessageCount;
import org.tron.core.net.service.statistics.PeerStatistics;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

@RunWith(MockitoJUnitRunner.class)
public class FetchInvDataMsgHandlerDiffblueTest {
  @Mock
  private AdvService advService;

  @InjectMocks
  private FetchInvDataMsgHandler fetchInvDataMsgHandler;

  /**
   * Test {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@link AdvService} {@link AdvService#getTrxCount()} return {@link MessageCount} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenAdvServiceGetTrxCountReturnMessageCount() throws P2pException {
    // Arrange
    when(advService.getTrxCount()).thenReturn(new MessageCount());
    PeerConnection peer = new PeerConnection();

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(advService).getTrxCount();
  }

  /**
   * Test {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@code FIRST}.</li>
   *   <li>When {@link PeerConnection}.</li>
   *   <li>Then calls {@link InventoryMessage#getHashList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenFirst_whenPeerConnection_thenCallsGetHashList() throws P2pException {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInvMessageType()).thenReturn(MessageTypes.FIRST);
    when(msg.getInventoryType()).thenReturn(InventoryType.TRX);

    // Act
    fetchInvDataMsgHandler.processMessage(peer, msg);

    // Assert
    verify(msg, atLeast(1)).getHashList();
    verify(msg).getInvMessageType();
    verify(msg).getInventoryType();
  }

  /**
   * Test {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@link InetAddress}.</li>
   *   <li>Then calls {@link PeerConnection#getInetAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenInetAddress_thenCallsGetInetAddress() throws P2pException {
    // Arrange
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(-1);
    when(advService.getTrxCount()).thenReturn(messageCount);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getPeerStatistics()).thenReturn(new PeerStatistics());

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(peer).getInetAddress();
    verify(peer).getPeerStatistics();
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }

  /**
   * Test {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Given {@link MessageCount} {@link MessageCount#getCount(int)} return three.</li>
   *   <li>Then calls {@link MessageCount#getCount(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenMessageCountGetCountReturnThree_thenCallsGetCount() throws P2pException {
    // Arrange
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(3);
    when(advService.getTrxCount()).thenReturn(messageCount);
    PeerConnection peer = new PeerConnection();

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }

  /**
   * Test {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Then calls {@link PeerConnection#getPeerStatistics()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_thenCallsGetPeerStatistics() throws P2pException {
    // Arrange
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(3);
    when(advService.getTrxCount()).thenReturn(messageCount);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getPeerStatistics()).thenReturn(new PeerStatistics());

    // Act
    fetchInvDataMsgHandler.processMessage(peer, new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX));

    // Assert
    verify(peer).getPeerStatistics();
    verify(advService).getTrxCount();
    verify(messageCount).getCount(eq(60));
  }

  /**
   * Test {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>When {@link FetchInvDataMessage} {@link InventoryMessage#getInvMessageType()} return {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchInvDataMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_whenFetchInvDataMessageGetInvMessageTypeReturnTrx() throws P2pException {
    // Arrange
    MessageCount messageCount = mock(MessageCount.class);
    when(messageCount.getCount(anyInt())).thenReturn(-1);
    when(advService.getTrxCount()).thenReturn(messageCount);
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peer.getPeerStatistics()).thenReturn(new PeerStatistics());
    FetchInvDataMessage msg = mock(FetchInvDataMessage.class);
    when(msg.getHashList()).thenReturn(new ArrayList<>());
    when(msg.getInvMessageType()).thenReturn(MessageTypes.TRX);
    when(msg.getInventoryType()).thenReturn(InventoryType.TRX);

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
