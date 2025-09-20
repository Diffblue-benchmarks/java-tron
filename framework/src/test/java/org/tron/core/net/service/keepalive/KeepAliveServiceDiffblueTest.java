package org.tron.core.net.service.keepalive;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.overlay.message.Message;
import org.tron.core.net.message.MessageTypes;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.peer.PeerConnection;

public class KeepAliveServiceDiffblueTest {
  /**
   * Test {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}.
   *
   * <ul>
   *   <li>Given {@code FIRST}.
   *   <li>When {@link PingMessage} {@link PingMessage#getType()} return {@code FIRST}.
   *   <li>Then calls {@link PingMessage#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeepAliveService.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenFirst_whenPingMessageGetTypeReturnFirst_thenCallsGetType() {
    // Arrange
    KeepAliveService keepAliveService = new KeepAliveService();
    PeerConnection peer = new PeerConnection();

    PingMessage message = mock(PingMessage.class);
    when(message.getType()).thenReturn(MessageTypes.FIRST);

    // Act
    keepAliveService.processMessage(peer, message);

    // Assert
    verify(message).getType();
  }

  /**
   * Test {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}.
   *
   * <ul>
   *   <li>Given {@code P2P_PING}.
   *   <li>Then calls {@link PeerConnection#sendMessage(Message)}.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeepAliveService.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenP2pPing_thenCallsSendMessage() {
    // Arrange
    KeepAliveService keepAliveService = new KeepAliveService();

    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).sendMessage(Mockito.<Message>any());

    PingMessage message = mock(PingMessage.class);
    when(message.getType()).thenReturn(MessageTypes.P2P_PING);

    // Act
    keepAliveService.processMessage(peer, message);

    // Assert
    verify(message).getType();
    verify(peer).sendMessage(isA(Message.class));
  }
}
