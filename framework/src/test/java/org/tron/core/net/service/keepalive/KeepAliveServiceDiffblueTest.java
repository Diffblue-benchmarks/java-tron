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
   * <ul>
   *   <li>Given {@code FIRST}.</li>
   *   <li>When {@link PeerConnection}.</li>
   *   <li>Then calls {@link Message#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeepAliveService.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_givenFirst_whenPeerConnection_thenCallsGetType() {
    // Arrange
    KeepAliveService keepAliveService = new KeepAliveService();
    PeerConnection peer = mock(PeerConnection.class);
    TronMessage message = mock(TronMessage.class);
    when(message.getType()).thenReturn(MessageTypes.FIRST);

    // Act
    keepAliveService.processMessage(peer, message);

    // Assert
    verify(message).getType();
  }

  /**
   * Test {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>When {@link PingMessage#PingMessage()}.</li>
   *   <li>Then calls {@link PeerConnection#sendMessage(Message)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeepAliveService.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_whenPingMessage_thenCallsSendMessage() {
    // Arrange
    KeepAliveService keepAliveService = new KeepAliveService();
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).sendMessage(Mockito.<Message>any());

    // Act
    keepAliveService.processMessage(peer, new PingMessage());

    // Assert
    verify(peer).sendMessage(isA(Message.class));
  }
}
