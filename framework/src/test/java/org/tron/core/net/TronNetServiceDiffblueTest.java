package org.tron.core.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.overlay.message.Message;
import org.tron.core.net.message.adv.TransactionMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.messagehandler.TransactionsMsgHandler;
import org.tron.core.net.peer.PeerStatusCheck;
import org.tron.core.net.service.adv.AdvService;
import org.tron.core.net.service.effective.EffectiveCheckService;
import org.tron.core.net.service.effective.ResilienceService;
import org.tron.core.net.service.fetchblock.FetchBlockService;
import org.tron.core.net.service.nodepersist.NodePersistService;
import org.tron.core.net.service.relay.RelayService;
import org.tron.core.net.service.statistics.TronStatsManager;
import org.tron.core.net.service.sync.SyncService;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class TronNetServiceDiffblueTest {
  @Mock
  private AdvService advService;

  @Mock
  private EffectiveCheckService effectiveCheckService;

  @Mock
  private FetchBlockService fetchBlockService;

  @Mock
  private NodePersistService nodePersistService;

  @Mock
  private P2pEventHandlerImpl p2pEventHandlerImpl;

  @Mock
  private PeerStatusCheck peerStatusCheck;

  @Mock
  private RelayService relayService;

  @Mock
  private ResilienceService resilienceService;

  @Mock
  private SyncService syncService;

  @Mock
  private TransactionsMsgHandler transactionsMsgHandler;

  @InjectMocks
  private TronNetService tronNetService;

  @Mock
  private TronStatsManager tronStatsManager;

  /**
   * Method under test: {@link TronNetService#broadcast(Message)}
   */
  @Test
  public void testBroadcast() {
    // Arrange
    doNothing().when(advService).broadcast(Mockito.<Message>any());

    // Act
    tronNetService.broadcast(new PingMessage());

    // Assert that nothing has changed
    verify(advService).broadcast(isA(Message.class));
  }

  /**
   * Method under test:
   * {@link TronNetService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  public void testFastBroadcastTransaction() {
    // Arrange
    when(advService.fastBroadcastTransaction(Mockito.<TransactionMessage>any())).thenReturn(1);

    // Act
    int actualFastBroadcastTransactionResult = tronNetService
        .fastBroadcastTransaction(new TransactionMessage(Protocol.Transaction.getDefaultInstance()));

    // Assert
    verify(advService).fastBroadcastTransaction(isA(TransactionMessage.class));
    assertEquals(1, actualFastBroadcastTransactionResult);
  }

  /**
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  public void testHasIpv4Stack() {
    // Arrange, Act and Assert
    assertFalse(TronNetService.hasIpv4Stack(new HashSet<>()));
  }

  /**
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  public void testHasIpv4Stack2() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      HashSet<String> ipSet = new HashSet<>();
      ipSet.add("foo");

      // Act
      boolean actualHasIpv4StackResult = TronNetService.hasIpv4Stack(ipSet);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertFalse(actualHasIpv4StackResult);
    }
  }

  /**
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  public void testHasIpv4Stack3() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      HashSet<String> ipSet = new HashSet<>();
      ipSet.add("42");
      ipSet.add("foo");

      // Act
      boolean actualHasIpv4StackResult = TronNetService.hasIpv4Stack(ipSet);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      assertFalse(actualHasIpv4StackResult);
    }
  }

  /**
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  public void testHasIpv4Stack4() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("foo"));

      HashSet<String> ipSet = new HashSet<>();
      ipSet.add("foo");

      // Act
      boolean actualHasIpv4StackResult = TronNetService.hasIpv4Stack(ipSet);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertFalse(actualHasIpv4StackResult);
    }
  }

  /**
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  public void testHasIpv4Stack5() {
    // Arrange
    HashSet<String> ipSet = new HashSet<>();
    ipSet.add("");
    ipSet.add("foo");
    ipSet.add("42");
    ipSet.add("foo");
    ipSet.add("foo");

    // Act and Assert
    assertTrue(TronNetService.hasIpv4Stack(ipSet));
  }
}
