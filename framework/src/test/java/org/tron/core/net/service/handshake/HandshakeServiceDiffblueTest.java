package org.tron.core.net.service.handshake;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.net.message.handshake.HelloMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.effective.EffectiveCheckService;
import org.tron.core.net.service.relay.RelayService;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class HandshakeServiceDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private EffectiveCheckService effectiveCheckService;

  @InjectMocks
  private HandshakeService handshakeService;

  @Mock
  private RelayService relayService;

  /**
   * Method under test:
   * {@link HandshakeService#processHelloMessage(PeerConnection, HelloMessage)}
   */
  @Test
  public void testProcessHelloMessage() throws Exception {
    // Arrange
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetSocketAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    doNothing().when(peer).disconnect(Mockito.<Protocol.ReasonCode>any());
    when(peer.getHelloMessageReceive()).thenReturn(new HelloMessage(new byte[]{}));

    // Act
    handshakeService.processHelloMessage(peer, new HelloMessage(new byte[]{}));

    // Assert that nothing has changed
    verify(peer).disconnect(eq(Protocol.ReasonCode.BAD_PROTOCOL));
    verify(peer).getHelloMessageReceive();
    verify(peer).getInetSocketAddress();
  }
}
