package org.tron.core.net.service.handshake;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.net.message.handshake.HelloMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

@RunWith(MockitoJUnitRunner.class)
public class HandshakeServiceDiffblueTest {
  @InjectMocks
  private HandshakeService handshakeService;

  /**
   * Test {@link HandshakeService#processHelloMessage(PeerConnection, HelloMessage)}.
   * <ul>
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HandshakeService#processHelloMessage(PeerConnection, HelloMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HandshakeService.processHelloMessage(PeerConnection, HelloMessage)"})
  public void testProcessHelloMessage_thenCallsDisconnect() throws Exception {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getHelloMessageReceive()).thenReturn(new HelloMessage(new byte[]{}));

    // Act
    handshakeService.processHelloMessage(peer, mock(HelloMessage.class));

    // Assert
    verify(peer).disconnect(eq(ReasonCode.BAD_PROTOCOL));
    verify(peer).getHelloMessageReceive();
    verify(peer).getInetSocketAddress();
  }
}
