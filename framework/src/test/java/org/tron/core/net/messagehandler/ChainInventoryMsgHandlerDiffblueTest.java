package org.tron.core.net.messagehandler;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
public class ChainInventoryMsgHandlerDiffblueTest {
  @InjectMocks
  private ChainInventoryMsgHandler chainInventoryMsgHandler;

  /**
   * Test {@link ChainInventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>When {@link PeerConnection} (default constructor).</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChainInventoryMsgHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ChainInventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_whenPeerConnection_thenThrowP2pException() throws P2pException {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> chainInventoryMsgHandler.processMessage(new PeerConnection(), null));
  }
}
