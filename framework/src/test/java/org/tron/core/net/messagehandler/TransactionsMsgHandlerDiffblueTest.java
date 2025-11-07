package org.tron.core.net.messagehandler;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.tron.core.net.message.adv.TransactionMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.protos.Protocol;

public class TransactionsMsgHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionsMsgHandler.TrxEvent#TrxEvent(TransactionsMsgHandler, PeerConnection, TransactionMessage)}
   */
  @Test
  public void testTrxEventNewTrxEvent() {
    // Arrange
    TransactionsMsgHandler transactionsMsgHandler = mock(TransactionsMsgHandler.class);
    PeerConnection peer = new PeerConnection();
    TransactionMessage msg = new TransactionMessage(Protocol.Transaction.getDefaultInstance());

    // Act
    TransactionsMsgHandler.TrxEvent actualTrxEvent = transactionsMsgHandler.new TrxEvent(peer, msg);

    // Assert
    assertSame(msg, actualTrxEvent.getMsg());
    assertSame(peer, actualTrxEvent.getPeer());
  }
}
