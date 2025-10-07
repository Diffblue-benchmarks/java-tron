package org.tron.core.net.messagehandler;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.net.message.adv.TransactionMessage;
import org.tron.core.net.messagehandler.TransactionsMsgHandler.TrxEvent;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
public class TransactionsMsgHandlerDiffblueTest {
  @Mock private PeerConnection peerConnection;

  @Mock private TransactionMessage transactionMessage;

  @Mock private TransactionsMsgHandler transactionsMsgHandler;

  /**
   * Test TrxEvent {@link TrxEvent#TrxEvent(TransactionsMsgHandler, PeerConnection,
   * TransactionMessage)}.
   *
   * <p>Method under test: {@link TrxEvent#TrxEvent(TransactionsMsgHandler, PeerConnection,
   * TransactionMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TrxEvent.<init>(TransactionsMsgHandler, PeerConnection, TransactionMessage)"
  })
  public void testTrxEventNewTrxEvent() {
    // Arrange and Act
    TrxEvent actualTrxEvent =
        transactionsMsgHandler.new TrxEvent(peerConnection, transactionMessage);

    // Assert
    assertSame(transactionMessage, actualTrxEvent.getMsg());
    assertSame(peerConnection, actualTrxEvent.getPeer());
  }
}
