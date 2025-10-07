package org.tron.core.net.service.handshake;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.tron.p2p.discover.Node;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

@RunWith(MockitoJUnitRunner.class)
public class HandshakeServiceDiffblueTest {
  @InjectMocks private HandshakeService handshakeService;

  /**
   * Test {@link HandshakeService#processHelloMessage(PeerConnection, HelloMessage)}.
   *
   * <ul>
   *   <li>Given createUnresolved {@code foo} and one.
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.
   * </ul>
   *
   * <p>Method under test: {@link HandshakeService#processHelloMessage(PeerConnection,
   * HelloMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HandshakeService.processHelloMessage(PeerConnection, HelloMessage)"})
  public void testProcessHelloMessage_givenCreateUnresolvedFooAndOne_thenCallsDisconnect() {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    when(peer.getHelloMessageReceive()).thenReturn(mock(HelloMessage.class));
    HelloMessage msg = mock(HelloMessage.class);

    Node node = mock(Node.class);
    doNothing().when(node).setId(Mockito.<byte[]>any());
    node.setId(null);

    // Act
    handshakeService.processHelloMessage(peer, msg);

    // Assert
    verify(peer).disconnect(ReasonCode.BAD_PROTOCOL);
    verify(peer).getHelloMessageReceive();
    verify(peer).getInetSocketAddress();
    verify(node).setId(isNull());
  }
}
