package org.tron.core.net.service.handshake;

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
import org.mockito.Mockito;
import org.tron.core.net.message.handshake.HelloMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

public class HandshakeServiceDiffblueTest {
  /**
   * Test {@link HandshakeService#processHelloMessage(PeerConnection, HelloMessage)}.
   *
   * <ul>
   *   <li>Given {@link HandshakeService} (default constructor).
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
  public void testProcessHelloMessage_givenHandshakeService_thenCallsDisconnect() throws Exception {
    // Arrange
    HandshakeService handshakeService = new HandshakeService();

    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    doNothing().when(peer).disconnect(Mockito.<ReasonCode>any());
    HelloMessage helloMessage = new HelloMessage(new byte[] {});
    when(peer.getHelloMessageReceive()).thenReturn(helloMessage);
    HelloMessage msg = new HelloMessage(new byte[] {});

    // Act
    handshakeService.processHelloMessage(peer, msg);

    // Assert
    verify(peer).disconnect(ReasonCode.BAD_PROTOCOL);
    verify(peer).getHelloMessageReceive();
    verify(peer).getInetSocketAddress();
  }
}
