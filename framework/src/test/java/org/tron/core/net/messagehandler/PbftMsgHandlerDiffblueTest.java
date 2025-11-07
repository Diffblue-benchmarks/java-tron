package org.tron.core.net.messagehandler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.pbft.PbftManager;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
public class PbftMsgHandlerDiffblueTest {
  @Mock
  private PbftManager pbftManager;

  @InjectMocks
  private PbftMsgHandler pbftMsgHandler;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Method under test:
   * {@link PbftMsgHandler#processMessage(PeerConnection, PbftMessage)}
   */
  @Test
  public void testProcessMessage() throws Exception {
    // Arrange
    when(tronNetDelegate.allowPBFT()).thenReturn(false);
    PeerConnection peer = new PeerConnection();

    // Act
    pbftMsgHandler.processMessage(peer, new PbftMessage());

    // Assert that nothing has changed
    verify(tronNetDelegate).allowPBFT();
  }
}
