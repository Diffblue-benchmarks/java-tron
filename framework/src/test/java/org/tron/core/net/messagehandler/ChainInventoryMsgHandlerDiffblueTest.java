package org.tron.core.net.messagehandler;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.exception.P2pException;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.sync.SyncService;

@RunWith(MockitoJUnitRunner.class)
public class ChainInventoryMsgHandlerDiffblueTest {
  @InjectMocks
  private ChainInventoryMsgHandler chainInventoryMsgHandler;

  @Mock
  private SyncService syncService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Method under test:
   * {@link ChainInventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage() throws P2pException {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> chainInventoryMsgHandler.processMessage(new PeerConnection(), null));
  }
}
