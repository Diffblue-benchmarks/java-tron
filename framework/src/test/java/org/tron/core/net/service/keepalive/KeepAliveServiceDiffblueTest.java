package org.tron.core.net.service.keepalive;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.common.overlay.message.Message;
import org.tron.core.net.message.MessageTypes;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.peer.PeerConnection;

@ContextConfiguration(classes = {KeepAliveService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class KeepAliveServiceDiffblueTest {
  @Autowired
  private KeepAliveService keepAliveService;

  /**
   * Method under test:
   * {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    doNothing().when(peer).sendMessage(Mockito.<Message>any());

    // Act
    keepAliveService.processMessage(peer, new PingMessage());

    // Assert
    verify(peer).sendMessage(isA(Message.class));
  }

  /**
   * Method under test:
   * {@link KeepAliveService#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage2() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    TronMessage message = mock(TronMessage.class);
    when(message.getType()).thenReturn(MessageTypes.FIRST);

    // Act
    keepAliveService.processMessage(peer, message);

    // Assert that nothing has changed
    verify(message).getType();
  }
}
